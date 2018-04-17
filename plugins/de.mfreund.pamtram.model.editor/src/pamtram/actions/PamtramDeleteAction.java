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
/**
 *
 */
package pamtram.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.ui.action.DeleteAction;

import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.commands.DeleteSharedSectionModelCommand;
import pamtram.presentation.PamtramEditor;

/**
 * A special implementation of {@link DeleteAction} that can be used when working with PAMTraM models.
 * <p />
 * Currently, it only extends the standard DeleteAction so that shared SectionModels can be deleted which would not be
 * possible with the standard implementation.
 *
 * @author mfreund
 */
public class PamtramDeleteAction extends DeleteAction {


	/**
	 * This creates an instance.
	 *
	 * @param removeAllReferences
	 *            Whether all references to an element shall be removed when an element is deleted.
	 */
	public PamtramDeleteAction(boolean removeAllReferences) {
		super(removeAllReferences);
	}

	@Override
	public Command createCommand(Collection<?> selection) {

		if (selection == null || selection.isEmpty()) {
			return super.createCommand(selection);
		}

		// We only use a custom implementation if one or multiple shared SectionModels are to be deleted
		//
		if (selection.parallelStream().allMatch(
				s -> s instanceof SectionModel<?, ?, ?, ?> && ((SectionModel<?, ?, ?, ?>) s).eContainer() == null)) {

			return this.createDeleteSharedSectionModelCommand(selection);
		}

		return super.createCommand(selection);
	}

	/**
	 * Create one or multiple {@link DeleteSharedSectionModelCommand DeleteSharedSectionModelCommands} to delete the
	 * given list of shared SectionModels.
	 *
	 * @param selection
	 *            The list of shared SectionModels to delete.
	 * @return The created command that will the delete the SecitonModel(s).
	 */
	protected Command createDeleteSharedSectionModelCommand(Collection<?> selection) {

		if (!(UIHelper.getCurrentEditor() instanceof PamtramEditor)) {
			return super.createCommand(selection);
		}

		PAMTraM owner = ((PamtramEditor) UIHelper.getCurrentEditor()).getPamtram();

		if (selection.size() == 1) {

			return new DeleteSharedSectionModelCommand(this.domain, owner,
					(SectionModel<?, ?, ?, ?>) selection.iterator().next());
		} else {

			CompoundCommand command = new CompoundCommand();
			selection.stream().forEach(element -> command.append(
					new DeleteSharedSectionModelCommand(this.domain, owner, (SectionModel<?, ?, ?, ?>) element)));
			return command;
		}
	}
}
