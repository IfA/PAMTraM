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

import org.eclipse.emf.ecore.EObject;

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Match Spec Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MatchSpecElement can be equipped with a 'referenceMatchSpec' consisting of a list of References. The 'referenceMatchSpec' restricts the application of matched elements by specifiy an additional path (based on references).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.MatchSpecElement#getReferenceMatchSpec <em>Reference Match Spec</em>}</li>
 *   <li>{@link pamtram.MatchSpecElement#isFollowExternalReferences <em>Follow External References</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getMatchSpecElement()
 * @model abstract="true"
 * @generated
 */
public interface MatchSpecElement<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference Match Spec</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In case of SourceSections referencing itself via a CrossReference, it may be necessary to further restrict the determined values that are used for calculation (e.g. do not use the 'own' attribute value but only attribute values of 'referenced' elements. Therefore, this allows to specify a list of References describing a path how to get to the relevant instances based on the root element of the Section.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reference Match Spec</em>' reference list.
	 * @see pamtram.PamtramPackage#getMatchSpecElement_ReferenceMatchSpec()
	 * @model
	 * @generated
	 */
	EList<R> getReferenceMatchSpec();

	/**
	 * Returns the value of the '<em><b>Follow External References</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In case of Attributes defined in abstract Sections and inherited by multiple concrete Sections, the specified source Attribute might match via various paths (including one or multiple CrossReferences). By default, however, only 'local' matches (in the current SourceSection) are evaluated. If matches in other Sections shall be used, set this to 'true' (also consider specifying an additional 'referenceMatchSpec' elements in such cases).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Follow External References</em>' attribute.
	 * @see #setFollowExternalReferences(boolean)
	 * @see pamtram.PamtramPackage#getMatchSpecElement_FollowExternalReferences()
	 * @model required="true"
	 * @generated
	 */
	boolean isFollowExternalReferences();

	/**
	 * Sets the value of the '{@link pamtram.MatchSpecElement#isFollowExternalReferences <em>Follow External References</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Follow External References</em>' attribute.
	 * @see #isFollowExternalReferences()
	 * @generated
	 */
	void setFollowExternalReferences(boolean value);

} // MatchSpecElement
