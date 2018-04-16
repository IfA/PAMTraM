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
package pamtram.structure.constraint;

import pamtram.structure.ExternalDynamicSourceElement;

import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Constraint Global Source Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A concrete type of 'sourceElement' to calculate the reference value of a ValueConstraint.<br />
 * This type is based on the value of a 'global' attribute.
 * <br /><br />
 * Note: See the documentation of 'GlobalDynamicSourceElement' for a detailed explanation of the meaning of 'global' source elements.
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getValueConstraintGlobalSourceElement()
 * @model
 * @generated
 */
public interface ValueConstraintGlobalSourceElement extends ExternalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, ValueConstraintSourceInterface {
} // ValueConstraintGlobalSourceElement
