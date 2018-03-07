/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.Objects;

/**
 * Instances of this class describe the 'length' of an {@link EClassConnectionPath} (via how many references this path
 * leads from the {@link EClassConnectionPath#getStartingClass() startingClass} to the
 * {@link EClassConnectionPath#getTargetClass() targetClass}).
 * <p />
 * This is basically just a wrapper for a simple integer. However, three special static instances
 * {@link #NO_CONNECTION}, {@link #DIRECT_CONNECTION} and {@link #UNBOUNDED} are provided to simplify handling of
 * special cases.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class Length {

	public static final Length NO_CONNECTION = new Length(0);

	public static final Length DIRECT_CONNECTION = new Length(1);

	public static final Length UNBOUNDED = new Length(-1);

	private final int value;

	/**
	 * Creates an instance based on a capacity value.
	 *
	 * @param value
	 *            The capacity value.
	 */
	public Length(int value) {

		this.value = value;
	}

	/**
	 * @return the {@link #value}
	 */
	public int getValue() {

		return this.value;
	}

	public boolean isUnbounded() {

		return Length.UNBOUNDED.equals(this);
	}

	public boolean isDirectConnection() {

		return Length.DIRECT_CONNECTION.equals(this);
	}

	public boolean isNoConnection() {

		return Length.NO_CONNECTION.equals(this);
	}

	@Override
	public boolean equals(Object obj) {

		return obj instanceof Length && ((Length) obj).value == this.value;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.value);
	}

	@Override
	public String toString() {

		return String.valueOf(this.value);
	}

}
