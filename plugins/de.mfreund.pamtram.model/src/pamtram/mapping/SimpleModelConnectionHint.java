/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.SourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Model Connection Hint</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getSimpleModelConnectionHint()
 * @model
 * @generated
 */
public interface SimpleModelConnectionHint extends ModelConnectionHint, AttributeMappingSourceElementType {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\t\t\tEList<SourceSectionAttribute> sources= new org.eclipse.emf.common.util.BasicEList<SourceSectionAttribute>();\n\t\t\t\tsources.add(this.getSource());\n\t\t\t\t\n\t\t\t\treturn sources;'"
	 * @generated
	 */
	EList<SourceSectionAttribute> getSourceAttributes();
} // SimpleModelConnectionHint
