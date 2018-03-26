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
package pamtram.structure.generic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference of an element structure. In contrast to 'actual' References, 'virtual' Reference do not represent an actual metamodel element (EReference) but can be used to create additional (virtual) references.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference. As the Reference is not based on an actual EReference, the actual instances of the specified target Classes need to be specified by the modeler by means of additional language elements (dependent on the concrete sub-type).
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.generic.GenericPackage#getVirtualReference()
 * @model abstract="true"
 * @generated
 */
public interface VirtualReference<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends Reference<S, C, R, A> {
} // VirtualReference
