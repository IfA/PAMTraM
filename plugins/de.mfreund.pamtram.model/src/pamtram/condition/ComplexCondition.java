/**
 */
package pamtram.condition;

import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getComplexCondition()
 * @model abstract="true"
 * @generated
 */
public interface ComplexCondition extends NamedElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/condition!ComplexCondition!isLocalCondition()'"
	 * @generated
	 */
	boolean isLocalCondition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.eContainer() instanceof Mapping;'"
	 * @generated
	 */
	boolean isMappingCondition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.eContainer() instanceof Mapping;'"
	 * @generated
	 */
	boolean isConditionModelCondition();
} // ComplexCondition
