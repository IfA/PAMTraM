package de.mfreund.gentrans.transformation.calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import pamtram.NamedElement;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * This class can be used to calculate values of {@link TargetSectionAttribute}s.
 * 
 * @author mfreund
 * @author gkoltun (modifier)
 */
public class AttributeValueCalculator {
	
	/**
	 * used for modifying attribute values
	 */
	private final AttributeValueModifierExecutor attributeValuemodifier;
	
	/**
	 * Registry for values of global Variables that can be mapped to double
	 */
	private final Map<String, Double> globalVarValueDoubles;

	/**
	 * The console stream to be used to print messages.
	 */
	private MessageConsoleStream consoleStream;
	
	/**
	 * This creates an instance.
	 * <p />
	 * Note: This has been deprecated. Use {@link #AttributeValueCalculator(GlobalValueMap, 
	 * AttributeValueModifierExecutor, MessageConsoleStream)} instead.
	 * 
	 * @deprecated
	 * @param globalVarValueDoubles
	 * @param attributeValuemodifier
	 * @param consoleStream
	 */
	@Deprecated
	public AttributeValueCalculator(Map<String, Double> globalVarValueDoubles, AttributeValueModifierExecutor attributeValuemodifier, MessageConsoleStream consoleStream) {
		
		// store the attribute value modifier
		this.attributeValuemodifier = attributeValuemodifier;
		
		// store the global var value doubles
		this.globalVarValueDoubles = globalVarValueDoubles;
		
		// store the message stream
		this.consoleStream = consoleStream;
	}
	
	/**
	 * This creates an instance.
	 * 
	 * @param globalValues The {@link GlobalValueMap} providing values of {@link GlobalAttribute GlobalAttributes}
	 * and {@link FixedValue FixedValues} that can be used in calculations.
	 * @param attributeValuemodifier The {@link AttributeValueModifierExecutor} that shall be used to 
	 * apply {@link AttributeValueModifierSet AttributeValueModifierSets}.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages to the user.
	 */
	public AttributeValueCalculator(GlobalValueMap globalValues, AttributeValueModifierExecutor attributeValuemodifier, MessageConsoleStream consoleStream) {
		
		// store the attribute value modifier
		this.attributeValuemodifier = attributeValuemodifier;
		
		// store the global var value doubles
		this.globalVarValueDoubles = globalValues.getGlobalValuesAsDouble().entrySet().parallelStream().collect(
				Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
		
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
	@SuppressWarnings("unchecked")
	public String calculateAttributeValue(
			final TargetSectionAttribute attr,
			MappingHint hint, 
			Object attrHintValueList) {
		String attrValue = null;
		if (attrHintValueList != null && attrHintValueList instanceof LinkedList<?>) {

			// this is the map of hint values that we will use for this calculation
			Map<?, AttributeValueRepresentation> attrHintValues = 
					((LinkedList<Map<?, AttributeValueRepresentation>>) attrHintValueList).removeFirst(); 

			// determine the value of the 'expression' attribute
			String expression = "";
			if (hint instanceof AttributeMapping) {
				expression = ((AttributeMapping) hint).getExpression();
			} else if(hint instanceof MappingInstanceSelector && ((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
				expression = ((AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher()).getExpression();
			}
			
			List<AttributeValueModifierSet> resultModifiers = new ArrayList<>();
			if(hint instanceof AttributeMapping) {
				resultModifiers.addAll(((AttributeMapping) hint).getResultModifier());
			} else if(hint instanceof MappingInstanceSelector) {
				resultModifiers.addAll(((AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher()).getResultModifier());
			}
			
			// calculate the value based on the hint values and a possible expression
			if(expression.isEmpty()) {
				attrValue = calculateAttributeValueWithoutExpression(hint, attrHintValues, resultModifiers);
			} else {
				attrValue = calculateAttributeValueWithExpression(hint, attrHintValues, expression, resultModifiers);
			}
					
		}
		// only use value of target section if no hint value
		// present
		if (attr != null && attr.getValue() != null && attrValue == null
				&& !attr.getValue().isEmpty()) {
			attrValue = attr.getValue();
		}
		return attrValue;
	}
	
	/**
	 * This calculates an attribute value based on a list of given hint values.
	 ** @param hint A {@link MappingHint} to be used for the calculation (typically, this should be
	 * 		either an {@link AttributeMapping}, a {@link MappingInstanceSelector} with {@link AttributeMatcher}, or 
	 * 		<em>null</em> if no hint has been found.
	 * @param hintValues A list of hint values to be used in the calculation.
	 * @param resultModifiers The list of {@link AttributeValueModifierSet} to apply to the resulting value.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateAttributeValueWithoutExpression(MappingHint hint, Map<?, AttributeValueRepresentation> hintValues, 
			List<AttributeValueModifierSet> resultModifiers) {
		
		// Collect the source elements that determine the order in which the hint
		// values will get appended
		//
		List<Object> sourceElements = new ArrayList<>();
		if(hint instanceof AttributeMapping) {
			sourceElements.addAll(((AttributeMapping) hint).getSourceAttributeMappings());
		} else if(hint instanceof MappingInstanceSelector) {
			sourceElements.addAll(((AttributeMatcher) ((MappingInstanceSelector) hint).getMatcher()).getSourceAttributes());
		}
		
		return calculateValueWithoutExpression(sourceElements, hintValues, resultModifiers);
	}

	/**
	 * This calculates an attribute value based on a list of given hint values and an expression.
	 ** @param hint A {@link MappingHint} to be used for the calculation (typically, this should be
	 * 		either an {@link AttributeMapping}, a {@link MappingInstanceSelector} with {@link AttributeMatcher}, or 
	 * 		<em>null</em> if no hint has been found.
	 * @param attrHintValues A list of hint values to be used in the calculation.
	 * @param expression An expression to be used to calculate the hint values.
	 * @param resultModifiers The list of {@link AttributeValueModifierSet} to apply to the resulting value.
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateAttributeValueWithExpression(MappingHint hint, Map<?, AttributeValueRepresentation> attrHintValues, String expression,
			List<AttributeValueModifierSet> resultModifiers) {
		
		if(hint instanceof AttributeMapping && !((AttributeMapping) hint).getSourceAttributeMappings().isEmpty()
				&& attrHintValues.isEmpty()) {
			consoleStream.println("Error calculating the expression for hint '" + hint.getName() + "'."
					+ "No hint values have been passed.");
			return null;
		}
		
		return calculateValueWithExpression(attrHintValues, expression, resultModifiers);
	}

	/**
	 * From the given map of <em>valueParts</em>, this assembles a single String value.
	 * The order, in which the value parts are assembled is thereby determined by
	 * the (order of the) list of <em>sourceElements</em>.
	 * <p />
	 * Note: Normally, one {@link AttributeValueRepresentation value} for each 
	 * of the given <em>sourceElements</em> should exist in the given map of <em>valueParts</em>.
	 * 
	 * @param sourceElements The list of source elements that determine the order in which the
	 * <em>valueParts</em> shall be assembled.
	 * @param valueParts The value parts (the keys of the map should match the list of <em>sourceElements</em>).
	 * @param resultModifiers A list of {@link AttributeValueModifierSet AttributeValueModifierSets} to apply
	 * to the resulting value before returning it.
	 * @return The assembled value after applying the <em>resultModifiers</em>.
	 */
	public String calculateValueWithoutExpression(List<Object> sourceElements,
			Map<?, AttributeValueRepresentation> valueParts, List<AttributeValueModifierSet> resultModifiers) {
		
		StringBuilder attrValueBuilder = new StringBuilder();
		
		for (Object srcElement : sourceElements) {
			if (valueParts.containsKey(srcElement)) {
				attrValueBuilder.append(valueParts.get(srcElement).getNextValue());
			} else {
				consoleStream.println("SourceValue not found for element '" + 
						(srcElement instanceof NamedElement ? ((NamedElement) srcElement).getName() : srcElement) + 
						"'.");
			}
		}
		
		return attributeValuemodifier.applyAttributeValueModifiers(
				attrValueBuilder.toString(), resultModifiers);
	}

	/**
	 * From the given map of <em>valueParts</em>, this calculates a single String value
	 * using the given expression.
	 * <p />
	 * If no value parts are passed (i.e. <em>valueParts</em> is <em>null</em> or <em>empty</em>)
	 * the value of the expression is returned.
	 * 
	 * @param valueParts The value parts to use for the evaluation of the expression.
	 * @param expression The expression to calculate.
	 * @param resultModifiers A list of {@link AttributeValueModifierSet AttributeValueModifierSets} to apply
	 * to the resulting value before returning it.
	 * @return The calculated value after applying the <em>resultModifiers</em>.
	 */
	public String calculateValueWithExpression(Map<?, AttributeValueRepresentation> valueParts, String expression,
			List<AttributeValueModifierSet> resultModifiers) {
		// If no hint values are passed, we simply use the expression as return value
		//
		if(valueParts.isEmpty()) {
			return expression;
		}
		
		final Map<String, Double> vars = new HashMap<>();
		
		// Add global variables
		//
		vars.putAll(globalVarValueDoubles);
		
		// Add local variables (as double)
		//
		for (Entry<?, AttributeValueRepresentation> entry : valueParts.entrySet()) {
			if(entry.getKey() instanceof NamedElement) {
				
				String value = entry.getValue().getNextValue();
				try {
					vars.put(((NamedElement) entry.getKey()).getName(), Double.valueOf(value));
				} catch (NumberFormatException e) {
					consoleStream.println("Error parsing double of value '" + value + "'.");
				}					
			}
		}

		// Calculate the value
		//
		ExpressionCalculator expCalc = new ExpressionCalculator();
		String attrValue = expCalc.calculateExpression(expression, vars);
		
		// Apply the result modifiers
		return attributeValuemodifier.applyAttributeValueModifiers(
				attrValue, resultModifiers);
	}
}
