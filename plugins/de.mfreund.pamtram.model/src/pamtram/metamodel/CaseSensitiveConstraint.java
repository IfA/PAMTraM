/**
 */
package pamtram.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Sensitive Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.CaseSensitiveConstraint#isCaseSensitive <em>Case Sensitive</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getCaseSensitiveConstraint()
 * @model abstract="true"
 * @generated
 */
public interface CaseSensitiveConstraint extends AttributeValueConstraint {
	/**
	 * Returns the value of the '<em><b>Case Sensitive</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Sensitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Sensitive</em>' attribute.
	 * @see #setCaseSensitive(boolean)
	 * @see pamtram.metamodel.MetamodelPackage#getCaseSensitiveConstraint_CaseSensitive()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isCaseSensitive();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.CaseSensitiveConstraint#isCaseSensitive <em>Case Sensitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Sensitive</em>' attribute.
	 * @see #isCaseSensitive()
	 * @generated
	 */
	void setCaseSensitive(boolean value);

} // CaseSensitiveConstraint
