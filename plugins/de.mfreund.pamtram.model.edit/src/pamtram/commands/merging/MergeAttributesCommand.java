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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.PamtramPackage;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.util.NullComparator;

/**
 * A concrete {@link MergeMetaModelElementsCommand} that allows to merge two
 * {@link Attribute Attributes}.
 *
 * @author mfreund
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public class MergeAttributesCommand<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MergeMetaModelElementsCommand<A, A, S, C, R, A> {

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
	public MergeAttributesCommand(EditingDomain domain, A left, A right, Set<EObject> elementsOfInterest) {
		super(domain, left, right, elementsOfInterest);
	}

	/**
	 * Factory method to create a command that will merge multiple given
	 * <em>referencesToMerge</em>.
	 * <p />
	 * Note: This will return a compound command that contains one
	 * {@link MergeAttributesCommand} for each <em>referencesToMerge</em> to be
	 * merged.
	 *
	 * @param <S>
	 * @param <C>
	 * @param <R>
	 * @param <A>
	 * @param domain
	 *            The editing domain that the command operated on.
	 * @param attributesToMerge
	 *            The set of {@link Attribute Attributes} to be merged.
	 * @param elementsOfInterest
	 *            The set of {@link EObject elements} that need to be consulted
	 *            when
	 *            {@link #prepareRedirectCrossReferencesCommand(MetaModelElement, MetaModelElement)
	 *            redirecting cross-references} after merging elements or
	 *            <em>null</em> when the elements shall be determined from the
	 *            resource set associated with the given <em>domain</em>.
	 * @return The created command.
	 */
	public static <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Command create(
			EditingDomain domain, Set<A> attributesToMerge, Set<EObject> elementsOfInterest) {

		// Only ActualAttributes can be merged
		//
		if (attributesToMerge.parallelStream().anyMatch(a -> a instanceof VirtualAttribute<?, ?, ?, ?>)) {
			return UnexecutableCommand.INSTANCE;
		}

		// The attributes can only be merged if they all represent the same
		// EAttribute ...
		//
		Set<EAttribute> eAttributes = attributesToMerge.parallelStream().map(a -> (ActualAttribute<?, ?, ?, ?>) a)
				.map(ActualAttribute::getAttribute).collect(Collectors.toSet());

		boolean enabled = eAttributes.size() == 1;

		// ... and if they all are contained in the same Class
		//
		enabled = enabled
				&& attributesToMerge.stream().map(EObject::eContainer).collect(Collectors.toSet()).size() == 1;

		enabled = enabled && attributesToMerge.iterator().next().eContainer() instanceof Class<?, ?, ?, ?>;

		if (!enabled) {
			return UnexecutableCommand.INSTANCE;
		}

		CompoundCommand command = new CompoundCommand() {

			@Override
			public Collection<?> getAffectedObjects() {

				// Returning the set of attributesToMerge results in a correct
				// selection of elements in the viewers
				//
				return new ArrayList<>(attributesToMerge);
			}
		};

		command.setLabel(MergeMetaModelElementsCommand.COMMAND_LABEL);
		command.setDescription(MergeMetaModelElementsCommand.COMMAND_DESCRIPTION);

		// Initialize the various sub-commands
		//
		Iterator<A> it = attributesToMerge.iterator();

		A attribute1 = it.next();

		while (it.hasNext()) {
			A attribute2 = it.next();

			command.append(new MergeAttributesCommand<>(domain, attribute1, attribute2, elementsOfInterest));

			// After merging the reference, it needs to be deleted as it is now
			// unused
			//
			command.append(DeleteCommand.create(domain, attribute2));
		}

		return command;
	}

	@Override
	public Collection<?> getAffectedObjects() {

		return Arrays.asList(this.left);
	}

	@Override
	protected boolean prepare() {

		// This command is only valid for ActualAttributes
		//
		if (this.left instanceof VirtualAttribute<?, ?, ?, ?> || this.right instanceof VirtualAttribute<?, ?, ?, ?>) {
			return false;
		}

		EqualityHelper equalityHelper = new EqualityHelper();

		// Merge the attributes
		//
		String mergedName;
		if (this.left.getName().isEmpty()) {
			mergedName = this.right.getName();
		} else if (this.right.getName().isEmpty()) {
			mergedName = this.left.getName();
		} else {
			mergedName = MergeMetaModelElementsCommand.longestCommonSubstring(this.left.getName(),
					this.right.getName());
		}

		this.append(new SetCommand(this.domain, this.left, PamtramPackage.Literals.NAMED_ELEMENT__NAME, mergedName));

		if (this.left instanceof SourceSectionAttribute) {

			// TODO find a better algorithm to merge constraints?
			List<ValueConstraint> leftConstraints = ((SourceSectionAttribute) this.left).getValueConstraints();
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
		} else if (this.left instanceof TargetSectionAttribute) {

			String leftValue = ((TargetSectionAttribute) this.left).getValue();
			String rightValue = ((TargetSectionAttribute) this.right).getValue();

			if (!NullComparator.compare(leftValue, rightValue)) {
				this.append(new SetCommand(this.domain, this.left,
						TargetPackage.Literals.TARGET_SECTION_ATTRIBUTE__VALUE, null));
			}

		} else {
			return false;
		}

		this.prepareRedirectCrossReferencesCommand(this.right, this.left);

		return super.prepare();
	}

}
