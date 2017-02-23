/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.PamtramFactory;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorSourceInterface;
import pamtram.mapping.ContainerSelectorTargetAttribute;
import pamtram.mapping.impl.MappingPackageImpl;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.ContainerSelector} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainerSelectorItemProvider
extends MappingHintBaseTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerSelectorItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(MappingPackage.Literals.CONTAINER_SELECTOR__TARGET_ATTRIBUTES);
			childrenFeatures.add(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS);
		}
		return childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if(labelRelatedChildrenFeatures == null) {
			labelRelatedChildrenFeatures = new ArrayList<>();
			labelRelatedChildrenFeatures.add(MappingPackageImpl.eINSTANCE.getContainerSelector_SourceElements());
			labelRelatedChildrenFeatures.add(MappingPackageImpl.eINSTANCE.getContainerSelector_TargetAttributes());
		}
		return labelRelatedChildrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ContainerSelector.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ContainerSelector"));
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

		ContainerSelector mch = ((ContainerSelector)object);
		StyledString styledLabel = new StyledString();

		ArrayList<String> targets = new ArrayList<>();
		for (ContainerSelectorTargetAttribute target : mch.getTargetAttributes()) {
			targets.add(target.getName());
		} 
		styledLabel.append(String.join(", ", targets), StyledString.Style.COUNTER_STYLER);

		ArrayList<String> sources = new ArrayList<>();
		for (ContainerSelectorSourceInterface source : mch.getSourceElements()) {
			sources.add(source.getName());
		} 
		styledLabel.append(" == " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);

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

		switch (notification.getFeatureID(ContainerSelector.class)) {
			case MappingPackage.CONTAINER_SELECTOR__TARGET_ATTRIBUTES:
			case MappingPackage.CONTAINER_SELECTOR__SOURCE_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.CONTAINER_SELECTOR__TARGET_ATTRIBUTES,
				 MappingFactory.eINSTANCE.createContainerSelectorTargetAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createContainerSelectorSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createContainerSelectorExternalSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createContainerSelectorGlobalSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createGlobalAttributeImporter()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.CONTAINER_SELECTOR__SOURCE_ELEMENTS,
				 PamtramFactory.eINSTANCE.createFixedValue()));
	}

}
