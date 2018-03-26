/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.pamtram.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.mfreund.pamtram.ui.views.PamtramReferencesView;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PAMTraM;

/**
 * An {@link AbstractHandler} that allows the user to identify, which elements
 * of a {@link PAMTraM} model reference the currently selected element.
 *
 * @author mfreund
 */
public class ShowReferencesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// The element for that references shall be shown
		//
		EObject selectedElement = (EObject) UIHelper.getFirstSelection();

		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		if (selectedElement != null) {
			try {
				IViewPart view = editorPart.getSite().getPage().showView(PamtramReferencesView.VIEW_ID);
				((PamtramReferencesView) view).setAnalyzedObject((EObject) selectedElement);
			} catch (PartInitException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}

}
