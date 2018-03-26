/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package de.mfreund.pamtram.transformation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pamtram.mapping.Mapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.mfreund.pamtram.transformation.TransformationMapping#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.TransformationMapping#getAssociatedMapping <em>Associated Mapping</em>}</li>
 *   <li>{@link de.mfreund.pamtram.transformation.TransformationMapping#getTransformationHintGroups <em>Transformation Hint Groups</em>}</li>
 * </ul>
 *
 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformationMapping()
 * @model
 * @generated
 */
public interface TransformationMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Element</em>' reference.
	 * @see #setSourceElement(EObject)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformationMapping_SourceElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getSourceElement();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.TransformationMapping#getSourceElement <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Element</em>' reference.
	 * @see #getSourceElement()
	 * @generated
	 */
	void setSourceElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Associated Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Mapping</em>' reference.
	 * @see #setAssociatedMapping(Mapping)
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformationMapping_AssociatedMapping()
	 * @model required="true"
	 * @generated
	 */
	Mapping getAssociatedMapping();

	/**
	 * Sets the value of the '{@link de.mfreund.pamtram.transformation.TransformationMapping#getAssociatedMapping <em>Associated Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Mapping</em>' reference.
	 * @see #getAssociatedMapping()
	 * @generated
	 */
	void setAssociatedMapping(Mapping value);

	/**
	 * Returns the value of the '<em><b>Transformation Hint Groups</b></em>' containment reference list.
	 * The list contents are of type {@link de.mfreund.pamtram.transformation.TransformationMappingHintGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Hint Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Hint Groups</em>' containment reference list.
	 * @see de.mfreund.pamtram.transformation.TransformationPackage#getTransformationMapping_TransformationHintGroups()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<TransformationMappingHintGroup> getTransformationHintGroups();

} // TransformationMapping
