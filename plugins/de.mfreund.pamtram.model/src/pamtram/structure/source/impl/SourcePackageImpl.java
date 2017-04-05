/**
 */
package pamtram.structure.source.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pamtram.PamtramPackage;

import pamtram.condition.ConditionPackage;

import pamtram.condition.impl.ConditionPackageImpl;

import pamtram.impl.PamtramPackageImpl;

import pamtram.mapping.MappingPackage;

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
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.SourceSectionReference;

import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.structure.source.util.SourceValidator;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.impl.TargetPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourcePackageImpl extends EPackageImpl implements SourcePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionCompositeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionCrossReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualSourceSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualSourceSectionAttributeEClass = null;

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
	 * @see pamtram.structure.source.SourcePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SourcePackageImpl() {
		super(eNS_URI, SourceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SourcePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SourcePackage init() {
		if (isInited) return (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);

		// Obtain or create and register package
		SourcePackageImpl theSourcePackage = (SourcePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SourcePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SourcePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) : GenericPackage.eINSTANCE);
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) : ConstraintPackage.eINSTANCE);
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) : TargetPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);

		// Create package meta-data objects
		theSourcePackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();

		// Initialize created meta-data
		theSourcePackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theSourcePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return SourceValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theSourcePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SourcePackage.eNS_URI, theSourcePackage);
		return theSourcePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSection() {
		return sourceSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceSection_ReferencingMappings() {
		return (EReference)sourceSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSourceSection__ValidateIsReferencedByMapping__DiagnosticChain_Map() {
		return sourceSectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionClass() {
		return sourceSectionClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceSectionClass_IncludeSubTypes() {
		return (EAttribute)sourceSectionClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionReference() {
		return sourceSectionReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceSectionReference_IgnoreUnmatchedElements() {
		return (EAttribute)sourceSectionReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionCompositeReference() {
		return sourceSectionCompositeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionCrossReference() {
		return sourceSectionCrossReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceSectionAttribute() {
		return sourceSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceSectionAttribute_ValueConstraints() {
		return (EReference)sourceSectionAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualSourceSectionAttribute() {
		return actualSourceSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualSourceSectionAttribute() {
		return virtualSourceSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualSourceSectionAttribute_Derivation() {
		return (EAttribute)virtualSourceSectionAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVirtualSourceSectionAttribute__ValidateDerivation__DiagnosticChain_Map() {
		return virtualSourceSectionAttributeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFactory getSourceFactory() {
		return (SourceFactory)getEFactoryInstance();
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
		sourceSectionEClass = createEClass(SOURCE_SECTION);
		createEReference(sourceSectionEClass, SOURCE_SECTION__REFERENCING_MAPPINGS);
		createEOperation(sourceSectionEClass, SOURCE_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP);

		sourceSectionClassEClass = createEClass(SOURCE_SECTION_CLASS);
		createEAttribute(sourceSectionClassEClass, SOURCE_SECTION_CLASS__INCLUDE_SUB_TYPES);

		sourceSectionReferenceEClass = createEClass(SOURCE_SECTION_REFERENCE);
		createEAttribute(sourceSectionReferenceEClass, SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS);

		sourceSectionCompositeReferenceEClass = createEClass(SOURCE_SECTION_COMPOSITE_REFERENCE);

		sourceSectionCrossReferenceEClass = createEClass(SOURCE_SECTION_CROSS_REFERENCE);

		sourceSectionAttributeEClass = createEClass(SOURCE_SECTION_ATTRIBUTE);
		createEReference(sourceSectionAttributeEClass, SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINTS);

		actualSourceSectionAttributeEClass = createEClass(ACTUAL_SOURCE_SECTION_ATTRIBUTE);

		virtualSourceSectionAttributeEClass = createEClass(VIRTUAL_SOURCE_SECTION_ATTRIBUTE);
		createEAttribute(virtualSourceSectionAttributeEClass, VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION);
		createEOperation(virtualSourceSectionAttributeEClass, VIRTUAL_SOURCE_SECTION_ATTRIBUTE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP);
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
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);
		ConstraintPackage theConstraintPackage = (ConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getSourceSectionClass());
		sourceSectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		EGenericType g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionClassEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCompositeReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionReference());
		sourceSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCrossReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionReference());
		sourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionAttribute());
		actualSourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getActualAttribute());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		actualSourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionAttribute());
		virtualSourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getVirtualAttribute());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		virtualSourceSectionAttributeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(sourceSectionEClass, SourceSection.class, "SourceSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSection_ReferencingMappings(), theMappingPackage.getMappingType(), null, "referencingMappings", null, 0, -1, SourceSection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSourceSection__ValidateIsReferencedByMapping__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIsReferencedByMapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sourceSectionClassEClass, SourceSectionClass.class, "SourceSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceSectionClass_IncludeSubTypes(), ecorePackage.getEBoolean(), "includeSubTypes", "true", 1, 1, SourceSectionClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionReferenceEClass, SourceSectionReference.class, "SourceSectionReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceSectionReference_IgnoreUnmatchedElements(), ecorePackage.getEBoolean(), "ignoreUnmatchedElements", "false", 1, 1, SourceSectionReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionCompositeReferenceEClass, SourceSectionCompositeReference.class, "SourceSectionCompositeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceSectionCrossReferenceEClass, SourceSectionCrossReference.class, "SourceSectionCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceSectionAttributeEClass, SourceSectionAttribute.class, "SourceSectionAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceSectionAttribute_ValueConstraints(), theConstraintPackage.getValueConstraint(), null, "valueConstraints", null, 0, -1, SourceSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualSourceSectionAttributeEClass, ActualSourceSectionAttribute.class, "ActualSourceSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(virtualSourceSectionAttributeEClass, VirtualSourceSectionAttribute.class, "VirtualSourceSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVirtualSourceSectionAttribute_Derivation(), ecorePackage.getEString(), "derivation", null, 1, 1, VirtualSourceSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVirtualSourceSectionAttribute__ValidateDerivation__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDerivation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create annotations
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
		  (sourceSectionEClass, 
		   source, 
		   new String[] {
			 "constraints", "isReferencedByMapping"
		   });	
		addAnnotation
		  (sourceSectionCrossReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "valuesMatchReferenceType"
		   });
	}

} //SourcePackageImpl
