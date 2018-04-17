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
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;

import de.mfreund.gentrans.transformation.resolving.Activator;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.presentation.PamtramEditor;

/**
 * A customizable {@link TitleAreaDialog} with a message and three buttons ('<em>OK</em>', '<em>Abort
 * Transformation</em>', and <em>Enhance PAMTraM Model</em>).
 * <p />
 * An additional {@link SelectionListener2} may be passed in the constructor. This will result in the creation of an
 * additional button entitled '<em>Enhance PAMTraM Model</em>', triggering the given listener when clicked.
 *
 * @author mfreund
 */
public abstract class AbstractDialog extends TitleAreaDialog {

	/**
	 * The title for the dialog.
	 */
	private static final String DIALOG_TITLE = "Please resolve the following ambiguity...";

	/**
	 * A {@link SelectionListener2} that is triggered when the {@link #enhanceMappingModelButton} is selected.
	 */
	protected final SelectionListener2 enhanceMappingModelListener;

	/**
	 * The message for the dialog.
	 */
	protected String message;

	/**
	 * Create the dialog.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param enhanceMappingModelListener2
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public AbstractDialog(String message, final Optional<SelectionListener2> enhanceMappingModelListener2) {

		super(UIHelper.getShell());

		this.setShellStyle(SWT.CLOSE | SWT.BORDER | SWT.TITLE | SWT.RESIZE);

		this.message = message;

		this.enhanceMappingModelListener = enhanceMappingModelListener2.orElse(null);
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {

		return Activator.INSTANCE.getDialogSettings();
	}

	@Override
	public void create() {

		super.create();

		this.setTitle(AbstractDialog.DIALOG_TITLE);
		this.setMessage(this.message, IMessageProvider.WARNING);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {

		Button enhanceMappingModelButton = this.createButton(parent, IDialogConstants.OPEN_ID, "Enhance PAMTraM Model",
				false);
		enhanceMappingModelButton
				.setToolTipText("Enhance the PAMTraM model (e.g. by creating additional mapping hints) to prevent this "
						+ "user interaction in future executions of the transformation...");
		enhanceMappingModelButton.addSelectionListener((SelectionListener2) e -> {
			this.setReturnCode(IDialogConstants.OPEN_ID);
			this.close();

		});
		if (this.enhanceMappingModelListener == null) {
			enhanceMappingModelButton.setEnabled(false);
		} else {
			enhanceMappingModelButton.addSelectionListener(this.enhanceMappingModelListener);
		}
		this.createButton(parent, IDialogConstants.OK_ID, "OK", true);
		this.createButton(parent, IDialogConstants.CANCEL_ID, "Abort transformation", false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);

		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 5;
		layout.marginRight = 5;
		layout.marginLeft = 5;
		container.setLayout(layout);

		this.createInnerContents(container);

		return container;
	}

	/**
	 * This is called as part of {@link #createDialogArea(Composite)} to create the contents between the displayed
	 * message (top) and the buttons (bottom).
	 * <p />
	 * Clients must overwrite this to insert specific contents.
	 *
	 * @param container
	 */
	protected abstract void createInnerContents(Composite container);

	/**
	 * Create a {@link Link} widget that allows to select the given <em>element</em> in a PAMTraM editor (which is
	 * opened if necessary).
	 * <p />
	 * Note: This just calls {@link #createLinkToPamtramModel(Composite, String, EObject)} and provides a label in the
	 * form of '-> Show " + element.eClass().getName() + " in PAMTraM Model...'.
	 *
	 * @see #createLinkToPamtramModel(Composite, String, EObject)
	 *
	 * @param container
	 *            The {@link Composite} below which the link shall be created.
	 * @param element
	 *            The {@link EObject} to select in the PAMTraM editor.
	 */
	protected Link createLinkToPamtramModel(Composite container, EObject element) {

		return this.createLinkToPamtramModel(container,
				"-> Show " + element.eClass().getName() + " in PAMTraM Model...", element);
	}

	/**
	 * Create a {@link Link} widget that allows to select the given <em>element</em> in a PAMTraM editor (which is
	 * opened if necessary).
	 *
	 * @see #createLinkToPamtramModel(Composite, EObject)
	 *
	 * @param container
	 *            The {@link Composite} below which the link shall be created.
	 * @param label
	 *            The label for the link.
	 * @param element
	 *            The {@link EObject} to select in the PAMTraM editor.
	 */
	protected Link createLinkToPamtramModel(Composite container, String label, EObject element) {

		Link link = new Link(container, SWT.NONE);
		GridDataFactory.swtDefaults().applyTo(link);
		link.setText("<A>" + label + "</A>");
		link.addSelectionListener((SelectionListener2) e -> {

			try {
				PamtramEditor editor = (PamtramEditor) UIHelper.openEditor(
						ResourceHelper.getFileForResource(element.eResource()), "pamtram.presentation.PamtramEditorID");
				editor.setSelection(new StructuredSelection(
						AgteleEcoreUtil.getEquivalentElementFrom(element, editor.getEditingDomain().getResourceSet())));
			} catch (Exception e1) {
				UIHelper.log(e1);
				this.setErrorMessage("Unable to select element in the PAMTraM Editor!");
			}

		});

		return link;
	}

	/**
	 * Create a {@link Link} widget that allows to select the given <em>element</em> in a source model editor (which is
	 * opened if necessary).
	 * <p />
	 * Note: This just calls {@link #createLinkToSourceModel(Composite, String, EObject)} and provides a label in the
	 * form of '-> Show Element in Source Model...'.
	 *
	 * @see #createLinkToSourceModel(Composite, String, EObject)
	 *
	 * @param container
	 *            The {@link Composite} below which the link shall be created.
	 * @param element
	 *            The {@link EObject} to select in the source model editor.
	 */
	protected Link createLinkToSourceModel(Composite container, EObject element) {

		return this.createLinkToPamtramModel(container, "-> Show Element in Source Model...", element);
	}

	/**
	 * Create a {@link Link} widget that allows to select the given <em>element</em> in a source model editor (which is
	 * opened if necessary).
	 *
	 * @see #createLinkToSourceModel(Composite, EObject)
	 *
	 * @param container
	 *            The {@link Composite} below which the link shall be created.
	 * @param label
	 *            The label for the link.
	 * @param element
	 *            The {@link EObject} to select in the source model editor.
	 */
	protected Link createLinkToSourceModel(Composite container, String label, EObject element) {

		Link link = new Link(container, SWT.NONE);
		GridDataFactory.swtDefaults().applyTo(link);
		link.setText("<A>" + label + "</A>");
		link.addSelectionListener((SelectionListener2) e -> {

			try {
				UIHelper.selectEObjectInEditor(element, Optional.empty());
			} catch (Exception e1) {
				UIHelper.log(e1);
				this.setErrorMessage("Unable to select element in the Source Model Editor!");
			}

		});

		return link;
	}

}
