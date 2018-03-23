/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.matching;

import java.util.LinkedHashMap;

import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.FixedValue;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to extract values required by an {@link InstanceSelector} from source model elements for a
 * given list of {@link MatchedSectionDescriptor matched sections}.
 *
 * @author mfreund
 */
public class InstanceSelectorValueExtractor extends ValueExtractor {

	/**
	 * The {@link ValueCalculator} to be used calculate target values.
	 */
	private ValueCalculator attributeValueCalculator;

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public InstanceSelectorValueExtractor(TransformationAssetManager assetManager) {

		super(assetManager);

		this.attributeValueCalculator = assetManager.getValueCalculator();
	}

	/**
	 * This extracts and returns the required target value for the given {@link InstanceSelector} as specified by its
	 * {@link InstanceSelector#getSourceElements() source attributes}.
	 *
	 * @param instanceSelector
	 *            The {@link InstanceSelector} for that the target value shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the value shall be extracted.
	 * @return The extracted value (after applying a possible {@link InstanceSelector#getModifiers() result modifier} or
	 *         '<em><b>null</b></em>' if no value could be extracted.
	 */
	@SuppressWarnings("unchecked")
	public String extractRequiredTargetValue(InstanceSelector instanceSelector,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		// Collect the value parts
		//
		LinkedHashMap<InstanceSelectorSourceInterface, AttributeValueRepresentation> valueParts = new LinkedHashMap<>();

		// Extract the value part based on its type
		//
		for (InstanceSelectorSourceInterface instanceSelectorSourceInterface : instanceSelector.getSourceElements()) {

			AttributeValueRepresentation attributeValueRepresentation = null;

			if (instanceSelectorSourceInterface instanceof DynamicSourceElement<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) instanceSelectorSourceInterface,
						matchedSectionDescriptor);
			} else if (instanceSelectorSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = this.extractValue((FixedValue) instanceSelectorSourceInterface,
						matchedSectionDescriptor);
			} else if (instanceSelectorSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = this.extractValue(
						(GlobalAttributeImporter) instanceSelectorSourceInterface, matchedSectionDescriptor);
			} else {
				this.logger.severe(() -> "Unsupported type of source element for an InstanceSelector found: '"
						+ instanceSelectorSourceInterface.eClass().getName() + "'!");
			}

			if (attributeValueRepresentation != null) {

				if (attributeValueRepresentation.isMany()) {
					this.logger.warning(() -> "Multiple values found for the source element '"
							+ instanceSelectorSourceInterface.getName() + "' of " + instanceSelector.printInfo()
							+ "! This is currently not supported and only the first found value will be used!'");
				}

				valueParts.put(instanceSelectorSourceInterface, attributeValueRepresentation);
			}
		}

		// Assemble the target value based on the value parts and a potential
		// expression
		//
		return this.attributeValueCalculator.calculateValue(instanceSelector.getExpression(), valueParts,
				instanceSelector.getModifiers());

	}

}
