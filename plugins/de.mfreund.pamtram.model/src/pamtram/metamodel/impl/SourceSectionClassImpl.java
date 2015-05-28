/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionClassImpl#getOwningContainmentReference <em>Owning Containment Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceSectionClassImpl extends ClassImpl<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> implements SourceSectionClass {
	/**
	 * The cached value of the '{@link #getOwningContainmentReference() <em>Owning Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningContainmentReference()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionContainmentReference owningContainmentReference;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SOURCE_SECTION_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SourceSectionReference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<SourceSectionReference>(SourceSectionReference.class, this, MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setContainer(SourceSectionClass newContainer) {
		super.setContainer(newContainer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<SourceSectionAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<SourceSectionAttribute>(SourceSectionAttribute.class, this, MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionContainmentReference getOwningContainmentReference() {
		if (owningContainmentReference != null && owningContainmentReference.eIsProxy()) {
			InternalEObject oldOwningContainmentReference = (InternalEObject)owningContainmentReference;
			owningContainmentReference = (SourceSectionContainmentReference)eResolveProxy(oldOwningContainmentReference);
			if (owningContainmentReference != oldOwningContainmentReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE, oldOwningContainmentReference, owningContainmentReference));
			}
		}
		return owningContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionContainmentReference basicGetOwningContainmentReference() {
		return owningContainmentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningContainmentReference(SourceSectionContainmentReference newOwningContainmentReference) {
		SourceSectionContainmentReference oldOwningContainmentReference = owningContainmentReference;
		owningContainmentReference = newOwningContainmentReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE, oldOwningContainmentReference, owningContainmentReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				if (resolve) return getOwningContainmentReference();
				return basicGetOwningContainmentReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				setOwningContainmentReference((SourceSectionContainmentReference)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				setOwningContainmentReference((SourceSectionContainmentReference)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				return owningContainmentReference != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceSectionClassImpl
