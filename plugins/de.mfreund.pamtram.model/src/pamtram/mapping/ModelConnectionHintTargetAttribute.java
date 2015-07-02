/**
 */
package pamtram.mapping;

import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Connection Hint Target Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getModelConnectionHintTargetAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceMatchesPossibleContainerType'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot sourceMatchesPossibleContainerType='self.source.oclAsType(pamtram::metamodel::TargetSectionAttribute).oclContainer().oclAsType(pamtram::metamodel::Class).eClass.eAllContainments->exists(r : ecore::EReference | r.eReferenceType.isSuperTypeOf(self.oclContainer().oclContainer().oclAsType(pamtram::mapping::MappingHintGroupType).targetMMSection.eClass))'"
 * @generated
 */
public interface ModelConnectionHintTargetAttribute extends ModifiedAttributeElementType<TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {
} // ModelConnectionHintTargetAttribute
