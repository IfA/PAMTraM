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
import pamtram.mapping.extended.AttributeMatcher;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingExternalSourceElement;
import pamtram.mapping.extended.CardinalityMappingGlobalSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceInterface;
import pamtram.mapping.extended.ClassMatcher;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ContainerSelectorTargetAttribute;
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
import pamtram.mapping.extended.Matcher;
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
	private EClass matcherEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classMatcherEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMatcherEClass = null;
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
	private EClass containerSelectorTargetAttributeEClass = null;
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
	public EOperation getCardinalityMapping__ValidateSourceElementMatchesSection__DiagnosticChain_Map() {
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
	public EReference getReferenceTargetSelector_Matcher() {
		return (EReference)referenceTargetSelectorEClass.getEStructuralFeatures().get(1);
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
	public EClass getMatcher() {
		return matcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassMatcher() {
		return classMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassMatcher_TargetClass() {
		return (EReference)classMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMatcher() {
		return attributeMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMatcher_Target() {
		return (EReference)attributeMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMatcher__ValidateTargetMatchesAffectedReferenceType__DiagnosticChain_Map() {
		return attributeMatcherEClass.getEOperations().get(0);
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
	public EReference getContainerSelector_TargetAttributes() {
		return (EReference)containerSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerSelectorTargetAttribute() {
		return containerSelectorTargetAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainerSelectorTargetAttribute__ValidateSourceMatchesPossibleContainerType__DiagnosticChain_Map() {
		return containerSelectorTargetAttributeEClass.getEOperations().get(0);
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
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);
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
		createEReference(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR__MATCHER);
		createEOperation(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP);
		createEOperation(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP);

		matcherEClass = createEClass(MATCHER);

		classMatcherEClass = createEClass(CLASS_MATCHER);
		createEReference(classMatcherEClass, CLASS_MATCHER__TARGET_CLASS);

		attributeMatcherEClass = createEClass(ATTRIBUTE_MATCHER);
		createEReference(attributeMatcherEClass, ATTRIBUTE_MATCHER__TARGET);
		createEOperation(attributeMatcherEClass, ATTRIBUTE_MATCHER___VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP);

		containerSelectorEClass = createEClass(CONTAINER_SELECTOR);
		createEReference(containerSelectorEClass, CONTAINER_SELECTOR__TARGET_ATTRIBUTES);

		containerSelectorTargetAttributeEClass = createEClass(CONTAINER_SELECTOR_TARGET_ATTRIBUTE);
		createEOperation(containerSelectorTargetAttributeEClass, CONTAINER_SELECTOR_TARGET_ATTRIBUTE___VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP);

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
		classMatcherEClass.getESuperTypes().add(this.getMatcher());
		attributeMatcherEClass.getESuperTypes().add(this.getMatcher());
		attributeMatcherEClass.getESuperTypes().add(this.getExpandableHint());
		attributeMatcherEClass.getESuperTypes().add(theStructurePackage.getInstanceSelector());
		containerSelectorEClass.getESuperTypes().add(this.getMappingHint());
		containerSelectorEClass.getESuperTypes().add(theStructurePackage.getInstanceSelector());
		g1 = createEGenericType(theStructurePackage.getDynamicSourceElement());
		g2 = createEGenericType(theTargetPackage.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theTargetPackage.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theTargetPackage.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theTargetPackage.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		containerSelectorTargetAttributeEClass.getEGenericSuperTypes().add(g1);
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

		EOperation op = initEOperation(getAttributeMapping__ValidateTargetAttributeMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetAttributeMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
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

		op = initEOperation(getCardinalityMapping__ValidateSourceElementMatchesSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceElementMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
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
		initEReference(getReferenceTargetSelector_Matcher(), this.getMatcher(), null, "matcher", null, 1, 1, ReferenceTargetSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(matcherEClass, Matcher.class, "Matcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classMatcherEClass, ClassMatcher.class, "ClassMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassMatcher_TargetClass(), theTargetPackage.getTargetSectionClass(), null, "targetClass", null, 1, 1, ClassMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMatcherEClass, AttributeMatcher.class, "AttributeMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMatcher_Target(), theTargetPackage.getTargetSectionAttribute(), null, "target", null, 1, 1, AttributeMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAttributeMatcher__ValidateTargetMatchesAffectedReferenceType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTargetMatchesAffectedReferenceType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containerSelectorEClass, ContainerSelector.class, "ContainerSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerSelector_TargetAttributes(), this.getContainerSelectorTargetAttribute(), null, "targetAttributes", null, 1, -1, ContainerSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerSelectorTargetAttributeEClass, ContainerSelectorTargetAttribute.class, "ContainerSelectorTargetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getContainerSelectorTargetAttribute__ValidateSourceMatchesPossibleContainerType__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceMatchesPossibleContainerType", 0, 1, IS_UNIQUE, IS_ORDERED);
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
			 "body", "\r\nif(this.getTarget() == null || !(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nMappingHintGroupType containingHintGroup = ((MappingHintGroupType) this.eContainer());\r\n\r\nboolean result = this.getTarget().getContainingSection() == containingHintGroup.getTargetSection() || containingHintGroup.getTargetSection().getExtend().contains(this.getTarget().getContainingSection());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target attribute \'\" + this.getTarget().getName() + \"\' is not part of the target section referenced by parent hint group \" + ((MappingHintGroupType) this.eContainer()).getName() + \"!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.ATTRIBUTE_MAPPING__VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.ATTRIBUTE_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;"
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
		  (getCardinalityMapping__ValidateSourceElementMatchesSection__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(this.getSource() == null || !(this.eContainer().eContainer() instanceof <%pamtram.mapping.Mapping%>) || ((Mapping) this.eContainer().eContainer()).getSourceSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSource().getContainingSection() == ((Mapping) this.eContainer().eContainer()).getSourceSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The source element \'\" + this.getSource().getName() + \"\' is not part of the source section referenced by parent mapping \'\" + ((pamtram.mapping.Mapping) this.eContainer().eContainer()).getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getCardinalityMapping__ValidateTargetClassMatchesSection__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(this.getTarget() == null || !(this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getTarget().getContainingSection() == ((MappingHintGroupType) this.eContainer()).getTargetSection();\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The target class \'\" + this.getTarget().getName() + \"\' is not part of the target section referenced by parent hint group \'\" + ((MappingHintGroupType) this.eContainer()).getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.CARDINALITY_MAPPING__TARGET }));\r\n\r\n}\r\n\r\nreturn result;"
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
			 "body", "\r\nif(this.getAffectedReference() == null) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.target.TargetSection%> targetSection = this.eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%> ? ((MappingHintGroupType) this.eContainer()).getTargetSection() : ((<%pamtram.mapping.MappingHintGroupImporter%>) this.eContainer()).getHintGroup().getTargetSection();\r\n\r\nboolean result = targetSection == null ? true : this.getAffectedReference().getContainingSection() == targetSection || targetSection.getExtend().contains(this.getAffectedReference().getContainingSection());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString hintGroupName = this.eContainer() instanceof MappingHintGroupType ? ((MappingHintGroupType) this.eContainer()).getName() : ((MappingHintGroupImporter) this.eContainer()).getHintGroup().getName();\r\n\tString errorMessage = \"The affected reference \'\" + this.getAffectedReference().getName() + \"\' is not part of the target section referenced by parent hint group \'\" + hintGroupName + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getReferenceTargetSelector_AffectedReference(), 
		   source, 
		   new String[] {
			 "documentation", "The TargetSectionCrossReference whose target values are determined by this ReferenceTargetSelector."
		   });	
		addAnnotation
		  (getReferenceTargetSelector_Matcher(), 
		   source, 
		   new String[] {
			 "documentation", "The Matcher that is used to determine the target instances for the \'affectedReference\'."
		   });	
		addAnnotation
		  (matcherEClass, 
		   source, 
		   new String[] {
			 "documentation", "A common super-class for all types that can be used to determine the target instances for a ReferenceTargetSelector."
		   });	
		addAnnotation
		  (classMatcherEClass, 
		   source, 
		   new String[] {
			 "documentation", "A ClassMatcher can be used to determine the target instance(s) for a ReferenceTargetSelector.\r\n<br />\r\nThereby, all elements that have been created based on the specified \'targetClass\' will be used as target instances.\r\n<br /><br />\r\nNote: In most cases, a simple ClassMatcher will not be sufficient if not all but only a subset of the instances created based on the denoted \'targetClass\' shall be used. For such more complex use cases, an AttributeMatcher can be used instead."
		   });	
		addAnnotation
		  (getClassMatcher_TargetClass(), 
		   source, 
		   new String[] {
			 "documentation", "The \'targetClass\' whose created instances will be used as target instances for the containing ReferenceTargetSelector."
		   });	
		addAnnotation
		  (attributeMatcherEClass, 
		   source, 
		   new String[] {
			 "documentation", "An AttributeMatcher can be used to determine the target instance(s) for a ReferenceTargetSelector.\r\n<br />\r\nThereby, a certain subset of the elements that have been created based on the specified \'target\' Attribute (resp. the containing TargetSectionClass) is used as target instances.\r\n<br />\r\nThe selection process is based on the comparison of the value of a the \'target\' attribute of the created instance with a reference value. The reference value is thereby calculated based on the list of specified \'sourceElements\'.\r\n<br /><br />\r\nNote: In cases where all instances created based on the denoted \'target\' Attribute (resp. the containing TargetSectionClass) shall be used, a simple ClassMatcher can be used instead."
		   });	
		addAnnotation
		  (getAttributeMatcher__ValidateTargetMatchesAffectedReferenceType__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(!(this.eContainer() instanceof <%pamtram.mapping.extended.ReferenceTargetSelector%>) || ((ReferenceTargetSelector) this.eContainer()).getAffectedReference() == null || ((ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference() == null || this.getTarget() == null || !(this.getTarget().eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = ((ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference().getEReferenceType().isSuperTypeOf(((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getTarget().eContainer()).getEClass());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The type of the class containing the target attribute (\'\" + \r\n\t\t\t((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getTarget().eContainer()).getEClass().getName() + \"\') is not allowed by the affected reference of the parent ReferenceTargetSelector that \" +\r\n\t\t\t\"requires a (sub-)type of \'\" + ((pamtram.mapping.extended.ReferenceTargetSelector) this.eContainer()).getAffectedReference().getEReference().getEReferenceType().getName() + \"\'!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.ATTRIBUTE_MATCHER__VALIDATE_TARGET_MATCHES_AFFECTED_REFERENCE_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.mapping.extended.ExtendedPackage%>.Literals.ATTRIBUTE_MATCHER__TARGET }));\r\n\r\n}\r\n\r\nreturn result;"
		   });	
		addAnnotation
		  (getAttributeMatcher_Target(), 
		   source, 
		   new String[] {
			 "documentation", "The specific attribute of the created TargetSections whose value is compared with the reference value used by this matcher."
		   });	
		addAnnotation
		  (containerSelectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "A MappingHint that tells the transformation algorithm how to determine the container element for the instances created based on the TargetSection associated with this HintGroup in the course of a transformation.\r\n<br /><br />\r\nThereby, exactly one of the elements that have been created based on the specified \'targetAttributes\' (resp. the containing TargetSectionClasses) is used as container element.\r\n<br />\r\nThe selection of the container element is based on the comparison of the value of a the \'targetAttributes\' of the created instances with a reference value. The reference value is thereby calculated based on the list of specified \'sourceElements\'."
		   });	
		addAnnotation
		  (getContainerSelector_TargetAttributes(), 
		   source, 
		   new String[] {
			 "documentation", "The specific attributes of the created TargetSections whose values are compared with the reference value used by this ContainerSelector."
		   });	
		addAnnotation
		  (containerSelectorTargetAttributeEClass, 
		   source, 
		   new String[] {
			 "documentation", "This represents a TargetSectionAttribute whose created instances (resp. the instances created based on the containing TargetSectionClass) are potential candidates for the container element determined by this ContainerSelector."
		   });	
		addAnnotation
		  (getContainerSelectorTargetAttribute__ValidateSourceMatchesPossibleContainerType__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "body", "\r\nif(!(this.eContainer().eContainer() instanceof <%pamtram.mapping.MappingHintGroupType%>) || this.getSource() == null || !(this.getSource().eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.structure.target.TargetSection%> targetSection = ((MappingHintGroupType) this.eContainer().eContainer()).getTargetSection();\r\n\r\nboolean result = this.getSource() == null || targetSection == null ? true : ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getSource().eContainer()).getEClass().getEAllContainments().parallelStream().anyMatch(r -> r.getEReferenceType().isSuperTypeOf(targetSection.getEClass()));\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"The type of the parent hint group\'s target section (\'\" + \r\n\t\t((MappingHintGroupType) this.eContainer().eContainer()).getTargetSection().getEClass().getName() + \r\n\t\t\"\') cannot be connected to (contained in) the type of the class containing the target attribute (\'\" + \r\n\t\t((pamtram.structure.generic.Class<?, ?, ?, ?>) this.getSource().eContainer()).getName() + \"\')!\";\r\n\r\n\tdiagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t<%pamtram.mapping.extended.util.ExtendedValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.CONTAINER_SELECTOR_TARGET_ATTRIBUTE__VALIDATE_SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, <%pamtram.structure.StructurePackage%>.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;"
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
		  (attributeMatcherEClass, 
		   source, 
		   new String[] {
			 "constraints", "targetMatchesAffectedReferenceType"
		   });	
		addAnnotation
		  (containerSelectorTargetAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceMatchesPossibleContainerType"
		   });
	}

} //ExtendedPackageImpl
