/**
 */
package pamtram.structure.source;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CompositeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Composite Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference (as an instance of an EReference) of a source model element structure. CompositeReferences can be used to describe the tree that is the basis of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionCompositeReference()
 * @model
 * @generated
 */
public interface SourceSectionCompositeReference extends CompositeReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, SourceSectionReference, ActualReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
} // SourceSectionCompositeReference
