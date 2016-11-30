/**
 *
 */
package pamtram.commands.merging;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
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
public class MergeReferenceIntoClassCommand<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
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
	public MergeReferenceIntoClassCommand(EditingDomain domain, C left, R right, Set<EObject> elementsOfInterest) {
		super(domain, left, right, elementsOfInterest);
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
			return super.prepare();
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