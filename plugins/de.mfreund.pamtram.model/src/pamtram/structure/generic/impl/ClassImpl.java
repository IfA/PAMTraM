/**
 */
package pamtram.structure.generic.impl;

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

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.ContainmentReference;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.util.GenericValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Class</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.generic.impl.ClassImpl#getEClass
 * <em>EClass</em>}</li>
 * <li>{@link pamtram.structure.generic.impl.ClassImpl#getCardinality
 * <em>Cardinality</em>}</li>
 * <li>{@link pamtram.structure.generic.impl.ClassImpl#getReferences
 * <em>References</em>}</li>
 * <li>{@link pamtram.structure.generic.impl.ClassImpl#getContainer
 * <em>Container</em>}</li>
 * <li>{@link pamtram.structure.generic.impl.ClassImpl#getAttributes
 * <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends MetaModelElementImpl<S, C, R, A> implements pamtram.structure.generic.Class<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEClass()
	 * @generated
	 * @ordered
	 */
	protected EClass eClass;

	/**
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final CardinalityType CARDINALITY_EDEFAULT = CardinalityType.ONE;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected CardinalityType cardinality = ClassImpl.CARDINALITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<R> references;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected C container;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<A> attributes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getEClass() {
		if (this.eClass != null && this.eClass.eIsProxy()) {
			InternalEObject oldEClass = (InternalEObject) this.eClass;
			this.eClass = (EClass) this.eResolveProxy(oldEClass);
			if (this.eClass != oldEClass) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericPackage.CLASS__ECLASS,
							oldEClass, this.eClass));
				}
			}
		}
		return this.eClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass basicGetEClass() {
		return this.eClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEClassGen(EClass newEClass) {
		EClass oldEClass = this.eClass;
		this.eClass = newEClass;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, GenericPackage.CLASS__ECLASS, oldEClass,
					this.eClass));
		}
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CardinalityType getCardinality() {
		return this.cardinality;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCardinality(CardinalityType newCardinality) {
		CardinalityType oldCardinality = this.cardinality;
		this.cardinality = newCardinality == null ? ClassImpl.CARDINALITY_EDEFAULT : newCardinality;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, GenericPackage.CLASS__CARDINALITY,
					oldCardinality, this.cardinality));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<R> getReferences() {
		if (this.references == null) {
			this.references = new EObjectContainmentWithInverseEList<>(Reference.class, this,
					GenericPackage.CLASS__REFERENCES, GenericPackage.REFERENCE__OWNING_CLASS);
		}
		return this.references;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public C getContainerGen() {
		if (this.container != null && this.container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject) this.container;
			this.container = (C) this.eResolveProxy(oldContainer);
			if (this.container != oldContainer) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, GenericPackage.CLASS__CONTAINER,
							oldContainer, this.container));
				}
			}
		}
		return this.container;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public C basicGetContainer() {
		return this.container;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setContainer(C newContainer) {
		C oldContainer = this.container;
		this.container = newContainer;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, GenericPackage.CLASS__CONTAINER, oldContainer,
					this.container));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<A> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new EObjectContainmentWithInverseEList<>(Attribute.class, this,
					GenericPackage.CLASS__ATTRIBUTES, GenericPackage.ATTRIBUTE__OWNING_CLASS);
		}
		return this.attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isContainerFor(final C containedClass) {
		C container = containedClass.getContainer();

		// this means that we have reached the top level container for the
		// 'containedClass'
		if (container == null) {
			return false;
			// this is the container
		} else if (this.equals(container)) {
			return true;
			// one of the extended sections is the container
		} else if (container instanceof Section && ((Section) container).getExtend().contains(this)) {
			return true;
			// this was not the container, so iterate up in the containment
			// hierarchy
		} else {
			return this.isContainerFor(container);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isContainedIn(final C containerClass) {
		EList<C> containedClasses = new BasicEList<>();

		// collect all classes that are referenced by containment references
		BasicEList<R> refs = new BasicEList<>(containerClass.getReferences());
		if (containerClass instanceof Section) {
			EList<Section> sections = ((Section) containerClass).getExtend();
			for (Section s : sections) {
				refs.addAll(s.getReferences());
			}
		}

		for (R ref : containerClass.getReferences()) {
			if (!(ref.getEReference().isContainment())) {
				continue;
			}
			if (ref instanceof ContainmentReference<?, ?, ?, ?>) {
				containedClasses.addAll(((ContainmentReference<S, C, R, A>) ref).getValue());
			} else if (ref instanceof CrossReference) {
				containedClasses.addAll(((CrossReference) ref).getValue());
			}
		}

		// recursively iterate over all contained classes
		boolean found = false;
		for (C containedClass : containedClasses) {
			if (containedClass.equals(this) || this.isContainedIn(containedClass)) {
				found = true;
				break;
			}
		}

		return found;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ContainmentReference<S, C, R, A> getOwningContainmentReference() {
		if (this.eContainer() instanceof ContainmentReference<?, ?, ?, ?>) {
			return (ContainmentReference<S, C, R, A>) this.eContainer();
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean isReferencedBy(final C referencingClass, EList<C> referencedClasses) {
		if (referencedClasses == null) {
			referencedClasses = new BasicEList<>();
		}
		BasicEList<C> classes = new BasicEList<>();

		// collect all classes that are referenced
		for (R ref : referencingClass.getReferences()) {

			if (ref instanceof ContainmentReference<?, ?, ?, ?>) {
				classes.addAll(((ContainmentReference<S, C, R, A>) ref).getValue());
			} else if (ref instanceof CrossReference) {
				classes.addAll(((CrossReference) ref).getValue());
			} else if (ref instanceof CrossReference) {
				classes.addAll(((CrossReference<S, C, R, A>) ref).getValue());
			}
		}

		// recursively iterate over all referenced classes
		for (C clazz : classes) {
			if (clazz.equals(this) || this.isReferencedBy(clazz, referencedClasses)) {
				return true;
			} else {
				if (!referencedClasses.contains(clazz)) {
					referencedClasses.add(clazz);
				}
			}
		}

		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean validateEClassMatchesParentEReference(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		if (this == this.getContainingSection() || this.getEClass() == null
				|| !(this.eContainer() instanceof Reference<?, ?, ?, ?>)) {
			return true;
		}

		Reference<?, ?, ?, ?> parentReference = (Reference<?, ?, ?, ?>) this.eContainer();

		if (parentReference.getEReference() == null) {
			return true;
		}

		boolean result = parentReference.getEReference().getEReferenceType().isSuperTypeOf(this.getEClass());

		if (!result && diagnostics != null) {

			String errorMessage = "The eClass '" + this.eClass().getName()
					+ "' is not allowed by the containing reference!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,
					GenericValidator.CLASS__VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE, errorMessage,
					new Object[] { this, GenericPackage.Literals.CLASS__ECLASS }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean validateCardinalityIsValid(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		if (this == this.getContainingSection() || this.getEClass() == null
				|| !(this.eContainer() instanceof Reference<?, ?, ?, ?>)) {
			return true;
		}

		Reference<?, ?, ?, ?> parentReference = (Reference<?, ?, ?, ?>) this.eContainer();

		if (parentReference.getEReference() == null) {
			return true;
		}

		boolean result = !(this.cardinality != CardinalityType.ONE
				&& parentReference.getEReference().getUpperBound() == 1);

		if (!result && diagnostics != null) {

			String errorMessage = "The cardinality of a Class must be specified as 'CardinalityType::ONE' when the upper bound of the containing Reference is '1'!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,
					GenericValidator.CLASS__VALIDATE_CARDINALITY_IS_VALID, errorMessage,
					new Object[] { this, GenericPackage.Literals.CLASS__CARDINALITY }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean validateContainerIsValid(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		boolean result = this instanceof Section<?, ?, ?, ?> || this.getContainer() == null ? true
				: this.getContainer().equals(this.eContainer().eContainer());

		if (!result && diagnostics != null) {

			String errorMessage = "The 'container' refrence must point to the containing Class!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,
					GenericValidator.CLASS__VALIDATE_CONTAINER_IS_VALID, errorMessage,
					new Object[] { this, GenericPackage.Literals.CLASS__CONTAINER }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case GenericPackage.CLASS__REFERENCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getReferences()).basicAdd(otherEnd, msgs);
		case GenericPackage.CLASS__ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getAttributes()).basicAdd(otherEnd, msgs);
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
		case GenericPackage.CLASS__REFERENCES:
			return ((InternalEList<?>) this.getReferences()).basicRemove(otherEnd, msgs);
		case GenericPackage.CLASS__ATTRIBUTES:
			return ((InternalEList<?>) this.getAttributes()).basicRemove(otherEnd, msgs);
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
		case GenericPackage.CLASS__ECLASS:
			if (resolve) {
				return this.getEClass();
			}
			return this.basicGetEClass();
		case GenericPackage.CLASS__CARDINALITY:
			return this.getCardinality();
		case GenericPackage.CLASS__REFERENCES:
			return this.getReferences();
		case GenericPackage.CLASS__CONTAINER:
			if (resolve) {
				return this.getContainer();
			}
			return this.basicGetContainer();
		case GenericPackage.CLASS__ATTRIBUTES:
			return this.getAttributes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GenericPackage.CLASS__ECLASS:
			this.setEClass((EClass) newValue);
			return;
		case GenericPackage.CLASS__CARDINALITY:
			this.setCardinality((CardinalityType) newValue);
			return;
		case GenericPackage.CLASS__REFERENCES:
			this.getReferences().clear();
			this.getReferences().addAll((Collection<? extends R>) newValue);
			return;
		case GenericPackage.CLASS__CONTAINER:
			this.setContainer((C) newValue);
			return;
		case GenericPackage.CLASS__ATTRIBUTES:
			this.getAttributes().clear();
			this.getAttributes().addAll((Collection<? extends A>) newValue);
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
		case GenericPackage.CLASS__ECLASS:
			this.setEClass((EClass) null);
			return;
		case GenericPackage.CLASS__CARDINALITY:
			this.setCardinality(ClassImpl.CARDINALITY_EDEFAULT);
			return;
		case GenericPackage.CLASS__REFERENCES:
			this.getReferences().clear();
			return;
		case GenericPackage.CLASS__CONTAINER:
			this.setContainer((C) null);
			return;
		case GenericPackage.CLASS__ATTRIBUTES:
			this.getAttributes().clear();
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
		case GenericPackage.CLASS__ECLASS:
			return this.eClass != null;
		case GenericPackage.CLASS__CARDINALITY:
			return this.cardinality != ClassImpl.CARDINALITY_EDEFAULT;
		case GenericPackage.CLASS__REFERENCES:
			return this.references != null && !this.references.isEmpty();
		case GenericPackage.CLASS__CONTAINER:
			return this.container != null;
		case GenericPackage.CLASS__ATTRIBUTES:
			return this.attributes != null && !this.attributes.isEmpty();
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
		case GenericPackage.CLASS___IS_CONTAINER_FOR__CLASS:
			return this.isContainerFor((C) arguments.get(0));
		case GenericPackage.CLASS___IS_CONTAINED_IN__CLASS:
			return this.isContainedIn((C) arguments.get(0));
		case GenericPackage.CLASS___GET_OWNING_CONTAINMENT_REFERENCE:
			return this.getOwningContainmentReference();
		case GenericPackage.CLASS___IS_REFERENCED_BY__CLASS_ELIST:
			return this.isReferencedBy((C) arguments.get(0), (EList<C>) arguments.get(1));
		case GenericPackage.CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP:
			return this.validateEClassMatchesParentEReference((DiagnosticChain) arguments.get(0),
					(Map<?, ?>) arguments.get(1));
		case GenericPackage.CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP:
			return this.validateCardinalityIsValid((DiagnosticChain) arguments.get(0), (Map<?, ?>) arguments.get(1));
		case GenericPackage.CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP:
			return this.validateContainerIsValid((DiagnosticChain) arguments.get(0), (Map<?, ?>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cardinality: ");
		result.append(this.cardinality);
		result.append(')');
		return result.toString();
	}

} // ClassImpl
