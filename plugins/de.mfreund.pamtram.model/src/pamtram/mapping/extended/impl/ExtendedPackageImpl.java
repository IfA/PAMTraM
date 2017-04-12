/**
 */
package pamtram.mapping.extended.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

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

import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMappingExternalSourceElement;
import pamtram.mapping.extended.AttributeMappingGlobalSourceElement;
import pamtram.mapping.extended.AttributeMappingSourceElement;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingExternalSourceElement;
import pamtram.mapping.extended.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceInterface;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.util.ExtendedValidator;
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
public class ExtendedPackageImpl extends EPackageImpl implements ExtendedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingSourceInterfaceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingExternalSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingGlobalSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingSourceInterfaceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingExternalSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingGlobalSourceElementEClass = null;
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
	 * @see pamtram.mapping.extended.ExtendedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtendedPackageImpl() {
		super(eNS_URI, ExtendedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExtendedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtendedPackage init() {
		if (isInited) return (ExtendedPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI);

		// Obtain or create and register package
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtendedPackageImpl());

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
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);

		// Create package meta-data objects
		theExtendedPackage.createPackageContents();
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

		// Initialize created meta-data
		theExtendedPackage.initializePackageContents();
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

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theExtendedPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ExtendedValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theExtendedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExtendedPackage.eNS_URI, theExtendedPackage);
		return theExtendedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMapping() {
		return attributeMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMapping_Target() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMapping_SourceElements() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMapping__GetLocalSourceElements() {
		return attributeMappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMapping__GetExternalSourceElements() {
		return attributeMappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map() {
		return attributeMappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingSourceInterface() {
		return attributeMappingSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingSourceElement() {
		return attributeMappingSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingExternalSourceElement() {
		return attributeMappingExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingGlobalSourceElement() {
		return attributeMappingGlobalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMapping() {
		return cardinalityMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCardinalityMapping_Source() {
		return (EReference)cardinalityMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCardinalityMapping_Target() {
		return (EReference)cardinalityMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCardinalityMapping_SourceElements() {
		return (EReference)cardinalityMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateSourceElementMatchesSection__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateOnlySourceOrSourceElements__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateExpressionOnlyForSourceElements__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateModifiersOnlyForSourceElements__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__GetLocalSourceElements() {
		return cardinalityMappingEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__GetExternalSourceElements() {
		return cardinalityMappingEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingSourceInterface() {
		return cardinalityMappingSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingSourceElement() {
		return cardinalityMappingSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingExternalSourceElement() {
		return cardinalityMappingExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingGlobalSourceElement() {
		return cardinalityMappingGlobalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedFactory getExtendedFactory() {
		return (ExtendedFactory)getEFactoryInstance();
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
		attributeMappingEClass = createEClass(ATTRIBUTE_MAPPING);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__TARGET);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);

		attributeMappingSourceInterfaceEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_INTERFACE);

		attributeMappingSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_ELEMENT);

		attributeMappingExternalSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT);

		attributeMappingGlobalSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT);

		cardinalityMappingEClass = createEClass(CARDINALITY_MAPPING);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__SOURCE);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__TARGET);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__SOURCE_ELEMENTS);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS);

		cardinalityMappingSourceInterfaceEClass = createEClass(CARDINALITY_MAPPING_SOURCE_INTERFACE);

		cardinalityMappingSourceElementEClass = createEClass(CARDINALITY_MAPPING_SOURCE_ELEMENT);

		cardinalityMappingExternalSourceElementEClass = createEClass(CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT);

		cardinalityMappingGlobalSourceElementEClass = createEClass(CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT);
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
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);
		StructurePackage theStructurePackage = (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		attributeMappingEClass.getESuperTypes().add(theMappingPackage.getMappingHint());
		attributeMappingEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		attributeMappingEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		attributeMappingEClass.getESuperTypes().add(theMappingPackage.getExpandableHint());
		attributeMappingSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
		EGenericType g1 = createEGenericType(theStructurePackage.getLocalDynamicSourceElement());
		EGenericType g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getGlobalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getSourceInstanceSelector());
		g1.getETypeArguments().add(g2);
		attributeMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		cardinalityMappingEClass.getESuperTypes().add(theMappingPackage.getMappingHint());
		cardinalityMappingEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		cardinalityMappingEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		cardinalityMappingSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
		g1 = createEGenericType(theStructurePackage.getLocalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		cardinalityMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCardinalityMappingSourceInterface());
		cardinalityMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		cardinalityMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCardinalityMappingSourceInterface());
		cardinalityMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getGlobalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getSourceInstanceSelector());
		g1.getETypeArguments().add(g2);
		cardinalityMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCardinalityMappingSourceInterface());
		cardinalityMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(attributeMappingEClass, AttributeMapping.class, "AttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMapping_Target(), theTargetPackage.getTargetSectionAttribute(), null, "target", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMapping_SourceElements(), this.getAttributeMappingSourceInterface(), null, "sourceElements", null, 1, -1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttributeMapping__GetLocalSourceElements(), this.getAttributeMappingSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttributeMapping__GetExternalSourceElements(), this.getAttributeMappingExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetAttributeMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeMappingSourceInterfaceEClass, AttributeMappingSourceInterface.class, "AttributeMappingSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingSourceElementEClass, AttributeMappingSourceElement.class, "AttributeMappingSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingExternalSourceElementEClass, AttributeMappingExternalSourceElement.class, "AttributeMappingExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingGlobalSourceElementEClass, AttributeMappingGlobalSourceElement.class, "AttributeMappingGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingEClass, CardinalityMapping.class, "CardinalityMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theGenericPackage.getMetaModelElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		initEReference(getCardinalityMapping_Source(), g1, null, "source", null, 0, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCardinalityMapping_Target(), theTargetPackage.getTargetSectionClass(), null, "target", null, 1, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCardinalityMapping_SourceElements(), this.getCardinalityMappingSourceInterface(), null, "sourceElements", null, 0, -1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateSourceElementMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceElementMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetClassMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceClassIsVariableCardinality", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetClassIsVariableCardinality", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoCardinalityMappingForSourceSectionRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateOnlySourceOrSourceElements__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlySourceOrSourceElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateExpressionOnlyForSourceElements__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateExpressionOnlyForSourceElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateModifiersOnlyForSourceElements__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateModifiersOnlyForSourceElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getCardinalityMapping__GetLocalSourceElements(), this.getCardinalityMappingSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getCardinalityMapping__GetExternalSourceElements(), this.getCardinalityMappingExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(cardinalityMappingSourceInterfaceEClass, CardinalityMappingSourceInterface.class, "CardinalityMappingSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingSourceElementEClass, CardinalityMappingSourceElement.class, "CardinalityMappingSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingExternalSourceElementEClass, CardinalityMappingExternalSourceElement.class, "CardinalityMappingExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingGlobalSourceElementEClass, CardinalityMappingGlobalSourceElement.class, "CardinalityMappingGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		  (attributeMappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "targetAttributeMatchesSection"
		   });	
		addAnnotation
		  (cardinalityMappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceClassMatchesSection sourceClassIsVariableCardinality targetClassMatchesSection targetClassIsVariableCardinality noCardinalityMappingForSourceSectionRoot"
		   });
	}

} //ExtendedPackageImpl
