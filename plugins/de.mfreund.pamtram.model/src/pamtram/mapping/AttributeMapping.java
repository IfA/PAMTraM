/**
 */
package pamtram.mapping;

import pamtram.metamodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMapping()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesSection\r\ntargetAttributeMatchesSection'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL sourceAttributeMatchesSection='' targetAttributeMatchesSection='\n'"
 * @generated
 */
public interface AttributeMapping extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Attribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	Attribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Attribute value);

} // AttributeMapping
