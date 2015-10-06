/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.EnumerationLiteralId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ClassImpl<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends MetaModelElementImpl<C, R, A> implements pamtram.metamodel.Class<C, R, A> {
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
		C container = getContainerGen();
		if (container == null && !this.isSection()) {
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
		// this was not the container, so iterate up in the containment hierarchy
		} else {
			return isContainerFor(container);
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
	public boolean isContainedIn(final C containerClass) {
		EList<C> containedClasses = new BasicEList<>();
		
		// collect all classes that are referenced by containment references
		for (R ref : containerClass.getReferences()) {
			if(!(ref.getEReference().isContainment())) {
				continue;
			}
			if(ref instanceof ContainmentReference<?,?,?>){
				containedClasses.addAll(((ContainmentReference<C,R,A>) ref).getValue());
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
	public ContainmentReference<C, R, A> getOwningContainmentReference() {
		if(this.eContainer() instanceof ContainmentReference<?,?,?>) {
			return (ContainmentReference<C,R,A>) this.eContainer();
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

			if(ref instanceof ContainmentReference<?,?,?>){
				classes.addAll(((ContainmentReference<C,R,A>) ref).getValue());
			} else if(ref instanceof MetaModelSectionReference) {
				classes.addAll((Collection<? extends C>) ((MetaModelSectionReference) ref).getValue());
			} else if(ref instanceof NonContainmentReference){
				classes.addAll(((NonContainmentReference<C,R,A>) ref).getValue());
			}
		}

		// recursively iterate over all referenced classes
		for (C clazz : classes) {
			if(clazz.equals(this) || isReferencedBy(clazz, referencedClasses)) {
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
	public boolean containerIsValid(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv containerIsValid:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[1] = if self.isSection() or self.container = null
		 *       then true
		 *       else self.container = self.oclContainer().oclContainer()
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The \'container\' refrence must point to the containing Class!'
		 *         else null
		 *         endif
		 *       in
		 *         'Class::containerIsValid'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_isSection;
		    try {
		        final /*@Thrown*/ boolean isSection = this.isSection();
		        CAUGHT_isSection = isSection;
		    }
		    catch (Exception e) {
		        CAUGHT_isSection = ValueUtil.createInvalidValue(e);
		    }
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final /*@Nullable*/ /*@Thrown*/ Object container = this.getContainer();
		        final /*@Thrown*/ boolean eq = container == null;
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_isSection, CAUGHT_eq);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Thrown*/ boolean status;
		    if (or) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@Nullable*/ /*@Thrown*/ Object container_0 = this.getContainer();
		        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, oclContainer);
		        final /*@Thrown*/ boolean eq_0 = (container_0 != null) ? container_0.equals(oclContainer_0) : (oclContainer_0 == null);
		        status = eq_0;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne) {
		    message_0 = MetamodelTables.STR_The_32_39_container_39_32_refrence_32_must_32_point_32_to_32_the_32_containing_32_Class_33;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Class_c_c_containerIsValid, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean cardinalityIsValid(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv cardinalityIsValid:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if self =
		 *         self.getContainingSection() or
		 *         self.eClass.oclType() = OclVoid
		 *       then true
		 *       else
		 *         let
		 *           parentEReference : ecore::EReference[1] = self.oclContainer()
		 *           .oclAsType(Reference(C, R, A)).eReference
		 *         in
		 *           if parentEReference.oclType() = OclVoid
		 *           then true
		 *           else
		 *             not (self.cardinality <> CardinalityType::ONE and
		 *               self.oclContainer()
		 *               .oclAsType(Reference(C, R, A))
		 *               .eReference.oclAsType(ecore::EReference).upperBound = 1
		 *             )
		 *           endif
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The cardinality of a Class must be specified as \'CardinalityType::ONE\' when the upper bound of the containing Reference is \'1\'!'
		 *         else null
		 *         endif
		 *       in
		 *         'Class::cardinalityIsValid'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = ((MetaModelElement)this).getContainingSection();
		        final /*@Thrown*/ boolean eq = this.equals(getContainingSection);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonNull*/ /*@Thrown*/ EClass eClass = this.getEClass();
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, eClass));
		        final /*@Thrown*/ boolean eq_0 = oclType.getTypeId() == TYP_OclVoid_0.getTypeId();
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Nullable*/ /*@Thrown*/ Boolean status;
		    if (or) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e_0 = idResolver.getClass(MetamodelTables.CLSSid_Reference, null);
		        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		        final /*@NonNull*/ /*@Thrown*/ Reference oclAsType = ClassUtil.nonNullState((Reference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e_0));
		        final /*@NonNull*/ /*@Thrown*/ EReference parentEReference = oclAsType.getEReference();
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_1 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, parentEReference));
		        final /*@Thrown*/ boolean eq_1 = oclType_0.getTypeId() == TYP_OclVoid_1.getTypeId();
		        /*@Nullable*/ /*@Thrown*/ Boolean symbol_0;
		        if (eq_1) {
		            symbol_0 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_ne;
		            try {
		                final /*@NonNull*/ /*@Thrown*/ Enumerator cardinality = this.getCardinality();
		                final /*@NonNull*/ /*@Thrown*/ EnumerationLiteralId BOXED_cardinality = MetamodelTables.ENUMid_CardinalityType.getEnumerationLiteralId(ClassUtil.nonNullState(cardinality.getName()));
		                final /*@Thrown*/ boolean ne = BOXED_cardinality != MetamodelTables.ELITid_ONE;
		                CAUGHT_ne = ne;
		            }
		            catch (Exception e) {
		                CAUGHT_ne = ValueUtil.createInvalidValue(e);
		            }
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_2;
		            try {
		                final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EReference_0 = idResolver.getClass(MetamodelTables.CLSSid_EReference, null);
		                final /*@NonNull*/ /*@Thrown*/ EReference eReference = oclAsType.getEReference();
		                final /*@NonNull*/ /*@Thrown*/ EReference oclAsType_1 = ClassUtil.nonNullState((EReference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference_0));
		                final /*@Nullable*/ /*@Thrown*/ Object upperBound = oclAsType_1.getUpperBound();
		                final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_upperBound = upperBound == null ? null : ValueUtil.integerValueOf(upperBound);
		                final /*@Thrown*/ boolean eq_2 = MetamodelTables.INT_1.equals(BOXED_upperBound);
		                CAUGHT_eq_2 = eq_2;
		            }
		            catch (Exception e) {
		                CAUGHT_eq_2 = ValueUtil.createInvalidValue(e);
		            }
		            final /*@Nullable*/ /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_ne, CAUGHT_eq_2);
		            final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(and);
		            symbol_0 = not;
		        }
		        status = symbol_0;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne_0 = CAUGHT_status == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne_0) {
		    message_0 = MetamodelTables.STR_The_32_cardinality_32_of_32_a_32_Class_32_must_32_be_32_specified_32_as_32_39_CardinalityType;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Class_c_c_cardinalityIsValid, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eClassMatchesParentEReference(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv eClassMatchesParentEReference:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if self =
		 *         self.getContainingSection() or
		 *         self.eClass.oclType() = OclVoid
		 *       then true
		 *       else
		 *         let
		 *           parentEReference : ecore::EReference[1] = self.oclContainer()
		 *           .oclAsType(Reference(C, R, A)).eReference
		 *         in
		 *           if parentEReference.oclType() = OclVoid
		 *           then true
		 *           else
		 *             parentEReference.oclAsType(ecore::EReference)
		 *             .eReferenceType.isSuperTypeOf(
		 *               self.eClass.oclAsType(ecore::EClass))
		 *           endif
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The eClass \'' + self.eClass.name + '\' is not allowed by the containing reference!'
		 *         else null
		 *         endif
		 *       in
		 *         'Class::eClassMatchesParentEReference'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		/*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		try {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq;
		    try {
		        final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = ((MetaModelElement)this).getContainingSection();
		        final /*@Thrown*/ boolean eq = this.equals(getContainingSection);
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_eq_0;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonNull*/ /*@Thrown*/ EClass eClass = this.getEClass();
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, eClass));
		        final /*@Thrown*/ boolean eq_0 = oclType.getTypeId() == TYP_OclVoid.getTypeId();
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Nullable*/ /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Thrown*/ boolean status;
		    if (or) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e = idResolver.getClass(MetamodelTables.CLSSid_Reference, null);
		        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		        final /*@NonNull*/ /*@Thrown*/ Reference oclAsType = ClassUtil.nonNullState((Reference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e));
		        final /*@NonNull*/ /*@Thrown*/ EReference parentEReference = oclAsType.getEReference();
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonNull*/ /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(evaluator, parentEReference));
		        final /*@Thrown*/ boolean eq_1 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();
		        /*@Thrown*/ boolean symbol_0;
		        if (eq_1) {
		            symbol_0 = ValueUtil.TRUE_VALUE;
		        }
		        else {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EClass = idResolver.getClass(MetamodelTables.CLSSid_EClass, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EReference = idResolver.getClass(MetamodelTables.CLSSid_EReference, null);
		            final /*@NonNull*/ /*@Thrown*/ EReference oclAsType_0 = ClassUtil.nonNullState((EReference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parentEReference, TYP_ecore_c_c_EReference));
		            @SuppressWarnings("null")
		            final /*@NonNull*/ /*@Thrown*/ EClass eReferenceType = oclAsType_0.getEReferenceType();
		            final /*@NonNull*/ /*@Thrown*/ EClass eClass_0 = this.getEClass();
		            final /*@NonNull*/ /*@Thrown*/ EClass oclAsType_1 = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eClass_0, TYP_ecore_c_c_EClass));
		            final /*@Thrown*/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(oclAsType_1);
		            symbol_0 = isSuperTypeOf;
		        }
		        status = symbol_0;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@Nullable*/ /*@NonInvalid*/ String message_0;
		if (ne) {
		    final /*@NonNull*/ /*@Thrown*/ EClass eClass_1 = this.getEClass();
		    final /*@Nullable*/ /*@Thrown*/ String name = eClass_1.getName();
		    final /*@NonNull*/ /*@NonInvalid*/ String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(MetamodelTables.STR_The_32_eClass_32_39, name));
		    final /*@NonNull*/ /*@NonInvalid*/ String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, MetamodelTables.STR__39_32_is_32_not_32_allowed_32_by_32_the_32_containing_32_reference_33));
		    message_0 = sum_0;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Class_c_c_eClassMatchesParentEReference, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		return Boolean.TRUE == logDiagnostic;
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
			case MetamodelPackage.CLASS___IS_SECTION:
				return isSection();
			case MetamodelPackage.CLASS___IS_CONTAINED_IN__CLASS:
				return isContainedIn((C)arguments.get(0));
			case MetamodelPackage.CLASS___GET_OWNING_CONTAINMENT_REFERENCE:
				return getOwningContainmentReference();
			case MetamodelPackage.CLASS___IS_REFERENCED_BY__CLASS_ELIST:
				return isReferencedBy((C)arguments.get(0), (EList<C>)arguments.get(1));
			case MetamodelPackage.CLASS___CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP_1:
				return containerIsValid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MetamodelPackage.CLASS___CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP_1:
				return cardinalityIsValid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MetamodelPackage.CLASS___ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP_1:
				return eClassMatchesParentEReference((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
