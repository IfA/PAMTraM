package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModifiableHint;
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
	 * @param attr The {@link TargetSectionAttribute} for which the target value is calculated or <em>null</em> if
	 * 		the given hint is a {@link MappingInstanceSelector}.
	 * @param hint A {@link MappingHint} to be used for the calculation (typically, this should be
	 * 		either an {@link AttributeMapping}, a {@link MappingInstanceSelector} with {@link AttributeMatcher}, or 
	 * 		<em>null</em> if no hint has been found.
	 * @param attrHintValueList A list of hint values to be used in the calculation. Each entry of the list represents
	 * 		the hint values for one instance that is created.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	public String calculateAttributeValue(
			final TargetSectionAttribute attr,
			MappingHint hint, 
			Object attrHintValueList) {
		String attrValue = null;
		if (attrHintValueList != null) {
			
			// this is the map of hint values that we will use for this calculation
			@SuppressWarnings("unchecked")
			Map<?, AttributeValueRepresentation> attrHintValues = 
					((LinkedList<Map<?, AttributeValueRepresentation>>) attrHintValueList).removeFirst(); 
			
			// determine the value of the 'expression' attribute
			String expression = "";
			if (hint instanceof AttributeMapping) {
				expression = ((AttributeMapping) hint).getExpression();
			} else if(hint instanceof MappingInstanceSelector && ((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
				expression = ((AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher()).getExpression();
			}
			
			// calculate the value based on the hint values and a possible expression
			if(expression.isEmpty()) {
				attrValue = calculateAttributeValueWithoutExpression(hint, attrHintValues);
			} else {
				attrValue = calculateAttributeValueWithExpression(hint, attrHintValues, expression);
			}
					
			// apply resultModifiers if everything went well
			if (attrValue != null) {
				ModifiableHint modifiableHint = null;
				if(hint instanceof AttributeMapping) {
					modifiableHint = (AttributeMapping) hint;
				} else if(hint instanceof MappingInstanceSelector) {
					modifiableHint = (AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher();
				}
				attrValue = attributeValuemodifier.applyAttributeValueModifiers(
						attrValue, modifiableHint.getResultModifier());
			}

		}
		// only use value of target section if no hint value
		// present
		if (attr != null && attr.getValue() != null && attrValue == null
				&& !attr.getValue().equals("")) {
			attrValue = attr.getValue();
		}
		return attrValue;
	}
	
	/**
	 * This calculates an attribute value based on a list of given hint values.
	 ** @param hint A {@link MappingHint} to be used for the calculation (typically, this should be
	 * 		either an {@link AttributeMapping}, a {@link MappingInstanceSelector} with {@link AttributeMatcher}, or 
	 * 		<em>null</em> if no hint has been found.
	 * @param attrHintValues A list of hint values to be used in the calculation.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateAttributeValueWithoutExpression(MappingHint hint, Map<?, AttributeValueRepresentation> attrHintValues) {
		
		String attrValue = "";
		
		if(hint instanceof AttributeMapping) {
			for (final AttributeMappingSourceInterface srcElement : 
					((AttributeMapping) hint).getSourceAttributeMappings()) {
				if (attrHintValues.containsKey(srcElement)) {
					attrValue += attrHintValues.get(srcElement).getNextValue();
				} else {
					consoleStream.println("HintSourceValue not found for element " + srcElement.getName()
							+ " in hint " + hint.getName() + ".");
				}
			}
		} else if(hint instanceof MappingInstanceSelector) {
			for (final AttributeMatcherSourceInterface srcElement : 
						((AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher()).getSourceAttributes()) {
				if (attrHintValues.containsKey(srcElement)) {
					attrValue += attrHintValues.get(srcElement).getNextValue();
				} else {
					consoleStream.println("HintSourceValue not found for element " + srcElement.getName()
							+ " in hint " + hint.getName() + ".");
				}
			}
		}
		
		return attrValue;
	}
	
	/**
	 * This calculates an attribute value based on a list of given hint values and an expression.
	 ** @param hint A {@link MappingHint} to be used for the calculation (typically, this should be
	 * 		either an {@link AttributeMapping}, a {@link MappingInstanceSelector} with {@link AttributeMatcher}, or 
	 * 		<em>null</em> if no hint has been found.
	 * @param attrHintValues A list of hint values to be used in the calculation.
	 * @param expression An expression to be used to calculate the hint values.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateAttributeValueWithExpression(MappingHint hint, Map<?, AttributeValueRepresentation> attrHintValues, String expression) {
		
		String attrValue = "";
		
		try {
			final Map<String, Double> vars = new HashMap<>();
			vars.putAll(globalVarValueDoubles);
			/*
			 * Names of local (CalcMapping) variables will
			 * overwrite names of global variables
			 */
			final Map<String, Double> stringVarValues = new HashMap<>();
			if(hint instanceof AttributeMapping) {
				@SuppressWarnings("unchecked")
				final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> varValues = 
				(Map<AttributeMappingSourceInterface, AttributeValueRepresentation>) attrHintValues;
				for (AttributeMappingSourceInterface s : varValues.keySet()) {
					stringVarValues.put(s.getName(), Double.valueOf(varValues.get(s).getNextValue()));
				}
			} else if(hint instanceof MappingInstanceSelector) {
				@SuppressWarnings("unchecked")
				final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> varValues = 
				(Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>) attrHintValues;
				for (AttributeMatcherSourceInterface s : varValues.keySet()) {
					stringVarValues.put(s.getName(), Double.valueOf(varValues.get(s).getNextValue()));
				}
			}
			
			vars.putAll(stringVarValues);

			// make calculation
			attrValue = String.valueOf(new ExpressionBuilder(expression)
					.withCustomFunction(round)
					.withCustomFunction(max)
					.withCustomFunction(min)
					.withVariables(vars).build()
					.calculate());
		} catch (final Exception e) {
			// TODO this will lead to a lot of error output if it fails
			consoleStream.println("Error parsing the expression of CalculatorMapping" + hint.getName()
					+ ". Message:\n" + e.getMessage());
		}
		
		return attrValue;
	}
}
