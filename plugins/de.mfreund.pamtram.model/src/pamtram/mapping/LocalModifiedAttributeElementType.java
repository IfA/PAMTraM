/**
 */
package pamtram.mapping;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Modified Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getLocalModifiedAttributeElementType()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeMatchesSectionOrContainedSection'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot sourceAttributeMatchesSectionOrContainedSection='self.source.oclAsType(pamtram::metamodel::MetaModelElement).getContainingSection() = self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection or self.source.oclAsType(pamtram::metamodel::SourceSectionAttribute).getContainingSection().oclAsType(pamtram::metamodel::SourceSectionClass).isContainedIn(self.getMappingHintGroup().oclContainer().oclAsType(pamtram::mapping::Mapping).sourceMMSection)'"
 * @generated
 */
public interface LocalModifiedAttributeElementType<C extends pamtram.metamodel.Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends ModifiedAttributeElementType<C, R, A> {
} // LocalModifiedAttributeElementType
