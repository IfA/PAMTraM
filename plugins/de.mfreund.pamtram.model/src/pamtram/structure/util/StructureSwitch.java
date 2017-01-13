/**
 */
package pamtram.structure.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import pamtram.NamedElement;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.ModifiedAttributeElementType;
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
			case StructurePackage.LIBRARY_PARAMETER: {
				LibraryParameter<?> libraryParameter = (LibraryParameter<?>)theEObject;
				T result = caseLibraryParameter(libraryParameter);
				if (result == null) result = caseNamedElement(libraryParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.ATTRIBUTE_PARAMETER: {
				AttributeParameter attributeParameter = (AttributeParameter)theEObject;
				T result = caseAttributeParameter(attributeParameter);
				if (result == null) result = caseLibraryParameter(attributeParameter);
				if (result == null) result = caseNamedElement(attributeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.CONTAINER_PARAMETER: {
				ContainerParameter containerParameter = (ContainerParameter)theEObject;
				T result = caseContainerParameter(containerParameter);
				if (result == null) result = caseLibraryParameter(containerParameter);
				if (result == null) result = caseNamedElement(containerParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.EXTERNAL_REFERENCE_PARAMETER: {
				ExternalReferenceParameter externalReferenceParameter = (ExternalReferenceParameter)theEObject;
				T result = caseExternalReferenceParameter(externalReferenceParameter);
				if (result == null) result = caseLibraryParameter(externalReferenceParameter);
				if (result == null) result = caseNamedElement(externalReferenceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.RESOURCE_PARAMETER: {
				ResourceParameter resourceParameter = (ResourceParameter)theEObject;
				T result = caseResourceParameter(resourceParameter);
				if (result == null) result = caseNamedElement(resourceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.LIBRARY_ENTRY: {
				LibraryEntry libraryEntry = (LibraryEntry)theEObject;
				T result = caseLibraryEntry(libraryEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER: {
				InstancePointer instancePointer = (InstancePointer)theEObject;
				T result = caseInstancePointer(instancePointer);
				if (result == null) result = caseExpressionHint(instancePointer);
				if (result == null) result = caseModifiableHint(instancePointer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER_SOURCE_INTERFACE: {
				InstancePointerSourceInterface instancePointerSourceInterface = (InstancePointerSourceInterface)theEObject;
				T result = caseInstancePointerSourceInterface(instancePointerSourceInterface);
				if (result == null) result = caseMappingHintSourceInterface(instancePointerSourceInterface);
				if (result == null) result = caseNamedElement(instancePointerSourceInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER_SOURCE_ELEMENT: {
				InstancePointerSourceElement instancePointerSourceElement = (InstancePointerSourceElement)theEObject;
				T result = caseInstancePointerSourceElement(instancePointerSourceElement);
				if (result == null) result = caseLocalModifiedAttributeElementType(instancePointerSourceElement);
				if (result == null) result = caseInstancePointerSourceInterface(instancePointerSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(instancePointerSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(instancePointerSourceElement);
				if (result == null) result = caseNamedElement(instancePointerSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StructurePackage.INSTANCE_POINTER_EXTERNAL_SOURCE_ELEMENT: {
				InstancePointerExternalSourceElement instancePointerExternalSourceElement = (InstancePointerExternalSourceElement)theEObject;
				T result = caseInstancePointerExternalSourceElement(instancePointerExternalSourceElement);
				if (result == null) result = caseExternalModifiedAttributeElementType(instancePointerExternalSourceElement);
				if (result == null) result = caseInstancePointerSourceInterface(instancePointerExternalSourceElement);
				if (result == null) result = caseModifiedAttributeElementType(instancePointerExternalSourceElement);
				if (result == null) result = caseMappingHintSourceInterface(instancePointerExternalSourceElement);
				if (result == null) result = caseNamedElement(instancePointerExternalSourceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <ParameterType> T caseLibraryParameter(LibraryParameter<ParameterType> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeParameter(AttributeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerParameter(ContainerParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Reference Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Reference Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalReferenceParameter(ExternalReferenceParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceParameter(ResourceParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryEntry(LibraryEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointer(InstancePointer object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointerSourceElement(InstancePointerSourceElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Pointer External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Pointer External Source Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstancePointerExternalSourceElement(InstancePointerExternalSourceElement object) {
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
