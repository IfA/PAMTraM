/**
 */
package pamtram.provider;

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

import pamtram.MappingModel;
import pamtram.PamtramPackage;
import pamtram.condition.ConditionFactory;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.modifier.ModifierFactory;

/**
 * This is the item provider adapter for a {@link pamtram.MappingModel} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class MappingModelItemProvider extends NamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MappingModelItemProvider(AdapterFactory adapterFactory) {
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

			addDeactivatedPropertyDescriptor(object);
			addSharedConditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_PropertyDescriptor_description", "_UI_DeactivatableElement_deactivated_feature", "_UI_DeactivatableElement_type"),
				 PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Shared Condition feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSharedConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConditionalElement_sharedCondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConditionalElement_sharedCondition_feature", "_UI_ConditionalElement_type"),
				 PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION,
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION);
			childrenFeatures.add(PamtramPackage.Literals.MAPPING_MODEL__MAPPING);
			childrenFeatures.add(PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS);
			childrenFeatures.add(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES);
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
	 * This returns MappingModel.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MappingModel"));
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

		String label = ((MappingModel) object).getName();
		StyledString styledLabel = new StyledString();
		if (((MappingModel) object).eContainer() == null) {
			styledLabel.append("Shared", StyledString.Style.QUALIFIER_STYLER);
		}
		if (label != null && label.length() > 0) {
			if (!styledLabel.getString().isEmpty()) {
				styledLabel.append(" ");
			}
			styledLabel.append(label);
		}

		if (((MappingModel) object).isDeactivated()) {
			return new StyledString(styledLabel.getString(),
					StyledString.Style.newBuilder().setStrikedout(true).toStyle());
		} else {
			return styledLabel;

		}
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

		switch (notification.getFeatureID(MappingModel.class)) {
			case PamtramPackage.MAPPING_MODEL__DEACTIVATED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PamtramPackage.MAPPING_MODEL__LOCAL_CONDITION:
			case PamtramPackage.MAPPING_MODEL__MAPPING:
			case PamtramPackage.MAPPING_MODEL__MODIFIER_SETS:
			case PamtramPackage.MAPPING_MODEL__GLOBAL_VALUES:
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

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.MAPPING_MODEL__MAPPING,
				 MappingFactory.eINSTANCE.createMapping()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS,
				 ModifierFactory.eINSTANCE.createValueModifierSet()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES,
				 MappingFactory.eINSTANCE.createFixedValue()));
	}

}
