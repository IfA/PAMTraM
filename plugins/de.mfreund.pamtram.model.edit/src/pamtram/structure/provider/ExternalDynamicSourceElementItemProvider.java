/**
 */
package pamtram.structure.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.SourceSectionModel;
import pamtram.mapping.Mapping;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.StructurePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;

/**
 * This is the item provider adapter for a
 * {@link pamtram.structure.ExternalDynamicSourceElement} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class ExternalDynamicSourceElementItemProvider extends DynamicSourceElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ExternalDynamicSourceElementItemProvider(AdapterFactory adapterFactory) {
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
		String label = ((ExternalDynamicSourceElement<?, ?, ?, ?>)object).getName();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_ExternalDynamicSourceElement_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_ExternalDynamicSourceElement_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

						// the parent Mapping
						//
						Mapping mapping = ((DynamicSourceElement<?, ?, ?, ?>) object).getMapping();

						if (mapping == null || mapping.getSourceSection() == null) {
							return new ArrayList<>();
						}

						// the container section
						SourceSectionClass container = mapping.getSourceSection().getContainer();

						List<Object> choiceOfValues = new ArrayList<>();

						if (container != null) {
							// add attributes of container and the metamodel
							// section above
							while (true) {
								choiceOfValues.addAll(container.getAttributes());

								if (container instanceof SourceSection) {
									choiceOfValues.addAll(((SourceSection) container).getAllExtend().stream()
											.flatMap(s -> s.getAttributes().stream()).collect(Collectors.toList()));
								}

								if (container.eContainer() instanceof SourceSectionCompositeReference) {
									container = (SourceSectionClass) container.eContainer().eContainer();
								} else if (container.eContainer() instanceof SourceSectionModel
										&& container.getContainer() != null) {
									container = container.getContainer();
								} else {
									break;
								}
							}
						}

						return choiceOfValues.stream().distinct().collect(Collectors.toList());
					}
				});
	}

}
