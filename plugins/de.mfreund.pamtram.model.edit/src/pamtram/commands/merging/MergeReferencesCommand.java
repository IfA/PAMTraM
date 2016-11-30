/**
 *
 */
package pamtram.commands.merging;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * A concrete {@link MergeMetaModelElementsCommand} that allows to merge a {@link Reference} into a {@link Class}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class MergeReferencesCommand<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MergeMetaModelElementsCommand<C, R, S, C, R, A> {

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
	public MergeReferencesCommand(EditingDomain domain, C left, R right, Set<EObject> elementsOfInterest) {
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
	public static <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Command create(
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

		@SuppressWarnings("unchecked")
		C containerClass = (C) referencesToMerge.iterator().next().eContainer();

		CompoundCommand command = new CompoundCommand();

		command.setLabel(MergeMetaModelElementsCommand.LABEL);
		command.setDescription(MergeMetaModelElementsCommand.DESCRIPTION);

		// Initialize the various sub-commands
		//
		Iterator<R> it = referencesToMerge.iterator();

		while (it.hasNext()) {
			R reference = it.next();
			command.append(new MergeReferencesCommand<>(domain, containerClass, reference, elementsOfInterest));
		}

		return command;
	}

	@Override
	protected boolean prepare() {

		Optional<R> leftReference = this.left.getReferences().parallelStream().filter(
				l -> l.getClass() == this.right.getClass() && l.getEReference().equals(this.right.getEReference()))
				.findAny();

		// Simply add the reference
		//
		if (!leftReference.isPresent()) {
			this.append(
					new AddCommand(this.domain, this.left, MetamodelPackage.Literals.CLASS__REFERENCES, this.right));

			return super.prepare();
		}

		// Nothing to be done
		//
		if (this.right.getValuesGeneric().isEmpty()) {
			return true;
		}

		// For a single-valued reference, we cannot simply add the values (unless the 'size == 1'-constraint is
		// already
		// violated). Consequently, we try to merge the values...
		//
		if (!leftReference.get().getEReference().isMany() && leftReference.get().getValuesGeneric().size() == 1) {

			Set<C> valuesToMerge = Stream
					.concat(leftReference.get().getValuesGeneric().stream(), this.right.getValuesGeneric().stream())
					.collect(Collectors.toSet());

			// Initialize the various sub-commands
			//
			this.append(MergeClassesCommand.create(this.domain, valuesToMerge, this.elementsOfInterest));

			this.prepareRedirectCrossReferencesCommand(this.right, leftReference.get());

			return super.prepare();
		}

		// In any other case, we simply add the values
		//
		if (leftReference.get() instanceof ContainmentReference<?, ?, ?, ?>) {

			this.append(new AddCommand(this.domain, leftReference.get(),
					MetamodelPackage.Literals.CONTAINMENT_REFERENCE__VALUE, this.right.getValuesGeneric()));
		} else if (leftReference.get() instanceof NonContainmentReference<?, ?, ?, ?>) {
			this.append(new AddCommand(this.domain, leftReference.get(),
					MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE__VALUE, this.right.getValuesGeneric()));

		} else {
			return false;
		}

		return super.prepare();
	}

}