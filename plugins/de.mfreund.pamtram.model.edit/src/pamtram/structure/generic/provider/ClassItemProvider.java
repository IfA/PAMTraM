/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.generic.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.emf.EPackageHelper;
import de.tud.et.ifa.agtele.emf.XSDAnyContentUtil;
import pamtram.PAMTraM;
import pamtram.PamtramPackage;
import pamtram.SectionModel;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.library.ContainerParameter;
import pamtram.structure.source.SourceFactory;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAnyContentCompositeReference;
import pamtram.structure.target.TargetSectionAnyContentCrossReference;
import pamtram.structure.target.TargetSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.structure.generic.Class} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class ClassItemProvider extends MetaModelElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassItemProvider(AdapterFactory adapterFactory) {
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

			addEClassPropertyDescriptor(object);
			addCardinalityPropertyDescriptor(object);
			addContainerPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the EClass feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEClassPropertyDescriptor(Object object) {
		
		itemPropertyDescriptors
				.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Class_eClass_feature"),
						this.getString("_UI_Class_eClass_description", "_UI_Class_eClass_feature", "_UI_Class_type"),
						GenericPackage.Literals.CLASS__ECLASS, true, false, true, null,
						this.getString("_UI_BasicPropertyCategory"), null) {
		
					@Override
					public Collection<?> getChoiceOfValues(Object object) {
		
						pamtram.structure.generic.Class<?, ?, ?, ?> selectedClass = (pamtram.structure.generic.Class<?, ?, ?, ?>) object;
						Section<?, ?, ?, ?> containingSection = selectedClass.getContainingSection();
		
						/*
						 * If we have a container parameter with a specified source, we do not need to scan package
						 * contents. Instead, the user may only select the eClass of the specified source element.
						 */
						if (containingSection.eContainer() instanceof ContainerParameter
								&& ((ContainerParameter) containingSection.eContainer()).getSource() != null) {
							return Arrays
									.asList(((ContainerParameter) containingSection.eContainer()).getSource().eClass());
						}
		
						SectionModel<?, ?, ?, ?> containingSectionModel = containingSection.getContainingSectionModel();
		
						if (containingSectionModel.getMetaModelPackage() == null) {
							return Collections.emptyList();
						}
		
						boolean selectedClassIsSection = containingSection.equals(object);
		
						List<EClass> choiceOfValues = new ArrayList<>();
		
						List<SectionModel<?, ?, ?, ?>> sectionModelsToConsider = new ArrayList<>();
						if (AgteleEcoreUtil.hasAncestorOfKind(containingSection, PamtramPackage.Literals.PAM_TRA_M)) {
							if (containingSection instanceof SourceSection) {
								sectionModelsToConsider
										.addAll(((PAMTraM) AgteleEcoreUtil.getAncestorOfKind(containingSection,
												PamtramPackage.Literals.PAM_TRA_M)).getSourceSectionModels());
							} else if (containingSection instanceof TargetSection) {
								sectionModelsToConsider
										.addAll(((PAMTraM) AgteleEcoreUtil.getAncestorOfKind(containingSection,
												PamtramPackage.Literals.PAM_TRA_M)).getTargetSectionModels());
							}
						} else {
							sectionModelsToConsider.add((SectionModel<?, ?, ?, ?>) AgteleEcoreUtil
									.getAncestorOfKind(containingSection, PamtramPackage.Literals.SECTION_MODEL));
						}
		
						Set<EPackage> ePackagesOfSectionModelsToConsider = sectionModelsToConsider.stream()
								.map(SectionModel::getMetaModelPackage).collect(Collectors.toSet());
		
						Set<EPackage> packagesToScan = EPackageHelper.collectEPackages(
								ePackagesOfSectionModelsToConsider, true, true, !selectedClassIsSection,
								Optional.empty());
		
						for (EPackage pkg : packagesToScan) {
		
							EClass docroot = ExtendedMetaData.INSTANCE.getDocumentRoot(pkg);
		
							List<EClass> classesInPackage = pkg.getEClassifiers().stream()
									.filter(EClass.class::isInstance).map(EClass.class::cast)
									.collect(Collectors.toList());
							for (EClass eClass : classesInPackage) {
		
								// Do not consider DocRoot classes; Abstract EClasses are only allowed for
								// SourceSections or abstract TargetSections
								//
								if (!eClass.equals(docroot) && (!eClass.isAbstract()
										|| object instanceof SourceSectionClass
										|| object instanceof TargetSection && ((TargetSection) object).isAbstract())) {
									choiceOfValues.add(eClass);
								}
							}
						}
		
						if (selectedClassIsSection) { // top level-section
							return choiceOfValues;
						} else { // not a top-level section
							List<EClass> newChoiceOfValues = new LinkedList<>();
							Reference<?, ?, ?, ?> ref = (Reference<?, ?, ?, ?>) ((Class<?, ?, ?, ?>) object)
									.eContainer();
							if (ref instanceof ActualReference<?, ?, ?, ?>
									&& ((ActualReference<?, ?, ?, ?>) ref).getEReference() != null) {
								if (!(((ActualReference<?, ?, ?, ?>) ref).getEReference()
										.getEType() instanceof EClass)) {
									throw new RuntimeException(
											"Type checks can only be performed for instances of type 'EClass'");
								} else {
									EClass refClass = null;
		
									try {
										refClass = (EClass) ((ActualReference<?, ?, ?, ?>) ref).getEReference()
												.getEGenericType().getERawType();
									} catch (Exception e) {
										refClass = (EClass) ((ActualReference<?, ?, ?, ?>) ref).getEReference()
												.getEType();
									}
		
									if (EcorePackage.Literals.EOBJECT.equals(refClass)) {
										newChoiceOfValues.addAll(choiceOfValues);
									} else if (refClass != null) {
		
										for (EClass c : choiceOfValues) {
											if (refClass.isSuperTypeOf(c)) {
												newChoiceOfValues.add(c);
											}
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
	 * @generated NOT
	 */
	protected void addCardinalityPropertyDescriptor(Object object) {

		itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_Class_cardinality_feature"),
				object instanceof SourceSectionClass ? this.getString("_UI_SourceSectionClass_cardinality_description")
						: this.getString("_UI_TargetSectionClass_cardinality_description"),
				GenericPackage.Literals.CLASS__CARDINALITY, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, this.getString("_UI_BasicPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Container feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainerPropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(new ItemPropertyDescriptor(
						((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
						this.getString("_UI_Class_container_feature"),
						object instanceof SourceSectionClass ? this.getString("_UI_SourceSectionClass_container_description")
								: this.getString("_UI_TargetSectionClass_container_description"),
						GenericPackage.Literals.CLASS__CONTAINER, true, false, true, null,
						this.getString("_UI_ExtendedPropertyCategory"), null) {
		
				@Override
					public Collection<?> getChoiceOfValues(Object object) {
		
					List<Object> ret = new ArrayList<>();
		
					if (object instanceof Section<?, ?, ?, ?>) {
							ret = super.getChoiceOfValues(object).stream()
									.filter(o -> o instanceof pamtram.structure.generic.Class<?, ?, ?, ?>)
									.map(o -> (pamtram.structure.generic.Class<?, ?, ?, ?>) o)
									.filter(o -> o.getEClass().getEAllContainments().stream().anyMatch(
											c -> c.getEReferenceType().isSuperTypeOf(((pamtram.structure.generic.Class<?, ?, ?, ?>) object).getEClass())))
									.filter(o -> !o.getAllContainer().contains(object)).collect(Collectors.toList());
						} else {
		
						// For normal 'Classes', the container property is not relevant to the
							// user. If it is set, it has to point to the containing 'Class'...
							//
							if (((EObject) object).eContainer().eContainer() instanceof pamtram.structure.generic.Class<?, ?, ?, ?>) {
								ret.add(((EObject) object).eContainer().eContainer());
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(GenericPackage.Literals.CLASS__REFERENCES);
			childrenFeatures.add(GenericPackage.Literals.CLASS__ATTRIBUTES);
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
	 * This returns Class.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {

		Object baseImage = overlayImage(object, this.getResourceLocator().getImage("full/obj16/Class"));
		Object multiplicityImage = getMultiplicityImage((Class<?, ?, ?, ?>) object);

		return multiplicityImage == null ? baseImage
				: new DecoratedComposedImage(Arrays.asList(baseImage, multiplicityImage), 0, -2);
	}

	/**
	 * Returns an image representing the multiplicity of the {@link Class} that can be used as decoration image.
	 *
	 * @param object
	 * @return
	 */
	protected Object getMultiplicityImage(Class<?, ?, ?, ?> object) {

		Class<?, ?, ?, ?> clazz = object;

		String imageName = "full/obj16/EOccurrence";

		switch (clazz.getCardinality()) {
			case ONE:
				imageName += "One";
				break;
			case ONE_INFINITY:
				imageName += "OneToUnbounded";
				break;
			case ZERO_INFINITY:
				imageName += "ZeroToUnbounded";
				break;
			default:
				return null;
		}

		return EcoreEditPlugin.INSTANCE.getImage(imageName);
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
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> The label of the class is
	 * composed of its name and the name of the associated eClass. <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		String label = ((pamtram.structure.generic.Class<?, ?, ?, ?>) object).getName();
		EClass eClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) object).getEClass();

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
		updateChildren(notification);

		switch (notification.getFeatureID(pamtram.structure.generic.Class.class)) {
			case GenericPackage.CLASS__CARDINALITY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case GenericPackage.CLASS__REFERENCES:
			case GenericPackage.CLASS__ATTRIBUTES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		EClass eClass = object instanceof Class<?, ?, ?, ?> ? (eClass = ((Class<?, ?, ?, ?>) object).getEClass())
				: null;

		ActualReference<?, ?, ?, ?> ref = TargetFactory.eINSTANCE.createTargetSectionCompositeReference();
		if (eClass != null) {
			// Find a (containment) EReference for that there is not yet a
			// Reference defined
			// in the containing Class
			//
			Optional<EReference> eReference = eClass.getEAllContainments().stream()
					.filter(r -> !((Class<?, ?, ?, ?>) object).getActualReferences().stream()
							.map(actualRef -> ((ActualReference<?, ?, ?, ?>) actualRef).getEReference())
							.collect(java.util.stream.Collectors.toList()).contains(r))
					.findAny();
			if (eReference.isPresent()) {
				ref.setEReference(eReference.get());
			}

		}
		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__REFERENCES, ref));

		ref = TargetFactory.eINSTANCE.createTargetSectionCrossReference();
		if (eClass != null) {
			// Find a (non-containment) EReference for that there is not yet a
			// Reference defined
			// in the containing Class
			//
			Optional<EReference> eReference = eClass.getEAllReferences().stream()
					.filter(r -> !r.isContainment() && !((Class<?, ?, ?, ?>) object).getActualReferences().stream()
							.map(actualRef -> ((ActualReference<?, ?, ?, ?>) actualRef).getEReference())
							.collect(java.util.stream.Collectors.toList()).contains(r))
					.findAny();
			if (eReference.isPresent()) {
				ref.setEReference(eReference.get());
			}

		}
		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__REFERENCES, ref));

		ref = SourceFactory.eINSTANCE.createSourceSectionCompositeReference();
		if (eClass != null) {
			// Find a (containment) EReference for that there is not yet a
			// Reference defined
			// in the containing Class
			//
			Optional<EReference> eReference = eClass.getEAllContainments().stream()
					.filter(r -> !((Class<?, ?, ?, ?>) object).getActualReferences().stream()
							.map(actualRef -> ((ActualReference<?, ?, ?, ?>) actualRef).getEReference())
							.collect(java.util.stream.Collectors.toList()).contains(r))
					.findAny();
			if (eReference.isPresent()) {
				ref.setEReference(eReference.get());
			}

		}
		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__REFERENCES, ref));

		ref = SourceFactory.eINSTANCE.createSourceSectionCrossReference();
		if (eClass != null) {
			// Find a (non-containment) EReference for that there is not yet a
			// Reference defined
			// in the containing Class
			//
			Optional<EReference> eReference = eClass.getEAllReferences().stream()
					.filter(r -> !r.isContainment() && !((Class<?, ?, ?, ?>) object).getActualReferences().stream()
							.map(actualRef -> ((ActualReference<?, ?, ?, ?>) actualRef).getEReference())
							.collect(java.util.stream.Collectors.toList()).contains(r))
					.findAny();
			if (eReference.isPresent()) {
				ref.setEReference(eReference.get());
			}

		}
		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__REFERENCES, ref));

		/*
		 * A 'FileAttribute' must only be added as child of a 'TargetSection'
		 */
		// newChildDescriptors.add
		// (createChildParameter
		// (StructurePackage.Literals.CLASS__ATTRIBUTES,
		// StructureFactory.eINSTANCE.createFileAttribute()));

		ActualAttribute<?, ?, ?, ?> att = SourceFactory.eINSTANCE.createActualSourceSectionAttribute();
		if (eClass != null) {
			// Find an EAttribute for that there is not yet an Attribute defined
			// in the containing Class
			//
			Optional<EAttribute> eAttribute = eClass.getEAllAttributes().stream()
					.filter(a -> !((Class<?, ?, ?, ?>) object).getActualAttributes().stream()
							.map(actualAtt -> ((ActualAttribute<?, ?, ?, ?>) actualAtt).getAttribute())
							.collect(java.util.stream.Collectors.toList()).contains(a))
					.findAny();
			if (eAttribute.isPresent()) {
				att.setAttribute(eAttribute.get());
			}

		}
		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__ATTRIBUTES, att));

		att = TargetFactory.eINSTANCE.createActualTargetSectionAttribute();
		if (eClass != null) {
			// Find an EAttribute for that there is not yet an Attribute defined
			// in the containing Class
			//
			Optional<EAttribute> eAttribute = eClass.getEAllAttributes().stream()
					.filter(a -> !((Class<?, ?, ?, ?>) object).getActualAttributes().stream()
							.map(actualAtt -> ((ActualAttribute<?, ?, ?, ?>) actualAtt).getAttribute())
							.collect(java.util.stream.Collectors.toList()).contains(a))
					.findAny();
			if (eAttribute.isPresent()) {
				att.setAttribute(eAttribute.get());
			}

		}
		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__ATTRIBUTES, att));

		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__REFERENCES,
				SourceFactory.eINSTANCE.createVirtualSourceSectionCrossReference()));

		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__ATTRIBUTES,
				TargetFactory.eINSTANCE.createVirtualTargetSectionAttribute()));

		newChildDescriptors.add(createChildParameter(GenericPackage.Literals.CLASS__ATTRIBUTES,
				SourceFactory.eINSTANCE.createVirtualSourceSectionAttribute()));

		/*
		 * A 'TargetSectionAnyContent' reference must only be added as child of an appropriate 'TargetSectionClass'
		 */
		TargetSectionAnyContentCompositeReference anyContentCompositeRef = TargetFactory.eINSTANCE
				.createTargetSectionAnyContentCompositeReference();
		TargetSectionAnyContentCrossReference anyContentCrossRef = TargetFactory.eINSTANCE
				.createTargetSectionAnyContentCrossReference();
		if (eClass != null && object instanceof TargetSectionClass) {

			if (XSDAnyContentUtil.allowsAnyContent(((TargetSectionClass) object).getEClass())) {
				newChildDescriptors
						.add(createChildParameter(GenericPackage.Literals.CLASS__REFERENCES, anyContentCompositeRef));
				newChildDescriptors
						.add(createChildParameter(GenericPackage.Literals.CLASS__REFERENCES, anyContentCrossRef));
			}

		}

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
					command.append(new SetCommand(domain, owner, TargetPackage.Literals.TARGET_SECTION__FILE,
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
