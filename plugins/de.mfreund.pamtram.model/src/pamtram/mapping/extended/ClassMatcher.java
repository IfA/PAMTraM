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

import pamtram.structure.target.TargetSectionClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ClassMatcher can be used to determine the target instance(s) for a ReferenceTargetSelector.
 * <br />
 * Thereby, all elements that have been created based on the specified 'targetClass' will be used as target instances.
 * <br /><br />
 * Note: In most cases, a simple ClassMatcher will not be sufficient if not all but only a subset of the instances created based on the denoted 'targetClass' shall be used. For such more complex use cases, an AttributeMatcher can be used instead.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.extended.ClassMatcher#getTargetClass <em>Target Class</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getClassMatcher()
 * @model
 * @generated
 */
public interface ClassMatcher extends Matcher {
	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The 'targetClass' whose created instances will be used as target instances for the containing ReferenceTargetSelector.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(TargetSectionClass)
	 * @see pamtram.mapping.extended.ExtendedPackage#getClassMatcher_TargetClass()
	 * @model required="true"
	 * @generated
	 */
	TargetSectionClass getTargetClass();

	/**
	 * Sets the value of the '{@link pamtram.mapping.extended.ClassMatcher#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(TargetSectionClass value);

} // ClassMatcher
