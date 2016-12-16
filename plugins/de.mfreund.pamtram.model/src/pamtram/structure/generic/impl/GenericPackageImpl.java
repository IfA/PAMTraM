/**
 */
package pamtram.structure.generic.impl;

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

import pamtram.condition.ConditionPackage;

import pamtram.condition.impl.ConditionPackageImpl;

import pamtram.impl.PamtramPackageImpl;

import pamtram.mapping.MappingPackage;

import pamtram.mapping.impl.MappingPackageImpl;

import pamtram.structure.StructurePackage;

import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.ContainmentReference;
import pamtram.structure.generic.GenericFactory;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.NonContainmentReference;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;

import pamtram.structure.generic.util.GenericValidator;

import pamtram.structure.impl.StructurePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericPackageImpl extends EPackageImpl implements GenericPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaModelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containmentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonContainmentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cardinalityTypeEEnum = null;

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
	 * @see pamtram.structure.generic.GenericPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GenericPackageImpl() {
		super(eNS_URI, GenericFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GenericPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GenericPackage init() {
		if (isInited) return (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);

		// Obtain or create and register package
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GenericPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);

		// Create package meta-data objects
		theGenericPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		theGenericPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theGenericPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return GenericValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theGenericPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GenericPackage.eNS_URI, theGenericPackage);
		return theGenericPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaModelElement() {
		return metaModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetaModelElement__GetContainingSection() {
		return metaModelElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetaModelElement__GetContainingSectionModel() {
		return metaModelElementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetaModelElement__IsLibraryEntry() {
		return metaModelElementEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_EClass() {
		return (EReference)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Cardinality() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_References() {
		return (EReference)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Container() {
		return (EReference)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsContainerFor__Class() {
		return classEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsContainedIn__Class() {
		return classEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__GetOwningContainmentReference() {
		return classEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsReferencedBy__Class_EList() {
		return classEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__ValidateEClassMatchesParentEReference__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__ValidateCardinalityIsValid__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__ValidateContainerIsValid__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSection() {
		return sectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSection_Abstract() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_Extend() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSection__ValidateContainerMatchesExtendContainer__DiagnosticChain_Map() {
		return sectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSection__ValidateExtendsValidSections__DiagnosticChain_Map() {
		return sectionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_EReference() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_OwningClass() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__ValidateEReferenceMatchesParentEClass__DiagnosticChain_Map() {
		return referenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__GetValuesGeneric() {
		return referenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__AddValuesGeneric__EList() {
		return referenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainmentReference() {
		return containmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainmentReference_Value() {
		return (EReference)containmentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainmentReference__ValidateEReferenceIsContainment__DiagnosticChain_Map() {
		return containmentReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonContainmentReference() {
		return nonContainmentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonContainmentReference_Value() {
		return (EReference)nonContainmentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNonContainmentReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map() {
		return nonContainmentReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_OwningClass() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualAttribute() {
		return actualAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActualAttribute_Attribute() {
		return (EReference)actualAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActualAttribute__ValidateAttributeMatchesParentEClass__DiagnosticChain_Map() {
		return actualAttributeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualAttribute() {
		return virtualAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCardinalityType() {
		return cardinalityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericFactory getGenericFactory() {
		return (GenericFactory)getEFactoryInstance();
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
		metaModelElementEClass = createEClass(META_MODEL_ELEMENT);
		createEOperation(metaModelElementEClass, META_MODEL_ELEMENT___GET_CONTAINING_SECTION);
		createEOperation(metaModelElementEClass, META_MODEL_ELEMENT___GET_CONTAINING_SECTION_MODEL);
		createEOperation(metaModelElementEClass, META_MODEL_ELEMENT___IS_LIBRARY_ENTRY);

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__ECLASS);
		createEAttribute(classEClass, CLASS__CARDINALITY);
		createEReference(classEClass, CLASS__REFERENCES);
		createEReference(classEClass, CLASS__CONTAINER);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEOperation(classEClass, CLASS___IS_CONTAINER_FOR__CLASS);
		createEOperation(classEClass, CLASS___IS_CONTAINED_IN__CLASS);
		createEOperation(classEClass, CLASS___GET_OWNING_CONTAINMENT_REFERENCE);
		createEOperation(classEClass, CLASS___IS_REFERENCED_BY__CLASS_ELIST);
		createEOperation(classEClass, CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP);

		sectionEClass = createEClass(SECTION);
		createEAttribute(sectionEClass, SECTION__ABSTRACT);
		createEReference(sectionEClass, SECTION__EXTEND);
		createEOperation(sectionEClass, SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP);
		createEOperation(sectionEClass, SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP);

		referenceEClass = createEClass(REFERENCE);
		createEReference(referenceEClass, REFERENCE__EREFERENCE);
		createEReference(referenceEClass, REFERENCE__OWNING_CLASS);
		createEOperation(referenceEClass, REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP);
		createEOperation(referenceEClass, REFERENCE___GET_VALUES_GENERIC);
		createEOperation(referenceEClass, REFERENCE___ADD_VALUES_GENERIC__ELIST);

		containmentReferenceEClass = createEClass(CONTAINMENT_REFERENCE);
		createEReference(containmentReferenceEClass, CONTAINMENT_REFERENCE__VALUE);
		createEOperation(containmentReferenceEClass, CONTAINMENT_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP);

		nonContainmentReferenceEClass = createEClass(NON_CONTAINMENT_REFERENCE);
		createEReference(nonContainmentReferenceEClass, NON_CONTAINMENT_REFERENCE__VALUE);
		createEOperation(nonContainmentReferenceEClass, NON_CONTAINMENT_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__OWNING_CLASS);

		actualAttributeEClass = createEClass(ACTUAL_ATTRIBUTE);
		createEReference(actualAttributeEClass, ACTUAL_ATTRIBUTE__ATTRIBUTE);
		createEOperation(actualAttributeEClass, ACTUAL_ATTRIBUTE___VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP);

		virtualAttributeEClass = createEClass(VIRTUAL_ATTRIBUTE);

		// Create enums
		cardinalityTypeEEnum = createEEnum(CARDINALITY_TYPE);
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

		// Create type parameters
		ETypeParameter metaModelElementEClass_S = addETypeParameter(metaModelElementEClass, "S");
		ETypeParameter metaModelElementEClass_C = addETypeParameter(metaModelElementEClass, "C");
		ETypeParameter metaModelElementEClass_R = addETypeParameter(metaModelElementEClass, "R");
		ETypeParameter metaModelElementEClass_A = addETypeParameter(metaModelElementEClass, "A");
		ETypeParameter classEClass_S = addETypeParameter(classEClass, "S");
		ETypeParameter classEClass_C = addETypeParameter(classEClass, "C");
		ETypeParameter classEClass_R = addETypeParameter(classEClass, "R");
		ETypeParameter classEClass_A = addETypeParameter(classEClass, "A");
		ETypeParameter sectionEClass_S = addETypeParameter(sectionEClass, "S");
		ETypeParameter sectionEClass_C = addETypeParameter(sectionEClass, "C");
		ETypeParameter sectionEClass_R = addETypeParameter(sectionEClass, "R");
		ETypeParameter sectionEClass_A = addETypeParameter(sectionEClass, "A");
		ETypeParameter referenceEClass_S = addETypeParameter(referenceEClass, "S");
		ETypeParameter referenceEClass_C = addETypeParameter(referenceEClass, "C");
		ETypeParameter referenceEClass_R = addETypeParameter(referenceEClass, "R");
		ETypeParameter referenceEClass_A = addETypeParameter(referenceEClass, "A");
		ETypeParameter containmentReferenceEClass_S = addETypeParameter(containmentReferenceEClass, "S");
		ETypeParameter containmentReferenceEClass_C = addETypeParameter(containmentReferenceEClass, "C");
		ETypeParameter containmentReferenceEClass_R = addETypeParameter(containmentReferenceEClass, "R");
		ETypeParameter containmentReferenceEClass_A = addETypeParameter(containmentReferenceEClass, "A");
		ETypeParameter nonContainmentReferenceEClass_S = addETypeParameter(nonContainmentReferenceEClass, "S");
		ETypeParameter nonContainmentReferenceEClass_C = addETypeParameter(nonContainmentReferenceEClass, "C");
		ETypeParameter nonContainmentReferenceEClass_R = addETypeParameter(nonContainmentReferenceEClass, "R");
		ETypeParameter nonContainmentReferenceEClass_A = addETypeParameter(nonContainmentReferenceEClass, "A");
		ETypeParameter attributeEClass_S = addETypeParameter(attributeEClass, "S");
		ETypeParameter attributeEClass_C = addETypeParameter(attributeEClass, "C");
		ETypeParameter attributeEClass_R = addETypeParameter(attributeEClass, "R");
		ETypeParameter attributeEClass_A = addETypeParameter(attributeEClass, "A");
		ETypeParameter actualAttributeEClass_S = addETypeParameter(actualAttributeEClass, "S");
		ETypeParameter actualAttributeEClass_C = addETypeParameter(actualAttributeEClass, "C");
		ETypeParameter actualAttributeEClass_R = addETypeParameter(actualAttributeEClass, "R");
		ETypeParameter actualAttributeEClass_A = addETypeParameter(actualAttributeEClass, "A");
		ETypeParameter virtualAttributeEClass_S = addETypeParameter(virtualAttributeEClass, "S");
		ETypeParameter virtualAttributeEClass_C = addETypeParameter(virtualAttributeEClass, "C");
		ETypeParameter virtualAttributeEClass_R = addETypeParameter(virtualAttributeEClass, "R");
		ETypeParameter virtualAttributeEClass_A = addETypeParameter(virtualAttributeEClass, "A");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getSection());
		EGenericType g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		metaModelElementEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass_A.getEBounds().add(g1);

		// Add supertypes to classes
		metaModelElementEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		g1 = createEGenericType(this.getMetaModelElement());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		classEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(sectionEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(sectionEClass_A);
		g1.getETypeArguments().add(g2);
		sectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getMetaModelElement());
		g2 = createEGenericType(referenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(referenceEClass_A);
		g1.getETypeArguments().add(g2);
		referenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(containmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(containmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		containmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(nonContainmentReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(nonContainmentReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		nonContainmentReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getMetaModelElement());
		g2 = createEGenericType(attributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(attributeEClass_A);
		g1.getETypeArguments().add(g2);
		attributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(actualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		actualAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(virtualAttributeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualAttributeEClass_A);
		g1.getETypeArguments().add(g2);
		virtualAttributeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(metaModelElementEClass, MetaModelElement.class, "MetaModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getMetaModelElement__GetContainingSection(), null, "getContainingSection", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(metaModelElementEClass_S);
		initEOperation(op, g1);

		op = initEOperation(getMetaModelElement__GetContainingSectionModel(), null, "getContainingSectionModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(thePamtramPackage.getSectionModel());
		g2 = createEGenericType(metaModelElementEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(metaModelElementEClass_A);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEOperation(getMetaModelElement__IsLibraryEntry(), ecorePackage.getEBoolean(), "isLibraryEntry", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(classEClass, pamtram.structure.generic.Class.class, "Class", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_EClass(), ecorePackage.getEClass(), null, "eClass", null, 1, 1, pamtram.structure.generic.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Cardinality(), this.getCardinalityType(), "cardinality", "ONE", 1, 1, pamtram.structure.generic.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_R);
		initEReference(getClass_References(), g1, this.getReference_OwningClass(), "references", null, 0, -1, pamtram.structure.generic.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		initEReference(getClass_Container(), g1, null, "container", null, 0, 1, pamtram.structure.generic.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_A);
		initEReference(getClass_Attributes(), g1, this.getAttribute_OwningClass(), "attributes", null, 0, -1, pamtram.structure.generic.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getClass__IsContainerFor__Class(), ecorePackage.getEBoolean(), "isContainerFor", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "containedClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__IsContainedIn__Class(), ecorePackage.getEBoolean(), "isContainedIn", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "containerClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__GetOwningContainmentReference(), null, "getOwningContainmentReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getContainmentReference());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getClass__IsReferencedBy__Class_EList(), ecorePackage.getEBoolean(), "isReferencedBy", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "referencingClass", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "referencedClasses", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__ValidateEClassMatchesParentEReference__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEClassMatchesParentEReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__ValidateCardinalityIsValid__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCardinalityIsValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__ValidateContainerIsValid__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateContainerIsValid", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sectionEClass, Section.class, "Section", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSection_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(sectionEClass_S);
		initEReference(getSection_Extend(), g1, null, "extend", null, 0, -1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getSection__ValidateContainerMatchesExtendContainer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateContainerMatchesExtendContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSection__ValidateExtendsValidSections__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateExtendsValidSections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReference_EReference(), ecorePackage.getEReference(), null, "eReference", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		initEReference(getReference_OwningClass(), g1, this.getClass_References(), "owningClass", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getReference__ValidateEReferenceMatchesParentEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEReferenceMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getReference__GetValuesGeneric(), null, "getValuesGeneric", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		initEOperation(op, g1);

		op = initEOperation(getReference__AddValuesGeneric__EList(), null, "addValuesGeneric", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		addEParameter(op, g1, "values", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(containmentReferenceEClass, ContainmentReference.class, "ContainmentReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(containmentReferenceEClass_C);
		initEReference(getContainmentReference_Value(), g1, null, "value", null, 0, -1, ContainmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getContainmentReference__ValidateEReferenceIsContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEReferenceIsContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nonContainmentReferenceEClass, NonContainmentReference.class, "NonContainmentReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(nonContainmentReferenceEClass_C);
		initEReference(getNonContainmentReference_Value(), g1, null, "value", null, 0, -1, NonContainmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getNonContainmentReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEReferenceIsNonContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(attributeEClass_C);
		initEReference(getAttribute_OwningClass(), g1, this.getClass_Attributes(), "owningClass", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualAttributeEClass, ActualAttribute.class, "ActualAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualAttribute_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1, ActualAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getActualAttribute__ValidateAttributeMatchesParentEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateAttributeMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(virtualAttributeEClass, VirtualAttribute.class, "VirtualAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(cardinalityTypeEEnum, CardinalityType.class, "CardinalityType");
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ONE);
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ONE_INFINITY);
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ZERO_INFINITY);

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
		  (classEClass, 
		   source, 
		   new String[] {
			 "constraints", "eClassMatchesParentEReference variableCardinalityIsValid containerIsValid"
		   });	
		addAnnotation
		  (sectionEClass, 
		   source, 
		   new String[] {
			 "constraints", "extendsValidSections containerMatchesExtendContainer"
		   });	
		addAnnotation
		  (referenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "eReferenceMatchesParentEClass"
		   });	
		addAnnotation
		  (containmentReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "eReferenceIsContainment"
		   });	
		addAnnotation
		  (nonContainmentReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "eReferenceIsNonContainment"
		   });	
		addAnnotation
		  (actualAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "attributeMatchesParentEClass"
		   });
	}

} //GenericPackageImpl
