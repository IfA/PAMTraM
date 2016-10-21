/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.List;

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

import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionFactory;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.commands.BasicDragAndDropSetCommand;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.MappingHintGroup} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingHintGroupItemProvider
extends MappingHintGroupTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHintGroupItemProvider(AdapterFactory adapterFactory) {
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

			addDeactivatedPropertyDescriptor(object);
			addSharedConditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Deactivated feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION);
			childrenFeatures.add(MappingPackage.Literals.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER);
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
	 * This returns MappingHintGroup.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MappingHintGroup"));
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

		StyledString styledLabel = (StyledString) super.getStyledText(object);

		if(((MappingHintGroup) object).isDeactivated()) {
			return new StyledString(styledLabel.getString(), StyledString.Style.newBuilder().setStrikedout(true).toStyle());
		} else {
			return styledLabel;

		}
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

		switch (notification.getFeatureID(MappingHintGroup.class)) {
			case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION:
			case MappingPackage.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER:
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
	protected void collectNewChildDescriptorsGen(Collection<Object> newChildDescriptors, Object object) {
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
				(MappingPackage.Literals.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER,
				 MappingFactory.eINSTANCE.createContainerSelector()));
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		collectNewChildDescriptorsGen(newChildDescriptors, object);

		newChildDescriptors.add
		(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP__MODEL_CONNECTION_MATCHER,
						MappingFactory.eINSTANCE.createContainerSelectorWithSourceAndTarget()));

	}

	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {

		// provide labels for the custom child descriptors
		if(child instanceof ContainerSelector) {
			ContainerSelector modelConnectionHint = (ContainerSelector) child;
			if(!modelConnectionHint.getSourceElements().isEmpty() &&
					!modelConnectionHint.getTargetAttributes().isEmpty()) {
				return super.getCreateChildText(owner, feature, child, selection) + " (incl. Source and Target Attribute)";
			}
		} 
		return super.getCreateChildText(owner, feature, child, selection);
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		if(collection.size() == 1) {
			Object object = (Object) collection.iterator().next();
			if(object instanceof ComplexCondition) {
				return new BasicDragAndDropSetCommand(domain, (EObject) owner, 
						PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION, object, 0);
			}
		}
		
		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}
}
