/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.SourceSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ComplexModelConnectionHint#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getComplexModelConnectionHint()
 * @model
 * @generated
 */
public interface ComplexModelConnectionHint extends ModelConnectionHint {
	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ComplexModelConnectionHintSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getComplexModelConnectionHint_SourceElements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ComplexModelConnectionHintSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList<ComplexModelConnectionHintSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<ComplexModelConnectionHintSourceElement>();\n\t\t\n\t\tfor(ComplexModelConnectionHintSourceInterface i : this.getSourceElements()){\n\t\t\tif(i instanceof ComplexModelConnectionHintSourceElement){\n\t\t\t\telements.add((ComplexModelConnectionHintSourceElement) i);\n\t\t\t}\n\t\t}\n\t\t\n\t\treturn elements;'"
	 * @generated
	 */
	EList<ComplexModelConnectionHintSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\t\t\tEList<SourceSectionAttribute> sources= new org.eclipse.emf.common.util.BasicEList<SourceSectionAttribute>();\n\t\t\t\t\tfor(ComplexModelConnectionHintSourceInterface e : this.getSourceElements()){\n\t\t\t\t\t\tsources.add(e.getSourceAttribute());\n\t\t\t\t\t}\n\t\t\t\treturn sources;'"
	 * @generated
	 */
	EList<SourceSectionAttribute> getSourceAttributes();

} // ComplexModelConnectionHint
