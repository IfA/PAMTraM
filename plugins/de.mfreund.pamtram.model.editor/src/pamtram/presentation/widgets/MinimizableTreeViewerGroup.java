package pamtram.presentation.widgets;

import java.util.ArrayList;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.tud.et.ifa.agtele.resources.BundleContentHelper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup;


/**
 * A {@link TreeViewerGroup} that can be minimized (and restored) when placed inside a {@link MinimizableSashForm}.
 * @author Matthias
 *
 */
public class MinimizableTreeViewerGroup extends TreeViewerGroup implements IMinimizedHeightProvider, IMinimizable {
	
	private final String bundleID = "de.mfreund.pamtram.model.editor";
	
	private Image minimizeImage, restoreImage;
	
	/**
	 * This keeps track of the state of the control.
	 */
	private boolean isMinimized;

	/**
	 * The {@link ToolItem} that toggles the state of the tree viewer group between <em>minimized</em> and <em>normal</em>.
	 */
	private ToolItem minimizeItem;
	
	/**
	 * This stores the minimized height that is only calculate once. 
	 */
	private int minimizedHeight;
	
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
		minimizedHeight = -1;
		minimizeImage = BundleContentHelper.getBundleImage(bundleID, "icons/minimize.gif");
		restoreImage = BundleContentHelper.getBundleImage(bundleID, "icons/restore.gif");
		
		minimizeItem = new ToolItem(toolbar, SWT.PUSH);
		minimizeItem.setImage(minimizeImage);
		minimizeItem.setToolTipText("Minimize");

		// either minimize or restore the control depending on the 'minimized' state
		minimizeItem.addSelectionListener(new SelectionListener2() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(!isMinimized) {
					((MinimizableSashForm) parent).minimizeControl(MinimizableTreeViewerGroup.this);
				} else {
					((MinimizableSashForm) parent).restoreLayout();
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

		if(minimizedHeight == -1) {
			// in the 'minimized' state, we do not want to display the tree viewer
			minimizedHeight = (this.group.getSize().y - this.treeViewer.getTree().getSize().y);
		}

		return minimizedHeight;
	}

	@Override
	public void minimize() {
		isMinimized = true;
		minimizeItem.setImage(restoreImage);
		minimizeItem.setToolTipText("Restore");
	}

	@Override
	public void restore() {
		isMinimized = false;
		minimizeItem.setImage(minimizeImage);
		minimizeItem.setToolTipText("Minimize");
	}

}
