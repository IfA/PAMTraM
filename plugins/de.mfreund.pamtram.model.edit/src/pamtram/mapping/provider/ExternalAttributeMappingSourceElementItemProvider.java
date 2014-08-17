/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.ExternalAttributeMappingSourceElement;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionNonContainmentReference;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.ExternalAttributeMappingSourceElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExternalAttributeMappingSourceElementItemProvider extends AttributeMappingSourceElementWithModifiersItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalAttributeMappingSourceElementItemProvider(AdapterFactory adapterFactory) {
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
		String label = ((ExternalAttributeMappingSourceElement)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ExternalAttributeMappingSourceElement_type") :
			getString("_UI_ExternalAttributeMappingSourceElement_type") + " " + label;
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
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributeMappingSourceElementType_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributeMappingSourceElementType_source_feature", "_UI_AttributeMappingSourceElementType_type"),
				 MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			   {
				@Override
				public Collection<?> getChoiceOfValues(Object object) {

					//the parent Mapping Hint Group
					EObject parent=((AttributeMappingSourceElementType) object).eContainer();
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

					List<Object> choiceOfValues = new ArrayList<Object>();
					
					if(container != null){
						//add atttributes of container and the metamodel section above
						while(true){
							choiceOfValues.addAll(container.getAttributes());
							if(container.eContainer() instanceof SourceSectionClass){
								container=(SourceSectionClass) container.eContainer();
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
