/**
 *
 */
package pamtram.commands;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.util.ClassMerger;

/**
 * A {@link Command} that can be used to merge multiple {@link Class Classes}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class ClassMergeCommand<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends AbstractOverrideableCommand {

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = "ClassMergeCommand";

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = "Merges a set of Classes.";

	/**
	 * The set of {@link Class elements} to merge.
	 */
	protected Set<C> elementsToMerge;

	/**
	 * The {@link ClassMerger} that is used to merge the {@link #elementsToMerge}.
	 */
	protected ClassMerger<S, C, R, A> merger;

	/**
	 * This constructs an instance of the generic command to convert an instance of a source type to an instance of the
	 * target type.
	 *
	 * The actual conversion is performed by an instance of 'IConverter' that is called when the command is invoked.
	 *
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param elementsToMerge
	 *            The set of {@link Class elements} to merge.
	 */
	public ClassMergeCommand(EditingDomain domain, Set<C> elementsToMerge) {
		super(domain, ClassMergeCommand.LABEL, ClassMergeCommand.DESCRIPTION);

		this.elementsToMerge = elementsToMerge;
	}

	@Override
	public void doExecute() {

		// Merge the elements using the special merger class
		//
		this.merger.merge();

		// Finally, we delete the merged elements and update/refresh the viewers
		//
		Set<EObject> elementsToDelete = this.merger.getMergedElements().values().stream().flatMap(Set::stream)
				.collect(Collectors.toSet());
		elementsToDelete.addAll(this.merger.getDeletedElements());

		elementsToDelete.stream().forEach(EcoreUtil::delete);

	}

	@Override
	protected boolean prepare() {

		// Initialize the 'merger' and check if it can merge the 'elementsToMerge'
		//
		this.merger = new ClassMerger<>(this.elementsToMerge);
		return this.merger.canMerge();
	}

	@Override
	public void doUndo() {

		// TODO Auto-generated method stub

	}

	@Override
	public void doRedo() {

		// TODO Auto-generated method stub

	}

}
