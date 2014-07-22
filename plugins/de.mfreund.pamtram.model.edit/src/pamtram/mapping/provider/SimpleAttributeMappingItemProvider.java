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
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionNonContainmentReference;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.SimpleAttributeMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleAttributeMappingItemProvider
	extends AttributeMappingItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleAttributeMappingItemProvider(AdapterFactory adapterFactory) {
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

			addSourcePropertyDescriptor(object);
			addModifierPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		// copied from 'AttributeMappingSourceElementTypeItemProvider'
		// (not automatically performed due to multiple inheritance
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
				MappingHintGroup mappingHintGroup;
				while(true){
					if(parent instanceof MappingHintGroup){
						mappingHintGroup=(MappingHintGroup) parent;
						break;
					} else {
						parent=parent.eContainer();
					}
				}
				// the parent mapping
				Mapping mapping = (Mapping) mappingHintGroup.eContainer();
				
				// the source section
				SourceSectionClass source = mapping.getSourceMMSection();

				List<Object> choiceOfValues = new ArrayList<Object>();
				
				// iterate over all elements and return the attributes as possible options
				Set<SourceSectionClass> scanned=new HashSet<SourceSectionClass>();
				List<SourceSectionClass> sectionsToScan=new ArrayList<SourceSectionClass>();
				sectionsToScan.add(source);
				
				while(sectionsToScan.size() > 0){
					SourceSectionClass classToScan=sectionsToScan.remove(0);
					scanned.add(classToScan);
					
					Iterator<EObject> it = classToScan.eAllContents();
					while(it.hasNext()) {
						EObject next = it.next();
						if(next instanceof pamtram.metamodel.Attribute) {
							choiceOfValues.add(next);
						} else if(next instanceof SourceSectionNonContainmentReference){
							List<SourceSectionClass> vals=new ArrayList<SourceSectionClass>();
							vals.addAll(((SourceSectionNonContainmentReference) next).getValue());
							vals.removeAll(scanned);
							sectionsToScan.addAll(vals);
						}
					}
				}
				
				return choiceOfValues;
			}
		   });
	}

	/**
	 * This adds a property descriptor for the Modifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributeMappingSourceElementType_modifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributeMappingSourceElementType_modifier_feature", "_UI_AttributeMappingSourceElementType_type"),
				 MappingPackage.Literals.ATTRIBUTE_MAPPING_SOURCE_ELEMENT_TYPE__MODIFIER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns SimpleAttributeMapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SimpleAttributeMapping"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getText(Object object) {
		String label = ((SimpleAttributeMapping)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AttributeMapping_type") :
			getString("_UI_AttributeMapping_type") + " " + label;
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

}
