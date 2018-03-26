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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exported Mapping Hint Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * If an ExportedMappingHintGroup (resp. the containing Mapping) is executed, the specified TargetSection is not directly instantiated although values for specified MappingHints are collected.
 * Instead ExportedMappingHintGroups may be imported by means of a MappingHintGroupImporter that is part of another Mapping.
 * <br />
 * Importing thereby means that all values that have been collected for the MappingHints defined in the exported MappingHintGroup are reused during the instantiation of the MappingHintGroupImporter.
 * <br /><br />
 * Note: There is a difference between (1) 'extending' and (2) 'importing' MappingHintGroups:
 * <br />
 * (1) Extending a HintGroup means that all MappingHints defined in the extended HintGroup are added to the Extending HintGroup (before execution of the transformation).
 * (2) Importing a HintGroup means that the VALUES of all MappingHints defined in the exported HintGroup are used when instantiating the HintGroupImporter (during the execution of the transformation).
 * <br /><br />
 * In most cases, 'extending' HintGroups will be the desired behavior. Importing HintGroups is only necessary for a few special use cases.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.MappingPackage#getExportedMappingHintGroup()
 * @model
 * @generated
 */
public interface ExportedMappingHintGroup extends MappingHintGroupType {
} // ExportedMappingHintGroup
