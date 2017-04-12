/**
 */
package pamtram.mapping.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.*;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.MappingPackage
 * @generated
 */
public class MappingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MappingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MappingPackage.eINSTANCE;
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
	protected MappingSwitch<Adapter> modelSwitch =
		new MappingSwitch<Adapter>() {
			@Override
			public Adapter caseMappingType(MappingType object) {
				return createMappingTypeAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseMappingHintGroupType(MappingHintGroupType object) {
				return createMappingHintGroupTypeAdapter();
			}
			@Override
			public Adapter caseInstantiableMappingHintGroup(InstantiableMappingHintGroup object) {
				return createInstantiableMappingHintGroupAdapter();
			}
			@Override
			public Adapter caseMappingHintGroup(MappingHintGroup object) {
				return createMappingHintGroupAdapter();
			}
			@Override
			public Adapter caseMappingHintGroupImporter(MappingHintGroupImporter object) {
				return createMappingHintGroupImporterAdapter();
			}
			@Override
			public Adapter caseExportedMappingHintGroup(ExportedMappingHintGroup object) {
				return createExportedMappingHintGroupAdapter();
			}
			@Override
			public Adapter caseMappingHintBaseType(MappingHintBaseType object) {
				return createMappingHintBaseTypeAdapter();
			}
			@Override
			public Adapter caseMappingHintType(MappingHintType object) {
				return createMappingHintTypeAdapter();
			}
			@Override
			public Adapter caseMappingHint(MappingHint object) {
				return createMappingHintAdapter();
			}
			@Override
			public Adapter caseHintImporterMappingHint(HintImporterMappingHint object) {
				return createHintImporterMappingHintAdapter();
			}
			@Override
			public Adapter caseMappedAttributeValueExpander(MappedAttributeValueExpander object) {
				return createMappedAttributeValueExpanderAdapter();
			}
			@Override
			public Adapter caseLocalMappedAttributeValueExpander(LocalMappedAttributeValueExpander object) {
				return createLocalMappedAttributeValueExpanderAdapter();
			}
			@Override
			public Adapter caseMappedAttributeValuePrepender(MappedAttributeValuePrepender object) {
				return createMappedAttributeValuePrependerAdapter();
			}
			@Override
			public Adapter caseMappedAttributeValueAppender(MappedAttributeValueAppender object) {
				return createMappedAttributeValueAppenderAdapter();
			}
			@Override
			public Adapter caseGlobalAttribute(GlobalAttribute object) {
				return createGlobalAttributeAdapter();
			}
			@Override
			public Adapter caseGlobalAttributeImporter(GlobalAttributeImporter object) {
				return createGlobalAttributeImporterAdapter();
			}
			@Override
			public Adapter caseMappingHintSourceInterface(MappingHintSourceInterface object) {
				return createMappingHintSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseExternalMappedAttributeValueExpander(ExternalMappedAttributeValueExpander object) {
				return createExternalMappedAttributeValueExpanderAdapter();
			}
			@Override
			public Adapter caseExternalMappedAttributeValuePrepender(ExternalMappedAttributeValuePrepender object) {
				return createExternalMappedAttributeValuePrependerAdapter();
			}
			@Override
			public Adapter caseExternalMappedAttributeValueAppender(ExternalMappedAttributeValueAppender object) {
				return createExternalMappedAttributeValueAppenderAdapter();
			}
			@Override
			public Adapter caseExpandableHint(ExpandableHint object) {
				return createExpandableHintAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseDeactivatableElement(DeactivatableElement object) {
				return createDeactivatableElementAdapter();
			}
			@Override
			public Adapter caseConditionalElement(ConditionalElement object) {
				return createConditionalElementAdapter();
			}
			@Override
			public Adapter caseModifiableElement(ModifiableElement object) {
				return createModifiableElementAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseDynamicSourceElement(DynamicSourceElement<S, C, R, A> object) {
				return createDynamicSourceElementAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseLocalDynamicSourceElement(LocalDynamicSourceElement<S, C, R, A> object) {
				return createLocalDynamicSourceElementAdapter();
			}
			@Override
			public Adapter caseAttributeMappingSourceInterface(AttributeMappingSourceInterface object) {
				return createAttributeMappingSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseInstanceSelectorSourceInterface(InstanceSelectorSourceInterface object) {
				return createInstanceSelectorSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseValueConstraintSourceInterface(ValueConstraintSourceInterface object) {
				return createValueConstraintSourceInterfaceAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseExternalDynamicSourceElement(ExternalDynamicSourceElement<S, C, R, A> object) {
				return createExternalDynamicSourceElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingType
	 * @generated
	 */
	public Adapter createMappingTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHint <em>Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHint
	 * @generated
	 */
	public Adapter createMappingHintAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.structure.DynamicSourceElement <em>Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.DynamicSourceElement
	 * @generated
	 */
	public Adapter createDynamicSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.LocalDynamicSourceElement <em>Local Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.LocalDynamicSourceElement
	 * @generated
	 */
	public Adapter createLocalDynamicSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.ExternalDynamicSourceElement <em>External Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.ExternalDynamicSourceElement
	 * @generated
	 */
	public Adapter createExternalDynamicSourceElementAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintGroup <em>Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintGroup
	 * @generated
	 */
	public Adapter createMappingHintGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintBaseType <em>Hint Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintBaseType
	 * @generated
	 */
	public Adapter createMappingHintBaseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintGroupType <em>Hint Group Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintGroupType
	 * @generated
	 */
	public Adapter createMappingHintGroupTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.InstantiableMappingHintGroup <em>Instantiable Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.InstantiableMappingHintGroup
	 * @generated
	 */
	public Adapter createInstantiableMappingHintGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintGroupImporter <em>Hint Group Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintGroupImporter
	 * @generated
	 */
	public Adapter createMappingHintGroupImporterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExportedMappingHintGroup <em>Exported Mapping Hint Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExportedMappingHintGroup
	 * @generated
	 */
	public Adapter createExportedMappingHintGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappingHintType <em>Hint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappingHintType
	 * @generated
	 */
	public Adapter createMappingHintTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.HintImporterMappingHint <em>Hint Importer Mapping Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.HintImporterMappingHint
	 * @generated
	 */
	public Adapter createHintImporterMappingHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappedAttributeValueExpander <em>Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.LocalMappedAttributeValueExpander <em>Local Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.LocalMappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createLocalMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappedAttributeValuePrepender <em>Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappedAttributeValuePrepender
	 * @generated
	 */
	public Adapter createMappedAttributeValuePrependerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.MappedAttributeValueAppender <em>Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.MappedAttributeValueAppender
	 * @generated
	 */
	public Adapter createMappedAttributeValueAppenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.GlobalAttribute <em>Global Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.GlobalAttribute
	 * @generated
	 */
	public Adapter createGlobalAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.GlobalAttributeImporter <em>Global Attribute Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.GlobalAttributeImporter
	 * @generated
	 */
	public Adapter createGlobalAttributeImporterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.AttributeMappingSourceInterface <em>Attribute Mapping Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.AttributeMappingSourceInterface
	 * @generated
	 */
	public Adapter createAttributeMappingSourceInterfaceAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalMappedAttributeValueExpander <em>External Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalMappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalMappedAttributeValuePrepender <em>External Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalMappedAttributeValuePrepender
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValuePrependerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExternalMappedAttributeValueAppender <em>External Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExternalMappedAttributeValueAppender
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValueAppenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.ExpandableHint <em>Expandable Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.ExpandableHint
	 * @generated
	 */
	public Adapter createExpandableHintAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.DeactivatableElement <em>Deactivatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.DeactivatableElement
	 * @generated
	 */
	public Adapter createDeactivatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.ConditionalElement <em>Conditional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.ConditionalElement
	 * @generated
	 */
	public Adapter createConditionalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.structure.constraint.ValueConstraintSourceInterface <em>Value Constraint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.constraint.ValueConstraintSourceInterface
	 * @generated
	 */
	public Adapter createValueConstraintSourceInterfaceAdapter() {
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

} //MappingAdapterFactory
