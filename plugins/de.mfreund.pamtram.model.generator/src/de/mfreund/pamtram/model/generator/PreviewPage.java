package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

import de.mfreund.pamtram.model.generator.provider.ResultPageTableViewerContentProvider;
import de.mfreund.pamtram.model.generator.provider.ResultPageTableViewerLabelProvider;
import pamtram.PAMTraM;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.provider.MetamodelItemProviderAdapterFactory;

public class PreviewPage extends WizardPage {

	private final class ResultPageTreeViewerSelectionListener implements
	SelectionListener {
		private final Tree tree;

		private ResultPageTreeViewerSelectionListener(Tree tree) {
			this.tree = tree;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			TreeItem item = (TreeItem) e.item;

			List<Attribute> lines = new ArrayList<Attribute>();

			if(item.getData() instanceof pamtram.metamodel.Class) {
				// populate the attribute view
				lines.addAll(
						((pamtram.metamodel.Class)item.getData()).getAttributes());
			}

			propertiesViewer.setInput(lines);

			// set the 'checked' states of the attributes
			for(Attribute att : lines) {
				// the attribute has been shown before -> reuse last setting
				if(!elementsToExclude.contains(att)) {
					propertiesViewer.setChecked(att, true);
					// the attribute has not been shown before -> calculate the setting by the value
				} else {
					//	attributesToInclude.put(att, !(att.getValue() == null)); TODO
					//	propertiesViewer.setChecked(att, !(att.getValue() == null)); TODO
				}
			}

			//			if(data.getReferenceObject() != null) {
			//				pamtram.metamodel.Reference ref = data.getReferenceObject();
			//				// jump to the referenced element only if it is a non-containment reference
			//				// and if the user did not click on the check-box besides the element
			//				if(ref instanceof NonContainmentReference && e.detail != 32) {
			//					
			//					TreeItem referencedItem = treeItems.get(data.getClassObject());
			//					if(referencedItem == null) {
			//						setErrorMessage("Referenced Item is null!");
			//					} else {
			//						tree.setSelection(referencedItem);
			//					}
			//				}
			//			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
	}

	private Composite container;
	private ContainerCheckedTreeViewer viewer;
	private CheckboxTableViewer propertiesViewer;
	private HashMap<pamtram.metamodel.Class, TreeItem> treeItems = 
			new HashMap<pamtram.metamodel.Class, TreeItem>();
	private WizardData wizardData;
	private ArrayList<MetaModelElement> elementsToExclude = 
			new ArrayList<MetaModelElement>();

	/**
	 * This is the one adapter factory used for providing views of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ComposedAdapterFactory adapterFactory;

	public PreviewPage(WizardData wizardData) {
		super("Preview");
		setTitle("Preview");
		setDescription("Preview of the section(s)...\n"
				+ "Check/Uncheck the attributes to include/exclude them from the section.");

		this.wizardData = wizardData;

		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new MetamodelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	/* try to generate the section by launching the eol transformation;
	 * if the transformation has not been successful, generate an error message;
	 * if the transformation has been successful, populate the tree viewer
	 */
	@Override
	public void setVisible(boolean visible) {
		if(visible) {
			this.setPageComplete(false);

			try {
				// create the metamodel section
				createMetaModelSection(
						wizardData.geteObject(), 
						wizardData.getePackage(), 
						wizardData.getSectionType()
						);
				this.setPageComplete(true);
			} catch (Exception e) {
				this.setErrorMessage(e.getLocalizedMessage());
			}	
			getWizard().getContainer().updateButtons();

			if(wizardData.getCreatedEObjects() != null) {				
				viewer.setInput(
						//						wizardData.getCreatedEObjects());
						//ClassTreeItem.createClassTreeItems(wizardData.getCreatedEObjects()));
						wizardData.getCreatedEObjects().toArray());
				// expand the tree so that the tree item map can be generated
				viewer.expandAll();
				// create a map of the items in the tree that is later used for jumping to these items
				/*for(TreeItem item : viewer.getTree().getItems()) {
					populateTreeItemMap(item);					
				}*/
				for (pamtram.metamodel.Class clazz : wizardData.getCreatedEObjects()) {
					viewer.setSubtreeChecked(clazz, true);
				}
				// collapse the tree (NOTE: 'collapseAll()' cannot be used as this disposes the tree items)  
				viewer.setExpandedTreePaths(new TreePath[]{});
				// only expand the root element and its direct children
				viewer.expandToLevel(2);						
			}
		}

		super.setVisible(visible);
	}

	/* create the metamodel section and store it in the PAMTraM instance
	 */
	private void createMetaModelSection(EObject eObject, EPackage ePackage,
			SectionType sectionType) {

		PAMTraM pamtram = wizardData.getPamtram();

		MetaModelSectionGenerator generator = new MetaModelSectionGenerator(pamtram, eObject, sectionType);
		wizardData.setGenerator(generator);

		LinkedList<pamtram.metamodel.Class<?, ?, ?>> created = generator.generate();

		wizardData.setCreatedEObjects(created);

	}

	/* recursively creates a hashmap HashCode(eObject) -> TreeItem;
	 * the hashmap can later be used to get the corresponding TreeItem for an eObject;
	 * note that only the ONE! TreeItem belonging to an eObject is included in the 
	 * hashmap that points to its actual place in the model hierarchie (non-containment
	 * references are not treated)
	 */
	/*private void populateTreeItemMap(TreeItem obj) {

		if(obj.getData() == null) {
			return;
		}

		ClassTreeItem classTreeItem = (ClassTreeItem) obj.getData(); 

		// add the item to the hashmap if necessary
		if(classTreeItem.getReferenceObject() == null || 
				classTreeItem.getReferenceObject() instanceof ContainmentReference) {
			treeItems.put(classTreeItem.getClassObject(), obj);
		}

		// iterate further
		for(TreeItem child : obj.getItems()) {
			populateTreeItemMap(child);
		}
	}
	 */
	@Override
	public void createControl(Composite parent) {

		GridLayout gl;
		GridData gd;

		// container to host the file selector
		container = new Composite(parent, SWT.NONE);

		// define a grid layout
		gl = new GridLayout(2, false);
		container.setLayout(gl);

		// the viewer field is an already configured TreeViewer
		viewer = new ContainerCheckedTreeViewer(container, SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {
			/* handle the fact that an array of the created sections 
			 * will be set as input
			 */
			@Override
			public Object[] getElements(Object object) {
				if(object instanceof Object[]) {
					return (Object[]) object;
				} else {
					return super.getElements(object);
				}
			}
			@Override
			public Object[] getChildren(Object object) {
				if(object instanceof pamtram.metamodel.Class) {
					return ((pamtram.metamodel.Class) object).getReferences().toArray();
				} else {
					return super.getChildren(object);
				}
			}
			@Override
			public boolean hasChildren(Object object) {
				if(object instanceof pamtram.metamodel.Class) {
					return !((pamtram.metamodel.Class) object).getReferences().isEmpty();
				} else {
					return super.hasChildren(object);
				}
			}
		});
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		//viewer.setContentProvider(new ResultPageTreeViewerContentProvider());
		//viewer.setLabelProvider(new ResultPageTreeViewerLabelProvider(wizardData.getBundle()));

		viewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			// update the value in the hashmap
			public void checkStateChanged(CheckStateChangedEvent event) {
				if(event.getElement() instanceof MetaModelElement) {
					MetaModelElement element = 
							(MetaModelElement) event.getElement();
					if(event.getChecked()) {
						if(elementsToExclude.contains(element)) {
							elementsToExclude.remove(element);
						}
					} else {
						if(!elementsToExclude.contains(element)) {
							elementsToExclude.add(element);
						}
					}
				}
			}
		});

		// the tree that the viewer operates on
		final Tree tree = (Tree) viewer.getControl();

		// add a selection listener that - if a non-containment reference is selected
		// jumps to the referenced item in the tree
		tree.addSelectionListener(new ResultPageTreeViewerSelectionListener(tree));

		// define layout for the tree viewer
		gd = new GridData(GridData.FILL, GridData.FILL, true, true);
		gd.widthHint = 350;
		gd.heightHint = 400;
		tree.setLayoutData(gd);

		// create the properties viewer
		propertiesViewer = CheckboxTableViewer.newCheckList(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		createColumns(parent, propertiesViewer);
		// the table that the viewer operates on
		final Table table = propertiesViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// use a simple array content provider to dipslay the array of attribute and their values
		propertiesViewer.setContentProvider(new ResultPageTableViewerContentProvider());
		propertiesViewer.setLabelProvider(new ResultPageTableViewerLabelProvider());
		propertiesViewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			// update the value in the hashmap
			public void checkStateChanged(CheckStateChangedEvent event) {
				Attribute att = (Attribute) event.getElement();
				if(event.getChecked()) {
					if(elementsToExclude.contains(att)) {
						elementsToExclude.remove(att);
					}
				} else {
					if(!elementsToExclude.contains(att)) {
						elementsToExclude.add(att);
					}
				}
			}
		});

		// define layout for the table viewer
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

		// fill the wizard page
		setControl(container);
		setPageComplete(true);
	}	

	// create the columns for the table
	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "Property", "Value"};
		int[] bounds = { 100, 150};

		// first column is for the property name
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object[] line = (Object[]) element;
				return ((pamtram.metamodel.Attribute) line[0]).getName();
			}
		});

		// second column is for the property value
		col = createTableViewerColumn(titles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object[] line = (Object[]) element;
				// return ((pamtram.metamodel.Attribute) line[0]).getValue(); TODO
				return ""; //TODO
			}
		});
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(propertiesViewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	public ArrayList<MetaModelElement> getElementsToExclude() {
		return this.elementsToExclude;
	}
}
