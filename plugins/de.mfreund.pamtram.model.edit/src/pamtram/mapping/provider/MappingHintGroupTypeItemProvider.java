/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;

import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.MappingHintGroupType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingHintGroupTypeItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHintGroupTypeItemProvider(AdapterFactory adapterFactory) {
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

			addTargetMMSectionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target MM Section feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetMMSectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappingHintGroupType_targetMMSection_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappingHintGroupType_targetMMSection_feature", "_UI_MappingHintGroupType_type"),
				 MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_MM_SECTION,
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
			childrenFeatures.add(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS);
		}
		return childrenFeatures;
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MappingHintGroupType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MappingHintGroupType_type") :
			getString("_UI_MappingHintGroupType_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MappingHintGroupType.class)) {
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
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
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 MappingFactory.eINSTANCE.createCardinalityMapping()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 MappingFactory.eINSTANCE.createMappingInstanceSelector()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 MappingFactory.eINSTANCE.createSimpleAttributeMapping()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 MappingFactory.eINSTANCE.createComplexAttributeMapping()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 MappingFactory.eINSTANCE.createCalculatorMapping()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

}
