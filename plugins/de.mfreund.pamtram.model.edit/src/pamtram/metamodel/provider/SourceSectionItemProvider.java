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
import pamtram.metamodel.SourceSection;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.SourceSection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceSectionItemProvider extends SourceSectionClassItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionItemProvider(AdapterFactory adapterFactory) {
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
			addReferencingMappingsPropertyDescriptor(object);
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
						null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				SourceSection sourceSection = (SourceSection) object;

				if(sourceSection.getEClass() == null) {
					return new BasicEList<>();
				}

				Collection<SourceSection> values = (Collection<SourceSection>) super.getChoiceOfValues(object);
				Collection<SourceSection> ret = new BasicEList<>();

				for (SourceSection val : values) {
					// only abstract sections that have a matching eClass can be used as extended section
					if(val.isAbstract() && (val.eClass() == sourceSection.eClass() || val.getEClass().getESuperTypes().contains(sourceSection.getEClass()))) {
						ret.add(val);
					}
				}

				return ret;
			}
		});
	}

	/**
	 * This adds a property descriptor for the Referencing Mappings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencingMappingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SourceSection_referencingMappings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SourceSection_referencingMappings_feature", "_UI_SourceSection_type"),
				 MetamodelPackage.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns SourceSection.gif.
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
		return (((SourceSection) object).isAbstract() ? "<<abstract>> " : "") + super.getText(object);
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

		switch (notification.getFeatureID(SourceSection.class)) {
			case MetamodelPackage.SOURCE_SECTION__ABSTRACT:
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
