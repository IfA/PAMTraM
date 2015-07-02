/**
 */
package pamtram.metamodel;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.AttributeParameter#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getAttributeParameter()
 * @model
 * @generated
 */
public interface AttributeParameter extends LibraryParameter<AbstractAttributeParameter<?>> {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(ActualAttribute)
	 * @see pamtram.metamodel.MetamodelPackage#getAttributeParameter_Attribute()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ActualAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.AttributeParameter#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(ActualAttribute value);

} // AttributeParameter
