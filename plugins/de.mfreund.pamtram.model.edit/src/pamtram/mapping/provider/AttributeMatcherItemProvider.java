/**
 */
package pamtram.mapping.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.impl.MappingPackageImpl;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.AttributeMatcher} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeMatcherItemProvider
extends MatcherItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeMatcherItemProvider(AdapterFactory adapterFactory) {
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

			addExpressionPropertyDescriptor(object);
			addResultModifierPropertyDescriptor(object);
			addTargetAttributePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
	 * This adds a property descriptor for the Target Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected void addTargetAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_AttributeMatcher_targetAttribute_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_AttributeMatcher_targetAttribute_feature", "_UI_AttributeMatcher_type"),
						MappingPackage.Literals.ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE,
						true,
						false,
						true,
						null,
						null,
						null){

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				//the parent MappingInstanceSelector
				Collection<TargetSectionAttribute> choices=new LinkedList<TargetSectionAttribute>();
				Collection<TargetSectionClass>refClasses=((MappingInstanceSelector) ((EObject) object).eContainer()).getAffectedReference().getValue();

				/*
				 * Only show attributes that belong to an Class that was modeled as the reference's value
				 */
				for(TargetSectionClass val : refClasses){
					choices.addAll(val.getAttributes());
				}

				return choices;
			}


		});
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
			childrenFeatures.add(MappingPackage.Literals.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES);
		}
		return childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if(labelRelatedChildrenFeatures == null) {
			labelRelatedChildrenFeatures = new ArrayList<>();
			labelRelatedChildrenFeatures.add(MappingPackageImpl.eINSTANCE.getAttributeMatcher_SourceAttributes());
			labelRelatedChildrenFeatures.add(MappingPackageImpl.eINSTANCE.getAttributeMatcher_TargetAttribute());
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
	 * This returns AttributeMatcher.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributeMatcher"));
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

		AttributeMatcher am = ((AttributeMatcher)object);
		StyledString styledLabel = new StyledString();

		String label = (am.getTargetAttribute() != null ? am.getTargetAttribute().getName() : null);

		if(label != null) {
			styledLabel.append(label);
		}

		if(am.getExpression() != null && !am.getExpression().isEmpty()) {
			styledLabel.append(" == " + am.getExpression(), StyledString.Style.COUNTER_STYLER);
		} else {
			ArrayList<String> sources = new ArrayList<>();
			for (AttributeMatcherSourceInterface source : am.getSourceAttributes()) {
				sources.add(source.getName());
			} 
			styledLabel.append(" == " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);
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
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AttributeMatcher.class)) {
			case MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MappingPackage.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
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
				(MappingPackage.Literals.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES,
				 MappingFactory.eINSTANCE.createAttributeMatcherSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES,
				 MappingFactory.eINSTANCE.createFixedValue()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES,
				 MappingFactory.eINSTANCE.createGlobalAttributeImporter()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES,
				 MappingFactory.eINSTANCE.createAttributeMatcherExternalSourceElement()));
	}

}
