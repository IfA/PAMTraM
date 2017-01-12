/**
 */
package pamtram.mapping;

import org.eclipse.emf.common.util.EList;

import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.SourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Attribute Value Expander</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.MappedAttributeValueExpander#getHintsToExpand <em>Hints To Expand</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpander()
 * @model abstract="true"
 * @generated
 */
public interface MappedAttributeValueExpander extends HintImporterMappingHint {

	/**
	 * Returns the value of the '<em><b>Hints To Expand</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.ExpandableHint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hints To Expand</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hints To Expand</em>' reference list.
	 * @see pamtram.mapping.MappingPackage#getMappedAttributeValueExpander_HintsToExpand()
	 * @model required="true"
	 * @generated
	 */
	EList<ExpandableHint> getHintsToExpand();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this instanceof LocalMappedAttributeValueExpander) {\r\n\treturn ((LocalMappedAttributeValueExpander) this).getSource();\r\n} else if(this instanceof ExternalMappedAttributeValueExpander) {\r\n\treturn ((ExternalMappedAttributeValueExpander) this).getSource();\r\n} else {\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	SourceSectionAttribute getSourceAttribute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this instanceof LocalMappedAttributeValueExpander) {\r\n\treturn ((LocalMappedAttributeValueExpander) this).getModifier();\r\n} else if(this instanceof ExternalMappedAttributeValueExpander) {\r\n\treturn ((ExternalMappedAttributeValueExpander) this).getModifier();\r\n} else {\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	EList<ValueModifierSet> getModifiers();

} // MappedAttributeValueExpander
