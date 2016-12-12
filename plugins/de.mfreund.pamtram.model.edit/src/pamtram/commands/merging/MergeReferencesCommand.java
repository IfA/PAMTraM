/**
 *
 */
package pamtram.commands.merging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.ContainmentReference;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.NonContainmentReference;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * A concrete {@link MergeMetaModelElementsCommand} that allows to merge two {@link Reference References}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class MergeReferencesCommand<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MergeMetaModelElementsCommand<R, R, S, C, R, A> {

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
	public MergeReferencesCommand(EditingDomain domain, R left, R right, Set<EObject> elementsOfInterest) {
		super(domain, left, right, elementsOfInterest);
	}

	/**
	 * Factory method to create a command that will merge multiple given <em>referencesToMerge</em>.
	 * <p />
	 * Note: This will return a compound command that contains one {@link MergeReferencesCommand} for each
	 * <em>referencesToMerge</em> to be merged.
	 *
	 * @param <S>
	 * @param <C>
	 * @param <R>
	 * @param <A>
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param referencesToMerge
	 *            The set of {@link Reference References} to be merged.
	 * @param elementsOfInterest
	 *            The set of {@link EObject elements} that need to be consulted when
	 *            {@link #prepareRedirectCrossReferencesCommand(MetaModelElement, MetaModelElement) redirecting
	 *            cross-references} after merging elements or <em>null</em> when the elements shall be determined from
	 *            the resource set associated with the given <em>domain</em>.
	 * @return The created command.
	 */
	public static <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Command create(
			EditingDomain domain, Set<R> referencesToMerge, Set<EObject> elementsOfInterest) {

		// The references can only be merged if they all represent the same EReference ...
		//
		Set<EReference> eReferences = referencesToMerge.parallelStream().map(Reference::getEReference)
				.collect(Collectors.toSet());

		boolean enabled = eReferences.size() == 1;

		// ... and if they all are contained in the same Class
		//
		enabled = enabled
				&& referencesToMerge.stream().map(EObject::eContainer).collect(Collectors.toSet()).size() == 1;

		enabled = enabled && referencesToMerge.iterator().next().eContainer() instanceof Class<?, ?, ?, ?>;

		if (!enabled) {
			return UnexecutableCommand.INSTANCE;
		}

		CompoundCommand command = new CompoundCommand() {

			@Override
			public Collection<?> getAffectedObjects() {

				// Returning the set of referencesToMerge results in a correct selection of elements in the viewers
				//
				return new ArrayList<>(referencesToMerge);
			}
		};

		command.setLabel(MergeMetaModelElementsCommand.LABEL);
		command.setDescription(MergeMetaModelElementsCommand.DESCRIPTION);

		// Initialize the various sub-commands
		//
		Iterator<R> it = referencesToMerge.iterator();

		R reference1 = it.next();

		while (it.hasNext()) {
			R reference2 = it.next();

			command.append(new MergeReferencesCommand<>(domain, reference1, reference2, elementsOfInterest));

			// After merging the reference, it needs to be deleted as it is now unused
			//
			command.append(DeleteCommand.create(domain, reference2));
		}

		return command;
	}

	@Override
	public Collection<?> getAffectedObjects() {

		return Arrays.asList(this.left);
	}

	@Override
	protected boolean prepare() {

		// Nothing to be done
		//
		if (this.right.getValuesGeneric().isEmpty()) {
			return true;
		}

		// For a single-valued reference, we cannot simply add the values (unless the 'size == 1'-constraint is
		// already
		// violated). Consequently, we try to merge the values...
		//
		if (!this.left.getEReference().isMany() && this.left.getValuesGeneric().size() == 1) {

			Set<C> valuesToMerge = Stream
					.concat(this.left.getValuesGeneric().stream(), this.right.getValuesGeneric().stream())
					.collect(Collectors.toSet());

			// Initialize the various sub-commands
			//
			this.append(MergeClassesCommand.create(this.domain, valuesToMerge, this.elementsOfInterest));

			this.prepareRedirectCrossReferencesCommand(this.right, this.left);

			return super.prepare();
		}

		// In any other case, we simply add the values
		//
		if (this.left instanceof ContainmentReference<?, ?, ?, ?>) {

			List<C> values = new ArrayList<>(this.right.getValuesGeneric());
			this.append(new RemoveCommand(this.domain, this.right,
					StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE, values));
			this.append(new AddCommand(this.domain, this.left, StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE,
					values));
		} else if (this.left instanceof NonContainmentReference<?, ?, ?, ?>) {
			this.append(new AddCommand(this.domain, this.left,
					StructurePackage.Literals.NON_CONTAINMENT_REFERENCE__VALUE, this.right.getValuesGeneric()));

		} else {
			return false;
		}

		this.prepareRedirectCrossReferencesCommand(this.right, this.left);

		return super.prepare();
	}

}