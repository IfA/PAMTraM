/**
 */
package pamtram.condition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Cond Setting Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see pamtram.condition.ConditionPackage#getCondSettingEnum()
 * @model
 * @generated
 */
public enum CondSettingEnum implements Enumerator {
	/**
	 * The '<em><b>Matching Required</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATCHING_REQUIRED_VALUE
	 * @generated
	 * @ordered
	 */
	MATCHING_REQUIRED(0, "MatchingRequired", "MatchingRequired"),

	/**
	 * The '<em><b>No Matching Accepted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_MATCHING_ACCEPTED_VALUE
	 * @generated
	 * @ordered
	 */
	NO_MATCHING_ACCEPTED(1, "NoMatchingAccepted", "NoMatchingAccepted");

	/**
	 * The '<em><b>Matching Required</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Matching Required</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATCHING_REQUIRED
	 * @model name="MatchingRequired"
	 * @generated
	 * @ordered
	 */
	public static final int MATCHING_REQUIRED_VALUE = 0;

	/**
	 * The '<em><b>No Matching Accepted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No Matching Accepted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_MATCHING_ACCEPTED
	 * @model name="NoMatchingAccepted"
	 * @generated
	 * @ordered
	 */
	public static final int NO_MATCHING_ACCEPTED_VALUE = 1;

	/**
	 * An array of all the '<em><b>Cond Setting Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CondSettingEnum[] VALUES_ARRAY =
		new CondSettingEnum[] {
			MATCHING_REQUIRED,
			NO_MATCHING_ACCEPTED,
		};

	/**
	 * A public read-only list of all the '<em><b>Cond Setting Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CondSettingEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Cond Setting Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CondSettingEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CondSettingEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cond Setting Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CondSettingEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CondSettingEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Cond Setting Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static CondSettingEnum get(int value) {
		switch (value) {
			case MATCHING_REQUIRED_VALUE: return MATCHING_REQUIRED;
			case NO_MATCHING_ACCEPTED_VALUE: return NO_MATCHING_ACCEPTED;
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
	private CondSettingEnum(int value, String name, String literal) {
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
	
} //CondSettingEnum
