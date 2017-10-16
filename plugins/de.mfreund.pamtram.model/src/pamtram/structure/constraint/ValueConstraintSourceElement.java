/**
 */
package pamtram.structure.constraint;

import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Value Constraint Source Element</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A concrete type of 'sourceElement' to calculate the reference value of a ValueConstraint.<br />
 * This type is based on the value of a 'local' attribute.
 * <br /><br />
 * Note: See the documentation of 'LocalDynamicSourceElement' for a detailed explanation of the meaning of 'local' source elements.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getValueConstraintSourceElement()
 * @model
 * @generated
 */
public interface ValueConstraintSourceElement extends LocalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, ValueConstraintSourceInterface {
} // AttributeValueConstraintSourceElement
