/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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

		String externalMessage = getMessage() != null ? getMessage() : "";
		String internalMessage = getCause() != null && getCause().getMessage() != null ? getCause().getMessage() : "";

		StringBuilder builder = new StringBuilder();
		if (!externalMessage.isEmpty() && !externalMessage.equals(internalMessage)) {
			builder.append(externalMessage);
			if (!internalMessage.isEmpty()) {
				builder.append("\n\t-> ");
			}
		}
		builder.append(internalMessage);

		return builder.toString();
	}
}
