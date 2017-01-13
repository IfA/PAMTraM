/**
 */
package pamtram.structure.generic.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.SectionModel;
import pamtram.structure.ContainerParameter;
import pamtram.structure.FileAttribute;
import pamtram.structure.StructureFactory;
import pamtram.structure.StructurePackage;
import pamtram.structure.TargetSection;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceFactory;

/**
 * This is the item provider adapter for a {@link pamtram.structure.generic.Class} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ClassItemProvider extends MetaModelElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ClassItemProvider(AdapterFactory adapterFactory) {
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

			this.addEClassPropertyDescriptor(object);
			this.addCardinalityPropertyDescriptor(object);
			this.addContainerPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the EClass feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addEClassPropertyDescriptorGen(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_Class_eClass_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_Class_eClass_feature", "_UI_Class_type"),
				GenericPackage.Literals.CLASS__ECLASS, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the EClass feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected void addEClassPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Class_eClass_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_Class_eClass_feature",
								"_UI_Class_type"),
						GenericPackage.Literals.CLASS__ECLASS, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						Class section = ((pamtram.structure.generic.Class) object).getContainingSection();
						SectionModel sectionModel = section.getContainingSectionModel();

						List<EClass> choiceOfValues = new LinkedList<>();

						/*
						 * If we have a container parameter with a specified source, we do not need to scan package
						 * contents. Instead, the user may only select the eClass of the specified source element.
						 */
						if (section.eContainer() instanceof ContainerParameter
								&& ((ContainerParameter) section.eContainer()).getSource() != null) {
							choiceOfValues.add(((ContainerParameter) section.eContainer()).getSource().eClass());
							return choiceOfValues;
						}

						List<EPackage> packagesToScan = new LinkedList<>();

						packagesToScan.add(sectionModel.getMetaModelPackage());

						List<EClass> documentRoot = new LinkedList<>();// this should only contain one element but we
																		// need to implement this in a generic way...

						while (packagesToScan.size() > 0) {
							EPackage pkg = packagesToScan.remove(0);
							EClass docroot = ExtendedMetaData.INSTANCE.getDocumentRoot(pkg);
							if (docroot != null) {
								documentRoot.add(docroot);
							}

							packagesToScan.addAll(pkg.getESubpackages());
							for (EClassifier c : pkg.getEClassifiers()) {
								if (c instanceof EClass) {
									EClass cl = (EClass) c;
									if (!documentRoot.contains(cl)) {
										// abstract EClasses are only allowed for abstract sections
										if (!cl.isAbstract() || object instanceof Section<?, ?, ?, ?>
												&& ((Section<?, ?, ?, ?>) object).isAbstract()) {
											choiceOfValues.add((EClass) c);
										}
									}
								}
							}
						}

						if (section.equals(object)) { // top level-section
							return choiceOfValues;
						} else { // not a top-level section
							List<EClass> newChoiceOfValues = new LinkedList<>();
							pamtram.structure.generic.Reference ref = (Reference) ((pamtram.structure.generic.Class) object)
									.eContainer();
							if (ref.getEReference() != null) {
								if (!(ref.getEReference().getEType() instanceof EClass)) {
									throw new RuntimeException(
											"Type checks can only be performed for instances of type 'EClass'");
								} else {
									EClass refClass = (EClass) ref.getEReference().getEType();

									for (EClass c : choiceOfValues) {
										if (refClass.isSuperTypeOf(c)) {
											newChoiceOfValues.add(c);
										}
									}
									return newChoiceOfValues;

								}

							}

						}
						return super.getChoiceOfValues(object);
					}

				});
	}

	/**
	 * This adds a property descriptor for the Cardinality feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addCardinalityPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this
				.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Class_cardinality_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_Class_cardinality_feature",
								"_UI_Class_type"),
						GenericPackage.Literals.CLASS__CARDINALITY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Container feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addContainerPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_Class_container_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_Class_container_feature", "_UI_Class_type"),
				GenericPackage.Literals.CLASS__CONTAINER, true, false, true, null, null, null));
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
			this.childrenFeatures.add(GenericPackage.Literals.CLASS__REFERENCES);
			this.childrenFeatures.add(GenericPackage.Literals.CLASS__ATTRIBUTES);
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
	 * This returns Class.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {

		return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/Class"));
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
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> The label of the class is
	 * composed of its name and the name of the associated eClass. <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((pamtram.structure.generic.Class) object).getName();
		EClass eClass = ((pamtram.structure.generic.Class) object).getEClass();

		StyledString styledLabel = new StyledString();

		if (label != null && label.length() > 0) {
			styledLabel.append(label);
		}

		if (eClass != null && eClass.getEPackage() != null) {
			styledLabel.append(
					styledLabel.toString().equals("")
							? "(" + eClass.getEPackage().getNsPrefix() + "::" + eClass.getName() + ")"
							: " (" + eClass.getEPackage().getNsPrefix() + "::" + eClass.getName() + ")",
					StyledString.Style.QUALIFIER_STYLER);
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
	@Override
	public void notifyChanged(Notification notification) {

		this.updateChildren(notification);

		switch (notification.getFeatureID(pamtram.structure.generic.Class.class)) {
			case GenericPackage.CLASS__CARDINALITY:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GenericPackage.CLASS__REFERENCES:
			case GenericPackage.CLASS__ATTRIBUTES:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
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

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.CLASS__REFERENCES,
				StructureFactory.eINSTANCE.createTargetSectionCompositeReference()));

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.CLASS__REFERENCES,
				StructureFactory.eINSTANCE.createTargetSectionCrossReference()));

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.CLASS__REFERENCES,
				SourceFactory.eINSTANCE.createSourceSectionCompositeReference()));

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.CLASS__REFERENCES,
				SourceFactory.eINSTANCE.createSourceSectionCrossReference()));

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.CLASS__ATTRIBUTES,
				StructureFactory.eINSTANCE.createVirtualTargetSectionAttribute()));

		/*
		 * A 'FileAttribute' must only be added as child of a 'TargetSection'
		 */
		// newChildDescriptors.add
		// (createChildParameter
		// (StructurePackage.Literals.CLASS__ATTRIBUTES,
		// StructureFactory.eINSTANCE.createFileAttribute()));

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.CLASS__ATTRIBUTES,
				SourceFactory.eINSTANCE.createActualSourceSectionAttribute()));

		newChildDescriptors.add(this.createChildParameter(GenericPackage.Literals.CLASS__ATTRIBUTES,
				StructureFactory.eINSTANCE.createActualTargetSectionAttribute()));
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {

		/*
		 * We must not add a 'FileAttribute' to anything but a TargetSection.
		 */
		if (feature == GenericPackage.Literals.CLASS__ATTRIBUTES) {
			for (Object object : collection) {
				if (object instanceof FileAttribute && !(owner instanceof TargetSection)) {
					/*
					 * Do not override the 'file' if there already is one
					 */
					Collection<Object> collectionWithoutFile = new ArrayList<>();
					collectionWithoutFile.addAll(collection);
					collectionWithoutFile.remove(object);
					return super.createAddCommand(domain, owner, feature, collectionWithoutFile, index);
				}
			}
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EReference feature,
			Collection<?> collection) {

		/*
		 * If a 'FileAttribute' is removed, we also need to reset the 'file' reference.
		 */
		if (feature == GenericPackage.Literals.CLASS__ATTRIBUTES) {
			for (Object object : collection) {
				if (object instanceof FileAttribute && owner instanceof TargetSection) {
					CompoundCommand command = new CompoundCommand();
					command.append(new SetCommand(domain, owner, StructurePackage.Literals.TARGET_SECTION__FILE,
							SetCommand.UNSET_VALUE));
					command.append(super.createRemoveCommand(domain, owner, feature, collection));
					return command;
				}
			}
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		/*
		 * 'FileAttributes' may not be dragged onto a class.
		 */
		for (Object object : collection) {
			if (object instanceof FileAttribute) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
	}
}
