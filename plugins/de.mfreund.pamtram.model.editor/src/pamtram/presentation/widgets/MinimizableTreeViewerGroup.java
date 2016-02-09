package pamtram.presentation.widgets;

import java.util.ArrayList;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.mfreund.pamtram.util.BundleContentHelper;
import de.mfreund.pamtram.util.SelectionListener2;

/**
 * A {@link TreeViewerGroup} that can be minimized (and restored) when placed insied a {@link MinimizableSashForm}.
 * @author Matthias
 *
 */
public class MinimizableTreeViewerGroup extends TreeViewerGroup implements IMinimizedHeightProvider {
	
	private final String bundleID = "de.mfreund.pamtram.model.editor";
	
	private Image minimizeImage, restoreImage;
	
	/**
	 * This keeps track of the state of the control.
	 */
	private boolean isMinimized;
	
	public MinimizableTreeViewerGroup(MinimizableSashForm parent, ComposedAdapterFactory adapterFactory,
			EditingDomain editingDomain, String groupText) {
		super(parent, adapterFactory, editingDomain, groupText);
	}
	
	public MinimizableTreeViewerGroup(MinimizableSashForm parent, ComposedAdapterFactory adapterFactory,
			EditingDomain editingDomain, String groupText, ArrayList<Image> images,
			ArrayList<SelectionListener> listeners, boolean displayCollapseAll, boolean displayAdd) {
		super(parent, adapterFactory, editingDomain, groupText, images, listeners, displayCollapseAll, displayAdd);
	}

	@Override
	protected void createAdditionalToolbarItems(ToolBar toolbar) {

		isMinimized = false;
		minimizeImage = BundleContentHelper.getBundleImage(bundleID, "icons/minimize.gif");
		restoreImage = BundleContentHelper.getBundleImage(bundleID, "icons/restore.gif");
		
		final ToolItem minimizeItem = new ToolItem(toolbar, SWT.PUSH);
		minimizeItem.setImage(minimizeImage);

		// the listener that removes the 'minimized' state when the user manually resizes the control
		final Listener resizeListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				isMinimized = false;
				minimizeItem.setImage(minimizeImage);
				MinimizableTreeViewerGroup.this.removeListener(SWT.Resize, this);
			}
		};
		
		// either minimize or restore the control depending on the 'minimized' state
		minimizeItem.addSelectionListener(new SelectionListener2() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				isMinimized = !isMinimized;
				
				if(isMinimized) {
					((MinimizableSashForm) parent).minimizeControl(MinimizableTreeViewerGroup.this);
					minimizeItem.setImage(restoreImage);
					MinimizableTreeViewerGroup.this.addListener(SWT.Resize, resizeListener);
					
				} else {
					((MinimizableSashForm) parent).restoreLayout();
					minimizeItem.setImage(minimizeImage);
					MinimizableTreeViewerGroup.this.removeListener(SWT.Resize, resizeListener);
				}
			}
		});
		
		super.createAdditionalToolbarItems(toolbar);
	}
	
	@Override
	public void dispose() {
		minimizeImage.dispose();
		restoreImage.dispose();
		super.dispose();
	}

	@Override
	public int getMinimizedHeight() {
		
		// in the 'minimized' state, we do not want to display the tree viewer
		return (this.group.getSize().y - this.treeViewer.getTree().getSize().y);
	}

}
