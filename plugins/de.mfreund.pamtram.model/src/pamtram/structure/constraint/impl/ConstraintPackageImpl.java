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
package pamtram.structure.constraint.impl;

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
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.ConstraintFactory;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.NumericConstraint;
import pamtram.structure.constraint.NumericConstraintOperatorType;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.StringConstraint;
import pamtram.structure.constraint.StringConstraintOperatorType;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.constraint.ValueConstraintGlobalSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceInterface;
import pamtram.structure.constraint.ValueConstraintType;

import pamtram.structure.constraint.util.ConstraintValidator;

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
public class ConstraintPackageImpl extends EPackageImpl implements ConstraintPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalityConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleReferenceValueConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintExternalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueConstraintGlobalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum valueConstraintTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum numericConstraintOperatorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stringConstraintOperatorTypeEEnum = null;

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
	 * @see pamtram.structure.constraint.ConstraintPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConstraintPackageImpl() {
		super(eNS_URI, ConstraintFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConstraintPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConstraintPackage init() {
		if (isInited) return (ConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI);

		// Obtain or create and register package
		ConstraintPackageImpl theConstraintPackage = (ConstraintPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConstraintPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConstraintPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenLibraryPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) : StructurePackage.eINSTANCE);
		GenericPackageImpl theGenericPackage = (GenericPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) instanceof GenericPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI) : GenericPackage.eINSTANCE);
		SourcePackageImpl theSourcePackage = (SourcePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) instanceof SourcePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI) : SourcePackage.eINSTANCE);
		TargetPackageImpl theTargetPackage = (TargetPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) instanceof TargetPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI) : TargetPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		theConstraintPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		theConstraintPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		theExtendedPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theConstraintPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ConstraintValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theConstraintPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConstraintPackage.eNS_URI, theConstraintPackage);
		return theConstraintPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraint() {
		return valueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueConstraint_Type() {
		return (EAttribute)valueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getValueConstraint__IsLocalConstraint() {
		return valueConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringConstraint() {
		return stringConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringConstraint_OperatorType() {
		return (EAttribute)stringConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringConstraint_CaseSensitive() {
		return (EAttribute)stringConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualityConstraint() {
		return equalityConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceConstraint() {
		return choiceConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoiceConstraint_Choices() {
		return (EReference)choiceConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getChoiceConstraint__CheckConstraint__String_EList() {
		return choiceConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericConstraint() {
		return numericConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNumericConstraint_OperatorType() {
		return (EAttribute)numericConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleReferenceValueConstraint() {
		return singleReferenceValueConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceValueConstraint_SourceElements() {
		return (EReference)singleReferenceValueConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceValueConstraint_InstanceSelectors() {
		return (EReference)singleReferenceValueConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__CheckConstraint__String_String() {
		return singleReferenceValueConstraintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map() {
		return singleReferenceValueConstraintEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSingleReferenceValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map() {
		return singleReferenceValueConstraintEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraintSourceInterface() {
		return valueConstraintSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraintSourceElement() {
		return valueConstraintSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraintExternalSourceElement() {
		return valueConstraintExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueConstraintGlobalSourceElement() {
		return valueConstraintGlobalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValueConstraintType() {
		return valueConstraintTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNumericConstraintOperatorType() {
		return numericConstraintOperatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStringConstraintOperatorType() {
		return stringConstraintOperatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintFactory getConstraintFactory() {
		return (ConstraintFactory)getEFactoryInstance();
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
		valueConstraintEClass = createEClass(VALUE_CONSTRAINT);
		createEAttribute(valueConstraintEClass, VALUE_CONSTRAINT__TYPE);
		createEOperation(valueConstraintEClass, VALUE_CONSTRAINT___IS_LOCAL_CONSTRAINT);

		singleReferenceValueConstraintEClass = createEClass(SINGLE_REFERENCE_VALUE_CONSTRAINT);
		createEReference(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
		createEReference(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT__INSTANCE_SELECTORS);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___CHECK_CONSTRAINT__STRING_STRING);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS__DIAGNOSTICCHAIN_MAP);
		createEOperation(singleReferenceValueConstraintEClass, SINGLE_REFERENCE_VALUE_CONSTRAINT___VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP);

		equalityConstraintEClass = createEClass(EQUALITY_CONSTRAINT);

		choiceConstraintEClass = createEClass(CHOICE_CONSTRAINT);
		createEReference(choiceConstraintEClass, CHOICE_CONSTRAINT__CHOICES);
		createEOperation(choiceConstraintEClass, CHOICE_CONSTRAINT___CHECK_CONSTRAINT__STRING_ELIST);

		numericConstraintEClass = createEClass(NUMERIC_CONSTRAINT);
		createEAttribute(numericConstraintEClass, NUMERIC_CONSTRAINT__OPERATOR_TYPE);

		stringConstraintEClass = createEClass(STRING_CONSTRAINT);
		createEAttribute(stringConstraintEClass, STRING_CONSTRAINT__OPERATOR_TYPE);
		createEAttribute(stringConstraintEClass, STRING_CONSTRAINT__CASE_SENSITIVE);

		valueConstraintSourceInterfaceEClass = createEClass(VALUE_CONSTRAINT_SOURCE_INTERFACE);

		valueConstraintSourceElementEClass = createEClass(VALUE_CONSTRAINT_SOURCE_ELEMENT);

		valueConstraintExternalSourceElementEClass = createEClass(VALUE_CONSTRAINT_EXTERNAL_SOURCE_ELEMENT);

		valueConstraintGlobalSourceElementEClass = createEClass(VALUE_CONSTRAINT_GLOBAL_SOURCE_ELEMENT);

		// Create enums
		valueConstraintTypeEEnum = createEEnum(VALUE_CONSTRAINT_TYPE);
		numericConstraintOperatorTypeEEnum = createEEnum(NUMERIC_CONSTRAINT_OPERATOR_TYPE);
		stringConstraintOperatorTypeEEnum = createEEnum(STRING_CONSTRAINT_OPERATOR_TYPE);
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
		StructurePackage theStructurePackage = (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);
		ExtendedPackage theExtendedPackage = (ExtendedPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI);
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		valueConstraintEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		singleReferenceValueConstraintEClass.getESuperTypes().add(this.getValueConstraint());
		singleReferenceValueConstraintEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		singleReferenceValueConstraintEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		equalityConstraintEClass.getESuperTypes().add(this.getSingleReferenceValueConstraint());
		choiceConstraintEClass.getESuperTypes().add(this.getValueConstraint());
		numericConstraintEClass.getESuperTypes().add(this.getSingleReferenceValueConstraint());
		stringConstraintEClass.getESuperTypes().add(this.getSingleReferenceValueConstraint());
		valueConstraintSourceInterfaceEClass.getESuperTypes().add(theExtendedPackage.getMappingHintSourceInterface());
		EGenericType g1 = createEGenericType(theStructurePackage.getLocalDynamicSourceElement());
		EGenericType g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		valueConstraintSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValueConstraintSourceInterface());
		valueConstraintSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		valueConstraintExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValueConstraintSourceInterface());
		valueConstraintExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		valueConstraintGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getValueConstraintSourceInterface());
		valueConstraintGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(valueConstraintEClass, ValueConstraint.class, "ValueConstraint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValueConstraint_Type(), this.getValueConstraintType(), "type", "REQUIRED", 1, 1, ValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getValueConstraint__IsLocalConstraint(), ecorePackage.getEBoolean(), "isLocalConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(singleReferenceValueConstraintEClass, SingleReferenceValueConstraint.class, "SingleReferenceValueConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleReferenceValueConstraint_SourceElements(), this.getValueConstraintSourceInterface(), null, "sourceElements", null, 0, -1, SingleReferenceValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferenceValueConstraint_InstanceSelectors(), theStructurePackage.getSourceInstanceSelector(), null, "instanceSelectors", null, 0, -1, SingleReferenceValueConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSingleReferenceValueConstraint__CheckConstraint__String_String(), ecorePackage.getEBoolean(), "checkConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attrValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "refValue", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSingleReferenceValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesInSourceSections", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSingleReferenceValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlyFixedValuesOrGlobalAttributesInConditionModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(equalityConstraintEClass, EqualityConstraint.class, "EqualityConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(choiceConstraintEClass, ChoiceConstraint.class, "ChoiceConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoiceConstraint_Choices(), this.getEqualityConstraint(), null, "choices", null, 2, -1, ChoiceConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getChoiceConstraint__CheckConstraint__String_EList(), ecorePackage.getEBoolean(), "checkConstraint", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "attrValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "refValue", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(numericConstraintEClass, NumericConstraint.class, "NumericConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNumericConstraint_OperatorType(), this.getNumericConstraintOperatorType(), "operatorType", null, 1, 1, NumericConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringConstraintEClass, StringConstraint.class, "StringConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringConstraint_OperatorType(), this.getStringConstraintOperatorType(), "operatorType", null, 1, 1, StringConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringConstraint_CaseSensitive(), ecorePackage.getEBoolean(), "caseSensitive", "true", 1, 1, StringConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueConstraintSourceInterfaceEClass, ValueConstraintSourceInterface.class, "ValueConstraintSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstraintSourceElementEClass, ValueConstraintSourceElement.class, "ValueConstraintSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstraintExternalSourceElementEClass, ValueConstraintExternalSourceElement.class, "ValueConstraintExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueConstraintGlobalSourceElementEClass, ValueConstraintGlobalSourceElement.class, "ValueConstraintGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(valueConstraintTypeEEnum, ValueConstraintType.class, "ValueConstraintType");
		addEEnumLiteral(valueConstraintTypeEEnum, ValueConstraintType.REQUIRED);
		addEEnumLiteral(valueConstraintTypeEEnum, ValueConstraintType.FORBIDDEN);

		initEEnum(numericConstraintOperatorTypeEEnum, NumericConstraintOperatorType.class, "NumericConstraintOperatorType");
		addEEnumLiteral(numericConstraintOperatorTypeEEnum, NumericConstraintOperatorType.EQUAL);
		addEEnumLiteral(numericConstraintOperatorTypeEEnum, NumericConstraintOperatorType.GREATER);
		addEEnumLiteral(numericConstraintOperatorTypeEEnum, NumericConstraintOperatorType.GREATER_OR_EQUAL);
		addEEnumLiteral(numericConstraintOperatorTypeEEnum, NumericConstraintOperatorType.LESS);
		addEEnumLiteral(numericConstraintOperatorTypeEEnum, NumericConstraintOperatorType.LESS_OR_EQUAL);

		initEEnum(stringConstraintOperatorTypeEEnum, StringConstraintOperatorType.class, "StringConstraintOperatorType");
		addEEnumLiteral(stringConstraintOperatorTypeEEnum, StringConstraintOperatorType.MATCH_EQUAL);
		addEEnumLiteral(stringConstraintOperatorTypeEEnum, StringConstraintOperatorType.MATCH_BEGINNING);
		addEEnumLiteral(stringConstraintOperatorTypeEEnum, StringConstraintOperatorType.MATCH_ENDING);
		addEEnumLiteral(stringConstraintOperatorTypeEEnum, StringConstraintOperatorType.MATCH_SUBSTRING);
		addEEnumLiteral(stringConstraintOperatorTypeEEnum, StringConstraintOperatorType.MATCH_REGEX);

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
			 "documentation", "This package contains all elements related to the description of ValueConstraints that may e.g. be used to describe a restriction/claim of specific values of an attribute in a SourceSection."
		   });	
		addAnnotation
		  (valueConstraintEClass, 
		   source, 
		   new String[] {
			 "documentation", "The super type for all specific types that can be used to describe constraints for attribute values.\r\n<br /><br />\r\nValueConstraints thereby specify a single reference value or list/range of reference values which the actual attribute value must or must not satisfy."
		   });	
		addAnnotation
		  (getValueConstraint__IsLocalConstraint(), 
		   source, 
		   new String[] {
			 "body", "if (this instanceof <%pamtram.structure.constraint.ChoiceConstraint%>) {\r\n\treturn ((ChoiceConstraint) this).getChoices().stream().allMatch(<%pamtram.structure.constraint.ValueConstraint%>::isLocalConstraint);\r\n}\r\n\r\nif (<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.structure.source.SourcePackage%>.Literals.ACTUAL_SOURCE_SECTION_ATTRIBUTE)) {\r\n\treturn true;\r\n}\r\n\r\nif (!(this instanceof <%pamtram.structure.constraint.SingleReferenceValueConstraint%>)\r\n\t\t|| !AgteleEcoreUtil.hasAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.Literals.ATTRIBUTE_CONDITION)) {\r\n\tthrow new UnsupportedOperationException();\r\n}\r\n\r\n<%org.eclipse.emf.ecore.EObject%> container = this;\r\n\r\nwhile (!(container instanceof <%pamtram.mapping.Mapping%>)) {\r\n\tif (container == null) {\r\n\t\treturn false;\r\n\t}\r\n\tcontainer = container.eContainer();\r\n}\r\n\r\n// The SourceSection of the Mapping that contains the constraint\r\n//\r\nSourceSection localSection = ((Mapping) container).getSourceSection();\r\n\r\nif (((SingleReferenceValueConstraint) this).getSourceElements().parallelStream()\r\n\t\t.allMatch(s -> s instanceof <%pamtram.FixedValue%> || s instanceof <%pamtram.mapping.extended.GlobalAttributeImporter%>\r\n\t\t\t\t|| s instanceof <%pamtram.structure.constraint.ValueConstraintSourceElement%> && ((ValueConstraintSourceElement) s).getSource()\r\n\t\t\t\t\t\t.getContainingSection().equals(localSection)\r\n\t\t\t\t|| s instanceof <%pamtram.structure.constraint.ValueConstraintExternalSourceElement%>\r\n\t\t\t\t\t\t&& ((ValueConstraintExternalSourceElement) s).getSource().getContainingSection()\r\n\t\t\t\t\t\t\t\t.isContainerFor(localSection))) {\r\n\treturn true;\r\n}\r\n\r\n// A constraint is also \'local\' if an InstancePointer with local or external SourceAttributes exist\r\n//\r\nreturn ((SingleReferenceValueConstraint) this).getInstanceSelectors()\r\n\t\t.parallelStream()\r\n\t\t.flatMap(instanceSelector -> instanceSelector.getSourceElements().parallelStream()\r\n\t\t\t\t.filter(s -> s instanceof <%pamtram.structure.InstanceSelectorSourceElement%>\r\n\t\t\t\t\t\t|| s instanceof <%pamtram.structure.InstanceSelectorExternalSourceElement%>))\r\n\t\t.findAny().isPresent();"
		   });	
		addAnnotation
		  (getValueConstraint_Type(), 
		   source, 
		   new String[] {
			 "documentation", "The type of this constraint (either REQUIRED or FORBIDDEN)."
		   });	
		addAnnotation
		  (valueConstraintTypeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "The type of value constraint (either REQUIRED or FORBIDDEN)."
		   });	
		addAnnotation
		  (valueConstraintTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value MUST satisfy the value(s) specified by this constraint."
		   });	
		addAnnotation
		  (valueConstraintTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value MUST NOT satisfy the value(s) specified by this constraint."
		   });	
		addAnnotation
		  (singleReferenceValueConstraintEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ValueConstraint for which the reference value is calculated based on the combination of a list of \'sourceElements\'."
		   });	
		addAnnotation
		  (getSingleReferenceValueConstraint__ValidateOnlyFixedValuesInSourceSections__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if(this.getSourceElements().isEmpty() || \r\n\t\t!<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.structure.source.SourcePackage%>.eINSTANCE.getActualSourceSectionAttribute())) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof <%pamtram.FixedValue%>);\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues as source elements as it is modeled as part of a SourceSection!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.structure.constraint.util.ConstraintValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  <%pamtram.structure.constraint.ConstraintPackage%>.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getSingleReferenceValueConstraint__ValidateOnlyFixedValuesOrGlobalAttributesInConditionModel__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if(this.getSourceElements().isEmpty() || \r\n\t\t!<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.eINSTANCE.getComplexCondition())) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.condition.ComplexCondition%> condition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.eINSTANCE.getComplexCondition());\r\n\r\nif(!condition.isConditionModelCondition()) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof <%pamtram.FixedValue%> || s instanceof <%pamtram.mapping.extended.GlobalAttributeImporter%>);\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues or GlobalAttributeImporters as source elements as it is modeled as part of a condition inside a ConditionModel!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.structure.constraint.util.ConstraintValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t ConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  <%pamtram.structure.constraint.ConstraintPackage%>.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getSingleReferenceValueConstraint_SourceElements(), 
		   source, 
		   new String[] {
			 "documentation", "The list of \'sourceElements\' based on which the reference value for this constraint is calculated."
		   });	
		addAnnotation
		  (getSingleReferenceValueConstraint_InstanceSelectors(), 
		   source, 
		   new String[] {
			 "documentation", "A list of InstanceSelectors that can be used to restrict the application of this constraint: \r\n<br />\r\nOnly Attributes (resp. their values) identified by the list of InstanceSelectors are checked against this constraint."
		   });	
		addAnnotation
		  (equalityConstraintEClass, 
		   source, 
		   new String[] {
			 "documentation", "This ValueConstraint type checks if the determined attribute value is equal to the calculated reference value."
		   });	
		addAnnotation
		  (choiceConstraintEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ValueConstraint that specifies a list of values (each by means of an EqualityConstraint). For this constraint to be fulfilled, the actual attribute value must match at least one of the specified values."
		   });	
		addAnnotation
		  (getChoiceConstraint__CheckConstraint__String_EList(), 
		   source, 
		   new String[] {
			 "body", "return refValue.stream().anyMatch(r -> r.equals(attrValue));"
		   });	
		addAnnotation
		  (numericConstraintEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ValueConstraint type that can be used for numeric attribute values. It (numerically) compares the determined attribute value to the calculated reference value.\r\n"
		   });	
		addAnnotation
		  (getNumericConstraint_OperatorType(), 
		   source, 
		   new String[] {
			 "documentation", "The comparison type used to (numerically) compare the actual attribute value to the determined reference value."
		   });	
		addAnnotation
		  (numericConstraintOperatorTypeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "The type of numerical comparison to be performed."
		   });	
		addAnnotation
		  (numericConstraintOperatorTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must be equal to the determined reference value."
		   });	
		addAnnotation
		  (numericConstraintOperatorTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must be greater then the determined reference value."
		   });	
		addAnnotation
		  (numericConstraintOperatorTypeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must be greater then or equal to the determined reference value."
		   });	
		addAnnotation
		  (numericConstraintOperatorTypeEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must be less then the determined reference value."
		   });	
		addAnnotation
		  (numericConstraintOperatorTypeEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must be less then or equal to the determined reference value."
		   });	
		addAnnotation
		  (stringConstraintEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ValueConstraint type that can be used for literal attribute values. It compares the determined attribute value to the calculated reference value based on a String comparison.\r\n"
		   });	
		addAnnotation
		  (getStringConstraint_OperatorType(), 
		   source, 
		   new String[] {
			 "documentation", "The comparison type used to compare the actual attribute value to the determined reference value."
		   });	
		addAnnotation
		  (getStringConstraint_CaseSensitive(), 
		   source, 
		   new String[] {
			 "documentation", "Whether the String comparison shall be performed case-sensitive (true) or case-insensitive (false)."
		   });	
		addAnnotation
		  (stringConstraintOperatorTypeEEnum, 
		   source, 
		   new String[] {
			 "documentation", "The type of String-based comparison to be performed."
		   });	
		addAnnotation
		  (stringConstraintOperatorTypeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must be equal to the determined reference value."
		   });	
		addAnnotation
		  (stringConstraintOperatorTypeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must begin with the determined reference value."
		   });	
		addAnnotation
		  (stringConstraintOperatorTypeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must end with the determined reference value."
		   });	
		addAnnotation
		  (stringConstraintOperatorTypeEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must contain the determined reference value."
		   });	
		addAnnotation
		  (stringConstraintOperatorTypeEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "The actual attribute value must satisfy the regular expression specified by the determined reference value."
		   });	
		addAnnotation
		  (valueConstraintSourceInterfaceEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common superclass of all types that can be used as \'sourceElement\' to calculate the reference value of a ValueConstraint."
		   });	
		addAnnotation
		  (valueConstraintSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' to calculate the reference value of a ValueConstraint.<br />\r\nThis type is based on the value of a \'local\' attribute.\r\n<br /><br />\r\nNote: See the documentation of \'LocalDynamicSourceElement\' for a detailed explanation of the meaning of \'local\' source elements."
		   });	
		addAnnotation
		  (valueConstraintExternalSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' to calculate the reference value of a ValueConstraint.<br />\r\nThis type is based on the value of an \'external\' attribute.\r\n<br /><br />\r\nNote: See the documentation of \'ExternalDynamicSourceElement\' for a detailed explanation of the meaning of \'external\' source elements."
		   });	
		addAnnotation
		  (valueConstraintGlobalSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' to calculate the reference value of a ValueConstraint.<br />\r\nThis type is based on the value of a \'global\' attribute.\r\n<br /><br />\r\nNote: See the documentation of \'GlobalDynamicSourceElement\' for a detailed explanation of the meaning of \'global\' source elements."
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
		  (singleReferenceValueConstraintEClass, 
		   source, 
		   new String[] {
			 "constraints", "onlyFixedValuesInSourceSections onlyFixedValuesOrGlobalAttributesInConditionModel"
		   });
	}

} //ConstraintPackageImpl
