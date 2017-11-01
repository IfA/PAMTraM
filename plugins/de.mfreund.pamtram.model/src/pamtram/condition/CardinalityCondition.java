/**
 */
package pamtram.condition;

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
 * This condition can be used to check the cardinality of a Class (how often the class is present in the matched source model excerpt).
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getCardinalityCondition()
 * @model
 * @generated
 */
public interface CardinalityCondition extends Condition<MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> {

} // SectionCondition
