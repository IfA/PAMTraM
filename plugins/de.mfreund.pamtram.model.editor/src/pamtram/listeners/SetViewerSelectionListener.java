/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.listeners;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.presentation.PamtramEditor;

/**
 * A {@link SelectionListener2 SelectionListener} that triggers {@link PamtramEditor#setCurrentViewer(Viewer)}.
 * <p />
 * An instance of this should be attached to all {@link Control Controls} that display an excerpt of the PAMTraM model.
 * It ensures that the 'current viewer' is always kept up to date and thus that, e.g., the properties view always
 * displays the properties of the correct element.
 * <p />
 * Additionally, depending of the resulting selection in the {@link #viewer},
 * {@link #handleEmptySelection(SelectionEvent)}, {@link #handleSingleSelection(Object, SelectionEvent)} or
 * {@link #handleMultiSelection(List, SelectionEvent)} is called. While the default implementations of these methods do
 * nothing, clients may override these.
 *
 * @author mfreund
 */
public class SetViewerSelectionListener implements SelectionListener2 {

	/**
	 * The {@link PamtramEditor} for that the viewer shall be {@link PamtramEditor#setCurrentViewer(Viewer) activated}
	 * if this listener is triggered.
	 */
	protected PamtramEditor editor;

	/**
	 * The viewer that shall be {@link PamtramEditor#setCurrentViewer(Viewer) activated} upon if this listener is
	 * triggered.
	 */
	protected Viewer viewer;

	/**
	 * This creates an instance.
	 *
	 * @param editor
	 *            The {@link PamtramEditor} for that the viewer shall be {@link PamtramEditor#setCurrentViewer(Viewer)
	 *            activated} if this listener is triggered.
	 * @param viewer
	 *            The viewer that shall be {@link PamtramEditor#setCurrentViewer(Viewer) activated} upon if this
	 *            listener is triggered.
	 */
	public SetViewerSelectionListener(PamtramEditor editor, Viewer viewer) {

		this.editor = editor;
		this.viewer = viewer;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		editor.setCurrentViewer(viewer);

		if (e.item == null || !(viewer.getSelection() instanceof StructuredSelection)) {
			return;
		}

		StructuredSelection selection = (StructuredSelection) viewer.getSelection();

		if (selection.isEmpty()) {
			handleEmptySelection(e);
		} else if (selection.size() == 1) {
			handleSingleSelection(selection.getFirstElement(), e);
		} else {
			handleMultiSelection(Arrays.asList(selection.toArray()), e);
		}
	}

	/**
	 * React to the {@link #widgetSelected(SelectionEvent) selection} of no element in the {@link #viewer}.
	 *
	 * @param e
	 *            The {@link SelectionEvent} that triggered {@link #widgetSelected(SelectionEvent)}.
	 */
	protected void handleEmptySelection(SelectionEvent e) {

		// default implementation does nothing
	}

	/**
	 * React to the {@link #widgetSelected(SelectionEvent) selection} of a single element in the {@link #viewer}.
	 *
	 * @param selected
	 *            The selected element.
	 * @param e
	 *            The {@link SelectionEvent} that triggered {@link #widgetSelected(SelectionEvent)}.
	 */
	protected void handleSingleSelection(Object selected, SelectionEvent e) {

		// default implementation does nothing
	}

	/**
	 * React to the {@link #widgetSelected(SelectionEvent) selection} of multiple elements in the {@link #viewer}.
	 *
	 * @param selected
	 *            The selected elements.
	 * @param e
	 *            The {@link SelectionEvent} that triggered {@link #widgetSelected(SelectionEvent)}.
	 */
	protected void handleMultiSelection(List<Object> selected, SelectionEvent e) {

		// default implementation does nothing
	}

}
