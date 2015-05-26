/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}</li>
 *   <li>{@link pamtram.mapping.AttributeMapping#getSourceAttributeMappings <em>Source Attribute Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMapping()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='targetAttributeMatchesSection'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot targetAttributeMatchesSection='self.target.getContainingSection() = self.oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection'"
 * @generated
 */
public interface AttributeMapping extends MappingHint, ExpressionHint, ModifiableHint, ExpandableHint {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(TargetSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTarget();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Source Attribute Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeMappingSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attribute Mappings</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getAttributeMapping_SourceAttributeMappings()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AttributeMappingSourceInterface> getSourceAttributeMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\t\tEList<AttributeMappingSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingSourceElement>();\r\n\t\t\r\n\t\tfor(AttributeMappingSourceInterface i : this.getSourceAttributeMappings()){\r\n\t\t\tif(i instanceof AttributeMappingSourceElement){\r\n\t\t\t\telements.add((AttributeMappingSourceElement) i);\r\n\t\t\t}\r\n\t\t}\r\n\t\t\r\n\t\treturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AttributeMappingExternalSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMappingExternalSourceElement>();\r\n\r\nfor(AttributeMappingSourceInterface i : this.getSourceAttributeMappings()){\r\n\tif(i instanceof AttributeMappingExternalSourceElement){\r\n\t\telements.add((AttributeMappingExternalSourceElement) i);\r\n\t}\r\n}\r\n\r\nreturn elements;'"
	 * @generated
	 */
	EList<AttributeMappingExternalSourceElement> getExternalSourceElements();

} // AttributeMapping
