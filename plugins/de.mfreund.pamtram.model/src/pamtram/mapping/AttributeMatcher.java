/**
 */
package pamtram.mapping;

import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMatcher()
 * @model abstract="true"
 * @generated
 */
public interface AttributeMatcher extends Matcher, ExpandableHint {
	/**
	 * Returns the value of the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attribute</em>' reference.
	 * @see #setTargetAttribute(TargetSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_TargetAttribute()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTargetAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' reference.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(TargetSectionAttribute value);

} // AttributeMatcher
