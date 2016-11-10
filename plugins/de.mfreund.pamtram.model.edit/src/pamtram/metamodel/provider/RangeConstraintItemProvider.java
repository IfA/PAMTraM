/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.RangeConstraint;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.RangeConstraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RangeConstraintItemProvider extends MultipleReferencesValueConstraintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeConstraintItemProvider(AdapterFactory adapterFactory) {
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
		if (this.itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			this.addUpperBoundPropertyDescriptor(object);
			this.addLowerBoundPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Upper Bound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUpperBoundPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add
		(this.createItemPropertyDescriptor
				(((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(),
						this.getString("_UI_RangeConstraint_upperBound_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_RangeConstraint_upperBound_feature", "_UI_RangeConstraint_type"),
						MetamodelPackage.Literals.RANGE_CONSTRAINT__UPPER_BOUND,
						true,
						false,
						false,
						null,
						null,
						null));
	}

	/**
	 * This adds a property descriptor for the Lower Bound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLowerBoundPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add
		(this.createItemPropertyDescriptor
				(((ComposeableAdapterFactory)this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(),
						this.getString("_UI_RangeConstraint_lowerBound_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_RangeConstraint_lowerBound_feature", "_UI_RangeConstraint_type"),
						MetamodelPackage.Literals.RANGE_CONSTRAINT__LOWER_BOUND,
						true,
						false,
						false,
						null,
						null,
						null));
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
		if (this.childrenFeatures == null) {
			super.getChildrenFeatures(object);
			this.childrenFeatures.add(MetamodelPackage.Literals.RANGE_CONSTRAINT__UPPER_BOUND);
			this.childrenFeatures.add(MetamodelPackage.Literals.RANGE_CONSTRAINT__LOWER_BOUND);
		}
		return this.childrenFeatures;
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
	 * This returns RangeConstraint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/RangeConstraint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)this.getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((RangeConstraint)object).getName();
		StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(this.getString("_UI_RangeConstraint_type"), StyledString.Style.QUALIFIER_STYLER);
		} else {
			styledLabel.append(this.getString("_UI_RangeConstraint_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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
		this.updateChildren(notification);

		switch (notification.getFeatureID(RangeConstraint.class)) {
			case MetamodelPackage.RANGE_CONSTRAINT__UPPER_BOUND:
			case MetamodelPackage.RANGE_CONSTRAINT__LOWER_BOUND:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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
		(this.createChildParameter
				(MetamodelPackage.Literals.RANGE_CONSTRAINT__UPPER_BOUND,
						MetamodelFactory.eINSTANCE.createRangeBound()));

		newChildDescriptors.add
		(this.createChildParameter
				(MetamodelPackage.Literals.RANGE_CONSTRAINT__LOWER_BOUND,
						MetamodelFactory.eINSTANCE.createRangeBound()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {

		// Object childFeature = feature;
		// Object childObject = child;
		//
		// boolean qualify =
		// childFeature == MetamodelPackage.Literals.RANGE_CONSTRAINT__UPPER_BOUND ||
		// childFeature == MetamodelPackage.Literals.RANGE_CONSTRAINT__LOWER_BOUND;
		//
		// if (qualify) {
		// return getString
		// ("_UI_CreateChild_text2",
		// new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		// }
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
