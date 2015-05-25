/**
 */
package pamtram.mapping;

import pamtram.metamodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getExternalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesContainerSection'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL sourceAttributeMatchesContainerSection='self.source.oclAsType(pamtram::metamodel::MetaModelElement).getContainingSection().isContainerForGeneric(self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection)'"
 * @generated
 */
public interface ExternalModifiedAttributeElementType<AttributeType extends Attribute> extends ModifiedAttributeElementType<AttributeType> {
} // ExternalModifiedAttributeElementType
