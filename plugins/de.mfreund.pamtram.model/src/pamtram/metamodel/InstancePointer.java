/**
 */
package pamtram.metamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Pointer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.InstancePointer#getAttributePointer <em>Attribute Pointer</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer()
 * @model
 * @generated
 */
public interface InstancePointer extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute Pointer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Pointer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Pointer</em>' reference.
	 * @see #setAttributePointer(SourceSectionAttribute)
	 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer_AttributePointer()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!InstancePointer!attributePointer'"
	 * @generated
	 */
	SourceSectionAttribute getAttributePointer();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.InstancePointer#getAttributePointer <em>Attribute Pointer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Pointer</em>' reference.
	 * @see #getAttributePointer()
	 * @generated
	 */
	void setAttributePointer(SourceSectionAttribute value);

} // InstancePointer
