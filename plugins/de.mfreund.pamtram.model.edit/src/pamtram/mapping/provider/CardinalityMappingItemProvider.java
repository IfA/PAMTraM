/**
 */
package pamtram.mapping.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.source.SourceSectionClass;

/**
 * This is the item provider adapter for a {@link pamtram.mapping.CardinalityMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CardinalityMappingItemProvider extends MappingHintItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CardinalityMappingItemProvider(AdapterFactory adapterFactory) {
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

			addSourcePropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSourcePropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CardinalityMapping_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_source_feature", "_UI_CardinalityMapping_type"),
				 MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Source feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	protected void addSourcePropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_CardinalityMapping_source_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_source_feature",
								"_UI_CardinalityMapping_type"),
						MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE, true, false, true, null, null, null) {

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

						// iterate over all elements and return the attributes
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

							Iterator<EObject> it = classToScan.eAllContents();
							while (it.hasNext()) {
								EObject next = it.next();
								if (next instanceof SourceSectionClass) {
									if (!((SourceSectionClass) next).getCardinality().equals(CardinalityType.ONE)) {
										choiceOfValues.add(next);
									}
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
	 * This adds a property descriptor for the Target feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTargetPropertyDescriptorGen(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CardinalityMapping_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_target_feature", "_UI_CardinalityMapping_type"),
				 MappingPackage.Literals.CARDINALITY_MAPPING__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	protected void addTargetPropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_CardinalityMapping_target_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_CardinalityMapping_target_feature",
								"_UI_CardinalityMapping_type"),
						MappingPackage.Literals.CARDINALITY_MAPPING__TARGET, true, false, true, null, null, null) {

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
	 * This returns CardinalityMapping.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CardinalityMapping"));
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

		return styledLabel;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
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
	}

}
