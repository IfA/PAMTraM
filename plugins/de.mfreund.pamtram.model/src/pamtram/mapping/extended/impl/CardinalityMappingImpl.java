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
package pamtram.mapping.extended.impl;

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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.ExpressionElement;
import pamtram.MatchSpecElement;
import pamtram.ModifiableElement;
import pamtram.PamtramPackage;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingExternalSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceElement;
import pamtram.mapping.extended.CardinalityMappingSourceInterface;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.util.ExtendedValidator;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Section;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.target.TargetSectionClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cardinality Mapping</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.impl.CardinalityMappingImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.CardinalityMappingImpl#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.CardinalityMappingImpl#getReferenceMatchSpec <em>Reference Match Spec</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.CardinalityMappingImpl#isFollowExternalReferences <em>Follow External References</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.CardinalityMappingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.CardinalityMappingImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.extended.impl.CardinalityMappingImpl#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityMappingImpl extends MappingHintImpl implements CardinalityMapping {

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModifiers() <em>Modifiers</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getModifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> modifiers;

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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass target;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<CardinalityMappingSourceInterface> sourceElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CardinalityMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.CARDINALITY_MAPPING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpression() {
	
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {
	
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION, oldExpression, expression));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifiers() {
	
		if (modifiers == null) {
			modifiers = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, ExtendedPackage.CARDINALITY_MAPPING__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SourceSectionReference> getReferenceMatchSpec() {
	
		if (referenceMatchSpec == null) {
			referenceMatchSpec = new EObjectResolvingEList<SourceSectionReference>(SourceSectionReference.class, this, ExtendedPackage.CARDINALITY_MAPPING__REFERENCE_MATCH_SPEC);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES, oldFollowExternalReferences, followExternalReferences));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> getSource() {
	
		  if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.CARDINALITY_MAPPING__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(
			MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> newSource) {
	
		MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.CARDINALITY_MAPPING__SOURCE, oldSource, source));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionClass getTarget() {
	
		  if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (TargetSectionClass)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.CARDINALITY_MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(TargetSectionClass newTarget) {
	
		TargetSectionClass oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.CARDINALITY_MAPPING__TARGET, oldTarget, target));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CardinalityMappingSourceInterface> getSourceElements() {
	
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<CardinalityMappingSourceInterface>(CardinalityMappingSourceInterface.class, this, ExtendedPackage.CARDINALITY_MAPPING__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean validateSourceElementMatchesSectionOrContainedSection(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		if (getSource() == null || !(eContainer().eContainer() instanceof Mapping)
				|| ((Mapping) eContainer().eContainer()).getSourceSection() == null) {
			return true;
		}
		
		Mapping mapping = (Mapping) eContainer().eContainer();
		
		boolean result = false;
		
		SourceSection relevantClass = mapping.getSourceSection();
		
		// iterate over all elements and return the attributes as possible options
		//
		Set<SourceSectionClass> scanned = new HashSet<>();
		List<SourceSectionClass> sectionsToScan = new ArrayList<>();
		sectionsToScan.add(relevantClass);
		
		// also regard abstract sections that this extends
		if (relevantClass instanceof Section) {
			sectionsToScan.addAll(relevantClass.getAllExtend());
		}
		
		while (!sectionsToScan.isEmpty()) {
			SourceSectionClass classToScan = sectionsToScan.remove(0);
			scanned.add(classToScan);
		
			Iterator<EObject> it = classToScan.eAllContents();
			while (it.hasNext()) {
				EObject next = it.next();
				if (getSource().equals(next)) {
					result = true;
					break;
				} else if (next instanceof CrossReference && next instanceof SourceSectionReference) {
					List<SourceSectionClass> vals = new ArrayList<>();
					vals.addAll(
							(Collection<? extends SourceSectionClass>) ((CrossReference<?, ?, ?, ?>) next).getValue());
					vals.removeAll(scanned);
					sectionsToScan.addAll(vals);
				}
			}
		}
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The source element '" + getSource().getName()
					+ "' is not part of the source section referenced by parent mapping '" + mapping.getName() + "'!";
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExtendedValidator.DIAGNOSTIC_SOURCE,
					ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION_OR_CONTAINED_SECTION,
					errorMessage, new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetClassMatchesSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		if (getTarget() == null || !(eContainer() instanceof MappingHintGroupType)
				|| ((MappingHintGroupType) eContainer()).getTargetSection() == null) {
			return true;
		}
		
		MappingHintGroupType mappingHintGroup = (MappingHintGroupType) eContainer();
		
		boolean result = getTarget().getContainingSection() == mappingHintGroup.getTargetSection()
				|| mappingHintGroup.getAllExtend().stream().map(MappingHintGroupType::getTargetSection)
						.collect(Collectors.toSet()).contains(getTarget().getContainingSection());
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The target class '" + getTarget().getName()
					+ "' is not part of the target section referenced by parent hint group '"
					+ mappingHintGroup.getName() + "'!";
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExtendedValidator.DIAGNOSTIC_SOURCE,
					ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_MATCHES_SECTION, errorMessage,
					new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING__TARGET }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateSourceClassIsVariableCardinality(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		boolean result = this.getSource() == null || !(this.getSource() instanceof SourceSectionClass) ? true : ((SourceSectionClass) this.getSource()).getCardinality() != CardinalityType.ONE;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Cardinality mappings may only be defined for source classes with a specified cardinality distinct from 'CardinalityType::ONE'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetClassIsVariableCardinality(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		boolean result = this.getTarget() == null ? true : this.getTarget().getCardinality() != CardinalityType.ONE;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Cardinality mappings may only be defined for target classes with a specified cardinality distinct from 'CardinalityType::ONE'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING__TARGET }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNoCardinalityMappingForSourceSectionRoot(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		boolean result = this.getSource() == null ? true : this.getSource() != this.getSource().getContainingSection();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "Cardinality mappings must not be defined for SourceSection root classes!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateOnlySourceOrSourceElements(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = this.getSource() == null || this.getSourceElements() == null || this.getSourceElements().isEmpty();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "A CardinalityMapping must not specify both a 'source' and a set of 'sourceElements'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateExpressionOnlyForSourceElements(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		
		boolean result = !this.getSourceElements().isEmpty() || this.expression.isEmpty();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "A CardinalityMapping must only specify an 'expression' if it also specifies a set of 'sourceElements'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CardinalityMappingSourceElement> getLocalSourceElements() {
		return new BasicEList<>(this.getSourceElements().stream().filter(s -> s instanceof CardinalityMappingSourceElement).map(s -> (CardinalityMappingSourceElement) s).collect(Collectors.toList()));	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CardinalityMappingExternalSourceElement> getExternalSourceElements() {
		return new BasicEList<>(this.getSourceElements().stream().filter(s -> s instanceof CardinalityMappingExternalSourceElement).map(s -> (CardinalityMappingExternalSourceElement) s).collect(Collectors.toList()));	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateFollowExternalReferencesTrueIfRequired(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		Mapping mapping = (Mapping) AgteleEcoreUtil.getAncestorOfKind(this, MappingPackage.Literals.MAPPING);
		
		if (this.source == null || mapping.getSourceSection() == null || !this.getReferenceMatchSpec().isEmpty()) {
			return true;
		}
		
		SourceSection sourceSection = mapping.getSourceSection();
		
		boolean result = true;
		String errorMessage = "";
		
		if (!this.isFollowExternalReferences() && (!sourceSection.equals(this.source.getContainingSection())
				|| !sourceSection.getAllExtend().contains(this.source.getContainingSection()))) {
		
			result = false;
			errorMessage = "The source Attribute is not part of the SourceSection specified by this Mapping. This is not allowed unless 'followExternalReferences' is set to 'true'.";
		
		}
		
		if (!result && diagnostics != null) {
		
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, ExtendedValidator.DIAGNOSTIC_SOURCE,
					ExtendedValidator.CARDINALITY_MAPPING__VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED,
					errorMessage, new Object[] { this, ExtendedPackage.Literals.CARDINALITY_MAPPING__SOURCE }));
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE_ELEMENTS:
				return ((InternalEList<?>)getSourceElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION:
				return getExpression();
			case ExtendedPackage.CARDINALITY_MAPPING__MODIFIERS:
				return getModifiers();
			case ExtendedPackage.CARDINALITY_MAPPING__REFERENCE_MATCH_SPEC:
				return getReferenceMatchSpec();
			case ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES:
				return isFollowExternalReferences();
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ExtendedPackage.CARDINALITY_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE_ELEMENTS:
				return getSourceElements();
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
			case ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION:
				setExpression((String)newValue);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends ValueModifierSet>)newValue);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				getReferenceMatchSpec().addAll((Collection<? extends SourceSectionReference>)newValue);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES:
				setFollowExternalReferences((Boolean)newValue);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE:
				setSource((MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>)newValue);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__TARGET:
				setTarget((TargetSectionClass)newValue);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends CardinalityMappingSourceInterface>)newValue);
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
			case ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__MODIFIERS:
				getModifiers().clear();
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__REFERENCE_MATCH_SPEC:
				getReferenceMatchSpec().clear();
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES:
				setFollowExternalReferences(FOLLOW_EXTERNAL_REFERENCES_EDEFAULT);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE:
				setSource((MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>)null);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__TARGET:
				setTarget((TargetSectionClass)null);
				return;
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE_ELEMENTS:
				getSourceElements().clear();
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
			case ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case ExtendedPackage.CARDINALITY_MAPPING__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case ExtendedPackage.CARDINALITY_MAPPING__REFERENCE_MATCH_SPEC:
				return referenceMatchSpec != null && !referenceMatchSpec.isEmpty();
			case ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES:
				return followExternalReferences != FOLLOW_EXTERNAL_REFERENCES_EDEFAULT;
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE:
				return source != null;
			case ExtendedPackage.CARDINALITY_MAPPING__TARGET:
				return target != null;
			case ExtendedPackage.CARDINALITY_MAPPING__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION: return PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.CARDINALITY_MAPPING__MODIFIERS: return PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS;
				default: return -1;
			}
		}
		if (baseClass == MatchSpecElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.CARDINALITY_MAPPING__REFERENCE_MATCH_SPEC: return PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC;
				case ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES: return PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES;
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
		if (baseClass == ExpressionElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION: return ExtendedPackage.CARDINALITY_MAPPING__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS: return ExtendedPackage.CARDINALITY_MAPPING__MODIFIERS;
				default: return -1;
			}
		}
		if (baseClass == MatchSpecElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MATCH_SPEC_ELEMENT__REFERENCE_MATCH_SPEC: return ExtendedPackage.CARDINALITY_MAPPING__REFERENCE_MATCH_SPEC;
				case PamtramPackage.MATCH_SPEC_ELEMENT__FOLLOW_EXTERNAL_REFERENCES: return ExtendedPackage.CARDINALITY_MAPPING__FOLLOW_EXTERNAL_REFERENCES;
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
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_SOURCE_ELEMENT_MATCHES_SECTION_OR_CONTAINED_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateSourceElementMatchesSectionOrContainedSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateTargetClassMatchesSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_SOURCE_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP:
				return validateSourceClassIsVariableCardinality((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_TARGET_CLASS_IS_VARIABLE_CARDINALITY__DIAGNOSTICCHAIN_MAP:
				return validateTargetClassIsVariableCardinality((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_NO_CARDINALITY_MAPPING_FOR_SOURCE_SECTION_ROOT__DIAGNOSTICCHAIN_MAP:
				return validateNoCardinalityMappingForSourceSectionRoot((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_ONLY_SOURCE_OR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP:
				return validateOnlySourceOrSourceElements((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_EXPRESSION_ONLY_FOR_SOURCE_ELEMENTS__DIAGNOSTICCHAIN_MAP:
				return validateExpressionOnlyForSourceElements((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.CARDINALITY_MAPPING___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
			case ExtendedPackage.CARDINALITY_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS:
				return getExternalSourceElements();
			case ExtendedPackage.CARDINALITY_MAPPING___VALIDATE_FOLLOW_EXTERNAL_REFERENCES_TRUE_IF_REQUIRED__DIAGNOSTICCHAIN_MAP:
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
		result.append(" (expression: ");
		result.append(expression);
		result.append(", followExternalReferences: ");
		result.append(followExternalReferences);
		result.append(')');
		return result.toString();
	}

} // CardinalityMappingImpl
