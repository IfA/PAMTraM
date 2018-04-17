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
package pamtram.structure.source.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.impl.ReferenceImpl;
import pamtram.structure.generic.util.GenericValidator;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.source.util.SourceValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Reference</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionReferenceImpl#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SourceSectionReferenceImpl
		extends ReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionReference {

	/**
	 * The default value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_UNMATCHED_ELEMENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreUnmatchedElements = IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.SOURCE_SECTION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIgnoreUnmatchedElements() {
	
		return ignoreUnmatchedElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIgnoreUnmatchedElements(boolean newIgnoreUnmatchedElements) {
	
		boolean oldIgnoreUnmatchedElements = ignoreUnmatchedElements;
		ignoreUnmatchedElements = newIgnoreUnmatchedElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS, oldIgnoreUnmatchedElements, ignoreUnmatchedElements));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIsIgnoreUnmatchedIfIsComplemented(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		if (!(this instanceof ActualReference<?, ?, ?, ?> && this instanceof CompositeReference<?, ?, ?, ?>)) {
			return true;
		}
		
		List<EReference> actualCrossReferences = this.getOwningClass().getAllCrossReferences().stream()
				.filter(r -> r instanceof ActualReference<?, ?, ?, ?>)
				.map(r -> ((ActualReference<?, ?, ?, ?>) r).getEReference()).collect(Collectors.toList());
		
		boolean isComplemented = actualCrossReferences.stream()
				.anyMatch(r -> r != null && r.equals(((ActualReference<?, ?, ?, ?>) this).getEReference()));
		
		boolean result = !isComplemented || this.isIgnoreUnmatchedElements();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "This reference is complemented by a CrossReference that represents the same EReference. Hence, 'ignoreUmatchedElements' needs to be set to 'true'!";
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,
					SourceValidator.SOURCE_SECTION_REFERENCE__VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED,
					errorMessage, new Object[] { this, SourcePackage.Literals.SOURCE_SECTION_REFERENCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return isIgnoreUnmatchedElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements(IGNORE_UNMATCHED_ELEMENTS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return ignoreUnmatchedElements != IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SourcePackage.SOURCE_SECTION_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP:
				return validateIsIgnoreUnmatchedIfIsComplemented((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ignoreUnmatchedElements: ");
		result.append(ignoreUnmatchedElements);
		result.append(')');
		return result.toString();
	}

} // SourceSectionReferenceImpl
