/**
 */
package pamtram.structure.constraint.provider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.ValueConstraintType;

/**
 * This is the item provider adapter for a {@link pamtram.structure.constraint.EqualityConstraint} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EqualityConstraintItemProvider extends SingleReferenceValueConstraintItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityConstraintItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns EqualityConstraint.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	public Object getImage(Object object) {

		ValueConstraintType constraintType = ((EqualityConstraint) object).getType();
		if (constraintType.equals(ValueConstraintType.REQUIRED)) {
			return this.overlayImage(object,
					this.getResourceLocator().getImage("full/obj16/EqualityConstraint_Inclusion"));
		} else if (constraintType.equals(ValueConstraintType.FORBIDDEN)) {
			return this.overlayImage(object,
					this.getResourceLocator().getImage("full/obj16/EqualityConstraint_Exclusion"));
		} else {
			return null;
		}
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

		this.initializeLabelRelatedChildrenFeatureNotifications(object);

		String label = ((EqualityConstraint) object).getName();
		String value = ((EqualityConstraint) object).getExpression();

		StyledString styledLabel = new StyledString();

		if (value != null && !value.isEmpty()) {
			styledLabel.append(value, StyledString.Style.COUNTER_STYLER);
		} else {

			List<String> sources = ((EqualityConstraint) object).getSourceElements().parallelStream()
					.map(s -> s.getName()).collect(Collectors.toList());
			styledLabel.append(String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);
		}

		return styledLabel;
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
	}

}
