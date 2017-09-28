/**
 */
package pamtram.mapping.provider;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.PamtramPackage;
import pamtram.condition.ConditionFactory;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.provider.DeactivatableElementItemProvider;
import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.target.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.MappingHintGroupImporter} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MappingHintGroupImporterItemProvider extends NamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MappingHintGroupImporterItemProvider(AdapterFactory adapterFactory) {

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

			this.addDeactivatedPropertyDescriptor(object);
			this.addSharedConditionPropertyDescriptor(object);
			this.addHintGroupPropertyDescriptor(object);
			this.addContainerPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Deactivated feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addDeactivatedPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_DeactivatableElement_deactivated_feature"),
				this.getString("_UI_DeactivatableElement_deactivated_description"),
				PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, this.getString("_UI_ExtendedPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Shared Condition feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addSharedConditionPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_ConditionalElement_sharedCondition_feature"),
						this.getString("_UI_ConditionalElement_sharedCondition_description"),
						PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION, true, false, true, null,
						this.getString("_UI_ExtendedPropertyCategory"), null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						Collection<?> choices = super.getChoiceOfValues(object);

						// Only allow to reference ConditionModel-conditions as
						// shared
						// conditions
						//
						return choices.stream()
								.filter(c -> c instanceof pamtram.condition.ComplexCondition
										&& ((pamtram.condition.ComplexCondition) c).isConditionModelCondition())
								.collect(Collectors.toList());
					}
				});
	}

	/**
	 * This adds a property descriptor for the Hint Group feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addHintGroupPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_MappingHintGroupImporter_hintGroup_feature"),
				this.getString("_UI_MappingHintGroupImporter_hintGroup_description"),
				MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__HINT_GROUP, true, false, true, null,
				this.getString("_UI_BasicPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Container feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected void addContainerPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_MappingHintGroupImporter_container_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_MappingHintGroupImporter_container_feature",
						"_UI_MappingHintGroupImporter_type"),
				MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__CONTAINER, true, false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				List<TargetSectionClass> choiceOfValues = new LinkedList<>();

				Mapping mapping = (Mapping) ((EObject) object).eContainer();

				for (MappingHintGroupType g : mapping.getMappingHintGroups()) {
					if (g.getTargetSection() != null && g instanceof MappingHintGroup) {
						choiceOfValues.add(g.getTargetSection());
						TreeIterator<EObject> it = g.getTargetSection().eAllContents();
						while (it.hasNext()) {
							EObject next = it.next();
							if (next instanceof TargetSectionClass) {
								choiceOfValues.add((TargetSectionClass) next);
							}
						}
					}
				}

				return choiceOfValues;
			}

		});
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
			this.childrenFeatures.add(PamtramPackage.Literals.CONDITIONAL_ELEMENT__LOCAL_CONDITION);
			this.childrenFeatures.add(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS);
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
	 * This returns MappingHintGroupImporter.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {

		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/MappingHintGroupImporter"));
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
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		MappingHintGroupImporter mhg = (MappingHintGroupImporter) object;
		String label = mhg.getName();

		StyledString styledLabel = new StyledString();
		if (label != null && label.length() >= 0) {
			styledLabel.append(label);
		}

		if (mhg.getHintGroup() != null) {
			styledLabel.append(" imports " + mhg.getHintGroup().getName(), StyledString.Style.DECORATIONS_STYLER);
		}

		return DeactivatableElementItemProvider.modifyLabelBasedOnActivationStatus(mhg, styledLabel);
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

		switch (notification.getFeatureID(MappingHintGroupImporter.class)) {
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__DEACTIVATED:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__LOCAL_CONDITION:
			case MappingPackage.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT due to addition of custom hints and custom sorting
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createAttributeMappingWithSource()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createAttributeMapping()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createCardinalityMapping()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createReferenceTargetSelector()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createContainerSelectorWithSource()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createContainerSelector()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createMappedAttributeValuePrepender()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createMappedAttributeValueAppender()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createExternalMappedAttributeValuePrepender()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_IMPORTER__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createExternalMappedAttributeValueAppender()));

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
	 * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {

		return PamtramEditPlugin.INSTANCE;
	}

}
