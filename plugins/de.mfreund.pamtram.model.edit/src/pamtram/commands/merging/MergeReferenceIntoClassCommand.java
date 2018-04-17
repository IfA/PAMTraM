/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package pamtram.commands.merging;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * A concrete {@link MergeMetaModelElementsCommand} that allows to merge a
 * {@link Reference} into a {@link Class}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class MergeReferenceIntoClassCommand<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
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
	 *            The set of {@link EObject elements} that need to be consulted
	 *            when
	 *            {@link #prepareRedirectCrossReferencesCommand(MetaModelElement, MetaModelElement)
	 *            redirecting cross-references} after merging elements or
	 *            <em>null</em> when the elements shall be determined from the
	 *            resource set associated with the given <em>domain</em>.
	 */
	public MergeReferenceIntoClassCommand(EditingDomain domain, C left, R right, Set<EObject> elementsOfInterest) {
		super(domain, left, right, elementsOfInterest);
	}

	@Override
	protected boolean prepare() {

		// Nothing to be done
		//
		if (this.right.getValuesGeneric().isEmpty()) {
			return true;
		}

		Optional<R> leftReference = this.right instanceof ActualReference<?, ?, ?, ?>
				? this.left.getReferences().parallelStream()
						.filter(l -> l instanceof ActualReference<?, ?, ?, ?> && l.getClass() == this.right.getClass()
								&& ((ActualReference<?, ?, ?, ?>) l).getEReference()
										.equals(((ActualReference<?, ?, ?, ?>) this.right).getEReference()))
						.findAny()
				: Optional.empty();

		// Simply add the reference
		//
		if (!leftReference.isPresent()) {
			if (this.right.eContainer() instanceof Class<?, ?, ?, ?>) {
				this.append(new RemoveCommand(this.domain, this.right.eContainer(),
						GenericPackage.Literals.CLASS__REFERENCES, this.right));
			}
			this.append(new AddCommand(this.domain, this.left, GenericPackage.Literals.CLASS__REFERENCES, this.right));

			return super.prepare();
		}

		// For a single-valued reference, we cannot simply add the values
		// (unless the 'size == 1'-constraint is
		// already
		// violated). Consequently, we try to merge the values...
		//
		if (!((ActualReference<?, ?, ?, ?>) leftReference.get()).getEReference().isMany()
				&& leftReference.get().getValuesGeneric().size() == 1) {

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
		if (leftReference.get() instanceof CompositeReference<?, ?, ?, ?>) {
			List<C> values = new ArrayList<>(this.right.getValuesGeneric());
			this.append(new RemoveCommand(this.domain, this.right, GenericPackage.Literals.COMPOSITE_REFERENCE__VALUE,
					values));
			this.append(new AddCommand(this.domain, leftReference.get(),
					GenericPackage.Literals.COMPOSITE_REFERENCE__VALUE, values));
		} else if (leftReference.get() instanceof CrossReference<?, ?, ?, ?>) {
			this.append(new AddCommand(this.domain, leftReference.get(), GenericPackage.Literals.CROSS_REFERENCE__VALUE,
					this.right.getValuesGeneric()));

		} else {
			return false;
		}

		return super.prepare();
	}

}
