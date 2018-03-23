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

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import pamtram.structure.target.TargetSectionCrossReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Reference Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper element for a GenLibrary ExternalReferenceParameter.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.library.ExternalReferenceParameter#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.library.LibraryPackage#getExternalReferenceParameter()
 * @model
 * @generated
 */
public interface ExternalReferenceParameter extends LibraryParameter<AbstractExternalReferenceParameter<?, ?>> {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Reference that can be used to set the value(s) for the ExternalReferenceParameter (e.g. by means of a ReferenceTargetSelector).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference</em>' containment reference.
	 * @see #setReference(TargetSectionCrossReference)
	 * @see pamtram.structure.library.LibraryPackage#getExternalReferenceParameter_Reference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetSectionCrossReference getReference();

	/**
	 * Sets the value of the '{@link pamtram.structure.library.ExternalReferenceParameter#getReference <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' containment reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(TargetSectionCrossReference value);

} // ExternalReferenceParameter
