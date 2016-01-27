/**
 */
package pamtram.metamodel;

import pamtram.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.metamodel.MetamodelPackage#getAttributeValueConstraint()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AttributeValueConstraint extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!AttributeValueConstraint!checkConstraint(String)'"
	 * @generated
	 */
	boolean checkConstraint(String attrValue);

} // AttributeValueConstraint
