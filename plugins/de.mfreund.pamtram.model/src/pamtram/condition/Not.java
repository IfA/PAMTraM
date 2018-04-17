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
package pamtram.condition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Condition that evaluates to 'true' if the specified sub-condition evaluates to 'false'.
 * <br />
 * The sub-condition can be specified locally (via the 'localCondPart' reference) or globally (specified via the 'sharedCondPart' reference).
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.condition.ConditionPackage#getNot()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='referenceOnlyConditionsFromConditionModelOrFromConditionalElements'"
 * @generated
 */
public interface Not extends UnaryCondition {

} // Not
