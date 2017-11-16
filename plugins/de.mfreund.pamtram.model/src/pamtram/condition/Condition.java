/**
 */
package pamtram.condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.ConditionalElement;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.MappingHint;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.source.SourcePackage;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Condition</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> The super type for all Condition types that are not only simple logical compositions of
 * sub-conditions. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.condition.Condition#getValue <em>Value</em>}</li>
 * <li>{@link pamtram.condition.Condition#getComparator <em>Comparator</em>}</li>
 * <li>{@link pamtram.condition.Condition#getTarget <em>Target</em>}</li>
 * <li>{@link pamtram.condition.Condition#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getCondition()
 * @model abstract="true"
 * @generated
 */
public interface Condition<TargetType> extends ComplexCondition {

	/**
	 * Returns the value of the '<em><b>Comparator</b></em>' attribute. The literals are from the enumeration
	 * {@link pamtram.condition.ComparatorEnum}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparator</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Together with the defined 'value', this specifies how often/for
	 * how many of the elements matched for the specified 'target' element this Condition needs to be fulfilled. <br />
	 * <br />
	 * For example, if 'value' is set to '1' and 'comparator is set to 'GE', the condition needs to be fulfilled at
	 * least once. <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Comparator</em>' attribute.
	 * @see pamtram.condition.ComparatorEnum
	 * @see #setComparator(ComparatorEnum)
	 * @see pamtram.condition.ConditionPackage#getCondition_Comparator()
	 * @model
	 * @generated
	 */
	ComparatorEnum getComparator();

	/**
	 * Sets the value of the '{@link pamtram.condition.Condition#getComparator <em>Comparator</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Comparator</em>' attribute.
	 * @see pamtram.condition.ComparatorEnum
	 * @see #getComparator()
	 * @generated
	 */
	void setComparator(ComparatorEnum value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The element on which this condition is evaluated. <br />
	 * <br />
	 * Note: As the specified 'target' element may be matched multiple times in a source model, additional restrictions
	 * on how often this condition should be met may be specified via the 'value' and 'comparator' attributes. <!--
	 * end-model-doc -->
	 *
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Object)
	 * @see pamtram.condition.ConditionPackage#getCondition_Target()
	 * @model kind="reference" required="true"
	 * @generated
	 */
	TargetType getTarget();

	/**
	 * Sets the value of the '{@link pamtram.condition.Condition#getTarget <em>Target</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetType value);

	/**
	 * Returns the value of the '<em><b>Instance Selectors</b></em>' containment reference list. The list contents are
	 * of type {@link pamtram.structure.SourceInstanceSelector}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selectors</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> A list of InstanceSelectors that can be used to restrict the
	 * application of this condition: <br />
	 * The specified 'target' element may be matched multiple times in a source model. However, the Condition will only
	 * evaluated for those matches that are identified by the specified list of InstanceSelectors. <!-- end-model-doc
	 * -->
	 *
	 * @return the value of the '<em>Instance Selectors</em>' containment reference list.
	 * @see pamtram.condition.ConditionPackage#getCondition_InstanceSelectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceInstanceSelector> getInstanceSelectors();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true"
	 * @generated
	 */
	boolean checkCondition(ComplexCondition condition);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. The default value is <code>"1"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Together with the defined 'comparator', this specifies how
	 * often/for how many of the elements matched for the specified 'target' element this Condition needs to be
	 * fulfilled. <br />
	 * <br />
	 * For example, if 'value' is set to '1' and 'comparator is set to 'GE', the condition needs to be fulfilled at
	 * least once. <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see pamtram.condition.ConditionPackage#getCondition_Value()
	 * @model default="1"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link pamtram.condition.Condition#getValue <em>Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * This returns the {@link SourceSection} that is affected by the condition, i.e. the SourceSection that contains
	 * the {@link Condition#getTarget() target} of the Condition.
	 *
	 * @return The affected {@link SourceSection}.
	 * @throws ConditionEvaluationException
	 *             If the condition could not be evaluated.
	 */
	public default SourceSection getAffectedSection() throws ConditionEvaluationException {

		if (this.getTarget() == null) {
			return null;
		}

		if (this instanceof CardinalityCondition || this instanceof AttributeCondition) {

			return this.getTarget() instanceof SourceSection ? (SourceSection) this.getTarget()
					: (SourceSection) AgteleEcoreUtil.getAncestorOfType((EObject) this.getTarget(),
							SourcePackage.Literals.SOURCE_SECTION);

		} else if (this instanceof ApplicationDependency) {

			Mapping mapping = this.getTarget() instanceof Mapping ? (Mapping) this.getTarget()
					: (Mapping) AgteleEcoreUtil.getAncestorOfKind((EObject) this.getTarget(),
							MappingPackage.Literals.MAPPING);

			return mapping == null ? null : mapping.getSourceSection();
		} else {
			throw new ConditionEvaluationException("Unknown condition type '" + this.eClass().getName() + "' found!");
		}
	}

	/**
	 * This returns the {@link SourceSection} that is referenced by the {@link Mapping} containing this Condition.
	 *
	 * @return The local {@link SourceSection} or 'null' if non could be determined.
	 */
	public default SourceSection getLocalSection() {

		Mapping mapping = (Mapping) AgteleEcoreUtil.getAncestorOfKind(this, MappingPackage.Literals.MAPPING);

		return mapping != null ? mapping.getSourceSection() : null;
	}

	/**
	 * This returns the {@link SourceSectionClass SourceSectionClasses} that are affected by the condition.
	 * <p />
	 * <ol>
	 * <li>For a {@link CardinalityCondition} pointed at a...</li>
	 * <ol>
	 * <li>Class, this is the Class itself</li>
	 * <li>Attribute, this is the Class holding the Attribute</li>
	 * <li>Reference, these are the classes referenced as 'value' by the Reference which is the target of the
	 * condition</li>
	 * </ol>
	 * <li>For an {@link AttributeCondition}, this is the Class holding the attribute that is the target of the
	 * condition</li>
	 * <li>For an {@link ApplicationDependency}, this is the {@link SourceSection} referenced by the {@link Mapping}
	 * which contains the {@link ConditionalElement} targeted by the condition.
	 * </ol>
	 *
	 * @return The list of affected {@link SourceSectionClass SourceSectionClasses}.
	 * @throws ConditionEvaluationException
	 *             If the condition could not be evaluated.
	 */
	public default Set<SourceSectionClass> getAffectedClasses() throws ConditionEvaluationException {

		if (this.getTarget() == null) {
			return new HashSet<>();
		}

		List<SourceSectionClass> affectedClasses;

		if (this instanceof CardinalityCondition) {
			MetaModelElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> conditionTarget = ((CardinalityCondition) this)
					.getTarget();
			if (conditionTarget instanceof SourceSectionClass) {
				affectedClasses = Arrays.asList((SourceSectionClass) conditionTarget);
			} else if (conditionTarget instanceof SourceSectionAttribute) {
				affectedClasses = Arrays.asList((SourceSectionClass) AgteleEcoreUtil.getAncestorOfKind(conditionTarget,
						SourcePackage.Literals.SOURCE_SECTION_CLASS));
			} else if (conditionTarget instanceof SourceSectionReference) {
				affectedClasses = new ArrayList<>(((SourceSectionReference) conditionTarget).getValuesGeneric());
			} else {
				throw new ConditionEvaluationException("Unsupported type of target for a CardinalityCondition '"
						+ conditionTarget.eClass().getName() + "' found!");
			}
		} else if (this instanceof AttributeCondition) {
			affectedClasses = Arrays.asList((SourceSectionClass) ((AttributeCondition) this).getTarget().eContainer());
		} else if (this instanceof ApplicationDependency) {
			ConditionalElement conditionalElement = ((ApplicationDependency) this).getTarget();
			if (conditionalElement instanceof Mapping) {
				affectedClasses = Arrays.asList(((Mapping) conditionalElement).getSourceSection());
			} else if (conditionalElement instanceof InstantiableMappingHintGroup) {
				affectedClasses = Arrays.asList(((Mapping) conditionalElement.eContainer()).getSourceSection());
			} else if (conditionalElement instanceof MappingHint) {
				affectedClasses = Arrays
						.asList(((Mapping) conditionalElement.eContainer().eContainer()).getSourceSection());
			} else {
				throw new ConditionEvaluationException(
						"Unknown type of ConditionalElement '" + conditionalElement.eClass().getName() + "' found!");
			}
		} else {
			throw new ConditionEvaluationException("Unknown condition type '" + this.eClass().getName() + "' found!");
		}

		return affectedClasses.stream().flatMap(c -> c.getAllConcreteExtending().stream())
				.collect(Collectors.toCollection(LinkedHashSet::new));

	}

} // Condition
