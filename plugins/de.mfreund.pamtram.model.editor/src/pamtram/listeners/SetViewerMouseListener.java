package pamtram.listeners;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Control;

import pamtram.presentation.PamtramEditor;

/**
 * A {@link MouseListener} that triggers {@link PamtramEditor#setCurrentViewer(Viewer)}.
 * <p />
 * An instance of this should be attached to all {@link Control Controls} that display an excerpt
 * of the PAMTraM model. It ensures that the correct 'current viewer' is set before other listeners
 * (e.g. a SelectionListener) are triggered and thus that no selection events are mysteriously lost.
 * 
 * @author mfreund
 */
public class SetViewerMouseListener implements MouseListener {
	
	/**
	 * The {@link PamtramEditor} for that the viewer shall be {@link PamtramEditor#setCurrentViewer(Viewer) activated}
	 * if this listener is triggered. 
	 */
	private PamtramEditor editor;
	
	/**
	 * The viewer that shall be {@link PamtramEditor#setCurrentViewer(Viewer) activated} upon
	 * if this listener is triggered.
	 */
	private Viewer viewer;
	
	/**
	 * This creates an instance.
	 * 
	 * @param editor The {@link PamtramEditor} for that the viewer shall be {@link PamtramEditor#setCurrentViewer(Viewer) activated}
	 * if this listener is triggered. 
	 * @param viewer The viewer that shall be {@link PamtramEditor#setCurrentViewer(Viewer) activated} upon
	 * if this listener is triggered.
	 */
	public SetViewerMouseListener(PamtramEditor editor, Viewer viewer) {
		this.editor = editor;
		this.viewer = viewer;
	}
	
	@Override
	public void mouseUp(MouseEvent e) {}

	@Override
	public void mouseDown(MouseEvent e) {
		editor.setCurrentViewer(viewer);
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {}
}