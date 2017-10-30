/**
 */
package dfd.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import dfd.DfdFactory;
import dfd.DfdPackage;

/**
 * This is the item provider adapter for a {@link dfd.Process} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ProcessItemProvider extends DFDElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessItemProvider(AdapterFactory adapterFactory) {
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

			addNumberPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Number feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Process_number_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Process_number_feature", "_UI_Process_type"),
				 DfdPackage.Literals.PROCESS__NUMBER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DfdPackage.Literals.DFD__ELEMENTS);
			childrenFeatures.add(DfdPackage.Literals.DFD__FLOWS);
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
	 * This returns Process.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Process"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT due to inclusion of the process number into the label
	 */
	@Override
	public String getText(Object object) {

		String label = ((dfd.Process) object).getName();
		if (label == null) {
			label = "";
		}
		String number = ((dfd.Process) object).getNumber();
		if (number != null && !number.isEmpty()) {
			label = number + " : " + label;
		}
		return label.length() == 0 ? this.getString("_UI_Process_type")
				: this.getString("_UI_Process_type") + " " + label;
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

		switch (notification.getFeatureID(dfd.Process.class)) {
			case DfdPackage.PROCESS__NUMBER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DfdPackage.PROCESS__ELEMENTS:
			case DfdPackage.PROCESS__FLOWS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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

		newChildDescriptors.add
			(createChildParameter
				(DfdPackage.Literals.DFD__ELEMENTS,
				 DfdFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add
			(createChildParameter
				(DfdPackage.Literals.DFD__ELEMENTS,
				 DfdFactory.eINSTANCE.createDataStore()));

		newChildDescriptors.add
			(createChildParameter
				(DfdPackage.Literals.DFD__FLOWS,
				 DfdFactory.eINSTANCE.createControlFlow()));

		newChildDescriptors.add
			(createChildParameter
				(DfdPackage.Literals.DFD__FLOWS,
				 DfdFactory.eINSTANCE.createDataFlow()));
	}

}
