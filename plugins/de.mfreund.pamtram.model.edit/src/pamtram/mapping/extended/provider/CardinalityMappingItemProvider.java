/**
 */
package pamtram.mapping.extended.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.DeactivatableElement;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.provider.DeactivatableElementItemProvider;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.source.SourceSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.extended.CardinalityMapping} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class CardinalityMappingItemProvider extends MappingHintItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CardinalityMappingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExpressionPropertyDescriptor(object);
			addModifiersPropertyDescriptor(object);
			addReferenceMatchSpecPropertyDescriptor(object);
			addFollowExternalReferencesPropertyDescriptor(object);
			addSourcePropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Expression feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addExpressionPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ExpressionElement_expression_feature"),
				this.getString("_UI_CardinalityMapping_expression_description"),
				PamtramPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, this.getString("_UI_ExtendedPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Modifiers feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addModifiersPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ModifiableElement_modifiers_feature"),
				this.getString("_UI_CardinalityMapping_modifiers_description"),
				PamtramPackage.Literals.MODIFIABLE_ELEMENT__MODIFIERS, true, false, true, null,
				this.getString("_UI_ExtendedPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Reference Match Spec feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferenceMatchSpecPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MatchSpecElement_referenceMatchSpec_feature"),
				 getString("_UI_MatchSpecElement_referenceMatchSpec_description"),
				 PamtramPackage.Literals.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_ExtendedPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Follow External References feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFollowExternalReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MatchSpecElement_followExternalReferences_feature"),
				 getString("_UI_MatchSpecElement_followExternalReferences_description"),
				 PamtramPackage.Literals.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ExtendedPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CardinalityMapping_source_feature"),
				 getString("_UI_CardinalityMapping_source_description"),
				 ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected void addSourcePropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_CardinalityMapping_source_feature"),
						this.getString("_UI_CardinalityMapping_source_description"),
						ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE, true, false, true, null,
						this.getString("_UI_BasicPropertyCategory"), null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						// the parent mapping
						Mapping mapping = null;
						if (((CardinalityMapping) object).eContainer() instanceof MappingHintGroupType) {
							mapping = (Mapping) ((MappingHintGroupType) ((CardinalityMapping) object).eContainer())
									.eContainer();
						} else if (((CardinalityMapping) object).eContainer() instanceof MappingHintGroupImporter) {
							mapping = (Mapping) ((MappingHintGroupImporter) ((CardinalityMapping) object).eContainer())
									.eContainer();
						}

						// the source section
						SourceSectionClass source = mapping.getSourceSection();

						List<Object> choiceOfValues = new ArrayList<>();

						// iterate over all elements and return the classes and
						// attributes
						// as possible options
						Set<SourceSectionClass> scanned = new HashSet<>();
						List<SourceSectionClass> sectionsToScan = new ArrayList<>();
						sectionsToScan.add(source);

						while (sectionsToScan.size() > 0) {
							SourceSectionClass classToScan = sectionsToScan.remove(0);
							scanned.add(classToScan);

							if (!classToScan.getCardinality().equals(CardinalityType.ONE)) {
								choiceOfValues.add(classToScan);
							}
							choiceOfValues.addAll(classToScan.getAttributes());
							choiceOfValues.addAll(classToScan.getReferences());

							Iterator<EObject> it = classToScan.eAllContents();
							while (it.hasNext()) {
								EObject next = it.next();
								if (next instanceof SourceSectionClass) {
									if (!((SourceSectionClass) next).getCardinality().equals(CardinalityType.ONE)) {
										choiceOfValues.add(next);
									}
									choiceOfValues.addAll(((SourceSectionClass) next).getAttributes());
									choiceOfValues.addAll(((SourceSectionClass) next).getReferences());
								} else if (next instanceof CrossReference) {
									List<SourceSectionClass> vals = new ArrayList<>();
									vals.addAll(((CrossReference) next).getValue());
									vals.removeAll(scanned);
									sectionsToScan.addAll(vals);
								}
							}
						}

						return choiceOfValues;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CardinalityMapping_target_feature"),
				 getString("_UI_CardinalityMapping_target_description"),
				 ExtendedPackage.Literals.CARDINALITY_MAPPING__TARGET,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_BasicPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected void addTargetPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_CardinalityMapping_target_feature"),
						this.getString("_UI_CardinalityMapping_target_description"),
						ExtendedPackage.Literals.CARDINALITY_MAPPING__TARGET, true, false, true, null,
						this.getString("_UI_BasicPropertyCategory"), null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						// the target section
						Class target = null;
						if (((CardinalityMapping) object).eContainer() instanceof MappingHintGroupType) {
							target = ((MappingHintGroupType) ((CardinalityMapping) object).eContainer())
									.getTargetSection();
						} else if (((CardinalityMapping) object).eContainer() instanceof MappingHintGroupImporter) {
							target = ((MappingHintGroupImporter) ((CardinalityMapping) object).eContainer())
									.getHintGroup().getTargetSection();
						}

						List<Object> choiceOfValues = new ArrayList<>();

						// is the target itself a possible option?
						if (target.getCardinality().getValue() != CardinalityType.ONE_VALUE) {
							choiceOfValues.add(target);
						}

						// iterate over all elements and return the attributes
						// as
						// possible options
						Iterator<EObject> it = target.eAllContents();
						while (it.hasNext()) {
							EObject next = it.next();
							if (next instanceof pamtram.structure.generic.Class
									&& ((pamtram.structure.generic.Class) next).getCardinality()
											.getValue() != CardinalityType.ONE_VALUE) {
								choiceOfValues.add(next);
							}
						}

						return choiceOfValues;
					}
				});
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE_ELEMENTS);
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
	 * This returns CardinalityMapping.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CardinalityMapping"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		CardinalityMapping cm = (CardinalityMapping) object;

		StyledString styledLabel = new StyledString();

		if (cm.getSource() != null) {
			styledLabel.append(cm.getSource().getName());
		}
		styledLabel.append(".cardinality", StyledString.Style.COUNTER_STYLER);
		styledLabel.append(" -> ", StyledString.Style.COUNTER_STYLER);
		if (cm.getTarget() != null) {
			styledLabel.append(cm.getTarget().getName());
		}
		styledLabel.append(".cardinality", StyledString.Style.COUNTER_STYLER);

		return DeactivatableElementItemProvider.modifyLabelBasedOnActivationStatus((DeactivatableElement) object,
				styledLabel);
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
		updateChildren(notification);

		switch (notification.getFeatureID(CardinalityMapping.class)) {
			case ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION:
			case ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE_ELEMENTS,
				 ExtendedFactory.eINSTANCE.createCardinalityMappingSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE_ELEMENTS,
				 ExtendedFactory.eINSTANCE.createCardinalityMappingExternalSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE_ELEMENTS,
				 ExtendedFactory.eINSTANCE.createCardinalityMappingGlobalSourceElement()));

		newChildDescriptors.add
			(createChildParameter
				(ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE_ELEMENTS,
				 PamtramFactory.eINSTANCE.createFixedValue()));
	}

}
