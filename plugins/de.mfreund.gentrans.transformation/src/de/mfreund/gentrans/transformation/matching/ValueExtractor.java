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
package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import pamtram.FixedValue;
import pamtram.MatchSpecElement;
import pamtram.NamedElement;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.source.VirtualSourceSectionAttribute;

/**
 * This represents an abstract base class that allows to extract {@link AttributeValueRepresentation values} from a list
 * of {@link MatchedSectionDescriptor MatchedSectionDescriptors}.
 *
 * @author mfreund
 *
 */
public abstract class ValueExtractor extends CancelableTransformationAsset {

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public ValueExtractor(TransformationAssetManager assetManager) {

		super(assetManager);
	}

	/**
	 * This extracts and returns the value for the given {@link FixedValue} from the source elements represented by the
	 * given <em>matchedSectionDescriptor</em>.
	 *
	 * @param fixedValue
	 *            The {@link FixedValue} for that the values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(FixedValue fixedValue,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		this.checkCanceled();

		// FIXME two different FixedValues are currently not supported (both get
		// added to the 'null' attribute
		return new AttributeValueRepresentation(null, fixedValue.getValue());
	}

	/**
	 * This extracts and returns the value for the given {@link GlobalAttributeImporter} from the source elements
	 * represented by the given <em>mappingInstance</em>.
	 *
	 * @param globaleAttributeImporter
	 *            The {@link GlobalAttributeImporter} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(GlobalAttributeImporter globaleAttributeImporter,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		this.checkCanceled();

		return this.assetManager.getGlobalValues().getGlobalAttributes()
				.containsKey(globaleAttributeImporter.getGlobalAttribute())
						? new AttributeValueRepresentation(null,
								this.assetManager.getGlobalValues().get(globaleAttributeImporter.getGlobalAttribute()))
						: null;
	}

	/**
	 * This extracts and returns the hint value for the given {@link DynamicSourceElement} from the source elements
	 * represented by the given <em>mappingInstance</em>.
	 * <p />
	 * Note: This method must not be used for {@link GlobalDynamicSourceElement GlobalModifiedAttributeElementTypes}.
	 * Use {@link #extractValue(GlobalDynamicSourceElement, Map)} instead.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link DynamicSourceElement} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(
			DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		this.checkCanceled();

		MatchedSectionDescriptor sourceDescriptor = matchedSectionDescriptor;

		Set<EObject> sourceElements = new LinkedHashSet<>();

		if (mappingHintSourceElement instanceof ExternalDynamicSourceElement<?, ?, ?, ?>) {

			SourceSection mappingHintSourceElementProvidingSection = mappingHintSourceElement.getSource()
					.getContainingSection();

			// In case we are dealing with an external source element, we first need
			// to determine the correct 'container descriptor' that represents the source element
			//
			do {
				sourceDescriptor = sourceDescriptor.getContainerDescriptor();

				if (sourceDescriptor == null) {
					break;
				}

			} while (!(sourceDescriptor.getAssociatedSourceSection().equals(mappingHintSourceElementProvidingSection)
					|| sourceDescriptor.getAssociatedSourceSection().getContainingSection().getAllExtend()
							.contains(mappingHintSourceElementProvidingSection)));

			if (sourceDescriptor != null) {
				// Now that we found the correct descriptor, we can determine the suitable source elements
				//
				sourceElements = sourceDescriptor
						.getMatchedSourceModelElementsFor(mappingHintSourceElement.getSource().getOwningClass(), false);
			}

		} else if (mappingHintSourceElement instanceof LocalDynamicSourceElement<?, ?, ?, ?>) {

			// In case we are dealing with a local source element, we need to collect all elements of the given
			// descriptor and of all descriptors (directly or indirectly) referenced by this descriptor
			//
			sourceElements = sourceDescriptor.getMatchedSourceModelElementsFor(
					mappingHintSourceElement.getSource().getOwningClass(),
					((LocalDynamicSourceElement<?, ?, ?, ?>) mappingHintSourceElement).isFollowExternalReferences());

			// If the user specified an additional 'referenceMatchSpec', use
			// only that subset of the determined source elements corresponding
			// to this matching path.
			//
			if (!((LocalDynamicSourceElement<?, ?, ?, ?>) mappingHintSourceElement).getReferenceMatchSpec().isEmpty()) {

				MatchedSectionDescriptor localDescriptor = sourceDescriptor;
				sourceElements = sourceElements.stream()
						.filter(s -> this.assetManager.getMatchSpecHandler().conformsMatchedObject(
								localDescriptor.getAssociatedSourceModelElement(), s,
								(MatchSpecElement<?, ?, ?, ?>) mappingHintSourceElement))
						.collect(Collectors.toCollection(LinkedHashSet::new));
			}
		}

		if (sourceElements.isEmpty()) {
			this.logger.warning(() -> "No hint value found for source element '" + mappingHintSourceElement.getName()
					+ "' in " + ((NamedElement) mappingHintSourceElement.eContainer()).printInfo() + "!");
			return null;
		}

		return this.extractValue(mappingHintSourceElement, new ArrayList<>(sourceElements));
	}

	/**
	 * This extracts and returns the hint value for the given {@link GlobalDynamicSourceElement} from the source
	 * elements represented by the given <em>mappingInstance</em>.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link GlobalDynamicSourceElement} for that the hint values shall be extracted.
	 * @param matchedSections
	 *            Registry for <em>source model objects</em> that have already been matched. The matched objects are
	 *            stored in a map where the key is the corresponding {@link SourceSectionClass} that they have been
	 *            matched to.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(
			GlobalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute, SourceInstanceSelector> mappingHintSourceElement,
			MatchedSectionRegistry matchedSections, MatchedSectionDescriptor matchedSectionDescriptor,
			boolean useParallelization) {

		this.checkCanceled();

		List<MatchedSectionDescriptor> sourceDescriptors = matchedSections
				.get(mappingHintSourceElement.getSource().getContainingSection());

		// Collect all instances for the MatchedSectionDescriptors
		//
		List<EObject> sourceElements = (useParallelization ? sourceDescriptors.parallelStream()
				: sourceDescriptors.stream())
						.flatMap(descriptor -> descriptor
								.getMatchedSourceModelElementsFor(
										(SourceSectionClass) mappingHintSourceElement.getSource().eContainer(), false)
								.stream())
						.collect(Collectors.toList());

		// Reduce the list of instances based on modeled InstancePointers
		//
		if (!sourceElements.isEmpty() && !mappingHintSourceElement.getInstanceSelectors().isEmpty()) {

			for (SourceInstanceSelector instancePointer : mappingHintSourceElement.getInstanceSelectors()) {

				sourceElements = this.assetManager.getInstanceSelectorHandler().filterSourceInstances(sourceElements,
						instancePointer, matchedSectionDescriptor);
			}

		}

		if (sourceElements.isEmpty()) {
			this.logger.warning(() -> "No hint value found for source element '" + mappingHintSourceElement.getName()
					+ "' in " + ((NamedElement) mappingHintSourceElement.eContainer()).printInfo() + "')!");
			return null;
		}

		if (!(mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute)) {

			this.logger.severe(() -> "Mapping hint source elements of type '"
					+ mappingHintSourceElement.getSource().eClass() + "' are not yet supported!");
			return null;
		}

		return this.extractValue(mappingHintSourceElement, sourceElements);
	}

	/**
	 * This extracts and returns the hint value for the given {@link DynamicSourceElement} from the given list of source
	 * elements.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link DynamicSourceElement} for that the hint values shall be extracted.
	 * @param sourceElements
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(
			DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement,
			List<EObject> sourceElements) {

		this.checkCanceled();

		if (!(mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute
				|| mappingHintSourceElement.getSource() instanceof VirtualSourceSectionAttribute)) {

			this.logger.severe(() -> "Mapping hint source elements of type '"
					+ mappingHintSourceElement.getSource().eClass() + "' are not yet supported!");
			return null;
		}

		AttributeValueRepresentation hintValue = null;

		// Collect all values of the attribute in all source elements
		//
		List<String> srcAttrValues = mappingHintSourceElement.isUseElementID()
				? sourceElements.stream()
						.map(e -> String.valueOf(
								this.assetManager.getElementIDs().getID(e, mappingHintSourceElement.getSource())))
						.collect(Collectors.toList())
				: this.assetManager.getModelAccessUtil().getAttributeValueAsStringList(sourceElements,
						mappingHintSourceElement.getSource());

		if (srcAttrValues.isEmpty()) {
			this.logger.warning(() -> "No hint value found for source element '" + mappingHintSourceElement.getName()
					+ "' in " + ((NamedElement) mappingHintSourceElement.eContainer()).printInfo() + "')!");
			return null;
		}

		// Extract a hint value for each retrieved value
		//
		for (String srcAttrValue : srcAttrValues) {

			// Apply ValueModifierSets
			//
			final String valCopy = this.assetManager.getValueModifierExecutor()
					.applyAttributeValueModifiers(srcAttrValue, mappingHintSourceElement.getModifiers());

			// create a new AttributeValueRepresentation or update the existing
			// one
			if (hintValue == null) {
				hintValue = new AttributeValueRepresentation(mappingHintSourceElement.getSource(), valCopy);
			} else {
				hintValue.addValue(valCopy);
			}
		}

		return hintValue;
	}

}
