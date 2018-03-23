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
package pamtram.condition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Condition that evaluates to 'true' if AT LEAST ONE of the specified sub-conditions evaluates to 'true'.
 * <br />
 * The sub-conditions can be specified locally (via the 'localCondParts' reference) and/or globally (specified via the 'sharedCondParts' reference).
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getOr()
 * @model
 * @generated
 */
public interface Or extends VariadicCondition {

} // Or
