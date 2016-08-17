/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple References Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.metamodel.MetamodelPackage#getMultipleReferencesAttributeValueConstraint()
 * @model abstract="true"
 * @generated
 */
public interface MultipleReferencesValueConstraint extends ValueConstraint {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true" refValueRequired="true" refValueMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!MultipleReferencesAttributeValueConstraint!checkConstraint(String,http://www.eclipse.org/ocl/2015/Library!OrderedSet[String]_1)'"
	 * @generated
	 */
	boolean checkConstraint(String attrValue, EList<String> refValue);
} // MultipleReferencesAttributeValueConstraint
