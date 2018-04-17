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
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.util.GenericValidator;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourcePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Attribute</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.ActualSourceSectionAttributeImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActualSourceSectionAttributeImpl extends SourceSectionAttributeImpl
		implements ActualSourceSectionAttribute {

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attribute;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActualSourceSectionAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.ACTUAL_SOURCE_SECTION_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute() {
	
		  if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeGen(EAttribute newAttribute) {
	
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE, oldAttribute, attribute));
	
	}

	/**
	 * Before setting the {@link newEAttribute}, update the name.
	 */
	@Override
	public void setAttribute(EAttribute newAttribute) {

		this.setNameDerived(this.attribute, newAttribute, null, null);
		this.setAttributeGen(newAttribute);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAttributeMatchesParentEClass(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.isLibraryEntry() || this.getAttribute() == null || !(this.eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)) {
			return true;
		}
		
		EClass parentEClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.eContainer()).getEClass();
		
		boolean result = parentEClass == null ? true : parentEClass.getEAllAttributes().contains(this.getAttribute());
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The eAttribute '" + this.getAttribute().getName() + "' is not allowed by the containing Class!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					GenericValidator.DIAGNOSTIC_SOURCE,
							GenericValidator.ACTUAL_ATTRIBUTE__VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS,
							errorMessage,
					new Object[] { this, GenericPackage.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE }));
		
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
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
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
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				setAttribute((EAttribute)null);
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
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE:
				return attribute != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ActualAttribute.class) {
			switch (derivedFeatureID) {
				case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE: return GenericPackage.ACTUAL_ATTRIBUTE__ATTRIBUTE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ActualAttribute.class) {
			switch (baseFeatureID) {
				case GenericPackage.ACTUAL_ATTRIBUTE__ATTRIBUTE: return SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE__ATTRIBUTE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ActualAttribute.class) {
			switch (baseOperationID) {
				case GenericPackage.ACTUAL_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP: return SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SourcePackage.ACTUAL_SOURCE_SECTION_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
				return validateAttributeMatchesParentEClass((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // SourceSectionAttributeImpl
