/**
 */
package pamtram.mapping.extended.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.ConditionModel;
import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.extended.util.ExtendedValidator;
import pamtram.util.PamtramValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Hint</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#getLocalCondition <em>Local Condition</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#getSharedCondition <em>Shared Condition</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#isDeactivated <em>Deactivated</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.MappingHintImpl#getOverwrite <em>Overwrite</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingHintImpl extends MappingHintTypeImpl implements MappingHint {

	/**
	 * The cached value of the '{@link #getLocalCondition() <em>Local Condition</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getLocalCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition localCondition;

	/**
	 * The cached value of the '{@link #getSharedCondition() <em>Shared Condition</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #getSharedCondition()
	 * @generated
	 * @ordered
	 */
	protected ComplexCondition sharedCondition;

	/**
	 * The default value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEACTIVATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected boolean deactivated = MappingHintImpl.DEACTIVATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOverwrite() <em>Overwrite</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #getOverwrite()
	 * @generated
	 * @ordered
	 */
	protected MappingHint overwrite;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MappingHintImpl() {

		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ExtendedPackage.Literals.MAPPING_HINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ComplexCondition getLocalCondition() {

		return this.localCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetLocalCondition(ComplexCondition newLocalCondition, NotificationChain msgs) {

		ComplexCondition oldLocalCondition = this.localCondition;
		this.localCondition = newLocalCondition;
		if (this.eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION, oldLocalCondition, newLocalCondition);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setLocalCondition(ComplexCondition newLocalCondition) {

		if (newLocalCondition != this.localCondition) {
			NotificationChain msgs = null;
			if (this.localCondition != null) {
				msgs = ((InternalEObject) this.localCondition).eInverseRemove(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION, null,
						msgs);
			}
			if (newLocalCondition != null) {
				msgs = ((InternalEObject) newLocalCondition).eInverseAdd(this,
						InternalEObject.EOPPOSITE_FEATURE_BASE - ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION, null,
						msgs);
			}
			msgs = this.basicSetLocalCondition(newLocalCondition, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION,
					newLocalCondition, newLocalCondition));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ComplexCondition getSharedCondition() {

		if (this.sharedCondition != null && this.sharedCondition.eIsProxy()) {
			InternalEObject oldSharedCondition = (InternalEObject) this.sharedCondition;
			this.sharedCondition = (ComplexCondition) this.eResolveProxy(oldSharedCondition);
			if (this.sharedCondition != oldSharedCondition) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExtendedPackage.MAPPING_HINT__SHARED_CONDITION, oldSharedCondition, this.sharedCondition));
				}
			}
		}
		return this.sharedCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ComplexCondition basicGetSharedCondition() {

		return this.sharedCondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setSharedCondition(ComplexCondition newSharedCondition) {

		ComplexCondition oldSharedCondition = this.sharedCondition;
		this.sharedCondition = newSharedCondition;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__SHARED_CONDITION,
					oldSharedCondition, this.sharedCondition));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean isDeactivated() {

		return this.deactivated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setDeactivated(boolean newDeactivated) {

		boolean oldDeactivated = this.deactivated;
		this.deactivated = newDeactivated;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__DEACTIVATED,
					oldDeactivated, this.deactivated));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MappingHint getOverwrite() {

		if (this.overwrite != null && this.overwrite.eIsProxy()) {
			InternalEObject oldOverwrite = (InternalEObject) this.overwrite;
			this.overwrite = (MappingHint) this.eResolveProxy(oldOverwrite);
			if (this.overwrite != oldOverwrite) {
				if (this.eNotificationRequired()) {
					this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ExtendedPackage.MAPPING_HINT__OVERWRITE, oldOverwrite, this.overwrite));
				}
			}
		}
		return this.overwrite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MappingHint basicGetOverwrite() {

		return this.overwrite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setOverwrite(MappingHint newOverwrite) {

		MappingHint oldOverwrite = this.overwrite;
		this.overwrite = newOverwrite;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.MAPPING_HINT__OVERWRITE,
					oldOverwrite, this.overwrite));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateOverwritesValidMappingHint(DiagnosticChain diagnostics, Map<?, ?> context) {

		if (this.overwrite == null) {
			return true;
		}

		boolean ret = true;
		String message = "";

		if (this.eClass() != this.overwrite.eClass()) {
			ret = false;
			message = "MappingHints must only overwrite MappingHints of the same type!";
		}

		if (((MappingHintGroupType) this.eContainer()).getExtend().isEmpty()
				|| ((MappingHintGroupType) this.eContainer()).getExtend().stream()
						.anyMatch(hg -> hg.getMappingHints().contains(this.overwrite))) {
			ret = false;
			message = "The overwritten MappingHint is not part of a MappingHintGroup that is extended by the HintGroup containing this MappingHint!";
		}

		if (this instanceof AttributeMapping
				&& ((AttributeMapping) this).getTarget() != ((AttributeMapping) this.overwrite).getTarget()) {
			ret = false;
			message = "An AttributeMapping must only overwrite another AttributeMapping pointing to the same TargetSectionAttribute!";
		} else if (this instanceof CardinalityMapping
				&& ((CardinalityMapping) this).getTarget() != ((CardinalityMapping) this.overwrite).getTarget()) {
			ret = false;
			message = "A CardinalityMapping must only overwrite another CardinalityMapping pointing to the same TargetSectionClass!";
		} else if (this instanceof ReferenceTargetSelector && ((ReferenceTargetSelector) this)
				.getAffectedReference() != ((ReferenceTargetSelector) this.overwrite).getAffectedReference()) {
			ret = false;
			message = "A ReferenceTargetSelector must only overwrite another ReferenceTargetSelector pointing to the same TargetSectionReference!";
		}

		if (!ret && diagnostics != null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExtendedValidator.DIAGNOSTIC_SOURCE,
					ExtendedValidator.MAPPING_HINT__VALIDATE_OVERWRITES_VALID_MAPPING_HINT, message,
					new Object[] { this, ExtendedPackage.Literals.MAPPING_HINT__OVERWRITE }));
		}

		return ret;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateEitherModelOrReferCondition(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		boolean result = !(this.getLocalCondition() != null && this.getSharedCondition() != null);

		if (!result && diagnostics != null) {

			String errorMessage = "Please specify at most one (local or shared) condition!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, PamtramValidator.DIAGNOSTIC_SOURCE,
					PamtramValidator.CONDITIONAL_ELEMENT__VALIDATE_EITHER_MODEL_OR_REFER_CONDITION, errorMessage,
					new Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public boolean validateReferenceOnlyConditionsFromConditionModel(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {

		boolean result = this.getSharedCondition() == null
				|| this.getSharedCondition().eContainer() instanceof ConditionModel;

		if (!result && diagnostics != null) {

			String errorMessage = "It is only allowed to reference shared conditions that are model inside the ConditionModel!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, PamtramValidator.DIAGNOSTIC_SOURCE,
					PamtramValidator.CONDITIONAL_ELEMENT__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,
					errorMessage,
					new Object[] { this, PamtramPackage.Literals.CONDITIONAL_ELEMENT__SHARED_CONDITION }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {

		switch (featureID) {
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				return this.basicSetLocalCondition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				return this.getLocalCondition();
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				if (resolve) {
					return this.getSharedCondition();
				}
				return this.basicGetSharedCondition();
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				return this.isDeactivated();
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				if (resolve) {
					return this.getOverwrite();
				}
				return this.basicGetOverwrite();
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
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				this.setLocalCondition((ComplexCondition) newValue);
				return;
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				this.setSharedCondition((ComplexCondition) newValue);
				return;
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				this.setDeactivated((Boolean) newValue);
				return;
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				this.setOverwrite((MappingHint) newValue);
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
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				this.setLocalCondition((ComplexCondition) null);
				return;
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				this.setSharedCondition((ComplexCondition) null);
				return;
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				this.setDeactivated(MappingHintImpl.DEACTIVATED_EDEFAULT);
				return;
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				this.setOverwrite((MappingHint) null);
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
			case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
				return this.localCondition != null;
			case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
				return this.sharedCondition != null;
			case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
				return this.deactivated != MappingHintImpl.DEACTIVATED_EDEFAULT;
			case ExtendedPackage.MAPPING_HINT__OVERWRITE:
				return this.overwrite != null;
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

		if (baseClass == ConditionalElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION:
					return PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION;
				case ExtendedPackage.MAPPING_HINT__SHARED_CONDITION:
					return PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION;
				default:
					return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.MAPPING_HINT__DEACTIVATED:
					return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
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

		if (baseClass == ConditionalElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.CONDITIONAL_ELEMENT__LOCAL_CONDITION:
					return ExtendedPackage.MAPPING_HINT__LOCAL_CONDITION;
				case PamtramPackage.CONDITIONAL_ELEMENT__SHARED_CONDITION:
					return ExtendedPackage.MAPPING_HINT__SHARED_CONDITION;
				default:
					return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED:
					return ExtendedPackage.MAPPING_HINT__DEACTIVATED;
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

		if (baseClass == ConditionalElement.class) {
			switch (baseOperationID) {
				case PamtramPackage.CONDITIONAL_ELEMENT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP:
					return ExtendedPackage.MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP;
				case PamtramPackage.CONDITIONAL_ELEMENT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
					return ExtendedPackage.MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP;
				default:
					return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (baseOperationID) {
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {

		switch (operationID) {
			case ExtendedPackage.MAPPING_HINT___VALIDATE_OVERWRITES_VALID_MAPPING_HINT__DIAGNOSTICCHAIN_MAP:
				return this.validateOverwritesValidMappingHint((DiagnosticChain) arguments.get(0),
						(Map<?, ?>) arguments.get(1));
			case ExtendedPackage.MAPPING_HINT___VALIDATE_EITHER_MODEL_OR_REFER_CONDITION__DIAGNOSTICCHAIN_MAP:
				return this.validateEitherModelOrReferCondition((DiagnosticChain) arguments.get(0),
						(Map<?, ?>) arguments.get(1));
			case ExtendedPackage.MAPPING_HINT___VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL__DIAGNOSTICCHAIN_MAP:
				return this.validateReferenceOnlyConditionsFromConditionModel((DiagnosticChain) arguments.get(0),
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
		result.append(" (deactivated: ");
		result.append(this.deactivated);
		result.append(')');
		return result.toString();
	}

} // MappingHintImpl
