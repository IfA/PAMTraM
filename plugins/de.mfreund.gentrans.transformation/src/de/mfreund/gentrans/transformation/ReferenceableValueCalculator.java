package de.mfreund.gentrans.transformation;

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
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.InstancePointer;
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
	private MessageConsoleStream consoleStream;

	 /**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	@SuppressWarnings("unused")
	private LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections;
	
	/**
	* Registry for <em>source model objects</em> that have TEMPORARILY been matched. The matched objects are stored in a map
	* where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	*/
	private LinkedHashMap<SourceSectionClass, Set<EObject>> tempMatchedSections;
	
	/**
	 * It will be used for extract a more in detail specified Element which was more than one times matched
	 */
	private InstancePointerHandler instancePointerHandler;
	
	public ReferenceableValueCalculator(List<FixedValue> fixedVals, Map<GlobalAttribute, String> globalAttrVals, InstancePointerHandler instancePointerHandler, LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections, MessageConsoleStream consoleStream) {
				
		// store the message stream
		this.consoleStream = consoleStream;
		
		// store the 'InstancePointerHandler'
		this.instancePointerHandler = instancePointerHandler;
		
		// store the 'matchedSections' reference (Note: 'tempMatchedSections' contains matched Sections corresponding to the investigated Mapping
		// (and also SourceSection) while the 'ReferenceableValueCalculator' can be called
		this.matchedSections = matchedSections;
		this.tempMatchedSections = new LinkedHashMap<>();
		
		// find GlobalAttrs that can be mapped to double
		this.globalValuesAsString = new HashMap<>();
		for (final GlobalAttribute g : globalAttrVals.keySet()) {
			globalValuesAsString.put(g.getName(), globalAttrVals.get(g));
		}

		/*
		 * add global values (named as 'FixedValue' in the metamodel)
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
	 * General structure for calculating a reference value (mostly for {@link AttributeValueConstraint}s)
	 * @param rootObj This is the root element which contains all needed information (e.g. references) (mostly an instance of {@link AttributeValueConstraint}-child)
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(EObject rootObj) {
		
		//Initialize needed variables and get list of referenced elements and modeled InstancePointers
		String refValue = "", refExpression ="";
		EList<ReferenceableElement> refElementsAsList = new BasicEList<ReferenceableElement>();
		EList<InstancePointer> instPointersAsList = new BasicEList<InstancePointer>();
		
		// Fill variables and lists
		if(rootObj instanceof SingleReferenceAttributeValueConstraint){
			refElementsAsList = ((SingleReferenceAttributeValueConstraint) rootObj).getConstraintReferenceValue();
			instPointersAsList = ((SingleReferenceAttributeValueConstraint) rootObj).getConstraintReferenceValueAdditionalSpecification();
			refExpression = ((SingleReferenceAttributeValueConstraint) rootObj).getExpression();
		} else if (rootObj instanceof RangeBound){
			refElementsAsList = ((RangeBound) rootObj).getBoundReferenceValue();
			instPointersAsList = ((RangeBound) rootObj).getBoundReferenceValueAdditionalSpecification();
			refExpression = ((RangeBound) rootObj).getExpression();
		} else {
			// more types could be supported in the future
			consoleStream.println("AttributeValueConstraint type " + rootObj.getClass().getName() + " is not yet supported!");
			return null; // "" keep running the application (in this case YOU may have to do some changes here?!)
		}
		
		//Now we' re start 'calculating'
		
		//Firstly, if there is only one reference and the expression empty, than we are just return the referred value
		if(refElementsAsList.size()==1 &&  (refExpression.isEmpty() || refExpression == "")){
			
			ReferenceableElement refElement = refElementsAsList.get(0);
			
			if(refElement instanceof FixedValue){
				refValue = globalValuesAsString.get(((FixedValue) refElement).getName());
			} else if(refElement instanceof GlobalAttribute){
				refValue = globalValuesAsString.get(((GlobalAttribute) refElement).getName());
			} else if(refElement instanceof SourceSectionAttribute){ //SSA = SourceSectionAttribute
				try{
					SourceSectionAttribute refElementAsSSA = (SourceSectionAttribute) refElement;
					EList<EObject> correspondEObjectClasses = this.instancePointerHandler.getPointedInstanceByMatchedSectionRepo(instPointersAsList.get(0), (SourceSectionClass) refElementAsSSA.eContainer());
					if(correspondEObjectClasses.size() == 1){
						// convert Attribute value to String
						refValue = refElementAsSSA.getAttribute().getEType().getEPackage().getEFactoryInstance()
								.convertToString(refElementAsSSA.getAttribute().getEAttributeType(), refElementAsSSA);
					} else{
						refValue="";
						consoleStream.println("'correspondEObjectClasses' in 'ReferenceableValueCalculator' contains more than one object!");
					}
				} catch (final Exception e) {
					consoleStream.println("Message:\n The reference value represented by an SourceSectionAttribute can be either not calculated because of a missing"
							+ "InstancePointer or either the SourceSectionAttribute never matched at this moment");
					refValue="";
				}
			} else {
				// If we are here, some mistake is happened
				consoleStream.println("ReferenceableElement type " + refElement.getClass().getName() + " is not yet supported!");
				return null; // "" keep running the application (in this case YOU may have to do some changes here?!)
			}		
		} 
		
		// If the first step fails (String of refValue is empty/null), so secondly we try to interpret the expression
		refValue = calculateReferenceValueWithExpression(refExpression, refElementsAsList, instPointersAsList);
			
		// Return the calculated value, also if it is null or empty
		return refValue;
	}

	/**
	 * This calculates an attribute value based on an expression.
	 * @param expression An expression to be used to calculate the reference value
	 * @param refElementsAsList A list that contains all referenced {@link SourceSectionAttribute}s by the expression (Note: 'ReferenceableValueCalculator' 
	 * already knows {@link FixedVaue}s and {@link GlobalAttribute}s)
	 * @param instPointersAsList A list that according to refObts contains the corresponding {@link InstancePointer}s (Note: The order of both list will be considered)
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated or <em>null</em> if a logical mistake occurred
	 */
	private String calculateReferenceValueWithExpression(String expression, EList<ReferenceableElement> refElementsAsList, EList<InstancePointer> instPointersAsList) {
		
		String expressionResult = "";
		Map<String,Double> vars = this.globalValuesAsDouble;
		
		// Get SourcSectionAttributes and their values and put them into 'vars' List
		int temp = 0;
		for(int i = 0;  i < refElementsAsList.size(); i++){
			
			EObject refElement = refElementsAsList.get(i);
			
			if(refElement instanceof SourceSectionAttribute){
				
				if(instPointersAsList.size() != 0){
					
					InstancePointer instPt = instPointersAsList.get(i-temp);
					SourceSectionAttribute refElementAsSSA = (SourceSectionAttribute) refElement;
					
					if(instPt!=null){
						
						EList<EObject> correspondEClassInstances = this.instancePointerHandler.getPointedInstanceByMatchedSectionRepo(instPt, (SourceSectionClass) refElementAsSSA.eContainer());
						
						if(correspondEClassInstances.size()==1){
							
							Object refValueAttr = correspondEClassInstances.get(0).eGet(refElementAsSSA.getAttribute());
							
							// convert Attribute value to String
							String refValue = refElementAsSSA.getAttribute().getEType().getEPackage().getEFactoryInstance()
									.convertToString(refElementAsSSA.getAttribute().getEAttributeType(), refValueAttr);
							// convert to Double when possible
							try{
								vars.put(refElementAsSSA.getName(), Double.valueOf(refValue));
							} catch(final Exception e){
								consoleStream.println("Cannot" + refValue + "match to Double. Message:" + e.getMessage());
							}
						} else {
							consoleStream.println("InstancePointerHandler return more than one object!");
						}
					}
				}
			} else{//FixedValue or GlobalAttribute, so we need not to handle it
				++temp;
			}
		}
		
		// make calculation
		try{
			ExpressionCalculator expCalc = new ExpressionCalculator();
			expressionResult = expCalc.calculateExpression(expression, vars);
		} catch (final Exception e) {
			consoleStream.println("Message:\n A reference value couldn't be be calculated by the 'ExpressionCalculator'. Expression:" + expression + "because of" + e.getMessage()
			+ "\n. Original expression will be returned!");
			return expression;
		}
		return expressionResult;
	}

	public void addTempSectionMap(LinkedHashMap<SourceSectionClass, Set<EObject>> tempMatchedSections) {
		this.tempMatchedSections = tempMatchedSections;
	}

	public void clearTempSectionMap() {
		this.tempMatchedSections.clear();
	}
}
