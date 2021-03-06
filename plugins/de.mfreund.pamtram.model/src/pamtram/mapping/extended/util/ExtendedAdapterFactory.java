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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.extended.ExtendedPackage
 * @generated
 */
public class ExtendedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExtendedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExtendedPackage.eINSTANCE;
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
	protected ExtendedSwitch<Adapter> modelSwitch =
		new ExtendedSwitch<Adapter>() {
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
			public Adapter caseExpandableHint(ExpandableHint object) {
				return createExpandableHintAdapter();
			}
			@Override
			public Adapter caseHintImporterMappingHint(HintImporterMappingHint object) {
				return createHintImporterMappingHintAdapter();
			}
			@Override
			public Adapter caseMappingHintSourceInterface(MappingHintSourceInterface object) {
				return createMappingHintSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseGlobalAttributeImporter(GlobalAttributeImporter object) {
				return createGlobalAttributeImporterAdapter();
			}
			@Override
			public Adapter caseAttributeMapping(AttributeMapping object) {
				return createAttributeMappingAdapter();
			}
			@Override
			public Adapter caseAttributeMappingSourceInterface(AttributeMappingSourceInterface object) {
				return createAttributeMappingSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseAttributeMappingSourceElement(AttributeMappingSourceElement object) {
				return createAttributeMappingSourceElementAdapter();
			}
			@Override
			public Adapter caseAttributeMappingExternalSourceElement(AttributeMappingExternalSourceElement object) {
				return createAttributeMappingExternalSourceElementAdapter();
			}
			@Override
			public Adapter caseAttributeMappingGlobalSourceElement(AttributeMappingGlobalSourceElement object) {
				return createAttributeMappingGlobalSourceElementAdapter();
			}
			@Override
			public Adapter caseCardinalityMapping(CardinalityMapping object) {
				return createCardinalityMappingAdapter();
			}
			@Override
			public Adapter caseCardinalityMappingSourceInterface(CardinalityMappingSourceInterface object) {
				return createCardinalityMappingSourceInterfaceAdapter();
			}
			@Override
			public Adapter caseCardinalityMappingSourceElement(CardinalityMappingSourceElement object) {
				return createCardinalityMappingSourceElementAdapter();
			}
			@Override
			public Adapter caseCardinalityMappingExternalSourceElement(CardinalityMappingExternalSourceElement object) {
				return createCardinalityMappingExternalSourceElementAdapter();
			}
			@Override
			public Adapter caseCardinalityMappingGlobalSourceElement(CardinalityMappingGlobalSourceElement object) {
				return createCardinalityMappingGlobalSourceElementAdapter();
			}
			@Override
			public Adapter caseReferenceTargetSelector(ReferenceTargetSelector object) {
				return createReferenceTargetSelectorAdapter();
			}
			@Override
			public Adapter caseContainerSelector(ContainerSelector object) {
				return createContainerSelectorAdapter();
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
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseConditionalElement(ConditionalElement object) {
				return createConditionalElementAdapter();
			}
			@Override
			public Adapter caseDeactivatableElement(DeactivatableElement object) {
				return createDeactivatableElementAdapter();
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
			public Adapter caseExpressionElement(ExpressionElement object) {
				return createExpressionElementAdapter();
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
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseMatchSpecElement(MatchSpecElement<S, C, R, A> object) {
				return createMatchSpecElementAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseLocalDynamicSourceElement(LocalDynamicSourceElement<S, C, R, A> object) {
				return createLocalDynamicSourceElementAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> Adapter caseExternalDynamicSourceElement(ExternalDynamicSourceElement<S, C, R, A> object) {
				return createExternalDynamicSourceElementAdapter();
			}
			@Override
			public <S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>, InstanceSelectorType extends InstanceSelector> Adapter caseGlobalDynamicSourceElement(GlobalDynamicSourceElement<S, C, R, A, InstanceSelectorType> object) {
				return createGlobalDynamicSourceElementAdapter();
			}
			@Override
			public Adapter caseInstanceSelector(InstanceSelector object) {
				return createInstanceSelectorAdapter();
			}
			@Override
			public Adapter caseTargetInstanceSelector(TargetInstanceSelector object) {
				return createTargetInstanceSelectorAdapter();
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.AttributeMapping <em>Attribute Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.AttributeMapping
	 * @generated
	 */
	public Adapter createAttributeMappingAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.AttributeMappingSourceElement <em>Attribute Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.AttributeMappingSourceElement
	 * @generated
	 */
	public Adapter createAttributeMappingSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.AttributeMappingExternalSourceElement <em>Attribute Mapping External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.AttributeMappingExternalSourceElement
	 * @generated
	 */
	public Adapter createAttributeMappingExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.AttributeMappingGlobalSourceElement <em>Attribute Mapping Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.AttributeMappingGlobalSourceElement
	 * @generated
	 */
	public Adapter createAttributeMappingGlobalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.CardinalityMapping <em>Cardinality Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.CardinalityMapping
	 * @generated
	 */
	public Adapter createCardinalityMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.CardinalityMappingSourceInterface <em>Cardinality Mapping Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.CardinalityMappingSourceInterface
	 * @generated
	 */
	public Adapter createCardinalityMappingSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.CardinalityMappingSourceElement <em>Cardinality Mapping Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.CardinalityMappingSourceElement
	 * @generated
	 */
	public Adapter createCardinalityMappingSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.CardinalityMappingExternalSourceElement <em>Cardinality Mapping External Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.CardinalityMappingExternalSourceElement
	 * @generated
	 */
	public Adapter createCardinalityMappingExternalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.CardinalityMappingGlobalSourceElement <em>Cardinality Mapping Global Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.CardinalityMappingGlobalSourceElement
	 * @generated
	 */
	public Adapter createCardinalityMappingGlobalSourceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.ReferenceTargetSelector <em>Reference Target Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.ReferenceTargetSelector
	 * @generated
	 */
	public Adapter createReferenceTargetSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.ContainerSelector <em>Container Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.ContainerSelector
	 * @generated
	 */
	public Adapter createContainerSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.MappedAttributeValueExpander <em>Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.MappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.LocalMappedAttributeValueExpander <em>Local Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.LocalMappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createLocalMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.MappedAttributeValuePrepender <em>Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.MappedAttributeValuePrepender
	 * @generated
	 */
	public Adapter createMappedAttributeValuePrependerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.MappedAttributeValueAppender <em>Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.MappedAttributeValueAppender
	 * @generated
	 */
	public Adapter createMappedAttributeValueAppenderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.ExternalMappedAttributeValueExpander <em>External Mapped Attribute Value Expander</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.ExternalMappedAttributeValueExpander
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValueExpanderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.ExternalMappedAttributeValuePrepender <em>External Mapped Attribute Value Prepender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.ExternalMappedAttributeValuePrepender
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValuePrependerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.ExternalMappedAttributeValueAppender <em>External Mapped Attribute Value Appender</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.ExternalMappedAttributeValueAppender
	 * @generated
	 */
	public Adapter createExternalMappedAttributeValueAppenderAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.MappingHintBaseType <em>Mapping Hint Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.MappingHintBaseType
	 * @generated
	 */
	public Adapter createMappingHintBaseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.MappingHintType <em>Mapping Hint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.MappingHintType
	 * @generated
	 */
	public Adapter createMappingHintTypeAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.MappingHint <em>Mapping Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.MappingHint
	 * @generated
	 */
	public Adapter createMappingHintAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.ExpandableHint <em>Expandable Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.ExpandableHint
	 * @generated
	 */
	public Adapter createExpandableHintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.MappingHintSourceInterface <em>Mapping Hint Source Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.MappingHintSourceInterface
	 * @generated
	 */
	public Adapter createMappingHintSourceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.GlobalAttributeImporter <em>Global Attribute Importer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.GlobalAttributeImporter
	 * @generated
	 */
	public Adapter createGlobalAttributeImporterAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.MatchSpecElement <em>Match Spec Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.MatchSpecElement
	 * @generated
	 */
	public Adapter createMatchSpecElementAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.structure.GlobalDynamicSourceElement <em>Global Dynamic Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.GlobalDynamicSourceElement
	 * @generated
	 */
	public Adapter createGlobalDynamicSourceElementAdapter() {
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
	 * Creates a new adapter for an object of class '{@link pamtram.structure.TargetInstanceSelector <em>Target Instance Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.structure.TargetInstanceSelector
	 * @generated
	 */
	public Adapter createTargetInstanceSelectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link pamtram.mapping.extended.HintImporterMappingHint <em>Hint Importer Mapping Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see pamtram.mapping.extended.HintImporterMappingHint
	 * @generated
	 */
	public Adapter createHintImporterMappingHintAdapter() {
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

} //ExtendedAdapterFactory
