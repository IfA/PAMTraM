/**
 */
package pamtram.structure.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.structure.*;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public class StructureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StructurePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StructurePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureSwitch<Adapter> modelSwitch =
		new StructureSwitch<Adapter>() {
			@Override
			public <ParameterType> Adapter caseLibraryParameter(LibraryParameter<ParameterType> object) {
				return createLibraryParameterAdapter();
			}
			@Override
			public Adapter caseAttributeParameter(AttributeParameter object) {
				return createAttributeParameterAdapter();
			}
			@Override
			public Adapter caseContainerParameter(ContainerParameter object) {
				return createContainerParameterAdapter();
			}
			@Override
			public Adapter caseExternalReferenceParameter(ExternalReferenceParameter object) {
				return createExternalReferenceParameterAdapter();
			}
			@Override
			public Adapter caseResourceParameter(ResourceParameter object) {
				return createResourceParameterAdapter();
			}
			@Override
			public Adapter caseLibraryEntry(LibraryEntry object) {
				return createLibraryEntryAdapter();
			}
			@Override
			public Adapter caseInstanceSelector(InstanceSelector object) {
				return createInstanceSelectorAdapter();
			}
			@Override
			public Adapter caseInstanceSelectorSourceInterface(InstanceSelectorSourceInterface object) {
				return createInstanceSelectorSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseInstanceSelectorSourceElement(InstanceSelectorSourceElement object) {
				return createInstanceSelectorSourceElementAdapter();
			}
			@Override
			public Adapter caseInstanceSelectorExternalSourceElement(InstanceSelectorExternalSourceElement object) {
				return createInstanceSelectorExternalSourceElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseExpressionElement(ExpressionElement object) {
				return createExpressionElementAdapter();
			}
			@Override
			public Adapter caseModifiableElement(ModifiableElement object) {
				return createModifiableElementAdapter();
			}
			@Override
			public Adapter caseMappingHintSourceInterface(MappingHintSourceInterface object) {
				return createMappingHintSourceInterfaceAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseModifiedAttributeElementType(ModifiedAttributeElementType<S, C, R, A> object) {
				return createModifiedAttributeElementTypeAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseLocalModifiedAttributeElementType(LocalModifiedAttributeElementType<S, C, R, A> object) {
				return createLocalModifiedAttributeElementTypeAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseExternalModifiedAttributeElementType(ExternalModifiedAttributeElementType<S, C, R, A> object) {
				return createExternalModifiedAttributeElementTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.LibraryParameter <em>Library Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.LibraryParameter
	 * @generated
	 */
	public Adapter createLibraryParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.AttributeParameter <em>Attribute Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.AttributeParameter
	 * @generated
	 */
	public Adapter createAttributeParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.ContainerParameter <em>Container Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.ContainerParameter
	 * @generated
	 */
	public Adapter createContainerParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.ExternalReferenceParameter <em>External Reference Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.ExternalReferenceParameter
	 * @generated
	 */
	public Adapter createExternalReferenceParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.ResourceParameter <em>Resource Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.ResourceParameter
	 * @generated
	 */
	public Adapter createResourceParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.LibraryEntry <em>Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.LibraryEntry
	 * @generated
	 */
	public Adapter createLibraryEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.InstanceSelector <em>Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.InstanceSelector
	 * @generated
	 */
	public Adapter createInstanceSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.InstanceSelectorSourceInterface <em>Instance Selector Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.InstanceSelectorSourceInterface
	 * @generated
	 */
	public Adapter createInstanceSelectorSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.InstanceSelectorSourceElement <em>Instance Selector Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.InstanceSelectorSourceElement
	 * @generated
	 */
	public Adapter createInstanceSelectorSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.InstanceSelectorExternalSourceElement <em>Instance Selector External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.InstanceSelectorExternalSourceElement
	 * @generated
	 */
	public Adapter createInstanceSelectorExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.ExpressionElement <em>Expression Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.ExpressionElement
	 * @generated
	 */
	public Adapter createExpressionElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.ModifiableElement <em>Modifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.ModifiableElement
	 * @generated
	 */
	public Adapter createModifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintSourceInterface <em>Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintSourceInterface
	 * @generated
	 */
	public Adapter createMappingHintSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.ModifiedAttributeElementType <em>Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.ModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.LocalModifiedAttributeElementType <em>Local Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.LocalModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createLocalModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.ExternalModifiedAttributeElementType <em>External Modified Attribute Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.ExternalModifiedAttributeElementType
	 * @generated
	 */
	public Adapter createExternalModifiedAttributeElementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StructureAdapterFactory
