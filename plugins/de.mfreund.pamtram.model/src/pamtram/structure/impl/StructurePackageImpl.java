/**
 */
package pamtram.structure.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
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
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorGlobalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.impl.ConstraintPackageImpl;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.GenericPackageImpl;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.library.impl.LibraryPackageImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.impl.SourcePackageImpl;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.impl.TargetPackageImpl;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructurePackageImpl extends EPackageImpl implements StructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceInstanceSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetInstanceSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceSelectorSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceSelectorSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceSelectorExternalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceSelectorGlobalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localDynamicSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalDynamicSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalDynamicSourceElementEClass = null;

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
	 * @see pamtram.structure.StructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StructurePackageImpl() {
		super(eNS_URI, StructureFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StructurePackage init() {
		if (isInited) return (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);

		// Obtain or create and register package
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
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
		theStructurePackage.createPackageContents();
		thePamtramPackage.createPackageContents();
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
		theStructurePackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
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
			(theStructurePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return StructureValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theStructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StructurePackage.eNS_URI, theStructurePackage);
		return theStructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceSelector() {
		return instanceSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceSelector_SourceElements() {
		return (EReference)instanceSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceSelector__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map() {
		return instanceSelectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceSelector__GetLocalSourceElements() {
		return instanceSelectorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInstanceSelector__GetExternalSourceElements() {
		return instanceSelectorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceInstanceSelector() {
		return sourceInstanceSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceInstanceSelector_Target() {
		return (EReference)sourceInstanceSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetInstanceSelector() {
		return targetInstanceSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetInstanceSelector_Target() {
		return (EReference)targetInstanceSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceSelectorSourceInterface() {
		return instanceSelectorSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceSelectorSourceElement() {
		return instanceSelectorSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceSelectorExternalSourceElement() {
		return instanceSelectorExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceSelectorGlobalSourceElement() {
		return instanceSelectorGlobalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicSourceElement() {
		return dynamicSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDynamicSourceElement_Source() {
		return (EReference)dynamicSourceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDynamicSourceElement__GetMappingHintGroup() {
		return dynamicSourceElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDynamicSourceElement__GetMapping() {
		return dynamicSourceElementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalDynamicSourceElement() {
		return localDynamicSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalDynamicSourceElement__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map() {
		return localDynamicSourceElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalDynamicSourceElement() {
		return externalDynamicSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalDynamicSourceElement__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map() {
		return externalDynamicSourceElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalDynamicSourceElement() {
		return globalDynamicSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalDynamicSourceElement_InstanceSelectors() {
		return (EReference)globalDynamicSourceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureFactory getStructureFactory() {
		return (StructureFactory)getEFactoryInstance();
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
		instanceSelectorEClass = createEClass(INSTANCE_SELECTOR);
		createEReference(instanceSelectorEClass, INSTANCE_SELECTOR__SOURCE_ELEMENTS);
		createEOperation(instanceSelectorEClass, INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP);
		createEOperation(instanceSelectorEClass, INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(instanceSelectorEClass, INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS);

		sourceInstanceSelectorEClass = createEClass(SOURCE_INSTANCE_SELECTOR);
		createEReference(sourceInstanceSelectorEClass, SOURCE_INSTANCE_SELECTOR__TARGET);

		targetInstanceSelectorEClass = createEClass(TARGET_INSTANCE_SELECTOR);
		createEReference(targetInstanceSelectorEClass, TARGET_INSTANCE_SELECTOR__TARGET);

		instanceSelectorSourceInterfaceEClass = createEClass(INSTANCE_SELECTOR_SOURCE_INTERFACE);

		instanceSelectorSourceElementEClass = createEClass(INSTANCE_SELECTOR_SOURCE_ELEMENT);

		instanceSelectorExternalSourceElementEClass = createEClass(INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT);

		instanceSelectorGlobalSourceElementEClass = createEClass(INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT);

		dynamicSourceElementEClass = createEClass(DYNAMIC_SOURCE_ELEMENT);
		createEReference(dynamicSourceElementEClass, DYNAMIC_SOURCE_ELEMENT__SOURCE);
		createEOperation(dynamicSourceElementEClass, DYNAMIC_SOURCE_ELEMENT___GET_MAPPING_HINT_GROUP);
		createEOperation(dynamicSourceElementEClass, DYNAMIC_SOURCE_ELEMENT___GET_MAPPING);

		localDynamicSourceElementEClass = createEClass(LOCAL_DYNAMIC_SOURCE_ELEMENT);
		createEOperation(localDynamicSourceElementEClass, LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP);

		externalDynamicSourceElementEClass = createEClass(EXTERNAL_DYNAMIC_SOURCE_ELEMENT);
		createEOperation(externalDynamicSourceElementEClass, EXTERNAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP);

		globalDynamicSourceElementEClass = createEClass(GLOBAL_DYNAMIC_SOURCE_ELEMENT);
		createEReference(globalDynamicSourceElementEClass, GLOBAL_DYNAMIC_SOURCE_ELEMENT__INSTANCE_SELECTORS);
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
		ConstraintPackage theConstraintPackage = (ConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI);
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);
		LibraryPackage theLibraryPackage = (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGenericPackage);
		getESubpackages().add(theConstraintPackage);
		getESubpackages().add(theSourcePackage);
		getESubpackages().add(theTargetPackage);
		getESubpackages().add(theLibraryPackage);

		// Create type parameters
		ETypeParameter dynamicSourceElementEClass_S = addETypeParameter(dynamicSourceElementEClass, "S");
		ETypeParameter dynamicSourceElementEClass_C = addETypeParameter(dynamicSourceElementEClass, "C");
		ETypeParameter dynamicSourceElementEClass_R = addETypeParameter(dynamicSourceElementEClass, "R");
		ETypeParameter dynamicSourceElementEClass_A = addETypeParameter(dynamicSourceElementEClass, "A");
		ETypeParameter localDynamicSourceElementEClass_S = addETypeParameter(localDynamicSourceElementEClass, "S");
		ETypeParameter localDynamicSourceElementEClass_C = addETypeParameter(localDynamicSourceElementEClass, "C");
		ETypeParameter localDynamicSourceElementEClass_R = addETypeParameter(localDynamicSourceElementEClass, "R");
		ETypeParameter localDynamicSourceElementEClass_A = addETypeParameter(localDynamicSourceElementEClass, "A");
		ETypeParameter externalDynamicSourceElementEClass_S = addETypeParameter(externalDynamicSourceElementEClass, "S");
		ETypeParameter externalDynamicSourceElementEClass_C = addETypeParameter(externalDynamicSourceElementEClass, "C");
		ETypeParameter externalDynamicSourceElementEClass_R = addETypeParameter(externalDynamicSourceElementEClass, "R");
		ETypeParameter externalDynamicSourceElementEClass_A = addETypeParameter(externalDynamicSourceElementEClass, "A");
		ETypeParameter globalDynamicSourceElementEClass_S = addETypeParameter(globalDynamicSourceElementEClass, "S");
		ETypeParameter globalDynamicSourceElementEClass_C = addETypeParameter(globalDynamicSourceElementEClass, "C");
		ETypeParameter globalDynamicSourceElementEClass_R = addETypeParameter(globalDynamicSourceElementEClass, "R");
		ETypeParameter globalDynamicSourceElementEClass_A = addETypeParameter(globalDynamicSourceElementEClass, "A");
		ETypeParameter globalDynamicSourceElementEClass_InstanceSelectorType = addETypeParameter(globalDynamicSourceElementEClass, "InstanceSelectorType");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theGenericPackage.getSection());
		EGenericType g2 = createEGenericType(dynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		dynamicSourceElementEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(dynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		dynamicSourceElementEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(dynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		dynamicSourceElementEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(dynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(dynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		dynamicSourceElementEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		g2 = createEGenericType(localDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		localDynamicSourceElementEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(localDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		localDynamicSourceElementEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(localDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		localDynamicSourceElementEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(localDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		localDynamicSourceElementEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		g2 = createEGenericType(externalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		externalDynamicSourceElementEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(externalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		externalDynamicSourceElementEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(externalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		externalDynamicSourceElementEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(externalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		externalDynamicSourceElementEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		g2 = createEGenericType(globalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		globalDynamicSourceElementEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(globalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		globalDynamicSourceElementEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(globalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		globalDynamicSourceElementEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(globalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		globalDynamicSourceElementEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getInstanceSelector());
		globalDynamicSourceElementEClass_InstanceSelectorType.getEBounds().add(g1);

		// Add supertypes to classes
		instanceSelectorEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		instanceSelectorEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		sourceInstanceSelectorEClass.getESuperTypes().add(this.getInstanceSelector());
		targetInstanceSelectorEClass.getESuperTypes().add(this.getInstanceSelector());
		instanceSelectorSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
		g1 = createEGenericType(this.getLocalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		instanceSelectorSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInstanceSelectorSourceInterface());
		instanceSelectorSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		instanceSelectorExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInstanceSelectorSourceInterface());
		instanceSelectorExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGlobalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSourceInstanceSelector());
		g1.getETypeArguments().add(g2);
		instanceSelectorGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInstanceSelectorSourceInterface());
		instanceSelectorGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		dynamicSourceElementEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		dynamicSourceElementEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		g1 = createEGenericType(this.getDynamicSourceElement());
		g2 = createEGenericType(localDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		localDynamicSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDynamicSourceElement());
		g2 = createEGenericType(externalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		externalDynamicSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getDynamicSourceElement());
		g2 = createEGenericType(globalDynamicSourceElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalDynamicSourceElementEClass_A);
		g1.getETypeArguments().add(g2);
		globalDynamicSourceElementEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(instanceSelectorEClass, InstanceSelector.class, "InstanceSelector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceSelector_SourceElements(), this.getInstanceSelectorSourceInterface(), null, "sourceElements", null, 0, -1, InstanceSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getInstanceSelector__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoModifiedAttributeElementTypesInConditionModelConditions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceSelector__GetLocalSourceElements(), this.getInstanceSelectorSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getInstanceSelector__GetExternalSourceElements(), this.getInstanceSelectorExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(sourceInstanceSelectorEClass, SourceInstanceSelector.class, "SourceInstanceSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceInstanceSelector_Target(), theSourcePackage.getSourceSectionAttribute(), null, "target", null, 1, 1, SourceInstanceSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetInstanceSelectorEClass, TargetInstanceSelector.class, "TargetInstanceSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetInstanceSelector_Target(), theTargetPackage.getTargetSectionAttribute(), null, "target", null, 1, 1, TargetInstanceSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instanceSelectorSourceInterfaceEClass, InstanceSelectorSourceInterface.class, "InstanceSelectorSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceSelectorSourceElementEClass, InstanceSelectorSourceElement.class, "InstanceSelectorSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceSelectorExternalSourceElementEClass, InstanceSelectorExternalSourceElement.class, "InstanceSelectorExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceSelectorGlobalSourceElementEClass, InstanceSelectorGlobalSourceElement.class, "InstanceSelectorGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dynamicSourceElementEClass, DynamicSourceElement.class, "DynamicSourceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(dynamicSourceElementEClass_A);
		initEReference(getDynamicSourceElement_Source(), g1, null, "source", null, 1, 1, DynamicSourceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDynamicSourceElement__GetMappingHintGroup(), thePamtramPackage.getNamedElement(), "getMappingHintGroup", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDynamicSourceElement__GetMapping(), theMappingPackage.getMapping(), "getMapping", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(localDynamicSourceElementEClass, LocalDynamicSourceElement.class, "LocalDynamicSourceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getLocalDynamicSourceElement__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceAttributeMatchesSectionOrContainedSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(externalDynamicSourceElementEClass, ExternalDynamicSourceElement.class, "ExternalDynamicSourceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getExternalDynamicSourceElement__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceAttributeMatchesContainerSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(globalDynamicSourceElementEClass, GlobalDynamicSourceElement.class, "GlobalDynamicSourceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(globalDynamicSourceElementEClass_InstanceSelectorType);
		initEReference(getGlobalDynamicSourceElement_InstanceSelectors(), g1, null, "instanceSelectors", null, 0, -1, GlobalDynamicSourceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
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
		  (instanceSelectorEClass, 
		   source, 
		   new String[] {
			 "constraints", "noModifiedAttributeElementTypesInConditionModelConditions"
		   });	
		addAnnotation
		  (localDynamicSourceElementEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeMatchesSectionOrContainedSection"
		   });	
		addAnnotation
		  (externalDynamicSourceElementEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeMatchesContainerSection"
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

} //StructurePackageImpl
