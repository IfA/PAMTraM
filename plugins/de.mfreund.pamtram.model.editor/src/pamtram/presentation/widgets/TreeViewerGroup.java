package pamtram.presentation.widgets;

import java.util.ArrayList;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.mihalis.opal.promptSupport.PromptSupport;

import pamtram.presentation.PamtramEditorPlugin;
import de.mfreund.pamtram.util.BundleContentHelper;

/**
 * A class that represents an SWT group containing a tree viewer and 
 * optionally a tool bar.
 * 
 * @author mfreund
 *
 */
public class TreeViewerGroup {
	
	private final String bundleID = PamtramEditorPlugin.getPlugin().getSymbolicName();
	
	private final int fontSize = 9;
	
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

	private ToolItem separator;
	
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
		createLayout(groupText, null, null, false, false);
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
	 * @param displayCollapseAll If to include a 'collapseAll' button in the tool bar.
	 * @param displaySearch If to include a search/filter box.
	 */
	public TreeViewerGroup(Composite parent, ComposedAdapterFactory adapterFactory,
			String groupText, ArrayList<Image> images, ArrayList<SelectionListener> listeners,
			boolean displayCollapseAll, boolean displaySearch) {
		
		this.parent = parent;
		this.adapterFactory = adapterFactory;
		createLayout(groupText, images, listeners, displayCollapseAll, displaySearch);
	}

	/**
	 * This creates the layout of the composite.
	 */
	private void createLayout(String groupText, ArrayList<Image> images, 
			ArrayList<SelectionListener> listeners, boolean displayCollapseAll,
			boolean displaySearch) {
		
		// The group to hold all other widgets.
		group = new Group(parent, SWT.NONE);
		group.setText(groupText);
		group.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		group.setLayout(new GridLayout(1, true));
		
		// If necessary, create the tool bar.
		createToolbar(images, listeners, displayCollapseAll, displaySearch);
		
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
	 * @param displayCollapseAll If to include a 'collapseAll' button in the tool bar.
	 * @param displaySearch If to include a search/filter box.
	 */
	private void createToolbar(ArrayList<Image> images,
			ArrayList<SelectionListener> listeners, boolean displayCollapseAll,
			boolean displaySearch) {
		
		if(images == null && listeners == null && !displayCollapseAll) {
			// nothing to be done
			return;
		}
		
		if(images == null || listeners == null || images.size() != listeners.size()) {
			throw new RuntimeException("The number of images provided must match"
					+ " the number of listeners provided!");
		}
		
		if(images.isEmpty() && listeners.isEmpty() && !displayCollapseAll && !displaySearch) {
			// nothing to be done
			return;
		}
		
		// Create the button area
		toolbar = new ToolBar(group, SWT.NONE);
		toolbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		
		// Add the search/filter box
		if(displaySearch) {
			
			// Create the search text box
			ToolItem searchItem = new ToolItem(toolbar, SWT.NONE); 
			final Text search = new Text(toolbar, 
					SWT.CANCEL | SWT.SEARCH | SWT.ICON_CANCEL | SWT.ICON_SEARCH);
			setFontSize(search, fontSize);
			PromptSupport.setPrompt("Search...", search);
			search.pack();
			searchItem.setControl(search);
			searchItem.setWidth(search.computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
			
			// Add a listener that performs the search
			search.addKeyListener(new KeyListener() {
				
				@Override
				public void keyReleased(KeyEvent e) {}
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.keyCode == SWT.ESC) {
						search.setText("");
					}
					System.out.println(search.getText());
				}
			});

			// Create a 'dummy item' with a transparent image that is used to control
			// the height of the tool bar: Manual resizing does not seem to work because
			// the height of a tool bar is determined by the height of the first image
			// added to it. If we do not include the search box, we do not need this
			// as the images will adjust themself.
			ToolItem dummyItem = new ToolItem(toolbar, SWT.NONE);
			int dummyHeight = search.getLineHeight();
			dummyItem.setImage(
					resize(BundleContentHelper.getBundleImage(bundleID, "icons/transparent.png"),
							dummyHeight, dummyHeight));
		}
		
		separator = new ToolItem(toolbar, SWT.SEPARATOR);
	    separator.setWidth(0);
	    
	    // Add the 'collapseAll' tool bar item
	    if(displayCollapseAll) {
	    	ToolItem item = new ToolItem(toolbar, SWT.PUSH | SWT.TRAIL);
	    	item.setImage(BundleContentHelper.getBundleImage(bundleID, "icons/collapse_all.gif"));
			item.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					treeViewer.collapseAll();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {}
			});
	    }
		
	    // Add the various tool bar items passed in the constructor
		for (int i=0; i<images.size(); i++) {
			ToolItem item = new ToolItem(toolbar, SWT.PUSH | SWT.TRAIL);
			item.setImage(images.get(i));
			item.addSelectionListener(listeners.get(i));
		}
		
		toolbar.pack();

		// This handles the right alignment of the tool bar items on resize 
		final int toolbarItemSize = computeToolbarItemWidth();
		toolbar.addListener(SWT.Resize, new Listener() {
			@Override
		    public void handleEvent(Event event) {
	            final int separatorWidth = toolbar.getSize().x - toolbarItemSize ;
	            separator.setWidth(separatorWidth);
	        }
	    });
	}

	/**
	 * Computes the size of the items in the tool bar.
	 * @return
	 */
	private int computeToolbarItemWidth() {
		int itemSize = 0;
		
		for(int i=0; i<toolbar.getItemCount(); i++) {
			// do not include the size of the separator used for right alignment
			if(toolbar.getItems()[i].equals(separator)) {
				continue;
			}
			itemSize += toolbar.getItems()[i].getWidth();
		}
		
		return itemSize;
	}
	
	/**
	 * Resizes an image.
	 * From http://aniszczyk.org/2007/08/09/resizing-images-using-swt/
	 * @param image
	 * @param width
	 * @param height
	 * @return
	 */
	private Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, 
		image.getBounds().width, image.getBounds().height, 
		0, 0, width, height);
		gc.dispose();
		image.dispose(); // don't forget about me!
		return scaled;
	}
	
	/**
	 * Sets the font size of a text box.
	 * 
	 * @param text
	 * @param fontSize
	 */
	private void setFontSize(Text text, int fontSize) {
		FontData[] fontData = text.getFont().getFontData();
		fontData[0].setHeight(fontSize);
		text.setFont(new Font(toolbar.getDisplay(), fontData));
	}
}
