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

import org.eclipse.emf.common.util.EList;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.generic.Attribute;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Section Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents an attribute of a source model element structure.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.source.SourceSectionAttribute#getValueConstraints <em>Value Constraints</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.source.SourcePackage#getSourceSectionAttribute()
 * @model abstract="true"
 * @generated
 */
public interface SourceSectionAttribute extends Attribute<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> {

	/**
	 * Returns the value of the '<em><b>Value Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.constraint.ValueConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of ValueConstraints that specify a single reference value or a list/range of reference values which the actual attribute value must or must not satisfy.
	 * <br /><br />
	 * A certain attribute (value) in a source model will only match against this Attribute if all specified constraints are met.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Constraints</em>' containment reference list.
	 * @see pamtram.structure.source.SourcePackage#getSourceSectionAttribute_ValueConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValueConstraint> getValueConstraints();
} // SourceSectionAttribute
