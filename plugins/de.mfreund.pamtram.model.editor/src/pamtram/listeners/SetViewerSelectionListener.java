package pamtram.listeners;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;

import de.mfreund.pamtram.util.SelectionListener2;
import pamtram.presentation.PamtramEditor;

/**
 * A {@link SelectionListener2 SelectionListener} that triggers {@link PamtramEditor#setCurrentViewer(Viewer)}.
 * <p />
 * An instance of this should be attached to all {@link Control Controls} that display an excerpt
 * of the PAMTraM model. It ensures that the 'current viewer' is always kept up to date and thus that, e.g.,
 * the properties view always displays the properties of the correct element.
 * 
 * @author mfreund
 */
public class SetViewerSelectionListener implements SelectionListener2 {
	
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
	public SetViewerSelectionListener(PamtramEditor editor, Viewer viewer) {
		this.editor = editor;
		this.viewer = viewer;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		editor.setCurrentViewer(viewer);			
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {}

}