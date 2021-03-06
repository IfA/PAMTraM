/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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

import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.impl.ExtendedPackageImpl;
import pamtram.mapping.impl.MappingPackageImpl;

import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.impl.ModifierPackageImpl;
import pamtram.structure.StructurePackage;

import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.impl.ConstraintPackageImpl;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.GenericFactory;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.VirtualAttribute;

import pamtram.structure.generic.VirtualReference;
import pamtram.structure.generic.util.GenericValidator;

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
	private EClass actualReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crossReferenceEClass = null;

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
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI) : ConstraintPackage.eINSTANCE);
		SourcePackageImpl theSourcePackage = (SourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) instanceof SourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) : SourcePackage.eINSTANCE);
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) : TargetPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		theGenericPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		theGenericPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
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
	public EReference getClass_AllContainer() {
		return (EReference)classEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_ActualAttributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_VirtualAttributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_ActualReferences() {
		return (EReference)classEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_VirtualReferences() {
		return (EReference)classEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AllAttributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AllReferences() {
		return (EReference)classEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AllConcreteExtending() {
		return (EReference)classEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AllCompositeReferences() {
		return (EReference)classEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AllCrossReferences() {
		return (EReference)classEClass.getEStructuralFeatures().get(14);
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
	public EOperation getClass__ValidateNotSelfContainer__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__ValidateOnlyComplementingActualReferences__DiagnosticChain_Map() {
		return classEClass.getEOperations().get(8);
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
	public EReference getSection_AllExtend() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_AllExtending() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(3);
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
	public EOperation getSection__ValidateNotExtendSelf__DiagnosticChain_Map() {
		return sectionEClass.getEOperations().get(2);
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
	public EReference getReference_OwningClass() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__GetValuesGeneric() {
		return referenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__AddValuesGeneric__EList() {
		return referenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__IsExtended() {
		return referenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReference__GetValuesIncludingExtended() {
		return referenceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualReference() {
		return actualReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActualReference_EReference() {
		return (EReference)actualReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getActualReference__ValidateEReferenceMatchesParentEClass__DiagnosticChain_Map() {
		return actualReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVirtualReference() {
		return virtualReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeReference() {
		return compositeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeReference_Value() {
		return (EReference)compositeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCompositeReference__ValidateEReferenceIsContainment__DiagnosticChain_Map() {
		return compositeReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCrossReference() {
		return crossReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrossReference_Value() {
		return (EReference)crossReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCrossReference__ValidateValuesMatchReferenceType__DiagnosticChain_Map() {
		return crossReferenceEClass.getEOperations().get(0);
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
		createEReference(classEClass, CLASS__ALL_CONTAINER);
		createEReference(classEClass, CLASS__ACTUAL_ATTRIBUTES);
		createEReference(classEClass, CLASS__VIRTUAL_ATTRIBUTES);
		createEReference(classEClass, CLASS__ACTUAL_REFERENCES);
		createEReference(classEClass, CLASS__VIRTUAL_REFERENCES);
		createEReference(classEClass, CLASS__ALL_ATTRIBUTES);
		createEReference(classEClass, CLASS__ALL_REFERENCES);
		createEReference(classEClass, CLASS__ALL_CONCRETE_EXTENDING);
		createEReference(classEClass, CLASS__ALL_COMPOSITE_REFERENCES);
		createEReference(classEClass, CLASS__ALL_CROSS_REFERENCES);
		createEOperation(classEClass, CLASS___IS_CONTAINER_FOR__CLASS);
		createEOperation(classEClass, CLASS___IS_CONTAINED_IN__CLASS);
		createEOperation(classEClass, CLASS___GET_OWNING_CONTAINMENT_REFERENCE);
		createEOperation(classEClass, CLASS___IS_REFERENCED_BY__CLASS_ELIST);
		createEOperation(classEClass, CLASS___VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___VALIDATE_CARDINALITY_IS_VALID__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___VALIDATE_CONTAINER_IS_VALID__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___VALIDATE_NOT_SELF_CONTAINER__DIAGNOSTICCHAIN_MAP);
		createEOperation(classEClass, CLASS___VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES__DIAGNOSTICCHAIN_MAP);

		sectionEClass = createEClass(SECTION);
		createEAttribute(sectionEClass, SECTION__ABSTRACT);
		createEReference(sectionEClass, SECTION__EXTEND);
		createEReference(sectionEClass, SECTION__ALL_EXTEND);
		createEReference(sectionEClass, SECTION__ALL_EXTENDING);
		createEOperation(sectionEClass, SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP);
		createEOperation(sectionEClass, SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP);
		createEOperation(sectionEClass, SECTION___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP);

		referenceEClass = createEClass(REFERENCE);
		createEReference(referenceEClass, REFERENCE__OWNING_CLASS);
		createEOperation(referenceEClass, REFERENCE___GET_VALUES_GENERIC);
		createEOperation(referenceEClass, REFERENCE___ADD_VALUES_GENERIC__ELIST);
		createEOperation(referenceEClass, REFERENCE___IS_EXTENDED);
		createEOperation(referenceEClass, REFERENCE___GET_VALUES_INCLUDING_EXTENDED);

		actualReferenceEClass = createEClass(ACTUAL_REFERENCE);
		createEReference(actualReferenceEClass, ACTUAL_REFERENCE__EREFERENCE);
		createEOperation(actualReferenceEClass, ACTUAL_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP);

		virtualReferenceEClass = createEClass(VIRTUAL_REFERENCE);

		compositeReferenceEClass = createEClass(COMPOSITE_REFERENCE);
		createEReference(compositeReferenceEClass, COMPOSITE_REFERENCE__VALUE);
		createEOperation(compositeReferenceEClass, COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP);

		crossReferenceEClass = createEClass(CROSS_REFERENCE);
		createEReference(crossReferenceEClass, CROSS_REFERENCE__VALUE);
		createEOperation(crossReferenceEClass, CROSS_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP);

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
		ETypeParameter actualReferenceEClass_S = addETypeParameter(actualReferenceEClass, "S");
		ETypeParameter actualReferenceEClass_C = addETypeParameter(actualReferenceEClass, "C");
		ETypeParameter actualReferenceEClass_R = addETypeParameter(actualReferenceEClass, "R");
		ETypeParameter actualReferenceEClass_A = addETypeParameter(actualReferenceEClass, "A");
		ETypeParameter virtualReferenceEClass_S = addETypeParameter(virtualReferenceEClass, "S");
		ETypeParameter virtualReferenceEClass_C = addETypeParameter(virtualReferenceEClass, "C");
		ETypeParameter virtualReferenceEClass_R = addETypeParameter(virtualReferenceEClass, "R");
		ETypeParameter virtualReferenceEClass_A = addETypeParameter(virtualReferenceEClass, "A");
		ETypeParameter compositeReferenceEClass_S = addETypeParameter(compositeReferenceEClass, "S");
		ETypeParameter compositeReferenceEClass_C = addETypeParameter(compositeReferenceEClass, "C");
		ETypeParameter compositeReferenceEClass_R = addETypeParameter(compositeReferenceEClass, "R");
		ETypeParameter compositeReferenceEClass_A = addETypeParameter(compositeReferenceEClass, "A");
		ETypeParameter crossReferenceEClass_S = addETypeParameter(crossReferenceEClass, "S");
		ETypeParameter crossReferenceEClass_C = addETypeParameter(crossReferenceEClass, "C");
		ETypeParameter crossReferenceEClass_R = addETypeParameter(crossReferenceEClass, "R");
		ETypeParameter crossReferenceEClass_A = addETypeParameter(crossReferenceEClass, "A");
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
		g2 = createEGenericType(actualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		actualReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(actualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		actualReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(actualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		actualReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(actualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		actualReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(virtualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		virtualReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(virtualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		virtualReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(virtualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		virtualReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(virtualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		virtualReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(compositeReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		compositeReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(compositeReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		compositeReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(compositeReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		compositeReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(compositeReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		compositeReferenceEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(this.getSection());
		g2 = createEGenericType(crossReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		crossReferenceEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(this.getClass_());
		g2 = createEGenericType(crossReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		crossReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(crossReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		crossReferenceEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(this.getAttribute());
		g2 = createEGenericType(crossReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		crossReferenceEClass_A.getEBounds().add(g1);
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
		g2 = createEGenericType(actualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		actualReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(virtualReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(virtualReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		virtualReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(compositeReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(compositeReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		compositeReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getReference());
		g2 = createEGenericType(crossReferenceEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(crossReferenceEClass_A);
		g1.getETypeArguments().add(g2);
		crossReferenceEClass.getEGenericSuperTypes().add(g1);
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
		g1 = createEGenericType(classEClass_C);
		initEReference(getClass_AllContainer(), g1, null, "allContainer", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_A);
		initEReference(getClass_ActualAttributes(), g1, null, "actualAttributes", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_A);
		initEReference(getClass_VirtualAttributes(), g1, null, "virtualAttributes", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_R);
		initEReference(getClass_ActualReferences(), g1, null, "actualReferences", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_R);
		initEReference(getClass_VirtualReferences(), g1, null, "virtualReferences", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_A);
		initEReference(getClass_AllAttributes(), g1, null, "allAttributes", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_R);
		initEReference(getClass_AllReferences(), g1, null, "allReferences", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		initEReference(getClass_AllConcreteExtending(), g1, null, "allConcreteExtending", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getCompositeReference());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		initEReference(getClass_AllCompositeReferences(), g1, null, "allCompositeReferences", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getCrossReference());
		g2 = createEGenericType(classEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(classEClass_A);
		g1.getETypeArguments().add(g2);
		initEReference(getClass_AllCrossReferences(), g1, null, "allCrossReferences", null, 0, -1, pamtram.structure.generic.Class.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getClass__IsContainerFor__Class(), ecorePackage.getEBoolean(), "isContainerFor", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "containedClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__IsContainedIn__Class(), ecorePackage.getEBoolean(), "isContainedIn", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(classEClass_C);
		addEParameter(op, g1, "containerClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__GetOwningContainmentReference(), null, "getOwningContainmentReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getCompositeReference());
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

		op = initEOperation(getClass__ValidateNotSelfContainer__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNotSelfContainer", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClass__ValidateOnlyComplementingActualReferences__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyComplementingActualReferences", 0, 1, IS_UNIQUE, IS_ORDERED);
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
		g1 = createEGenericType(sectionEClass_S);
		initEReference(getSection_AllExtend(), g1, null, "allExtend", null, 0, -1, Section.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(sectionEClass_S);
		initEReference(getSection_AllExtending(), g1, null, "allExtending", null, 0, -1, Section.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

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

		op = initEOperation(getSection__ValidateNotExtendSelf__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNotExtendSelf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(referenceEClass_C);
		initEReference(getReference_OwningClass(), g1, this.getClass_References(), "owningClass", null, 0, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getReference__GetValuesGeneric(), null, "getValuesGeneric", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		initEOperation(op, g1);

		op = initEOperation(getReference__AddValuesGeneric__EList(), null, "addValuesGeneric", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		addEParameter(op, g1, "values", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getReference__IsExtended(), ecorePackage.getEBoolean(), "isExtended", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getReference__GetValuesIncludingExtended(), null, "getValuesIncludingExtended", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(referenceEClass_C);
		initEOperation(op, g1);

		initEClass(actualReferenceEClass, ActualReference.class, "ActualReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualReference_EReference(), ecorePackage.getEReference(), null, "eReference", null, 1, 1, ActualReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getActualReference__ValidateEReferenceMatchesParentEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEReferenceMatchesParentEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(virtualReferenceEClass, VirtualReference.class, "VirtualReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeReferenceEClass, CompositeReference.class, "CompositeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(compositeReferenceEClass_C);
		initEReference(getCompositeReference_Value(), g1, null, "value", null, 0, -1, CompositeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCompositeReference__ValidateEReferenceIsContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEReferenceIsContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(crossReferenceEClass, CrossReference.class, "CrossReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(crossReferenceEClass_C);
		initEReference(getCrossReference_Value(), g1, null, "value", null, 0, -1, CrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCrossReference__ValidateValuesMatchReferenceType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateValuesMatchReferenceType", 0, 1, IS_UNIQUE, IS_ORDERED);
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
			 "documentation", "This package contains all elements related to the generic description of element structures.\r\n<br />\r\nElement structures are always based on a specific metamodel but may impose further restrictions. For example, one may describe a structure containing of an element (Class) which holds exactly one element (Class) via a certain reference (Reference), although the metamodel allows for an unlimited number of elements referenced via this reference. Another example is the description of certain constraints for values of attributes (Attribute)."
		   });	
		addAnnotation
		  (metaModelElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "The super type for all specific types that can be used to describe element structures."
		   });	
		addAnnotation
		  (getMetaModelElement__GetContainingSection(), 
		   source, 
		   new String[] {
			 "body", "MetaModelElement<S,C,R,A> element = this;\r\n\r\n// move upwards in the hierarchy\r\nwhile(element.eContainer() instanceof MetaModelElement) {\r\n\telement = (MetaModelElement<S,C,R,A>) element.eContainer();\r\n}\r\n\r\nif(element instanceof Section || element.eContainer() instanceof ContainerParameter) {\r\n\t// we have found the section\r\n\treturn (S) element;\r\n} else if((element instanceof TargetSectionAttribute && (element.eContainer() instanceof AttributeParameter || element.eContainer() instanceof ResourceParameter)) || \r\n\t\t(element instanceof TargetSectionCrossReference) && element.eContainer() instanceof ExternalReferenceParameter) {\r\n\tLibraryEntry libEntry = (LibraryEntry) element.eContainer().eContainer();\r\n\tfor (LibraryParameter<?> param : libEntry.getParameters()) {\r\n\t\t//TODO if multiple container parameters exist, there might need to be additional logic\r\n\t\tif(param instanceof ContainerParameter) {\r\n\t\t\treturn (S) ((ContainerParameter) param).getClass_();\r\n\t\t}\r\n\t}\r\n\treturn null;\r\n} else  if(element instanceof VirtualTargetSectionAttribute && element.eContainer() instanceof LibraryEntry) {\r\n\tLibraryEntry libEntry = (LibraryEntry) element.eContainer();\r\n\tfor (LibraryParameter<?> param : libEntry.getParameters()) {\r\n\t\t//TODO if multiple container parameters exist, there might need to be additional logic\r\n\t\tif(param instanceof ContainerParameter) {\r\n\t\t\treturn (S) ((ContainerParameter) param).getClass_();\r\n\t\t}\r\n\t}\r\n\treturn null;\r\n} else {\r\n\t// something went wrong\r\n\treturn null;\r\n}"
		   });	
		addAnnotation
		  (getMetaModelElement__GetContainingSectionModel(), 
		   source, 
		   new String[] {
			 "body", "S section = this.getContainingSection();\r\n\r\nEObject container = section.eContainer();\r\nwhile(!(container instanceof SectionModel)) {\r\n\t// we have reached the root element\r\n\tif(container == null) {\r\n\t\treturn null;\r\n\t}\r\n\tcontainer = container.eContainer();\r\n}\r\nreturn (SectionModel<S, C, R, A>) container;"
		   });	
		addAnnotation
		  (getMetaModelElement__IsLibraryEntry(), 
		   source, 
		   new String[] {
			 "body", "return (this.getContainingSection().eContainer() instanceof ContainerParameter);"
		   });	
		addAnnotation
		  (classEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents one element (as an instance of an EClass) of an element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, Classes can be equipped with Attributes and References (which itself may reference/contain other Classes)."
		   });	
		addAnnotation
		  (getClass__IsContainerFor__Class(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (<%org.eclipse.emf.ecore.util.EcoreUtil%>.isAncestor(this, containedClass)\r\n\t\t|| this.getContainingSection().getAllExtend().stream().anyMatch(c -> c.isContainerFor(containedClass))\r\n\t\t|| containedClass.getContainingSection().getAllExtend().stream()\r\n\t\t\t\t.anyMatch(c -> this.isContainerFor((C) c))) {\r\n\treturn true;\r\n}\r\n\r\nC container = containedClass.getContainingSection().getContainer();\r\n\r\n// this means that we have reached the top level container for the \'containedClass\'\r\nif (container == null) {\r\n\treturn false;\r\n}\r\n\r\n// Prevent stack overflow in case of modeling error\r\n//\r\nif (EcoreUtil.isAncestor(containedClass, container)) {\r\n\treturn false;\r\n}\r\n\r\n// this was not the container, so iterate up in the containment hierarchy\r\nreturn this.isContainerFor(container);\r\n"
		   });	
		addAnnotation
		  (getClass__IsContainedIn__Class(), 
		   source, 
		   new String[] {
			 "body", "\r\n// recursively collect all classes that are referenced by containment references and check if any matches this\r\n// class\r\n//\r\nreturn containerClass.getAllReferences().stream()\r\n\t\t.filter(r -> r instanceof <%pamtram.structure.generic.ActualReference%><?, ?, ?, ?>\r\n\t\t\t\t&& ((ActualReference<?, ?, ?, ?>) r).getEReference().isContainment())\r\n\t\t.flatMap(r -> r.getValuesGeneric().stream()).anyMatch(\r\n\t\t\t\tc -> c.equals(this)\r\n\t\t\t\t\t\t|| c instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?>\r\n\t\t\t\t\t\t\t\t&& ((Section<?, ?, ?, ?>) c).getAllExtending().contains(this)\r\n\t\t\t\t\t\t|| this.isContainedIn(c));"
		   });	
		addAnnotation
		  (getClass__GetOwningContainmentReference(), 
		   source, 
		   new String[] {
			 "body", "if(this.eContainer() instanceof CompositeReference<?,?,?,?>) {\r\n\treturn (CompositeReference<S,C,R,A>) this.eContainer();\r\n} else {\r\n\treturn null;\r\n}"
		   });	
		addAnnotation
		  (getClass__IsReferencedBy__Class_EList(), 
		   source, 
		   new String[] {
			 "body", "if(referencedClasses == null) {\r\n\treferencedClasses = new BasicEList<>();\r\n}\r\nBasicEList<C> classes = new BasicEList<>();\r\n\r\n// collect all classes that are referenced\r\nfor (R ref : referencingClass.getReferences()) {\r\n\r\n\tif(ref instanceof ContainmentReference<?,?,?,?>){\r\n\t\tclasses.addAll(((ContainmentReference<S,C,R,A>) ref).getValue());\r\n\t} else if(ref instanceof MetaModelSectionReference) {\r\n\t\tclasses.addAll((Collection<? extends C>) ((MetaModelSectionReference) ref).getValue());\r\n\t} else if(ref instanceof NonContainmentReference){\r\n\t\tclasses.addAll(((NonContainmentReference<S,C,R,A>) ref).getValue());\r\n\t}\r\n}\r\n\r\n// recursively iterate over all referenced classes\r\nfor (C clazz : classes) {\r\n\tif(clazz.equals(this) || isReferencedBy(clazz, referencedClasses)) {\r\n\t\treturn true;\r\n\t} else {\r\n\t\tif(!referencedClasses.contains(clazz)) {\r\n\t\t\treferencedClasses.add(clazz);\r\n\t\t}\r\n\t}\r\n}\r\n\r\nreturn false;"
		   });	
		addAnnotation
		  (getClass__ValidateEClassMatchesParentEReference__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (this == this.getContainingSection() || this.getEClass() == null\r\n\t\t|| !(this.eContainer() instanceof <%pamtram.structure.generic.ActualReference%><?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\nActualReference<?, ?, ?, ?> parentReference = (ActualReference<?, ?, ?, ?>) this.eContainer();\r\n\r\nif (parentReference.getEReference() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = <%org.eclipse.emf.ecore.EcorePackage%>.Literals.EOBJECT.equals(parentReference.getEReference().getEReferenceType())\r\n\t\t|| parentReference.getEReference().getEReferenceType().isSuperTypeOf(this.getEClass());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eClass \'\" + this.eClass().getName()\r\n\t\t\t+ \"\' is not allowed by the containing reference!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE, errorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ECLASS }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getClass__ValidateCardinalityIsValid__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(this == this.getContainingSection() || this.getEClass() == null || !(this.eContainer() instanceof ActualReference<?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.generic.ActualReference%><?, ?, ?, ?> parentReference = (ActualReference<?, ?, ?, ?>) this.eContainer();\r\n\r\nif(parentReference.getEReference() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = !(this.cardinality != <%pamtram.structure.generic.CardinalityType%>.ONE && parentReference.getEReference().getUpperBound() == 1 && parentReference.getEReference().getLowerBound() == 1);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The cardinality of a Class must be specified as \'CardinalityType::ONE\' when the upper and lower bound of the containing Reference is \'1\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.CLASS__VALIDATE_CARDINALITY_IS_VALID,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__CARDINALITY }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getClass__ValidateContainerIsValid__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result;\r\nString errorMessage = \"\";\r\n\r\nif (this.getContainer() == null) {\r\n\t// nothing specified -> no problem as the \'container\' is an optional info\r\n\t//\r\n\tresult = true;\r\n} else if (this instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?>) {\r\n\t// For Sections, the container must point to a Class that can theoretically (according to the metamodel) act\r\n\t// as container\r\n\t//\r\n\tresult = this.getEClass() == null || this.getContainer().getEClass() == null\r\n\t\t\t|| pamtram.util.XSDAnyContentUtil\r\n\t\t\t\t\t.getEAllReferencesIncludingVirtualAnyContentReference(this.getContainer().getEClass(),\r\n\t\t\t\t\t\t\t<%de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType%>.CONTAINMENT)\r\n\t\t\t\t\t.stream().map(org.eclipse.emf.ecore.EReference::getEReferenceType).anyMatch(\r\n\t\t\t\t\t\t\te -> e.equals(<%org.eclipse.emf.ecore.EcorePackage%>.Literals.EOBJECT) || e.isSuperTypeOf(this.getEClass()));\r\n\terrorMessage = \"The \'container\' reference must point to a Class whose type (<%org.eclipse.emf.ecore.EClass%>) owns a suitable containment reference!\";\r\n} else {\r\n\t// For normal Class, the container must point to a the containing Class\r\n\t//\r\n\tresult = this.getContainer().equals(this.eContainer().eContainer());\r\n\terrorMessage = \"The \'container\' refrence must point to the containing Class!\";\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_CONTAINER_IS_VALID, errorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__CONTAINER }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getClass__ValidateNotSelfContainer__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "boolean result = !this.getAllContainer().contains(this);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Class must not specify itself as container (neither directly nor indirectly)!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, \r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\tGenericValidator.CLASS__VALIDATE_NOT_SELF_CONTAINER, \r\n\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__CONTAINER }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getClass__ValidateOnlyComplementingActualReferences__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\n<%java.util.List%><<%org.eclipse.emf.ecore.EReference%>> actualCompositeReferences = this.getActualReferences().stream()\r\n\t\t.filter(r -> r instanceof <%pamtram.structure.generic.CompositeReference%><?, ?, ?, ?>)\r\n\t\t.map(r -> ((<%pamtram.structure.generic.ActualReference%><?, ?, ?, ?>) r).getEReference()).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\nboolean noCompositeDuplicates = actualCompositeReferences.size() == new <%java.util.HashSet%><>(actualCompositeReferences)\r\n\t\t.size();\r\n\r\nif (!noCompositeDuplicates && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Class must not specify two CompositeReferences that represent the same EReference!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES, errorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__REFERENCES }));\r\n\r\n\treturn false;\r\n}\r\n\r\nList<EReference> actualCrossReferences = this.getActualReferences().stream()\r\n\t\t.filter(r -> r instanceof <%pamtram.structure.generic.CrossReference%><?, ?, ?, ?>)\r\n\t\t.map(r -> ((ActualReference<?, ?, ?, ?>) r).getEReference()).collect(Collectors.toList());\r\n\r\nboolean noCrossDuplicates = actualCrossReferences.size() == new HashSet<>(actualCrossReferences).size();\r\n\r\nif (!noCrossDuplicates && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Class must not specify two CrossReferences that represent the same EReference!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES, errorMessage,\r\n\t\t\tnew Object[] { this, GenericPackage.Literals.CLASS__REFERENCES }));\r\n\r\n\treturn false;\r\n}\r\n\r\nreturn true;"
		   });	
		addAnnotation
		  (getClass_EClass(), 
		   source, 
		   new String[] {
			 "documentation", "The metamodel element (EClass) that this Class represents.",
			 "propertyDescriptor", "\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_Class_eClass_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_Class_eClass_description\", \"_UI_Class_eClass_feature\", \"_UI_Class_type\"),\r\n\t\t\t\t<%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ECLASS, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\tpamtram.structure.generic.Class<?, ?, ?, ?> selectedClass = (<%pamtram.structure.generic.Class%><?, ?, ?, ?>) object;\r\n\t\t\t\t<%pamtram.structure.generic.Section%><?, ?, ?, ?> containingSection = selectedClass.getContainingSection();\r\n\r\n\t\t\t\t/*\r\n\t\t\t\t * If we have a container parameter with a specified source, we do not need to scan package\r\n\t\t\t\t * contents. Instead, the user may only select the eClass of the specified source element.\r\n\t\t\t\t */\r\n\t\t\t\tif (containingSection.eContainer() instanceof <%pamtram.structure.library.ContainerParameter%>\r\n\t\t\t\t\t\t&& ((ContainerParameter) containingSection.eContainer()).getSource() != null) {\r\n\t\t\t\t\treturn <%java.util.Arrays%>\r\n\t\t\t\t\t\t\t.asList(((ContainerParameter) containingSection.eContainer()).getSource().eClass());\r\n\t\t\t\t}\r\n\r\n\t\t\t\t<%pamtram.SectionModel%><?, ?, ?, ?> containingSectionModel = containingSection.getContainingSectionModel();\r\n\r\n\t\t\t\tif (containingSectionModel.getMetaModelPackage() == null) {\r\n\t\t\t\t\treturn <%java.util.Collections%>.emptyList();\r\n\t\t\t\t}\r\n\r\n\t\t\t\tboolean selectedClassIsSection = containingSection.equals(object);\r\n\r\n\t\t\t\t<%java.util.List%><<%org.eclipse.emf.ecore.EClass%>> choiceOfValues = new <%java.util.ArrayList%><>();\r\n\r\n\t\t\t\tList<SectionModel<?, ?, ?, ?>> sectionModelsToConsider = new ArrayList<>();\r\n\t\t\t\tif (<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(containingSection, <%pamtram.PamtramPackage%>.Literals.PAM_TRA_M)) {\r\n\t\t\t\t\tif (containingSection instanceof <%pamtram.structure.source.SourceSection%>) {\r\n\t\t\t\t\t\tsectionModelsToConsider\r\n\t\t\t\t\t\t\t\t.addAll(((<%pamtram.PAMTraM%>) AgteleEcoreUtil.getAncestorOfKind(containingSection,\r\n\t\t\t\t\t\t\t\t\t\tPamtramPackage.Literals.PAM_TRA_M)).getSourceSectionModels());\r\n\t\t\t\t\t} else if (containingSection instanceof <%pamtram.structure.target.TargetSection%>) {\r\n\t\t\t\t\t\tsectionModelsToConsider\r\n\t\t\t\t\t\t\t\t.addAll(((PAMTraM) AgteleEcoreUtil.getAncestorOfKind(containingSection,\r\n\t\t\t\t\t\t\t\t\t\tPamtramPackage.Literals.PAM_TRA_M)).getTargetSectionModels());\r\n\t\t\t\t\t}\r\n\t\t\t\t} else {\r\n\t\t\t\t\tsectionModelsToConsider.add((SectionModel<?, ?, ?, ?>) AgteleEcoreUtil\r\n\t\t\t\t\t\t\t.getAncestorOfKind(containingSection, PamtramPackage.Literals.SECTION_MODEL));\r\n\t\t\t\t}\r\n\r\n\t\t\t\t<%java.util.Set%><<%org.eclipse.emf.ecore.EPackage%>> ePackagesOfSectionModelsToConsider = sectionModelsToConsider.stream()\r\n\t\t\t\t\t\t.map(SectionModel::getMetaModelPackage).collect(<%java.util.stream.Collectors%>.toSet());\r\n\r\n\t\t\t\tSet<EPackage> packagesToScan = <%de.tud.et.ifa.agtele.emf.EPackageHelper%>.collectEPackages(\r\n\t\t\t\t\t\tePackagesOfSectionModelsToConsider, true, true, !selectedClassIsSection,\r\n\t\t\t\t\t\t<%java.util.Optional%>.empty());\r\n\r\n\t\t\t\tfor (EPackage pkg : packagesToScan) {\r\n\r\n\t\t\t\t\tEClass docroot = <%org.eclipse.emf.ecore.util.ExtendedMetaData%>.INSTANCE.getDocumentRoot(pkg);\r\n\r\n\t\t\t\t\tList<EClass> classesInPackage = pkg.getEClassifiers().stream()\r\n\t\t\t\t\t\t\t.filter(EClass.class::isInstance).map(EClass.class::cast)\r\n\t\t\t\t\t\t\t.collect(Collectors.toList());\r\n\t\t\t\t\tfor (EClass eClass : classesInPackage) {\r\n\r\n\t\t\t\t\t\t// Do not consider DocRoot classes; Abstract EClasses are only allowed for\r\n\t\t\t\t\t\t// SourceSections or abstract TargetSections\r\n\t\t\t\t\t\t//\r\n\t\t\t\t\t\tif (!eClass.equals(docroot) && (!eClass.isAbstract()\r\n\t\t\t\t\t\t\t\t|| object instanceof <%pamtram.structure.source.SourceSectionClass%>\r\n\t\t\t\t\t\t\t\t|| object instanceof TargetSection && ((TargetSection) object).isAbstract())) {\r\n\t\t\t\t\t\t\tchoiceOfValues.add(eClass);\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\tif (selectedClassIsSection) { // top level-section\r\n\t\t\t\t\treturn choiceOfValues;\r\n\t\t\t\t} else { // not a top-level section\r\n\t\t\t\t\tList<EClass> newChoiceOfValues = new <%java.util.LinkedList%><>();\r\n\t\t\t\t\t<%pamtram.structure.generic.Reference%><?, ?, ?, ?> ref = (Reference<?, ?, ?, ?>) ((Class<?, ?, ?, ?>) object)\r\n\t\t\t\t\t\t\t.eContainer();\r\n\t\t\t\t\tif (ref instanceof <%pamtram.structure.generic.ActualReference%><?, ?, ?, ?>\r\n\t\t\t\t\t\t\t&& ((ActualReference<?, ?, ?, ?>) ref).getEReference() != null) {\r\n\t\t\t\t\t\tif (!(((ActualReference<?, ?, ?, ?>) ref).getEReference()\r\n\t\t\t\t\t\t\t\t.getEType() instanceof EClass)) {\r\n\t\t\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\t\t\"Type checks can only be performed for instances of type \'EClass\'\");\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\tEClass refClass = null;\r\n\r\n\t\t\t\t\t\t\ttry {\r\n\t\t\t\t\t\t\t\trefClass = (EClass) ((ActualReference<?, ?, ?, ?>) ref).getEReference()\r\n\t\t\t\t\t\t\t\t\t\t.getEGenericType().getERawType();\r\n\t\t\t\t\t\t\t} catch (Exception e) {\r\n\t\t\t\t\t\t\t\trefClass = (EClass) ((ActualReference<?, ?, ?, ?>) ref).getEReference()\r\n\t\t\t\t\t\t\t\t\t\t.getEType();\r\n\t\t\t\t\t\t\t}\r\n\r\n\t\t\t\t\t\t\tif (<%org.eclipse.emf.ecore.EcorePackage%>.Literals.EOBJECT.equals(refClass)) {\r\n\t\t\t\t\t\t\t\tnewChoiceOfValues.addAll(choiceOfValues);\r\n\t\t\t\t\t\t\t} else if (refClass != null) {\r\n\r\n\t\t\t\t\t\t\t\tfor (EClass c : choiceOfValues) {\r\n\t\t\t\t\t\t\t\t\tif (refClass.isSuperTypeOf(c)) {\r\n\t\t\t\t\t\t\t\t\t\tnewChoiceOfValues.add(c);\r\n\t\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\treturn newChoiceOfValues;\r\n\r\n\t\t\t\t\t\t}\r\n\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\t}\r\n\t\t\t\treturn super.getChoiceOfValues(object);\r\n\t\t\t}\r\n\r\n\t\t});"
		   });	
		addAnnotation
		  (getClass_Cardinality(), 
		   source, 
		   new String[] {
			 "documentation", "This can be used to specify a cardinality constraint for this element.\r\n<br />\r\nFor example, setting this to \'ONE\' means that exactly one element must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections)."
		   });	
		addAnnotation
		  (getClass_References(), 
		   source, 
		   new String[] {
			 "documentation", "A list of References based on which further elements of the element structure a specified."
		   });	
		addAnnotation
		  (getClass_Container(), 
		   source, 
		   new String[] {
			 "documentation", "This can be used to specify additional constraints on the containment structure of the current element structure.\r\n<br />\r\nFor SourceSections: By setting the \'container\' reference, SourceSections will only be matched if the specified container Class can also be matched in the source model.\r\n<br />\r\nFor TargetSections: Created target structures will automatically connected to (contained by) an instance of the specified container Class.",
			 "propertyDescriptor", "\r\nitemPropertyDescriptors.add(new ItemPropertyDescriptor(\r\n\t\t((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),\r\n\t\tthis.getString(\"_UI_Class_container_feature\"),\r\n\t\tobject instanceof <%pamtram.structure.source.SourceSectionClass%> ? this.getString(\"_UI_SourceSectionClass_container_description\")\r\n\t\t\t\t: this.getString(\"_UI_TargetSectionClass_container_description\"),\r\n\t\t<%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__CONTAINER, true, false, true, null,\r\n\t\tthis.getString(\"_UI_ExtendedPropertyCategory\"), null) {\r\n\r\n\t@Override\r\n\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\r\n\t\t<%java.util.List%><Object> ret = new <%java.util.ArrayList%><>();\r\n\r\n\t\tif (object instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?>) {\r\n\t\t\tret = super.getChoiceOfValues(object).stream()\r\n\t\t\t\t\t.filter(o -> o instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)\r\n\t\t\t\t\t.map(o -> (pamtram.structure.generic.Class<?, ?, ?, ?>) o)\r\n\t\t\t\t\t.filter(o -> pamtram.util.XSDAnyContentUtil\r\n\t\t\t\t\t\t\t.getEAllReferencesIncludingVirtualAnyContentReference(o.getEClass(),\r\n\t\t\t\t\t\t\t\t\tde.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType.CONTAINMENT)\r\n\t\t\t\t\t\t\t.stream()\r\n\t\t\t\t\t\t\t.anyMatch(c -> c.getEReferenceType().equals(<%org.eclipse.emf.ecore.EcorePackage%>.Literals.EOBJECT) || c\r\n\t\t\t\t\t\t\t\t\t.getEReferenceType()\r\n\t\t\t\t\t\t\t\t\t.isSuperTypeOf(((pamtram.structure.generic.Class<?, ?, ?, ?>) object)\r\n\t\t\t\t\t\t\t\t\t\t\t.getEClass())))\r\n\t\t\t\t\t.filter(o -> !o.getAllContainer().contains(object)).collect(<%java.util.stream.Collectors%>.toList());\r\n\t\t} else {\r\n\r\n\t\t\t// For normal \'Classes\', the container property is not relevant to the\r\n\t\t\t// user. If it is set, it has to point to the containing \'Class\'...\r\n\t\t\t//\r\n\t\t\tif (((<%org.eclipse.emf.ecore.EObject%>) object).eContainer()\r\n\t\t\t\t\t.eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>) {\r\n\t\t\t\tret.add(((EObject) object).eContainer().eContainer());\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn ret;\r\n\r\n\t}\r\n});"
		   });	
		addAnnotation
		  (getClass_Attributes(), 
		   source, 
		   new String[] {
			 "documentation", "A list of Attribute further describing the current element.\r\n<br />\r\nSpecified attributes can e.g. be equipped with additional constraints (for SourceSections) or can be set via an AttributeMapping (for TargetSections)."
		   });	
		addAnnotation
		  (getClass_AllContainer(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><Object> ret = new <%java.util.ArrayList%><>();\r\nif(this.getContainer() != null) {\r\n\r\n\t<%pamtram.structure.generic.Class%><?, ?, ?, ?> toCheck = this;\r\n\r\n\twhile (toCheck.getContainer() != null && !ret.contains(toCheck.getContainer())) {\r\n\t\tret.add(toCheck.getContainer());\r\n\t\ttoCheck = toCheck.getContainer();\r\n\t}\r\n\t\r\n\tif(this.getContainer() instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?>) {\t\t\t\t\r\n\t\tret.addAll(((Section<?, ?, ?, ?>) this.getContainer()).getAllExtend());\r\n\t\tret.addAll(((Section<?, ?, ?, ?>) this.getContainer()).getAllExtend().stream().flatMap(s -> s.getAllContainer().stream()).collect(<%java.util.stream.Collectors%>.toList()));\r\n\t}\r\n}\r\n\r\nret = ret.stream().distinct().collect(Collectors.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ALL_CONTAINER,\r\n\t\tret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getClass_AllContainer(), 
		   source, 
		   new String[] {
			 "documentation", "The list of recursively collected \'container\' Classes."
		   });	
		addAnnotation
		  (getClass_ActualAttributes(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><Object> ret = this.getAttributes().stream().filter(a -> a instanceof pamtram.structure.generic.ActualAttribute<?, ?, ?, ?>).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ACTUAL_ATTRIBUTES,\r\n\t\tret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getClass_ActualAttributes(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'attributes\' that are of type ActualAttribute."
		   });	
		addAnnotation
		  (getClass_VirtualAttributes(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><Object> ret = this.getAttributes().stream().filter(a -> a instanceof pamtram.structure.generic.VirtualAttribute<?, ?, ?, ?>).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ACTUAL_ATTRIBUTES,\r\n\t\tret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getClass_VirtualAttributes(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'attributes\' that are of type VirtualAttribute."
		   });	
		addAnnotation
		  (getClass_ActualReferences(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><Object> ret = this.getReferences().stream().filter(a -> a instanceof pamtram.structure.generic.ActualReference<?, ?, ?, ?>).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ACTUAL_REFERENCES,\r\n\t\tret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getClass_ActualReferences(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'references\' that are of type ActualReference."
		   });	
		addAnnotation
		  (getClass_VirtualReferences(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.List%><Object> ret = this.getReferences().stream().filter(a -> a instanceof pamtram.structure.generic.VirtualReference<?, ?, ?, ?>).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__VIRTUAL_REFERENCES,\r\n\t\tret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getClass_VirtualReferences(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'references\' that are of type VirtualReference."
		   });	
		addAnnotation
		  (getClass_AllAttributes(), 
		   source, 
		   new String[] {
			 "get", "List<Object> ret = new ArrayList<>();\n\nret.addAll(this.getAttributes());\n\nif (this instanceof Section<?, ?, ?, ?>) {\n\tret.addAll(((Section<?, ?, ?, ?>) this).getAllExtend().stream().flatMap(s -> s.getAttributes().stream())\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList()));\n}\n\nif (this.isLibraryEntry()) {\n\n\t<%pamtram.structure.library.LibraryEntry%> libraryEntry = (<%pamtram.structure.library.LibraryEntry%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(this,\n\t\t\t<%pamtram.structure.library.LibraryPackage%>.Literals.LIBRARY_ENTRY);\n\n\tif (libraryEntry != null) {\n\n\t\tret.add(libraryEntry.getId());\n\t\tret.add(libraryEntry.getClasspath());\n\t\tret.addAll(libraryEntry.getParameters().stream().filter(p -> p instanceof pamtram.structure.library.AttributeParameter)\n\t\t\t\t.map(p -> ((pamtram.structure.library.AttributeParameter) p).getAttribute()).collect(<%java.util.stream.Collectors%>.toList()));\n\t}\n}\n\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ALL_ATTRIBUTES, ret.size(),\n\t\tret.toArray());"
		   });	
		addAnnotation
		  (getClass_AllAttributes(), 
		   source, 
		   new String[] {
			 "documentation", "The list of Attributes (if this is a Section, including those of extended Sections)."
		   });	
		addAnnotation
		  (getClass_AllReferences(), 
		   source, 
		   new String[] {
			 "get", "List<Object> ret = new ArrayList<>();\n\nret.addAll(this.getReferences());\n\nif (this instanceof Section<?, ?, ?, ?>) {\n\tret.addAll(((Section<?, ?, ?, ?>) this).getAllExtend().stream().flatMap(s -> s.getReferences().stream())\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList()));\n}\n\nif (this.isLibraryEntry()) {\n\n\t<%pamtram.structure.library.LibraryEntry%> libraryEntry = (<%pamtram.structure.library.LibraryEntry%>) <%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.getAncestorOfKind(this,\n\t\t\t<%pamtram.structure.library.LibraryPackage%>.Literals.LIBRARY_ENTRY);\n\n\tif (libraryEntry != null) {\n\n\t\tret.addAll(libraryEntry.getParameters().stream().filter(p -> p instanceof pamtram.structure.library.ExternalReferenceParameter)\n\t\t\t\t.map(p -> ((pamtram.structure.library.ExternalReferenceParameter) p).getReference()).collect(<%java.util.stream.Collectors%>.toList()));\n\t}\n}\n\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ALL_REFERENCES, ret.size(),\n\t\tret.toArray());"
		   });	
		addAnnotation
		  (getClass_AllReferences(), 
		   source, 
		   new String[] {
			 "documentation", "The list of References (if this is a Section, including those of extended Sections)."
		   });	
		addAnnotation
		  (getClass_AllConcreteExtending(), 
		   source, 
		   new String[] {
			 "get", "@SuppressWarnings(\"unchecked\")\nList<Object> ret = this instanceof Section<?, ?, ?, ?> && ((S) this).isAbstract()\n\t\t? ((S) this).getAllExtending().stream().filter(s -> !s.isAbstract()).collect(<%java.util.stream.Collectors%>.toList())\n\t\t: <%java.util.Arrays%>.asList(this);\n\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ALL_CONCRETE_EXTENDING, ret.size(),\n\t\tret.toArray());"
		   });	
		addAnnotation
		  (getClass_AllConcreteExtending(), 
		   source, 
		   new String[] {
			 "documentation", "If this element is a Section, this returns the list of recursively collected Sections extending this Section that are not \'abstract\'. Otherwise, returns a list containing only this element."
		   });	
		addAnnotation
		  (getClass_AllCompositeReferences(), 
		   source, 
		   new String[] {
			 "get", "\r\n<%java.util.List%><Object> ret = this.getAllReferences().stream().filter(r -> r instanceof <%pamtram.structure.generic.CompositeReference%><?, ?, ?, ?>)\r\n\t\t.map(r -> (CompositeReference<?, ?, ?, ?>) r).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ALL_COMPOSITE_REFERENCES,\r\n\t\tret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getClass_AllCompositeReferences(), 
		   source, 
		   new String[] {
			 "documentation", "The list of CompositeReferences (if this is a Section, including those of extended Sections)."
		   });	
		addAnnotation
		  (getClass_AllCrossReferences(), 
		   source, 
		   new String[] {
			 "get", "\r\n<%java.util.List%><Object> ret = this.getAllReferences().stream().filter(r -> r instanceof <%pamtram.structure.generic.CrossReference%><?, ?, ?, ?>)\r\n\t\t.map(r -> (CrossReference<?, ?, ?, ?>) r).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.CLASS__ALL_CROSS_REFERENCES, ret.size(),\r\n\t\tret.toArray());"
		   });	
		addAnnotation
		  (getClass_AllCrossReferences(), 
		   source, 
		   new String[] {
			 "documentation", "The list of CrossReferences (if this is a Section, including those of extended Sections)."
		   });	
		addAnnotation
		  (sectionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A special Class that represents the root element (as an instance of an EClass) of an element structure.\r\n<br />\r\nNote: Every specified structure must contain one and only one Section element (its root element)."
		   });	
		addAnnotation
		  (getSection__ValidateContainerMatchesExtendContainer__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if(this.getContainer() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().allMatch(\r\n\t\te -> e.getContainer() == null || e.getContainer() == this.getContainer());\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"The section extends a section that specifies a different container!\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new BasicDiagnostic\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__EXTEND }));\r\n\t}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getSection__ValidateExtendsValidSections__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(this.getEClass() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getExtend().parallelStream().noneMatch(e -> !e.isAbstract() || e.getEClass() != null\r\n\t\t&& this.getEClass() != e.getEClass() && !this.getEClass().getEAllSuperTypes().contains(e.getEClass()));\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The Section extends a Section that is either not abstract or that references an EClass of a different (super-)type!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.SECTION__VALIDATE_EXTENDS_VALID_SECTIONS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__EXTEND }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getSection__ValidateNotExtendSelf__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "boolean result = !this.getAllExtend().contains(this);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Section must not extend itself (neither directly nor indirectly)!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, \r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\tGenericValidator.SECTION__VALIDATE_NOT_EXTEND_SELF, \r\n\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__EXTEND }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getSection_Abstract(), 
		   source, 
		   new String[] {
			 "documentation", "If set to \'true\', this Section can be extended by other specified Sections (via the \'extend\' reference) which will then recursively inherit the structure specified by this Section (all contained Attributes, References and Classes).\r\n<br /><br />\r\nNote: Abstract Sections will not be (directly) matched against a source model. Consequently, Mappings based on abstract Sections will never be executed. Such mappings can however be used to specifiy abstract MappingHintGroups which can be extended by concrete MappingHintGroups that are based on a concrete Sub-Section of this abstract Section."
		   });	
		addAnnotation
		  (getSection_Extend(), 
		   source, 
		   new String[] {
			 "documentation", "The list of (abstract) Sections that this Section extends.\r\n<br /><br />\r\nThis Section will recursively inherit the structure specified by all extended Sections (all contained Attributes, References and Classes).",
			 "propertyDescriptor", "itemPropertyDescriptors.add\r\n\t(new <%org.eclipse.emf.edit.provider.ItemPropertyDescriptor%>\r\n\t\t(((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>)adapterFactory).getRootAdapterFactory(),\r\n\t\t getResourceLocator(),\r\n\t\t getString(\"_UI_Section_extend_feature\"),\r\n\t\t getString(\"_UI_Section_extend_description\"),\r\n\t\t <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__EXTEND,\r\n\t\t true,\r\n\t\t false,\r\n\t\t true,\r\n\t\t null,\r\n\t\t getString(\"_UI_ExtendedPropertyCategory\"),\r\n\t\t null) {\r\n\t\t\r\n\t\t@Override\r\n\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\t\t\r\n\t\t\treturn super.getChoiceOfValues(object).stream().filter(e -> !e.equals(object) && !((<%pamtram.structure.generic.Section%><?, ?, ?, ?>) e).getAllExtend().contains(object)).collect(<%java.util.stream.Collectors%>.toList());\r\n\t\t}\r\n\t});"
		   });	
		addAnnotation
		  (getSection_AllExtend(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.Set%><Object> ret = new <%java.util.LinkedHashSet%><>();\r\n\r\n<%java.util.List%><Section<?, ?, ?, ?>> toCheck = new <%java.util.ArrayList%><>();\r\ntoCheck.add(this);\r\n\r\nwhile (!toCheck.isEmpty()) {\r\n\tSection<?, ?, ?, ?> next = toCheck.remove(0);\r\n\r\n\tList<Section<?, ?, ?, ?>> localToCheck = next.getExtend().stream().filter(e -> !ret.contains(e))\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n\tret.addAll(localToCheck);\r\n\ttoCheck.addAll(localToCheck);\r\n}\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__ALL_EXTEND, ret.size(),\r\n\t\tret.toArray());"
		   });	
		addAnnotation
		  (getSection_AllExtend(), 
		   source, 
		   new String[] {
			 "documentation", "The list of recursively collected (abstract) extended Sections."
		   });	
		addAnnotation
		  (getSection_AllExtending(), 
		   source, 
		   new String[] {
			 "get", "\r\n<%java.util.Set%><Object> extendingSections = new <%java.util.LinkedHashSet%><>();\r\n<%java.util.Iterator%><<%org.eclipse.emf.common.notify.Notifier%>> it = this.eResource().getResourceSet().getAllContents();\r\nwhile (it.hasNext()) {\r\n\tNotifier next = it.next();\r\n\tif (next instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?> && ((Section<?, ?, ?, ?>) next).getAllExtend().contains(this)) {\r\n\t\textendingSections.add(next);\r\n\t}\r\n}\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.structure.generic.GenericPackage%>.Literals.SECTION__ALL_EXTENDING,\r\n\t\textendingSections.size(), extendingSections.toArray());"
		   });	
		addAnnotation
		  (getSection_AllExtending(), 
		   source, 
		   new String[] {
			 "documentation", "The list of recursively collected Sections extending this Section."
		   });	
		addAnnotation
		  (referenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference of an element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getReference__IsExtended(), 
		   source, 
		   new String[] {
			 "body", "\r\n// We consider a reference as \'extended\' if:\r\n// 1. the reference is directly contained in an abstract <%pamtram.structure.generic.Section%>,\r\n// 2. the reference is an <%pamtram.structure.generic.ActualReference%> (i.e. it represents a metamodel reference), and\r\n// 3. there is another reference further downward in the extension hierarchy that represents the same metamodel\r\n// reference\r\n//\r\nif (!(this instanceof ActualReference<?, ?, ?, ?> && this.getOwningClass() instanceof Section<?, ?, ?, ?>\r\n\t\t&& ((Section<?, ?, ?, ?>) this.getOwningClass()).isAbstract())) {\r\n\treturn false;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EReference%> eReference = ((ActualReference<?, ?, ?, ?>) this).getEReference();\r\n\r\nif (eReference == null) {\r\n\treturn false;\r\n}\r\n\r\nreturn ((Section<?, ?, ?, ?>) this.getOwningClass()).getAllExtending().stream()\r\n\t\t.flatMap(s -> s.getActualReferences().stream()).anyMatch(r -> r.eClass().equals(this.eClass())\r\n\t\t\t\t&& eReference.equals(((ActualReference<?, ?, ?, ?>) r).getEReference()));"
		   });	
		addAnnotation
		  (getReference__GetValuesIncludingExtended(), 
		   source, 
		   new String[] {
			 "body", "\r\n<%org.eclipse.emf.common.util.EList%><C> values = new <%org.eclipse.emf.common.util.BasicEList%><>(this.getValuesGeneric());\r\n\r\n// Only ActualReferences directly contained in Sections can extend other references\r\n//\r\nif (this.getOwningClass() instanceof <%pamtram.structure.generic.Section%><?, ?, ?, ?> && this instanceof <%pamtram.structure.generic.ActualReference%><?, ?, ?, ?>\r\n\t\t&& ((ActualReference<?, ?, ?, ?>) this).getEReference() != null) {\r\n\r\n\t<%org.eclipse.emf.ecore.EReference%> eReference = ((ActualReference<?, ?, ?, ?>) this).getEReference();\r\n\r\n\t<%java.util.List%><<%pamtram.structure.generic.Reference%><?, ?, ?, ?>> extendedReferences = ((Section<?, ?, ?, ?>) this.getOwningClass())\r\n\t\t\t.getAllExtend().stream().flatMap(s -> s.getActualReferences().stream())\r\n\t\t\t.filter(r -> eReference.equals(((ActualReference<?, ?, ?, ?>) r).getEReference()))\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n\r\n\tvalues.addAll((<%java.util.Collection%><? extends C>) extendedReferences.stream()\r\n\t\t\t.flatMap(r -> r.getValuesGeneric().stream()).collect(Collectors.toList()));\r\n}\r\n\r\nreturn values;"
		   });	
		addAnnotation
		  (getReference_OwningClass(), 
		   source, 
		   new String[] {
			 "documentation", "The Class containing this Reference."
		   });	
		addAnnotation
		  (actualReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference (as an instance of an EReference) of an element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getActualReference__ValidateEReferenceMatchesParentEClass__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (isLibraryEntry() || this.getEReference() == null\r\n\t\t|| !(eContainer() instanceof pamtram.structure.generic.Class)) {\r\n\treturn true;\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EClass%> parentEClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true\r\n\t\t: pamtram.util.XSDAnyContentUtil.getEAllReferencesIncludingVirtualAnyContentReference(parentEClass)\r\n\t\t\t\t.contains(this.getEReference());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + this.getEReference().getName()\r\n\t\t\t+ \"\' is not allowed by the containing Class!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.ACTUAL_REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS, errorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getActualReference_EReference(), 
		   source, 
		   new String[] {
			 "documentation", "The metamodel element (EReference) that this Reference represents.",
			 "propertyDescriptor", "\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_Reference_eReference_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_ActualReference_eReference_description\"),\r\n\t\t\t\t<%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_REFERENCE__EREFERENCE, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t// make sure that only those references can be selected\r\n\t\t\t\t// that belong to the parent eClass\r\n\t\t\t\tpamtram.structure.generic.Class<?, ?, ?, ?> parent = ((<%pamtram.structure.generic.impl.ReferenceImpl%><?, ?, ?, ?>) object)\r\n\t\t\t\t\t\t.getOwningClass();\r\n\r\n\t\t\t\t// do not filter the choices further so that containment\r\n\t\t\t\t// as well as non-containment references are displayed\r\n\t\t\t\treturn pamtram.util.XSDAnyContentUtil\r\n\t\t\t\t\t\t.getEAllReferencesIncludingVirtualAnyContentReference(parent.getEClass()).stream()\r\n\t\t\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n\r\n\t\t\t}\r\n\t\t});"
		   });	
		addAnnotation
		  (virtualReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference of an element structure. In contrast to \'actual\' References, \'virtual\' Reference do not represent an actual metamodel element (EReference) but can be used to create additional (virtual) references.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference. As the Reference is not based on an actual EReference, the actual instances of the specified target Classes need to be specified by the modeler by means of additional language elements (dependent on the concrete sub-type)."
		   });	
		addAnnotation
		  (compositeReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference of an element structure. CompositeReferences can be used to describe the tree that is the basis of an element structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getCompositeReference__ValidateEReferenceIsContainment__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\n<%org.eclipse.emf.ecore.EReference%> reference = this instanceof <%pamtram.structure.generic.ActualReference%> ? ((ActualReference<?, ?, ?, ?>) this).getEReference() : null;\r\n\r\nboolean result = reference == null || reference.isContainment();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eReference \'\" + reference.getName() + \"\' is no containment reference!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.COMPOSITE_REFERENCE__VALIDATE_EREFERENCE_IS_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_REFERENCE__EREFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCompositeReference_Value(), 
		   source, 
		   new String[] {
			 "documentation", "The list of elements (Classes) further describing the element structure."
		   });	
		addAnnotation
		  (crossReferenceEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a reference of an element structure. CrossReferences can be used to describe references to other element structures or to other elements of this structure.\r\n<br />\r\nIn order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the \'value\' reference."
		   });	
		addAnnotation
		  (getCrossReference__ValidateValuesMatchReferenceType__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\n<%org.eclipse.emf.ecore.EReference%> reference = this instanceof <%pamtram.structure.generic.ActualReference%> ? ((ActualReference<?, ?, ?, ?>) this).getEReference() : null;\r\n\r\nboolean result = reference == null ? true : this.getValue().parallelStream().allMatch(c -> reference.getEReferenceType().isSuperTypeOf(c.getEClass()));\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = this.getValue().parallelStream()\r\n\t\t.filter(c -> !reference.getEReferenceType().isSuperTypeOf(c.getEClass())).count()\r\n\t\t+ \" of the selected target Classes (Value) are not allowed by the selected eReference \'\"\r\n\t\t+ reference.getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.CROSS_REFERENCE__VALIDATE_VALUES_MATCH_REFERENCE_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.CROSS_REFERENCE__VALUE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCrossReference_Value(), 
		   source, 
		   new String[] {
			 "documentation", "The list of elements (Classes) further describing the element structure."
		   });	
		addAnnotation
		  (attributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute of an element structure."
		   });	
		addAnnotation
		  (getAttribute_OwningClass(), 
		   source, 
		   new String[] {
			 "documentation", "The Class containing this Attribute."
		   });	
		addAnnotation
		  (actualAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute (as an instance of an EAttribute) of an element structure."
		   });	
		addAnnotation
		  (getActualAttribute__ValidateAttributeMatchesParentEClass__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(this.isLibraryEntry() || this.getAttribute() == null || !(this.eContainer() instanceof <%pamtram.structure.generic.Class%><?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\nEClass parentEClass = ((<%pamtram.structure.generic.Class%><?, ?, ?, ?>) this.eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true : parentEClass.getEAllAttributes().contains(this.getAttribute());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eAttribute \'\" + this.getAttribute().getName() + \"\' is not allowed by the containing Class!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.structure.generic.util.GenericValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.ACTUAL_ATTRIBUTE__VALIDATE_ATTRIBUTE_MATCHES_PARENT_ECLASS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getActualAttribute_Attribute(), 
		   source, 
		   new String[] {
			 "documentation", "The metamodel element (EAttribute) that this Attribute represents.",
			 "propertyDescriptor", "\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_ActualAttribute_attribute_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_ActualAttribute_attribute_description\"),\r\n\t\t\t\t<%pamtram.structure.generic.GenericPackage%>.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t<%pamtram.structure.generic.ActualAttribute%><?, ?, ?, ?> att = (ActualAttribute<?, ?, ?, ?>) object;\r\n\r\n\t\t\t\t<%java.util.List%><<%org.eclipse.emf.ecore.EAttribute%>> attributes = new <%java.util.ArrayList%><>();\r\n\r\n\t\t\t\t// in case of a \'normal\' TargetSectionClass, the\r\n\t\t\t\t// attribute of this class can be chosen\r\n\t\t\t\tif (att.getOwningClass() != null) {\r\n\t\t\t\t\tattributes.addAll(att.getOwningClass().getEClass().getEAllAttributes());\r\n\t\t\t\t\t// in case of an <%pamtram.structure.library.AttributeParameter%>, the attribute\r\n\t\t\t\t\t// of its source can be chosen\r\n\t\t\t\t} else if (att.eContainer() instanceof AttributeParameter\r\n\t\t\t\t\t\t&& ((AttributeParameter) att.eContainer()).getSource() != null) {\r\n\t\t\t\t\tattributes.addAll(\r\n\t\t\t\t\t\t\t((AttributeParameter) att.eContainer()).getSource().eClass().getEAllAttributes());\r\n\t\t\t\t}\r\n\r\n\t\t\t\t// Do not allow \'xs:any\'-content attributes\r\n\t\t\t\t//\r\n\t\t\t\treturn attributes.stream()\r\n\t\t\t\t\t\t.filter(a -> !de.tud.et.ifa.agtele.emf.XSDAnyContentUtil\r\n\t\t\t\t\t\t\t\t.isAnyContentFeature(att.getOwningClass().getEClass(), a))\r\n\t\t\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n\t\t\t}\r\n\t\t});"
		   });	
		addAnnotation
		  (virtualAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents an attribute of an element structure. In contrast to \'actual\' Attributes, \'virtual\' Attributes do not represent an actual metamodel element (EAttribtue) but can be used to create additional (virtual) attributes.\r\n<br />\r\n As the Attribute is not based on an actual EAttribute, the actual values held by this Attribute need to be specified manually by means of additional language elements (dependent on the concrete sub-type)."
		   });	
		addAnnotation
		  (cardinalityTypeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "The type of cardinality constraint for an element."
		   });	
		addAnnotation
		  (cardinalityTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Exactly one element must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections)."
		   });	
		addAnnotation
		  (cardinalityTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "At least one element must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections).\r\n<br /><br />\r\nFor elements of TargetSections, the concrete number to be created should be specified by additional MappingHints (CardinalityMappings or AttributeMappings)."
		   });	
		addAnnotation
		  (cardinalityTypeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Zero or any number of elements must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections).\r\n<br /><br />\r\nFor elements of TargetSections, the concrete number to be created should be specified by additional MappingHints (CardinalityMappings or AttributeMappings)."
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
		  (compositeReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "eReferenceIsContainment"
		   });	
		addAnnotation
		  (crossReferenceEClass, 
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
