/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.NamedElement;
import pamtram.metamodel.SourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.ModelConnectionHint#getTargetAttributes <em>Target Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getModelConnectionHint()
 * @model abstract="true"
 * @generated
 */
public interface ModelConnectionHint extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Target Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ConnectionHintTargetAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getModelConnectionHint_TargetAttributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConnectionHintTargetAttribute> getTargetAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList<SourceSectionAttribute> sources= new org.eclipse.emf.common.util.BasicEList<SourceSectionAttribute>();\n\t\tif(this instanceof SimpleModelConnectionHint){\n\t\t\tsources.add(((SimpleModelConnectionHint)this).getSource());\n\t\t\n\t\t} else if(this instanceof ComplexModelConnectionHint){\n\t\t\tfor(ComplexModelConnectionHintSourceElement e : ((ComplexModelConnectionHint)this).getSourceElements()){\n\t\t\t\tsources.add(e.getSource());\n\t\t\t}\n\t\t}\n\t\treturn sources;'"
	 * @generated
	 */
	EList<SourceSectionAttribute> getSourceAttributes();

} // ModelConnectionHint
