/**
 */
package pamtram.structure.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.structure.Attribute;
import pamtram.structure.CardinalityType;
import pamtram.structure.ContainmentReference;
import pamtram.structure.MetaModelSectionReference;
import pamtram.structure.MetamodelPackage;
import pamtram.structure.NonContainmentReference;
import pamtram.structure.Reference;
import pamtram.structure.Section;
import pamtram.structure.util.MetamodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.ClassImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.structure.impl.ClassImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link pamtram.structure.impl.ClassImpl#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.structure.impl.ClassImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.structure.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MetaModelElementImpl<S, C, R, A> implements pamtram.structure.Class<S, C, R, A> {
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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<A> attributes;

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
		this.setNameDerived(this.eClass, newEClass, null, null);
		this.setEClassGen(newEClass);
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
			references = new EObjectContainmentWithInverseEList<R>(Reference.class, this, MetamodelPackage.CLASS__REFERENCES, MetamodelPackage.REFERENCE__OWNING_CLASS);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public C getContainerGen() {
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
	 */
	@Override
	public C getContainer() {
		C container = this.getContainerGen();
		if (container == null && !(this instanceof Section)) {
			return this.getOwningContainmentReference().getOwningClass();
		} else {
			return container;
		}
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
	public EList<A> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<A>(Attribute.class, this, MetamodelPackage.CLASS__ATTRIBUTES, MetamodelPackage.ATTRIBUTE__OWNING_CLASS);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isContainerFor(final C containedClass) {
		C container = containedClass.getContainer();
				
		// this means that we have reached the top level container for the 'containedClass'
		if(container == null) {
			return false;
		// this is the container
		} else if(this.equals(container)) {
			return true;
		// one of the extended sections is the container
		} else if(container instanceof Section && ((Section) container).getExtend().contains(this)) {
			return true;
		// this was not the container, so iterate up in the containment hierarchy
		} else {
			return isContainerFor(container);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isContainedIn(final C containerClass) {
		EList<C> containedClasses = new BasicEList<>();
		
		// collect all classes that are referenced by containment references
		BasicEList<R> refs = new BasicEList<>(containerClass.getReferences());
		if(containerClass instanceof Section) {
			EList<Section> sections = ((Section) containerClass).getExtend(); 
			for (Section s : sections) {
				refs.addAll(s.getReferences());
			}
		}
		
		for (R ref : containerClass.getReferences()) {
			if(!(ref.getEReference().isContainment())) {
				continue;
			}
			if(ref instanceof ContainmentReference<?,?,?,?>){
				containedClasses.addAll(((ContainmentReference<S,C,R,A>) ref).getValue());
			} else if(ref instanceof MetaModelSectionReference) {
				containedClasses.addAll((Collection<? extends C>) ((MetaModelSectionReference) ref).getValue());
			}
		}
			
		// recursively iterate over all contained classes
		boolean found = false;
		for (C containedClass : containedClasses) {
			if(containedClass.equals(this) || isContainedIn(containedClass)) {
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
	@SuppressWarnings("unchecked")
	public ContainmentReference<S, C, R, A> getOwningContainmentReference() {
		if(this.eContainer() instanceof ContainmentReference<?,?,?,?>) {
			return (ContainmentReference<S,C,R,A>) this.eContainer();
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isReferencedBy(final C referencingClass, EList<C> referencedClasses) {
		if(referencedClasses == null) {
			referencedClasses = new BasicEList<>();
		}
		BasicEList<C> classes = new BasicEList<>();

		// collect all classes that are referenced
		for (R ref : referencingClass.getReferences()) {

			if(ref instanceof ContainmentReference<?,?,?,?>){
				classes.addAll(((ContainmentReference<S,C,R,A>) ref).getValue());
			} else if(ref instanceof MetaModelSectionReference) {
				classes.addAll((Collection<? extends C>) ((MetaModelSectionReference) ref).getValue());
			} else if(ref instanceof NonContainmentReference){
				classes.addAll(((NonContainmentReference<S,C,R,A>) ref).getValue());
			}
		}

		// recursively iterate over all referenced classes
		for (C clazz : classes) {
			if(clazz.equals(this) || this.isReferencedBy(clazz, referencedClasses)) {
				return true;
			} else {
				if(!referencedClasses.contains(clazz)) {
					referencedClasses.add(clazz);
				}
			}
		}

		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateEClassMatchesParentEReference(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this == this.getContainingSection() || this.getEClass() == null || !(this.eContainer() instanceof Reference<?, ?, ?, ?>)) {
			return true;
		}
		
		Reference<?, ?, ?, ?> parentReference = (Reference<?, ?, ?, ?>) this.eContainer();
		
		if(parentReference.getEReference() == null) {
			return true;
		}
		
		boolean result = parentReference.getEReference().getEReferenceType().isSuperTypeOf(this.getEClass());
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The eClass '" + this.eClass().getName() + "' is not allowed by the containing reference!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MetamodelValidator.DIAGNOSTIC_SOURCE,
							MetamodelValidator.CLASS__VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE,
							errorMessage,
					new Object[] { this, MetamodelPackage.Literals.CLASS__ECLASS }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCardinalityIsValid(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this == this.getContainingSection() || this.getEClass() == null || !(this.eContainer() instanceof Reference<?, ?, ?, ?>)) {
			return true;
		}
		
		Reference<?, ?, ?, ?> parentReference = (Reference<?, ?, ?, ?>) this.eContainer();
		
		if(parentReference.getEReference() == null) {
			return true;
		}
		
		boolean result = !(this.cardinality != CardinalityType.ONE && parentReference.getEReference().getUpperBound() == 1);
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The cardinality of a Class must be specified as 'CardinalityType::ONE' when the upper bound of the containing Reference is '1'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MetamodelValidator.DIAGNOSTIC_SOURCE,
							MetamodelValidator.CLASS__VALIDATE_CARDINALITY_IS_VALID,
							errorMessage,
					new Object[] { this, MetamodelPackage.Literals.CLASS__CARDINALITY }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateContainerIsValid(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this instanceof Section<?, ?, ?, ?> || this.getContainer() == null ? true : this.getContainer().equals(this.eContainer().eContainer());
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The 'container' refrence must point to the containing Class!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MetamodelValidator.DIAGNOSTIC_SOURCE,
							MetamodelValidator.CLASS__VALIDATE_CONTAINER_IS_VALID,
							errorMessage,
					new Object[] { this, MetamodelPackage.Literals.CLASS__CONTAINER }));
		
		}
		
		return result;
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
			case MetamodelPackage.CLASS__REFERENCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferences()).basicAdd(otherEnd, msgs);
			case MetamodelPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
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
			case MetamodelPackage.CLASS__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.CLASS__ATTRIBUTES:
				return getAttributes();
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
			case MetamodelPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends A>)newValue);
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
			case MetamodelPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
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
			case MetamodelPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
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
			case MetamodelPackage.CLASS___IS_CONTAINER_FOR__CLASS:
				return isContainerFor((C)arguments.get(0));
			case MetamodelPackage.CLASS___IS_CONTAINED_IN__CLASS:
				return isContainedIn((C)arguments.get(0));
			case MetamodelPackage.CLASS___GET_OWNING_CONTAINMENT_REFERENCE:
				return getOwningContainmentReference();
			case MetamodelPackage.CLASS___IS_REFERENCED_BY__CLASS_ELIST:
				return isReferencedBy((C)arguments.get(0), (EList<C>)arguments.get(1));
			case MetamodelPackage.CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP:
				return validateEClassMatchesParentEReference((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP:
				return validateCardinalityIsValid((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP:
				return validateContainerIsValid((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
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
