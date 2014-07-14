/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ComplexAttributeMapping#getSourceAttributeMappings <em>Source Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getComplexAttributeMapping()
 * @model
 * @generated
 */
public interface ComplexAttributeMapping extends AttributeMapping {
	/**
	 * Returns the value of the '<em><b>Source Attribute Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ComplexAttribueMappingSourceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attribute Mappings</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getComplexAttributeMapping_SourceAttributeMappings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ComplexAttribueMappingSourceElement> getSourceAttributeMappings();

} // ComplexAttributeMapping
