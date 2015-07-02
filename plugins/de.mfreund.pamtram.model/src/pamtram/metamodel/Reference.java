/**
 */
package pamtram.metamodel;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.Reference#getEReference <em>EReference</em>}</li>
 *   <li>{@link pamtram.metamodel.Reference#getOwningClass <em>Owning Class</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eReferenceMatchesParentEClass'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot eReferenceMatchesParentEClass='if self.isLibraryEntry() then true else self.oclContainer().oclAsType(pamtram::metamodel::Class).eClass.oclAsType(ecore::EClass).eAllReferences->includes(self.eReference) endif'"
 * @generated
 */
public interface Reference<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends MetaModelElement<C, R, A> {
	/**
	 * Returns the value of the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference</em>' reference.
	 * @see #setEReference(EReference)
	 * @see pamtram.metamodel.MetamodelPackage#getReference_EReference()
	 * @model required="true"
	 * @generated
	 */
	EReference getEReference();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Reference#getEReference <em>EReference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference</em>' reference.
	 * @see #getEReference()
	 * @generated
	 */
	void setEReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Owning Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Class</em>' container reference.
	 * @see pamtram.metamodel.MetamodelPackage#getReference_OwningClass()
	 * @see pamtram.metamodel.Class#getReferences
	 * @model opposite="references" transient="false" changeable="false"
	 * @generated
	 */
	C getOwningClass();

} // Reference
