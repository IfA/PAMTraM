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
package pamtram.mapping.modifier;

import pamtram.ExpressionElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This ValueModifier will modify the (numeric) 'value' by applying the given 'expression'.
 * <br /><br />
 * Note: The 'value' to be modfied can be referenced in the 'expression' via the variable 'x'. For example, a valid expression to duplicate the given value would be "2*x".
 * <!-- end-model-doc -->
 *
 *
 * @see pamtram.mapping.modifier.ModifierPackage#getExpressionModifier()
 * @model
 * @generated
 */
public interface ExpressionModifier extends NumericModifier, ExpressionElement {

} // ExpressionModifier
