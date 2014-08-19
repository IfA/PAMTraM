/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Attribute Value Expander Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.MappedAttributeValueExpanderType#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.MappedAttributeValueExpanderType#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.MappedAttributeValueExpanderType#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpanderType()
 * @model abstract="true"
 * @generated
 */
public interface MappedAttributeValueExpanderType extends HintImporterMappingHint {
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
	 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpanderType_SourceAttribute()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionAttribute getSourceAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappedAttributeValueExpanderType#getSourceAttribute <em>Source Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Attribute</em>' reference.
	 * @see #getSourceAttribute()
	 * @generated
	 */
	void setSourceAttribute(SourceSectionAttribute value);

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
	 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpanderType_TargetAttribute()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTargetAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappedAttributeValueExpanderType#getTargetAttribute <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' reference.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(TargetSectionAttribute value);

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
	 * @see #isSetModifiers()
	 * @see #unsetModifiers()
	 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpanderType_Modifiers()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifiers();

	/**
	 * Unsets the value of the '{@link pamtram.mapping.MappedAttributeValueExpanderType#getModifiers <em>Modifiers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetModifiers()
	 * @see #getModifiers()
	 * @generated
	 */
	void unsetModifiers();

	/**
	 * Returns whether the value of the '{@link pamtram.mapping.MappedAttributeValueExpanderType#getModifiers <em>Modifiers</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Modifiers</em>' reference list is set.
	 * @see #unsetModifiers()
	 * @see #getModifiers()
	 * @generated
	 */
	boolean isSetModifiers();

} // MappedAttributeValueExpanderType
