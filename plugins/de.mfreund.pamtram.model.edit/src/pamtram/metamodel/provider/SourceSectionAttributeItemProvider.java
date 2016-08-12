/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import org.eclipse.emf.edit.provider.ViewerNotification;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.SourceSectionAttribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceSectionAttributeItemProvider extends AttributeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionAttributeItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT);
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
	 * This returns SourceSectionAttribute.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SourceSectionAttribute"));
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
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((SourceSectionAttribute)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_SourceSectionAttribute_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_SourceSectionAttribute_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
		}
		return styledLabel;
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

		switch (notification.getFeatureID(SourceSectionAttribute.class)) {
			case MetamodelPackage.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT:
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
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT,
				 MetamodelFactory.eINSTANCE.createEqualityMatcher()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT,
				 MetamodelFactory.eINSTANCE.createSubstringMatcher()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT,
				 MetamodelFactory.eINSTANCE.createBeginningMatcher()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT,
				 MetamodelFactory.eINSTANCE.createEndingMatcher()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT,
				 MetamodelFactory.eINSTANCE.createRegExMatcher()));

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.SOURCE_SECTION_ATTRIBUTE__VALUE_CONSTRAINT,
				 MetamodelFactory.eINSTANCE.createRangeConstraint()));
	}

}
