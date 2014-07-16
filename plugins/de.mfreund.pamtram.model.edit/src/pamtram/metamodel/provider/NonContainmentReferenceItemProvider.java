/**
 */
package pamtram.metamodel.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.impl.ReferenceImpl;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.NonContainmentReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NonContainmentReferenceItemProvider
	extends ReferenceItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonContainmentReferenceItemProvider(AdapterFactory adapterFactory) {
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
	 * This adds a property descriptor for the EReference feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected void addEReferencePropertyDescriptor(Object object) {
		
		itemPropertyDescriptors.add
	      (new ItemPropertyDescriptor
	        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
	         getResourceLocator(),
	         getString("_UI_Reference_eReference_feature"),
	         getString("_UI_PropertyDescriptor_description", "_UI_Reference_eReference_feature", "_UI_Reference_type"),
	         MetamodelPackage.Literals.REFERENCE__EREFERENCE,
	         true,
	         false,
	         true,
	         null,
	         null,
	         null)
	       {
	        @Override
	        public Collection<?> getChoiceOfValues(Object object)
	        {
	        	List<Object> choiceOfValues = new ArrayList<Object>();
	        	
	        	// make sure that only those references can be selected that belong to the parent eClass
	        	pamtram.metamodel.Class parent = (Class) ((ReferenceImpl) object).eContainer();
	        	Iterator<EReference> it = parent.getEClass().getEAllReferences().iterator(); 
	        	
	        	// filter the choices further so that only non-containment references are displayed
	        	while(it.hasNext()) {
	        		EReference ref = it.next();
	        		if(!(ref.isContainment())) {
	        			choiceOfValues.add(ref);
	        		}
	        	}
	        	
	        	return choiceOfValues;
	        }
	      });
	}

	/**
	 * This returns NonContainmentReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/NonContainmentReference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return super.getText(object);
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
