/**
 */
package dfd.provider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import dfd.DfdPackage;

/**
 * This is the item provider adapter for a {@link dfd.Flow} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class FlowItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FlowItemProvider(AdapterFactory adapterFactory) {
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

			addIncomingPropertyDescriptor(object);
			addOutgoingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Incoming feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT due to customization of 'getChoiceOfValues'
	 */
	protected void addIncomingPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Flow_incoming_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_Flow_incoming_feature",
								"_UI_Flow_type"),
						DfdPackage.Literals.FLOW__INCOMING, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						return super.getChoiceOfValues(object).stream()
								.filter(e -> ((org.eclipse.emf.ecore.EObject) e).eContainer()
										.equals(((org.eclipse.emf.ecore.EObject) object).eContainer()))
								.collect(Collectors.toList());
					}
				});
	}

	/**
	 * This adds a property descriptor for the Outgoing feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT due to customization of 'getChoiceOfValues'
	 */
	protected void addOutgoingPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Flow_outgoing_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_Flow_outgoing_feature",
								"_UI_Flow_type"),
						DfdPackage.Literals.FLOW__OUTGOING, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						return super.getChoiceOfValues(object).stream()
								.filter(e -> ((org.eclipse.emf.ecore.EObject) e).eContainer()
										.equals(((org.eclipse.emf.ecore.EObject) object).eContainer()))
								.collect(Collectors.toList());
					}
				});
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Flow_type");
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DataFlowDiagramEditPlugin.INSTANCE;
	}

}
