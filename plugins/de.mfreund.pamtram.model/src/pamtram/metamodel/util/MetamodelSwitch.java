/**
 */
package pamtram.metamodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import pamtram.NamedElement;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueSpecification;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.VirtualAttribute;

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
 * @see pamtram.metamodel.MetamodelPackage
 * @generated
 */
public class MetamodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = MetamodelPackage.eINSTANCE;
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
			case MetamodelPackage.META_MODEL_ELEMENT: {
				MetaModelElement metaModelElement = (MetaModelElement)theEObject;
				T result = caseMetaModelElement(metaModelElement);
				if (result == null) result = caseNamedElement(metaModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CLASS: {
				pamtram.metamodel.Class class_ = (pamtram.metamodel.Class)theEObject;
				T result = caseClass(class_);
				if (result == null) result = caseMetaModelElement(class_);
				if (result == null) result = caseNamedElement(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.REFERENCE: {
				Reference reference = (Reference)theEObject;
				T result = caseReference(reference);
				if (result == null) result = caseMetaModelElement(reference);
				if (result == null) result = caseNamedElement(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CONTAINMENT_REFERENCE: {
				ContainmentReference containmentReference = (ContainmentReference)theEObject;
				T result = caseContainmentReference(containmentReference);
				if (result == null) result = caseReference(containmentReference);
				if (result == null) result = caseMetaModelElement(containmentReference);
				if (result == null) result = caseNamedElement(containmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE: {
				NonContainmentReference nonContainmentReference = (NonContainmentReference)theEObject;
				T result = caseNonContainmentReference(nonContainmentReference);
				if (result == null) result = caseReference(nonContainmentReference);
				if (result == null) result = caseMetaModelElement(nonContainmentReference);
				if (result == null) result = caseNamedElement(nonContainmentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseMetaModelElement(attribute);
				if (result == null) result = caseNamedElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ACTUAL_ATTRIBUTE: {
				ActualAttribute actualAttribute = (ActualAttribute)theEObject;
				T result = caseActualAttribute(actualAttribute);
				if (result == null) result = caseAttribute(actualAttribute);
				if (result == null) result = caseMetaModelElement(actualAttribute);
				if (result == null) result = caseNamedElement(actualAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.VIRTUAL_ATTRIBUTE: {
				VirtualAttribute virtualAttribute = (VirtualAttribute)theEObject;
				T result = caseVirtualAttribute(virtualAttribute);
				if (result == null) result = caseAttribute(virtualAttribute);
				if (result == null) result = caseMetaModelElement(virtualAttribute);
				if (result == null) result = caseNamedElement(virtualAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE_VALUE_SPECIFICATION: {
				AttributeValueSpecification attributeValueSpecification = (AttributeValueSpecification)theEObject;
				T result = caseAttributeValueSpecification(attributeValueSpecification);
				if (result == null) result = caseNamedElement(attributeValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.EQUALITY_MATCHER: {
				EqualityMatcher equalityMatcher = (EqualityMatcher)theEObject;
				T result = caseEqualityMatcher(equalityMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(equalityMatcher);
				if (result == null) result = caseAttributeValueConstraint(equalityMatcher);
				if (result == null) result = caseAttributeValueSpecification(equalityMatcher);
				if (result == null) result = caseNamedElement(equalityMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ATTRIBUTE_VALUE_CONSTRAINT: {
				AttributeValueConstraint attributeValueConstraint = (AttributeValueConstraint)theEObject;
				T result = caseAttributeValueConstraint(attributeValueConstraint);
				if (result == null) result = caseAttributeValueSpecification(attributeValueConstraint);
				if (result == null) result = caseNamedElement(attributeValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SUBSTRING_MATCHER: {
				SubstringMatcher substringMatcher = (SubstringMatcher)theEObject;
				T result = caseSubstringMatcher(substringMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(substringMatcher);
				if (result == null) result = caseAttributeValueConstraint(substringMatcher);
				if (result == null) result = caseAttributeValueSpecification(substringMatcher);
				if (result == null) result = caseNamedElement(substringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.BEGINNING_MATCHER: {
				BeginningMatcher beginningMatcher = (BeginningMatcher)theEObject;
				T result = caseBeginningMatcher(beginningMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(beginningMatcher);
				if (result == null) result = caseAttributeValueConstraint(beginningMatcher);
				if (result == null) result = caseAttributeValueSpecification(beginningMatcher);
				if (result == null) result = caseNamedElement(beginningMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ENDING_MATCHER: {
				EndingMatcher endingMatcher = (EndingMatcher)theEObject;
				T result = caseEndingMatcher(endingMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(endingMatcher);
				if (result == null) result = caseAttributeValueConstraint(endingMatcher);
				if (result == null) result = caseAttributeValueSpecification(endingMatcher);
				if (result == null) result = caseNamedElement(endingMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.REG_EX_MATCHER: {
				RegExMatcher regExMatcher = (RegExMatcher)theEObject;
				T result = caseRegExMatcher(regExMatcher);
				if (result == null) result = caseAttributeValueConstraint(regExMatcher);
				if (result == null) result = caseAttributeValueSpecification(regExMatcher);
				if (result == null) result = caseNamedElement(regExMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CASE_SENSITIVE_CONSTRAINT: {
				CaseSensitiveConstraint caseSensitiveConstraint = (CaseSensitiveConstraint)theEObject;
				T result = caseCaseSensitiveConstraint(caseSensitiveConstraint);
				if (result == null) result = caseAttributeValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseAttributeValueSpecification(caseSensitiveConstraint);
				if (result == null) result = caseNamedElement(caseSensitiveConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaModelElement(MetaModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(pamtram.metamodel.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReference(Reference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainmentReference(ContainmentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Containment Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Containment Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonContainmentReference(NonContainmentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actual Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actual Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActualAttribute(ActualAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Virtual Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Virtual Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVirtualAttribute(VirtualAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueSpecification(AttributeValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualityMatcher(EqualityMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueConstraint(AttributeValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substring Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substring Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstringMatcher(SubstringMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Beginning Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Beginning Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeginningMatcher(BeginningMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ending Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ending Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndingMatcher(EndingMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reg Ex Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reg Ex Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegExMatcher(RegExMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Sensitive Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Sensitive Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseSensitiveConstraint(CaseSensitiveConstraint object) {
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

} //MetamodelSwitch
