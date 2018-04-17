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
package de.mfreund.pamtram.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.navigator.CommonViewer;

/**
 * A {@link WizardPage} that allows to select one or multiple files (containing shared SectionModels) from the
 * workspace.
 *
 * @author mfreund
 */
public class SharedSectionModelSelectionPage extends WizardPage {

	/**
	 * The {@link TreeViewer} used to present the workspace content to the user.
	 */
	private TreeViewer resourceTreeViewer;

	/**
	 * The required file ending of the file(s) to be selected.
	 */
	private String fileEnding;

	/**
	 * Whether multiple files may be selected by the user.
	 */
	private boolean allowMultiSelection;

	/**
	 * This creates an instance.
	 *
	 * @param title
	 *            The title of the wizard page.
	 * @param message
	 *            The message displayed in the wizard page.
	 * @param fileEnding
	 *            The required file ending of the file(s) to be selected or <em>null</em> if the file ending shall not
	 *            be restricted.
	 * @param allowMultiSelection
	 *            Whether multiple files may be selected by the user.
	 *
	 */
	public SharedSectionModelSelectionPage(String title, String message, String fileEnding,
			boolean allowMultiSelection) {
		super(title);
		this.setTitle(title);
		this.setMessage(message);
		this.fileEnding = fileEnding;
		this.allowMultiSelection = allowMultiSelection;
	}

	@Override
	public void createControl(Composite parent) {

		Composite container = new Composite(parent, SWT.NULL);
		this.setControl(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		// We reuse the viewer used by the ProjectExplorer because it is already equipped with a suitable content and
		// label provider
		//
		this.resourceTreeViewer = new CommonViewer("org.eclipse.ui.navigator.ProjectExplorer", container,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

		this.resourceTreeViewer.addSelectionChangedListener(
				event -> SharedSectionModelSelectionPage.this.getContainer().updateButtons());

		this.resourceTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
	}

	@Override
	public boolean isPageComplete() {

		this.setErrorMessage(null);

		ISelection sel = this.resourceTreeViewer.getSelection();

		if (!(sel instanceof TreeSelection) || ((TreeSelection) sel).isEmpty()) {
			return false;
		}

		if (!this.allowMultiSelection && ((TreeSelection) sel).size() > 1) {
			this.setErrorMessage("Please select a single file!");
			return false;
		}

		for (Iterator<?> iterator = ((TreeSelection) sel).iterator(); iterator.hasNext();) {
			Object selection = iterator.next();

			if (!(selection instanceof IFile)) {
				this.setErrorMessage("Please select only files!");
				return false;
			}

			if (this.fileEnding != null && !((IFile) selection).getName().endsWith(this.fileEnding)) {
				this.setErrorMessage("Please select a file with the file ending '" + this.fileEnding + "'!");
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the single selected {@link IFile}.
	 *
	 * @return The {@link IFile} selected by the user.
	 */
	public IFile getSingleSelection() {

		return this.resourceTreeViewer.getSelection() instanceof TreeSelection
				? (IFile) ((TreeSelection) this.resourceTreeViewer.getSelection()).getFirstElement() : null;
	}

	/**
	 * Returns the list of selected {@link IFile IFiles}.
	 *
	 * @return The {@link IFile IFiles} selected by the user.
	 */
	public List<IFile> getSelection() {

		if (!(this.resourceTreeViewer.getSelection() instanceof TreeSelection)) {
			return new ArrayList<>();
		}

		ArrayList<IFile> selectedFiles = new ArrayList<>();
		for (Iterator<?> iterator = ((TreeSelection) this.resourceTreeViewer.getSelection()).iterator(); iterator
				.hasNext();) {
			Object selection = iterator.next();
			if (selection instanceof IFile) {
				selectedFiles.add((IFile) selection);
			} else {
				return new ArrayList<>();
			}
		}

		return selectedFiles;
	}
}
