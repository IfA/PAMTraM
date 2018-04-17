/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.source.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;

import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingType;
import pamtram.structure.generic.GenericPackage;
import pamtram.structure.generic.Section;
import pamtram.structure.generic.util.GenericValidator;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.util.SourceValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Source Section</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionImpl#getExtend <em>Extend</em>}</li>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionImpl#getAllExtend <em>All Extend</em>}</li>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionImpl#getAllExtending <em>All Extending</em>}</li>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionImpl#isDeactivated <em>Deactivated</em>}</li>
 *   <li>{@link pamtram.structure.source.impl.SourceSectionImpl#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceSectionImpl extends SourceSectionClassImpl implements SourceSection {

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
	protected EList<SourceSection> extend;

	/**
	 * The default value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEACTIVATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeactivated() <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isDeactivated()
	 * @generated
	 * @ordered
	 */
	protected boolean deactivated = DEACTIVATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcePackage.Literals.SOURCE_SECTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.SOURCE_SECTION__ABSTRACT, oldAbstract, abstract_));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getExtend() {
	
		if (extend == null) {
			extend = new EObjectResolvingEList<SourceSection>(SourceSection.class, this, SourcePackage.SOURCE_SECTION__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getAllExtend() {
	
		Set<Object> ret = new LinkedHashSet<>();
		
		List<Section<?, ?, ?, ?>> toCheck = new ArrayList<>();
		toCheck.add(this);
		
		while (!toCheck.isEmpty()) {
			Section<?, ?, ?, ?> next = toCheck.remove(0);
		
			List<Section<?, ?, ?, ?>> localToCheck = next.getExtend().stream().filter(e -> !ret.contains(e))
					.collect(Collectors.toList());
			ret.addAll(localToCheck);
			toCheck.addAll(localToCheck);
		}
		
		return new EcoreEList.UnmodifiableEList<>(this, GenericPackage.Literals.SECTION__ALL_EXTEND, ret.size(),
				ret.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSection> getAllExtending() {
	
		
		Set<Object> extendingSections = new LinkedHashSet<>();
		Iterator<Notifier> it = this.eResource().getResourceSet().getAllContents();
		while (it.hasNext()) {
			Notifier next = it.next();
			if (next instanceof Section<?, ?, ?, ?> && ((Section<?, ?, ?, ?>) next).getAllExtend().contains(this)) {
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
	public boolean isDeactivated() {
	
		return deactivated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeactivated(boolean newDeactivated) {
	
		boolean oldDeactivated = deactivated;
		deactivated = newDeactivated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcePackage.SOURCE_SECTION__DEACTIVATED, oldDeactivated, deactivated));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingType> getReferencingMappings() {
	
		
		List<Mapping> mappings = new ArrayList<>();
		
		if (this.eResource() != null) {
		
			mappings = this.eResource().getResourceSet().getResources().stream()
					.filter(r -> r.getContents().get(0) instanceof pamtram.PAMTraM)
					.flatMap(r -> ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().stream())
					.collect(Collectors.toList());
		}
		
		List<Mapping> referencingMappings = mappings.stream().filter(m -> this.equals(m.getSourceSection())).collect(Collectors.toList());
		
		return new UnmodifiableEList<>(this, SourcePackage.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS,
				referencingMappings.size(), referencingMappings.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateIsReferencedByMapping(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = !this.getReferencingMappings().isEmpty();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The section is not referenced by any mapping!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.WARNING,
					SourceValidator.DIAGNOSTIC_SOURCE,
							SourceValidator.SOURCE_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING,
							errorMessage,
					new Object[] { this, SourcePackage.Literals.SOURCE_SECTION }));
		
		}
		
		return result;	
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
		
			String errorMessage = "The Section extends a Section that is either not abstract or that references an EClass of a different (super-)type!";
		
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
	public boolean validateNotExtendSelf(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		boolean result = !this.getAllExtend().contains(this);
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "A Section must not extend itself (neither directly nor indirectly)!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR, 
					GenericValidator.DIAGNOSTIC_SOURCE,
						GenericValidator.SECTION__VALIDATE_NOT_EXTEND_SELF, 
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
			case SourcePackage.SOURCE_SECTION__ABSTRACT:
				return isAbstract();
			case SourcePackage.SOURCE_SECTION__EXTEND:
				return getExtend();
			case SourcePackage.SOURCE_SECTION__ALL_EXTEND:
				return getAllExtend();
			case SourcePackage.SOURCE_SECTION__ALL_EXTENDING:
				return getAllExtending();
			case SourcePackage.SOURCE_SECTION__DEACTIVATED:
				return isDeactivated();
			case SourcePackage.SOURCE_SECTION__REFERENCING_MAPPINGS:
				return getReferencingMappings();
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
			case SourcePackage.SOURCE_SECTION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case SourcePackage.SOURCE_SECTION__EXTEND:
				getExtend().clear();
				getExtend().addAll((Collection<? extends SourceSection>)newValue);
				return;
			case SourcePackage.SOURCE_SECTION__DEACTIVATED:
				setDeactivated((Boolean)newValue);
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
			case SourcePackage.SOURCE_SECTION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case SourcePackage.SOURCE_SECTION__EXTEND:
				getExtend().clear();
				return;
			case SourcePackage.SOURCE_SECTION__DEACTIVATED:
				setDeactivated(DEACTIVATED_EDEFAULT);
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
			case SourcePackage.SOURCE_SECTION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case SourcePackage.SOURCE_SECTION__EXTEND:
				return extend != null && !extend.isEmpty();
			case SourcePackage.SOURCE_SECTION__ALL_EXTEND:
				return !getAllExtend().isEmpty();
			case SourcePackage.SOURCE_SECTION__ALL_EXTENDING:
				return !getAllExtending().isEmpty();
			case SourcePackage.SOURCE_SECTION__DEACTIVATED:
				return deactivated != DEACTIVATED_EDEFAULT;
			case SourcePackage.SOURCE_SECTION__REFERENCING_MAPPINGS:
				return !getReferencingMappings().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (derivedFeatureID) {
				case SourcePackage.SOURCE_SECTION__ABSTRACT: return GenericPackage.SECTION__ABSTRACT;
				case SourcePackage.SOURCE_SECTION__EXTEND: return GenericPackage.SECTION__EXTEND;
				case SourcePackage.SOURCE_SECTION__ALL_EXTEND: return GenericPackage.SECTION__ALL_EXTEND;
				case SourcePackage.SOURCE_SECTION__ALL_EXTENDING: return GenericPackage.SECTION__ALL_EXTENDING;
				default: return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (derivedFeatureID) {
				case SourcePackage.SOURCE_SECTION__DEACTIVATED: return PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED;
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
		if (baseClass == Section.class) {
			switch (baseFeatureID) {
				case GenericPackage.SECTION__ABSTRACT: return SourcePackage.SOURCE_SECTION__ABSTRACT;
				case GenericPackage.SECTION__EXTEND: return SourcePackage.SOURCE_SECTION__EXTEND;
				case GenericPackage.SECTION__ALL_EXTEND: return SourcePackage.SOURCE_SECTION__ALL_EXTEND;
				case GenericPackage.SECTION__ALL_EXTENDING: return SourcePackage.SOURCE_SECTION__ALL_EXTENDING;
				default: return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.DEACTIVATABLE_ELEMENT__DEACTIVATED: return SourcePackage.SOURCE_SECTION__DEACTIVATED;
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Section.class) {
			switch (baseOperationID) {
				case GenericPackage.SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP: return SourcePackage.SOURCE_SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP;
				case GenericPackage.SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP: return SourcePackage.SOURCE_SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP;
				case GenericPackage.SECTION___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP: return SourcePackage.SOURCE_SECTION___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP;
				default: return -1;
			}
		}
		if (baseClass == DeactivatableElement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SourcePackage.SOURCE_SECTION___VALIDATE_IS_REFERENCED_BY_MAPPING__DIAGNOSTICCHAIN_MAP:
				return validateIsReferencedByMapping((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case SourcePackage.SOURCE_SECTION___VALIDATE_CONTAINER_MATCHES_EXTEND_CONTAINER__DIAGNOSTICCHAIN_MAP:
				return validateContainerMatchesExtendContainer((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case SourcePackage.SOURCE_SECTION___VALIDATE_EXTENDS_VALID_SECTIONS__DIAGNOSTICCHAIN_MAP:
				return validateExtendsValidSections((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case SourcePackage.SOURCE_SECTION___VALIDATE_NOT_EXTEND_SELF__DIAGNOSTICCHAIN_MAP:
				return validateNotExtendSelf((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
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
		result.append(", deactivated: ");
		result.append(deactivated);
		result.append(')');
		return result.toString();
	}

} // SourceSectionImpl
