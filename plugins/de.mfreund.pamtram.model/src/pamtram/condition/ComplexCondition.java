/**
 */
package pamtram.condition;

import org.eclipse.emf.common.util.EList;
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
	 * @generated
	 */
	boolean isLocalCondition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getRootCondition().eContainer() instanceof Mapping;'"
	 * @generated
	 */
	boolean isMappingCondition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getRootCondition().eContainer() instanceof ConditionModel;'"
	 * @generated
	 */
	boolean isConditionModelCondition();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	EList<ComplexCondition> getConditionPartsFlat();

	/**
	 * This iterates upward in the containment hierarchy and determines the <em>root condition</em> of this,
	 * i.e. the condition for that {@link #eContainer()} returns anything but a {@link ComplexCondition}.
	 * 
	 * @return The <em>root condition</em>.
	 */
	public ComplexCondition getRootCondition();
} // ComplexCondition
