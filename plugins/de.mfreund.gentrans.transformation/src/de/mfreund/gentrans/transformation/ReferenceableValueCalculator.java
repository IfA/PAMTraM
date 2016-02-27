package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.ReferenceableElement;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.RangeBound;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.InvalidCustomFunctionException;
import de.mfreund.gentrans.transformation.calculation.ExpressionCalculator;
import de.mfreund.gentrans.transformation.calculation.MaxFunction;
import de.mfreund.gentrans.transformation.calculation.MinFunction;
import de.mfreund.gentrans.transformation.calculation.RoundFunction;

/**
 * This class can be used to calculate values of {@link ReferenceableElement}s.
 * 
 * @author gkoltun
 */
public class ReferenceableValueCalculator {

	/**
	 * Registry for values of global Variables that can be mapped to double
	 */
	private final Map<String, String> globalAttrValueDoubles;
	
	/**
	 * Registry for values of global Variables that can be mapped to double
	 */
	private final Map<String, String> globalVarValueDoubles;

	/**
	 * The console stream to be used to print messages.
	 */
	@SuppressWarnings("unused")
	private MessageConsoleStream consoleStream;
	
	public ReferenceableValueCalculator(Map<String, String> globalVarValueDoubles, Map<String, String> globalAttrValueDoubles, MessageConsoleStream consoleStream) {
		
		// store the global var value doubles
		this.globalVarValueDoubles = globalVarValueDoubles;
		
		// store the global var value doubles
		this.globalAttrValueDoubles = globalAttrValueDoubles;
		
		// store the message stream
		this.consoleStream = consoleStream;
	}
	
	/**
	 * This 
	 * @param obt 
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(Object obt) {
		
		String refValue = null;
		
		//Get first a list of references
		EList<ReferenceableElement> refObts = null;
		if(obt instanceof SingleReferenceAttributeValueConstraint){
			refObts = ((SingleReferenceAttributeValueConstraint) obt).getConstraintReferenceValue();
		} else if (obt instanceof RangeBound){
			refObts = ((RangeBound) obt).getBoundReferenceValue();
		}
		
		//From now we are start calculating
		
		//First, may only one valued referred by one NC-Reference should be used
		if(refObts.size()==1){ 
			refValue = refObts.get(0).toString(); //TODO is that the value??
		} 
		
		// If first step fails (String of refValue is empty), so secondly we try to interpret the expression
		if(refValue == "" || refValue == null){
			refValue = calculateReferenceValueWithExpression(((RangeBound) obt).getExpression(), refObts); // TODO cast-operator doesn't matter because it the same method (check it)
		}
			
		// Return the calculated value, also if it is null or empty
		return refValue;
	}

	/**
	 * This calculates an attribute value based on a list of given hint values and an expression.
	 ** @param hint A {@link MappingHint} to be used for the calculation (typically, this should be
	 * 		either an {@link AttributeMapping}, a {@link MappingInstanceSelector} with {@link AttributeMatcher}, or 
	 * 		<em>null</em> if no hint has been found.
	 * @param expression An expression to be used to calculate the hint values.
	 * @param refObts 
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateReferenceValueWithExpression(String expression, EList<ReferenceableElement> refObts) {
		
			final Map<String, String> vars = new HashMap<>();
			vars.putAll(globalVarValueDoubles);
			vars.putAll(globalAttrValueDoubles);
			
			final Map<String, Double> varsAsDouble = new HashMap<>();
			
			for (Map.Entry<String, Object> entry : map.entrySet()) {
			       try{
			            varsAsDouble.put(entry.getKey(), Double.parseDouble(entry.getValue().toString()));
			          }catch(ClassCastException cce){
			           // TODO: handle exception
			          }
			 }

			// make calculation
			ExpressionCalculator expCalc = new ExpressionCalculator();
			return (expCalc.calculateExpression(expression, varsAsDouble));
	}
}
