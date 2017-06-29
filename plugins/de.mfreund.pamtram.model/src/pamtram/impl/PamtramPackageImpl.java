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
import pamtram.ExpressionElement;
import pamtram.FixedValue;
import pamtram.MappingModel;
import pamtram.ModifiableElement;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedValueEClass = null;

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
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) : ConstraintPackage.eINSTANCE);
		SourcePackageImpl theSourcePackage = (SourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) instanceof SourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) : SourcePackage.eINSTANCE);
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) : TargetPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		theExtendedPackage.initializePackageContents();

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
	public EReference getPAMTraM_SourceSectionModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SharedSourceSectionModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_TargetSectionModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SharedTargetSectionModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_MappingModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SharedMappingModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SourceSections() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_TargetSections() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_Mappings() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_ActiveMappings() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_GlobalValues() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_GlobalAttributes() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_ModifierSets() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_ConditionModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SharedConditionModels() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(14);
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
	public EOperation getPAMTraM__GetActiveSourceSectionModels() {
		return pamTraMEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPAMTraM__GetActiveSourceSections() {
		return pamTraMEClass.getEOperations().get(2);
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
	public EReference getSectionModel_Sections() {
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
	public EReference getMappingModel_Mappings() {
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
	public EReference getMappingModel_GlobalAttributes() {
		return (EReference)mappingModelEClass.getEStructuralFeatures().get(4);
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
	public EReference getConditionModel_Conditions() {
		return (EReference)conditionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionElement() {
		return expressionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionElement_Expression() {
		return (EAttribute)expressionElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiableElement() {
		return modifiableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifiableElement_Modifiers() {
		return (EReference)modifiableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedValue() {
		return fixedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedValue_Value() {
		return (EAttribute)fixedValueEClass.getEStructuralFeatures().get(0);
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
		createEReference(pamTraMEClass, PAM_TRA_M__SOURCE_SECTION_MODELS);
		createEReference(pamTraMEClass, PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS);
		createEReference(pamTraMEClass, PAM_TRA_M__TARGET_SECTION_MODELS);
		createEReference(pamTraMEClass, PAM_TRA_M__SHARED_TARGET_SECTION_MODELS);
		createEReference(pamTraMEClass, PAM_TRA_M__MAPPING_MODELS);
		createEReference(pamTraMEClass, PAM_TRA_M__SHARED_MAPPING_MODELS);
		createEReference(pamTraMEClass, PAM_TRA_M__SOURCE_SECTIONS);
		createEReference(pamTraMEClass, PAM_TRA_M__TARGET_SECTIONS);
		createEReference(pamTraMEClass, PAM_TRA_M__MAPPINGS);
		createEReference(pamTraMEClass, PAM_TRA_M__ACTIVE_MAPPINGS);
		createEReference(pamTraMEClass, PAM_TRA_M__GLOBAL_VALUES);
		createEReference(pamTraMEClass, PAM_TRA_M__GLOBAL_ATTRIBUTES);
		createEReference(pamTraMEClass, PAM_TRA_M__MODIFIER_SETS);
		createEReference(pamTraMEClass, PAM_TRA_M__CONDITION_MODELS);
		createEReference(pamTraMEClass, PAM_TRA_M__SHARED_CONDITION_MODELS);
		createEOperation(pamTraMEClass, PAM_TRA_M___MERGE_EXTENDS);
		createEOperation(pamTraMEClass, PAM_TRA_M___GET_ACTIVE_SOURCE_SECTION_MODELS);
		createEOperation(pamTraMEClass, PAM_TRA_M___GET_ACTIVE_SOURCE_SECTIONS);

		sectionModelEClass = createEClass(SECTION_MODEL);
		createEReference(sectionModelEClass, SECTION_MODEL__META_MODEL_PACKAGE);
		createEReference(sectionModelEClass, SECTION_MODEL__SECTIONS);

		sourceSectionModelEClass = createEClass(SOURCE_SECTION_MODEL);

		targetSectionModelEClass = createEClass(TARGET_SECTION_MODEL);
		createEReference(targetSectionModelEClass, TARGET_SECTION_MODEL__LIBRARY_ELEMENTS);

		mappingModelEClass = createEClass(MAPPING_MODEL);
		createEReference(mappingModelEClass, MAPPING_MODEL__MAPPINGS);
		createEReference(mappingModelEClass, MAPPING_MODEL__MODIFIER_SETS);
		createEReference(mappingModelEClass, MAPPING_MODEL__GLOBAL_VALUES);
		createEReference(mappingModelEClass, MAPPING_MODEL__ACTIVE_MAPPINGS);
		createEReference(mappingModelEClass, MAPPING_MODEL__GLOBAL_ATTRIBUTES);

		conditionalElementEClass = createEClass(CONDITIONAL_ELEMENT);
		createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__LOCAL_CONDITION);
		createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__SHARED_CONDITION);
		createEOperation(conditionalElementEClass, CONDITIONAL_ELEMENT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP);
		createEOperation(conditionalElementEClass, CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);

		conditionModelEClass = createEClass(CONDITION_MODEL);
		createEReference(conditionModelEClass, CONDITION_MODEL__CONDITIONS);

		expressionElementEClass = createEClass(EXPRESSION_ELEMENT);
		createEAttribute(expressionElementEClass, EXPRESSION_ELEMENT__EXPRESSION);

		modifiableElementEClass = createEClass(MODIFIABLE_ELEMENT);
		createEReference(modifiableElementEClass, MODIFIABLE_ELEMENT__MODIFIERS);

		fixedValueEClass = createEClass(FIXED_VALUE);
		createEAttribute(fixedValueEClass, FIXED_VALUE__VALUE);
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
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);
		ModifierPackage theModifierPackage = (ModifierPackage)EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI);
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);
		LibraryPackage theLibraryPackage = (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);
		ExtendedPackage theExtendedPackage = (ExtendedPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI);
		ConstraintPackage theConstraintPackage = (ConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI);

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
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionModelEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDeactivatableElement());
		sourceSectionModelEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSectionModel());
		g2 = createEGenericType(theTargetPackage.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theTargetPackage.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theTargetPackage.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theTargetPackage.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionModelEClass.getEGenericSuperTypes().add(g1);
		mappingModelEClass.getESuperTypes().add(this.getNamedElement());
		mappingModelEClass.getESuperTypes().add(this.getDeactivatableElement());
		mappingModelEClass.getESuperTypes().add(this.getConditionalElement());
		conditionModelEClass.getESuperTypes().add(this.getNamedElement());
		fixedValueEClass.getESuperTypes().add(this.getNamedElement());
		fixedValueEClass.getESuperTypes().add(theExtendedPackage.getAttributeMappingSourceInterface());
		fixedValueEClass.getESuperTypes().add(theStructurePackage.getInstanceSelectorSourceInterface());
		fixedValueEClass.getESuperTypes().add(theConstraintPackage.getValueConstraintSourceInterface());
		fixedValueEClass.getESuperTypes().add(theExtendedPackage.getCardinalityMappingSourceInterface());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deactivatableElementEClass, DeactivatableElement.class, "DeactivatableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeactivatableElement_Deactivated(), ecorePackage.getEBoolean(), "deactivated", "false", 1, 1, DeactivatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pamTraMEClass, PAMTraM.class, "PAMTraM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPAMTraM_SourceSectionModels(), this.getSourceSectionModel(), null, "sourceSectionModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SharedSourceSectionModels(), this.getSourceSectionModel(), null, "sharedSourceSectionModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_TargetSectionModels(), this.getTargetSectionModel(), null, "targetSectionModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SharedTargetSectionModels(), this.getTargetSectionModel(), null, "sharedTargetSectionModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_MappingModels(), this.getMappingModel(), null, "mappingModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SharedMappingModels(), this.getMappingModel(), null, "sharedMappingModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SourceSections(), theSourcePackage.getSourceSection(), null, "sourceSections", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_TargetSections(), theTargetPackage.getTargetSection(), null, "targetSections", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_Mappings(), theMappingPackage.getMapping(), null, "mappings", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_ActiveMappings(), theMappingPackage.getMapping(), null, "activeMappings", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_GlobalValues(), this.getFixedValue(), null, "globalValues", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_GlobalAttributes(), theMappingPackage.getGlobalAttribute(), null, "globalAttributes", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_ModifierSets(), theModifierPackage.getValueModifierSet(), null, "modifierSets", null, 0, -1, PAMTraM.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_ConditionModels(), this.getConditionModel(), null, "conditionModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SharedConditionModels(), this.getConditionModel(), null, "sharedConditionModels", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPAMTraM__MergeExtends(), null, "mergeExtends", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPAMTraM__GetActiveSourceSectionModels(), this.getSourceSectionModel(), "getActiveSourceSectionModels", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPAMTraM__GetActiveSourceSections(), theSourcePackage.getSourceSection(), "getActiveSourceSections", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(sectionModelEClass, SectionModel.class, "SectionModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSectionModel_MetaModelPackage(), ecorePackage.getEPackage(), null, "metaModelPackage", null, 1, 1, SectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(sectionModelEClass_S);
		initEReference(getSectionModel_Sections(), g1, null, "sections", null, 0, -1, SectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionModelEClass, SourceSectionModel.class, "SourceSectionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionModelEClass, TargetSectionModel.class, "TargetSectionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetSectionModel_LibraryElements(), theLibraryPackage.getLibraryEntry(), null, "libraryElements", null, 0, -1, TargetSectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingModelEClass, MappingModel.class, "MappingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingModel_Mappings(), theMappingPackage.getMapping(), null, "mappings", null, 1, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_ModifierSets(), theModifierPackage.getValueModifierSet(), null, "modifierSets", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_GlobalValues(), this.getFixedValue(), null, "globalValues", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_ActiveMappings(), theMappingPackage.getMapping(), null, "activeMappings", null, 0, -1, MappingModel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_GlobalAttributes(), theMappingPackage.getGlobalAttribute(), null, "globalAttributes", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getConditionModel_Conditions(), theConditionPackage.getComplexCondition(), null, "conditions", null, 0, -1, ConditionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionElementEClass, ExpressionElement.class, "ExpressionElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpressionElement_Expression(), ecorePackage.getEString(), "expression", "", 1, 1, ExpressionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifiableElementEClass, ModifiableElement.class, "ModifiableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifiableElement_Modifiers(), theModifierPackage.getValueModifierSet(), null, "modifiers", null, 0, -1, ModifiableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fixedValueEClass, FixedValue.class, "FixedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, FixedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
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
			 "documentation", "Main package of the PAMTraM (Persistent Ambiguous Mapping and Transformation Model) meta-model containing various structuring and general elements."
		   });	
		addAnnotation
		  (namedElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A NamedElement provides a human-readable name that can be used to identify it, e.g. when working with the model editor."
		   });	
		addAnnotation
		  (getNamedElement_Name(), 
		   source, 
		   new String[] {
			 "documentation", "A human-readable name for this element. This does not necessarilly need to be unique."
		   });	
		addAnnotation
		  (deactivatableElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A DeactivatableElement can be deactivated by the user (e.g. via the model editor). Deactivated elements will be ignored by the transformation algorithm executing the PAMTraM model."
		   });	
		addAnnotation
		  (getDeactivatableElement_Deactivated(), 
		   source, 
		   new String[] {
			 "documentation", "If set to \'true\', this element (and possible sub-elements) will be ignored during a transformation."
		   });	
		addAnnotation
		  (pamTraMEClass, 
		   source, 
		   new String[] {
			 "documentation", "The root element of a PAMTraM model. It mainly acts as container for the various sub-models that are used to define Source- and TargetSections, Mappings, and Conditions."
		   });	
		addAnnotation
		  (getPAMTraM__MergeExtends(), 
		   source, 
		   new String[] {
			 "body", "// TODO handle hierarchical extensions (an extended section extends\r\n// other sections\r\n// TODO implement a more sophisticated merging strategy that takes into\r\n// account overwriting of hints?\r\n\r\n/*\r\n * First, we collect each abstract source and target section as well as\r\n * the concrete sections that reference them\r\n */\r\nHashMap<Section, LinkedList<<%pamtram.structure.generic.Section%>>> abstractToConcreteSectionMap = new HashMap<>();\r\nMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> sourceSettings = <%org.eclipse.emf.ecore.util.EcoreUtil%>.CrossReferencer\r\n\t\t.find(this.getActiveSourceSections());\r\nfor (<%pamtram.structure.generic.Section%> section : this.getActiveSourceSections()) {\r\n\tif (section.isAbstract() && sourceSettings.containsKey(section)) {\r\n\t\tLinkedList<<%pamtram.structure.generic.Section%>> concreteSections = new LinkedList<>();\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : sourceSettings.get(section)) {\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.impl.GenericPackageImpl%>.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((<%pamtram.structure.generic.Section%>) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\nMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> targetSettings = <%org.eclipse.emf.ecore.util.EcoreUtil%>.CrossReferencer.find(this.getTargetSections());\r\nfor (<%pamtram.structure.generic.Section%> section : this.getTargetSections()) {\r\n\tif (section.isAbstract() && targetSettings.containsKey(section)) {\r\n\t\tLinkedList<<%pamtram.structure.generic.Section%>> concreteSections = new LinkedList<>();\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : targetSettings.get(section)) {\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.impl.GenericPackageImpl%>.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\tconcreteSections.add((<%pamtram.structure.generic.Section%>) setting.getEObject());\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteSectionMap.put(section, concreteSections);\r\n\t}\r\n}\r\n\r\nArrayList<<%pamtram.mapping.Mapping%>> concreteMappings = new ArrayList<>();\r\nfor (<%pamtram.mapping.Mapping%> mapping : this.getActiveMappings()) {\r\n\tif (!mapping.isAbstract()) {\r\n\t\tconcreteMappings.add(mapping);\r\n\t}\r\n}\r\n\r\n/*\r\n * Now, we copy all elements from the abstract sections to the concrete\r\n * sections that extend them. In this process, we store the associations\r\n * between the elements from the abstract sections and the copied\r\n * elements in a map.\r\n */\r\nHashMap<EObject, LinkedList<<%org.eclipse.emf.ecore.EObject%>>> abstractToConcreteElementMap = new HashMap<>();\r\nfor (<%pamtram.structure.generic.Section%> abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (<%pamtram.structure.generic.Section%> concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\r\n\t<%pamtram.structure.generic.Section%> copiedSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.copy(abstractSection);\r\n\r\n\tTreeIterator<<%org.eclipse.emf.ecore.EObject%>> originalIterator = <%org.eclipse.emf.ecore.util.EcoreUtil%>\r\n\t\t\t\t.getAllContents(<%java.util.Collections%>.singleton(abstractSection));\r\n\t\tTreeIterator<<%org.eclipse.emf.ecore.EObject%>> copyIterator = <%org.eclipse.emf.ecore.util.EcoreUtil%>.getAllContents(<%java.util.Collections%>.singleton(copiedSection));\r\n\r\n\t// these lists will store the elements that we will add to the\r\n\t\t// concrete section\r\n\t\tArrayList<<%pamtram.structure.generic.Attribute%>> attributesToAdd = new ArrayList<>();\r\n\t\tArrayList<<%pamtram.structure.generic.Reference%>> referencesToAdd = new ArrayList<>();\r\n\r\n\twhile (originalIterator.hasNext()) {\r\n\t\t\tassert copyIterator.hasNext();\r\n\r\n\t\t<%org.eclipse.emf.ecore.EObject%> originalNext = originalIterator.next();\r\n\t\t\t<%org.eclipse.emf.ecore.EObject%> copyNext = copyIterator.next();\r\n\r\n\t\t// if the element is the section itself, we skip it\r\n\t\t\tif (originalNext instanceof <%pamtram.structure.generic.Section%>) {\r\n\t\t\t\tcontinue;\r\n\t\t\t}\r\n\r\n\t\t// if the element is a top-level element below the section,\r\n\t\t\t// we add it to the concrete section\r\n\t\t\tif (originalNext.eContainer().equals(abstractSection)) {\r\n\t\t\t\tif (copyNext instanceof <%pamtram.structure.generic.Attribute%>) {\r\n\t\t\t\t\tattributesToAdd.add((<%pamtram.structure.generic.Attribute%>) copyNext);\r\n\t\t\t\t} else if (copyNext instanceof <%pamtram.structure.generic.Reference%>) {\r\n\t\t\t\t\treferencesToAdd.add((<%pamtram.structure.generic.Reference%>) copyNext);\r\n\t\t\t\t} else {\r\n\t\t\t\t\tthrow new RuntimeException(\"Unsupported element type \'\" + copyNext.eClass().getName()\r\n\t\t\t\t\t\t\t+ \"\' encountered when merging extends!\");\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t\t// in any case, we fill the abstractToConcreteElementMap\r\n\t\t\tLinkedList<<%org.eclipse.emf.ecore.EObject%>> vals = abstractToConcreteElementMap.get(originalNext);\r\n\t\t\tif (vals == null) {\r\n\t\t\t\tvals = new LinkedList<>();\r\n\t\t\t}\r\n\t\t\tvals.add(copyNext);\r\n\t\t\tabstractToConcreteElementMap.put(originalNext, vals);\r\n\t\t}\r\n\r\n\t/*\r\n\t\t * now, we add the collected elements to the concrete section;\r\n\t\t * we have to do this after the process of iterating over the\r\n\t\t * contents - otherwise, the <%org.eclipse.emf.common.util.TreeIterator%> will throw\r\n\t\t * IndexOutOfBoundsExceptions\r\n\t\t */\r\n\t\tconcreteSection.getAttributes().addAll(attributesToAdd);\r\n\t\tconcreteSection.getReferences().addAll(referencesToAdd);\r\n\r\n\t/*\r\n\t\t * Now, we redirect references from concrete sections to\r\n\t\t * elements from the abstract section to the (new) elements from\r\n\t\t * the concrete sections.\r\n\t\t */\r\n\t\tMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> refsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), this.getActiveSourceSections().stream()\r\n\t\t\t\t\t\t.filter(s -> !s.isAbstract()).collect(<%java.util.stream.Collectors%>.toList()));\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject).stream()\r\n\t\t\t\t\t.filter(s -> !s.getEStructuralFeature().isDerived()).collect(<%java.util.stream.Collectors%>.toList())) {\r\n\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.GenericPackage%>.eINSTANCE.getSection_Extend())) {\r\n\t\t\t\t\t// the \'extend\' feature has already been handled\r\n\t\t\t\t\t// above\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be an element of a section)\r\n\t\t\t\t<%org.eclipse.emf.ecore.EObject%> hintElement = setting.getEObject();\r\n\r\n\t\t\tif (setting.getEStructuralFeature().equals(<%pamtram.structure.generic.GenericPackage%>.eINSTANCE.getClass_Container())) {\r\n\t\t\t\t\tif (abstractSection.equals(hintElement) || abstractSection\r\n\t\t\t\t\t\t\t.isContainerFor((pamtram.structure.generic.Class<?, ?, ?, ?>) hintElement)) {\r\n\r\n\t\t\t\t\t// redirect the reference (we can always use the\r\n\t\t\t\t\t\t// \'last\' of the concrete objects as we just\r\n\t\t\t\t\t\t// added it above\r\n\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t\t}\r\n\r\n\t\t\t} else {\r\n\t\t\t\t\tSystem.out.println(\r\n\t\t\t\t\t\t\t\"Unhandled reference to element of an abstract section. Maybe consider redirecting this?\");\r\n\t\t\t\t}\r\n\r\n\t\t}\r\n\r\n\t}\r\n\r\n\t/*\r\n\t\t * Now, we redirect references from MappingHints to elements\r\n\t\t * from the abstract section to the elements from the concrete\r\n\t\t * sections. Here, we only handle references from concrete\r\n\t\t * mappings as the references from abstract mappings (and thus\r\n\t\t * from extended hint groups) are handled afterwards when these\r\n\t\t * hint groups are copied.\r\n\t\t */\r\n\t\trefsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer.findAll(abstractToConcreteElementMap.keySet(),\r\n\t\t\t\tconcreteMappings);\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be contained in a <%pamtram.mapping.Mapping%> and be either\r\n\t\t\t\t// part of a MappingHintGroup or of a Condition)\r\n\t\t\t\t//\r\n\t\t\t\t<%pamtram.mapping.MappingHintGroupType%> hintGroup = (<%pamtram.mapping.MappingHintGroupType%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(\r\n\t\t\t\t\t\tsetting.getEObject(), <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE);\r\n\t\t\t\t<%pamtram.mapping.Mapping%> mapping = (<%pamtram.mapping.Mapping%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(setting.getEObject(),\r\n\t\t\t\t\t\t<%pamtram.mapping.MappingPackage%>.Literals.MAPPING);\r\n\r\n\t\t\tif (mapping == null) {\r\n\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\r\n\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\r\n\t\t\t\t}\r\n\r\n\t\t\t// We do not need to handle deactivated\r\n\t\t\t\t// Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif (hintGroup instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) hintGroup).isDeactivated() || mapping.isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\t/*\r\n\t\t\t\t * check if the hint group or its parent mapping equals\r\n\t\t\t\t * the section that we just added the concrete elements\r\n\t\t\t\t * to\r\n\t\t\t\t */\r\n\t\t\t\tif (hintGroup != null\r\n\t\t\t\t\t\t&& (concreteSection.equals(hintGroup.getTargetSection())\r\n\t\t\t\t\t\t\t\t|| concreteSection.isContainerFor(hintGroup.getTargetSection()))\r\n\t\t\t\t\t\t|| concreteSection.equals(mapping.getSourceSection())\r\n\t\t\t\t\t\t|| concreteSection.isContainerFor(mapping.getSourceSection())) {\r\n\r\n\t\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t\t\t.equals(<%pamtram.structure.impl.StructurePackageImpl%>.eINSTANCE.getDynamicSourceElement_Source())\r\n\t\t\t\t\t\t\t&& setting.getEObject() instanceof <%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>\r\n\t\t\t\t\t\t\t|| setting.getEStructuralFeature()\r\n\t\t\t\t\t\t\t\t\t.equals(<%pamtram.mapping.extended.impl.ExtendedPackageImpl%>.eINSTANCE.getAttributeMatcher_Target())\r\n\t\t\t\t\t\t\t\t\t&& setting.getEObject() instanceof <%pamtram.mapping.extended.AttributeMatcher%>) {\r\n\t\t\t\t\t\t// do nothing as ContainerSelectors and\r\n\t\t\t\t\t\t// AttributeMatchers are handled\r\n\t\t\t\t\t\t// below separately\r\n\t\t\t\t\t} else {\r\n\r\n\t\t\t\t\t// redirect the reference (we can always use the\r\n\t\t\t\t\t\t// \'last\' of the concrete objects as we just\r\n\t\t\t\t\t\t// added it above\r\n\t\t\t\t\t\tsetting.set(abstractToConcreteElementMap.get(referencedObject).getLast());\r\n\t\t\t\t\t}\r\n\r\n\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n}\r\n}\r\n\r\n/*\r\n * Now, we handle the ContainerSelectors and AttributeMatchers that we\r\n * skipped above. We can do this now as we now know all concrete\r\n * TargetSections that are a possible match for each <%pamtram.mapping.extended.ContainerSelector%>\r\n * that points to an abstract <%pamtram.structure.target.TargetSection%>.\r\n */\r\nfor (<%pamtram.structure.generic.Section%> abstractSection : abstractToConcreteSectionMap.keySet()) {\r\n\tfor (<%pamtram.structure.generic.Section%> concreteSection : abstractToConcreteSectionMap.get(abstractSection)) {\r\n\t\t/*\r\n\t\t * as ContainerSelectors will get treated differently (see\r\n\t\t * below), we store the ContainerSelectorTargetAttributes\r\n\t\t * holding the references to the Attributes in the abstract\r\n\t\t * section and will delete these later\r\n\t\t */\r\n\t\tArrayList<<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>> mchTargetAttributesToDelete = new ArrayList<>();\r\n\r\n\tMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> refsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), concreteMappings);\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject)) {\r\n\r\n\t\t\t// this is the element referencing the abstract section\r\n\t\t\t\t// (it should be contained in a <%pamtram.mapping.Mapping%> and be either\r\n\t\t\t\t// part of a MappingHintGroup or of a Condition)\r\n\t\t\t\t//\r\n\t\t\t\t<%pamtram.mapping.MappingHintGroupType%> hintGroup = (<%pamtram.mapping.MappingHintGroupType%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(\r\n\t\t\t\t\t\tsetting.getEObject(), <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE);\r\n\t\t\t\t<%pamtram.mapping.Mapping%> mapping = (<%pamtram.mapping.Mapping%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(setting.getEObject(),\r\n\t\t\t\t\t\t<%pamtram.mapping.MappingPackage%>.Literals.MAPPING);\r\n\r\n\t\t\tif (mapping == null) {\r\n\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\"Internal error during merging of extends. No containing element of type \'Mapping\' found for element \'\"\r\n\t\t\t\t\t\t\t\t\t+ setting.getEObject() + \"\'!\");\r\n\t\t\t\t}\r\n\r\n\t\t\t// We do not need to handle deactivated\r\n\t\t\t\t// Mappings/MappingHintGroups\r\n\t\t\t\t//\r\n\t\t\t\tif (hintGroup instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) hintGroup).isDeactivated() || mapping.isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t}\r\n\r\n\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t\t.equals(<%pamtram.structure.impl.StructurePackageImpl%>.eINSTANCE.getDynamicSourceElement_Source())\r\n\t\t\t\t\t\t&& setting.getEObject() instanceof <%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>) {\r\n\r\n\t\t\t\t// For ContainerSelectorTargetAttributes, we must\r\n\t\t\t\t\t// not simply redirect but we\r\n\t\t\t\t\t// create a new <%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>\r\n\t\t\t\t\t<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%> original = (<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>) setting\r\n\t\t\t\t\t\t\t.getEObject();\r\n\r\n\t\t\t\tfor (<%org.eclipse.emf.ecore.EObject%> concreteTargetSectionAttribute : abstractToConcreteElementMap\r\n\t\t\t\t\t\t\t.get(referencedObject)) {\r\n\t\t\t\t\t\t<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%> copy = <%pamtram.mapping.extended.impl.ExtendedFactoryImpl%>.eINSTANCE\r\n\t\t\t\t\t\t\t\t.createContainerSelectorTargetAttribute();\r\n\t\t\t\t\t\tcopy.setName(original.getName());\r\n\t\t\t\t\t\tcopy.getModifiers().addAll(original.getModifiers());\r\n\t\t\t\t\t\tcopy.setSource((<%pamtram.structure.target.TargetSectionAttribute%>) concreteTargetSectionAttribute);\r\n\r\n\t\t\t\t\t((<%pamtram.mapping.extended.ContainerSelector%>) setting.getEObject().eContainer()).getTargetAttributes().add(copy);\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\tmchTargetAttributesToDelete.add((<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%>) setting.getEObject());\r\n\r\n\t\t\t} else if (setting.getEStructuralFeature()\r\n\t\t\t\t\t\t.equals(<%pamtram.mapping.extended.impl.ExtendedPackageImpl%>.eINSTANCE.getAttributeMatcher_Target())\r\n\t\t\t\t\t\t&& setting.getEObject() instanceof <%pamtram.mapping.extended.AttributeMatcher%>) {\r\n\r\n\t\t\t\t// For AttributeMatchers, we redirect to\r\n\t\t\t\t\t// (the) one concrete attribute which is contained\r\n\t\t\t\t\t// in a <%pamtram.structure.target.TargetSectionClass%> which is a possible\r\n\t\t\t\t\t// target for the <%pamtram.structure.target.TargetSectionCrossReference%>\r\n\t\t\t\t\t// affected by ReferenceTargetSelectors containing\r\n\t\t\t\t\t// this matcher\r\n\t\t\t\t\t//\r\n\t\t\t\t\t<%pamtram.mapping.extended.ReferenceTargetSelector%> parentSelector = (<%pamtram.mapping.extended.ReferenceTargetSelector%>) setting.getEObject()\r\n\t\t\t\t\t\t\t.eContainer();\r\n\t\t\t\t\t<%pamtram.structure.target.TargetSectionCrossReference%> affectedReference = parentSelector.getAffectedReference();\r\n\r\n\t\t\t\tfor (<%org.eclipse.emf.ecore.EObject%> concreteTargetSectionAttribute : abstractToConcreteElementMap\r\n\t\t\t\t\t\t\t.get(referencedObject)) {\r\n\t\t\t\t\t\tif (!affectedReference.getValue().isEmpty()) {\r\n\t\t\t\t\t\t\tfor (<%pamtram.structure.target.TargetSectionClass%> targetClass : affectedReference.getValue()) {\r\n\t\t\t\t\t\t\t\tif (targetClass.getAttributes().contains(concreteTargetSectionAttribute)) {\r\n\t\t\t\t\t\t\t\t\tsetting.getEObject().eSet(setting.getEStructuralFeature(),\r\n\t\t\t\t\t\t\t\t\t\t\tconcreteTargetSectionAttribute);\r\n\t\t\t\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\tif (affectedReference.getEReference().getEReferenceType().isSuperTypeOf(\r\n\t\t\t\t\t\t\t\t\t((<%pamtram.structure.target.TargetSectionClass%>) concreteTargetSectionAttribute.eContainer())\r\n\t\t\t\t\t\t\t\t\t\t\t.getEClass())) {\r\n\t\t\t\t\t\t\t\tsetting.getEObject().eSet(setting.getEStructuralFeature(),\r\n\t\t\t\t\t\t\t\t\t\tconcreteTargetSectionAttribute);\r\n\t\t\t\t\t\t\t\tbreak;\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\tfor (<%pamtram.mapping.extended.ContainerSelectorTargetAttribute%> mchTargetAttribute : mchTargetAttributesToDelete) {\r\n\t\t\t<%org.eclipse.emf.ecore.util.EcoreUtil%>.delete(mchTargetAttribute);\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * Finally, we can copy the abstract hint groups\r\n */\r\n\r\n// collect each abstract hint group as well as the concrete hint groups\r\n// that reference them\r\nHashMap<MappingHintGroupType, LinkedList<<%pamtram.mapping.MappingHintGroupType%>>> abstractToConcreteHintGroupMap = new HashMap<>();\r\nMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> mappingSettings = <%org.eclipse.emf.ecore.util.EcoreUtil%>.CrossReferencer.find(this.getActiveMappings());\r\nfor (<%org.eclipse.emf.ecore.EObject%> element : mappingSettings.keySet()) {\r\n\tif (element instanceof <%pamtram.mapping.MappingHintGroupType%> && ((<%pamtram.mapping.Mapping%>) element.eContainer()).isAbstract()) {\r\n\r\n\t// We do not need to handle deactivated MappingHintGroups\r\n\t\t//\r\n\t\tif (element instanceof <%pamtram.DeactivatableElement%> && ((<%pamtram.DeactivatableElement%>) element).isDeactivated()\r\n\t\t\t\t|| element.eContainer() instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) element.eContainer()).isDeactivated()) {\r\n\t\t\tcontinue;\r\n\t\t}\r\n\r\n\tLinkedList<<%pamtram.mapping.MappingHintGroupType%>> concreteHintGroups = new LinkedList<>();\r\n\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : mappingSettings.get(element)) {\r\n\t\t\tif (setting.getEStructuralFeature()\r\n\t\t\t\t\t.equals(<%pamtram.mapping.impl.MappingPackageImpl%>.eINSTANCE.getMappingHintGroupType_Extend())) {\r\n\r\n\t\t\t// only copy hints to activated hint groups\r\n\t\t\t\tif (setting.getEObject() instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) setting.getEObject()).isDeactivated()\r\n\t\t\t\t\t\t|| setting.getEObject().eContainer() instanceof <%pamtram.DeactivatableElement%>\r\n\t\t\t\t\t\t\t\t&& ((<%pamtram.DeactivatableElement%>) setting.getEObject().eContainer()).isDeactivated()) {\r\n\t\t\t\t\tcontinue;\r\n\t\t\t\t} else {\r\n\t\t\t\t\tconcreteHintGroups.add((<%pamtram.mapping.MappingHintGroupType%>) setting.getEObject());\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t}\r\n\t\tabstractToConcreteHintGroupMap.put((<%pamtram.mapping.MappingHintGroupType%>) element, concreteHintGroups);\r\n\t}\r\n}\r\n\r\n// copy the contained elements (hints and condition) to the concrete\r\n// hint groups\r\nfor (<%pamtram.mapping.MappingHintGroupType%> abstractHintGroup : abstractToConcreteHintGroupMap.keySet()) {\r\n\tfor (<%pamtram.mapping.MappingHintGroupType%> concreteHintGroup : abstractToConcreteHintGroupMap.get(abstractHintGroup)) {\r\n\r\n\tCollection<<%pamtram.mapping.extended.MappingHintBaseType%>> hintsToCopy = new BasicEList<>();\r\n\t\t/*\r\n\t\t * Collect all hints that will get copied. Those are all mapping\r\n\t\t * hints (including ContainerSelectors) that are not\r\n\t\t * \'overwritten\' by hints of the concrete HintGroup.\r\n\t\t */\r\n\t\tfor (<%pamtram.mapping.extended.MappingHint%> abstractHint : abstractHintGroup.getActiveMappingHints()) {\r\n\t\t\t<%org.eclipse.emf.ecore.EObject%> hintTarget = null;\r\n\t\t\tif (abstractHint instanceof <%pamtram.mapping.extended.AttributeMapping%>) {\r\n\t\t\t\thintTarget = ((<%pamtram.mapping.extended.AttributeMapping%>) abstractHint).getTarget();\r\n\t\t\t} else if (abstractHint instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%>) {\r\n\t\t\t\thintTarget = ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) abstractHint).getAffectedReference();\r\n\t\t\t} else if (abstractHint instanceof <%pamtram.mapping.extended.CardinalityMapping%>) {\r\n\t\t\t\thintTarget = ((<%pamtram.mapping.extended.CardinalityMapping%>) abstractHint).getTarget();\r\n\t\t\t} else if (abstractHint instanceof <%pamtram.mapping.extended.ContainerSelector%>) {\r\n\t\t\t\t// nothing to do as ContainerSelectorTargetAttributes\r\n\t\t\t\t// are handled separately\r\n\t\t\t} else {\r\n\t\t\t\tthrow new RuntimeException(\"Unsupported hint type \'\" + abstractHint.eClass().getName()\r\n\t\t\t\t\t\t+ \"\' in HintGroup \'\" + abstractHintGroup.getName()\r\n\t\t\t\t\t\t+ \"\': These kind of hints are not supported yet in abstract HintGroups!\");\r\n\t\t\t}\r\n\r\n\t\t// An abstract hint is not overwritten (and may thus get\r\n\t\t\t// copied) if...\r\n\t\t\t//\r\n\t\t\t// ... there are either no concrete hints at all...\r\n\t\t\tif (concreteHintGroup.getMappingHints().isEmpty()\r\n\t\t\t\t\t// ... or if there are are no hints with the same\r\n\t\t\t\t\t// target element ...\r\n\t\t\t\t\t|| <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t\t\t\t.find(hintTarget, concreteHintGroup.getActiveMappingHints()).isEmpty()\r\n\t\t\t\t\t\t\t// ... and no hints with a target elements\r\n\t\t\t\t\t\t\t// that extends the target element of the\r\n\t\t\t\t\t\t\t// abstract hint\r\n\t\t\t\t\t\t\t&& (abstractToConcreteElementMap.get(hintTarget) == null\r\n\t\t\t\t\t\t\t\t\t|| abstractToConcreteElementMap.get(hintTarget).isEmpty()\r\n\t\t\t\t\t\t\t\t\t|| <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t\t\t\t\t\t\t\t.findAll(abstractToConcreteElementMap.get(hintTarget),\r\n\t\t\t\t\t\t\t\t\t\t\t\t\tconcreteHintGroup.getActiveMappingHints())\r\n\t\t\t\t\t\t\t\t\t\t\t.isEmpty())) {\r\n\r\n\t\t\thintsToCopy.add(abstractHint);\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\t// Retrieve a possible condition to be copied\r\n\t\t//\r\n\t\t<%pamtram.condition.ComplexCondition%> condition = null;\r\n\t\tif (abstractHintGroup instanceof <%pamtram.ConditionalElement%>) {\r\n\t\t\tcondition = ((<%pamtram.ConditionalElement%>) abstractHintGroup).getLocalCondition() != null\r\n\t\t\t\t\t? ((<%pamtram.ConditionalElement%>) abstractHintGroup).getLocalCondition()\r\n\t\t\t\t\t: ((<%pamtram.ConditionalElement%>) abstractHintGroup).getSharedCondition();\r\n\t\t}\r\n\t\t<%pamtram.condition.ComplexCondition%> copiedCondition = condition != null ? <%org.eclipse.emf.ecore.util.EcoreUtil%>.copy(condition) : null;\r\n\r\n\tCollection<<%pamtram.mapping.extended.MappingHintBaseType%>> copiedHints = <%org.eclipse.emf.ecore.util.EcoreUtil%>.copyAll(hintsToCopy);\r\n\r\n\t/*\r\n\t\t * make sure that all references to elements from the abstract\r\n\t\t * sections are redirected to the concrete sections that we\r\n\t\t * created earlier\r\n\t\t */\r\n\t\tCollection<<%org.eclipse.emf.ecore.EObject%>> copiedElements = new ArrayList<>(copiedHints);\r\n\t\tif (copiedCondition != null) {\r\n\t\t\tcopiedElements.add(copiedCondition);\r\n\t\t}\r\n\t\tfor (<%org.eclipse.emf.ecore.EObject%> copiedElement : copiedElements) {\r\n\r\n\t\t/*\r\n\t\t\t * these are the references from the copied hint (that will\r\n\t\t\t * get added to the concrete hint group) to elements from\r\n\t\t\t * abstract sections\r\n\t\t\t */\r\n\t\t\tMap<EObject, Collection<<%org.eclipse.emf.ecore.EStructuralFeature.Setting%>>> refsToAbstractSection = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t\t.findAll(abstractToConcreteElementMap.keySet(), copiedElement);\r\n\t\t\tfor (<%org.eclipse.emf.ecore.EObject%> referencedObject : refsToAbstractSection.keySet()) {\r\n\r\n\t\t\t/*\r\n\t\t\t\t * based on the type of hint element that we are\r\n\t\t\t\t * handling (local or external), source and target\r\n\t\t\t\t * sections or their containers are checked\r\n\t\t\t\t */\r\n\t\t\t\tboolean local = true;\r\n\t\t\t\tif (refsToAbstractSection.get(referencedObject).size() > 1) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal Error! The element \'\"\r\n\t\t\t\t\t\t\t+ (copiedElement instanceof <%pamtram.NamedElement%> ? ((<%pamtram.NamedElement%>) copiedElement).getName()\r\n\t\t\t\t\t\t\t\t\t: copiedElement.toString())\r\n\t\t\t\t\t\t\t+ \"\' in the hint group \'\" + abstractHintGroup.getName()\r\n\t\t\t\t\t\t\t+ \"\' holds multiple references to the same object of an abstract section (\'\"\r\n\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\t\t\t\tif (refsToAbstractSection.get(referencedObject).iterator().next()\r\n\t\t\t\t\t\t.getEObject() instanceof <%pamtram.structure.ExternalDynamicSourceElement%>) {\r\n\t\t\t\t\tlocal = false;\r\n\t\t\t\t}\r\n\t\t\t\tArrayList<<%pamtram.structure.generic.Section%>> sourceAndTargetSections = new ArrayList<>();\r\n\t\t\t\t<%pamtram.structure.source.SourceSection%> sourceSection = ((<%pamtram.mapping.Mapping%>) concreteHintGroup.eContainer()).getSourceSection();\r\n\t\t\t\tif (local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (sourceSection.getContainer() != null) {\r\n\t\t\t\t\t\tsourceSection = sourceSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(sourceSection);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\t<%pamtram.structure.target.TargetSection%> targetSection = concreteHintGroup.getTargetSection();\r\n\t\t\t\tif (local) {\r\n\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t} else {\r\n\t\t\t\t\twhile (targetSection.getContainer() != null) {\r\n\t\t\t\t\t\ttargetSection = targetSection.getContainer().getContainingSection();\r\n\t\t\t\t\t\tsourceAndTargetSections.add(targetSection);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t/*\r\n\t\t\t\t * these are possible targets for the redirection of\r\n\t\t\t\t * references to the referenced object\r\n\t\t\t\t */\r\n\t\t\t\tLinkedList<<%org.eclipse.emf.ecore.EObject%>> possibleTargets = abstractToConcreteElementMap.get(referencedObject);\r\n\r\n\t\t\tboolean found = false;\r\n\t\t\t\t<%org.eclipse.emf.ecore.EObject%> target = null; // this will contain the new\r\n\t\t\t\t\t\t\t\t\t\t// value for the reference\r\n\t\t\t\tfor (<%org.eclipse.emf.ecore.EObject%> possibleTarget : possibleTargets) {\r\n\t\t\t\t\t<%pamtram.structure.generic.Section%> containingSection = ((<%pamtram.structure.generic.MetaModelElement%>) possibleTarget).getContainingSection();\r\n\t\t\t\t\tif (sourceAndTargetSections.contains(containingSection)) {\r\n\t\t\t\t\t\tif (found == false) {\r\n\t\t\t\t\t\t\tfound = true;\r\n\t\t\t\t\t\t\ttarget = possibleTarget;\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\t// this should not happen, should it?\r\n\t\t\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\t\t\"Internal error! Multiple targets found for redirection of element \'\"\r\n\t\t\t\t\t\t\t\t\t\t\t+ referencedObject + \"\' in.\");\r\n\t\t\t\t\t\t}\r\n\r\n\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\tif (found == false) {\r\n\t\t\t\t\tthrow new RuntimeException(\"Internal error! No target found for redirection of element \'\"\r\n\t\t\t\t\t\t\t+ referencedObject + \"\'.\");\r\n\t\t\t\t}\r\n\r\n\t\t\tfor (<%org.eclipse.emf.ecore.EStructuralFeature.Setting%> setting : refsToAbstractSection.get(referencedObject)) {\r\n\t\t\t\t\tsetting.set(target);\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\n\t}\r\n\r\n\t// Finally, we add the copied hints and condition to the\r\n\t\t// concrete hint group\r\n\t\tfor (<%pamtram.mapping.extended.MappingHintBaseType%> copiedHint : copiedHints) {\r\n\t\t\tconcreteHintGroup.getMappingHints().add((<%pamtram.mapping.extended.MappingHint%>) copiedHint);\r\n\t\t}\r\n\t\tif (copiedCondition != null && concreteHintGroup instanceof <%pamtram.ConditionalElement%>) {\r\n\t\t\t<%pamtram.ConditionalElement%> concreteHintGroupCast = (<%pamtram.ConditionalElement%>) concreteHintGroup;\r\n\t\t\t// If there is already a condition present in the concrete\r\n\t\t\t// HintGroup, we have to create a new condition that will\r\n\t\t\t// conjunct both conditions\r\n\t\t\t//\r\n\t\t\tif (concreteHintGroupCast.getLocalCondition() != null) {\r\n\t\t\t\t<%pamtram.condition.And%> and = <%pamtram.condition.ConditionFactory%>.eINSTANCE.createAnd();\r\n\t\t\t\tand.getLocalCondParts().add(concreteHintGroupCast.getLocalCondition());\r\n\t\t\t\tand.getLocalCondParts().add(copiedCondition);\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\r\n\t\t\t} else if (concreteHintGroupCast.getSharedCondition() != null) {\r\n\t\t\t\t<%pamtram.condition.And%> and = <%pamtram.condition.ConditionFactory%>.eINSTANCE.createAnd();\r\n\t\t\t\tand.getLocalCondParts().add(<%org.eclipse.emf.ecore.util.EcoreUtil%>.copy(concreteHintGroupCast.getSharedCondition()));\r\n\t\t\t\tand.getLocalCondParts().add(copiedCondition);\r\n\t\t\t\tconcreteHintGroupCast.setSharedCondition(null);\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(and);\r\n\t\t\t} else {\r\n\t\t\t\tconcreteHintGroupCast.setLocalCondition(copiedCondition);\r\n\t\t\t}\r\n\t\t}\r\n\t}\r\n}\r\n\r\n/*\r\n * At the end, we clear the values of the \'extend\' references of the\r\n * concrete elements as these are no longer needed.\r\n */\r\nfor (Entry<Section, LinkedList<<%pamtram.structure.generic.Section%>>> entry : abstractToConcreteSectionMap.entrySet()) {\r\n\tfor (<%pamtram.structure.generic.Section%> concreteSection : entry.getValue()) {\r\n\t\tconcreteSection.getExtend().remove(entry.getKey());\r\n\t}\r\n}\r\nfor (Entry<MappingHintGroupType, LinkedList<<%pamtram.mapping.MappingHintGroupType%>>> entry : abstractToConcreteHintGroupMap\r\n\t\t.entrySet()) {\r\n\tfor (<%pamtram.mapping.MappingHintGroupType%> concreteHintGroup : entry.getValue()) {\r\n\t\tconcreteHintGroup.getExtend().remove(entry.getKey());\r\n\t}\r\n}"
		   });	
		addAnnotation
		  (getPAMTraM__GetActiveSourceSectionModels(), 
		   source, 
		   new String[] {
			 "body", "Object[] sourceSectionModels = Stream.concat(this.getSourceSectionModels().stream(), this.getSharedSourceSectionModels().stream()).filter(s -> !s.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(sourceSectionModels.length, sourceSectionModels);"
		   });	
		addAnnotation
		  (getPAMTraM__GetActiveSourceSections(), 
		   source, 
		   new String[] {
			 "body", "Object[] sourceSections = getActiveSourceSectionModels().stream().flatMap(s -> s.getSections().stream()).filter(s -> !s.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(sourceSections.length, sourceSections);"
		   });	
		addAnnotation
		  (getPAMTraM_SourceSectionModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of SourceSectionModels contained in this PAMTraM instance.\r\n<br />\r\nTogether with the list of \'sharedSourceSectionModels\', these make up the list of SourceSectionModels providing the SourceSections (LHS) that will be used during a transformation."
		   });	
		addAnnotation
		  (getPAMTraM_SharedSourceSectionModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of external SourceSectionModels (stored in their own files with the file-ending \'*.pamtram.source\') referenced by this PAMTraM instance.\r\n<br />\r\nTogether with the list of (local) \'sourceSectionModels\', these make up the list of SourceSectionModels providing the SourceSections (LHS) that will be used during a transformation."
		   });	
		addAnnotation
		  (getPAMTraM_TargetSectionModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of TargetSectionModels contained in this PAMTraM instance.\r\n<br />\r\nTogether with the list of \'sharedTargetSectionModels\', these make up the list of TargetSectionModels providing the TargetSections (RHS) that will be used during a transformation."
		   });	
		addAnnotation
		  (getPAMTraM_SharedTargetSectionModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of external TargetSectionModels (stored in their own files with the file-ending \'*.pamtram.target\') referenced by this PAMTraM instance.\r\n<br />\r\nTogether with the list of (local) \'targetSectionModels\', these make up the list of TargetSectionModels providing the TargetSections (RHS) that will be used during a transformation."
		   });	
		addAnnotation
		  (getPAMTraM_MappingModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of MappingModels contained in this PAMTraM instance.\r\n<br />\r\nTogether with the list of \'sharedMappingModels\', these make up the list of MappingModels defining the Mappings that will be executed during a transformation."
		   });	
		addAnnotation
		  (getPAMTraM_SharedMappingModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of external MappingSectionModels (stored in their own files with the file-ending \'*.pamtram.mapping\') referenced by this PAMTraM instance.\r\n<br />\r\nTogether with the list of (local) \'mappingSectionModels\', these make up the list of MappingModels defining the Mappings that will be executed during a transformation."
		   });	
		addAnnotation
		  (getPAMTraM_SourceSections(), 
		   source, 
		   new String[] {
			 "get", "List<SourceSection> sourceSections = Stream\r\n\t\t.concat(this.getSourceSectionModels().stream(),\r\n\t\t\t\tthis.getSharedSourceSectionModels().stream())\r\n\t\t.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTIONS,\r\n\t\tsourceSections.size(), sourceSections.toArray());"
		   });	
		addAnnotation
		  (getPAMTraM_SourceSections(), 
		   source, 
		   new String[] {
			 "documentation", "The list of all SourceSections (LHS) contained in all local and global/shared SourceSectionModels."
		   });	
		addAnnotation
		  (getPAMTraM_TargetSections(), 
		   source, 
		   new String[] {
			 "get", "List<TargetSection> targetSections = Stream\r\n\t\t.concat(this.getTargetSectionModels().stream(),\r\n\t\t\t\tthis.getSharedTargetSectionModels().stream())\r\n\t\t.flatMap(s -> s.getSections().stream()).collect(Collectors.toList());\r\nreturn new EcoreEList.UnmodifiableEList<>(this, PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTIONS,\r\n\t\ttargetSections.size(), targetSections.toArray());"
		   });	
		addAnnotation
		  (getPAMTraM_TargetSections(), 
		   source, 
		   new String[] {
			 "documentation", "The list of all TargetSections (RHS) contained in all local and global/shared TargetSectionModels."
		   });	
		addAnnotation
		  (getPAMTraM_Mappings(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><<%pamtram.mapping.Mapping%>> mappings = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getMappings().stream()).collect(Collectors.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());"
		   });	
		addAnnotation
		  (getPAMTraM_Mappings(), 
		   source, 
		   new String[] {
			 "documentation", "The list of all Mappings contained in all local and global/shared MappingModels."
		   });	
		addAnnotation
		  (getPAMTraM_ActiveMappings(), 
		   source, 
		   new String[] {
			 "get", "List<<%pamtram.mapping.Mapping%>> mappings = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.filter(m -> !m.isDeactivated()).flatMap(s -> s.getActiveMappings().stream())\r\n\t\t.filter(m -> m.getSourceSection() == null || !m.getSourceSection().isDeactivated())\r\n\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__ACTIVE_MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());"
		   });	
		addAnnotation
		  (getPAMTraM_ActiveMappings(), 
		   source, 
		   new String[] {
			 "documentation", "The list of all \'active\' Mappings contained in all local and global/shared MappingModels.\r\n<br />\r\nA Mapping is active if its \'deactivated\' attribute is not set to \'true\'."
		   });	
		addAnnotation
		  (getPAMTraM_GlobalValues(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><FixedValue> globalValues = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getGlobalValues().stream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__GLOBAL_VALUES,\r\n\t\tglobalValues.size(), globalValues.toArray());"
		   });	
		addAnnotation
		  (getPAMTraM_GlobalValues(), 
		   source, 
		   new String[] {
			 "documentation", "The list of all GlobalValues contained in all local and global/shared MappingModels."
		   });	
		addAnnotation
		  (getPAMTraM_GlobalAttributes(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><GlobalAttribute> globalAttributes = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getGlobalAttributes().stream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__GLOBAL_ATTRIBUTES,\r\n\t\tglobalAttributes.size(), globalAttributes.toArray());"
		   });	
		addAnnotation
		  (getPAMTraM_GlobalAttributes(), 
		   source, 
		   new String[] {
			 "documentation", "The list of all GlobalAttributes contained in all local and global/shared MappingModels."
		   });	
		addAnnotation
		  (getPAMTraM_ModifierSets(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><<%pamtram.mapping.modifier.ValueModifierSet%>> modifierSets = <%java.util.stream.Stream%>.concat(this.getMappingModels().stream(), this.getSharedMappingModels().stream())\r\n\t\t.flatMap(s -> s.getModifierSets().stream()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M__MODIFIER_SETS,\r\n\t\tmodifierSets.size(), modifierSets.toArray());"
		   });	
		addAnnotation
		  (getPAMTraM_ModifierSets(), 
		   source, 
		   new String[] {
			 "documentation", "The list of all ValueModifierSets contained in all local and global/shared MappingModels."
		   });	
		addAnnotation
		  (getPAMTraM_ConditionModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of ConditionModels contained in this PAMTraM instance.\r\n<br />\r\nTogether with the list of \'sharedConditionModels\', these make up the list of ConditionModels defining the global Conditions that can be referenced by other elements in the PAMTraM model."
		   });	
		addAnnotation
		  (getPAMTraM_SharedConditionModels(), 
		   source, 
		   new String[] {
			 "documentation", "The list of external ConditionModels (stored in their own files with the file-ending \'*.pamtram.condition\') referenced by this PAMTraM instance.\r\n<br />\r\nTogether with the list of (local) \'conditionModels\', these make up the list of ConditionModels defining the global Conditions that can be referenced by other elements in the PAMTraM model."
		   });	
		addAnnotation
		  (sectionModelEClass, 
		   source, 
		   new String[] {
			 "documentation", "SectionModels contain a list of Sections representing element structures. All element structures need to be based on the meta-model/EPackage identified by the \'metaModelPackage\' reference."
		   });	
		addAnnotation
		  (getSectionModel_MetaModelPackage(), 
		   source, 
		   new String[] {
			 "documentation", "The meta-model (represented by an EPackage) based on which all element structures (Sections) in this SectionModel need to be based."
		   });	
		addAnnotation
		  (getSectionModel_Sections(), 
		   source, 
		   new String[] {
			 "documentation", "The list of Sections defined by this SectionModel.\r\n<br />\r\nAll Sections need to be based on the meta-model/EPackage specified via the \'metaModelPackage\' reference."
		   });	
		addAnnotation
		  (sourceSectionModelEClass, 
		   source, 
		   new String[] {
			 "documentation", "A SourceSectionModel contains a list of SourceSections which can act as the left-hand side (LHS) of a Mapping."
		   });	
		addAnnotation
		  (targetSectionModelEClass, 
		   source, 
		   new String[] {
			 "documentation", "A TargetSectionModel contains a list of TargetSections which can act as the right-hand side (RHS) of a Mapping."
		   });	
		addAnnotation
		  (getTargetSectionModel_LibraryElements(), 
		   source, 
		   new String[] {
			 "documentation", "The list of LibraryElement-based TargetSections defined by this SectionModel."
		   });	
		addAnnotation
		  (mappingModelEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingModel contains a list of Mapping which will be executed by the transformation algorithm."
		   });	
		addAnnotation
		  (getMappingModel_Mappings(), 
		   source, 
		   new String[] {
			 "documentation", "The list of Mappings which are contained in this MappingModel. These will be executed by the transformation algorithm.\r\n<br />\r\nNote: Only \'active\' Mappings will actually be executed (also see the \'activeMappings\' reference)."
		   });	
		addAnnotation
		  (getMappingModel_ModifierSets(), 
		   source, 
		   new String[] {
			 "documentation", "The list of ValueModiferSets which are contained in this MappingModel."
		   });	
		addAnnotation
		  (getMappingModel_GlobalValues(), 
		   source, 
		   new String[] {
			 "documentation", "A list of global FixedValues. These values can e.g. be used in calculations of values of attributes in TargetSections. Therefore, they can be referenced in expressions via their name."
		   });	
		addAnnotation
		  (getMappingModel_ActiveMappings(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><Mapping> mappings = this.getMappings().stream().filter(m -> !m.isDeactivated() && !m.isAbstract()).collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.PamtramPackage%>.Literals.MAPPING_MODEL__ACTIVE_MAPPINGS,\r\n\t\tmappings.size(), mappings.toArray());"
		   });	
		addAnnotation
		  (getMappingModel_ActiveMappings(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the Mappings contained in this MappingModel that are not \'deactivated\'. These will be executed by the transformation algorithm."
		   });	
		addAnnotation
		  (getMappingModel_GlobalAttributes(), 
		   source, 
		   new String[] {
			 "documentation", "The list of GlobalAttributes defined by this MappingModel."
		   });	
		addAnnotation
		  (conditionalElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ConditionalElement is an element that can be attached with a Condition which restrains its applicability during the course of a transformation. This can e.g. be used to specify a platform condition which ensures that the element will only be evaluated if a certain scree size is available."
		   });	
		addAnnotation
		  (getConditionalElement__ValidateEitherModelOrReferCondition__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = !(this.getLocalCondition() != null && this.getSharedCondition() != null);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Please specify at most one (local or shared) condition!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\tPamtramValidator.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.util.PamtramValidator%>.CONDITIONAL_ELEMENT__VALIDATE_EITHER_MODEL_OR_REFER_CONDITION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getConditionalElement__ValidateReferenceOnlyConditionsFromConditionModel__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getSharedCondition() == null || this.getSharedCondition().eContainer() instanceof <%pamtram.ConditionModel%>;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"It is only allowed to reference shared conditions that are model inside the ConditionModel!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\tPamtramValidator.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.util.PamtramValidator%>.CONDITIONAL_ELEMENT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getConditionalElement_LocalCondition(), 
		   source, 
		   new String[] {
			 "documentation", "The (locally defined) Condition which restrains the applicability of this element during the course of a transformation.\r\n<br />\r\nThis can e.g. be used to specify a platform condition which ensures that the element will only be evaluated if a certain scree size is available.\r\n<br />\r\nNote: Only one of \'localCondition\' or \'sharedCondition\' may be set for each element!"
		   });	
		addAnnotation
		  (getConditionalElement_SharedCondition(), 
		   source, 
		   new String[] {
			 "documentation", "The (globally defined) referenced Condition which restrains the applicability of this element during the course of a transformation.\r\n<br />\r\nThis can e.g. be used to specify a platform condition which ensures that the element will only be evaluated if a certain scree size is available.\r\n<br />\r\nNote: Only one of \'localCondition\' or \'sharedCondition\' may be set for each element!"
		   });	
		addAnnotation
		  (conditionModelEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ConditionModel contains a list of (global, reusable) Conditions which can be attached to ConditionalElements in order to restrain their applicability.\r\n<br />\r\nIn order to reference global conditions from a ConditionModel, you have to use a \'sharedCondition(s)\' non-containment reference (e.g. present for a ConditionalElement)."
		   });	
		addAnnotation
		  (getConditionModel_Conditions(), 
		   source, 
		   new String[] {
			 "documentation", "The lis of (global, reusable) Conditions defined by this ConditionModel."
		   });	
		addAnnotation
		  (expressionElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "An ExpressionElement can be equipped with a mathematical expression describing how to calculate the (numeric) value of this element.\r\n<br />\r\nThe specific meaning of the calculated \'value\' is dependent on the concrete sub-type of this element."
		   });	
		addAnnotation
		  (getExpressionElement_Expression(), 
		   source, 
		   new String[] {
			 "documentation", "A mathematical expression describing how to calculate the (numeric) value of this element.\r\n<br />\r\nThe specific meaning of the calculated \'value\' is dependent on the concrete type of this element.\r\n<br />\r\nNote: Variables (e.g. global FixedValues or specified source elements) can be referenced in the expression via their name, e.g. \'2*x\' if their is a (local) source element or a global FixedValue named \'x\'."
		   });	
		addAnnotation
		  (modifiableElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ModifiableElement can be equipped with a list of \'ValueModifierSets\' that will be applied on the value of this element.\r\n<br />\r\nThe specific meaning of the modified \'value\' is dependent on the concrete sub-type of this element."
		   });	
		addAnnotation
		  (getModifiableElement_Modifiers(), 
		   source, 
		   new String[] {
			 "documentation", "The list of \'ValueModifierSets\' that will be applied on the value of this element.\r\n<br />\r\nThe specific meaning of the modified \'value\' is dependent on the concrete sub-type of this element."
		   });	
		addAnnotation
		  (fixedValueEClass, 
		   source, 
		   new String[] {
			 "documentation", "This simply represents a certain numeric or literal value. It can be used e.g. as part of an AttributeMapping to specify the value of a TargetSectionAttribute."
		   });	
		addAnnotation
		  (getFixedValue_Value(), 
		   source, 
		   new String[] {
			 "documentation", "The numeric or literal value."
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
