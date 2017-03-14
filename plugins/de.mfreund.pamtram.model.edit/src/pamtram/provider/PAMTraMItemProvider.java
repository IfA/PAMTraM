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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
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
import pamtram.commands.CreateSharedModelCommand;
import pamtram.util.PamtramItemProviderAdapter;

/**
 * This is the item provider adapter for a {@link pamtram.PAMTraM} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class PAMTraMItemProvider extends PamtramItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemStyledLabelProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PAMTraMItemProvider(AdapterFactory adapterFactory) {
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

			addSharedSourceSectionModelsPropertyDescriptor(object);
			addSharedTargetSectionModelsPropertyDescriptor(object);
			addSharedMappingModelsPropertyDescriptor(object);
			addSharedConditionModelsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Shared Source Section Models feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSharedSourceSectionModelsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PAMTraM_sharedSourceSectionModels_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PAMTraM_sharedSourceSectionModels_feature", "_UI_PAMTraM_type"),
				 PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Shared Target Section Models feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSharedTargetSectionModelsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PAMTraM_sharedTargetSectionModels_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PAMTraM_sharedTargetSectionModels_feature", "_UI_PAMTraM_type"),
				 PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Shared Mapping Models feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void addSharedMappingModelsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PAMTraM_sharedMappingModels_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PAMTraM_sharedMappingModels_feature", "_UI_PAMTraM_type"),
				 PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Shared Condition Models feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addSharedConditionModelsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PAMTraM_sharedConditionModels_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PAMTraM_sharedConditionModels_feature", "_UI_PAMTraM_type"),
				 PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODELS);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODELS);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODELS);
			childrenFeatures.add(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODELS);
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
	 * This returns PAMTraM.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PAMTraM"));
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
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		return new StyledString(getString("_UI_PAMTraM_type"));
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

		switch (notification.getFeatureID(PAMTraM.class)) {
			case PamtramPackage.PAM_TRA_M__SOURCE_SECTION_MODELS:
			case PamtramPackage.PAM_TRA_M__TARGET_SECTION_MODELS:
			case PamtramPackage.PAM_TRA_M__MAPPING_MODELS:
			case PamtramPackage.PAM_TRA_M__CONDITION_MODELS:
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
				(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODELS,
				 PamtramFactory.eINSTANCE.createSourceSectionModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODELS,
				 PamtramFactory.eINSTANCE.createTargetSectionModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODELS,
				 PamtramFactory.eINSTANCE.createMappingModel()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODELS,
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

	@Override
	protected Command createCreateChildCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Object value, int index, Collection<?> collection) {

		// If a shared model shall be created, use the custom CreateSharedModelCommand that will persist
		// the the shared model in a new resource
		//
		if (feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_SOURCE_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_TARGET_SECTION_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_MAPPING_MODELS)
				|| feature.equals(PamtramPackage.Literals.PAM_TRA_M__SHARED_CONDITION_MODELS)) {
			return CreateSharedModelCommand.createCreateSharedModelCommand(domain, (PAMTraM) owner, (EObject) value,
					collection, this);
		}
		return super.createCreateChildCommand(domain, owner, feature, value, index, collection);
	}

}
