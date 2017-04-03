/**
 */
package pamtram.structure.source;

import pamtram.structure.generic.VirtualAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.VirtualSourceSectionAttribute#getDerivation <em>Derivation</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getVirtualSourceSectionAttribute()
 * @model
 * @generated
 */
public interface VirtualSourceSectionAttribute extends SourceSectionAttribute, VirtualAttribute<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
	/**
	 * Returns the value of the '<em><b>Derivation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivation</em>' attribute.
	 * @see #setDerivation(String)
	 * @see pamtram.structure.source.SourcePackage#getVirtualSourceSectionAttribute_Derivation()
	 * @model required="true"
	 * @generated
	 */
	String getDerivation();

	/**
	 * Sets the value of the '{@link pamtram.structure.source.VirtualSourceSectionAttribute#getDerivation <em>Derivation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivation</em>' attribute.
	 * @see #getDerivation()
	 * @generated
	 */
	void setDerivation(String value);

} // VirtualSourceSectionAttribute
