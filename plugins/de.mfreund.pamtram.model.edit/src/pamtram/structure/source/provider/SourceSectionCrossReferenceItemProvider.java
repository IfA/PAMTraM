/**
 */
package pamtram.structure.source.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.ReferenceImpl;
import pamtram.structure.generic.provider.CrossReferenceItemProvider;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSectionCrossReference;

/**
 * This is the item provider adapter for a {@link pamtram.structure.source.SourceSectionCrossReference} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class SourceSectionCrossReferenceItemProvider extends CrossReferenceItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionCrossReferenceItemProvider(AdapterFactory adapterFactory) {
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

			addIgnoreUnmatchedElementsPropertyDescriptor(object);
			addEReferencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ignore Unmatched Elements feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addIgnoreUnmatchedElementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SourceSectionReference_ignoreUnmatchedElements_feature"),
				 getString("_UI_SourceSectionReference_ignoreUnmatchedElements_description"),
				 SourcePackage.Literals.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ExtendedPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the EReference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addEReferencePropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Reference_eReference_feature"),
						this.getString("_UI_ActualReference_eReference_description"),
						GenericPackage.Literals.ACTUAL_REFERENCE__EREFERENCE, true, false, true, null,
						this.getString("_UI_BasicPropertyCategory"), null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						// make sure that only those references can be selected
						// that belong to the parent eClass
						Class<?, ?, ?, ?> parent = (Class<?, ?, ?, ?>) ((ReferenceImpl<?, ?, ?, ?>) object)
								.eContainer();

						// do not filter the choices further so that containment
						// as well as non-containment references are displayed
						return parent.getEClass() != null
								? parent.getEClass().getEAllReferences().stream().collect(Collectors.toList())
								: new ArrayList<>();

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
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		return super.getStyledText(object);
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

		switch (notification.getFeatureID(SourceSectionCrossReference.class)) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

}
