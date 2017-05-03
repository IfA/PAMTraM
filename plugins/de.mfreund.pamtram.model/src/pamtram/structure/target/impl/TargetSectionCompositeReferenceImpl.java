/**
 */
package pamtram.structure.target.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.CompositeReferenceImpl;
import pamtram.structure.generic.util.GenericValidator;
import pamtram.structure.target.TargetPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Target
 * Section Containment Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.target.impl.TargetSectionCompositeReferenceImpl#getEReference
 * <em>EReference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetSectionCompositeReferenceImpl extends
		CompositeReferenceImpl<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>
		implements TargetSectionCompositeReference {

	/**
	 * The cached value of the '{@link #getEReference() <em>EReference</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getEReference()
	 * @generated
	 * @ordered
	 */
	protected EReference eReference;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TargetSectionCompositeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.TARGET_SECTION_COMPOSITE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the
	 * more specific element type known in this context.
	 *
	 * @generated
	 */
	@Override
	public EList<TargetSectionClass> getValue() {
		if (this.value == null) {
			this.value = new EObjectContainmentEList<>(TargetSectionClass.class, this,
					TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__VALUE);
		}
		return this.value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEReference() {
		if (this.eReference != null && this.eReference.eIsProxy()) {
			InternalEObject oldEReference = (InternalEObject) this.eReference;
			this.eReference = (EReference) this.eResolveProxy(oldEReference);
			if (this.eReference != oldEReference) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE, oldEReference,
							this.eReference));
				}
			}
		}
		return this.eReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference basicGetEReference() {
		return this.eReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setEReferenceGen(EReference newEReference) {
		EReference oldEReference = this.eReference;
		this.eReference = newEReference;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE, oldEReference, this.eReference));
		}
	}

	/**
	 * Before setting the newEReference, update the name.
	 */
	@Override
	public void setEReference(EReference newEReference) {

		this.setNameDerived(this.eReference, newEReference, null, null);
		this.setEReferenceGen(newEReference);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean validateEReferenceMatchesParentEClass(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		if (this.isLibraryEntry() || this.getEReference() == null
				|| !(this.eContainer() instanceof pamtram.structure.generic.Class)) {
			return true;
		}

		EClass parentEClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.eContainer()).getEClass();

		boolean result = parentEClass == null ? true : parentEClass.getEAllReferences().contains(this.getEReference());

		if (!result && diagnostics != null) {

			String errorMessage = "The eReference '" + this.getEReference().getName()
					+ "' is not allowed by the containing Class!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,
					GenericValidator.ACTUAL_REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS, errorMessage,
					new Object[] { this, GenericPackage.Literals.ACTUAL_REFERENCE__EREFERENCE }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE:
			if (resolve) {
				return this.getEReference();
			}
			return this.basicGetEReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE:
			this.setEReference((EReference) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE:
			this.setEReference((EReference) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE:
			return this.eReference != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == TargetSectionReference.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (derivedFeatureID) {
			case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE:
				return GenericPackage.ACTUAL_REFERENCE__EREFERENCE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == TargetSectionReference.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (baseFeatureID) {
			case GenericPackage.ACTUAL_REFERENCE__EREFERENCE:
				return TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE__EREFERENCE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == TargetSectionReference.class) {
			switch (baseOperationID) {
			default:
				return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (baseOperationID) {
			case GenericPackage.ACTUAL_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
				return TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP;
			default:
				return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case TargetPackage.TARGET_SECTION_COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
			return this.validateEReferenceMatchesParentEClass((DiagnosticChain) arguments.get(0),
					(Map<?, ?>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public void addValuesGeneric(EList<TargetSectionClass> values) {

		this.getValue().addAll(values);

	}

	@Override
	public EList<TargetSectionClass> getValuesGeneric() {

		return this.getValue();
	}

} // TargetSectionCompositeReferenceImpl
