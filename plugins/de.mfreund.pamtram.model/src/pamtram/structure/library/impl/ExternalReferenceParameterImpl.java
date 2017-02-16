/**
 */
package pamtram.structure.library.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import pamtram.structure.StructurePackage;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>External Reference Parameter</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.library.impl.ExternalReferenceParameterImpl#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalReferenceParameterImpl extends LibraryParameterImpl<AbstractExternalReferenceParameter<?, ?>>
		implements ExternalReferenceParameter {

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionCrossReference reference;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExternalReferenceParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return StructurePackage.Literals.EXTERNAL_REFERENCE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 * 
	 * @generated
	 */
	@Override
	public void setOriginalParameter(AbstractExternalReferenceParameter<?, ?> newOriginalParameter) {

		super.setOriginalParameter(newOriginalParameter);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public TargetSectionCrossReference getReference() {

		return this.reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetReference(TargetSectionCrossReference newReference, NotificationChain msgs) {

		TargetSectionCrossReference oldReference = this.reference;
		this.reference = newReference;
		if (this.eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE, oldReference, newReference);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setReference(TargetSectionCrossReference newReference) {

		if (newReference != this.reference) {
			NotificationChain msgs = null;
			if (this.reference != null) {
				msgs = ((InternalEObject) this.reference).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE
						- StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE, null, msgs);
			}
			if (newReference != null) {
				msgs = ((InternalEObject) newReference).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE
						- StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE, null, msgs);
			}
			msgs = this.basicSetReference(newReference, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE, newReference, newReference));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE:
				return this.basicSetReference(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE:
				return this.getReference();
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
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE:
				this.setReference((TargetSectionCrossReference) newValue);
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
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE:
				this.setReference((TargetSectionCrossReference) null);
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
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER__REFERENCE:
				return this.reference != null;
		}
		return super.eIsSet(featureID);
	}

} // ExternalReferenceParameterImpl
