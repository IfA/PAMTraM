/**
 */
package pamtram.structure.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.MappingModel;
import pamtram.PamtramPackage;
import pamtram.commands.BasicDragAndDropSetCommand;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.GlobalModifiedAttributeElementType;
import pamtram.mapping.MappingFactory;
import pamtram.provider.ExpressionElementItemProvider;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.InstancePointer;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.source.ActualSourceSectionAttribute;

/**
 * This is the item provider adapter for a {@link pamtram.structure.InstancePointer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InstancePointerItemProvider
extends ExpressionElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePointerItemProvider(AdapterFactory adapterFactory) {
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

			addResultModifierPropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Result Modifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResultModifierPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ModifiableElement_resultModifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ModifiableElement_resultModifier_feature", "_UI_ModifiableElement_type"),
				 PamtramPackage.Literals.MODIFIABLE_ELEMENT__RESULT_MODIFIER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstancePointer_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstancePointer_target_feature", "_UI_InstancePointer_type"),
				 StructurePackage.Literals.INSTANCE_POINTER__TARGET,
				 true,
				 false,
				 true,
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
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StructurePackage.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS);
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
	 * This returns InstancePointer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InstancePointer"));
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
		String label = ((InstancePointer)object).getExpression();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_InstancePointer_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_InstancePointer_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

		switch (notification.getFeatureID(InstancePointer.class)) {
			case StructurePackage.INSTANCE_POINTER__SOURCE_ELEMENTS:
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

		ComplexCondition parentCondition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind((EObject) object,
				ConditionPackage.eINSTANCE.getComplexCondition());

		if(parentCondition != null) {
			parentCondition = parentCondition.getRootCondition();
		}

		// ModifiedAttributeType children only allowed in
		// - conditions that are no ConditionModelConditions or
		// - conditions that are no MappingModelConditions
		// - global source elements
		//
		if (parentCondition != null && !parentCondition.isConditionModelCondition()
				&& !(parentCondition.eContainer() instanceof MappingModel)
				|| ((EObject) object).eContainer() instanceof GlobalModifiedAttributeElementType<?, ?, ?, ?>) {

			newChildDescriptors.add
			(this.createChildParameter
					(StructurePackage.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS,
							StructureFactory.eINSTANCE.createInstancePointerSourceElement()));

			newChildDescriptors.add
			(this.createChildParameter
					(StructurePackage.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS,
							StructureFactory.eINSTANCE.createInstancePointerExternalSourceElement()));
		}

		newChildDescriptors.add
		(this.createChildParameter
				(StructurePackage.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS,
						MappingFactory.eINSTANCE.createFixedValue()));

		// GlobalAttributeImporters not allowed in MappingModelConditions
		//
		if (parentCondition != null && !(parentCondition.eContainer() instanceof MappingModel)) {
			newChildDescriptors.add
			(this.createChildParameter
					(StructurePackage.Literals.INSTANCE_POINTER__SOURCE_ELEMENTS,
							MappingFactory.eINSTANCE.createGlobalAttributeImporter()));
		}
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return PamtramEditPlugin.INSTANCE;
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		if(collection.size() == 1 && collection.iterator().next() instanceof ActualSourceSectionAttribute) {
			return new BasicDragAndDropSetCommand(domain, (EObject) owner, StructurePackage.Literals.INSTANCE_POINTER__TARGET,
					collection.iterator().next(), 0);
		}

		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}

}
