/**
 */
package pamtram.mapping.modifier.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import pamtram.NamedElement;

import pamtram.mapping.modifier.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see pamtram.mapping.modifier.ModifierPackage
 * @generated
 */
public class ModifierSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModifierPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifierSwitch() {
		if (modelPackage == null) {
			modelPackage = ModifierPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModifierPackage.VALUE_MODIFIER_SET: {
				ValueModifierSet valueModifierSet = (ValueModifierSet)theEObject;
				T result = caseValueModifierSet(valueModifierSet);
				if (result == null) result = caseNamedElement(valueModifierSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.VALUE_MODIFIER: {
				ValueModifier valueModifier = (ValueModifier)theEObject;
				T result = caseValueModifier(valueModifier);
				if (result == null) result = caseNamedElement(valueModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.UNIQUE_NUMBER_APPENDER: {
				UniqueNumberAppender uniqueNumberAppender = (UniqueNumberAppender)theEObject;
				T result = caseUniqueNumberAppender(uniqueNumberAppender);
				if (result == null) result = caseValueModifier(uniqueNumberAppender);
				if (result == null) result = caseNamedElement(uniqueNumberAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.NUMERIC_MODIFIER: {
				NumericModifier numericModifier = (NumericModifier)theEObject;
				T result = caseNumericModifier(numericModifier);
				if (result == null) result = caseValueModifier(numericModifier);
				if (result == null) result = caseNamedElement(numericModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.EXPRESSION_MODIFIER: {
				ExpressionModifier expressionModifier = (ExpressionModifier)theEObject;
				T result = caseExpressionModifier(expressionModifier);
				if (result == null) result = caseNumericModifier(expressionModifier);
				if (result == null) result = caseValueModifier(expressionModifier);
				if (result == null) result = caseNamedElement(expressionModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STRING_MODIFIER: {
				StringModifier stringModifier = (StringModifier)theEObject;
				T result = caseStringModifier(stringModifier);
				if (result == null) result = caseValueModifier(stringModifier);
				if (result == null) result = caseNamedElement(stringModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.SUBSTRING_REPLACER: {
				SubstringReplacer substringReplacer = (SubstringReplacer)theEObject;
				T result = caseSubstringReplacer(substringReplacer);
				if (result == null) result = caseStringModifier(substringReplacer);
				if (result == null) result = caseValueModifier(substringReplacer);
				if (result == null) result = caseNamedElement(substringReplacer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STRING_APPENDER: {
				StringAppender stringAppender = (StringAppender)theEObject;
				T result = caseStringAppender(stringAppender);
				if (result == null) result = caseStringModifier(stringAppender);
				if (result == null) result = caseValueModifier(stringAppender);
				if (result == null) result = caseNamedElement(stringAppender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.STRING_PREPENDER: {
				StringPrepender stringPrepender = (StringPrepender)theEObject;
				T result = caseStringPrepender(stringPrepender);
				if (result == null) result = caseStringModifier(stringPrepender);
				if (result == null) result = caseValueModifier(stringPrepender);
				if (result == null) result = caseNamedElement(stringPrepender);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.TO_LOWER_CASE_CONVERTER: {
				ToLowerCaseConverter matchToLowerCaseConverter = (ToLowerCaseConverter)theEObject;
				T result = caseMatchToLowerCaseConverter(matchToLowerCaseConverter);
				if (result == null) result = caseStringModifier(matchToLowerCaseConverter);
				if (result == null) result = caseValueModifier(matchToLowerCaseConverter);
				if (result == null) result = caseNamedElement(matchToLowerCaseConverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifierPackage.TO_UPPER_CASE_CONVERTER: {
				ToUpperCaseConverter matchToUpperCaseConverter = (ToUpperCaseConverter)theEObject;
				T result = caseMatchToUpperCaseConverter(matchToUpperCaseConverter);
				if (result == null) result = caseStringModifier(matchToUpperCaseConverter);
				if (result == null) result = caseValueModifier(matchToUpperCaseConverter);
				if (result == null) result = caseNamedElement(matchToUpperCaseConverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Modifier Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Modifier Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueModifierSet(ValueModifierSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueModifier(ValueModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Substring Replacer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Substring Replacer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubstringReplacer(SubstringReplacer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringAppender(StringAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unique Number Appender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unique Number Appender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniqueNumberAppender(UniqueNumberAppender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericModifier(NumericModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionModifier(ExpressionModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringModifier(StringModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Prepender</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Prepender</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringPrepender(StringPrepender object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match To Lower Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match To Lower Case Converter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchToLowerCaseConverter(ToLowerCaseConverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match To Upper Case Converter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match To Upper Case Converter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchToUpperCaseConverter(ToUpperCaseConverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModifierSwitch
