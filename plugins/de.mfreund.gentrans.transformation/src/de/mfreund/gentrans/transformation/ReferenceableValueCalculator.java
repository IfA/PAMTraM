package de.mfreund.gentrans.transformation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.ReferenceableElement;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.RangeBound;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.calculation.ExpressionCalculator;

/**
 * This class can be used to calculate values of {@link ReferenceableElement}s.
 * 
 * @author gkoltun
 */
public class ReferenceableValueCalculator {

	/**
	 * Registry for global values
	 */
	private final Map<String, String> globalValuesAsString;
	
	/**
	 * Registry for global values that are doubles
	 */
	private final Map<String, Double> globalValuesAsDouble;
	
	/**
	 * The console stream to be used to print messages.
	 */
	@SuppressWarnings("unused")
	private MessageConsoleStream consoleStream;

	 /**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections;
	
	public ReferenceableValueCalculator(List<FixedValue> fixedVals, Map<GlobalAttribute, String> globalAttrVals, MessageConsoleStream consoleStream) {
				
		// store the message stream
		this.consoleStream = consoleStream;
		
		// find GlobalAttrs that can be mapped to double
		this.globalValuesAsString = new HashMap<>();
		for (final GlobalAttribute g : globalAttrVals.keySet()) {
			globalValuesAsString.put(g.getName(), globalAttrVals.get(g));
		}

		/*
		 * add global values
		 */
		for (final FixedValue val : fixedVals) {
			if (val.getName() != null) {
				globalValuesAsString.put(val.getName(), val.getValue());
			}
		}
		
		/*
		 * only use global values that represent doubles
		 */
		this.globalValuesAsDouble = new HashMap<>();
		for (Entry<String, String> globalValue : globalValuesAsString.entrySet()) {
			try {
				/*
				 * We make use of the ExpressionBuilder as 'String.valueOf(double)' doesn't support
				 * scientific notation, like: 0.42e2 == 4200e-2 == 42
				 */
				final Calculable calc = new ExpressionBuilder(globalValue.getValue()).build();
				globalValuesAsDouble.put(globalValue.getKey(), calc.calculate());
			} catch (final Exception e) {}
		}
	}
	
	/**
	 * General structure for calculating
	 * @param obt This is the root element which contain information over all referenced values
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
		} else {
			// more types could be supported in the future
			consoleStream.println("AttributeValueConstraint type " + obt.getClass().getName() + " is not yet supported!");
			return null;
		}
		
		//Now we are start to calculate
		
		//First, may only one valued referred by one NC-Reference should be used
		if(refObts.size()==1 && ((RangeBound) obt).getExpression().isEmpty()){
			ReferenceableElement refEle = refObts.get(0);
			if(refEle instanceof FixedValue){
				refValue = globalValuesAsString.get(((FixedValue) refEle).getName());
			} else if(refEle instanceof GlobalAttribute){
				refValue = globalValuesAsString.get(((GlobalAttribute) refEle).getName());
			} else if(refEle instanceof SourceSectionAttribute){
				refValue = null; //FIXME
				// convert Attribute value to String
				// refValue = ((SourceSectionAttribute) refEle).getAttribute().getEType().getEPackage().getEFactoryInstance()
						//.convertToString(((SourceSectionAttribute) refEle).getAttribute().getEAttributeType(), srcAttrValue);
			} else {
				// If we are here, some mistake is happened
				// more types could be supported in the future
				consoleStream.println("ReferenceableElement type " + refEle.getClass().getName() + " is not yet supported!");
				refValue = null;
			}		
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
		
		Map<String,Double> mapOfValuesForExp = this.globalValuesAsDouble;
		//mapOfValuesForExp.
		
		ExpressionCalculator expCalc = new ExpressionCalculator();
		return (expCalc.calculateExpression(expression, this.globalValuesAsDouble));
	}

	public void updateMatchedSections(LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections2) {
		this.matchedSections = matchedSections;
		
	}
}
