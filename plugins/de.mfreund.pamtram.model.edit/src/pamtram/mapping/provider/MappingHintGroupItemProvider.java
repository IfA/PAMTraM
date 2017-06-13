/**
 */
package pamtram.mapping.provider;

import java.util.Collection;
import java.util.List;
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
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.provider.DeactivatableElementItemProvider;

/**
 * This is the item provider adapter for a
 * {@link pamtram.mapping.MappingHintGroup} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class MappingHintGroupItemProvider extends MappingHintGroupTypeItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MappingHintGroupItemProvider(AdapterFactory adapterFactory) {
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
		if (this.itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			this.addDeactivatedPropertyDescriptor(object);
			this.addSharedConditionPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Deactivated feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addDeactivatedPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_DeactivatableElement_deactivated_feature"),
				this.getString("_UI_DeactivatableElement_deactivated_description"),
				PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, this.getString("_UI_ExtendedPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Shared Condition feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
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
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (this.childrenFeatures == null) {
			super.getChildrenFeatures(object);
			this.childrenFeatures.add(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION);
		}
		return this.childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MappingHintGroup.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/MappingHintGroup"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString) this.getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		StyledString styledLabel = (StyledString) super.getStyledText(object);

		return DeactivatableElementItemProvider.modifyLabelBasedOnActivationStatus((DeactivatableElement) object,
				styledLabel);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		this.updateChildren(notification);

		switch (notification.getFeatureID(MappingHintGroup.class)) {
		case MappingPackage.MAPPING_HINT_GROUP__DEACTIVATED:
			this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case MappingPackage.MAPPING_HINT_GROUP__LOCAL_CONDITION:
			this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptorsGen(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createAttributeCondition()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createCardinalityCondition()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createApplicationDependency()));
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		this.collectNewChildDescriptorsGen(newChildDescriptors, object);

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createContainerSelectorWithSourceAndTarget()));

	}

	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {

		// provide labels for the custom child descriptors
		if (child instanceof ContainerSelector) {
			ContainerSelector modelConnectionHint = (ContainerSelector) child;
			if (!modelConnectionHint.getSourceElements().isEmpty()
					&& !modelConnectionHint.getTargetAttributes().isEmpty()) {
				return super.getCreateChildText(owner, feature, child, selection)
						+ " (incl. Source and Target Attribute)";
			}
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
