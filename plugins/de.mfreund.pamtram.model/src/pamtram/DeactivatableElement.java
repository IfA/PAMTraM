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
package pamtram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deactivatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A DeactivatableElement can be deactivated by the user (e.g. via the model editor). Deactivated elements will be ignored by the transformation algorithm executing the PAMTraM model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.DeactivatableElement#isDeactivated <em>Deactivated</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getDeactivatableElement()
 * @model abstract="true"
 * @generated
 */
public interface DeactivatableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Deactivated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deactivated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to 'true', this element (and possible sub-elements) will be ignored during a transformation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deactivated</em>' attribute.
	 * @see #setDeactivated(boolean)
	 * @see pamtram.PamtramPackage#getDeactivatableElement_Deactivated()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDeactivated();

	/**
	 * Sets the value of the '{@link pamtram.DeactivatableElement#isDeactivated <em>Deactivated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deactivated</em>' attribute.
	 * @see #isDeactivated()
	 * @generated
	 */
	void setDeactivated(boolean value);

} // DeactivatableElement
