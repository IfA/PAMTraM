/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calculator Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.CalculatorMapping#getExpression <em>Expression</em>}</li>
 *   <li>{@link pamtram.mapping.CalculatorMapping#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getCalculatorMapping()
 * @model
 * @generated
 */
public interface CalculatorMapping extends AttributeMapping {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see pamtram.mapping.MappingPackage#getCalculatorMapping_Expression()
	 * @model required="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link pamtram.mapping.CalculatorMapping#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ExpressionVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getCalculatorMapping_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpressionVariable> getVariables();

} // CalculatorMapping
