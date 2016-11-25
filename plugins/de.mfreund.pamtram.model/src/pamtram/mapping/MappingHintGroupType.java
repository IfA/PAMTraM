/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.metamodel.TargetSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getTargetSection <em>Target Section</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getMappingHints <em>Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroupType#getExtend <em>Extend</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType()
 * @model abstract="true"
 * @generated
 */
public interface MappingHintGroupType extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target MM Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Section</em>' reference.
	 * @see #setTargetSection(TargetSection)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_TargetSection()
	 * @model required="true"
	 * @generated
	 */
	TargetSection getTargetSection();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroupType#getTargetSection <em>Target Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Section</em>' reference.
	 * @see #getTargetSection()
	 * @generated
	 */
	void setTargetSection(TargetSection value);

	/**
	 * Returns the value of the '<em><b>Mapping Hints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping Hints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping Hints</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_MappingHints()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHint> getMappingHints();

	/**
	 * Returns the value of the '<em><b>Extend</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingHintGroupType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extend</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extend</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroupType_Extend()
	 * @model
	 * @generated
	 */
	EList<MappingHintGroupType> getExtend();

} // MappingHintGroupType
