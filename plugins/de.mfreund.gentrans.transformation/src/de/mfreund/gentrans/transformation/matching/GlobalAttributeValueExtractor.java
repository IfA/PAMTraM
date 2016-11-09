package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.metamodel.SourceSection;

/**
 * This class can be used to extract values of {@link GlobalAttribute GlobalAttributes}
 * from source model elements for a given list of {@link MatchedSectionDescriptor matched sections}.
 * 
 * @author mfreund
 */
public class GlobalAttributeValueExtractor extends ValueExtractor {

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 * 
	 * @param attributeValueModifierExecutor The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param logger The {@link Logger} that shall be used to print messages.
	 */
	public GlobalAttributeValueExtractor(AttributeValueModifierExecutor attributeValueModifierExecutor,
			Logger logger) {
		super(attributeValueModifierExecutor, logger);
	}

	/**
	 * This extracts and returns the values of {@link GlobalAttribute GlobalAttributes} for the given list of
	 * {@link MappingInstanceStorage mapping instance}.
	 * FIXME In the future, GlobalAttributes should be modeled as direct children of a MappingModel instead of a Mapping.
	 * That way, they can be used even if a mapping is not selected. This is possible due to the new matching process.
	 * 
	 * @param matchingResult The set of MatchedSectionDescriptors that represents the result of the matching process. The values
	 * of GlobalAttributes will get extracted from this.
	 * @param suitableMappings The list of {@link Mapping Mappings} containing the GlobalAttributes to be extracted.
	 * @return The found values of the {@link GlobalAttribute GlobalAttributes}.
	 */
	public Map<GlobalAttribute, String> extractGlobalAttributeValues(
			Map<SourceSection, List<MatchedSectionDescriptor>> matchingResult, 
			List<Mapping> suitableMappings) {

		// Collect the GlobalAttributes that are modeled for each SourceSection
		//
		Map<SourceSection, EList<GlobalAttribute>> globalAttributesBySection =
				suitableMappings.parallelStream().collect(Collectors.toConcurrentMap(
						Mapping::getSourceSection, Mapping::getGlobalVariables, (i, j) -> { i.addAll(j); return i;}));

		// Collect the MatchedSectionDescriptors for each GlobalAttribute
		//
		Map<GlobalAttribute, List<MatchedSectionDescriptor>> sourceSectionByGlobalAttribute = new HashMap<>();

		globalAttributesBySection.entrySet().stream().forEach(e -> {
			e.getValue().stream().forEach(g -> {
				sourceSectionByGlobalAttribute.put(g, 
						matchingResult.containsKey(e.getKey()) ? matchingResult.get(e.getKey()): new ArrayList<>());
			});
		});

		// Extract values for GlobalAttributes
		//
		sourceSectionByGlobalAttribute.entrySet().stream().forEach(e -> 
		e.getValue().stream().forEach(m -> extractGlobalAttributeValue(e.getKey(), m))
				);

		return this.globalAttributeValues;
	}

	/**
	 * This extracts the value for the given {@link GlobalAttribute} from the source elements represented
	 * by the given <em>matchedSectionDescriptor</em>.
	 * <p />
	 * Note: The extracted value is stored in {@link #globalAttributeValues}.
	 * 
	 * @param globalAttribute The {@link GlobalAttribute} for that the value shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} representing the source model elements from that values shall be extracted.
	 */
	private void extractGlobalAttributeValue(GlobalAttribute globalAttribute, MatchedSectionDescriptor matchedSectionDescriptor) {

		if(globalAttributeValues.containsKey(globalAttribute)) {
			logger.warning("Multiple source values found for global attribute '" + globalAttribute.getName() + "'."
					+ " This is not supported. Only the first element is used!");
		}

		Set<EObject> sourceElements = matchedSectionDescriptor.getSourceModelObjectsMapped().get(globalAttribute.getSource().eContainer());

		if(sourceElements == null) {
			logger.severe("Value of global attribute '" + globalAttribute.getName() + "' not found!");
			return;
		} else if(sourceElements.size() > 1) {
			logger.warning("Multiple source elements found for global attribute '" + globalAttribute.getName() + "'."
					+ " This is not supported. Only the first element is used!");
		}

		EObject sourceElement = sourceElements.iterator().next();

		EAttribute sourceAttribute = globalAttribute.getSource().getAttribute();

		/*
		 * Attributes may have a cardinality greater than 1.
		 */
		Object srcAttrValue;
		if(sourceAttribute.isMany()) {
			logger.warning("Multiple source values found for global attribute '" + globalAttribute.getName() + "'."
					+ " This is not supported. Only the first element is used!");
			srcAttrValue = ((Collection<?>) sourceElement.eGet(sourceAttribute)).iterator().next();
		} else {
			srcAttrValue = sourceElement.eGet(sourceAttribute);
		}

		// convert Attribute value to String
		final String srcAttrAsString = sourceAttribute.getEType().getEPackage().getEFactoryInstance()
				.convertToString(sourceAttribute.getEAttributeType(), srcAttrValue);

		final String valCopy = attributeValueModifierExecutor
				.applyAttributeValueModifiers(srcAttrAsString, globalAttribute.getModifier());

		// Store the found value
		//
		globalAttributeValues.put(globalAttribute, valCopy);		
	}

}
