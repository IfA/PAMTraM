package de.mfreund.gentrans.transformation.matching;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import pamtram.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.structure.ExternalModifiedAttributeElementType;
import pamtram.structure.GlobalModifiedAttributeElementType;
import pamtram.structure.InstanceSelector;
import pamtram.structure.ModifiedAttributeElementType;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This represents an abstract base class that allows to extract {@link AttributeValueRepresentation values}
 * from a list of {@link MatchedSectionDescriptor MatchedSectionDescriptors}.
 *
 * @author mfreund
 *
 */
public abstract class ValueExtractor extends CancelableElement {

	/**
	 * The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 */
	protected final AttributeValueModifierExecutor attributeValueModifierExecutor;
	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	protected final Logger logger;

	/**
	 * Registry for values of {@link GlobalAttribute GlobalAttributes}.
	 */
	protected final Map<GlobalAttribute, String> globalAttributeValues;

	/**
	 * This creates an instance for a given list of
	 * {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param attributeValueModifierExecutor
	 *            The {@link AttributeValueModifierExecutor} that shall be used
	 *            for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public ValueExtractor(AttributeValueModifierExecutor attributeValueModifierExecutor, Logger logger) {

		this.attributeValueModifierExecutor = attributeValueModifierExecutor;
		this.logger = logger;
		this.globalAttributeValues = new HashMap<>();
	}

	/**
	 * This creates an instance for a given list of
	 * {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param globalAttributeValues
	 *            The values of {@link GlobalAttribute GlobalAttributes} that
	 *            shall be used by
	 *            {@link #extractValue(GlobalAttributeImporter, MatchedSectionDescriptor)}.
	 * @param attributeValueModifierExecutor
	 *            The {@link AttributeValueModifierExecutor} that shall be used
	 *            for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public ValueExtractor(Map<GlobalAttribute, String> globalAttributeValues,
			AttributeValueModifierExecutor attributeValueModifierExecutor, Logger logger) {

		this.attributeValueModifierExecutor = attributeValueModifierExecutor;
		this.logger = logger;
		this.globalAttributeValues = globalAttributeValues;
	}

	/**
	 * This is the getter for the {@link #globalAttributeValues}.
	 *
	 * @return The registry for values of {@link GlobalAttribute GlobalAttributes}.
	 */
	public Map<GlobalAttribute, String> getGlobalAttributeValues() {
		return this.globalAttributeValues;
	}

	/**
	 * This extracts and returns the value for the given {@link FixedValue} from the source elements represented
	 * by the given <em>matchedSectionDescriptor</em>.
	 *
	 * @param fixedValue The {@link FixedValue} for that the values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could be extracted.
	 */
	protected AttributeValueRepresentation extractValue(FixedValue fixedValue, MatchedSectionDescriptor matchedSectionDescriptor) {

		//FIXME two different FixedValues are currently not supported (both get added to the 'null' attribute
		return new AttributeValueRepresentation(null, fixedValue.getValue());
	}

	/**
	 * This extracts and returns the value for the given {@link GlobalAttributeImporter} from the source elements represented
	 * by the given <em>mappingInstance</em>.
	 *
	 * @param globaleAttributeImporter The {@link GlobalAttributeImporter} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could be extracted.
	 */
	protected AttributeValueRepresentation extractValue(GlobalAttributeImporter globaleAttributeImporter, MatchedSectionDescriptor matchedSectionDescriptor) {

		return this.globalAttributeValues.containsKey(globaleAttributeImporter.getGlobalAttribute()) ?
				new AttributeValueRepresentation(null, this.globalAttributeValues.get(globaleAttributeImporter.getGlobalAttribute())) : null;
	}

	/**
	 * This extracts and returns the hint value for the given {@link ModifiedAttributeElementType} from the source
	 * elements represented by the given <em>mappingInstance</em>.
	 * <p />
	 * Note: This method must not be used for {@link GlobalModifiedAttributeElementType
	 * GlobalModifiedAttributeElementTypes}. Use {@link #extractValue(GlobalModifiedAttributeElementType, Map)} instead.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link ModifiedAttributeElementType} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement, MatchedSectionDescriptor matchedSectionDescriptor) {

		AttributeValueRepresentation hintValue = null;

		MatchedSectionDescriptor sourceDescriptor = matchedSectionDescriptor;

		// In case we are dealing with an external source element, we first need to determine the correct
		// 'container descriptor' that represents the source element
		//
		if(mappingHintSourceElement instanceof ExternalModifiedAttributeElementType<?,?,?,?>) {
			while (!sourceDescriptor.getSourceModelObjectsMapped().containsKey(mappingHintSourceElement.getSource().eContainer())) {
				sourceDescriptor = sourceDescriptor.getContainerDescriptor();
				if(sourceDescriptor == null) {
					// Error: could not determine hint value
					return null;
				}
			}
		}

		Set<EObject> sourceElements = sourceDescriptor.getSourceModelObjectsMapped().get(mappingHintSourceElement.getSource().eContainer());

		if(sourceElements == null) {
			this.logger.warning("Hint source value '" + mappingHintSourceElement.getName() + "' not found!");
			return null;
		}

		if (!(mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute)) {

			this.logger.severe("Mapping hint source elements of type '" + mappingHintSourceElement.getSource().eClass()
					+ "' are not yet supported!");
			return null;
		}

		EAttribute sourceAttribute = ((ActualSourceSectionAttribute) mappingHintSourceElement.getSource())
				.getAttribute();

		// Collect all values of the attribute in all source elements
		//
		List<Object> srcAttrValues;
		if(sourceAttribute.isMany()) {
			srcAttrValues = sourceElements.parallelStream().flatMap(
					e -> ((Collection<?>) e.eGet(sourceAttribute)).parallelStream()).collect(Collectors.toList());
		} else {
			srcAttrValues = sourceElements.parallelStream().map(
					e -> e.eGet(sourceAttribute)).collect(Collectors.toList());
		}

		// Extract a hint value for each retrieved value
		//
		for (Object srcAttrValue : srcAttrValues) {

			// convert Attribute value to String
			final String srcAttrAsString = sourceAttribute.getEType().getEPackage().getEFactoryInstance()
					.convertToString(sourceAttribute.getEAttributeType(), srcAttrValue);

			final String valCopy = this.attributeValueModifierExecutor
					.applyAttributeValueModifiers(srcAttrAsString, mappingHintSourceElement.getModifiers());

			// create a new AttributeValueRepresentation or update the existing one
			if(hintValue == null) {
				hintValue = new AttributeValueRepresentation(mappingHintSourceElement.getSource(), valCopy);
			} else {
				hintValue.addValue(valCopy);
			}
		}

		return hintValue;
	}

	/**
	 * This extracts and returns the hint value for the given {@link GlobalModifiedAttributeElementType} from the source
	 * elements represented by the given <em>mappingInstance</em>.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link GlobalModifiedAttributeElementType} for that the hint values shall be extracted.
	 * @param matchedSections
	 *            Registry for <em>source model objects</em> that have already been matched. The matched objects are
	 *            stored in a map where the key is the corresponding {@link SourceSectionClass} that they have been
	 *            matched to.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(
			GlobalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement,
			Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		AttributeValueRepresentation hintValue = null;

		List<MatchedSectionDescriptor> sourceDescriptors = matchedSections
				.get(mappingHintSourceElement.getSource().getContainingSection());

		// Collect all instances for the MatchedSectionDescriptors
		//
		List<EObject> sourceElements = sourceDescriptors.parallelStream().flatMap(descriptor -> descriptor
				.getSourceModelObjectsMapped().get(mappingHintSourceElement.getSource().eContainer()).stream())
				.collect(Collectors.toList());

		// Reduce the list of instances based on modeled InstancePointers
		//
		if (!sourceElements.isEmpty() && !mappingHintSourceElement.getInstanceSelectors().isEmpty()) {

			GlobalValueMap gv = new GlobalValueMap(new HashMap<>(), this.globalAttributeValues);
			InstanceSelectorHandler instancePointerHandler = new InstanceSelectorHandler(matchedSections, gv,
					new AttributeValueCalculator(gv, this.attributeValueModifierExecutor, this.logger), this.logger);

			for (InstanceSelector instancePointer : mappingHintSourceElement.getInstanceSelectors()) {

				sourceElements = instancePointerHandler.getSelectedInstancesByInstanceList(instancePointer,
						sourceElements, matchedSectionDescriptor);
			}

		}

		if (sourceElements.isEmpty()) {
			this.logger.warning("Hint source value '" + mappingHintSourceElement.getName() + "' not found!");
			return null;
		}

		if (!(mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute)) {

			this.logger.severe("Mapping hint source elements of type '" + mappingHintSourceElement.getSource().eClass()
					+ "' are not yet supported!");
			return null;
		}

		EAttribute sourceAttribute = ((ActualSourceSectionAttribute) mappingHintSourceElement.getSource())
				.getAttribute();

		// Collect all values of the attribute in all source elements
		//
		List<Object> srcAttrValues;
		if (sourceAttribute.isMany()) {
			srcAttrValues = sourceElements.parallelStream()
					.flatMap(e -> ((Collection<?>) e.eGet(sourceAttribute)).parallelStream())
					.collect(Collectors.toList());
		} else {
			srcAttrValues = sourceElements.parallelStream().map(e -> e.eGet(sourceAttribute))
					.collect(Collectors.toList());
		}

		// Extract a hint value for each retrieved value
		//
		for (Object srcAttrValue : srcAttrValues) {

			// convert Attribute value to String
			final String srcAttrAsString = sourceAttribute.getEType().getEPackage().getEFactoryInstance()
					.convertToString(sourceAttribute.getEAttributeType(), srcAttrValue);

			final String valCopy = this.attributeValueModifierExecutor.applyAttributeValueModifiers(srcAttrAsString,
					mappingHintSourceElement.getModifiers());

			// create a new AttributeValueRepresentation or update the existing one
			if (hintValue == null) {
				hintValue = new AttributeValueRepresentation(mappingHintSourceElement.getSource(), valCopy);
			} else {
				hintValue.addValue(valCopy);
			}
		}

		return hintValue;
	}

}