/**
 *
 */
package pamtram.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IStructuredSelection;

import de.mfreund.pamtram.util.NullComparator;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionReference;
import pamtram.metamodel.ValueConstraint;

/**
 * An {@link Action} that can be used to merge multiple {@link Class Classes}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class ClassMergeAction<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends Action {

	/**
	 * The set of {@link Class elements} to be merged.
	 */
	protected Set<C> elementsToMerge = new HashSet<>();

	/**
	 * The list of {@link ContentViewer ContentViewers} to be refreshed after the merge.
	 */
	protected List<ContentViewer> viewersToUpdate;

	/**
	 * This creates an instance.
	 *
	 * @param text
	 *            The String used as text for the action.
	 * @param selection
	 *            The {@link IStructuredSelection selected elements} to be merged.
	 * @param viewersToUpdate
	 *            The list of {@link ContentViewer ContentViewers} to be refreshed after the merge.
	 */
	@SuppressWarnings("unchecked")
	public ClassMergeAction(String text, IStructuredSelection selection, List<ContentViewer> viewersToUpdate) {

		super(text);

		this.viewersToUpdate = viewersToUpdate;

		// This action is only enabled if more than one elements are
		// selected ...
		//
		boolean enabled = selection.size() > 1;

		// And if all selected elements represent the same EClass
		//
		this.elementsToMerge = Stream.of(selection.toArray())
				.filter(e -> e instanceof pamtram.metamodel.Class<?, ?, ?, ?>).map(e -> (C) e)
				.collect(Collectors.toSet());
		Set<EClass> eClasses = this.elementsToMerge.parallelStream().map(C::getEClass).collect(Collectors.toSet());

		enabled = enabled && eClasses.size() == 1;

		this.setEnabled(enabled);
	}

	@Override
	public void run() {

		// First, we check if we can safely merge the selected elements
		//
		if (!this.canMerge(this.elementsToMerge)) {
			MessageDialog.openError(UIHelper.getShell(), "Error", "The selected elements cannot be merged!");
			return;
		}

		// Now, we merge the elements
		//
		this.merge(this.elementsToMerge);

		// Finally, we delete the merged elements and update/refresh the viewers
		//
		Set<C> classesToDelete = new HashSet<>(this.elementsToMerge);
		classesToDelete.remove(this.elementsToMerge.iterator().next());

		classesToDelete.stream().forEach(EcoreUtil::delete);

		this.viewersToUpdate.stream().forEach(v -> {

			if (v.getInput() instanceof Object[]) {
				List<Object> input = new ArrayList<>(Arrays.asList((Object[]) v.getInput()));
				input.removeAll(classesToDelete);
				v.setInput(input);
			} else if (v.getInput() instanceof Collection<?>) {
				List<Object> input = new ArrayList<>((Collection<?>) v.getInput());
				input.removeAll(classesToDelete);
				v.setInput(input);
			}

			v.refresh();
		});

	}

	private boolean merge(Set<C> elements) {

		Iterator<C> it = elements.iterator();

		C class1 = it.next();

		while (it.hasNext()) {
			if (!this.mergeClass(class1, it.next())) {
				return false;
			}
		}

		return true;

	}

	private boolean canMerge(Set<C> elements) {
	
		// Create a self-contained copy of all elements that we can safely try to merge without having to think about
		// any consequences if the merge fails
		//
		Set<C> copiedElements = new HashSet<>(EcoreUtil.copyAll(elements));
	
		return this.merge(copiedElements);
	
	}

	private boolean mergeClass(C left, C right) {

		// Merge the attributes first
		//
		if (!this.mergeAttributes(left, right)) {
			return false;
		}

		// Now, merge the references
		//
		return this.mergeReferences(left, right);

	}

	private boolean mergeAttributes(C left, C right) {

		return right.getAttributes().stream().allMatch(rightAttribute -> this.mergeAttribute(left, rightAttribute));
	}

	private boolean mergeReferences(C left, C right) {

		return right.getReferences().stream().allMatch(rightReference -> this.mergeReference(left, rightReference));
	}

	/**
	 *
	 *
	 * @param left
	 * @param rightAttribute
	 * @return
	 */
	private boolean mergeAttribute(C left, A rightAttribute) {

		Optional<A> leftAttribute = left.getAttributes().parallelStream()
				.filter(a -> a.getName().equals(rightAttribute.getName())).findAny();

		// Simply add the attribute
		//
		if (!leftAttribute.isPresent()) {
			left.getAttributes().add(rightAttribute);
			return true;
		}

		EqualityHelper equalityHelper = new EqualityHelper();

		// Merge the attributes
		//
		if (leftAttribute.get() instanceof SourceSectionAttribute) {

			List<ValueConstraint> leftConstraints = ((SourceSectionAttribute) leftAttribute.get()).getValueConstraint();
			List<ValueConstraint> rightConstraints = ((SourceSectionAttribute) rightAttribute).getValueConstraint();

			if (leftConstraints.isEmpty() && rightConstraints.isEmpty()) {
				// nothing to be done
			} else if (leftConstraints.size() != rightConstraints.size()) {
				// delete all constraints
				leftConstraints.clear();
			} else {
				// delete those constraints that are not equal
				Set<ValueConstraint> constraintsToDelete = IntStream.range(0, leftConstraints.size())
						.filter(i -> !equalityHelper.equals(leftConstraints.get(i), rightConstraints.get(i)))
						.mapToObj(leftConstraints::get).collect(Collectors.toSet());

				leftConstraints.removeAll(constraintsToDelete);
			}
		} else if (leftAttribute.get() instanceof TargetSectionAttribute) {

			String leftValue = ((TargetSectionAttribute) leftAttribute.get()).getValue();
			String rightValue = ((TargetSectionAttribute) rightAttribute).getValue();

			if (!NullComparator.compare(leftValue, rightValue)) {
				((TargetSectionAttribute) leftAttribute.get()).setValue(null);
			}

		} else {
			return false;
		}

		return true;
	}

	/**
	 *
	 *
	 * @param left
	 * @param rightReference
	 */
	private boolean mergeReference(C left, R rightReference) {

		Optional<R> leftReference = left.getReferences().parallelStream()
				.filter(l -> l.getClass() == rightReference.getClass()
						&& l.getEReference().equals(rightReference.getEReference()))
				.findAny();

		// Simply add the reference
		//
		if (!leftReference.isPresent()) {
			left.getReferences().add(rightReference);
			return true;
		}

		// Simply add the values
		//
		if (leftReference.get().getValuesGeneric().isEmpty()) {
			leftReference.get().addValuesGeneric(rightReference.getValuesGeneric());
			return true;
		}

		// Try to merge the references
		//
		if (leftReference.get() instanceof SourceSectionReference) {

		} else if (leftReference.get() instanceof TargetSectionReference) {

		} else {
			return false;
		}

		return true;
	}

}