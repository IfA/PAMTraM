/**
 *
 */
package pamtram.commands.merging;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PamtramPackage;
import pamtram.metamodel.Attribute;
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
	 */
	public MergeClassesCommand(EditingDomain domain, C left, C right, Set<EObject> elementsOfInterest) {

		super(domain, left, right, elementsOfInterest);
	}

	@Override
	protected boolean prepare() {

		// Merge the names of the class
		//
		this.append(new SetCommand(this.domain, this.left, PamtramPackage.Literals.NAMED_ELEMENT__NAME,
				MergeMetaModelElementsCommand.longestCommonSubstring(this.left.getName(), this.right.getName())));

		// Merge the attributes first
		//
		new ArrayList<>(this.right.getAttributes()).stream().forEach(rightAttribute -> this
				.append(new MergeAttributesCommand<>(this.domain, this.left, rightAttribute, this.elementsOfInterest)));

		// Now, merge the references
		//
		new ArrayList<>(this.right.getReferences()).stream().forEach(rightReference -> this
				.append(new MergeReferencesCommand<>(this.domain, this.left, rightReference, this.elementsOfInterest)));

		this.prepareRedirectCrossReferencesCommand(this.right, this.left);

		return super.prepare();
	}

}