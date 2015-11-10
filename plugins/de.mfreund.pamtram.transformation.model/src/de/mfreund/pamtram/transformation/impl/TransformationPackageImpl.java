/**
 */
package de.mfreund.pamtram.transformation.impl;

import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationFactory;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import de.mfreund.pamtram.transformation.TransformationPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pamtram.PamtramPackage;

import pamtram.mapping.MappingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformationPackageImpl extends EPackageImpl implements TransformationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationMappingHintGroupEClass = null;

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
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TransformationPackageImpl() {
		super(eNS_URI, TransformationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TransformationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TransformationPackage init() {
		if (isInited) return (TransformationPackage)EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI);

		// Obtain or create and register package
		TransformationPackageImpl theTransformationPackage = (TransformationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TransformationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TransformationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PamtramPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTransformationPackage.createPackageContents();

		// Initialize created meta-data
		theTransformationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTransformationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TransformationPackage.eNS_URI, theTransformationPackage);
		return theTransformationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformation() {
		return transformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformation_StartDate() {
		return (EAttribute)transformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformation_EndDate() {
		return (EAttribute)transformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformation_Name() {
		return (EAttribute)transformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformation_Id() {
		return (EAttribute)transformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_PamtramInstance() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_SourceModels() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_TargetModels() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_TransformationMappings() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_TransformationHintGroups() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationMapping() {
		return transformationMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationMapping_SourceElement() {
		return (EReference)transformationMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationMapping_AssociatedMapping() {
		return (EReference)transformationMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationMappingHintGroup() {
		return transformationMappingHintGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationMappingHintGroup_TargetElements() {
		return (EReference)transformationMappingHintGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationMappingHintGroup_AssociatedMappingHintGroup() {
		return (EReference)transformationMappingHintGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationFactory getTransformationFactory() {
		return (TransformationFactory)getEFactoryInstance();
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
		transformationEClass = createEClass(TRANSFORMATION);
		createEAttribute(transformationEClass, TRANSFORMATION__START_DATE);
		createEAttribute(transformationEClass, TRANSFORMATION__END_DATE);
		createEAttribute(transformationEClass, TRANSFORMATION__NAME);
		createEAttribute(transformationEClass, TRANSFORMATION__ID);
		createEReference(transformationEClass, TRANSFORMATION__PAMTRAM_INSTANCE);
		createEReference(transformationEClass, TRANSFORMATION__SOURCE_MODELS);
		createEReference(transformationEClass, TRANSFORMATION__TARGET_MODELS);
		createEReference(transformationEClass, TRANSFORMATION__TRANSFORMATION_MAPPINGS);
		createEReference(transformationEClass, TRANSFORMATION__TRANSFORMATION_HINT_GROUPS);

		transformationMappingEClass = createEClass(TRANSFORMATION_MAPPING);
		createEReference(transformationMappingEClass, TRANSFORMATION_MAPPING__SOURCE_ELEMENT);
		createEReference(transformationMappingEClass, TRANSFORMATION_MAPPING__ASSOCIATED_MAPPING);

		transformationMappingHintGroupEClass = createEClass(TRANSFORMATION_MAPPING_HINT_GROUP);
		createEReference(transformationMappingHintGroupEClass, TRANSFORMATION_MAPPING_HINT_GROUP__TARGET_ELEMENTS);
		createEReference(transformationMappingHintGroupEClass, TRANSFORMATION_MAPPING_HINT_GROUP__ASSOCIATED_MAPPING_HINT_GROUP);
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
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransformation_StartDate(), ecorePackage.getEDate(), "startDate", null, 1, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformation_EndDate(), ecorePackage.getEDate(), "endDate", null, 1, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformation_Id(), ecorePackage.getEString(), "id", null, 1, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_PamtramInstance(), thePamtramPackage.getPAMTraM(), null, "pamtramInstance", null, 1, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_SourceModels(), ecorePackage.getEObject(), null, "sourceModels", null, 1, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_TargetModels(), ecorePackage.getEObject(), null, "targetModels", null, 1, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_TransformationMappings(), this.getTransformationMapping(), null, "transformationMappings", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_TransformationHintGroups(), this.getTransformationMappingHintGroup(), null, "transformationHintGroups", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationMappingEClass, TransformationMapping.class, "TransformationMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationMapping_SourceElement(), ecorePackage.getEObject(), null, "sourceElement", null, 1, 1, TransformationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationMapping_AssociatedMapping(), theMappingPackage.getMapping(), null, "associatedMapping", null, 1, 1, TransformationMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationMappingHintGroupEClass, TransformationMappingHintGroup.class, "TransformationMappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationMappingHintGroup_TargetElements(), ecorePackage.getEObject(), null, "targetElements", null, 1, -1, TransformationMappingHintGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationMappingHintGroup_AssociatedMappingHintGroup(), theMappingPackage.getInstantiableMappingHintGroup(), null, "associatedMappingHintGroup", null, 1, 1, TransformationMappingHintGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TransformationPackageImpl
