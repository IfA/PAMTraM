/**
 */
package pamtram.mapping;

import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.NamedElement;
import pamtram.metamodel.TargetSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiable Mapping Hint Group</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getInstantiableMappingHintGroup()
 * @model abstract="true"
 * @generated
 */
public interface InstantiableMappingHintGroup extends NamedElement, DeactivatableElement, ConditionalElement {

	public TargetSection getTargetMMSectionGeneric();
} // InstantiableMappingHintGroup
