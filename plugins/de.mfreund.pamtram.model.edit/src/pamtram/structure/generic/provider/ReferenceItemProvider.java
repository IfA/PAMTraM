/**
 */
package pamtram.structure.generic.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Reference;

/**
 * This is the item provider adapter for a {@link pamtram.structure.generic.Reference} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ReferenceItemProvider extends MetaModelElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ReferenceItemProvider(AdapterFactory adapterFactory) {

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

		String label = ((Reference<?, ?, ?, ?>) object).getName();
		EReference eReference = object instanceof ActualReference<?, ?, ?, ?>
				? ((ActualReference<?, ?, ?, ?>) object).getEReference()
				: null;

		StyledString styledLabel = new StyledString();

		if (label != null && label.length() != 0) {
			styledLabel.append(label);
		}

		if (eReference != null && eReference.eContainer() instanceof EClass) {
			EClass eClass = (EClass) eReference.eContainer();
			EPackage ePackage = eClass.getEPackage();

			if (ePackage != null) {
				styledLabel.append(styledLabel.toString().equals("") ? "(" + ePackage.getNsPrefix() + "::"
						: " (" + ePackage.getNsPrefix() + "::", StyledString.Style.QUALIFIER_STYLER);
				styledLabel.append(eClass.getName() + "." + eReference.getName() + ")",
						StyledString.Style.QUALIFIER_STYLER);
			} else {
				styledLabel.append(
						styledLabel.toString().equals("") ? "(" + eClass.getName() + "." + eReference.getName() + ")"
								: " (" + eClass.getName() + "." + eReference.getName() + ")",
						StyledString.Style.QUALIFIER_STYLER);
			}
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
