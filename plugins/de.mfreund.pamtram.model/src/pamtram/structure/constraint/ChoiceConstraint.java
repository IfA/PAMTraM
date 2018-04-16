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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ValueConstraint that specifies a list of values (each by means of an EqualityConstraint). For this constraint to be fulfilled, the actual attribute value must match at least one of the specified values.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.constraint.ChoiceConstraint#getChoices <em>Choices</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.constraint.ConstraintPackage#getChoiceConstraint()
 * @model
 * @generated
 */
public interface ChoiceConstraint extends ValueConstraint {
	/**
	 * Returns the value of the '<em><b>Choices</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.structure.constraint.EqualityConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choices</em>' containment reference list.
	 * @see pamtram.structure.constraint.ConstraintPackage#getChoiceConstraint_Choices()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<EqualityConstraint> getChoices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" attrValueRequired="true" refValueRequired="true" refValueMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return refValue.stream().anyMatch(r -&gt; r.equals(attrValue));'"
	 * @generated
	 */
	boolean checkConstraint(String attrValue, EList<String> refValue);

} // ChoiceConstraint
