/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link pamtram.mapping.AttributeMatcher#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see pamtram.mapping.MappingPackage#getAttributeMatcher()
 * @model
 * @generated
 */
public interface AttributeMatcher extends Matcher, ExpressionHint, ModifiableHint, ExpandableHint {
	/**
	 * Returns the value of the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attribute</em>' reference.
	 * @see #setTargetAttribute(TargetSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_TargetAttribute()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionAttribute getTargetAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.AttributeMatcher#getTargetAttribute <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' reference.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(TargetSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Source Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeMatcherSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attributes</em>' containment reference list.
	 * @see pamtram.mapping.MappingPackage#getAttributeMatcher_SourceAttributes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AttributeMatcherSourceInterface> getSourceAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AttributeMatcherSourceElement> elements= new org.eclipse.emf.common.util.BasicEList<AttributeMatcherSourceElement>();\r\n\t\t\t\t\r\n\t\t\t\tfor(AttributeMatcherSourceInterface i : this.getSourceAttributes()){\r\n\t\t\t\t\tif(i instanceof AttributeMatcherSourceElement){\r\n\t\t\t\t\t\telements.add((AttributeMatcherSourceElement) i);\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\t\t\t\t\r\n\t\t\t\treturn elements;'"
	 * @generated
	 */
	EList<AttributeMatcherSourceElement> getLocalSourceElements();

} // AttributeMatcher
