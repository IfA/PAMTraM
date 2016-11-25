/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.metamodel.ActualSourceSectionAttribute;


/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ContainerSelector</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.mapping.ContainerSelector#getTargetAttributes <em>Target Attributes</em>}</li>
 * <li>{@link pamtram.mapping.ContainerSelector#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getContainerSelector()
 * @model
 * @generated
 */
public interface ContainerSelector extends MappingHintBaseType {

	/**
	 * Returns the value of the '<em><b>Target Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ContainerSelectorTargetAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getContainerSelector_TargetAttributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ContainerSelectorTargetAttribute> getTargetAttributes();

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.ContainerSelectorSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getContainerSelector_SourceElements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ContainerSelectorSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<ActualSourceSectionAttribute> getSourceAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList<ContainerSelectorSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<ContainerSelectorSourceElement>();\r\n\t\t\r\n\t\tfor(ContainerSelectorSourceInterface i : this.getSourceElements()){\r\n\t\t\tif(i instanceof ContainerSelectorSourceElement){\r\n\t\t\t\telements.add((ContainerSelectorSourceElement) i);\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn elements;'"
	 * @generated
	 */
	EList<ContainerSelectorSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<ContainerSelectorExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<>();\r\n\r\nfor(ContainerSelectorSourceInterface i : this.getSourceElements()){\r\n\tif(i instanceof ContainerSelectorExternalSourceElement){\r\n\t\telements.add((ContainerSelectorExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;'"
	 * @generated
	 */
	EList<ContainerSelectorExternalSourceElement> getExternalSourceElements();

} // ModelConnectionHint
