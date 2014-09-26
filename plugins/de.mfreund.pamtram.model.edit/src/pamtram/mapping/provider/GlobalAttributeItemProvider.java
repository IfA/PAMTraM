/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.commands.BasicDragAndDropAddCommand;
import pamtram.mapping.commands.BasicDragAndDropSetCommand;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;
import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.GlobalAttribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalAttributeItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalAttributeItemProvider(AdapterFactory adapterFactory) {
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
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GlobalVariable_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GlobalVariable_source_feature", "_UI_GlobalVariable_type"),
				 MappingPackage.Literals.GLOBAL_ATTRIBUTE__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null){

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						
						List<SourceSectionAttribute> sources = new LinkedList<SourceSectionAttribute>();
						
						Mapping mapping= (Mapping) ((EObject) object).eContainer();
						
						if(mapping.getSourceMMSection() == null){
							return super.getChoiceOfValues(object);
						} else {
							List<SourceSectionClass> classes=new LinkedList<SourceSectionClass>();
							Set<SourceSectionClass> classesScanned=new HashSet<SourceSectionClass>();

							classes.add(mapping.getSourceMMSection());
							
							while(classes.size() > 0){
								SourceSectionClass c=classes.remove(0);
								//add attributes
								if(c.getAttributes() != null){
									sources.addAll(c.getAttributes());
								}
								
								//search children
								for(SourceSectionReference ref : c.getReferences()){
									for(SourceSectionClass rClass : ref.getValuesGeneric()){
										if(!classesScanned.contains(rClass)){
											classes.add(rClass);	
										}
									}
								}
							}
							
							
							return sources;
						}
						
						
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
				 getString("_UI_GlobalAttribute_modifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GlobalAttribute_modifier_feature", "_UI_GlobalAttribute_type"),
				 MappingPackage.Literals.GLOBAL_ATTRIBUTE__MODIFIER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns GlobalAttribute.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/GlobalAttribute"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((GlobalAttribute)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_GlobalAttribute_type") :
			getString("_UI_GlobalAttribute_type") + " " + label;
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

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain,
			Object owner, float location, int operations, int operation,
			Collection<?> collection) {
		
		if(collection.size() == 1) {
			Object value = collection.iterator().next();
			if(value instanceof SourceSectionAttribute) {
		
				return new BasicDragAndDropSetCommand(domain, (EObject) owner, 
						MappingPackage.Literals.GLOBAL_ATTRIBUTE__SOURCE, value, 0);
			}
		}
		
		EList<AttributeValueModifierSet> values = new BasicEList<AttributeValueModifierSet>();
		for(Iterator<?> iter = collection.iterator(); iter.hasNext(); ) {
			Object value = iter.next();
			if(value instanceof AttributeValueModifierSet) {
				values.add((AttributeValueModifierSet) value);
			} else {
				return super.createDragAndDropCommand(domain, owner, location, operations,
						operation, collection); 
			}
		}
		
		if(values.isEmpty()) {
			return super.createDragAndDropCommand(domain, owner, location, operations,
					operation, collection); 
		} else {
			return new BasicDragAndDropAddCommand(domain, (EObject) owner, 
					MappingPackage.Literals.GLOBAL_ATTRIBUTE__MODIFIER, values);
		}
	}
}
