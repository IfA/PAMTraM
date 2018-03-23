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
package pamtram;

import org.eclipse.emf.common.util.EList;

import pamtram.structure.library.LibraryEntry;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A TargetSectionModel contains a list of TargetSections which can act as the right-hand side (RHS) of a Mapping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.TargetSectionModel#getLibraryElements <em>Library Elements</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getTargetSectionModel()
 * @model
 * @generated
 */
public interface TargetSectionModel extends SectionModel<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Library Elements</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.library.LibraryEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of LibraryElement-based TargetSections defined by this SectionModel.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Library Elements</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getTargetSectionModel_LibraryElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<LibraryEntry> getLibraryElements();
} // TargetSectionModel
