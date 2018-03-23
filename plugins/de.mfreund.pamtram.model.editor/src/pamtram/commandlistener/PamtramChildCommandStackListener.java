/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.commandlistener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;

/**
 * Abstract command listener that all listeners acting as child
 * listener of the PamtramCommandStackListener have to implement.
 *
 * @author mfreund
 *
 */
abstract class PamtramChildCommandStackListener implements CommandStackListener {

	/**
	 * The parent {@link PamtramCommandStackListener} for this listener.
	 */
	final PamtramCommandStackListener parentListener;

	/**
	 * This creates an instance.
	 *
	 * @param parentListener
	 *            The parent {@link PamtramCommandStackListener} for this listener.
	 */
	public PamtramChildCommandStackListener(PamtramCommandStackListener parentListener) {
		this.parentListener = parentListener;
	}

	/**
	 * This returns the {@link CommandStack#getMostRecentCommand() most recent command} that was executed on the command
	 * stack of the {@link #parentListener}.
	 *
	 * @return The most recent command executed on the command stack of the {@link #parentListener} .
	 */
	Command getMostRecentCommand() {
		return this.parentListener.getEditor().getEditingDomain().getCommandStack().getMostRecentCommand();
	}
}
