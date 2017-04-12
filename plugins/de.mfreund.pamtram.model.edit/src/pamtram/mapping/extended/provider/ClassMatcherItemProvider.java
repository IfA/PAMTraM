/**
 */
package pamtram.mapping.extended.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.ClassMatcher;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.impl.MappingPackageImpl;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.extended.ClassMatcher} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassMatcherItemProvider
extends MatcherItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMatcherItemProvider(AdapterFactory adapterFactory) {
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

			addTargetClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addTargetClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ClassMatcher_targetClass_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ClassMatcher_targetClass_feature", "_UI_ClassMatcher_type"),
						MappingPackage.Literals.CLASS_MATCHER__TARGET_CLASS,
						true,
						false,
						true,
						null,
						null,
						null){

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				return ((ReferenceTargetSelector) ((EObject) object).eContainer()).getAffectedReference().getValue();
			}


		});
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if(labelRelatedChildrenFeatures == null) {
			labelRelatedChildrenFeatures = new ArrayList<>();
			labelRelatedChildrenFeatures.add(MappingPackageImpl.eINSTANCE.getClassMatcher_TargetClass());
		}
		return labelRelatedChildrenFeatures;
	}

	/**
	 * This returns ClassMatcher.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ClassMatcher"));
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

		ClassMatcher am = ((ClassMatcher)object);
		StyledString styledLabel = new StyledString();

		String label = (am.getTargetClass() != null ? am.getTargetClass().getName() : "");

		styledLabel.append("TargetSectionClass ");


		styledLabel.append(" == " + label, StyledString.Style.COUNTER_STYLER);

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ClassMatcher.class)) {
			case MappingPackage.CLASS_MATCHER__TARGET_CLASS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	@Override
	public void notifyChanged(Notification notification) {
		handleLabelRelatedChildrenFeatureChangeNotification(notification);
		notifyChangedGen(notification);
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
