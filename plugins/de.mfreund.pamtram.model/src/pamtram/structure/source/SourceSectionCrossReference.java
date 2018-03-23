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
package pamtram.structure.source;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CrossReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Cross Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference (as an instance of an EReference) of a source model element structure. CrossReferences can be used to describe references to other element structures or to other elements of this structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionCrossReference()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='valuesMatchReferenceType'"
 * @generated
 */
public interface SourceSectionCrossReference extends CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, SourceSectionReference, ActualReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
} // SourceSectionCrossReference
