/**
 */
package pamtram.structure.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.MappingModel;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.provider.ExpressionElementItemProvider;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;

/**
 * This is the item provider adapter for a
 * {@link pamtram.structure.InstanceSelector} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class InstanceSelectorItemProvider extends ExpressionElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSelectorItemProvider(AdapterFactory adapterFactory) {
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

			this.addModifiersPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Modifiers feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addModifiersPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ModifiableElement_modifiers_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_ModifiableElement_modifiers_feature",
						"_UI_ModifiableElement_type"),
				PamtramPackage.Literals.MODIFIABLE_ELEMENT__MODIFIERS, true, false, true, null, null, null));
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
			this.childrenFeatures.add(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS);
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
	 * This returns InstanceSelector.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/InstanceSelector"));
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
		String label = ((InstanceSelector) object).getExpression();
		StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(this.getString("_UI_InstanceSelector_type"), StyledString.Style.QUALIFIER_STYLER);
		} else {
			styledLabel.append(this.getString("_UI_InstanceSelector_type"), StyledString.Style.QUALIFIER_STYLER)
					.append(" " + label);
		}
		return styledLabel;
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

		switch (notification.getFeatureID(InstanceSelector.class)) {
		case StructurePackage.INSTANCE_SELECTOR__SOURCE_ELEMENTS:
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
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);

		ComplexCondition parentCondition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind((EObject) object,
				ConditionPackage.eINSTANCE.getComplexCondition());

		if (parentCondition != null) {
			parentCondition = parentCondition.getRootCondition();
		}

		// ModifiedAttributeType children only allowed in
		// - conditions that are no ConditionModelConditions or
		// - conditions that are no MappingModelConditions
		// - global source elements
		//
		if (parentCondition != null && !parentCondition.isConditionModelCondition()
				&& !(parentCondition.eContainer() instanceof MappingModel)
				|| ((EObject) object).eContainer() instanceof GlobalDynamicSourceElement<?, ?, ?, ?, ?>) {

			newChildDescriptors
					.add(this.createChildParameter(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
							StructureFactory.eINSTANCE.createInstanceSelectorSourceElement()));

			newChildDescriptors
					.add(this.createChildParameter(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
							StructureFactory.eINSTANCE.createInstanceSelectorExternalSourceElement()));

			newChildDescriptors
					.add(this.createChildParameter(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
							StructureFactory.eINSTANCE.createInstanceSelectorGlobalSourceElement()));
		}

		newChildDescriptors.add(this.createChildParameter(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
				PamtramFactory.eINSTANCE.createFixedValue()));

		// GlobalAttributeImporters not allowed in MappingModelConditions
		//
		if (parentCondition != null && !(parentCondition.eContainer() instanceof MappingModel)) {
			newChildDescriptors
					.add(this.createChildParameter(StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS,
							ExtendedFactory.eINSTANCE.createGlobalAttributeImporter()));
		}
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
