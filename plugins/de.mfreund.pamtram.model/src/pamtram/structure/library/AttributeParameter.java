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
package pamtram.structure.library;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import pamtram.structure.target.ActualTargetSectionAttribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper element for a GenLibrary AttributeParameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.library.AttributeParameter#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.library.LibraryPackage#getAttributeParameter()
 * @model
 * @generated
 */
public interface AttributeParameter extends LibraryParameter<AbstractAttributeParameter<?>> {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Attribute that can be used to set the value for the AttributeParameter (either by specifying a fixed value or by means of an AttributeMapping).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(ActualTargetSectionAttribute)
	 * @see pamtram.structure.library.LibraryPackage#getAttributeParameter_Attribute()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ActualTargetSectionAttribute getAttribute();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.AttributeParameter#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(ActualTargetSectionAttribute value);

} // AttributeParameter
