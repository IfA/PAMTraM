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
package pamtram.structure.source;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.structure.generic.Reference;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Source Section Reference</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference of a source model element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.SourceSectionReference#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionReference()
 * @model abstract="true"
 * @generated
 */
public interface SourceSectionReference
		extends Reference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Ignore Unmatched Elements</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ignore Unmatched Elements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This determines the matching behavior in the case that there are source model elements that are not covered by one of the Classes specified as 'value' for this Reference.
	 * <br /><br />
	 * If this is set to 'true', the source model excerpt will nonetheless be declared a match for this SourceSection.
	 * <br />
	 * If this is set to 'false', the source model excerpt will NOT be declared a match. This means, that all source model elements referenced via this Reference need to matched against Classes specified as 'value' for this Reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ignore Unmatched Elements</em>' attribute.
	 * @see #setIgnoreUnmatchedElements(boolean)
	 * @see pamtram.structure.source.SourcePackage#getSourceSectionReference_IgnoreUnmatchedElements()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIgnoreUnmatchedElements();

	/**
	 * Sets the value of the '{@link pamtram.structure.source.SourceSectionReference#isIgnoreUnmatchedElements <em>Ignore Unmatched Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore Unmatched Elements</em>' attribute.
	 * @see #isIgnoreUnmatchedElements()
	 * @generated
	 */
	void setIgnoreUnmatchedElements(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (!(this instanceof &lt;%pamtram.structure.generic.ActualReference%&gt;&lt;?, ?, ?, ?&gt; &amp;&amp; this instanceof &lt;%pamtram.structure.generic.CompositeReference%&gt;&lt;?, ?, ?, ?&gt;)) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%java.util.List%&gt;&lt;&lt;%org.eclipse.emf.ecore.EReference%&gt;&gt; actualCrossReferences = this.getOwningClass().getAllCrossReferences().stream()\r\n\t\t.filter(r -&gt; r instanceof ActualReference&lt;?, ?, ?, ?&gt;)\r\n\t\t.map(r -&gt; ((ActualReference&lt;?, ?, ?, ?&gt;) r).getEReference()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nboolean isComplemented = actualCrossReferences.stream()\r\n\t\t.anyMatch(r -&gt; r != null &amp;&amp; r.equals(((ActualReference&lt;?, ?, ?, ?&gt;) this).getEReference()));\r\n\r\nboolean result = !isComplemented || this.isIgnoreUnmatchedElements();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"This reference is complemented by a CrossReference that represents the same EReference. Hence, \'ignoreUmatchedElements\' needs to be set to \'true\'!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t&lt;%pamtram.structure.source.util.SourceValidator%&gt;.SOURCE_SECTION_REFERENCE__VALIDATE_IS_IGNORE_UNMATCHED_IF_IS_COMPLEMENTED,\r\n\t\t\terrorMessage, new Object[] { this, &lt;%pamtram.structure.source.SourcePackage%&gt;.Literals.SOURCE_SECTION_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateIsIgnoreUnmatchedIfIsComplemented(DiagnosticChain diagnostics, Map<?, ?> context);

} // SourceSectionReference
