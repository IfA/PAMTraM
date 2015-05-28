/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import pamtram.mapping.commands.BasicDragAndDropSetCommand;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.TargetSectionClass} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetSectionClassItemProvider
	extends ClassItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClassItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns TargetSectionClass.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	
	@Override
	protected Command createDragAndDropCommand(EditingDomain domain,
			Object owner, float location, int operations, int operation,
			Collection<?> collection) {
		
		if(location > 0.25 && location < 0.75) {
			if(collection.size() == 1) {
				Object value = collection.iterator().next();
				if(value instanceof TargetSectionClass) {
			
					return new BasicDragAndDropSetCommand(domain, (EObject) owner, 
							MetamodelPackage.Literals.CLASS__CONTAINER, value, 0);
				}
			}
		}
		
		return super.createDragAndDropCommand(domain, owner, location, operations,
				operation, collection); 
	}

}
