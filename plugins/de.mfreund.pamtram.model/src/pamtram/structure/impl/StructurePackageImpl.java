/**
 */
package pamtram.structure.impl;

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
import pamtram.PamtramPackage;
import pamtram.condition.ConditionPackage;
import pamtram.condition.impl.ConditionPackageImpl;
import pamtram.impl.PamtramPackageImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.impl.ModifierPackageImpl;
import pamtram.structure.AttributeParameter;
import pamtram.structure.ContainerParameter;
import pamtram.structure.ExternalModifiedAttributeElementType;
import pamtram.structure.ExternalReferenceParameter;
import pamtram.structure.GlobalModifiedAttributeElementType;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.LibraryEntry;
import pamtram.structure.LibraryParameter;
import pamtram.structure.LocalModifiedAttributeElementType;
import pamtram.structure.ModifiedAttributeElementType;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.ResourceParameter;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.impl.ConstraintPackageImpl;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.GenericPackageImpl;
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
	private EClass libraryParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalReferenceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEntryEClass = null;

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
	private EClass modifiedAttributeElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localModifiedAttributeElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalModifiedAttributeElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalModifiedAttributeElementTypeEClass = null;

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
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);

		// Create package meta-data objects
		theStructurePackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();

		// Initialize created meta-data
		theStructurePackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();

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
	public EClass getLibraryParameter() {
		return libraryParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryParameter_Source() {
		return (EReference)libraryParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryParameter_OriginalParameter() {
		return (EReference)libraryParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeParameter() {
		return attributeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeParameter_Attribute() {
		return (EReference)attributeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerParameter() {
		return containerParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerParameter_Class() {
		return (EReference)containerParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalReferenceParameter() {
		return externalReferenceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalReferenceParameter_Reference() {
		return (EReference)externalReferenceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceParameter() {
		return resourceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceParameter_Attribute() {
		return (EReference)resourceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceParameter_OriginalParameter() {
		return (EReference)resourceParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryEntry() {
		return libraryEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_Parameters() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibraryEntry_LibraryFile() {
		return (EAttribute)libraryEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_Path() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_Id() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_ResourceParameters() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(5);
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
	public EReference getInstanceSelector_Target() {
		return (EReference)instanceSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceSelector_SourceElements() {
		return (EReference)instanceSelectorEClass.getEStructuralFeatures().get(1);
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
	public EClass getModifiedAttributeElementType() {
		return modifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifiedAttributeElementType_Source() {
		return (EReference)modifiedAttributeElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModifiedAttributeElementType__GetMappingHintGroup() {
		return modifiedAttributeElementTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModifiedAttributeElementType__GetMapping() {
		return modifiedAttributeElementTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalModifiedAttributeElementType() {
		return localModifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalModifiedAttributeElementType__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map() {
		return localModifiedAttributeElementTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalModifiedAttributeElementType() {
		return externalModifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalModifiedAttributeElementType__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map() {
		return externalModifiedAttributeElementTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalModifiedAttributeElementType() {
		return globalModifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalModifiedAttributeElementType_InstanceSelectors() {
		return (EReference)globalModifiedAttributeElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_OriginalLibraryEntry() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(2);
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
		libraryParameterEClass = createEClass(LIBRARY_PARAMETER);
		createEReference(libraryParameterEClass, LIBRARY_PARAMETER__SOURCE);
		createEReference(libraryParameterEClass, LIBRARY_PARAMETER__ORIGINAL_PARAMETER);

		attributeParameterEClass = createEClass(ATTRIBUTE_PARAMETER);
		createEReference(attributeParameterEClass, ATTRIBUTE_PARAMETER__ATTRIBUTE);

		containerParameterEClass = createEClass(CONTAINER_PARAMETER);
		createEReference(containerParameterEClass, CONTAINER_PARAMETER__CLASS);

		externalReferenceParameterEClass = createEClass(EXTERNAL_REFERENCE_PARAMETER);
		createEReference(externalReferenceParameterEClass, EXTERNAL_REFERENCE_PARAMETER__REFERENCE);

		resourceParameterEClass = createEClass(RESOURCE_PARAMETER);
		createEReference(resourceParameterEClass, RESOURCE_PARAMETER__ATTRIBUTE);
		createEReference(resourceParameterEClass, RESOURCE_PARAMETER__ORIGINAL_PARAMETER);

		libraryEntryEClass = createEClass(LIBRARY_ENTRY);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__PARAMETERS);
		createEAttribute(libraryEntryEClass, LIBRARY_ENTRY__LIBRARY_FILE);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__ORIGINAL_LIBRARY_ENTRY);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__PATH);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__ID);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__RESOURCE_PARAMETERS);

		instanceSelectorEClass = createEClass(INSTANCE_SELECTOR);
		createEReference(instanceSelectorEClass, INSTANCE_SELECTOR__TARGET);
		createEReference(instanceSelectorEClass, INSTANCE_SELECTOR__SOURCE_ELEMENTS);
		createEOperation(instanceSelectorEClass, INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP);

		instanceSelectorSourceInterfaceEClass = createEClass(INSTANCE_SELECTOR_SOURCE_INTERFACE);

		instanceSelectorSourceElementEClass = createEClass(INSTANCE_SELECTOR_SOURCE_ELEMENT);

		instanceSelectorExternalSourceElementEClass = createEClass(INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT);

		modifiedAttributeElementTypeEClass = createEClass(MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEReference(modifiedAttributeElementTypeEClass, MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE);
		createEOperation(modifiedAttributeElementTypeEClass, MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP);
		createEOperation(modifiedAttributeElementTypeEClass, MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING);

		localModifiedAttributeElementTypeEClass = createEClass(LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEOperation(localModifiedAttributeElementTypeEClass, LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP);

		externalModifiedAttributeElementTypeEClass = createEClass(EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEOperation(externalModifiedAttributeElementTypeEClass, EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP);

		globalModifiedAttributeElementTypeEClass = createEClass(GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEReference(globalModifiedAttributeElementTypeEClass, GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTORS);
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
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		GenLibraryPackage theGenLibraryPackage = (GenLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(GenLibraryPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGenericPackage);
		getESubpackages().add(theConstraintPackage);
		getESubpackages().add(theSourcePackage);
		getESubpackages().add(theTargetPackage);

		// Create type parameters
		ETypeParameter libraryParameterEClass_ParameterType = addETypeParameter(libraryParameterEClass, "ParameterType");
		ETypeParameter modifiedAttributeElementTypeEClass_S = addETypeParameter(modifiedAttributeElementTypeEClass, "S");
		ETypeParameter modifiedAttributeElementTypeEClass_C = addETypeParameter(modifiedAttributeElementTypeEClass, "C");
		ETypeParameter modifiedAttributeElementTypeEClass_R = addETypeParameter(modifiedAttributeElementTypeEClass, "R");
		ETypeParameter modifiedAttributeElementTypeEClass_A = addETypeParameter(modifiedAttributeElementTypeEClass, "A");
		ETypeParameter localModifiedAttributeElementTypeEClass_S = addETypeParameter(localModifiedAttributeElementTypeEClass, "S");
		ETypeParameter localModifiedAttributeElementTypeEClass_C = addETypeParameter(localModifiedAttributeElementTypeEClass, "C");
		ETypeParameter localModifiedAttributeElementTypeEClass_R = addETypeParameter(localModifiedAttributeElementTypeEClass, "R");
		ETypeParameter localModifiedAttributeElementTypeEClass_A = addETypeParameter(localModifiedAttributeElementTypeEClass, "A");
		ETypeParameter externalModifiedAttributeElementTypeEClass_S = addETypeParameter(externalModifiedAttributeElementTypeEClass, "S");
		ETypeParameter externalModifiedAttributeElementTypeEClass_C = addETypeParameter(externalModifiedAttributeElementTypeEClass, "C");
		ETypeParameter externalModifiedAttributeElementTypeEClass_R = addETypeParameter(externalModifiedAttributeElementTypeEClass, "R");
		ETypeParameter externalModifiedAttributeElementTypeEClass_A = addETypeParameter(externalModifiedAttributeElementTypeEClass, "A");
		ETypeParameter globalModifiedAttributeElementTypeEClass_S = addETypeParameter(globalModifiedAttributeElementTypeEClass, "S");
		ETypeParameter globalModifiedAttributeElementTypeEClass_C = addETypeParameter(globalModifiedAttributeElementTypeEClass, "C");
		ETypeParameter globalModifiedAttributeElementTypeEClass_R = addETypeParameter(globalModifiedAttributeElementTypeEClass, "R");
		ETypeParameter globalModifiedAttributeElementTypeEClass_A = addETypeParameter(globalModifiedAttributeElementTypeEClass, "A");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theGenericPackage.getSection());
		EGenericType g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_A.getEBounds().add(g1);

		// Add supertypes to classes
		libraryParameterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType(theGenLibraryPackage.getAbstractAttributeParameter());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		attributeParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType(theGenLibraryPackage.getAbstractContainerParameter());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		containerParameterEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType(theGenLibraryPackage.getAbstractExternalReferenceParameter());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType();
		g2.getETypeArguments().add(g3);
		externalReferenceParameterEClass.getEGenericSuperTypes().add(g1);
		resourceParameterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		instanceSelectorEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		instanceSelectorEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		instanceSelectorSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
		g1 = createEGenericType(this.getLocalModifiedAttributeElementType());
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
		g1 = createEGenericType(this.getExternalModifiedAttributeElementType());
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
		modifiedAttributeElementTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		modifiedAttributeElementTypeEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		g1 = createEGenericType(this.getModifiedAttributeElementType());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModifiedAttributeElementType());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModifiedAttributeElementType());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(libraryParameterEClass, LibraryParameter.class, "LibraryParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibraryParameter_Source(), ecorePackage.getEObject(), null, "source", null, 1, 1, LibraryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(libraryParameterEClass_ParameterType);
		initEReference(getLibraryParameter_OriginalParameter(), g1, null, "originalParameter", null, 1, 1, LibraryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeParameterEClass, AttributeParameter.class, "AttributeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeParameter_Attribute(), theTargetPackage.getActualTargetSectionAttribute(), null, "attribute", null, 1, 1, AttributeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerParameterEClass, ContainerParameter.class, "ContainerParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerParameter_Class(), theTargetPackage.getTargetSection(), null, "class", null, 1, 1, ContainerParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalReferenceParameterEClass, ExternalReferenceParameter.class, "ExternalReferenceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalReferenceParameter_Reference(), theTargetPackage.getTargetSectionCrossReference(), null, "reference", null, 1, 1, ExternalReferenceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceParameterEClass, ResourceParameter.class, "ResourceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceParameter_Attribute(), theTargetPackage.getVirtualTargetSectionAttribute(), null, "attribute", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceParameter_OriginalParameter(), theGenLibraryPackage.getResourceParameter(), null, "originalParameter", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEntryEClass, LibraryEntry.class, "LibraryEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getLibraryParameter());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getLibraryEntry_Parameters(), g1, null, "parameters", null, 1, -1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibraryEntry_LibraryFile(), ecorePackage.getEString(), "libraryFile", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_OriginalLibraryEntry(), theGenLibraryPackage.getLibraryEntry(), null, "originalLibraryEntry", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Path(), theTargetPackage.getVirtualTargetSectionAttribute(), null, "path", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Id(), theTargetPackage.getVirtualTargetSectionAttribute(), null, "id", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_ResourceParameters(), this.getResourceParameter(), null, "resourceParameters", null, 0, -1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instanceSelectorEClass, InstanceSelector.class, "InstanceSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceSelector_Target(), theSourcePackage.getActualSourceSectionAttribute(), null, "target", null, 1, 1, InstanceSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceSelector_SourceElements(), this.getInstanceSelectorSourceInterface(), null, "sourceElements", null, 0, -1, InstanceSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getInstanceSelector__ValidateNoModifiedAttributeElementTypesInConditionModelConditions__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoModifiedAttributeElementTypesInConditionModelConditions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instanceSelectorSourceInterfaceEClass, InstanceSelectorSourceInterface.class, "InstanceSelectorSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceSelectorSourceElementEClass, InstanceSelectorSourceElement.class, "InstanceSelectorSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(instanceSelectorExternalSourceElementEClass, InstanceSelectorExternalSourceElement.class, "InstanceSelectorExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modifiedAttributeElementTypeEClass, ModifiedAttributeElementType.class, "ModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		initEReference(getModifiedAttributeElementType_Source(), g1, null, "source", null, 1, 1, ModifiedAttributeElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModifiedAttributeElementType__GetMappingHintGroup(), thePamtramPackage.getNamedElement(), "getMappingHintGroup", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModifiedAttributeElementType__GetMapping(), theMappingPackage.getMapping(), "getMapping", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(localModifiedAttributeElementTypeEClass, LocalModifiedAttributeElementType.class, "LocalModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getLocalModifiedAttributeElementType__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceAttributeMatchesSectionOrContainedSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(externalModifiedAttributeElementTypeEClass, ExternalModifiedAttributeElementType.class, "ExternalModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getExternalModifiedAttributeElementType__ValidateSourceAttributeMatchesContainerSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceAttributeMatchesContainerSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(globalModifiedAttributeElementTypeEClass, GlobalModifiedAttributeElementType.class, "GlobalModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalModifiedAttributeElementType_InstanceSelectors(), this.getInstanceSelector(), null, "instanceSelector", null, 0, -1, GlobalModifiedAttributeElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (localModifiedAttributeElementTypeEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeMatchesSectionOrContainedSection"
		   });	
		addAnnotation
		  (externalModifiedAttributeElementTypeEClass, 
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
