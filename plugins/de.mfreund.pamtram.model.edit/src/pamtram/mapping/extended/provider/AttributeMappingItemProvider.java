/**
 */
package pamtram.mapping.extended.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

import de.tud.et.ifa.agtele.emf.edit.ICommandSelectionStrategy;
import pamtram.DeactivatableElement;
import pamtram.PamtramFactory;
import pamtram.PamtramPackage;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
import pamtram.mapping.extended.ExtendedFactory;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.provider.DeactivatableElementItemProvider;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * This is the item provider adapter for a
 * {@link pamtram.mapping.extended.AttributeMapping} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class AttributeMappingItemProvider extends MappingHintItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public AttributeMappingItemProvider(AdapterFactory adapterFactory) {
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

			this.addExpressionPropertyDescriptor(object);
			this.addModifiersPropertyDescriptor(object);
			this.addTargetPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Target feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addTargetPropertyDescriptorGen(Object object) {
		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_AttributeMapping_target_feature"),
				this.getString("_UI_AttributeMapping_target_description"),
				ExtendedPackage.Literals.ATTRIBUTE_MAPPING__TARGET, true, false, true, null,
				this.getString("_UI_BasicPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Target feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_AttributeMapping_target_feature"),
						this.getString("_UI_AttributeMapping_target_description"),
						ExtendedPackage.Literals.ATTRIBUTE_MAPPING__TARGET, true, false, true, null,
						this.getString("_UI_BasicPropertyCategory"), null) {
					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						AttributeMapping attrMapping = (AttributeMapping) object;

						// the target section
						TargetSection target = null;
						if (attrMapping.eContainer() instanceof MappingHintGroupType) {
							target = ((MappingHintGroupType) attrMapping.eContainer()).getTargetSection();
						} else if (attrMapping.eContainer() instanceof MappingHintGroupImporter) {
							target = ((MappingHintGroupImporter) attrMapping.eContainer()).getHintGroup()
									.getTargetSection();
						}

						if (target == null) {
							return new ArrayList<>();
						}

						List<Object> choiceOfValues = new ArrayList<>();

						if (target.isLibraryEntry() && target.eContainer().eContainer() instanceof LibraryEntry) {

							LibraryEntry libEntry = (LibraryEntry) target.eContainer().eContainer();
							choiceOfValues.addAll(libEntry.getParameters().parallelStream()
									.filter(p -> p instanceof pamtram.structure.library.AttributeParameter)
									.map(p -> ((pamtram.structure.library.AttributeParameter) p).getAttribute())
									.collect(Collectors.toList()));
							choiceOfValues.addAll(libEntry.getResourceParameters().parallelStream()
									.map(p -> p.getAttribute()).collect(Collectors.toList()));

						} else {

							// We can use all of the original 'choice of values'
							// that are part of the referenced TargetSection or
							// any of the sections that this extends
							//
							List<TargetSection> validTargetSections = new ArrayList<>(Arrays.asList(target));
							validTargetSections.addAll(target.getAllExtend());

							choiceOfValues = super.getChoiceOfValues(object).stream()
									.filter(c -> c instanceof TargetSectionAttribute
											&& EcoreUtil.isAncestor(validTargetSections, (EObject) c))
									.collect(Collectors.toList());

						}

						return choiceOfValues;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Expression feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addExpressionPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ExpressionElement_expression_feature"),
				this.getString("_UI_AttributeMapping_expression_description"),
				PamtramPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, this.getString("_UI_ExtendedPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Modifiers feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addModifiersPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ModifiableElement_modifiers_feature"),
				this.getString("_UI_AttributeMapping_modifiers_description"),
				PamtramPackage.Literals.MODIFIABLE_ELEMENT__MODIFIERS, true, false, true, null,
				this.getString("_UI_ExtendedPropertyCategory"), null));
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
			this.childrenFeatures.add(ExtendedPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS);
		}
		return this.childrenFeatures;
	}

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if (this.labelRelatedChildrenFeatures == null) {
			this.labelRelatedChildrenFeatures = new ArrayList<>();
			this.labelRelatedChildrenFeatures.add(ExtendedPackage.eINSTANCE.getAttributeMapping_SourceElements());
			this.labelRelatedChildrenFeatures.add(ExtendedPackage.eINSTANCE.getAttributeMapping_Target());
			/*
			 * we do not need to add the 'expression' feature here as
			 * notifications for this attribute are already generated
			 * automatically as its 'Notify' property in the genmodel is set to
			 * 'true'
			 */
		}
		return this.labelRelatedChildrenFeatures;
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
	 * This returns AttributeMapping.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/AttributeMapping"));
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
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		this.initializeLabelRelatedChildrenFeatureNotifications(object);

		AttributeMapping am = (AttributeMapping) object;
		StyledString styledLabel = new StyledString();

		String label = am.getName();
		if ((label == null || label.isEmpty()) && am.getTarget() != null) {
			label = am.getTarget().getName();
		}

		if (label != null) {
			styledLabel.append(label);
		}

		if (am.getExpression() != null && !am.getExpression().isEmpty()) {
			styledLabel.append(" = " + am.getExpression(), StyledString.Style.COUNTER_STYLER);
		} else {
			ArrayList<String> sources = new ArrayList<>();
			for (AttributeMappingSourceInterface source : am.getSourceElements()) {
				sources.add(source.getName());
				// registerNotifyChangedListener(am, source, adapterFactory);
			}
			styledLabel.append(" = " + String.join(" + ", sources), StyledString.Style.COUNTER_STYLER);
		}

		return DeactivatableElementItemProvider.modifyLabelBasedOnActivationStatus((DeactivatableElement) object,
				styledLabel);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		this.updateChildren(notification);

		switch (notification.getFeatureID(AttributeMapping.class)) {
		case ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION:
			this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ExtendedPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS:
			this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(this.createChildParameter(ExtendedPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				ExtendedFactory.eINSTANCE.createGlobalAttributeImporter()));

		newChildDescriptors.add(this.createChildParameter(ExtendedPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				ExtendedFactory.eINSTANCE.createAttributeMappingSourceElement()));

		newChildDescriptors.add(this.createChildParameter(ExtendedPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				ExtendedFactory.eINSTANCE.createAttributeMappingExternalSourceElement()));

		newChildDescriptors.add(this.createChildParameter(ExtendedPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				ExtendedFactory.eINSTANCE.createAttributeMappingGlobalSourceElement()));

		newChildDescriptors.add(this.createChildParameter(ExtendedPackage.Literals.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS,
				PamtramFactory.eINSTANCE.createFixedValue()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.tud.et.ifa.agtele.emf.edit.IDragAndDropProvider#
	 * createCustomDragAndDropCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * java.lang.Object, float, int, int, java.util.Collection,
	 * de.tud.et.ifa.agtele.emf.edit.ICommandSelectionStrategy)
	 */
	@Override
	public Command createCustomDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection, ICommandSelectionStrategy strategy) {
		// TODO Auto-generated method stub
		return super.createCustomDragAndDropCommand(domain, owner, location, operations, operation, collection,
				strategy);
	}
}
