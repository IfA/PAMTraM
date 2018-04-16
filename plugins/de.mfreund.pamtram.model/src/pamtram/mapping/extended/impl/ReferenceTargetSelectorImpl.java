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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.PamtramPackage;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.extended.util.ExtendedValidator;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorExternalSourceElement;
import pamtram.structure.InstanceSelectorSourceElement;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.StructurePackage;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;
import pamtram.structure.util.StructureValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Instance Selector</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl#getExpression <em>Expression</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl#getModifiers <em>Modifiers</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl#getSourceElements <em>Source Elements</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl#getReferenceAttribute <em>Reference
 * Attribute</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl#getTargetClass <em>Target Class</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.ReferenceTargetSelectorImpl#getAffectedReference <em>Affected
 * Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceTargetSelectorImpl extends MappingHintImpl implements ReferenceTargetSelector {

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
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSelectorSourceInterface> sourceElements;

	/**
	 * The cached value of the '{@link #getReferenceAttribute() <em>Reference Attribute</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getReferenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute referenceAttribute;

	/**
	 * The cached value of the '{@link #getTargetClass() <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTargetClass()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionClass targetClass;

	/**
	 * The cached value of the '{@link #getAffectedReference() <em>Affected Reference</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getAffectedReference()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionCrossReference affectedReference;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceTargetSelectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.REFERENCE_TARGET_SELECTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION, oldExpression, expression));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifiers() {
	
		if (modifiers == null) {
			modifiers = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, ExtendedPackage.REFERENCE_TARGET_SELECTOR__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstanceSelectorSourceInterface> getSourceElements() {
	
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<InstanceSelectorSourceInterface>(InstanceSelectorSourceInterface.class, this, ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS);
		}
		return sourceElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionAttribute getReferenceAttribute() {
	
		  if (referenceAttribute != null && referenceAttribute.eIsProxy()) {
			InternalEObject oldReferenceAttribute = (InternalEObject)referenceAttribute;
			referenceAttribute = (TargetSectionAttribute)eResolveProxy(oldReferenceAttribute);
			if (referenceAttribute != oldReferenceAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
			}
		}
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute basicGetReferenceAttribute() {
		return referenceAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferenceAttribute(TargetSectionAttribute newReferenceAttribute) {
	
		TargetSectionAttribute oldReferenceAttribute = referenceAttribute;
		referenceAttribute = newReferenceAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE, oldReferenceAttribute, referenceAttribute));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionClass getTargetClass() {
	
		  if (targetClass != null && targetClass.eIsProxy()) {
			InternalEObject oldTargetClass = (InternalEObject)targetClass;
			targetClass = (TargetSectionClass)eResolveProxy(oldTargetClass);
			if (targetClass != oldTargetClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS, oldTargetClass, targetClass));
			}
		}
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionClass basicGetTargetClass() {
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetClass(TargetSectionClass newTargetClass) {
	
		TargetSectionClass oldTargetClass = targetClass;
		targetClass = newTargetClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS, oldTargetClass, targetClass));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionCrossReference getAffectedReference() {
	
		  if (affectedReference != null && affectedReference.eIsProxy()) {
			InternalEObject oldAffectedReference = (InternalEObject)affectedReference;
			affectedReference = (TargetSectionCrossReference)eResolveProxy(oldAffectedReference);
			if (affectedReference != oldAffectedReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
			}
		}
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionCrossReference basicGetAffectedReference() {
		return affectedReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedReferenceGen(TargetSectionCrossReference newAffectedReference) {
	
		TargetSectionCrossReference oldAffectedReference = affectedReference;
		affectedReference = newAffectedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE, oldAffectedReference, affectedReference));
	
	}

	/**
	 * Before setting the {@link newAffectedReference}, update the name
	 */
	@Override
	public void setAffectedReference(TargetSectionCrossReference newAffectedReference) {

		this.setNameDerived(affectedReference, newAffectedReference, null, null);
		setAffectedReferenceGen(newAffectedReference);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAffectedReferenceIsNonContainment(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		boolean result = this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null ? true : !this.getAffectedReference().getEReference().isContainment();
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The affected reference '" + this.getAffectedReference().getName() + "' is no non-containment reference!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateAffectedReferenceMatchesSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(this.getAffectedReference() == null) {
			return true;
		}
		
		TargetSection targetSection = this.eContainer() instanceof MappingHintGroupType ? ((MappingHintGroupType) this.eContainer()).getTargetSection() : ((MappingHintGroupImporter) this.eContainer()).getHintGroup().getTargetSection();
		
		boolean result = targetSection == null ? true : this.getAffectedReference().getContainingSection() == targetSection || targetSection.getAllExtend().contains(this.getAffectedReference().getContainingSection());
		
		if (!result && diagnostics != null) {
		
			String hintGroupName = this.eContainer() instanceof MappingHintGroupType ? ((MappingHintGroupType) this.eContainer()).getName() : ((MappingHintGroupImporter) this.eContainer()).getHintGroup().getName();
			String errorMessage = "The affected reference '" + this.getAffectedReference().getName() + "' is not part of the target section referenced by parent hint group '" + hintGroupName + "'!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));
		
		}
		
		return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNoModifiedAttributeElementTypesInConditionModelConditions(final DiagnosticChain diagnostics,
			final Map<?, ?> context) {
		
		boolean result = this.eContainer() instanceof ComplexCondition && ((ComplexCondition) this.eContainer()).isConditionModelCondition() ? this.getSourceElements().parallelStream().noneMatch(s -> s instanceof pamtram.structure.DynamicSourceElement) : true;
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "ModifiedAttributeElementTypes are not allowed as part of ConditionModelConditions!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					StructureValidator.DIAGNOSTIC_SOURCE,
							StructureValidator.INSTANCE_SELECTOR__VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS,
							errorMessage,
					new Object[] { this, StructurePackage.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS }));
		
		}
		
		return result;	
	}

	@Override
	public boolean validateReferenceAttributeIsValid(final DiagnosticChain diagnostics, final Map<?, ?> context) {

		if (referenceAttribute == null || targetClass == null || targetClass.getContainingSection() == null) {
			return true;
		}

		// If a 'targetClass' has already been set for this 'TargetInstanceSelector', allow only 'referenceAttributes'
		// that are part of the same TargetSection as the specified 'targetClass' (or of one of the extended
		// sections).
		//

		TargetSection section = targetClass.getContainingSection();

		List<TargetSection> allowedSections = new ArrayList<>(Arrays.asList(section));
		allowedSections.addAll(section.getAllExtend());

		boolean result = allowedSections.contains(referenceAttribute.getContainingSection());

		if (!result && diagnostics != null) {

			String errorMessage = "The 'referenceAttribute' must be contained in the same TargetSection (or an extended section) as the 'targetClass'!";

			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, StructureValidator.DIAGNOSTIC_SOURCE,
					StructureValidator.TARGET_INSTANCE_SELECTOR__VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID, errorMessage,
					new Object[] { this, StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE }));

		}

		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetClass(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		// If an 'affectedReference' has already been set for this 'TargetInstanceSelector', allow only
				// those choices
				// that are compatible with the selected reference.
				//
				if (this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null
						|| this.getTargetClass() == null || this.getTargetClass().getEClass() == null) {
					return true;
				}
		
			boolean result = this.getAffectedReference().getEReference().getEReferenceType()
						.isSuperTypeOf(this.targetClass.getEClass());
		
			if (!result && diagnostics != null) {
		
				String errorMessage = "The specified 'targetClass' is not compatible with the specified 'affectedReference'!";
		
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_TARGET_CLASS, errorMessage,
							new Object[] { this, StructurePackage.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));
				}
		
			return result;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstanceSelectorSourceElement> getLocalSourceElements() {
		return new BasicEList<>(
				this.getSourceElements().stream().filter(i -> i instanceof InstanceSelectorSourceElement)
						.map(i -> (InstanceSelectorSourceElement) i).collect(Collectors.toList()));	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstanceSelectorExternalSourceElement> getExternalSourceElements() {
		return new BasicEList<>(
				this.getSourceElements().stream().filter(i -> i instanceof InstanceSelectorExternalSourceElement)
						.map(i -> (InstanceSelectorExternalSourceElement) i).collect(Collectors.toList()));	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS:
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
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION:
				return getExpression();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__MODIFIERS:
				return getModifiers();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS:
				return getSourceElements();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE:
				if (resolve) return getReferenceAttribute();
				return basicGetReferenceAttribute();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS:
				if (resolve) return getTargetClass();
				return basicGetTargetClass();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				if (resolve) return getAffectedReference();
				return basicGetAffectedReference();
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
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION:
				setExpression((String)newValue);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends ValueModifierSet>)newValue);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends InstanceSelectorSourceInterface>)newValue);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE:
				setReferenceAttribute((TargetSectionAttribute)newValue);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS:
				setTargetClass((TargetSectionClass)newValue);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionCrossReference)newValue);
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
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__MODIFIERS:
				getModifiers().clear();
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS:
				getSourceElements().clear();
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE:
				setReferenceAttribute((TargetSectionAttribute)null);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS:
				setTargetClass((TargetSectionClass)null);
				return;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				setAffectedReference((TargetSectionCrossReference)null);
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
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS:
				return sourceElements != null && !sourceElements.isEmpty();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE:
				return referenceAttribute != null;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS:
				return targetClass != null;
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE:
				return affectedReference != null;
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
				case ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION: return PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.REFERENCE_TARGET_SELECTOR__MODIFIERS: return PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS;
				default: return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS: return StructurePackage.INSTANCE_SELECTOR__SOURCE_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == TargetInstanceSelector.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE: return StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE;
				case ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS: return StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS;
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
				case PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION: return ExtendedPackage.REFERENCE_TARGET_SELECTOR__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS: return ExtendedPackage.REFERENCE_TARGET_SELECTOR__MODIFIERS;
				default: return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (baseFeatureID) {
				case StructurePackage.INSTANCE_SELECTOR__SOURCE_ELEMENTS: return ExtendedPackage.REFERENCE_TARGET_SELECTOR__SOURCE_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == TargetInstanceSelector.class) {
			switch (baseFeatureID) {
				case StructurePackage.TARGET_INSTANCE_SELECTOR__REFERENCE_ATTRIBUTE: return ExtendedPackage.REFERENCE_TARGET_SELECTOR__REFERENCE_ATTRIBUTE;
				case StructurePackage.TARGET_INSTANCE_SELECTOR__TARGET_CLASS: return ExtendedPackage.REFERENCE_TARGET_SELECTOR__TARGET_CLASS;
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
		if (baseClass == ExpressionElement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == InstanceSelector.class) {
			switch (baseOperationID) {
				case StructurePackage.INSTANCE_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP: return ExtendedPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP;
				case StructurePackage.INSTANCE_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS: return ExtendedPackage.REFERENCE_TARGET_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS;
				case StructurePackage.INSTANCE_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS: return ExtendedPackage.REFERENCE_TARGET_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS;
				default: return -1;
			}
		}
		if (baseClass == TargetInstanceSelector.class) {
			switch (baseOperationID) {
				case StructurePackage.TARGET_INSTANCE_SELECTOR___VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID__DIAGNOSTICCHAIN_MAP: return ExtendedPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID__DIAGNOSTICCHAIN_MAP;
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
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT__DIAGNOSTICCHAIN_MAP:
				return validateAffectedReferenceIsNonContainment((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateAffectedReferenceMatchesSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_TARGET_CLASS__DIAGNOSTICCHAIN_MAP:
				return validateTargetClass((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_REFERENCE_ATTRIBUTE_IS_VALID__DIAGNOSTICCHAIN_MAP:
				return validateReferenceAttributeIsValid((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR___VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP:
				return validateNoModifiedAttributeElementTypesInConditionModelConditions((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
			case ExtendedPackage.REFERENCE_TARGET_SELECTOR___GET_EXTERNAL_SOURCE_ELEMENTS:
				return getExternalSourceElements();
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
		result.append(')');
		return result.toString();
	}

} // MappingInstanceSelectorImpl
