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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see pamtram.structure.source.SourcePackage
 * @generated
 */
public interface SourceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SourceFactory eINSTANCE = pamtram.structure.source.impl.SourceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Section</em>'.
	 * @generated
	 */
	SourceSection createSourceSection();

	/**
	 * Returns a new object of class '<em>Section Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Section Class</em>'.
	 * @generated
	 */
	SourceSectionClass createSourceSectionClass();

	/**
	 * Returns a new object of class '<em>Section Composite Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Section Composite Reference</em>'.
	 * @generated
	 */
	SourceSectionCompositeReference createSourceSectionCompositeReference();

	/**
	 * Returns a new object of class '<em>Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Section Cross Reference</em>'.
	 * @generated
	 */
	SourceSectionCrossReference createSourceSectionCrossReference();

	/**
	 * Returns a new object of class '<em>Virtual Source Section Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Source Section Cross Reference</em>'.
	 * @generated
	 */
	VirtualSourceSectionCrossReference createVirtualSourceSectionCrossReference();

	/**
	 * Returns a new object of class '<em>Actual Source Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actual Source Section Attribute</em>'.
	 * @generated
	 */
	ActualSourceSectionAttribute createActualSourceSectionAttribute();

	/**
	 * Returns a new object of class '<em>Virtual Source Section Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Source Section Attribute</em>'.
	 * @generated
	 */
	VirtualSourceSectionAttribute createVirtualSourceSectionAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SourcePackage getSourcePackage();

} //SourceFactory
