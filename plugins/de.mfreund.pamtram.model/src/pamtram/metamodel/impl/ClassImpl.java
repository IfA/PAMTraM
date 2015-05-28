/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassImpl<C extends pamtram.metamodel.Class<C, R>, R extends Reference<C>> extends MetaModelElementImpl<C> implements pamtram.metamodel.Class<C, R> {
	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

	/**
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final CardinalityType CARDINALITY_EDEFAULT = CardinalityType.ONE;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected CardinalityType cardinality = CARDINALITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<R> references;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected C container;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEClass() {
		if (eClass != null && eClass.eIsProxy()) {
			InternalEObject oldEClass = (InternalEObject)eClass;
			eClass = (EClass)eResolveProxy(oldEClass);
			if (eClass != oldEClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CLASS__ECLASS, oldEClass, eClass));
			}
		}
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetEClass() {
		return eClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEClassGen(EClass newEClass) {
		EClass oldEClass = eClass;
		eClass = newEClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CLASS__ECLASS, oldEClass, eClass));
	}
	
	/**
	 * Before setting the {@link newEClass}, update the name.
	 */
	@Override
	public void setEClass(EClass newEClass) {
		setNameDerived(eClass, newEClass, null, null);
		setEClassGen(newEClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CardinalityType getCardinality() {
		return cardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCardinality(CardinalityType newCardinality) {
		CardinalityType oldCardinality = cardinality;
		cardinality = newCardinality == null ? CARDINALITY_EDEFAULT : newCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CLASS__CARDINALITY, oldCardinality, cardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<R> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<R>(Reference.class, this, MetamodelPackage.CLASS__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public C getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (C)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CLASS__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContainer(C newContainer) {
		C oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CLASS__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isContainerForGeneric(final C containedClass) {
		C container = containedClass.getContainer();
				
		// this means that we have reached the top level container for the 'containedClass'
		if(container == null) {
			return false;
		// this is the container
		} else if(this.equals(container)) {
			return true;
		// this was not the container, so iterate up in the containment hierarchy
		} else {
			return isContainerForGeneric(container);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns <em>true</em> if the class is a top-level element of a section
	 * or of a {@link LibraryEntry}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSection() {
		return this.equals(this.getContainingSection());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isContainedInGeneric(final C containerClass) {
		C container = containerClass.getContainer();
				
		// this means that we have reached the top level container for the 'containedClass'
		if(container == null) {
			return false;
		// this is the container
		} else if(this.equals(container)) {
			return true;
		// this was not the container, so iterate up in the containment hierarchy
		} else {
			return isContainerForGeneric(container);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.CLASS__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.CLASS__ECLASS:
				if (resolve) return getEClass();
				return basicGetEClass();
			case MetamodelPackage.CLASS__CARDINALITY:
				return getCardinality();
			case MetamodelPackage.CLASS__REFERENCES:
				return getReferences();
			case MetamodelPackage.CLASS__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
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
			case MetamodelPackage.CLASS__ECLASS:
				setEClass((EClass)newValue);
				return;
			case MetamodelPackage.CLASS__CARDINALITY:
				setCardinality((CardinalityType)newValue);
				return;
			case MetamodelPackage.CLASS__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends R>)newValue);
				return;
			case MetamodelPackage.CLASS__CONTAINER:
				setContainer((C)newValue);
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
			case MetamodelPackage.CLASS__ECLASS:
				setEClass((EClass)null);
				return;
			case MetamodelPackage.CLASS__CARDINALITY:
				setCardinality(CARDINALITY_EDEFAULT);
				return;
			case MetamodelPackage.CLASS__REFERENCES:
				getReferences().clear();
				return;
			case MetamodelPackage.CLASS__CONTAINER:
				setContainer((C)null);
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
			case MetamodelPackage.CLASS__ECLASS:
				return eClass != null;
			case MetamodelPackage.CLASS__CARDINALITY:
				return cardinality != CARDINALITY_EDEFAULT;
			case MetamodelPackage.CLASS__REFERENCES:
				return references != null && !references.isEmpty();
			case MetamodelPackage.CLASS__CONTAINER:
				return container != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MetamodelPackage.CLASS___IS_CONTAINER_FOR_GENERIC__CLASS:
				return isContainerForGeneric((C)arguments.get(0));
			case MetamodelPackage.CLASS___IS_SECTION:
				return isSection();
			case MetamodelPackage.CLASS___IS_CONTAINED_IN_GENERIC__CLASS:
				return isContainedInGeneric((C)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cardinality: ");
		result.append(cardinality);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
