package pamtram.presentation.widgets;

import java.util.ArrayList;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import pamtram.presentation.PamtramEditorPlugin;
import de.mfreund.pamtram.util.BundleContentHelper;

/**
 * A class that represents an SWT group containing a tree viewer and 
 * optionally a tool bar.
 * 
 * @author mfreund
 *
 */
public class TreeViewerGroup extends FilteredTree{
	
	private final String bundleID = PamtramEditorPlugin.getPlugin().getSymbolicName();
	
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
	 * This is the tool bar.
	 */
	private ToolBar toolbar;

	private ToolItem separator;

	private String groupText;
	
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
		super(parent, true);
		this.parent = parent;
		this.groupText = groupText;
		this.adapterFactory = adapterFactory;
		this.init(SWT.MULTI, new PatternFilter());
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
		super(parent, true);
		this.parent = parent;
		this.groupText = groupText;
		this.adapterFactory = adapterFactory;
		this.init(SWT.MULTI, new PatternFilter());
	}
	
	/**
	 * Create the filtered tree's controls. This is copied from the 
	 * standard 'FilteredTree' - changes are only introduced in the
	 * layout of the filter composite. 
	 * 
	 * @param parent
	 * @param treeStyle
	 */
	protected void createControl(Composite parent, int treeStyle) {
		
		// Set the layout for the main composite
		if (parent.getLayout() instanceof GridLayout) {
			setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		setLayout(layout);

		// The group to hold everything else.
		group = new Group(this, SWT.NONE);
		group.setText(this.groupText);
		group.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		group.setLayout(new GridLayout(1, true));
		
		if (showFilterControls) {
			
			// This composite hosts two children: the filter composite and the
			// tool bar composite.
			filterComposite= new Composite(group, SWT.NONE);
			filterComposite.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING,
					true, false));

			GridLayout filterLayout= new GridLayout(2, false);
			filterLayout.marginHeight= 0;
			filterLayout.marginWidth= 0;
			filterComposite.setLayout(filterLayout);

			// create filter controls that will take up all of the horizontal space
			// except the one that is taken by the tool bar
			Composite filterBoxComposite = new Composite(filterComposite, SWT.BORDER);
			filterBoxComposite.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			filterBoxComposite.setLayoutData(
					new GridData(SWT.FILL, SWT.BEGINNING, true, false));
			GridLayout filterBoxLayout = new GridLayout(2, false);
			filterBoxLayout.marginHeight = 0;
			filterBoxLayout.marginWidth = 0;
			filterBoxComposite.setLayout(filterLayout);
			filterBoxComposite.setFont(parent.getFont());
			createFilterControls(filterBoxComposite);
			
			// create additional controls besides the filter controls
			Composite toolbarComposite = new Composite(filterComposite, SWT.NONE);
			toolbarComposite.setLayoutData(
					new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
			GridLayout toolbarLayout = new GridLayout(1, false);
			toolbarLayout.marginHeight = 0;
			toolbarLayout.marginWidth = 0;
			toolbarComposite.setLayout(toolbarLayout);
			createToolbar(toolbarComposite, new ArrayList<Image>(), new ArrayList<SelectionListener>(), 
					true, false);
			
		}

		treeComposite = new Composite(group, SWT.NONE);
		GridLayout treeCompositeLayout = new GridLayout();
		treeCompositeLayout.marginHeight = 0;
		treeCompositeLayout.marginWidth = 0;
		treeComposite.setLayout(treeCompositeLayout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		treeComposite.setLayoutData(data);
		createTreeControl(treeComposite, treeStyle);
		
	}
	
	/**
	 * Override the standard method so that default label and content providers
	 * based on the adapter factory are created.
	 * 
	 * @param parent
	 * @param style
	 * @return
	 */
	@Override
	protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
		TreeViewer treeViewer = super.doCreateTreeViewer(parent, style);
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		return treeViewer;
	}

	/**
	 * This creates a tool bar if necessary.
	 * 
	 * @param parent The parent composite.
	 * @param images The images used for the tool items.
	 * @param listeners The listeners used for the tool items.
	 * @param displayCollapseAll If to include a 'collapseAll' button in the tool bar.
	 * @param displaySearch If to include a search/filter box.
	 */
	private void createToolbar(Composite parent, ArrayList<Image> images,
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
		toolbar = new ToolBar(parent, SWT.NONE);
		toolbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		separator = new ToolItem(toolbar, SWT.SEPARATOR);
	    separator.setWidth(0);
	    
	    // Add the 'collapseAll' tool bar item
	    if(displayCollapseAll) {
	    	ToolItem item = new ToolItem(toolbar, SWT.PUSH | SWT.TRAIL);
	    	item.setImage(BundleContentHelper.getBundleImage(bundleID, "icons/collapse_all.gif"));
			item.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					getViewer().collapseAll();
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
	
}
