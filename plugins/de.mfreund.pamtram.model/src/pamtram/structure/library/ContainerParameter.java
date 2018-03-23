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
package pamtram.structure.library;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import pamtram.structure.target.TargetSection;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper element for a GenLibrary ContainerParameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.library.ContainerParameter#getClass_ <em>Class</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.library.LibraryPackage#getContainerParameter()
 * @model
 * @generated
 */
public interface ContainerParameter extends LibraryParameter<AbstractContainerParameter<?, ?>> {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Class that can be used to set the value (the container) for the ContainerParameter (e.g. by means of a ContainerSelector).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class</em>' containment reference.
	 * @see #setClass(TargetSection)
	 * @see pamtram.structure.library.LibraryPackage#getContainerParameter_Class()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetSection getClass_();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.ContainerParameter#getClass_ <em>Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' containment reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(TargetSection value);

} // ContainerParameter
