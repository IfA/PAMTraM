package de.mfreund.gentrans.transformation.calculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.NamedElement;
import pamtram.ReferenceableElement;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.RangeBound;
import de.mfreund.gentrans.transformation.condition.InstancePointerHandler;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;


/**
 * This class can be used to calculate values of {@link ReferenceableElement}s.
 * 
 * @author gkoltun
 */
public class ReferenceableValueCalculator {

	/**
	 * Registry for global values
	 */
	private final GlobalValueMap globalValues;
	
	/**
	 * Registry for global values that are doubles
	 */
	private final Map<NamedElement, Double> globalValuesAsDouble;
	
	/**
	 * The console stream to be used to print messages.
	 */
	private MessageConsoleStream consoleStream;

	/**
	 * It will be used for extract a more in detail specified Element which was more than one times matched
	 */
	private InstancePointerHandler instancePointerHandler;
	
	/**
	 * This creates an instance that can only handled {@link FixedValue FixedValues} but no referenced 
	 * {@link SourceSectionAttribute SourceSectionAttributes}.
	 * <p />
	 * This should be used during the 'matching' phase where these latter information are not yet present.
	 * 
	 * @param globalValues The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttribute}) 
	 * defined in the PAMTraM model.
	 * @param consoleStream
	 */
	public ReferenceableValueCalculator(GlobalValueMap globalValues, MessageConsoleStream consoleStream) {
		this(globalValues, null, consoleStream);
	}
	
	/**
	 * This creates an instance.
	 * 
	 * @param globalValues The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttribute}) 
	 * defined in the PAMTraM model.
	 * @param instancePointerHandler The {@link InstancePointerHandler} that is used to evaluate {@link InstancePointer InstancePointers}
	 * that have been modeled.
	 * @param consoleStream The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public ReferenceableValueCalculator(GlobalValueMap globalValues, InstancePointerHandler instancePointerHandler, 
			MessageConsoleStream consoleStream) {
		
		// store the message stream
		this.consoleStream = consoleStream;
		
		// store the 'InstancePointerHandler'
		this.instancePointerHandler = instancePointerHandler;
		
		// store the 'GlobalValues'
		this.globalValues = globalValues;
		
		/*
		 * only use global values that represent doubles
		 */
		this.globalValuesAsDouble = globalValues.getGlobalValuesAsDouble();
	}
	
	/**
	 * General structure for calculating a reference value (mostly for {@link AttributeValueConstraint}s).
	 * 
	 * @param rootObj This is the root element which contains all needed information (e.g. references) 
	 * (mostly an instance of {@link AttributeValueConstraint}-child)
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(EObject rootObj) {
		
		//Initialize needed variables and get list of referenced elements and modeled InstancePointers
		String refValue; 
		String refExpression;
		EList<ReferenceableElement> refElementsAsList;
		EList<InstancePointer> instPointersAsList;
		
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
		if(refElementsAsList.size()==1 && (refExpression.isEmpty() || refExpression == "")){
			
			ReferenceableElement refElement = refElementsAsList.get(0);
			
			if(refElement instanceof FixedValue){
				refValue = globalValues.get((FixedValue) refElement);
			} else if(refElement instanceof GlobalAttribute){
				refValue = globalValues.get((GlobalAttribute) refElement);
			} else if(refElement instanceof SourceSectionAttribute){
				
				SourceSectionAttribute refElementAsSSA = (SourceSectionAttribute) refElement;
				List<EObject> correspondEClassInstances = new BasicEList<>();
				
				InstancePointer instPt = null;
				if(!instPointersAsList.isEmpty()){
					instPt = instPointersAsList.get(0); //actual we handle only one InstancePointer, so model a clear one!
				}
				
				if(instPt != null){
					//FIXME We need the corresponding MatchedSectionDescriptor here!
					correspondEClassInstances = this.instancePointerHandler.getPointedInstanceBySourceSectionClass(instPt, (SourceSectionClass) refElementAsSSA.eContainer(), null);
				}
				
				if(correspondEClassInstances.size()==1){
					Object refValueAttr = correspondEClassInstances.get(0).eGet(refElementAsSSA.getAttribute());
					
					// convert Attribute value to String
					refValue = refElementAsSSA.getAttribute().getEType().getEPackage().getEFactoryInstance()
							.convertToString(refElementAsSSA.getAttribute().getEAttributeType(), refValueAttr);
				} else{
					refValue="";
					consoleStream.println(" Note: The cardinality of the SourceSectionAttribute, " + refElementAsSSA.getName() + ", is "
							+ correspondEClassInstances.size() +"! So it cannot be handled. Hint: Create or change the InstancePointer!");
				}
			} else {
				// If we are here, some mistake is happened
				consoleStream.println("ReferenceableElement type " + refElement.getClass().getName() + " is not yet supported!");
				return null; // "" keep running the application (in this case YOU may have to do some changes here?!)
			}
			
			if(!(refValue.isEmpty() || refValue == "" || refValue == null)){
				return refValue;
			}
		} 
		
		// If the first step fails (String of refValue is empty/null), so secondly we try to interpret the expression
		refValue = calculateReferenceValueWithExpression(refExpression, refElementsAsList, instPointersAsList);
			
		// Return the calculated value, also if it is null or empty
		return refValue;
	}

	/**
	 * This calculates an attribute value based on an expression.
	 * 
	 * @param expression An expression to be used to calculate the reference value
	 * @param refElementsAsList A list that contains all referenced {@link SourceSectionAttribute}s by the expression (Note: 'ReferenceableValueCalculator' 
	 * already knows {@link FixedVaue}s and {@link GlobalAttribute}s)
	 * @param instPointersAsList A list that according to refObts contains the corresponding {@link InstancePointer}s (Note: The order of both list will be considered)
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated or <em>null</em> if a logical mistake occurred
	 */
	private String calculateReferenceValueWithExpression(String expression, EList<ReferenceableElement> refElementsAsList, EList<InstancePointer> instPointersAsList) {
		
		String expressionResult;
		Map<String,Double> vars = new HashMap<>();
		vars.putAll(this.globalValuesAsDouble.entrySet().parallelStream().collect(
				Collectors.toMap(e -> e.getKey().getName(), Entry::getValue)));
		
		// Get SourcSectionAttributes and their values and put them into 'vars' List
		int temp = 0; // Is needed for getting the correspond InstancePointer
		for(int i = 0;  i < refElementsAsList.size(); i++){
			
			EObject refElement = refElementsAsList.get(i);
			
			if(refElement instanceof SourceSectionAttribute){
					SourceSectionAttribute refElementAsSSA = (SourceSectionAttribute) refElement;
					List<EObject> correspondEClassInstances = new BasicEList<>();
					
					InstancePointer instPt = null;					
					if(!instPointersAsList.isEmpty()){
						instPt = instPointersAsList.get(i-temp);
					}
					
					if(instPt!=null){
						//FIXME We need the corresponding MatchedSectionDescriptor here!
						correspondEClassInstances = this.instancePointerHandler.getPointedInstanceBySourceSectionClass(instPt, (SourceSectionClass) refElementAsSSA.eContainer(), null);
					}
					
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
						consoleStream.println(" Note: The cardinality of the SourceSectionAttribute, " + refElementAsSSA.getName() + ", is "
								+ correspondEClassInstances.size() +"! So it cannot be handled. Hint: Create or change the InstancePointer!"
										+ "\n But we're continue while we still try calculate by 'ExpressionCalculator'!");
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
			/*consoleStream.println("Message:\n A reference value couldn't be be calculated by the 'ExpressionCalculator'. Expression, " + expression + ", because of " + e.getMessage()
			+ ".\n Original expression will be returned!");
			// If it fails, so return the original expression back (maybe it's a simple string, e.g. "Hello World!")*/
			return expression;
		}
		return expressionResult;
	}
}
