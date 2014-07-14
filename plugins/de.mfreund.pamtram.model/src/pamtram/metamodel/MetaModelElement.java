/**
 */
package pamtram.metamodel;

import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.metamodel.MetamodelPackage#getMetaModelElement()
 * @model abstract="true"
 * @generated
 */
public interface MetaModelElement extends NamedElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='MetaModelElement element = this;\r\n\t\t\r\n// move upwards in the hierarchy\r\nwhile(element.eContainer() instanceof MetaModelElement) {\r\n\telement = (MetaModelElement) element.eContainer();\r\n}\r\n\r\nif(element instanceof pamtram.metamodel.Class &&\r\n\t\telement.eContainer() instanceof SectionModel) {\r\n\t// we have found the section\r\n\treturn (pamtram.metamodel.Class) element;\r\n} else {\r\n\t// something went wrong\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	pamtram.metamodel.Class getContainingSection();
} // MetaModelElement
