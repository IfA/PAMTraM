/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import de.mfreund.gentrans.transformation.ui.Activator;

/**
 * A {@link Handler} that prints log messages that are based on a thrown {@link Exception} to the internal
 * {@link Activator#log(Exception) logging facilities} of the {@link Activator gentrans.transformation} plugin.
 *
 * @author mfreund
 */
public class GenTransPluginStreamHandler extends Handler {

	/**
	 * This creates an instance.
	 */
	public GenTransPluginStreamHandler() {

		super();

		// Log only severe messages that result from a thrown exception
		//
		this.setLevel(Level.SEVERE);
		this.setFilter((LogRecord record) -> record.getThrown() instanceof Exception
				&& record.getLevel().equals(Level.SEVERE));
	}

	@Override
	public void publish(LogRecord record) {

		// Log the message via the internal logging facilities of the 'gentrans.transformation' plugin
		//
		if (record.getThrown() instanceof Exception) {
			Activator.log((Exception) record.getThrown());
		}
	}

	@Override
	public void close() {

		// Nothing to be done
		//

	}

	@Override
	public void flush() {

		// Nothing to be done
		//

	}
}
