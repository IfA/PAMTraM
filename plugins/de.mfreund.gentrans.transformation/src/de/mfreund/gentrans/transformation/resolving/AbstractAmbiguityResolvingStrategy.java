/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.resolving;

import java.util.List;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import pamtram.PAMTraM;

/**
 * This provides an abstract, extensible implementation of
 * {@link IAmbiguityResolvingStrategy}.
 *
 * @author mfreund
 */
public abstract class AbstractAmbiguityResolvingStrategy implements IAmbiguityResolvingStrategy {

	/**
	 * This keeps track of the {@link PAMTraM} instances that the current
	 * transformation operate on.
	 */
	protected List<PAMTraM> pamtramModels;

	/**
	 * This keeps track of the list of {@link EObject sourceModels} that serve
	 * as input to the current transformation.
	 */
	protected List<EObject> sourceModels;

	/**
	 * This keeps track of the {@link Logger} that can be used to print
	 * messages. Messages can be written via {@link #printMessage(String)} or
	 * {@link #printMessage(String, String)}.
	 */
	private Logger logger;

	@Override
	public void init(List<PAMTraM> pamtramModels, List<EObject> sourceModels, Logger logger)
			throws AmbiguityResolvingException {

		this.logger = logger;

		this.printMessage("Initializing strategy '" + this.getClass().getSimpleName() + "'...");

		this.pamtramModels = pamtramModels;
		this.sourceModels = sourceModels;
	}

	/**
	 * This prints a message to the {@link #logger}.
	 * <p/>
	 * Note: If '<em>messageStream</em>' is '<em>null</em>' a call of this
	 * method will do nothing.
	 *
	 * @param message
	 *            The message to print.
	 */
	protected void printMessage(String message) {
		if (this.logger != null) {
			this.logger.fine(message);
		}
	}

	/**
	 * This prints a prefixed message to the {@link #logger}. The message will
	 * be formatted as follows: <br />
	 * "[prefix] message".
	 * <p/>
	 * Note: If '<em>messageStream</em>' is '<em>null</em>' a call of this
	 * method will do nothing.
	 *
	 * @param message
	 *            The message to print.
	 */
	protected void printMessage(String message, String prefix) {
		if (this.logger != null) {
			this.logger.fine(() -> "[" + prefix + "]" + message);
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
