/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.AttributeMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeMappingItemProvider
extends MappingHintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMappingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExpressionPropertyDescriptor(object);
			addResultModifierPropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}



	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributeMapping_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributeMapping_target_feature", "_UI_AttributeMapping_type"),
				 MappingPackage.Literals.ATTRIBUTE_MAPPING__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(),
						this.getString("_UI_AttributeMapping_target_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_AttributeMapping_target_feature", "_UI_AttributeMapping_type"),
						MappingPackage.Literals.ATTRIBUTE_MAPPING__TARGET,
						true,
						false,
						true,
						null,
						null,
						null)
		{
			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				AttributeMapping attrMapping=(AttributeMapping) object;

				// the target sections
				TargetSectionClass target = null;
				if(attrMapping.eContainer()  instanceof MappingHintGroupType){
					target=((MappingHintGroupType)attrMapping.eContainer()).getTargetSection();
				} else if(attrMapping.eContainer() instanceof MappingHintGroupImporter){
					target=((MappingHintGroupImporter)attrMapping.eContainer()).getHintGroup().getTargetSection();
				}

				if (target == null) {
					return new ArrayList<>();
				}

				List<Object> choiceOfValues = new ArrayList<>();

				if (target.isLibraryEntry() && target.eContainer().eContainer() instanceof LibraryEntry) {

					LibraryEntry libEntry = (LibraryEntry) target.eContainer().eContainer();
					choiceOfValues.addAll(
							libEntry.getParameters().parallelStream()
									.filter(p -> p instanceof pamtram.metamodel.AttributeParameter)
									.map(p -> ((pamtram.metamodel.AttributeParameter) p).getAttribute())
									.collect(Collectors.toList()));
					choiceOfValues.addAll(libEntry.getResourceParameters().parallelStream().map(p -> p.getAttribute())
							.collect(Collectors.toList()));

				} else {

					// iterate over all elements and return the attributes as
					// possible options
					Iterator<EObject> it = target.eAllContents();
					while (it.hasNext()) {
						EObject next = it.next();
						if (next instanceof pamtram.metamodel.Attribute) {
							choiceOfValues.add(next);
						}
					}
				}

				return choiceOfValues;
			}
		});
	}

	/**
	 * This adds a property descriptor for the Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExpressionHint_expression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExpressionHint_expression_feature", "_UI_ExpressionHint_type"),
				 MappingPackage.Literals.EXPRESSION_HINT__EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Result Modifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultModifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ModifiableHint_resultModifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ModifiableHint_resultModifier_feature", "_UI_ModifiableHint_type"),
				 MappingPackage.Literals.MODIFIABLE_HINT__RESULT_MODIFIER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS);
		}
		return childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if(this.labelRelatedChildrenFeatures == null) {
			this.labelRelatedChildrenFeatures = new ArrayList<>();
			this.labelRelatedChildrenFeatures.add(MappingPackage.eINSTANCE.getAttributeMapping_SourceElements());
			this.labelRelatedChildrenFeatures.add(MappingPackage.eINSTANCE.getAttributeMapping_Target());
			/*
			 * we do not need to add the 'expression' feature here as notifications for this attribute are already generated
			 * automatically as its 'Notify' property in the genmodel is set to 'true'
			 */
		}
		return this.labelRelatedChildrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns AttributeMapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributeMapping"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		this.initializeLabelRelatedChildrenFeatureNotifications(object);

		AttributeMapping am = (AttributeMapping)object;
		StyledString styledLabel = new StyledString();

		String label = am.getName();
		if((label == null || label.isEmpty()) && am.getTarget() != null) {
			label = am.getTarget().getName();
		}

		if(label != null) {
			styledLabel.append(label);
		}

		if(am.getExpression() != null && !am.getExpression().isEmpty()) {
			styledLabel.append(" = " + am.getExpression(), StyledString.Style.COUNTER_STYLER);
		} else {
			ArrayList<String> sources = new ArrayList<>();
			for (AttributeMappingSourceInterface source : am.getSourceElements()) {
				sources.add(source.getName());
				//				registerNotifyChangedListener(am, source, adapterFactory);
			}
			styledLabel.append(" = " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);
		}

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AttributeMapping.class)) {
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	@Override
	public void notifyChanged(Notification notification) {

		this.handleLabelRelatedChildrenFeatureChangeNotification(notification);

		this.notifyChangedGen(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createAttributeMappingSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createFixedValue()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createGlobalAttributeImporter()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createAttributeMappingExternalSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createAttributeMappingGlobalSourceElement()));
	}

}
