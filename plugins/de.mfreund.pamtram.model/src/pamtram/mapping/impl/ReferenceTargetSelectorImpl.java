/**
 */
package pamtram.mapping.impl;

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

import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.Matcher;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.mapping.util.MappingValidator;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.ReferenceTargetSelectorImpl#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.impl.ReferenceTargetSelectorImpl#getMatcher <em>Matcher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceTargetSelectorImpl extends MappingHintImpl implements ReferenceTargetSelector {
	/**
	 * The cached value of the '{@link #getAffectedReference() <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedReference()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionCrossReference affectedReference;

	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected Matcher matcher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceTargetSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.REFERENCE_TARGET_SELECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionCrossReference getAffectedReference() {
		if (affectedReference != null && affectedReference.eIsProxy()) {
			InternalEObject oldAffectedReference = (InternalEObject)affectedReference;
			affectedReference = (TargetSectionCrossReference)eResolveProxy(oldAffectedReference);
			if (affectedReference != oldAffectedReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
			}
		}
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionCrossReference basicGetAffectedReference() {
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedReferenceGen(TargetSectionCrossReference newAffectedReference) {
		TargetSectionCrossReference oldAffectedReference = affectedReference;
		affectedReference = newAffectedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
	}

	/**
	 * Before setting the {@link newAffectedReference}, update the name
	 */
	@Override
	public void setAffectedReference(TargetSectionCrossReference newAffectedReference) {
		this.setNameDerived(this.affectedReference, newAffectedReference, null, null);
		this.setAffectedReferenceGen(newAffectedReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Matcher getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatcher(Matcher newMatcher, NotificationChain msgs) {
		Matcher oldMatcher = matcher;
		matcher = newMatcher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER, oldMatcher, newMatcher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatcher(Matcher newMatcher) {
		if (newMatcher != matcher) {
			NotificationChain msgs = null;
			if (matcher != null)
				msgs = ((InternalEObject)matcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER, null, msgs);
			if (newMatcher != null)
				msgs = ((InternalEObject)newMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER, null, msgs);
			msgs = basicSetMatcher(newMatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER, newMatcher, newMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAffectedReferenceIsNonContainment(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null ? true : !this.getAffectedReference().getEReference().isContainment();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The affected reference '" + this.getAffectedReference().getName() + "' is no non-containment reference!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAffectedReferenceMatchesSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.getAffectedReference() == null) {
			return true;
		}
		
		TargetSection targetSection = this.eContainer() instanceof MappingHintGroupType ? ((MappingHintGroupType) this.eContainer()).getTargetSection() : ((MappingHintGroupImporter) this.eContainer()).getHintGroup().getTargetSection();
		
		boolean result = targetSection == null ? true : this.getAffectedReference().getContainingSection() == targetSection || targetSection.getExtend().contains(this.getAffectedReference().getContainingSection());
		
		if (!result && diagnostics != null) {
		
			String hintGroupName = this.eContainer() instanceof MappingHintGroupType ? ((MappingHintGroupType) this.eContainer()).getName() : ((MappingHintGroupImporter) this.eContainer()).getHintGroup().getName();
			String errorMessage = "The affected reference '" + this.getAffectedReference().getName() + "' is not part of the target section referenced by parent hint group '" + hintGroupName + "'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER:
				return basicSetMatcher(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				if (resolve) return getAffectedReference();
				return basicGetAffectedReference();
			case MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER:
				return getMatcher();
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
			case MappingPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionCrossReference)newValue);
				return;
			case MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER:
				setMatcher((Matcher)newValue);
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
			case MappingPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionCrossReference)null);
				return;
			case MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER:
				setMatcher((Matcher)null);
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
			case MappingPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				return affectedReference != null;
			case MappingPackage.REFERENCE_TARGET_SELECTOR__MATCHER:
				return matcher != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP:
				return validateAffectedReferenceIsNonContainment((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateAffectedReferenceMatchesSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //MappingInstanceSelectorImpl
