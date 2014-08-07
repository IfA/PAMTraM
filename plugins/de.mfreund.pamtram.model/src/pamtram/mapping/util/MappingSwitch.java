/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import pamtram.NamedElement;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.AttributeMappingSourceElementWithModifiers;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.CalculatorMapping;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingSourceElement;
import pamtram.mapping.ComplexAttributeMappingSourceInterface;
import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintSourceElement;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExpressionVariable;
import pamtram.mapping.GlobalVariabeImporter;
import pamtram.mapping.GlobalVariable;
import pamtram.mapping.HintImporterMappingHint;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappedAttributeValueAppender;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;
import pamtram.mapping.Matcher;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.SimpleAttributeMatcher;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.mapping.StringAppender;
import pamtram.mapping.StringPrepender;
import pamtram.mapping.SubstringReplacer;
import pamtram.mapping.UniqueNumberAppender;

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
				if (result == null) result = caseMappingHintType(mappingHint);
				if (result == null) result = caseNamedElement(mappingHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING: {
				AttributeMapping attributeMapping = (AttributeMapping)theEObject;
				T result = caseAttributeMapping(attributeMapping);
				if (result == null) result = caseMappingHint(attributeMapping);
				if (result == null) result = caseMappingHintType(attributeMapping);
				if (result == null) result = caseNamedElement(attributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CARDINALITY_MAPPING: {
				CardinalityMapping cardinalityMapping = (CardinalityMapping)theEObject;
				T result = caseCardinalityMapping(cardinalityMapping);
				if (result == null) result = caseMappingHint(cardinalityMapping);
				if (result == null) result = caseMappingHintType(cardinalityMapping);
				if (result == null) result = caseNamedElement(cardinalityMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_INSTANCE_SELECTOR: {
				MappingInstanceSelector mappingInstanceSelector = (MappingInstanceSelector)theEObject;
				T result = caseMappingInstanceSelector(mappingInstanceSelector);
				if (result == null) result = caseMappingHint(mappingInstanceSelector);
				if (result == null) result = caseMappingHintType(mappingInstanceSelector);
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
				if (result == null) result = caseMappingHintGroupType(mappingHintGroup);
				if (result == null) result = caseInstantiableMappingHintGroup(mappingHintGroup);
				if (result == null) result = caseNamedElement(mappingHintGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_GROUP_TYPE: {
				MappingHintGroupType mappingHintGroupType = (MappingHintGroupType)theEObject;
				T result = caseMappingHintGroupType(mappingHintGroupType);
				if (result == null) result = caseNamedElement(mappingHintGroupType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.INSTANTIABLE_MAPPING_HINT_GROUP: {
				InstantiableMappingHintGroup instantiableMappingHintGroup = (InstantiableMappingHintGroup)theEObject;
				T result = caseInstantiableMappingHintGroup(instantiableMappingHintGroup);
				if (result == null) result = caseNamedElement(instantiableMappingHintGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER: {
				MappingHintGroupImporter mappingHintGroupImporter = (MappingHintGroupImporter)theEObject;
				T result = caseMappingHintGroupImporter(mappingHintGroupImporter);
				if (result == null) result = caseInstantiableMappingHintGroup(mappingHintGroupImporter);
				if (result == null) result = caseNamedElement(mappingHintGroupImporter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXPORTED_MAPPING_HINT_GROUP: {
				ExportedMappingHintGroup exportedMappingHintGroup = (ExportedMappingHintGroup)theEObject;
				T result = caseExportedMappingHintGroup(exportedMappingHintGroup);
				if (result == null) result = caseMappingHintGroupType(exportedMappingHintGroup);
				if (result == null) result = caseNamedElement(exportedMappingHintGroup);
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
				if (result == null) result = caseAttributeMappingSourceElementWithModifiers(simpleAttributeMapping);
				if (result == null) result = caseMappingHint(simpleAttributeMapping);
				if (result == null) result = caseAttributeMappingSourceElementType(simpleAttributeMapping);
				if (result == null) result = caseMappingHintType(simpleAttributeMapping);
				if (result == null) result = caseNamedElement(simpleAttributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING: {
				ComplexAttributeMapping complexAttributeMapping = (ComplexAttributeMapping)theEObject;
				T result = caseComplexAttributeMapping(complexAttributeMapping);
				if (result == null) result = caseAttributeMapping(complexAttributeMapping);
				if (result == null) result = caseMappingHint(complexAttributeMapping);
				if (result == null) result = caseMappingHintType(complexAttributeMapping);
				if (result == null) result = caseNamedElement(complexAttributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_ELEMENT: {
				ComplexAttributeMappingSourceElement complexAttributeMappingSourceElement = (ComplexAttributeMappingSourceElement)theEObject;
				T result = caseComplexAttributeMappingSourceElement(complexAttributeMappingSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementWithModifiers(complexAttributeMappingSourceElement);
				if (result == null) result = caseComplexAttributeMappingSourceInterface(complexAttributeMappingSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementType(complexAttributeMappingSourceElement);
				if (result == null) result = caseNamedElement(complexAttributeMappingSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CALCULATOR_MAPPING: {
				CalculatorMapping calculatorMapping = (CalculatorMapping)theEObject;
				T result = caseCalculatorMapping(calculatorMapping);
				if (result == null) result = caseAttributeMapping(calculatorMapping);
				if (result == null) result = caseMappingHint(calculatorMapping);
				if (result == null) result = caseMappingHintType(calculatorMapping);
				if (result == null) result = caseNamedElement(calculatorMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXPRESSION_VARIABLE: {
				ExpressionVariable expressionVariable = (ExpressionVariable)theEObject;
				T result = caseExpressionVariable(expressionVariable);
				if (result == null) result = caseAttributeMappingSourceElementWithModifiers(expressionVariable);
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
				if (result == null) result = caseAttributeMappingSourceElementWithModifiers(simpleAttributeMatcher);
				if (result == null) result = caseMatcher(simpleAttributeMatcher);
				if (result == null) result = caseAttributeMappingSourceElementType(simpleAttributeMatcher);
				if (result == null) result = caseNamedElement(simpleAttributeMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT: {
				ComplexAttributeMatcherSourceElement complexAttributeMatcherSourceElement = (ComplexAttributeMatcherSourceElement)theEObject;
				T result = caseComplexAttributeMatcherSourceElement(complexAttributeMatcherSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementWithModifiers(complexAttributeMatcherSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementType(complexAttributeMatcherSourceElement);
				if (result == null) result = caseNamedElement(complexAttributeMatcherSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.SIMPLE_MODEL_CONNECTION_HINT: {
				SimpleModelConnectionHint simpleModelConnectionHint = (SimpleModelConnectionHint)theEObject;
				T result = caseSimpleModelConnectionHint(simpleModelConnectionHint);
				if (result == null) result = caseModelConnectionHint(simpleModelConnectionHint);
				if (result == null) result = caseAttributeMappingSourceElementWithModifiers(simpleModelConnectionHint);
				if (result == null) result = caseAttributeMappingSourceElementType(simpleModelConnectionHint);
				if (result == null) result = caseNamedElement(simpleModelConnectionHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_MODEL_CONNECTION_HINT: {
				ComplexModelConnectionHint complexModelConnectionHint = (ComplexModelConnectionHint)theEObject;
				T result = caseComplexModelConnectionHint(complexModelConnectionHint);
				if (result == null) result = caseModelConnectionHint(complexModelConnectionHint);
				if (result == null) result = caseNamedElement(complexModelConnectionHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT: {
				ComplexModelConnectionHintSourceElement complexModelConnectionHintSourceElement = (ComplexModelConnectionHintSourceElement)theEObject;
				T result = caseComplexModelConnectionHintSourceElement(complexModelConnectionHintSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementWithModifiers(complexModelConnectionHintSourceElement);
				if (result == null) result = caseAttributeMappingSourceElementType(complexModelConnectionHintSourceElement);
				if (result == null) result = caseNamedElement(complexModelConnectionHintSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_WITH_MODIFIERS: {
				AttributeMappingSourceElementWithModifiers attributeMappingSourceElementWithModifiers = (AttributeMappingSourceElementWithModifiers)theEObject;
				T result = caseAttributeMappingSourceElementWithModifiers(attributeMappingSourceElementWithModifiers);
				if (result == null) result = caseAttributeMappingSourceElementType(attributeMappingSourceElementWithModifiers);
				if (result == null) result = caseNamedElement(attributeMappingSourceElementWithModifiers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_TYPE: {
				MappingHintType mappingHintType = (MappingHintType)theEObject;
				T result = caseMappingHintType(mappingHintType);
				if (result == null) result = caseNamedElement(mappingHintType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.HINT_IMPORTER_MAPPING_HINT: {
				HintImporterMappingHint hintImporterMappingHint = (HintImporterMappingHint)theEObject;
				T result = caseHintImporterMappingHint(hintImporterMappingHint);
				if (result == null) result = caseMappingHintType(hintImporterMappingHint);
				if (result == null) result = caseNamedElement(hintImporterMappingHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
				MappedAttributeValueExpander mappedAttributeValueExpander = (MappedAttributeValueExpander)theEObject;
				T result = caseMappedAttributeValueExpander(mappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValueExpander);
				if (result == null) result = caseMappingHintType(mappedAttributeValueExpander);
				if (result == null) result = caseNamedElement(mappedAttributeValueExpander);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER: {
				MappedAttributeValuePrepender mappedAttributeValuePrepender = (MappedAttributeValuePrepender)theEObject;
				T result = caseMappedAttributeValuePrepender(mappedAttributeValuePrepender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValuePrepender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintType(mappedAttributeValuePrepender);
				if (result == null) result = caseNamedElement(mappedAttributeValuePrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER: {
				MappedAttributeValueAppender mappedAttributeValueAppender = (MappedAttributeValueAppender)theEObject;
				T result = caseMappedAttributeValueAppender(mappedAttributeValueAppender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValueAppender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValueAppender);
				if (result == null) result = caseMappingHintType(mappedAttributeValueAppender);
				if (result == null) result = caseNamedElement(mappedAttributeValueAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.GLOBAL_VARIABLE: {
				GlobalVariable globalVariable = (GlobalVariable)theEObject;
				T result = caseGlobalVariable(globalVariable);
				if (result == null) result = caseNamedElement(globalVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.GLOBAL_VARIABE_IMPORTER: {
				GlobalVariabeImporter globalVariabeImporter = (GlobalVariabeImporter)theEObject;
				T result = caseGlobalVariabeImporter(globalVariabeImporter);
				if (result == null) result = caseNamedElement(globalVariabeImporter);
				if (result == null) result = caseComplexAttributeMappingSourceInterface(globalVariabeImporter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.COMPLEX_ATTRIBUTE_MAPPING_SOURCE_INTERFACE: {
				ComplexAttributeMappingSourceInterface complexAttributeMappingSourceInterface = (ComplexAttributeMappingSourceInterface)theEObject;
				T result = caseComplexAttributeMappingSourceInterface(complexAttributeMappingSourceInterface);
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
	 * Returns the result of interpreting the object as an instance of '<em>Hint Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Group Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintGroupType(MappingHintGroupType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiable Mapping Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiable Mapping Hint Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantiableMappingHintGroup(InstantiableMappingHintGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Group Importer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Group Importer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintGroupImporter(MappingHintGroupImporter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exported Mapping Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exported Mapping Hint Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExportedMappingHintGroup(ExportedMappingHintGroup object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Complex Attribute Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Attribute Mapping Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexAttributeMappingSourceElement(ComplexAttributeMappingSourceElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Simple Model Connection Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Model Connection Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleModelConnectionHint(SimpleModelConnectionHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Model Connection Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Model Connection Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexModelConnectionHint(ComplexModelConnectionHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Model Connection Hint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Model Connection Hint Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexModelConnectionHintSourceElement(ComplexModelConnectionHintSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element With Modifiers</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element With Modifiers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingSourceElementWithModifiers(AttributeMappingSourceElementWithModifiers object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintType(MappingHintType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Importer Mapping Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Importer Mapping Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHintImporterMappingHint(HintImporterMappingHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Attribute Value Expander</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Attribute Value Expander</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedAttributeValueExpander(MappedAttributeValueExpander object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Attribute Value Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Attribute Value Prepender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedAttributeValuePrepender(MappedAttributeValuePrepender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Attribute Value Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Attribute Value Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedAttributeValueAppender(MappedAttributeValueAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalVariable(GlobalVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Variabe Importer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Variabe Importer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalVariabeImporter(GlobalVariabeImporter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Attribute Mapping Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Attribute Mapping Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexAttributeMappingSourceInterface(ComplexAttributeMappingSourceInterface object) {
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
