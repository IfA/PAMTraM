/**
 */
package pamtram.mapping;

import pamtram.DeactivatableElement;
import pamtram.NamedElement;
import pamtram.metamodel.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingType#getSourceMMSection <em>Source MM Section</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingType()
 * @model abstract="true"
 * @generated
 */
public interface MappingType extends NamedElement, DeactivatableElement {
	/**
	 * Returns the value of the '<em><b>Source MM Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source MM Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source MM Section</em>' reference.
	 * @see #setSourceMMSection(SourceSectionClass)
	 * @see pamtram.mapping.MappingPackage#getMappingType_SourceMMSection()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionClass getSourceMMSection();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingType#getSourceMMSection <em>Source MM Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source MM Section</em>' reference.
	 * @see #getSourceMMSection()
	 * @generated
	 */
	void setSourceMMSection(SourceSectionClass value);

} // MappingType
