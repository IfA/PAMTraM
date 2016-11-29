/**
 * 
 */
package pamtram.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.ValueConstraint;

/**
 * An {@link Action} that can be used to merge multiple {@link Class
 * Classes}.
 *
 * @author mfreund
 */
public class ClassMergeAction extends Action {

	/**
	 * The list of {@link Class elements} selected by the user to be merged.
	 */
	protected List<pamtram.metamodel.Class<?, ?, ?, ?>> selectedElements = new ArrayList<>();

	/**
	 * The list of {@link ContentViewer ContentViewers} to be refreshed
	 * after the merge.
	 */
	protected List<ContentViewer> viewersToUpdate;

	/**
	 * This creates an instance.
	 *
	 * @param text
	 *            The String used as text for the action.
	 * @param selection
	 *            The {@link IStructuredSelection selected elements} to be
	 *            merged.
	 * @param viewersToUpdate
	 *            The list of {@link ContentViewer ContentViewers} to be
	 *            refreshed after the merge.
	 */
	public ClassMergeAction(String text, IStructuredSelection selection, List<ContentViewer> viewersToUpdate) {

		super(text);

		this.viewersToUpdate = viewersToUpdate;

		// This action is only enabled if more than one elements are
		// selected ...
		//
		boolean enabled = selection.size() > 1;

		// And if all selected elements represent the same EClass
		//
		this.selectedElements = Stream.of(selection.toArray())
				.filter(e -> e instanceof pamtram.metamodel.Class<?, ?, ?, ?>)
				.map(e -> (pamtram.metamodel.Class<?, ?, ?, ?>) e).collect(Collectors.toList());
		Set<EClass> eClasses = this.selectedElements.parallelStream()
				.map(pamtram.metamodel.Class<?, ?, ?, ?>::getEClass).collect(Collectors.toSet());

		enabled = enabled && eClasses.size() == 1;

		this.setEnabled(enabled);
	}

	@Override
	public void run() {

		// Merge the elements
		//
		boolean result = false;

		pamtram.metamodel.Class<?, ?, ?, ?> class1 = this.selectedElements.get(0);

		for (Class<?, ?, ?, ?> class2 : this.selectedElements) {
			if (class1.equals(class2)) {
				continue;
			}

			if (class1 instanceof SourceSectionClass && class2 instanceof SourceSectionClass) {

				result = this.merge((SourceSectionClass) class1, (SourceSectionClass) class2);
			} else if (class1 instanceof TargetSectionClass && class2 instanceof TargetSectionClass) {

				result = this.merge((TargetSectionClass) class1, (TargetSectionClass) class2);
			}

			// If the merge was successful, delete the merged element and
			// update/refresh the viewers
			//
			if (result) {

				EcoreUtil.delete(class2);

				this.viewersToUpdate.stream().forEach(v -> {

					if (v.getInput() instanceof Object[]) {
						List<Object> input = new ArrayList<>(Arrays.asList((Object[]) v.getInput()));
						input.remove(class2);
						v.setInput(input);
					} else if (v.getInput() instanceof Collection<?>) {
						List<Object> input = new ArrayList<>((Collection<?>) v.getInput());
						input.remove(class2);
						v.setInput(input);
					}

					v.refresh();
				});

			} else {
				break;
			}
		}

		if (!result) {

			MessageDialog.openError(UIHelper.getShell(), "Error", "Error while merging the selected elements!");
		}

	}

	private <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> boolean merge(
			C left, C right) {

		for (A rightAttribute : right.getAttributes()) {

			Optional<A> leftAttribute = left.getAttributes().parallelStream()
					.filter(a -> a.getName().equals(rightAttribute.getName())).findAny();

			// Simply add the attribute
			//
			if (!leftAttribute.isPresent()) {
				left.getAttributes().add(rightAttribute);
				continue;
			}

			// Merge the attributes
			//
			if (leftAttribute.get() instanceof SourceSectionAttribute) {

				List<ValueConstraint> leftConstraints = ((SourceSectionAttribute) leftAttribute.get())
						.getValueConstraint();
				List<ValueConstraint> rightConstraints = ((SourceSectionAttribute) rightAttribute)
						.getValueConstraint();

				if (leftConstraints.isEmpty() && rightConstraints.isEmpty()) {
					// nothing to be done
				} else if (!leftConstraints.isEmpty() || !rightConstraints.isEmpty()
						|| leftConstraints.size() != rightConstraints.size()) {
					leftConstraints.clear();
				} else {
					for (int i = 0; i < leftConstraints.size(); i++) {
						System.out.println(leftConstraints.get(i).equals(rightConstraints.get(i)));
					}
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
		}

		return true;
	}

}