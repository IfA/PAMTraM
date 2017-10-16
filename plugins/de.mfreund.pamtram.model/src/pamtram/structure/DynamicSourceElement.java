/**
 */
package pamtram.structure;

import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.mapping.Mapping;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DynamicSourceElement represents a certain value that can be used in various calculations.
 * <br /><br />
 * The dynamic value is thereby calculated based on the value of an attribute of a SourceSection (resp. the matched source model excerpt(s)). As multiple source model excerpts can be matched against a single SourceSection (and thus against a single SourceSectionAttribute), a DynamicSourceElement may actually deliver many values that will be used by the calculation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.DynamicSourceElement#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getDynamicSourceElement()
 * @model abstract="true"
 * @generated
 */
public interface DynamicSourceElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends NamedElement, ModifiableElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attribute of a SourceSection based on which the dynamic value(s) is/are calculated.
	 * <br /><br />
	 * The concrete sub-type of DynamicSourceElement poses additional constraints on the fact which SourceSectionAttributes may be used as 'source'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Attribute)
	 * @see pamtram.structure.StructurePackage#getDynamicSourceElement_Source()
	 * @model required="true"
	 * @generated
	 */
	A getSource();

	/**
	 * Sets the value of the '{@link pamtram.structure.DynamicSourceElement#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(A value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EObject ret = this.eContainer;\r\nwhile(!(ret instanceof MappingHintGroupType || ret instanceof InstantiableMappingHintGroup)) {\r\n\tret = ret.eContainer();\r\n\tif(ret instanceof PAMTraM) {\r\n\t\t// something went wrong\r\n\t\treturn null;\r\n\t}\r\n}\r\nreturn (NamedElement) ret;'"
	 * @generated
	 */
	NamedElement getMappingHintGroup();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EObject ret = this.eContainer;\r\nwhile(!(ret instanceof Mapping)) {\r\n\tret = ret.eContainer();\r\n\tif(ret instanceof PAMTraM) {\r\n\t\t// something went wrong\r\n\t\treturn null;\r\n\t}\r\n}\r\nreturn (Mapping) ret;'"
	 * @generated
	 */
	Mapping getMapping();

} // DynamicSourceElement
