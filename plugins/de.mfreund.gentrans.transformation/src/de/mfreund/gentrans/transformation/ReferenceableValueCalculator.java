package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.ReferenceableElement;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.RangeBound;
import de.congrace.exp4j.Calculable;
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
	private MessageConsoleStream consoleStream;

	 /**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections;
	
	/**
	 * It will be used for extract a more in detail specified Element which was more than one times matched
	 */
	private InstancePointerHandler instancePointerHandler;
	
	/**
	 * RoundFunction instance, maybe needed when inside of an expression defined
	 */
	private RoundFunction round;
	
	/**
	 * MaxFunction instance, maybe needed when inside of an expression defined
	 */
	private MaxFunction max;
	
	/**
	 * MinFunction instance, maybe needed when inside of an expression defined
	 */
	private MinFunction min;
	
	public ReferenceableValueCalculator(List<FixedValue> fixedVals, Map<GlobalAttribute, String> globalAttrVals, InstancePointerHandler instancePointerHandler, MessageConsoleStream consoleStream) {
				
		// store the message stream
		this.consoleStream = consoleStream;
		
		// store the instance pointer handler
		this.instancePointerHandler = instancePointerHandler;
		
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
		
		// initialize the custom calculator functions
		try {
			round = new RoundFunction();
			max = new MaxFunction();
			min = new MinFunction();
		} catch (InvalidCustomFunctionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * General structure for calculating
	 * @param obt This is the root element which contain information over all referenced values
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(EObject obt) {
		
		//Initialize need variables and get list of referenced elements and modeled InstancePointers
		String refValue = "",refExpression ="";
		EList<ReferenceableElement> refObts = new BasicEList<ReferenceableElement>();
		EList<InstancePointer> instPointObts = new BasicEList<InstancePointer>();
		
		if(obt instanceof SingleReferenceAttributeValueConstraint){
			refObts = ((SingleReferenceAttributeValueConstraint) obt).getConstraintReferenceValue();
			instPointObts = ((SingleReferenceAttributeValueConstraint) obt).getConstraintReferenceValueAdditionalSpecification();
			refExpression = ((SingleReferenceAttributeValueConstraint) obt).getExpression();
		} else if (obt instanceof RangeBound){
			refObts = ((RangeBound) obt).getBoundReferenceValue();
			instPointObts = ((RangeBound) obt).getBoundReferenceValueAdditionalSpecification();
			refExpression = ((RangeBound) obt).getExpression();
		} else {
			// more types could be supported in the future
			consoleStream.println("AttributeValueConstraint type " + obt.getClass().getName() + " is not yet supported!");
			return null;
		}
		
		//Now we are start to calculate (in a certain way)
		
		//First, one referenced value shall be used
		if(refObts.size()==1 &&  (refExpression.isEmpty() || refExpression == "")){
			
			ReferenceableElement refEle = refObts.get(0);
			if(refEle instanceof FixedValue){
				refValue = globalValuesAsString.get(((FixedValue) refEle).getName());
			} else if(refEle instanceof GlobalAttribute){
				refValue = globalValuesAsString.get(((GlobalAttribute) refEle).getName());
			} else if(refEle instanceof SourceSectionAttribute){//FIXME check me!!
				try{
					SourceSectionAttribute refEleSSA = (SourceSectionAttribute) refEle;
					EObject correspondObjectClass = this.instancePointerHandler.getPointedInstanceByMatchedSectionRepo(instPointObts.get(0), refEleSSA);
					// convert Attribute value to String
					refValue = refEleSSA.getAttribute().getEType().getEPackage().getEFactoryInstance()
							.convertToString(refEleSSA.getAttribute().getEAttributeType(), correspondObjectClass.eGet((EStructuralFeature) refObts.get(0)));
				} catch (final Exception e) {
					consoleStream.println("Message:\n The reference value represented by an SourceSectionAttribute can be either not calculated because of a missing"
							+ "InstancePointer or either the SourceSectionAttribute never matched at this moment");
					refValue="";
				}
			} else {
				// If we are here, some mistake is happened
				// more types could be supported in the future
				consoleStream.println("ReferenceableElement type " + refEle.getClass().getName() + " is not yet supported!");
				refValue = "";
			}		
		} 
		
		// If first step fails (String of refValue is empty), so secondly we try to interpret the expression
		if(refValue == "" || refValue == null){
			if(obt instanceof SingleReferenceAttributeValueConstraint){
				refValue = calculateReferenceValueWithExpression(refExpression, refObts, instPointObts);
			} else if (obt instanceof RangeBound){
				refValue = calculateReferenceValueWithExpression(refExpression, refObts, instPointObts);
			} else {
				// more types could be supported in the future
				consoleStream.println("Expression of " + obt.getClass().getName() + " cannot yet supported!");
			}
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
	 * @param instPointObts 
	 * @return The calculated attribute value or <em>null</em> if no value could be calculated.
	 */
	private String calculateReferenceValueWithExpression(String expression, EList<ReferenceableElement> refObts, EList<InstancePointer> instPointObts) {
		
		String expResult = "";
		Map<String,Double> vars = this.globalValuesAsDouble;
		
		if(refObts.size()!=instPointObts.size()){
			consoleStream.println("Note: Calculating reference value based on an expression but note:"
					+ "number of Elements not equal to number of InstancePointers");
		}
		// Get Attributes and their values and put them into 'vars' List
		for(int i = 0;  i < refObts.size(); i++){
			EObject refEle = refObts.get(i);
			if(!(refEle instanceof SourceSectionAttribute)){
				// FixedValue or GlobalAttribute already exists in the List
				break;
			}
			InstancePointer instPt = instPointObts.get(i);
			SourceSectionAttribute refEleSSA = (SourceSectionAttribute) refEle;
			EObject correspondObjectClass = this.instancePointerHandler.getPointedInstanceByMatchedSectionRepo(instPt, refEleSSA);
			if(correspondObjectClass !=null){
				// convert Attribute value to String
				String refValue = refEleSSA.getAttribute().getEType().getEPackage().getEFactoryInstance()
						.convertToString(refEleSSA.getAttribute().getEAttributeType(), correspondObjectClass.eGet((EStructuralFeature) refEle));
				vars.put(refEleSSA.getName(), Double.valueOf(refValue));
			} else{
				consoleStream.println("Message:\n Could not find the reference value for SourceSectionAttribute" + refEleSSA + "and InstancePointer" + instPt);
			}
		}
		
		// make calculation
		try{
			ExpressionCalculator expCalc = new ExpressionCalculator();
			expResult = expCalc.calculateExpression(expression, vars);
		} catch (final Exception e) {
			consoleStream.println("Message:\n A reference value couldn't be be calculated. Expression:" + expression + "because of" + e.getMessage());
			return expression;		
		}
		
		
		
		return expResult;
	}
}
