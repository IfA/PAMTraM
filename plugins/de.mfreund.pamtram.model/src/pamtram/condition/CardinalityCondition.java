/**
 */
package pamtram.condition;

import pamtram.MatchSpecElement;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This condition can be used to check the cardinality of an element (a Class, an Attribute, or a Reference inside a SourceSection), i.e. how often this element can be found in the current source model excerpt.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getCardinalityCondition()
 * @model
 * @generated
 */
public interface CardinalityCondition extends Condition<MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>>, MatchSpecElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

} // SectionCondition
