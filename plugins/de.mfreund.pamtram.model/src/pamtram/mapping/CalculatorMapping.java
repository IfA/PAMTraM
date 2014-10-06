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
 *   <li>{@link pamtram.mapping.CalculatorMapping#getResultModifier <em>Result Modifier</em>}</li>
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
	 * The list contents are of type {@link pamtram.mapping.CalculatorMappingSourceInterface}.
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
	EList<CalculatorMappingSourceInterface> getVariables();

	/**
	 * Returns the value of the '<em><b>Result Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getCalculatorMapping_ResultModifier()
	 * @model
	 * @generated
	 */
	EList<AttributeValueModifierSet> getResultModifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\t\t\tEList<ExpressionVariable> elements= new org.eclipse.emf.common.util.BasicEList<ExpressionVariable>();\n\t\t\t\t\n\t\t\t\tfor(CalculatorMappingSourceInterface i : this.getVariables()){\n\t\t\t\t\tif(i instanceof ExpressionVariable){\n\t\t\t\t\t\telements.add((ExpressionVariable) i);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\treturn elements;'"
	 * @generated
	 */
	EList<ExpressionVariable> getLocalSourceElements();

} // CalculatorMapping
