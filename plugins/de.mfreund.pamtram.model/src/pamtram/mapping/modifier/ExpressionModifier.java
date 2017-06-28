/**
 */
package pamtram.mapping.modifier;

import pamtram.ExpressionElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This ValueModifier will modify the (numeric) 'value' by applying the given 'expression'.
 * <br /><br />
 * Note: The 'value' to be modfied can be referenced in the 'expression' via the variable 'x'. For example, a valid expression to duplicate the given value would be "2*x".
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getExpressionModifier()
 * @model
 * @generated
 */
public interface ExpressionModifier extends NumericModifier, ExpressionElement {

} // ExpressionModifier
