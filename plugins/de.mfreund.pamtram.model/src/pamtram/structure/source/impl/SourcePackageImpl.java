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
import pamtram.structure.source.VirtualSourceSectionCrossReference;
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
	private EClass virtualSourceSectionCrossReferenceEClass = null;

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
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

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
		theExtendedPackage.createPackageContents();

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
		theExtendedPackage.initializePackageContents();

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
	public EClass getVirtualSourceSectionCrossReference() {
		return virtualSourceSectionCrossReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVirtualSourceSectionCrossReference_Derivation() {
		return (EAttribute)virtualSourceSectionCrossReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVirtualSourceSectionCrossReference__ValidateDerivation__DiagnosticChain_Map() {
		return virtualSourceSectionCrossReferenceEClass.getEOperations().get(0);
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

		virtualSourceSectionCrossReferenceEClass = createEClass(VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE);
		createEAttribute(virtualSourceSectionCrossReferenceEClass, VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION);
		createEOperation(virtualSourceSectionCrossReferenceEClass, VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_DERIVATION__DIAGNOSTICCHAIN_MAP);

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
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
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
		g1 = createEGenericType(thePamtramPackage.getDeactivatableElement());
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
		g1 = createEGenericType(theGenericPackage.getActualReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
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
		g1 = createEGenericType(theGenericPackage.getActualReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		sourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCrossReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		virtualSourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSourceSectionReference());
		virtualSourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getVirtualReference());
		g2 = createEGenericType(this.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		virtualSourceSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
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

		initEClass(virtualSourceSectionCrossReferenceEClass, VirtualSourceSectionCrossReference.class, "VirtualSourceSectionCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVirtualSourceSectionCrossReference_Derivation(), ecorePackage.getEString(), "derivation", null, 1, 1, VirtualSourceSectionCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVirtualSourceSectionCrossReference__ValidateDerivation__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDerivation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

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
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
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
			 "documentation", "This package contains all elements related to the description of source element structures (aka SourceSections). These form the left-hand side (LHS) of a mapping."
		   });	
		addAnnotation
		  (sourceSectionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A special SourceSectionClass that represents the root element (as an instance of an EClass) of an element structure in a source model.\r\n<br />\r\nNote: Every specified source model structure must contain one and only one SourceSection element (its root element)."
		   });	
		addAnnotation
		  (getSourceSection__ValidateIsReferencedByMapping__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = !this.getReferencingMappings().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The section is not referenced by any mapping!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.structure.source.util.SourceValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tSourceValidator.SOURCE_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.source.SourcePackage%>.Literals.SOURCE_SECTION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getSourceSection_ReferencingMappings(), 
		   source, 
		   new String[] {
			 "get", "\r\nList<<%pamtram.mapping.Mapping%>> mappings = new <%java.util.ArrayList%><>();\r\n\r\nif (this.eResource() != null) {\r\n\r\n\tmappings = this.eResource().getResourceSet().getResources().stream()\r\n\t\t\t.filter(r -> r.getContents().get(0) instanceof pamtram.PAMTraM)\r\n\t\t\t.flatMap(r -> ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().stream())\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n}\r\n\r\nList<Mapping> referencingMappings = mappings.stream().filter(m -> this.equals(m.getSourceSection())).collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList%><>(this, <%pamtram.structure.source.SourcePackage%>.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS,\r\n\t\treferencingMappings.size(), referencingMappings.toArray());"
		   });	
		addAnnotation
		  (getSourceSection_ReferencingMappings(), 
		   source, 
		   new String[] {
			 "documentation", "All Mappings that are based on this SourceSection (that specify this as their \'sourceSection\')."
		   });	
		addAnnotation
		  (sourceSectionClassEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents one element (as an instance of an EClass) of a source model element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, Classes can be equipped with Attributes and References (which itself may reference/contain other Classes)."
		   });	
		addAnnotation
		  (getSourceSectionClass_IncludeSubTypes(), 
		   source, 
		   new String[] {
			 "documentation", "Whether this shall also represent source model elements that are instances of sub-classes of the specified EClass."
		   });	
		addAnnotation
		  (sourceSectionReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference of a source model element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getSourceSectionReference_IgnoreUnmatchedElements(), 
		   source, 
		   new String[] {
			 "documentation", "This determines the matching behavior in the case that there are source model elements that are not covered by one of the Classes specified as \'value\' for this Reference.\r\n<br /><br />\r\nIf this is set to \'true\', the source model excerpt will nonetheless be declared a match for this SourceSection.\r\n<br />\r\nIf this is set to \'false\', the source model excerpt will NOT be declared a match. This means, that all source model elements referenced via this Reference need to matched against Classes specified as \'value\' for this Reference."
		   });	
		addAnnotation
		  (sourceSectionCompositeReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference (as an instance of an EReference) of a source model element structure. CompositeReferences can be used to describe the tree that is the basis of an element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (sourceSectionCrossReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference (as an instance of an EReference) of a source model element structure. CrossReferences can be used to describe references to other element structures or to other elements of this structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (virtualSourceSectionCrossReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference of a source model element structure. CrossReferences can be used to describe references to other element structures or to other elements of this structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference.\r\n<br /><br />\r\nIn contrast to \'actual\' References, \'virtual\' Reference do not represent an actual metamodel element (EReference) but can be used to create additional (virtual) references. As the Reference is not based on an actual EReference, the actual instances of the specified target Classes need to be specified manually. Therefore, a \'derivation\' specification has to be given by the modeler."
		   });	
		addAnnotation
		  (getVirtualSourceSectionCrossReference__ValidateDerivation__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (this.getDerivation() == null || this.getDerivation().isEmpty()\r\n\t\t|| !(this.eContainer() instanceof SourceSectionClass)\r\n\t\t|| ((<%pamtram.structure.source.SourceSectionClass%>) this.eContainer()).getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = true;\r\nString parserException = \"\";\r\n\r\ntry {\r\n\t<%pamtram.util.OCLUtil%>.validateQuery(this.getDerivation(), ((SourceSectionClass) this.eContainer()).getEClass());\r\n} catch (<%org.eclipse.ocl.ParserException%> e) {\r\n\tresult = false;\r\n\tparserException = e.getMessage();\r\n\te.printStackTrace();\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The specified derivation is not valid! The following error was provided: \" + parserException;\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.source.util.SourceValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tSourceValidator.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__VALIDATE_DERIVATION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.source.SourcePackage%>.Literals.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getVirtualSourceSectionCrossReference_Derivation(), 
		   source, 
		   new String[] {
			 "documentation", "An OCL expression describing the derivation of the actual instances of the specified target Classes."
		   });	
		addAnnotation
		  (sourceSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute of a source model element structure."
		   });	
		addAnnotation
		  (getSourceSectionAttribute_ValueConstraints(), 
		   source, 
		   new String[] {
			 "documentation", "A list of ValueConstraints that specify a single reference value or a list/range of reference values which the actual attribute value must or must not satisfy.\r\n<br /><br />\r\nA certain attribute (value) in a source model will only match against this Attribute if all specified constraints are met."
		   });	
		addAnnotation
		  (actualSourceSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute (as an instance of an EAttribute) of a source model element structure."
		   });	
		addAnnotation
		  (virtualSourceSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute of a source model element structure. In contrast to \'actual\' Attributes, \'virtual\' Attributes do not represent an actual metamodel element (EAttribtue) but can be used to create additional (virtual) attributes.\r\n<br />\r\n As the Attribute is not based on an actual EAttribute, the actual values held by this Attribute need to be specified manually. Therefore, a \'derivation\' specification has to be given by the modeler."
		   });	
		addAnnotation
		  (getVirtualSourceSectionAttribute__ValidateDerivation__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (this.getDerivation() == null || this.getDerivation().isEmpty()\r\n\t\t|| !(this.eContainer() instanceof SourceSectionClass)\r\n\t\t|| ((<%pamtram.structure.source.SourceSectionClass%>) this.eContainer()).getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = true;\r\nString parserException = \"\";\r\n\r\ntry {\r\n\t<%pamtram.util.OCLUtil%>.validateQuery(this.getDerivation(), ((SourceSectionClass) this.eContainer()).getEClass());\r\n} catch (<%org.eclipse.ocl.ParserException%> e) {\r\n\tresult = false;\r\n\tparserException = e.getMessage();\r\n\te.printStackTrace();\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The specified derivation is not valid! The following error was provided: \" + parserException;\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.source.util.SourceValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tSourceValidator.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__VALIDATE_DERIVATION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.source.SourcePackage%>.Literals.VIRTUAL_SOURCE_SECTION_ATTRIBUTE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getVirtualSourceSectionAttribute_Derivation(), 
		   source, 
		   new String[] {
			 "documentation", "An OCL expression describing the derivation of the actual value(s) of this attribute."
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
