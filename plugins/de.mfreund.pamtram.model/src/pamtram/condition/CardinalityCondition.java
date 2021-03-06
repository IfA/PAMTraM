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
package pamtram.condition;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this.target == null || this.getLocalSection() == null || this.followExternalReferences) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.source.SourceSection%&gt; sourceSection = this.getLocalSection();\r\n\r\nboolean result = true;\r\nString errorMessage = \"\";\r\n\r\nif (this.isLocalCondition() &amp;&amp; !sourceSection.equals(this.target.getContainingSection())\r\n\t\t&amp;&amp; !sourceSection.getAllExtend().contains(this.target.getContainingSection())) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The target Class is not part of the SourceSection specified by this Mapping. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n} else if (this.isLocalCondition() &amp;&amp; this.target instanceof &lt;%pamtram.structure.generic.CrossReference%&gt;&lt;?, ?, ?, ?&gt;) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The target Reference is a Cross Reference. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n} else if (this.getReferenceMatchSpec().parallelStream()\r\n\t\t.anyMatch(r -&gt; r instanceof CrossReference&lt;?, ?, ?, ?&gt;)) {\r\n\r\n\tresult = false;\r\n\terrorMessage = \"The specified Reference Match Spec contains Cross References. This is not allowed unless \'followExternalReferences\' is set to \'true\'.\";\r\n\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.condition.util.ConditionValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tConditionValidator.CARDINALITY_CONDITION__VALIDATE_REFERENCE_MATCH_SPEC_PRESENT_IN_CASE_OF_AMBIGUOUS_SOURCE,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.condition.ConditionPackage%&gt;.Literals.CONDITION__TARGET }));\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateReferenceMatchSpecPresentInCaseOfAmbiguousSource(DiagnosticChain diagnostics, Map<?, ?> context);

} // SectionCondition
