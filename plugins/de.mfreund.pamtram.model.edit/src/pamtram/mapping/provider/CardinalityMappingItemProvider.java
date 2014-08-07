/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.Class;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.CardinalityMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CardinalityMappingItemProvider
	extends MappingHintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityMappingItemProvider(AdapterFactory adapterFactory) {
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
			addTargetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CardinalityMapping_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_source_feature", "_UI_CardinalityMapping_type"),
				 MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
				 getString("_UI_CardinalityMapping_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_source_feature", "_UI_CardinalityMapping_type"),
				 MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			   {
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					
					// the parent mapping
					MappingHintGroup mappingGroup = (MappingHintGroup) ((CardinalityMapping) object).eContainer();
					Mapping mapping = (Mapping) mappingGroup.eContainer();
					
					// the source section
					pamtram.metamodel.Class source = mapping.getSourceMMSection();

					List<Object> choiceOfValues = new ArrayList<Object>();
					
					// iterate over all elements and return the attributes as possible options
					Iterator<EObject> it = source.eAllContents(); 
					while(it.hasNext()) {
						EObject next = it.next();
						if(next instanceof pamtram.metamodel.Class && 
								((pamtram.metamodel.Class) next).getCardinality().getValue() != CardinalityType.ONE_VALUE) {
							choiceOfValues.add(next);
						}
					}
					
					return choiceOfValues;
				}
			   });
	}
	
	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CardinalityMapping_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_target_feature", "_UI_CardinalityMapping_type"),
				 MappingPackage.Literals.CARDINALITY_MAPPING__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CardinalityMapping_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_target_feature", "_UI_CardinalityMapping_type"),
				 MappingPackage.Literals.CARDINALITY_MAPPING__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			   {
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					
				// the parent mapping
				MappingHintGroup mappingHintGroup = (MappingHintGroup) ((CardinalityMapping) object)
						.eContainer();

				// the source section
				Class target = mappingHintGroup.getTargetMMSection();

				List<Object> choiceOfValues = new ArrayList<Object>();

				// is the target itself a possible option?
				if (target.getCardinality().getValue() != CardinalityType.ONE_VALUE) {
					choiceOfValues.add(target);
				}

				// iterate over all elements and return the attributes as
				// possible options
				Iterator<EObject> it = target.eAllContents();
				while (it.hasNext()) {
					EObject next = it.next();
					if (next instanceof pamtram.metamodel.Class
							&& ((pamtram.metamodel.Class) next)
									.getCardinality().getValue() != CardinalityType.ONE_VALUE) {
						choiceOfValues.add(next);
					}
				}
					
					
					return choiceOfValues;
				}
			   });
	}

	/**
	 * This returns CardinalityMapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CardinalityMapping"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CardinalityMapping)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CardinalityMapping_type") :
			getString("_UI_CardinalityMapping_type") + " " + label;
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
