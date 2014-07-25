/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.TargetSectionClass;
import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.MappingHintGroupImporter} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingHintGroupImporterItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingHintGroupImporterItemProvider(AdapterFactory adapterFactory) {
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

			addHintGroupPropertyDescriptor(object);
			addContainerPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Hint Group feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHintGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappingHintGroupImporter_hintGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappingHintGroupImporter_hintGroup_feature", "_UI_MappingHintGroupImporter_type"),
				 MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappingHintGroupImporter_container_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MappingHintGroupImporter_container_feature", "_UI_MappingHintGroupImporter_type"),
				 MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__CONTAINER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null){

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						List<TargetSectionClass> choiceOfValues=new LinkedList<TargetSectionClass>();
						
						Mapping mapping= (Mapping) ((EObject)object).eContainer();
						
						for(MappingHintGroupType g : mapping.getMappingHintGroups()){
							if(g.getTargetMMSection() != null && !(g instanceof ExportedMappingHintGroup)){
								choiceOfValues.add(g.getTargetMMSection());
								TreeIterator<EObject> it=g.getTargetMMSection().eAllContents();
								while(it.hasNext()){
									EObject next=it.next();
									if(next instanceof TargetSectionClass){
										choiceOfValues.add((TargetSectionClass) next);
									}
								}	
							}
						}
						
						return choiceOfValues;
					}
				
				
			});
	}

	/**
	 * This returns MappingHintGroupImporter.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MappingHintGroupImporter"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MappingHintGroupImporter)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_MappingHintGroupImporter_type") :
			getString("_UI_MappingHintGroupImporter_type") + " " + label;
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

}