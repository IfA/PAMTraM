/**
 */
package pamtram.mapping.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getSourceAttributeMappings <em>Source Attribute Mappings</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.mapping.impl.AttributeMappingImpl#getResultModifier <em>Result Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeMappingImpl extends MappingHintImpl implements AttributeMapping {
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
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;
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
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return getSourceAttributeMappings();
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				return getExpression();
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				return getResultModifier();
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
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				setTarget((TargetSectionAttribute)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				getSourceAttributeMappings().clear();
				getSourceAttributeMappings().addAll((Collection<? extends AttributeMappingSourceInterface>)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				setExpression((String)newValue);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				getResultModifier().clear();
				getResultModifier().addAll((Collection<? extends AttributeValueModifierSet>)newValue);
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
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				setTarget((TargetSectionAttribute)null);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				getSourceAttributeMappings().clear();
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				getResultModifier().clear();
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
			case MappingPackage.ATTRIBUTE_MAPPING__TARGET:
				return target != null;
			case MappingPackage.ATTRIBUTE_MAPPING__SOURCE_ATTRIBUTE_MAPPINGS:
				return sourceAttributeMappings != null && !sourceAttributeMappings.isEmpty();
			case MappingPackage.ATTRIBUTE_MAPPING__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case MappingPackage.ATTRIBUTE_MAPPING__RESULT_MODIFIER:
				return resultModifier != null && !resultModifier.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MappingPackage.ATTRIBUTE_MAPPING___GET_LOCAL_SOURCE_ELEMENTS:
				return getLocalSourceElements();
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
