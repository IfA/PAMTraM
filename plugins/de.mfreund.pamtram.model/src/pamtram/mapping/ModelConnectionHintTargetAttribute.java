/**
 */
package pamtram.mapping;

import pamtram.metamodel.TargetSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Connection Hint Target Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getModelConnectionHintTargetAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceMatchesPossibleContainerType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL sourceMatchesPossibleContainerType='self.source.oclContainer().oclAsType(pamtram::metamodel::Class).eClass.eAllContainments->exists(r : ecore::EReference | r.eReferenceType.isSuperTypeOf(self.oclContainer().oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection.eClass))'"
 * @generated
 */
public interface ModelConnectionHintTargetAttribute extends ModifiedAttributeElementType<TargetSectionAttribute> {
} // ModelConnectionHintTargetAttribute
