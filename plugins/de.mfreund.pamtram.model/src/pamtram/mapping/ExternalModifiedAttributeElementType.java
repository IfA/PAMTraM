/**
 */
package pamtram.mapping;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getExternalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesContainerSection'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot sourceAttributeMatchesContainerSection='self.source.oclAsType(pamtram::metamodel::SourceSectionAttribute).getContainingSection().oclAsType(pamtram::metamodel::SourceSectionClass).isContainerForGeneric(self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection.oclAsType(pamtram::metamodel::SourceSectionClass))'"
 * @generated
 */
public interface ExternalModifiedAttributeElementType<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ModifiedAttributeElementType<C, R, A> {
} // ExternalModifiedAttributeElementType
