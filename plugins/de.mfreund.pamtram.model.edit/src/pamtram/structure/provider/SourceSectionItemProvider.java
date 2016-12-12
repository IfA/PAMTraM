/**
 */
package pamtram.structure.provider;

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

import pamtram.structure.SourceSection;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.impl.GenericPackageImpl;

/**
 * This is the item provider adapter for a {@link pamtram.structure.SourceSection} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class SourceSectionItemProvider extends SourceSectionClassItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public SourceSectionItemProvider(AdapterFactory adapterFactory) {
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

			this.addAbstractPropertyDescriptor(object);
			this.addExtendPropertyDescriptor(object);
			this.addReferencingMappingsPropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Abstract feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_Section_abstract_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_Section_abstract_feature",
						"_UI_Section_type"),
				GenericPackage.Literals.SECTION__ABSTRACT, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
						this.getString("_UI_PropertyDescriptor_description", "_UI_Section_extend_feature",
								"_UI_Section_type"),
						GenericPackage.Literals.SECTION__EXTEND, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						SourceSection sourceSection = (SourceSection) object;

						if (sourceSection.getEClass() == null) {
							return new BasicEList<>();
						}

						Collection<SourceSection> values = (Collection<SourceSection>) super.getChoiceOfValues(object);
						Collection<SourceSection> ret = new BasicEList<>();

						for (SourceSection val : values) {
							// only abstract sections that have a matching eClass can be used as extended section
							if (val.isAbstract() && (val.getEClass() == sourceSection.getEClass()
									|| sourceSection.getEClass().getEAllSuperTypes().contains(val.getEClass()))) {
								ret.add(val);
							}
						}

						return ret;
					}
				});
	}

	/**
	 * This adds a property descriptor for the Referencing Mappings feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected void addReferencingMappingsPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_SourceSection_referencingMappings_feature"),
				this.getString("_UI_PropertyDescriptor_description", "_UI_SourceSection_referencingMappings_feature",
						"_UI_SourceSection_type"),
				StructurePackage.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS, false, false, false, null, null, null));
	}

	@Override
	protected Collection<? extends EStructuralFeature> getLabelRelatedChildrenFeatures(Object object) {

		if (this.labelRelatedChildrenFeatures == null) {
			this.labelRelatedChildrenFeatures = new ArrayList<>();
			this.labelRelatedChildrenFeatures.add(GenericPackageImpl.eINSTANCE.getSection_Extend());
		}
		return this.labelRelatedChildrenFeatures;
	}

	/**
	 * This returns SourceSection.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
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

		this.updateChildren(notification);

		switch (notification.getFeatureID(SourceSection.class)) {
			case StructurePackage.SOURCE_SECTION__ABSTRACT:
				this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
