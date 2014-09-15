/**
 */
package pamtram.mapping;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match To Lower Case Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.MatchToLowerCaseConverter#getRegex <em>Regex</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getMatchToLowerCaseConverter()
 * @model
 * @generated
 */
public interface MatchToLowerCaseConverter extends AttributeValueModifier {
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
	 * @see pamtram.mapping.MappingPackage#getMatchToLowerCaseConverter_Regex()
	 * @model required="true"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MatchToLowerCaseConverter#getRegex <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex</em>' attribute.
	 * @see #getRegex()
	 * @generated
	 */
	void setRegex(String value);

} // MatchToLowerCaseConverter
