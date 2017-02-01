/**
 */
package pamtram.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.ConditionModel;
import pamtram.PamtramPackage;
import pamtram.condition.ConditionFactory;

/**
 * This is the item provider adapter for a {@link pamtram.ConditionModel} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ConditionModelItemProvider extends NamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConditionModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {

		if (this.itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {

		if (this.childrenFeatures == null) {
			super.getChildrenFeatures(object);
			this.childrenFeatures.add(PamtramPackage.Literals.CONDITION_MODEL__CONDITION);
		}
		return this.childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ConditionModel.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {

		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/ConditionModel"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getText(Object object) {

		return ((StyledString) this.getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((ConditionModel) object).getName();
		StyledString styledLabel = new StyledString();
		if (((ConditionModel) object).eContainer() == null) {
			styledLabel.append("Shared", StyledString.Style.QUALIFIER_STYLER);
		}
		if (label != null && label.length() > 0) {
			if (!styledLabel.getString().isEmpty()) {
				styledLabel.append(" ");
			}
			styledLabel.append(label);
		}

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {

		this.updateChildren(notification);

		switch (notification.getFeatureID(ConditionModel.class)) {
			case PamtramPackage.CONDITION_MODEL__CONDITION:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITION_MODEL__CONDITION,
				ConditionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITION_MODEL__CONDITION,
				ConditionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITION_MODEL__CONDITION,
				ConditionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITION_MODEL__CONDITION,
				ConditionFactory.eINSTANCE.createAttributeCondition()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITION_MODEL__CONDITION,
				ConditionFactory.eINSTANCE.createCardinalityCondition()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITION_MODEL__CONDITION,
				ConditionFactory.eINSTANCE.createApplicationDependency()));
	}

}
