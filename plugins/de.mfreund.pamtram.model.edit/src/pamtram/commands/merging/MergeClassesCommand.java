/**
 *
 */
package pamtram.commands.merging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PamtramPackage;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * A concrete {@link MergeMetaModelElementsCommand} that allows to merge two {@link pamtram.metamodel.Class
 * pamtram.metamodel.Classes}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class MergeClassesCommand<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MergeMetaModelElementsCommand<C, C, S, C, R, A> {

	/**
	 * This constructs an instance.
	 *
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param left
	 *            The left element for the merge.
	 * @param right
	 *            The right element for the merge.
	 * @param elementsOfInterest
	 *            The set of {@link EObject elements} that need to be consulted when
	 *            {@link #prepareRedirectCrossReferencesCommand(MetaModelElement, MetaModelElement) redirecting
	 *            cross-references} after merging elements or <em>null</em> when the elements shall be determined from
	 *            the resource set associated with the given <em>domain</em>.
	 *
	 * @see #create(EditingDomain, Set, Set)
	 */
	public MergeClassesCommand(EditingDomain domain, C left, C right, Set<EObject> elementsOfInterest) {

		super(domain, left, right, elementsOfInterest);
	}

	/**
	 * Factory method to create a command that will merge multiple given <em>classesToMerge</em>.
	 * <p />
	 * Note: This will return a compound command that contains one {@link MergeClassesCommand} for each (except the
	 * first) <em>classesToMerge</em> to be merged.
	 *
	 * @param <S>
	 * @param <C>
	 * @param <R>
	 * @param <A>
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param classesToMerge
	 *            The set of {@link Class Classes} to be merged.
	 * @param elementsOfInterest
	 *            The set of {@link EObject elements} that need to be consulted when
	 *            {@link #prepareRedirectCrossReferencesCommand(MetaModelElement, MetaModelElement) redirecting
	 *            cross-references} after merging elements or <em>null</em> when the elements shall be determined from
	 *            the resource set associated with the given <em>domain</em>.
	 * @return The created command.
	 */
	public static <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Command create(
			EditingDomain domain, Set<C> classesToMerge, Set<EObject> elementsOfInterest) {

		// The classes can only be merged if they all represent the same EClass
		//
		Set<EClass> eClasses = classesToMerge.parallelStream().map(C::getEClass).collect(Collectors.toSet());

		boolean enabled = eClasses.size() == 1;

		if (!enabled) {
			return UnexecutableCommand.INSTANCE;
		}

		CompoundCommand command = new CompoundCommand();

		command.setLabel(MergeMetaModelElementsCommand.LABEL);
		command.setDescription(MergeMetaModelElementsCommand.DESCRIPTION);

		// Initialize the various sub-commands
		//
		Iterator<C> it = classesToMerge.iterator();

		C class1 = it.next();

		while (it.hasNext()) {
			C class2 = it.next();

			command.append(new MergeClassesCommand<>(domain, class1, class2, elementsOfInterest));

			// After merging the class, it needs to be deleted as it is now unused
			//
			command.append(DeleteCommand.create(domain, class2));
		}

		return command;
	}

	@Override
	public Collection<?> getAffectedObjects() {

		return Arrays.asList(this.left);
	}

	@Override
	protected boolean prepare() {

		// Merge the names of the class
		//
		this.append(new SetCommand(this.domain, this.left, PamtramPackage.Literals.NAMED_ELEMENT__NAME,
				MergeMetaModelElementsCommand.longestCommonSubstring(this.left.getName(), this.right.getName())));

		// Merge the attributes first
		//
		new ArrayList<>(this.right.getAttributes()).stream().forEach(rightAttribute -> this.append(
				new MergeAttributeIntoClassCommand<>(this.domain, this.left, rightAttribute, this.elementsOfInterest)));

		// Now, merge the references
		//
		new ArrayList<>(this.right.getReferences()).stream().forEach(rightReference -> this.append(
				new MergeReferenceIntoClassCommand<>(this.domain, this.left, rightReference, this.elementsOfInterest)));

		this.prepareRedirectCrossReferencesCommand(this.right, this.left);

		return super.prepare();
	}

}