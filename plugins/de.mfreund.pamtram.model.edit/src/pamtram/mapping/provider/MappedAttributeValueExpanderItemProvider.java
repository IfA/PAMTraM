/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.SourceSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.MappedAttributeValueExpander} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappedAttributeValueExpanderItemProvider extends MappedAttributeValueExpanderTypeItemProvider {
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

			addHintsToExpandPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hints To Expand feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addHintsToExpandPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
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
				 null){

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						//the parent Mapping Hint Group
						MappingHintGroupImporter parent=(MappingHintGroupImporter) ((MappedAttributeValueExpander) object).eContainer();
						
						List<ExpandableHint> choices=new LinkedList<ExpandableHint>();
						
						if(parent.getHintGroup() != null){
							for(MappingHint h : parent.getHintGroup().getMappingHints()){
								if(h instanceof AttributeMapping){
									choices.add((AttributeMapping) h);
								} else if(h instanceof MappingInstanceSelector){
									if(((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher){
										choices.add((ExpandableHint) ((MappingInstanceSelector) h).getMatcher());
									}
								}
							}
						}
	
						return choices;
					}
				
			});
	}

	/**
	 * This adds a property descriptor for the Source Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected void addSourceAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappedAttributeValueExpander_sourceAttribute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappedAttributeValueExpander_sourceAttribute_feature", "_UI_MappedAttributeValueExpander_type"),
				 MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE,
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
								} else if(next instanceof MetaModelSectionReference){
									List<SourceSectionClass> vals=new ArrayList<SourceSectionClass>();
									vals.addAll(((MetaModelSectionReference) next).getValue());
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
