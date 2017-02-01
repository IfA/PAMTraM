/**
 */
package pamtram.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.PAMTraM;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.commands.CreateSharedSectionModelCommand;
import pamtram.util.PamtramItemProviderAdapter;

/**
 * This is the item provider adapter for a {@link pamtram.PAMTraM} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PAMTraMItemProvider
extends PamtramItemProviderAdapter
implements
IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemStyledLabelProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PAMTraMItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODEL);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODEL);
		}
		return childrenFeatures;
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
	 * This returns PAMTraM.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PAMTraM"));
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
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		return new StyledString(getString("_UI_PAMTraM_type"));
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

		switch (notification.getFeatureID(PAMTraM.class)) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODEL:
			case PamtramPackage.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL:
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODEL:
			case PamtramPackage.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL:
			case PamtramPackage.PAM_TRA_M__MAPPING_MODEL:
			case PamtramPackage.PAM_TRA_M__SHARED_MAPPING_MODEL:
			case PamtramPackage.PAM_TRA_M__CONDITION_MODEL:
			case PamtramPackage.PAM_TRA_M__SHARED_CONDITION_MODEL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL,
				 PamtramFactory.eINSTANCE.createSourceSectionModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL,
				 PamtramFactory.eINSTANCE.createSourceSectionModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL,
				 PamtramFactory.eINSTANCE.createTargetSectionModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL,
				 PamtramFactory.eINSTANCE.createTargetSectionModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL,
				 PamtramFactory.eINSTANCE.createMappingModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODEL,
				 PamtramFactory.eINSTANCE.createMappingModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL,
				 PamtramFactory.eINSTANCE.createConditionModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODEL,
				 PamtramFactory.eINSTANCE.createConditionModel()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

	@Override
	protected Command createCreateChildCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, int index, Collection<?> collection) {

		// If a shared SectionModel shall be created, use the custom CreateSharedSectionModelCommand that will persist
		// the the SectionModel in a new resource
		//
		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODEL)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODEL)) {
			return new CreateSharedSectionModelCommand(domain, (PAMTraM) owner, (SectionModel<?, ?, ?, ?>) value,
					collection, this);
		}
		return super.createCreateChildCommand(domain, owner, feature, value, index, collection);
	}

}
