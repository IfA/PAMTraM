/**
 */
package pamtram.mapping;

import pamtram.metamodel.TargetSectionNonContainmentReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappingInstanceSelector#getAffectedReference <em>Affected Reference</em>}</li>
 *   <li>{@link pamtram.mapping.MappingInstanceSelector#getMatcher <em>Matcher</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='affectedReferenceIsNonContainment affectedReferenceMatchesSection'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot affectedReferenceIsNonContainment='not self.affectedReference.eReference.oclAsType(ecore::EReference).containment' affectedReferenceMatchesSection='if self.oclContainer().oclIsKindOf(pamtram::mapping::MappingHintGroupType) then self.affectedReference.getContainingSection() = self.oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection else self.affectedReference.getContainingSection() = self.oclContainer().oclAsType(pamtram::mapping::MappingHintGroupImporter).hintGroup.targetMMSection endif'"
 * @generated
 */
public interface MappingInstanceSelector extends MappingHint {
	/**
	 * Returns the value of the '<em><b>Affected Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Reference</em>' reference.
	 * @see #setAffectedReference(TargetSectionNonContainmentReference)
	 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector_AffectedReference()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionNonContainmentReference getAffectedReference();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingInstanceSelector#getAffectedReference <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Reference</em>' reference.
	 * @see #getAffectedReference()
	 * @generated
	 */
	void setAffectedReference(TargetSectionNonContainmentReference value);

	/**
	 * Returns the value of the '<em><b>Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher</em>' containment reference.
	 * @see #setMatcher(Matcher)
	 * @see pamtram.mapping.MappingPackage#getMappingInstanceSelector_Matcher()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Matcher getMatcher();

	/**
	 * Sets the value of the '{@link pamtram.mapping.MappingInstanceSelector#getMatcher <em>Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher</em>' containment reference.
	 * @see #getMatcher()
	 * @generated
	 */
	void setMatcher(Matcher value);

} // MappingInstanceSelector
