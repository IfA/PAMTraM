/**
 */
package pamtram.structure.source.impl;

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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.CrossReferenceImpl;
import pamtram.structure.generic.util.GenericValidator;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Meta
 * Model Section Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.source.impl.SourceSectionCrossReferenceImpl#isIgnoreUnmatchedElements
 * <em>Ignore Unmatched Elements</em>}</li>
 * <li>{@link pamtram.structure.source.impl.SourceSectionCrossReferenceImpl#getEReference
 * <em>EReference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceSectionCrossReferenceImpl
		extends CrossReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionCrossReference {

	/**
	 * The default value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore
	 * Unmatched Elements</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_UNMATCHED_ELEMENTS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore
	 * Unmatched Elements</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreUnmatchedElements = SourceSectionCrossReferenceImpl.IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;

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
	protected SourceSectionCrossReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.SOURCE_SECTION_CROSS_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the
	 * more specific element type known in this context.
	 *
	 * @generated
	 */
	@Override
	public EList<SourceSectionClass> getValue() {
		if (this.value == null) {
			this.value = new EObjectResolvingEList<>(SourceSectionClass.class, this,
					SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__VALUE);
		}
		return this.value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isIgnoreUnmatchedElements() {
		return this.ignoreUnmatchedElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIgnoreUnmatchedElements(boolean newIgnoreUnmatchedElements) {
		boolean oldIgnoreUnmatchedElements = this.ignoreUnmatchedElements;
		this.ignoreUnmatchedElements = newIgnoreUnmatchedElements;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET,
					SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS, oldIgnoreUnmatchedElements,
					this.ignoreUnmatchedElements));
		}
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
							SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE, oldEReference, this.eReference));
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
					SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE, oldEReference, this.eReference));
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
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
			return this.isIgnoreUnmatchedElements();
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
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
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
			this.setIgnoreUnmatchedElements((Boolean) newValue);
			return;
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
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
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
			this.setIgnoreUnmatchedElements(SourceSectionCrossReferenceImpl.IGNORE_UNMATCHED_ELEMENTS_EDEFAULT);
			return;
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
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
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
			return this.ignoreUnmatchedElements != SourceSectionCrossReferenceImpl.IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
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
		if (baseClass == SourceSectionReference.class) {
			switch (derivedFeatureID) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (derivedFeatureID) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
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
		if (baseClass == SourceSectionReference.class) {
			switch (baseFeatureID) {
			case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
			default:
				return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (baseFeatureID) {
			case GenericPackage.ACTUAL_REFERENCE__EREFERENCE:
				return SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE;
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
		if (baseClass == SourceSectionReference.class) {
			switch (baseOperationID) {
			default:
				return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (baseOperationID) {
			case GenericPackage.ACTUAL_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
				return SourcePackage.SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP;
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
		case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
			return this.validateEReferenceMatchesParentEClass((DiagnosticChain) arguments.get(0),
					(Map<?, ?>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ignoreUnmatchedElements: ");
		result.append(this.ignoreUnmatchedElements);
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

} // MetaModelSectionReferenceImpl
