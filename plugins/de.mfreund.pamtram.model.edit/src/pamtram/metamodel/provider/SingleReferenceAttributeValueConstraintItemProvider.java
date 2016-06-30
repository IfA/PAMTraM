/**
 */
package pamtram.metamodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.FixedValue;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.SingleReferenceAttributeValueConstraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SingleReferenceAttributeValueConstraintItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleReferenceAttributeValueConstraintItemProvider(AdapterFactory adapterFactory) {
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

			addTypePropertyDescriptor(object);
			addExpressionPropertyDescriptor(object);
			addResultModifierPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributeValueConstraint_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributeValueConstraint_type_feature", "_UI_AttributeValueConstraint_type"),
				 MetamodelPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExpressionHint_expression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ExpressionHint_expression_feature", "_UI_ExpressionHint_type"),
				 MappingPackage.Literals.EXPRESSION_HINT__EXPRESSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
			childrenFeatures.add(MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
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
		String label = ((SingleReferenceAttributeValueConstraint)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_SingleReferenceAttributeValueConstraint_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_SingleReferenceAttributeValueConstraint_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

		switch (notification.getFeatureID(SingleReferenceAttributeValueConstraint.class)) {
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__TYPE:
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
			case MetamodelPackage.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
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

		if(!(object instanceof EObject)) {
			return;
		}
		
		// Do not allow to add InstancePointers below SourceSectionAttributes as these are only supported as part of 
				// Conditions
				//
				if(!AgteleEcoreUtil.hasAncestorOfKind((EObject) object, MetamodelPackage.eINSTANCE.getSourceSectionAttribute())) {
			
			newChildDescriptors.add
			(createChildParameter
					(MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION,
							MetamodelFactory.eINSTANCE.createInstancePointer()));
		}

		// Do not allow to add local/external source attributes or GlobalAttributeImporters below 
		// SourceSectionAttributes as these are only supported as part of Conditions
		//
		if(!AgteleEcoreUtil.hasAncestorOfKind((EObject) object, MetamodelPackage.eINSTANCE.getSourceSectionAttribute())) {
			
			// Do not allow to add local/external source attributes below 
			// AttributeConditions that are located inside a ConditionModel
			//
			ComplexCondition condition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind((EObject) object, ConditionPackage.eINSTANCE.getComplexCondition());
			if(condition == null || !condition.isConditionModelCondition()) {
				
				newChildDescriptors.add
				(createChildParameter
						(MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
								MetamodelFactory.eINSTANCE.createAttributeValueConstraintSourceElement()));
				
				newChildDescriptors.add
				(createChildParameter
						(MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
								MetamodelFactory.eINSTANCE.createAttributeValueConstraintExternalSourceElement()));
				
			}
			
			newChildDescriptors.add
			(createChildParameter
					(MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
							MappingFactory.eINSTANCE.createGlobalAttributeImporter()));
		}

		newChildDescriptors.add
			(createChildParameter
				(MetamodelPackage.Literals.SINGLE_REFERENCE_ATTRIBUTE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
				 MappingFactory.eINSTANCE.createFixedValue()));
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
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {
		
		if(feature.equals(MetamodelPackage.eINSTANCE.getSingleReferenceAttributeValueConstraint_ConstraintReferenceValueAdditionalSpecification()) &&
				!AgteleEcoreUtil.hasAncestorOfKind(owner, MappingPackage.eINSTANCE.getMapping()) && !collection.parallelStream().allMatch(s -> s instanceof FixedValue)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}
	
	@Override
	public AbstractCommand createDragAndDropCommand(EditingDomain domain, Collection<EObject> collection,
			EObject parent, EReference ref) {
		if(ref.equals(MetamodelPackage.eINSTANCE.getSingleReferenceAttributeValueConstraint_ConstraintReferenceValueAdditionalSpecification()) &&
				!AgteleEcoreUtil.hasAncestorOfKind(parent, MappingPackage.eINSTANCE.getMapping()) && !collection.parallelStream().allMatch(s -> s instanceof FixedValue)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.createDragAndDropCommand(domain, collection, parent, ref);
	}

}
