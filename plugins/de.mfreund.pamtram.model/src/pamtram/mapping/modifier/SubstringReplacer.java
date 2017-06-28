/**
 */
package pamtram.mapping.modifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Substring Replacer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This ValueModifier will modify the (String-based) 'value' by replacing the sub-string identified by the given 'regex' by the given 'replacement'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.SubstringReplacer#getRegex <em>Regex</em>}</li>
 *   <li>{@link pamtram.mapping.modifier.SubstringReplacer#getReplacement <em>Replacement</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getSubstringReplacer()
 * @model
 * @generated
 */
public interface SubstringReplacer extends StringModifier {
	/**
	 * Returns the value of the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The regular expression identifying the string to be replaced.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Regex</em>' attribute.
	 * @see #setRegex(String)
	 * @see pamtram.mapping.modifier.ModifierPackage#getSubstringReplacer_Regex()
	 * @model required="true"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link pamtram.mapping.modifier.SubstringReplacer#getRegex <em>Regex</em>}' attribute.
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
	 * <!-- begin-model-doc -->
	 * The replacement.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Replacement</em>' attribute.
	 * @see #setReplacement(String)
	 * @see pamtram.mapping.modifier.ModifierPackage#getSubstringReplacer_Replacement()
	 * @model required="true"
	 * @generated
	 */
	String getReplacement();

	/**
	 * Sets the value of the '{@link pamtram.mapping.modifier.SubstringReplacer#getReplacement <em>Replacement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replacement</em>' attribute.
	 * @see #getReplacement()
	 * @generated
	 */
	void setReplacement(String value);

} // SubstringReplacer
