/**
 */
package pamtram.condition;

import pamtram.ConditionalElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A condition that allows to check whether another 'ConditionalElement' was applied/executed a certain number of times.
 * <br /><br />
 * This can e.g. be used to create dependencies between mappings like "Only execute this mapping, if another mapping was applied for a certain part of a source model".
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getApplicationDependency()
 * @model
 * @generated
 */
public interface ApplicationDependency extends Condition<ConditionalElement> {

} // ApplicationDependency
