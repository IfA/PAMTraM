/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import pamtram.SourceSectionModel;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.ExternalModifiedAttributeElementType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalModifiedAttributeElementTypeItemProvider extends ModifiedAttributeElementTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalModifiedAttributeElementTypeItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ExternalModifiedAttributeElementType<?, ?, ?, ?>)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExternalModifiedAttributeElementType_type") :
			getString("_UI_ExternalModifiedAttributeElementType_type") + " " + label;
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

	@Override
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ModifiedAttributeElementType_source_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ModifiedAttributeElementType_source_feature", "_UI_ModifiedAttributeElementType_type"),
						MappingPackage.Literals.MODIFIED_ATTRIBUTE_ELEMENT_TYPE__SOURCE,
						true,
						false,
						true,
						null,
						null,
						null){

			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				//the parent Mapping Hint Group
				EObject parent= ((EObject) object).eContainer();
				// the parent mapping
				Mapping mapping;
				while(true){
					if(parent instanceof MappingHintGroupType){
						mapping=(Mapping)((MappingHintGroupType) parent).eContainer();
						break;
					} else if(parent instanceof MappingHintGroupImporter){
						mapping=(Mapping)((MappingHintGroupImporter) parent).eContainer();
						break;
					}else {
						parent=parent.eContainer();
					}
				}
				// the container section
				SourceSectionClass container = mapping.getSourceMMSection().getContainer();

				List<Object> choiceOfValues = new ArrayList<>();

				if(container != null){
					//add attributes of container and the metamodel section above
					while(true){
						choiceOfValues.addAll(container.getAttributes());
						if(container.eContainer() instanceof SourceSectionContainmentReference){
							container=(SourceSectionClass) container.eContainer().eContainer();
						}else if(container.eContainer() instanceof SourceSectionModel && container.getContainer() != null){
							container=container.getContainer();
						} else {
							break;
						}
					}
				}					
				return choiceOfValues;
			}
		});
	}

}
