/**
 */
package pamtram.condition.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import pamtram.ConditionModel;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionFactory;
import pamtram.condition.ConditionPackage;
import pamtram.condition.MultipleConditionOperator;
import pamtram.mapping.commands.BasicDragAndDropAddCommand;

/**
 * This is the item provider adapter for a {@link pamtram.condition.MultipleConditionOperator} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MultipleConditionOperatorItemProvider extends ComplexConditionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleConditionOperatorItemProvider(AdapterFactory adapterFactory) {
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

			addCondPartsRefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Cond Parts Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCondPartsRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MultipleConditionOperator_condPartsRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MultipleConditionOperator_condPartsRef_feature", "_UI_MultipleConditionOperator_type"),
				 ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			{				
				@Override
				public Collection<?> getChoiceOfValues(Object object) {

					List<Object> choiceOfValues = new ArrayList<Object>();
					choiceOfValues.addAll(super.getChoiceOfValues(object));
					for(Iterator<Object> element = choiceOfValues.iterator(); element.hasNext();){
						EObject choiceValue = (EObject) element.next();
						
						if(!(choiceValue.eContainer() instanceof ConditionModel)){
							element.remove();
						}
					}
					
					return choiceOfValues;
				}
			});
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
			childrenFeatures.add(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS);
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
		String label = ((MultipleConditionOperator)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_MultipleConditionOperator_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_MultipleConditionOperator_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

		switch (notification.getFeatureID(MultipleConditionOperator.class)) {
			case ConditionPackage.MULTIPLE_CONDITION_OPERATOR__COND_PARTS:
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
				(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS,
				 ConditionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS,
				 ConditionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS,
				 ConditionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS,
				 ConditionFactory.eINSTANCE.createAttributeCondition()));

		newChildDescriptors.add
			(createChildParameter
				(ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS,
				 ConditionFactory.eINSTANCE.createSectionCondition()));
	}
	
	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		EList<ComplexCondition> values = new BasicEList<>();
		for (Object value : collection) {
			if(value instanceof ComplexCondition) {
				values.add((ComplexCondition) value);
			} else {
				return super.createDragAndDropCommand(domain, owner, location, operations,
						operation, collection); 
			}
		}
		
		if(values.isEmpty()) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		} else {
			return new BasicDragAndDropAddCommand(domain, (EObject) owner, 
					ConditionPackage.Literals.MULTIPLE_CONDITION_OPERATOR__COND_PARTS_REF, values);
		}
		
	}

}
