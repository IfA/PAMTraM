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
package pamtram.mapping.modifier.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pamtram.mapping.modifier.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifierFactoryImpl extends EFactoryImpl implements ModifierFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifierFactory init() {
		try {
			ModifierFactory theModifierFactory = (ModifierFactory)EPackage.Registry.INSTANCE.getEFactory(ModifierPackage.eNS_URI);
			if (theModifierFactory != null) {
				return theModifierFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifierFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModifierPackage.VALUE_MODIFIER_SET: return createValueModifierSet();
			case ModifierPackage.UNIQUE_NUMBER_APPENDER: return createUniqueNumberAppender();
			case ModifierPackage.EXPRESSION_MODIFIER: return createExpressionModifier();
			case ModifierPackage.SUBSTRING_REPLACER: return createSubstringReplacer();
			case ModifierPackage.STRING_APPENDER: return createStringAppender();
			case ModifierPackage.STRING_PREPENDER: return createStringPrepender();
			case ModifierPackage.TO_LOWER_CASE_CONVERTER: return createToLowerCaseConverter();
			case ModifierPackage.TO_UPPER_CASE_CONVERTER: return createToUpperCaseConverter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueModifierSet createValueModifierSet() {
		ValueModifierSetImpl valueModifierSet = new ValueModifierSetImpl();
		return valueModifierSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubstringReplacer createSubstringReplacer() {
		SubstringReplacerImpl substringReplacer = new SubstringReplacerImpl();
		return substringReplacer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAppender createStringAppender() {
		StringAppenderImpl stringAppender = new StringAppenderImpl();
		return stringAppender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniqueNumberAppender createUniqueNumberAppender() {
		UniqueNumberAppenderImpl uniqueNumberAppender = new UniqueNumberAppenderImpl();
		return uniqueNumberAppender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionModifier createExpressionModifier() {
		ExpressionModifierImpl expressionModifier = new ExpressionModifierImpl();
		return expressionModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPrepender createStringPrepender() {
		StringPrependerImpl stringPrepender = new StringPrependerImpl();
		return stringPrepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToLowerCaseConverter createToLowerCaseConverter() {
		ToLowerCaseConverterImpl toLowerCaseConverter = new ToLowerCaseConverterImpl();
		return toLowerCaseConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToUpperCaseConverter createToUpperCaseConverter() {
		ToUpperCaseConverterImpl toUpperCaseConverter = new ToUpperCaseConverterImpl();
		return toUpperCaseConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierPackage getModifierPackage() {
		return (ModifierPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifierPackage getPackage() {
		return ModifierPackage.eINSTANCE;
	}

} //ModifierFactoryImpl
