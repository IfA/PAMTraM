/**
 *
 */
package de.mfreund.gentrans.transformation;

/**
 * A custom {@link RuntimeException} that can be thrown anywhere during the
 * execution of a transformation in order to indicate that the transformation
 * should be canceled.
 *
 * @author mfreund
 */
public class CancelTransformationException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -4199753744461545599L;

	/**
	 * Constructs a new exception with null as its detail message.
	 *
	 */
	public CancelTransformationException() {
		super();
	}

	/**
	 * Constructs a new runtime exception with the specified detail message.
	 *
	 * @param message
	 *            the detail message.
	 */
	public CancelTransformationException(String message) {
		super(message);
	}

	/**
	 * Constructs a new runtime exception with the specified cause and a detail
	 * message of (cause==null ? null : cause.toString()) (which typically
	 * contains the class and detail message of cause).
	 *
	 * @param throwable
	 *            the cause for the exception.
	 */
	public CancelTransformationException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Constructs a new runtime exception with the specified detail message and
	 * cause. Note that the detail message associated with cause is not
	 * automatically incorporated in this runtime exception's detail message.
	 *
	 * @param message
	 *            the detail message.
	 * @param throwable
	 *            the cause for the exception.
	 */
	public CancelTransformationException(String message, Throwable throwable) {
		super(message, throwable);
	}

}