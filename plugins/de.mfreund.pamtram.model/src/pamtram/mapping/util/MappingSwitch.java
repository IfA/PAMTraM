/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.*;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.constraint.ValueConstraintSourceInterface;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

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
			case MappingPackage.ATTRIBUTE_MAPPING: {
				AttributeMapping attributeMapping = (AttributeMapping)theEObject;
				T result = caseAttributeMapping(attributeMapping);
				if (result == null) result = caseMappingHint(attributeMapping);
				if (result == null) result = caseExpressionElement(attributeMapping);
				if (result == null) result = caseModifiableElement(attributeMapping);
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
			case MappingPackage.REFERENCE_TARGET_SELECTOR: {
				ReferenceTargetSelector referenceTargetSelector = (ReferenceTargetSelector)theEObject;
				T result = caseReferenceTargetSelector(referenceTargetSelector);
				if (result == null) result = caseMappingHint(referenceTargetSelector);
				if (result == null) result = caseMappingHintType(referenceTargetSelector);
				if (result == null) result = caseConditionalElement(referenceTargetSelector);
				if (result == null) result = caseMappingHintBaseType(referenceTargetSelector);
				if (result == null) result = caseNamedElement(referenceTargetSelector);
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
				if (result == null) result = caseExpressionElement(attributeMatcher);
				if (result == null) result = caseModifiableElement(attributeMatcher);
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
			case MappingPackage.CONTAINER_SELECTOR: {
				ContainerSelector containerSelector = (ContainerSelector)theEObject;
				T result = caseContainerSelector(containerSelector);
				if (result == null) result = caseMappingHintBaseType(containerSelector);
				if (result == null) result = caseNamedElement(containerSelector);
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
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_ELEMENT: {
				ContainerSelectorSourceElement containerSelectorSourceElement = (ContainerSelectorSourceElement)theEObject;
				T result = caseContainerSelectorSourceElement(containerSelectorSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(containerSelectorSourceElement);
				if (result == null) result = caseContainerSelectorSourceInterface(containerSelectorSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(containerSelectorSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(containerSelectorSourceElement);
				if (result == null) result = caseNamedElement(containerSelectorSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CONTAINER_SELECTOR_TARGET_ATTRIBUTE: {
				ContainerSelectorTargetAttribute containerSelectorTargetAttribute = (ContainerSelectorTargetAttribute)theEObject;
				T result = caseContainerSelectorTargetAttribute(containerSelectorTargetAttribute);
				if (result == null) result = caseModifiedAttributeElementType(containerSelectorTargetAttribute);
				if (result == null) result = caseNamedElement(containerSelectorTargetAttribute);
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
				if (result == null) result = caseContainerSelectorSourceInterface(fixedValue);
				if (result == null) result = caseInstancePointerSourceInterface(fixedValue);
				if (result == null) result = caseValueConstraintSourceInterface(fixedValue);
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
				if (result == null) result = caseContainerSelectorSourceInterface(globalAttributeImporter);
				if (result == null) result = caseInstancePointerSourceInterface(globalAttributeImporter);
				if (result == null) result = caseValueConstraintSourceInterface(globalAttributeImporter);
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
			case MappingPackage.CONTAINER_SELECTOR_SOURCE_INTERFACE: {
				ContainerSelectorSourceInterface containerSelectorSourceInterface = (ContainerSelectorSourceInterface)theEObject;
				T result = caseContainerSelectorSourceInterface(containerSelectorSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(containerSelectorSourceInterface);
				if (result == null) result = caseNamedElement(containerSelectorSourceInterface);
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
			case MappingPackage.CONTAINER_SELECTOR_EXTERNAL_SOURCE_ELEMENT: {
				ContainerSelectorExternalSourceElement containerSelectorExternalSourceElement = (ContainerSelectorExternalSourceElement)theEObject;
				T result = caseContainerSelectorExternalSourceElement(containerSelectorExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(containerSelectorExternalSourceElement);
				if (result == null) result = caseContainerSelectorSourceInterface(containerSelectorExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(containerSelectorExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(containerSelectorExternalSourceElement);
				if (result == null) result = caseNamedElement(containerSelectorExternalSourceElement);
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
			case MappingPackage.GLOBAL_MODIFIED_ATTRIBUTE_ELEMENT_TYPE: {
				GlobalModifiedAttributeElementType<?, ?, ?, ?> globalModifiedAttributeElementType = (GlobalModifiedAttributeElementType<?, ?, ?, ?>)theEObject;
				T result = caseGlobalModifiedAttributeElementType(globalModifiedAttributeElementType);
				if (result == null) result = caseModifiedAttributeElementType(globalModifiedAttributeElementType);
				if (result == null) result = caseNamedElement(globalModifiedAttributeElementType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MATCHER_GLOBAL_SOURCE_ELEMENT: {
				AttributeMatcherGlobalSourceElement attributeMatcherGlobalSourceElement = (AttributeMatcherGlobalSourceElement)theEObject;
				T result = caseAttributeMatcherGlobalSourceElement(attributeMatcherGlobalSourceElement);
				if (result == null) result = caseGlobalModifiedAttributeElementType(attributeMatcherGlobalSourceElement);
				if (result == null) result = caseAttributeMatcherSourceInterface(attributeMatcherGlobalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeMatcherGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMatcherGlobalSourceElement);
				if (result == null) result = caseNamedElement(attributeMatcherGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT: {
				AttributeMappingGlobalSourceElement attributeMappingGlobalSourceElement = (AttributeMappingGlobalSourceElement)theEObject;
				T result = caseAttributeMappingGlobalSourceElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseGlobalModifiedAttributeElementType(attributeMappingGlobalSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingGlobalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(attributeMappingGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingGlobalSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.CONTAINER_SELECTOR_GLOBAL_SOURCE_ELEMENT: {
				ContainerSelectorGlobalSourceElement containerSelectorGlobalSourceElement = (ContainerSelectorGlobalSourceElement)theEObject;
				T result = caseContainerSelectorGlobalSourceElement(containerSelectorGlobalSourceElement);
				if (result == null) result = caseGlobalModifiedAttributeElementType(containerSelectorGlobalSourceElement);
				if (result == null) result = caseContainerSelectorSourceInterface(containerSelectorGlobalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(containerSelectorGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(containerSelectorGlobalSourceElement);
				if (result == null) result = caseNamedElement(containerSelectorGlobalSourceElement);
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
	 * Returns the result of interpreting the object as an instance of '<em>Expression Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionElement(ExpressionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiableElement(ModifiableElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Reference Target Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Target Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceTargetSelector(ReferenceTargetSelector object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseModifiedAttributeElementType(ModifiedAttributeElementType<S, C, R, A> object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<S, C, R, A> object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelector(ContainerSelector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelectorSourceElement(ContainerSelectorSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector Target Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector Target Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelectorTargetAttribute(ContainerSelectorTargetAttribute object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelectorSourceInterface(ContainerSelectorSourceInterface object) {
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
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelectorExternalSourceElement(ContainerSelectorExternalSourceElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Global Modified Attribute Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Modified Attribute Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseGlobalModifiedAttributeElementType(GlobalModifiedAttributeElementType<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Matcher Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Matcher Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMatcherGlobalSourceElement(AttributeMatcherGlobalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Mapping Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Mapping Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeMappingGlobalSourceElement(AttributeMappingGlobalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Selector Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selector Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelectorGlobalSourceElement(ContainerSelectorGlobalSourceElement object) {
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
	public T caseInstancePointerSourceInterface(InstanceSelectorSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Constraint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Constraint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueConstraintSourceInterface(ValueConstraintSourceInterface object) {
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
