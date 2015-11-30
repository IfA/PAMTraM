/**
 */
package pamtram.metamodel.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.StyledString.Fragment;
import org.eclipse.emf.edit.provider.ViewerNotification;

import pamtram.metamodel.MetamodelFactory;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Section;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.impl.MetamodelPackageImpl;

/**
 * This is the item provider adapter for a {@link pamtram.metamodel.TargetSection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetSectionItemProvider extends TargetSectionClassItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionItemProvider(AdapterFactory adapterFactory) {
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

			addAbstractPropertyDescriptor(object);
			addExtendPropertyDescriptor(object);
			addReferencingMappingHintGroupsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Section_abstract_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Section_abstract_feature", "_UI_Section_type"),
				 MetamodelPackage.Literals.SECTION__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Extend feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addExtendPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_Section_extend_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Section_extend_feature", "_UI_Section_type"),
						MetamodelPackage.Literals.SECTION__EXTEND,
						true,
						false,
						true,
						null,
						null,
						null) 
		{

			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				TargetSection targetSection = (TargetSection) object;

				if(targetSection.getEClass() == null) {
					return new BasicEList<>();
				}

				Collection<TargetSection> values = (Collection<TargetSection>) super.getChoiceOfValues(object);
				Collection<TargetSection> ret = new BasicEList<>();

				for (TargetSection val : values) {
					// only abstract sections that have a matching eClass can be used as extended section
					if(val.isAbstract() && (val.getEClass() == targetSection.getEClass() || targetSection.getEClass().getEAllSuperTypes().contains(val.getEClass()))) {
						ret.add(val);
					}
				}

				return ret;
			}
		}
				);
	}

	/**
	 * This adds a property descriptor for the Referencing Mapping Hint Groups feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferencingMappingHintGroupsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TargetSection_referencingMappingHintGroups_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_TargetSection_referencingMappingHintGroups_feature", "_UI_TargetSection_type"),
				 MetamodelPackage.Literals.TARGET_SECTION__REFERENCING_MAPPING_HINT_GROUPS,
				 false,
				 false,
				 false,
				 null,
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
			childrenFeatures.add(MetamodelPackage.Literals.TARGET_SECTION__FILE);
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

	@Override
	protected Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {
		if(labelRelatedChildrenFeatures == null) {
			labelRelatedChildrenFeatures = new ArrayList<>();
			labelRelatedChildrenFeatures.add(MetamodelPackageImpl.eINSTANCE.getSection_Extend());
		}
		return labelRelatedChildrenFeatures;
	}

	/**
	 * This returns TargetSection.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return (((TargetSection) object).isAbstract() ? "<<abstract>> " : "") + super.getText(object);
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

		Section section = (Section) object;

		StyledString styledLabel = new StyledString();

		if(!section.isAbstract() || section.getName() == null || section.getName().isEmpty()) {
			styledLabel.append((StyledString) super.getStyledText(object));
		} else {
			Iterator<Fragment> it = ((StyledString) super.getStyledText(object)).iterator();
			while(it.hasNext()) {
				Fragment next = it.next();
				if(next.getString().equals(section.getName())) {
					// use the 'qualifier styler' for the label
					styledLabel.append(next.getString(), StyledString.Style.QUALIFIER_STYLER);
				} else {
					// every other fragment is added as is
					styledLabel.append(next.getString(), next.getStyle());
				}
			}
		}

		// add the 'extends'
		if(!section.getExtend().isEmpty()) {
			ArrayList<String> extend = new ArrayList<>();
			for (Object e : section.getExtend()) {
				extend.add(((Section) e).getName());
			}
			styledLabel.append(" -> " + String.join(", ", extend), StyledString.Style.DECORATIONS_STYLER);
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

		switch (notification.getFeatureID(TargetSection.class)) {
			case MetamodelPackage.TARGET_SECTION__ABSTRACT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case MetamodelPackage.TARGET_SECTION__FILE:
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
				(MetamodelPackage.Literals.TARGET_SECTION__FILE,
				 MetamodelFactory.eINSTANCE.createFileAttribute()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == MetamodelPackage.Literals.CLASS__ATTRIBUTES ||
			childFeature == MetamodelPackage.Literals.TARGET_SECTION__FILE;

		if (qualify) {
			if(childFeature == MetamodelPackage.Literals.TARGET_SECTION__FILE) {
				return "File Attribute";
			}
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
