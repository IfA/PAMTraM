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
import java.util.Collection;
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.PamtramPackage;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMappingExternalSourceElement;
import pamtram.mapping.extended.AttributeMappingSourceElement;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
import pamtram.mapping.extended.ExpandableHint;
import pamtram.mapping.extended.ExtendedPackage;
import pamtram.mapping.extended.util.ExtendedValidator;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.target.TargetSectionAttribute;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Mapping</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMappingImpl#getExpression <em>Expression</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMappingImpl#getModifiers <em>Modifiers</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMappingImpl#getTarget <em>Target</em>}</li>
 * <li>{@link pamtram.mapping.extended.impl.AttributeMappingImpl#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeMappingImpl extends MappingHintImpl implements AttributeMapping {

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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute target;

	/**
	 * The cached value of the '{@link #getSourceElements() <em>Source Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceElements()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeMappingSourceInterface> sourceElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedPackage.Literals.ATTRIBUTE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionAttribute getTarget() {
	
		  if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (TargetSectionAttribute)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtendedPackage.ATTRIBUTE_MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetGen(TargetSectionAttribute newTarget) {
	
		TargetSectionAttribute oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.ATTRIBUTE_MAPPING__TARGET, oldTarget, target));
	
	}

	/**
	 * Before setting the {@link newSourceMMSection}, update the name
	 */
	@Override
	public void setTarget(TargetSectionAttribute newTarget) {

		this.setNameDerived(this.target, newTarget, null, "Mapping");
		this.setTargetGen(newTarget);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMappingSourceInterface> getSourceElements() {
	
		if (sourceElements == null) {
			sourceElements = new EObjectContainmentEList<AttributeMappingSourceInterface>(AttributeMappingSourceInterface.class, this, ExtendedPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS);
		}
		return sourceElements;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION, oldExpression, expression));
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValueModifierSet> getModifiers() {
	
		if (modifiers == null) {
			modifiers = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, ExtendedPackage.ATTRIBUTE_MAPPING__MODIFIERS);
		}
		return modifiers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMappingSourceElement> getLocalSourceElements() {
				EList<AttributeMappingSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingSourceElement>();
				
				for(AttributeMappingSourceInterface i : this.getSourceElements()){
					if(i instanceof AttributeMappingSourceElement){
						elements.add((AttributeMappingSourceElement) i);
					}
				}
				
				return elements;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMappingExternalSourceElement> getExternalSourceElements() {
		EList<AttributeMappingExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingExternalSourceElement>();
		
		for(AttributeMappingSourceInterface i : this.getSourceElements()){
			if(i instanceof AttributeMappingExternalSourceElement){
				elements.add((AttributeMappingExternalSourceElement) i);
			}
		}
		
		return elements;	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateTargetAttributeMatchesSection(final DiagnosticChain diagnostics, final Map<?, ?> context) {
		if(this.getTarget() == null || !(this.eContainer() instanceof MappingHintGroupType) || ((MappingHintGroupType) this.eContainer()).getTargetSection() == null) {
			return true;
		}
		
		MappingHintGroupType containingHintGroup = ((MappingHintGroupType) this.eContainer());
		
		boolean result = this.getTarget().getContainingSection() == containingHintGroup.getTargetSection() || containingHintGroup.getTargetSection().getAllExtend().contains(this.getTarget().getContainingSection());
		
		if (!result && diagnostics != null) {
		
			String errorMessage = "The target attribute '" + this.getTarget().getName() + "' is not part of the target section referenced by parent hint group " + ((MappingHintGroupType) this.eContainer()).getName() + "!";
		
			diagnostics.add(new BasicDiagnostic
					(Diagnostic.ERROR,
					ExtendedValidator.DIAGNOSTIC_SOURCE,
							ExtendedValidator.ATTRIBUTE_MAPPING__VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION,
							errorMessage,
					new Object[] { this, ExtendedPackage.Literals.ATTRIBUTE_MAPPING__TARGET }));
		
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
			case ExtendedPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS:
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
			case ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				return getExpression();
			case ExtendedPackage.ATTRIBUTE_MAPPING__MODIFIERS:
				return getModifiers();
			case ExtendedPackage.ATTRIBUTE_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case ExtendedPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS:
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
			case ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				setExpression((String)newValue);
				return;
			case ExtendedPackage.ATTRIBUTE_MAPPING__MODIFIERS:
				getModifiers().clear();
				getModifiers().addAll((Collection<? extends ValueModifierSet>)newValue);
				return;
			case ExtendedPackage.ATTRIBUTE_MAPPING__TARGET:
				setTarget((TargetSectionAttribute)newValue);
				return;
			case ExtendedPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS:
				getSourceElements().clear();
				getSourceElements().addAll((Collection<? extends AttributeMappingSourceInterface>)newValue);
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
			case ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case ExtendedPackage.ATTRIBUTE_MAPPING__MODIFIERS:
				getModifiers().clear();
				return;
			case ExtendedPackage.ATTRIBUTE_MAPPING__TARGET:
				setTarget((TargetSectionAttribute)null);
				return;
			case ExtendedPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS:
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
			case ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case ExtendedPackage.ATTRIBUTE_MAPPING__MODIFIERS:
				return modifiers != null && !modifiers.isEmpty();
			case ExtendedPackage.ATTRIBUTE_MAPPING__TARGET:
				return target != null;
			case ExtendedPackage.ATTRIBUTE_MAPPING__SOURCE_ELEMENTS:
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
				case ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION: return PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (derivedFeatureID) {
				case ExtendedPackage.ATTRIBUTE_MAPPING__MODIFIERS: return PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS;
				default: return -1;
			}
		}
		if (baseClass == ExpandableHint.class) {
			switch (derivedFeatureID) {
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
				case PamtramPackage.EXPRESSION_ELEMENT__EXPRESSION: return ExtendedPackage.ATTRIBUTE_MAPPING__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableElement.class) {
			switch (baseFeatureID) {
				case PamtramPackage.MODIFIABLE_ELEMENT__MODIFIERS: return ExtendedPackage.ATTRIBUTE_MAPPING__MODIFIERS;
				default: return -1;
			}
		}
		if (baseClass == ExpandableHint.class) {
			switch (baseFeatureID) {
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
			case ExtendedPackage.ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
			case ExtendedPackage.ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS:
				return getExternalSourceElements();
			case ExtendedPackage.ATTRIBUTE_MAPPING___VALIDATE_TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP:
				return validateTargetAttributeMatchesSection((DiagnosticChain)arguments.get(0), (Map<?, ?>)arguments.get(1));
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

} // AttributeMappingImpl
