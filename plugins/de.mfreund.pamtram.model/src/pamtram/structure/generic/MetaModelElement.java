/**
 */
package pamtram.structure.generic;

import pamtram.NamedElement;
import pamtram.SectionModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.structure.generic.GenericPackage#getMetaModelElement()
 * @model abstract="true"
 * @generated
 */
public interface MetaModelElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends NamedElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='MetaModelElement<S,C,R,A> element = this;\r\n\r\n// move upwards in the hierarchy\r\nwhile(element.eContainer() instanceof MetaModelElement) {\r\n\telement = (MetaModelElement<S,C,R,A>) element.eContainer();\r\n}\r\n\r\nif(element instanceof Section || element.eContainer() instanceof ContainerParameter) {\r\n\t// we have found the section\r\n\treturn (S) element;\r\n} else if((element instanceof TargetSectionAttribute && (element.eContainer() instanceof AttributeParameter || element.eContainer() instanceof ResourceParameter)) || \r\n\t\t(element instanceof TargetSectionCrossReference) && element.eContainer() instanceof ExternalReferenceParameter) {\r\n\tLibraryEntry libEntry = (LibraryEntry) element.eContainer().eContainer();\r\n\tfor (LibraryParameter<?> param : libEntry.getParameters()) {\r\n\t\t//TODO if multiple container parameters exist, there might need to be additional logic\r\n\t\tif(param instanceof ContainerParameter) {\r\n\t\t\treturn (S) ((ContainerParameter) param).getClass_();\r\n\t\t}\r\n\t}\r\n\treturn null;\r\n} else  if(element instanceof VirtualTargetSectionAttribute && element.eContainer() instanceof LibraryEntry) {\r\n\tLibraryEntry libEntry = (LibraryEntry) element.eContainer();\r\n\tfor (LibraryParameter<?> param : libEntry.getParameters()) {\r\n\t\t//TODO if multiple container parameters exist, there might need to be additional logic\r\n\t\tif(param instanceof ContainerParameter) {\r\n\t\t\treturn (S) ((ContainerParameter) param).getClass_();\r\n\t\t}\r\n\t}\r\n\treturn null;\r\n} else {\r\n\t// something went wrong\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	S getContainingSection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='S section = this.getContainingSection();\r\n\r\nEObject container = section.eContainer();\r\nwhile(!(container instanceof SectionModel)) {\r\n\t// we have reached the root element\r\n\tif(container == null) {\r\n\t\treturn null;\r\n\t}\r\n\tcontainer = container.eContainer();\r\n}\r\nreturn (SectionModel<S, C, R, A>) container;'"
	 * @generated
	 */
	SectionModel<S, C, R, A> getContainingSectionModel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (this.getContainingSection().eContainer() instanceof ContainerParameter);'"
	 * @generated
	 */
	boolean isLibraryEntry();
} // MetaModelElement