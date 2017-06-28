/**
 */
package pamtram.structure.constraint;

import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Value Constraint External Source
 * Element</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A concrete type of 'sourceElement' to calculate the reference value of a ValueConstraint.<br />
 * This type is based on the value of an 'external' attribute.
 * <br /><br />
 * Note: See the documentation of 'ExternalDynamicSourceElement' for a detailed explanation of the meaning of 'external' source elements.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getValueConstraintExternalSourceElement()
 * @model
 * @generated
 */
public interface ValueConstraintExternalSourceElement extends ExternalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, ValueConstraintSourceInterface {
} // AttributeValueConstraintExternalSourceElement
