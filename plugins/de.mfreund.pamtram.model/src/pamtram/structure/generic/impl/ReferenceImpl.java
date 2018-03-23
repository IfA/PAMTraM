/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.generic.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.impl.ReferenceImpl#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ReferenceImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MetaModelElementImpl<S, C, R, A> implements Reference<S, C, R, A> {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public C getOwningClass() {
	
		if (eContainerFeatureID() != GenericPackage.REFERENCE__OWNING_CLASS) return null;
		return (C)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<C> getValuesGeneric() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addValuesGeneric(EList<C> values) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExtended() {
		
		// We consider a reference as 'extended' if:
		// 1. the reference is directly contained in an abstract Section,
		// 2. the reference is an ActualReference (i.e. it represents a metamodel reference), and
		// 3. there is another reference further downward in the extension hierarchy that represents the same metamodel
		// reference
		//
		if (!(this instanceof ActualReference<?, ?, ?, ?> && this.getOwningClass() instanceof Section<?, ?, ?, ?>
				&& ((Section<?, ?, ?, ?>) this.getOwningClass()).isAbstract())) {
			return false;
		}
		
		EReference eReference = ((ActualReference<?, ?, ?, ?>) this).getEReference();
		
		if (eReference == null) {
			return false;
		}
		
		return ((Section<?, ?, ?, ?>) this.getOwningClass()).getAllExtending().stream()
				.flatMap(s -> s.getActualReferences().stream()).anyMatch(r -> r.eClass().equals(this.eClass())
						&& eReference.equals(((ActualReference<?, ?, ?, ?>) r).getEReference()));	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<C> getValuesIncludingExtended() {
		
		EList<C> values = new BasicEList<>(this.getValuesGeneric());
		
		// Only ActualReferences directly contained in Sections can extend other references
		//
		if (this.getOwningClass() instanceof Section<?, ?, ?, ?> && this instanceof ActualReference<?, ?, ?, ?>
				&& ((ActualReference<?, ?, ?, ?>) this).getEReference() != null) {
		
			EReference eReference = ((ActualReference<?, ?, ?, ?>) this).getEReference();
		
			List<Reference<?, ?, ?, ?>> extendedReferences = ((Section<?, ?, ?, ?>) this.getOwningClass())
					.getAllExtend().stream().flatMap(s -> s.getActualReferences().stream())
					.filter(r -> eReference.equals(((ActualReference<?, ?, ?, ?>) r).getEReference()))
					.collect(Collectors.toList());
		
			values.addAll((Collection<? extends C>) extendedReferences.stream()
					.flatMap(r -> r.getValuesGeneric().stream()).collect(Collectors.toList()));
		}
		
		return values;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenericPackage.REFERENCE__OWNING_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, GenericPackage.REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenericPackage.REFERENCE__OWNING_CLASS:
				return eBasicSetContainer(null, GenericPackage.REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GenericPackage.REFERENCE__OWNING_CLASS:
				return eInternalContainer().eInverseRemove(this, GenericPackage.CLASS__REFERENCES, pamtram.structure.generic.Class.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericPackage.REFERENCE__OWNING_CLASS:
				return getOwningClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GenericPackage.REFERENCE__OWNING_CLASS:
				return getOwningClass() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GenericPackage.REFERENCE___GET_VALUES_GENERIC:
				return getValuesGeneric();
			case GenericPackage.REFERENCE___ADD_VALUES_GENERIC__ELIST:
				addValuesGeneric((EList<C>)arguments.get(0));
				return null;
			case GenericPackage.REFERENCE___IS_EXTENDED:
				return isExtended();
			case GenericPackage.REFERENCE___GET_VALUES_INCLUDING_EXTENDED:
				return getValuesIncludingExtended();
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public void addValuesGeneric(List<C> values) {

		this.addValuesGeneric(new BasicEList<>(values));

	}

} // ReferenceImpl
