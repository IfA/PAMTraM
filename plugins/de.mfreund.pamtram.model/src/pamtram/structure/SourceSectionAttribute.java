/**
 */
package pamtram.structure;

import org.eclipse.emf.common.util.EList;

import pamtram.structure.generic.Attribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.SourceSectionAttribute#getValueConstraint <em>Value Constraint</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getSourceSectionAttribute()
 * @model abstract="true"
 * @generated
 */
public interface SourceSectionAttribute extends Attribute<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Value Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.ValueConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Constraint</em>' containment reference list.
	 * @see pamtram.structure.StructurePackage#getSourceSectionAttribute_ValueConstraint()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueConstraint> getValueConstraint();
} // SourceSectionAttribute
