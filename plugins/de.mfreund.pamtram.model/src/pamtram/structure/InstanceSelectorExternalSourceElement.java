/**
 */
package pamtram.structure;

import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Pointer External Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A concrete type of 'sourceElement' to calculate the reference value used by an InstanceSelector.<br />
 * This type is based on the value of an 'external' attribute.
 * <br /><br />
 * Note: See the documentation of 'ExternalDynamicSourceElement' for a detailed explanation of the meaning of 'external' source elements.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.StructurePackage#getInstanceSelectorExternalSourceElement()
 * @model
 * @generated
 */
public interface InstanceSelectorExternalSourceElement extends ExternalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, InstanceSelectorSourceInterface {
} // InstanceSelectorExternalSourceElement
