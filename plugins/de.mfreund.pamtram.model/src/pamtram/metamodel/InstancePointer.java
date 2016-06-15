/**
 */
package pamtram.metamodel;

import org.eclipse.emf.common.util.EList;
import pamtram.mapping.ExpressionHint;
import pamtram.mapping.ModifiableHint;

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
 *   <li>{@link pamtram.metamodel.InstancePointer#getValue <em>Value</em>}</li>
 *   <li>{@link pamtram.metamodel.InstancePointer#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer()
 * @model
 * @generated
 */
public interface InstancePointer extends ExpressionHint, ModifiableHint {
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

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer_Value()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!InstancePointer!value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.InstancePointer#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Source Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.metamodel.InstancePointerSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attributes</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getInstancePointer_SourceAttributes()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!InstancePointer!sourceAttributes'"
	 * @generated
	 */
	EList<InstancePointerSourceInterface> getSourceAttributes();

} // InstancePointer
