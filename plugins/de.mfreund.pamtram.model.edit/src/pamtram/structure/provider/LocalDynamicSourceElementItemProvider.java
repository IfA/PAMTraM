/**
 */
package pamtram.structure.provider;

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

import pamtram.mapping.ContainerSelectorTargetAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Class;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceSectionClass;

/**
 * This is the item provider adapter for a
 * {@link pamtram.structure.LocalDynamicSourceElement} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class LocalDynamicSourceElementItemProvider extends DynamicSourceElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public LocalDynamicSourceElementItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((LocalDynamicSourceElement<?, ?, ?, ?>)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_LocalDynamicSourceElement_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_LocalDynamicSourceElement_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

	/**
	 * This adds a property descriptor for the Source feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	protected void addSourcePropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_DynamicSourceElement_source_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_DynamicSourceElement_source_feature",
								"_UI_DynamicSourceElement_type"),
						StructurePackage.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						// the parent MappingHintGroup
						//
						EObject parent = ((DynamicSourceElement<?, ?, ?, ?>) object).getMappingHintGroup();

						// the parent Mapping
						//
						Mapping mapping = ((DynamicSourceElement<?, ?, ?, ?>) object).getMapping();

						Class<?, ?, ?, ?> relevantClass = null;

						// If we operate on an ModelConnectionHintTarget, we
						// need to
						// scan the container of the target section.
						//
						if (object instanceof ContainerSelectorTargetAttribute) {
							if (parent instanceof MappingHintGroupType
									&& ((MappingHintGroupType) parent).getTargetSection() != null) {
								relevantClass = ((MappingHintGroupType) parent).getTargetSection().getContainer();

								// If no container has been specified, we allow
								// for the
								// default values.
								if (relevantClass == null) {
									return super.getChoiceOfValues(object);
								}
							}

							// Otherwise, we need to scan the source section for
							// suitable attributes.
							//
						} else if (mapping != null) {
							relevantClass = mapping.getSourceSection();
						}

						if (relevantClass == null) {
							return new ArrayList<>();
						}

						List<Object> choiceOfValues = new ArrayList<>();

						// iterate over all elements and return the attributes
						// as
						// possible options
						Set<Class<?, ?, ?, ?>> scanned = new HashSet<>();
						List<Class<?, ?, ?, ?>> sectionsToScan = new ArrayList<>();
						sectionsToScan.add(relevantClass);

						// also regard abstract sections that this extends
						if (relevantClass instanceof Section) {
							sectionsToScan.addAll(((Section<?, ?, ?, ?>) relevantClass).getExtend());
						}

						while (!sectionsToScan.isEmpty()) {
							Class<?, ?, ?, ?> classToScan = sectionsToScan.remove(0);
							scanned.add(classToScan);

							Iterator<EObject> it = classToScan.eAllContents();
							while (it.hasNext()) {
								EObject next = it.next();
								if (next instanceof pamtram.structure.generic.Attribute) {
									choiceOfValues.add(next);
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
}