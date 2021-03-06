/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.constraint;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.structure.SourceInstanceSelector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Reference Attribute Value Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ValueConstraint for which the reference value is calculated based on the combination of a list of 'sourceElements'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.SingleReferenceValueConstraint#getSourceElements <em>Source Elements</em>}</li>
 *   <li>{@link pamtram.structure.constraint.SingleReferenceValueConstraint#getInstanceSelectors <em>Instance Selectors</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getSingleReferenceValueConstraint()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='onlyFixedValuesInSourceSections onlyFixedValuesOrGlobalAttributesInConditionModel'"
 * @generated
 */
public interface SingleReferenceValueConstraint extends ValueConstraint, ExpressionElement, ModifiableElement {
	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.constraint.ValueConstraintSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of 'sourceElements' based on which the reference value for this constraint is calculated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.structure.constraint.ConstraintPackage#getSingleReferenceValueConstraint_SourceElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueConstraintSourceInterface> getSourceElements();

	/**
	 * Returns the value of the '<em><b>Instance Selectors</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.SourceInstanceSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Selectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of InstanceSelectors that can be used to restrict the application of this constraint: 
	 * <br />
	 * Only Attributes (resp. their values) identified by the list of InstanceSelectors are checked against this constraint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance Selectors</em>' containment reference list.
	 * @see pamtram.structure.constraint.ConstraintPackage#getSingleReferenceValueConstraint_InstanceSelectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceInstanceSelector> getInstanceSelectors();

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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getSourceElements().isEmpty() || \r\n\t\t!&lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.hasAncestorOfKind(this, &lt;%pamtram.structure.source.SourcePackage%&gt;.eINSTANCE.getActualSourceSectionAttribute())) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -&gt; s instanceof &lt;%pamtram.FixedValue%&gt;);\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues as source elements as it is modeled as part of a SourceSection!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t &lt;%pamtram.structure.constraint.util.ConstraintValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_IN_SOURCE_SECTIONS,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  &lt;%pamtram.structure.constraint.ConstraintPackage%&gt;.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlyFixedValuesInSourceSections(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getSourceElements().isEmpty() || \r\n\t\t!&lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.hasAncestorOfKind(this, &lt;%pamtram.condition.ConditionPackage%&gt;.eINSTANCE.getComplexCondition())) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.condition.ComplexCondition%&gt; condition = (ComplexCondition) AgteleEcoreUtil.getAncestorOfKind(this, &lt;%pamtram.condition.ConditionPackage%&gt;.eINSTANCE.getComplexCondition());\r\n\r\nif(!condition.isConditionModelCondition()) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = this.getSourceElements().parallelStream().allMatch(s -&gt; s instanceof &lt;%pamtram.FixedValue%&gt; || s instanceof &lt;%pamtram.mapping.extended.GlobalAttributeImporter%&gt;);\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\t\r\n\tString errorMessage = \"This ValueConstraint must only\"\r\n\t\t\t+ \" contain FixedValues or GlobalAttributeImporters as source elements as it is modeled as part of a condition inside a ConditionModel!\'\";\r\n\t\r\n\tdiagnostics.add\r\n\t\t(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t &lt;%pamtram.structure.constraint.util.ConstraintValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t ConstraintValidator.SINGLE_REFERENCE_VALUE_CONSTRAINT__VALIDATE_ONLY_FIXED_VALUES_OR_GLOBAL_ATTRIBUTES_IN_CONDITION_MODEL,\r\n\t\t\t errorMessage,\r\n\t\t\t new Object [] { this,  &lt;%pamtram.structure.constraint.ConstraintPackage%&gt;.Literals.SINGLE_REFERENCE_VALUE_CONSTRAINT__SOURCE_ELEMENTS }));\r\n\t}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateOnlyFixedValuesOrGlobalAttributesInConditionModel(DiagnosticChain diagnostics, Map<?, ?> context);

} // SingleReferenceAttributeValueConstraint
