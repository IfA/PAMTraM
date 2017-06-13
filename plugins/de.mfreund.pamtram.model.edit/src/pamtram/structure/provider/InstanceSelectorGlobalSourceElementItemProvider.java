/**
 */
package pamtram.structure.provider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.PamtramPackage;
import pamtram.condition.ConditionFactory;
import pamtram.structure.InstanceSelectorGlobalSourceElement;
import pamtram.structure.StructurePackage;

/**
 * This is the item provider adapter for a
 * {@link pamtram.structure.InstanceSelectorGlobalSourceElement} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class InstanceSelectorGlobalSourceElementItemProvider extends GlobalDynamicSourceElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public InstanceSelectorGlobalSourceElementItemProvider(AdapterFactory adapterFactory) {
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

			addSharedConditionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
								.filter(c -> c instanceof pamtram.condition.ComplexCondition
										&& ((pamtram.condition.ComplexCondition) c).isConditionModelCondition())
								.collect(Collectors.toList());
					}
				});
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
	 * This returns InstanceSelectorGlobalSourceElement.gif.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InstanceSelectorGlobalSourceElement"));
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
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((InstanceSelectorGlobalSourceElement)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_InstanceSelectorGlobalSourceElement_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_InstanceSelectorGlobalSourceElement_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
		}
		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(InstanceSelectorGlobalSourceElement.class)) {
			case StructurePackage.INSTANCE_SELECTOR_GLOBAL_SOURCE_ELEMENT__LOCAL_CONDITION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

}
