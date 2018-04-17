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
package pamtram.condition.impl;

import org.eclipse.emf.ecore.EClass;

import pamtram.ConditionalElement;
import pamtram.condition.ApplicationDependency;
import pamtram.condition.ConditionPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Application Dependency</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ApplicationDependencyImpl extends ConditionImpl<ConditionalElement> implements ApplicationDependency {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConditionPackage.Literals.APPLICATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> This is specialized for the more specific type known in this
	 * context.
	 *
	 * @generated
	 */
	@Override
	public void setTarget(ConditionalElement newTarget) {
		super.setTarget(newTarget);
	}

} // ApplicationDependencyImpl
