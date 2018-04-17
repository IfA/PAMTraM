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
package pamtram.structure.generic;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents an attribute of an element structure. In contrast to 'actual' Attributes, 'virtual' Attributes do not represent an actual metamodel element (EAttribtue) but can be used to create additional (virtual) attributes.
 * <br />
 *  As the Attribute is not based on an actual EAttribute, the actual values held by this Attribute need to be specified manually by means of additional language elements (dependent on the concrete sub-type).
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.generic.GenericPackage#getVirtualAttribute()
 * @model abstract="true"
 * @generated
 */
public interface VirtualAttribute<S extends Section<S, C, R, A>, C extends pamtram.structure.generic.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends Attribute<S, C, R, A> {
} // VirtualAttribute
