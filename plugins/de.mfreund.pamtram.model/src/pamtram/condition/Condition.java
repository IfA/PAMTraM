/**
 */
package pamtram.condition;

import pamtram.InstanceSelectingElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.Condition#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getComparator <em>Comparator</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getCondition()
 * @model abstract="true"
 * @generated
 */
public interface Condition<TargetType> extends ComplexCondition, InstanceSelectingElement {
	/**
	 * Returns the value of the '<em><b>Comparator</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.condition.ComparatorEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparator</em>' attribute.
	 * @see pamtram.condition.ComparatorEnum
	 * @see #setComparator(ComparatorEnum)
	 * @see pamtram.condition.ConditionPackage#getCondition_Comparator()
	 * @model
	 * @generated
	 */
	ComparatorEnum getComparator();

	/**
	 * Sets the value of the '{@link pamtram.condition.Condition#getComparator <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparator</em>' attribute.
	 * @see pamtram.condition.ComparatorEnum
	 * @see #getComparator()
	 * @generated
	 */
	void setComparator(ComparatorEnum value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Object)
	 * @see pamtram.condition.ConditionPackage#getCondition_Target()
	 * @model kind="reference" required="true"
	 * @generated
	 */
	TargetType getTarget();

	/**
	 * Sets the value of the '{@link pamtram.condition.Condition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean checkCondition(ComplexCondition condition);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see pamtram.condition.ConditionPackage#getCondition_Value()
	 * @model default="1"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link pamtram.condition.Condition#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

} // Condition
