/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Attribute Value Expander</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.MappedAttributeValueExpander#getHintsToExpand <em>Hints To Expand</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpander()
 * @model abstract="true"
 * @generated
 */
public interface MappedAttributeValueExpander extends MappedAttributeValueExpanderType {

	/**
	 * Returns the value of the '<em><b>Hints To Expand</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hints To Expand</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hints To Expand</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpander_HintsToExpand()
	 * @model required="true"
	 * @generated
	 */
	EList<AttributeMapping> getHintsToExpand();

} // MappedAttributeValueExpander
