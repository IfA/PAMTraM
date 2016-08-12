/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionAttribute#getValueConstraint <em>Value Constraint</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute()
 * @model abstract="true"
 * @generated
 */
public interface SourceSectionAttribute extends Attribute<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Value Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.AttributeValueConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Constraint</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute_ValueConstraint()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!SourceSectionAttribute!valueConstraint'"
	 * @generated
	 */
	EList<AttributeValueConstraint> getValueConstraint();
} // SourceSectionAttribute
