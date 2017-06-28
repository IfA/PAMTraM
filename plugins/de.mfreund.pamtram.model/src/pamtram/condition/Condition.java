/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;
import pamtram.structure.SourceInstanceSelector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The super type for all Condition types that are not only simple logical compositions of sub-conditions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.Condition#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getComparator <em>Comparator</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getCondition()
 * @model abstract="true"
 * @generated
 */
public interface Condition<TargetType> extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Comparator</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.condition.ComparatorEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Together with the defined 'value', this specifies how often/for how many of the elements matched for the specified 'target' element this Condition needs to be fulfilled.
	 * <br /><br />
	 * For example, if 'value' is set to '1' and 'comparator is set to 'GE', the condition needs to be fulfilled at least once.
	 * <!-- end-model-doc -->
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
	 * <!-- begin-model-doc -->
	 * The element on which this condition is evaluated.
	 * <br /><br />
	 * Note: As the specified 'target' element may be matched multiple times in a source model, additional restrictions on how often this condition should be met may be specified via the 'value' and 'comparator' attributes.
	 * <!-- end-model-doc -->
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
	 * Returns the value of the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.SourceInstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of InstanceSelectors that can be used to restrict the application of this condition: 
	 * <br />
	 * The specified 'target' element may be matched multiple times in a source model. However, the Condition will only evaluated for those matches that are identified by the specified list of InstanceSelectors.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Selectors</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getCondition_InstanceSelectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceInstanceSelector> getInstanceSelectors();

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
	 * <!-- begin-model-doc -->
	 * Together with the defined 'comparator', this specifies how often/for how many of the elements matched for the specified 'target' element this Condition needs to be fulfilled.
	 * <br /><br />
	 * For example, if 'value' is set to '1' and 'comparator is set to 'GE', the condition needs to be fulfilled at least once.
	 * <!-- end-model-doc -->
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
