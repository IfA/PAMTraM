/**
 */
package pamtram.structure.source.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import pamtram.structure.generic.impl.ReferenceImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Reference</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionReferenceImpl#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SourceSectionReferenceImpl
		extends ReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionReference {

	/**
	 * The default value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_UNMATCHED_ELEMENTS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreUnmatchedElements = IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.SOURCE_SECTION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIgnoreUnmatchedElements() {
	
		return ignoreUnmatchedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIgnoreUnmatchedElements(boolean newIgnoreUnmatchedElements) {
	
		boolean oldIgnoreUnmatchedElements = ignoreUnmatchedElements;
		ignoreUnmatchedElements = newIgnoreUnmatchedElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS, oldIgnoreUnmatchedElements, ignoreUnmatchedElements));
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return isIgnoreUnmatchedElements();
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
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements((Boolean)newValue);
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
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements(IGNORE_UNMATCHED_ELEMENTS_EDEFAULT);
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
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return ignoreUnmatchedElements != IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;
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
		result.append(" (ignoreUnmatchedElements: ");
		result.append(ignoreUnmatchedElements);
		result.append(')');
		return result.toString();
	}

} // SourceSectionReferenceImpl
