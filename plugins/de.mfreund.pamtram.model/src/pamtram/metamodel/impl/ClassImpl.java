/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.SectionModel;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionReference;

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
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassImpl<R extends Reference> extends MetaModelElementImpl implements pamtram.metamodel.Class<R> {
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
	public EList<R> getReferencesGeneric() {
		return getReferences(); //TODO delete this
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAttributesGeneric() {
		EList<Attribute> attrs= new org.eclipse.emf.common.util.BasicEList<Attribute>();
		if(this instanceof SourceSectionClass){
		 attrs.addAll(((SourceSectionClass) this).getAttributes());
		
		} else if(this instanceof TargetSectionClass){
		 attrs.addAll(((TargetSectionClass) this).getAttributes());
		}
		return attrs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * If the 'container' reference is set, returns the value of
	 * this reference. If it is not set but the container can 
	 * automatically be determined by stepping up in the
	 * section hierarchy, the determined container is returned.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public pamtram.metamodel.Class<Reference> getContainerGeneric() {
		pamtram.metamodel.Class ret;
		if(this instanceof SourceSectionClass){
			ret = ((SourceSectionClass)this).getContainer();
		} else if(this instanceof TargetSectionClass){
			ret = ((TargetSectionClass)this).getContainer();
		} else {
			return null;
		}
		if(ret == null && this.eContainer() instanceof Reference &&
				!(this.eContainer() instanceof SectionModel)) {
			ret = (pamtram.metamodel.Class) this.eContainer().eContainer();
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isContainerForGeneric(final pamtram.metamodel.Class<Reference> containedClass) {
		pamtram.metamodel.Class container = containedClass.getContainerGeneric();
				
		// this means that we have reached the top level container for the 'containedClass'
		if(container == null) {
			return false;
		// this is the container
		} else if(this.equals(container)) {
			return true;
		// this was not the container, so iterate up in the containment hierarchy
		} else {
			return isContainerForGeneric(containedClass.getContainerGeneric());
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
	 * This recursively iterates through all Classes that are contained in the 
	 * given {@link #containerClass} (via a {@link Reference} for that 
	 * Reference.getEReference().isContainment() returns <em>true</em>) and checks 
	 * if any of these classes matches this class.<br /><br />
	 * Note: This also check containments across {@link MetaModelSectionReference
	 * MetaModelSectionReferences}.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isContainedInGeneric(final pamtram.metamodel.Class<Reference> containerClass) {
		EList<pamtram.metamodel.Class> containedClasses = new BasicEList<>();
		
		// collect all classes that are referenced by containment references
		for (Reference ref : containerClass.getReferencesGeneric()) {
			if(!(ref.getEReference().isContainment())) {
				continue;
			}
			if(ref instanceof SourceSectionReference) {
				containedClasses.addAll(((SourceSectionReference) ref).getValuesGeneric());
			} else if(ref instanceof TargetSectionReference) {
				containedClasses.addAll(((TargetSectionReference) ref).getValuesGeneric());
			}
		}
		
		// recursively iterate over all contained classes
		boolean found = false;
		for (pamtram.metamodel.Class containedClass : containedClasses) {
			if(containedClass.equals(this) || isContainedInGeneric(containedClass)) {
				found = true;
				break;
			}
		}
		return found;
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
			case MetamodelPackage.CLASS___GET_REFERENCES_GENERIC:
				return getReferencesGeneric();
			case MetamodelPackage.CLASS___GET_ATTRIBUTES_GENERIC:
				return getAttributesGeneric();
			case MetamodelPackage.CLASS___GET_CONTAINER_GENERIC:
				return getContainerGeneric();
			case MetamodelPackage.CLASS___IS_CONTAINER_FOR_GENERIC__CLASS:
				return isContainerForGeneric((pamtram.metamodel.Class<Reference>)arguments.get(0));
			case MetamodelPackage.CLASS___IS_SECTION:
				return isSection();
			case MetamodelPackage.CLASS___IS_CONTAINED_IN_GENERIC__CLASS:
				return isContainedInGeneric((pamtram.metamodel.Class<Reference>)arguments.get(0));
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
