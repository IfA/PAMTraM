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
package pamtram.structure.target.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.commands.ReplacingDragAndDropAddCommand;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.ReferenceImpl;
import pamtram.structure.generic.provider.CompositeReferenceItemProvider;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.structure.TargetSectionContainmentReference} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class TargetSectionCompositeReferenceItemProvider extends CompositeReferenceItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionCompositeReferenceItemProvider(AdapterFactory adapterFactory) {
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

			addEReferencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the EReference feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEReferencePropertyDescriptor(Object object) {
		
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Reference_eReference_feature"),
						this.getString("_UI_ActualReference_eReference_description"),
						GenericPackage.Literals.ACTUAL_REFERENCE__EREFERENCE, true, false, true, null,
						this.getString("_UI_BasicPropertyCategory"), null) {
		
					@Override
					public Collection<?> getChoiceOfValues(Object object) {
		
						// make sure that only those references can be selected
						// that belong to the parent eClass
						pamtram.structure.generic.Class<?, ?, ?, ?> parent = ((ReferenceImpl<?, ?, ?, ?>) object)
								.getOwningClass();
		
						// do not filter the choices further so that containment
						// as well as non-containment references are displayed
						return pamtram.util.XSDAnyContentUtil
								.getEAllReferencesIncludingVirtualAnyContentReference(parent.getEClass()).stream()
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

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		/*
		 * Allow to drop Classes onto this CompositeReference.
		 */

		if (collection.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		HashMap<EObject, EObject> targetSectionClassMap = new HashMap<>();

		for (Object object : collection) {

			if (object instanceof TargetSectionClass) {
				if (object instanceof TargetSection) {
					targetSectionClassMap.put((TargetSectionClass) object,
							TargetFactory.eINSTANCE.createTargetSectionClass());
				} else {
					targetSectionClassMap.put((TargetSectionClass) object, (TargetSectionClass) object);
				}
			} else {
				return UnexecutableCommand.INSTANCE;
			}
		}

		return new ReplacingDragAndDropAddCommand(domain, (EObject) owner,
				GenericPackage.Literals.COMPOSITE_REFERENCE__VALUE,
				(Collection<EObject>) targetSectionClassMap.keySet(), targetSectionClassMap.values());

	}
}
