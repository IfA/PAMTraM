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
package pamtram.structure;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import pamtram.ExpressionElement;
import pamtram.ModifiableElement;
import pamtram.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Instance Pointer</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pamtram.structure.InstanceSelector#getTarget <em>Attribute Pointer</em>}</li>
 * <li>{@link pamtram.structure.InstanceSelector#getSourceAttributes <em>Source Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getInstancePointer()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore
 *        constraints='noModifiedAttributeElementTypesInConditionModelConditions'"
 * @generated
 */
public interface InstanceSelector extends NamedElement, ExpressionElement, ModifiableElement {
	/**
	 * Returns the value of the '<em><b>Source Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.InstanceSelectorSourceInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of 'sourceElements' based on which the reference value used by this selector is calculated.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source Elements</em>' containment reference list.
	 * @see pamtram.structure.StructurePackage#getInstanceSelector_SourceElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceSelectorSourceInterface> getSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.eContainer() instanceof &lt;%pamtram.condition.ComplexCondition%&gt; &amp;&amp; ((ComplexCondition) this.eContainer()).isConditionModelCondition() ? this.getSourceElements().parallelStream().noneMatch(s -&gt; s instanceof pamtram.structure.DynamicSourceElement) : true;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"ModifiedAttributeElementTypes are not allowed as part of ConditionModelConditions!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.structure.util.StructureValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tStructureValidator.INSTANCE_SELECTOR__VALIDATE_NO_MODIFIED_ATTRIBUTE_ELEMENT_TYPES_IN_CONDITION_MODEL_CONDITIONS,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.INSTANCE_SELECTOR__SOURCE_ELEMENTS }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNoModifiedAttributeElementTypesInConditionModelConditions(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&gt;(\r\n\t\tthis.getSourceElements().stream().filter(i -&gt; i instanceof InstanceSelectorSourceElement)\r\n\t\t\t\t.map(i -&gt; (InstanceSelectorSourceElement) i).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));'"
	 * @generated
	 */
	EList<InstanceSelectorSourceElement> getLocalSourceElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new &lt;%org.eclipse.emf.common.util.BasicEList%&gt;&lt;&gt;(\r\n\t\tthis.getSourceElements().stream().filter(i -&gt; i instanceof InstanceSelectorExternalSourceElement)\r\n\t\t\t\t.map(i -&gt; (InstanceSelectorExternalSourceElement) i).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));'"
	 * @generated
	 */
	EList<InstanceSelectorExternalSourceElement> getExternalSourceElements();

} // InstanceSelector
