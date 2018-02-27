/**
 */
package pamtram.structure.source.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
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
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.impl.CrossReferenceImpl;
import pamtram.structure.generic.util.GenericValidator;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.source.util.SourceValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Meta
 * Model Section Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionCrossReferenceImpl#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}</li>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionCrossReferenceImpl#getEReference <em>EReference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceSectionCrossReferenceImpl
		extends CrossReferenceImpl<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>
		implements SourceSectionCrossReference {

	/**
	 * The default value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IGNORE_UNMATCHED_ELEMENTS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIgnoreUnmatchedElements() <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 * @ordered
	 */
	protected boolean ignoreUnmatchedElements = IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEReference() <em>EReference</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEReference()
	 * @generated
	 * @ordered
	 */
	protected EReference eReference;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionCrossReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		if (value == null) {
			value = new EObjectResolvingEList<SourceSectionClass>(SourceSectionClass.class, this, SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIgnoreUnmatchedElements() {
	
		return ignoreUnmatchedElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIgnoreUnmatchedElements(boolean newIgnoreUnmatchedElements) {
	
		boolean oldIgnoreUnmatchedElements = ignoreUnmatchedElements;
		ignoreUnmatchedElements = newIgnoreUnmatchedElements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS, oldIgnoreUnmatchedElements, ignoreUnmatchedElements));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEReference() {
	
		  if (eReference != null && eReference.eIsProxy()) {
			InternalEObject oldEReference = (InternalEObject)eReference;
			eReference = (EReference)eResolveProxy(oldEReference);
			if (eReference != oldEReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE, oldEReference, eReference));
			}
		}
		return eReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetEReference() {
		return eReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReferenceGen(EReference newEReference) {
	
		EReference oldEReference = eReference;
		eReference = newEReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE, oldEReference, eReference));
	
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
	 * @generated
	 */
	@Override
	public boolean validateEReferenceMatchesParentEClass(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.isLibraryEntry() || this.getEReference() == null || !(this.eContainer() instanceof pamtram.structure.generic.Class)) {
			return true;
		}
		
		EClass parentEClass = ((pamtram.structure.generic.Class<?, ?, ?, ?>) this.eContainer()).getEClass();
		
		boolean result = parentEClass == null ? true : parentEClass.getEAllReferences().contains(this.getEReference());
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The eReference '" + this.getEReference().getName() + "' is not allowed by the containing Class!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					GenericValidator.DIAGNOSTIC_SOURCE,
							GenericValidator.ACTUAL_REFERENCE__VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS,
							errorMessage,
					new Object[] { this, GenericPackage.Literals.ACTUAL_REFERENCE__EREFERENCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIsIgnoreUnmatchedIfIsComplemented(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if (!(this instanceof ActualReference<?, ?, ?, ?> && this instanceof CompositeReference<?, ?, ?, ?>)) {
			return true;
		}
		
		List<EReference> actualCrossReferences = this.getOwningClass().getAllCrossReferences().stream()
				.filter(r -> r instanceof ActualReference<?, ?, ?, ?>)
				.map(r -> ((ActualReference<?, ?, ?, ?>) r).getEReference()).collect(Collectors.toList());
		
		boolean isComplemented = actualCrossReferences.stream()
				.anyMatch(r -> r != null && r.equals(((ActualReference<?, ?, ?, ?>) this).getEReference()));
		
		boolean result = !isComplemented || this.isIgnoreUnmatchedElements();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "This reference is complemented by a CrossReference that represents the same EReference. Hence, 'ignoreUmatchedElements' needs to be set to 'true'!";
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,
					SourceValidator.SOURCE_SECTION_REFERENCE__VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED,
					errorMessage, new Object[] { this, SourcePackage.Literals.SOURCE_SECTION_REFERENCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return isIgnoreUnmatchedElements();
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
				if (resolve) return getEReference();
				return basicGetEReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements((Boolean)newValue);
				return;
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
				setEReference((EReference)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				setIgnoreUnmatchedElements(IGNORE_UNMATCHED_ELEMENTS_EDEFAULT);
				return;
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
				setEReference((EReference)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS:
				return ignoreUnmatchedElements != IGNORE_UNMATCHED_ELEMENTS_EDEFAULT;
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE:
				return eReference != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (derivedFeatureID) {
				case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS: return SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (derivedFeatureID) {
				case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE: return GenericPackage.ACTUAL_REFERENCE__EREFERENCE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (baseFeatureID) {
				case SourcePackage.SOURCE_SECTION_REFERENCE__IGNORE_UNMATCHED_ELEMENTS: return SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__IGNORE_UNMATCHED_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (baseFeatureID) {
				case GenericPackage.ACTUAL_REFERENCE__EREFERENCE: return SourcePackage.SOURCE_SECTION_CROSS_REFERENCE__EREFERENCE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == SourceSectionReference.class) {
			switch (baseOperationID) {
				case SourcePackage.SOURCE_SECTION_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP: return SourcePackage.SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		if (baseClass == ActualReference.class) {
			switch (baseOperationID) {
				case GenericPackage.ACTUAL_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP: return SourcePackage.SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_EREFERENCE_MATCHES_PARENT_ECLASS__DIAGNOSTICCHAIN_MAP:
				return validateEReferenceMatchesParentEClass((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case SourcePackage.SOURCE_SECTION_CROSS_REFERENCE___VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED__DIAGNOSTICCHAIN_MAP:
				return validateIsIgnoreUnmatchedIfIsComplemented((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

} // MetaModelSectionReferenceImpl
