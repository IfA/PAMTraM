/**
 */
package pamtram.structure.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.structure.MetaModelSectionReference;
import pamtram.structure.MetamodelPackage;
import pamtram.structure.SourceSectionClass;
import pamtram.structure.util.MetamodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Meta Model Section Reference</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.impl.MetaModelSectionReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaModelSectionReferenceImpl extends SourceSectionReferenceImpl implements MetaModelSectionReference {

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionClass> value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MetaModelSectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<SourceSectionClass> getValue() {

		if (this.value == null) {
			this.value = new EObjectResolvingEList<>(SourceSectionClass.class, this,
					MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE);
		}
		return this.value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean validateValuesMatchReferenceType(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		boolean result = this.getEReference() == null ? true
				: this.getValue().parallelStream()
						.allMatch(c -> this.getEReference().getEReferenceType().isSuperTypeOf(c.getEClass()));

		if (!result && diagnostics != null) {

			String errorMessage = this.getValue().parallelStream()
					.filter(c -> !this.getEReference().getEReferenceType().isSuperTypeOf(c.getEClass())).count()
					+ " of the selected target Classes (Value) are not allowed by the selected eReference '"
					+ this.getEReference().getName() + "'!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, MetamodelValidator.DIAGNOSTIC_SOURCE,
					MetamodelValidator.META_MODEL_SECTION_REFERENCE__VALIDATE_VALUES_MATCH_REFERENCE_TYPE, errorMessage,
					new Object[] { this, MetamodelPackage.Literals.META_MODEL_SECTION_REFERENCE__VALUE }));

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
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				return this.getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				this.getValue().clear();
				this.getValue().addAll((Collection<? extends SourceSectionClass>) newValue);
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
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				this.getValue().clear();
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
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE__VALUE:
				return this.value != null && !this.value.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case MetamodelPackage.META_MODEL_SECTION_REFERENCE___VALIDATE_VALUES_MATCH_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP:
				return this.validateValuesMatchReferenceType((DiagnosticChain) arguments.get(0),
						(Map<?, ?>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
