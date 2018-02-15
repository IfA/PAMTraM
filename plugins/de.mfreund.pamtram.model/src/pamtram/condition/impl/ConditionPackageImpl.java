/**
 */
package pamtram.condition.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import pamtram.PamtramPackage;
import pamtram.condition.And;
import pamtram.condition.ApplicationDependency;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ComparatorEnum;
import pamtram.condition.ComplexCondition;
import pamtram.condition.Condition;
import pamtram.condition.ConditionFactory;
import pamtram.condition.ConditionPackage;
import pamtram.condition.VariadicCondition;
import pamtram.condition.Not;
import pamtram.condition.Or;
import pamtram.condition.CardinalityCondition;
import pamtram.condition.UnaryCondition;
import pamtram.condition.util.ConditionValidator;
import pamtram.impl.PamtramPackageImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.impl.ExtendedPackageImpl;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.impl.ModifierPackageImpl;
import pamtram.structure.StructurePackage;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.impl.ConstraintPackageImpl;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.GenericPackageImpl;
import pamtram.structure.impl.StructurePackageImpl;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.library.impl.LibraryPackageImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.impl.SourcePackageImpl;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.impl.TargetPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConditionPackageImpl extends EPackageImpl implements ConditionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variadicConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum comparatorEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see pamtram.condition.ConditionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConditionPackageImpl() {
		super(eNS_URI, ConditionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ConditionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConditionPackage init() {
		if (isInited) return (ConditionPackage)EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI);

		// Obtain or create and register package
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConditionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) : GenericPackage.eINSTANCE);
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) : ConstraintPackage.eINSTANCE);
		SourcePackageImpl theSourcePackage = (SourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) instanceof SourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) : SourcePackage.eINSTANCE);
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) : TargetPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		theConditionPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		theConditionPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		theExtendedPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theConditionPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ConditionValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theConditionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConditionPackage.eNS_URI, theConditionPackage);
		return theConditionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexCondition() {
		return complexConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexCondition__IsLocalCondition() {
		return complexConditionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexCondition__IsExternalCondition() {
		return complexConditionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexCondition__IsGlobalCondition() {
		return complexConditionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexCondition__IsMappingCondition() {
		return complexConditionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexCondition__IsConditionModelCondition() {
		return complexConditionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexCondition__GetConditionPartsFlat() {
		return complexConditionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCondition_Comparator() {
		return (EAttribute)conditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_Target() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_InstanceSelectors() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCondition__CheckCondition__ComplexCondition() {
		return conditionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariadicCondition() {
		return variadicConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariadicCondition_LocalCondParts() {
		return (EReference)variadicConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariadicCondition_SharedCondParts() {
		return (EReference)variadicConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVariadicCondition__ReferencesOnlyValidConditions() {
		return variadicConditionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVariadicCondition__ValidateMinimalNumberOfArgs__DiagnosticChain_Map() {
		return variadicConditionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVariadicCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map() {
		return variadicConditionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCondition_Value() {
		return (EAttribute)conditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryCondition() {
		return unaryConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryCondition_LocalCondPart() {
		return (EReference)unaryConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryCondition_SharedCondPart() {
		return (EReference)unaryConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnaryCondition__ValidateExactlyOneArg__DiagnosticChain_Map() {
		return unaryConditionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getUnaryCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map() {
		return unaryConditionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNot() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCondition() {
		return attributeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeCondition_ValueConstraints() {
		return (EReference)attributeConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeCondition__ValidateFollowExternalReferencesTrueIfRequired__DiagnosticChain_Map() {
		return attributeConditionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityCondition() {
		return cardinalityConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityCondition__ValidateReferenceMatchSpecPresentInCaseOfAmbiguousSource__DiagnosticChain_Map() {
		return cardinalityConditionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationDependency() {
		return applicationDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getComparatorEnum() {
		return comparatorEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionFactory getConditionFactory() {
		return (ConditionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		complexConditionEClass = createEClass(COMPLEX_CONDITION);
		createEOperation(complexConditionEClass, COMPLEX_CONDITION___IS_LOCAL_CONDITION);
		createEOperation(complexConditionEClass, COMPLEX_CONDITION___IS_EXTERNAL_CONDITION);
		createEOperation(complexConditionEClass, COMPLEX_CONDITION___IS_GLOBAL_CONDITION);
		createEOperation(complexConditionEClass, COMPLEX_CONDITION___IS_MAPPING_CONDITION);
		createEOperation(complexConditionEClass, COMPLEX_CONDITION___IS_CONDITION_MODEL_CONDITION);
		createEOperation(complexConditionEClass, COMPLEX_CONDITION___GET_CONDITION_PARTS_FLAT);

		variadicConditionEClass = createEClass(VARIADIC_CONDITION);
		createEReference(variadicConditionEClass, VARIADIC_CONDITION__LOCAL_COND_PARTS);
		createEReference(variadicConditionEClass, VARIADIC_CONDITION__SHARED_COND_PARTS);
		createEOperation(variadicConditionEClass, VARIADIC_CONDITION___REFERENCES_ONLY_VALID_CONDITIONS);
		createEOperation(variadicConditionEClass, VARIADIC_CONDITION___VALIDATE_MINIMAL_NUMBER_OF_ARGS__DIAGNOSTICCHAIN_MAP);
		createEOperation(variadicConditionEClass, VARIADIC_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);

		andEClass = createEClass(AND);

		orEClass = createEClass(OR);

		unaryConditionEClass = createEClass(UNARY_CONDITION);
		createEReference(unaryConditionEClass, UNARY_CONDITION__LOCAL_COND_PART);
		createEReference(unaryConditionEClass, UNARY_CONDITION__SHARED_COND_PART);
		createEOperation(unaryConditionEClass, UNARY_CONDITION___VALIDATE_EXACTLY_ONE_ARG__DIAGNOSTICCHAIN_MAP);
		createEOperation(unaryConditionEClass, UNARY_CONDITION___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);

		notEClass = createEClass(NOT);

		conditionEClass = createEClass(CONDITION);
		createEAttribute(conditionEClass, CONDITION__VALUE);
		createEAttribute(conditionEClass, CONDITION__COMPARATOR);
		createEReference(conditionEClass, CONDITION__TARGET);
		createEReference(conditionEClass, CONDITION__INSTANCE_SELECTORS);
		createEOperation(conditionEClass, CONDITION___CHECK_CONDITION__COMPLEXCONDITION);

		attributeConditionEClass = createEClass(ATTRIBUTE_CONDITION);
		createEReference(attributeConditionEClass, ATTRIBUTE_CONDITION__VALUE_CONSTRAINTS);
		createEOperation(attributeConditionEClass, ATTRIBUTE_CONDITION___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP);

		cardinalityConditionEClass = createEClass(CARDINALITY_CONDITION);
		createEOperation(cardinalityConditionEClass, CARDINALITY_CONDITION___VALIDATE_REFERENCE_MATCH_SPEC_PRESENT_IN_CASE_OF_AMBIGUOUS_SOURCE__DIAGNOSTICCHAIN_MAP);

		applicationDependencyEClass = createEClass(APPLICATION_DEPENDENCY);

		// Create enums
		comparatorEnumEEnum = createEEnum(COMPARATOR_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		StructurePackage theStructurePackage = (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);
		ConstraintPackage theConstraintPackage = (ConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI);
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);

		// Create type parameters
		ETypeParameter conditionEClass_TargetType = addETypeParameter(conditionEClass, "TargetType");

		// Set bounds for type parameters

		// Add supertypes to classes
		complexConditionEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		variadicConditionEClass.getESuperTypes().add(this.getComplexCondition());
		andEClass.getESuperTypes().add(this.getVariadicCondition());
		orEClass.getESuperTypes().add(this.getVariadicCondition());
		unaryConditionEClass.getESuperTypes().add(this.getComplexCondition());
		notEClass.getESuperTypes().add(this.getUnaryCondition());
		conditionEClass.getESuperTypes().add(this.getComplexCondition());
		EGenericType g1 = createEGenericType(this.getCondition());
		EGenericType g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeConditionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(thePamtramPackage.getMatchSpecElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeConditionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCondition());
		g2 = createEGenericType(theGenericPackage.getMetaModelElement());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(theSourcePackage.getSourceSection());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g2.getETypeArguments().add(g3);
		cardinalityConditionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(thePamtramPackage.getMatchSpecElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		cardinalityConditionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCondition());
		g2 = createEGenericType(thePamtramPackage.getConditionalElement());
		g1.getETypeArguments().add(g2);
		applicationDependencyEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(complexConditionEClass, ComplexCondition.class, "ComplexCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getComplexCondition__IsLocalCondition(), ecorePackage.getEBoolean(), "isLocalCondition", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComplexCondition__IsExternalCondition(), ecorePackage.getEBoolean(), "isExternalCondition", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComplexCondition__IsGlobalCondition(), ecorePackage.getEBoolean(), "isGlobalCondition", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComplexCondition__IsMappingCondition(), ecorePackage.getEBoolean(), "isMappingCondition", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComplexCondition__IsConditionModelCondition(), ecorePackage.getEBoolean(), "isConditionModelCondition", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComplexCondition__GetConditionPartsFlat(), this.getComplexCondition(), "getConditionPartsFlat", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(variadicConditionEClass, VariadicCondition.class, "VariadicCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariadicCondition_LocalCondParts(), this.getComplexCondition(), null, "localCondParts", null, 0, -1, VariadicCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariadicCondition_SharedCondParts(), this.getComplexCondition(), null, "sharedCondParts", null, 0, -1, VariadicCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getVariadicCondition__ReferencesOnlyValidConditions(), ecorePackage.getEBoolean(), "referencesOnlyValidConditions", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getVariadicCondition__ValidateMinimalNumberOfArgs__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateMinimalNumberOfArgs", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getVariadicCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateReferenceOnlyConditionsFromConditionModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryConditionEClass, UnaryCondition.class, "UnaryCondition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryCondition_LocalCondPart(), this.getComplexCondition(), null, "localCondPart", null, 0, 1, UnaryCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryCondition_SharedCondPart(), this.getComplexCondition(), null, "sharedCondPart", null, 0, 1, UnaryCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getUnaryCondition__ValidateExactlyOneArg__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateExactlyOneArg", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getUnaryCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateReferenceOnlyConditionsFromConditionModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionEClass, Condition.class, "Condition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCondition_Value(), ecorePackage.getEInt(), "value", "1", 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCondition_Comparator(), this.getComparatorEnum(), "comparator", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(conditionEClass_TargetType);
		initEReference(getCondition_Target(), g1, null, "target", null, 1, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_InstanceSelectors(), theStructurePackage.getSourceInstanceSelector(), null, "instanceSelectors", null, 0, -1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCondition__CheckCondition__ComplexCondition(), ecorePackage.getEBoolean(), "checkCondition", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getComplexCondition(), "condition", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeConditionEClass, AttributeCondition.class, "AttributeCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeCondition_ValueConstraints(), theConstraintPackage.getValueConstraint(), null, "valueConstraints", null, 1, -1, AttributeCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAttributeCondition__ValidateFollowExternalReferencesTrueIfRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateFollowExternalReferencesTrueIfRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(cardinalityConditionEClass, CardinalityCondition.class, "CardinalityCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getCardinalityCondition__ValidateReferenceMatchSpecPresentInCaseOfAmbiguousSource__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateReferenceMatchSpecPresentInCaseOfAmbiguousSource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(applicationDependencyEClass, ApplicationDependency.class, "ApplicationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(comparatorEnumEEnum, ComparatorEnum.class, "ComparatorEnum");
		addEEnumLiteral(comparatorEnumEEnum, ComparatorEnum.EQ);
		addEEnumLiteral(comparatorEnumEEnum, ComparatorEnum.GT);
		addEEnumLiteral(comparatorEnumEEnum, ComparatorEnum.LT);
		addEEnumLiteral(comparatorEnumEEnum, ComparatorEnum.GE);
		addEEnumLiteral(comparatorEnumEEnum, ComparatorEnum.LE);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (variadicConditionEClass, 
		   source, 
		   new String[] {
			 "constraints", "minimalNumberOfArgs"
		   });	
		addAnnotation
		  (unaryConditionEClass, 
		   source, 
		   new String[] {
			 "constraints", "exactlyOneArg"
		   });	
		addAnnotation
		  (notEClass, 
		   source, 
		   new String[] {
			 "constraints", "referenceOnlyConditionsFromConditionModelOrFromConditionalElements"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			 "genlib", "http://www.et.tu-dresden.de/ifa/agtele/genlib"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "This package contains all elements related to the description of Conditions. These can e.g. be used to restrict the applicability of a Mapping."
		   });	
		addAnnotation
		  (complexConditionEClass, 
		   source, 
		   new String[] {
			 "documentation", "The super type for all specific Condition types."
		   });	
		addAnnotation
		  (getComplexCondition__IsMappingCondition(), 
		   source, 
		   new String[] {
			 "body", "return getRootCondition().eContainer() instanceof Mapping;"
		   });	
		addAnnotation
		  (getComplexCondition__IsConditionModelCondition(), 
		   source, 
		   new String[] {
			 "body", "return getRootCondition().eContainer() instanceof ConditionModel;"
		   });	
		addAnnotation
		  (variadicConditionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A Condition that is composed of multiple sub-conditions.\r\n<br />\r\nThe sub-conditions can be specified locally (via the \'localCondParts\' reference) and/or globally (specified via the \'sharedCondParts\' reference)."
		   });	
		addAnnotation
		  (getVariadicCondition__ReferencesOnlyValidConditions(), 
		   source, 
		   new String[] {
			 "body", "if(this.sharedCondParts == null || this.sharedCondParts.size() == 0) {\r\n\treturn true;\r\n}\r\nEList<ComplexCondition> conditionRefs = new BasicEList<ComplexCondition>();\r\nconditionRefs.add((ComplexCondition) this.sharedCondParts);\r\nfor(ComplexCondition condition : conditionRefs){\r\n\tif(!(condition instanceof ConditionModel)){\r\n\t\treturn false;\r\n\t}\r\n}\r\nreturn true;"
		   });	
		addAnnotation
		  (getVariadicCondition__ValidateMinimalNumberOfArgs__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getLocalCondParts().size() + this.getSharedCondParts().size() > 1;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"At least two (local or shared) condition parts need to be specified!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.VARIADIC_CONDITION__VALIDATE_MINIMAL_NUMBER_OF_ARGS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.VARIADIC_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getVariadicCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (this.getSharedCondParts() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSharedCondParts().stream().allMatch(c -> c.eContainer() instanceof <%pamtram.ConditionModel%>);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Reference only Conditions that are placed inside a ConditionModel!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tConditionValidator.VARIADIC_CONDITION__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,\r\n\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.VARIADIC_CONDITION__SHARED_COND_PARTS }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getVariadicCondition_LocalCondParts(), 
		   source, 
		   new String[] {
			 "documentation", "The list of locally defined sub-conditions."
		   });	
		addAnnotation
		  (getVariadicCondition_SharedCondParts(), 
		   source, 
		   new String[] {
			 "documentation", "The list of globally specified sub-conditions.",
			 "propertyDescriptor", "\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tgetResourceLocator(), getString(\"_UI_VariadicCondition_sharedCondParts_feature\"),\r\n\t\t\t\tgetString(\"_UI_VariadicCondition_sharedCondParts_description\"),\r\n\t\t\t\t<%pamtram.condition.ConditionPackage%>.Literals.VARIADIC_CONDITION__SHARED_COND_PARTS, true, false, true, null,\r\n\t\t\t\tgetString(\"_UI_ExtendedPropertyCategory\"), null) {\r\n\r\n\t\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t<%java.util.List%><Object> choiceOfValues = new <%java.util.ArrayList%><>();\r\n\t\t\t\tchoiceOfValues.addAll(super.getChoiceOfValues(object));\r\n\t\t\t\tfor (<%java.util.Iterator%><Object> element = choiceOfValues.iterator(); element.hasNext();) {\r\n\t\t\t\t\t<%org.eclipse.emf.ecore.EObject%> choiceValue = (EObject) element.next();\r\n\t\t\t\t\tif (choiceValue == null) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\t\t\t\t\tif (!(choiceValue.eContainer() instanceof <%pamtram.ConditionModel%>)) {\r\n\t\t\t\t\t\telement.remove();\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\treturn choiceOfValues;\r\n\t\t\t}\r\n\t\t});"
		   });	
		addAnnotation
		  (andEClass, 
		   source, 
		   new String[] {
			 "documentation", "A Condition that evaluates to \'true\' only if ALL specified sub-conditions evaluate to \'true\'.\r\n<br />\r\nThe sub-conditions can be specified locally (via the \'localCondParts\' reference) and/or globally (specified via the \'sharedCondParts\' reference)."
		   });	
		addAnnotation
		  (orEClass, 
		   source, 
		   new String[] {
			 "documentation", "A Condition that evaluates to \'true\' if AT LEAST ONE of the specified sub-conditions evaluates to \'true\'.\r\n<br />\r\nThe sub-conditions can be specified locally (via the \'localCondParts\' reference) and/or globally (specified via the \'sharedCondParts\' reference)."
		   });	
		addAnnotation
		  (unaryConditionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A Condition that is composed of exactly one sub-condition.\r\n<br />\r\nThe sub-condition can be specified locally (via the \'localCondPart\' reference) or globally (specified via the \'sharedCondPart\' reference)."
		   });	
		addAnnotation
		  (getUnaryCondition__ValidateExactlyOneArg__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getLocalCondPart() != null ^ this.getSharedCondPart() != null;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Please specify exactly one (local or shared) condition part!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.UNARY_CONDITION__VALIDATE_EXACTLY_ONE_ARG,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.UNARY_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getUnaryCondition__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(this.sharedCondPart == null) {\r\n\treturn true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EObject%> sharedCondPartContainer = this.sharedCondPart.eContainer();\r\n\r\nboolean result = sharedCondPartContainer instanceof <%pamtram.ConditionModel%>;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Reference only Conditions that are placed inside a ConditionModel!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.UNARY_CONDITION__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.UNARY_CONDITION__SHARED_COND_PART }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getUnaryCondition_LocalCondPart(), 
		   source, 
		   new String[] {
			 "documentation", "The locally defined sub-condition.\r\n<br /><br />\r\nNote: Only one of \'localCondPart\' or \'sharedCondPart\' may be set!"
		   });	
		addAnnotation
		  (getUnaryCondition_SharedCondPart(), 
		   source, 
		   new String[] {
			 "documentation", "The globally specified sub-condition.\r\n<br /><br />\r\nNote: Only one of \'localCondPart\' or \'sharedCondPart\' may be set!",
			 "propertyDescriptor", "\r\nthis.itemPropertyDescriptors.add(\r\n\t\tnew ItemPropertyDescriptor(((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) this.adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_UnaryCondition_sharedCondPart_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_UnaryCondition_sharedCondPart_description\"),\r\n\t\t\t\t<%pamtram.condition.ConditionPackage%>.Literals.UNARY_CONDITION__SHARED_COND_PART, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_ExtendedPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t<%java.util.List%><Object> choiceOfValues = new <%java.util.ArrayList%><>();\r\n\t\t\t\tchoiceOfValues.addAll(super.getChoiceOfValues(object));\r\n\t\t\t\tfor (<%java.util.Iterator%><Object> element = choiceOfValues.iterator(); element.hasNext();) {\r\n\t\t\t\t\t<%org.eclipse.emf.ecore.EObject%> choiceValue = (EObject) element.next();\r\n\t\t\t\t\tif (choiceValue == null) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\t\t\t\t\tif (!(choiceValue.eContainer() instanceof <%pamtram.ConditionModel%>)) {\r\n\t\t\t\t\t\telement.remove();\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\treturn choiceOfValues;\r\n\t\t\t}\r\n\t\t});"
		   });	
		addAnnotation
		  (notEClass, 
		   source, 
		   new String[] {
			 "documentation", "A Condition that evaluates to \'true\' if the specified sub-condition evaluates to \'false\'.\r\n<br />\r\nThe sub-condition can be specified locally (via the \'localCondPart\' reference) or globally (specified via the \'sharedCondPart\' reference)."
		   });	
		addAnnotation
		  (conditionEClass, 
		   source, 
		   new String[] {
			 "documentation", "The super type for all Condition types that are not only simple logical compositions of sub-conditions."
		   });	
		addAnnotation
		  (getCondition_Value(), 
		   source, 
		   new String[] {
			 "documentation", "Together with the defined \'comparator\', this specifies how often/for how many of the elements matched for the specified \'target\' element this Condition needs to be fulfilled.\r\n<br /><br />\r\nFor example, if \'value\' is set to \'1\' and \'comparator is set to \'GE\', the condition needs to be fulfilled at least once."
		   });	
		addAnnotation
		  (getCondition_Comparator(), 
		   source, 
		   new String[] {
			 "documentation", "Together with the defined \'value\', this specifies how often/for how many of the elements matched for the specified \'target\' element this Condition needs to be fulfilled.\r\n<br /><br />\r\nFor example, if \'value\' is set to \'1\' and \'comparator is set to \'GE\', the condition needs to be fulfilled at least once."
		   });	
		addAnnotation
		  (getCondition_Target(), 
		   source, 
		   new String[] {
			 "documentation", "The element on which this condition is evaluated.\r\n<br /><br />\r\nNote: As the specified \'target\' element may be matched multiple times in a source model, additional restrictions on how often this condition should be met may be specified via the \'value\' and \'comparator\' attributes."
		   });	
		addAnnotation
		  (getCondition_InstanceSelectors(), 
		   source, 
		   new String[] {
			 "documentation", "A list of InstanceSelectors that can be used to restrict the application of this condition: \r\n<br />\r\nThe specified \'target\' element may be matched multiple times in a source model. However, the Condition will only evaluated for those matches that are identified by the specified list of InstanceSelectors."
		   });	
		addAnnotation
		  (comparatorEnumEEnum, 
		   source, 
		   new String[] {
			 "documentation", "This specifies how two values shall be compared."
		   });	
		addAnnotation
		  (comparatorEnumEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "The value to be checked needs to be equal to the reference value."
		   });	
		addAnnotation
		  (comparatorEnumEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The value to be checked needs to be greater than the reference value."
		   });	
		addAnnotation
		  (comparatorEnumEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "The value to be checked needs to be less than the reference value."
		   });	
		addAnnotation
		  (comparatorEnumEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "The value to be checked needs to be greater than or equal to the reference value."
		   });	
		addAnnotation
		  (comparatorEnumEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "The value to be checked needs to be less than or equal to the reference value."
		   });	
		addAnnotation
		  (attributeConditionEClass, 
		   source, 
		   new String[] {
			 "documentation", "This condition can be used to check the value of an Attribute."
		   });	
		addAnnotation
		  (getAttributeCondition__ValidateFollowExternalReferencesTrueIfRequired__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (this.target == null || !this.isMappingCondition()\r\n\t\t|| ((<%pamtram.mapping.Mapping%>) this.getRootCondition().eContainer()).getSourceSection() == null\r\n\t\t|| this.followExternalReferences) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.source.SourceSection%> sourceSection = ((Mapping) this.getRootCondition().eContainer()).getSourceSection();\r\n\r\nboolean result = true;\r\nString errorMessage = \"\";\r\n\r\nif (this.isLocalCondition() && !sourceSection.equals(this.target.getContainingSection())\r\n\t\t&& !sourceSection.getAllExtend().contains(this.target.getContainingSection())) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The target Attribute is not part of the SourceSection specified by this Mapping. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n} else if (this.getReferenceMatchSpec().parallelStream()\r\n\t\t.anyMatch(r -> !r.getContainingSection().equals(sourceSection))) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The specified Reference Match Spec contains Cross References. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tConditionValidator.ATTRIBUTE_CONDITION__VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED,\r\n\t\t\terrorMessage, new Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.CONDITION__TARGET }));\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getAttributeCondition_ValueConstraints(), 
		   source, 
		   new String[] {
			 "documentation", "A list of ValueConstraints that specify a single reference value or a list/range of reference values which the value of the \'target\' Attribute must or must not satisfy.\r\n<br /><br />\r\nA certain attribute (value) in a source model will only match against the specified \'target\' Attribute if all specified constraints are met."
		   });	
		addAnnotation
		  (cardinalityConditionEClass, 
		   source, 
		   new String[] {
			 "documentation", "This condition can be used to check the cardinality of an element (a Class, an Attribute, or a Reference inside a SourceSection), i.e. how often this element can be found in the current source model excerpt."
		   });	
		addAnnotation
		  (getCardinalityCondition__ValidateReferenceMatchSpecPresentInCaseOfAmbiguousSource__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (this.target == null || !this.isMappingCondition()\r\n\t\t|| ((<%pamtram.mapping.Mapping%>) this.getRootCondition().eContainer()).getSourceSection() == null\r\n\t\t|| this.followExternalReferences) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.source.SourceSection%> sourceSection = ((Mapping) this.getRootCondition().eContainer()).getSourceSection();\r\n\r\nboolean result = true;\r\nString errorMessage = \"\";\r\n\r\nif (this.isLocalCondition() && !sourceSection.equals(this.target.getContainingSection())\r\n\t\t&& !sourceSection.getAllExtend().contains(this.target.getContainingSection())) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The target Class is not part of the SourceSection specified by this Mapping. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n} else if (this.getReferenceMatchSpec().parallelStream()\r\n\t\t.anyMatch(r -> !r.getContainingSection().equals(sourceSection))) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The specified Reference Match Spec contains Cross References. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.condition.util.ConditionValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tConditionValidator.CARDINALITY_CONDITION__VALIDATE_REFERENCE_MATCH_SPEC_PRESENT_IN_CASE_OF_AMBIGUOUS_SOURCE,\r\n\t\t\terrorMessage, new Object[] { this, <%pamtram.condition.ConditionPackage%>.Literals.CONDITION__TARGET }));\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (applicationDependencyEClass, 
		   source, 
		   new String[] {
			 "documentation", "A condition that allows to check whether another \'ConditionalElement\' was applied/executed a certain number of times.\r\n<br /><br />\r\nThis can e.g. be used to create dependencies between mappings like \"Only execute this mapping, if another mapping was applied for a certain part of a source model\".\r\n"
		   });
	}

} //ConditionPackageImpl
