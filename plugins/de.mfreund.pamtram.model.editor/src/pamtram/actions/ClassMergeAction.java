/**
 *
 */
package pamtram.actions;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;

import pamtram.commands.merging.MergeClassesCommand;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * A {@link StaticSelectionCommandAction} that can be used to merge multiple {@link Class Classes} via a
 * {@link MergeClassesCommand}.
 *
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 *
 * @author mfreund
 */
public class ClassMergeAction<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends StaticSelectionCommandAction {

	/**
	 * This creates an instance.
	 *
	 * @param editorPart
	 *            The {@link IEditorPart} in which this action is used.
	 * @param selection
	 *            The {@link IStructuredSelection selected elements} to be merged.
	 */
	public ClassMergeAction(IEditorPart editorPart, IStructuredSelection selection) {

		super(editorPart);
		this.setText("Merge selected elements");

		this.configureAction(selection);

	}

	/**
	 * This creates an instance.
	 *
	 * @param editingDomain
	 *            The {@link EditingDomain} on which this the command represented by this action is to be executed.
	 * @param selection
	 *            The {@link IStructuredSelection selected elements} to be merged.
	 */
	public ClassMergeAction(EditingDomain editingDomain, IStructuredSelection selection) {

		super(editingDomain);
		this.setText("Merge selected elements");

		this.configureAction(selection);

	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {

		// This action is only enabled if more than one element of the correct type 'C' are
		// selected ...
		//
		boolean enabled = collection.size() > 1 && collection.stream().allMatch(e -> {
			try {
				@SuppressWarnings({ "unchecked", "unused" })
				C temp = (C) e;
				return true;
			} catch (ClassCastException e1) {
				return false;
			}
		});

		if (!enabled) {
			return UnexecutableCommand.INSTANCE;
		}

		// ... and if all selected elements represent the same EClass ...
		//
		@SuppressWarnings("unchecked")
		Set<C> elementsToMerge = collection.stream().map(e -> (C) e).collect(Collectors.toSet());
		Set<EClass> eClasses = elementsToMerge.parallelStream().map(C::getEClass).collect(Collectors.toSet());

		enabled = eClasses.size() == 1;

		// ... and if all elements are either Sections, have the same container or no container at all
		//
		enabled = enabled && (elementsToMerge.stream().allMatch(e -> e instanceof Section<?, ?, ?, ?>)
				|| elementsToMerge.stream().allMatch(e -> e.eContainer() == null)
				|| elementsToMerge.stream().map(EObject::eContainer).collect(Collectors.toSet()).size() == 1);

		if (!enabled) {
			return UnexecutableCommand.INSTANCE;
		}

		return this.doCreateClassMergeCommand(elementsToMerge);
	}

	/**
	 * This creates the actual {@link ClassMergeCommand} that will perform the merging.
	 * <p />
	 * Clients should override this instead of {@link #createActionCommand(EditingDomain, Collection)} as checks to the
	 * validity of the given set of <em>elementsToMerge</em> are already performed there.
	 *
	 *
	 * @param elementsToMerge
	 * @return
	 */
	protected Command doCreateClassMergeCommand(Set<C> elementsToMerge) {

		return MergeClassesCommand.create(this.editingDomain, elementsToMerge, null);
	}

}