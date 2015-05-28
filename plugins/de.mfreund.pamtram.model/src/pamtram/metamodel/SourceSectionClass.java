/**
 */
package pamtram.metamodel;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionClass#getOwningContainmentReference <em>Owning Containment Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass()
 * @model
 * @generated
 */
public interface SourceSectionClass extends pamtram.metamodel.Class<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Owning Containment Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Containment Reference</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Containment Reference</em>' reference.
	 * @see #setOwningContainmentReference(SourceSectionContainmentReference)
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionClass_OwningContainmentReference()
	 * @model
	 * @generated
	 */
	SourceSectionContainmentReference getOwningContainmentReference();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SourceSectionClass#getOwningContainmentReference <em>Owning Containment Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Containment Reference</em>' reference.
	 * @see #getOwningContainmentReference()
	 * @generated
	 */
	void setOwningContainmentReference(SourceSectionContainmentReference value);
	
	
} // SourceSectionClass
