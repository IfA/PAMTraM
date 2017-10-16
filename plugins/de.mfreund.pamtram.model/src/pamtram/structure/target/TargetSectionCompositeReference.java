/**
 */
package pamtram.structure.target;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CompositeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Composite Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference (as an instance of an EReference) of an element structure to be created in a target model. CompositeReferences can be used to describe the tree that is the basis of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.target.TargetPackage#getTargetSectionCompositeReference()
 * @model
 * @generated
 */
public interface TargetSectionCompositeReference extends CompositeReference<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>, TargetSectionReference, ActualReference<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {
} // TargetSectionCompositeReference
