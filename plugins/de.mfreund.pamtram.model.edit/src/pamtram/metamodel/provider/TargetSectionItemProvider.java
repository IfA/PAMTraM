/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSection;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.TargetSection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetSectionItemProvider extends TargetSectionClassItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionItemProvider(AdapterFactory adapterFactory) {
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

			addAbstractPropertyDescriptor(object);
			addExtendPropertyDescriptor(object);
			addReferencingMappingHintGroupsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Section_abstract_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Section_abstract_feature", "_UI_Section_type"),
						MetamodelPackage.Literals.SECTION__ABSTRACT,
						true,
						false,
						false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
						null,
						null));
	}

	/**
	 * This adds a property descriptor for the Extend feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addExtendPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Section_extend_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Section_extend_feature", "_UI_Section_type"),
						MetamodelPackage.Literals.SECTION__EXTEND,
						true,
						false,
						true,
						null,
						null,
						null) 
		{

			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				TargetSection targetSection = (TargetSection) object;

				if(targetSection.getEClass() == null) {
					return new BasicEList<>();
				}

				Collection<TargetSection> values = (Collection<TargetSection>) super.getChoiceOfValues(object);
				Collection<TargetSection> ret = new BasicEList<>();

				for (TargetSection val : values) {
					// only abstract sections that have a matching eClass can be used as extended section
					if(val.isAbstract() && (val.eClass() == targetSection.eClass() || val.getEClass().getESuperTypes().contains(targetSection.getEClass()))) {
						ret.add(val);
					}
				}

				return ret;
			}
		}
				);
	}

	/**
	 * This adds a property descriptor for the Referencing Mapping Hint Groups feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencingMappingHintGroupsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_TargetSection_referencingMappingHintGroups_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_TargetSection_referencingMappingHintGroups_feature", "_UI_TargetSection_type"),
						MetamodelPackage.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS,
						false,
						false,
						false,
						null,
						null,
						null));
	}

	/**
	 * This returns TargetSection.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return (((TargetSection) object).isAbstract() ? "<<abstract>> " : "") + super.getText(object);
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

		switch (notification.getFeatureID(TargetSection.class)) {
		case MetamodelPackage.TARGET_SECTION__ABSTRACT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
