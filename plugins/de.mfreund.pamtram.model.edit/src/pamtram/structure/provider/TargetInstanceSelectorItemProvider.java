/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.StructurePackage;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.target.TargetSection;

/**
 * This is the item provider adapter for a {@link pamtram.structure.TargetInstanceSelector} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class TargetInstanceSelectorItemProvider extends InstanceSelectorItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetInstanceSelectorItemProvider(AdapterFactory adapterFactory) {
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

			addReferenceAttributePropertyDescriptor(object);
			addTargetClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Reference Attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected void addReferenceAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TargetInstanceSelector_referenceAttribute_feature"),
				 getString("_UI_TargetInstanceSelector_referenceAttribute_description"),
				 StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null) {
				
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
				
					Collection<?> choices = super.getChoiceOfValues(object);
					
					// If a 'targetClass' has already been set for this 'TargetInstanceSelector', allow only those choices
						// that are part of the same TargetSection as the specified 'targetClass' (or of one of the extended
						// sections).
						//
						if (object instanceof TargetInstanceSelector
								&& ((TargetInstanceSelector) object).getTargetClass() != null) {
					
						TargetSection section = ((TargetInstanceSelector) object).getTargetClass().getContainingSection();
							if (section != null) {
					
							List<TargetSection> allowedSections = new ArrayList<>(Arrays.asList(section));
								allowedSections.addAll(section.getAllExtend());
					
							return choices.stream()
										.filter(c -> c instanceof pamtram.structure.target.TargetSectionAttribute && allowedSections
												.contains(((pamtram.structure.target.TargetSectionAttribute) c).getContainingSection()))
										.collect(Collectors.toList());
							}
					
					}
					
					return choices;
				}
			});
	}

	/**
	 * This adds a property descriptor for the Target Class feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetClassPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_TargetInstanceSelector_targetClass_feature"),
						this.getString("_UI_TargetInstanceSelector_targetClass_description"),
						StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS, true, false, true, null,
						this.getString("_UI_BasicPropertyCategory"), null) {
		
					@Override
					public Collection<?> getChoiceOfValues(Object object) {
		
						Collection<?> choices = super.getChoiceOfValues(object);
		
						// If an 'affectedReference' has already been set for this 'TargetInstanceSelector', allow only
						// those choices
						// that are compatible with the selected reference.
						//
						if (object instanceof ReferenceTargetSelector
								&& ((ReferenceTargetSelector) object).getAffectedReference() != null
								&& ((ReferenceTargetSelector) object).getAffectedReference().getEReference() != null) {
		
							ReferenceTargetSelector referenceTargetSelector = (ReferenceTargetSelector) object;
		
							return choices.stream().filter(c -> c instanceof pamtram.structure.target.TargetSectionClass)
									.map(c -> (pamtram.structure.target.TargetSectionClass) c)
									.filter(targetClass -> targetClass.getEClass() != null
											&& referenceTargetSelector.getAffectedReference().getEReference()
													.getEReferenceType().isSuperTypeOf(targetClass.getEClass()))
									.collect(Collectors.toList());
		
						}
		
						return super.getChoiceOfValues(object);
					}
				});
	}

	/**
	 * This returns TargetInstanceSelector.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TargetInstanceSelector"));
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
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((TargetInstanceSelector)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_TargetInstanceSelector_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_TargetInstanceSelector_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
		}
		return styledLabel;
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
	}

}
