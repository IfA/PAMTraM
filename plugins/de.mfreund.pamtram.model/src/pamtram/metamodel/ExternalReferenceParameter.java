/**
 */
package pamtram.metamodel;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Reference Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.ExternalReferenceParameter#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getExternalReferenceParameter()
 * @model
 * @generated
 */
public interface ExternalReferenceParameter extends LibraryParameter<AbstractExternalReferenceParameter<?, ?>> {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' containment reference.
	 * @see #setReference(TargetSectionNonContainmentReference)
	 * @see pamtram.metamodel.MetamodelPackage#getExternalReferenceParameter_Reference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetSectionNonContainmentReference getReference();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.ExternalReferenceParameter#getReference <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' containment reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(TargetSectionNonContainmentReference value);

} // ExternalReferenceParameter
