/**
 */
package pamtram.mapping;

import pamtram.NamedElement;
import pamtram.ReferenceableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.GlobalValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getGlobalValue()
 * @model
 * @generated
 */
public interface GlobalValue extends NamedElement, ReferenceableElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see pamtram.mapping.MappingPackage#getGlobalValue_Value()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!GlobalValue!value'"
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link pamtram.mapping.GlobalValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

} // GlobalValue
