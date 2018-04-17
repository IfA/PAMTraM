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
package de.mfreund.pamtram.wizards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.Wizard;

import pamtram.PAMTraM;

/**
 * A {@link Wizard} that allows to import some kind of {@link EObject elements}
 * into a {@link PAMTraM} model via a {@link #importCommand Command}.
 * <p />
 * After execution of the {@link #importCommand Command} (i.e. after termination
 * of the wizard), the {@link #getImportedElements() imported elements} are
 * {@link #selectImportedElementsInViewer() selected and revealed} in the
 * {@link #viewer}.
 *
 * @author mfreund
 */
public abstract class AbstractImportElementWizard extends Wizard {

	/**
	 * This is the pamtram instance into that the library elements shall be
	 * imported.
	 */
	protected final PAMTraM pamtram;

	/**
	 * This is the editing domain to be used to perform model changes.
	 */
	protected final EditingDomain editingDomain;

	/**
	 * The {@link Command} that is used to import the elements.
	 */
	protected Command importCommand;

	/**
	 * The {@link Viewer} where the imported elements will be shown and
	 * selected.
	 */
	protected Viewer viewer;

	/**
	 * This constructs an instance of the wizard without specifying a
	 * {@link #viewer}.
	 *
	 * @param pamtram
	 *            The pamtram instance into that the library elements shall be
	 *            imported.
	 * @param editingDomain
	 *            The editing domain to be used to perform model changes.
	 */
	public AbstractImportElementWizard(PAMTraM pamtram, EditingDomain editingDomain) {
		this(pamtram, editingDomain, null);
	}

	/**
	 * This constructs an instance of the wizard.
	 *
	 * @param pamtram
	 *            The pamtram instance into that the library elements shall be
	 *            imported.
	 * @param editingDomain
	 *            The editing domain to be used to perform model changes.
	 * @param viewer
	 *            The {@link Viewer} where the imported elements will be shown
	 *            and selected.
	 */
	public AbstractImportElementWizard(PAMTraM pamtram, EditingDomain editingDomain, Viewer viewer) {
		super();
		this.setNeedsProgressMonitor(true);
		this.pamtram = pamtram;
		this.editingDomain = editingDomain;
		this.importCommand = null;
		this.viewer = viewer;
	}

	@Override
	public boolean performFinish() {

		this.createImportElementsCommand();

		if (this.importCommand != null && this.importCommand.canExecute()) {

			this.editingDomain.getCommandStack().execute(this.importCommand);

			this.selectImportedElementsInViewer();

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Create the {@link #importCommand} that will import the elements.
	 */
	protected abstract void createImportElementsCommand();

	/**
	 * Select and reveal the {@link #getImportedElements() imported elements} in
	 * the {@link #viewer}.
	 *
	 */
	protected void selectImportedElementsInViewer() {
		if (this.viewer != null && !this.getImportedElements().isEmpty()) {

			// Refresh the viewer to be sure that all underlying changes to the
			// model are reflected
			//
			this.viewer.refresh();

			this.viewer.setSelection(new StructuredSelection(this.getImportedElements()), true);
			if (this.viewer instanceof TreeViewer) {
				List<Object> expanded = new ArrayList<>(
						Arrays.asList(((TreeViewer) this.viewer).getExpandedElements()));
				expanded.addAll(this.getImportedElements());
				((TreeViewer) this.viewer).setExpandedElements(expanded.toArray());
			}
		}
	}

	/**
	 * After the wizard was {@link #performFinish() executed}, this will hold
	 * the list of imported/created {@link EObject elements}.
	 * <p />
	 * In the default implementation, they are based on the
	 * {@link Command#getAffectedObjects() affected objects} of the executed
	 * command.
	 *
	 * @return The elements imported/created by the wizard resp. by the
	 *         {@link #importCommand}.
	 */
	protected List<EObject> getImportedElements() {
		return this.importCommand != null ? this.importCommand.getAffectedObjects().stream()
				.filter(e -> e instanceof EObject).map(e -> (EObject) e).collect(Collectors.toList())
				: new ArrayList<>();
	}

}
