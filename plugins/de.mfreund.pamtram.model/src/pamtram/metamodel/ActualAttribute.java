/**
 */
package pamtram.metamodel;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.metamodel.ActualAttribute#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.metamodel.MetamodelPackage#getActualAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='attributeMatchesParentEClass'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL attributeMatchesParentEClass='self.oclContainer().oclAsType(pamtram::metamodel::Class).eClass.eAllAttributes->includes(self.attribute)'"
 * @generated
 */
public interface ActualAttribute extends TargetSectionAttribute {
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
	 * @see pamtram.metamodel.MetamodelPackage#getActualAttribute_Attribute()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.ActualAttribute#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

} // ActualAttribute
