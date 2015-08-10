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

import pamtram.mapping.LocalModifiedAttributeElementType;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.SourceSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.LocalModifiedAttributeElementType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LocalModifiedAttributeElementTypeItemProvider extends ModifiedAttributeElementTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalModifiedAttributeElementTypeItemProvider(AdapterFactory adapterFactory) {
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
		String label = ((LocalModifiedAttributeElementType<?, ?, ?>)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_LocalModifiedAttributeElementType_type") :
			getString("_UI_LocalModifiedAttributeElementType_type") + " " + label;
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
				EObject parent=((ModifiedAttributeElementType<?,?,?>) object).eContainer();
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

				/*
				 * If we operate on an ModelConnectionHintTarget, we need to scan the container of the target section.
				 * Otherwise, we need to scan the source section for suitable attributes.
				 */
				Class relevantClass = null;
				if(object instanceof ModelConnectionHintTargetAttribute) {
					if(parent instanceof MappingHintGroupType && ((MappingHintGroupType) parent).getTargetMMSection() != null) {
						relevantClass = ((MappingHintGroupType) parent).getTargetMMSection().getContainer();

						// If no container has been specified, we allow for the default values.
						if(relevantClass == null) {
							return super.getChoiceOfValues(object);
						}
					}
				} else {
					relevantClass = mapping.getSourceMMSection();
				}

				if(relevantClass == null) {
					return new ArrayList<Object>();						
				}

				List<Object> choiceOfValues = new ArrayList<Object>();

				// iterate over all elements and return the attributes as possible options
				Set<Class> scanned=new HashSet<>();
				List<Class> sectionsToScan=new ArrayList<>();
				sectionsToScan.add(relevantClass);

				while(sectionsToScan.size() > 0){
					Class classToScan=sectionsToScan.remove(0);
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
}
