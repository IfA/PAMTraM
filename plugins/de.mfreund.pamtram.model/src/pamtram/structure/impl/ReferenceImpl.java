/**
 */
package pamtram.structure.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.structure.Attribute;
import pamtram.structure.Class;
import pamtram.structure.MetamodelPackage;
import pamtram.structure.Reference;
import pamtram.structure.Section;
import pamtram.structure.util.MetamodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.impl.ReferenceImpl#getEReference <em>EReference</em>}</li>
 * <li>{@link pamtram.structure.impl.ReferenceImpl#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ReferenceImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MetaModelElementImpl<S, C, R, A> implements Reference<S, C, R, A> {

	/**
	 * The cached value of the '{@link #getEReference() <em>EReference</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #getEReference()
	 * @generated
	 * @ordered
	 */
	protected EReference eReference;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MetamodelPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEReference() {

		if (this.eReference != null && this.eReference.eIsProxy()) {
			InternalEObject oldEReference = (InternalEObject) this.eReference;
			this.eReference = (EReference) this.eResolveProxy(oldEReference);
			if (this.eReference != oldEReference) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MetamodelPackage.REFERENCE__EREFERENCE, oldEReference, this.eReference));
				}
			}
		}
		return this.eReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference basicGetEReference() {

		return this.eReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEReferenceGen(EReference newEReference) {

		EReference oldEReference = this.eReference;
		this.eReference = newEReference;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.REFERENCE__EREFERENCE,
					oldEReference, this.eReference));
		}
	}

	/**
	 * Before setting the {@link newEReference}, update the name.
	 */
	@Override
	public void setEReference(EReference newEReference) {

		this.setNameDerived(this.eReference, newEReference, null, null);
		this.setEReferenceGen(newEReference);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public C getOwningClass() {

		if (this.eContainerFeatureID() != MetamodelPackage.REFERENCE__OWNING_CLASS) {
			return null;
		}
		return (C) this.eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean validateEReferenceMatchesParentEClass(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		if (this.isLibraryEntry() || this.getEReference() == null
				|| !(this.eContainer() instanceof pamtram.structure.Class)) {
			return true;
		}

		EClass parentEClass = ((Class<?, ?, ?, ?>) this.eContainer()).getEClass();

		boolean result = parentEClass == null ? true : parentEClass.getEAllReferences().contains(this.getEReference());

		if (!result && diagnostics != null) {

			String errorMessage = "The eReference '" + this.getEReference().getName()
					+ "' is not allowed by the containing Class!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MetamodelValidator.DIAGNOSTIC_SOURCE,
					MetamodelValidator.REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS, errorMessage,
					new Object[] { this, MetamodelPackage.Literals.REFERENCE__EREFERENCE }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<C> getValuesGeneric() {

		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void addValuesGeneric(EList<C> values) {

		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				if (this.eInternalContainer() != null) {
					msgs = this.eBasicRemoveFromContainer(msgs);
				}
				return this.eBasicSetContainer(otherEnd, MetamodelPackage.REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return this.eBasicSetContainer(null, MetamodelPackage.REFERENCE__OWNING_CLASS, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {

		switch (this.eContainerFeatureID()) {
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return this.eInternalContainer().eInverseRemove(this, MetamodelPackage.CLASS__REFERENCES,
						pamtram.structure.Class.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case MetamodelPackage.REFERENCE__EREFERENCE:
				if (resolve) {
					return this.getEReference();
				}
				return this.basicGetEReference();
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return this.getOwningClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case MetamodelPackage.REFERENCE__EREFERENCE:
				this.setEReference((EReference) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
			case MetamodelPackage.REFERENCE__EREFERENCE:
				this.setEReference((EReference) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
			case MetamodelPackage.REFERENCE__EREFERENCE:
				return this.eReference != null;
			case MetamodelPackage.REFERENCE__OWNING_CLASS:
				return this.getOwningClass() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case MetamodelPackage.REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
				return this.validateEReferenceMatchesParentEClass((DiagnosticChain) arguments.get(0),
						(Map<?, ?>) arguments.get(1));
			case MetamodelPackage.REFERENCE___GET_VALUES_GENERIC:
				return this.getValuesGeneric();
			case MetamodelPackage.REFERENCE___ADD_VALUES_GENERIC__ELIST:
				this.addValuesGeneric((EList<C>) arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public void addValuesGeneric(List<C> values) {

		this.addValuesGeneric(new BasicEList<>(values));

	}

} // ReferenceImpl
