/**
 *
 */
package pamtram.commands.merging;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

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
		extends CompoundCommand {

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
	 * The set of {@link EObject elements} that need to be consulted when
	 * {@link #prepareRedirectCrossReferencesCommand(EObject, EObject) redirecting cross-references} after merging
	 * elements.
	 */
	protected Set<EObject> elementsOfInterest;

	protected EditingDomain domain;

	/**
	 * This constructs an instance of the generic command to convert an instance of a source type to an instance of the
	 * target type.
	 * <p />
	 * The actual conversion is performed by an instance of 'IConverter' that is called when the command is invoked.
	 * <p />
	 * Note: When using this constructor, the {@link #elementsOfInterest} are determined from all resources in the
	 * <em>domain</em>'s resource set.
	 *
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param elementsToMerge
	 *            The set of {@link Class elements} to merge.
	 *
	 * @see ClassMergeCommand#ClassMergeCommand(EditingDomain, Set, Set)
	 */
	public ClassMergeCommand(EditingDomain domain, Set<C> elementsToMerge) {
		super();
		this.domain = domain;
		this.setLabel(ClassMergeCommand.LABEL);
		this.setDescription(ClassMergeCommand.DESCRIPTION);

		this.elementsToMerge = elementsToMerge;
		this.elementsOfInterest = null;
	}

	/**
	 * This constructs an instance of the generic command to convert an instance of a source type to an instance of the
	 * target type.
	 * <p />
	 * The actual conversion is performed by an instance of 'IConverter' that is called when the command is invoked.
	 * <p />
	 * Note: This constructor should be used when merging elements that are not contained in a resource, otherwise
	 * {@link ClassMergeCommand#ClassMergeCommand(EditingDomain, Set, Set) ClassMergeCommand(EditingDomain, Set, Set)}
	 * should be used as this determines the {@link #elementsOfInterest} from all resources in the <em>domain</em>'s
	 * resource set.
	 *
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param elementsToMerge
	 *            The set of {@link Class elements} to merge.
	 * @param elementsOfInterest
	 *            The set of {@link EObject elements} that need to be consulted when
	 *            {@link #prepareRedirectCrossReferencesCommand(EObject, EObject) redirecting cross-references} after
	 *            merging elements.
	 *
	 * @see ClassMergeCommand#ClassMergeCommand(EditingDomain, Set)
	 */
	public ClassMergeCommand(EditingDomain domain, Set<C> elementsToMerge, Set<EObject> elementsOfInterest) {
		this(domain, elementsToMerge);

		this.elementsToMerge = elementsToMerge;
		this.elementsOfInterest = elementsOfInterest;
	}

	@Override
	protected boolean prepare() {

		// Initialize the various sub-commands
		//
		Iterator<C> it = this.elementsToMerge.iterator();

		C class1 = it.next();

		while (it.hasNext()) {
			C class2 = it.next();
			this.append(new MergeClassesCommand<>(this.domain, class1, class2, null));
		}

		return super.prepare();
	}

}
