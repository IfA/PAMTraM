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
package pamtram.commands;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import pamtram.DeactivatableElement;
import pamtram.PamtramPackage;

/**
 * This command allows to change set the '<em><b>deactivated</b></em>' status of a
 * {@link DeactivatableElement}.
 * 
 * @author mfreund
 */
public class SetDeactivationStatusCommand extends SetCommand {

	/**
	 * This constructs an instance.
	 * 
	 * @param domain The editing domain on which the command shall be executed.
	 * @param owner The instance of {@link DeactivatableElement} for which to set
	 * the '<b><em>deactivated</em></b>' status.
	 * @param status The deactivation status to be set.
	 */
	public SetDeactivationStatusCommand(EditingDomain domain, DeactivatableElement owner,
			boolean status) {
		super(domain, owner, PamtramPackage.Literals.DEACTIVATABLE_ELEMENT__DEACTIVATED, status);
	}
	
}
