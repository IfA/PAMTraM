/**
 */
package pamtram.metamodel;

import pamtram.NamedElement;
import pamtram.SectionModel;

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='MetaModelElement element = this;\r\n\t\t\r\n// move upwards in the hierarchy\r\nwhile(element.eContainer() instanceof MetaModelElement) {\r\n\telement = (MetaModelElement) element.eContainer();\r\n}\r\n\r\nif(element instanceof pamtram.metamodel.Class &&\r\n\t\t(element.eContainer() instanceof SectionModel || element.eContainer() instanceof ContainerParameter)) {\r\n\t// we have found the section\r\n\treturn (pamtram.metamodel.Class) element;\r\n} else if((element instanceof TargetSectionAttribute && element.eContainer() instanceof AttributeParameter) || \r\n\t\t(element instanceof TargetSectionNonContainmentReference) && element.eContainer() instanceof ExternalReferenceParameter) {\r\n\tLibraryEntry libEntry = (LibraryEntry) element.eContainer().eContainer();\r\n\tfor (LibraryParameter param : libEntry.getParameters()) {\r\n\t\t//TODO if multiple container parameters exist, there might need to be additional logic\r\n\t\tif(param instanceof ContainerParameter) {\r\n\t\t\treturn ((ContainerParameter) param).getClass_();\r\n\t\t}\r\n\t}\r\n\treturn null;\r\n} else {\r\n\t// something went wrong\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	pamtram.metamodel.Class getContainingSection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='Class section = this.getContainingSection();\r\n\r\nEObject container = section.eContainer();\r\nwhile(!(container instanceof SectionModel)) {\r\n\t// we have reached the root element\r\n\tif(container == null) {\r\n\t\treturn null;\r\n\t}\r\n\tcontainer = container.eContainer();\r\n}\r\nreturn (SectionModel) container;'"
	 * @generated
	 */
	SectionModel getContainingSectionModel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (this.getContainingSection().eContainer() instanceof ContainerParameter);'"
	 * @generated
	 */
	boolean isLibraryEntry();
} // MetaModelElement
