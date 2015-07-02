/**
 */
package pamtram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import pamtram.NamedElement;
import pamtram.PamtramPackage;
import de.mfreund.pamtram.preferences.PreferenceSupplier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.impl.NamedElementImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NamedElementImpl extends MinimalEObjectImpl.Container implements NamedElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PamtramPackage.Literals.NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamtramPackage.NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PamtramPackage.NAMED_ELEMENT__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PamtramPackage.NAMED_ELEMENT__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PamtramPackage.NAMED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PamtramPackage.NAMED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * This sets the {@link NamedElement#Name} feature of the element based on
	 * the '<em><b>name</b></em>' of an {@link ENamedElement} while prepending/appending a prefix and a suffix.
	 * This functionality is however only performed if the '<em><b>auto-set-names</b></em>'
	 * preference is enabled.
	 */
	@Override
	public void setNameDerived(ENamedElement oldNamedElement,
			ENamedElement newNamedElement, String prefix, String suffix) {
		
		if(oldNamedElement == newNamedElement || !PreferenceSupplier.isAutoSetNames()) {
			return;
		}
		
		String prefixString = (prefix == null ? "" : prefix);
		String suffixString = (suffix == null ? "" : suffix);

		// check if the old name has been changed/set by the user
		String oldNamedElementString = (oldNamedElement == null ? "" : prefixString + oldNamedElement.getName() + suffixString);
		boolean oldNameIsCustom = !oldNamedElementString.equals(getName() == null ? "" : getName());
		if(oldNameIsCustom) {
			// if this is the case, do not change the value
			return;
		}
		
		// this is the new name
		String newNamedElementString = (newNamedElement == null ? "" : prefixString + newNamedElement.getName() + suffixString);
		
		if(!oldNamedElementString.equals(newNamedElementString)) {
			setName(newNamedElementString);
		}
	}
	
	/**
	 * This sets the {@link NamedElement#Name} feature of the element based on
	 * the '<em><b>name</b></em>' of an {@link NamedElement} while prepending/appending a prefix and a suffix.
	 * This functionality is however only performed if the '<em><b>auto-set-names</b></em>'
	 * preference is enabled.
	 */
	@Override
	public void setNameDerived(NamedElement oldNamedElement,
			NamedElement newNamedElement, String prefix, String suffix) {
		
		if(oldNamedElement == newNamedElement || !PreferenceSupplier.isAutoSetNames()) {
			return;
		}
		
		String prefixString = (prefix == null ? "" : prefix);
		String suffixString = (suffix == null ? "" : suffix);

		// check if the old name has been changed/set by the user
		String oldNamedElementString = (oldNamedElement == null ? "" : prefixString + oldNamedElement.getName() + suffixString);
		boolean oldNameIsCustom = !oldNamedElementString.equals(getName() == null ? "" : getName());
		if(oldNameIsCustom) {
			// if this is the case, do not change the value
			return;
		}
		
		// this is the new name
		String newNamedElementString = (newNamedElement == null ? "" : prefixString + newNamedElement.getName() + suffixString);
		
		if(!oldNamedElementString.equals(newNamedElementString)) {
			setName(newNamedElementString);
		}
	}
	
	/**
	 * This sets the {@link NamedElement#Name} feature of the element based on
	 * another {@link String} while prepending/appending a prefix and a suffix.
	 * This functionality is however only performed if the '<em><b>auto-set-names</b></em>'
	 * preference is enabled.
	 */
	@Override
	public void setNameDerived(String oldString, String newString,
			String prefix, String suffix) {
		
		if(oldString == newString || !PreferenceSupplier.isAutoSetNames()) {
			return;
		}
		
		String prefixString = (prefix == null ? "" : prefix);
		String suffixString = (suffix == null ? "" : suffix);

		// check if the old name has been changed/set by the user
		String oldValueBasedString = (oldString == null ? "" : prefixString + oldString + suffixString);
		boolean oldNameIsCustom = !oldValueBasedString.equals(getName() == null ? "" : getName());
		if(oldNameIsCustom) {
			// if this is the case, do not change the value
			return;
		}
		
		// this is the new name
		String newValueBasedString = (newString == null ? "" : prefixString + newString + suffixString);
		
		if(!oldValueBasedString.equals(newValueBasedString)) {
			setName(newValueBasedString);
		}
	}

} //NamedElementImpl
