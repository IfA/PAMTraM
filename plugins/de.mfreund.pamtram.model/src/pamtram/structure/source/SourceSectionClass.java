/**
 */
package pamtram.structure.source;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.SourceSectionClass#isIncludeSubTypes <em>Include Sub Types</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionClass()
 * @model
 * @generated
 */
public interface SourceSectionClass extends pamtram.structure.generic.Class<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Include Sub Types</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Sub Types</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Sub Types</em>' attribute.
	 * @see #setIncludeSubTypes(boolean)
	 * @see pamtram.structure.source.SourcePackage#getSourceSectionClass_IncludeSubTypes()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isIncludeSubTypes();

	/**
	 * Sets the value of the '{@link pamtram.structure.source.SourceSectionClass#isIncludeSubTypes <em>Include Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Sub Types</em>' attribute.
	 * @see #isIncludeSubTypes()
	 * @generated
	 */
	void setIncludeSubTypes(boolean value);
	
	
} // SourceSectionClass
