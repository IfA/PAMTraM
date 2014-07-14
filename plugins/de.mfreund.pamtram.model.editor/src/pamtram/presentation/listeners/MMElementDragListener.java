package pamtram.presentation.listeners;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;

import pamtram.metamodel.MetaModelElement;

public class MMElementDragListener implements DragSourceListener {
	
	private final TreeViewer viewer;
	
	public MMElementDragListener(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void dragStart(DragSourceEvent event) {}

	@Override
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		MetaModelElement firstElement = (MetaModelElement) selection.getFirstElement();
		
		event.data = firstElement;
	}

	@Override
	public void dragFinished(DragSourceEvent event) {}

}
