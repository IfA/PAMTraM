/**
 */
package pamtram.structure.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.structure.Class;
import pamtram.structure.ContainmentReference;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.impl.ReferenceImpl;

/**
 * This is the item provider adapter for a {@link pamtram.structure.ContainmentReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ContainmentReferenceItemProvider
extends ReferenceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainmentReferenceItemProvider(AdapterFactory adapterFactory) {
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
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
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
						StructurePackage.Literals.REFERENCE__EREFERENCE,
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
				pamtram.structure.Class parent = (Class) ((ReferenceImpl) object).eContainer();
				Iterator<EReference> it = parent.getEClass().getEAllReferences().iterator(); 

				// filter the choices further so that only containment references are displayed
				while(it.hasNext()) {
					EReference ref = it.next();
					if(ref.isContainment()) {
						choiceOfValues.add(ref);
					}
				}

				return choiceOfValues;
			}
		});
	}

	/**
	 * This returns ContainmentReference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ContainmentReference"));
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

		switch (notification.getFeatureID(ContainmentReference.class)) {
			case StructurePackage.CONTAINMENT_REFERENCE__VALUE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
		(createChildParameter
				(StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE,
						StructureFactory.eINSTANCE.createSourceSectionClass()));

		// SourceSections may only be top-level elements in sections
		//		newChildDescriptors.add
		//			(createChildParameter
		//				(StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE,
		//				 StructureFactory.eINSTANCE.createSourceSection()));

		newChildDescriptors.add
		(createChildParameter
				(StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE,
						StructureFactory.eINSTANCE.createTargetSectionClass()));

		// TargetSections may only be top-level elements in sections
		//		newChildDescriptors.add
		//			(createChildParameter
		//				(StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE,
		//				 StructureFactory.eINSTANCE.createTargetSection()));
	}

}
