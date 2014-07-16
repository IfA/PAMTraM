/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ComplexAttributeMatcher#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getComplexAttributeMatcher()
 * @model
 * @generated
 */
public interface ComplexAttributeMatcher extends AttributeMatcher {
	/**
	 * Returns the value of the '<em><b>Source Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ComplexAttributeMatcherSourceElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getComplexAttributeMatcher_SourceAttributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ComplexAttributeMatcherSourceElement> getSourceAttributes();

} // ComplexAttributeMatcher
