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

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionNonContainmentReference;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.MappedAttributeValueExpander} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappedAttributeValueExpanderItemProvider extends HintImporterMappingHintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedAttributeValueExpanderItemProvider(AdapterFactory adapterFactory) {
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

			addSourceAttributePropertyDescriptor(object);
			addTargetAttributePropertyDescriptor(object);
			addModifiersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addSourceAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappedAttributeValueExpander_sourceAttribute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappedAttributeValueExpander_sourceAttribute_feature", "_UI_MappedAttributeValueExpander_type"),
				 MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER__SOURCE_ATTRIBUTE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null){

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						//the parent Mapping Hint Group
						MappingHintGroupImporter parent=(MappingHintGroupImporter) ((MappedAttributeValueExpander) object).eContainer();

						// the source section
						SourceSectionClass source = ((Mapping)parent.eContainer()).getSourceMMSection();

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
	 * This adds a property descriptor for the Target Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addTargetAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappedAttributeValueExpander_targetAttribute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappedAttributeValueExpander_targetAttribute_feature", "_UI_MappedAttributeValueExpander_type"),
				 MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER__TARGET_ATTRIBUTE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null){

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						MappedAttributeValueExpander attrMapping=(MappedAttributeValueExpander) object;

						// the target sections
						ExportedMappingHintGroup expGroup=((MappingHintGroupImporter)attrMapping.eContainer()).getHintGroup();

						List<Object> choiceOfValues = new ArrayList<Object>();
						
						for(MappingHint hint : expGroup.getMappingHints()){
							if(hint instanceof AttributeMapping){
								choiceOfValues.add(((AttributeMapping) hint).getTarget());
							}
						}
						
						return choiceOfValues;
					}
				
			});
	}

	/**
	 * This adds a property descriptor for the Modifiers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModifiersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappedAttributeValueExpander_modifiers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappedAttributeValueExpander_modifiers_feature", "_UI_MappedAttributeValueExpander_type"),
				 MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER__MODIFIERS,
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
		String label = ((MappedAttributeValueExpander)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MappedAttributeValueExpander_type") :
			getString("_UI_MappedAttributeValueExpander_type") + " " + label;
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
