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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tMetaModelElement element = this;\r\n\t\t\t\t\r\n\t\t// move upwards in the hierarchy\r\n\t\twhile(element.eContainer() instanceof MetaModelElement) {\r\n\t\t\telement = (MetaModelElement) element.eContainer();\r\n\t\t}\r\n\t\t\r\n\t\tif(element instanceof pamtram.metamodel.Class &&\r\n\t\t\t\t(element.eContainer() instanceof SectionModel || element.eContainer() instanceof ContainerParameter)) {\r\n\t\t\t// we have found the section\r\n\t\t\treturn (pamtram.metamodel.Class) element;\r\n\t\t} else if((element instanceof TargetSectionAttribute && element.eContainer() instanceof AttributeParameter) || \r\n\t\t\t\t(element instanceof TargetSectionNonContainmentReference) && element instanceof ExternalReferenceParameter) {\r\n\t\t\tLibraryEntry libEntry = (LibraryEntry) element.eContainer().eContainer();\r\n\t\t\tfor (LibraryParameter param : libEntry.getParameters()) {\r\n\t\t\t\t//TODO if multiple container parameters exist, there might need to be additional logic\r\n\t\t\t\tif(param instanceof ContainerParameter) {\r\n\t\t\t\t\treturn ((ContainerParameter) param).getClass_();\r\n\t\t\t\t}\r\n\t\t\t}\r\n\t\t\treturn null;\r\n\t\t} else {\r\n\t\t\t// something went wrong\r\n\t\t\treturn null;\r\n\t\t}'"
	 * @generated
	 */
	pamtram.metamodel.Class getContainingSection();
} // MetaModelElement
