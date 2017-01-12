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
			case ModifierPackage.SUBSTRING_REPLACER: return createSubstringReplacer();
			case ModifierPackage.STRING_APPENDER: return createStringAppender();
			case ModifierPackage.UNIQUE_NUMBER_APPENDER: return createUniqueNumberAppender();
			case ModifierPackage.STRING_PREPENDER: return createStringPrepender();
			case ModifierPackage.MATCH_TO_LOWER_CASE_CONVERTER: return createMatchToLowerCaseConverter();
			case ModifierPackage.MATCH_TO_UPPER_CASE_CONVERTER: return createMatchToUpperCaseConverter();
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
	public StringPrepender createStringPrepender() {
		StringPrependerImpl stringPrepender = new StringPrependerImpl();
		return stringPrepender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchToLowerCaseConverter createMatchToLowerCaseConverter() {
		MatchToLowerCaseConverterImpl matchToLowerCaseConverter = new MatchToLowerCaseConverterImpl();
		return matchToLowerCaseConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchToUpperCaseConverter createMatchToUpperCaseConverter() {
		MatchToUpperCaseConverterImpl matchToUpperCaseConverter = new MatchToUpperCaseConverterImpl();
		return matchToUpperCaseConverter;
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
