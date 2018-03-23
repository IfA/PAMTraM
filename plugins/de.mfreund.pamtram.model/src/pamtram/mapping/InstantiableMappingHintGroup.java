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
package pamtram.mapping;

import pamtram.ConditionalElement;
import pamtram.DeactivatableElement;
import pamtram.NamedElement;
import pamtram.structure.target.TargetSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instantiable Mapping Hint Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An abstract super-type for elements describing some kind of MappingHintGroup that (resp. whose specified TargetSection) can be directly instantiated.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getInstantiableMappingHintGroup()
 * @model abstract="true"
 * @generated
 */
public interface InstantiableMappingHintGroup extends NamedElement, DeactivatableElement, ConditionalElement {

	public TargetSection getTargetMMSectionGeneric();
} // InstantiableMappingHintGroup
