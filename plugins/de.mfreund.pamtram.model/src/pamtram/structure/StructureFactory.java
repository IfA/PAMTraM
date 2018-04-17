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
package pamtram.structure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.StructurePackage
 * @generated
 */
public interface StructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructureFactory eINSTANCE = pamtram.structure.impl.StructureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Source Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Instance Selector</em>'.
	 * @generated
	 */
	SourceInstanceSelector createSourceInstanceSelector();

	/**
	 * Returns a new object of class '<em>Target Instance Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Instance Selector</em>'.
	 * @generated
	 */
	TargetInstanceSelector createTargetInstanceSelector();

	/**
	 * Returns a new object of class '<em>Instance Selector Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Selector Source Element</em>'.
	 * @generated
	 */
	InstanceSelectorSourceElement createInstanceSelectorSourceElement();

	/**
	 * Returns a new object of class '<em>Instance Selector External Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Selector External Source Element</em>'.
	 * @generated
	 */
	InstanceSelectorExternalSourceElement createInstanceSelectorExternalSourceElement();

	/**
	 * Returns a new object of class '<em>Instance Selector Global Source Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Selector Global Source Element</em>'.
	 * @generated
	 */
	InstanceSelectorGlobalSourceElement createInstanceSelectorGlobalSourceElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StructurePackage getStructurePackage();



} //StructureFactory
