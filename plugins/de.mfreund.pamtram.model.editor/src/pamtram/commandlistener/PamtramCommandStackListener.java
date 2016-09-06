package pamtram.commandlistener;

import java.util.ArrayList;
import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStackListener;

import pamtram.presentation.PamtramEditor;

/**
 * A command stack listener that holds track of multiple sub-listeners and
 * notifies them once a command has been issued.
 *
 * @author mfreund
 */
public class PamtramCommandStackListener implements CommandStackListener {

	/**
	 * The {@link PamtramEditor} on whose command stack this listener listens.
	 */
	private PamtramEditor editor = null;

	/**
	 * A list of CommandStack listeners that act as children of this listener and
	 * will be notified of any issued command automatically when this listener
	 * is notified. With this structure, a better separation should be possible
	 * but we can still manage to work with one single listener for everything.
	 */
	ArrayList<PamtramChildCommandStackListener> subListeners =
			new ArrayList<>();

	final ValueModifierSetChangedListener attValModifierSetChangedListener =
	new ValueModifierSetChangedListener(this);

	/**
	 * Constructor.
	 *
	 * @param editor The editor on whose command stack this listener listens.
	 */
	public PamtramCommandStackListener(PamtramEditor editor) {
	
		this.editor = editor;
	
		// populate the list of child command stack listeners
		this.subListeners.add(this.attValModifierSetChangedListener);
	}

	/**
	 * The {@link PamtramEditor} on whose command stack this listener listens.
	 *
	 * @return The {@link PamtramEditor}.
	 */
	public PamtramEditor getEditor() {
		return this.editor;
	}

	@Override
	public void commandStackChanged(EventObject event) {

		// notfiy every child listener
		for (PamtramChildCommandStackListener childListener : this.subListeners) {
			childListener.commandStackChanged(event);
		}
	}

}
