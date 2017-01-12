/**
 */
package pamtram.mapping.modifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match To Lower Case Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.MatchToLowerCaseConverter#getRegex <em>Regex</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getMatchToLowerCaseConverter()
 * @model
 * @generated
 */
public interface MatchToLowerCaseConverter extends ValueModifier {
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
	 * @see pamtram.mapping.modifier.ModifierPackage#getMatchToLowerCaseConverter_Regex()
	 * @model required="true"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link pamtram.mapping.modifier.MatchToLowerCaseConverter#getRegex <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex</em>' attribute.
	 * @see #getRegex()
	 * @generated
	 */
	void setRegex(String value);

} // MatchToLowerCaseConverter
