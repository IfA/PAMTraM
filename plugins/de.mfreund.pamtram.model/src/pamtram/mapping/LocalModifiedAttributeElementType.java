/**
 */
package pamtram.mapping;

import pamtram.metamodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getLocalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesSectionOrContainedSection'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL sourceAttributeMatchesSectionOrContainedSection='self.source.oclAsType(pamtram::metamodel::MetaModelElement).getContainingSection() = self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection or self.source.oclAsType(pamtram::metamodel::MetaModelElement).getContainingSection().isContainedInGeneric(self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection)'"
 * @generated
 */
public interface LocalModifiedAttributeElementType<AttributeType extends Attribute> extends ModifiedAttributeElementType<AttributeType> {
} // LocalModifiedAttributeElementType
