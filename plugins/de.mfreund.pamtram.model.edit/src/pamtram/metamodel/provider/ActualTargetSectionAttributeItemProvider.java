/**
 */
package pamtram.metamodel.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.metamodel.ActualTargetSectionAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.MetamodelPackage;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.ActualTargetSectionAttribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActualTargetSectionAttributeItemProvider
extends TargetSectionAttributeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualTargetSectionAttributeItemProvider(AdapterFactory adapterFactory) {
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

			addAttributePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addAttributePropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(),
						this.getString("_UI_ActualAttribute_attribute_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_ActualAttribute_attribute_feature", "_UI_ActualAttribute_type"),
				MetamodelPackage.Literals.ACTUAL_ATTRIBUTE__ATTRIBUTE,
						true,
						false,
						true,
						null,
						null,
						null){

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				ActualTargetSectionAttribute att = (ActualTargetSectionAttribute) object;

				// in case of a 'normal' TargetSectionClass, the attribute of this class can be chosen
				if(att.getOwningClass() != null) {
					return att.getOwningClass().getEClass().getEAllAttributes();
					// in case of an AttributeParameter, the attribute of its source can be chosen
				} else if(att.eContainer() instanceof AttributeParameter &&
						((AttributeParameter) att.eContainer()).getSource() != null) {
					return ((AttributeParameter) att.eContainer()).getSource().eClass().getEAllAttributes();
				}
				return new ArrayList<>();
			}
		});
	}

	/**
	 * This returns ActualAttribute.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
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
		return super.getStyledText(object);
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

}
