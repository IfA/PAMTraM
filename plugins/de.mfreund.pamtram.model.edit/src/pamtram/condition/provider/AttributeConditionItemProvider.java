/**
 */
package pamtram.condition.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import org.eclipse.emf.edit.provider.ViewerNotification;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ConditionPackage;
import pamtram.structure.constraint.ConstraintFactory;

/**
 * This is the item provider adapter for a {@link pamtram.condition.AttributeCondition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeConditionItemProvider extends ConditionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeConditionItemProvider(AdapterFactory adapterFactory) {
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

			addValueConstraintPropertyDescriptor(object);
			addConditionAttributeRefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Value Constraint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueConstraintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributeCondition_valueConstraint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributeCondition_valueConstraint_feature", "_UI_AttributeCondition_type"),
				 ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Condition Attribute Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionAttributeRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributeCondition_conditionAttributeRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributeCondition_conditionAttributeRef_feature", "_UI_AttributeCondition_type"),
				 ConditionPackage.Literals.ATTRIBUTE_CONDITION__CONDITION_ATTRIBUTE_REF,
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
			childrenFeatures.add(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT);
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
	 * This returns AttributeCondition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributeCondition"));
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
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((AttributeCondition)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_AttributeCondition_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_AttributeCondition_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AttributeCondition.class)) {
			case ConditionPackage.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT:
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
				(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 ConstraintFactory.eINSTANCE.createEqualityConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 ConstraintFactory.eINSTANCE.createNumericConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 ConstraintFactory.eINSTANCE.createSubstringConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 ConstraintFactory.eINSTANCE.createBeginningConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 ConstraintFactory.eINSTANCE.createEndingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 ConstraintFactory.eINSTANCE.createRegExConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.ATTRIBUTE_CONDITION__VALUE_CONSTRAINT,
				 ConstraintFactory.eINSTANCE.createRangeConstraint()));
	}
	
}
