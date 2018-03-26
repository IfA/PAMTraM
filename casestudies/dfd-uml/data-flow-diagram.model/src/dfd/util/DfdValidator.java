/*******************************************************************************
 * Copyright (C) 2017-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package dfd.util;

import dfd.ControlFlow;
import dfd.DFD;
import dfd.DFDElement;
import dfd.DataFlow;
import dfd.DataStore;
import dfd.DfdPackage;
import dfd.Flow;
import dfd.NamedElement;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see dfd.DfdPackage
 * @generated
 */
public class DfdValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DfdValidator INSTANCE = new DfdValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "dfd";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate Number Format Is Correct' of 'Process'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int PROCESS__VALIDATE_NUMBER_FORMAT_IS_CORRECT = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate From Points To Element Of Same System' of 'Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FLOW__VALIDATE_FROM_POINTS_TO_ELEMENT_OF_SAME_SYSTEM = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate To Points To Element Of Same System' of 'Flow'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FLOW__VALIDATE_TO_POINTS_TO_ELEMENT_OF_SAME_SYSTEM = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 3;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DfdValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return DfdPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case DfdPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case DfdPackage.DFD:
				return validateDFD((DFD)value, diagnostics, context);
			case DfdPackage.DFD_ELEMENT:
				return validateDFDElement((DFDElement)value, diagnostics, context);
			case DfdPackage.PROCESS:
				return validateProcess((dfd.Process)value, diagnostics, context);
			case DfdPackage.DATA_STORE:
				return validateDataStore((DataStore)value, diagnostics, context);
			case DfdPackage.FLOW:
				return validateFlow((Flow)value, diagnostics, context);
			case DfdPackage.CONTROL_FLOW:
				return validateControlFlow((ControlFlow)value, diagnostics, context);
			case DfdPackage.DATA_FLOW:
				return validateDataFlow((DataFlow)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDFD(DFD dfd, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dfd, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDFDElement(DFDElement dfdElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dfdElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess(dfd.Process process, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(process, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(process, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(process, diagnostics, context);
		if (result || diagnostics != null) result &= validateProcess_DummyConstraint(process, diagnostics, context);
		if (result || diagnostics != null) result &= validateProcess_validateNumberFormatIsCorrect(process, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DummyConstraint constraint of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess_DummyConstraint(dfd.Process process, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "DummyConstraint", getObjectLabel(process, context) },
						 new Object[] { process },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the validateNumberFormatIsCorrect constraint of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess_validateNumberFormatIsCorrect(dfd.Process process, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return process.validateNumberFormatIsCorrect(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataStore(DataStore dataStore, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataStore, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlow(Flow flow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flow, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlow_validateFromPointsToElementOfSameSystem(flow, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlow_validateToPointsToElementOfSameSystem(flow, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validateFromPointsToElementOfSameSystem constraint of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlow_validateFromPointsToElementOfSameSystem(Flow flow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return flow.validateFromPointsToElementOfSameSystem(diagnostics, context);
	}

	/**
	 * Validates the validateToPointsToElementOfSameSystem constraint of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlow_validateToPointsToElementOfSameSystem(Flow flow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return flow.validateToPointsToElementOfSameSystem(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateControlFlow(ControlFlow controlFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(controlFlow, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlow_validateFromPointsToElementOfSameSystem(controlFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlow_validateToPointsToElementOfSameSystem(controlFlow, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataFlow(DataFlow dataFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataFlow, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlow_validateFromPointsToElementOfSameSystem(dataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlow_validateToPointsToElementOfSameSystem(dataFlow, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //DfdValidator
