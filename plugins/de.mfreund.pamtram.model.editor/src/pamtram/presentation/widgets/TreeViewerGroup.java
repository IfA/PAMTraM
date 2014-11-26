package pamtram.presentation.widgets;

import java.util.ArrayList;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;

/**
 * A class that represents an SWT group containing a tree viewer and 
 * optionally a tool bar.
 * 
 * @author mfreund
 *
 */
public class TreeViewerGroup {
	
	/**
	 * This is the adapter factory used to create content and
	 * label providers.
	 */
	private ComposedAdapterFactory adapterFactory;
	
	/**
	 * This is the group that contains all other parts.
	 */
	private Group group;
	
	/**
	 * This is the tree that is displayed in the tree viewer.
	 */
	private Tree tree;
	
	/**
	 * This is the tree viewer that displays the tree.
	 */
	private TreeViewer treeViewer;
	
	/**
	 * This returns the tree viewer of this composite.
	 * @return the tree viewer.
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	/**
	 * This is the parent composite holding all widgets created
	 * by this object.
	 */
	private Composite parent;
	
	/**
	 * This is the tool bar.
	 */
	private ToolBar toolbar;
	
	/**
	 * Use this constructor if you do not want to add a tool bar to the viewer.
	 * 
	 * @param parent The parent composite.
	 * @param adapterFactory The adapter factory used to create label and
	 * 	content adapters.
	 * @param groupText The label of the group widget that hold all other
	 * 	widgets.
	 */
	public TreeViewerGroup(Composite parent, ComposedAdapterFactory adapterFactory,
			String groupText) {
		this.parent = parent;
		this.adapterFactory = adapterFactory;
		createLayout(groupText, null, null);
	}
	
	/**
	 * Use this constructor if you want to add a tool bar to the viewer.
	 * 
	 * @param parent The parent composite.
	 * @param adapterFactory The adapter factory used to create label and
	 	content adapters.
	 * @param groupText The label of the group widget that hold all other
	 * 	widgets.
	 * @param images A list of images used as icons for the items of the tool bar.
	 * @param listeners A list of SelectionListeners used for the items of the tool bar.
	 */
	public TreeViewerGroup(Composite parent, ComposedAdapterFactory adapterFactory,
			String groupText, ArrayList<Image> images, ArrayList<SelectionListener> listeners) {
		
		this.parent = parent;
		this.adapterFactory = adapterFactory;
		createLayout(groupText, images, listeners);
	}

	/**
	 * This creates the layout of the composite.
	 */
	private void createLayout(String groupText, ArrayList<Image> images, 
			ArrayList<SelectionListener> listeners) {
		
		// The group to hold all other widgets.
		group = new Group(parent, SWT.NONE);
		group.setText(groupText);
		group.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		group.setLayout(new GridLayout(1, true));
		
		// If necessary, create the tool bar.
		createToolbar(images, listeners);
		
		// Create the tree viewer.
		tree = new Tree(group, SWT.MULTI);
		treeViewer = new TreeViewer(tree);
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		tree.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
	}

	/**
	 * This creates a tool bar if necessary.
	 * 
	 * @param images The images used for the tool items.
	 * @param listeners The listeners used for the tool items.
	 */
	private void createToolbar(ArrayList<Image> images,
			ArrayList<SelectionListener> listeners) {
		
		if(images == null && listeners == null) {
			// nothing to be done
			return;
		}
		
		if(images == null || listeners == null || images.size() != listeners.size()) {
			throw new RuntimeException("The number of images provided must match"
					+ " the number of listeners provided!");
		}
		
		if(images.isEmpty() && listeners.isEmpty()) {
			// nothing to be done
			return;
		}
		
		// Create the button area
		toolbar = new ToolBar(group, SWT.NONE);
		toolbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		// This separator will be resized in order to get right alignment.
		final ToolItem separator = new ToolItem(toolbar, SWT.SEPARATOR);
	    separator.setWidth(0);
		
	    // Add the various toobar items
		for (int i=0; i<images.size(); i++) {
			ToolItem item = new ToolItem(toolbar, SWT.PUSH | SWT.TRAIL);
			item.setImage(images.get(i));
			item.addSelectionListener(listeners.get(i));
		}
		
		toolbar.pack();

		// This handles the right alignment of the toolbar items on resize 
		final int toolbarItemSize = computeToolbarItemSize();
		toolbar.addListener(SWT.Resize, new Listener() {
			@Override
		    public void handleEvent(Event event) {
	            final int separatorWidth = toolbar.getSize().x - toolbarItemSize ;
	            separator.setWidth(separatorWidth);
	        }
	    });
	}

	private int computeToolbarItemSize() {
		int itemSize = 0;
		
		// do not include the size of the separator used for right alignment
		for(int i=1; i<toolbar.getItemCount(); i++) {
			itemSize += toolbar.getItems()[i].getWidth();
		}
		
		return itemSize;
	}
}
