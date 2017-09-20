/**
 */
package pamtram.mapping.extended.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.DeactivatableElement;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.provider.DeactivatableElementItemProvider;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.impl.StructurePackageImpl;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.extended.ContainerSelector} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ContainerSelectorItemProvider extends MappingHintItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerSelectorItemProvider(AdapterFactory adapterFactory) {
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
			(createItemPropertyDescriptor
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
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Class feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TargetInstanceSelector_targetClass_feature"),
				 getString("_UI_TargetInstanceSelector_targetClass_description"),
				 StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null));
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
			this.labelRelatedChildrenFeatures.add(StructurePackageImpl.eINSTANCE.getInstanceSelector_SourceElements());
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
	 * This returns ContainerSelector.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ContainerSelector"));
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

		ContainerSelector mch = (ContainerSelector) object;
		StyledString styledLabel = new StyledString();

		if (mch.getReferenceAttribute() != null) {
			styledLabel.append(mch.getReferenceAttribute().getName(), StyledString.Style.COUNTER_STYLER);
		}

		ArrayList<String> sources = new ArrayList<>();
		for (InstanceSelectorSourceInterface source : mch.getSourceElements()) {
			sources.add(source.getName());
		}
		styledLabel.append(" == " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);

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
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ContainerSelector.class)) {
			case ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
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

}
