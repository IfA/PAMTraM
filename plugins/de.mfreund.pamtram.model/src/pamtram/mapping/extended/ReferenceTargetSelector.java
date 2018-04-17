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
package pamtram.mapping.extended;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ReferenceTargetSelector</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingHint that tells the transformation algorithm how determine the target value(s)/instance(s) of a TargetSectionCrossReference in the course of a transformation.
 * <br /><br />
 * The target instances are thereby determined based on the specified 'matcher'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.ReferenceTargetSelector#getAffectedReference <em>Affected Reference</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getReferenceTargetSelector()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='affectedReferenceIsNonContainment affectedReferenceMatchesSection'"
 * @generated
 */
public interface ReferenceTargetSelector extends MappingHint, TargetInstanceSelector {

	/**
	 * Returns the value of the '<em><b>Affected Reference</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affected Reference</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The TargetSectionCrossReference whose target values are determined
	 * by this ReferenceTargetSelector. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Affected Reference</em>' reference.
	 * @see #setAffectedReference(TargetSectionCrossReference)
	 * @see pamtram.mapping.extended.ExtendedPackage#getReferenceTargetSelector_AffectedReference()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionCrossReference getAffectedReference();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.ReferenceTargetSelector#getAffectedReference <em>Affected Reference</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Reference</em>' reference.
	 * @see #getAffectedReference()
	 * @generated
	 */
	void setAffectedReference(TargetSectionCrossReference value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null ? true : !this.getAffectedReference().getEReference().isContainment();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The affected reference \'\" + this.getAffectedReference().getName() + \"\' is no non-containment reference!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tExtendedValidator.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_IS_NON_CONTAINMENT,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateAffectedReferenceIsNonContainment(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.getAffectedReference() == null) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.target.TargetSection%&gt; targetSection = this.eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt; ? ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getTargetSection() : ((&lt;%pamtram.mapping.MappingHintGroupImporter%&gt;) this.eContainer()).getHintGroup().getTargetSection();\r\n\r\nboolean result = targetSection == null ? true : this.getAffectedReference().getContainingSection() == targetSection || targetSection.getAllExtend().contains(this.getAffectedReference().getContainingSection());\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString hintGroupName = this.eContainer() instanceof &lt;%pamtram.mapping.MappingHintGroupType%&gt; ? ((&lt;%pamtram.mapping.MappingHintGroupType%&gt;) this.eContainer()).getName() : ((&lt;%pamtram.mapping.MappingHintGroupImporter%&gt;) this.eContainer()).getHintGroup().getName();\r\n\tString errorMessage = \"The affected reference \'\" + this.getAffectedReference().getName() + \"\' is not part of the target section referenced by parent hint group \'\" + hintGroupName + \"\'!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.REFERENCE_TARGET_SELECTOR__VALIDATE_AFFECTED_REFERENCE_MATCHES_SECTION,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.extended.ExtendedPackage%&gt;.Literals.REFERENCE_TARGET_SELECTOR__AFFECTED_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateAffectedReferenceMatchesSection(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// If an \'affectedReference\' has already been set for this \'TargetInstanceSelector\', allow only\r\n\t\t// those choices\r\n\t\t// that are compatible with the selected reference.\r\n\t\t//\r\n\t\tif (this.getAffectedReference() == null || this.getAffectedReference().getEReference() == null\r\n\t\t\t\t|| this.getTargetClass() == null || this.getTargetClass().getEClass() == null) {\r\n\t\t\treturn true;\r\n\t\t}\r\n\r\tboolean result = this.getAffectedReference().getEReference().getEReferenceType()\r\n\t\t\t\t.isSuperTypeOf(this.targetClass.getEClass());\r\n\r\tif (!result &amp;&amp; diagnostics != null) {\r\n\r\t\tString errorMessage = \"The specified \'targetClass\' is not compatible with the specified \'affectedReference\'!\";\r\n\r\t\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\t&lt;%pamtram.mapping.extended.util.ExtendedValidator%&gt;.REFERENCE_TARGET_SELECTOR__VALIDATE_TARGET_CLASS, errorMessage,\r\n\t\t\t\t\tnew Object[] { this, &lt;%pamtram.structure.StructurePackage%&gt;.Literals.TARGET_INSTANCE_SELECTOR__TARGET_CLASS }));\r\n\t\t}\r\n\r\treturn result;'"
	 * @generated
	 */
	boolean validateTargetClass(DiagnosticChain diagnostics, Map<?, ?> context);

} // MappingInstanceSelector
