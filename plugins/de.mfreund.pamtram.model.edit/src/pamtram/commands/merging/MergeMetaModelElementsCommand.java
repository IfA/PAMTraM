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

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * An abstract base {@link Command} that allows to merge two {@link MetaModelElement MetaModelElements} (a given
 * {@link #right} element is merged into a given {@link #left} element).
 *
 * @author mfreund
 * @param <L>
 *            The concrete type of the {@link #left} element for the merge.
 * @param <M>
 *            The concrete type of the {@link #right} element for the merge.
 * @param <S>
 * @param <C>
 * @param <R>
 * @param <A>
 */
public abstract class MergeMetaModelElementsCommand<L extends MetaModelElement<S, C, R, A>, M extends MetaModelElement<S, C, R, A>, S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends CompoundCommand {

	/**
	 * This caches the label.
	 */
	protected static final String COMMAND_LABEL = "MergeCommand";

	/**
	 * This caches the description.
	 */
	protected static final String COMMAND_DESCRIPTION = "Merges a set of MetaModelElements";

	/**
	 * The set of {@link EObject elements} that need to be consulted when
	 * {@link #prepareRedirectCrossReferencesCommand(EObject, EObject) redirecting cross-references} after merging
	 * elements.
	 */
	protected Set<EObject> elementsOfInterest;

	/**
	 * The left element for the merge.
	 */
	protected L left;

	/**
	 * The right element for the merge.
	 */
	protected M right;

	/**
	 * The {@link EditingDomain} on which this command will be executed.
	 */
	protected EditingDomain domain;

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
	public MergeMetaModelElementsCommand(EditingDomain domain, L left, M right, Set<EObject> elementsOfInterest) {

		super();

		this.setLabel(MergeMetaModelElementsCommand.COMMAND_LABEL);
		this.setDescription(MergeMetaModelElementsCommand.COMMAND_DESCRIPTION);

		this.domain = domain;
		this.left = left;
		this.right = right;
		this.elementsOfInterest = elementsOfInterest;
	}

	/**
	 * After merging elements, this can be used to redirect all cross references to the given <em>mergedElement</em> to
	 * the element they have been merged into.
	 *
	 * @param mergedElement
	 *            The element that has been merged into the <em>newElement</em>.
	 * @param newElement
	 *            The element into which the <em>mergedElement</em> has been merged into.
	 */
	protected void prepareRedirectCrossReferencesCommand(M mergedElement, M newElement) {

		// Determine all cross references...
		//
		Collection<Setting> usages;

		if (this.elementsOfInterest != null) {
			usages = EcoreUtil.UsageCrossReferencer.find(mergedElement, this.elementsOfInterest);
		} else {
			usages = EcoreUtil.UsageCrossReferencer.find(mergedElement, this.domain.getResourceSet());
		}

		// ... and redirect them by creating appropriate SetCommands
		//
		usages.stream()
				.filter(usage -> !usage.getEStructuralFeature().isDerived()
						&& !usage.getEStructuralFeature().isTransient()
						&& usage.getEStructuralFeature() instanceof EReference)
				.forEach(usage -> {

					if (usage.getEStructuralFeature().isMany()) {
						this.append(new AddCommand(this.domain, usage.getEObject(), usage.getEStructuralFeature(),
								newElement));
					} else {
						this.append(new SetCommand(this.domain, usage.getEObject(), usage.getEStructuralFeature(),
								newElement));
					}

				});

	}

	/**
	 * Find the longest common substring of two Strings. Copied from <a href=
	 * "https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Longest_common_substring#Java">Wikipedia</a>.
	 *
	 * @param S1
	 * @param S2
	 * @return
	 */
	protected static String longestCommonSubstring(String S1, String S2) {

		if (S1 == null || S2 == null) {
			return "";
		}

		int Start = 0;
		int Max = 0;
		for (int i = 0; i < S1.length(); i++) {
			for (int j = 0; j < S2.length(); j++) {
				int x = 0;
				while (S1.charAt(i + x) == S2.charAt(j + x)) {
					x++;
					if (i + x >= S1.length() || j + x >= S2.length()) {
						break;
					}
				}
				if (x > Max) {
					Max = x;
					Start = i;
				}
			}
		}
		return S1.substring(Start, Start + Max);
	}
}
