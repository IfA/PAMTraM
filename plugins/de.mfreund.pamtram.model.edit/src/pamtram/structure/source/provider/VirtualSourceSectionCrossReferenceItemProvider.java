/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.source.provider;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.generic.provider.CrossReferenceItemProvider;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.VirtualSourceSectionCrossReference;

/**
 * This is the item provider adapter for a {@link pamtram.structure.source.VirtualSourceSectionCrossReference} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class VirtualSourceSectionCrossReferenceItemProvider extends CrossReferenceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public VirtualSourceSectionCrossReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIgnoreUnmatchedElementsPropertyDescriptor(object);
			addDerivationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ignore Unmatched Elements feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * This adds a property descriptor for the Derivation feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addDerivationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_VirtualSourceSectionCrossReference_derivation_feature"),
				 getString("_UI_VirtualSourceSectionCrossReference_derivation_description"),
				 SourcePackage.Literals.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION,
				 true,
				 true,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 *
	 */
	@Override
	public Object getImage(Object object) {

		Object baseImage = super.getImage(object);
		Object virtualImage = this.getResourceLocator().getImage("Virtual");

		return new DecoratedComposedImage(Arrays.asList(baseImage, virtualImage), 0, 0);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {
		return super.getStyledText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(VirtualSourceSectionCrossReference.class)) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
			case SourcePackage.VIRTUAL_SOURCE_SECTION_CROSS_REFERENCE__DERIVATION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

}
