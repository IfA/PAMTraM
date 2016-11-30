/**
 *
 */
package pamtram.actions;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;

import pamtram.commands.merging.MergeClassesCommand;
import pamtram.commands.merging.MergeMetaModelElementsCommand;
import pamtram.commands.merging.MergeReferenceIntoClassCommand;
import pamtram.commands.merging.MergeReferencesCommand;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * A {@link StaticSelectionCommandAction} that can be used to merge multiple {@link MetaModelElement MetaModelElements}
 * via the associated concrete {@link MergeMetaModelElementsCommand}.
 *
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 *
 * @author mfreund
 */
public class MetaModelElementMergeAction<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends StaticSelectionCommandAction {

	/**
	 * This creates an instance.
	 *
	 * @param editorPart
	 *            The {@link IEditorPart} in which this action is used.
	 * @param selection
	 *            The {@link IStructuredSelection selected elements} to be merged.
	 */
	public MetaModelElementMergeAction(IEditorPart editorPart, IStructuredSelection selection) {

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
	public MetaModelElementMergeAction(EditingDomain editingDomain, IStructuredSelection selection) {

		super(editingDomain);
		this.setText("Merge selected elements");

		this.configureAction(selection);

	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {

		if (collection.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		Object firstElement = collection.iterator().next();

		if (firstElement instanceof Class<?, ?, ?, ?>) {
			return this.createMergeClassesCommand(editingDomain, collection);
		} else if (firstElement instanceof Reference<?, ?, ?, ?>) {
			return this.createMergeReferencesCommand(editingDomain, collection);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * If the given <em>collection</em> consists only of {@link Class Classes}, this creates a
	 * {@link MergeClassesCommand} to merge the Classes in the collection. Otherwise, an {@link UnexecutableCommand} is
	 * returned.
	 *
	 * @param editingDomain
	 *            The {@link EditingDomain} on which this the command represented by this action is to be executed.
	 * @param collection
	 *            The collection of elements to be merged.
	 * @return The created {@link Command}.
	 */
	protected Command createMergeClassesCommand(EditingDomain editingDomain, Collection<?> collection) {

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

		// ... and if they all are either Sections, have the same container or no container at all
		//
		enabled = enabled && (collection.stream().allMatch(e -> e instanceof Section<?, ?, ?, ?>)
				|| collection.stream().allMatch(e -> ((EObject) e).eContainer() == null)
				|| collection.stream().map(e -> ((EObject) e).eContainer()).collect(Collectors.toSet()).size() == 1);

		if (!enabled) {
			return UnexecutableCommand.INSTANCE;
		}

		@SuppressWarnings("unchecked")
		Set<C> elementsToMerge = collection.stream().map(e -> (C) e).collect(Collectors.toSet());

		return MergeClassesCommand.create(editingDomain, elementsToMerge, this.getElementsOfInterest());
	}

	/**
	 * If the given <em>collection</em> consists only of {@link Reference References}, this creates a
	 * {@link MergeReferenceIntoClassCommand} to merge the References in the collection. Otherwise, an
	 * {@link UnexecutableCommand} is returned.
	 *
	 *
	 * @param editingDomain
	 *            The {@link EditingDomain} on which this the command represented by this action is to be executed.
	 * @param collection
	 *            The collection of elements to be merged.
	 * @return The created {@link Command}.
	 */
	protected Command createMergeReferencesCommand(EditingDomain editingDomain, Collection<?> collection) {

		// This action is only enabled if more than one element of the correct type 'R' are
		// selected.
		//
		boolean enabled = collection.size() > 1 && collection.stream().allMatch(e -> {
			try {
				@SuppressWarnings({ "unchecked", "unused" })
				R temp = (R) e;
				return true;
			} catch (ClassCastException e1) {
				return false;
			}
		});

		if (!enabled) {
			return UnexecutableCommand.INSTANCE;
		}

		@SuppressWarnings("unchecked")
		Set<R> elementsToMerge = collection.stream().map(e -> (R) e).collect(Collectors.toSet());

		return MergeReferencesCommand.create(editingDomain, elementsToMerge, this.getElementsOfInterest());
	}

	/**
	 * This returns the set of {@link EObject elements} that need to be consulted when
	 * {@link MergeMetaModelElementsCommand#prepareRedirectCrossReferencesCommand(MetaModelElement, MetaModelElement)
	 * redirecting cross-references} after merging elements or <em>null</em> when the elements shall be determined from
	 * the resource set associated with the {@link #editingDomain}.
	 *
	 *
	 * @return The set of elements or <em>null</em>.
	 */
	protected Set<EObject> getElementsOfInterest() {

		return null;
	}

}