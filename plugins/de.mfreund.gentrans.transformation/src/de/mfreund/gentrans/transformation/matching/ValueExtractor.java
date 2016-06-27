package de.mfreund.gentrans.transformation.matching;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

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
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	protected final MessageConsoleStream consoleStream;
	
	/**
	 * Registry for values of {@link GlobalAttribute GlobalAttributes}.
	 */
	protected final Map<GlobalAttribute, String> globalAttributeValues;

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 * 
	 * @param attributeValueModifierExecutor The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public ValueExtractor(AttributeValueModifierExecutor attributeValueModifierExecutor, MessageConsoleStream consoleStream) {

		this.attributeValueModifierExecutor = attributeValueModifierExecutor;
		this.consoleStream = consoleStream;
		this.globalAttributeValues = new HashMap<>();
	}
	
	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 * 
	 * @param globalAttributeValues The values of {@link GlobalAttribute GlobalAttributes} that shall be used by
	 * {@link #extractValue(GlobalAttributeImporter, MatchedSectionDescriptor)}.
	 * @param attributeValueModifierExecutor The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public ValueExtractor(Map<GlobalAttribute, String> globalAttributeValues,
			AttributeValueModifierExecutor attributeValueModifierExecutor, MessageConsoleStream consoleStream) {

		this.attributeValueModifierExecutor = attributeValueModifierExecutor;
		this.consoleStream = consoleStream;
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
		
		return globalAttributeValues.containsKey(globaleAttributeImporter.getGlobalAttribute()) ?
				new AttributeValueRepresentation(null, globalAttributeValues.get(globaleAttributeImporter.getGlobalAttribute())) : null;
	}

	/**
	 * This extracts and returns the hint value for the given {@link ModifiedAttributeElementType} from the source elements represented
	 * by the given <em>mappingInstance</em>.
	 * 
	 * @param mappingHintSourceElement The {@link ModifiedAttributeElementType} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could be extracted.
	 */
	protected AttributeValueRepresentation extractValue(ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement, MatchedSectionDescriptor matchedSectionDescriptor) {
		
		AttributeValueRepresentation hintValue = null;
		
		MatchedSectionDescriptor sourceDescriptor = matchedSectionDescriptor;
		
		// In case we are dealing with an external source element, we first need to determine the correct
		// 'container descriptor' that represents the source element
		//
		if(mappingHintSourceElement instanceof ExternalModifiedAttributeElementType<?,?,?,?>) {
			do {
				sourceDescriptor = sourceDescriptor.getContainerDescriptor();
				if(sourceDescriptor == null) {
					// Error: could not determine hint value
					return null;
				}
			} while (!sourceDescriptor.getSourceModelObjectsMapped().containsKey(mappingHintSourceElement.getSource().eContainer()));
		}
		
		Set<EObject> sourceElements = sourceDescriptor.getSourceModelObjectsMapped().get(mappingHintSourceElement.getSource().eContainer());
		
		if(sourceElements == null) {
			consoleStream.println("Hint source value '" + mappingHintSourceElement.getName() + "' not found!");
			return null;
		}
		
		EAttribute sourceAttribute = mappingHintSourceElement.getSource().getAttribute();
		
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
			
			final String valCopy = attributeValueModifierExecutor
					.applyAttributeValueModifiers(srcAttrAsString, mappingHintSourceElement.getModifier());
			
			// create a new AttributeValueRepresentation or update the existing one
			if(hintValue == null) {
				hintValue = new AttributeValueRepresentation(mappingHintSourceElement.getSource(), valCopy);
			} else {
				hintValue.addValue(valCopy);
			}
		}
		
		return hintValue;
	}

}