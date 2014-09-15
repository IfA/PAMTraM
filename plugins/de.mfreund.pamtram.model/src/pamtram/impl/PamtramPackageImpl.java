/**
 */
package pamtram.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import pamtram.MappingModel;
import pamtram.NamedElement;
import pamtram.PAMTraM;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;
import pamtram.TransformationModel;
import pamtram.condition.ConditionPackage;
import pamtram.condition.impl.ConditionPackageImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.impl.MetamodelPackageImpl;
import pamtram.transformation.TransformationPackage;
import pamtram.transformation.impl.TransformationPackageImpl;

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
	private EClass transformationModelEClass = null;

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

		// Obtain or create and register interdependencies
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) instanceof MetamodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) : MetamodelPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		TransformationPackageImpl theTransformationPackage = (TransformationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) instanceof TransformationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) : TransformationPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);

		// Create package meta-data objects
		thePamtramPackage.createPackageContents();
		theMetamodelPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theTransformationPackage.createPackageContents();
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		thePamtramPackage.initializePackageContents();
		theMetamodelPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theTransformationPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();

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
	public EClass getPAMTraM() {
		return pamTraMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_ContextMetaModelPackage() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_SourceSectionModel() {
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
	public EReference getPAMTraM_MappingModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPAMTraM_TransformationModel() {
		return (EReference)pamTraMEClass.getEStructuralFeatures().get(4);
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
	public EClass getSourceSectionModel() {
		return sourceSectionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceSectionModel_MetaModelSections() {
		return (EReference)sourceSectionModelEClass.getEStructuralFeatures().get(0);
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
	public EReference getTargetSectionModel_MetaModelSections() {
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
	public EClass getTransformationModel() {
		return transformationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationModel_Transformation() {
		return (EReference)transformationModelEClass.getEStructuralFeatures().get(0);
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

		pamTraMEClass = createEClass(PAM_TRA_M);
		createEReference(pamTraMEClass, PAM_TRA_M__CONTEXT_META_MODEL_PACKAGE);
		createEReference(pamTraMEClass, PAM_TRA_M__SOURCE_SECTION_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__TARGET_SECTION_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__MAPPING_MODEL);
		createEReference(pamTraMEClass, PAM_TRA_M__TRANSFORMATION_MODEL);

		sectionModelEClass = createEClass(SECTION_MODEL);
		createEReference(sectionModelEClass, SECTION_MODEL__META_MODEL_PACKAGE);

		sourceSectionModelEClass = createEClass(SOURCE_SECTION_MODEL);
		createEReference(sourceSectionModelEClass, SOURCE_SECTION_MODEL__META_MODEL_SECTIONS);

		targetSectionModelEClass = createEClass(TARGET_SECTION_MODEL);
		createEReference(targetSectionModelEClass, TARGET_SECTION_MODEL__META_MODEL_SECTIONS);

		mappingModelEClass = createEClass(MAPPING_MODEL);
		createEReference(mappingModelEClass, MAPPING_MODEL__MAPPING);
		createEReference(mappingModelEClass, MAPPING_MODEL__MODIFIER_SETS);
		createEReference(mappingModelEClass, MAPPING_MODEL__GLOBAL_VALUES);

		transformationModelEClass = createEClass(TRANSFORMATION_MODEL);
		createEReference(transformationModelEClass, TRANSFORMATION_MODEL__TRANSFORMATION);
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
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);
		ConditionPackage theConditionPackage = (ConditionPackage)EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI);
		TransformationPackage theTransformationPackage = (TransformationPackage)EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theMetamodelPackage);
		getESubpackages().add(theConditionPackage);
		getESubpackages().add(theTransformationPackage);
		getESubpackages().add(theMappingPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sourceSectionModelEClass.getESuperTypes().add(this.getSectionModel());
		targetSectionModelEClass.getESuperTypes().add(this.getSectionModel());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pamTraMEClass, PAMTraM.class, "PAMTraM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPAMTraM_ContextMetaModelPackage(), ecorePackage.getEPackage(), null, "contextMetaModelPackage", null, 0, -1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_SourceSectionModel(), this.getSourceSectionModel(), null, "sourceSectionModel", null, 1, 1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_TargetSectionModel(), this.getTargetSectionModel(), null, "targetSectionModel", null, 1, 1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_MappingModel(), this.getMappingModel(), null, "mappingModel", null, 1, 1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPAMTraM_TransformationModel(), this.getTransformationModel(), null, "transformationModel", null, 0, 1, PAMTraM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sectionModelEClass, SectionModel.class, "SectionModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSectionModel_MetaModelPackage(), ecorePackage.getEPackage(), null, "metaModelPackage", null, 1, 1, SectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionModelEClass, SourceSectionModel.class, "SourceSectionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSectionModel_MetaModelSections(), theMetamodelPackage.getSourceSectionClass(), null, "metaModelSections", null, 0, -1, SourceSectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetSectionModelEClass, TargetSectionModel.class, "TargetSectionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetSectionModel_MetaModelSections(), theMetamodelPackage.getTargetSectionClass(), null, "metaModelSections", null, 0, -1, TargetSectionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingModelEClass, MappingModel.class, "MappingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingModel_Mapping(), theMappingPackage.getMapping(), null, "mapping", null, 1, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_ModifierSets(), theMappingPackage.getAttributeValueModifierSet(), null, "modifierSets", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingModel_GlobalValues(), theMappingPackage.getGlobalValue(), null, "globalValues", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationModelEClass, TransformationModel.class, "TransformationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationModel_Transformation(), theTransformationPackage.getTransformation(), null, "transformation", null, 0, -1, TransformationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PamtramPackageImpl