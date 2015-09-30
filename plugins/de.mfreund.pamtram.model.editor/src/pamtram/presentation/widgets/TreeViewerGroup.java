package pamtram.presentation.widgets;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.ui.viewer.ColumnViewerInformationControlToolTipSupport;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.DecoratingColumLabelProvider;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

import pamtram.presentation.PamtramEditorPlugin;
import de.mfreund.pamtram.util.BundleContentHelper;

/**
 * A class that represents an SWT group containing a filtered tree viewer and 
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

	/**
	 * This is the label of the group containing all other widgets.
	 */
	private String groupText;

	/**
	 * This is the list of additional images to display in the tool bar
	 * (besides standard icons like 'collapseAll').
	 */
	private ArrayList<Image> toolbarImages;
	
	/**
	 * A setter for the tool bar images that checks for 'null' parameter.
	 * 
	 * @param toolbarImages (may be 'null')
	 */
	private void setToolbarImages(ArrayList<Image> toolbarImages) {
		this.toolbarImages = 
				(toolbarImages != null ? toolbarImages : new ArrayList<Image>()); 
	}

	/**
	 * This is the list of additional listeners that are invoked when the
	 * user selects one of the additional images in the tool bar.
	 */
	private ArrayList<SelectionListener> toolbarListeners;

	/**
	 * Whether to display a 'collapseAll' button in the tool bar.
	 */
	private boolean displayCollapseAll;
	
	/**
	 * Whether to display an 'add' button in the tool bar.
	 */
	private boolean displayAdd;

	private EditingDomain editingDomain;
	
	/**
	 * A setter for the tool bar listeners that checks for 'null' parameter.
	 * 
	 * @param toolbarListeners (may be 'null')
	 */
	private void setToolbarListeners(ArrayList<SelectionListener> toolbarListeners) {
		this.toolbarListeners = 
				(toolbarListeners != null ? toolbarListeners : new ArrayList<SelectionListener>()); 
	}
	
	/**
	 * Use this constructor if you do not want to add a tool bar to the viewer.
	 * 
	 * @param parent The parent composite.
	 * @param adapterFactory The adapter factory used to create label and
	 * 	content adapters.
	 * @param editingDomain The editing domain that is used for the viewer.
	 * @param groupText The label of the group widget that hold all other
	 * 	widgets.
	 */
	public TreeViewerGroup(Composite parent, ComposedAdapterFactory adapterFactory,
			EditingDomain editingDomain, String groupText) {
		super(parent, true);
		this.parent = parent;
		this.groupText = groupText;
		this.setToolbarImages(null);
		this.setToolbarListeners(null);
		this.displayCollapseAll = false;
		this.displayAdd = false;
		this.editingDomain = editingDomain;
		this.adapterFactory = adapterFactory;
		this.init(SWT.MULTI, new PatternFilter());
	}
	
	/**
	 * Use this constructor if you want to add a tool bar to the viewer.
	 * 
	 * @param parent The parent composite.
	 * @param adapterFactory The adapter factory used to create label and
	 	content adapters.
	 * @param editingDomain The editing domain that is used for the viewer.
	 * @param groupText The label of the group widget that hold all other
	 * 	widgets.
	 * @param images A list of images used as icons for the items of the tool bar.
	 * @param listeners A list of SelectionListeners used for the items of the tool bar.
	 * @param displayCollapseAll If to include a 'collapseAll' button in the tool bar.
	 * @param displayAdd If to include an 'add' button in the tool bar.
	 */
	public TreeViewerGroup(Composite parent, ComposedAdapterFactory adapterFactory, 
			EditingDomain editingDomain, String groupText, ArrayList<Image> images, 
			ArrayList<SelectionListener> listeners, boolean displayCollapseAll, boolean displayAdd) {
		super(parent, true);
		this.parent = parent;
		this.groupText = groupText;
		this.setToolbarImages(images);
		this.setToolbarListeners(listeners);
		this.displayCollapseAll = displayCollapseAll;
		this.displayAdd = displayAdd;
		this.adapterFactory = adapterFactory;
		this.editingDomain = editingDomain;
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
	@Override
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
			
			// create a toolbar besides the filter controls
			Composite toolbarComposite = new Composite(filterComposite, SWT.NONE);
			toolbarComposite.setLayoutData(
					new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));
			GridLayout toolbarLayout = new GridLayout(1, false);
			toolbarLayout.marginHeight = 0;
			toolbarLayout.marginWidth = 0;
			toolbarComposite.setLayout(toolbarLayout);
			createToolbar(toolbarComposite, toolbarImages, toolbarListeners, 
					displayCollapseAll, displayAdd);
			
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
		treeViewer.setLabelProvider(new DecoratingColumLabelProvider(
				new AdapterFactoryLabelProvider(adapterFactory), 
				new DiagnosticDecorator(editingDomain, treeViewer, PamtramEditorPlugin.getPlugin().getDialogSettings())));
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		new ColumnViewerInformationControlToolTipSupport(
				treeViewer, 
				new DiagnosticDecorator.EditingDomainLocationListener(editingDomain, treeViewer));
		return treeViewer;
	}

	/**
	 * This creates a tool bar if necessary.
	 * 
	 * @param parent The parent composite.
	 * @param images The images used for the tool items.
	 * @param listeners The listeners used for the tool items.
	 * @param displayCollapseAll If to include a 'collapseAll' button in the tool bar.
	 * @param displayAdd If to include an add button.
	 */
	private void createToolbar(Composite parent, ArrayList<Image> images,
			ArrayList<SelectionListener> listeners, boolean displayCollapseAll,
			boolean displayAdd) {
		
		if(images.size() != listeners.size()) {
			throw new RuntimeException("The number of images provided must match"
					+ " the number of listeners provided!");
		}
		
		if(images.isEmpty() && listeners.isEmpty() && !displayCollapseAll && !displayAdd) {
			// nothing to be done
			return;
		}
		
		// Create the button area
		toolbar = new ToolBar(parent, SWT.NONE);
		toolbar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	    
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
	    
	    // Add the 'add' tool bar item
	    if(displayAdd) {
	    	ToolItem item = new ToolItem(toolbar, SWT.DROP_DOWN);
	    	item.setImage(BundleContentHelper.getBundleImage(bundleID, "icons/add_obj.gif"));
	    	
	        item.addSelectionListener(
	        		new AddDropDownSelectionListener(item));
	    }
		
	    // Add the various tool bar items passed in the constructor
		for (int i=0; i<images.size(); i++) {
			ToolItem item = new ToolItem(toolbar, SWT.PUSH | SWT.TRAIL);
			item.setImage(images.get(i));
			item.addSelectionListener(listeners.get(i));
		}
		
		// Add additional stuff to the tool bar
		createAdditionalToolbarItems(toolbar);
		
		toolbar.pack();

	}
	
	/**
	 * This creates additional tool bar items besides the standard items
	 * like 'collapseAll'. The default implementation does nothing - 
	 * subclasses may override. 
	 * 
	 * @param toolbar The parent tool bar.
	 */
	protected void createAdditionalToolbarItems(ToolBar toolbar) {
		
		// allow extending classes to easily configure the tool bar
	}
	
	class AddDropDownSelectionListener extends SelectionAdapter {
		
		private MenuManager menuManager;

		public AddDropDownSelectionListener(ToolItem dropdown) {
			menuManager = new MenuManager();
			menuManager.createContextMenu(dropdown.getParent());
		}
		
		@Override
		public void widgetSelected(SelectionEvent event) {
			if (event.detail == SWT.ARROW) {
		    	ToolItem item = (ToolItem) event.widget;
		    	Rectangle rect = item.getBounds();
		    	Point pt = item.getParent().toDisplay(new Point(rect.x, rect.y));
		    	createMenu();
		    	menuManager.getMenu().setLocation(pt.x, pt.y + rect.height);
		    	menuManager.getMenu().setVisible(true);
		    } else {
		    	addDefaultElement();
		    }
		}
		
		/**
		 * This determines the currently selected element and adds
		 * an element of the same type to its parent.
		 */
		private void addDefaultElement() {
			ISelection selection = treeViewer.getSelection();
			if(selection.isEmpty() || !(selection instanceof StructuredSelection)) {
				// nothing to be done
				return;
			}
			StructuredSelection structuredSelection = (StructuredSelection) selection;
			Object selectedObject = structuredSelection.getFirstElement();
			if(!(selectedObject instanceof EObject)) {
				// nothing to be done
				return;
			}
			
			// A command that will create a new eObject that is of the same
			// type of the selected eObject. The newly created object will then
			// be added to the parent.
			CreateChildCommand command = new CreateChildCommand(
					editingDomain,
					((EObject) selectedObject).eContainer(),
					((EObject) selectedObject).eContainingFeature(), 
					EcoreUtil.create(
							((EObject) selectedObject).eClass()),
					null);
			
			// Execute the command and set the selection of the viewer to the
			// newly created object.
			editingDomain.getCommandStack().execute(command);
			treeViewer.setSelection(new StructuredSelection(command.getResult().toArray()));
		}
		
		/**
		 * This creates a new menu based on the currently selected 
		 * element that allows to create children and siblings.
		 */
		private void createMenu() {
			
			// Clear the context menu
			//
			menuManager.removeAll();
			
			// Query the new selection for appropriate new child/sibling descriptors
			//
			Collection<?> newChildDescriptors = null;
			Collection<?> newSiblingDescriptors = null;
			ISelection selection = treeViewer.getSelection();
			if (!(selection instanceof IStructuredSelection) || 
					!(((IStructuredSelection)selection).size() == 1)) {
						// nothing to be done
						// TODO if nothing is selected, the user should be allowed
						// to add top-level elements
						return;
			}
			
			Object object = ((IStructuredSelection)selection).getFirstElement();

			newChildDescriptors = editingDomain.getNewChildDescriptors(object, null);
			newSiblingDescriptors = editingDomain.getNewChildDescriptors(null, object);

			IEditorPart editorPart = 
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			
			// Generate actions for selection; populate and redraw the menus.
			//
			ArrayList<IAction> createChildActions = new ArrayList<>();
			for (Object descriptor : newChildDescriptors) {
				createChildActions.add(
						new CreateChildAction(editorPart, selection, descriptor));
			}
			ArrayList<IAction> createSiblingActions = new ArrayList<>();
			for (Object descriptor : newSiblingDescriptors) {
				createSiblingActions.add(
						new CreateSiblingAction(editorPart, selection, descriptor));
			}

			// Populate the context menu
			//
			menuManager.add(new Separator("Add Child"));
			for (IAction iAction : createChildActions) {
				menuManager.add(iAction);
			}
			menuManager.add(new Separator("Add Sibling"));
			for (IAction iAction : createSiblingActions) {
				menuManager.add(iAction);
			}
		}
	}

}