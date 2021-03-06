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
package pamtram.mapping.modifier;

import org.eclipse.emf.common.util.EList;

import pamtram.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value Modifier Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A reusable set of ValueModifiers that can be attached to a ModifiableElement in order to modify its 'value'.
 * <br /><br />
 * For example, when attached this to an AttributeMapping, the value resulting from evaluating the AttributeMapping is modified by applying the specified ValueModifers before setting the value of the associated TargetSectionAttribute.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.mapping.modifier.ValueModifierSet#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getValueModifierSet()
 * @model
 * @generated
 */
public interface ValueModifierSet extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Modifiers</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.mapping.modifier.ValueModifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set of ValueModifiers that will be used to modify the 'value'.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Modifiers</em>' containment reference list.
	 * @see pamtram.mapping.modifier.ModifierPackage#getValueModifierSet_Modifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueModifier> getModifiers();

} // AttributeValueModifierSet
