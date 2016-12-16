/**
 */
package pamtram.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.MappingModel;
import pamtram.NamedElement;
import pamtram.PAMTraM;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.condition.ConditionPackage;
import pamtram.condition.impl.ConditionPackageImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.GenericPackageImpl;
import pamtram.structure.impl.StructurePackageImpl;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PamtramPackageImpl extends EPackageImpl implements PamtramPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deactivatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pamTraMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionModelEClass = null;

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
	 * @see pamtram.PamtramPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PamtramPackageImpl() {
		super(eNS_URI, PamtramFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PamtramPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PamtramPackage init() {
		if (isInited) return (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);

		// Obtain or create and register package
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PamtramPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) : GenericPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);

		// Create package meta-data objects
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(thePamtramPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return PamtramValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		thePamtramPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PamtramPackage.eNS_URI, thePamtramPackage);
		return thePamtramPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeactivatableElement() {
		return deactivatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeactivatableElement_Deactivated() {
		return (EAttribute)deactivatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPAMTraM() {
		return pamTraMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SourceSectionModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SharedSourceSectionModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_TargetSectionModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SharedTargetSectionModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_MappingModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SourceSections() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_TargetSections() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_Mappings() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_ActiveMappings() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_GlobalValues() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_ModifierSets() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_ConditionModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPAMTraM__MergeExtends() {
		return pamTraMEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSectionModel() {
		return sectionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSectionModel_MetaModelPackage() {
		return (EReference)sectionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSectionModel_MetaModelSections() {
		return (EReference)sectionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionModel() {
		return sourceSectionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionModel() {
		return targetSectionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetSectionModel_LibraryElements() {
		return (EReference)targetSectionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingModel() {
		return mappingModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModel_Mapping() {
		return (EReference)mappingModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModel_ModifierSets() {
		return (EReference)mappingModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModel_GlobalValues() {
		return (EReference)mappingModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModel_ActiveMappings() {
		return (EReference)mappingModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalElement() {
		return conditionalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalElement_LocalCondition() {
		return (EReference)conditionalElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalElement_SharedCondition() {
		return (EReference)conditionalElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalElement__ValidateEitherModelOrReferCondition__DiagnosticChain_Map() {
		return conditionalElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getConditionalElement__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map() {
		return conditionalElementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionModel() {
		return conditionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionModel_Condition() {
		return (EReference)conditionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PamtramFactory getPamtramFactory() {
		return (PamtramFactory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		deactivatableElementEClass = createEClass(DEACTIVATABLE_ELEMENT);
		createEAttribute(deactivatableElementEClass, DEACTIVATABLE_ELEMENT__DEACTIVATED);

		pamTraMEClass = createEClass(PAM_TRA_M);
		createEReference(pamTraMEClass, PAM_TRA_M__SOURCE_SECTION_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__TARGET_SECTION_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__SHARED_TARGET_SECTION_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__MAPPING_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__SOURCE_SECTIONS);
		createEReference(pamTraMEClass, PAM_TRA_M__TARGET_SECTIONS);
		createEReference(pamTraMEClass, PAM_TRA_M__MAPPINGS);
		createEReference(pamTraMEClass, PAM_TRA_M__ACTIVE_MAPPINGS);
		createEReference(pamTraMEClass, PAM_TRA_M__GLOBAL_VALUES);
		createEReference(pamTraMEClass, PAM_TRA_M__MODIFIER_SETS);
		createEReference(pamTraMEClass, PAM_TRA_M__CONDITION_MODEL);
		createEOperation(pamTraMEClass, PAM_TRA_M___MERGE_EXTENDS);

		sectionModelEClass = createEClass(SECTION_MODEL);
		createEReference(sectionModelEClass, SECTION_MODEL__META_MODEL_PACKAGE);
		createEReference(sectionModelEClass, SECTION_MODEL__META_MODEL_SECTIONS);

		sourceSectionModelEClass = createEClass(SOURCE_SECTION_MODEL);

		targetSectionModelEClass = createEClass(TARGET_SECTION_MODEL);
		createEReference(targetSectionModelEClass, TARGET_SECTION_MODEL__LIBRARY_ELEMENTS);

		mappingModelEClass = createEClass(MAPPING_MODEL);
		createEReference(mappingModelEClass, MAPPING_MODEL__MAPPING);
		createEReference(mappingModelEClass, MAPPING_MODEL__MODIFIER_SETS);
		createEReference(mappingModelEClass, MAPPING_MODEL__GLOBAL_VALUES);
		createEReference(mappingModelEClass, MAPPING_MODEL__ACTIVE_MAPPINGS);

		conditionalElementEClass = createEClass(CONDITIONAL_ELEMENT);
		createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__LOCAL_CONDITION);
		createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__SHARED_CONDITION);
		createEOperation(conditionalElementEClass, CONDITIONAL_ELEMENT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP);
		createEOperation(conditionalElementEClass, CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);

		conditionModelEClass = createEClass(CONDITION_MODEL);
		createEReference(conditionModelEClass, CONDITION_MODEL__CONDITION);
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
		StructurePackage theStructurePackage = (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);
		ConditionPackage theConditionPackage = (ConditionPackage)EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theStructurePackage);
		getESubpackages().add(theConditionPackage);
		getESubpackages().add(theMappingPackage);

		// Create type parameters
		ETypeParameter sectionModelEClass_S = addETypeParameter(sectionModelEClass, "S");
		ETypeParameter sectionModelEClass_C = addETypeParameter(sectionModelEClass, "C");
		ETypeParameter sectionModelEClass_R = addETypeParameter(sectionModelEClass, "R");
		ETypeParameter sectionModelEClass_A = addETypeParameter(sectionModelEClass, "A");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theGenericPackage.getSection());
		EGenericType g2 = createEGenericType(sectionModelEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_A);
		g1.getETypeArguments().add(g2);
		sectionModelEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(sectionModelEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_A);
		g1.getETypeArguments().add(g2);
		sectionModelEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(sectionModelEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_A);
		g1.getETypeArguments().add(g2);
		sectionModelEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(sectionModelEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionModelEClass_A);
		g1.getETypeArguments().add(g2);
		sectionModelEClass_A.getEBounds().add(g1);

		// Add supertypes to classes
		sectionModelEClass.getESuperTypes().add(this.getNamedElement());
		g1 = createEGenericType(this.getSectionModel());
		g2 = createEGenericType(theStructurePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionModelEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSectionModel());
		g2 = createEGenericType(theStructurePackage.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionModelEClass.getEGenericSuperTypes().add(g1);
		mappingModelEClass.getESuperTypes().add(this.getNamedElement());
		mappingModelEClass.getESuperTypes().add(this.getDeactivatableElement());
		mappingModelEClass.getESuperTypes().add(this.getConditionalElement());
		conditionModelEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deactivatableElementEClass, DeactivatableElement.class, "DeactivatableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeactivatableElement_Deactivated(), ecorePackage.getEBoolean(), "deactivated", "false", 1, 1, DeactivatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pamTraMEClass, PAMTraM.class, "PAMTraM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPAMTraM_SourceSectionModel(), this.getSourceSectionModel(), null, "sourceSectionModel", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SharedSourceSectionModel(), this.getSourceSectionModel(), null, "sharedSourceSectionModel", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_TargetSectionModel(), this.getTargetSectionModel(), null, "targetSectionModel", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SharedTargetSectionModel(), this.getTargetSectionModel(), null, "sharedTargetSectionModel", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_MappingModel(), this.getMappingModel(), null, "mappingModel", null, 1, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SourceSections(), theStructurePackage.getSourceSection(), null, "sourceSections", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_TargetSections(), theStructurePackage.getTargetSection(), null, "targetSections", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_Mappings(), theMappingPackage.getMapping(), null, "mappings", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_ActiveMappings(), theMappingPackage.getMapping(), null, "activeMappings", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_GlobalValues(), theMappingPackage.getFixedValue(), null, "globalValues", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_ModifierSets(), theMappingPackage.getValueModifierSet(), null, "modifierSets", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_ConditionModel(), this.getConditionModel(), null, "conditionModel", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPAMTraM__MergeExtends(), null, "mergeExtends", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sectionModelEClass, SectionModel.class, "SectionModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSectionModel_MetaModelPackage(), ecorePackage.getEPackage(), null, "metaModelPackage", null, 1, 1, SectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(sectionModelEClass_S);
		initEReference(getSectionModel_MetaModelSections(), g1, null, "metaModelSections", null, 0, -1, SectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionModelEClass, SourceSectionModel.class, "SourceSectionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionModelEClass, TargetSectionModel.class, "TargetSectionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetSectionModel_LibraryElements(), theStructurePackage.getLibraryEntry(), null, "libraryElements", null, 0, -1, TargetSectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingModelEClass, MappingModel.class, "MappingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingModel_Mapping(), theMappingPackage.getMapping(), null, "mapping", null, 1, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_ModifierSets(), theMappingPackage.getValueModifierSet(), null, "modifierSets", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_GlobalValues(), theMappingPackage.getFixedValue(), null, "globalValues", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_ActiveMappings(), theMappingPackage.getMapping(), null, "activeMappings", null, 0, -1, MappingModel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(conditionalElementEClass, ConditionalElement.class, "ConditionalElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalElement_LocalCondition(), theConditionPackage.getComplexCondition(), null, "localCondition", null, 0, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalElement_SharedCondition(), theConditionPackage.getComplexCondition(), null, "sharedCondition", null, 0, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getConditionalElement__ValidateEitherModelOrReferCondition__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEitherModelOrReferCondition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConditionalElement__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateReferenceOnlyConditionsFromConditionModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(conditionModelEClass, ConditionModel.class, "ConditionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionModel_Condition(), theConditionPackage.getComplexCondition(), null, "condition", null, 0, -1, ConditionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
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
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (conditionalElementEClass, 
		   source, 
		   new String[] {
			 "constraints", "eitherModelOrReferCondition referenceOnlyConditionsFromConditionModel"
		   });
	}

} //PamtramPackageImpl
