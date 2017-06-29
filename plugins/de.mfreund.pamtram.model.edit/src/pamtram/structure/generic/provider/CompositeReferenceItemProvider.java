/**
 */
package pamtram.structure.generic.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.target.TargetFactory;

/**
 * This is the item provider adapter for a
 * {@link pamtram.structure.generic.CompositeReference} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class CompositeReferenceItemProvider extends ReferenceItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public CompositeReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(GenericPackage.Literals.COMPOSITE_REFERENCE__VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns CompositeReference.gif.
	 */
	@Override
	public Object getImage(Object object) {

		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/CompositeReference"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		return super.getStyledText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CompositeReference.class)) {
			case GenericPackage.COMPOSITE_REFERENCE__VALUE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);

		Class<?, ?, ?, ?> clazz = SourceFactory.eINSTANCE.createSourceSectionClass();

		EReference ref = object instanceof ActualReference<?, ?, ?, ?>
				? ((ActualReference<?, ?, ?, ?>) object).getEReference() : null;
		if (ref != null && ref.getUpperBound() < 0) {
			clazz.setCardinality(CardinalityType.ONE_INFINITY);
		}

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.COMPOSITE_REFERENCE__VALUE, clazz));

		// SourceSections may only be top-level elements in sections
		// newChildDescriptors.add
		// (createChildParameter
		// (StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE,
		// StructureFactory.eINSTANCE.createSourceSection()));

		clazz = TargetFactory.eINSTANCE.createTargetSectionClass();
		if (ref != null && ref.getUpperBound() < 0) {
			clazz.setCardinality(CardinalityType.ONE_INFINITY);
		}

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.COMPOSITE_REFERENCE__VALUE, clazz));

		// TargetSections may only be top-level elements in sections
		// newChildDescriptors.add
		// (createChildParameter
		// (StructurePackage.Literals.CONTAINMENT_REFERENCE__VALUE,
		// StructureFactory.eINSTANCE.createTargetSection()));
	}

}
