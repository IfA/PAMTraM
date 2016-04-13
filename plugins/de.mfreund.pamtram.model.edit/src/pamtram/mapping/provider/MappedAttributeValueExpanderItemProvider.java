/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import org.eclipse.emf.edit.provider.StyledString;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.commands.BasicDragAndDropAddCommand;

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

//	/**
//	 * This adds a property descriptor for the Source Attribute feature.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 */
//	@Override
//	protected void addSourceAttributePropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(new ItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_MappedAttributeValueExpander_sourceAttribute_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_MappedAttributeValueExpander_sourceAttribute_feature", "_UI_MappedAttributeValueExpander_type"),
//				 MappingPackage.Literals.MAPPED_ATTRIBUTE_VALUE_EXPANDER_TYPE__SOURCE_ATTRIBUTE,
//				 true,
//				 false,
//				 true,
//				 null,
//				 null,
//				 null){
//
//					@Override
//					public Collection<?> getChoiceOfValues(Object object) {
//
//						//the parent Mapping Hint Group
//						MappingHintGroupImporter parent=(MappingHintGroupImporter) ((MappedAttributeValueExpander) object).eContainer();
//
//						// the source section
//						SourceSectionClass source = ((Mapping)parent.eContainer()).getSourceMMSection();
//
//						List<Object> choiceOfValues = new ArrayList<Object>();
//						
//						// iterate over all elements and return the attributes as possible options
//						Set<SourceSectionClass> scanned=new HashSet<SourceSectionClass>();
//						List<SourceSectionClass> sectionsToScan=new ArrayList<SourceSectionClass>();
//						sectionsToScan.add(source);
//						
//						while(sectionsToScan.size() > 0){
//							SourceSectionClass classToScan=sectionsToScan.remove(0);
//							scanned.add(classToScan);
//							
//							Iterator<EObject> it = classToScan.eAllContents();
//							while(it.hasNext()) {
//								EObject next = it.next();
//								if(next instanceof pamtram.metamodel.Attribute) {
//									choiceOfValues.add(next);
//								} else if(next instanceof MetaModelSectionReference){
//									List<SourceSectionClass> vals=new ArrayList<SourceSectionClass>();
//									vals.addAll(((MetaModelSectionReference) next).getValue());
//									vals.removeAll(scanned);
//									sectionsToScan.addAll(vals);
//								}
//							}
//						}
//						
//						return choiceOfValues;
//					}
//			});
//	}

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
		String label = ((MappedAttributeValueExpander)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_MappedAttributeValueExpander_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_MappedAttributeValueExpander_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

}
