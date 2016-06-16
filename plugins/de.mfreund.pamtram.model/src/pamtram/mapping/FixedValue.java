/**
 */
package pamtram.mapping;

import pamtram.NamedElement;
import pamtram.ReferenceableElement;
import pamtram.metamodel.InstancePointerSourceInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.FixedValue#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getFixedValue()
 * @model
 * @generated
 */
public interface FixedValue extends NamedElement, AttributeMappingSourceInterface, AttributeMatcherSourceInterface, ModelConnectionHintSourceInterface, InstancePointerSourceInterface, ReferenceableElement {
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
	 * @see pamtram.mapping.MappingPackage#getFixedValue_Value()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!FixedValue!value'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link pamtram.mapping.FixedValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // FixedValue
