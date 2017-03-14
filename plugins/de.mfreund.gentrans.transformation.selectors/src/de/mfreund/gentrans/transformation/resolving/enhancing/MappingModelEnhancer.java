/**
 *
 */
package de.mfreund.gentrans.transformation.resolving.enhancing;

import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.wizards.AbstractDialog;
import de.mfreund.gentrans.transformation.resolving.wizards.AbstractDialogRunner;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.PAMTraM;
import pamtram.presentation.PamtramEditor;


/**
 * An abstract base class that can be used to implement {@link AbstractDialogRunner#enhanceMappingModelListener}.
 * <p />
 * Concrete implementations are provided for each ambiguity and are used by the {@link UserDecisionResolvingStrategy}.
 *
 * @author mfreund
 * @param <D>
 *            The concrete type of {@link AbstractDialogRunner} that this enhancer operates on.
 */
public abstract class MappingModelEnhancer<D extends AbstractDialogRunner> implements SelectionListener2 {

	/**
	 * The {@link AbstractDialogRunner} that this enhancer operates on (based on that the enhancement is executed).
	 */
	protected D dialogRunner = null;

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
	private PamtramEditor editor;

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
	 * This is the setter for the {@link #dialogRunner}.
	 * <p />
	 * Note: This needs to be called before the {@link AbstractDialog#enhanceMappingModelButton} is pressed by the user.
	 * Note: The passed <em>dialogRunner</em> needs to be of the same type as the generic type parameter <em>D</em>.
	 *
	 * @param dialogRunner
	 *            The {@link AbstractDialogRunner} that this enhancer operates on (based on that the enhancement is
	 *            executed).
	 */
	@SuppressWarnings("unchecked")
	public void setDialogRunner(Object dialogRunner) {

		this.dialogRunner = (D) dialogRunner;
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
