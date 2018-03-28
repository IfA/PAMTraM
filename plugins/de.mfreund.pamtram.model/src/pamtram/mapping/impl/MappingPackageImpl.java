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
package pamtram.mapping.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import org.eclipse.emf.ecore.EAttribute;
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
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.impl.ExtendedPackageImpl;
import pamtram.mapping.modifier.ModifierPackage;
import pamtram.mapping.modifier.impl.ModifierPackageImpl;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;
import pamtram.mapping.util.MappingValidator;
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
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingHintGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingHintGroupTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantiableMappingHintGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingHintGroupImporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exportedMappingHintGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalAttributeEClass = null;

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
	 * @see pamtram.mapping.MappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MappingPackageImpl() {
		super(eNS_URI, MappingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MappingPackage init() {
		if (isInited) return (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Obtain or create and register package
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MappingPackageImpl());

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
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI) : ExtendedPackage.eINSTANCE);

		// Create package meta-data objects
		theMappingPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theModifierPackage.createPackageContents();
		theExtendedPackage.createPackageContents();

		// Initialize created meta-data
		theMappingPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();
		theExtendedPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMappingPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MappingValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMappingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
		return theMappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_MappingHintGroups() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_ImportedMappingHintGroups() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_Abstract() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__GetActiveMappingHintGroups() {
		return mappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__GetActiveImportedMappingHintGroups() {
		return mappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__ValidateContainsHintGroups__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__ValidateContainsDeactivatedHintGroups__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__ValidateSourceSectionIsActive__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__ValidateSourceSectionIsNotAbstract__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingType() {
		return mappingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingType_SourceSection() {
		return (EReference)mappingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingHintGroup() {
		return mappingHintGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingHintGroupType() {
		return mappingHintGroupTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_TargetSection() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_MappingHints() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_Extend() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_AttributeMappings() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_CardinalityMappings() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_ReferenceTargetSelectors() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_ContainerSelectors() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_AllMappingHints() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_AllExtend() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_AllExtending() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_ParentMapping() {
		return (EReference)mappingHintGroupTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHintGroupType__ValidateExtendsOnlyValidHintGroups__DiagnosticChain_Map() {
		return mappingHintGroupTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHintGroupType__GetActiveMappingHints() {
		return mappingHintGroupTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHintGroupType__ValidateDoNotUseLibraryElementsWithoutLibraryNature__DiagnosticChain_Map() {
		return mappingHintGroupTypeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHintGroupType__ValidateTargetSectionIsNotAbstract__DiagnosticChain_Map() {
		return mappingHintGroupTypeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHintGroupType__ValidateNotExtendSelf__DiagnosticChain_Map() {
		return mappingHintGroupTypeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantiableMappingHintGroup() {
		return instantiableMappingHintGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingHintGroupImporter() {
		return mappingHintGroupImporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupImporter_HintGroup() {
		return (EReference)mappingHintGroupImporterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupImporter_Container() {
		return (EReference)mappingHintGroupImporterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupImporter_MappingHints() {
		return (EReference)mappingHintGroupImporterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupImporter_ParentMapping() {
		return (EReference)mappingHintGroupImporterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHintGroupImporter__GetActiveMappingHints() {
		return mappingHintGroupImporterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExportedMappingHintGroup() {
		return exportedMappingHintGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalAttribute() {
		return globalAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalAttribute_Source() {
		return (EReference)globalAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGlobalAttribute__ValidateSourceAttributeHasUpperBoundOne__DiagnosticChain_Map() {
		return globalAttributeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingFactory getMappingFactory() {
		return (MappingFactory)getEFactoryInstance();
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
		mappingTypeEClass = createEClass(MAPPING_TYPE);
		createEReference(mappingTypeEClass, MAPPING_TYPE__SOURCE_SECTION);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__MAPPING_HINT_GROUPS);
		createEReference(mappingEClass, MAPPING__IMPORTED_MAPPING_HINT_GROUPS);
		createEAttribute(mappingEClass, MAPPING__ABSTRACT);
		createEOperation(mappingEClass, MAPPING___GET_ACTIVE_MAPPING_HINT_GROUPS);
		createEOperation(mappingEClass, MAPPING___GET_ACTIVE_IMPORTED_MAPPING_HINT_GROUPS);
		createEOperation(mappingEClass, MAPPING___VALIDATE_CONTAINS_HINT_GROUPS__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingEClass, MAPPING___VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingEClass, MAPPING___VALIDATE_SOURCE_SECTION_IS_ACTIVE__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingEClass, MAPPING___VALIDATE_SOURCE_SECTION_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP);

		mappingHintGroupTypeEClass = createEClass(MAPPING_HINT_GROUP_TYPE);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__TARGET_SECTION);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__EXTEND);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__ALL_MAPPING_HINTS);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__ALL_EXTEND);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__ALL_EXTENDING);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__PARENT_MAPPING);
		createEOperation(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE___VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE___GET_ACTIVE_MAPPING_HINTS);
		createEOperation(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE___VALIDATE_DO_NOT_USE_LIBRARY_ELEMENTS_WITHOUT_LIBRARY_NATURE__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE___VALIDATE_TARGET_SECTION_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP);

		instantiableMappingHintGroupEClass = createEClass(INSTANTIABLE_MAPPING_HINT_GROUP);

		mappingHintGroupEClass = createEClass(MAPPING_HINT_GROUP);

		mappingHintGroupImporterEClass = createEClass(MAPPING_HINT_GROUP_IMPORTER);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__CONTAINER);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__PARENT_MAPPING);
		createEOperation(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER___GET_ACTIVE_MAPPING_HINTS);

		exportedMappingHintGroupEClass = createEClass(EXPORTED_MAPPING_HINT_GROUP);

		globalAttributeEClass = createEClass(GLOBAL_ATTRIBUTE);
		createEReference(globalAttributeEClass, GLOBAL_ATTRIBUTE__SOURCE);
		createEOperation(globalAttributeEClass, GLOBAL_ATTRIBUTE___VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__DIAGNOSTICCHAIN_MAP);
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
		ModifierPackage theModifierPackage = (ModifierPackage)EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI);
		ExtendedPackage theExtendedPackage = (ExtendedPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI);
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theModifierPackage);
		getESubpackages().add(theExtendedPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mappingTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingTypeEClass.getESuperTypes().add(thePamtramPackage.getDeactivatableElement());
		mappingEClass.getESuperTypes().add(this.getMappingType());
		mappingEClass.getESuperTypes().add(thePamtramPackage.getConditionalElement());
		mappingHintGroupTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		instantiableMappingHintGroupEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		instantiableMappingHintGroupEClass.getESuperTypes().add(thePamtramPackage.getDeactivatableElement());
		instantiableMappingHintGroupEClass.getESuperTypes().add(thePamtramPackage.getConditionalElement());
		mappingHintGroupEClass.getESuperTypes().add(this.getMappingHintGroupType());
		mappingHintGroupEClass.getESuperTypes().add(this.getInstantiableMappingHintGroup());
		mappingHintGroupImporterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintGroupImporterEClass.getESuperTypes().add(this.getInstantiableMappingHintGroup());
		exportedMappingHintGroupEClass.getESuperTypes().add(this.getMappingHintGroupType());
		globalAttributeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		globalAttributeEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(mappingTypeEClass, MappingType.class, "MappingType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingType_SourceSection(), theSourcePackage.getSourceSection(), null, "sourceSection", null, 1, 1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_MappingHintGroups(), this.getMappingHintGroupType(), null, "mappingHintGroups", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_ImportedMappingHintGroups(), this.getMappingHintGroupImporter(), null, "importedMappingHintGroups", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMapping__GetActiveMappingHintGroups(), this.getMappingHintGroupType(), "getActiveMappingHintGroups", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMapping__GetActiveImportedMappingHintGroups(), this.getMappingHintGroupImporter(), "getActiveImportedMappingHintGroups", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getMapping__ValidateContainsHintGroups__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateContainsHintGroups", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMapping__ValidateContainsDeactivatedHintGroups__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateContainsDeactivatedHintGroups", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMapping__ValidateSourceSectionIsActive__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceSectionIsActive", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMapping__ValidateSourceSectionIsNotAbstract__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceSectionIsNotAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mappingHintGroupTypeEClass, MappingHintGroupType.class, "MappingHintGroupType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroupType_TargetSection(), theTargetPackage.getTargetSection(), null, "targetSection", null, 1, 1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_MappingHints(), theExtendedPackage.getMappingHint(), null, "mappingHints", null, 0, -1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_Extend(), this.getMappingHintGroupType(), null, "extend", null, 0, -1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_AttributeMappings(), theExtendedPackage.getAttributeMapping(), null, "attributeMappings", null, 0, -1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_CardinalityMappings(), theExtendedPackage.getCardinalityMapping(), null, "cardinalityMappings", null, 0, -1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_ReferenceTargetSelectors(), theExtendedPackage.getReferenceTargetSelector(), null, "referenceTargetSelectors", null, 0, -1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_ContainerSelectors(), theExtendedPackage.getContainerSelector(), null, "containerSelectors", null, 0, -1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_AllMappingHints(), theExtendedPackage.getMappingHint(), null, "allMappingHints", null, 0, -1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_AllExtend(), this.getMappingHintGroupType(), null, "allExtend", null, 0, -1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_AllExtending(), this.getMappingHintGroupType(), null, "allExtending", null, 0, -1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_ParentMapping(), this.getMapping(), null, "parentMapping", null, 0, 1, MappingHintGroupType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getMappingHintGroupType__ValidateExtendsOnlyValidHintGroups__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateExtendsOnlyValidHintGroups", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMappingHintGroupType__GetActiveMappingHints(), theExtendedPackage.getMappingHint(), "getActiveMappingHints", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMappingHintGroupType__ValidateDoNotUseLibraryElementsWithoutLibraryNature__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateDoNotUseLibraryElementsWithoutLibraryNature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMappingHintGroupType__ValidateTargetSectionIsNotAbstract__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetSectionIsNotAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMappingHintGroupType__ValidateNotExtendSelf__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNotExtendSelf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instantiableMappingHintGroupEClass, InstantiableMappingHintGroup.class, "InstantiableMappingHintGroup", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintGroupEClass, MappingHintGroup.class, "MappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintGroupImporterEClass, MappingHintGroupImporter.class, "MappingHintGroupImporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroupImporter_HintGroup(), this.getExportedMappingHintGroup(), null, "hintGroup", null, 1, 1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupImporter_Container(), theTargetPackage.getTargetSectionClass(), null, "container", null, 0, 1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupImporter_MappingHints(), theExtendedPackage.getMappingHintType(), null, "mappingHints", null, 0, -1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupImporter_ParentMapping(), this.getMapping(), null, "parentMapping", null, 1, 1, MappingHintGroupImporter.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getMappingHintGroupImporter__GetActiveMappingHints(), theExtendedPackage.getMappingHintType(), "getActiveMappingHints", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(exportedMappingHintGroupEClass, ExportedMappingHintGroup.class, "ExportedMappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globalAttributeEClass, GlobalAttribute.class, "GlobalAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalAttribute_Source(), theSourcePackage.getActualSourceSectionAttribute(), null, "source", null, 1, 1, GlobalAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGlobalAttribute__ValidateSourceAttributeHasUpperBoundOne__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceAttributeHasUpperBoundOne", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
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
		  (mappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "containsHintGroups containsDeactivatedHintGroups"
		   });	
		addAnnotation
		  (globalAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeHasUpperBoundOne"
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
			 "documentation", "This package contains all elements related to the description of Mappings between a SourceSection (representing its left-hand side) and one or multiple TargetSections (representing its right-hand side).\r\n<br />\r\nThe elements directly contained in this package can be used to create \'basic\' mappings which only link Source- and TargetSections. Elements that can be used to realize \'extended\' mappings which contain additional information for the transformation algorithms (aka MappingHints) are contained in the \'extended\' sub-package."
		   });	
		addAnnotation
		  (mappingTypeEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super type for elements describing some kind of mapping. Currently, there is only one concrete sub-element (Mapping)."
		   });	
		addAnnotation
		  (getMappingType_SourceSection(), 
		   source, 
		   new String[] {
			 "documentation", "The SourceSection that this Mapping is based on.\r\n<br /><br />\r\nThis Mapping will be executed/applied if the specified SourceSection is matched in the source model. If the SourceSection is matched multiple times, this Mapping will also be executed multiple times."
		   });	
		addAnnotation
		  (mappingEClass, 
		   source, 
		   new String[] {
			 "documentation", "A Mapping between a SourceSection and one or multiple TargetSections.\r\n<br /><br />\r\nThis Mapping will be executed/applied if the specified SourceSection is matched in the source model. If the SourceSection is matched multiple times, this Mapping will also be executed multiple times.\r\nEach execution of the Mapping will result in the instantiation of each specified TargetSection.\r\n<br /><br />\r\nNote: Each TargetSection to be instantiated is specified via its own MappingHintGroup that can be created as child of the Mapping."
		   });	
		addAnnotation
		  (getMapping__GetActiveMappingHintGroups(), 
		   source, 
		   new String[] {
			 "body", "Object[] hintGroups = getMappingHintGroups().stream().filter(h -> !(h instanceof InstantiableMappingHintGroup) ||  !((InstantiableMappingHintGroup) h).isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(hintGroups.length, hintGroups);"
		   });	
		addAnnotation
		  (getMapping__GetActiveImportedMappingHintGroups(), 
		   source, 
		   new String[] {
			 "body", "Object[] importedHintGroups = getImportedMappingHintGroups().stream().filter(h -> !h.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(importedHintGroups.length, importedHintGroups);"
		   });	
		addAnnotation
		  (getMapping__ValidateContainsHintGroups__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = !this.getMappingHintGroups().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping does not contain any hint groups!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_CONTAINS_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getMapping__ValidateContainsDeactivatedHintGroups__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.isDeactivated() ? this.getMappingHintGroups().size() == this.getActiveMappingHintGroups().size() && this.getImportedMappingHintGroups().size() == this.getActiveImportedMappingHintGroups().size() : true;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping contains deactivated hint groups that will not be used in a transformation!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_CONTAINS_DEACTIVATED_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getMapping__ValidateSourceSectionIsActive__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getSourceSection() == null || !this.getSourceSection().isDeactivated();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The mapping is based on a deactivated SourceSection and will not be used in a transformation!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING__VALIDATE_SOURCE_SECTION_IS_ACTIVE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getMapping__ValidateSourceSectionIsNotAbstract__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "boolean result = this.getSourceSection() == null || this.isAbstract() || !this.getSourceSection().isAbstract();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Only abstract Mappings may reference abstract SourceSections!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.util.MappingValidator%>.MAPPING__VALIDATE_SOURCE_SECTION_IS_NOT_ABSTRACT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_TYPE__SOURCE_SECTION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getMapping_MappingHintGroups(), 
		   source, 
		   new String[] {
			 "documentation", "The list of MappingHintGroups specifying the TargetSections to be instantiated when the Mapping is executed."
		   });	
		addAnnotation
		  (getMapping_ImportedMappingHintGroups(), 
		   source, 
		   new String[] {
			 "documentation", "The list of MappingHintGroupImporters specifying imported MappingHintGroups whose TargetSections shall be instantiated when the Mapping is executed."
		   });	
		addAnnotation
		  (getMapping_Abstract(), 
		   source, 
		   new String[] {
			 "documentation", "If a Mapping is marked as \'abstract\', it will not be executed directly. However, the MappingHintGroups contained in other Mappings may extend the MappingHintGroups defined in an abstract Mapping.\r\n<br />\r\nConsequently, abstract Mappings can be used to define some kind of template mappings that can be reqused by other (non-abstract) Mappings."
		   });	
		addAnnotation
		  (mappingHintGroupTypeEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super-type for elements describing some kind of MappingHintGroup that will lead to the instantiation of a specified TargetSection."
		   });	
		addAnnotation
		  (getMappingHintGroupType__ValidateExtendsOnlyValidHintGroups__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\n<%pamtram.structure.source.SourceSection%> sourceSection = ((<%pamtram.mapping.Mapping%>) this.eContainer()).getSourceSection();\r\n\r\nif (sourceSection == null) {\r\n\treturn true;\r\n}\r\n\r\n<%java.util.List%><SourceSection> validExtends = new <%java.util.ArrayList%><>();\r\nvalidExtends.add(sourceSection);\r\nvalidExtends.addAll(sourceSection.getAllExtend());\r\n\r\n<%java.util.Optional%><MappingHintGroupType> result = this.getExtend().stream()\r\n\t\t.filter(hg -> !validExtends.contains(((Mapping) hg.eContainer()).getSourceSection())).findFirst();\r\n\r\nif (result.isPresent() && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The MappingHintGroup \'\" + result.get().getName() + \"\' may not be extended by this MappingHintGroup because the referenced SourceSections are not compatible!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_EXTENDS_ONLY_VALID_HINT_GROUPS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND }));\r\n\r\n}\r\n\r\nreturn !result.isPresent();"
		   });	
		addAnnotation
		  (getMappingHintGroupType__GetActiveMappingHints(), 
		   source, 
		   new String[] {
			 "body", "Object[] hints = getAllMappingHints().stream().filter(h -> !h.isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(hints.length, hints);"
		   });	
		addAnnotation
		  (getMappingHintGroupType__ValidateDoNotUseLibraryElementsWithoutLibraryNature__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if (this.getTargetSection() == null || !this.getTargetSection().isLibraryEntry()) {\r\n\treturn true;\r\n}\r\n\r\n// Check if the \'PAMTraM Library Nature\' is set for the project\r\n//\r\n<%org.eclipse.core.resources.IFile%> file = <%de.tud.et.ifa.agtele.resources.ResourceHelper%>.getFileForResource(this.eResource());\r\nif (file == null || file.getProject() == null) {\r\n\treturn true;\r\n}\r\n\r\nString errorMessage = \"The \'PAMTraM Library Nature\' is not activated for this project. Thus, LibraryEntries may not be used as TargetSections! You can activate the nature in the project properties...\";\r\n\r\ntry {\r\n\tif (!Boolean.parseBoolean(<%de.mfreund.pamtram.properties.PropertySupplier%>.getResourceProperty(<%de.mfreund.pamtram.properties.PropertySupplier%>.PROP_HAS_LIBRARY_NATURE,\r\n\t\t\tfile.getProject()))) {\r\n\t\tif (diagnostics != null) {\r\n\t\t\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.util.MappingValidator%>.MAPPING_HINT_GROUP_TYPE__VALIDATE_DO_NOT_USE_LIBRARY_ELEMENTS_WITHOUT_LIBRARY_NATURE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION }));\r\n\t\t}\r\n\t\treturn false;\r\n\t}\r\n} catch (<%org.eclipse.core.runtime.CoreException%> e) {\r\n\te.printStackTrace();\r\n}\r\nreturn true;"
		   });	
		addAnnotation
		  (getMappingHintGroupType__ValidateTargetSectionIsNotAbstract__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if(!(this.eContainer() instanceof <%pamtram.mapping.Mapping%>)) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.mapping.Mapping%> mapping = (<%pamtram.mapping.Mapping%>) this.eContainer();\r\n\r\nboolean result = this.getTargetSection() == null || mapping.isAbstract() || !this.getTargetSection().isAbstract();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Only MappingHintGroups in abstract Mappings may reference abstract TargetSections!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.util.MappingValidator%>.MAPPING_HINT_GROUP_TYPE__VALIDATE_TARGET_SECTION_IS_NOT_ABSTRACT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getMappingHintGroupType__ValidateNotExtendSelf__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "boolean result = !this.getAllExtend().contains(this);\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A MappingHintGroup must not extend itself (neither directly nor indirectly)!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, \r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\tMappingValidator.MAPPING_HINT_GROUP_TYPE__VALIDATE_NOT_EXTEND_SELF, \r\n\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getMappingHintGroupType_TargetSection(), 
		   source, 
		   new String[] {
			 "documentation", "The TargetSection to be instantiated based on this MappingHintGroup."
		   });	
		addAnnotation
		  (getMappingHintGroupType_MappingHints(), 
		   source, 
		   new String[] {
			 "documentation", "An optional list of MappingHints refining this Mapping resp. MappingHintGroup.\r\n<br /><br />\r\nMappingHints can be used to assist the transformation algorithm in the instantiation of TargetSections. For example, AttributeMappings can be added that specify how to set the values of the Attributes defined as part of the TargetSection."
		   });	
		addAnnotation
		  (getMappingHintGroupType_Extend(), 
		   source, 
		   new String[] {
			 "documentation", "One or multiple MappingHintGroups (that are part of an \'abstract\' Mapping) which shall be extended by this MappingHintGroup.\r\n<br />\r\nAll MappingHints that are defined in extended MappingHintGroups will be added to the MappingHints defined locally in this Group.\r\n<br /><br />\r\nNote: If an extended Group defines a MappingHint that is \'overwritten\' by a MappingHint defined locally, it will not be added.",
			 "propertyDescriptor", "\r\nthis.itemPropertyDescriptors.add(\r\n\t\tnew ItemPropertyDescriptor(((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) this.adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_MappingHintGroupType_extend_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_MappingHintGroupType_extend_description\"),\r\n\t\t\t\t<%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_ExtendedPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t<%pamtram.mapping.MappingHintGroupType%> mhg = (MappingHintGroupType) object;\r\n\r\n\t\t\t\tif (mhg.getTargetSection() == null) {\r\n\t\t\t\t\treturn new <%org.eclipse.emf.common.util.BasicEList%><>();\r\n\t\t\t\t}\r\n\r\n\t\t\t\tCollection<MappingHintGroupType> ret = new BasicEList<>();\r\n\r\n\t\t\t\t<%pamtram.mapping.Mapping%> mhgMapping = (Mapping) mhg.eContainer();\r\n\t\t\t\tfor (Object choice : super.getChoiceOfValues(object)) {\r\n\r\n\t\t\t\t\tMappingHintGroupType val = (MappingHintGroupType) choice;\r\n\r\n\t\t\t\t\tMapping abstractMapping = (Mapping) val.eContainer();\r\n\r\n\t\t\t\t\t// only hint groups that do not extend this hint group can be used\r\n\t\t\t\t\t//\r\n\t\t\t\t\tif (val.getAllExtend().contains(mhg)) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\t\t// only hint groups from other mappings can be used\r\n\t\t\t\t\t// for extension\r\n\t\t\t\t\tif (mhgMapping.equals(abstractMapping)) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\t\t// only hint groups in abstract mappings can be used\r\n\t\t\t\t\tif (!abstractMapping.isAbstract()) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\t\t// additionally, the source section need to match or\r\n\t\t\t\t\t// be connected via an \'extend\' reference\r\n\t\t\t\t\tif (!(mhgMapping.getSourceSection().equals(abstractMapping.getSourceSection()) || mhgMapping\r\n\t\t\t\t\t\t\t.getSourceSection().getAllExtend().contains(abstractMapping.getSourceSection()))) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\t\t// finally, the target sections of the hint groups\r\n\t\t\t\t\t// need to \'extend\', too\r\n\t\t\t\t\tif (mhg.getTargetSection().equals(val.getTargetSection())\r\n\t\t\t\t\t\t\t|| mhg.getTargetSection().getAllExtend().contains(val.getTargetSection())) {\r\n\t\t\t\t\t\tret.add(val);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\treturn ret;\r\n\t\t\t}\r\n\t\t});"
		   });	
		addAnnotation
		  (getMappingHintGroupType_AttributeMappings(), 
		   source, 
		   new String[] {
			 "get", "List<<%pamtram.mapping.extended.AttributeMapping%>> attributeMappings = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof <%pamtram.mapping.extended.AttributeMapping%>).map(hint -> (<%pamtram.mapping.extended.AttributeMapping%>) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__ATTRIBUTE_MAPPINGS,\r\n\t\tattributeMappings.size(),attributeMappings.toArray());"
		   });	
		addAnnotation
		  (getMappingHintGroupType_AttributeMappings(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'mappingHints\' that are of type AttributeMapping."
		   });	
		addAnnotation
		  (getMappingHintGroupType_CardinalityMappings(), 
		   source, 
		   new String[] {
			 "get", "List<<%pamtram.mapping.extended.CardinalityMapping%>> cardinalityMappings = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof <%pamtram.mapping.extended.CardinalityMapping%>).map(hint -> (<%pamtram.mapping.extended.CardinalityMapping%>) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__CARDINALITY_MAPPINGS,\r\n\t\tcardinalityMappings.size(),cardinalityMappings.toArray());"
		   });	
		addAnnotation
		  (getMappingHintGroupType_CardinalityMappings(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'mappingHints\' that are of type CardinalityMapping."
		   });	
		addAnnotation
		  (getMappingHintGroupType_ReferenceTargetSelectors(), 
		   source, 
		   new String[] {
			 "get", "List<<%pamtram.mapping.extended.ReferenceTargetSelector%>> referenceTargetSelectors = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%>).map(hint -> (<%pamtram.mapping.extended.ReferenceTargetSelector%>) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__REFERENCE_TARGET_SELECTORS,\r\n\t\treferenceTargetSelectors.size(),referenceTargetSelectors.toArray());"
		   });	
		addAnnotation
		  (getMappingHintGroupType_ReferenceTargetSelectors(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'mappingHints\' that are of type ReferenceTargetSelector."
		   });	
		addAnnotation
		  (getMappingHintGroupType_ContainerSelectors(), 
		   source, 
		   new String[] {
			 "get", "List<<%pamtram.mapping.extended.ContainerSelector%>> containerSelectors = this.getAllMappingHints().stream()\r\n\t\t\t\t.filter(hint -> hint instanceof <%pamtram.mapping.extended.ContainerSelector%>).map(hint -> (<%pamtram.mapping.extended.ContainerSelector%>) hint)\r\n\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__CONTAINER_SELECTORS,\r\n\t\tcontainerSelectors.size(),containerSelectors.toArray());"
		   });	
		addAnnotation
		  (getMappingHintGroupType_ContainerSelectors(), 
		   source, 
		   new String[] {
			 "documentation", "The subset of the \'mappingHints\' that are of type ContainerSelector."
		   });	
		addAnnotation
		  (getMappingHintGroupType_AllMappingHints(), 
		   source, 
		   new String[] {
			 "get", "Set<<%pamtram.mapping.extended.MappingHint%>> ret = new LinkedHashSet<>();\r\n\r\nret.addAll(this.getAllExtend().stream().flatMap(s -> s.getMappingHints().stream())\r\n\t\t.collect(<%java.util.stream.Collectors%>.toList()));\r\n\r\n\tret.addAll(this.getMappingHints());\r\n\r\n\t// Filter those MappingHints that are overridden by more concrete hints\r\n\t\t//\r\n\t\tSet<<%pamtram.mapping.extended.MappingHint%>> overridenHints = ret.parallelStream().filter(h -> h.getOverwrite() != null).map(MappingHint::getOverwrite).collect(<%java.util.stream.Collectors%>.toSet());\r\n\t\tret.removeAll(overridenHints);\r\n\r\n\t\treturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this,\r\n\t\t\t\t\t\t<%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__ALL_MAPPING_HINTS, ret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getMappingHintGroupType_AllMappingHints(), 
		   source, 
		   new String[] {
			 "documentation", "All \'mappingHints\' (including those defined by potential extended Mappings)."
		   });	
		addAnnotation
		  (getMappingHintGroupType_AllExtend(), 
		   source, 
		   new String[] {
			 "get", "<%java.util.Set%><Object> ret = new <%java.util.LinkedHashSet%><>();\r\n\r\n<%java.util.List%><<%pamtram.mapping.MappingHintGroupType%>> toCheck = new <%java.util.ArrayList%><>();\r\ntoCheck.add(this);\r\n\r\nwhile (!toCheck.isEmpty()) {\r\n\t<%pamtram.mapping.MappingHintGroupType%> next = toCheck.remove(0);\r\n\r\n\tList<<%pamtram.mapping.MappingHintGroupType%>> localToCheck = next.getExtend().stream().filter(e -> !ret.contains(e))\r\n\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\r\n\tret.addAll(localToCheck);\r\n\ttoCheck.addAll(localToCheck);\r\n}\r\n\r\nreturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__ALL_EXTEND,\r\n\t\tret.size(), ret.toArray());"
		   });	
		addAnnotation
		  (getMappingHintGroupType_AllExtend(), 
		   source, 
		   new String[] {
			 "documentation", "The list of recursively collected extended MappingHintGroups."
		   });	
		addAnnotation
		  (getMappingHintGroupType_AllExtending(), 
		   source, 
		   new String[] {
			 "get", "Set<Object> extendingSections = new HashSet<>();\r\n\t\tIterator<<%org.eclipse.emf.common.notify.Notifier%>> it = this.eResource().getResourceSet().getAllContents();\r\n\t\twhile (it.hasNext()) {\r\n\t\t\t<%org.eclipse.emf.common.notify.Notifier%> next = it.next();\r\n\t\t\tif (next instanceof <%pamtram.mapping.MappingHintGroupType%> && ((<%pamtram.mapping.MappingHintGroupType%>) next).getAllExtend().contains(this)) {\r\n\t\t\t\textendingSections.add(next);\r\n\t\t\t}\r\n\t\t}\r\n\r\treturn new <%org.eclipse.emf.ecore.util.EcoreEList%>.UnmodifiableEList<>(this, <%pamtram.mapping.MappingPackage%>.Literals.MAPPING_HINT_GROUP_TYPE__ALL_EXTENDING,\r\n\t\t\t\textendingSections.size(), extendingSections.toArray());"
		   });	
		addAnnotation
		  (getMappingHintGroupType_AllExtending(), 
		   source, 
		   new String[] {
			 "documentation", "The list of recursively collected MappingHintGroups extending this MappingHintGroup."
		   });	
		addAnnotation
		  (getMappingHintGroupType_ParentMapping(), 
		   source, 
		   new String[] {
			 "get", "\r\nreturn this.eContainer() instanceof <%pamtram.mapping.Mapping%> ? (Mapping) this.eContainer() : null;"
		   });	
		addAnnotation
		  (getMappingHintGroupType_ParentMapping(), 
		   source, 
		   new String[] {
			 "documentation", "The Mapping that defines resp. contains this."
		   });	
		addAnnotation
		  (instantiableMappingHintGroupEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super-type for elements describing some kind of MappingHintGroup that (resp. whose specified TargetSection) can be directly instantiated."
		   });	
		addAnnotation
		  (mappingHintGroupEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingHintGroup serves two purposes:\r\n<br />\r\n(1) It specifies a TargetSection that will be instantiated when the Mapping containing this MappingHintGroup is executed.\r\n<br />\r\n(2) It acts as container for a set of MappingHints. MappingHints can be used to assist the transformation algorithm in the instantiation of the specified TargetSection. For example, AttributeMappings can be added that specify how to set the values of the Attributes defined as part of the TargetSection.\r\n<br /><br />\r\nNote: Each execution of the Mapping will result in the instantiation of the specified TargetSection."
		   });	
		addAnnotation
		  (mappingHintGroupImporterEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingHintGroupImporter does not specify its own TargetSection to be instantiated but \'imports\' an existing (exported) MappingHintGroup instead.\r\n<br />\r\nImporting thereby means that all values that have been collected for the MappingHints defined in the exported MappingHintGroup are reused during the instantiation.\r\n<br /><br />\r\nNote: There is a difference between (1) \'extending\' and (2) \'importing\' MappingHintGroups:\r\n<br />\r\n(1) Extending a HintGroup means that all MappingHints defined in the extended HintGroup are added to the Extending HintGroup (before execution of the transformation).\r\n(2) Importing a HintGroup means that the VALUES of all MappingHints defined in the exported HintGroup are used when instantiating the HintGroupImporter (during the execution of the transformation).\r\n<br /><br />\r\nIn most cases, \'extending\' HintGroups will be the desired behavior. Importing HintGroups is only necessary for a few special use cases."
		   });	
		addAnnotation
		  (getMappingHintGroupImporter__GetActiveMappingHints(), 
		   source, 
		   new String[] {
			 "body", "Object[] hints = getMappingHints().stream().filter(h -> !(h instanceof DeactivatableElement) || !((<%pamtram.DeactivatableElement%>) h).isDeactivated()).toArray();\r\nreturn new <%org.eclipse.emf.common.util.BasicEList%>.UnmodifiableEList<>(hints.length, hints);"
		   });	
		addAnnotation
		  (getMappingHintGroupImporter_HintGroup(), 
		   source, 
		   new String[] {
			 "documentation", "The existing (exported) MappingHintGroup that is imported by this HintGroupImporter."
		   });	
		addAnnotation
		  (getMappingHintGroupImporter_Container(), 
		   source, 
		   new String[] {
			 "documentation", "An optional TargetSectionClass that (resp. instances of that) will be used as container for the instances created based on the TargetSection denoted by the imported MappingHintGroup."
		   });	
		addAnnotation
		  (getMappingHintGroupImporter_MappingHints(), 
		   source, 
		   new String[] {
			 "documentation", "An optional list of MappingHints refining the imported MappingHintGroup. The specified MappingHints will be added to those already defined by the imported MappingHintGroup."
		   });	
		addAnnotation
		  (getMappingHintGroupImporter_ParentMapping(), 
		   source, 
		   new String[] {
			 "get", "\r\nreturn this.eContainer() instanceof <%pamtram.mapping.Mapping%> ? (Mapping) this.eContainer() : null;"
		   });	
		addAnnotation
		  (getMappingHintGroupImporter_ParentMapping(), 
		   source, 
		   new String[] {
			 "documentation", "The Mapping that defines resp. contains this."
		   });	
		addAnnotation
		  (exportedMappingHintGroupEClass, 
		   source, 
		   new String[] {
			 "documentation", "If an ExportedMappingHintGroup (resp. the containing Mapping) is executed, the specified TargetSection is not directly instantiated although values for specified MappingHints are collected.\r\nInstead ExportedMappingHintGroups may be imported by means of a MappingHintGroupImporter that is part of another Mapping.\r\n<br />\r\nImporting thereby means that all values that have been collected for the MappingHints defined in the exported MappingHintGroup are reused during the instantiation of the MappingHintGroupImporter.\r\n<br /><br />\r\nNote: There is a difference between (1) \'extending\' and (2) \'importing\' MappingHintGroups:\r\n<br />\r\n(1) Extending a HintGroup means that all MappingHints defined in the extended HintGroup are added to the Extending HintGroup (before execution of the transformation).\r\n(2) Importing a HintGroup means that the VALUES of all MappingHints defined in the exported HintGroup are used when instantiating the HintGroupImporter (during the execution of the transformation).\r\n<br /><br />\r\nIn most cases, \'extending\' HintGroups will be the desired behavior. Importing HintGroups is only necessary for a few special use cases."
		   });	
		addAnnotation
		  (globalAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "GlobalAttributes can be used to store the value of a SourceSectionAttribute in a reusable way.\r\n<br />\r\nThe value of a GlobalAttribute can thereby be reused in various calculations (e.g. in AttributeMappings) by means of a GlobalAttributeImporter. In contrast to the \'local\' usage of an Attribute value in a calculation, GlobalAttributes can be reused as part of any Mapping - the Attribute does not need to be part of the SourceSection associated with the Mapping."
		   });	
		addAnnotation
		  (getGlobalAttribute__ValidateSourceAttributeHasUpperBoundOne__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getSource() == null || this.getSource().getAttribute() == null ? true : this.getSource().getAttribute().getUpperBound() == 1;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Global attributes may only be defined for attributes that have an upper bound of 1!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.util.MappingValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.GLOBAL_ATTRIBUTE__VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.MappingPackage%>.Literals.GLOBAL_ATTRIBUTE__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getGlobalAttribute_Source(), 
		   source, 
		   new String[] {
			 "documentation", "The SourceSectionAttribute based on which the value of this GlobalAttribute is determined."
		   });
	}

} //MappingPackageImpl
