/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package pamtram.commands.merging;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PamtramPackage;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.util.NullComparator;

/**
 * A concrete {@link MergeMetaModelElementsCommand} that allows to merge an {@link Attribute} into a {@link Class}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class MergeAttributeIntoClassCommand<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MergeMetaModelElementsCommand<C, A, S, C, R, A> {

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
	public MergeAttributeIntoClassCommand(EditingDomain domain, C left, A right, Set<EObject> elementsOfInterest) {
		super(domain, left, right, elementsOfInterest);
	}

	@Override
	protected boolean prepare() {

		Optional<A> leftAttribute;

		if (this.right instanceof ActualAttribute<?, ?, ?, ?>) {
			leftAttribute = this.left.getAttributes().parallelStream()
					.filter(a -> a instanceof ActualAttribute<?, ?, ?, ?> && ((ActualAttribute<?, ?, ?, ?>) a)
							.getAttribute().equals(((ActualAttribute<?, ?, ?, ?>) this.right).getAttribute()))
					.findAny();
		} else {
			leftAttribute = this.left.getAttributes().parallelStream()
					.filter(a -> a.getName().equals(this.right.getName())).findAny();
		}

		// Simply add the attribute
		//
		if (!leftAttribute.isPresent()) {
			if (this.right.eContainer() instanceof Class<?, ?, ?, ?>) {
				this.append(new RemoveCommand(this.domain, this.right.eContainer(),
						GenericPackage.Literals.CLASS__ATTRIBUTES, this.right));
			}
			this.append(new AddCommand(this.domain, this.left, GenericPackage.Literals.CLASS__ATTRIBUTES, this.right));
			return super.prepare();
		}

		EqualityHelper equalityHelper = new EqualityHelper();

		// Merge the attributes
		//
		String mergedName;
		if (leftAttribute.get().getName().isEmpty()) {
			mergedName = this.right.getName();
		} else if (this.right.getName().isEmpty()) {
			mergedName = leftAttribute.get().getName();
		} else {
			mergedName = MergeMetaModelElementsCommand.longestCommonSubstring(leftAttribute.get().getName(),
					this.right.getName());
		}

		this.append(new SetCommand(this.domain, leftAttribute.get(), PamtramPackage.Literals.NAMED_ELEMENT__NAME,
				mergedName));

		if (leftAttribute.get() instanceof SourceSectionAttribute) {

			// TODO find a better algorithm to merge constraints?
			List<ValueConstraint> leftConstraints = ((SourceSectionAttribute) leftAttribute.get()).getValueConstraints();
			List<ValueConstraint> rightConstraints = ((SourceSectionAttribute) this.right).getValueConstraints();

			if (leftConstraints.isEmpty() && rightConstraints.isEmpty()) {
				// nothing to be done
			} else if (leftConstraints.size() != rightConstraints.size()) {
				// delete all constraints
				this.append(DeleteCommand.create(this.domain, leftConstraints));
			} else {
				// delete those constraints that are not equal
				Set<ValueConstraint> constraintsToDelete = IntStream.range(0, leftConstraints.size())
						.filter(i -> !equalityHelper.equals(leftConstraints.get(i), rightConstraints.get(i)))
						.mapToObj(leftConstraints::get).collect(Collectors.toSet());

				if (!constraintsToDelete.isEmpty()) {
					this.append(new DeleteCommand(this.domain, constraintsToDelete));
				}
			}
		} else if (leftAttribute.get() instanceof TargetSectionAttribute) {

			String leftValue = ((TargetSectionAttribute) leftAttribute.get()).getValue();
			String rightValue = ((TargetSectionAttribute) this.right).getValue();

			if (!NullComparator.compare(leftValue, rightValue)) {
				this.append(new SetCommand(this.domain, leftAttribute.get(),
						TargetPackage.Literals.TARGET_SECTION_ATTRIBUTE__VALUE, null));
			}

		} else {
			return false;
		}

		this.prepareRedirectCrossReferencesCommand(this.right, leftAttribute.get());

		return super.prepare();
	}

}
