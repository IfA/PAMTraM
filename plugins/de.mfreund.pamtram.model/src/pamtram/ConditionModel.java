/**
 */
package pamtram;

import org.eclipse.emf.common.util.EList;
import pamtram.condition.ComplexCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.ConditionModel#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getConditionModel()
 * @model
 * @generated
 */
public interface ConditionModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getConditionModel_Condition()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram!ConditionModel!condition'"
	 * @generated
	 */
	EList<ComplexCondition> getCondition();

} // ConditionModel
