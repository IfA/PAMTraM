/**
 *
 */
package de.mfreund.gentrans.transformation;

/**
 * A custom {@link RuntimeException} that can be thrown anywhere during the execution of a transformation in order to
 * indicate that the transformation should be canceled.
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
	 * Constructs a new runtime exception with the specified cause and a detail message of (cause==null ? null :
	 * cause.toString()) (which typically contains the class and detail message of cause).
	 *
	 * @param throwable
	 *            the cause for the exception.
	 */
	public CancelTransformationException(Throwable throwable) {

		super(throwable);
	}

	/**
	 * Constructs a new runtime exception with the specified detail message and cause. Note that the detail message
	 * associated with cause is not automatically incorporated in this runtime exception's detail message.
	 *
	 * @param message
	 *            the detail message.
	 * @param throwable
	 *            the cause for the exception.
	 */
	public CancelTransformationException(String message, Throwable throwable) {

		super(message, throwable);
	}

	/**
	 * Depending on the {@link #getMessage() message} and {@link #getCause() cause} of this Exception, compile a
	 * detailed String representation that can e.g. be used to print meaningful log messages.
	 *
	 * @return The compiled String.
	 */
	public String printInfo() {

		String externalMessage = this.getMessage() != null ? this.getMessage() : "";
		String internalMessage = this.getCause() != null && this.getCause().getMessage() != null
				? this.getCause().getMessage()
				: "";

		StringBuilder builder = new StringBuilder();
		if (!externalMessage.isEmpty()) {
			builder.append(externalMessage);
			if (!internalMessage.isEmpty()) {
				builder.append("\n\t-> ");
			}
		}
		builder.append(internalMessage);

		return builder.toString();
	}
}