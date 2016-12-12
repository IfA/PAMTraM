/**
 */
package pamtram.structure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple References Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.structure.StructurePackage#getMultipleReferencesValueConstraint()
 * @model abstract="true"
 * @generated
 */
public interface MultipleReferencesValueConstraint extends ValueConstraint {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true" refValueRequired="true" refValueMany="true"
	 * @generated
	 */
	boolean checkConstraint(String attrValue, EList<String> refValue);
} // MultipleReferencesAttributeValueConstraint
