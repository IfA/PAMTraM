/**
 */
package pamtram.structure.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.extended.MappingHintSourceInterface;
import pamtram.structure.*;
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
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public class StructureSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StructurePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureSwitch() {
		if (modelPackage == null) {
			modelPackage = StructurePackage.eINSTANCE;
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
			case StructurePackage.INSTANCE_SELECTOR: {
				InstanceSelector instanceSelector = (InstanceSelector)theEObject;
				T result = caseInstanceSelector(instanceSelector);
				if (result == null) result = caseExpressionElement(instanceSelector);
				if (result == null) result = caseModifiableElement(instanceSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.SOURCE_INSTANCE_SELECTOR: {
				SourceInstanceSelector sourceInstanceSelector = (SourceInstanceSelector)theEObject;
				T result = caseSourceInstanceSelector(sourceInstanceSelector);
				if (result == null) result = caseInstanceSelector(sourceInstanceSelector);
				if (result == null) result = caseExpressionElement(sourceInstanceSelector);
				if (result == null) result = caseModifiableElement(sourceInstanceSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.TARGET_INSTANCE_SELECTOR: {
				TargetInstanceSelector targetInstanceSelector = (TargetInstanceSelector)theEObject;
				T result = caseTargetInstanceSelector(targetInstanceSelector);
				if (result == null) result = caseInstanceSelector(targetInstanceSelector);
				if (result == null) result = caseExpressionElement(targetInstanceSelector);
				if (result == null) result = caseModifiableElement(targetInstanceSelector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_SELECTOR_SOURCE_INTERFACE: {
				InstanceSelectorSourceInterface instanceSelectorSourceInterface = (InstanceSelectorSourceInterface)theEObject;
				T result = caseInstanceSelectorSourceInterface(instanceSelectorSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(instanceSelectorSourceInterface);
				if (result == null) result = caseNamedElement(instanceSelectorSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_SELECTOR_SOURCE_ELEMENT: {
				InstanceSelectorSourceElement instanceSelectorSourceElement = (InstanceSelectorSourceElement)theEObject;
				T result = caseInstanceSelectorSourceElement(instanceSelectorSourceElement);
				if (result == null) result = caseLocalDynamicSourceElement(instanceSelectorSourceElement);
				if (result == null) result = caseInstanceSelectorSourceInterface(instanceSelectorSourceElement);
				if (result == null) result = caseDynamicSourceElement(instanceSelectorSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(instanceSelectorSourceElement);
				if (result == null) result = caseNamedElement(instanceSelectorSourceElement);
				if (result == null) result = caseModifiableElement(instanceSelectorSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_SELECTOR_EXTERNAL_SOURCE_ELEMENT: {
				InstanceSelectorExternalSourceElement instanceSelectorExternalSourceElement = (InstanceSelectorExternalSourceElement)theEObject;
				T result = caseInstanceSelectorExternalSourceElement(instanceSelectorExternalSourceElement);
				if (result == null) result = caseExternalDynamicSourceElement(instanceSelectorExternalSourceElement);
				if (result == null) result = caseInstanceSelectorSourceInterface(instanceSelectorExternalSourceElement);
				if (result == null) result = caseDynamicSourceElement(instanceSelectorExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(instanceSelectorExternalSourceElement);
				if (result == null) result = caseNamedElement(instanceSelectorExternalSourceElement);
				if (result == null) result = caseModifiableElement(instanceSelectorExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT: {
				InstanceSelectorGlobalSourceElement instanceSelectorGlobalSourceElement = (InstanceSelectorGlobalSourceElement)theEObject;
				T result = caseInstanceSelectorGlobalSourceElement(instanceSelectorGlobalSourceElement);
				if (result == null) result = caseGlobalDynamicSourceElement(instanceSelectorGlobalSourceElement);
				if (result == null) result = caseInstanceSelectorSourceInterface(instanceSelectorGlobalSourceElement);
				if (result == null) result = caseDynamicSourceElement(instanceSelectorGlobalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(instanceSelectorGlobalSourceElement);
				if (result == null) result = caseNamedElement(instanceSelectorGlobalSourceElement);
				if (result == null) result = caseModifiableElement(instanceSelectorGlobalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.DYNAMIC_SOURCE_ELEMENT: {
				DynamicSourceElement<?, ?, ?, ?> dynamicSourceElement = (DynamicSourceElement<?, ?, ?, ?>)theEObject;
				T result = caseDynamicSourceElement(dynamicSourceElement);
				if (result == null) result = caseNamedElement(dynamicSourceElement);
				if (result == null) result = caseModifiableElement(dynamicSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT: {
				LocalDynamicSourceElement<?, ?, ?, ?> localDynamicSourceElement = (LocalDynamicSourceElement<?, ?, ?, ?>)theEObject;
				T result = caseLocalDynamicSourceElement(localDynamicSourceElement);
				if (result == null) result = caseDynamicSourceElement(localDynamicSourceElement);
				if (result == null) result = caseNamedElement(localDynamicSourceElement);
				if (result == null) result = caseModifiableElement(localDynamicSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.EXTERNAL_DYNAMIC_SOURCE_ELEMENT: {
				ExternalDynamicSourceElement<?, ?, ?, ?> externalDynamicSourceElement = (ExternalDynamicSourceElement<?, ?, ?, ?>)theEObject;
				T result = caseExternalDynamicSourceElement(externalDynamicSourceElement);
				if (result == null) result = caseDynamicSourceElement(externalDynamicSourceElement);
				if (result == null) result = caseNamedElement(externalDynamicSourceElement);
				if (result == null) result = caseModifiableElement(externalDynamicSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.GLOBAL_DYNAMIC_SOURCE_ELEMENT: {
				GlobalDynamicSourceElement<?, ?, ?, ?, ?> globalDynamicSourceElement = (GlobalDynamicSourceElement<?, ?, ?, ?, ?>)theEObject;
				T result = caseGlobalDynamicSourceElement(globalDynamicSourceElement);
				if (result == null) result = caseDynamicSourceElement(globalDynamicSourceElement);
				if (result == null) result = caseNamedElement(globalDynamicSourceElement);
				if (result == null) result = caseModifiableElement(globalDynamicSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Source Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Instance Selector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceInstanceSelector(SourceInstanceSelector object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Instance Selector Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Selector Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSelectorSourceElement(InstanceSelectorSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Selector External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Selector External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSelectorExternalSourceElement(InstanceSelectorExternalSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Selector Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Selector Global Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceSelectorGlobalSourceElement(InstanceSelectorGlobalSourceElement object) {
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

} //StructureSwitch
