/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import org.eclipse.emf.edit.provider.StyledString;
import pamtram.mapping.commands.BasicDragAndDropAddCommand;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.MetaModelSectionReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetaModelSectionReferenceItemProvider extends SourceSectionReferenceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModelSectionReferenceItemProvider(AdapterFactory adapterFactory) {
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

			addValuePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_MetaModelSectionReference_value_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MetaModelSectionReference_value_feature", "_UI_MetaModelSectionReference_type"),
						MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE,
						true,
						false,
						true,
						null,
						null,
						null){

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				Collection<?> superChoices=super.getChoiceOfValues(object);

				EClass refClass =null;
				try{
					refClass=((MetaModelSectionReference)object).getEReference().getEReferenceType();
				} catch(Exception e){
					return superChoices;
				}
				List<SourceSectionClass> choices=new LinkedList<SourceSectionClass>();
				Iterator<?>  it=superChoices.iterator();
				while(it.hasNext()){
					Object next=it.next();
					if(next instanceof SourceSectionClass){
						if(((SourceSectionClass) next).getEClass() != null){
							if(refClass.isSuperTypeOf(((SourceSectionClass) next).getEClass())){
								choices.add((SourceSectionClass) next);
							}
						}
					}
				}

				return choices;
			}


		});
	}

	/**
	 * This returns MetaModelSectionReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MetaModelSectionReference"));
	}

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
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {
		return super.getStyledText(object);
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

		EList<SourceSectionClass> values = new BasicEList<SourceSectionClass>();
		for (Object value : collection) {
			if(value instanceof SourceSectionClass) {
				values.add((SourceSectionClass) value);
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
					MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE, values);
		}
	}
}
