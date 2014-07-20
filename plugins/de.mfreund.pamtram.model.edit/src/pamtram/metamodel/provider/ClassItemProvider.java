/**
 */
package pamtram.metamodel.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.Class} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassItemProvider
	extends MetaModelElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassItemProvider(AdapterFactory adapterFactory) {
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

			addEClassPropertyDescriptor(object);
			addCardinalityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the EClass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEClassPropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Class_eClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Class_eClass_feature", "_UI_Class_type"),
				 MetamodelPackage.Literals.CLASS__ECLASS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}
	
	/**
	 * This adds a property descriptor for the EClass feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addEClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Class_eClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Class_eClass_feature", "_UI_Class_type"),
				 MetamodelPackage.Literals.CLASS__ECLASS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null)
			   {
				@SuppressWarnings("unchecked")
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					
					Collection<?> parentChoiceOfValues =  super.getChoiceOfValues(object);
					
					// if the class represents a top-level section, do not filter the choices
					if(!(((pamtram.metamodel.Class) object).eContainer() instanceof pamtram.metamodel.Reference)) {
						return parentChoiceOfValues;
					}
					// else, do only allow those eClasses that match the parent reference
					
					// the containing reference
					Reference ref = (Reference) ((pamtram.metamodel.Class) object).eContainer();
					
					if(!(ref.getEReference().getEType() instanceof EClass)) {
						throw new RuntimeException("Type checks can only be performed for instances of type 'EClass'");
					}
					
					// the type of the non-containment reference
					EClass refClass = (EClass) ref.getEReference().getEType();

					List<Object> choiceOfValues = new ArrayList<Object>();
					Iterator<EClass> it = (Iterator<EClass>) parentChoiceOfValues.iterator();
					
					// make sure that only those classes can be selected that correspond to the type of the parent reference
					while(it.hasNext()) {
						EClass eClass = it.next();
						// at some point, it seems to occur that it.next() delivers 'null'
						if(eClass == null) {
							continue;
						}
						if(refClass.isSuperTypeOf(eClass)) {
							choiceOfValues.add(eClass);
						}
					}
					
					return choiceOfValues;
				}
			   });
	}

	/**
	 * This adds a property descriptor for the Cardinality feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCardinalityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Class_cardinality_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Class_cardinality_feature", "_UI_Class_type"),
				 MetamodelPackage.Literals.CLASS__CARDINALITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Class.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Class"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * The label of the class is composed of its name and the 
	 * name of the associated eClass.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((pamtram.metamodel.Class)object).getName();
		EClass eClass = ((pamtram.metamodel.Class)object).getEClass();
		
		String ret = "";
		if(label != null && label.length() != 0) {
			ret += label;
		}
		if(eClass != null && eClass.getEPackage() != null) {
			ret += (ret.equals("") ?
					"(" + eClass.getEPackage().getNsPrefix() + "::" + eClass.getName() + ")" :
					" (" + eClass.getEPackage().getNsPrefix() + "::" + eClass.getName() + ")");
		}
		
		return ret;
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

		switch (notification.getFeatureID(pamtram.metamodel.Class.class)) {
			case MetamodelPackage.CLASS__CARDINALITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
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
