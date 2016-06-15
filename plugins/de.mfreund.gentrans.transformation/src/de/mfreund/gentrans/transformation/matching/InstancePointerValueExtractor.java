package de.mfreund.gentrans.transformation.matching;

import java.util.Map;

import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.AttributeValueRepresentation;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * This class can be used to extract values required by an {@link InstancePointer}
 * from source model elements for a given list of {@link MatchedSectionDescriptor matched sections}.
 * 
 * @author mfreund
 */
public class InstancePointerValueExtractor extends ValueExtractor {

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 * 
	 * @param globalAttributeValues The values of {@link GlobalAttribute GlobalAttributes} that shall be used by
	 * {@link #extractValue(GlobalAttributeImporter, MatchedSectionDescriptor)}.
	 * @param attributeValueModifierExecutor The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public InstancePointerValueExtractor(Map<GlobalAttribute, String> globalAttributeValues,
			AttributeValueModifierExecutor attributeValueModifierExecutor, MessageConsoleStream consoleStream) {
		
		super(globalAttributeValues, attributeValueModifierExecutor, consoleStream);
	}

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 * 
	 * @param attributeValueModifierExecutor The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public InstancePointerValueExtractor(AttributeValueModifierExecutor attributeValueModifierExecutor, MessageConsoleStream consoleStream) {
		
		super(attributeValueModifierExecutor, consoleStream);
	}
	
	/**
	 * This extracts and returns the required target value for the given {@link InstancePointer} as specified by its 
	 * {@link InstancePointer#getSourceAttributes() source attributes}.
	 * 
	 * @param instancePointer The {@link InstancePointer} for that the target value shall be extracted.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} for that the value shall be extracted.
	 * @return The extracted value (after applying a possible {@link InstancePointer#getResultModifier() result modifier} or 
	 * '<em><b>null</b></em>' if no value could be extracted.
	 */
	@SuppressWarnings("unchecked")
	public String extractRequiredTargetValue(InstancePointer instancePointer, 
			MatchedSectionDescriptor matchedSectionDescriptor) {
		
		// This is used to assemble the parts of the target value
		//
		StringBuilder valueBuilder = new StringBuilder();
		
		// Extract the value part based on its type
		//
		for (InstancePointerSourceInterface instancePointerSourceInterface : instancePointer.getSourceAttributes()) {
			
			AttributeValueRepresentation attributeValueRepresentation = null;
			
			if(instancePointerSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = extractValue((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) instancePointerSourceInterface, matchedSectionDescriptor);
			} else if(instancePointerSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = extractValue((FixedValue) instancePointerSourceInterface, matchedSectionDescriptor); 
			} else if(instancePointerSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = extractValue((GlobalAttributeImporter) instancePointerSourceInterface, matchedSectionDescriptor); 
			} else {
				consoleStream.println("Unsupported type of source element for an InstancePointer found: '" + 
						instancePointerSourceInterface.eClass().getName() + "'!");
			}
			
			if(attributeValueRepresentation != null) {					

				if(attributeValueRepresentation.isMany()) {
					consoleStream.println("Multiple values found for the source element '" + instancePointerSourceInterface.getName() +
							"' of an InstancePointer! This is currently not supported and only the first found value will be used!'");
				}
				
				valueBuilder.append(attributeValueRepresentation.getNextValue());
			}
		}
		
		return instancePointer.getResultModifier().isEmpty() 
				? valueBuilder.toString()
				: attributeValueModifierExecutor.applyAttributeValueModifiers(valueBuilder.toString(), instancePointer.getResultModifier());
		
	}

}
