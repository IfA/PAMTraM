/**
 */
package pamtram.structure.source;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents one element (as an instance of an EClass) of a source model element structure.
 * <br />
 * In order to allow for the description of complex element structures, Classes can be equipped with Attributes and References (which itself may reference/contain other Classes).
 * <!-- end-model-doc -->
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
	 * <!-- begin-model-doc -->
	 * Whether this shall also represent source model elements that are instances of sub-classes of the specified EClass.
	 * <!-- end-model-doc -->
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
