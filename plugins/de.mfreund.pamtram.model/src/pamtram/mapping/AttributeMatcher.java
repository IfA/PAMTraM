/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMatcher()
 * @model
 * @generated
 */
public interface AttributeMatcher extends Matcher {
	/**
	 * Returns the value of the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attribute</em>' reference.
	 * @see #setSourceAttribute(Attribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_SourceAttribute()
	 * @model required="true"
	 * @generated
	 */
	Attribute getSourceAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMatcher#getSourceAttribute <em>Source Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Attribute</em>' reference.
	 * @see #getSourceAttribute()
	 * @generated
	 */
	void setSourceAttribute(Attribute value);

	/**
	 * Returns the value of the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attribute</em>' reference.
	 * @see #setTargetAttribute(Attribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_TargetAttribute()
	 * @model required="true"
	 * @generated
	 */
	Attribute getTargetAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' reference.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(Attribute value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_Modifier()
	 * @model
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifier();

} // AttributeMatcher
