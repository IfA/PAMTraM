/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanOrOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclTypeOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingExternalSourceElement;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.MappingTables;
import pamtram.mapping.ModifiableHint;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Section;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getResultModifier <em>Result Modifier</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getSourceAttributeMappings <em>Source Attribute Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeMappingImpl extends MappingHintImpl implements AttributeMapping {
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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected TargetSectionAttribute target;

	/**
	 * The cached value of the '{@link #getSourceAttributeMappings() <em>Source Attribute Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAttributeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeMappingSourceInterface> sourceAttributeMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.ATTRIBUTE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TargetSectionAttribute getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (TargetSectionAttribute)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.ATTRIBUTE_MAPPING__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSectionAttribute basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetGen(TargetSectionAttribute newTarget) {
		TargetSectionAttribute oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ATTRIBUTE_MAPPING__TARGET, oldTarget, target));
	}
	
	/**
	 * Before setting the {@link newSourceMMSection}, update the name
	 */
	@Override
	public void setTarget(TargetSectionAttribute newTarget) {
		setNameDerived(target, newTarget, null, "Mapping");
		setTargetGen(newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMappingSourceInterface> getSourceAttributeMappings() {
		if (sourceAttributeMappings == null) {
			sourceAttributeMappings = new EObjectContainmentEList<AttributeMappingSourceInterface>(AttributeMappingSourceInterface.class, this, MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS);
		}
		return sourceAttributeMappings;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeValueModifierSet> getResultModifier() {
		if (resultModifier == null) {
			resultModifier = new EObjectResolvingEList<AttributeValueModifierSet>(AttributeValueModifierSet.class, this, MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER);
		}
		return resultModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeMappingSourceElement> getLocalSourceElements() {
				EList<AttributeMappingSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingSourceElement>();
				
				for(AttributeMappingSourceInterface i : this.getSourceAttributeMappings()){
					if(i instanceof AttributeMappingSourceElement){
						elements.add((AttributeMappingSourceElement) i);
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
	public EList<AttributeMappingExternalSourceElement> getExternalSourceElements() {
		EList<AttributeMappingExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingExternalSourceElement>();
		
		for(AttributeMappingSourceInterface i : this.getSourceAttributeMappings()){
			if(i instanceof AttributeMappingExternalSourceElement){
				elements.add((AttributeMappingExternalSourceElement) i);
			}
		}
		
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean targetAttributeMatchesSection(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv targetAttributeMatchesSection:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if
		 *         self.target.oclType() = OclVoid or
		 *         self.oclContainer()
		 *         .oclAsType(MappingHintGroupType)
		 *         .targetMMSection.oclType() = OclVoid
		 *       then true
		 *       else
		 *         self.target.getContainingSection() =
		 *         self.oclContainer()
		 *         .oclAsType(MappingHintGroupType).targetMMSection or
		 *         self.oclContainer()
		 *         .oclAsType(MappingHintGroupType)
		 *         .targetMMSection.oclAsType(metamodel::Section(S, C, R, A))
		 *         .extend->includes(self.target.getContainingSection())
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'The target attribute \'' + self.target.name + '\' is not part of the target section referenced by parent hint group ' +
		 *           self.oclContainer()
		 *           .oclAsType(MappingHintGroupType).name + '!'
		 *         else null
		 *         endif
		 *       in
		 *         'AttributeMapping::targetAttributeMatchesSection'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@Nullable*/ Object CAUGHT_status;
		try {
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@Thrown*/ TargetSectionAttribute target = this.getTarget();
		        final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, target);
		        final /*@Thrown*/ boolean eq = oclType.getTypeId() == TYP_OclVoid.getTypeId();
		        CAUGHT_eq = eq;
		    }
		    catch (Exception e) {
		        CAUGHT_eq = ValueUtil.createInvalidValue(e);
		    }
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_0;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_OclVoid_0 = idResolver.getClass(TypeId.OCL_VOID, null);
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		        final /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		        final /*@Thrown*/ MappingHintGroupType oclAsType = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType));
		        final /*@Thrown*/ TargetSection targetMMSection = oclAsType.getTargetMMSection();
		        final /*@Thrown*/ org.eclipse.ocl.pivot.Class oclType_0 = (org.eclipse.ocl.pivot.Class)OclAnyOclTypeOperation.INSTANCE.evaluate(executor, targetMMSection);
		        final /*@Thrown*/ boolean eq_0 = oclType_0.getTypeId() == TYP_OclVoid_0.getTypeId();
		        CAUGHT_eq_0 = eq_0;
		    }
		    catch (Exception e) {
		        CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Thrown*/ Boolean or = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);
		    if (or == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Thrown*/ Boolean status;
		    if (or) {
		        status = ValueUtil.TRUE_VALUE;
		    }
		    else {
		        /*@Caught*/ /*@NonNull*/ Object CAUGHT_eq_1;
		        try {
		            final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		            final /*@Thrown*/ TargetSectionAttribute target_0 = this.getTarget();
		            final /*@Thrown*/ Object getContainingSection = ((MetaModelElement)target_0).getContainingSection();
		            final /*@NonInvalid*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		            final /*@Thrown*/ MappingHintGroupType oclAsType_0 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_0));
		            final /*@Thrown*/ TargetSection targetMMSection_0 = oclAsType_0.getTargetMMSection();
		            final /*@Thrown*/ boolean eq_1 = getContainingSection.equals(targetMMSection_0);
		            CAUGHT_eq_1 = eq_1;
		        }
		        catch (Exception e) {
		            CAUGHT_eq_1 = ValueUtil.createInvalidValue(e);
		        }
		        /*@Caught*/ /*@NonNull*/ Object CAUGHT_includes;
		        try {
		            final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		            final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e = idResolver.getClass(MappingTables.CLSSid_Section, null);
		            final /*@NonInvalid*/ Object oclContainer_1 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		            final /*@Thrown*/ MappingHintGroupType oclAsType_1 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_1, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_1));
		            final /*@Thrown*/ TargetSection targetMMSection_1 = oclAsType_1.getTargetMMSection();
		            final /*@Thrown*/ Section oclAsType_2 = ClassUtil.nonNullState((Section)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, targetMMSection_1, TYP_pamtram_c_c_metamodel_c_c_Section_o_S_44_C_44_R_44_A_e));
		            final /*@Thrown*/ List<Object> extend = oclAsType_2.getExtend();
		            final /*@Thrown*/ OrderedSetValue BOXED_extend = idResolver.createOrderedSetOfAll(MappingTables.ORD_TMPLid_, extend);
		            final /*@Thrown*/ TargetSectionAttribute target_1 = this.getTarget();
		            final /*@Thrown*/ Object getContainingSection_0 = ((MetaModelElement)target_1).getContainingSection();
		            final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_extend, getContainingSection_0).booleanValue();
		            CAUGHT_includes = includes;
		        }
		        catch (Exception e) {
		            CAUGHT_includes = ValueUtil.createInvalidValue(e);
		        }
		        final /*@Thrown*/ Boolean or_0 = BooleanOrOperation.INSTANCE.evaluate(CAUGHT_eq_1, CAUGHT_includes);
		        status = or_0;
		    }
		    CAUGHT_status = status;
		}
		catch (Exception e) {
		    CAUGHT_status = ValueUtil.createInvalidValue(e);
		}
		if (CAUGHT_status instanceof InvalidValueException) {
		    throw (InvalidValueException)CAUGHT_status;
		}
		final /*@Thrown*/ boolean ne = CAUGHT_status == Boolean.FALSE;
		/*@NonInvalid*/ String message_0;
		if (ne) {
		    final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2 = idResolver.getClass(MappingTables.CLSSid_MappingHintGroupType, null);
		    final /*@Thrown*/ TargetSectionAttribute target_2 = this.getTarget();
		    final /*@Thrown*/ String name = target_2.getName();
		    final /*@NonInvalid*/ String sum = StringConcatOperation.INSTANCE.evaluate(MappingTables.STR_The_32_target_32_attribute_32_39, name);
		    final /*@NonInvalid*/ String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, MappingTables.STR__39_32_is_32_not_32_part_32_of_32_the_32_target_32_section_32_referenced_32_by_32_parent_32_hint_32_gr);
		    final /*@NonInvalid*/ Object oclContainer_2 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		    final /*@Thrown*/ MappingHintGroupType oclAsType_3 = ClassUtil.nonNullState((MappingHintGroupType)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_2, TYP_pamtram_c_c_mapping_c_c_MappingHintGroupType_2));
		    final /*@Thrown*/ String name_0 = oclAsType_3.getName();
		    final /*@NonInvalid*/ String sum_1 = StringConcatOperation.INSTANCE.evaluate(sum_0, name_0);
		    final /*@NonInvalid*/ String sum_2 = StringConcatOperation.INSTANCE.evaluate(sum_1, MappingTables.STR__33);
		    message_0 = sum_2;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MappingTables.STR_AttributeMapping_c_c_targetAttributeMatchesSection, this, null, diagnostics, context, message_0, MappingTables.INT_4, CAUGHT_status, MappingTables.INT_0).booleanValue();
		return Boolean.TRUE == logDiagnostic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return ((InternalEList<?>)getSourceAttributeMappings()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				return getExpression();
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				return getResultModifier();
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return getSourceAttributeMappings();
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
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				setExpression((String)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				getResultModifier().clear();
				getResultModifier().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				setTarget((TargetSectionAttribute)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				getSourceAttributeMappings().clear();
				getSourceAttributeMappings().addAll((Collection<? extends AttributeMappingSourceInterface>)newValue);
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
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				getResultModifier().clear();
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				setTarget((TargetSectionAttribute)null);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				getSourceAttributeMappings().clear();
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
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				return resultModifier != null && !resultModifier.isEmpty();
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				return target != null;
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return sourceAttributeMappings != null && !sourceAttributeMappings.isEmpty();
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
				case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION: return MappingPackage.EXPRESSION_HINT__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (derivedFeatureID) {
				case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER: return MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER;
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
				case MappingPackage.EXPRESSION_HINT__EXPRESSION: return MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION;
				default: return -1;
			}
		}
		if (baseClass == ModifiableHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER: return MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER;
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
			case MappingPackage.ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
			case MappingPackage.ATTRIBUTE_MAPPING___GET_EXTERNAL_SOURCE_ELEMENTS:
				return getExternalSourceElements();
			case MappingPackage.ATTRIBUTE_MAPPING___TARGET_ATTRIBUTE_MATCHES_SECTION__DIAGNOSTICCHAIN_MAP_3:
				return targetAttributeMatchesSection((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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

} //AttributeMappingImpl
