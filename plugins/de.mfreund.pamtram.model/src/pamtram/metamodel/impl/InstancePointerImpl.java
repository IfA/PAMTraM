/**
 */
package pamtram.metamodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
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
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsTypeOfOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import pamtram.condition.ComplexCondition;
import pamtram.mapping.ValueModifierSet;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.ModifiableHint;
import pamtram.mapping.impl.ExpressionHintImpl;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.InstancePointerSourceInterface;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.MetamodelTables;
import pamtram.metamodel.ActualSourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Pointer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.impl.InstancePointerImpl#getResultModifier <em>Result Modifier</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.InstancePointerImpl#getAttributePointer <em>Attribute Pointer</em>}</li>
 *   <li>{@link pamtram.metamodel.impl.InstancePointerImpl#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstancePointerImpl extends ExpressionHintImpl implements InstancePointer {
	/**
	 * The cached value of the '{@link #getResultModifier() <em>Result Modifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<ValueModifierSet> resultModifier;

	/**
	 * The cached value of the '{@link #getAttributePointer() <em>Attribute Pointer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributePointer()
	 * @generated
	 * @ordered
	 */
	protected ActualSourceSectionAttribute attributePointer;

	/**
	 * The cached value of the '{@link #getSourceAttributes() <em>Source Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<InstancePointerSourceInterface> sourceAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstancePointerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.INSTANCE_POINTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValueModifierSet> getResultModifier() {
		if (resultModifier == null) {
			resultModifier = new EObjectResolvingEList<ValueModifierSet>(ValueModifierSet.class, this, MetamodelPackage.INSTANCE_POINTER__RESULT_MODIFIER);
		}
		return resultModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute getAttributePointer() {
		if (attributePointer != null && attributePointer.eIsProxy()) {
			InternalEObject oldAttributePointer = (InternalEObject)attributePointer;
			attributePointer = (ActualSourceSectionAttribute)eResolveProxy(oldAttributePointer);
			if (attributePointer != oldAttributePointer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER, oldAttributePointer, attributePointer));
			}
		}
		return attributePointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualSourceSectionAttribute basicGetAttributePointer() {
		return attributePointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributePointer(ActualSourceSectionAttribute newAttributePointer) {
		ActualSourceSectionAttribute oldAttributePointer = attributePointer;
		attributePointer = newAttributePointer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER, oldAttributePointer, attributePointer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstancePointerSourceInterface> getSourceAttributes() {
		if (sourceAttributes == null) {
			sourceAttributes = new EObjectContainmentEList<InstancePointerSourceInterface>(InstancePointerSourceInterface.class, this, MetamodelPackage.INSTANCE_POINTER__SOURCE_ATTRIBUTES);
		}
		return sourceAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean noModifiedAttributeElementTypesInConditionModelConditions(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 * 
		 * inv noModifiedAttributeElementTypesInConditionModelConditions:
		 *   let severity : Integer[1] = 4
		 *   in
		 *     let
		 *       status : OclAny[?] = if
		 *         self.oclContainer()
		 *         .oclIsKindOf(condition::ComplexCondition) and
		 *         self.oclContainer()
		 *         .oclAsType(condition::ComplexCondition)
		 *         .isConditionModelCondition()
		 *       then
		 *         not self.sourceAttributes->exists(
		 *           self.oclIsTypeOf(mapping::ModifiedAttributeElementType(S, C, R, A)))
		 *       else true
		 *       endif
		 *     in
		 *       let
		 *         message : String[?] = if status <> true
		 *         then 'ModifiedAttributeElementTypes are not allowed as part of ConditionModelConditions!'
		 *         else null
		 *         endif
		 *       in
		 *         'InstancePointer::noModifiedAttributeElementTypesInConditionModelConditions'.logDiagnostic(self, null, diagnostics, context, message, severity, status, 0)
		 */
		final /*@NonInvalid*/ Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ IdResolver idResolver = executor.getIdResolver();
		/*@Caught*/ /*@Nullable*/ Object CAUGHT_status;
		try {
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_oclIsKindOf;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_condition_c_c_ComplexCondition = idResolver.getClass(MetamodelTables.CLSSid_ComplexCondition, null);
		        final /*@NonInvalid*/ Object oclContainer = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_pamtram_c_c_condition_c_c_ComplexCondition).booleanValue();
		        CAUGHT_oclIsKindOf = oclIsKindOf;
		    }
		    catch (Exception e) {
		        CAUGHT_oclIsKindOf = ValueUtil.createInvalidValue(e);
		    }
		    /*@Caught*/ /*@NonNull*/ Object CAUGHT_isConditionModelCondition;
		    try {
		        final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_condition_c_c_ComplexCondition_0 = idResolver.getClass(MetamodelTables.CLSSid_ComplexCondition, null);
		        final /*@NonInvalid*/ Object oclContainer_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(executor, this);
		        final /*@Thrown*/ ComplexCondition oclAsType = ClassUtil.nonNullState((ComplexCondition)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, oclContainer_0, TYP_pamtram_c_c_condition_c_c_ComplexCondition_0));
		        final /*@Thrown*/ boolean isConditionModelCondition = oclAsType.isConditionModelCondition();
		        CAUGHT_isConditionModelCondition = isConditionModelCondition;
		    }
		    catch (Exception e) {
		        CAUGHT_isConditionModelCondition = ValueUtil.createInvalidValue(e);
		    }
		    final /*@Thrown*/ Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_oclIsKindOf, CAUGHT_isConditionModelCondition);
		    if (and == null) {
		        throw new InvalidValueException("Null if condition");
		    }
		    /*@Thrown*/ Boolean status;
		    if (and) {
		        final /*@Thrown*/ List<InstancePointerSourceInterface> sourceAttributes = this.getSourceAttributes();
		        final /*@Thrown*/ OrderedSetValue BOXED_sourceAttributes = idResolver.createOrderedSetOfAll(MetamodelTables.ORD_CLSSid_InstancePointerSourceInterface, sourceAttributes);
		        /*@Thrown*/ Object accumulator = ValueUtil.FALSE_VALUE;
		        /*@NonNull*/ Iterator<Object> ITERATOR__1 = BOXED_sourceAttributes.iterator();
		        /*@Thrown*/ boolean exists;
		        while (true) {
		            if (!ITERATOR__1.hasNext()) {
		                if (accumulator == ValueUtil.FALSE_VALUE) {
		                    exists = ValueUtil.FALSE_VALUE;
		                }
		                else {
		                    throw (InvalidValueException)accumulator;
		                }
		                break;
		            }
		            /*@NonInvalid*/ InstancePointerSourceInterface _1 = (InstancePointerSourceInterface)ITERATOR__1.next();
		            /**
		             * 
		             * self.oclIsTypeOf(mapping::ModifiedAttributeElementType(S, C, R, A))
		             */
		            final /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_pamtram_c_c_mapping_c_c_ModifiedAttributeElementType_o_S_44_C_44_R_44_A_e = idResolver.getClass(MetamodelTables.CLSSid_ModifiedAttributeElementType, null);
		            final /*@NonInvalid*/ boolean oclIsTypeOf = OclAnyOclIsTypeOfOperation.INSTANCE.evaluate(executor, this, TYP_pamtram_c_c_mapping_c_c_ModifiedAttributeElementType_o_S_44_C_44_R_44_A_e).booleanValue();
		            //
		            if (oclIsTypeOf == ValueUtil.TRUE_VALUE) {					// Normal successful body evaluation result
		                exists = ValueUtil.TRUE_VALUE;
		                break;														// Stop immediately 
		            }
		            else if (oclIsTypeOf == ValueUtil.FALSE_VALUE) {				// Normal unsuccessful body evaluation result
		                ;															// Carry on
		            }
		            else {															// Impossible badly typed result
		                accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "exists");
		            }
		        }
		        final /*@Thrown*/ Boolean not = BooleanNotOperation.INSTANCE.evaluate(exists);
		        status = not;
		    }
		    else {
		        status = ValueUtil.TRUE_VALUE;
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
		    message_0 = MetamodelTables.STR_ModifiedAttributeElementTypes_32_are_32_not_32_allowed_32_as_32_part_32_of_32_Conditi;
		}
		else {
		    message_0 = null;
		}
		final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, MetamodelTables.STR_InstancePointer_c_c_noModifiedAttributeElementTypesInConditionModel, this, null, diagnostics, context, message_0, MetamodelTables.INT_4, CAUGHT_status, MetamodelTables.INT_0).booleanValue();
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
			case MetamodelPackage.INSTANCE_POINTER__SOURCE_ATTRIBUTES:
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
			case MetamodelPackage.INSTANCE_POINTER__RESULT_MODIFIER:
				return getResultModifier();
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				if (resolve) return getAttributePointer();
				return basicGetAttributePointer();
			case MetamodelPackage.INSTANCE_POINTER__SOURCE_ATTRIBUTES:
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
			case MetamodelPackage.INSTANCE_POINTER__RESULT_MODIFIER:
				getResultModifier().clear();
				getResultModifier().addAll((Collection<? extends ValueModifierSet>)newValue);
				return;
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				setAttributePointer((ActualSourceSectionAttribute)newValue);
				return;
			case MetamodelPackage.INSTANCE_POINTER__SOURCE_ATTRIBUTES:
				getSourceAttributes().clear();
				getSourceAttributes().addAll((Collection<? extends InstancePointerSourceInterface>)newValue);
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
			case MetamodelPackage.INSTANCE_POINTER__RESULT_MODIFIER:
				getResultModifier().clear();
				return;
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				setAttributePointer((ActualSourceSectionAttribute)null);
				return;
			case MetamodelPackage.INSTANCE_POINTER__SOURCE_ATTRIBUTES:
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
			case MetamodelPackage.INSTANCE_POINTER__RESULT_MODIFIER:
				return resultModifier != null && !resultModifier.isEmpty();
			case MetamodelPackage.INSTANCE_POINTER__ATTRIBUTE_POINTER:
				return attributePointer != null;
			case MetamodelPackage.INSTANCE_POINTER__SOURCE_ATTRIBUTES:
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
		if (baseClass == ModifiableHint.class) {
			switch (derivedFeatureID) {
				case MetamodelPackage.INSTANCE_POINTER__RESULT_MODIFIER: return MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER;
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
		if (baseClass == ModifiableHint.class) {
			switch (baseFeatureID) {
				case MappingPackage.MODIFIABLE_HINT__RESULT_MODIFIER: return MetamodelPackage.INSTANCE_POINTER__RESULT_MODIFIER;
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
			case MetamodelPackage.INSTANCE_POINTER___NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS__DIAGNOSTICCHAIN_MAP_1:
				return noModifiedAttributeElementTypesInConditionModelConditions((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //InstancePointerImpl
