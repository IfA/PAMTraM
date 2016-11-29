/**
 *
 */
package pamtram.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IStructuredSelection;

import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.util.ClassMerger;

/**
 * An {@link Action} that can be used to merge multiple {@link Class Classes}.
 *
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 *
 * @author mfreund
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

		// Merge the elements using the special merger class
		//
		ClassMerger<S, C, R, A> merger = new ClassMerger<>(this.elementsToMerge);

		boolean canMerge = merger.canMerge();

		if (!canMerge) {
			MessageDialog.openError(UIHelper.getShell(), "Error", "The selected elements cannot be merged!");
			return;
		}

		merger.merge();

		// Finally, we delete the merged elements and update/refresh the viewers
		//
		Set<EObject> elementsToDelete = merger.getMergedElements().values().stream().flatMap(Set::stream)
				.collect(Collectors.toSet());
		elementsToDelete.addAll(merger.getDeletedElements());

		elementsToDelete.stream().forEach(EcoreUtil::delete);

		this.viewersToUpdate.stream().forEach(v -> {

			if (v.getInput() instanceof Object[]) {
				List<Object> input = new ArrayList<>(Arrays.asList((Object[]) v.getInput()));
				input.removeAll(elementsToDelete);
				v.setInput(input);
			} else if (v.getInput() instanceof Collection<?>) {
				List<Object> input = new ArrayList<>((Collection<?>) v.getInput());
				input.removeAll(elementsToDelete);
				v.setInput(input);
			}

			v.refresh();
		});

	}

}