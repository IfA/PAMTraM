/**
 */
package pamtram.mapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substring Replacer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.SubstringReplacer#getRegex <em>Regex</em>}</li>
 *   <li>{@link pamtram.mapping.SubstringReplacer#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getSubstringReplacer()
 * @model
 * @generated
 */
public interface SubstringReplacer extends AttributeValueModifier {
	/**
	 * Returns the value of the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex</em>' attribute.
	 * @see #setRegex(String)
	 * @see pamtram.mapping.MappingPackage#getSubstringReplacer_Regex()
	 * @model required="true"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link pamtram.mapping.SubstringReplacer#getRegex <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex</em>' attribute.
	 * @see #getRegex()
	 * @generated
	 */
	void setRegex(String value);

	/**
	 * Returns the value of the '<em><b>Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replacement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replacement</em>' attribute.
	 * @see #setReplacement(String)
	 * @see pamtram.mapping.MappingPackage#getSubstringReplacer_Replacement()
	 * @model required="true"
	 * @generated
	 */
	String getReplacement();

	/**
	 * Sets the value of the '{@link pamtram.mapping.SubstringReplacer#getReplacement <em>Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' attribute.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(String value);

} // SubstringReplacer
