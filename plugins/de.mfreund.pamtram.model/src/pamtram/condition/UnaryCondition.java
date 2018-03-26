/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.condition;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Condition Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Condition that is composed of exactly one sub-condition.
 * <br />
 * The sub-condition can be specified locally (via the 'localCondPart' reference) or globally (specified via the 'sharedCondPart' reference).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.condition.UnaryCondition#getLocalCondPart <em>Local Cond Part</em>}</li>
 *   <li>{@link pamtram.condition.UnaryCondition#getSharedCondPart <em>Shared Cond Part</em>}</li>
 * </ul>
 *
 * @see pamtram.condition.ConditionPackage#getUnaryCondition()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='exactlyOneArg'"
 * @generated
 */
public interface UnaryCondition extends ComplexCondition {
	/**
	 * Returns the value of the '<em><b>Local Cond Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The locally defined sub-condition.
	 * <br /><br />
	 * Note: Only one of 'localCondPart' or 'sharedCondPart' may be set!
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Local Cond Part</em>' containment reference.
	 * @see #setLocalCondPart(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getUnaryCondition_LocalCondPart()
	 * @model containment="true"
	 * @generated
	 */
	ComplexCondition getLocalCondPart();

	/**
	 * Sets the value of the '{@link pamtram.condition.UnaryCondition#getLocalCondPart <em>Local Cond Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Cond Part</em>' containment reference.
	 * @see #getLocalCondPart()
	 * @generated
	 */
	void setLocalCondPart(ComplexCondition value);

	/**
	 * Returns the value of the '<em><b>Shared Cond Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cond Part Ref</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The globally specified sub-condition.
	 * <br /><br />
	 * Note: Only one of 'localCondPart' or 'sharedCondPart' may be set!
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Shared Cond Part</em>' reference.
	 * @see #setSharedCondPart(ComplexCondition)
	 * @see pamtram.condition.ConditionPackage#getUnaryCondition_SharedCondPart()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='\r\nthis.itemPropertyDescriptors.add(\r\n\t\tnew ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) this.adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_UnaryCondition_sharedCondPart_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_UnaryCondition_sharedCondPart_description\"),\r\n\t\t\t\t&lt;%pamtram.condition.ConditionPackage%&gt;.Literals.UNARY_CONDITION__SHARED_COND_PART, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_ExtendedPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\t&lt;%java.util.List%&gt;&lt;Object&gt; choiceOfValues = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\t\t\t\tchoiceOfValues.addAll(super.getChoiceOfValues(object));\r\n\t\t\t\tfor (&lt;%java.util.Iterator%&gt;&lt;Object&gt; element = choiceOfValues.iterator(); element.hasNext();) {\r\n\t\t\t\t\t&lt;%org.eclipse.emf.ecore.EObject%&gt; choiceValue = (EObject) element.next();\r\n\t\t\t\t\tif (choiceValue == null) {\r\n\t\t\t\t\t\tcontinue;\r\n\t\t\t\t\t}\r\n\t\t\t\t\tif (!(choiceValue.eContainer() instanceof &lt;%pamtram.ConditionModel%&gt;)) {\r\n\t\t\t\t\t\telement.remove();\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\treturn choiceOfValues;\r\n\t\t\t}\r\n\t\t});'"
	 * @generated
	 */
	ComplexCondition getSharedCondPart();

	/**
	 * Sets the value of the '{@link pamtram.condition.UnaryCondition#getSharedCondPart <em>Shared Cond Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Cond Part</em>' reference.
	 * @see #getSharedCondPart()
	 * @generated
	 */
	void setSharedCondPart(ComplexCondition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getLocalCondPart() != null ^ this.getSharedCondPart() != null;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"Please specify exactly one (local or shared) condition part!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.condition.util.ConditionValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.UNARY_CONDITION__VALIDATE_EXACTLY_ONE_ARG,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.condition.ConditionPackage%&gt;.Literals.UNARY_CONDITION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateExactlyOneArg(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this.sharedCondPart == null) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%org.eclipse.emf.ecore.EObject%&gt; sharedCondPartContainer = this.sharedCondPart.eContainer();\r\n\r\nboolean result = sharedCondPartContainer instanceof &lt;%pamtram.ConditionModel%&gt;;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"Reference only Conditions that are placed inside a ConditionModel!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.condition.util.ConditionValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tConditionValidator.UNARY_CONDITION__VALIDATE_REFERENCE_ONLY_CONDITIONS_FROM_CONDITION_MODEL,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.condition.ConditionPackage%&gt;.Literals.UNARY_CONDITION__SHARED_COND_PART }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateReferenceOnlyConditionsFromConditionModel(DiagnosticChain diagnostics, Map<?, ?> context);

} // SingleConditionOperator
