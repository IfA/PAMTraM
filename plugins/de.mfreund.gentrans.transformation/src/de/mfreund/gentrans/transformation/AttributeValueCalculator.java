package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.MappingHint;
import pamtram.metamodel.TargetSectionAttribute;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.InvalidCustomFunctionException;
import de.mfreund.gentrans.transformation.CalculatorFunctions.MaxFunction;
import de.mfreund.gentrans.transformation.CalculatorFunctions.MinFunction;
import de.mfreund.gentrans.transformation.CalculatorFunctions.RoundFunction;

/**
 * This class can be used to calculate values of {@link TargetSectionAttribute}s.
 * 
 * @author mfreund
 */
public class AttributeValueCalculator {
	
	/**
	 * used for modifying attribute values
	 */
	private final AttributeValueModifierExecutor attributeValuemodifier;

	/**
	 * RoundFunction instance, needed when evaluating ClaculatorMappingHints
	 */
	private RoundFunction round;
	
	/**
	 * MaxFunction instance, needed when evaluating ClaculatorMappingHints
	 */
	private MaxFunction max;
	
	/**
	 * MinFunction instance, needed when evaluating ClaculatorMappingHints
	 */
	private MinFunction min;
	
	/**
	 * Registry for values of global Variables that can be mapped to double
	 */
	private final Map<String, Double> globalVarValueDoubles;

	/**
	 * The console stream to be used to print messages.
	 */
	private MessageConsoleStream consoleStream;
	
	public AttributeValueCalculator(Map<String, Double> globalVarValueDoubles, AttributeValueModifierExecutor attributeValuemodifier, MessageConsoleStream consoleStream) {
		
		// initialize the custom calculator functions
		try {
			round = new RoundFunction();
			max = new MaxFunction();
			min = new MinFunction();
		} catch (InvalidCustomFunctionException e) {
			e.printStackTrace();
		}
		
		// store the attribute value modifier
		this.attributeValuemodifier = attributeValuemodifier;
		
		// store the global var value doubles
		this.globalVarValueDoubles = globalVarValueDoubles;
		
		// store the message stream
		this.consoleStream = consoleStream;
	}
	
	/**
	 * This calculates the value of a {@link TargetSectionAttribute} for a given
	 * {@link MappingHint} and a list of hint values.
	 * 
	 * @param attr The {@link TargetSectionAttribute} for which the target value is calculated.
	 * @param hint A {@link MappingHint} to be used for the calculation (typically, this should be
	 * 		either an {@link AttributeMappingu} or <em>null</em> if no hint has been found.
	 * @param attrHintValues A list of hint values to be used in the calculation.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	public String calculateAttributeValue(final TargetSectionAttribute attr,
			MappingHint hint, LinkedList<Object> attrHintValues, int i) {
		String attrValue = null;
		if (attrHintValues != null) {
			if (hint instanceof AttributeMapping) {
				attrValue = "";
					
				if(((AttributeMapping) hint).getExpression() != null && !((AttributeMapping) hint).getExpression().isEmpty()) {
					try {
						final Map<String, Double> vars = new HashMap<String, Double>();
						vars.putAll(globalVarValueDoubles);
						/*
						 * Names of local (CalcMapping) variables will
						 * overwrite names of global variables
						 */
						@SuppressWarnings("unchecked")
						final Map<AttributeMappingSourceElement, AttributeValueRepresentation> varValues = 
								(Map<AttributeMappingSourceElement, AttributeValueRepresentation>) attrHintValues.remove(0);
						final Map<String, Double> stringVarValues = new HashMap<String, Double>();
						for (AttributeMappingSourceInterface s : varValues.keySet()) {
							if(varValues.get(s).isMany()) {
								stringVarValues.put(s.getName(), Double.valueOf(varValues.get(s).getValues().get(i)));
							} else {
								stringVarValues.put(s.getName(), Double.valueOf(varValues.get(s).getValue()));
							}
						}
						
						vars.putAll(stringVarValues);

						attrValue = String
								.valueOf(new ExpressionBuilder(
										((AttributeMapping) hint)
										.getExpression())
								// make calculation
								.withCustomFunction(round)
								.withCustomFunction(max)
								.withCustomFunction(min)
								.withVariables(vars).build()
								.calculate());
					} catch (final Exception e) {// TODO this will lead
						// to a lot of error
						// output if it
						// fails
						consoleStream
						.println("Error parsing the expression of CalculatorMapping"
								+ hint.getName()
								+ ". Message:\n"
								+ e.getMessage());
					}
				} else {
					
					@SuppressWarnings("unchecked")
					final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hVal = 
							(Map<AttributeMappingSourceInterface, AttributeValueRepresentation>) attrHintValues.remove(0);
					for (final AttributeMappingSourceInterface srcElement : ((AttributeMapping) hint)
							.getSourceAttributeMappings()) {
						if (hVal.containsKey(srcElement)) {
							if(hVal.get(srcElement).isMany()) {
								attrValue += hVal.get(srcElement).getValues().get(i);
							} else {
								attrValue += hVal.get(srcElement).getValue();
							}
						} else {
							consoleStream
							.println("HintSourceValue not found for element "
									+ srcElement.getName()
									+ " in hint "
									+ hint.getName() + ".");
						}
					}
				}
				
				if (attrValue != null) {// apply resultModifiers if
					// all went well
					attrValue = attributeValuemodifier
							.applyAttributeValueModifiers(
									attrValue,
									((AttributeMapping) hint)
									.getResultModifier());
				}
				
			} else {
				attrValue = (String) attrHintValues.remove(0);
			}
		}
		// only use value of target section if no hint value
		// present
		if (attr.getValue() != null && attrValue == null
				&& !attr.getValue().equals("")) {
			attrValue = attr.getValue();
		}
		return attrValue;
	}
}
