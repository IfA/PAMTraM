/**
 */
package pamtram.structure.generic.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.util.GenericValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.impl.CompositeReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CompositeReferenceImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ReferenceImpl<S, C, R, A> implements CompositeReference<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<C> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericPackage.Literals.COMPOSITE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<C> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<C>(pamtram.structure.generic.Class.class, this, GenericPackage.COMPOSITE_REFERENCE__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateEReferenceIsContainment(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getEReference() == null ? true : this.getEReference().isContainment();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The eReference '" + this.getEReference().getName() + "' is no containment reference!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					GenericValidator.DIAGNOSTIC_SOURCE,
							GenericValidator.COMPOSITE_REFERENCE__VALIDATE_EREFERENCE_IS_CONTAINMENT,
							errorMessage,
					new Object[] { this, GenericPackage.Literals.REFERENCE__EREFERENCE }));
		
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
			case GenericPackage.COMPOSITE_REFERENCE__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
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
			case GenericPackage.COMPOSITE_REFERENCE__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GenericPackage.COMPOSITE_REFERENCE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends C>)newValue);
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
			case GenericPackage.COMPOSITE_REFERENCE__VALUE:
				getValue().clear();
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
			case GenericPackage.COMPOSITE_REFERENCE__VALUE:
				return value != null && !value.isEmpty();
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
			case GenericPackage.COMPOSITE_REFERENCE___VALIDATE_EREFERENCE_IS_CONTAINMENT__DIAGNOSTICCHAIN_MAP:
				return validateEReferenceIsContainment((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //CompositeReferenceImpl
