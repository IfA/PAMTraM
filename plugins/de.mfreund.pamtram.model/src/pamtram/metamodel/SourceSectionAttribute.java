/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.SourceSectionAttribute#getOwningClass <em>Owning Class</em>}</li>
 *   <li>{@link pamtram.metamodel.SourceSectionAttribute#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link pamtram.metamodel.SourceSectionAttribute#getValueConstraint <em>Value Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='attributeMatchesParentEClass'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot attributeMatchesParentEClass='self.oclContainer().oclAsType(pamtram::metamodel::Class).eClass.eAllAttributes->includes(self.attribute)'"
 * @generated
 */
public interface SourceSectionAttribute extends Attribute<SourceSectionClass> {
	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' reference.
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute_OwningClass()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	SourceSectionClass getOwningClass();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see pamtram.metamodel.MetamodelPackage#getSourceSectionAttribute_Attribute()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.SourceSectionAttribute#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

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
	 * @generated
	 */
	EList<AttributeValueConstraint> getValueConstraint();

} // SourceSectionAttribute
