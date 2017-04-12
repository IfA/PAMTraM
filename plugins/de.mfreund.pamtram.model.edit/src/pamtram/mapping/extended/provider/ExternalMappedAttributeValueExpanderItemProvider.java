/**
 */
package pamtram.mapping.extended.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import org.eclipse.emf.edit.provider.StyledString;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ExternalMappedAttributeValueExpander;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.provider.ExternalDynamicSourceElementItemProvider;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.extended.ExternalMappedAttributeValueExpander} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalMappedAttributeValueExpanderItemProvider extends ExternalDynamicSourceElementItemProvider {
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
				 ExtendedPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER__HINTS_TO_EXPAND,
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
		String label = ((ExternalMappedAttributeValueExpander)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_ExternalMappedAttributeValueExpander_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_ExternalMappedAttributeValueExpander_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
		}
		return styledLabel;
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
