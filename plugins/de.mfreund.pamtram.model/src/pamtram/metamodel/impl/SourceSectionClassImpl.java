/**
 */
package pamtram.metamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

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
 *   <li>{@link pamtram.metamodel.impl.SourceSectionClassImpl#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionClassImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SourceSectionClassImpl#getOwningContainmentReference <em>Owning Containment Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceSectionClassImpl extends ClassImpl implements SourceSectionClass {
	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionReference> references;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionAttribute> attributes;
	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass container;

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
	 * @generated
	 */
	public EList<SourceSectionReference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentWithInverseEList<SourceSectionReference>(SourceSectionReference.class, this, MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES, MetamodelPackage.SOURCE_SECTION_REFERENCE__OWNING_CLASS);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceSectionAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<SourceSectionAttribute>(SourceSectionAttribute.class, this, MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES, MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__OWNING_CLASS);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (SourceSectionClass)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.SOURCE_SECTION_CLASS__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(SourceSectionClass newContainer) {
		SourceSectionClass oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SOURCE_SECTION_CLASS__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionContainmentReference getOwningContainmentReference() {
		if (eContainerFeatureID() != MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE) return null;
		return (SourceSectionContainmentReference)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningContainmentReference(SourceSectionContainmentReference newOwningContainmentReference, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningContainmentReference, MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningContainmentReference(SourceSectionContainmentReference newOwningContainmentReference) {
		if (newOwningContainmentReference != eInternalContainer() || (eContainerFeatureID() != MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE && newOwningContainmentReference != null)) {
			if (EcoreUtil.isAncestor(this, newOwningContainmentReference))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningContainmentReference != null)
				msgs = ((InternalEObject)newOwningContainmentReference).eInverseAdd(this, MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE, SourceSectionContainmentReference.class, msgs);
			msgs = basicSetOwningContainmentReference(newOwningContainmentReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE, newOwningContainmentReference, newOwningContainmentReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferences()).basicAdd(otherEnd, msgs);
			case MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningContainmentReference((SourceSectionContainmentReference)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				return basicSetOwningContainmentReference(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				return eInternalContainer().eInverseRemove(this, MetamodelPackage.SOURCE_SECTION_CONTAINMENT_REFERENCE__VALUE, SourceSectionContainmentReference.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES:
				return getReferences();
			case MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES:
				return getAttributes();
			case MetamodelPackage.SOURCE_SECTION_CLASS__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				return getOwningContainmentReference();
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
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends SourceSectionReference>)newValue);
				return;
			case MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends SourceSectionAttribute>)newValue);
				return;
			case MetamodelPackage.SOURCE_SECTION_CLASS__CONTAINER:
				setContainer((SourceSectionClass)newValue);
				return;
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
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES:
				getReferences().clear();
				return;
			case MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case MetamodelPackage.SOURCE_SECTION_CLASS__CONTAINER:
				setContainer((SourceSectionClass)null);
				return;
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
			case MetamodelPackage.SOURCE_SECTION_CLASS__REFERENCES:
				return references != null && !references.isEmpty();
			case MetamodelPackage.SOURCE_SECTION_CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case MetamodelPackage.SOURCE_SECTION_CLASS__CONTAINER:
				return container != null;
			case MetamodelPackage.SOURCE_SECTION_CLASS__OWNING_CONTAINMENT_REFERENCE:
				return getOwningContainmentReference() != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceSectionClassImpl