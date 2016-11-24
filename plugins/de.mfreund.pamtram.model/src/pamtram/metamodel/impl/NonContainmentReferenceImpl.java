/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.util.MetamodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Containment Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.NonContainmentReferenceImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NonContainmentReferenceImpl<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ReferenceImpl<S, C, R, A> implements NonContainmentReference<S, C, R, A> {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference list.
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
	protected NonContainmentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.NON_CONTAINMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<C> getValue() {
		if (this.value == null) {
			this.value = new EObjectResolvingEList<>(pamtram.metamodel.Class.class, this, MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE);
		}
		return this.value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateEReferenceIsNonContainment(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getEReference() == null ? true : !this.getEReference().isContainment();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The eReference '" + this.getEReference().getName() + "' is no non-containment reference!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MetamodelValidator.DIAGNOSTIC_SOURCE,
							MetamodelValidator.NON_CONTAINMENT_REFERENCE__VALIDATE_EREFERENCE_IS_NON_CONTAINMENT,
							errorMessage,
					new Object[] { this, MetamodelPackage.Literals.REFERENCE__EREFERENCE }));
		
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				return this.getValue();
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				this.getValue().clear();
				this.getValue().addAll((Collection<? extends C>)newValue);
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				this.getValue().clear();
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE__VALUE:
				return this.value != null && !this.value.isEmpty();
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
			case MetamodelPackage.NON_CONTAINMENT_REFERENCE___VALIDATE_EREFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP:
				return this.validateEReferenceIsNonContainment((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //NonContainmentReferenceImpl
