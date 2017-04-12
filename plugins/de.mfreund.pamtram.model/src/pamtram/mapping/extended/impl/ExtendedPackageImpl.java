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
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ExternalMappedAttributeValueAppender;
import pamtram.mapping.extended.ExternalMappedAttributeValueExpander;
import pamtram.mapping.extended.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.extended.LocalMappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValueAppender;
import pamtram.mapping.extended.MappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValuePrepender;
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
		MappingPackage theMappingPackage = (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		TargetPackage theTargetPackage = (TargetPackage)EPackage.Registry.INSTANCE.getEPackage(TargetPackage.eNS_URI);
		StructurePackage theStructurePackage = (StructurePackage)EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI);
		SourcePackage theSourcePackage = (SourcePackage)EPackage.Registry.INSTANCE.getEPackage(SourcePackage.eNS_URI);
		GenericPackage theGenericPackage = (GenericPackage)EPackage.Registry.INSTANCE.getEPackage(GenericPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		attributeMappingEClass.getESuperTypes().add(theMappingPackage.getMappingHint());
		attributeMappingEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		attributeMappingEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		attributeMappingEClass.getESuperTypes().add(theMappingPackage.getExpandableHint());
		attributeMappingSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
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
		cardinalityMappingEClass.getESuperTypes().add(theMappingPackage.getMappingHint());
		cardinalityMappingEClass.getESuperTypes().add(thePamtramPackage.getExpressionElement());
		cardinalityMappingEClass.getESuperTypes().add(thePamtramPackage.getModifiableElement());
		cardinalityMappingSourceInterfaceEClass.getESuperTypes().add(theMappingPackage.getMappingHintSourceInterface());
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
		referenceTargetSelectorEClass.getESuperTypes().add(theMappingPackage.getMappingHint());
		classMatcherEClass.getESuperTypes().add(this.getMatcher());
		attributeMatcherEClass.getESuperTypes().add(this.getMatcher());
		attributeMatcherEClass.getESuperTypes().add(theMappingPackage.getExpandableHint());
		attributeMatcherEClass.getESuperTypes().add(theStructurePackage.getInstanceSelector());
		containerSelectorEClass.getESuperTypes().add(theMappingPackage.getMappingHint());
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
		mappedAttributeValueExpanderEClass.getESuperTypes().add(theMappingPackage.getHintImporterMappingHint());
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
		initEReference(getMappedAttributeValueExpander_HintsToExpand(), theMappingPackage.getExpandableHint(), null, "hintsToExpand", null, 1, -1, MappedAttributeValueExpander.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMappedAttributeValueExpander__GetSourceAttribute(), theSourcePackage.getSourceSectionAttribute(), "getSourceAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(localMappedAttributeValueExpanderEClass, LocalMappedAttributeValueExpander.class, "LocalMappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValuePrependerEClass, MappedAttributeValuePrepender.class, "MappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValueAppenderEClass, MappedAttributeValueAppender.class, "MappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueExpanderEClass, ExternalMappedAttributeValueExpander.class, "ExternalMappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValuePrependerEClass, ExternalMappedAttributeValuePrepender.class, "ExternalMappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueAppenderEClass, ExternalMappedAttributeValueAppender.class, "ExternalMappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
