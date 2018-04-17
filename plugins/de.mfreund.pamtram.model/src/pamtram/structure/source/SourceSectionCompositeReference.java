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
package pamtram.structure.source;

import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CompositeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Composite Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents a reference (as an instance of an EReference) of a source model element structure. CompositeReferences can be used to describe the tree that is the basis of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, target elements (Classes) can be specified for References via the 'value' reference.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionCompositeReference()
 * @model
 * @generated
 */
public interface SourceSectionCompositeReference extends CompositeReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, SourceSectionReference, ActualReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {
} // SourceSectionCompositeReference
