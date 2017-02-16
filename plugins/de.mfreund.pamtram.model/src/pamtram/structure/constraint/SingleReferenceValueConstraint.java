/**
 */
package pamtram.structure.constraint;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.structure.InstanceSelector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Reference Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.SingleReferenceValueConstraint#getInstanceSelectors <em>Instance Selectors</em>}</li>
 *   <li>{@link pamtram.structure.constraint.SingleReferenceValueConstraint#getSourceElements <em>Source Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getSingleReferenceValueConstraint()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='onlyFixedValuesInSourceSections onlyFixedValuesOrGlobalAttributesInConditionModel'"
 * @generated
 */
public interface SingleReferenceValueConstraint extends ValueConstraint, ExpressionElement, ModifiableElement {
	/**
	 * Returns the value of the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.InstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Reference Value Additional Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Selectors</em>' containment reference list.
	 * @see pamtram.structure.constraint.ConstraintPackage#getSingleReferenceValueConstraint_InstanceSelectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceSelector> getInstanceSelectors();

	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.constraint.ValueConstraintSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.structure.constraint.ConstraintPackage#getSingleReferenceValueConstraint_SourceElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueConstraintSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true" refValueRequired="true"
	 * @generated
	 */
	boolean checkConstraint(String attrValue, String refValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getSourceElements().isEmpty() || \r\n\t\t!<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.structure.source.SourcePackage%>.eINSTANCE.getActualSourceSectionAttribute())) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof <%pamtram.FixedValue%>);\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues as source elements as it is modeled as part of a SourceSection!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.structure.constraint.util.ConstraintValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  <%pamtram.structure.constraint.ConstraintPackage%>.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlyFixedValuesInSourceSections(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getSourceElements().isEmpty() || \r\n\t\t!<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.eINSTANCE.getComplexCondition())) {\r\n\treturn true;\r\n}\r\n\r\n<%pamtram.condition.ComplexCondition%> condition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind(this, <%pamtram.condition.ConditionPackage%>.eINSTANCE.getComplexCondition());\r\n\r\nif(!condition.isConditionModelCondition()) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -> s instanceof <%pamtram.FixedValue%> || s instanceof <%pamtram.mapping.GlobalAttributeImporter%>);\r\n\r\nif (!result && diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues or GlobalAttributeImporters as source elements as it is modeled as part of a condition inside a ConditionModel!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new <%org.eclipse.emf.common.util.BasicDiagnostic%>\r\n\t\t\t(<%org.eclipse.emf.common.util.Diagnostic%>.ERROR,\r\n\t\t\t <%pamtram.structure.constraint.util.ConstraintValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\t ConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  <%pamtram.structure.constraint.ConstraintPackage%>.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlyFixedValuesOrGlobalAttributesInConditionModel(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = this.getModifiers().isEmpty() ||\r\n\t\t!<%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%>.hasAncestorOfKind(this, <%pamtram.structure.source.SourcePackage%>.eINSTANCE.getActualSourceSectionAttribute());\r\n\r\nif (!result && diagnostics != null) {\r\n\r\n\tString errorMessage = \"ValueConstraints that are part of a SourceSection must not\"\r\n\t\t\t+ \" specify a Modifier!\'\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, <%pamtram.structure.constraint.util.ConstraintValidator%>.DIAGNOSTIC_SOURCE,\r\n\t\t\tConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_NO_RESULT_MODIFIER_IN_SOURCE_SECTIONS,\r\n\t\t\terrorMessage, new Object[] { this,\r\n\t\t\t\t\t<%pamtram.PamtramPackage%>.Literals.MODIFIABLE_ELEMENT__MODIFIERS }));\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNoResultModifierInSourceSections(DiagnosticChain diagnostics, Map<?, ?> context);

} // SingleReferenceAttributeValueConstraint
