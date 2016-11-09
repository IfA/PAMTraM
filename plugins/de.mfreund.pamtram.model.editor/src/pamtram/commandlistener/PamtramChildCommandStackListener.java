package pamtram.commandlistener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;

/**
 * Abstract command listener that all listeners acting as child
 * listener of the PamtramCommandStackListener have to implement.
 *
 * @author mfreund
 *
 */
abstract class PamtramChildCommandStackListener implements CommandStackListener {

	/**
	 * The parent {@link PamtramCommandStackListener} for this listener.
	 */
	final PamtramCommandStackListener parentListener;

	/**
	 * This creates an instance.
	 *
	 * @param parentListener
	 *            The parent {@link PamtramCommandStackListener} for this listener.
	 */
	public PamtramChildCommandStackListener(PamtramCommandStackListener parentListener) {
		this.parentListener = parentListener;
	}

	/**
	 * This returns the {@link CommandStack#getMostRecentCommand() most recent command} that was executed on the command
	 * stack of the {@link #parentListener}.
	 *
	 * @return The most recent command executed on the command stack of the {@link #parentListener} .
	 */
	Command getMostRecentCommand() {
		return this.parentListener.getEditor().getEditingDomain().getCommandStack().getMostRecentCommand();
	}
}
