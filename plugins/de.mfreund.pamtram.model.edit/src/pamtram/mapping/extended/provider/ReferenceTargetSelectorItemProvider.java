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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.edit.commands.BasicDragAndDropCompoundCommand;
import pamtram.DeactivatableElement;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.provider.DeactivatableElementItemProvider;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.extended.ReferenceTargetSelector} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ReferenceTargetSelectorItemProvider extends MappingHintItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceTargetSelectorItemProvider(AdapterFactory adapterFactory) {
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

			addExpressionPropertyDescriptor(object);
			addModifiersPropertyDescriptor(object);
			addReferenceAttributePropertyDescriptor(object);
			addTargetClassPropertyDescriptor(object);
			addAffectedReferencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Expression feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExpressionElement_expression_feature"),
				 getString("_UI_ExpressionElement_expression_description"),
				 PamtramPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_ExtendedPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Modifiers feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModifiersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ModifiableElement_modifiers_feature"),
				 getString("_UI_ModifiableElement_modifiers_description"),
				 PamtramPackage.Literals.MODIFIABLE_ELEMENT__MODIFIERS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_ExtendedPropertyCategory"),
				 null));
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
	 * This adds a property descriptor for the Affected Reference feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAffectedReferencePropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ReferenceTargetSelector_affectedReference_feature"),
				this.getString("_UI_ReferenceTargetSelector_affectedReference_description"),
				ExtendedPackage.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE, true, false, true, null,
				this.getString("_UI_BasicPropertyCategory"), null) {
		
			@Override
			public Collection<?> getChoiceOfValues(Object object) {
		
				TargetSection target;
				if (((ReferenceTargetSelector) object).eContainer() instanceof MappingHintGroupType) {
					target = ((MappingHintGroupType) ((ReferenceTargetSelector) object).eContainer())
							.getTargetSection();
				} else {
					target = ((MappingHintGroupImporter) ((ReferenceTargetSelector) object).eContainer()).getHintGroup()
							.getTargetSection();
				}
		
				return Stream.concat(Arrays.asList(target).stream(), target.getAllExtend().stream()).flatMap(t -> {
		
					List<EObject> vals = new ArrayList<>();
					org.eclipse.emf.common.util.TreeIterator<EObject> it = t.eAllContents();
		
					while (it.hasNext()) {
						EObject next = it.next();
						if (next instanceof pamtram.structure.target.TargetSectionCrossReference) {
							vals.add(next);
						}
					}
		
					return vals.stream();
				}).collect(Collectors.toList());
		
			}
		
		});
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
			childrenFeatures.add(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS);
		}
		return childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {

		if (this.labelRelatedChildrenFeatures == null) {
			this.labelRelatedChildrenFeatures = new ArrayList<>();
			this.labelRelatedChildrenFeatures.add(StructurePackage.eINSTANCE.getInstanceSelector_SourceElements());
			/*
			 * we do not need to add the 'expression' feature here as notifications for this attribute are already
			 * generated automatically as its 'Notify' property in the genmodel is set to 'true'
			 */
		}
		return this.labelRelatedChildrenFeatures;
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
	 * This returns ReferenceTargetSelector.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ReferenceTargetSelector"));
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

		this.initializeLabelRelatedChildrenFeatureNotifications(object);

		ReferenceTargetSelector mis = (ReferenceTargetSelector) object;
		StyledString styledLabel = new StyledString();

		String label = mis.getName();

		if ((label == null || label.isEmpty()) && mis.getAffectedReference() != null) {
			label = mis.getAffectedReference().getName();
		}

		if (label != null) {
			styledLabel.append(label);
		}

		if (mis.getExpression() != null && !mis.getExpression().isEmpty()) {
			styledLabel.append(" = " + mis.getExpression(), StyledString.Style.COUNTER_STYLER);
		} else {
			ArrayList<String> sources = new ArrayList<>();
			for (InstanceSelectorSourceInterface source : mis.getSourceElements()) {
				sources.add(source.getName());
				// registerNotifyChangedListener(am, source, adapterFactory);
			}
			styledLabel.append(" = " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);
		}

		return DeactivatableElementItemProvider.modifyLabelBasedOnActivationStatus((DeactivatableElement) object,
				styledLabel);
	}

	@Override
	public void notifyChanged(Notification notification) {

		this.handleLabelRelatedChildrenFeatureChangeNotification(notification);
		this.notifyChangedGen(notification);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ReferenceTargetSelector.class)) {
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS:
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
				(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
				 ExtendedFactory.eINSTANCE.createGlobalAttributeImporter()));

		newChildDescriptors.add
			(createChildParameter
				(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
				 PamtramFactory.eINSTANCE.createFixedValue()));

		newChildDescriptors.add
			(createChildParameter
				(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
				 StructureFactory.eINSTANCE.createInstanceSelectorSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
				 StructureFactory.eINSTANCE.createInstanceSelectorExternalSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
				 StructureFactory.eINSTANCE.createInstanceSelectorGlobalSourceElement()));
	}

	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {

		// If the 'referenceAttribute' is set, automatically set the 'targetClass' if it has not been set before
		//
		if (owner instanceof ReferenceTargetSelector && value instanceof TargetSectionAttribute && (feature == null
				|| feature.equals(StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE))) {
			return new SetCommand(domain, owner, feature, value) {

				boolean setTargetClass = false;

				@Override
				public void doExecute() {

					super.doExecute();

					ReferenceTargetSelector referenceTargetSelector = (ReferenceTargetSelector) this.owner;
					if (referenceTargetSelector.getTargetClass() == null && this.value instanceof TargetSectionAttribute
							&& ((TargetSectionAttribute) this.value).eContainer() instanceof TargetSectionClass) {

						TargetSectionClass targetClass = (TargetSectionClass) ((TargetSectionAttribute) this.value)
								.eContainer();

						if (targetClass.getEClass() != null && referenceTargetSelector.getAffectedReference() != null
								&& referenceTargetSelector.getAffectedReference().getEReference() != null
								&& referenceTargetSelector.getAffectedReference().getEReference().getEReferenceType()
										.isSuperTypeOf(targetClass.getEClass())) {
							this.setTargetClass = true;
							((TargetInstanceSelector) this.owner).setTargetClass(targetClass);
						}
					}
				}

				@Override
				public void doUndo() {

					if (this.setTargetClass) {
						((TargetInstanceSelector) this.owner).setTargetClass(null);
					}
					super.doUndo();
				}

				@Override
				public void doRedo() {

					super.doRedo();

					if (this.setTargetClass) {
						TargetSectionClass targetClass = (TargetSectionClass) ((TargetSectionAttribute) this.value)
								.eContainer();
						((TargetInstanceSelector) this.owner).setTargetClass(targetClass);
					}
				}
			};
		}
		return super.createSetCommand(domain, owner, feature, value);
	}

	@Override
	public AbstractCommand createDragAndDropCommand(EditingDomain domain, Collection<EObject> collection,
			EObject parent, EReference ref) {

		// If the 'referenceAttribute' is set, automatically set the 'targetClass' if it has not been set before
		//
		if (parent instanceof ReferenceTargetSelector && collection.size() == 1
				&& collection.iterator().next() instanceof TargetSectionAttribute && (ref == null
						|| ref.equals(StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE))) {

			BasicDragAndDropCompoundCommand ret = new BasicDragAndDropCompoundCommand();
			ret.append(this.createSetCommand(domain, parent, ref, collection.iterator().next()));
			return ret;
		}
		return super.createDragAndDropCommand(domain, collection, parent, ref);
	}
}
