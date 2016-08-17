/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.NamedElement;
import pamtram.mapping.*;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.ValueConstraintSourceInterface;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated
 */
public class MappingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MappingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSwitch() {
		if (modelPackage == null) {
			modelPackage = MappingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MappingPackage.MAPPING_TYPE: {
				MappingType mappingType = (MappingType)theEObject;
				T result = caseMappingType(mappingType);
				if (result == null) result = caseNamedElement(mappingType);
				if (result == null) result = caseDeactivatableElement(mappingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = caseMappingType(mapping);
				if (result == null) result = caseConditionalElement(mapping);
				if (result == null) result = caseNamedElement(mapping);
				if (result == null) result = caseDeactivatableElement(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_GROUP_TYPE: {
				MappingHintGroupType mappingHintGroupType = (MappingHintGroupType)theEObject;
				T result = caseMappingHintGroupType(mappingHintGroupType);
				if (result == null) result = caseNamedElement(mappingHintGroupType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.INSTANTIABLE_MAPPING_HINT_GROUP: {
				InstantiableMappingHintGroup instantiableMappingHintGroup = (InstantiableMappingHintGroup)theEObject;
				T result = caseInstantiableMappingHintGroup(instantiableMappingHintGroup);
				if (result == null) result = caseNamedElement(instantiableMappingHintGroup);
				if (result == null) result = caseDeactivatableElement(instantiableMappingHintGroup);
				if (result == null) result = caseConditionalElement(instantiableMappingHintGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_GROUP: {
				MappingHintGroup mappingHintGroup = (MappingHintGroup)theEObject;
				T result = caseMappingHintGroup(mappingHintGroup);
				if (result == null) result = caseMappingHintGroupType(mappingHintGroup);
				if (result == null) result = caseInstantiableMappingHintGroup(mappingHintGroup);
				if (result == null) result = caseNamedElement(mappingHintGroup);
				if (result == null) result = caseDeactivatableElement(mappingHintGroup);
				if (result == null) result = caseConditionalElement(mappingHintGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_BASE_TYPE: {
				MappingHintBaseType mappingHintBaseType = (MappingHintBaseType)theEObject;
				T result = caseMappingHintBaseType(mappingHintBaseType);
				if (result == null) result = caseNamedElement(mappingHintBaseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT: {
				MappingHint mappingHint = (MappingHint)theEObject;
				T result = caseMappingHint(mappingHint);
				if (result == null) result = caseMappingHintType(mappingHint);
				if (result == null) result = caseConditionalElement(mappingHint);
				if (result == null) result = caseMappingHintBaseType(mappingHint);
				if (result == null) result = caseNamedElement(mappingHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXPRESSION_HINT: {
				ExpressionHint expressionHint = (ExpressionHint)theEObject;
				T result = caseExpressionHint(expressionHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODIFIABLE_HINT: {
				ModifiableHint modifiableHint = (ModifiableHint)theEObject;
				T result = caseModifiableHint(modifiableHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING: {
				AttributeMapping attributeMapping = (AttributeMapping)theEObject;
				T result = caseAttributeMapping(attributeMapping);
				if (result == null) result = caseMappingHint(attributeMapping);
				if (result == null) result = caseExpressionHint(attributeMapping);
				if (result == null) result = caseModifiableHint(attributeMapping);
				if (result == null) result = caseExpandableHint(attributeMapping);
				if (result == null) result = caseMappingHintType(attributeMapping);
				if (result == null) result = caseConditionalElement(attributeMapping);
				if (result == null) result = caseMappingHintBaseType(attributeMapping);
				if (result == null) result = caseNamedElement(attributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CARDINALITY_MAPPING: {
				CardinalityMapping cardinalityMapping = (CardinalityMapping)theEObject;
				T result = caseCardinalityMapping(cardinalityMapping);
				if (result == null) result = caseMappingHint(cardinalityMapping);
				if (result == null) result = caseMappingHintType(cardinalityMapping);
				if (result == null) result = caseConditionalElement(cardinalityMapping);
				if (result == null) result = caseMappingHintBaseType(cardinalityMapping);
				if (result == null) result = caseNamedElement(cardinalityMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_INSTANCE_SELECTOR: {
				MappingInstanceSelector mappingInstanceSelector = (MappingInstanceSelector)theEObject;
				T result = caseMappingInstanceSelector(mappingInstanceSelector);
				if (result == null) result = caseMappingHint(mappingInstanceSelector);
				if (result == null) result = caseMappingHintType(mappingInstanceSelector);
				if (result == null) result = caseConditionalElement(mappingInstanceSelector);
				if (result == null) result = caseMappingHintBaseType(mappingInstanceSelector);
				if (result == null) result = caseNamedElement(mappingInstanceSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MATCHER: {
				Matcher matcher = (Matcher)theEObject;
				T result = caseMatcher(matcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MATCHER: {
				AttributeMatcher attributeMatcher = (AttributeMatcher)theEObject;
				T result = caseAttributeMatcher(attributeMatcher);
				if (result == null) result = caseMatcher(attributeMatcher);
				if (result == null) result = caseExpressionHint(attributeMatcher);
				if (result == null) result = caseModifiableHint(attributeMatcher);
				if (result == null) result = caseExpandableHint(attributeMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_ELEMENT: {
				AttributeMatcherSourceElement attributeMatcherSourceElement = (AttributeMatcherSourceElement)theEObject;
				T result = caseAttributeMatcherSourceElement(attributeMatcherSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(attributeMatcherSourceElement);
				if (result == null) result = caseAttributeMatcherSourceInterface(attributeMatcherSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeMatcherSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMatcherSourceElement);
				if (result == null) result = caseNamedElement(attributeMatcherSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MATCHER_SOURCE_INTERFACE: {
				AttributeMatcherSourceInterface attributeMatcherSourceInterface = (AttributeMatcherSourceInterface)theEObject;
				T result = caseAttributeMatcherSourceInterface(attributeMatcherSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(attributeMatcherSourceInterface);
				if (result == null) result = caseNamedElement(attributeMatcherSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CLASS_MATCHER: {
				ClassMatcher classMatcher = (ClassMatcher)theEObject;
				T result = caseClassMatcher(classMatcher);
				if (result == null) result = caseMatcher(classMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.VALUE_MODIFIER_SET: {
				ValueModifierSet valueModifierSet = (ValueModifierSet)theEObject;
				T result = caseValueModifierSet(valueModifierSet);
				if (result == null) result = caseNamedElement(valueModifierSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.VALUE_MODIFIER: {
				ValueModifier valueModifier = (ValueModifier)theEObject;
				T result = caseValueModifier(valueModifier);
				if (result == null) result = caseNamedElement(valueModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.SUBSTRING_REPLACER: {
				SubstringReplacer substringReplacer = (SubstringReplacer)theEObject;
				T result = caseSubstringReplacer(substringReplacer);
				if (result == null) result = caseValueModifier(substringReplacer);
				if (result == null) result = caseNamedElement(substringReplacer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.STRING_APPENDER: {
				StringAppender stringAppender = (StringAppender)theEObject;
				T result = caseStringAppender(stringAppender);
				if (result == null) result = caseValueModifier(stringAppender);
				if (result == null) result = caseNamedElement(stringAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.UNIQUE_NUMBER_APPENDER: {
				UniqueNumberAppender uniqueNumberAppender = (UniqueNumberAppender)theEObject;
				T result = caseUniqueNumberAppender(uniqueNumberAppender);
				if (result == null) result = caseValueModifier(uniqueNumberAppender);
				if (result == null) result = caseNamedElement(uniqueNumberAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.STRING_PREPENDER: {
				StringPrepender stringPrepender = (StringPrepender)theEObject;
				T result = caseStringPrepender(stringPrepender);
				if (result == null) result = caseValueModifier(stringPrepender);
				if (result == null) result = caseNamedElement(stringPrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODIFIED_ATTRIBUTE_ELEMENT_TYPE: {
				ModifiedAttributeElementType<?, ?, ?, ?> modifiedAttributeElementType = (ModifiedAttributeElementType<?, ?, ?, ?>)theEObject;
				T result = caseModifiedAttributeElementType(modifiedAttributeElementType);
				if (result == null) result = caseNamedElement(modifiedAttributeElementType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.LOCAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE: {
				LocalModifiedAttributeElementType<?, ?, ?, ?> localModifiedAttributeElementType = (LocalModifiedAttributeElementType<?, ?, ?, ?>)theEObject;
				T result = caseLocalModifiedAttributeElementType(localModifiedAttributeElementType);
				if (result == null) result = caseModifiedAttributeElementType(localModifiedAttributeElementType);
				if (result == null) result = caseNamedElement(localModifiedAttributeElementType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER: {
				MappingHintGroupImporter mappingHintGroupImporter = (MappingHintGroupImporter)theEObject;
				T result = caseMappingHintGroupImporter(mappingHintGroupImporter);
				if (result == null) result = caseInstantiableMappingHintGroup(mappingHintGroupImporter);
				if (result == null) result = caseNamedElement(mappingHintGroupImporter);
				if (result == null) result = caseDeactivatableElement(mappingHintGroupImporter);
				if (result == null) result = caseConditionalElement(mappingHintGroupImporter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXPORTED_MAPPING_HINT_GROUP: {
				ExportedMappingHintGroup exportedMappingHintGroup = (ExportedMappingHintGroup)theEObject;
				T result = caseExportedMappingHintGroup(exportedMappingHintGroup);
				if (result == null) result = caseMappingHintGroupType(exportedMappingHintGroup);
				if (result == null) result = caseNamedElement(exportedMappingHintGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODEL_CONNECTION_HINT: {
				ModelConnectionHint modelConnectionHint = (ModelConnectionHint)theEObject;
				T result = caseModelConnectionHint(modelConnectionHint);
				if (result == null) result = caseMappingHintBaseType(modelConnectionHint);
				if (result == null) result = caseNamedElement(modelConnectionHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT: {
				AttributeMappingSourceElement attributeMappingSourceElement = (AttributeMappingSourceElement)theEObject;
				T result = caseAttributeMappingSourceElement(attributeMappingSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(attributeMappingSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeMappingSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODEL_CONNECTION_HINT_SOURCE_ELEMENT: {
				ModelConnectionHintSourceElement modelConnectionHintSourceElement = (ModelConnectionHintSourceElement)theEObject;
				T result = caseModelConnectionHintSourceElement(modelConnectionHintSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(modelConnectionHintSourceElement);
				if (result == null) result = caseModelConnectionHintSourceInterface(modelConnectionHintSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(modelConnectionHintSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(modelConnectionHintSourceElement);
				if (result == null) result = caseNamedElement(modelConnectionHintSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODEL_CONNECTION_HINT_TARGET_ATTRIBUTE: {
				ModelConnectionHintTargetAttribute modelConnectionHintTargetAttribute = (ModelConnectionHintTargetAttribute)theEObject;
				T result = caseModelConnectionHintTargetAttribute(modelConnectionHintTargetAttribute);
				if (result == null) result = caseModifiedAttributeElementType(modelConnectionHintTargetAttribute);
				if (result == null) result = caseNamedElement(modelConnectionHintTargetAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_TYPE: {
				MappingHintType mappingHintType = (MappingHintType)theEObject;
				T result = caseMappingHintType(mappingHintType);
				if (result == null) result = caseMappingHintBaseType(mappingHintType);
				if (result == null) result = caseNamedElement(mappingHintType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.HINT_IMPORTER_MAPPING_HINT: {
				HintImporterMappingHint hintImporterMappingHint = (HintImporterMappingHint)theEObject;
				T result = caseHintImporterMappingHint(hintImporterMappingHint);
				if (result == null) result = caseMappingHintType(hintImporterMappingHint);
				if (result == null) result = caseMappingHintBaseType(hintImporterMappingHint);
				if (result == null) result = caseNamedElement(hintImporterMappingHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
				MappedAttributeValueExpander mappedAttributeValueExpander = (MappedAttributeValueExpander)theEObject;
				T result = caseMappedAttributeValueExpander(mappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValueExpander);
				if (result == null) result = caseMappingHintType(mappedAttributeValueExpander);
				if (result == null) result = caseMappingHintBaseType(mappedAttributeValueExpander);
				if (result == null) result = caseNamedElement(mappedAttributeValueExpander);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
				LocalMappedAttributeValueExpander localMappedAttributeValueExpander = (LocalMappedAttributeValueExpander)theEObject;
				T result = caseLocalMappedAttributeValueExpander(localMappedAttributeValueExpander);
				if (result == null) result = caseLocalModifiedAttributeElementType(localMappedAttributeValueExpander);
				if (result == null) result = caseMappedAttributeValueExpander(localMappedAttributeValueExpander);
				if (result == null) result = caseModifiedAttributeElementType(localMappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(localMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintType(localMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintBaseType(localMappedAttributeValueExpander);
				if (result == null) result = caseNamedElement(localMappedAttributeValueExpander);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER: {
				MappedAttributeValuePrepender mappedAttributeValuePrepender = (MappedAttributeValuePrepender)theEObject;
				T result = caseMappedAttributeValuePrepender(mappedAttributeValuePrepender);
				if (result == null) result = caseLocalMappedAttributeValueExpander(mappedAttributeValuePrepender);
				if (result == null) result = caseLocalModifiedAttributeElementType(mappedAttributeValuePrepender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValuePrepender);
				if (result == null) result = caseModifiedAttributeElementType(mappedAttributeValuePrepender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintType(mappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintBaseType(mappedAttributeValuePrepender);
				if (result == null) result = caseNamedElement(mappedAttributeValuePrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER: {
				MappedAttributeValueAppender mappedAttributeValueAppender = (MappedAttributeValueAppender)theEObject;
				T result = caseMappedAttributeValueAppender(mappedAttributeValueAppender);
				if (result == null) result = caseLocalMappedAttributeValueExpander(mappedAttributeValueAppender);
				if (result == null) result = caseLocalModifiedAttributeElementType(mappedAttributeValueAppender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValueAppender);
				if (result == null) result = caseModifiedAttributeElementType(mappedAttributeValueAppender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValueAppender);
				if (result == null) result = caseMappingHintType(mappedAttributeValueAppender);
				if (result == null) result = caseMappingHintBaseType(mappedAttributeValueAppender);
				if (result == null) result = caseNamedElement(mappedAttributeValueAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.FIXED_VALUE: {
				FixedValue fixedValue = (FixedValue)theEObject;
				T result = caseFixedValue(fixedValue);
				if (result == null) result = caseAttributeMappingSourceInterface(fixedValue);
				if (result == null) result = caseAttributeMatcherSourceInterface(fixedValue);
				if (result == null) result = caseModelConnectionHintSourceInterface(fixedValue);
				if (result == null) result = caseInstancePointerSourceInterface(fixedValue);
				if (result == null) result = caseAttributeValueConstraintSourceInterface(fixedValue);
				if (result == null) result = caseMappingHintSourceInterface(fixedValue);
				if (result == null) result = caseNamedElement(fixedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.GLOBAL_ATTRIBUTE: {
				GlobalAttribute globalAttribute = (GlobalAttribute)theEObject;
				T result = caseGlobalAttribute(globalAttribute);
				if (result == null) result = caseNamedElement(globalAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER: {
				GlobalAttributeImporter globalAttributeImporter = (GlobalAttributeImporter)theEObject;
				T result = caseGlobalAttributeImporter(globalAttributeImporter);
				if (result == null) result = caseAttributeMappingSourceInterface(globalAttributeImporter);
				if (result == null) result = caseAttributeMatcherSourceInterface(globalAttributeImporter);
				if (result == null) result = caseModelConnectionHintSourceInterface(globalAttributeImporter);
				if (result == null) result = caseInstancePointerSourceInterface(globalAttributeImporter);
				if (result == null) result = caseAttributeValueConstraintSourceInterface(globalAttributeImporter);
				if (result == null) result = caseMappingHintSourceInterface(globalAttributeImporter);
				if (result == null) result = caseNamedElement(globalAttributeImporter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE: {
				AttributeMappingSourceInterface attributeMappingSourceInterface = (AttributeMappingSourceInterface)theEObject;
				T result = caseAttributeMappingSourceInterface(attributeMappingSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingSourceInterface);
				if (result == null) result = caseNamedElement(attributeMappingSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MAPPING_HINT_SOURCE_INTERFACE: {
				MappingHintSourceInterface mappingHintSourceInterface = (MappingHintSourceInterface)theEObject;
				T result = caseMappingHintSourceInterface(mappingHintSourceInterface);
				if (result == null) result = caseNamedElement(mappingHintSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODEL_CONNECTION_HINT_SOURCE_INTERFACE: {
				ModelConnectionHintSourceInterface modelConnectionHintSourceInterface = (ModelConnectionHintSourceInterface)theEObject;
				T result = caseModelConnectionHintSourceInterface(modelConnectionHintSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(modelConnectionHintSourceInterface);
				if (result == null) result = caseNamedElement(modelConnectionHintSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT: {
				AttributeMappingExternalSourceElement attributeMappingExternalSourceElement = (AttributeMappingExternalSourceElement)theEObject;
				T result = caseAttributeMappingExternalSourceElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(attributeMappingExternalSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeMappingExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingExternalSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXTERNAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE: {
				ExternalModifiedAttributeElementType<?, ?, ?, ?> externalModifiedAttributeElementType = (ExternalModifiedAttributeElementType<?, ?, ?, ?>)theEObject;
				T result = caseExternalModifiedAttributeElementType(externalModifiedAttributeElementType);
				if (result == null) result = caseModifiedAttributeElementType(externalModifiedAttributeElementType);
				if (result == null) result = caseNamedElement(externalModifiedAttributeElementType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MODEL_CONNECTION_HINT_EXTERNAL_SOURCE_ELEMENT: {
				ModelConnectionHintExternalSourceElement modelConnectionHintExternalSourceElement = (ModelConnectionHintExternalSourceElement)theEObject;
				T result = caseModelConnectionHintExternalSourceElement(modelConnectionHintExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(modelConnectionHintExternalSourceElement);
				if (result == null) result = caseModelConnectionHintSourceInterface(modelConnectionHintExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(modelConnectionHintExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(modelConnectionHintExternalSourceElement);
				if (result == null) result = caseNamedElement(modelConnectionHintExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MATCHER_EXTERNAL_SOURCE_ELEMENT: {
				AttributeMatcherExternalSourceElement attributeMatcherExternalSourceElement = (AttributeMatcherExternalSourceElement)theEObject;
				T result = caseAttributeMatcherExternalSourceElement(attributeMatcherExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(attributeMatcherExternalSourceElement);
				if (result == null) result = caseAttributeMatcherSourceInterface(attributeMatcherExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeMatcherExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMatcherExternalSourceElement);
				if (result == null) result = caseNamedElement(attributeMatcherExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
				ExternalMappedAttributeValueExpander externalMappedAttributeValueExpander = (ExternalMappedAttributeValueExpander)theEObject;
				T result = caseExternalMappedAttributeValueExpander(externalMappedAttributeValueExpander);
				if (result == null) result = caseExternalModifiedAttributeElementType(externalMappedAttributeValueExpander);
				if (result == null) result = caseMappedAttributeValueExpander(externalMappedAttributeValueExpander);
				if (result == null) result = caseModifiedAttributeElementType(externalMappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(externalMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintType(externalMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintBaseType(externalMappedAttributeValueExpander);
				if (result == null) result = caseNamedElement(externalMappedAttributeValueExpander);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER: {
				ExternalMappedAttributeValuePrepender externalMappedAttributeValuePrepender = (ExternalMappedAttributeValuePrepender)theEObject;
				T result = caseExternalMappedAttributeValuePrepender(externalMappedAttributeValuePrepender);
				if (result == null) result = caseExternalMappedAttributeValueExpander(externalMappedAttributeValuePrepender);
				if (result == null) result = caseExternalModifiedAttributeElementType(externalMappedAttributeValuePrepender);
				if (result == null) result = caseMappedAttributeValueExpander(externalMappedAttributeValuePrepender);
				if (result == null) result = caseModifiedAttributeElementType(externalMappedAttributeValuePrepender);
				if (result == null) result = caseHintImporterMappingHint(externalMappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintType(externalMappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintBaseType(externalMappedAttributeValuePrepender);
				if (result == null) result = caseNamedElement(externalMappedAttributeValuePrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER: {
				ExternalMappedAttributeValueAppender externalMappedAttributeValueAppender = (ExternalMappedAttributeValueAppender)theEObject;
				T result = caseExternalMappedAttributeValueAppender(externalMappedAttributeValueAppender);
				if (result == null) result = caseExternalMappedAttributeValueExpander(externalMappedAttributeValueAppender);
				if (result == null) result = caseExternalModifiedAttributeElementType(externalMappedAttributeValueAppender);
				if (result == null) result = caseMappedAttributeValueExpander(externalMappedAttributeValueAppender);
				if (result == null) result = caseModifiedAttributeElementType(externalMappedAttributeValueAppender);
				if (result == null) result = caseHintImporterMappingHint(externalMappedAttributeValueAppender);
				if (result == null) result = caseMappingHintType(externalMappedAttributeValueAppender);
				if (result == null) result = caseMappingHintBaseType(externalMappedAttributeValueAppender);
				if (result == null) result = caseNamedElement(externalMappedAttributeValueAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.EXPANDABLE_HINT: {
				ExpandableHint expandableHint = (ExpandableHint)theEObject;
				T result = caseExpandableHint(expandableHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MATCH_TO_LOWER_CASE_CONVERTER: {
				MatchToLowerCaseConverter matchToLowerCaseConverter = (MatchToLowerCaseConverter)theEObject;
				T result = caseMatchToLowerCaseConverter(matchToLowerCaseConverter);
				if (result == null) result = caseValueModifier(matchToLowerCaseConverter);
				if (result == null) result = caseNamedElement(matchToLowerCaseConverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.MATCH_TO_UPPER_CASE_CONVERTER: {
				MatchToUpperCaseConverter matchToUpperCaseConverter = (MatchToUpperCaseConverter)theEObject;
				T result = caseMatchToUpperCaseConverter(matchToUpperCaseConverter);
				if (result == null) result = caseValueModifier(matchToUpperCaseConverter);
				if (result == null) result = caseNamedElement(matchToUpperCaseConverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingType(MappingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHint(MappingHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionHint(ExpressionHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiableHint(ModifiableHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMapping(AttributeMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMapping(CardinalityMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingInstanceSelector(MappingInstanceSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatcher(Matcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMatcher(AttributeMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Matcher Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Matcher Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMatcherSourceElement(AttributeMatcherSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Matcher Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Matcher Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMatcherSourceInterface(AttributeMatcherSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassMatcher(ClassMatcher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Modifier Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Modifier Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueModifierSet(ValueModifierSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueModifier(ValueModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substring Replacer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substring Replacer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstringReplacer(SubstringReplacer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringAppender(StringAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Number Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Number Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniqueNumberAppender(UniqueNumberAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Prepender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringPrepender(StringPrepender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseModifiedAttributeElementType(ModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintGroup(MappingHintGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Base Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Base Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintBaseType(MappingHintBaseType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Group Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Group Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintGroupType(MappingHintGroupType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instantiable Mapping Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instantiable Mapping Hint Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstantiableMappingHintGroup(InstantiableMappingHintGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Group Importer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Group Importer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintGroupImporter(MappingHintGroupImporter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exported Mapping Hint Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exported Mapping Hint Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExportedMappingHintGroup(ExportedMappingHintGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Connection Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Connection Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelConnectionHint(ModelConnectionHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingSourceElement(AttributeMappingSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Connection Hint Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Connection Hint Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelConnectionHintSourceElement(ModelConnectionHintSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Connection Hint Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Connection Hint Target Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelConnectionHintTargetAttribute(ModelConnectionHintTargetAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintType(MappingHintType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Importer Mapping Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Importer Mapping Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHintImporterMappingHint(HintImporterMappingHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Attribute Value Expander</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Attribute Value Expander</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedAttributeValueExpander(MappedAttributeValueExpander object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Mapped Attribute Value Expander</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Mapped Attribute Value Expander</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalMappedAttributeValueExpander(LocalMappedAttributeValueExpander object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Attribute Value Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Attribute Value Prepender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedAttributeValuePrepender(MappedAttributeValuePrepender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Attribute Value Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Attribute Value Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedAttributeValueAppender(MappedAttributeValueAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedValue(FixedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalAttribute(GlobalAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Attribute Importer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Attribute Importer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobalAttributeImporter(GlobalAttributeImporter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingSourceInterface(AttributeMappingSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintSourceInterface(MappingHintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Connection Hint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Connection Hint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelConnectionHintSourceInterface(ModelConnectionHintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingExternalSourceElement(AttributeMappingExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Connection Hint External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Connection Hint External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelConnectionHintExternalSourceElement(ModelConnectionHintExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Matcher External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Matcher External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMatcherExternalSourceElement(AttributeMatcherExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Mapped Attribute Value Expander</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Mapped Attribute Value Expander</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalMappedAttributeValueExpander(ExternalMappedAttributeValueExpander object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Mapped Attribute Value Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Mapped Attribute Value Prepender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalMappedAttributeValuePrepender(ExternalMappedAttributeValuePrepender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Mapped Attribute Value Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Mapped Attribute Value Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalMappedAttributeValueAppender(ExternalMappedAttributeValueAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expandable Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expandable Hint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandableHint(ExpandableHint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match To Lower Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match To Lower Case Converter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchToLowerCaseConverter(MatchToLowerCaseConverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match To Upper Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match To Upper Case Converter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchToUpperCaseConverter(MatchToUpperCaseConverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deactivatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deactivatable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeactivatableElement(DeactivatableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalElement(ConditionalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointerSourceInterface(InstancePointerSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Constraint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Constraint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueConstraintSourceInterface(ValueConstraintSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MappingSwitch
