/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.InstancePointer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.Condition#getAdditionalConditionSpecification <em>Additional Condition Specification</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getComparator <em>Comparator</em>}</li>
 *   <li>{@link pamtram.condition.Condition#getDefaultSetting <em>Default Setting</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getCondition()
 * @model abstract="true"
 * @generated
 */
public interface Condition extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Additional Condition Specification</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Condition Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Condition Specification</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getCondition_AdditionalConditionSpecification()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!Condition!additionalConditionSpecification'"
	 * @generated
	 */
	EList<InstancePointer> getAdditionalConditionSpecification();

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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!Condition!comparator'"
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
	 * Returns the value of the '<em><b>Default Setting</b></em>' attribute.
	 * The literals are from the enumeration {@link pamtram.condition.CondSettingEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Setting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Setting</em>' attribute.
	 * @see pamtram.condition.CondSettingEnum
	 * @see #setDefaultSetting(CondSettingEnum)
	 * @see pamtram.condition.ConditionPackage#getCondition_DefaultSetting()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!Condition!defaultSetting'"
	 * @generated
	 */
	CondSettingEnum getDefaultSetting();

	/**
	 * Sets the value of the '{@link pamtram.condition.Condition#getDefaultSetting <em>Default Setting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Setting</em>' attribute.
	 * @see pamtram.condition.CondSettingEnum
	 * @see #getDefaultSetting()
	 * @generated
	 */
	void setDefaultSetting(CondSettingEnum value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!Condition!checkCondition(http://mfreund.de/pamtram/condition!ComplexCondition)'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!Condition!value'"
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
