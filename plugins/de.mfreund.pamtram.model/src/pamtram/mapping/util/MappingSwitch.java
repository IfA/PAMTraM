/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.*;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
import pamtram.mapping.extended.ExternalMappedAttributeValueAppender;
import pamtram.mapping.extended.ExternalMappedAttributeValueExpander;
import pamtram.mapping.extended.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.extended.LocalMappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValueAppender;
import pamtram.mapping.extended.MappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValuePrepender;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.DynamicSourceElement;
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
			case MappingPackage.MAPPING_HINT_BASE_TYPE: {
				MappingHintBaseType mappingHintBaseType = (MappingHintBaseType)theEObject;
				T result = caseMappingHintBaseType(mappingHintBaseType);
				if (result == null) result = caseNamedElement(mappingHintBaseType);
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
				if (result == null) result = caseLocalDynamicSourceElement(localMappedAttributeValueExpander);
				if (result == null) result = caseMappedAttributeValueExpander(localMappedAttributeValueExpander);
				if (result == null) result = caseDynamicSourceElement(localMappedAttributeValueExpander);
				if (result == null) result = caseHintImporterMappingHint(localMappedAttributeValueExpander);
				if (result == null) result = caseModifiableElement(localMappedAttributeValueExpander);
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
				if (result == null) result = caseLocalDynamicSourceElement(mappedAttributeValuePrepender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValuePrepender);
				if (result == null) result = caseDynamicSourceElement(mappedAttributeValuePrepender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValuePrepender);
				if (result == null) result = caseModifiableElement(mappedAttributeValuePrepender);
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
				if (result == null) result = caseLocalDynamicSourceElement(mappedAttributeValueAppender);
				if (result == null) result = caseMappedAttributeValueExpander(mappedAttributeValueAppender);
				if (result == null) result = caseDynamicSourceElement(mappedAttributeValueAppender);
				if (result == null) result = caseHintImporterMappingHint(mappedAttributeValueAppender);
				if (result == null) result = caseModifiableElement(mappedAttributeValueAppender);
				if (result == null) result = caseMappingHintType(mappedAttributeValueAppender);
				if (result == null) result = caseMappingHintBaseType(mappedAttributeValueAppender);
				if (result == null) result = caseNamedElement(mappedAttributeValueAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.GLOBAL_ATTRIBUTE: {
				GlobalAttribute globalAttribute = (GlobalAttribute)theEObject;
				T result = caseGlobalAttribute(globalAttribute);
				if (result == null) result = caseNamedElement(globalAttribute);
				if (result == null) result = caseModifiableElement(globalAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MappingPackage.GLOBAL_ATTRIBUTE_IMPORTER: {
				GlobalAttributeImporter globalAttributeImporter = (GlobalAttributeImporter)theEObject;
				T result = caseGlobalAttributeImporter(globalAttributeImporter);
				if (result == null) result = caseAttributeMappingSourceInterface(globalAttributeImporter);
				if (result == null) result = caseInstanceSelectorSourceInterface(globalAttributeImporter);
				if (result == null) result = caseValueConstraintSourceInterface(globalAttributeImporter);
				if (result == null) result = caseMappingHintSourceInterface(globalAttributeImporter);
				if (result == null) result = caseNamedElement(globalAttributeImporter);
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
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_EXPANDER: {
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
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_PREPENDER: {
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
			case MappingPackage.EXTERNAL_MAPPED_ATTRIBUTE_VALUE_APPENDER: {
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
			case MappingPackage.EXPANDABLE_HINT: {
				ExpandableHint expandableHint = (ExpandableHint)theEObject;
				T result = caseExpandableHint(expandableHint);
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
