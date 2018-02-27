/**
 */
package pamtram.condition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Condition that evaluates to 'true' if the specified sub-condition evaluates to 'false'.
 * <br />
 * The sub-condition can be specified locally (via the 'localCondPart' reference) or globally (specified via the 'sharedCondPart' reference).
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getNot()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='referenceOnlyConditionsFromConditionModelOrFromConditionalElements'"
 * @generated
 */
public interface Not extends UnaryCondition {

} // Not
