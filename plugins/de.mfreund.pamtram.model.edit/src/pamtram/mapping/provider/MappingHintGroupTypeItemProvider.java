/**
 */
package pamtram.mapping.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMatcher;
import pamtram.mapping.extended.ClassMatcher;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.MappingHintGroupType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingHintGroupTypeItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MappingHintGroupTypeItemProvider(AdapterFactory adapterFactory) {
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

			addTargetSectionPropertyDescriptor(object);
			addExtendPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target Section feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addTargetSectionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MappingHintGroupType_targetSection_feature"),
				 getString("_UI_MappingHintGroupType_targetSection_description"),
				 MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__TARGET_SECTION,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Extend feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addExtendPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_MappingHintGroupType_extend_feature"),
						this.getString("_UI_MappingHintGroupType_extend_description"),
						MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__EXTEND, true, false, true, null,
						this.getString("_UI_ExtendedPropertyCategory"), null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						MappingHintGroupType mhg = (MappingHintGroupType) object;

						if (mhg.getTargetSection() == null) {
							return new BasicEList<EObject>();
						}

						Collection<MappingHintGroupType> values = (Collection<MappingHintGroupType>) super.getChoiceOfValues(
								object);
						Collection<MappingHintGroupType> ret = new BasicEList<>();

						Mapping mhgMapping = (Mapping) mhg.eContainer();
						for (MappingHintGroupType val : values) {

							Mapping abstractMapping = (Mapping) val.eContainer();

							// only hint groups from other mappings can be used
							// for extension
							if (mhgMapping.equals(abstractMapping)) {
								continue;
							}

							// only hint groups in abstract mappings can be used
							if (!abstractMapping.isAbstract()) {
								continue;
							}

							// additionally, the source section need to match or
							// be connected via an 'extend' reference
							if (!(mhgMapping.getSourceSection().equals(abstractMapping.getSourceSection()) || mhgMapping
									.getSourceSection().getExtend().contains(abstractMapping.getSourceSection()))) {
								continue;
							}

							// finally, the target sections of the hint groups
							// need to 'extend', too
							if (mhg.getTargetSection().equals(val.getTargetSection())
									|| mhg.getTargetSection().getExtend().contains(val.getTargetSection())) {
								ret.add(val);
							}
						}

						return ret;
					}
				});
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
			childrenFeatures.add(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS);
		}
		return childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if (this.labelRelatedChildrenFeatures == null) {
			this.labelRelatedChildrenFeatures = new ArrayList<>();
			this.labelRelatedChildrenFeatures.add(MappingPackage.eINSTANCE.getMappingHintGroupType_Extend());
		}
		return this.labelRelatedChildrenFeatures;
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

		this.initializeLabelRelatedChildrenFeatureNotifications(object);

		MappingHintGroupType mhg = (MappingHintGroupType) object;
		String label = mhg.getName();

		StyledString styledLabel = new StyledString();
		if (label != null && label.length() >= 0) {
			styledLabel.append(label);
		}

		// add the 'extends'
		if (!mhg.getExtend().isEmpty()) {
			ArrayList<String> extend = new ArrayList<>();
			for (Object e : mhg.getExtend()) {
				extend.add(((MappingHintGroupType) e).getName());
			}
			styledLabel.append(" -> " + String.join(", ", extend), StyledString.Style.DECORATIONS_STYLER);
		}

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MappingHintGroupType.class)) {
			case MappingPackage.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	@Override
	public void notifyChanged(Notification notification) {
		this.handleLabelRelatedChildrenFeatureChangeNotification(notification);
		this.notifyChangedGen(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void collectNewChildDescriptorsGen(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 ExtendedFactory.eINSTANCE.createAttributeMapping()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 ExtendedFactory.eINSTANCE.createCardinalityMapping()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 ExtendedFactory.eINSTANCE.createReferenceTargetSelector()));

		newChildDescriptors.add
			(createChildParameter
				(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
				 ExtendedFactory.eINSTANCE.createContainerSelector()));
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createAttributeMappingWithSource()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createAttributeMapping()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createCardinalityMapping()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createMappingInstanceSelectorWithClassMatcher()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createMappingInstanceSelectorWithAttributeMatcher()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createReferenceTargetSelector()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createContainerSelectorWithSourceAndTarget()));

		newChildDescriptors
				.add(this.createChildParameter(MappingPackage.Literals.MAPPING_HINT_GROUP_TYPE__MAPPING_HINTS,
						ExtendedFactory.eINSTANCE.createContainerSelector()));

	}

	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {

		// provide labels for the custom child descriptors
		if (child instanceof AttributeMapping) {
			AttributeMapping attributeMapping = (AttributeMapping) child;
			if (!attributeMapping.getSourceElements().isEmpty()) {
				return super.getCreateChildText(owner, feature, child, selection) + " (incl. Source Attribute)";
			}
		} else if (child instanceof ReferenceTargetSelector) {
			ReferenceTargetSelector mappingInstanceSelector = (ReferenceTargetSelector) child;
			if (mappingInstanceSelector.getMatcher() instanceof ClassMatcher) {
				return super.getCreateChildText(owner, feature, child, selection) + " (incl. Class Matcher)";
			} else if (mappingInstanceSelector.getMatcher() instanceof AttributeMatcher) {
				return super.getCreateChildText(owner, feature, child, selection) + " (incl. Attribute Matcher)";
			}
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
