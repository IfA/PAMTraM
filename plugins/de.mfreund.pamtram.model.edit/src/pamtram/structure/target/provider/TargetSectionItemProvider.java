/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.target.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.StyledString.Fragment;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.tud.et.ifa.agtele.emf.edit.commands.BasicDragAndDropCompoundCommand;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Section;
import pamtram.structure.target.FileAttribute;
import pamtram.structure.target.TargetFactory;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;

/**
 * This is the item provider adapter for a {@link pamtram.structure.target.TargetSection} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class TargetSectionItemProvider extends TargetSectionClassItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionItemProvider(AdapterFactory adapterFactory) {
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

			addAbstractPropertyDescriptor(object);
			addExtendPropertyDescriptor(object);
			addReferencingMappingHintGroupsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Section_abstract_feature"),
				 getString("_UI_Section_abstract_description"),
				 GenericPackage.Literals.SECTION__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ExtendedPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Extend feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void addExtendPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Section_extend_feature"),
						this.getString("_UI_Section_extend_description"), GenericPackage.Literals.SECTION__EXTEND, true,
						false, true, null, this.getString("_UI_ExtendedPropertyCategory"), null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						TargetSection targetSection = (TargetSection) object;

						if (targetSection.getEClass() == null) {
							return new BasicEList<>();
						}

						Collection<TargetSection> ret = new BasicEList<>();

						for (Object v : super.getChoiceOfValues(object).stream()
								.filter(e -> !e.equals(object) && !((TargetSection) e).getAllExtend().contains(object))
								.collect(Collectors.toList())) {

							TargetSection val = (TargetSection) v;
							// only abstract sections that have a matching
							// eClass can be used as extended section
							if (val.isAbstract() && (val.getEClass() == targetSection.getEClass()
									|| targetSection.getEClass().getEAllSuperTypes().contains(val.getEClass()))) {
								ret.add(val);
							}
						}

						return ret;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Referencing Mapping Hint Groups feature.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void addReferencingMappingHintGroupsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TargetSection_referencingMappingHintGroups_feature"),
				 getString("_UI_TargetSection_referencingMappingHintGroups_description"),
				 TargetPackage.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_InfoPropertyCategory"),
				 null));
	}

	@Override
	protected Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {

		if (this.labelRelatedChildrenFeatures == null) {
			this.labelRelatedChildrenFeatures = new ArrayList<>();
			this.labelRelatedChildrenFeatures.add(GenericPackage.eINSTANCE.getSection_Extend());
		}
		return this.labelRelatedChildrenFeatures;
	}

	/**
	 * This returns TargetSection.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {

		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {

		return (((TargetSection) object).isAbstract() ? "<<abstract>> " : "") + super.getText(object);
	}

	/**
	 * This returns the label styled text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		this.initializeLabelRelatedChildrenFeatureNotifications(object);

		Section section = (Section) object;

		StyledString styledLabel = new StyledString();

		if (!section.isAbstract() || section.getName() == null || section.getName().isEmpty()) {
			styledLabel.append((StyledString) super.getStyledText(object));
		} else {
			Iterator<Fragment> it = ((StyledString) super.getStyledText(object)).iterator();
			while (it.hasNext()) {
				Fragment next = it.next();
				if (next.getString().equals(section.getName())) {
					// use the 'qualifier styler' for the label
					styledLabel.append(next.getString(), StyledString.Style.QUALIFIER_STYLER);
				} else {
					// every other fragment is added as is
					styledLabel.append(next.getString(), next.getStyle());
				}
			}
		}

		// add the 'extends'
		if (!section.getExtend().isEmpty()) {
			ArrayList<String> extend = new ArrayList<>();
			for (Object e : section.getExtend()) {
				extend.add(((Section) e).getName());
			}
			styledLabel.append(" -> " + String.join(", ", extend), StyledString.Style.DECORATIONS_STYLER);
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
		updateChildren(notification);

		switch (notification.getFeatureID(TargetSection.class)) {
			case TargetPackage.TARGET_SECTION__ABSTRACT:
			case TargetPackage.TARGET_SECTION__FILE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
				(TargetPackage.Literals.TARGET_SECTION__FILE,
				 TargetFactory.eINSTANCE.createFileAttribute()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {

		// Object childFeature = feature;
		// Object childObject = child;
		//
		// boolean qualify =
		// childFeature == StructurePackage.Literals.CLASS__ATTRIBUTES ||
		// childFeature == StructurePackage.Literals.TARGET_SECTION__FILE;
		//
		// if (qualify) {
		// return getString
		// ("_UI_CreateChild_text2",
		// new Object[] { getTypeText(childObject),
		// getFeatureText(childFeature), getTypeText(owner) });
		// }
		return super.getCreateChildText(owner, feature, child, selection);
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {

		/*
		 * If a 'FileAttribute' is added, we also need to set the 'file' reference.
		 */
		if (feature == GenericPackage.Literals.CLASS__ATTRIBUTES) {
			for (Object object : collection) {
				if (object instanceof FileAttribute && owner instanceof TargetSection) {
					if (((TargetSection) owner).getFile() == null) {
						CompoundCommand command = new CompoundCommand();
						command.append(new AddCommand(domain, owner, feature, collection, index));
						command.append(
								new SetCommand(domain, owner, TargetPackage.Literals.TARGET_SECTION__FILE, object));
						return command;
					} else {
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
		}
		return super.createAddCommand(domain, owner, feature, collection, index);
	}

	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Object value) {

		/*
		 * If a 'FileAttribute' is created, we also need to add it to the 'attributes' reference.
		 */
		if (feature == TargetPackage.Literals.TARGET_SECTION__FILE) {
			if (value.equals(SetCommand.UNSET_VALUE)) {
				CompoundCommand command = new CompoundCommand();
				if (((EList<Object>) owner.eGet(GenericPackage.Literals.CLASS__ATTRIBUTES)).contains(value)) {
					command.append(new RemoveCommand(domain, owner, GenericPackage.Literals.CLASS__ATTRIBUTES, value));
				}
				command.append(new SetCommand(domain, owner, feature, SetCommand.UNSET_VALUE));
				return command;
			} else {
				CompoundCommand command = new CompoundCommand();
				command.append(new AddCommand(domain, owner, GenericPackage.Literals.CLASS__ATTRIBUTES, value));
				command.append(new SetCommand(domain, owner, feature, value));
				return command;
			}
		}
		return super.createSetCommand(domain, owner, feature, value);
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {

		/*
		 * If a 'FileAttribute' is dragged, we also need to remove the 'file' from the old owner and set the 'file'
		 * reference in the new owner..
		 */
		Collection<Object> collectionWithoutFile = new ArrayList<>();
		FileAttribute file = null;

		for (Object object : collection) {
			if (object instanceof FileAttribute) {
				file = (FileAttribute) object;
			} else {
				collectionWithoutFile.add(object);
			}
		}

		if (file == null) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}

		if (owner instanceof TargetSection && ((TargetSection) owner).getFile() != null) {
			return UnexecutableCommand.INSTANCE;
		}

		BasicDragAndDropCompoundCommand command = new BasicDragAndDropCompoundCommand();
		command.append(
				super.createDragAndDropCommand(domain, owner, location, operations, operation, collectionWithoutFile));
		command.append(this.createRemoveCommand(domain, file.eContainer(), GenericPackage.Literals.CLASS__ATTRIBUTES,
				Arrays.asList(file)));
		command.append(
				this.createSetCommand(domain, (EObject) owner, TargetPackage.Literals.TARGET_SECTION__FILE, file));
		return command;
	}

}
