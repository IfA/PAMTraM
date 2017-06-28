/**
 */
package pamtram.mapping.extended;

import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Mapped Attribute Value Expander</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified external 'source' Attribute.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getExternalMappedAttributeValueExpander()
 * @model abstract="true"
 * @generated
 */
public interface ExternalMappedAttributeValueExpander extends ExternalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, MappedAttributeValueExpander {
} // ExternalMappedAttributeValueExpander
