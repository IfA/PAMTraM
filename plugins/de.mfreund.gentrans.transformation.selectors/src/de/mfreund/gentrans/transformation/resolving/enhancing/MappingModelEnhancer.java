/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.AbstractDialog;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.PAMTraM;
import pamtram.presentation.PamtramEditor;

/**
 * An abstract base class that can be used to implement {@link AbstractDialog#enhanceMappingModelListener}.
 * <p />
 * Concrete implementations are provided for each ambiguity and are used by the {@link UserDecisionResolvingStrategy}.
 *
 * @author mfreund
 * @param <D>
 *            The concrete type of {@link AbstractDialog} that this enhancer operates on.
 */
public abstract class MappingModelEnhancer<D extends AbstractDialog> implements SelectionListener2 {

	/**
	 * The {@link AbstractDialog} that this enhancer operates on (based on that the enhancement is executed).
	 */
	protected D dialog = null;

	/**
	 * The {@link PAMTraM} model that this enhancer operates on (loaded as part of the transformation).
	 * <p />
	 * Note: This differs from that {@link PamtramEditor#getPamtram() instance} that is managed by the {@link #editor}
	 * (as it was loaded via a different resource set).
	 */
	protected PAMTraM pamtramModel;

	/**
	 * The {@link PamtramEditor} associated with the {@link #pamtramModel}.
	 */
	protected PamtramEditor editor;

	/**
	 * This creates an instance.
	 *
	 * @param pamtramModel
	 *            The {@link PAMTraM} model that this enhancer operates on.
	 */
	public MappingModelEnhancer(PAMTraM pamtramModel) {

		this.pamtramModel = pamtramModel;
	}

	/**
	 * This is the setter for the {@link #dialog}.
	 * <p />
	 * Note: This needs to be called before the {@link AbstractDialog#enhanceMappingModelButton} is pressed by the user.
	 * Note: The passed <em>dialogRunner</em> needs to be of the same type as the generic type parameter <em>D</em>.
	 *
	 * @param dialog
	 *            The {@link AbstractDialog} that this enhancer operates on (based on that the enhancement is executed).
	 */
	@SuppressWarnings("unchecked")
	public void setDialogRunner(Object dialog) {

		this.dialog = (D) dialog;
	}

	/**
	 * This is the getter for the {@link #editor}.
	 *
	 * @return The {@link PamtramEditor} associated with the {@link #pamtramModel}.
	 */
	protected PamtramEditor getEditor() {

		if (this.editor == null) {
			this.editor = PamtramEditor.getEditor(this.pamtramModel, true);
		}
		return this.editor;
	}

}
