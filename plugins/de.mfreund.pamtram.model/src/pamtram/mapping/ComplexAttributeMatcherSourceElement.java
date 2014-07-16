/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;

import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Attribute Matcher Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ComplexAttributeMatcherSourceElement#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.ComplexAttributeMatcherSourceElement#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getComplexAttributeMatcherSourceElement()
 * @model
 * @generated
 */
public interface ComplexAttributeMatcherSourceElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attribute</em>' reference.
	 * @see #setSourceAttribute(SourceSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getComplexAttributeMatcherSourceElement_SourceAttribute()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionAttribute getSourceAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.ComplexAttributeMatcherSourceElement#getSourceAttribute <em>Source Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Attribute</em>' reference.
	 * @see #getSourceAttribute()
	 * @generated
	 */
	void setSourceAttribute(SourceSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Modifiers</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifiers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifiers</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getComplexAttributeMatcherSourceElement_Modifiers()
	 * @model
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifiers();

} // ComplexAttributeMatcherSourceElement
