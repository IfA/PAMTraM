/**
 */
package pamtram.mapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.ExpressionHint#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getExpressionHint()
 * @model abstract="true"
 * @generated
 */
public interface ExpressionHint extends EObject {
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
	 * @see pamtram.mapping.MappingPackage#getExpressionHint_Expression()
	 * @model default="" required="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link pamtram.mapping.ExpressionHint#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // ExpressionHint
