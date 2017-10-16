/**
 */
package pamtram.structure.source;

import pamtram.structure.generic.Reference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Source Section Reference</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference of a source model element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.SourceSectionReference#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionReference()
 * @model abstract="true"
 * @generated
 */
public interface SourceSectionReference
		extends Reference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Ignore Unmatched Elements</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore Unmatched Elements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This determines the matching behavior in the case that there are source model elements that are not covered by one of the Classes specified as 'value' for this Reference.
	 * <br /><br />
	 * If this is set to 'true', the source model excerpt will nonetheless be declared a match for this SourceSection.
	 * <br />
	 * If this is set to 'false', the source model excerpt will NOT be declared a match. This means, that all source model elements referenced via this Reference need to matched against Classes specified as 'value' for this Reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ignore Unmatched Elements</em>' attribute.
	 * @see #setIgnoreUnmatchedElements(boolean)
	 * @see pamtram.structure.source.SourcePackage#getSourceSectionReference_IgnoreUnmatchedElements()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIgnoreUnmatchedElements();

	/**
	 * Sets the value of the '{@link pamtram.structure.source.SourceSectionReference#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore Unmatched Elements</em>' attribute.
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 */
	void setIgnoreUnmatchedElements(boolean value);

} // SourceSectionReference
