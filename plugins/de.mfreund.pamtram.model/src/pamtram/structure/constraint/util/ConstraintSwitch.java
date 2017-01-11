/**
 */
package pamtram.structure.constraint.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pamtram.NamedElement;

import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ModifiedAttributeElementType;

import pamtram.structure.constraint.*;

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
 * @see pamtram.structure.constraint.ConstraintPackage
 * @generated
 */
public class ConstraintSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConstraintPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintSwitch() {
		if (modelPackage == null) {
			modelPackage = ConstraintPackage.eINSTANCE;
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
			case ConstraintPackage.EQUALITY_MATCHER: {
				EqualityMatcher equalityMatcher = (EqualityMatcher)theEObject;
				T result = caseEqualityMatcher(equalityMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(equalityMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(equalityMatcher);
				if (result == null) result = caseValueConstraint(equalityMatcher);
				if (result == null) result = caseExpressionHint(equalityMatcher);
				if (result == null) result = caseModifiableHint(equalityMatcher);
				if (result == null) result = caseNamedElement(equalityMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT: {
				ValueConstraint valueConstraint = (ValueConstraint)theEObject;
				T result = caseValueConstraint(valueConstraint);
				if (result == null) result = caseNamedElement(valueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.SUBSTRING_MATCHER: {
				SubstringMatcher substringMatcher = (SubstringMatcher)theEObject;
				T result = caseSubstringMatcher(substringMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(substringMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(substringMatcher);
				if (result == null) result = caseValueConstraint(substringMatcher);
				if (result == null) result = caseExpressionHint(substringMatcher);
				if (result == null) result = caseModifiableHint(substringMatcher);
				if (result == null) result = caseNamedElement(substringMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.BEGINNING_MATCHER: {
				BeginningMatcher beginningMatcher = (BeginningMatcher)theEObject;
				T result = caseBeginningMatcher(beginningMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(beginningMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(beginningMatcher);
				if (result == null) result = caseValueConstraint(beginningMatcher);
				if (result == null) result = caseExpressionHint(beginningMatcher);
				if (result == null) result = caseModifiableHint(beginningMatcher);
				if (result == null) result = caseNamedElement(beginningMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.ENDING_MATCHER: {
				EndingMatcher endingMatcher = (EndingMatcher)theEObject;
				T result = caseEndingMatcher(endingMatcher);
				if (result == null) result = caseCaseSensitiveConstraint(endingMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(endingMatcher);
				if (result == null) result = caseValueConstraint(endingMatcher);
				if (result == null) result = caseExpressionHint(endingMatcher);
				if (result == null) result = caseModifiableHint(endingMatcher);
				if (result == null) result = caseNamedElement(endingMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.REG_EX_MATCHER: {
				RegExMatcher regExMatcher = (RegExMatcher)theEObject;
				T result = caseRegExMatcher(regExMatcher);
				if (result == null) result = caseSingleReferenceValueConstraint(regExMatcher);
				if (result == null) result = caseValueConstraint(regExMatcher);
				if (result == null) result = caseExpressionHint(regExMatcher);
				if (result == null) result = caseModifiableHint(regExMatcher);
				if (result == null) result = caseNamedElement(regExMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.CASE_SENSITIVE_CONSTRAINT: {
				CaseSensitiveConstraint caseSensitiveConstraint = (CaseSensitiveConstraint)theEObject;
				T result = caseCaseSensitiveConstraint(caseSensitiveConstraint);
				if (result == null) result = caseSingleReferenceValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseValueConstraint(caseSensitiveConstraint);
				if (result == null) result = caseExpressionHint(caseSensitiveConstraint);
				if (result == null) result = caseModifiableHint(caseSensitiveConstraint);
				if (result == null) result = caseNamedElement(caseSensitiveConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.RANGE_CONSTRAINT: {
				RangeConstraint rangeConstraint = (RangeConstraint)theEObject;
				T result = caseRangeConstraint(rangeConstraint);
				if (result == null) result = caseMultipleReferencesValueConstraint(rangeConstraint);
				if (result == null) result = caseValueConstraint(rangeConstraint);
				if (result == null) result = caseNamedElement(rangeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.MULTIPLE_REFERENCES_VALUE_CONSTRAINT: {
				MultipleReferencesValueConstraint multipleReferencesValueConstraint = (MultipleReferencesValueConstraint)theEObject;
				T result = caseMultipleReferencesValueConstraint(multipleReferencesValueConstraint);
				if (result == null) result = caseValueConstraint(multipleReferencesValueConstraint);
				if (result == null) result = caseNamedElement(multipleReferencesValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT: {
				SingleReferenceValueConstraint singleReferenceValueConstraint = (SingleReferenceValueConstraint)theEObject;
				T result = caseSingleReferenceValueConstraint(singleReferenceValueConstraint);
				if (result == null) result = caseValueConstraint(singleReferenceValueConstraint);
				if (result == null) result = caseExpressionHint(singleReferenceValueConstraint);
				if (result == null) result = caseModifiableHint(singleReferenceValueConstraint);
				if (result == null) result = caseNamedElement(singleReferenceValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_INTERFACE: {
				ValueConstraintSourceInterface valueConstraintSourceInterface = (ValueConstraintSourceInterface)theEObject;
				T result = caseValueConstraintSourceInterface(valueConstraintSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintSourceInterface);
				if (result == null) result = caseNamedElement(valueConstraintSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_ELEMENT: {
				ValueConstraintSourceElement valueConstraintSourceElement = (ValueConstraintSourceElement)theEObject;
				T result = caseValueConstraintSourceElement(valueConstraintSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(valueConstraintSourceElement);
				if (result == null) result = caseValueConstraintSourceInterface(valueConstraintSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(valueConstraintSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintSourceElement);
				if (result == null) result = caseNamedElement(valueConstraintSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT: {
				ValueConstraintExternalSourceElement valueConstraintExternalSourceElement = (ValueConstraintExternalSourceElement)theEObject;
				T result = caseValueConstraintExternalSourceElement(valueConstraintExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(valueConstraintExternalSourceElement);
				if (result == null) result = caseValueConstraintSourceInterface(valueConstraintExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(valueConstraintExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintExternalSourceElement);
				if (result == null) result = caseNamedElement(valueConstraintExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.RANGE_BOUND: {
				RangeBound rangeBound = (RangeBound)theEObject;
				T result = caseRangeBound(rangeBound);
				if (result == null) result = caseExpressionHint(rangeBound);
				if (result == null) result = caseModifiableHint(rangeBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraint(ValueConstraint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Range Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeConstraint(RangeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple References Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple References Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleReferencesValueConstraint(MultipleReferencesValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Reference Value Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Reference Value Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleReferenceValueConstraint(SingleReferenceValueConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintSourceInterface(ValueConstraintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintSourceElement(ValueConstraintSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintExternalSourceElement(ValueConstraintExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeBound(RangeBound object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Expression Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionHint(ExpressionHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiableHint(ModifiableHint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseModifiedAttributeElementType(ModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<S, C, R, A> object) {
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

} //ConstraintSwitch
