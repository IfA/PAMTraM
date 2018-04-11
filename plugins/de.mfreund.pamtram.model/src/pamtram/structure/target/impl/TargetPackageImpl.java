/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.target.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
import pamtram.structure.source.SourcePackage;

import pamtram.structure.source.impl.SourcePackageImpl;

import pamtram.structure.target.ActualTargetSectionAttribute;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.FileType;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAnyContentCompositeReference;
import pamtram.structure.target.TargetSectionAnyContentCrossReference;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionCrossReference;
import pamtram.structure.target.TargetSectionReference;
import pamtram.structure.target.VirtualTargetSectionAttribute;

import pamtram.structure.target.util.TargetValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetPackageImpl extends EPackageImpl implements TargetPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileAttributeEClass = null;

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
	private EClass targetSectionReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionCompositeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionAnyContentCompositeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionCrossReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionAnyContentCrossReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualTargetSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualTargetSectionAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fileTypeEEnum = null;

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
	 * @see pamtram.structure.target.TargetPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TargetPackageImpl() {
		super(eNS_URI, TargetFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TargetPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TargetPackage init() {
		if (isInited) return (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);

		// Obtain or create and register package
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TargetPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) : GenericPackage.eINSTANCE);
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) : ConstraintPackage.eINSTANCE);
		SourcePackageImpl theSourcePackage = (SourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) instanceof SourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) : SourcePackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		theTargetPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		theTargetPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		theExtendedPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTargetPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return TargetValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTargetPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TargetPackage.eNS_URI, theTargetPackage);
		return theTargetPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSection() {
		return targetSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetSection_ReferencingMappingHintGroups() {
		return (EReference)targetSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetSection_File() {
		return (EReference)targetSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map() {
		return targetSectionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSection__ValidateCardinality__DiagnosticChain_Map() {
		return targetSectionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileAttribute() {
		return fileAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFileAttribute_FileType() {
		return (EAttribute)fileAttributeEClass.getEStructuralFeatures().get(0);
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
	public EClass getTargetSectionReference() {
		return targetSectionReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionCompositeReference() {
		return targetSectionCompositeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionAnyContentCompositeReference() {
		return targetSectionAnyContentCompositeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSectionAnyContentCompositeReference__ValidateIsAllowed__DiagnosticChain_Map() {
		return targetSectionAnyContentCompositeReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionCrossReference() {
		return targetSectionCrossReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map() {
		return targetSectionCrossReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionAnyContentCrossReference() {
		return targetSectionAnyContentCrossReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTargetSectionAnyContentCrossReference__ValidateIsAllowed__DiagnosticChain_Map() {
		return targetSectionAnyContentCrossReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetSectionAttribute() {
		return targetSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetSectionAttribute_Unique() {
		return (EAttribute)targetSectionAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTargetSectionAttribute_Value() {
		return (EAttribute)targetSectionAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualTargetSectionAttribute() {
		return actualTargetSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualTargetSectionAttribute() {
		return virtualTargetSectionAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFileType() {
		return fileTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetFactory getTargetFactory() {
		return (TargetFactory)getEFactoryInstance();
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
		targetSectionEClass = createEClass(TARGET_SECTION);
		createEReference(targetSectionEClass, TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS);
		createEReference(targetSectionEClass, TARGET_SECTION__FILE);
		createEOperation(targetSectionEClass, TARGET_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP__DIAGNOSTICCHAIN_MAP);
		createEOperation(targetSectionEClass, TARGET_SECTION___VALIDATE_CARDINALITY__DIAGNOSTICCHAIN_MAP);

		fileAttributeEClass = createEClass(FILE_ATTRIBUTE);
		createEAttribute(fileAttributeEClass, FILE_ATTRIBUTE__FILE_TYPE);

		targetSectionClassEClass = createEClass(TARGET_SECTION_CLASS);

		targetSectionReferenceEClass = createEClass(TARGET_SECTION_REFERENCE);

		targetSectionCompositeReferenceEClass = createEClass(TARGET_SECTION_COMPOSITE_REFERENCE);

		targetSectionAnyContentCompositeReferenceEClass = createEClass(TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE);
		createEOperation(targetSectionAnyContentCompositeReferenceEClass, TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE___VALIDATE_IS_ALLOWED__DIAGNOSTICCHAIN_MAP);

		targetSectionCrossReferenceEClass = createEClass(TARGET_SECTION_CROSS_REFERENCE);
		createEOperation(targetSectionCrossReferenceEClass, TARGET_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP);

		targetSectionAnyContentCrossReferenceEClass = createEClass(TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE);
		createEOperation(targetSectionAnyContentCrossReferenceEClass, TARGET_SECTION_ANY_CONTENT_CROSS_REFERENCE___VALIDATE_IS_ALLOWED__DIAGNOSTICCHAIN_MAP);

		targetSectionAttributeEClass = createEClass(TARGET_SECTION_ATTRIBUTE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__UNIQUE);
		createEAttribute(targetSectionAttributeEClass, TARGET_SECTION_ATTRIBUTE__VALUE);

		actualTargetSectionAttributeEClass = createEClass(ACTUAL_TARGET_SECTION_ATTRIBUTE);

		virtualTargetSectionAttributeEClass = createEClass(VIRTUAL_TARGET_SECTION_ATTRIBUTE);

		// Create enums
		fileTypeEEnum = createEEnum(FILE_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getTargetSectionClass());
		targetSectionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getSection());
		EGenericType g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionEClass.getEGenericSuperTypes().add(g1);
		fileAttributeEClass.getESuperTypes().add(this.getVirtualTargetSectionAttribute());
		g1 = createEGenericType(theGenericPackage.getClass_());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionClassEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCompositeReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getActualReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCompositeReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionAnyContentCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionAnyContentCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getVirtualReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionAnyContentCompositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCrossReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getActualReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getCrossReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionAnyContentCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionReference());
		targetSectionAnyContentCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getVirtualReference());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionAnyContentCrossReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getAttribute());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		targetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionAttribute());
		actualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getActualAttribute());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		actualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTargetSectionAttribute());
		virtualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theGenericPackage.getVirtualAttribute());
		g2 = createEGenericType(this.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		virtualTargetSectionAttributeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(targetSectionEClass, TargetSection.class, "TargetSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetSection_ReferencingMappingHintGroups(), theMappingPackage.getMappingHintGroupType(), null, "referencingMappingHintGroups", null, 0, -1, TargetSection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTargetSection_File(), this.getFileAttribute(), null, "file", null, 0, 1, TargetSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIsReferencedByMappingHintGroup", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTargetSection__ValidateCardinality__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCardinality", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fileAttributeEClass, FileAttribute.class, "FileAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileAttribute_FileType(), this.getFileType(), "fileType", null, 1, 1, FileAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetSectionClassEClass, TargetSectionClass.class, "TargetSectionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionReferenceEClass, TargetSectionReference.class, "TargetSectionReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionCompositeReferenceEClass, TargetSectionCompositeReference.class, "TargetSectionCompositeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(targetSectionAnyContentCompositeReferenceEClass, TargetSectionAnyContentCompositeReference.class, "TargetSectionAnyContentCompositeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getTargetSectionAnyContentCompositeReference__ValidateIsAllowed__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIsAllowed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionCrossReferenceEClass, TargetSectionCrossReference.class, "TargetSectionCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEReferenceIsNonContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionAnyContentCrossReferenceEClass, TargetSectionAnyContentCrossReference.class, "TargetSectionAnyContentCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getTargetSectionAnyContentCrossReference__ValidateIsAllowed__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateIsAllowed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetSectionAttributeEClass, TargetSectionAttribute.class, "TargetSectionAttribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTargetSectionAttribute_Unique(), ecorePackage.getEBoolean(), "unique", "false", 1, 1, TargetSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTargetSectionAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, TargetSectionAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actualTargetSectionAttributeEClass, ActualTargetSectionAttribute.class, "ActualTargetSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(virtualTargetSectionAttributeEClass, VirtualTargetSectionAttribute.class, "VirtualTargetSectionAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(fileTypeEEnum, FileType.class, "FileType");
		addEEnumLiteral(fileTypeEEnum, FileType.XMI);
		addEEnumLiteral(fileTypeEEnum, FileType.XML);

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
			 "documentation", "This package contains all elements related to the description of target element structures (aka TargetSections). These form the right-hand side (RHS) of a mapping."
		   });	
		addAnnotation
		  (targetSectionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A special TargetSectionClass that represents the root element (as an instance of an EClass) of an element structure to be created in a target model.\r\n<br />\r\nNote: Every specified target model structure must contain one and only one TargetSection element (its root element)."
		   });	
		addAnnotation
		  (getTargetSection__ValidateIsReferencedByMappingHintGroup__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = !this.getReferencingMappingHintGroups().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The section is not referenced by any hint group and will not be instantiated!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.structure.target.util.TargetValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tTargetValidator.TARGET_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING_HINT_GROUP,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getTargetSection__ValidateCardinality__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "boolean result = this.getCardinality() != <%pamtram.structure.generic.CardinalityType%>.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The cardinality of this section is currently set to \'ONE\'. Consider changing the cardinality if you want to allow that multiple instances of this section are created based on a mapping!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.structure.target.util.TargetValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tTargetValidator.TARGET_SECTION__VALIDATE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getTargetSection_ReferencingMappingHintGroups(), 
		   source, 
		   new String[] {
			 "get", "\r\nList<<%pamtram.mapping.Mapping%>> mappings = new <%java.util.ArrayList%><>();\r\n\r\nif (this.eResource() != null) {\r\n\r\n\tmappings = this.eResource().getResourceSet().getResources().stream()\r\n\t\t\t.filter(r -> r.getContents().get(0) instanceof pamtram.PAMTraM)\r\n\t\t\t.flatMap(r -> ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().stream())\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n}\r\n\r\nList<MappingHintGroupType> referencingHintGroups = mappings.stream().flatMap(m -> m.getMappingHintGroups().stream()).filter(m -> this.equals(m.getTargetSection())).collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList%><>(this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS,\r\n\t\treferencingHintGroups.size(), referencingHintGroups.toArray());"
		   });	
		addAnnotation
		  (getTargetSection_ReferencingMappingHintGroups(), 
		   source, 
		   new String[] {
			 "documentation", "All MappingHintGroups that lead to the instantiation of this TargetSection (that specify this as their \'targetSection\')."
		   });	
		addAnnotation
		  (getTargetSection_File(), 
		   source, 
		   new String[] {
			 "documentation", "If present, this specifies the model resp. file to which the created target model structure will be persisted.\r\n<br /><br />\r\nThis can be used to statically or dynamically specify the target models/model files to be created in the course of a transformation."
		   });	
		addAnnotation
		  (fileAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This specifies the model resp. file to which the target model structure(s) created based on this TargetSection will be persisted.\r\n<br /><br />\r\nThis can be used to statically or dynamically specify the target models/model files to be created in the course of a transformation. For example, this can be used to persist each instance of a TargetSection in its own file (if the \'value\' of this attribute is set dynamically for each instance)."
		   });	
		addAnnotation
		  (getFileAttribute_FileType(), 
		   source, 
		   new String[] {
			 "documentation", "The type of the model/file to be created."
		   });	
		addAnnotation
		  (fileTypeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "The type of a model/file."
		   });	
		addAnnotation
		  (fileTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "An XMI file that is based on an Ecore-based metamodel."
		   });	
		addAnnotation
		  (fileTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "An XML file that is based on an XML schema (XSD)."
		   });	
		addAnnotation
		  (targetSectionClassEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents one element (as an instance of an EClass) of an element structure to be created in a target model.\r\n<br />\r\nIn order to allow for the description of complex element structures, Classes can be equipped with Attributes and References (which itself may reference/contain other Classes)."
		   });	
		addAnnotation
		  (targetSectionReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference of an element structure to be created in a target model.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (targetSectionCompositeReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference (as an instance of an EReference) of an element structure to be created in a target model. CompositeReferences can be used to describe the tree that is the basis of an element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (targetSectionAnyContentCompositeReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a virtual reference for elements that are based on an XSD with \'xs:any\' specified as content. CompositeReferences can be used to describe the tree that is the basis of an element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getTargetSectionAnyContentCompositeReference__ValidateIsAllowed__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (!(this.eContainer() instanceof pamtram.structure.generic.Class)) {\r\n\treturn true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EClass%> parentEClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true : <%de.tud.et.ifa.agtele.emf.XSDAnyContentUtil%>.allowsAnyContent(parentEClass);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The containing Class does not allow \'any\' content!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.structure.target.util.TargetValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tTargetValidator.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE__VALIDATE_IS_ALLOWED, errorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (targetSectionCrossReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference (as an instance of an EReference) of an element structure to be created in a target model. CrossReferences can be used to describe references to other element structures or to other elements of this structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getTargetSectionCrossReference__ValidateEReferenceIsNonContainment__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getEReference() == null ? true : !this.getEReference().isContainment();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName() + \"\' is no non-containment reference! CrossReferences based on ContainmentReferences are not yet supported...\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.target.util.TargetValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tTargetValidator.TARGET_SECTION_CROSS_REFERENCE__VALIDATE_EREFERENCE_IS_NON_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (targetSectionAnyContentCrossReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a virtual reference for elements that are based on an XSD with \'xs:any\' specified as content. It can be used to reference any other element structure to be created in a target model. CrossReferences can be used to describe references to other element structures or to other elements of this structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getTargetSectionAnyContentCrossReference__ValidateIsAllowed__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (!(this.eContainer() instanceof pamtram.structure.generic.Class)) {\r\n\treturn true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EClass%> parentEClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true : <%de.tud.et.ifa.agtele.emf.XSDAnyContentUtil%>.allowsAnyContent(parentEClass);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The containing Class does not allow \'any\' content!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.structure.target.util.TargetValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tTargetValidator.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE__VALIDATE_IS_ALLOWED, errorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.target.TargetPackage%>.Literals.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (targetSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute of an element structure to be created in a target model."
		   });	
		addAnnotation
		  (getTargetSectionAttribute_Unique(), 
		   source, 
		   new String[] {
			 "documentation", "If this is set to \'true\', no two element structures with the same value of this Attribute will be created in the course of a transformation.\r\n<br /><br />\r\nCurrently, if a second element structure with the same attribute value would be created, this second structure is simply discarded. In the future, it might be useful to consider merging the two created structures."
		   });	
		addAnnotation
		  (getTargetSectionAttribute_Value(), 
		   source, 
		   new String[] {
			 "documentation", "This can be used to specify a fixed value for this attribute that will be used for all created instances.\r\n<br /><br />\r\nNote: The specified value will be overriden in case an AttributeMapping is specified for this Attribute."
		   });	
		addAnnotation
		  (actualTargetSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute (as an instance of an EAttribute) of an element structure to be created in a target model."
		   });	
		addAnnotation
		  (virtualTargetSectionAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute of a target model element structure. In contrast to \'actual\' Attributes, \'virtual\' Attributes do not represent an actual metamodel element (EAttribtue) an will thus not actually be persisted in the target model.\r\n<br /><br />\r\nVirtualTargetSectionAttributes are usually used as temporary variables (to store values calculated by means of an AttributeMapping). The stored values can then e.g. be used as reference value for Container- or ReferenceTargetSelectors."
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
		  (targetSectionEClass, 
		   source, 
		   new String[] {
			 "constraints", "isReferencedByMappingHintGroup"
		   });
	}

} //TargetPackageImpl
