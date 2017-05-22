/**
 */
package pamtram.provider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.ConditionalElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionFactory;
import pamtram.util.PamtramItemProviderAdapter;

/**
 * This is the item provider adapter for a {@link pamtram.ConditionalElement}
 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class ConditionalElementItemProvider extends PamtramItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemStyledLabelProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConditionalElementItemProvider(AdapterFactory adapterFactory) {
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
		if (this.itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			this.addSharedConditionPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Shared Condition feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addSharedConditionPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ConditionalElement_sharedCondition_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_ConditionalElement_sharedCondition_feature",
						"_UI_ConditionalElement_type"),
				PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION, true, false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				Collection<?> choices = super.getChoiceOfValues(object);

				// Only allow to reference ConditionModel-conditions as shared
				// conditions
				//
				return choices.stream().filter(
						c -> c instanceof ComplexCondition && ((ComplexCondition) c).isConditionModelCondition())
						.collect(Collectors.toList());
			}
		});
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (this.childrenFeatures == null) {
			super.getChildrenFeatures(object);
			this.childrenFeatures.add(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION);
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
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString) this.getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		return new StyledString(this.getString("_UI_ConditionalElement_type"));
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		this.updateChildren(notification);

		switch (notification.getFeatureID(ConditionalElement.class)) {
		case PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION:
			this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createAttributeCondition()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createCardinalityCondition()));

		newChildDescriptors.add(this.createChildParameter(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION,
				ConditionFactory.eINSTANCE.createApplicationDependency()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

}
