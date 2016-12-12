/**
 */
package pamtram.structure.provider;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.structure.EqualityMatcher;
import pamtram.structure.StructurePackage;
import pamtram.structure.ValueConstraintType;

/**
 * This is the item provider adapter for a {@link pamtram.structure.EqualityMatcher} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EqualityMatcherItemProvider
extends SingleReferenceValueConstraintItemProvider {
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

			addCaseSensitivePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Case Sensitive feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCaseSensitivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CaseSensitiveConstraint_caseSensitive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CaseSensitiveConstraint_caseSensitive_feature", "_UI_CaseSensitiveConstraint_type"),
				 StructurePackage.Literals.CASE_SENSITIVE_CONSTRAINT__CASE_SENSITIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns EqualityMatcher.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Object getImage(Object object) {
		ValueConstraintType constraintType = ((EqualityMatcher) object).getType();
		if(constraintType.equals(ValueConstraintType.INCLUSION)) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/EqualityMatcher_Inclusion"));			
		} else if(constraintType.equals(ValueConstraintType.EXCLUSION)) {
			return overlayImage(object, getResourceLocator().getImage("full/obj16/EqualityMatcher_Exclusion"));			
		} else {
			return null;
		}
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
		
		initializeLabelRelatedChildrenFeatureNotifications(object);

		String label = ((EqualityMatcher)object).getName();
		String value = ((EqualityMatcher)object).getExpression();

		StyledString styledLabel = new StyledString();

		if(value != null && !value.isEmpty()) {
			styledLabel.append(value, StyledString.Style.COUNTER_STYLER); 
		} else {
			
			List<String> sources = ((EqualityMatcher)object).getSourceElements().parallelStream().map(s -> s.getName()).collect(Collectors.toList());
			styledLabel.append(String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);
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

		switch (notification.getFeatureID(EqualityMatcher.class)) {
			case StructurePackage.EQUALITY_MATCHER__CASE_SENSITIVE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
