/**
 */
package pamtram.condition.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.condition.ConditionPackage;
import pamtram.condition.SectionCondition;
import pamtram.mapping.commands.BasicDragAndDropSetCommand;
import pamtram.metamodel.SourceSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.condition.SectionCondition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SectionConditionItemProvider extends ConditionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SectionConditionItemProvider(AdapterFactory adapterFactory) {
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

			addConditionSectionRefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Condition Section Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionSectionRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SectionCondition_conditionSectionRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SectionCondition_conditionSectionRef_feature", "_UI_SectionCondition_type"),
				 ConditionPackage.Literals.SECTION_CONDITION__CONDITION_SECTION_REF,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns SectionCondition.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SectionCondition"));
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
		String label = ((SectionCondition)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_SectionCondition_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_SectionCondition_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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
	}
	
	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		if(collection.size() == 1 && collection.iterator().next() instanceof SourceSectionClass) {
			return new BasicDragAndDropSetCommand(domain, (EObject) owner, ConditionPackage.Literals.SECTION_CONDITION__CONDITION_SECTION_REF, 
					collection.iterator().next(), 0);
		}
		
		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}

}
