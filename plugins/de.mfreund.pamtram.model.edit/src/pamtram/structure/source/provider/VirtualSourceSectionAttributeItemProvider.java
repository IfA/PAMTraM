/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.source.provider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.StyledString.Fragment;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.VirtualSourceSectionAttribute;

/**
 * This is the item provider adapter for a
 * {@link pamtram.structure.source.VirtualSourceSectionAttribute} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class VirtualSourceSectionAttributeItemProvider extends SourceSectionAttributeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public VirtualSourceSectionAttributeItemProvider(AdapterFactory adapterFactory) {
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

			addDerivationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_VirtualSourceSectionAttribute_derivation_feature"),
				 getString("_UI_VirtualSourceSectionAttribute_derivation_description"),
				 SourcePackage.Literals.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION,
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
		VirtualSourceSectionAttribute attribute = (VirtualSourceSectionAttribute) object;

		StyledString styledLabel = new StyledString();

		if (attribute.getName() == null || attribute.getName().isEmpty()) {
			styledLabel.append((StyledString) super.getStyledText(object));
		} else {
			Iterator<Fragment> it = ((StyledString) super.getStyledText(object)).iterator();
			while (it.hasNext()) {
				Fragment next = it.next();
				if (next.getString().equals(attribute.getName())) {
					// use the 'qualifier styler' for the label
					styledLabel.append(next.getString(), StyledString.Style.QUALIFIER_STYLER);
				} else {
					// every other fragment is added as is
					styledLabel.append(next.getString(), next.getStyle());
				}
			}
		}

		return styledLabel;
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

		switch (notification.getFeatureID(VirtualSourceSectionAttribute.class)) {
			case SourcePackage.VIRTUAL_SOURCE_SECTION_ATTRIBUTE__DERIVATION:
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

}
