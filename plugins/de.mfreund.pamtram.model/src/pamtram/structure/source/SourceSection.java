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
package pamtram.structure.source;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import pamtram.DeactivatableElement;
import pamtram.mapping.MappingType;
import pamtram.structure.generic.Section;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A special SourceSectionClass that represents the root element (as an instance of an EClass) of an element structure in a source model.
 * <br />
 * Note: Every specified source model structure must contain one and only one SourceSection element (its root element).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.SourceSection#getReferencingMappings <em>Referencing Mappings</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSection()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='isReferencedByMapping'"
 * @generated
 */
public interface SourceSection extends SourceSectionClass, Section<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, DeactivatableElement {

	/**
	 * Returns the value of the '<em><b>Referencing Mappings</b></em>' reference list.
	 * The list contents are of type {@link pamtram.mapping.MappingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Mappings</em>' reference list.
	 * @see pamtram.structure.source.SourcePackage#getSourceSection_ReferencingMappings()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\nList&lt;&lt;%pamtram.mapping.Mapping%&gt;&gt; mappings = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\r\nif (this.eResource() != null) {\r\n\r\n\tmappings = this.eResource().getResourceSet().getResources().stream()\r\n\t\t\t.filter(r -&gt; r.getContents().get(0) instanceof pamtram.PAMTraM)\r\n\t\t\t.flatMap(r -&gt; ((pamtram.PAMTraM) r.getContents().get(0)).getMappings().stream())\r\n\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n}\r\n\r\nList&lt;Mapping&gt; referencingMappings = mappings.stream().filter(m -&gt; this.equals(m.getSourceSection())).collect(Collectors.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList%&gt;&lt;&gt;(this, &lt;%pamtram.structure.source.SourcePackage%&gt;.Literals.SOURCE_SECTION__REFERENCING_MAPPINGS,\r\n\t\treferencingMappings.size(), referencingMappings.toArray());'"
	 * @generated
	 */
	EList<MappingType> getReferencingMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = !this.getReferencingMappings().isEmpty();\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The section is not referenced by any mapping!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.WARNING,\r\n\t\t\t&lt;%pamtram.structure.source.util.SourceValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tSourceValidator.SOURCE_SECTION__VALIDATE_IS_REFERENCED_BY_MAPPING,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.source.SourcePackage%&gt;.Literals.SOURCE_SECTION }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateIsReferencedByMapping(DiagnosticChain diagnostics, Map<?, ?> context);
} // SourceSection
