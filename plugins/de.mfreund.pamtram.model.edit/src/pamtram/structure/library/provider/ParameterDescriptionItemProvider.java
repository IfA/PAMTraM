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
package pamtram.structure.library.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationWrapper;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryPackage;

/**
 * This is the item provider adapter for the (virtual) ParameterDescription object. The concepts are copied from the EMF
 * book (Section 19.2.2).
 */
public class ParameterDescriptionItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This constructs an instance from a factory and a notifier.
	 */
	public ParameterDescriptionItemProvider(AdapterFactory adapterFactory, LibraryEntry libraryEntry) {
		/*
		 * As this item provider is not going to get created via the usual 'adapterFactory.adapt(...)' mechanism but
		 * instead via a direct call of the constructor, we need to explicitly add the item provider to the 'eAdapters'
		 * of the library entry.
		 */
		super(adapterFactory);
		libraryEntry.eAdapters().add(this);
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {

		if (this.childrenFeatures == null) {
			super.getChildrenFeatures(object);
			/*
			 * The 'parameters' feature of the 'LibraryEntry' shall be treated as if it belongs to this item provider.
			 */
			this.childrenFeatures.add(LibraryPackage.Literals.LIBRARY_ENTRY__PARAMETERS);
			this.childrenFeatures.add(LibraryPackage.Literals.LIBRARY_ENTRY__RESOURCE_PARAMETERS);
		}
		return this.childrenFeatures;
	}

	/**
	 * This returns the children of the real parent object, instead of the children of this virtual parent object.
	 */
	@Override
	public Collection<?> getChildren(Object object) {

		return super.getChildren(this.target);
	}

	/**
	 * This returns the child descriptors of the real parent object, instead of the children of this virtual parent
	 * object.
	 */
	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {

		return super.getNewChildDescriptors(this.target, editingDomain, sibling);
	}

	/**
	 * This returns the real parent object, instead of this virtual parent object.
	 */
	@Override
	public Object getParent(Object object) {

		return this.target;
	}

	/**
	 * This returns LibraryEntry.gif.
	 */
	@Override
	public Object getImage(Object object) {

		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/LibraryEntry"));
	}

	/**
	 * This returns the label text for the adapted class.
	 */
	@Override
	public String getText(Object object) {

		return "ParameterDescription";
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 */
	@Override
	public void notifyChanged(Notification notification) {

		this.updateChildren(notification);

		/*
		 * Handle only those notifications for which this object is the virtual parent.
		 */
		switch (notification.getFeatureID(LibraryEntry.class)) {
			case LibraryPackage.LIBRARY_ENTRY__PARAMETERS:
				this.fireNotifyChanged(new NotificationWrapper(this, notification));
				return;
		}
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 */
	@Override
	public ResourceLocator getResourceLocator() {

		return PamtramEditPlugin.INSTANCE;
	}

	/**
	 * We do not want to allow to manually add any children as these are created automatically.
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

	}

	/**
	 * Treat any command as if it was executed on the real parent and not on this virtual parent.
	 */
	@Override
	public Command createCommand(Object object, EditingDomain domain, Class<? extends Command> commandClass,
			CommandParameter commandParameter) {

		commandParameter.setOwner(this.target);
		return super.createCommand(this.target, domain, commandClass, commandParameter);
	}

}
