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
package pamtram.mapping.extended;

import pamtram.NamedElement;
import pamtram.mapping.GlobalAttribute;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.constraint.ValueConstraintSourceInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Variable Importer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This specifies a source element whose value is based on the value of a GlobalAttribute. GlobalAttributes can thereby be used to store the value of a SourceSectionAttribute in a reusable way.
 * <br />
 * The value of a GlobalAttribute can thereby be reused in various calculations (e.g. in AttributeMappings). In contrast to the 'local' usage of an Attribute value in a calculation, GlobalAttributes can be reused as part of any Mapping - the Attribute does not need to be part of the SourceSection associated with the Mapping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.GlobalAttributeImporter#getGlobalAttribute <em>Global Attribute</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getGlobalAttributeImporter()
 * @model
 * @generated
 */
public interface GlobalAttributeImporter extends NamedElement, AttributeMappingSourceInterface, InstanceSelectorSourceInterface, ValueConstraintSourceInterface {
	/**
	 * Returns the value of the '<em><b>Global Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The GlobalAttribute based on which the value of this element is determined.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Global Attribute</em>' reference.
	 * @see #setGlobalAttribute(GlobalAttribute)
	 * @see pamtram.mapping.extended.ExtendedPackage#getGlobalAttributeImporter_GlobalAttribute()
	 * @model required="true"
	 * @generated
	 */
	GlobalAttribute getGlobalAttribute();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.GlobalAttributeImporter#getGlobalAttribute <em>Global Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Attribute</em>' reference.
	 * @see #getGlobalAttribute()
	 * @generated
	 */
	void setGlobalAttribute(GlobalAttribute value);

} // GlobalAttributeImporter
