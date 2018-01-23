/**
 */
package pamtram.mapping.extended.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

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

import pamtram.mapping.MappingPackage;

import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMappingExternalSourceElement;
import pamtram.mapping.extended.AttributeMappingGlobalSourceElement;
import pamtram.mapping.extended.AttributeMappingSourceElement;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingExternalSourceElement;
import pamtram.mapping.extended.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceInterface;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ExpandableHint;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ExternalMappedAttributeValueAppender;
import pamtram.mapping.extended.ExternalMappedAttributeValueExpander;
import pamtram.mapping.extended.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.extended.HintImporterMappingHint;
import pamtram.mapping.extended.LocalMappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValueAppender;
import pamtram.mapping.extended.MappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValuePrepender;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintBaseType;
import pamtram.mapping.extended.MappingHintSourceInterface;
import pamtram.mapping.extended.MappingHintType;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.extended.util.ExtendedValidator;
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

import pamtram.structure.target.TargetPackage;

import pamtram.structure.target.impl.TargetPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtendedPackageImpl extends EPackageImpl implements ExtendedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingHintBaseTypeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingHintTypeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingHintEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expandableHintEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hintImporterMappingHintEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingHintSourceInterfaceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalAttributeImporterEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingSourceInterfaceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingExternalSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMappingGlobalSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingSourceInterfaceEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingExternalSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cardinalityMappingGlobalSourceElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceTargetSelectorEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerSelectorEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedAttributeValueExpanderEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localMappedAttributeValueExpanderEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedAttributeValuePrependerEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedAttributeValueAppenderEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalMappedAttributeValueExpanderEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalMappedAttributeValuePrependerEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalMappedAttributeValueAppenderEClass = null;
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
	 * @see pamtram.mapping.extended.ExtendedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtendedPackageImpl() {
		super(eNS_URI, ExtendedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExtendedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtendedPackage init() {
		if (isInited) return (ExtendedPackage)EPackage.Registry.INSTANCE.getEPackage(ExtendedPackage.eNS_URI);

		// Obtain or create and register package
		ExtendedPackageImpl theExtendedPackage = (ExtendedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExtendedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtendedPackageImpl());

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
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI) : MappingPackage.eINSTANCE);
		ModifierPackageImpl theModifierPackage = (ModifierPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) instanceof ModifierPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModifierPackage.eNS_URI) : ModifierPackage.eINSTANCE);

		// Create package meta-data objects
		theExtendedPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theGenericPackage.createPackageContents();
		theConstraintPackage.createPackageContents();
		theSourcePackage.createPackageContents();
		theTargetPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theMappingPackage.createPackageContents();
		theModifierPackage.createPackageContents();

		// Initialize created meta-data
		theExtendedPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theGenericPackage.initializePackageContents();
		theConstraintPackage.initializePackageContents();
		theSourcePackage.initializePackageContents();
		theTargetPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theMappingPackage.initializePackageContents();
		theModifierPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theExtendedPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ExtendedValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theExtendedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExtendedPackage.eNS_URI, theExtendedPackage);
		return theExtendedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingHintBaseType() {
		return mappingHintBaseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingHintType() {
		return mappingHintTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingHint() {
		return mappingHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHint_Overwrite() {
		return (EReference)mappingHintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHint__ValidateOverwritesValidMappingHint__DiagnosticChain_Map() {
		return mappingHintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingHint__ValidateConsiderOverwritingHint__DiagnosticChain_Map() {
		return mappingHintEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpandableHint() {
		return expandableHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHintImporterMappingHint() {
		return hintImporterMappingHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingHintSourceInterface() {
		return mappingHintSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalAttributeImporter() {
		return globalAttributeImporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalAttributeImporter_GlobalAttribute() {
		return (EReference)globalAttributeImporterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMapping() {
		return attributeMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMapping_Target() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMapping_SourceElements() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMapping__GetLocalSourceElements() {
		return attributeMappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMapping__GetExternalSourceElements() {
		return attributeMappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map() {
		return attributeMappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingSourceInterface() {
		return attributeMappingSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingSourceElement() {
		return attributeMappingSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingExternalSourceElement() {
		return attributeMappingExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMappingGlobalSourceElement() {
		return attributeMappingGlobalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMapping() {
		return cardinalityMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCardinalityMapping_Source() {
		return (EReference)cardinalityMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCardinalityMapping_Target() {
		return (EReference)cardinalityMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCardinalityMapping_SourceElements() {
		return (EReference)cardinalityMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateSourceElementMatchesSectionOrContainedSection__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateOnlySourceOrSourceElements__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateExpressionOnlyForSourceElements__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__ValidateModifiersOnlyForSourceElements__DiagnosticChain_Map() {
		return cardinalityMappingEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__GetLocalSourceElements() {
		return cardinalityMappingEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__GetExternalSourceElements() {
		return cardinalityMappingEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingSourceInterface() {
		return cardinalityMappingSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingSourceElement() {
		return cardinalityMappingSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingExternalSourceElement() {
		return cardinalityMappingExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCardinalityMappingGlobalSourceElement() {
		return cardinalityMappingGlobalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceTargetSelector() {
		return referenceTargetSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceTargetSelector_AffectedReference() {
		return (EReference)referenceTargetSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReferenceTargetSelector__ValidateAffectedReferenceIsNonContainment__DiagnosticChain_Map() {
		return referenceTargetSelectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReferenceTargetSelector__ValidateAffectedReferenceMatchesSection__DiagnosticChain_Map() {
		return referenceTargetSelectorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReferenceTargetSelector__ValidateTargetClass__DiagnosticChain_Map() {
		return referenceTargetSelectorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerSelector() {
		return containerSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainerSelector__ValidateTargetClassMatchesPossibleContainerType__DiagnosticChain_Map() {
		return containerSelectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappedAttributeValueExpander() {
		return mappedAttributeValueExpanderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappedAttributeValueExpander_HintsToExpand() {
		return (EReference)mappedAttributeValueExpanderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappedAttributeValueExpander__GetSourceAttribute() {
		return mappedAttributeValueExpanderEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalMappedAttributeValueExpander() {
		return localMappedAttributeValueExpanderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappedAttributeValuePrepender() {
		return mappedAttributeValuePrependerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappedAttributeValueAppender() {
		return mappedAttributeValueAppenderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalMappedAttributeValueExpander() {
		return externalMappedAttributeValueExpanderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalMappedAttributeValuePrepender() {
		return externalMappedAttributeValuePrependerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalMappedAttributeValueAppender() {
		return externalMappedAttributeValueAppenderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedFactory getExtendedFactory() {
		return (ExtendedFactory)getEFactoryInstance();
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
		mappingHintBaseTypeEClass = createEClass(MAPPING_HINT_BASE_TYPE);

		mappingHintTypeEClass = createEClass(MAPPING_HINT_TYPE);

		mappingHintEClass = createEClass(MAPPING_HINT);
		createEReference(mappingHintEClass, MAPPING_HINT__OVERWRITE);
		createEOperation(mappingHintEClass, MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP);
		createEOperation(mappingHintEClass, MAPPING_HINT___VALIDATE_CONSIDER_OVERWRITING_HINT__DIAGNOSTICCHAIN_MAP);

		expandableHintEClass = createEClass(EXPANDABLE_HINT);

		hintImporterMappingHintEClass = createEClass(HINT_IMPORTER_MAPPING_HINT);

		mappingHintSourceInterfaceEClass = createEClass(MAPPING_HINT_SOURCE_INTERFACE);

		globalAttributeImporterEClass = createEClass(GLOBAL_ATTRIBUTE_IMPORTER);
		createEReference(globalAttributeImporterEClass, GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE);

		attributeMappingEClass = createEClass(ATTRIBUTE_MAPPING);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__TARGET);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);

		attributeMappingSourceInterfaceEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_INTERFACE);

		attributeMappingSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_ELEMENT);

		attributeMappingExternalSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT);

		attributeMappingGlobalSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT);

		cardinalityMappingEClass = createEClass(CARDINALITY_MAPPING);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__SOURCE);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__TARGET);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__SOURCE_ELEMENTS);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS);

		cardinalityMappingSourceInterfaceEClass = createEClass(CARDINALITY_MAPPING_SOURCE_INTERFACE);

		cardinalityMappingSourceElementEClass = createEClass(CARDINALITY_MAPPING_SOURCE_ELEMENT);

		cardinalityMappingExternalSourceElementEClass = createEClass(CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT);

		cardinalityMappingGlobalSourceElementEClass = createEClass(CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT);

		referenceTargetSelectorEClass = createEClass(REFERENCE_TARGET_SELECTOR);
		createEReference(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE);
		createEOperation(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP);
		createEOperation(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);
		createEOperation(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR___VALIDATE_TARGET_CLASS__DIAGNOSTICCHAIN_MAP);

		containerSelectorEClass = createEClass(CONTAINER_SELECTOR);
		createEOperation(containerSelectorEClass, CONTAINER_SELECTOR___VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP);

		mappedAttributeValueExpanderEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_EXPANDER);
		createEReference(mappedAttributeValueExpanderEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND);
		createEOperation(mappedAttributeValueExpanderEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE);

		localMappedAttributeValueExpanderEClass = createEClass(LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER);

		mappedAttributeValuePrependerEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_PREPENDER);

		mappedAttributeValueAppenderEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_APPENDER);

		externalMappedAttributeValueExpanderEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER);

		externalMappedAttributeValuePrependerEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER);

		externalMappedAttributeValueAppenderEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER);
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
		ConstraintPackage theConstraintPackage = (ConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintPackage.eNS_URI);
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mappingHintBaseTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintTypeEClass.getESuperTypes().add(this.getMappingHintBaseType());
		mappingHintEClass.getESuperTypes().add(this.getMappingHintType());
		mappingHintEClass.getESuperTypes().add(thePamtramPackage.getConditionalElement());
		mappingHintEClass.getESuperTypes().add(thePamtramPackage.getDeactivatableElement());
		hintImporterMappingHintEClass.getESuperTypes().add(this.getMappingHintType());
		mappingHintSourceInterfaceEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintSourceInterfaceEClass.getESuperTypes().add(thePamtramPackage.getConditionalElement());
		globalAttributeImporterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		globalAttributeImporterEClass.getESuperTypes().add(this.getAttributeMappingSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(theStructurePackage.getInstanceSelectorSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(theConstraintPackage.getValueConstraintSourceInterface());
		attributeMappingEClass.getESuperTypes().add(this.getMappingHint());
		attributeMappingEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		attributeMappingEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		attributeMappingEClass.getESuperTypes().add(this.getExpandableHint());
		attributeMappingSourceInterfaceEClass.getESuperTypes().add(this.getMappingHintSourceInterface());
		EGenericType g1 = createEGenericType(theStructurePackage.getLocalDynamicSourceElement());
		EGenericType g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getGlobalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getSourceInstanceSelector());
		g1.getETypeArguments().add(g2);
		attributeMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		cardinalityMappingEClass.getESuperTypes().add(this.getMappingHint());
		cardinalityMappingEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		cardinalityMappingEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		cardinalityMappingSourceInterfaceEClass.getESuperTypes().add(this.getMappingHintSourceInterface());
		g1 = createEGenericType(theStructurePackage.getLocalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		cardinalityMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCardinalityMappingSourceInterface());
		cardinalityMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		cardinalityMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCardinalityMappingSourceInterface());
		cardinalityMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theStructurePackage.getGlobalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theStructurePackage.getSourceInstanceSelector());
		g1.getETypeArguments().add(g2);
		cardinalityMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCardinalityMappingSourceInterface());
		cardinalityMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		referenceTargetSelectorEClass.getESuperTypes().add(this.getMappingHint());
		referenceTargetSelectorEClass.getESuperTypes().add(theStructurePackage.getTargetInstanceSelector());
		containerSelectorEClass.getESuperTypes().add(this.getMappingHint());
		containerSelectorEClass.getESuperTypes().add(theStructurePackage.getTargetInstanceSelector());
		mappedAttributeValueExpanderEClass.getESuperTypes().add(this.getHintImporterMappingHint());
		g1 = createEGenericType(theStructurePackage.getLocalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		localMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getMappedAttributeValueExpander());
		localMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		mappedAttributeValuePrependerEClass.getESuperTypes().add(this.getLocalMappedAttributeValueExpander());
		mappedAttributeValueAppenderEClass.getESuperTypes().add(this.getLocalMappedAttributeValueExpander());
		g1 = createEGenericType(theStructurePackage.getExternalDynamicSourceElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		externalMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getMappedAttributeValueExpander());
		externalMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		externalMappedAttributeValuePrependerEClass.getESuperTypes().add(this.getExternalMappedAttributeValueExpander());
		externalMappedAttributeValueAppenderEClass.getESuperTypes().add(this.getExternalMappedAttributeValueExpander());

		// Initialize classes, features, and operations; add parameters
		initEClass(mappingHintBaseTypeEClass, MappingHintBaseType.class, "MappingHintBaseType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintTypeEClass, MappingHintType.class, "MappingHintType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintEClass, MappingHint.class, "MappingHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHint_Overwrite(), this.getMappingHint(), null, "overwrite", null, 0, 1, MappingHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getMappingHint__ValidateOverwritesValidMappingHint__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOverwritesValidMappingHint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMappingHint__ValidateConsiderOverwritingHint__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateConsiderOverwritingHint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(expandableHintEClass, ExpandableHint.class, "ExpandableHint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hintImporterMappingHintEClass, HintImporterMappingHint.class, "HintImporterMappingHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintSourceInterfaceEClass, MappingHintSourceInterface.class, "MappingHintSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globalAttributeImporterEClass, GlobalAttributeImporter.class, "GlobalAttributeImporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalAttributeImporter_GlobalAttribute(), theMappingPackage.getGlobalAttribute(), null, "globalAttribute", null, 1, 1, GlobalAttributeImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMappingEClass, AttributeMapping.class, "AttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMapping_Target(), theTargetPackage.getTargetSectionAttribute(), null, "target", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMapping_SourceElements(), this.getAttributeMappingSourceInterface(), null, "sourceElements", null, 1, -1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttributeMapping__GetLocalSourceElements(), this.getAttributeMappingSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttributeMapping__GetExternalSourceElements(), this.getAttributeMappingExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetAttributeMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeMappingSourceInterfaceEClass, AttributeMappingSourceInterface.class, "AttributeMappingSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingSourceElementEClass, AttributeMappingSourceElement.class, "AttributeMappingSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingExternalSourceElementEClass, AttributeMappingExternalSourceElement.class, "AttributeMappingExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingGlobalSourceElementEClass, AttributeMappingGlobalSourceElement.class, "AttributeMappingGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingEClass, CardinalityMapping.class, "CardinalityMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(theGenericPackage.getMetaModelElement());
		g2 = createEGenericType(theSourcePackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSourcePackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		initEReference(getCardinalityMapping_Source(), g1, null, "source", null, 0, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCardinalityMapping_Target(), theTargetPackage.getTargetSectionClass(), null, "target", null, 1, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCardinalityMapping_SourceElements(), this.getCardinalityMappingSourceInterface(), null, "sourceElements", null, 0, -1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateSourceElementMatchesSectionOrContainedSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceElementMatchesSectionOrContainedSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetClassMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceClassIsVariableCardinality", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetClassIsVariableCardinality", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNoCardinalityMappingForSourceSectionRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateOnlySourceOrSourceElements__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateOnlySourceOrSourceElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateExpressionOnlyForSourceElements__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateExpressionOnlyForSourceElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__ValidateModifiersOnlyForSourceElements__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateModifiersOnlyForSourceElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getCardinalityMapping__GetLocalSourceElements(), this.getCardinalityMappingSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getCardinalityMapping__GetExternalSourceElements(), this.getCardinalityMappingExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(cardinalityMappingSourceInterfaceEClass, CardinalityMappingSourceInterface.class, "CardinalityMappingSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingSourceElementEClass, CardinalityMappingSourceElement.class, "CardinalityMappingSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingExternalSourceElementEClass, CardinalityMappingExternalSourceElement.class, "CardinalityMappingExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cardinalityMappingGlobalSourceElementEClass, CardinalityMappingGlobalSourceElement.class, "CardinalityMappingGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceTargetSelectorEClass, ReferenceTargetSelector.class, "ReferenceTargetSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceTargetSelector_AffectedReference(), theTargetPackage.getTargetSectionCrossReference(), null, "affectedReference", null, 1, 1, ReferenceTargetSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getReferenceTargetSelector__ValidateAffectedReferenceIsNonContainment__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateAffectedReferenceIsNonContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getReferenceTargetSelector__ValidateAffectedReferenceMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateAffectedReferenceMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getReferenceTargetSelector__ValidateTargetClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containerSelectorEClass, ContainerSelector.class, "ContainerSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getContainerSelector__ValidateTargetClassMatchesPossibleContainerType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetClassMatchesPossibleContainerType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mappedAttributeValueExpanderEClass, MappedAttributeValueExpander.class, "MappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedAttributeValueExpander_HintsToExpand(), this.getExpandableHint(), null, "hintsToExpand", null, 1, -1, MappedAttributeValueExpander.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMappedAttributeValueExpander__GetSourceAttribute(), theSourcePackage.getSourceSectionAttribute(), "getSourceAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(localMappedAttributeValueExpanderEClass, LocalMappedAttributeValueExpander.class, "LocalMappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValuePrependerEClass, MappedAttributeValuePrepender.class, "MappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValueAppenderEClass, MappedAttributeValueAppender.class, "MappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueExpanderEClass, ExternalMappedAttributeValueExpander.class, "ExternalMappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValuePrependerEClass, ExternalMappedAttributeValuePrepender.class, "ExternalMappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueAppenderEClass, ExternalMappedAttributeValueAppender.class, "ExternalMappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
			 "documentation", "This package contains all elements related to the description of MappingHints (i.e. related to the description of \'extended\' mappings)."
		   });	
		addAnnotation
		  (mappingHintBaseTypeEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super-type for all MappingHints."
		   });	
		addAnnotation
		  (mappingHintTypeEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super-type for all MappingHints."
		   });	
		addAnnotation
		  (mappingHintEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super-type for all MappingHints that can be used in MappingHintGroups."
		   });	
		addAnnotation
		  (getMappingHint__ValidateOverwritesValidMappingHint__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if (this.overwrite == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\n\tboolean ret = true;\r\n\t\tString message = \"\";\r\n\r\n\tif (this.eClass() != this.overwrite.eClass()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"MappingHints must only overwrite MappingHints of the same type!\";\r\n\t\t}\r\n\r\n\tif (((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getExtend().isEmpty()\r\n\t\t\t\t|| ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getExtend().stream()\r\n\t\t\t\t\t\t.noneMatch(hg -> hg.getAllMappingHints().contains(this.overwrite))) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"The overwritten <%pamtram.mapping.extended.MappingHint%> is not part of a MappingHintGroup that is extended by the HintGroup containing this MappingHint!\";\r\n\t\t}\r\n\r\n\tif (this instanceof <%pamtram.mapping.extended.AttributeMapping%>\r\n\t\t\t\t&& ((<%pamtram.mapping.extended.AttributeMapping%>) this).getTarget() != ((<%pamtram.mapping.extended.AttributeMapping%>) this.overwrite).getTarget()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"An <%pamtram.mapping.extended.AttributeMapping%> must only overwrite another <%pamtram.mapping.extended.AttributeMapping%> pointing to the same TargetSectionAttribute!\";\r\n\t\t} else if (this instanceof <%pamtram.mapping.extended.CardinalityMapping%>\r\n\t\t\t\t&& ((<%pamtram.mapping.extended.CardinalityMapping%>) this).getTarget() != ((<%pamtram.mapping.extended.CardinalityMapping%>) this.overwrite).getTarget()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"A <%pamtram.mapping.extended.CardinalityMapping%> must only overwrite another <%pamtram.mapping.extended.CardinalityMapping%> pointing to the same TargetSectionClass!\";\r\n\t\t} else if (this instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%> && ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) this)\r\n\t\t\t\t.getAffectedReference() != ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) this.overwrite).getAffectedReference()) {\r\n\t\t\tret = false;\r\n\t\t\tmessage = \"A <%pamtram.mapping.extended.ReferenceTargetSelector%> must only overwrite another <%pamtram.mapping.extended.ReferenceTargetSelector%> pointing to the same TargetSectionReference!\";\r\n\t\t}\r\n\r\n\tif (!ret && diagnostics != null) {\r\n\t\t\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.MAPPING_HINT__VALIDATE_OVERWRITES_VALID_MAPPING_HINT, message,\r\n\t\t\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.MAPPING_HINT__OVERWRITE }));\r\n\t\t}\r\n\r\n\treturn ret;"
		   });	
		addAnnotation
		  (getMappingHint__ValidateConsiderOverwritingHint__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if (!(this.eContainer instanceof <%pamtram.mapping.MappingHintGroupType%>) || this.overwrite != null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tList<<%pamtram.mapping.extended.MappingHint%>> hintsOfExtendedHintGroups = ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getExtend().stream()\r\n\t\t\t\t.flatMap(hg -> hg.getMappingHints().stream()).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\tif (hintsOfExtendedHintGroups.isEmpty()) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tOptional<<%pamtram.mapping.extended.MappingHint%>> hintToConsider = <%java.util.Optional%>.empty();\r\n\r\tif (this instanceof <%pamtram.mapping.extended.AttributeMapping%> && ((<%pamtram.mapping.extended.AttributeMapping%>) this).getTarget() != null) {\r\n\r\t\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -> h instanceof <%pamtram.mapping.extended.AttributeMapping%>)\r\n\t\t\t\t\t.filter(h -> ((<%pamtram.mapping.extended.AttributeMapping%>) this).getTarget().equals(((<%pamtram.mapping.extended.AttributeMapping%>) h).getTarget()))\r\n\t\t\t\t\t.findAny();\r\n\r\t} else if (this instanceof <%pamtram.mapping.extended.CardinalityMapping%> && ((<%pamtram.mapping.extended.CardinalityMapping%>) this).getTarget() != null) {\r\n\r\t\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -> h instanceof <%pamtram.mapping.extended.CardinalityMapping%>)\r\n\t\t\t\t\t.filter(h -> ((<%pamtram.mapping.extended.CardinalityMapping%>) this).getTarget().equals(((<%pamtram.mapping.extended.CardinalityMapping%>) h).getTarget()))\r\n\t\t\t\t\t.findAny();\r\n\r\t} else if (this instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%>\r\n\t\t\t\t&& ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) this).getAffectedReference() != null) {\r\n\r\t\thintToConsider = hintsOfExtendedHintGroups.stream().filter(h -> h instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%>)\r\n\t\t\t\t\t.filter(h -> ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) this).getAffectedReference()\r\n\t\t\t\t\t\t\t.equals(((<%pamtram.mapping.extended.ReferenceTargetSelector%>) h).getAffectedReference()))\r\n\t\t\t\t\t.findAny();\r\n\t\t}\r\n\r\tif (!hintToConsider.isPresent()) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tString message = \"The hint \'\" + hintToConsider.get().getName() + \"\' of the extended MappingHintGroup \"\r\n\t\t\t\t+ (hintToConsider.get().eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>\r\n\t\t\t\t\t\t? \"\'\" + ((<%pamtram.mapping.MappingHintGroupType%>) hintToConsider.get().eContainer()).getName() + \"\' \"\r\n\t\t\t\t\t\t: \"\")\r\n\t\t\t\t+ \"affects the same target element. Consider overwriting this hint instead of providing additional hint values...\";\r\n\r\tif (diagnostics != null) {\r\n\t\t\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.WARNING, <%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.MAPPING_HINT__VALIDATE_CONSIDER_OVERWRITING_HINT, message,\r\n\t\t\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.MAPPING_HINT__OVERWRITE }));\r\n\t\t}\r\n\r\treturn false;"
		   });	
		addAnnotation
		  (getMappingHint_Overwrite(), 
		   source, 
		   new String[] {
			 "documentation", "A MappingHint from an extended MappingHintGroup that shall not be added to this MappingHintGroup but be overwritten instead.",
			 "propertyDescriptor", "// ContainerSelectors will always overwrite extended Selectors so they do not need this descriptor\n//\nif (!(object instanceof <%pamtram.mapping.extended.ContainerSelector%>)) {\n\n\tthis.itemPropertyDescriptors.add(new ItemPropertyDescriptor(\n\t\t\t((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) this.adapterFactory).getRootAdapterFactory(),\n\t\t\tthis.getResourceLocator(), this.getString(\"_UI_MappingHint_overwrite_feature\"),\n\t\t\tthis.getString(\"_UI_MappingHint_overwrite_description\"),\n\t\t\t<%pamtram.mapping.extended.ExtendedPackage%>.Literals.MAPPING_HINT__OVERWRITE, true, false, true, null,\n\t\t\tthis.getString(\"_UI_ExtendedPropertyCategory\"), null) {\n\n\t\t@Override\n\t\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\n\n\t\t\t<%pamtram.mapping.extended.MappingHint%> hint = (<%pamtram.mapping.extended.MappingHint%>) object;\n\t\t\tif (!(hint.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>)) {\n\t\t\t\treturn new <%java.util.ArrayList%><>();\n\t\t\t}\n\n\t\t\t<%java.util.Set%><<%pamtram.mapping.extended.MappingHint%>> possibleOverwrites = ((<%pamtram.mapping.MappingHintGroupType%>) hint.eContainer()).getExtend()\n\t\t\t\t\t.stream().flatMap(h -> h.getAllMappingHints().stream())\n\t\t\t\t\t.filter(h -> hint.eClass().equals(h.eClass()))\n\t\t\t\t\t.collect(<%java.util.stream.Collectors%>.toCollection(java.util.LinkedHashSet::new));\n\n\t\t\tif (hint instanceof <%pamtram.mapping.extended.AttributeMapping%>) {\n\t\t\t\t<%pamtram.mapping.extended.AttributeMapping%> attributeMapping = (<%pamtram.mapping.extended.AttributeMapping%>) hint;\n\t\t\t\tif (attributeMapping.getTarget() == null) {\n\t\t\t\t\treturn new <%java.util.ArrayList%><>();\n\t\t\t\t} else {\n\t\t\t\t\treturn possibleOverwrites.stream().map(h -> (<%pamtram.mapping.extended.AttributeMapping%>) h)\n\t\t\t\t\t\t\t.filter(am -> attributeMapping.getTarget().equals(am.getTarget()))\n\t\t\t\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\n\t\t\t\t}\n\t\t\t} else if (hint instanceof <%pamtram.mapping.extended.CardinalityMapping%>) {\n\t\t\t\t<%pamtram.mapping.extended.CardinalityMapping%> cardinalityMapping = (<%pamtram.mapping.extended.CardinalityMapping%>) hint;\n\t\t\t\tif (cardinalityMapping.getTarget() == null) {\n\t\t\t\t\treturn new <%java.util.ArrayList%><>();\n\t\t\t\t} else {\n\t\t\t\t\treturn possibleOverwrites.stream().map(h -> (<%pamtram.mapping.extended.CardinalityMapping%>) h)\n\t\t\t\t\t\t\t.filter(cm -> cardinalityMapping.getTarget().equals(cm.getTarget()))\n\t\t\t\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\n\t\t\t\t}\n\t\t\t} else if (hint instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%>) {\n\t\t\t\t<%pamtram.mapping.extended.ReferenceTargetSelector%> referenceTargetSelector = (<%pamtram.mapping.extended.ReferenceTargetSelector%>) hint;\n\t\t\t\tif (referenceTargetSelector.getAffectedReference() == null) {\n\t\t\t\t\treturn new <%java.util.ArrayList%><>();\n\t\t\t\t} else {\n\t\t\t\t\treturn possibleOverwrites.stream().map(h -> (<%pamtram.mapping.extended.ReferenceTargetSelector%>) h)\n\t\t\t\t\t\t\t.filter(rts -> referenceTargetSelector.getAffectedReference()\n\t\t\t\t\t\t\t\t\t.equals(rts.getAffectedReference()))\n\t\t\t\t\t\t\t.collect(<%java.util.stream.Collectors%>.toList());\n\t\t\t\t}\n\t\t\t} else if (hint instanceof <%pamtram.mapping.extended.ContainerSelector%>) {\n\t\t\t\treturn new <%java.util.ArrayList%><>(possibleOverwrites);\n\t\t\t} else {\n\t\t\t\treturn new <%java.util.ArrayList%><>();\n\t\t\t}\n\t\t}\n\t});\n}"
		   });	
		addAnnotation
		  (expandableHintEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super-type for all MappingHints that can be defined in ExportedMappingHintGroups and afterwards refined/expanded in MappingHintGroupImporters."
		   });	
		addAnnotation
		  (hintImporterMappingHintEClass, 
		   source, 
		   new String[] {
			 "documentation", "An abstract super-type for all MappingHints that can be used in MappingHintGroupImporters."
		   });	
		addAnnotation
		  (mappingHintSourceInterfaceEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common superclass of all types that can be used as \'sourceElement\' to calculate the value of a MappingHint."
		   });	
		addAnnotation
		  (globalAttributeImporterEClass, 
		   source, 
		   new String[] {
			 "documentation", "This specifies a source element whose value is based on the value of a GlobalAttribute. GlobalAttributes can thereby be used to store the value of a SourceSectionAttribute in a reusable way.\r\n<br />\r\nThe value of a GlobalAttribute can thereby be reused in various calculations (e.g. in AttributeMappings). In contrast to the \'local\' usage of an Attribute value in a calculation, GlobalAttributes can be reused as part of any Mapping - the Attribute does not need to be part of the SourceSection associated with the Mapping."
		   });	
		addAnnotation
		  (getGlobalAttributeImporter_GlobalAttribute(), 
		   source, 
		   new String[] {
			 "documentation", "The GlobalAttribute based on which the value of this element is determined."
		   });	
		addAnnotation
		  (attributeMappingEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingHint that tells the transformation algorithm how determine the value of a TargetSectionAttribute in the course of a transformation.\r\n<br /><br />\r\nThe value is thereby determined based on the list of specified \'sourceElements\' and an optional (mathematical) \'expression\'.\r\n<br />\r\nIf the expression is not present, the values of all specified source elements are treated as Strings and simply concatenated.\r\n<br />\r\nIf an expression is present, this will be used to calculate the value. The expression may thereby reference the (numeric) values of the specified source elements via their name. For example, if a source element named \'x\' is specified, a valid expression to double the value of this element would be \"2*x\".\r\n<br /><br />\r\nNote: As SourceSectionAttributes may be matched multiple times in a single source model excerpt, an AttributeMapping based on such a source element may result in multiple determined values. If this is the case, the specified \'target\' attribute (and if necessary the containing TargetSectionClass) will be instantiated multiple times."
		   });	
		addAnnotation
		  (getAttributeMapping__GetLocalSourceElements(), 
		   source, 
		   new String[] {
			 "body", "\t\tEList<AttributeMappingSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingSourceElement>();\r\n\t\t\r\n\t\tfor(AttributeMappingSourceInterface i : this.getSourceElements()){\r\n\t\t\tif(i instanceof AttributeMappingSourceElement){\r\n\t\t\t\telements.add((AttributeMappingSourceElement) i);\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn elements;"
		   });	
		addAnnotation
		  (getAttributeMapping__GetExternalSourceElements(), 
		   source, 
		   new String[] {
			 "body", "EList<AttributeMappingExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingExternalSourceElement>();\r\n\r\nfor(AttributeMappingSourceInterface i : this.getSourceElements()){\r\n\tif(i instanceof AttributeMappingExternalSourceElement){\r\n\t\telements.add((AttributeMappingExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;"
		   });	
		addAnnotation
		  (getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if(this.getTarget() == null || !(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.mapping.MappingHintGroupType%> containingHintGroup = ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer());\r\n\r\nboolean result = this.getTarget().getContainingSection() == containingHintGroup.getTargetSection() || containingHintGroup.getTargetSection().getAllExtend().contains(this.getTarget().getContainingSection());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target attribute \'\" + this.getTarget().getName() + \"\' is not part of the target section referenced by parent hint group \" + ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getName() + \"!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.ATTRIBUTE_MAPPING__VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.ATTRIBUTE_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getAttributeMapping_Target(), 
		   source, 
		   new String[] {
			 "documentation", "The TargetSectionAttribute whose value is determined by this AttributeMapping."
		   });	
		addAnnotation
		  (getAttributeMapping_SourceElements(), 
		   source, 
		   new String[] {
			 "documentation", "The list of \'sourceElements\' based on which the value of the \'target\' Attribute is determined."
		   });	
		addAnnotation
		  (attributeMappingSourceInterfaceEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common superclass of all types that can be used as \'sourceElement\' in an AttributeMapping."
		   });	
		addAnnotation
		  (attributeMappingSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' for an AttributeMapping.\r\n<br />\r\nThis type is based on the value of a \'local\' SourceSectionAttribute.\r\n<br /><br />\r\nNote: See the documentation of \'LocalDynamicSourceElement\' for a detailed explanation of the meaning of \'local\' source elements."
		   });	
		addAnnotation
		  (attributeMappingExternalSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' for an AttributeMapping.\r\n<br />\r\nThis type is based on the value of an \'external\' SourceSectionAttribute.\r\n<br /><br />\r\nNote: See the documentation of \'ExternalDynamicSourceElement\' for a detailed explanation of the meaning of \'external\' source elements."
		   });	
		addAnnotation
		  (attributeMappingGlobalSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' for an AttributeMapping.\r\n<br />\r\nThis type is based on the value of a \'global\' SourceSectionAttribute.\r\n<br /><br />\r\nNote: See the documentation of \'GlobalDynamicSourceElement\' for a detailed explanation of the meaning of \'global\' source elements."
		   });	
		addAnnotation
		  (cardinalityMappingEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingHint that tells the transformation algorithm how determine the cardinality of a TargetSectionClass (how often the Class shall be instantiated) in the course of a transformation.\r\n<br /><br />\r\nThe value is thereby determined based on one of two possibilities:\r\n<br />\r\n(1) Based on the list of specified \'sourceElements\' and an optional (mathematical) \'expression\'.\r\n<br />\r\nIf the expression is not present, the values of all specified source elements are treated as Strings and simply concatenated.\r\n<br />\r\nIf an expression is present, this will be used to calculate the value. The expression may thereby reference the (numeric) values of the specified source elements via their name. For example, if a source element named \'x\' is specified, a valid expression to double the value of this element would be \"2*x\".\r\n<br />\r\n(1) Base on the cardinality of the specified \'source\'.\r\n<br /><br />\r\nNote: Only one of \'sourceElements\' or \'source\' may be specified!"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateSourceElementMatchesSectionOrContainedSection__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif (this.getSource() == null || !(this.eContainer().eContainer() instanceof <%pamtram.mapping.Mapping%>)\r\n\t\t|| ((Mapping) this.eContainer().eContainer()).getSourceSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nMapping mapping = (Mapping) this.eContainer().eContainer();\r\n\r\nboolean result = false;\r\n\r\npamtram.structure.generic.Class<?, ?, ?, ?> relevantClass = mapping.getSourceSection();\r\n\r\n// iterate over all elements and return the attributes as possible options\r\n//\r\n<%java.util.Set%><pamtram.structure.generic.Class<?, ?, ?, ?>> scanned = new <%java.util.HashSet%><>();\r\n<%java.util.List%><pamtram.structure.generic.Class<?, ?, ?, ?>> sectionsToScan = new <%java.util.ArrayList%><>();\r\nsectionsToScan.add(relevantClass);\r\n\r\n// also regard abstract sections that this extends\r\nif (relevantClass instanceof <%pamtram.structure.generic.Section%>) {\r\n\tsectionsToScan.addAll(((Section<?, ?, ?, ?>) relevantClass).getAllExtend());\r\n}\r\n\r\nwhile (!sectionsToScan.isEmpty()) {\r\n\tpamtram.structure.generic.Class<?, ?, ?, ?> classToScan = sectionsToScan.remove(0);\r\n\tscanned.add(classToScan);\r\n\r\n\t<%java.util.Iterator%><<%org.eclipse.emf.ecore.EObject%>> it = classToScan.eAllContents();\r\n\twhile (it.hasNext()) {\r\n\t\tEObject next = it.next();\r\n\t\tif (this.getSource().equals(next)) {\r\n\t\t\tresult = true;\r\n\t\t\tbreak;\r\n\t\t} else if (next instanceof <%pamtram.structure.generic.CrossReference%>) {\r\n\t\t\tList<<%pamtram.structure.source.SourceSectionClass%>> vals = new ArrayList<>();\r\n\t\t\tvals.addAll(((CrossReference) next).getValue());\r\n\t\t\tvals.removeAll(scanned);\r\n\t\t\tsectionsToScan.addAll(vals);\r\n\t\t}\r\n\t}\r\n}\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source element \'\" + this.getSource().getName()\r\n\t\t\t+ \"\' is not part of the source section referenced by parent mapping \'\" + mapping.getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION_OR_CONTAINED_SECTION,\r\n\t\t\terrorMessage, new Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if (this.getTarget() == null || !(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>)\r\n\t\t\t\t|| ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getTargetSection() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\t\t\r\n\t\t<%pamtram.mapping.MappingHintGroupType%> mappingHintGroup = (<%pamtram.mapping.MappingHintGroupType%>) this.eContainer();\r\n\r\tboolean result = this.getTarget().getContainingSection() == mappingHintGroup\r\n\t\t\t\t.getTargetSection() || mappingHintGroup.getAllExtend().contains(this.getTarget().getContainingSection());\r\n\r\tif (!result && diagnostics != null) {\r\n\r\t\tString errorMessage = \"The target class \'\" + this.getTarget().getName()\r\n\t\t\t\t\t+ \"\' is not part of the target section referenced by parent hint group \'\"\r\n\t\t\t\t\t+ mappingHintGroup.getName() + \"\'!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\t}\r\n\r\treturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateSourceClassIsVariableCardinality__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getSource() == null || !(this.getSource() instanceof SourceSectionClass) ? true : ((SourceSectionClass) this.getSource()).getCardinality() != CardinalityType.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for source classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateTargetClassIsVariableCardinality__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getTarget() == null ? true : this.getTarget().getCardinality() != <%pamtram.structure.generic.CardinalityType%>.ONE;\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings may only be defined for target classes with a specified cardinality distinct from \'CardinalityType::ONE\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateNoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getSource() == null ? true : this.getSource() != this.getSource().getContainingSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"Cardinality mappings must not be defined for SourceSection root classes!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateOnlySourceOrSourceElements__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getSource() == null || this.getSourceElements() == null || this.getSourceElements().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must not specify both a \'source\' and a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateExpressionOnlyForSourceElements__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = !this.getSourceElements().isEmpty() || this.expression.isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must only specify an \'expression\' if it also specifies a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateModifiersOnlyForSourceElements__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = !this.getSourceElements().isEmpty() || this.getModifiers().isEmpty();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"A CardinalityMapping must only specify \'modifiers\' if it also specifies a set of \'sourceElements\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_MODIFIERS_ONLY_FOR_SOURCE_ELEMENTS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__GetLocalSourceElements(), 
		   source, 
		   new String[] {
			 "body", "return new <%org.eclipse.emf.common.util.BasicEList%><>(this.getSourceElements().stream().filter(s -> s instanceof CardinalityMappingSourceElement).map(s -> (CardinalityMappingSourceElement) s).collect(<%java.util.stream.Collectors%>.toList()));"
		   });	
		addAnnotation
		  (getCardinalityMapping__GetExternalSourceElements(), 
		   source, 
		   new String[] {
			 "body", "return new <%org.eclipse.emf.common.util.BasicEList%><>(this.getSourceElements().stream().filter(s -> s instanceof CardinalityMappingExternalSourceElement).map(s -> (CardinalityMappingExternalSourceElement) s).collect(<%java.util.stream.Collectors%>.toList()));"
		   });	
		addAnnotation
		  (getCardinalityMapping_Source(), 
		   source, 
		   new String[] {
			 "documentation", "The (optional) \'source\' element whose cardinality is used to determine the cardinality of the \'target\' Class."
		   });	
		addAnnotation
		  (getCardinalityMapping_Target(), 
		   source, 
		   new String[] {
			 "documentation", "The TargetSectionClass whose cardinality is determined by this CardinalityMapping."
		   });	
		addAnnotation
		  (getCardinalityMapping_SourceElements(), 
		   source, 
		   new String[] {
			 "documentation", "The (optional) list of \'sourceElements\' based on which the cardinality of the \'target\' Class is determined."
		   });	
		addAnnotation
		  (cardinalityMappingSourceInterfaceEClass, 
		   source, 
		   new String[] {
			 "documentation", "The common superclass of all types that can be used as \'sourceElement\' in a CardinalityMapping."
		   });	
		addAnnotation
		  (cardinalityMappingSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' for a CardinalityMapping.\r\n<br />\r\nThis type is based on the value of a \'local\' SourceSectionAttribute.\r\n<br /><br />\r\nNote: See the documentation of \'LocalDynamicSourceElement\' for a detailed explanation of the meaning of \'local\' source elements."
		   });	
		addAnnotation
		  (cardinalityMappingExternalSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' for a CardinalityMapping.\r\n<br />\r\nThis type is based on the value of an \'external\' SourceSectionAttribute.\r\n<br /><br />\r\nNote: See the documentation of \'ExternalDynamicSourceElement\' for a detailed explanation of the meaning of \'external\' source elements."
		   });	
		addAnnotation
		  (cardinalityMappingGlobalSourceElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "A concrete type of \'sourceElement\' for a CardinalityMapping.\r\n<br />\r\nThis type is based on the value of a \'global\' SourceSectionAttribute.\r\n<br /><br />\r\nNote: See the documentation of \'GlobalDynamicSourceElement\' for a detailed explanation of the meaning of \'global\' source elements."
		   });	
		addAnnotation
		  (referenceTargetSelectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingHint that tells the transformation algorithm how determine the target value(s)/instance(s) of a TargetSectionCrossReference in the course of a transformation.\r\n<br /><br />\r\nThe target instances are thereby determined based on the specified \'matcher\'."
		   });	
		addAnnotation
		  (getReferenceTargetSelector__ValidateAffectedReferenceIsNonContainment__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nboolean result = this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null ? true : !this.getAffectedReference().getEReference().isContainment();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The affected reference \'\" + this.getAffectedReference().getName() + \"\' is no non-containment reference!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getReferenceTargetSelector__ValidateAffectedReferenceMatchesSection__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if(this.getAffectedReference() == null) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.target.TargetSection%> targetSection = this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%> ? ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getTargetSection() : ((<%pamtram.mapping.MappingHintGroupImporter%>) this.eContainer()).getHintGroup().getTargetSection();\r\n\r\nboolean result = targetSection == null ? true : this.getAffectedReference().getContainingSection() == targetSection || targetSection.getAllExtend().contains(this.getAffectedReference().getContainingSection());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString hintGroupName = this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%> ? ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getName() : ((<%pamtram.mapping.MappingHintGroupImporter%>) this.eContainer()).getHintGroup().getName();\r\n\tString errorMessage = \"The affected reference \'\" + this.getAffectedReference().getName() + \"\' is not part of the target section referenced by parent hint group \'\" + hintGroupName + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getReferenceTargetSelector__ValidateTargetClass__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "// If an \'affectedReference\' has already been set for this \'TargetInstanceSelector\', allow only\r\n\t\t// those choices\r\n\t\t// that are compatible with the selected reference.\r\n\t\t//\r\n\t\tif (this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null\r\n\t\t\t\t|| this.getTargetClass() == null || this.getTargetClass().getEClass() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tboolean result = this.getAffectedReference().getEReference().getEReferenceType()\r\n\t\t\t\t.isSuperTypeOf(this.targetClass.getEClass());\r\n\r\tif (!result && diagnostics != null) {\r\n\r\t\tString errorMessage = \"The specified \'targetClass\' is not compatible with the specified \'affectedReference\'!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR, <%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.REFERENCE_TARGET_SELECTOR__VALIDATE_TARGET_CLASS, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, <%pamtram.structure.StructurePackage%>.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));\r\n\t\t}\r\n\r\treturn result;"
		   });	
		addAnnotation
		  (getReferenceTargetSelector_AffectedReference(), 
		   source, 
		   new String[] {
			 "documentation", "The TargetSectionCrossReference whose target values are determined by this ReferenceTargetSelector.",
			 "propertyDescriptor", "this.itemPropertyDescriptors.add(new ItemPropertyDescriptor(\n\t\t((<%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%>) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),\n\t\tthis.getString(\"_UI_ReferenceTargetSelector_affectedReference_feature\"),\n\t\tthis.getString(\"_UI_ReferenceTargetSelector_affectedReference_description\"),\n\t\t<%pamtram.mapping.extended.ExtendedPackage%>.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE, true, false, true, null,\n\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\n\n\t@Override\n\tpublic <%java.util.Collection%><?> getChoiceOfValues(Object object) {\n\n\t\t<%pamtram.structure.target.TargetSection%> target;\n\t\tif (((<%pamtram.mapping.extended.ReferenceTargetSelector%>) object).eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) {\n\t\t\ttarget = ((<%pamtram.mapping.MappingHintGroupType%>) ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) object).eContainer())\n\t\t\t\t\t.getTargetSection();\n\t\t} else {\n\t\t\ttarget = ((<%pamtram.mapping.MappingHintGroupImporter%>) ((<%pamtram.mapping.extended.ReferenceTargetSelector%>) object).eContainer()).getHintGroup()\n\t\t\t\t\t.getTargetSection();\n\t\t}\n\n\t\treturn <%java.util.stream.Stream%>.concat(<%java.util.Arrays%>.asList(target).stream(), target.getAllExtend().stream()).flatMap(t -> {\n\n\t\t\t<%java.util.List%><<%org.eclipse.emf.ecore.EObject%>> vals = new <%java.util.ArrayList%><>();\n\t\t\torg.eclipse.emf.common.util.TreeIterator<<%org.eclipse.emf.ecore.EObject%>> it = t.eAllContents();\n\n\t\t\twhile (it.hasNext()) {\n\t\t\t\t<%org.eclipse.emf.ecore.EObject%> next = it.next();\n\t\t\t\tif (next instanceof pamtram.structure.target.TargetSectionCrossReference) {\n\t\t\t\t\tvals.add(next);\n\t\t\t\t}\n\t\t\t}\n\n\t\t\treturn vals.stream();\n\t\t}).collect(<%java.util.stream.Collectors%>.toList());\n\n\t}\n\n});"
		   });	
		addAnnotation
		  (containerSelectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingHint that tells the transformation algorithm how to determine the container element for the instances created based on the TargetSection associated with this HintGroup in the course of a transformation.\r\n<br /><br />\r\nThereby, exactly one of the elements that have been created based on the specified \'targetAttributes\' (resp. the containing TargetSectionClasses) is used as container element.\r\n<br />\r\nThe selection of the container element is based on the comparison of the value of a the \'targetAttributes\' of the created instances with a reference value. The reference value is thereby calculated based on the list of specified \'sourceElements\'."
		   });	
		addAnnotation
		  (getContainerSelector__ValidateTargetClassMatchesPossibleContainerType__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "if (!(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || this.getTargetClass() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\t<%pamtram.structure.target.TargetSection%> targetSection = ((<%pamtram.mapping.MappingHintGroupType%>) this.eContainer()).getTargetSection();\r\n\r\tif (targetSection == null || targetSection.getEClass() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tboolean result = this.getTargetClass().getEClass().getEAllContainments().parallelStream()\r\n\t\t\t\t.anyMatch(r -> r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));\r\n\r\tif (!result && diagnostics != null) {\r\n\r\t\tint severity = <%org.eclipse.emf.common.util.Diagnostic%>.ERROR;\r\n\t\t\tString errorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t\t\t+ this.getTargetClass().getName() + \"\')!\";\r\n\r\t\t// If the <%pamtram.structure.target.TargetSection%> is abstract, we need to check if there are some concrete sub-Sections that may act\r\n\t\t\t// as container\r\n\t\t\t//\r\n\t\t\tif (this.getTargetClass().getContainingSection().isAbstract()) {\r\n\r\t\t\tList<<%pamtram.structure.target.TargetSection%>> extendingSections = <%org.eclipse.emf.ecore.util.EcoreUtil%>.UsageCrossReferencer\r\n\t\t\t\t\t\t.find(this.getTargetClass().getContainingSection(), this.eResource().getResourceSet())\r\n\t\t\t\t\t\t.parallelStream()\r\n\t\t\t\t\t\t.filter(s -> pamtram.structure.generic.GenericPackage.Literals.SECTION__EXTEND.equals(s.getEStructuralFeature()))\r\n\t\t\t\t\t\t.map(s -> (<%pamtram.structure.target.TargetSection%>) s.getEObject()).collect(<%java.util.stream.Collectors%>.toList());\r\n\r\t\t\tif (extendingSections.stream()\r\n\t\t\t\t\t\t.anyMatch(concreteSection -> concreteSection.getEClass().getEAllContainments().parallelStream()\r\n\t\t\t\t\t\t\t\t.anyMatch(r -> r.getEReferenceType().isSuperTypeOf(targetSection.getEClass())))) {\r\n\t\t\t\t\tseverity = <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\r\n\t\t\t\t\terrorMessage = \"The type of the parent hint group\'s target section (\'\"\r\n\t\t\t\t\t\t\t+ targetSection.getEClass().getName()\r\n\t\t\t\t\t\t\t+ \"\') cannot be connected to (contained in) the specified target class (\'\"\r\n\t\t\t\t\t\t\t+ this.getTargetClass().getName()\r\n\t\t\t\t\t\t\t+ \"\'). However, there are some concrete sub-classes that are valid containers and will be used instead!\";\r\n\t\t\t\t}\r\n\t\t\t}\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(severity, <%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.CONTAINER_SELECTOR__VALIDATE_TARGET_CLASS_MATCHES_POSSIBLE_CONTAINER_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\t\t\tnew Object[] { this, <%pamtram.structure.StructurePackage%>.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));\r\n\r\t}\r\n\r\treturn result;"
		   });	
		addAnnotation
		  (mappedAttributeValueExpanderEClass, 
		   source, 
		   new String[] {
			 "documentation", "A common super-class for MappingHints that can be used inside MappingHintGroupImporters and will expand values determined for an imported MappingHint."
		   });	
		addAnnotation
		  (getMappedAttributeValueExpander__GetSourceAttribute(), 
		   source, 
		   new String[] {
			 "body", "if(this instanceof LocalMappedAttributeValueExpander) {\r\n\treturn ((LocalMappedAttributeValueExpander) this).getSource();\r\n} else if(this instanceof ExternalMappedAttributeValueExpander) {\r\n\treturn ((ExternalMappedAttributeValueExpander) this).getSource();\r\n} else {\r\n\treturn null;\r\n}"
		   });	
		addAnnotation
		  (getMappedAttributeValueExpander_HintsToExpand(), 
		   source, 
		   new String[] {
			 "documentation", "The MappingHint for which determined values are expanded by this Expander."
		   });	
		addAnnotation
		  (localMappedAttributeValueExpanderEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified local \'source\' Attribute."
		   });	
		addAnnotation
		  (mappedAttributeValuePrependerEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified local \'source\' Attribute.\r\n<br /><br />\r\nThe local determined values will thereby be prepended to the imported values."
		   });	
		addAnnotation
		  (mappedAttributeValueAppenderEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified local \'source\' Attribute.\r\n<br /><br />\r\nThe local determined values will thereby be appended to the imported values."
		   });	
		addAnnotation
		  (externalMappedAttributeValueExpanderEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified external \'source\' Attribute."
		   });	
		addAnnotation
		  (externalMappedAttributeValuePrependerEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified external \'source\' Attribute.\r\n<br /><br />\r\nThe external determined values will thereby be appended to the imported values."
		   });	
		addAnnotation
		  (externalMappedAttributeValueAppenderEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified external \'source\' Attribute.\r\n<br /><br />\r\nThe external determined values will thereby be appended to the imported values."
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
		  (attributeMappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "targetAttributeMatchesSection"
		   });	
		addAnnotation
		  (cardinalityMappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceClassMatchesSection sourceClassIsVariableCardinality targetClassMatchesSection targetClassIsVariableCardinality noCardinalityMappingForSourceSectionRoot"
		   });	
		addAnnotation
		  (referenceTargetSelectorEClass, 
		   source, 
		   new String[] {
			 "constraints", "affectedReferenceIsNonContainment affectedReferenceMatchesSection"
		   });	
		addAnnotation
		  (containerSelectorEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceMatchesPossibleContainerType"
		   });
	}

} //ExtendedPackageImpl
