/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;
import pamtram.metamodel.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hint Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.MappingHintGroup#getMappingHints <em>Mapping Hints</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroup#getTargetMMSection <em>Target MM Section</em>}</li>
 *   <li>{@link pamtram.mapping.MappingHintGroup#getModelConnectionMatcher <em>Model Connection Matcher</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroup()
 * @model
 * @generated
 */
public interface MappingHintGroup extends NamedElement {
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
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroup_MappingHints()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingHint> getMappingHints();

	/**
	 * Returns the value of the '<em><b>Target MM Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target MM Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target MM Section</em>' reference.
	 * @see #setTargetMMSection(TargetSectionClass)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroup_TargetMMSection()
	 * @model
	 * @generated
	 */
	TargetSectionClass getTargetMMSection();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroup#getTargetMMSection <em>Target MM Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target MM Section</em>' reference.
	 * @see #getTargetMMSection()
	 * @generated
	 */
	void setTargetMMSection(TargetSectionClass value);

	/**
	 * Returns the value of the '<em><b>Model Connection Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Connection Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Connection Matcher</em>' containment reference.
	 * @see #setModelConnectionMatcher(ModelConnectionHint)
	 * @see pamtram.mapping.MappingPackage#getMappingHintGroup_ModelConnectionMatcher()
	 * @model containment="true"
	 * @generated
	 */
	ModelConnectionHint getModelConnectionMatcher();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingHintGroup#getModelConnectionMatcher <em>Model Connection Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Connection Matcher</em>' containment reference.
	 * @see #getModelConnectionMatcher()
	 * @generated
	 */
	void setModelConnectionMatcher(ModelConnectionHint value);

} // MappingHintGroup
