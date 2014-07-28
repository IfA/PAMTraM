/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.ClassMatcher} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassMatcherItemProvider
	extends MatcherItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassMatcherItemProvider(AdapterFactory adapterFactory) {
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

			addTargetClassPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ClassMatcher_targetClass_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ClassMatcher_targetClass_feature", "_UI_ClassMatcher_type"),
				 MappingPackage.Literals.CLASS_MATCHER__TARGET_CLASS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null){

					@Override
					public Collection<?> getChoiceOfValues(Object object) {
						Collection<?> superChoices=super.getChoiceOfValues(object);
						
						EClass refClass=null;
						try{
							refClass=((MappingInstanceSelector) ((EObject) object).eContainer()).getAffectedReference().getEReference().getEReferenceType();
						} catch(Exception e){
							return superChoices;
						}
							List<TargetSectionClass> choices=new LinkedList<TargetSectionClass>();
							Iterator<?>  it=superChoices.iterator();
							while(it.hasNext()){
								Object next=it.next();
								if(next instanceof TargetSectionClass){
									if(((TargetSectionClass) next).getEClass() != null){
										if(refClass.isSuperTypeOf(((TargetSectionClass) next).getEClass())){
											choices.add((TargetSectionClass) next);
										}
									}
								}
							}
							
							return choices;
						
					}
				
				
			});
	}

	/**
	 * This returns ClassMatcher.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ClassMatcher"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ClassMatcher_type");
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
