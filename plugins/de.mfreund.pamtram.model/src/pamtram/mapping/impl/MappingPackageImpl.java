/**
 */
package pamtram.mapping.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import pamtram.PamtramPackage;
import pamtram.condition.ConditionPackage;
import pamtram.condition.impl.ConditionPackageImpl;
import pamtram.impl.PamtramPackageImpl;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ComplexAttributeMappingExternalSourceElement;
import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherExternalSourceElement;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.ComplexAttributeMatcherSourceInterface;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintExternalSourceElement;
import pamtram.mapping.ComplexModelConnectionHintSourceElement;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalAttributeMappingSourceElement;
import pamtram.mapping.ExternalMappedAttributeValueAppender;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.HintImporterMappingHint;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappedAttributeValueAppender;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValueExpanderType;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;
import pamtram.mapping.MatchToLowerCaseConverter;
import pamtram.mapping.MatchToUpperCaseConverter;
import pamtram.mapping.Matcher;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleAttributeMatcher;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.mapping.StringAppender;
import pamtram.mapping.StringPrepender;
import pamtram.mapping.SubstringReplacer;
import pamtram.mapping.UniqueNumberAppender;
import pamtram.mapping.util.MappingValidator;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.impl.MetamodelPackageImpl;
import pamtram.transformation.TransformationPackage;
import pamtram.transformation.impl.TransformationPackageImpl;

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
	private EClass mappingInstanceSelectorEClass = null;

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
	private EClass classMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueModifierEClass = null;

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
	private EClass attributeValueModifierSetEClass = null;

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
	private EClass modelConnectionHintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionHintTargetAttributeEClass = null;

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
	private EClass attributeMappingSourceElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexAttributeMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleAttributeMatcherEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexAttributeMatcherSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleModelConnectionHintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexModelConnectionHintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexModelConnectionHintSourceElementEClass = null;

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
	private EClass mappedAttributeValueExpanderTypeEClass = null;

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
	private EClass complexMappingHintSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexAttributeMatcherSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexModelConnectionHintSourceInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexAttributeMappingExternalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalAttributeMappingSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexModelConnectionHintExternalSourceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexAttributeMatcherExternalSourceElementEClass = null;

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
	private EClass globalValueEClass = null;

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

		// Obtain or create and register interdependencies
		PamtramPackageImpl thePamtramPackage = (PamtramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) instanceof PamtramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI) : PamtramPackage.eINSTANCE);
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) instanceof MetamodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) : MetamodelPackage.eINSTANCE);
		ConditionPackageImpl theConditionPackage = (ConditionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) instanceof ConditionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI) : ConditionPackage.eINSTANCE);
		TransformationPackageImpl theTransformationPackage = (TransformationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) instanceof TransformationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TransformationPackage.eNS_URI) : TransformationPackage.eINSTANCE);

		// Create package meta-data objects
		theMappingPackage.createPackageContents();
		thePamtramPackage.createPackageContents();
		theMetamodelPackage.createPackageContents();
		theConditionPackage.createPackageContents();
		theTransformationPackage.createPackageContents();

		// Initialize created meta-data
		theMappingPackage.initializePackageContents();
		thePamtramPackage.initializePackageContents();
		theMetamodelPackage.initializePackageContents();
		theConditionPackage.initializePackageContents();
		theTransformationPackage.initializePackageContents();

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
	public EReference getMapping_Condition() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_MappingHintGroups() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_ImportedMappingHintGroups() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_GlobalVariables() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(3);
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
	public EReference getMappingType_SourceMMSection() {
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
	public EReference getAttributeMapping_SourceAttributeMappings() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeMapping_Expression() {
		return (EAttribute)attributeMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMapping_ResultModifier() {
		return (EReference)attributeMappingEClass.getEStructuralFeatures().get(3);
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
	public EClass getMappingInstanceSelector() {
		return mappingInstanceSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingInstanceSelector_AffectedReference() {
		return (EReference)mappingInstanceSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingInstanceSelector_Matcher() {
		return (EReference)mappingInstanceSelectorEClass.getEStructuralFeatures().get(1);
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
	public EReference getAttributeMatcher_TargetAttribute() {
		return (EReference)attributeMatcherEClass.getEStructuralFeatures().get(0);
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
	public EClass getAttributeValueModifier() {
		return attributeValueModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAttributeValueModifier__ModifyValue__String() {
		return attributeValueModifierEClass.getEOperations().get(0);
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
	public EClass getAttributeValueModifierSet() {
		return attributeValueModifierSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeValueModifierSet_Modifier() {
		return (EReference)attributeValueModifierSetEClass.getEStructuralFeatures().get(0);
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
	public EClass getMappingHintGroupType() {
		return mappingHintGroupTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingHintGroupType_TargetMMSection() {
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
	public EClass getModelConnectionHint() {
		return modelConnectionHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelConnectionHint_TargetAttributes() {
		return (EReference)modelConnectionHintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelConnectionHint__GetSourceAttributes() {
		return modelConnectionHintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectionHintTargetAttribute() {
		return connectionHintTargetAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionHintTargetAttribute_TargetAttribute() {
		return (EReference)connectionHintTargetAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectionHintTargetAttribute_Modifier() {
		return (EReference)connectionHintTargetAttributeEClass.getEStructuralFeatures().get(1);
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
	public EClass getAttributeMappingSourceElementType() {
		return attributeMappingSourceElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMappingSourceElementType_Source() {
		return (EReference)attributeMappingSourceElementTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeMappingSourceElementType_Modifier() {
		return (EReference)attributeMappingSourceElementTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexAttributeMatcher() {
		return complexAttributeMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexAttributeMatcher_SourceAttributes() {
		return (EReference)complexAttributeMatcherEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexAttributeMatcher__GetLocalSourceElements() {
		return complexAttributeMatcherEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleAttributeMatcher() {
		return simpleAttributeMatcherEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexAttributeMatcherSourceElement() {
		return complexAttributeMatcherSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleModelConnectionHint() {
		return simpleModelConnectionHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSimpleModelConnectionHint__GetSourceAttributes() {
		return simpleModelConnectionHintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexModelConnectionHint() {
		return complexModelConnectionHintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexModelConnectionHint_SourceElements() {
		return (EReference)complexModelConnectionHintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexModelConnectionHint__GetLocalSourceElements() {
		return complexModelConnectionHintEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexModelConnectionHint__GetSourceAttributes() {
		return complexModelConnectionHintEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexModelConnectionHintSourceElement() {
		return complexModelConnectionHintSourceElementEClass;
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
	public EClass getMappedAttributeValueExpanderType() {
		return mappedAttributeValueExpanderTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappedAttributeValueExpanderType_SourceAttribute() {
		return (EReference)mappedAttributeValueExpanderTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappedAttributeValueExpanderType_Modifiers() {
		return (EReference)mappedAttributeValueExpanderTypeEClass.getEStructuralFeatures().get(1);
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
	public EClass getComplexMappingHintSourceInterface() {
		return complexMappingHintSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexMappingHintSourceInterface__GetSourceAttribute() {
		return complexMappingHintSourceInterfaceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComplexMappingHintSourceInterface__GetName() {
		return complexMappingHintSourceInterfaceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexAttributeMatcherSourceInterface() {
		return complexAttributeMatcherSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexModelConnectionHintSourceInterface() {
		return complexModelConnectionHintSourceInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexAttributeMappingExternalSourceElement() {
		return complexAttributeMappingExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalAttributeMappingSourceElement() {
		return externalAttributeMappingSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexModelConnectionHintExternalSourceElement() {
		return complexModelConnectionHintExternalSourceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexAttributeMatcherExternalSourceElement() {
		return complexAttributeMatcherExternalSourceElementEClass;
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
	public EClass getGlobalValue() {
		return globalValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGlobalValue_Value() {
		return (EAttribute)globalValueEClass.getEStructuralFeatures().get(0);
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
		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__CONDITION);
		createEReference(mappingEClass, MAPPING__MAPPING_HINT_GROUPS);
		createEReference(mappingEClass, MAPPING__IMPORTED_MAPPING_HINT_GROUPS);
		createEReference(mappingEClass, MAPPING__GLOBAL_VARIABLES);

		mappingTypeEClass = createEClass(MAPPING_TYPE);
		createEReference(mappingTypeEClass, MAPPING_TYPE__SOURCE_MM_SECTION);

		mappingHintEClass = createEClass(MAPPING_HINT);

		attributeMappingEClass = createEClass(ATTRIBUTE_MAPPING);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__TARGET);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS);
		createEAttribute(attributeMappingEClass, ATTRIBUTE_MAPPING__EXPRESSION);
		createEReference(attributeMappingEClass, ATTRIBUTE_MAPPING__RESULT_MODIFIER);
		createEOperation(attributeMappingEClass, ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS);

		cardinalityMappingEClass = createEClass(CARDINALITY_MAPPING);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__SOURCE);
		createEReference(cardinalityMappingEClass, CARDINALITY_MAPPING__TARGET);

		mappingInstanceSelectorEClass = createEClass(MAPPING_INSTANCE_SELECTOR);
		createEReference(mappingInstanceSelectorEClass, MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE);
		createEReference(mappingInstanceSelectorEClass, MAPPING_INSTANCE_SELECTOR__MATCHER);

		matcherEClass = createEClass(MATCHER);

		attributeMatcherEClass = createEClass(ATTRIBUTE_MATCHER);
		createEReference(attributeMatcherEClass, ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE);

		classMatcherEClass = createEClass(CLASS_MATCHER);
		createEReference(classMatcherEClass, CLASS_MATCHER__TARGET_CLASS);

		attributeValueModifierEClass = createEClass(ATTRIBUTE_VALUE_MODIFIER);
		createEOperation(attributeValueModifierEClass, ATTRIBUTE_VALUE_MODIFIER___MODIFY_VALUE__STRING);

		substringReplacerEClass = createEClass(SUBSTRING_REPLACER);
		createEAttribute(substringReplacerEClass, SUBSTRING_REPLACER__REGEX);
		createEAttribute(substringReplacerEClass, SUBSTRING_REPLACER__REPLACEMENT);

		stringAppenderEClass = createEClass(STRING_APPENDER);
		createEAttribute(stringAppenderEClass, STRING_APPENDER__STRING);

		uniqueNumberAppenderEClass = createEClass(UNIQUE_NUMBER_APPENDER);

		stringPrependerEClass = createEClass(STRING_PREPENDER);
		createEAttribute(stringPrependerEClass, STRING_PREPENDER__STRING);

		attributeValueModifierSetEClass = createEClass(ATTRIBUTE_VALUE_MODIFIER_SET);
		createEReference(attributeValueModifierSetEClass, ATTRIBUTE_VALUE_MODIFIER_SET__MODIFIER);

		mappingHintGroupEClass = createEClass(MAPPING_HINT_GROUP);
		createEReference(mappingHintGroupEClass, MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER);

		mappingHintGroupTypeEClass = createEClass(MAPPING_HINT_GROUP_TYPE);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION);
		createEReference(mappingHintGroupTypeEClass, MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS);

		instantiableMappingHintGroupEClass = createEClass(INSTANTIABLE_MAPPING_HINT_GROUP);

		mappingHintGroupImporterEClass = createEClass(MAPPING_HINT_GROUP_IMPORTER);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__CONTAINER);
		createEReference(mappingHintGroupImporterEClass, MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS);

		exportedMappingHintGroupEClass = createEClass(EXPORTED_MAPPING_HINT_GROUP);

		modelConnectionHintEClass = createEClass(MODEL_CONNECTION_HINT);
		createEReference(modelConnectionHintEClass, MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES);
		createEOperation(modelConnectionHintEClass, MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES);

		connectionHintTargetAttributeEClass = createEClass(CONNECTION_HINT_TARGET_ATTRIBUTE);
		createEReference(connectionHintTargetAttributeEClass, CONNECTION_HINT_TARGET_ATTRIBUTE__TARGET_ATTRIBUTE);
		createEReference(connectionHintTargetAttributeEClass, CONNECTION_HINT_TARGET_ATTRIBUTE__MODIFIER);

		attributeMappingSourceElementEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_ELEMENT);

		attributeMappingSourceElementTypeEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE);
		createEReference(attributeMappingSourceElementTypeEClass, ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE);
		createEReference(attributeMappingSourceElementTypeEClass, ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER);

		complexAttributeMatcherEClass = createEClass(COMPLEX_ATTRIBUTE_MATCHER);
		createEReference(complexAttributeMatcherEClass, COMPLEX_ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES);
		createEOperation(complexAttributeMatcherEClass, COMPLEX_ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS);

		simpleAttributeMatcherEClass = createEClass(SIMPLE_ATTRIBUTE_MATCHER);

		complexAttributeMatcherSourceElementEClass = createEClass(COMPLEX_ATTRIBUTE_MATCHER_SOURCE_ELEMENT);

		simpleModelConnectionHintEClass = createEClass(SIMPLE_MODEL_CONNECTION_HINT);
		createEOperation(simpleModelConnectionHintEClass, SIMPLE_MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES);

		complexModelConnectionHintEClass = createEClass(COMPLEX_MODEL_CONNECTION_HINT);
		createEReference(complexModelConnectionHintEClass, COMPLEX_MODEL_CONNECTION_HINT__SOURCE_ELEMENTS);
		createEOperation(complexModelConnectionHintEClass, COMPLEX_MODEL_CONNECTION_HINT___GET_LOCAL_SOURCE_ELEMENTS);
		createEOperation(complexModelConnectionHintEClass, COMPLEX_MODEL_CONNECTION_HINT___GET_SOURCE_ATTRIBUTES);

		complexModelConnectionHintSourceElementEClass = createEClass(COMPLEX_MODEL_CONNECTION_HINT_SOURCE_ELEMENT);

		mappingHintTypeEClass = createEClass(MAPPING_HINT_TYPE);

		hintImporterMappingHintEClass = createEClass(HINT_IMPORTER_MAPPING_HINT);

		mappedAttributeValueExpanderEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_EXPANDER);
		createEReference(mappedAttributeValueExpanderEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND);

		mappedAttributeValueExpanderTypeEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE);
		createEReference(mappedAttributeValueExpanderTypeEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE);
		createEReference(mappedAttributeValueExpanderTypeEClass, MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__MODIFIERS);

		mappedAttributeValuePrependerEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_PREPENDER);

		mappedAttributeValueAppenderEClass = createEClass(MAPPED_ATTRIBUTE_VALUE_APPENDER);

		globalAttributeEClass = createEClass(GLOBAL_ATTRIBUTE);
		createEReference(globalAttributeEClass, GLOBAL_ATTRIBUTE__SOURCE);
		createEReference(globalAttributeEClass, GLOBAL_ATTRIBUTE__MODIFIER);

		globalAttributeImporterEClass = createEClass(GLOBAL_ATTRIBUTE_IMPORTER);
		createEReference(globalAttributeImporterEClass, GLOBAL_ATTRIBUTE_IMPORTER__GLOBAL_ATTRIBUTE);

		attributeMappingSourceInterfaceEClass = createEClass(ATTRIBUTE_MAPPING_SOURCE_INTERFACE);

		complexMappingHintSourceInterfaceEClass = createEClass(COMPLEX_MAPPING_HINT_SOURCE_INTERFACE);
		createEOperation(complexMappingHintSourceInterfaceEClass, COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_SOURCE_ATTRIBUTE);
		createEOperation(complexMappingHintSourceInterfaceEClass, COMPLEX_MAPPING_HINT_SOURCE_INTERFACE___GET_NAME);

		complexAttributeMatcherSourceInterfaceEClass = createEClass(COMPLEX_ATTRIBUTE_MATCHER_SOURCE_INTERFACE);

		complexModelConnectionHintSourceInterfaceEClass = createEClass(COMPLEX_MODEL_CONNECTION_HINT_SOURCE_INTERFACE);

		complexAttributeMappingExternalSourceElementEClass = createEClass(COMPLEX_ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT);

		externalAttributeMappingSourceElementEClass = createEClass(EXTERNAL_ATTRIBUTE_MAPPING_SOURCE_ELEMENT);

		complexModelConnectionHintExternalSourceElementEClass = createEClass(COMPLEX_MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT);

		complexAttributeMatcherExternalSourceElementEClass = createEClass(COMPLEX_ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT);

		externalMappedAttributeValueExpanderEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER);

		externalMappedAttributeValuePrependerEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER);

		externalMappedAttributeValueAppenderEClass = createEClass(EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER);

		expandableHintEClass = createEClass(EXPANDABLE_HINT);

		matchToLowerCaseConverterEClass = createEClass(MATCH_TO_LOWER_CASE_CONVERTER);
		createEAttribute(matchToLowerCaseConverterEClass, MATCH_TO_LOWER_CASE_CONVERTER__REGEX);

		matchToUpperCaseConverterEClass = createEClass(MATCH_TO_UPPER_CASE_CONVERTER);
		createEAttribute(matchToUpperCaseConverterEClass, MATCH_TO_UPPER_CASE_CONVERTER__REGEX);

		globalValueEClass = createEClass(GLOBAL_VALUE);
		createEAttribute(globalValueEClass, GLOBAL_VALUE__VALUE);
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
		ConditionPackage theConditionPackage = (ConditionPackage)EPackage.Registry.INSTANCE.getEPackage(ConditionPackage.eNS_URI);
		PamtramPackage thePamtramPackage = (PamtramPackage)EPackage.Registry.INSTANCE.getEPackage(PamtramPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mappingEClass.getESuperTypes().add(this.getMappingType());
		mappingTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintEClass.getESuperTypes().add(this.getMappingHintType());
		attributeMappingEClass.getESuperTypes().add(this.getMappingHint());
		attributeMappingEClass.getESuperTypes().add(this.getExpandableHint());
		cardinalityMappingEClass.getESuperTypes().add(this.getMappingHint());
		mappingInstanceSelectorEClass.getESuperTypes().add(this.getMappingHint());
		attributeMatcherEClass.getESuperTypes().add(this.getMatcher());
		attributeMatcherEClass.getESuperTypes().add(this.getExpandableHint());
		classMatcherEClass.getESuperTypes().add(this.getMatcher());
		attributeValueModifierEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		substringReplacerEClass.getESuperTypes().add(this.getAttributeValueModifier());
		stringAppenderEClass.getESuperTypes().add(this.getAttributeValueModifier());
		uniqueNumberAppenderEClass.getESuperTypes().add(this.getAttributeValueModifier());
		stringPrependerEClass.getESuperTypes().add(this.getAttributeValueModifier());
		attributeValueModifierSetEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintGroupEClass.getESuperTypes().add(this.getMappingHintGroupType());
		mappingHintGroupEClass.getESuperTypes().add(this.getInstantiableMappingHintGroup());
		mappingHintGroupTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		instantiableMappingHintGroupEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintGroupImporterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		mappingHintGroupImporterEClass.getESuperTypes().add(this.getInstantiableMappingHintGroup());
		exportedMappingHintGroupEClass.getESuperTypes().add(this.getMappingHintGroupType());
		modelConnectionHintEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		attributeMappingSourceElementEClass.getESuperTypes().add(this.getAttributeMappingSourceElementType());
		attributeMappingSourceElementEClass.getESuperTypes().add(this.getAttributeMappingSourceInterface());
		attributeMappingSourceElementTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		complexAttributeMatcherEClass.getESuperTypes().add(this.getAttributeMatcher());
		simpleAttributeMatcherEClass.getESuperTypes().add(this.getAttributeMatcher());
		simpleAttributeMatcherEClass.getESuperTypes().add(this.getAttributeMappingSourceElementType());
		complexAttributeMatcherSourceElementEClass.getESuperTypes().add(this.getAttributeMappingSourceElementType());
		complexAttributeMatcherSourceElementEClass.getESuperTypes().add(this.getComplexAttributeMatcherSourceInterface());
		simpleModelConnectionHintEClass.getESuperTypes().add(this.getModelConnectionHint());
		simpleModelConnectionHintEClass.getESuperTypes().add(this.getAttributeMappingSourceElementType());
		complexModelConnectionHintEClass.getESuperTypes().add(this.getModelConnectionHint());
		complexModelConnectionHintSourceElementEClass.getESuperTypes().add(this.getAttributeMappingSourceElementType());
		complexModelConnectionHintSourceElementEClass.getESuperTypes().add(this.getComplexModelConnectionHintSourceInterface());
		mappingHintTypeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		hintImporterMappingHintEClass.getESuperTypes().add(this.getMappingHintType());
		mappedAttributeValueExpanderEClass.getESuperTypes().add(this.getMappedAttributeValueExpanderType());
		mappedAttributeValueExpanderTypeEClass.getESuperTypes().add(this.getHintImporterMappingHint());
		mappedAttributeValuePrependerEClass.getESuperTypes().add(this.getMappedAttributeValueExpander());
		mappedAttributeValueAppenderEClass.getESuperTypes().add(this.getMappedAttributeValueExpander());
		globalAttributeEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		globalAttributeImporterEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());
		globalAttributeImporterEClass.getESuperTypes().add(this.getAttributeMappingSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(this.getComplexAttributeMatcherSourceInterface());
		globalAttributeImporterEClass.getESuperTypes().add(this.getComplexModelConnectionHintSourceInterface());
		attributeMappingSourceInterfaceEClass.getESuperTypes().add(this.getComplexMappingHintSourceInterface());
		complexAttributeMatcherSourceInterfaceEClass.getESuperTypes().add(this.getComplexMappingHintSourceInterface());
		complexModelConnectionHintSourceInterfaceEClass.getESuperTypes().add(this.getComplexMappingHintSourceInterface());
		complexAttributeMappingExternalSourceElementEClass.getESuperTypes().add(this.getExternalAttributeMappingSourceElement());
		complexAttributeMappingExternalSourceElementEClass.getESuperTypes().add(this.getAttributeMappingSourceInterface());
		externalAttributeMappingSourceElementEClass.getESuperTypes().add(this.getAttributeMappingSourceElementType());
		complexModelConnectionHintExternalSourceElementEClass.getESuperTypes().add(this.getExternalAttributeMappingSourceElement());
		complexModelConnectionHintExternalSourceElementEClass.getESuperTypes().add(this.getComplexModelConnectionHintSourceInterface());
		complexAttributeMatcherExternalSourceElementEClass.getESuperTypes().add(this.getExternalAttributeMappingSourceElement());
		complexAttributeMatcherExternalSourceElementEClass.getESuperTypes().add(this.getComplexAttributeMatcherSourceInterface());
		externalMappedAttributeValueExpanderEClass.getESuperTypes().add(this.getMappedAttributeValueExpander());
		externalMappedAttributeValuePrependerEClass.getESuperTypes().add(this.getExternalMappedAttributeValueExpander());
		externalMappedAttributeValueAppenderEClass.getESuperTypes().add(this.getExternalMappedAttributeValueExpander());
		matchToLowerCaseConverterEClass.getESuperTypes().add(this.getAttributeValueModifier());
		matchToUpperCaseConverterEClass.getESuperTypes().add(this.getAttributeValueModifier());
		globalValueEClass.getESuperTypes().add(thePamtramPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_Condition(), theConditionPackage.getComplexCondition(), null, "condition", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_MappingHintGroups(), this.getMappingHintGroupType(), null, "mappingHintGroups", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_ImportedMappingHintGroups(), this.getMappingHintGroupImporter(), null, "importedMappingHintGroups", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_GlobalVariables(), this.getGlobalAttribute(), null, "globalVariables", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingTypeEClass, MappingType.class, "MappingType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingType_SourceMMSection(), theMetamodelPackage.getSourceSectionClass(), null, "sourceMMSection", null, 1, 1, MappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingHintEClass, MappingHint.class, "MappingHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingEClass, AttributeMapping.class, "AttributeMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMapping_Target(), theMetamodelPackage.getTargetSectionAttribute(), null, "target", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMapping_SourceAttributeMappings(), this.getAttributeMappingSourceInterface(), null, "sourceAttributeMappings", null, 1, -1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeMapping_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMapping_ResultModifier(), this.getAttributeValueModifierSet(), null, "resultModifier", null, 0, -1, AttributeMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAttributeMapping__GetLocalSourceElements(), this.getAttributeMappingSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(cardinalityMappingEClass, CardinalityMapping.class, "CardinalityMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCardinalityMapping_Source(), theMetamodelPackage.getSourceSectionClass(), null, "source", null, 1, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCardinalityMapping_Target(), theMetamodelPackage.getTargetSectionClass(), null, "target", null, 1, 1, CardinalityMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingInstanceSelectorEClass, MappingInstanceSelector.class, "MappingInstanceSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingInstanceSelector_AffectedReference(), theMetamodelPackage.getTargetSectionNonContainmentReference(), null, "affectedReference", null, 1, 1, MappingInstanceSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingInstanceSelector_Matcher(), this.getMatcher(), null, "matcher", null, 1, 1, MappingInstanceSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matcherEClass, Matcher.class, "Matcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMatcherEClass, AttributeMatcher.class, "AttributeMatcher", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMatcher_TargetAttribute(), theMetamodelPackage.getTargetSectionAttribute(), null, "targetAttribute", null, 1, 1, AttributeMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classMatcherEClass, ClassMatcher.class, "ClassMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassMatcher_TargetClass(), theMetamodelPackage.getTargetSectionClass(), null, "targetClass", null, 1, 1, ClassMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeValueModifierEClass, AttributeValueModifier.class, "AttributeValueModifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getAttributeValueModifier__ModifyValue__String(), ecorePackage.getEString(), "modifyValue", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(substringReplacerEClass, SubstringReplacer.class, "SubstringReplacer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubstringReplacer_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, SubstringReplacer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubstringReplacer_Replacement(), ecorePackage.getEString(), "replacement", null, 1, 1, SubstringReplacer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringAppenderEClass, StringAppender.class, "StringAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringAppender_String(), ecorePackage.getEString(), "string", "", 1, 1, StringAppender.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uniqueNumberAppenderEClass, UniqueNumberAppender.class, "UniqueNumberAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringPrependerEClass, StringPrepender.class, "StringPrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringPrepender_String(), ecorePackage.getEString(), "string", "", 1, 1, StringPrepender.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeValueModifierSetEClass, AttributeValueModifierSet.class, "AttributeValueModifierSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeValueModifierSet_Modifier(), this.getAttributeValueModifier(), null, "modifier", null, 0, -1, AttributeValueModifierSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingHintGroupEClass, MappingHintGroup.class, "MappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroup_ModelConnectionMatcher(), this.getModelConnectionHint(), null, "modelConnectionMatcher", null, 0, 1, MappingHintGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingHintGroupTypeEClass, MappingHintGroupType.class, "MappingHintGroupType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroupType_TargetMMSection(), theMetamodelPackage.getTargetSectionClass(), null, "targetMMSection", null, 1, 1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupType_MappingHints(), this.getMappingHint(), null, "mappingHints", null, 0, -1, MappingHintGroupType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instantiableMappingHintGroupEClass, InstantiableMappingHintGroup.class, "InstantiableMappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintGroupImporterEClass, MappingHintGroupImporter.class, "MappingHintGroupImporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingHintGroupImporter_HintGroup(), this.getExportedMappingHintGroup(), null, "hintGroup", null, 1, 1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupImporter_Container(), theMetamodelPackage.getTargetSectionClass(), null, "container", null, 0, 1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingHintGroupImporter_MappingHints(), this.getMappingHintType(), null, "mappingHints", null, 0, -1, MappingHintGroupImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exportedMappingHintGroupEClass, ExportedMappingHintGroup.class, "ExportedMappingHintGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelConnectionHintEClass, ModelConnectionHint.class, "ModelConnectionHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelConnectionHint_TargetAttributes(), this.getConnectionHintTargetAttribute(), null, "targetAttributes", null, 1, -1, ModelConnectionHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelConnectionHint__GetSourceAttributes(), theMetamodelPackage.getSourceSectionAttribute(), "getSourceAttributes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(connectionHintTargetAttributeEClass, ConnectionHintTargetAttribute.class, "ConnectionHintTargetAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionHintTargetAttribute_TargetAttribute(), theMetamodelPackage.getTargetSectionAttribute(), null, "targetAttribute", null, 1, 1, ConnectionHintTargetAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionHintTargetAttribute_Modifier(), this.getAttributeValueModifierSet(), null, "modifier", null, 0, -1, ConnectionHintTargetAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMappingSourceElementEClass, AttributeMappingSourceElement.class, "AttributeMappingSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeMappingSourceElementTypeEClass, AttributeMappingSourceElementType.class, "AttributeMappingSourceElementType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeMappingSourceElementType_Source(), theMetamodelPackage.getSourceSectionAttribute(), null, "source", null, 1, 1, AttributeMappingSourceElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeMappingSourceElementType_Modifier(), this.getAttributeValueModifierSet(), null, "modifier", null, 0, -1, AttributeMappingSourceElementType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexAttributeMatcherEClass, ComplexAttributeMatcher.class, "ComplexAttributeMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexAttributeMatcher_SourceAttributes(), this.getComplexAttributeMatcherSourceInterface(), null, "sourceAttributes", null, 1, -1, ComplexAttributeMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getComplexAttributeMatcher__GetLocalSourceElements(), this.getComplexAttributeMatcherSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(simpleAttributeMatcherEClass, SimpleAttributeMatcher.class, "SimpleAttributeMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexAttributeMatcherSourceElementEClass, ComplexAttributeMatcherSourceElement.class, "ComplexAttributeMatcherSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleModelConnectionHintEClass, SimpleModelConnectionHint.class, "SimpleModelConnectionHint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getSimpleModelConnectionHint__GetSourceAttributes(), theMetamodelPackage.getSourceSectionAttribute(), "getSourceAttributes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(complexModelConnectionHintEClass, ComplexModelConnectionHint.class, "ComplexModelConnectionHint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexModelConnectionHint_SourceElements(), this.getComplexModelConnectionHintSourceInterface(), null, "sourceElements", null, 1, -1, ComplexModelConnectionHint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getComplexModelConnectionHint__GetLocalSourceElements(), this.getComplexModelConnectionHintSourceElement(), "getLocalSourceElements", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getComplexModelConnectionHint__GetSourceAttributes(), theMetamodelPackage.getSourceSectionAttribute(), "getSourceAttributes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(complexModelConnectionHintSourceElementEClass, ComplexModelConnectionHintSourceElement.class, "ComplexModelConnectionHintSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingHintTypeEClass, MappingHintType.class, "MappingHintType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hintImporterMappingHintEClass, HintImporterMappingHint.class, "HintImporterMappingHint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValueExpanderEClass, MappedAttributeValueExpander.class, "MappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedAttributeValueExpander_HintsToExpand(), this.getExpandableHint(), null, "hintsToExpand", null, 1, -1, MappedAttributeValueExpander.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedAttributeValueExpanderTypeEClass, MappedAttributeValueExpanderType.class, "MappedAttributeValueExpanderType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedAttributeValueExpanderType_SourceAttribute(), theMetamodelPackage.getSourceSectionAttribute(), null, "sourceAttribute", null, 1, 1, MappedAttributeValueExpanderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedAttributeValueExpanderType_Modifiers(), this.getAttributeValueModifierSet(), null, "modifiers", null, 0, -1, MappedAttributeValueExpanderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedAttributeValuePrependerEClass, MappedAttributeValuePrepender.class, "MappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappedAttributeValueAppenderEClass, MappedAttributeValueAppender.class, "MappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(globalAttributeEClass, GlobalAttribute.class, "GlobalAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalAttribute_Source(), theMetamodelPackage.getSourceSectionAttribute(), null, "source", null, 1, 1, GlobalAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGlobalAttribute_Modifier(), this.getAttributeValueModifierSet(), null, "modifier", null, 0, -1, GlobalAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalAttributeImporterEClass, GlobalAttributeImporter.class, "GlobalAttributeImporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGlobalAttributeImporter_GlobalAttribute(), this.getGlobalAttribute(), null, "globalAttribute", null, 1, 1, GlobalAttributeImporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeMappingSourceInterfaceEClass, AttributeMappingSourceInterface.class, "AttributeMappingSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexMappingHintSourceInterfaceEClass, ComplexMappingHintSourceInterface.class, "ComplexMappingHintSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getComplexMappingHintSourceInterface__GetSourceAttribute(), theMetamodelPackage.getSourceSectionAttribute(), "getSourceAttribute", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getComplexMappingHintSourceInterface__GetName(), ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(complexAttributeMatcherSourceInterfaceEClass, ComplexAttributeMatcherSourceInterface.class, "ComplexAttributeMatcherSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexModelConnectionHintSourceInterfaceEClass, ComplexModelConnectionHintSourceInterface.class, "ComplexModelConnectionHintSourceInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexAttributeMappingExternalSourceElementEClass, ComplexAttributeMappingExternalSourceElement.class, "ComplexAttributeMappingExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalAttributeMappingSourceElementEClass, ExternalAttributeMappingSourceElement.class, "ExternalAttributeMappingSourceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexModelConnectionHintExternalSourceElementEClass, ComplexModelConnectionHintExternalSourceElement.class, "ComplexModelConnectionHintExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexAttributeMatcherExternalSourceElementEClass, ComplexAttributeMatcherExternalSourceElement.class, "ComplexAttributeMatcherExternalSourceElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueExpanderEClass, ExternalMappedAttributeValueExpander.class, "ExternalMappedAttributeValueExpander", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValuePrependerEClass, ExternalMappedAttributeValuePrepender.class, "ExternalMappedAttributeValuePrepender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(externalMappedAttributeValueAppenderEClass, ExternalMappedAttributeValueAppender.class, "ExternalMappedAttributeValueAppender", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expandableHintEClass, ExpandableHint.class, "ExpandableHint", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(matchToLowerCaseConverterEClass, MatchToLowerCaseConverter.class, "MatchToLowerCaseConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchToLowerCaseConverter_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, MatchToLowerCaseConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchToUpperCaseConverterEClass, MatchToUpperCaseConverter.class, "MatchToUpperCaseConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchToUpperCaseConverter_Regex(), ecorePackage.getEString(), "regex", null, 1, 1, MatchToUpperCaseConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(globalValueEClass, GlobalValue.class, "GlobalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGlobalValue_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, GlobalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
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
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });	
		addAnnotation
		  (attributeMappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceAttributeMatchesSection\r\ntargetAttributeMatchesSection"
		   });	
		addAnnotation
		  (cardinalityMappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "sourceClassMatchesSection\r\nsourceClassIsVariableCardinality\r\ntargetClassMatchesSection\r\ntargetClassIsVariableCardinality"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";	
		addAnnotation
		  (attributeMappingEClass, 
		   source, 
		   new String[] {
			 "sourceAttributeMatchesSection", "",
			 "targetAttributeMatchesSection", "\n"
		   });	
		addAnnotation
		  (cardinalityMappingEClass, 
		   source, 
		   new String[] {
		   });
	}

} //MappingPackageImpl
