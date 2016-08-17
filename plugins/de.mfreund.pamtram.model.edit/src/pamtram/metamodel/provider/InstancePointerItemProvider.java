/**
 */
package pamtram.metamodel.provider;


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
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.commands.BasicDragAndDropSetCommand;
import pamtram.mapping.provider.ExpressionHintItemProvider;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.provider.PamtramEditPlugin;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.InstancePointer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InstancePointerItemProvider 
	extends ExpressionHintItemProvider {
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
			addAttributePointerPropertyDescriptor(object);
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
				 getString("_UI_ModifiableHint_resultModifier_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ModifiableHint_resultModifier_feature", "_UI_ModifiableHint_type"),
				 MappingPackage.Literals.MODIFIABLE_HINT__RESULT_MODIFIER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Attribute Pointer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAttributePointerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstancePointer_attributePointer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstancePointer_attributePointer_feature", "_UI_InstancePointer_type"),
				 MetamodelPackage.Literals.INSTANCE_POINTER__ATTRIBUTE_POINTER,
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
			childrenFeatures.add(MetamodelPackage.Literals.INSTANCE_POINTER__SOURCE_ATTRIBUTES);
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
			case MetamodelPackage.INSTANCE_POINTER__SOURCE_ATTRIBUTES:
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
		
		// ModifiedAttributeType children only allowed in conditions that are no ConditionModelConditions
		//
		if(parentCondition != null && !parentCondition.isConditionModelCondition()) {
			
			newChildDescriptors.add
			(createChildParameter
					(MetamodelPackage.Literals.INSTANCE_POINTER__SOURCE_ATTRIBUTES,
							MetamodelFactory.eINSTANCE.createInstancePointerSourceElement()));
			
			newChildDescriptors.add
			(createChildParameter
					(MetamodelPackage.Literals.INSTANCE_POINTER__SOURCE_ATTRIBUTES,
							MetamodelFactory.eINSTANCE.createInstancePointerExternalSourceElement()));
		}

		newChildDescriptors.add
		(createChildParameter
				(MetamodelPackage.Literals.INSTANCE_POINTER__SOURCE_ATTRIBUTES,
						MappingFactory.eINSTANCE.createFixedValue()));
		
		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.INSTANCE_POINTER__SOURCE_ATTRIBUTES,
				 MappingFactory.eINSTANCE.createGlobalAttributeImporter()));
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
			return new BasicDragAndDropSetCommand(domain, (EObject) owner, MetamodelPackage.Literals.INSTANCE_POINTER__ATTRIBUTE_POINTER, 
					collection.iterator().next(), 0);
		}
		
		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}

}
