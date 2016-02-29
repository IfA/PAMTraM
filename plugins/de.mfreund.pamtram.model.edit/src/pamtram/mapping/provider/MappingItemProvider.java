/**
 */
package pamtram.mapping.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionFactory;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.commands.BasicDragAndDropSetCommand;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.Mapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingItemProvider
extends MappingTypeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingItemProvider(AdapterFactory adapterFactory) {
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

			addConditionRefPropertyDescriptor(object);
			addAbstractPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Condition Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConditionalElement_conditionRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConditionalElement_conditionRef_feature", "_UI_ConditionalElement_type"),
				 PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION_REF,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Mapping_abstract_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Mapping_abstract_feature", "_UI_Mapping_type"),
				 MappingPackage.Literals.MAPPING__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION);
			childrenFeatures.add(MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS);
			childrenFeatures.add(MappingPackage.Literals.MAPPING__IMPORTED_MAPPING_HINT_GROUPS);
			childrenFeatures.add(MappingPackage.Literals.MAPPING__GLOBAL_VARIABLES);
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
	 * This adds a property descriptor for the Source MM Section feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected void addSourceMMSectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_MappingType_sourceMMSection_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MappingType_sourceMMSection_feature", "_UI_MappingType_type"),
						MappingPackage.Literals.MAPPING_TYPE__SOURCE_MM_SECTION,
						true,
						false,
						true,
						null,
						null,
						null)
		{
			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				PAMTraM pamtram = (PAMTraM) EcoreUtil.getRootContainer((Mapping) object);

				// all source metamodel sections are valid options
				return pamtram.getSourceSections();
			}
		});
	}

	/**
	 * This returns Mapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Mapping"));
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
		String label = ((Mapping)object).getName();
		StyledString styledLabel = new StyledString();

		if (label == null || label.length() == 0) {
			styledLabel.append(""); 
		} else {
			styledLabel.append(label, ((Mapping) object).isAbstract() ? StyledString.Style.QUALIFIER_STYLER : StyledString.Style.NO_STYLE);
		}

		if(((Mapping) object).isDeactivated()) {
			return new StyledString(styledLabel.getString(), StyledString.Style.newBuilder().setStrikedout(true).toStyle());
		} else {
			return styledLabel;

		}

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

		switch (notification.getFeatureID(Mapping.class)) {
			case MappingPackage.MAPPING__ABSTRACT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MappingPackage.MAPPING__CONDITION:
			case MappingPackage.MAPPING__MAPPING_HINT_GROUPS:
			case MappingPackage.MAPPING__IMPORTED_MAPPING_HINT_GROUPS:
			case MappingPackage.MAPPING__GLOBAL_VARIABLES:
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
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION,
				 ConditionFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION,
				 ConditionFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION,
				 ConditionFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION,
				 ConditionFactory.eINSTANCE.createAttributeCondition()));

		newChildDescriptors.add
			(createChildParameter
				(PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION,
				 ConditionFactory.eINSTANCE.createSectionCondition()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS,
				 MappingFactory.eINSTANCE.createMappingHintGroup()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS,
				 MappingFactory.eINSTANCE.createExportedMappingHintGroup()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING__IMPORTED_MAPPING_HINT_GROUPS,
				 MappingFactory.eINSTANCE.createMappingHintGroupImporter()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING__GLOBAL_VARIABLES,
				 MappingFactory.eINSTANCE.createGlobalAttribute()));
	}
	
	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		if(collection.size() == 1) {
			Object object = (Object) collection.iterator().next();
			if(object instanceof ComplexCondition) {
				return new BasicDragAndDropSetCommand(domain, (EObject) owner, 
						PamtramPackage.Literals.CONDITIONAL_ELEMENT__CONDITION_REF, object, 0);
			}
		}
		
		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}

}
