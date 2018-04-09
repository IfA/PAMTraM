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
package pamtram.structure.target;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.VirtualReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section Any Content Composite Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a virtual reference for elements that are based on an XSD with 'xs:any' specified as content. CompositeReferences can be used to describe the tree that is the basis of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.target.TargetPackage#getTargetSectionAnyContentCompositeReference()
 * @model
 * @generated
 */
public interface TargetSectionAnyContentCompositeReference extends CompositeReference<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>, TargetSectionReference, VirtualReference<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {
  
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (!(this.eContainer() instanceof pamtram.structure.generic.Class)) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%org.eclipse.emf.ecore.EClass%&gt; parentEClass = ((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) this.eContainer()).getEClass();\r\n\r\nboolean result = parentEClass == null ? true : &lt;%de.tud.et.ifa.agtele.emf.ExtendedMetaDataUtil%&gt;.allowsAnyContent(parentEClass);\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The containing Class does not allow \'any\' content!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.target.util.TargetValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tTargetValidator.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE__VALIDATE_IS_ALLOWED, errorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.target.TargetPackage%&gt;.Literals.TARGET_SECTION_ANY_CONTENT_COMPOSITE_REFERENCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateIsAllowed(DiagnosticChain diagnostics, Map<?, ?> context);

} // TargetSectionAnyContentCompositeReference
