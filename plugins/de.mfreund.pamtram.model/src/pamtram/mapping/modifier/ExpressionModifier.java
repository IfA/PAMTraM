/**
 */
package pamtram.mapping.modifier;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.ExpressionModifier#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getExpressionModifier()
 * @model
 * @generated
 */
public interface ExpressionModifier extends NumericModifier {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see pamtram.mapping.modifier.ModifierPackage#getExpressionModifier_Expression()
	 * @model default="" required="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link pamtram.mapping.modifier.ExpressionModifier#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // ExpressionModifier
