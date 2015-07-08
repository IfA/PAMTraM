/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.mapping.ModifiableHint;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.AttributeMatcherImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMatcherImpl#getResultModifier <em>Result Modifier</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMatcherImpl#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMatcherImpl#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeMatcherImpl extends MatcherImpl implements AttributeMatcher {
	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResultModifier() <em>Result Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValueModifierSet> resultModifier;

	/**
	 * The cached value of the '{@link #getTargetAttribute() <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAttribute()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute targetAttribute;

	/**
	 * The cached value of the '{@link #getSourceAttributes() <em>Source Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeMatcherSourceInterface> sourceAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMatcherImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ATTRIBUTE_MATCHER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(String newExpression) {
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeValueModifierSet> getResultModifier() {
		if (resultModifier == null) {
			resultModifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.ATTRIBUTE_MATCHER__RESULT_MODIFIER);
		}
		return resultModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionAttribute getTargetAttribute() {
		if (targetAttribute != null && targetAttribute.eIsProxy()) {
			InternalEObject oldTargetAttribute = (InternalEObject)targetAttribute;
			targetAttribute = (TargetSectionAttribute)eResolveProxy(oldTargetAttribute);
			if (targetAttribute != oldTargetAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE, oldTargetAttribute, targetAttribute));
			}
		}
		return targetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute basicGetTargetAttribute() {
		return targetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetAttribute(TargetSectionAttribute newTargetAttribute) {
		TargetSectionAttribute oldTargetAttribute = targetAttribute;
		targetAttribute = newTargetAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE, oldTargetAttribute, targetAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMatcherSourceInterface> getSourceAttributes() {
		if (sourceAttributes == null) {
			sourceAttributes = new EObjectContainmentEList<AttributeMatcherSourceInterface>(AttributeMatcherSourceInterface.class, this, MappingPackage.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES);
		}
		return sourceAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMatcherSourceElement> getLocalSourceElements() {
		EList<AttributeMatcherSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMatcherSourceElement>();
						
						for(AttributeMatcherSourceInterface i : this.getSourceAttributes()){
							if(i instanceof AttributeMatcherSourceElement){
								elements.add((AttributeMatcherSourceElement) i);
							}
						}
						
						return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMatcherExternalSourceElement> getExternalSourceElements() {
		EList<AttributeMatcherExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<>();
		
		for(AttributeMatcherSourceInterface i : this.getSourceAttributes()){
			if(i instanceof AttributeMatcherExternalSourceElement){
				elements.add((AttributeMatcherExternalSourceElement) i);
			}
		}
		
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean targetMatchesAffectedReferenceType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv targetMatchesAffectedReferenceType:
		 *   let
		 *     severity : Integer[1] = 'AttributeMatcher::targetMatchesAffectedReferenceType'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let
		 *         status : OclAny[?] = self.oclContainer()
		 *         .oclAsType(MappingInstanceSelector)
		 *         .affectedReference.eReference.oclAsType(ecore::EReference)
		 *         .eReferenceType.oclAsType(ecore::EClass)
		 *         .isSuperTypeOf(
		 *           self.targetAttribute.oclContainer()
		 *           .oclAsType(metamodel::Class(C, R, A)).eClass)
		 *       in
		 *         'AttributeMatcher::targetMatchesAffectedReferenceType'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonNull*/ /*@NonInvalid*/ Evaluator evaluator = PivotUtilInternal.getEvaluator(this);
		final /*@NonNull*/ /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
		final /*@NonNull*/ /*@NonInvalid*/ IntegerValue severity_0 = ClassUtil.nonNullState(CGStringGetSeverityOperation.INSTANCE.evaluate(evaluator, MappingTables.STR_AttributeMatcher_c_c_targetMatchesAffectedReferenceType));
		final /*@NonInvalid*/ boolean le = ClassUtil.nonNullState(OclComparableLessThanEqualOperation.INSTANCE.evaluate(evaluator, severity_0, MappingTables.INT_0).booleanValue());
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
		    symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
		    /*@NonNull*/ /*@Caught*/ Object CAUGHT_status;
		    try {
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EClass = idResolver.getClass(MappingTables.CLSSid_EClass, null);
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_ecore_c_c_EReference_0 = idResolver.getClass(MappingTables.CLSSid_EReference, null);
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector = idResolver.getClass(MappingTables.CLSSid_MappingInstanceSelector, null);
		        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_Class, null);
		        final /*@Nullable*/ /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, this);
		        final /*@NonNull*/ /*@Thrown*/ MappingInstanceSelector oclAsType = ClassUtil.nonNullState((MappingInstanceSelector)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingInstanceSelector));
		        final /*@NonNull*/ /*@Thrown*/ TargetSectionNonContainmentReference affectedReference = oclAsType.getAffectedReference();
		        final /*@NonNull*/ /*@Thrown*/ EReference eReference = affectedReference.getEReference();
		        final /*@NonNull*/ /*@Thrown*/ EReference oclAsType_0 = ClassUtil.nonNullState((EReference)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference_0));
		        @SuppressWarnings("null")
		        final /*@NonNull*/ /*@Thrown*/ EClass eReferenceType = oclAsType_0.getEReferenceType();
		        final /*@NonNull*/ /*@Thrown*/ EClass oclAsType_1 = ClassUtil.nonNullState((EClass)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, eReferenceType, TYP_ecore_c_c_EClass));
		        final /*@NonNull*/ /*@Thrown*/ TargetSectionAttribute targetAttribute = this.getTargetAttribute();
		        final /*@Nullable*/ /*@Thrown*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, targetAttribute);
		        final /*@NonNull*/ /*@Thrown*/ pamtram.metamodel.Class oclAsType_2 = ClassUtil.nonNullState((pamtram.metamodel.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, oclContainer_0, TYP_pamtram_c_c_metamodel_c_c_Class_o_C_44_R_44_A_e));
		        final /*@NonNull*/ /*@Thrown*/ EClass eClass = oclAsType_2.getEClass();
		        final /*@Thrown*/ boolean status = oclAsType_1.isSuperTypeOf(eClass);
		        CAUGHT_status = status;
		    }
		    catch (Exception e) {
		        CAUGHT_status = ValueUtil.createInvalidValue(e);
		    }
		    final /*@NonInvalid*/ boolean logDiagnostic = ClassUtil.nonNullState(CGStringLogDiagnosticOperation.INSTANCE.evaluate(evaluator, TypeId.BOOLEAN, MappingTables.STR_AttributeMatcher_c_c_targetMatchesAffectedReferenceType, this, null, diagnostics, context, null, severity_0, CAUGHT_status, MappingTables.INT_0).booleanValue());
		    symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				return ((InternalEList<?>)getSourceAttributes()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION:
				return getExpression();
			case MappingPackage.ATTRIBUTE_MATCHER__RESULT_MODIFIER:
				return getResultModifier();
			case MappingPackage.ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE:
				if (resolve) return getTargetAttribute();
				return basicGetTargetAttribute();
			case MappingPackage.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				return getSourceAttributes();
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
			case MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION:
				setExpression((String)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MATCHER__RESULT_MODIFIER:
				getResultModifier().clear();
				getResultModifier().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE:
				setTargetAttribute((TargetSectionAttribute)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				getSourceAttributes().clear();
				getSourceAttributes().addAll((Collection<? extends AttributeMatcherSourceInterface>)newValue);
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
			case MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case MappingPackage.ATTRIBUTE_MATCHER__RESULT_MODIFIER:
				getResultModifier().clear();
				return;
			case MappingPackage.ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE:
				setTargetAttribute((TargetSectionAttribute)null);
				return;
			case MappingPackage.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				getSourceAttributes().clear();
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
			case MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case MappingPackage.ATTRIBUTE_MATCHER__RESULT_MODIFIER:
				return resultModifier != null && !resultModifier.isEmpty();
			case MappingPackage.ATTRIBUTE_MATCHER__TARGET_ATTRIBUTE:
				return targetAttribute != null;
			case MappingPackage.ATTRIBUTE_MATCHER__SOURCE_ATTRIBUTES:
				return sourceAttributes != null && !sourceAttributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionHint.class) {
			switch (derivedFeatureID) {
				case MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION: return MappingPackage.EXPRESSION_HINT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (derivedFeatureID) {
				case MappingPackage.ATTRIBUTE_MATCHER__RESULT_MODIFIER: return MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ExpressionHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.EXPRESSION_HINT__EXPRESSION: return MappingPackage.ATTRIBUTE_MATCHER__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER: return MappingPackage.ATTRIBUTE_MATCHER__RESULT_MODIFIER;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.ATTRIBUTE_MATCHER___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
			case MappingPackage.ATTRIBUTE_MATCHER___GET_EXTERNAL_SOURCE_ELEMENTS:
				return getExternalSourceElements();
			case MappingPackage.ATTRIBUTE_MATCHER___TARGET_MATCHES_AFFECTED_REFERENCE_TYPE__DIAGNOSTICCHAIN_MAP:
				return targetMatchesAffectedReferenceType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		result.append(" (expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //AttributeMatcherImpl
