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
package pamtram.structure.impl;

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
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pamtram.MatchSpecElement;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.StructurePackage;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Local Modified Attribute Element
 * Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.impl.LocalDynamicSourceElementImpl#getReferenceMatchSpec <em>Reference Match Spec</em>}</li>
 *   <li>{@link pamtram.structure.impl.LocalDynamicSourceElementImpl#isFollowExternalReferences <em>Follow External References</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LocalDynamicSourceElementImpl<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>>
		extends DynamicSourceElementImpl<S, C, R, A> implements LocalDynamicSourceElement<S, C, R, A> {

	/**
	 * The cached value of the '{@link #getReferenceMatchSpec() <em>Reference Match Spec</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getReferenceMatchSpec()
	 * @generated
	 * @ordered
	 */
	protected EList<R> referenceMatchSpec;

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
	protected LocalDynamicSourceElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructurePackage.Literals.LOCAL_DYNAMIC_SOURCE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<R> getReferenceMatchSpec() {
	
		if (referenceMatchSpec == null) {
			referenceMatchSpec = new EObjectResolvingEList<R>(Reference.class, this, StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC);
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
			eNotify(new ENotificationImpl(this, Notification.SET, StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES, oldFollowExternalReferences, followExternalReferences));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceAttributeMatchesSectionOrContainedSection(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		if (this.getMapping() == null || this.source == null || this.getMapping().getSourceSection() == null
				|| !(this.source.getContainingSection() instanceof SourceSection)) {
			return true;
		}
		
		Mapping mapping = this.getMapping();
		SourceSection sourceSection = this.getMapping().getSourceSection();
		
		boolean result = false;
		
		pamtram.structure.generic.Class<?, ?, ?, ?> relevantClass = mapping.getSourceSection();
		
		// iterate over all elements and return the attributes as possible options
		//
		Set<pamtram.structure.generic.Class<?, ?, ?, ?>> scanned = new HashSet<>();
		List<pamtram.structure.generic.Class<?, ?, ?, ?>> sectionsToScan = new ArrayList<>();
		sectionsToScan.add(relevantClass);
		
		// also regard abstract sections that this extends
		if (relevantClass instanceof Section) {
			sectionsToScan.addAll(((Section<?, ?, ?, ?>) relevantClass).getAllExtend());
		}
		
		while (!sectionsToScan.isEmpty()) {
			pamtram.structure.generic.Class<?, ?, ?, ?> classToScan = sectionsToScan.remove(0);
			scanned.add(classToScan);
		
			Iterator<EObject> it = classToScan.eAllContents();
			while (it.hasNext()) {
				EObject next = it.next();
				if (next instanceof pamtram.structure.generic.Attribute && next.equals(this.source)) {
					result = true;
					break;
				} else if (next instanceof pamtram.structure.generic.CrossReference<?, ?, ?, ?>) {
					List<SourceSectionClass> vals = new ArrayList<>();
					List<pamtram.structure.generic.Class<?, ?, ?, ?>> values = new ArrayList<>(
							((pamtram.structure.generic.CrossReference<?, ?, ?, ?>) next).getValue());
					vals.addAll((Collection<? extends SourceSectionClass>) values);
					vals.addAll(values.stream().filter(c -> c instanceof SourceSection)
							.flatMap(c -> ((SourceSection) c).getAllExtend().stream()).collect(Collectors.toList()));
					vals.removeAll(scanned);
					sectionsToScan.addAll(vals);
				}
			}
		}
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The source attribute '" + this.source.getName()
					+ "' is not referenced by the source section of the parent mapping '" + sourceSection.getName()
					+ "' or in one of its extended sections/sub-sections!'";
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, StructureValidator.DIAGNOSTIC_SOURCE,
					StructureValidator.LOCAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION,
					errorMessage, new Object[] { this, StructurePackage.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateFollowExternalReferencesTrueIfRequired(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		if (this.source == null || this.getMapping().getSourceSection() == null || this.followExternalReferences) {
			return true;
		}
		
		SourceSection sourceSection = this.getMapping().getSourceSection();
		
		boolean isExternalSourceElement = !sourceSection.equals(this.source.getContainingSection())
				&& !sourceSection.getAllExtend().contains(this.source.getContainingSection());
		
		boolean result = true;
		String errorMessage = "";
		int severity = Diagnostic.OK;
		
		if (isExternalSourceElement) {
		
			result = false;
			severity = Diagnostic.ERROR;
			errorMessage = "The source Attribute is not part of the SourceSection specified by this Mapping. This is not allowed unless 'followExternalReferences' is set to 'true'.";
		
		} else if (this.getReferenceMatchSpec().parallelStream()
				.anyMatch(r -> r instanceof pamtram.structure.generic.CrossReference<?, ?, ?, ?>)) {
		
			result = false;
			severity = Diagnostic.ERROR;
			errorMessage = "The specified Reference Match Spec contains Cross References. This is not allowed unless 'followExternalReferences' is set to 'true'.";
		
		}
		
		if (!result && diagnostics != null) {
		
			diagnostics.add(new BasicDiagnostic(severity, StructureValidator.DIAGNOSTIC_SOURCE,
					StructureValidator.LOCAL_DYNAMIC_SOURCE_ELEMENT__VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED,
					errorMessage, new Object[] { this, StructurePackage.Literals.DYNAMIC_SOURCE_ELEMENT__SOURCE }));
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
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				return getReferenceMatchSpec();
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
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
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				getReferenceMatchSpec().addAll((Collection<? extends R>)newValue);
				return;
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
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
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				return;
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
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
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC:
				return referenceMatchSpec != null && !referenceMatchSpec.isEmpty();
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES:
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
				case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC: return PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC;
				case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES: return PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES;
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
				case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC: return StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__REFERENCE_MATCH_SPEC;
				case PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES: return StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT__FOLLOW_EXTERNAL_REFERENCES;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_SOURCE_ATTRIBUTE_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceAttributeMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case StructurePackage.LOCAL_DYNAMIC_SOURCE_ELEMENT___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP:
				return validateFollowExternalReferencesTrueIfRequired((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
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

} // LocalDynamicSourceElementImpl
