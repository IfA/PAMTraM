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

import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.MappingHint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hint
 * Group</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappingHintGroup serves two purposes:
 * <br />
 * (1) It specifies a TargetSection that will be instantiated when the Mapping containing this MappingHintGroup is executed.
 * <br />
 * (2) It acts as container for a set of MappingHints. MappingHints can be used to assist the transformation algorithm in the instantiation of the specified TargetSection. For example, AttributeMappings can be added that specify how to set the values of the Attributes defined as part of the TargetSection.
 * <br /><br />
 * Note: Each execution of the Mapping will result in the instantiation of the specified TargetSection.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getMappingHintGroup()
 * @model
 * @generated
 */
public interface MappingHintGroup extends MappingHintGroupType, InstantiableMappingHintGroup {

	/**
	 * This guarantees compatibility to legacy implementations.
	 *
	 * @return
	 * @deprecated {@link ContainerSelector} is now a full-fledged
	 *             {@link MappingHint} and should be accessed via
	 *             {@link MappingHintGroup#getMappingHints()}
	 */
	@Deprecated
	ContainerSelector getContainerSelector();

} // MappingHintGroup
