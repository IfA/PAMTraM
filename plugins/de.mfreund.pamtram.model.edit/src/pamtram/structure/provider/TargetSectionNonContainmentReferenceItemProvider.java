/**
 */
package pamtram.structure.provider;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.structure.TargetSectionClass;
import pamtram.structure.TargetSectionNonContainmentReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.provider.NonContainmentReferenceItemProvider;

/**
 * This is the item provider adapter for a {@link pamtram.structure.TargetSectionNonContainmentReference} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TargetSectionNonContainmentReferenceItemProvider extends NonContainmentReferenceItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TargetSectionNonContainmentReferenceItemProvider(AdapterFactory adapterFactory) {
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

		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Value feature. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	protected void addValuePropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
				this.getString("_UI_TargetSectionNonContainmentReference_value_feature"),
				this.getString("_UI_PropertyDescriptor_description",
						"_UI_TargetSectionNonContainmentReference_value_feature",
						"_UI_TargetSectionNonContainmentReference_type"),
				GenericPackage.Literals.NON_CONTAINMENT_REFERENCE__VALUE, true, false, true, null, null, null) {

			@Override
			public Collection<?> getChoiceOfValues(Object object) {

				Collection<?> superChoices = super.getChoiceOfValues(object);

				EClass refClass = null;
				try {
					refClass = ((TargetSectionNonContainmentReference) object).getEReference().getEReferenceType();
				} catch (Exception e) {
					return superChoices;
				}
				List<TargetSectionClass> choices = new LinkedList<>();
				Iterator<?> it = superChoices.iterator();
				while (it.hasNext()) {
					Object next = it.next();
					if (next instanceof TargetSectionClass) {
						if (((TargetSectionClass) next).getEClass() != null) {
							if (refClass.isSuperTypeOf(((TargetSectionClass) next).getEClass())) {
								choices.add((TargetSectionClass) next);
							}
						}
					}
				}

				return choices;
			}

		});
	}

	/**
	 * This returns TargetSectionNonContainmentReference.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
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

		return super.getStyledText(object);
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
		super.notifyChanged(notification);
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
