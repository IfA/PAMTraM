/**
 */
package pamtram.mapping.extended.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pamtram.ConditionalElement;
import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.extended.*;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

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
 * @see pamtram.mapping.extended.ExtendedPackage
 * @generated
 */
public class ExtendedSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExtendedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedSwitch() {
		if (modelPackage == null) {
			modelPackage = ExtendedPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case ExtendedPackage.ATTRIBUTE_MAPPING: {
				AttributeMapping attributeMapping = (AttributeMapping)theEObject;
				T result = caseAttributeMapping(attributeMapping);
				if (result == null) result = caseMappingHint(attributeMapping);
				if (result == null) result = caseExpressionElement(attributeMapping);
				if (result == null) result = caseModifiableElement(attributeMapping);
				if (result == null) result = caseExpandableHint(attributeMapping);
				if (result == null) result = caseMappingHintType(attributeMapping);
				if (result == null) result = caseConditionalElement(attributeMapping);
				if (result == null) result = caseMappingHintBaseType(attributeMapping);
				if (result == null) result = caseNamedElement(attributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE: {
				AttributeMappingSourceInterface attributeMappingSourceInterface = (AttributeMappingSourceInterface)theEObject;
				T result = caseAttributeMappingSourceInterface(attributeMappingSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingSourceInterface);
				if (result == null) result = caseNamedElement(attributeMappingSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT: {
				AttributeMappingSourceElement attributeMappingSourceElement = (AttributeMappingSourceElement)theEObject;
				T result = caseAttributeMappingSourceElement(attributeMappingSourceElement);
				if (result == null) result = caseLocalDynamicSourceElement(attributeMappingSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingSourceElement);
				if (result == null) result = caseDynamicSourceElement(attributeMappingSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingSourceElement);
				if (result == null) result = caseModifiableElement(attributeMappingSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT: {
				AttributeMappingExternalSourceElement attributeMappingExternalSourceElement = (AttributeMappingExternalSourceElement)theEObject;
				T result = caseAttributeMappingExternalSourceElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseExternalDynamicSourceElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingExternalSourceElement);
				if (result == null) result = caseDynamicSourceElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingExternalSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseModifiableElement(attributeMappingExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT: {
				AttributeMappingGlobalSourceElement attributeMappingGlobalSourceElement = (AttributeMappingGlobalSourceElement)theEObject;
				T result = caseAttributeMappingGlobalSourceElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseGlobalDynamicSourceElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingGlobalSourceElement);
				if (result == null) result = caseDynamicSourceElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingGlobalSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseModifiableElement(attributeMappingGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING: {
				CardinalityMapping cardinalityMapping = (CardinalityMapping)theEObject;
				T result = caseCardinalityMapping(cardinalityMapping);
				if (result == null) result = caseMappingHint(cardinalityMapping);
				if (result == null) result = caseExpressionElement(cardinalityMapping);
				if (result == null) result = caseModifiableElement(cardinalityMapping);
				if (result == null) result = caseMappingHintType(cardinalityMapping);
				if (result == null) result = caseConditionalElement(cardinalityMapping);
				if (result == null) result = caseMappingHintBaseType(cardinalityMapping);
				if (result == null) result = caseNamedElement(cardinalityMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_INTERFACE: {
				CardinalityMappingSourceInterface cardinalityMappingSourceInterface = (CardinalityMappingSourceInterface)theEObject;
				T result = caseCardinalityMappingSourceInterface(cardinalityMappingSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingSourceInterface);
				if (result == null) result = caseNamedElement(cardinalityMappingSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_ELEMENT: {
				CardinalityMappingSourceElement cardinalityMappingSourceElement = (CardinalityMappingSourceElement)theEObject;
				T result = caseCardinalityMappingSourceElement(cardinalityMappingSourceElement);
				if (result == null) result = caseLocalDynamicSourceElement(cardinalityMappingSourceElement);
				if (result == null) result = caseCardinalityMappingSourceInterface(cardinalityMappingSourceElement);
				if (result == null) result = caseDynamicSourceElement(cardinalityMappingSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingSourceElement);
				if (result == null) result = caseNamedElement(cardinalityMappingSourceElement);
				if (result == null) result = caseModifiableElement(cardinalityMappingSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT: {
				CardinalityMappingExternalSourceElement cardinalityMappingExternalSourceElement = (CardinalityMappingExternalSourceElement)theEObject;
				T result = caseCardinalityMappingExternalSourceElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseExternalDynamicSourceElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseCardinalityMappingSourceInterface(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseDynamicSourceElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseNamedElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseModifiableElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT: {
				CardinalityMappingGlobalSourceElement cardinalityMappingGlobalSourceElement = (CardinalityMappingGlobalSourceElement)theEObject;
				T result = caseCardinalityMappingGlobalSourceElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseGlobalDynamicSourceElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseCardinalityMappingSourceInterface(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseDynamicSourceElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseNamedElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseModifiableElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR: {
				ReferenceTargetSelector referenceTargetSelector = (ReferenceTargetSelector)theEObject;
				T result = caseReferenceTargetSelector(referenceTargetSelector);
				if (result == null) result = caseMappingHint(referenceTargetSelector);
				if (result == null) result = caseMappingHintType(referenceTargetSelector);
				if (result == null) result = caseConditionalElement(referenceTargetSelector);
				if (result == null) result = caseMappingHintBaseType(referenceTargetSelector);
				if (result == null) result = caseNamedElement(referenceTargetSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.MATCHER: {
				Matcher matcher = (Matcher)theEObject;
				T result = caseMatcher(matcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CLASS_MATCHER: {
				ClassMatcher classMatcher = (ClassMatcher)theEObject;
				T result = caseClassMatcher(classMatcher);
				if (result == null) result = caseMatcher(classMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MATCHER: {
				AttributeMatcher attributeMatcher = (AttributeMatcher)theEObject;
				T result = caseAttributeMatcher(attributeMatcher);
				if (result == null) result = caseMatcher(attributeMatcher);
				if (result == null) result = caseExpandableHint(attributeMatcher);
				if (result == null) result = caseInstanceSelector(attributeMatcher);
				if (result == null) result = caseExpressionElement(attributeMatcher);
				if (result == null) result = caseModifiableElement(attributeMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CONTAINER_SELECTOR: {
				ContainerSelector containerSelector = (ContainerSelector)theEObject;
				T result = caseContainerSelector(containerSelector);
				if (result == null) result = caseMappingHint(containerSelector);
				if (result == null) result = caseInstanceSelector(containerSelector);
				if (result == null) result = caseMappingHintType(containerSelector);
				if (result == null) result = caseConditionalElement(containerSelector);
				if (result == null) result = caseExpressionElement(containerSelector);
				if (result == null) result = caseModifiableElement(containerSelector);
				if (result == null) result = caseMappingHintBaseType(containerSelector);
				if (result == null) result = caseNamedElement(containerSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE: {
				ContainerSelectorTargetAttribute containerSelectorTargetAttribute = (ContainerSelectorTargetAttribute)theEObject;
				T result = caseContainerSelectorTargetAttribute(containerSelectorTargetAttribute);
				if (result == null) result = caseDynamicSourceElement(containerSelectorTargetAttribute);
				if (result == null) result = caseNamedElement(containerSelectorTargetAttribute);
				if (result == null) result = caseModifiableElement(containerSelectorTargetAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingSourceInterface(AttributeMappingSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingSourceElement(AttributeMappingSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingExternalSourceElement(AttributeMappingExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingGlobalSourceElement(AttributeMappingGlobalSourceElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingSourceInterface(CardinalityMappingSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingSourceElement(CardinalityMappingSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingExternalSourceElement(CardinalityMappingExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingGlobalSourceElement(CardinalityMappingGlobalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Target Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceTargetSelector(ReferenceTargetSelector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelector(ContainerSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector Target Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelectorTargetAttribute(ContainerSelectorTargetAttribute object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Hint Base Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Base Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintBaseType(MappingHintBaseType object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalElement(ConditionalElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Expression Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionElement(ExpressionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiableElement(ModifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expandable Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expandable Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandableHint(ExpandableHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintSourceInterface(MappingHintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseDynamicSourceElement(DynamicSourceElement<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseLocalDynamicSourceElement(LocalDynamicSourceElement<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseExternalDynamicSourceElement(ExternalDynamicSourceElement<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>, InstanceSelectorType extends InstanceSelector> T caseGlobalDynamicSourceElement(GlobalDynamicSourceElement<S, C, R, A, InstanceSelectorType> object) {
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
	public T caseInstanceSelector(InstanceSelector object) {
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

} //ExtendedSwitch
