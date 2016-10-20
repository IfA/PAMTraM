/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.mapping.impl.MappingPackageImpl;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.ModelConnectionHint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelConnectionHintItemProvider
extends MappingHintBaseTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelConnectionHintItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(MappingPackage.Literals.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES);
			childrenFeatures.add(MappingPackage.Literals.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS);
		}
		return childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if(labelRelatedChildrenFeatures == null) {
			labelRelatedChildrenFeatures = new ArrayList<>();
			labelRelatedChildrenFeatures.add(MappingPackageImpl.eINSTANCE.getModelConnectionHint_SourceElements());
			labelRelatedChildrenFeatures.add(MappingPackageImpl.eINSTANCE.getModelConnectionHint_TargetAttributes());
		}
		return labelRelatedChildrenFeatures;
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
	 * This returns ModelConnectionHint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ModelConnectionHint"));
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

		initializeLabelRelatedChildrenFeatureNotifications(object);

		ModelConnectionHint mch = ((ModelConnectionHint)object);
		StyledString styledLabel = new StyledString();

		ArrayList<String> targets = new ArrayList<>();
		for (ModelConnectionHintTargetAttribute target : mch.getTargetAttributes()) {
			targets.add(target.getName());
		} 
		styledLabel.append(String.join(", ", targets), StyledString.Style.COUNTER_STYLER);

		ArrayList<String> sources = new ArrayList<>();
		for (ModelConnectionHintSourceInterface source : mch.getSourceElements()) {
			sources.add(source.getName());
		} 
		styledLabel.append(" == " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ModelConnectionHint.class)) {
			case MappingPackage.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES:
			case MappingPackage.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	@Override
	public void notifyChanged(Notification notification) {

		handleLabelRelatedChildrenFeatureChangeNotification(notification);		
		notifyChangedGen(notification);
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

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MODEL_CONNECTION_HINT__TARGET_ATTRIBUTES,
				 MappingFactory.eINSTANCE.createModelConnectionHintTargetAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createModelConnectionHintSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createFixedValue()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createGlobalAttributeImporter()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createModelConnectionHintExternalSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MODEL_CONNECTION_HINT__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createModelConnectionHintGlobalSourceElement()));
	}

}
