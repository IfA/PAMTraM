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
package pamtram.structure.constraint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>String Constraint Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The type of String-based comparison to be performed.
 * <!-- end-model-doc -->
 * @see pamtram.structure.constraint.ConstraintPackage#getStringConstraintOperatorType()
 * @model
 * @generated
 */
public enum StringConstraintOperatorType implements Enumerator {
	/**
	 * The '<em><b>MATCH EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	MATCH_EQUAL(0, "MATCH_EQUAL", "MATCH_EQUAL"),

	/**
	 * The '<em><b>MATCH BEGINNING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_BEGINNING_VALUE
	 * @generated
	 * @ordered
	 */
	MATCH_BEGINNING(1, "MATCH_BEGINNING", "MATCH_BEGINNING"),

	/**
	 * The '<em><b>MATCH ENDING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_ENDING_VALUE
	 * @generated
	 * @ordered
	 */
	MATCH_ENDING(2, "MATCH_ENDING", "MATCH_ENDING"),

	/**
	 * The '<em><b>MATCH SUBSTRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_SUBSTRING_VALUE
	 * @generated
	 * @ordered
	 */
	MATCH_SUBSTRING(3, "MATCH_SUBSTRING", "MATCH_SUBSTRING"),

	/**
	 * The '<em><b>MATCH REGEX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCH_REGEX_VALUE
	 * @generated
	 * @ordered
	 */
	MATCH_REGEX(4, "MATCH_REGEX", "MATCH_REGEX");

	/**
	 * The '<em><b>MATCH EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual attribute value must be equal to the determined reference value.
	 * <!-- end-model-doc -->
	 * @see #MATCH_EQUAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_EQUAL_VALUE = 0;

	/**
	 * The '<em><b>MATCH BEGINNING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH BEGINNING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual attribute value must begin with the determined reference value.
	 * <!-- end-model-doc -->
	 * @see #MATCH_BEGINNING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_BEGINNING_VALUE = 1;

	/**
	 * The '<em><b>MATCH ENDING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH ENDING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual attribute value must end with the determined reference value.
	 * <!-- end-model-doc -->
	 * @see #MATCH_ENDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_ENDING_VALUE = 2;

	/**
	 * The '<em><b>MATCH SUBSTRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH SUBSTRING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual attribute value must contain the determined reference value.
	 * <!-- end-model-doc -->
	 * @see #MATCH_SUBSTRING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_SUBSTRING_VALUE = 3;

	/**
	 * The '<em><b>MATCH REGEX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCH REGEX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The actual attribute value must satisfy the regular expression specified by the determined reference value.
	 * <!-- end-model-doc -->
	 * @see #MATCH_REGEX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MATCH_REGEX_VALUE = 4;

	/**
	 * An array of all the '<em><b>String Constraint Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final StringConstraintOperatorType[] VALUES_ARRAY =
		new StringConstraintOperatorType[] {
			MATCH_EQUAL,
			MATCH_BEGINNING,
			MATCH_ENDING,
			MATCH_SUBSTRING,
			MATCH_REGEX,
		};

	/**
	 * A public read-only list of all the '<em><b>String Constraint Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<StringConstraintOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>String Constraint Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static StringConstraintOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StringConstraintOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>String Constraint Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static StringConstraintOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			StringConstraintOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>String Constraint Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static StringConstraintOperatorType get(int value) {
		switch (value) {
			case MATCH_EQUAL_VALUE: return MATCH_EQUAL;
			case MATCH_BEGINNING_VALUE: return MATCH_BEGINNING;
			case MATCH_ENDING_VALUE: return MATCH_ENDING;
			case MATCH_SUBSTRING_VALUE: return MATCH_SUBSTRING;
			case MATCH_REGEX_VALUE: return MATCH_REGEX;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private StringConstraintOperatorType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //StringConstraintOperatorType
