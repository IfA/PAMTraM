package pamtram.commandlistener;

import org.eclipse.emf.common.command.CommandStackListener;

/**
 * Abstract command listener that all listeners acting as child
 * listener of the PamtramCommandStackListener have to implement.
 * 
 * @author mfreund
 *
 */
abstract class PamtramChildCommandStackListener implements CommandStackListener {

	PamtramCommandStackListener parentListener;
	
	public PamtramChildCommandStackListener(PamtramCommandStackListener parentListener) {
		this.parentListener = parentListener;
	}
}
