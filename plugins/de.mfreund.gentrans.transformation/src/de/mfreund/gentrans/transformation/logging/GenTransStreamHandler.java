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
package de.mfreund.gentrans.transformation.logging;

import java.io.OutputStream;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * A {@link StreamHandler} that uses the {@link GenTransLogFormatter} to print logged messages to an
 * {@link OutputStream}.
 *
 * @author mfreund
 */
public class GenTransStreamHandler extends StreamHandler {

	/**
	 * This creates an instance.
	 *
	 * @param stream
	 *            The {@link OutputStream} to which logged messages will be printed.
	 */
	public GenTransStreamHandler(OutputStream stream) {

		super(stream, GenTransLogFormatter.getInstance());
	}

	@Override
	public void publish(LogRecord record) {

		super.publish(record);

		// It seems that we need to call 'flush()' manually after a new
		// record is published. Otherwise, no messages seem to appear on the
		// console.
		//
		this.flush();
	}
}
