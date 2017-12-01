package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.ElementIDMap;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
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
	 * @param globalValues
	 *            The {@link GlobalValueMap} where the extracted values are stored.
	 * @param elementIDs
	 *            The {@link ElementIDMap} managing model-unique ids of {@link EObject elements}.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used for selecting specific instances when extracting values.
	 * @param attributeValueModifierExecutor
	 *            The {@link ValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 */
	public GlobalAttributeValueExtractor(GlobalValueMap globalValues, ElementIDMap elementIDs,
			InstanceSelectorHandler instanceSelectorHandler, ValueModifierExecutor attributeValueModifierExecutor,
			Logger logger, boolean useParallelization) {

		super(globalValues, elementIDs, instanceSelectorHandler, attributeValueModifierExecutor, logger,
				useParallelization);
	}

	/**
	 * This extracts and returns the values of {@link GlobalAttribute GlobalAttributes}.
	 * <p />
	 * Note: The extracted values are also stored in the {@link #globalValues}.
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
		Map<GlobalAttribute, List<MatchedSectionDescriptor>> sourceSectionByGlobalAttribute = (this.useParallelization
				? mappingModels.parallelStream()
				: mappingModels.stream())
						.flatMap(m -> (this.useParallelization ? m.getGlobalAttributes().parallelStream()
								: m.getGlobalAttributes().stream()))
						.collect(Collectors.toMap(i -> i,
								i -> matchedSectionRegistry.containsKey(i.getSource().getContainingSection())
										? matchedSectionRegistry.get(i.getSource().getContainingSection())
										: new ArrayList<>()));

		// Extract values for GlobalAttributes
		//
		sourceSectionByGlobalAttribute.entrySet().stream()
				.forEach(e -> e.getValue().stream().forEach(m -> this.extractGlobalAttributeValue(e.getKey(), m)));

		return this.globalValues.getGlobalAttributes();
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

		if (this.globalValues.getGlobalAttributes().containsKey(globalAttribute)) {
			this.logger.warning(() -> "Multiple source values found for global attribute '" + globalAttribute.getName()
					+ "'." + " This is not supported. Only the first element is used!");
		}

		Set<EObject> sourceElements = matchedSectionDescriptor
				.getMatchedSourceModelElementsFor((SourceSectionClass) globalAttribute.getSource().eContainer());

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

		final String valCopy = this.attributeValueModifierExecutor.applyAttributeValueModifiers(srcAttrAsString,
				globalAttribute.getModifiers());

		// Store the found value
		//
		this.globalValues.addGlobalAttributeValue(globalAttribute, valCopy);
	}

}
