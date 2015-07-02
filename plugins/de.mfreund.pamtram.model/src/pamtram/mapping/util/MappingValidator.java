/**
 */
package pamtram.mapping.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.xtext.oclinecore.validation.OCLinEcoreEObjectValidator;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingExternalSourceElement;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.AttributeValueModifier;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ExternalMappedAttributeValueAppender;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.HintImporterMappingHint;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.LocalMappedAttributeValueExpander;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappedAttributeValueAppender;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingType;
import pamtram.mapping.MatchToLowerCaseConverter;
import pamtram.mapping.MatchToUpperCaseConverter;
import pamtram.mapping.Matcher;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintExternalSourceElement;
import pamtram.mapping.ModelConnectionHintSourceElement;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.mapping.StringAppender;
import pamtram.mapping.StringPrepender;
import pamtram.mapping.SubstringReplacer;
import pamtram.mapping.UniqueNumberAppender;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated NOT
 */
public class MappingValidator extends OCLinEcoreEObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MappingValidator INSTANCE = new MappingValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "pamtram.mapping";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return MappingPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case MappingPackage.MAPPING_TYPE:
			return validateMappingType((MappingType)value, diagnostics, context);
		case MappingPackage.MAPPING:
			return validateMapping((Mapping)value, diagnostics, context);
		case MappingPackage.MAPPING_HINT_GROUP_TYPE:
			return validateMappingHintGroupType((MappingHintGroupType)value, diagnostics, context);
		case MappingPackage.INSTANTIABLE_MAPPING_HINT_GROUP:
			return validateInstantiableMappingHintGroup((InstantiableMappingHintGroup)value, diagnostics, context);
		case MappingPackage.MAPPING_HINT_GROUP:
			return validateMappingHintGroup((MappingHintGroup)value, diagnostics, context);
		case MappingPackage.MAPPING_HINT_BASE_TYPE:
			return validateMappingHintBaseType((MappingHintBaseType)value, diagnostics, context);
		case MappingPackage.MAPPING_HINT:
			return validateMappingHint((MappingHint)value, diagnostics, context);
		case MappingPackage.EXPRESSION_HINT:
			return validateExpressionHint((ExpressionHint)value, diagnostics, context);
		case MappingPackage.MODIFIABLE_HINT:
			return validateModifiableHint((ModifiableHint)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MAPPING:
			return validateAttributeMapping((AttributeMapping)value, diagnostics, context);
		case MappingPackage.CARDINALITY_MAPPING:
			return validateCardinalityMapping((CardinalityMapping)value, diagnostics, context);
		case MappingPackage.MAPPING_INSTANCE_SELECTOR:
			return validateMappingInstanceSelector((MappingInstanceSelector)value, diagnostics, context);
		case MappingPackage.MATCHER:
			return validateMatcher((Matcher)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MATCHER:
			return validateAttributeMatcher((AttributeMatcher)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_ELEMENT:
			return validateAttributeMatcherSourceElement((AttributeMatcherSourceElement)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_INTERFACE:
			return validateAttributeMatcherSourceInterface((AttributeMatcherSourceInterface)value, diagnostics, context);
		case MappingPackage.CLASS_MATCHER:
			return validateClassMatcher((ClassMatcher)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_VALUE_MODIFIER_SET:
			return validateAttributeValueModifierSet((AttributeValueModifierSet)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_VALUE_MODIFIER:
			return validateAttributeValueModifier((AttributeValueModifier)value, diagnostics, context);
		case MappingPackage.SUBSTRING_REPLACER:
			return validateSubstringReplacer((SubstringReplacer)value, diagnostics, context);
		case MappingPackage.STRING_APPENDER:
			return validateStringAppender((StringAppender)value, diagnostics, context);
		case MappingPackage.UNIQUE_NUMBER_APPENDER:
			return validateUniqueNumberAppender((UniqueNumberAppender)value, diagnostics, context);
		case MappingPackage.STRING_PREPENDER:
			return validateStringPrepender((StringPrepender)value, diagnostics, context);
		case MappingPackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
			return validateModifiedAttributeElementType((ModifiedAttributeElementType<?, ?, ?>)value, diagnostics, context);
		case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
			return validateLocalModifiedAttributeElementType((LocalModifiedAttributeElementType<?, ?, ?>)value, diagnostics, context);
		case MappingPackage.MAPPING_HINT_GROUP_IMPORTER:
			return validateMappingHintGroupImporter((MappingHintGroupImporter)value, diagnostics, context);
		case MappingPackage.EXPORTED_MAPPING_HINT_GROUP:
			return validateExportedMappingHintGroup((ExportedMappingHintGroup)value, diagnostics, context);
		case MappingPackage.MODEL_CONNECTION_HINT:
			return validateModelConnectionHint((ModelConnectionHint)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT:
			return validateAttributeMappingSourceElement((AttributeMappingSourceElement)value, diagnostics, context);
		case MappingPackage.MODEL_CONNECTION_HINT_SOURCE_ELEMENT:
			return validateModelConnectionHintSourceElement((ModelConnectionHintSourceElement)value, diagnostics, context);
		case MappingPackage.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE:
			return validateModelConnectionHintTargetAttribute((ModelConnectionHintTargetAttribute)value, diagnostics, context);
		case MappingPackage.MAPPING_HINT_TYPE:
			return validateMappingHintType((MappingHintType)value, diagnostics, context);
		case MappingPackage.HINT_IMPORTER_MAPPING_HINT:
			return validateHintImporterMappingHint((HintImporterMappingHint)value, diagnostics, context);
		case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER:
			return validateMappedAttributeValueExpander((MappedAttributeValueExpander)value, diagnostics, context);
		case MappingPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
			return validateLocalMappedAttributeValueExpander((LocalMappedAttributeValueExpander)value, diagnostics, context);
		case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER:
			return validateMappedAttributeValuePrepender((MappedAttributeValuePrepender)value, diagnostics, context);
		case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER:
			return validateMappedAttributeValueAppender((MappedAttributeValueAppender)value, diagnostics, context);
		case MappingPackage.GLOBAL_ATTRIBUTE:
			return validateGlobalAttribute((GlobalAttribute)value, diagnostics, context);
		case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER:
			return validateGlobalAttributeImporter((GlobalAttributeImporter)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE:
			return validateAttributeMappingSourceInterface((AttributeMappingSourceInterface)value, diagnostics, context);
		case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE:
			return validateMappingHintSourceInterface((MappingHintSourceInterface)value, diagnostics, context);
		case MappingPackage.MODEL_CONNECTION_HINT_SOURCE_INTERFACE:
			return validateModelConnectionHintSourceInterface((ModelConnectionHintSourceInterface)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT:
			return validateAttributeMappingExternalSourceElement((AttributeMappingExternalSourceElement)value, diagnostics, context);
		case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE:
			return validateExternalModifiedAttributeElementType((ExternalModifiedAttributeElementType<?, ?, ?>)value, diagnostics, context);
		case MappingPackage.MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT:
			return validateModelConnectionHintExternalSourceElement((ModelConnectionHintExternalSourceElement)value, diagnostics, context);
		case MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT:
			return validateAttributeMatcherExternalSourceElement((AttributeMatcherExternalSourceElement)value, diagnostics, context);
		case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER:
			return validateExternalMappedAttributeValueExpander((ExternalMappedAttributeValueExpander)value, diagnostics, context);
		case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER:
			return validateExternalMappedAttributeValuePrepender((ExternalMappedAttributeValuePrepender)value, diagnostics, context);
		case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER:
			return validateExternalMappedAttributeValueAppender((ExternalMappedAttributeValueAppender)value, diagnostics, context);
		case MappingPackage.EXPANDABLE_HINT:
			return validateExpandableHint((ExpandableHint)value, diagnostics, context);
		case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER:
			return validateMatchToLowerCaseConverter((MatchToLowerCaseConverter)value, diagnostics, context);
		case MappingPackage.MATCH_TO_UPPER_CASE_CONVERTER:
			return validateMatchToUpperCaseConverter((MatchToUpperCaseConverter)value, diagnostics, context);
		case MappingPackage.GLOBAL_VALUE:
			return validateGlobalValue((GlobalValue)value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingType(MappingType mappingType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mapping, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroupType(MappingHintGroupType mappingHintGroupType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintGroupType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInstantiableMappingHintGroup(InstantiableMappingHintGroup instantiableMappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(instantiableMappingHintGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroup(MappingHintGroup mappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintBaseType(MappingHintBaseType mappingHintBaseType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintBaseType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHint(MappingHint mappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionHint(ExpressionHint expressionHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModifiableHint(ModifiableHint modifiableHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modifiableHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMapping, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(attributeMapping, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(attributeMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateAttributeMapping_targetAttributeMatchesSection(attributeMapping, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the targetAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ATTRIBUTE_MAPPING__TARGET_ATTRIBUTE_MATCHES_SECTION__EEXPRESSION = "self.target.getContainingSection() = self.oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection";

	/**
	 * Validates the targetAttributeMatchesSection constraint of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMapping_targetAttributeMatchesSection(AttributeMapping attributeMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.ATTRIBUTE_MAPPING,
						attributeMapping,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"targetAttributeMatchesSection",
						ATTRIBUTE_MAPPING__TARGET_ATTRIBUTE_MATCHES_SECTION__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(cardinalityMapping, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(cardinalityMapping, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateCardinalityMapping_sourceClassMatchesSection(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateCardinalityMapping_sourceClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateCardinalityMapping_targetClassMatchesSection(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateCardinalityMapping_targetClassIsVariableCardinality(cardinalityMapping, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateCardinalityMapping_noCardinalityMappingForSourceSectionRoot(cardinalityMapping, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the sourceClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CARDINALITY_MAPPING__SOURCE_CLASS_MATCHES_SECTION__EEXPRESSION = "self.source.getContainingSection() = self.oclContainer().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection";

	/**
	 * Validates the sourceClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_sourceClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.CARDINALITY_MAPPING,
						cardinalityMapping,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"sourceClassMatchesSection",
						CARDINALITY_MAPPING__SOURCE_CLASS_MATCHES_SECTION__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * The cached validation expression for the sourceClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CARDINALITY_MAPPING__SOURCE_CLASS_IS_VARIABLE_CARDINALITY__EEXPRESSION = "self.source.cardinality <> pamtram::metamodel::CardinalityType::ONE";

	/**
	 * Validates the sourceClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_sourceClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.CARDINALITY_MAPPING,
						cardinalityMapping,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"sourceClassIsVariableCardinality",
						CARDINALITY_MAPPING__SOURCE_CLASS_IS_VARIABLE_CARDINALITY__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * The cached validation expression for the targetClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CARDINALITY_MAPPING__TARGET_CLASS_MATCHES_SECTION__EEXPRESSION = "self.target.getContainingSection() = self.oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection";

	/**
	 * Validates the targetClassMatchesSection constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_targetClassMatchesSection(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.CARDINALITY_MAPPING,
						cardinalityMapping,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"targetClassMatchesSection",
						CARDINALITY_MAPPING__TARGET_CLASS_MATCHES_SECTION__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * The cached validation expression for the targetClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CARDINALITY_MAPPING__TARGET_CLASS_IS_VARIABLE_CARDINALITY__EEXPRESSION = "self.target.cardinality <> pamtram::metamodel::CardinalityType::ONE";

	/**
	 * Validates the targetClassIsVariableCardinality constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_targetClassIsVariableCardinality(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.CARDINALITY_MAPPING,
						cardinalityMapping,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"targetClassIsVariableCardinality",
						CARDINALITY_MAPPING__TARGET_CLASS_IS_VARIABLE_CARDINALITY__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * The cached validation expression for the noCardinalityMappingForSourceSectionRoot constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CARDINALITY_MAPPING__NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__EEXPRESSION = "self.source <> self.source.getContainingSection()";

	/**
	 * Validates the noCardinalityMappingForSourceSectionRoot constraint of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCardinalityMapping_noCardinalityMappingForSourceSectionRoot(CardinalityMapping cardinalityMapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.CARDINALITY_MAPPING,
						cardinalityMapping,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"noCardinalityMappingForSourceSectionRoot",
						CARDINALITY_MAPPING__NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingInstanceSelector(MappingInstanceSelector mappingInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappingInstanceSelector, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(mappingInstanceSelector, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateMappingInstanceSelector_affectedReferenceIsNonContainment(mappingInstanceSelector, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateMappingInstanceSelector_affectedReferenceMatchesSection(mappingInstanceSelector, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the affectedReferenceIsNonContainment constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE_IS_NON_CONTAINMENT__EEXPRESSION = "not self.affectedReference.eReference.oclAsType(ecore::EReference).containment";

	/**
	 * Validates the affectedReferenceIsNonContainment constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingInstanceSelector_affectedReferenceIsNonContainment(MappingInstanceSelector mappingInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.MAPPING_INSTANCE_SELECTOR,
						mappingInstanceSelector,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"affectedReferenceIsNonContainment",
						MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE_IS_NON_CONTAINMENT__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * The cached validation expression for the affectedReferenceMatchesSection constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE_MATCHES_SECTION__EEXPRESSION = "if self.oclContainer().oclIsKindOf(pamtram::mapping::MappingHintGroupType) then self.affectedReference.getContainingSection() = self.oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection else self.affectedReference.getContainingSection() = self.oclContainer().oclAsType(pamtram::mapping::MappingHintGroupImporter).hintGroup.targetMMSection endif";

	/**
	 * Validates the affectedReferenceMatchesSection constraint of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingInstanceSelector_affectedReferenceMatchesSection(MappingInstanceSelector mappingInstanceSelector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.MAPPING_INSTANCE_SELECTOR,
						mappingInstanceSelector,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"affectedReferenceMatchesSection",
						MAPPING_INSTANCE_SELECTOR__AFFECTED_REFERENCE_MATCHES_SECTION__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatcher(Matcher matcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcher(AttributeMatcher attributeMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMatcher, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(attributeMatcher, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(attributeMatcher, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateAttributeMatcher_targetMatchesAffectedReferenceType(attributeMatcher, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the targetMatchesAffectedReferenceType constraint of '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ATTRIBUTE_MATCHER__TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__EEXPRESSION = "self.oclContainer().oclAsType(pamtram::mapping::MappingInstanceSelector).affectedReference.eReference.oclAsType(ecore::EReference).eReferenceType.oclAsType(ecore::EClass).isSuperTypeOf(self.targetAttribute.oclContainer().oclAsType(pamtram::metamodel::Class).eClass)";

	/**
	 * Validates the targetMatchesAffectedReferenceType constraint of '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcher_targetMatchesAffectedReferenceType(AttributeMatcher attributeMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.ATTRIBUTE_MATCHER,
						attributeMatcher,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"targetMatchesAffectedReferenceType",
						ATTRIBUTE_MATCHER__TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherSourceElement(AttributeMatcherSourceElement attributeMatcherSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMatcherSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(attributeMatcherSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(attributeMatcherSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMatcherSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherSourceInterface(AttributeMatcherSourceInterface attributeMatcherSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMatcherSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateClassMatcher(ClassMatcher classMatcher, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(classMatcher, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValueModifierSet(AttributeValueModifierSet attributeValueModifierSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeValueModifierSet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeValueModifier(AttributeValueModifier attributeValueModifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeValueModifier, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubstringReplacer(SubstringReplacer substringReplacer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(substringReplacer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringAppender(StringAppender stringAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringAppender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUniqueNumberAppender(UniqueNumberAppender uniqueNumberAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(uniqueNumberAppender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringPrepender(StringPrepender stringPrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringPrepender, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModifiedAttributeElementType(ModifiedAttributeElementType<?, ?, ?> modifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modifiedAttributeElementType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<?, ?, ?> localModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(localModifiedAttributeElementType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(localModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(localModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(localModifiedAttributeElementType, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the sourceAttributeMatchesSectionOrContainedSection constraint of '<em>Local Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__EEXPRESSION = "self.source.oclAsType(pamtram::metamodel::MetaModelElement).getContainingSection() = self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection or self.source.oclAsType(pamtram::metamodel::SourceSectionAttribute).getContainingSection().oclAsType(pamtram::metamodel::SourceSectionClass).isContainedIn(self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection)";

	/**
	 * Validates the sourceAttributeMatchesSectionOrContainedSection constraint of '<em>Local Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(LocalModifiedAttributeElementType<?, ?, ?> localModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE,
						localModifiedAttributeElementType,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"sourceAttributeMatchesSectionOrContainedSection",
						LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintGroupImporter(MappingHintGroupImporter mappingHintGroupImporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintGroupImporter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExportedMappingHintGroup(ExportedMappingHintGroup exportedMappingHintGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(exportedMappingHintGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHint(ModelConnectionHint modelConnectionHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelConnectionHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingSourceElement(AttributeMappingSourceElement attributeMappingSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMappingSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(attributeMappingSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(attributeMappingSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(attributeMappingSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintSourceElement(ModelConnectionHintSourceElement modelConnectionHintSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelConnectionHintSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modelConnectionHintSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modelConnectionHintSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modelConnectionHintSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modelConnectionHintSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modelConnectionHintSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modelConnectionHintSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modelConnectionHintSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modelConnectionHintSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(modelConnectionHintSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintTargetAttribute(ModelConnectionHintTargetAttribute modelConnectionHintTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelConnectionHintTargetAttribute, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modelConnectionHintTargetAttribute, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateModelConnectionHintTargetAttribute_sourceMatchesPossibleContainerType(modelConnectionHintTargetAttribute, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the sourceMatchesPossibleContainerType constraint of '<em>Model Connection Hint Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE__SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__EEXPRESSION = "self.source.oclContainer().oclAsType(pamtram::metamodel::Class).eClass.eAllContainments->exists(r : ecore::EReference | r.eReferenceType.isSuperTypeOf(self.oclContainer().oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection.eClass))";

	/**
	 * Validates the sourceMatchesPossibleContainerType constraint of '<em>Model Connection Hint Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintTargetAttribute_sourceMatchesPossibleContainerType(ModelConnectionHintTargetAttribute modelConnectionHintTargetAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE,
						modelConnectionHintTargetAttribute,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"sourceMatchesPossibleContainerType",
						MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE__SOURCE_MATCHES_POSSIBLE_CONTAINER_TYPE__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintType(MappingHintType mappingHintType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHintImporterMappingHint(HintImporterMappingHint hintImporterMappingHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(hintImporterMappingHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValueExpander(MappedAttributeValueExpander mappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappedAttributeValueExpander, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLocalMappedAttributeValueExpander(LocalMappedAttributeValueExpander localMappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(localMappedAttributeValueExpander, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(localMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(localMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(localMappedAttributeValueExpander, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValuePrepender(MappedAttributeValuePrepender mappedAttributeValuePrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappedAttributeValuePrepender, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(mappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(mappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValuePrepender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappedAttributeValueAppender(MappedAttributeValueAppender mappedAttributeValueAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(mappedAttributeValueAppender, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(mappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(mappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateLocalModifiedAttributeElementType_sourceAttributeMatchesSectionOrContainedSection(mappedAttributeValueAppender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttribute(GlobalAttribute globalAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(globalAttribute, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(globalAttribute, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(globalAttribute, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateGlobalAttribute_sourceAttributeHasUpperBoundOne(globalAttribute, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the sourceAttributeHasUpperBoundOne constraint of '<em>Global Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String GLOBAL_ATTRIBUTE__SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__EEXPRESSION = "self.source.attribute.upperBound = 1";

	/**
	 * Validates the sourceAttributeHasUpperBoundOne constraint of '<em>Global Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttribute_sourceAttributeHasUpperBoundOne(GlobalAttribute globalAttribute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.GLOBAL_ATTRIBUTE,
						globalAttribute,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"sourceAttributeHasUpperBoundOne",
						GLOBAL_ATTRIBUTE__SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalAttributeImporter(GlobalAttributeImporter globalAttributeImporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(globalAttributeImporter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingSourceInterface(AttributeMappingSourceInterface attributeMappingSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(attributeMappingSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingHintSourceInterface(MappingHintSourceInterface mappingHintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingHintSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintSourceInterface(ModelConnectionHintSourceInterface modelConnectionHintSourceInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelConnectionHintSourceInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMappingExternalSourceElement(AttributeMappingExternalSourceElement attributeMappingExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMappingExternalSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(attributeMappingExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(attributeMappingExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMappingExternalSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<?, ?, ?> externalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalModifiedAttributeElementType, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(externalModifiedAttributeElementType, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(externalModifiedAttributeElementType, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalModifiedAttributeElementType, diagnostics, context);
		}
		return result;
	}

	/**
	 * The cached validation expression for the sourceAttributeMatchesContainerSection constraint of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__EEXPRESSION = "self.source.oclAsType(pamtram::metamodel::SourceSectionAttribute).getContainingSection().oclAsType(pamtram::metamodel::SourceSectionClass).isContainerFor(self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection.oclAsType(pamtram::metamodel::SourceSectionClass))";

	/**
	 * Validates the sourceAttributeMatchesContainerSection constraint of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(ExternalModifiedAttributeElementType<?, ?, ?> externalModifiedAttributeElementType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
				validate
				(MappingPackage.Literals.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE,
						externalModifiedAttributeElementType,
						diagnostics,
						context,
						"http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
						"sourceAttributeMatchesContainerSection",
						EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE_ATTRIBUTE_MATCHES_CONTAINER_SECTION__EEXPRESSION,
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelConnectionHintExternalSourceElement(ModelConnectionHintExternalSourceElement modelConnectionHintExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(modelConnectionHintExternalSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(modelConnectionHintExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(modelConnectionHintExternalSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributeMatcherExternalSourceElement(AttributeMatcherExternalSourceElement attributeMatcherExternalSourceElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(attributeMatcherExternalSourceElement, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(attributeMatcherExternalSourceElement, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(attributeMatcherExternalSourceElement, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValueExpander(ExternalMappedAttributeValueExpander externalMappedAttributeValueExpander, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalMappedAttributeValueExpander, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(externalMappedAttributeValueExpander, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(externalMappedAttributeValueExpander, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueExpander, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValuePrepender(ExternalMappedAttributeValuePrepender externalMappedAttributeValuePrepender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalMappedAttributeValuePrepender, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(externalMappedAttributeValuePrepender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValuePrepender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExternalMappedAttributeValueAppender(ExternalMappedAttributeValueAppender externalMappedAttributeValueAppender, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(externalMappedAttributeValueAppender, diagnostics, context)) {
			return false;
		}
		boolean result = validate_EveryMultiplicityConforms(externalMappedAttributeValueAppender, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(externalMappedAttributeValueAppender, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateExternalModifiedAttributeElementType_sourceAttributeMatchesContainerSection(externalMappedAttributeValueAppender, diagnostics, context);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpandableHint(ExpandableHint expandableHint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expandableHint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchToLowerCaseConverter(MatchToLowerCaseConverter matchToLowerCaseConverter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matchToLowerCaseConverter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMatchToUpperCaseConverter(MatchToUpperCaseConverter matchToUpperCaseConverter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(matchToUpperCaseConverter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGlobalValue(GlobalValue globalValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(globalValue, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MappingValidator
