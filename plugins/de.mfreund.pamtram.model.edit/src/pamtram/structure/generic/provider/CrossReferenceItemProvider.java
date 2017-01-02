/**
 */
package pamtram.structure.generic.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.structure.generic.Class;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.ReferenceImpl;

/**
 * This is the item provider adapter for a
 * {@link pamtram.structure.generic.CrossReference} object. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class CrossReferenceItemProvider extends ReferenceItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public CrossReferenceItemProvider(AdapterFactory adapterFactory) {
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
		if (this.itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			this.addValuePropertyDescriptor(object);
		}
		return this.itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void addValuePropertyDescriptor(Object object) {
		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_CrossReference_value_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_CrossReference_value_feature",
								"_UI_CrossReference_type"),
						GenericPackage.Literals.CROSS_REFERENCE__VALUE, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						Collection<?> superChoices = super.getChoiceOfValues(object);

						EClass refClass = null;
						try {
							refClass = ((CrossReference) object).getEReference().getEReferenceType();
						} catch (Exception e) {
							return superChoices;
						}
						List<Class> choices = new LinkedList<>();
						Iterator<?> it = superChoices.iterator();
						while (it.hasNext()) {
							Object next = it.next();
							if (next instanceof Class) {
								if (((Class) next).getEClass() != null) {
									if (refClass.isSuperTypeOf(((Class) next).getEClass())) {
										choices.add((Class) next);
									}
								}
							}
						}

						return choices;
					}
				});
	}

	/**
	 * This adds a property descriptor for the EReference feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	protected void addEReferencePropertyDescriptor(Object object) {

		this.itemPropertyDescriptors.add(
				new ItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
						this.getResourceLocator(), this.getString("_UI_Reference_eReference_feature"),
						this.getString("_UI_PropertyDescriptor_description", "_UI_Reference_eReference_feature",
								"_UI_Reference_type"),
						GenericPackage.Literals.REFERENCE__EREFERENCE, true, false, true, null, null, null) {

					@Override
					public Collection<?> getChoiceOfValues(Object object) {

						List<Object> choiceOfValues = new ArrayList<>();

						// make sure that only those references can be selected
						// that belong to the parent eClass
						pamtram.structure.generic.Class parent = (Class) ((ReferenceImpl) object).eContainer();
						Iterator<EReference> it = parent.getEClass().getEAllReferences().iterator();

						while (it.hasNext()) {
							// EReference ref = it.next();
							// if (!ref.isContainment()) {
							choiceOfValues.add(it.next());
							// }
						}

						return choiceOfValues;
					}
				});
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString) this.getStyledText(object)).getString();
	}

	/**
	 * This returns the label styled text for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {

		return super.getStyledText(object);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		this.updateChildren(notification);
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
