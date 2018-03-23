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

import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Instance Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SourceInstanceSelectors can be used to select a certain subset of a list of source model excerpts that have been matched for a certain SourceSection in the course of a transformation.
 * The specific use case for this selection depends on the concrete sub-type of this class.
 * <br />
 * <br />
 * The selection process is based on the comparison of the value of a certain attribute of the matched SourceSections with a reference value. The reference value is thereby calculated based on the list of specified 'sourceElements'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.SourceInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}</li>
 *   <li>{@link pamtram.structure.SourceInstanceSelector#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.StructurePackage#getSourceInstanceSelector()
 * @model
 * @generated
 */
public interface SourceInstanceSelector extends InstanceSelector {

	/**
	 * Returns the value of the '<em><b>Reference Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specific attribute of the matched SourceSections whose value is compared with the reference value used by this selector.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Attribute</em>' reference.
	 * @see #setReferenceAttribute(SourceSectionAttribute)
	 * @see pamtram.structure.StructurePackage#getSourceInstanceSelector_ReferenceAttribute()
	 * @model
	 * @generated
	 */
	SourceSectionAttribute getReferenceAttribute();

	/**
	 * Sets the value of the '{@link pamtram.structure.SourceInstanceSelector#getReferenceAttribute <em>Reference Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Attribute</em>' reference.
	 * @see #getReferenceAttribute()
	 * @generated
	 */
	void setReferenceAttribute(SourceSectionAttribute value);

	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SourceSectionClass one of whose matched instances shall be selected.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(SourceSectionClass)
	 * @see pamtram.structure.StructurePackage#getSourceInstanceSelector_TargetClass()
	 * @model required="true"
	 * @generated
	 */
	SourceSectionClass getTargetClass();

	/**
	 * Sets the value of the '{@link pamtram.structure.SourceInstanceSelector#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(SourceSectionClass value);
} // SourceInstanceSelector
