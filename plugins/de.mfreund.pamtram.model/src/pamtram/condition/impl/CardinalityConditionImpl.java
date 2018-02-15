/**
 */
package pamtram.condition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.MatchSpecElement;
import pamtram.PamtramPackage;
import pamtram.condition.CardinalityCondition;
import pamtram.condition.ConditionPackage;
import pamtram.condition.util.ConditionValidator;
import pamtram.structure.generic.CrossReference;
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
	 * The default value of the '{@link #isFollowExternalReferences() <em>Follow External References</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFollowExternalReferences()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOLLOW_EXTERNAL_REFERENCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFollowExternalReferences() <em>Follow External References</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFollowExternalReferences()
	 * @generated
	 * @ordered
	 */
	protected boolean followExternalReferences = FOLLOW_EXTERNAL_REFERENCES_EDEFAULT;

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
	public boolean isFollowExternalReferences() {
	
		return followExternalReferences;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFollowExternalReferences(boolean newFollowExternalReferences) {
	
		boolean oldFollowExternalReferences = followExternalReferences;
		followExternalReferences = newFollowExternalReferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConditionPackage.CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES, oldFollowExternalReferences, followExternalReferences));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateReferenceMatchSpecPresentInCaseOfAmbiguousSource(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		if (this.target == null || this.getLocalSection() == null || this.followExternalReferences) {
			return true;
		}
		
		SourceSection sourceSection = this.getLocalSection();
		
		boolean result = true;
		String errorMessage = "";
		
		if (this.isLocalCondition() && !sourceSection.equals(this.target.getContainingSection())
				&& !sourceSection.getAllExtend().contains(this.target.getContainingSection())) {
		
			result = false;
			errorMessage = "The target Class is not part of the SourceSection specified by this Mapping. This is not allowed unless 'followExternalReferences' is set to 'true'.";
		
		} else if (this.isLocalCondition() && this.target instanceof CrossReference<?, ?, ?, ?>) {
		
			result = false;
			errorMessage = "The target Reference is a Cross Reference. This is not allowed unless 'followExternalReferences' is set to 'true'.";
		
		} else if (this.getReferenceMatchSpec().parallelStream()
				.anyMatch(r -> r instanceof CrossReference<?, ?, ?, ?>)) {
		
			result = false;
			errorMessage = "The specified Reference Match Spec contains Cross References. This is not allowed unless 'followExternalReferences' is set to 'true'.";
		
		}
		
		if (!result && diagnostics != null) {
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ConditionValidator.DIAGNOSTIC_SOURCE,
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
			case ConditionPackage.CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES:
				return isFollowExternalReferences();
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
			case ConditionPackage.CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES:
				setFollowExternalReferences((Boolean)newValue);
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
			case ConditionPackage.CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES:
				setFollowExternalReferences(FOLLOW_EXTERNAL_REFERENCES_EDEFAULT);
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
			case ConditionPackage.CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES:
				return followExternalReferences != FOLLOW_EXTERNAL_REFERENCES_EDEFAULT;
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
				case ConditionPackage.CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES: return PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES;
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
				case PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES: return ConditionPackage.CARDINALITY_CONDITION__FOLLOW_EXTERNAL_REFERENCES;
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

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (followExternalReferences: ");
		result.append(followExternalReferences);
		result.append(')');
		return result.toString();
	}

} // SectionConditionImpl
