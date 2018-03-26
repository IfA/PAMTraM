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
import org.eclipse.emf.ecore.EPackage;

import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.Reference;
import pamtram.structure.generic.Section;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SectionModels contain a list of Sections representing element structures. All element structures need to be based on the meta-model/EPackage identified by the 'metaModelPackage' reference.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.SectionModel#getMetaModelPackage <em>Meta Model Package</em>}</li>
 *   <li>{@link pamtram.SectionModel#getSections <em>Sections</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getSectionModel()
 * @model abstract="true"
 * @generated
 */
public interface SectionModel<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Meta Model Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The meta-model (represented by an EPackage) based on which all element structures (Sections) in this SectionModel need to be based.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Meta Model Package</em>' reference.
	 * @see #setMetaModelPackage(EPackage)
	 * @see pamtram.PamtramPackage#getSectionModel_MetaModelPackage()
	 * @model required="true"
	 * @generated
	 */
	EPackage getMetaModelPackage();

	/**
	 * Sets the value of the '{@link pamtram.SectionModel#getMetaModelPackage <em>Meta Model Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model Package</em>' reference.
	 * @see #getMetaModelPackage()
	 * @generated
	 */
	void setMetaModelPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model Sections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of Sections defined by this SectionModel.
	 * <br />
	 * All Sections need to be based on the meta-model/EPackage specified via the 'metaModelPackage' reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sections</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getSectionModel_Sections()
	 * @model containment="true"
	 * @generated
	 */
	EList<S> getSections();

} // SectionModel
