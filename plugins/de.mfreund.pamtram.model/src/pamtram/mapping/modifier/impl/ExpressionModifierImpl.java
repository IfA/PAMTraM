/**
 */
package pamtram.mapping.modifier.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.mfreund.pamtram.util.ExpressionCalculator;
import pamtram.mapping.modifier.ExpressionModifier;
import pamtram.mapping.modifier.ModifierPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Expression Modifier</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.modifier.impl.ExpressionModifierImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionModifierImpl extends NumericModifierImpl implements ExpressionModifier {

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = ExpressionModifierImpl.EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ExpressionModifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {

		return ModifierPackage.Literals.EXPRESSION_MODIFIER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getExpression() {

		return this.expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setExpressionGen(String newExpression) {

		String oldExpression = this.expression;
		this.expression = newExpression;
		if (this.eNotificationRequired()) {
			this.eNotify(new ENotificationImpl(this, Notification.SET, ModifierPackage.EXPRESSION_MODIFIER__EXPRESSION,
					oldExpression, this.expression));
		}
	}

	/**
	 * Before setting the {@link newExpression}, update the name
	 */
	@Override
	public void setExpression(String newExpression) {

		this.setNameDerived(this.expression, newExpression, "", "");
		this.setExpressionGen(newExpression);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {

		switch (featureID) {
			case ModifierPackage.EXPRESSION_MODIFIER__EXPRESSION:
				return this.getExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {

		switch (featureID) {
			case ModifierPackage.EXPRESSION_MODIFIER__EXPRESSION:
				this.setExpression((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {

		switch (featureID) {
			case ModifierPackage.EXPRESSION_MODIFIER__EXPRESSION:
				this.setExpression(ExpressionModifierImpl.EXPRESSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {

		switch (featureID) {
			case ModifierPackage.EXPRESSION_MODIFIER__EXPRESSION:
				return ExpressionModifierImpl.EXPRESSION_EDEFAULT == null ? this.expression != null
						: !ExpressionModifierImpl.EXPRESSION_EDEFAULT.equals(this.expression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {

		if (this.eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (expression: ");
		result.append(this.expression);
		result.append(')');
		return result.toString();
	}

	@Override
	public String modifyValue(String value) {

		final Map<String, Double> vars = new HashMap<>();

		// Expressions in an ExpressionModifier must contain only one variable 'x' - which is set to the given 'value'
		//
		try {
			vars.put("x", Double.valueOf(value));
		} catch (NumberFormatException e) {
			System.out.println("Error parsing double of value '" + value + "'.");
			return this.expression;
		}

		// Calculate the value
		//
		ExpressionCalculator expCalc = new ExpressionCalculator();
		return expCalc.calculateExpression(this.expression, vars);
	}

} // ExpressionModifierImpl
