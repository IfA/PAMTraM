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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import pamtram.MappingModel;
import pamtram.PAMTraM;
import pamtram.mapping.GlobalAttribute;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class can be used to extract values of {@link GlobalAttribute GlobalAttributes} from source model elements for a
 * given list of {@link MatchedSectionDescriptor matched sections}.
 *
 * @author mfreund
 */
public class GlobalAttributeValueExtractor extends ValueExtractor {

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public GlobalAttributeValueExtractor(TransformationAssetManager assetManager) {

		super(assetManager);
	}

	/**
	 * This extracts and returns the values of {@link GlobalAttribute GlobalAttributes}.
	 * <p />
	 * Note: The extracted values are also stored in the {@link TransformationAssetManager#getGlobalValues()
	 * globalValues}.
	 *
	 * @param matchedSectionRegistry
	 *            The {@link MatchedSectionRegistry} that represents the result of the matching process. The values of
	 *            GlobalAttributes will get extracted from this.
	 * @param pamtramModels
	 *            The list of {@link PAMTraM PAMTraM models} containing the GlobalAttributes to be extracted.
	 * @return The found values of the {@link GlobalAttribute GlobalAttributes}.
	 */
	public Map<GlobalAttribute, String> extractGlobalAttributeValues(MatchedSectionRegistry matchedSectionRegistry,
			List<PAMTraM> pamtramModels) {

		List<MappingModel> mappingModels = pamtramModels.stream().flatMap(p -> p.getMappingModels().stream())
				.collect(Collectors.toList());

		// Collect the GlobalAttributes that are modeled for each MappingModels
		// and the associated
		// MatchedSectionDescriptors
		//
		Map<GlobalAttribute, List<MatchedSectionDescriptor>> sourceSectionByGlobalAttribute = (this.assetManager
				.getTransformationConfig().isUseParallelization() ? mappingModels.parallelStream()
						: mappingModels.stream())
								.flatMap(m -> (this.assetManager.getTransformationConfig().isUseParallelization()
										? m.getGlobalAttributes().parallelStream()
										: m.getGlobalAttributes().stream()))
								.collect(Collectors.toMap(i -> i,
										i -> matchedSectionRegistry.get(i.getSource().getContainingSection())));

		// Extract values for GlobalAttributes
		//
		sourceSectionByGlobalAttribute.entrySet().stream()
				.forEach(e -> e.getValue().stream().forEach(m -> this.extractGlobalAttributeValue(e.getKey(), m)));

		return this.assetManager.getGlobalValues().getGlobalAttributes();
	}

	/**
	 * This extracts the value for the given {@link GlobalAttribute} from the source elements represented by the given
	 * <em>matchedSectionDescriptor</em>.
	 * <p />
	 * Note: The extracted value is stored in {@link #globalValues}.
	 *
	 * @param globalAttribute
	 *            The {@link GlobalAttribute} for that the value shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} representing the source model elements from that values shall be
	 *            extracted.
	 */
	private void extractGlobalAttributeValue(GlobalAttribute globalAttribute,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		if (this.assetManager.getGlobalValues().getGlobalAttributes().containsKey(globalAttribute)) {
			this.logger.warning(() -> "Multiple source values found for global attribute '" + globalAttribute.getName()
					+ "'." + " This is not supported. Only the first element is used!");
		}

		Set<EObject> sourceElements = matchedSectionDescriptor
				.getMatchedSourceModelElementsFor((SourceSectionClass) globalAttribute.getSource().eContainer(), false);

		if (sourceElements == null) {
			this.logger.severe(() -> "Value of global attribute '" + globalAttribute.getName() + "' not found!");
			return;
		} else if (sourceElements.size() > 1) {
			this.logger.warning(() -> "Multiple source elements found for global attribute '"
					+ globalAttribute.getName() + "'." + " This is not supported. Only the first element is used!");
		}

		EObject sourceElement = sourceElements.iterator().next();

		EAttribute sourceAttribute = globalAttribute.getSource().getAttribute();

		/*
		 * Attributes may have a cardinality greater than 1.
		 */
		Object srcAttrValue;
		if (sourceAttribute.isMany()) {
			this.logger.warning(() -> "Multiple source values found for global attribute '" + globalAttribute.getName()
					+ "'." + " This is not supported. Only the first element is used!");
			srcAttrValue = ((Collection<?>) sourceElement.eGet(sourceAttribute)).iterator().next();
		} else {
			srcAttrValue = sourceElement.eGet(sourceAttribute);
		}

		// convert Attribute value to String
		final String srcAttrAsString = sourceAttribute.getEType().getEPackage().getEFactoryInstance()
				.convertToString(sourceAttribute.getEAttributeType(), srcAttrValue);

		final String valCopy = this.assetManager.getValueModifierExecutor()
				.applyAttributeValueModifiers(srcAttrAsString, globalAttribute.getModifiers());

		// Store the found value
		//
		this.assetManager.getGlobalValues().addGlobalAttributeValue(globalAttribute, valCopy);
	}

}
