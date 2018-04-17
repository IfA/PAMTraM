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
package pamtram.mapping.extended;

import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Mapped Attribute Value Expander</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MappedAttributeValueExpander that will expand values determined for an imported MappingHint by adding values of the specified local 'source' Attribute.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.extended.ExtendedPackage#getLocalMappedAttributeValueExpander()
 * @model abstract="true"
 * @generated
 */
public interface LocalMappedAttributeValueExpander extends LocalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, MappedAttributeValueExpander {
} // LocalMappedAttributeValueExpander
