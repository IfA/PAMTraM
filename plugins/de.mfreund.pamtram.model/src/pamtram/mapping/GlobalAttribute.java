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
package pamtram.mapping;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import pamtram.ModifiableElement;
import pamtram.NamedElement;
import pamtram.structure.source.ActualSourceSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * GlobalAttributes can be used to store the value of a SourceSectionAttribute in a reusable way.
 * <br />
 * The value of a GlobalAttribute can thereby be reused in various calculations (e.g. in AttributeMappings) by means of a GlobalAttributeImporter. In contrast to the 'local' usage of an Attribute value in a calculation, GlobalAttributes can be reused as part of any Mapping - the Attribute does not need to be part of the SourceSection associated with the Mapping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.MappingPackage#getGlobalAttribute()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourceAttributeHasUpperBoundOne'"
 * @generated
 */
public interface GlobalAttribute extends NamedElement, ModifiableElement {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SourceSectionAttribute based on which the value of this GlobalAttribute is determined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ActualSourceSectionAttribute)
	 * @see pamtram.mapping.MappingPackage#getGlobalAttribute_Source()
	 * @model required="true"
	 * @generated
	 */
	ActualSourceSectionAttribute getSource();

	/**
	 * Sets the value of the '{@link pamtram.mapping.GlobalAttribute#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ActualSourceSectionAttribute value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result = this.getSource() == null || this.getSource().getAttribute() == null ? true : this.getSource().getAttribute().getUpperBound() == 1;\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"Global attributes may only be defined for attributes that have an upper bound of 1!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.mapping.util.MappingValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tMappingValidator.GLOBAL_ATTRIBUTE__VALIDATE_SOURCE_ATTRIBUTE_HAS_UPPER_BOUND_ONE,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.mapping.MappingPackage%&gt;.Literals.GLOBAL_ATTRIBUTE__SOURCE }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateSourceAttributeHasUpperBoundOne(DiagnosticChain diagnostics, Map<?, ?> context);
} // GlobalVariable
