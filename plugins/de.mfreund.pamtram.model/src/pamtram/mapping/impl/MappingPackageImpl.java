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
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import pamtram.PamtramPackage;
import pamtram.condition.ConditionPackage;
import pamtram.condition.impl.ConditionPackageImpl;
import pamtram.impl.PamtramPackageImpl;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingExternalSourceElement;
import pamtram.mapping.AttributeMappingGlobalSourceElement;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.AttributeMatcherGlobalSourceElement;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.ValueModifier;
import pamtram.mapping.ValueModifierSet;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ExternalMappedAttributeValueAppender;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.GlobalModifiedAttributeElementType;
import pamtram.mapping.HintImporterMappingHint;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.LocalMappedAttributeValueExpander;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappedAttributeValueAppender;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;
import pamtram.mapping.MatchToLowerCaseConverter;
import pamtram.mapping.MatchToUpperCaseConverter;
import pamtram.mapping.Matcher;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorExternalSourceElement;
import pamtram.mapping.ContainerSelectorGlobalSourceElement;
import pamtram.mapping.ContainerSelectorSourceElement;
import pamtram.mapping.ContainerSelectorSourceInterface;
import pamtram.mapping.ContainerSelectorTargetAttribute;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.mapping.StringAppender;
import pamtram.mapping.StringPrepender;
import pamtram.mapping.SubstringReplacer;
import pamtram.mapping.UniqueNumberAppender;
import pamtram.mapping.util.MappingValidator;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.impl.MetamodelPackageImpl;

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
	private EClass mappingHintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionHintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiableHintEClass = null;

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
	private EClass cardinalityMappingEClass = null;

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
	private EClass attributeMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMatcherSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMatcherSourceInterfaceEClass = null;

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
	private EClass valueModifierSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass substringReplacerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringAppenderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uniqueNumberAppenderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringPrependerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifiedAttributeElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localModifiedAttributeElementTypeEClass = null;

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
	private EClass mappingHintBaseTypeEClass = null;

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
	private EClass containerSelectorEClass = null;

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
	private EClass containerSelectorSourceElementEClass = null;

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
	private EClass mappingHintTypeEClass = null;

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
	private EClass fixedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalAttributeEClass = null;

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
	private EClass attributeMappingSourceInterfaceEClass = null;

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
	private EClass containerSelectorSourceInterfaceEClass = null;

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
	private EClass externalModifiedAttributeElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerSelectorExternalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMatcherExternalSourceElementEClass = null;

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
	private EClass matchToLowerCaseConverterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchToUpperCaseConverterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globalModifiedAttributeElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeMatcherGlobalSourceElementEClass = null;

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
	private EClass containerSelectorGlobalSourceElementEClass = null;

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
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) instanceof MetamodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) : MetamodelPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);

		// Create package meta-data objects
		theMappingPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theMetamodelPackage.createPackageContents();
		theConditionPackage.createPackageContents();

		// Initialize created meta-data
		theMappingPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theMetamodelPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();

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
	public EReference getMapping_GlobalVariables() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_Abstract() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(3);
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
	public EOperation getMapping__ContainsHintGroups__DiagnosticChain_Map_1() {
		return mappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__ContainsDeactivatedHintGroups__DiagnosticChain_Map_1() {
		return mappingEClass.getEOperations().get(3);
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
	public EClass getMappingHint() {
		return mappingHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionHint() {
		return expressionHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionHint_Expression() {
		return (EAttribute)expressionHintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiableHint() {
		return modifiableHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifiableHint_ResultModifier() {
		return (EReference)modifiableHintEClass.getEStructuralFeatures().get(0);
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
	public EOperation getAttributeMapping__TargetAttributeMatchesSection__DiagnosticChain_Map_1() {
		return attributeMappingEClass.getEOperations().get(2);
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
	public EOperation getCardinalityMapping__NoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map_1() {
		return cardinalityMappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__SourceClassMatchesSection__DiagnosticChain_Map_1() {
		return cardinalityMappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__TargetClassMatchesSection__DiagnosticChain_Map_1() {
		return cardinalityMappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__TargetClassIsVariableCardinality__DiagnosticChain_Map_1() {
		return cardinalityMappingEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCardinalityMapping__SourceClassIsVariableCardinality__DiagnosticChain_Map_1() {
		return cardinalityMappingEClass.getEOperations().get(4);
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
	public EOperation getReferenceTargetSelector__AffectedReferenceMatchesSection__DiagnosticChain_Map_1() {
		return referenceTargetSelectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReferenceTargetSelector__AffectedReferenceIsNonContainment__DiagnosticChain_Map_1() {
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
	public EReference getAttributeMatcher_SourceElements() {
		return (EReference)attributeMatcherEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMatcher__GetLocalSourceElements() {
		return attributeMatcherEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMatcher__GetExternalSourceElements() {
		return attributeMatcherEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeMatcher__TargetMatchesAffectedReferenceType__DiagnosticChain_Map_1() {
		return attributeMatcherEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMatcherSourceElement() {
		return attributeMatcherSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMatcherSourceInterface() {
		return attributeMatcherSourceInterfaceEClass;
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
	public EClass getValueModifierSet() {
		return valueModifierSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueModifierSet_Modifier() {
		return (EReference)valueModifierSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueModifier() {
		return valueModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getValueModifier__ModifyValue__String() {
		return valueModifierEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubstringReplacer() {
		return substringReplacerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubstringReplacer_Regex() {
		return (EAttribute)substringReplacerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubstringReplacer_Replacement() {
		return (EAttribute)substringReplacerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringAppender() {
		return stringAppenderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringAppender_String() {
		return (EAttribute)stringAppenderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUniqueNumberAppender() {
		return uniqueNumberAppenderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringPrepender() {
		return stringPrependerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringPrepender_String() {
		return (EAttribute)stringPrependerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifiedAttributeElementType() {
		return modifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifiedAttributeElementType_Source() {
		return (EReference)modifiedAttributeElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifiedAttributeElementType_Modifier() {
		return (EReference)modifiedAttributeElementTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModifiedAttributeElementType__GetMappingHintGroup() {
		return modifiedAttributeElementTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModifiedAttributeElementType__GetMapping() {
		return modifiedAttributeElementTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalModifiedAttributeElementType() {
		return localModifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLocalModifiedAttributeElementType__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map() {
		return localModifiedAttributeElementTypeEClass.getEOperations().get(0);
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
	public EReference getMappingHintGroup_ModelConnectionMatcher() {
		return (EReference)mappingHintGroupEClass.getEStructuralFeatures().get(0);
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
	public EClass getExportedMappingHintGroup() {
		return exportedMappingHintGroupEClass;
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
	public EReference getContainerSelector_SourceElements() {
		return (EReference)containerSelectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainerSelector__GetSourceAttributes() {
		return containerSelectorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainerSelector__GetLocalSourceElements() {
		return containerSelectorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainerSelector__GetExternalSourceElements() {
		return containerSelectorEClass.getEOperations().get(2);
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
	public EClass getContainerSelectorSourceElement() {
		return containerSelectorSourceElementEClass;
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
	public EOperation getContainerSelectorTargetAttribute__SourceMatchesPossibleContainerType__DiagnosticChain_Map_1() {
		return containerSelectorTargetAttributeEClass.getEOperations().get(0);
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
	public EClass getHintImporterMappingHint() {
		return hintImporterMappingHintEClass;
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
	public EOperation getMappedAttributeValueExpander__GetModifiers() {
		return mappedAttributeValueExpanderEClass.getEOperations().get(1);
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
	public EClass getFixedValue() {
		return fixedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedValue_Value() {
		return (EAttribute)fixedValueEClass.getEStructuralFeatures().get(0);
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
	public EReference getGlobalAttribute_Modifier() {
		return (EReference)globalAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getGlobalAttribute__SourceAttributeHasUpperBoundOne__DiagnosticChain_Map_1() {
		return globalAttributeEClass.getEOperations().get(0);
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
	public EClass getAttributeMappingSourceInterface() {
		return attributeMappingSourceInterfaceEClass;
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
	public EOperation getMappingHintSourceInterface__GetSourceAttribute() {
		return mappingHintSourceInterfaceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerSelectorSourceInterface() {
		return containerSelectorSourceInterfaceEClass;
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
	public EClass getExternalModifiedAttributeElementType() {
		return externalModifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExternalModifiedAttributeElementType__SourceAttributeMatchesContainerSection__DiagnosticChain_Map_1() {
		return externalModifiedAttributeElementTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerSelectorExternalSourceElement() {
		return containerSelectorExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMatcherExternalSourceElement() {
		return attributeMatcherExternalSourceElementEClass;
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
	public EClass getExpandableHint() {
		return expandableHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchToLowerCaseConverter() {
		return matchToLowerCaseConverterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchToLowerCaseConverter_Regex() {
		return (EAttribute)matchToLowerCaseConverterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchToUpperCaseConverter() {
		return matchToUpperCaseConverterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatchToUpperCaseConverter_Regex() {
		return (EAttribute)matchToUpperCaseConverterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobalModifiedAttributeElementType() {
		return globalModifiedAttributeElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGlobalModifiedAttributeElementType_InstanceSelector() {
		return (EReference)globalModifiedAttributeElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeMatcherGlobalSourceElement() {
		return attributeMatcherGlobalSourceElementEClass;
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
	public EClass getContainerSelectorGlobalSourceElement() {
		return containerSelectorGlobalSourceElementEClass;
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
		createEReference(mappingEClass, MAPPING__GLOBAL_VARIABLES);
		createEAttribute(mappingEClass, MAPPING__ABSTRACT);
		createEOperation(mappingEClass, MAPPING___GET_ACTIVE_MAPPING_HINT_GROUPS);
		createEOperation(mappingEClass, MAPPING___GET_ACTIVE_IMPORTED_MAPPING_HINT_GROUPS);
		createEOperation(mappingEClass, MAPPING___CONTAINS_HINT_GROUPS__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(mappingEClass, MAPPING___CONTAINS_DEACTIVATED_HINT_GROUPS__DIAGNOSTICCHAIN_MAP_1);

		mappingHintGroupTypeEClass = createEClass(MAPPING_HINT_GROUP_TYPE);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__TARGET_SECTION);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__EXTEND);

		instantiableMappingHintGroupEClass = createEClass(INSTANTIABLE_MAPPING_HINT_GROUP);

		mappingHintGroupEClass = createEClass(MAPPING_HINT_GROUP);
		createEReference(mappingHintGroupEClass, MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER);

		mappingHintBaseTypeEClass = createEClass(MAPPING_HINT_BASE_TYPE);

		mappingHintEClass = createEClass(MAPPING_HINT);

		expressionHintEClass = createEClass(EXPRESSION_HINT);
		createEAttribute(expressionHintEClass, EXPRESSION_HINT__EXPRESSION);

		modifiableHintEClass = createEClass(MODIFIABLE_HINT);
		createEReference(modifiableHintEClass, MODIFIABLE_HINT__RESULT_MODIFIER);

		attributeMappingEClass = createEClass(ATTRIBUTE_MAPPING);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__TARGET);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP_1);

		cardinalityMappingEClass = createEClass(CARDINALITY_MAPPING);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__SOURCE);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__TARGET);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___SOURCE_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(cardinalityMappingEClass, CARDINALITY_MAPPING___SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP_1);

		referenceTargetSelectorEClass = createEClass(REFERENCE_TARGET_SELECTOR);
		createEReference(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE);
		createEReference(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR__MATCHER);
		createEOperation(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR___AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP_1);
		createEOperation(referenceTargetSelectorEClass, REFERENCE_TARGET_SELECTOR___AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP_1);

		matcherEClass = createEClass(MATCHER);

		attributeMatcherEClass = createEClass(ATTRIBUTE_MATCHER);
		createEReference(attributeMatcherEClass, ATTRIBUTE_MATCHER__TARGET);
		createEReference(attributeMatcherEClass, ATTRIBUTE_MATCHER__SOURCE_ELEMENTS);
		createEOperation(attributeMatcherEClass, ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(attributeMatcherEClass, ATTRIBUTE_MATCHER___GET_EXTERNAL_SOURCE_ELEMENTS);
		createEOperation(attributeMatcherEClass, ATTRIBUTE_MATCHER___TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP_1);

		attributeMatcherSourceElementEClass = createEClass(ATTRIBUTE_MATCHER_SOURCE_ELEMENT);

		attributeMatcherSourceInterfaceEClass = createEClass(ATTRIBUTE_MATCHER_SOURCE_INTERFACE);

		classMatcherEClass = createEClass(CLASS_MATCHER);
		createEReference(classMatcherEClass, CLASS_MATCHER__TARGET_CLASS);

		valueModifierSetEClass = createEClass(VALUE_MODIFIER_SET);
		createEReference(valueModifierSetEClass, VALUE_MODIFIER_SET__MODIFIER);

		valueModifierEClass = createEClass(VALUE_MODIFIER);
		createEOperation(valueModifierEClass, VALUE_MODIFIER___MODIFY_VALUE__STRING);

		substringReplacerEClass = createEClass(SUBSTRING_REPLACER);
		createEAttribute(substringReplacerEClass, SUBSTRING_REPLACER__REGEX);
		createEAttribute(substringReplacerEClass, SUBSTRING_REPLACER__REPLACEMENT);

		stringAppenderEClass = createEClass(STRING_APPENDER);
		createEAttribute(stringAppenderEClass, STRING_APPENDER__STRING);

		uniqueNumberAppenderEClass = createEClass(UNIQUE_NUMBER_APPENDER);

		stringPrependerEClass = createEClass(STRING_PREPENDER);
		createEAttribute(stringPrependerEClass, STRING_PREPENDER__STRING);

		modifiedAttributeElementTypeEClass = createEClass(MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEReference(modifiedAttributeElementTypeEClass, MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE);
		createEReference(modifiedAttributeElementTypeEClass, MODIFIED_ATTRIBUTE_ELEMENT_TYPE__MODIFIER);
		createEOperation(modifiedAttributeElementTypeEClass, MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING_HINT_GROUP);
		createEOperation(modifiedAttributeElementTypeEClass, MODIFIED_ATTRIBUTE_ELEMENT_TYPE___GET_MAPPING);

		localModifiedAttributeElementTypeEClass = createEClass(LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEOperation(localModifiedAttributeElementTypeEClass, LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP);

		mappingHintGroupImporterEClass = createEClass(MAPPING_HINT_GROUP_IMPORTER);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__CONTAINER);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS);

		exportedMappingHintGroupEClass = createEClass(EXPORTED_MAPPING_HINT_GROUP);

		containerSelectorEClass = createEClass(CONTAINER_SELECTOR);
		createEReference(containerSelectorEClass, CONTAINER_SELECTOR__TARGET_ATTRIBUTES);
		createEReference(containerSelectorEClass, CONTAINER_SELECTOR__SOURCE_ELEMENTS);
		createEOperation(containerSelectorEClass, CONTAINER_SELECTOR___GET_SOURCE_ATTRIBUTES);
		createEOperation(containerSelectorEClass, CONTAINER_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(containerSelectorEClass, CONTAINER_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS);

		attributeMappingSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_ELEMENT);

		containerSelectorSourceElementEClass = createEClass(CONTAINER_SELECTOR_SOURCE_ELEMENT);

		containerSelectorTargetAttributeEClass = createEClass(CONTAINER_SELECTOR_TARGET_ATTRIBUTE);
		createEOperation(containerSelectorTargetAttributeEClass, CONTAINER_SELECTOR_TARGET_ATTRIBUTE___SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__DIAGNOSTICCHAIN_MAP_1);

		mappingHintTypeEClass = createEClass(MAPPING_HINT_TYPE);

		hintImporterMappingHintEClass = createEClass(HINT_IMPORTER_MAPPING_HINT);

		mappedAttributeValueExpanderEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_EXPANDER);
		createEReference(mappedAttributeValueExpanderEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND);
		createEOperation(mappedAttributeValueExpanderEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_SOURCE_ATTRIBUTE);
		createEOperation(mappedAttributeValueExpanderEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER___GET_MODIFIERS);

		localMappedAttributeValueExpanderEClass = createEClass(LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER);

		mappedAttributeValuePrependerEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_PREPENDER);

		mappedAttributeValueAppenderEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_APPENDER);

		fixedValueEClass = createEClass(FIXED_VALUE);
		createEAttribute(fixedValueEClass, FIXED_VALUE__VALUE);

		globalAttributeEClass = createEClass(GLOBAL_ATTRIBUTE);
		createEReference(globalAttributeEClass, GLOBAL_ATTRIBUTE__SOURCE);
		createEReference(globalAttributeEClass, GLOBAL_ATTRIBUTE__MODIFIER);
		createEOperation(globalAttributeEClass, GLOBAL_ATTRIBUTE___SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__DIAGNOSTICCHAIN_MAP_1);

		globalAttributeImporterEClass = createEClass(GLOBAL_ATTRIBUTE_IMPORTER);
		createEReference(globalAttributeImporterEClass, GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE);

		attributeMappingSourceInterfaceEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_INTERFACE);

		mappingHintSourceInterfaceEClass = createEClass(MAPPING_HINT_SOURCE_INTERFACE);
		createEOperation(mappingHintSourceInterfaceEClass, MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE);

		containerSelectorSourceInterfaceEClass = createEClass(CONTAINER_SELECTOR_SOURCE_INTERFACE);

		attributeMappingExternalSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT);

		externalModifiedAttributeElementTypeEClass = createEClass(EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEOperation(externalModifiedAttributeElementTypeEClass, EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE___SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__DIAGNOSTICCHAIN_MAP_1);

		containerSelectorExternalSourceElementEClass = createEClass(CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT);

		attributeMatcherExternalSourceElementEClass = createEClass(ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT);

		externalMappedAttributeValueExpanderEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER);

		externalMappedAttributeValuePrependerEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER);

		externalMappedAttributeValueAppenderEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER);

		expandableHintEClass = createEClass(EXPANDABLE_HINT);

		matchToLowerCaseConverterEClass = createEClass(MATCH_TO_LOWER_CASE_CONVERTER);
		createEAttribute(matchToLowerCaseConverterEClass, MATCH_TO_LOWER_CASE_CONVERTER__REGEX);

		matchToUpperCaseConverterEClass = createEClass(MATCH_TO_UPPER_CASE_CONVERTER);
		createEAttribute(matchToUpperCaseConverterEClass, MATCH_TO_UPPER_CASE_CONVERTER__REGEX);

		globalModifiedAttributeElementTypeEClass = createEClass(GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE);
		createEReference(globalModifiedAttributeElementTypeEClass, GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__INSTANCE_SELECTOR);

		attributeMatcherGlobalSourceElementEClass = createEClass(ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT);

		attributeMappingGlobalSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT);

		containerSelectorGlobalSourceElementEClass = createEClass(CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT);
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
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);

		// Create type parameters
		ETypeParameter modifiedAttributeElementTypeEClass_S = addETypeParameter(modifiedAttributeElementTypeEClass, "S");
		ETypeParameter modifiedAttributeElementTypeEClass_C = addETypeParameter(modifiedAttributeElementTypeEClass, "C");
		ETypeParameter modifiedAttributeElementTypeEClass_R = addETypeParameter(modifiedAttributeElementTypeEClass, "R");
		ETypeParameter modifiedAttributeElementTypeEClass_A = addETypeParameter(modifiedAttributeElementTypeEClass, "A");
		ETypeParameter localModifiedAttributeElementTypeEClass_S = addETypeParameter(localModifiedAttributeElementTypeEClass, "S");
		ETypeParameter localModifiedAttributeElementTypeEClass_C = addETypeParameter(localModifiedAttributeElementTypeEClass, "C");
		ETypeParameter localModifiedAttributeElementTypeEClass_R = addETypeParameter(localModifiedAttributeElementTypeEClass, "R");
		ETypeParameter localModifiedAttributeElementTypeEClass_A = addETypeParameter(localModifiedAttributeElementTypeEClass, "A");
		ETypeParameter externalModifiedAttributeElementTypeEClass_S = addETypeParameter(externalModifiedAttributeElementTypeEClass, "S");
		ETypeParameter externalModifiedAttributeElementTypeEClass_C = addETypeParameter(externalModifiedAttributeElementTypeEClass, "C");
		ETypeParameter externalModifiedAttributeElementTypeEClass_R = addETypeParameter(externalModifiedAttributeElementTypeEClass, "R");
		ETypeParameter externalModifiedAttributeElementTypeEClass_A = addETypeParameter(externalModifiedAttributeElementTypeEClass, "A");
		ETypeParameter globalModifiedAttributeElementTypeEClass_S = addETypeParameter(globalModifiedAttributeElementTypeEClass, "S");
		ETypeParameter globalModifiedAttributeElementTypeEClass_C = addETypeParameter(globalModifiedAttributeElementTypeEClass, "C");
		ETypeParameter globalModifiedAttributeElementTypeEClass_R = addETypeParameter(globalModifiedAttributeElementTypeEClass, "R");
		ETypeParameter globalModifiedAttributeElementTypeEClass_A = addETypeParameter(globalModifiedAttributeElementTypeEClass, "A");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(theMetamodelPackage.getSection());
		EGenericType g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getClass_());
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getReference());
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getAttribute());
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		modifiedAttributeElementTypeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getSection());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getClass_());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getReference());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getAttribute());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getSection());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getClass_());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getReference());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getAttribute());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass_A.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getSection());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_S.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getClass_());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getReference());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_R.getEBounds().add(g1);
		g1 = createEGenericType(theMetamodelPackage.getAttribute());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass_A.getEBounds().add(g1);

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
		mappingHintBaseTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintEClass.getESuperTypes().add(this.getMappingHintType());
		mappingHintEClass.getESuperTypes().add(thePamtramPackage.getConditionalElement());
		attributeMappingEClass.getESuperTypes().add(this.getMappingHint());
		attributeMappingEClass.getESuperTypes().add(this.getExpressionHint());
		attributeMappingEClass.getESuperTypes().add(this.getModifiableHint());
		attributeMappingEClass.getESuperTypes().add(this.getExpandableHint());
		cardinalityMappingEClass.getESuperTypes().add(this.getMappingHint());
		referenceTargetSelectorEClass.getESuperTypes().add(this.getMappingHint());
		attributeMatcherEClass.getESuperTypes().add(this.getMatcher());
		attributeMatcherEClass.getESuperTypes().add(this.getExpressionHint());
		attributeMatcherEClass.getESuperTypes().add(this.getModifiableHint());
		attributeMatcherEClass.getESuperTypes().add(this.getExpandableHint());
		g1 = createEGenericType(this.getLocalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMatcherSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMatcherSourceInterface());
		attributeMatcherSourceElementEClass.getEGenericSuperTypes().add(g1);
		attributeMatcherSourceInterfaceEClass.getESuperTypes().add(this.getMappingHintSourceInterface());
		classMatcherEClass.getESuperTypes().add(this.getMatcher());
		valueModifierSetEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		valueModifierEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		substringReplacerEClass.getESuperTypes().add(this.getValueModifier());
		stringAppenderEClass.getESuperTypes().add(this.getValueModifier());
		uniqueNumberAppenderEClass.getESuperTypes().add(this.getValueModifier());
		stringPrependerEClass.getESuperTypes().add(this.getValueModifier());
		modifiedAttributeElementTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		g1 = createEGenericType(this.getModifiedAttributeElementType());
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(localModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		localModifiedAttributeElementTypeEClass.getEGenericSuperTypes().add(g1);
		mappingHintGroupImporterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintGroupImporterEClass.getESuperTypes().add(this.getInstantiableMappingHintGroup());
		exportedMappingHintGroupEClass.getESuperTypes().add(this.getMappingHintGroupType());
		containerSelectorEClass.getESuperTypes().add(this.getMappingHintBaseType());
		g1 = createEGenericType(this.getLocalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLocalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		containerSelectorSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerSelectorSourceInterface());
		containerSelectorSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getTargetSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getTargetSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getTargetSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getTargetSectionAttribute());
		g1.getETypeArguments().add(g2);
		containerSelectorTargetAttributeEClass.getEGenericSuperTypes().add(g1);
		mappingHintTypeEClass.getESuperTypes().add(this.getMappingHintBaseType());
		hintImporterMappingHintEClass.getESuperTypes().add(this.getMappingHintType());
		mappedAttributeValueExpanderEClass.getESuperTypes().add(this.getHintImporterMappingHint());
		g1 = createEGenericType(this.getLocalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		localMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getMappedAttributeValueExpander());
		localMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		mappedAttributeValuePrependerEClass.getESuperTypes().add(this.getLocalMappedAttributeValueExpander());
		mappedAttributeValueAppenderEClass.getESuperTypes().add(this.getLocalMappedAttributeValueExpander());
		fixedValueEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		fixedValueEClass.getESuperTypes().add(this.getAttributeMappingSourceInterface());
		fixedValueEClass.getESuperTypes().add(this.getAttributeMatcherSourceInterface());
		fixedValueEClass.getESuperTypes().add(this.getContainerSelectorSourceInterface());
		fixedValueEClass.getESuperTypes().add(theMetamodelPackage.getInstancePointerSourceInterface());
		fixedValueEClass.getESuperTypes().add(theMetamodelPackage.getValueConstraintSourceInterface());
		globalAttributeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		globalAttributeImporterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		globalAttributeImporterEClass.getESuperTypes().add(this.getAttributeMappingSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(this.getAttributeMatcherSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(this.getContainerSelectorSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(theMetamodelPackage.getInstancePointerSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(theMetamodelPackage.getValueConstraintSourceInterface());
		attributeMappingSourceInterfaceEClass.getESuperTypes().add(this.getMappingHintSourceInterface());
		mappingHintSourceInterfaceEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		containerSelectorSourceInterfaceEClass.getESuperTypes().add(this.getMappingHintSourceInterface());
		g1 = createEGenericType(this.getExternalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getModifiedAttributeElementType());
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(externalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		externalModifiedAttributeElementTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getExternalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		containerSelectorExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerSelectorSourceInterface());
		containerSelectorExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getExternalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMatcherExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMatcherSourceInterface());
		attributeMatcherExternalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getExternalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		externalMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getMappedAttributeValueExpander());
		externalMappedAttributeValueExpanderEClass.getEGenericSuperTypes().add(g1);
		externalMappedAttributeValuePrependerEClass.getESuperTypes().add(this.getExternalMappedAttributeValueExpander());
		externalMappedAttributeValueAppenderEClass.getESuperTypes().add(this.getExternalMappedAttributeValueExpander());
		matchToLowerCaseConverterEClass.getESuperTypes().add(this.getValueModifier());
		matchToUpperCaseConverterEClass.getESuperTypes().add(this.getValueModifier());
		g1 = createEGenericType(this.getModifiedAttributeElementType());
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_S);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_C);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(globalModifiedAttributeElementTypeEClass_A);
		g1.getETypeArguments().add(g2);
		globalModifiedAttributeElementTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGlobalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMatcherGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMatcherSourceInterface());
		attributeMatcherGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGlobalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		attributeMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getAttributeMappingSourceInterface());
		attributeMappingGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getGlobalModifiedAttributeElementType());
		g2 = createEGenericType(theMetamodelPackage.getSourceSection());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionClass());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionReference());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theMetamodelPackage.getSourceSectionAttribute());
		g1.getETypeArguments().add(g2);
		containerSelectorGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getContainerSelectorSourceInterface());
		containerSelectorGlobalSourceElementEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(mappingTypeEClass, MappingType.class, "MappingType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingType_SourceSection(), theMetamodelPackage.getSourceSection(), null, "sourceSection", null, 1, 1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_MappingHintGroups(), this.getMappingHintGroupType(), null, "mappingHintGroups", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_ImportedMappingHintGroups(), this.getMappingHintGroupImporter(), null, "importedMappingHintGroups", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_GlobalVariables(), this.getGlobalAttribute(), null, "globalVariables", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMapping__GetActiveMappingHintGroups(), this.getMappingHintGroupType(), "getActiveMappingHintGroups", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMapping__GetActiveImportedMappingHintGroups(), this.getMappingHintGroupImporter(), "getActiveImportedMappingHintGroups", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getMapping__ContainsHintGroups__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "containsHintGroups", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMapping__ContainsDeactivatedHintGroups__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "containsDeactivatedHintGroups", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mappingHintGroupTypeEClass, MappingHintGroupType.class, "MappingHintGroupType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroupType_TargetSection(), theMetamodelPackage.getTargetSection(), null, "targetSection", null, 1, 1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_MappingHints(), this.getMappingHint(), null, "mappingHints", null, 0, -1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_Extend(), this.getMappingHintGroupType(), null, "extend", null, 0, -1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instantiableMappingHintGroupEClass, InstantiableMappingHintGroup.class, "InstantiableMappingHintGroup", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintGroupEClass, MappingHintGroup.class, "MappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroup_ModelConnectionMatcher(), this.getContainerSelector(), null, "modelConnectionMatcher", null, 0, 1, MappingHintGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingHintBaseTypeEClass, MappingHintBaseType.class, "MappingHintBaseType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintEClass, MappingHint.class, "MappingHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionHintEClass, ExpressionHint.class, "ExpressionHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpressionHint_Expression(), ecorePackage.getEString(), "expression", "", 1, 1, ExpressionHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifiableHintEClass, ModifiableHint.class, "ModifiableHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifiableHint_ResultModifier(), this.getValueModifierSet(), null, "resultModifier", null, 0, -1, ModifiableHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMappingEClass, AttributeMapping.class, "AttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMapping_Target(), theMetamodelPackage.getTargetSectionAttribute(), null, "target", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMapping_SourceElements(), this.getAttributeMappingSourceInterface(), null, "sourceElements", null, 1, -1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttributeMapping__GetLocalSourceElements(), this.getAttributeMappingSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttributeMapping__GetExternalSourceElements(), this.getAttributeMappingExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeMapping__TargetAttributeMatchesSection__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "targetAttributeMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(cardinalityMappingEClass, CardinalityMapping.class, "CardinalityMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCardinalityMapping_Source(), theMetamodelPackage.getSourceSectionClass(), null, "source", null, 1, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCardinalityMapping_Target(), theMetamodelPackage.getTargetSectionClass(), null, "target", null, 1, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__NoCardinalityMappingForSourceSectionRoot__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "noCardinalityMappingForSourceSectionRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__SourceClassMatchesSection__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "sourceClassMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__TargetClassMatchesSection__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "targetClassMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__TargetClassIsVariableCardinality__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "targetClassIsVariableCardinality", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getCardinalityMapping__SourceClassIsVariableCardinality__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "sourceClassIsVariableCardinality", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(referenceTargetSelectorEClass, ReferenceTargetSelector.class, "ReferenceTargetSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceTargetSelector_AffectedReference(), theMetamodelPackage.getTargetSectionNonContainmentReference(), null, "affectedReference", null, 1, 1, ReferenceTargetSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceTargetSelector_Matcher(), this.getMatcher(), null, "matcher", null, 1, 1, ReferenceTargetSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getReferenceTargetSelector__AffectedReferenceMatchesSection__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "affectedReferenceMatchesSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getReferenceTargetSelector__AffectedReferenceIsNonContainment__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "affectedReferenceIsNonContainment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(matcherEClass, Matcher.class, "Matcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMatcherEClass, AttributeMatcher.class, "AttributeMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMatcher_Target(), theMetamodelPackage.getTargetSectionAttribute(), null, "target", null, 1, 1, AttributeMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMatcher_SourceElements(), this.getAttributeMatcherSourceInterface(), null, "sourceElements", null, 1, -1, AttributeMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttributeMatcher__GetLocalSourceElements(), this.getAttributeMatcherSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getAttributeMatcher__GetExternalSourceElements(), this.getAttributeMatcherExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAttributeMatcher__TargetMatchesAffectedReferenceType__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "targetMatchesAffectedReferenceType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeMatcherSourceElementEClass, AttributeMatcherSourceElement.class, "AttributeMatcherSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMatcherSourceInterfaceEClass, AttributeMatcherSourceInterface.class, "AttributeMatcherSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classMatcherEClass, ClassMatcher.class, "ClassMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassMatcher_TargetClass(), theMetamodelPackage.getTargetSectionClass(), null, "targetClass", null, 1, 1, ClassMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueModifierSetEClass, ValueModifierSet.class, "ValueModifierSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueModifierSet_Modifier(), this.getValueModifier(), null, "modifier", null, 0, -1, ValueModifierSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueModifierEClass, ValueModifier.class, "ValueModifier", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getValueModifier__ModifyValue__String(), ecorePackage.getEString(), "modifyValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(substringReplacerEClass, SubstringReplacer.class, "SubstringReplacer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubstringReplacer_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, SubstringReplacer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubstringReplacer_Replacement(), ecorePackage.getEString(), "replacement", null, 1, 1, SubstringReplacer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringAppenderEClass, StringAppender.class, "StringAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringAppender_String(), ecorePackage.getEString(), "string", "", 1, 1, StringAppender.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uniqueNumberAppenderEClass, UniqueNumberAppender.class, "UniqueNumberAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringPrependerEClass, StringPrepender.class, "StringPrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringPrepender_String(), ecorePackage.getEString(), "string", "", 1, 1, StringPrepender.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifiedAttributeElementTypeEClass, ModifiedAttributeElementType.class, "ModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(modifiedAttributeElementTypeEClass_A);
		initEReference(getModifiedAttributeElementType_Source(), g1, null, "source", null, 1, 1, ModifiedAttributeElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifiedAttributeElementType_Modifier(), this.getValueModifierSet(), null, "modifier", null, 0, -1, ModifiedAttributeElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModifiedAttributeElementType__GetMappingHintGroup(), thePamtramPackage.getNamedElement(), "getMappingHintGroup", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getModifiedAttributeElementType__GetMapping(), this.getMapping(), "getMapping", 1, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(localModifiedAttributeElementTypeEClass, LocalModifiedAttributeElementType.class, "LocalModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getLocalModifiedAttributeElementType__ValidateSourceAttributeMatchesSectionOrContainedSection__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceAttributeMatchesSectionOrContainedSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mappingHintGroupImporterEClass, MappingHintGroupImporter.class, "MappingHintGroupImporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroupImporter_HintGroup(), this.getExportedMappingHintGroup(), null, "hintGroup", null, 1, 1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupImporter_Container(), theMetamodelPackage.getTargetSectionClass(), null, "container", null, 0, 1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupImporter_MappingHints(), this.getMappingHintType(), null, "mappingHints", null, 0, -1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exportedMappingHintGroupEClass, ExportedMappingHintGroup.class, "ExportedMappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containerSelectorEClass, ContainerSelector.class, "ContainerSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerSelector_TargetAttributes(), this.getContainerSelectorTargetAttribute(), null, "targetAttributes", null, 1, -1, ContainerSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainerSelector_SourceElements(), this.getContainerSelectorSourceInterface(), null, "sourceElements", null, 1, -1, ContainerSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getContainerSelector__GetSourceAttributes(), theMetamodelPackage.getActualSourceSectionAttribute(), "getSourceAttributes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainerSelector__GetLocalSourceElements(), this.getContainerSelectorSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainerSelector__GetExternalSourceElements(), this.getContainerSelectorExternalSourceElement(), "getExternalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(attributeMappingSourceElementEClass, AttributeMappingSourceElement.class, "AttributeMappingSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containerSelectorSourceElementEClass, ContainerSelectorSourceElement.class, "ContainerSelectorSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containerSelectorTargetAttributeEClass, ContainerSelectorTargetAttribute.class, "ContainerSelectorTargetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getContainerSelectorTargetAttribute__SourceMatchesPossibleContainerType__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "sourceMatchesPossibleContainerType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mappingHintTypeEClass, MappingHintType.class, "MappingHintType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hintImporterMappingHintEClass, HintImporterMappingHint.class, "HintImporterMappingHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValueExpanderEClass, MappedAttributeValueExpander.class, "MappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedAttributeValueExpander_HintsToExpand(), this.getExpandableHint(), null, "hintsToExpand", null, 1, -1, MappedAttributeValueExpander.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMappedAttributeValueExpander__GetSourceAttribute(), theMetamodelPackage.getSourceSectionAttribute(), "getSourceAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMappedAttributeValueExpander__GetModifiers(), this.getValueModifierSet(), "getModifiers", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(localMappedAttributeValueExpanderEClass, LocalMappedAttributeValueExpander.class, "LocalMappedAttributeValueExpander", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValuePrependerEClass, MappedAttributeValuePrepender.class, "MappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValueAppenderEClass, MappedAttributeValueAppender.class, "MappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fixedValueEClass, FixedValue.class, "FixedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, FixedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalAttributeEClass, GlobalAttribute.class, "GlobalAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalAttribute_Source(), theMetamodelPackage.getActualSourceSectionAttribute(), null, "source", null, 1, 1, GlobalAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGlobalAttribute_Modifier(), this.getValueModifierSet(), null, "modifier", null, 0, -1, GlobalAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getGlobalAttribute__SourceAttributeHasUpperBoundOne__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "sourceAttributeHasUpperBoundOne", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(globalAttributeImporterEClass, GlobalAttributeImporter.class, "GlobalAttributeImporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalAttributeImporter_GlobalAttribute(), this.getGlobalAttribute(), null, "globalAttribute", null, 1, 1, GlobalAttributeImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMappingSourceInterfaceEClass, AttributeMappingSourceInterface.class, "AttributeMappingSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintSourceInterfaceEClass, MappingHintSourceInterface.class, "MappingHintSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getMappingHintSourceInterface__GetSourceAttribute(), theMetamodelPackage.getSourceSectionAttribute(), "getSourceAttribute", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containerSelectorSourceInterfaceEClass, ContainerSelectorSourceInterface.class, "ContainerSelectorSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingExternalSourceElementEClass, AttributeMappingExternalSourceElement.class, "AttributeMappingExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalModifiedAttributeElementTypeEClass, ExternalModifiedAttributeElementType.class, "ExternalModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getExternalModifiedAttributeElementType__SourceAttributeMatchesContainerSection__DiagnosticChain_Map_1(), ecorePackage.getEBoolean(), "sourceAttributeMatchesContainerSection", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containerSelectorExternalSourceElementEClass, ContainerSelectorExternalSourceElement.class, "ContainerSelectorExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMatcherExternalSourceElementEClass, AttributeMatcherExternalSourceElement.class, "AttributeMatcherExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueExpanderEClass, ExternalMappedAttributeValueExpander.class, "ExternalMappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValuePrependerEClass, ExternalMappedAttributeValuePrepender.class, "ExternalMappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueAppenderEClass, ExternalMappedAttributeValueAppender.class, "ExternalMappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expandableHintEClass, ExpandableHint.class, "ExpandableHint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(matchToLowerCaseConverterEClass, MatchToLowerCaseConverter.class, "MatchToLowerCaseConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchToLowerCaseConverter_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, MatchToLowerCaseConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchToUpperCaseConverterEClass, MatchToUpperCaseConverter.class, "MatchToUpperCaseConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchToUpperCaseConverter_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, MatchToUpperCaseConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalModifiedAttributeElementTypeEClass, GlobalModifiedAttributeElementType.class, "GlobalModifiedAttributeElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalModifiedAttributeElementType_InstanceSelector(), theMetamodelPackage.getInstancePointer(), null, "instanceSelector", null, 0, -1, GlobalModifiedAttributeElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMatcherGlobalSourceElementEClass, AttributeMatcherGlobalSourceElement.class, "AttributeMatcherGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingGlobalSourceElementEClass, AttributeMappingGlobalSourceElement.class, "AttributeMappingGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containerSelectorGlobalSourceElementEClass, ContainerSelectorGlobalSourceElement.class, "ContainerSelectorGlobalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
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
		   });	
		addAnnotation
		  (mappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "containsHintGroups containsDeactivatedHintGroups"
		   });	
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
		  (localModifiedAttributeElementTypeEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeMatchesSectionOrContainedSection"
		   });	
		addAnnotation
		  (containerSelectorTargetAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceMatchesPossibleContainerType"
		   });	
		addAnnotation
		  (globalAttributeEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeHasUpperBoundOne"
		   });	
		addAnnotation
		  (externalModifiedAttributeElementTypeEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeMatchesContainerSection"
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

} //MappingPackageImpl
