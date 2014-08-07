/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Hint Target Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ConnectionHintTargetAttribute#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.ConnectionHintTargetAttribute#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getConnectionHintTargetAttribute()
 * @model
 * @generated
 */
public interface ConnectionHintTargetAttribute extends EObject {
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
	 * @see pamtram.mapping.MappingPackage#getConnectionHintTargetAttribute_TargetAttribute()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTargetAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.ConnectionHintTargetAttribute#getTargetAttribute <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' reference.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(TargetSectionAttribute value);

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
	 * @see pamtram.mapping.MappingPackage#getConnectionHintTargetAttribute_Modifier()
	 * @model
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifier();

} // ConnectionHintTargetAttribute
