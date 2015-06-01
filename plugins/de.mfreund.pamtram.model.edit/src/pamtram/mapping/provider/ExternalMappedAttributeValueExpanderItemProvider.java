/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.MappingPackage;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.ExternalMappedAttributeValueExpander} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalMappedAttributeValueExpanderItemProvider extends ExternalModifiedAttributeElementTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalMappedAttributeValueExpanderItemProvider(AdapterFactory adapterFactory) {
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

			addHintsToExpandPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hints To Expand feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHintsToExpandPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappedAttributeValueExpander_hintsToExpand_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappedAttributeValueExpander_hintsToExpand_feature", "_UI_MappedAttributeValueExpander_type"),
				 MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ExternalMappedAttributeValueExpander)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExternalMappedAttributeValueExpander_type") :
			getString("_UI_ExternalMappedAttributeValueExpander_type") + " " + label;
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


//	/* (non-Javadoc)
//	 * @see pamtram.mapping.provider.MappedAttributeValueExpanderItemProvider#addSourceAttributePropertyDescriptor(java.lang.Object)
//	 */
//	@Override
//	protected void addSourceAttributePropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//		(new ItemPropertyDescriptor
//			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//			 getResourceLocator(),
//			 getString("_UI_MappedAttributeValueExpander_sourceAttribute_feature"),
//			 getString("_UI_PropertyDescriptor_description", "_UI_MappedAttributeValueExpander_sourceAttribute_feature", "_UI_MappedAttributeValueExpander_type"),
//			 MappingPackage.Literals.ModifMAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE,
//			 true,
//			 false,
//			 true,
//			 null,
//			 null,
//			 null){
//
//				@Override
//				public Collection<?> getChoiceOfValues(Object object) {
//
//					//the parent Mapping Hint Group
//					MappingHintGroupImporter parent=(MappingHintGroupImporter) ((ExternalMappedAttributeValueExpander) object).eContainer();
//					// the parent mapping
//					Mapping mapping=(Mapping)parent.eContainer();
//
//					// the container section
//					SourceSectionClass container = mapping.getSourceMMSection().getContainer();
//
//					List<Object> choiceOfValues = new ArrayList<Object>();
//					
//					if(container != null){
//						//add atttributes of container and the metamodel section above
//						while(true){
//							choiceOfValues.addAll(container.getAttributes());
//							if(container.eContainer() instanceof SourceSectionContainmentReference){
//								container=(SourceSectionClass) container.eContainer().eContainer();
//							}else if(container.eContainer() instanceof SourceSectionModel && container.getContainer() != null){
//								container=container.getContainer();
//							} else {
//								break;
//							}
//						}
//					}					
//					return choiceOfValues;
//				}
//		});
//	}

}
