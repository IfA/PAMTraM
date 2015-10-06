/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.ModifiedAttributeElementType#getSource <em>Source</em>}</li>
 *   <li>{@link pamtram.mapping.ModifiedAttributeElementType#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getModifiedAttributeElementType()
 * @model abstract="true"
 * @generated
 */
public interface ModifiedAttributeElementType<S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Attribute)
	 * @see pamtram.mapping.MappingPackage#getModifiedAttributeElementType_Source()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!ModifiedAttributeElementType{S,C,R,A}!source'"
	 * @generated
	 */
	A getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.ModifiedAttributeElementType#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(A value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.AttributeValueModifierSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getModifiedAttributeElementType_Modifier()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/mapping!ModifiedAttributeElementType{S,C,R,A}!modifier'"
	 * @generated
	 */
	EList<AttributeValueModifierSet> getModifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EObject ret = this.eContainer;\r\nwhile(!(ret instanceof MappingHintGroupType || ret instanceof InstantiableMappingHintGroup)) {\r\n\tret = ret.eContainer();\r\n\tif(ret instanceof PAMTraM) {\r\n\t\t// something went wrong\r\n\t\treturn null;\r\n\t}\r\n}\r\nreturn (NamedElement) ret;'"
	 * @generated
	 */
	NamedElement getMappingHintGroup();

} // ModifiedAttributeElementType
