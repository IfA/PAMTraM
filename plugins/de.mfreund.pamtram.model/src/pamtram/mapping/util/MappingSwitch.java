/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pamtram.NamedElement;

import pamtram.mapping.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated
 */
public class MappingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MappingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSwitch() {
		if (modelPackage == null) {
			modelPackage = MappingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MappingPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseMappingType(mapping);
				if (result == null) result = caseNamedElement(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_TYPE: {
				MappingType mappingType = (MappingType)theEObject;
				T result = caseMappingType(mappingType);
				if (result == null) result = caseNamedElement(mappingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT: {
				MappingHint mappingHint = (MappingHint)theEObject;
				T result = caseMappingHint(mappingHint);
				if (result == null) result = caseNamedElement(mappingHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING: {
				AttributeMapping attributeMapping = (AttributeMapping)theEObject;
				T result = caseAttributeMapping(attributeMapping);
				if (result == null) result = caseMappingHint(attributeMapping);
				if (result == null) result = caseNamedElement(attributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CARDINALITY_MAPPING: {
				CardinalityMapping cardinalityMapping = (CardinalityMapping)theEObject;
				T result = caseCardinalityMapping(cardinalityMapping);
				if (result == null) result = caseMappingHint(cardinalityMapping);
				if (result == null) result = caseNamedElement(cardinalityMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_INSTANCE_SELECTOR: {
				MappingInstanceSelector mappingInstanceSelector = (MappingInstanceSelector)theEObject;
				T result = caseMappingInstanceSelector(mappingInstanceSelector);
				if (result == null) result = caseMappingHint(mappingInstanceSelector);
				if (result == null) result = caseNamedElement(mappingInstanceSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MATCHER: {
				Matcher matcher = (Matcher)theEObject;
				T result = caseMatcher(matcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MATCHER: {
				AttributeMatcher attributeMatcher = (AttributeMatcher)theEObject;
				T result = caseAttributeMatcher(attributeMatcher);
				if (result == null) result = caseMatcher(attributeMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CLASS_MATCHER: {
				ClassMatcher classMatcher = (ClassMatcher)theEObject;
				T result = caseClassMatcher(classMatcher);
				if (result == null) result = caseMatcher(classMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_VALUE_MODIFIER: {
				AttributeValueModifier attributeValueModifier = (AttributeValueModifier)theEObject;
				T result = caseAttributeValueModifier(attributeValueModifier);
				if (result == null) result = caseNamedElement(attributeValueModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.SUBSTRING_REPLACER: {
				SubstringReplacer substringReplacer = (SubstringReplacer)theEObject;
				T result = caseSubstringReplacer(substringReplacer);
				if (result == null) result = caseAttributeValueModifier(substringReplacer);
				if (result == null) result = caseNamedElement(substringReplacer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.STRING_APPENDER: {
				StringAppender stringAppender = (StringAppender)theEObject;
				T result = caseStringAppender(stringAppender);
				if (result == null) result = caseAttributeValueModifier(stringAppender);
				if (result == null) result = caseNamedElement(stringAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.UNIQUE_NUMBER_APPENDER: {
				UniqueNumberAppender uniqueNumberAppender = (UniqueNumberAppender)theEObject;
				T result = caseUniqueNumberAppender(uniqueNumberAppender);
				if (result == null) result = caseAttributeValueModifier(uniqueNumberAppender);
				if (result == null) result = caseNamedElement(uniqueNumberAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.STRING_PREPENDER: {
				StringPrepender stringPrepender = (StringPrepender)theEObject;
				T result = caseStringPrepender(stringPrepender);
				if (result == null) result = caseAttributeValueModifier(stringPrepender);
				if (result == null) result = caseNamedElement(stringPrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_VALUE_MODIFIER_SET: {
				AttributeValueModifierSet attributeValueModifierSet = (AttributeValueModifierSet)theEObject;
				T result = caseAttributeValueModifierSet(attributeValueModifierSet);
				if (result == null) result = caseNamedElement(attributeValueModifierSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_GROUP: {
				MappingHintGroup mappingHintGroup = (MappingHintGroup)theEObject;
				T result = caseMappingHintGroup(mappingHintGroup);
				if (result == null) result = caseNamedElement(mappingHintGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODEL_CONNECTION_HINT: {
				ModelConnectionHint modelConnectionHint = (ModelConnectionHint)theEObject;
				T result = caseModelConnectionHint(modelConnectionHint);
				if (result == null) result = caseNamedElement(modelConnectionHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CONNECTION_HINT_TARGET_ATTRIBUTE: {
				ConnectionHintTargetAttribute connectionHintTargetAttribute = (ConnectionHintTargetAttribute)theEObject;
				T result = caseConnectionHintTargetAttribute(connectionHintTargetAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.SIMPLE_ATTRIBUTE_MAPPING: {
				SimpleAttributeMapping simpleAttributeMapping = (SimpleAttributeMapping)theEObject;
				T result = caseSimpleAttributeMapping(simpleAttributeMapping);
				if (result == null) result = caseAttributeMapping(simpleAttributeMapping);
				if (result == null) result = caseAttributeMappingSourceElementType(simpleAttributeMapping);
				if (result == null) result = caseMappingHint(simpleAttributeMapping);
				if (result == null) result = caseNamedElement(simpleAttributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING: {
				ComplexAttributeMapping complexAttributeMapping = (ComplexAttributeMapping)theEObject;
				T result = caseComplexAttributeMapping(complexAttributeMapping);
				if (result == null) result = caseAttributeMapping(complexAttributeMapping);
				if (result == null) result = caseMappingHint(complexAttributeMapping);
				if (result == null) result = caseNamedElement(complexAttributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUE_MAPPING_SOURCE_ELEMENT: {
				ComplexAttribueMappingSourceElement complexAttribueMappingSourceElement = (ComplexAttribueMappingSourceElement)theEObject;
				T result = caseComplexAttribueMappingSourceElement(complexAttribueMappingSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementType(complexAttribueMappingSourceElement);
				if (result == null) result = caseNamedElement(complexAttribueMappingSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CALCULATOR_MAPPING: {
				CalculatorMapping calculatorMapping = (CalculatorMapping)theEObject;
				T result = caseCalculatorMapping(calculatorMapping);
				if (result == null) result = caseAttributeMapping(calculatorMapping);
				if (result == null) result = caseMappingHint(calculatorMapping);
				if (result == null) result = caseNamedElement(calculatorMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXPRESSION_VARIABLE: {
				ExpressionVariable expressionVariable = (ExpressionVariable)theEObject;
				T result = caseExpressionVariable(expressionVariable);
				if (result == null) result = caseAttributeMappingSourceElementType(expressionVariable);
				if (result == null) result = caseNamedElement(expressionVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE: {
				AttributeMappingSourceElementType attributeMappingSourceElementType = (AttributeMappingSourceElementType)theEObject;
				T result = caseAttributeMappingSourceElementType(attributeMappingSourceElementType);
				if (result == null) result = caseNamedElement(attributeMappingSourceElementType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER: {
				ComplexAttributeMatcher complexAttributeMatcher = (ComplexAttributeMatcher)theEObject;
				T result = caseComplexAttributeMatcher(complexAttributeMatcher);
				if (result == null) result = caseAttributeMatcher(complexAttributeMatcher);
				if (result == null) result = caseMatcher(complexAttributeMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.SIMPLE_ATTRIBUTE_MATCHER: {
				SimpleAttributeMatcher simpleAttributeMatcher = (SimpleAttributeMatcher)theEObject;
				T result = caseSimpleAttributeMatcher(simpleAttributeMatcher);
				if (result == null) result = caseAttributeMatcher(simpleAttributeMatcher);
				if (result == null) result = caseAttributeMappingSourceElementType(simpleAttributeMatcher);
				if (result == null) result = caseMatcher(simpleAttributeMatcher);
				if (result == null) result = caseNamedElement(simpleAttributeMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT: {
				ComplexAttributeMatcherSourceElement complexAttributeMatcherSourceElement = (ComplexAttributeMatcherSourceElement)theEObject;
				T result = caseComplexAttributeMatcherSourceElement(complexAttributeMatcherSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementType(complexAttributeMatcherSourceElement);
				if (result == null) result = caseNamedElement(complexAttributeMatcherSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingType(MappingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHint(MappingHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMapping(AttributeMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMapping(CardinalityMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingInstanceSelector(MappingInstanceSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatcher(Matcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMatcher(AttributeMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassMatcher(ClassMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueModifier(AttributeValueModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substring Replacer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substring Replacer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstringReplacer(SubstringReplacer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringAppender(StringAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Number Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Number Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniqueNumberAppender(UniqueNumberAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Prepender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringPrepender(StringPrepender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Modifier Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Modifier Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueModifierSet(AttributeValueModifierSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintGroup(MappingHintGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Connection Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Connection Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelConnectionHint(ModelConnectionHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection Hint Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection Hint Target Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectionHintTargetAttribute(ConnectionHintTargetAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Attribute Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleAttributeMapping(SimpleAttributeMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Attribute Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexAttributeMapping(ComplexAttributeMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Attribue Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Attribue Mapping Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexAttribueMappingSourceElement(ComplexAttribueMappingSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Calculator Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Calculator Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCalculatorMapping(CalculatorMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionVariable(ExpressionVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingSourceElementType(AttributeMappingSourceElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Attribute Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexAttributeMatcher(ComplexAttributeMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Attribute Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleAttributeMatcher(SimpleAttributeMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Attribute Matcher Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Attribute Matcher Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexAttributeMatcherSourceElement(ComplexAttributeMatcherSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MappingSwitch
