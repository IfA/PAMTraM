/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.SectionModel;
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
				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					
					pamtram.metamodel.Class section=((pamtram.metamodel.Class) object).getContainingSection();
					
					List<EClass> choiceOfValues = new LinkedList<EClass>();
					List<EPackage> packagesToScan=new LinkedList<EPackage>();
					
					packagesToScan.add(((SectionModel)section.eContainer()).getMetaModelPackage());
					
					while(packagesToScan.size()>0){
						EPackage pkg=packagesToScan.remove(0);
						packagesToScan.addAll(pkg.getESubpackages());
						for(EClassifier c : pkg.getEClassifiers()){
							if(c instanceof EClass){
								if(!((EClass) c).isAbstract()){
									choiceOfValues.add((EClass) c);
								}
							}
						}
					}
					
					
					
					if(section.equals(object)){
						return choiceOfValues;
					}else { //not a top-level section
						List<EClass> newChoiceOfValues = new LinkedList<EClass>();
						pamtram.metamodel.Reference ref=(Reference) ((pamtram.metamodel.Class)object).eContainer();
						if(ref.getEReference() != null){
							if(!(ref.getEReference().getEType() instanceof EClass)) {
								throw new RuntimeException("Type checks can only be performed for instances of type 'EClass'");
							} else {
								EClass refClass=(EClass) ref.getEReference().getEType();
								
								for(EClass c : choiceOfValues){
									if(refClass.isSuperTypeOf(c)) {
										newChoiceOfValues.add(c);
									}
								}
								return newChoiceOfValues;
								
							}
							
						}
			
					} 
					return super.getChoiceOfValues(object);
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