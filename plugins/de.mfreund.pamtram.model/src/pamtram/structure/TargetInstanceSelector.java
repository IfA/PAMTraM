/**
 */
package pamtram.structure;

import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TargetInstanceSelectors can be used to select a certain subset of a list of target model excerpts that have been created based on a certain TargetSection in the course of a transformation.
 * The specific use case for this selection depends on the concrete sub-type of this class.
 * <br />
 * <br />
 * The selection process is based on the comparison of the value of a certain attribute of the created TargetSections with a reference value. The reference value is thereby calculated based on the list of specified 'sourceElements'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.TargetInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link pamtram.structure.TargetInstanceSelector#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getTargetInstanceSelector()
 * @model
 * @generated
 */
public interface TargetInstanceSelector extends InstanceSelector {
	/**
	 * Returns the value of the '<em><b>Reference Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TargetSectionClass one of whose created instances shall be selected.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Attribute</em>' reference.
	 * @see #setReferenceAttribute(TargetSectionAttribute)
	 * @see pamtram.structure.StructurePackage#getTargetInstanceSelector_ReferenceAttribute()
	 * @model
	 * @generated
	 */
	TargetSectionAttribute getReferenceAttribute();

	/**
	 * Sets the value of the '{@link pamtram.structure.TargetInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Attribute</em>' reference.
	 * @see #getReferenceAttribute()
	 * @generated
	 */
	void setReferenceAttribute(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TargetSectionClass one of whose created instances shall be selected.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(TargetSectionClass)
	 * @see pamtram.structure.StructurePackage#getTargetInstanceSelector_TargetClass()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionClass getTargetClass();

	/**
	 * Sets the value of the '{@link pamtram.structure.TargetInstanceSelector#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(TargetSectionClass value);

} // TargetInstanceSelector
