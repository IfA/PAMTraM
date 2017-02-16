/**
 */
package pamtram.structure.constraint.provider;

import java.util.Arrays;
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
import pamtram.MappingModel;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.condition.ConditionPackage;
import pamtram.mapping.MappingFactory;
import pamtram.mapping.MappingPackage;
import pamtram.provider.NamedElementItemProvider;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.StructureFactory;
import pamtram.structure.constraint.ConstraintFactory;
import pamtram.structure.constraint.ConstraintPackage;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.source.SourcePackage;

/**
 * This is the item provider adapter for a {@link pamtram.structure.constraint.SingleReferenceValueConstraint} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class SingleReferenceValueConstraintItemProvider extends NamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SingleReferenceValueConstraintItemProvider(AdapterFactory adapterFactory) {
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

			this.addTypePropertyDescriptor(object);
			this.addExpressionPropertyDescriptor(object);
			this.addResultModifierPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ValueConstraint_type_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_ValueConstraint_type_feature",
						"_UI_ValueConstraint_type"),
				ConstraintPackage.Literals.VALUE_CONSTRAINT__TYPE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Expression feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExpressionPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ExpressionElement_expression_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_ExpressionElement_expression_feature",
						"_UI_ExpressionElement_type"),
				PamtramPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Result Modifier feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addResultModifierPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_ModifiableElement_resultModifier_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_ModifiableElement_resultModifier_feature",
						"_UI_ModifiableElement_type"),
				PamtramPackage.Literals.MODIFIABLE_ELEMENT__RESULT_MODIFIER, true, false, true, null, null, null));
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
			this.childrenFeatures.add(
					ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION);
			this.childrenFeatures.add(ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS);
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

	@Override
	public Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {

		/*
		 * we do not need to add the 'expression' feature here as notifications for this attribute are already generated
		 * automatically as its 'Notify' property in the genmodel is set to 'true'
		 */
		return Arrays.asList(ConstraintPackage.eINSTANCE.getSingleReferenceValueConstraint_SourceElements());

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
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((SingleReferenceValueConstraint) object).getName();
		StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(this.getString("_UI_SingleReferenceValueConstraint_type"),
					StyledString.Style.QUALIFIER_STYLER);
		} else {
			styledLabel.append(this.getString("_UI_SingleReferenceValueConstraint_type"),
					StyledString.Style.QUALIFIER_STYLER).append(" " + label);
		}
		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {

		this.updateChildren(notification);

		switch (notification.getFeatureID(SingleReferenceValueConstraint.class)) {
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__TYPE:
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__EXPRESSION:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION:
			case ConstraintPackage.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS:
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
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
	 * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);

		if (!(object instanceof EObject)) {
			return;
		}

		// Do not allow to add InstancePointers below SourceSectionAttributes as these are only supported as part of
		// Conditions
		//
		if (!AgteleEcoreUtil.hasAncestorOfKind((EObject) object,
				SourcePackage.eINSTANCE.getActualSourceSectionAttribute())) {

			newChildDescriptors.add(this.createChildParameter(
					ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__CONSTRAINT_REFERENCE_VALUE_ADDITIONAL_SPECIFICATION,
					StructureFactory.eINSTANCE.createInstanceSelector()));
		}

		// Do not allow to add local/external source attributes or GlobalAttributeImporters below
		// SourceSectionAttributes as these are only supported as part of Conditions
		//
		if (!AgteleEcoreUtil.hasAncestorOfKind((EObject) object,
				SourcePackage.eINSTANCE.getActualSourceSectionAttribute())) {

			// Do not allow to add local/external source attributes below
			// Conditions that are located inside a ConditionModel or that are MappingModel conditions
			//
			ComplexCondition condition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind((EObject) object,
					ConditionPackage.eINSTANCE.getComplexCondition());
			if (condition == null
					|| !condition.isConditionModelCondition() && !(condition.eContainer() instanceof MappingModel)) {

				newChildDescriptors.add(this.createChildParameter(
						ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
						ConstraintFactory.eINSTANCE.createValueConstraintSourceElement()));

				newChildDescriptors.add(this.createChildParameter(
						ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
						ConstraintFactory.eINSTANCE.createValueConstraintExternalSourceElement()));

			}

			// Do not allow to add global attribute importers below
			// Conditions that are MappingModel conditions
			//
			if (condition == null || !(condition.eContainer() instanceof MappingModel)) {
				newChildDescriptors.add(this.createChildParameter(
						ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
						MappingFactory.eINSTANCE.createGlobalAttributeImporter()));
			}
		}

		newChildDescriptors.add(
				this.createChildParameter(ConstraintPackage.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS,
						MappingFactory.eINSTANCE.createFixedValue()));
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

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {

		if (feature
				.equals(ConstraintPackage.eINSTANCE
						.getSingleReferenceValueConstraint_ConstraintReferenceValueAdditionalSpecification())
				&& !AgteleEcoreUtil.hasAncestorOfKind(owner, MappingPackage.eINSTANCE.getMapping())
				&& !collection.parallelStream().allMatch(s -> s instanceof pamtram.mapping.FixedValue)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}

	@Override
	public AbstractCommand createDragAndDropCommand(EditingDomain domain, Collection<EObject> collection,
			EObject parent, EReference ref) {

		if (ref.equals(ConstraintPackage.eINSTANCE
				.getSingleReferenceValueConstraint_ConstraintReferenceValueAdditionalSpecification())
				&& !AgteleEcoreUtil.hasAncestorOfKind(parent, MappingPackage.eINSTANCE.getMapping())
				&& !collection.parallelStream().allMatch(s -> s instanceof pamtram.mapping.FixedValue)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.createDragAndDropCommand(domain, collection, parent, ref);
	}

}
