/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation;

/**
 * This exception can be used to indicate a request by the user for an early
 * termination of the transformation.
 *
 * @author mfreund
 */
public class UserAbortException extends Exception {

	private static final long serialVersionUID = -5137744892390040105L;

	@Override
	public String getMessage() {
		return "User abort requested.";
	}

}
