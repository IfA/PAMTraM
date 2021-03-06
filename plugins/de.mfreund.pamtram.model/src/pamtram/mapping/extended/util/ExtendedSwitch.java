/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.mapping.extended.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.ExpressionElement;
import pamtram.MatchSpecElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.extended.*;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.TargetInstanceSelector;
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
 * @see pamtram.mapping.extended.ExtendedPackage
 * @generated
 */
public class ExtendedSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExtendedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedSwitch() {
		if (modelPackage == null) {
			modelPackage = ExtendedPackage.eINSTANCE;
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
			case ExtendedPackage.MAPPING_HINT_BASE_TYPE: {
				MappingHintBaseType mappingHintBaseType = (MappingHintBaseType)theEObject;
				T result = caseMappingHintBaseType(mappingHintBaseType);
				if (result == null) result = caseNamedElement(mappingHintBaseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.MAPPING_HINT_TYPE: {
				MappingHintType mappingHintType = (MappingHintType)theEObject;
				T result = caseMappingHintType(mappingHintType);
				if (result == null) result = caseMappingHintBaseType(mappingHintType);
				if (result == null) result = caseNamedElement(mappingHintType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.MAPPING_HINT: {
				MappingHint mappingHint = (MappingHint)theEObject;
				T result = caseMappingHint(mappingHint);
				if (result == null) result = caseMappingHintType(mappingHint);
				if (result == null) result = caseConditionalElement(mappingHint);
				if (result == null) result = caseDeactivatableElement(mappingHint);
				if (result == null) result = caseMappingHintBaseType(mappingHint);
				if (result == null) result = caseNamedElement(mappingHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.EXPANDABLE_HINT: {
				ExpandableHint expandableHint = (ExpandableHint)theEObject;
				T result = caseExpandableHint(expandableHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.HINT_IMPORTER_MAPPING_HINT: {
				HintImporterMappingHint hintImporterMappingHint = (HintImporterMappingHint)theEObject;
				T result = caseHintImporterMappingHint(hintImporterMappingHint);
				if (result == null) result = caseMappingHintType(hintImporterMappingHint);
				if (result == null) result = caseMappingHintBaseType(hintImporterMappingHint);
				if (result == null) result = caseNamedElement(hintImporterMappingHint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.MAPPING_HINT_SOURCE_INTERFACE: {
				MappingHintSourceInterface mappingHintSourceInterface = (MappingHintSourceInterface)theEObject;
				T result = caseMappingHintSourceInterface(mappingHintSourceInterface);
				if (result == null) result = caseNamedElement(mappingHintSourceInterface);
				if (result == null) result = caseConditionalElement(mappingHintSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.GLOBAL_ATTRIBUTE_IMPORTER: {
				GlobalAttributeImporter globalAttributeImporter = (GlobalAttributeImporter)theEObject;
				T result = caseGlobalAttributeImporter(globalAttributeImporter);
				if (result == null) result = caseAttributeMappingSourceInterface(globalAttributeImporter);
				if (result == null) result = caseInstanceSelectorSourceInterface(globalAttributeImporter);
				if (result == null) result = caseValueConstraintSourceInterface(globalAttributeImporter);
				if (result == null) result = caseMappingHintSourceInterface(globalAttributeImporter);
				if (result == null) result = caseNamedElement(globalAttributeImporter);
				if (result == null) result = caseConditionalElement(globalAttributeImporter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING: {
				AttributeMapping attributeMapping = (AttributeMapping)theEObject;
				T result = caseAttributeMapping(attributeMapping);
				if (result == null) result = caseMappingHint(attributeMapping);
				if (result == null) result = caseExpressionElement(attributeMapping);
				if (result == null) result = caseModifiableElement(attributeMapping);
				if (result == null) result = caseExpandableHint(attributeMapping);
				if (result == null) result = caseMappingHintType(attributeMapping);
				if (result == null) result = caseConditionalElement(attributeMapping);
				if (result == null) result = caseDeactivatableElement(attributeMapping);
				if (result == null) result = caseMappingHintBaseType(attributeMapping);
				if (result == null) result = caseNamedElement(attributeMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_INTERFACE: {
				AttributeMappingSourceInterface attributeMappingSourceInterface = (AttributeMappingSourceInterface)theEObject;
				T result = caseAttributeMappingSourceInterface(attributeMappingSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingSourceInterface);
				if (result == null) result = caseNamedElement(attributeMappingSourceInterface);
				if (result == null) result = caseConditionalElement(attributeMappingSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_SOURCE_ELEMENT: {
				AttributeMappingSourceElement attributeMappingSourceElement = (AttributeMappingSourceElement)theEObject;
				T result = caseAttributeMappingSourceElement(attributeMappingSourceElement);
				if (result == null) result = caseLocalDynamicSourceElement(attributeMappingSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingSourceElement);
				if (result == null) result = caseDynamicSourceElement(attributeMappingSourceElement);
				if (result == null) result = caseMatchSpecElement(attributeMappingSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingSourceElement);
				if (result == null) result = caseModifiableElement(attributeMappingSourceElement);
				if (result == null) result = caseConditionalElement(attributeMappingSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_EXTERNAL_SOURCE_ELEMENT: {
				AttributeMappingExternalSourceElement attributeMappingExternalSourceElement = (AttributeMappingExternalSourceElement)theEObject;
				T result = caseAttributeMappingExternalSourceElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseExternalDynamicSourceElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingExternalSourceElement);
				if (result == null) result = caseDynamicSourceElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingExternalSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseModifiableElement(attributeMappingExternalSourceElement);
				if (result == null) result = caseConditionalElement(attributeMappingExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.ATTRIBUTE_MAPPING_GLOBAL_SOURCE_ELEMENT: {
				AttributeMappingGlobalSourceElement attributeMappingGlobalSourceElement = (AttributeMappingGlobalSourceElement)theEObject;
				T result = caseAttributeMappingGlobalSourceElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseGlobalDynamicSourceElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseAttributeMappingSourceInterface(attributeMappingGlobalSourceElement);
				if (result == null) result = caseDynamicSourceElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(attributeMappingGlobalSourceElement);
				if (result == null) result = caseNamedElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseModifiableElement(attributeMappingGlobalSourceElement);
				if (result == null) result = caseConditionalElement(attributeMappingGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING: {
				CardinalityMapping cardinalityMapping = (CardinalityMapping)theEObject;
				T result = caseCardinalityMapping(cardinalityMapping);
				if (result == null) result = caseMappingHint(cardinalityMapping);
				if (result == null) result = caseExpressionElement(cardinalityMapping);
				if (result == null) result = caseModifiableElement(cardinalityMapping);
				if (result == null) result = caseMatchSpecElement(cardinalityMapping);
				if (result == null) result = caseMappingHintType(cardinalityMapping);
				if (result == null) result = caseConditionalElement(cardinalityMapping);
				if (result == null) result = caseDeactivatableElement(cardinalityMapping);
				if (result == null) result = caseMappingHintBaseType(cardinalityMapping);
				if (result == null) result = caseNamedElement(cardinalityMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_INTERFACE: {
				CardinalityMappingSourceInterface cardinalityMappingSourceInterface = (CardinalityMappingSourceInterface)theEObject;
				T result = caseCardinalityMappingSourceInterface(cardinalityMappingSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingSourceInterface);
				if (result == null) result = caseNamedElement(cardinalityMappingSourceInterface);
				if (result == null) result = caseConditionalElement(cardinalityMappingSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_SOURCE_ELEMENT: {
				CardinalityMappingSourceElement cardinalityMappingSourceElement = (CardinalityMappingSourceElement)theEObject;
				T result = caseCardinalityMappingSourceElement(cardinalityMappingSourceElement);
				if (result == null) result = caseLocalDynamicSourceElement(cardinalityMappingSourceElement);
				if (result == null) result = caseCardinalityMappingSourceInterface(cardinalityMappingSourceElement);
				if (result == null) result = caseDynamicSourceElement(cardinalityMappingSourceElement);
				if (result == null) result = caseMatchSpecElement(cardinalityMappingSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingSourceElement);
				if (result == null) result = caseNamedElement(cardinalityMappingSourceElement);
				if (result == null) result = caseModifiableElement(cardinalityMappingSourceElement);
				if (result == null) result = caseConditionalElement(cardinalityMappingSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_EXTERNAL_SOURCE_ELEMENT: {
				CardinalityMappingExternalSourceElement cardinalityMappingExternalSourceElement = (CardinalityMappingExternalSourceElement)theEObject;
				T result = caseCardinalityMappingExternalSourceElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseExternalDynamicSourceElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseCardinalityMappingSourceInterface(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseDynamicSourceElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseNamedElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseModifiableElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = caseConditionalElement(cardinalityMappingExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CARDINALITY_MAPPING_GLOBAL_SOURCE_ELEMENT: {
				CardinalityMappingGlobalSourceElement cardinalityMappingGlobalSourceElement = (CardinalityMappingGlobalSourceElement)theEObject;
				T result = caseCardinalityMappingGlobalSourceElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseGlobalDynamicSourceElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseCardinalityMappingSourceInterface(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseDynamicSourceElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseNamedElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseModifiableElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = caseConditionalElement(cardinalityMappingGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR: {
				ReferenceTargetSelector referenceTargetSelector = (ReferenceTargetSelector)theEObject;
				T result = caseReferenceTargetSelector(referenceTargetSelector);
				if (result == null) result = caseMappingHint(referenceTargetSelector);
				if (result == null) result = caseTargetInstanceSelector(referenceTargetSelector);
				if (result == null) result = caseMappingHintType(referenceTargetSelector);
				if (result == null) result = caseConditionalElement(referenceTargetSelector);
				if (result == null) result = caseDeactivatableElement(referenceTargetSelector);
				if (result == null) result = caseInstanceSelector(referenceTargetSelector);
				if (result == null) result = caseMappingHintBaseType(referenceTargetSelector);
				if (result == null) result = caseExpressionElement(referenceTargetSelector);
				if (result == null) result = caseModifiableElement(referenceTargetSelector);
				if (result == null) result = caseNamedElement(referenceTargetSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.CONTAINER_SELECTOR: {
				ContainerSelector containerSelector = (ContainerSelector)theEObject;
				T result = caseContainerSelector(containerSelector);
				if (result == null) result = caseMappingHint(containerSelector);
				if (result == null) result = caseTargetInstanceSelector(containerSelector);
				if (result == null) result = caseMappingHintType(containerSelector);
				if (result == null) result = caseConditionalElement(containerSelector);
				if (result == null) result = caseDeactivatableElement(containerSelector);
				if (result == null) result = caseInstanceSelector(containerSelector);
				if (result == null) result = caseMappingHintBaseType(containerSelector);
				if (result == null) result = caseExpressionElement(containerSelector);
				if (result == null) result = caseModifiableElement(containerSelector);
				if (result == null) result = caseNamedElement(containerSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
				MappedAttributeValueExpander mappedAttributeValueExpander = (MappedAttributeValueExpander)theEObject;
				T result = caseMappedAttributeValueExpander(mappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValueExpander);
				if (result == null) result = caseMappingHintType(mappedAttributeValueExpander);
				if (result == null) result = caseMappingHintBaseType(mappedAttributeValueExpander);
				if (result == null) result = caseNamedElement(mappedAttributeValueExpander);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.LOCAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
				LocalMappedAttributeValueExpander localMappedAttributeValueExpander = (LocalMappedAttributeValueExpander)theEObject;
				T result = caseLocalMappedAttributeValueExpander(localMappedAttributeValueExpander);
				if (result == null) result = caseLocalDynamicSourceElement(localMappedAttributeValueExpander);
				if (result == null) result = caseMappedAttributeValueExpander(localMappedAttributeValueExpander);
				if (result == null) result = caseDynamicSourceElement(localMappedAttributeValueExpander);
				if (result == null) result = caseMatchSpecElement(localMappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(localMappedAttributeValueExpander);
				if (result == null) result = caseModifiableElement(localMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintType(localMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintBaseType(localMappedAttributeValueExpander);
				if (result == null) result = caseNamedElement(localMappedAttributeValueExpander);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_PREPENDER: {
				MappedAttributeValuePrepender mappedAttributeValuePrepender = (MappedAttributeValuePrepender)theEObject;
				T result = caseMappedAttributeValuePrepender(mappedAttributeValuePrepender);
				if (result == null) result = caseLocalMappedAttributeValueExpander(mappedAttributeValuePrepender);
				if (result == null) result = caseLocalDynamicSourceElement(mappedAttributeValuePrepender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValuePrepender);
				if (result == null) result = caseDynamicSourceElement(mappedAttributeValuePrepender);
				if (result == null) result = caseMatchSpecElement(mappedAttributeValuePrepender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValuePrepender);
				if (result == null) result = caseModifiableElement(mappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintType(mappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintBaseType(mappedAttributeValuePrepender);
				if (result == null) result = caseNamedElement(mappedAttributeValuePrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.MAPPED_ATTRIBUTE_VALUE_APPENDER: {
				MappedAttributeValueAppender mappedAttributeValueAppender = (MappedAttributeValueAppender)theEObject;
				T result = caseMappedAttributeValueAppender(mappedAttributeValueAppender);
				if (result == null) result = caseLocalMappedAttributeValueExpander(mappedAttributeValueAppender);
				if (result == null) result = caseLocalDynamicSourceElement(mappedAttributeValueAppender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValueAppender);
				if (result == null) result = caseDynamicSourceElement(mappedAttributeValueAppender);
				if (result == null) result = caseMatchSpecElement(mappedAttributeValueAppender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValueAppender);
				if (result == null) result = caseModifiableElement(mappedAttributeValueAppender);
				if (result == null) result = caseMappingHintType(mappedAttributeValueAppender);
				if (result == null) result = caseMappingHintBaseType(mappedAttributeValueAppender);
				if (result == null) result = caseNamedElement(mappedAttributeValueAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
				ExternalMappedAttributeValueExpander externalMappedAttributeValueExpander = (ExternalMappedAttributeValueExpander)theEObject;
				T result = caseExternalMappedAttributeValueExpander(externalMappedAttributeValueExpander);
				if (result == null) result = caseExternalDynamicSourceElement(externalMappedAttributeValueExpander);
				if (result == null) result = caseMappedAttributeValueExpander(externalMappedAttributeValueExpander);
				if (result == null) result = caseDynamicSourceElement(externalMappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(externalMappedAttributeValueExpander);
				if (result == null) result = caseModifiableElement(externalMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintType(externalMappedAttributeValueExpander);
				if (result == null) result = caseMappingHintBaseType(externalMappedAttributeValueExpander);
				if (result == null) result = caseNamedElement(externalMappedAttributeValueExpander);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER: {
				ExternalMappedAttributeValuePrepender externalMappedAttributeValuePrepender = (ExternalMappedAttributeValuePrepender)theEObject;
				T result = caseExternalMappedAttributeValuePrepender(externalMappedAttributeValuePrepender);
				if (result == null) result = caseExternalMappedAttributeValueExpander(externalMappedAttributeValuePrepender);
				if (result == null) result = caseExternalDynamicSourceElement(externalMappedAttributeValuePrepender);
				if (result == null) result = caseMappedAttributeValueExpander(externalMappedAttributeValuePrepender);
				if (result == null) result = caseDynamicSourceElement(externalMappedAttributeValuePrepender);
				if (result == null) result = caseHintImporterMappingHint(externalMappedAttributeValuePrepender);
				if (result == null) result = caseModifiableElement(externalMappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintType(externalMappedAttributeValuePrepender);
				if (result == null) result = caseMappingHintBaseType(externalMappedAttributeValuePrepender);
				if (result == null) result = caseNamedElement(externalMappedAttributeValuePrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExtendedPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER: {
				ExternalMappedAttributeValueAppender externalMappedAttributeValueAppender = (ExternalMappedAttributeValueAppender)theEObject;
				T result = caseExternalMappedAttributeValueAppender(externalMappedAttributeValueAppender);
				if (result == null) result = caseExternalMappedAttributeValueExpander(externalMappedAttributeValueAppender);
				if (result == null) result = caseExternalDynamicSourceElement(externalMappedAttributeValueAppender);
				if (result == null) result = caseMappedAttributeValueExpander(externalMappedAttributeValueAppender);
				if (result == null) result = caseDynamicSourceElement(externalMappedAttributeValueAppender);
				if (result == null) result = caseHintImporterMappingHint(externalMappedAttributeValueAppender);
				if (result == null) result = caseModifiableElement(externalMappedAttributeValueAppender);
				if (result == null) result = caseMappingHintType(externalMappedAttributeValueAppender);
				if (result == null) result = caseMappingHintBaseType(externalMappedAttributeValueAppender);
				if (result == null) result = caseNamedElement(externalMappedAttributeValueAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingSourceInterface(CardinalityMappingSourceInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingSourceElement(CardinalityMappingSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingExternalSourceElement(CardinalityMappingExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cardinality Mapping Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cardinality Mapping Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCardinalityMappingGlobalSourceElement(CardinalityMappingGlobalSourceElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Hint Base Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Hint Base Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintBaseType(MappingHintBaseType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Hint Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Hint Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintType(MappingHintType object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Instance Selector Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Selector Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSelectorSourceInterface(InstanceSelectorSourceInterface object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Hint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Hint</em>'.
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Hint Source Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Hint Source Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingHintSourceInterface(MappingHintSourceInterface object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseDynamicSourceElement(DynamicSourceElement<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Spec Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Spec Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseMatchSpecElement(MatchSpecElement<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseLocalDynamicSourceElement(LocalDynamicSourceElement<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> T caseExternalDynamicSourceElement(ExternalDynamicSourceElement<S, C, R, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global Dynamic Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global Dynamic Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>, InstanceSelectorType extends InstanceSelector> T caseGlobalDynamicSourceElement(GlobalDynamicSourceElement<S, C, R, A, InstanceSelectorType> object) {
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
	public T caseInstanceSelector(InstanceSelector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Target Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Target Instance Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTargetInstanceSelector(TargetInstanceSelector object) {
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

} //ExtendedSwitch
