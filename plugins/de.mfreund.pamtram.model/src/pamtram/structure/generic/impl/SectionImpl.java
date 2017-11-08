/**
 */
package pamtram.structure.generic.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEList;

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.util.GenericValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Section</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.impl.SectionImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.structure.generic.impl.SectionImpl#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.structure.generic.impl.SectionImpl#getAllExtend <em>All Extend</em>}</li>
 *   <li>{@link pamtram.structure.generic.impl.SectionImpl#getAllExtending <em>All Extending</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SectionImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends ClassImpl<S, C, R, A> implements Section<S, C, R, A> {

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<S> extend;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericPackage.Literals.SECTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericPackage.SECTION__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<S> getExtend() {
		if (extend == null) {
			extend = new EObjectResolvingEList<S>(Section.class, this, GenericPackage.SECTION__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<S> getAllExtend() {
		Set<Object> ret = new HashSet<>();
		
			List<Section<?, ?, ?, ?>> toCheck = new ArrayList<>();
				toCheck.add(this);
		
			while (!toCheck.isEmpty()) {
					Section<?, ?, ?, ?> next = toCheck.remove(0);
		
				List<Section<?, ?, ?, ?>> localToCheck = next.getExtend().stream().filter(e -> !ret.contains(e))
							.collect(Collectors.toList());
					ret.addAll(localToCheck);
					toCheck.addAll(localToCheck);
				}
		
			ret.addAll(this.getExtend().stream().flatMap(s -> s.getAllExtend().stream()).collect(Collectors.toList()));
		
			return new EcoreEList.UnmodifiableEList<>(this, GenericPackage.Literals.SECTION__ALL_EXTEND, ret.size(),
						ret.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<S> getAllExtending() {
		Set<Object> extendingSections = new HashSet<>();
		Iterator<Notifier> it = this.eResource().getResourceSet().getAllContents();
		while(it.hasNext()) {
			Notifier next = it.next();
			if(next instanceof Section<?, ?, ?, ?> && ((Section<?, ?, ?, ?>) next).getAllExtend().contains(this)) {
				extendingSections.add(next);
			}
		}
		
		return new EcoreEList.UnmodifiableEList<>(this, GenericPackage.Literals.SECTION__ALL_EXTENDING,
					extendingSections.size(), extendingSections.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
					 GenericValidator.DIAGNOSTIC_SOURCE,
					GenericValidator.SECTION__VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER,
					 errorMessage,
					 new Object [] { this, GenericPackage.Literals.SECTION__EXTEND }));
			}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
					GenericValidator.DIAGNOSTIC_SOURCE,
							GenericValidator.SECTION__VALIDATE_EXTENDS_VALID_SECTIONS,
							errorMessage,
					new Object[] { this, GenericPackage.Literals.SECTION__EXTEND }));
		
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
			case GenericPackage.SECTION__ABSTRACT:
				return isAbstract();
			case GenericPackage.SECTION__EXTEND:
				return getExtend();
			case GenericPackage.SECTION__ALL_EXTEND:
				return getAllExtend();
			case GenericPackage.SECTION__ALL_EXTENDING:
				return getAllExtending();
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
			case GenericPackage.SECTION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case GenericPackage.SECTION__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends S>)newValue);
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
			case GenericPackage.SECTION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case GenericPackage.SECTION__EXTEND:
				getExtend().clear();
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
			case GenericPackage.SECTION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case GenericPackage.SECTION__EXTEND:
				return extend != null && !extend.isEmpty();
			case GenericPackage.SECTION__ALL_EXTEND:
				return !getAllExtend().isEmpty();
			case GenericPackage.SECTION__ALL_EXTENDING:
				return !getAllExtending().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GenericPackage.SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP:
				return validateContainerMatchesExtendContainer((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case GenericPackage.SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return validateExtendsValidSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} // SectionImpl
