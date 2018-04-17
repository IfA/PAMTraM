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
package pamtram.structure.generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Cardinality Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The type of cardinality constraint for an element.
 * <!-- end-model-doc -->
 * @see pamtram.structure.generic.GenericPackage#getCardinalityType()
 * @model
 * @generated
 */
public enum CardinalityType implements Enumerator {
	/**
	 * The '<em><b>ONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_VALUE
	 * @generated
	 * @ordered
	 */
	ONE(0, "ONE", "ONE"),

	/**
	 * The '<em><b>ONE INFINITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_INFINITY_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_INFINITY(1, "ONE__INFINITY", "ONE__INFINITY"),

	/**
	 * The '<em><b>ZERO INFINITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZERO_INFINITY_VALUE
	 * @generated
	 * @ordered
	 */
	ZERO_INFINITY(2, "ZERO__INFINITY", "ZERO__INFINITY");

	/**
	 * The '<em><b>ONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Exactly one element must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections).
	 * <!-- end-model-doc -->
	 * @see #ONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ONE_VALUE = 0;

	/**
	 * The '<em><b>ONE INFINITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE INFINITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * At least one element must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections).
	 * <br /><br />
	 * For elements of TargetSections, the concrete number to be created should be specified by additional MappingHints (CardinalityMappings or AttributeMappings).
	 * <!-- end-model-doc -->
	 * @see #ONE_INFINITY
	 * @model name="ONE__INFINITY"
	 * @generated
	 * @ordered
	 */
	public static final int ONE_INFINITY_VALUE = 1;

	/**
	 * The '<em><b>ZERO INFINITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZERO INFINITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Zero or any number of elements must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections).
	 * <br /><br />
	 * For elements of TargetSections, the concrete number to be created should be specified by additional MappingHints (CardinalityMappings or AttributeMappings).
	 * <!-- end-model-doc -->
	 * @see #ZERO_INFINITY
	 * @model name="ZERO__INFINITY"
	 * @generated
	 * @ordered
	 */
	public static final int ZERO_INFINITY_VALUE = 2;

	/**
	 * An array of all the '<em><b>Cardinality Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CardinalityType[] VALUES_ARRAY =
		new CardinalityType[] {
			ONE,
			ONE_INFINITY,
			ZERO_INFINITY,
		};

	/**
	 * A public read-only list of all the '<em><b>Cardinality Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CardinalityType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Cardinality Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CardinalityType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CardinalityType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cardinality Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CardinalityType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CardinalityType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cardinality Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CardinalityType get(int value) {
		switch (value) {
			case ONE_VALUE: return ONE;
			case ONE_INFINITY_VALUE: return ONE_INFINITY;
			case ZERO_INFINITY_VALUE: return ZERO_INFINITY;
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
	private CardinalityType(int value, String name, String literal) {
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
	
} //CardinalityType
