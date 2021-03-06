/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.constraint.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pamtram.ConditionalElement;
import pamtram.ExpressionElement;
import pamtram.MatchSpecElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.extended.MappingHintSourceInterface;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.DynamicSourceElement;
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
			case ConstraintPackage.VALUE_CONSTRAINT: {
				ValueConstraint valueConstraint = (ValueConstraint)theEObject;
				T result = caseValueConstraint(valueConstraint);
				if (result == null) result = caseNamedElement(valueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT: {
				SingleReferenceValueConstraint singleReferenceValueConstraint = (SingleReferenceValueConstraint)theEObject;
				T result = caseSingleReferenceValueConstraint(singleReferenceValueConstraint);
				if (result == null) result = caseValueConstraint(singleReferenceValueConstraint);
				if (result == null) result = caseExpressionElement(singleReferenceValueConstraint);
				if (result == null) result = caseModifiableElement(singleReferenceValueConstraint);
				if (result == null) result = caseNamedElement(singleReferenceValueConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.EQUALITY_CONSTRAINT: {
				EqualityConstraint equalityConstraint = (EqualityConstraint)theEObject;
				T result = caseEqualityConstraint(equalityConstraint);
				if (result == null) result = caseSingleReferenceValueConstraint(equalityConstraint);
				if (result == null) result = caseValueConstraint(equalityConstraint);
				if (result == null) result = caseExpressionElement(equalityConstraint);
				if (result == null) result = caseModifiableElement(equalityConstraint);
				if (result == null) result = caseNamedElement(equalityConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.CHOICE_CONSTRAINT: {
				ChoiceConstraint choiceConstraint = (ChoiceConstraint)theEObject;
				T result = caseChoiceConstraint(choiceConstraint);
				if (result == null) result = caseValueConstraint(choiceConstraint);
				if (result == null) result = caseNamedElement(choiceConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.NUMERIC_CONSTRAINT: {
				NumericConstraint numericConstraint = (NumericConstraint)theEObject;
				T result = caseNumericConstraint(numericConstraint);
				if (result == null) result = caseSingleReferenceValueConstraint(numericConstraint);
				if (result == null) result = caseValueConstraint(numericConstraint);
				if (result == null) result = caseExpressionElement(numericConstraint);
				if (result == null) result = caseModifiableElement(numericConstraint);
				if (result == null) result = caseNamedElement(numericConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.STRING_CONSTRAINT: {
				StringConstraint stringConstraint = (StringConstraint)theEObject;
				T result = caseStringConstraint(stringConstraint);
				if (result == null) result = caseSingleReferenceValueConstraint(stringConstraint);
				if (result == null) result = caseValueConstraint(stringConstraint);
				if (result == null) result = caseExpressionElement(stringConstraint);
				if (result == null) result = caseModifiableElement(stringConstraint);
				if (result == null) result = caseNamedElement(stringConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_INTERFACE: {
				ValueConstraintSourceInterface valueConstraintSourceInterface = (ValueConstraintSourceInterface)theEObject;
				T result = caseValueConstraintSourceInterface(valueConstraintSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintSourceInterface);
				if (result == null) result = caseNamedElement(valueConstraintSourceInterface);
				if (result == null) result = caseConditionalElement(valueConstraintSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT_SOURCE_ELEMENT: {
				ValueConstraintSourceElement valueConstraintSourceElement = (ValueConstraintSourceElement)theEObject;
				T result = caseValueConstraintSourceElement(valueConstraintSourceElement);
				if (result == null) result = caseLocalDynamicSourceElement(valueConstraintSourceElement);
				if (result == null) result = caseValueConstraintSourceInterface(valueConstraintSourceElement);
				if (result == null) result = caseDynamicSourceElement(valueConstraintSourceElement);
				if (result == null) result = caseMatchSpecElement(valueConstraintSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintSourceElement);
				if (result == null) result = caseNamedElement(valueConstraintSourceElement);
				if (result == null) result = caseModifiableElement(valueConstraintSourceElement);
				if (result == null) result = caseConditionalElement(valueConstraintSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT: {
				ValueConstraintExternalSourceElement valueConstraintExternalSourceElement = (ValueConstraintExternalSourceElement)theEObject;
				T result = caseValueConstraintExternalSourceElement(valueConstraintExternalSourceElement);
				if (result == null) result = caseExternalDynamicSourceElement(valueConstraintExternalSourceElement);
				if (result == null) result = caseValueConstraintSourceInterface(valueConstraintExternalSourceElement);
				if (result == null) result = caseDynamicSourceElement(valueConstraintExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintExternalSourceElement);
				if (result == null) result = caseNamedElement(valueConstraintExternalSourceElement);
				if (result == null) result = caseModifiableElement(valueConstraintExternalSourceElement);
				if (result == null) result = caseConditionalElement(valueConstraintExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConstraintPackage.VALUE_CONSTRAINT_GLOBAL_SOURCE_ELEMENT: {
				ValueConstraintGlobalSourceElement valueConstraintGlobalSourceElement = (ValueConstraintGlobalSourceElement)theEObject;
				T result = caseValueConstraintGlobalSourceElement(valueConstraintGlobalSourceElement);
				if (result == null) result = caseExternalDynamicSourceElement(valueConstraintGlobalSourceElement);
				if (result == null) result = caseValueConstraintSourceInterface(valueConstraintGlobalSourceElement);
				if (result == null) result = caseDynamicSourceElement(valueConstraintGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(valueConstraintGlobalSourceElement);
				if (result == null) result = caseNamedElement(valueConstraintGlobalSourceElement);
				if (result == null) result = caseModifiableElement(valueConstraintGlobalSourceElement);
				if (result == null) result = caseConditionalElement(valueConstraintGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>String Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringConstraint(StringConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualityConstraint(EqualityConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceConstraint(ChoiceConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericConstraint(NumericConstraint object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintGlobalSourceElement(ValueConstraintGlobalSourceElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Hint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Hint Source Interface</em>'.
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
	 * Returns the result of interpreting the object as an instance of '<em>Match Spec Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Spec Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseMatchSpecElement(MatchSpecElement<S, C, R, A> object) {
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
