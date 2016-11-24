/**
 */
package pamtram.metamodel.impl;

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

import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.util.MetamodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.SectionImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.SectionImpl#getExtend <em>Extend</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SectionImpl<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends ClassImpl<S, C, R, A> implements Section<S, C, R, A> {
	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<S> extend;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SECTION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<S> getExtend() {
		if (extend == null) {
			extend = new EObjectResolvingEList<S>(Section.class, this, MetamodelPackage.SECTION__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateContainerMatchesExtendContainer(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(this.getContainer() == null) {
			return true;
		}
		
		boolean result = this.getExtend().parallelStream().allMatch(
				e -> e.getContainer() == null || e.getContainer() == this.getContainer());
		
		if (!result && diagnostics != null) {
			
			String errorMessage = "The section extends a section that specifies a different container!";
			
			diagnostics.add
				(new BasicDiagnostic
					(Diagnostic.ERROR,
					 MetamodelValidator.DIAGNOSTIC_SOURCE,
					MetamodelValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,
					 errorMessage,
					 new Object [] { this, MetamodelPackage.Literals.SECTION__EXTEND }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExtendsValidSections(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if(this.getEClass() == null) {
			return true;
		}
		
		boolean result = this.getExtend().parallelStream().noneMatch(e -> !e.isAbstract() || e.getEClass() != null
				&& this.getEClass() != e.getEClass() && !this.getEClass().getEAllSuperTypes().contains(e.getEClass()));
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The section extends a section that is either not abstract or that references an EClass of a different (super-)type!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					MetamodelValidator.DIAGNOSTIC_SOURCE,
							MetamodelValidator.SECTION__VALIDATE_EXTENDS_VALID_SECTIONS,
							errorMessage,
					new Object[] { this, MetamodelPackage.Literals.SECTION__EXTEND }));
		
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
			case MetamodelPackage.SECTION__ABSTRACT:
				return isAbstract();
			case MetamodelPackage.SECTION__EXTEND:
				return getExtend();
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
			case MetamodelPackage.SECTION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case MetamodelPackage.SECTION__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends S>)newValue);
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
			case MetamodelPackage.SECTION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case MetamodelPackage.SECTION__EXTEND:
				getExtend().clear();
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
			case MetamodelPackage.SECTION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case MetamodelPackage.SECTION__EXTEND:
				return extend != null && !extend.isEmpty();
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
			case MetamodelPackage.SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP:
				return validateContainerMatchesExtendContainer((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case MetamodelPackage.SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return validateExtendsValidSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //SectionImpl
