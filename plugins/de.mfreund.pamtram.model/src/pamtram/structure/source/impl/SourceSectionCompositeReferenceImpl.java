/**
 */
package pamtram.structure.source.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.impl.CompositeReferenceImpl;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionCompositeReferenceImpl#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceSectionCompositeReferenceImpl extends
		CompositeReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionCompositeReference {

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
	protected SourceSectionCompositeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.SOURCE_SECTION_COMPOSITE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific element type known in
	 * this context.
	 *
	 * @generated
	 */
	@Override
	public EList<SourceSectionClass> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<SourceSectionClass>(SourceSectionClass.class, this, SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__VALUE);
		}
		return value;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS, oldIgnoreUnmatchedElements, ignoreUnmatchedElements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
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
			case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
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
			case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
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
			case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (derivedFeatureID) {
				case SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS: return SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (baseFeatureID) {
				case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS: return SourcePackage.SOURCE_SECTION_COMPOSITE_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

	@Override
	public void addValuesGeneric(EList<SourceSectionClass> values) {

		this.getValue().addAll(values);

	}

	@Override
	public EList<SourceSectionClass> getValuesGeneric() {

		return this.getValue();
	}

} // SourceSectionCompositeReferenceImpl
