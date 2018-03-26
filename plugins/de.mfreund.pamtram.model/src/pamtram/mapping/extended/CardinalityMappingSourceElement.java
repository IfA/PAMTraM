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

import pamtram.structure.LocalDynamicSourceElement;

import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cardinality Mapping Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A concrete type of 'sourceElement' for a CardinalityMapping.
 * <br />
 * This type is based on the value of a 'local' SourceSectionAttribute.
 * <br /><br />
 * Note: See the documentation of 'LocalDynamicSourceElement' for a detailed explanation of the meaning of 'local' source elements.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getCardinalityMappingSourceElement()
 * @model
 * @generated
 */
public interface CardinalityMappingSourceElement extends LocalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, CardinalityMappingSourceInterface {
} // CardinalityMappingSourceElement
