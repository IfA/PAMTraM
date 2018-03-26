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

import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A SourceSectionModel contains a list of SourceSections which can act as the left-hand side (LHS) of a Mapping.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.PamtramPackage#getSourceSectionModel()
 * @model
 * @generated
 */
public interface SourceSectionModel extends SectionModel<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, DeactivatableElement {
} // SourceSectionModel
