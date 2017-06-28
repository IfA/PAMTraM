/**
 */
package pamtram.structure.library.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

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

import pamtram.structure.library.AttributeParameter;
import pamtram.structure.library.ContainerParameter;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryFactory;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.library.LibraryParameter;
import pamtram.structure.library.ResourceParameter;

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
public class LibraryPackageImpl extends EPackageImpl implements LibraryPackage {
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
	 * @see pamtram.structure.library.LibraryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LibraryPackageImpl() {
		super(eNS_URI, LibraryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LibraryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LibraryPackage init() {
		if (isInited) return (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);

		// Obtain or create and register package
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LibraryPackageImpl());

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
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		theLibraryPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		theLibraryPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		theExtendedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLibraryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI, theLibraryPackage);
		return theLibraryPackage;
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
	public EReference getLibraryEntry_OriginalLibraryEntry() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryEntry_Classpath() {
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
	public LibraryFactory getLibraryFactory() {
		return (LibraryFactory)getEFactoryInstance();
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
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__CLASSPATH);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__ID);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__RESOURCE_PARAMETERS);
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
		GenLibraryPackage theGenLibraryPackage = (GenLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(GenLibraryPackage.eNS_URI);
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);

		// Create type parameters
		ETypeParameter libraryParameterEClass_ParameterType = addETypeParameter(libraryParameterEClass, "ParameterType");

		// Set bounds for type parameters

		// Add supertypes to classes
		libraryParameterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		EGenericType g1 = createEGenericType(this.getLibraryParameter());
		EGenericType g2 = createEGenericType(theGenLibraryPackage.getAbstractAttributeParameter());
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
		initEReference(getLibraryEntry_Classpath(), theTargetPackage.getVirtualTargetSectionAttribute(), null, "classpath", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_Id(), theTargetPackage.getVirtualTargetSectionAttribute(), null, "id", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_ResourceParameters(), this.getResourceParameter(), null, "resourceParameters", null, 0, -1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
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
			 "documentation", "This package contains all elements related to the usage of library elements as TargetSections resp. right-hand side of a mapping.\r\n<br />\r\nThe library elements need to be based on the generic library meta-model \'GenLibrary\' (or one of its specializations for a specific UI meta-model)."
		   });	
		addAnnotation
		  (libraryParameterEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common super type for all wrapper elements for GenLibrary parameters."
		   });	
		addAnnotation
		  (getLibraryParameter_Source(), 
		   source, 
		   new String[] {
			 "documentation", "The model element inside the GenLibrary entry that this parameter influences."
		   });	
		addAnnotation
		  (getLibraryParameter_OriginalParameter(), 
		   source, 
		   new String[] {
			 "documentation", "The GenLibrary parameter that this wraps."
		   });	
		addAnnotation
		  (attributeParameterEClass, 
		   source, 
		   new String[] {
			 "documentation", "A wrapper element for a GenLibrary AttributeParameter."
		   });	
		addAnnotation
		  (getAttributeParameter_Attribute(), 
		   source, 
		   new String[] {
			 "documentation", "The Attribute that can be used to set the value for the AttributeParameter (either by specifying a fixed value or by means of an AttributeMapping)."
		   });	
		addAnnotation
		  (containerParameterEClass, 
		   source, 
		   new String[] {
			 "documentation", "A wrapper element for a GenLibrary ContainerParameter."
		   });	
		addAnnotation
		  (getContainerParameter_Class(), 
		   source, 
		   new String[] {
			 "documentation", "The Class that can be used to set the value (the container) for the ContainerParameter (e.g. by means of a ContainerSelector)."
		   });	
		addAnnotation
		  (externalReferenceParameterEClass, 
		   source, 
		   new String[] {
			 "documentation", "A wrapper element for a GenLibrary ExternalReferenceParameter."
		   });	
		addAnnotation
		  (getExternalReferenceParameter_Reference(), 
		   source, 
		   new String[] {
			 "documentation", "The Reference that can be used to set the value(s) for the ExternalReferenceParameter (e.g. by means of a ReferenceTargetSelector)."
		   });	
		addAnnotation
		  (resourceParameterEClass, 
		   source, 
		   new String[] {
			 "documentation", "A wrapper element for a GenLibrary ResourceParameter."
		   });	
		addAnnotation
		  (getResourceParameter_Attribute(), 
		   source, 
		   new String[] {
			 "documentation", "The Attribute that can be used to set the value for the ResourceParameter (either by specifying a fixed value or by means of an AttributeMapping)."
		   });	
		addAnnotation
		  (getResourceParameter_OriginalParameter(), 
		   source, 
		   new String[] {
			 "documentation", "The GenLibrary parameter that this wraps."
		   });	
		addAnnotation
		  (libraryEntryEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an element structure to be created in a target model based on a GenLibrary LibraryEntry.\r\n<br />\r\nInstances of this class act as wrapper for GenLibrary entries. This wrapper-based approach allows us to (1) instantiate LibraryEntries during the course of a transformation while (2) relying on the existing mechanisms for MappingHints."
		   });	
		addAnnotation
		  (getLibraryEntry_Parameters(), 
		   source, 
		   new String[] {
			 "documentation", "The list of LibraryParameters that need to be specified by the user for a successful instantiation of the LibraryEntry."
		   });	
		addAnnotation
		  (getLibraryEntry_LibraryFile(), 
		   source, 
		   new String[] {
			 "documentation", "The file containing the GenLibrary LibraryEntry that this wraps."
		   });	
		addAnnotation
		  (getLibraryEntry_OriginalLibraryEntry(), 
		   source, 
		   new String[] {
			 "documentation", "The GenLibrary LibraryEntry that this wraps."
		   });	
		addAnnotation
		  (getLibraryEntry_Classpath(), 
		   source, 
		   new String[] {
			 "documentation", "The classpath identifying the GenLibrary LibraryEntry that this wraps.\r\n<br /><br />\r\nNote: This can be overridden by an AttributeMapping during a transformation. That way, more specific LibraryEntries may be instantiated without having to create an own wrapper for each specific GenLibrary LibraryEntry."
		   });	
		addAnnotation
		  (getLibraryEntry_Id(), 
		   source, 
		   new String[] {
			 "documentation", "This can be used to specify an optional unique id for the entry to be instantiated. The id will be passed to the GenLibrary instantiation mechanism."
		   });	
		addAnnotation
		  (getLibraryEntry_ResourceParameters(), 
		   source, 
		   new String[] {
			 "documentation", "The list of ResourceParameters that need to be specified by the user for a successful instantiation of the LibraryEntry."
		   });
	}

} //LibraryPackageImpl
