/**
 */
package pamtram.structure.source;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CrossReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Cross Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference (as an instance of an EReference) of a source model element structure. CrossReferences can be used to describe references to other element structures or to other elements of this structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionCrossReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='valuesMatchReferenceType'"
 * @generated
 */
public interface SourceSectionCrossReference extends CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, SourceSectionReference, ActualReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
} // SourceSectionCrossReference
