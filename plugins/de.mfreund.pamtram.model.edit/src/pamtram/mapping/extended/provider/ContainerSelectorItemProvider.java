/**
 */
package pamtram.mapping.extended.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ContainerSelectorTargetAttribute;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.impl.ExtendedPackageImpl;
import pamtram.mapping.provider.MappingHintItemProvider;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.impl.StructurePackageImpl;

/**
 * This is the item provider adapter for a
 * {@link pamtram.mapping.extended.ContainerSelector} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ContainerSelectorItemProvider extends MappingHintItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ContainerSelectorItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExpressionPropertyDescriptor(object);
			addModifiersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Expression feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExpressionElement_expression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExpressionElement_expression_feature", "_UI_ExpressionElement_type"),
				 PamtramPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modifiers feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addModifiersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ModifiableElement_modifiers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ModifiableElement_modifiers_feature", "_UI_ModifiableElement_type"),
				 PamtramPackage.Literals.MODIFIABLE_ELEMENT__MODIFIERS,
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS);
			childrenFeatures.add(ExtendedPackage.Literals.CONTAINER_SELECTOR__TARGET_ATTRIBUTES);
		}
		return childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {

		if (this.labelRelatedChildrenFeatures == null) {
			this.labelRelatedChildrenFeatures = new ArrayList<>();
			this.labelRelatedChildrenFeatures.add(StructurePackageImpl.eINSTANCE.getInstanceSelector_SourceElements());
			this.labelRelatedChildrenFeatures
					.add(ExtendedPackageImpl.eINSTANCE.getContainerSelector_TargetAttributes());
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ContainerSelector"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		this.initializeLabelRelatedChildrenFeatureNotifications(object);

		ContainerSelector mch = (ContainerSelector) object;
		StyledString styledLabel = new StyledString();

		ArrayList<String> targets = new ArrayList<>();
		for (ContainerSelectorTargetAttribute target : mch.getTargetAttributes()) {
			targets.add(target.getName());
		}
		styledLabel.append(String.join(", ", targets), StyledString.Style.COUNTER_STYLER);

		ArrayList<String> sources = new ArrayList<>();
		for (InstanceSelectorSourceInterface source : mch.getSourceElements()) {
			sources.add(source.getName());
		}
		styledLabel.append(" == " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ContainerSelector.class)) {
			case ExtendedPackage.CONTAINER_SELECTOR__EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ExtendedPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
			case ExtendedPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES:
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
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

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

		newChildDescriptors.add
			(createChildParameter
				(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createGlobalAttributeImporter()));

		newChildDescriptors.add
			(createChildParameter
				(ExtendedPackage.Literals.CONTAINER_SELECTOR__TARGET_ATTRIBUTES,
				 ExtendedFactory.eINSTANCE.createContainerSelectorTargetAttribute()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

}
