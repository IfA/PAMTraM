/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.MatchSpecElement;
import pamtram.PamtramPackage;
import pamtram.condition.CardinalityCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.util.ConditionValidator;
import pamtram.mapping.Mapping;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Section Condition</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.condition.impl.CardinalityConditionImpl#getReferenceMatchSpec <em>Reference Match Spec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityConditionImpl extends
		ConditionImpl<MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>>
		implements CardinalityCondition {

	/**
	 * The cached value of the '{@link #getReferenceMatchSpec() <em>Reference Match Spec</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getReferenceMatchSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceSectionReference> referenceMatchSpec;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.CARDINALITY_CONDITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 *
	 * @generated
	 */
	@Override
	public void setTarget(
			MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> newTarget) {
		super.setTarget(newTarget);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionReference> getReferenceMatchSpec() {
	
		if (referenceMatchSpec == null) {
			referenceMatchSpec = new EObjectResolvingEList<SourceSectionReference>(SourceSectionReference.class, this, ConditionPackage.CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC);
		}
		return referenceMatchSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateReferenceMatchSpecPresentInCaseOfAmbiguousSource(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		if (this.target == null || !this.isMappingCondition()
				|| ((Mapping) this.getRootCondition().eContainer()).getSourceSection() == null
				|| !this.getReferenceMatchSpec().isEmpty()) {
			return true;
		}
		
		SourceSection sourceSection = ((Mapping) this.getRootCondition().eContainer()).getSourceSection();
		
		boolean result = true;
		String errorMessage = "";
		
		if (!sourceSection.equals(this.target.getContainingSection())) {
		
			result = false;
			errorMessage = "The target Class is not part of the SourceSection specified by this Mapping. Consider adding a ReferenceMatchSpec to concretize the matched instances to be used for this MappingHint.";
		
		} else if (sourceSection.isReferencedBy(sourceSection, new BasicEList<>())) {
		
			result = false;
			errorMessage = "The specified target Class can be matched in multiple ways (either as part of the local SourceSection or referenced via one or multiple CrossReferences). Consider adding a ReferenceMatchSpec to concretize the matched instances to be used for this MappingHint.";
		}
		
		if (!result && diagnostics != null) {
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, ConditionValidator.DIAGNOSTIC_SOURCE,
					ConditionValidator.CARDINALITY_CONDITION__VALIDATE_REFERENCE_MATCH_SPEC_PRESENT_IN_CASE_OF_AMBIGUOUS_SOURCE,
					errorMessage, new Object[] { this, ConditionPackage.Literals.CONDITION__TARGET }));
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
			case ConditionPackage.CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC:
				return getReferenceMatchSpec();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConditionPackage.CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				getReferenceMatchSpec().addAll((Collection<? extends SourceSectionReference>)newValue);
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
			case ConditionPackage.CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
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
			case ConditionPackage.CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC:
				return referenceMatchSpec != null && !referenceMatchSpec.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MatchSpecElement.class) {
			switch (derivedFeatureID) {
				case ConditionPackage.CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC: return PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC;
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
		if (baseClass == MatchSpecElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC: return ConditionPackage.CARDINALITY_CONDITION__REFERENCE_MATCH_SPEC;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ConditionPackage.CARDINALITY_CONDITION___VALIDATE_REFERENCE_MATCH_SPEC_PRESENT_IN_CASE_OF_AMBIGUOUS_SOURCE__DIAGNOSTICCHAIN_MAP:
				return validateReferenceMatchSpecPresentInCaseOfAmbiguousSource((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} // SectionConditionImpl
