/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.util.MappingValidator;
import pamtram.structure.SourceSectionClass;
import pamtram.structure.TargetSectionClass;
import pamtram.structure.generic.CardinalityType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cardinality Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.CardinalityMappingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.impl.CardinalityMappingImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityMappingImpl extends MappingHintImpl implements CardinalityMapping {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected SourceSectionClass source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.CARDINALITY_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceSectionClass getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (SourceSectionClass)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.CARDINALITY_MAPPING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSectionClass basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(SourceSectionClass newSource) {
		SourceSectionClass oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.CARDINALITY_MAPPING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionClass getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (TargetSectionClass)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.CARDINALITY_MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(TargetSectionClass newTarget) {
		TargetSectionClass oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.CARDINALITY_MAPPING__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceClassMatchesSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.getSource() == null || !(this.eContainer().eContainer() instanceof Mapping) || ((Mapping) this.eContainer().eContainer()).getSourceSection() == null) {
			return true;
		}
		
		boolean result = this.getSource().getContainingSection() == ((Mapping) this.eContainer().eContainer()).getSourceSection();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The source class '" + this.getSource().getName() + "' is not part of the source section referenced by parent mapping '" + ((pamtram.mapping.Mapping) this.eContainer().eContainer()).getName() + "'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_MATCHES_SECTION,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetClassMatchesSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.getTarget() == null || !(this.eContainer() instanceof MappingHintGroupType) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {
			return true;
		}
		
		boolean result = this.getTarget().getContainingSection() == ((MappingHintGroupType) this.eContainer()).getTargetSection();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The target class '" + this.getTarget().getName() + "' is not part of the target section referenced by parent hint group '" + ((MappingHintGroupType) this.eContainer()).getName() + "'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.CARDINALITY_MAPPING__TARGET }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceClassIsVariableCardinality(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getSource() == null ? true : this.getSource().getCardinality() != CardinalityType.ONE;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Cardinality mappings may only be defined for source classes with a specified cardinality distinct from 'CardinalityType::ONE'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetClassIsVariableCardinality(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getTarget() == null ? true : this.getTarget().getCardinality() != CardinalityType.ONE;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Cardinality mappings may only be defined for target classes with a specified cardinality distinct from 'CardinalityType::ONE'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.CARDINALITY_MAPPING__TARGET }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNoCardinalityMappingForSourceSectionRoot(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getSource() == null ? true : this.getSource() != this.getSource().getContainingSection();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Cardinality mappings must not be defined for SourceSection root classes!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MappingValidator.DIAGNOSTIC_SOURCE,
							MappingValidator.CARDINALITY_MAPPING__VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT,
							errorMessage,
					new Object[] { this, MappingPackage.Literals.CARDINALITY_MAPPING__SOURCE }));
		
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				setSource((SourceSectionClass)newValue);
				return;
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				setTarget((TargetSectionClass)newValue);
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
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				setSource((SourceSectionClass)null);
				return;
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				setTarget((TargetSectionClass)null);
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
			case MappingPackage.CARDINALITY_MAPPING__SOURCE:
				return source != null;
			case MappingPackage.CARDINALITY_MAPPING__TARGET:
				return target != null;
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
			case MappingPackage.CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceClassMatchesSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateTargetClassMatchesSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP:
				return validateSourceClassIsVariableCardinality((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP:
				return validateTargetClassIsVariableCardinality((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MappingPackage.CARDINALITY_MAPPING___VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP:
				return validateNoCardinalityMappingForSourceSectionRoot((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //CardinalityMappingImpl
