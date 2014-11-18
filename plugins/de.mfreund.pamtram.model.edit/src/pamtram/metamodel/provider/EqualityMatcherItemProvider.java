/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.EqualityMatcher;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.EqualityMatcher} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EqualityMatcherItemProvider
	extends CaseSensitiveConstraintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityMatcherItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns EqualityMatcher.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Object getImage(Object object) {
		AttributeValueConstraintType constraintType = ((EqualityMatcher) object).getType();
		if(constraintType.equals(AttributeValueConstraintType.INCLUSION)) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/EqualityMatcher_Inclusion"));			
		} else if(constraintType.equals(AttributeValueConstraintType.EXCLUSION)) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/EqualityMatcher_Exclusion"));			
		} else {
			return null;
		}
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getText(Object object) {
		String label = ((EqualityMatcher)object).getName();
		String value = ((EqualityMatcher)object).getValue();
		return label == null || label.length() == 0 ?
			(value == null ? "" : value) :
			getString("_UI_EqualityMatcher_type") + " " + label;
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
