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
package pamtram.mapping.extended.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.edit.commands.BasicDragAndDropSetCommand;
import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionFactory;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.provider.DeactivatableElementItemProvider;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.extended.MappingHint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingHintItemProvider extends MappingHintTypeItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHintItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSharedConditionPropertyDescriptor(object);
			addDeactivatedPropertyDescriptor(object);
			addOverwritePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Shared Condition feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addSharedConditionPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_ConditionalElement_sharedCondition_feature"),
						this.getString("_UI_ConditionalElement_sharedCondition_description"),
						PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION, true, false, true, null,
						this.getString("_UI_ExtendedPropertyCategory"), null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						Collection<?> choices = super.getChoiceOfValues(object);

						// Only allow to reference ConditionModel-conditions as
						// shared
						// conditions
						//
						return choices.stream()
								.filter(c -> c instanceof ComplexCondition
										&& ((ComplexCondition) c).isConditionModelCondition())
								.collect(Collectors.toList());
					}
				});
	}

	/**
	 * This adds a property descriptor for the Deactivated feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDeactivatedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DeactivatableElement_deactivated_feature"),
				 getString("_UI_DeactivatableElement_deactivated_description"),
				 PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ExtendedPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Overwrite feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOverwritePropertyDescriptor(Object object) {
		// ContainerSelectors will always overwrite extended Selectors so they do not need this descriptor
		//
		if (!(object instanceof ContainerSelector)) {
		
			this.itemPropertyDescriptors.add(new ItemPropertyDescriptor(
					((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
					this.getResourceLocator(), this.getString("_UI_MappingHint_overwrite_feature"),
					this.getString("_UI_MappingHint_overwrite_description"),
					ExtendedPackage.Literals.MAPPING_HINT__OVERWRITE, true, false, true, null,
					this.getString("_UI_ExtendedPropertyCategory"), null) {
		
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
		
					MappingHint hint = (MappingHint) object;
					if (!(hint.eContainer() instanceof MappingHintGroupType)) {
						return new ArrayList<>();
					}
		
					Set<MappingHint> possibleOverwrites = ((MappingHintGroupType) hint.eContainer()).getExtend()
							.stream().flatMap(h -> h.getAllMappingHints().stream())
							.filter(h -> hint.eClass().equals(h.eClass()))
							.collect(Collectors.toCollection(java.util.LinkedHashSet::new));
		
					if (hint instanceof AttributeMapping) {
						AttributeMapping attributeMapping = (AttributeMapping) hint;
						if (attributeMapping.getTarget() == null) {
							return new ArrayList<>();
						} else {
							return possibleOverwrites.stream().map(h -> (AttributeMapping) h)
									.filter(am -> attributeMapping.getTarget().equals(am.getTarget()))
									.collect(Collectors.toList());
						}
					} else if (hint instanceof CardinalityMapping) {
						CardinalityMapping cardinalityMapping = (CardinalityMapping) hint;
						if (cardinalityMapping.getTarget() == null) {
							return new ArrayList<>();
						} else {
							return possibleOverwrites.stream().map(h -> (CardinalityMapping) h)
									.filter(cm -> cardinalityMapping.getTarget().equals(cm.getTarget()))
									.collect(Collectors.toList());
						}
					} else if (hint instanceof ReferenceTargetSelector) {
						ReferenceTargetSelector referenceTargetSelector = (ReferenceTargetSelector) hint;
						if (referenceTargetSelector.getAffectedReference() == null) {
							return new ArrayList<>();
						} else {
							return possibleOverwrites.stream().map(h -> (ReferenceTargetSelector) h)
									.filter(rts -> referenceTargetSelector.getAffectedReference()
											.equals(rts.getAffectedReference()))
									.collect(Collectors.toList());
						}
					} else if (hint instanceof ContainerSelector) {
						return new ArrayList<>(possibleOverwrites);
					} else {
						return new ArrayList<>();
					}
				}
			});
		}
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((MappingHint) object).getName();
		StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(this.getString("_UI_MappingHint_type"), StyledString.Style.QUALIFIER_STYLER);
		} else {
			styledLabel.append(this.getString("_UI_MappingHint_type"), StyledString.Style.QUALIFIER_STYLER)
					.append(" " + label);
		}

		return DeactivatableElementItemProvider.modifyLabelBasedOnActivationStatus((DeactivatableElement) object,
				styledLabel);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MappingHint.class)) {
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				 ConditionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				 ConditionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				 ConditionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				 ConditionFactory.eINSTANCE.createAttributeCondition()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				 ConditionFactory.eINSTANCE.createCardinalityCondition()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				 ConditionFactory.eINSTANCE.createApplicationDependency()));
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		if (collection.size() == 1) {
			Object object = collection.iterator().next();
			if (object instanceof ComplexCondition) {
				return new BasicDragAndDropSetCommand(domain, (EObject) owner,
						PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION, object, 0);
			}
		}

		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}

}
