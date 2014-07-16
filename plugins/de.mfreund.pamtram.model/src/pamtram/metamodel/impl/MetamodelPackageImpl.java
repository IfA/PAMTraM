/**
 */
package pamtram.metamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.AttributeValueSpecification;
import pamtram.metamodel.BeginningMatcher;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.CaseSensitiveConstraint;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.EndingMatcher;
import pamtram.metamodel.EqualityMatcher;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SubstringMatcher;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.VirtualAttribute;
import pamtram.metamodel.util.MetamodelValidator;
import pamtram.transformation.TransformationPackage;
import pamtram.transformation.impl.TransformationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelPackageImpl extends EPackageImpl implements MetamodelPackage {
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
	private EClass sourceSectionClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionClassEClass = null;

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
	private EClass attributeValueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalityMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass substringMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beginningMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endingMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regExMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseSensitiveConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum attributeValueConstraintTypeEEnum = null;

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
	 * @see pamtram.metamodel.MetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetamodelPackageImpl() {
		super(eNS_URI, MetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetamodelPackage init() {
		if (isInited) return (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);

		// Obtain or create and register package
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetamodelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		TransformationPackageImpl theTransformationPackage = (TransformationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) instanceof TransformationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) : TransformationPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);

		// Create package meta-data objects
		theMetamodelPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theTransformationPackage.createPackageContents();
		theMappingPackage.createPackageContents();

		// Initialize created meta-data
		theMetamodelPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theTransformationPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMetamodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MetamodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMetamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetamodelPackage.eNS_URI, theMetamodelPackage);
		return theMetamodelPackage;
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
	public EReference getClass_References() {
		return (EReference)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attributes() {
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
	public EAttribute getClass_Cardinality() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(4);
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
	public EClass getTargetSectionClass() {
		return targetSectionClassEClass;
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
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_ValueSpecification() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Unique() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_OwningClass() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(2);
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
	public EClass getVirtualAttribute() {
		return virtualAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueSpecification() {
		return attributeValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeValueSpecification_Value() {
		return (EAttribute)attributeValueSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualityMatcher() {
		return equalityMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueConstraint() {
		return attributeValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeValueConstraint_Type() {
		return (EAttribute)attributeValueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubstringMatcher() {
		return substringMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeginningMatcher() {
		return beginningMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndingMatcher() {
		return endingMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegExMatcher() {
		return regExMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseSensitiveConstraint() {
		return caseSensitiveConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaseSensitiveConstraint_CaseSensitive() {
		return (EAttribute)caseSensitiveConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAttributeValueConstraintType() {
		return attributeValueConstraintTypeEEnum;
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
	public MetamodelFactory getMetamodelFactory() {
		return (MetamodelFactory)getEFactoryInstance();
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

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__ECLASS);
		createEReference(classEClass, CLASS__REFERENCES);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEReference(classEClass, CLASS__CONTAINER);
		createEAttribute(classEClass, CLASS__CARDINALITY);

		sourceSectionClassEClass = createEClass(SOURCE_SECTION_CLASS);

		targetSectionClassEClass = createEClass(TARGET_SECTION_CLASS);

		referenceEClass = createEClass(REFERENCE);
		createEReference(referenceEClass, REFERENCE__EREFERENCE);
		createEReference(referenceEClass, REFERENCE__OWNING_CLASS);

		containmentReferenceEClass = createEClass(CONTAINMENT_REFERENCE);
		createEReference(containmentReferenceEClass, CONTAINMENT_REFERENCE__VALUE);

		nonContainmentReferenceEClass = createEClass(NON_CONTAINMENT_REFERENCE);
		createEReference(nonContainmentReferenceEClass, NON_CONTAINMENT_REFERENCE__VALUE);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__VALUE_SPECIFICATION);
		createEAttribute(attributeEClass, ATTRIBUTE__UNIQUE);
		createEReference(attributeEClass, ATTRIBUTE__OWNING_CLASS);

		actualAttributeEClass = createEClass(ACTUAL_ATTRIBUTE);
		createEReference(actualAttributeEClass, ACTUAL_ATTRIBUTE__ATTRIBUTE);

		virtualAttributeEClass = createEClass(VIRTUAL_ATTRIBUTE);

		attributeValueSpecificationEClass = createEClass(ATTRIBUTE_VALUE_SPECIFICATION);
		createEAttribute(attributeValueSpecificationEClass, ATTRIBUTE_VALUE_SPECIFICATION__VALUE);

		equalityMatcherEClass = createEClass(EQUALITY_MATCHER);

		attributeValueConstraintEClass = createEClass(ATTRIBUTE_VALUE_CONSTRAINT);
		createEAttribute(attributeValueConstraintEClass, ATTRIBUTE_VALUE_CONSTRAINT__TYPE);

		substringMatcherEClass = createEClass(SUBSTRING_MATCHER);

		beginningMatcherEClass = createEClass(BEGINNING_MATCHER);

		endingMatcherEClass = createEClass(ENDING_MATCHER);

		regExMatcherEClass = createEClass(REG_EX_MATCHER);

		caseSensitiveConstraintEClass = createEClass(CASE_SENSITIVE_CONSTRAINT);
		createEAttribute(caseSensitiveConstraintEClass, CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE);

		// Create enums
		attributeValueConstraintTypeEEnum = createEEnum(ATTRIBUTE_VALUE_CONSTRAINT_TYPE);
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

		// Set bounds for type parameters

		// Add supertypes to classes
		metaModelElementEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		classEClass.getESuperTypes().add(this.getMetaModelElement());
		sourceSectionClassEClass.getESuperTypes().add(this.getClass_());
		targetSectionClassEClass.getESuperTypes().add(this.getClass_());
		referenceEClass.getESuperTypes().add(this.getMetaModelElement());
		containmentReferenceEClass.getESuperTypes().add(this.getReference());
		nonContainmentReferenceEClass.getESuperTypes().add(this.getReference());
		attributeEClass.getESuperTypes().add(this.getMetaModelElement());
		actualAttributeEClass.getESuperTypes().add(this.getAttribute());
		virtualAttributeEClass.getESuperTypes().add(this.getAttribute());
		attributeValueSpecificationEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		equalityMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		attributeValueConstraintEClass.getESuperTypes().add(this.getAttributeValueSpecification());
		substringMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		beginningMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		endingMatcherEClass.getESuperTypes().add(this.getCaseSensitiveConstraint());
		regExMatcherEClass.getESuperTypes().add(this.getAttributeValueConstraint());
		caseSensitiveConstraintEClass.getESuperTypes().add(this.getAttributeValueConstraint());

		// Initialize classes, features, and operations; add parameters
		initEClass(metaModelElementEClass, MetaModelElement.class, "MetaModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getMetaModelElement__GetContainingSection(), this.getClass_(), "getContainingSection", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(classEClass, pamtram.metamodel.Class.class, "Class", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_EClass(), ecorePackage.getEClass(), null, "eClass", null, 1, 1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_References(), this.getReference(), this.getReference_OwningClass(), "references", null, 0, -1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Attributes(), this.getAttribute(), this.getAttribute_OwningClass(), "attributes", null, 0, -1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Container(), this.getClass_(), null, "container", null, 0, 1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Cardinality(), this.getCardinalityType(), "cardinality", "ONE", 1, 1, pamtram.metamodel.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceSectionClassEClass, SourceSectionClass.class, "SourceSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionClassEClass, TargetSectionClass.class, "TargetSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceEClass, Reference.class, "Reference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReference_EReference(), ecorePackage.getEReference(), null, "eReference", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReference_OwningClass(), this.getClass_(), this.getClass_References(), "owningClass", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containmentReferenceEClass, ContainmentReference.class, "ContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainmentReference_Value(), this.getClass_(), null, "value", null, 0, -1, ContainmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nonContainmentReferenceEClass, NonContainmentReference.class, "NonContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNonContainmentReference_Value(), this.getClass_(), null, "value", null, 0, -1, NonContainmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_ValueSpecification(), this.getAttributeValueSpecification(), null, "valueSpecification", null, 0, -1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Unique(), ecorePackage.getEBoolean(), "unique", "false", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_OwningClass(), this.getClass_(), this.getClass_Attributes(), "owningClass", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualAttributeEClass, ActualAttribute.class, "ActualAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualAttribute_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1, ActualAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualAttributeEClass, VirtualAttribute.class, "VirtualAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueSpecificationEClass, AttributeValueSpecification.class, "AttributeValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeValueSpecification_Value(), ecorePackage.getEString(), "value", null, 1, 1, AttributeValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equalityMatcherEClass, EqualityMatcher.class, "EqualityMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueConstraintEClass, AttributeValueConstraint.class, "AttributeValueConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeValueConstraint_Type(), this.getAttributeValueConstraintType(), "type", "INCLUSION", 1, 1, AttributeValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(substringMatcherEClass, SubstringMatcher.class, "SubstringMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beginningMatcherEClass, BeginningMatcher.class, "BeginningMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endingMatcherEClass, EndingMatcher.class, "EndingMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regExMatcherEClass, RegExMatcher.class, "RegExMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(caseSensitiveConstraintEClass, CaseSensitiveConstraint.class, "CaseSensitiveConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaseSensitiveConstraint_CaseSensitive(), ecorePackage.getEBoolean(), "caseSensitive", "true", 1, 1, CaseSensitiveConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(attributeValueConstraintTypeEEnum, AttributeValueConstraintType.class, "AttributeValueConstraintType");
		addEEnumLiteral(attributeValueConstraintTypeEEnum, AttributeValueConstraintType.INCLUSION);
		addEEnumLiteral(attributeValueConstraintTypeEEnum, AttributeValueConstraintType.EXCLUSION);

		initEEnum(cardinalityTypeEEnum, CardinalityType.class, "CardinalityType");
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ONE);
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ONE_INFINITY);
		addEEnumLiteral(cardinalityTypeEEnum, CardinalityType.ZERO_INFINITY);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
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
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });			
		addAnnotation
		  (classEClass, 
		   source, 
		   new String[] {
			 "constraints", "eClassMatchesParentEReference\r\nvariableCardinalityIsValid"
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
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";					
		addAnnotation
		  (classEClass, 
		   source, 
		   new String[] {
			 "eClassMatchesParentEReference", "if metamodel::Reference.oclAsType(ecore::EClass).isSuperTypeOf(self.oclAsType(ecore::EObject).eContainer().eClass()) then self.oclAsType(ecore::EObject).eContainer().oclAsType(metamodel::Reference).eReference.oclAsType(ecore::\r\nEReference).eReferenceType.isSuperTypeOf(self.eClass.oclAsType(ecore::EClass)) else true endif",
			 "cardinalityIsValid", "if metamodel::Reference.oclAsType(ecore::EClass).isSuperTypeOf(self.oclAsType(ecore::EObject).eContainer().eClass()) then not ((self.cardinality <> 0) and (self.oclAsType(ecore::EObject).eContainer().oclAsType(metamodel::Reference).eReference.oclAsType(ecore::EReference).upperBound <= 1)) else true endif"
		   });			
		addAnnotation
		  (referenceEClass, 
		   source, 
		   new String[] {
			 "eReferenceMatchesParentEClass", "self.oclAsType(ecore::EObject).eContainer().oclAsType(metamodel::Class).eClass.oclAsType(ecore::\r\nEClass).eAllReferences->includes(self.eReference)"
		   });			
		addAnnotation
		  (containmentReferenceEClass, 
		   source, 
		   new String[] {
			 "eReferenceIsContainment", "self.eReference.containment=true"
		   });			
		addAnnotation
		  (nonContainmentReferenceEClass, 
		   source, 
		   new String[] {
			 "eReferenceIsNonContainment", "self.eReference.containment=false"
		   });
	}

} //MetamodelPackageImpl
