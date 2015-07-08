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
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
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
	 * @generated
	 */
	public boolean containerIsValid(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv containerIsValid:
		 *   let severity : Integer[1] = 'Class::containerIsValid'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[1] = if self.isSection() or self.container = null
		 *         then true
		 *         else self.container = self.oclContainer().oclContainer()
		 *         endif
		 *       in
		 *         'Class::containerIsValid'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MetamodelTables.STR_Class_c_c_containerIsValid));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MetamodelTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
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
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Class_c_c_containerIsValid, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean cardinalityIsValid(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv cardinalityIsValid:
		 *   let severity : Integer[1] = 'Class::cardinalityIsValid'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = if self <> self.getContainingSection()
		 *         then
		 *           not (self.cardinality <> CardinalityType::ONE and
		 *             self.oclContainer()
		 *             .oclAsType(Reference(C, R, A))
		 *             .eReference.oclAsType(ecore::EReference).upperBound <= 1
		 *           )
		 *         else true
		 *         endif
		 *       in
		 *         'Class::cardinalityIsValid'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MetamodelTables.STR_Class_c_c_cardinalityIsValid));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MetamodelTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@Nullable*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = ((MetaModelElement)this).getContainingSection();
		        final /*@Thrown*/ boolean ne = !this.equals(getContainingSection);
		        /*@Nullable*/ /*@Thrown*/ Boolean status;
		        if (ne) {
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_ne_0;
		            try {
		                final /*@NonNull*/ /*@Thrown*/ Enumerator cardinality = this.getCardinality();
		                final /*@NonNull*/ /*@Thrown*/ EnumerationLiteralId BOXED_cardinality = MetamodelTables.ENUMid_CardinalityType.getEnumerationLiteralId(ClassUtil.nonNullState(cardinality.getName()));
		                final /*@Thrown*/ boolean ne_0 = BOXED_cardinality != MetamodelTables.ELITid_ONE;
		                CAUGHT_ne_0 = ne_0;
		            }
		            catch (Exception e) {
		                CAUGHT_ne_0 = ValueUtil.createInvalidValue(e);
		            }
		            /*@NonNull*/ /*@Caught*/ Object CAUGHT_le_0;
		            try {
		                final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EReference_0 = idResolver.getClass(MetamodelTables.CLSSid_EReference, null);
		                final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e_0 = idResolver.getClass(MetamodelTables.CLSSid_Reference, null);
		                final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		                final /*@NonNull*/ /*@Thrown*/ Reference oclAsType = ClassUtil.nonNullState((Reference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e_0));
		                final /*@NonNull*/ /*@Thrown*/ EReference eReference = oclAsType.getEReference();
		                final /*@NonNull*/ /*@Thrown*/ EReference oclAsType_0 = ClassUtil.nonNullState((EReference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference_0));
		                final /*@Nullable*/ /*@Thrown*/ Object upperBound = oclAsType_0.getUpperBound();
		                final /*@Nullable*/ /*@Thrown*/ IntegerValue BOXED_upperBound = upperBound == null ? null : ValueUtil.integerValueOf(upperBound);
		                final /*@Thrown*/ boolean le_0 = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, BOXED_upperBound, MetamodelTables.INT_1).booleanValue());
		                CAUGHT_le_0 = le_0;
		            }
		            catch (Exception e) {
		                CAUGHT_le_0 = ValueUtil.createInvalidValue(e);
		            }
		            final /*@Nullable*/ /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_ne_0, CAUGHT_le_0);
		            final /*@Nullable*/ /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(and);
		            status = not;
		        }
		        else {
		            status = ValueUtil.TRUE_VALUE;
		        }
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Class_c_c_cardinalityIsValid, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eClassMatchesParentEReference(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv eClassMatchesParentEReference:
		 *   let
		 *     severity : Integer[1] = 'Class::eClassMatchesParentEReference'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = if self <> self.getContainingSection()
		 *         then
		 *           self.oclContainer()
		 *           .oclAsType(Reference(C, R, A))
		 *           .eReference.oclAsType(ecore::EReference)
		 *           .eReferenceType.isSuperTypeOf(
		 *             self.eClass.oclAsType(ecore::EClass))
		 *         else true
		 *         endif
		 *       in
		 *         'Class::eClassMatchesParentEReference'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MetamodelTables.STR_Class_c_c_eClassMatchesParentEReference));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MetamodelTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@Thrown*/ Object getContainingSection = ((MetaModelElement)this).getContainingSection();
		        final /*@Thrown*/ boolean ne = !this.equals(getContainingSection);
		        /*@Thrown*/ boolean status;
		        if (ne) {
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EClass = idResolver.getClass(MetamodelTables.CLSSid_EClass, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EReference = idResolver.getClass(MetamodelTables.CLSSid_EReference, null);
		            final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e = idResolver.getClass(MetamodelTables.CLSSid_Reference, null);
		            final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		            final /*@NonNull*/ /*@Thrown*/ Reference oclAsType = ClassUtil.nonNullState((Reference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e));
		            final /*@NonNull*/ /*@Thrown*/ EReference eReference = oclAsType.getEReference();
		            final /*@NonNull*/ /*@Thrown*/ EReference oclAsType_0 = ClassUtil.nonNullState((EReference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference));
		            @SuppressWarnings("null")
		            final /*@NonNull*/ /*@Thrown*/ EClass eReferenceType = oclAsType_0.getEReferenceType();
		            final /*@NonNull*/ /*@Thrown*/ EClass eClass = this.getEClass();
		            final /*@NonNull*/ /*@Thrown*/ EClass oclAsType_1 = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eClass, TYP_ecore_c_c_EClass));
		            final /*@Thrown*/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(oclAsType_1);
		            status = isSuperTypeOf;
		        }
		        else {
		            status = ValueUtil.TRUE_VALUE;
		        }
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MetamodelTables.STR_Class_c_c_eClassMatchesParentEReference, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MetamodelTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
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
			case MetamodelPackage.CLASS___CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP_2:
				return containerIsValid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MetamodelPackage.CLASS___CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP_2:
				return cardinalityIsValid((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case MetamodelPackage.CLASS___ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP_2:
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
