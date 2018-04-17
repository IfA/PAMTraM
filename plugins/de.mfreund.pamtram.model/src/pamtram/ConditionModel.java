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
package pamtram;

import org.eclipse.emf.common.util.EList;
import pamtram.condition.ComplexCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ConditionModel contains a list of (global, reusable) Conditions which can be attached to ConditionalElements in order to restrain their applicability.
 * <br />
 * In order to reference global conditions from a ConditionModel, you have to use a 'sharedCondition(s)' non-containment reference (e.g. present for a ConditionalElement).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.ConditionModel#getConditions <em>Conditions</em>}</li>
 * </ul>
 *
 * @see pamtram.PamtramPackage#getConditionModel()
 * @model
 * @generated
 */
public interface ConditionModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link pamtram.condition.ComplexCondition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The lis of (global, reusable) Conditions defined by this ConditionModel.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see pamtram.PamtramPackage#getConditionModel_Conditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComplexCondition> getConditions();

} // ConditionModel
