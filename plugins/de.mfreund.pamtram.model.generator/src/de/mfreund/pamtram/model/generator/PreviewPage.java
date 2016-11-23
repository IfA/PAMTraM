package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

import de.mfreund.pamtram.model.generator.provider.ResultPageTableViewerLabelProvider;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import pamtram.PAMTraM;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Section;
import pamtram.metamodel.provider.MetamodelItemProviderAdapterFactory;

/**
 * This {@link WizardPage} will display a preview of a generated source or target {@link Section} that
 * will get inserted into a pamtram model.
 *
 * @author mfreund
 */
public class PreviewPage extends WizardPage {

	/**
	 * The {@link WizardData} that stores all relevant information gathered in the course of the wizard.
	 */
	protected WizardData wizardData;

	/**
	 * The {@link ContainerCheckedTreeViewer} that will display the preview of the generated section
	 * in a tree view.
	 */
	protected ContainerCheckedTreeViewer viewer;

	/**
	 * The {@link CheckboxTableViewer} that will display the preview of the attributes of the element
	 * currently selected in the {@link #viewer}.
	 */
	protected CheckboxTableViewer propertiesViewer;

	/**
	 * This keeps track of those {@link MetaModelElement MetaModelElements} that have been unchecked by
	 * the user (either in the {@link #viewer} or in the {@link #propertiesViewer} and that thus will not be
	 * included in the section that will finally be added to the pamtram model.
	 */
	protected ArrayList<MetaModelElement<?, ?, ?, ?>> elementsToExclude = new ArrayList<>();

	/**
	 * This is the one adapter factory used for providing views of the model.
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This creates an instance.
	 *
	 * @param wizardData The {@link WizardData} that stores all relevant information gathered in the course of the wizard.
	 */
	public PreviewPage(WizardData wizardData) {
		super("Preview");
		this.setTitle("Preview");
		this.setDescription("Preview of the section(s)...\n"
				+ "Check/Uncheck the attributes to include/exclude them from the section.");

		this.wizardData = wizardData;

		// Create an adapter factory that yields item providers.
		//
		this.adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		this.adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new MetamodelItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	@Override
	public void setVisible(boolean visible) {
		if(visible) {
			this.setPageComplete(false);

			try {
				// create the metamodel section
				this.createMetaModelSection(
						this.wizardData.getSourceElements(),
						this.wizardData.getEPackage(),
						this.wizardData.getSectionType()
						);
				this.setPageComplete(true);
			} catch (Exception e) {
				this.setErrorMessage(e.getLocalizedMessage());
			}
			this.getWizard().getContainer().updateButtons();

			if(this.wizardData.getCreatedSections() != null) {
				this.viewer.setInput(this.wizardData.getCreatedSections().toArray());
				// expand the tree so that the tree item map can be generated
				this.viewer.expandAll();
				for (pamtram.metamodel.Class<?, ?, ?, ?> clazz : this.wizardData.getCreatedSections()) {
					this.viewer.setSubtreeChecked(clazz, true);
				}
				// collapse the tree (NOTE: 'collapseAll()' cannot be used as this disposes the tree items)
				this.viewer.setExpandedTreePaths(new TreePath[]{});
				// only expand the root element and its direct children
				this.viewer.expandToLevel(2);
			}
		}

		super.setVisible(visible);
	}

	/* create the metamodel section and store it in the PAMTraM instance
	 */
	private void createMetaModelSection(List<EObject> eObjects, EPackage ePackage,
			SectionType sectionType) {

		PAMTraM pamtram = this.wizardData.getPamtram();

		MetaModelSectionGenerator generator = new MetaModelSectionGenerator(pamtram, eObjects, sectionType,
				this.wizardData.isIncludeCrossReferences());
		this.wizardData.setGenerator(generator);

		List<Section<?, ?, ?, ?>> created = generator.generate();

		this.wizardData.setCreatedSections(created);

	}

	@Override
	public void createControl(Composite parent) {

		GridLayout gl;
		GridData gd;

		// container to host the file selector
		Composite container = new Composite(parent, SWT.NONE);

		// define a grid layout
		gl = new GridLayout(2, false);
		container.setLayout(gl);

		// the viewer field is an already configured TreeViewer
		this.viewer = new ContainerCheckedTreeViewer(container, SWT.H_SCROLL | SWT.V_SCROLL);
		this.viewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory) {
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
					return ((pamtram.metamodel.Class<?, ?, ?, ?>) object).getReferences().toArray();
				} else {
					return super.getChildren(object);
				}
			}
			@Override
			public boolean hasChildren(Object object) {
				if(object instanceof pamtram.metamodel.Class) {
					return !((pamtram.metamodel.Class<?, ?, ?, ?>) object).getReferences().isEmpty();
				} else {
					return super.hasChildren(object);
				}
			}
		});
		this.viewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

		this.viewer.addCheckStateListener(event -> {
			if(event.getElement() instanceof MetaModelElement) {
				MetaModelElement<?, ?, ?, ?> element =
						(MetaModelElement<?, ?, ?, ?>) event.getElement();
				if(event.getChecked()) {
					if(PreviewPage.this.elementsToExclude.contains(element)) {
						PreviewPage.this.elementsToExclude.remove(element);
					}
				} else {
					if(!PreviewPage.this.elementsToExclude.contains(element)) {
						PreviewPage.this.elementsToExclude.add(element);
					}
				}
			}
		});

		// the tree that the viewer operates on
		final Tree tree = (Tree) this.viewer.getControl();

		// add a selection listener that - if a non-containment reference is selected
		// jumps to the referenced item in the tree
		tree.addSelectionListener(new ResultPageTreeViewerSelectionListener());

		// define layout for the tree viewer
		gd = new GridData(GridData.FILL, GridData.FILL, true, true);
		gd.widthHint = 350;
		gd.heightHint = 400;
		tree.setLayoutData(gd);

		// create the properties viewer
		this.propertiesViewer = CheckboxTableViewer.newCheckList(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		this.createColumns(parent, this.propertiesViewer);
		// the table that the viewer operates on
		final Table table = this.propertiesViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// use a simple array content provider to dipslay the array of attribute and their values
		this.propertiesViewer
				.setContentProvider((IStructuredContentProvider) inputElement -> inputElement instanceof List<?>
						? ((List<?>) inputElement).toArray() : new Object[0]);
		this.propertiesViewer.setLabelProvider(new ResultPageTableViewerLabelProvider());
		this.propertiesViewer.addCheckStateListener(event -> {
			Attribute<?, ?, ?, ?> att = (Attribute<?, ?, ?, ?>) event.getElement();
			if(event.getChecked()) {
				if(PreviewPage.this.elementsToExclude.contains(att)) {
					PreviewPage.this.elementsToExclude.remove(att);
				}
			} else {
				if(!PreviewPage.this.elementsToExclude.contains(att)) {
					PreviewPage.this.elementsToExclude.add(att);
				}
			}
		});

		// define layout for the table viewer
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

		// fill the wizard page
		this.setControl(container);
		this.setPageComplete(true);
	}

	// create the columns for the table
	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "Property", "Value"};
		int[] bounds = { 100, 150};

		// first column is for the property name
		TableViewerColumn col = this.createTableViewerColumn(titles[0], bounds[0]);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object[] line = (Object[]) element;
				return ((pamtram.metamodel.Attribute<?, ?, ?, ?>) line[0]).getName();
			}
		});

		// second column is for the property value
		col = this.createTableViewerColumn(titles[1], bounds[1]);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				//				Object[] line = (Object[]) element;
				// return ((pamtram.metamodel.Attribute) line[0]).getValue(); TODO
				return ""; //TODO
			}
		});
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(this.propertiesViewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	public List<MetaModelElement<?, ?, ?, ?>> getElementsToExclude() {
		return this.elementsToExclude;
	}

	/**
	 * A {@link SelectionListener2 SelectionListener} that will update the {@link PreviewPage#propertiesViewer}
	 * based on the selection in the {@link PreviewPage#viewer}.
	 * @author Matthias
	 *
	 */
	private final class ResultPageTreeViewerSelectionListener implements SelectionListener2 {

		@Override
		public void widgetSelected(SelectionEvent e) {

			TreeItem item = (TreeItem) e.item;

			List<Attribute<?, ?, ?, ?>> lines = new ArrayList<>();

			if(item.getData() instanceof pamtram.metamodel.Class) {

				// populate the attribute view
				lines.addAll(((pamtram.metamodel.Class<?, ?, ?, ?>)item.getData()).getAttributes());
			}

			PreviewPage.this.propertiesViewer.setInput(lines);

			// set the 'checked' states of the attributes
			for(Attribute<?, ?, ?, ?> att : lines) {
				// the attribute has been shown before -> reuse last setting
				if(!PreviewPage.this.elementsToExclude.contains(att)) {
					PreviewPage.this.propertiesViewer.setChecked(att, true);
					// the attribute has not been shown before -> calculate the setting by the value
				} else {
					//	attributesToInclude.put(att, !(att.getValue() == null)); TODO
					//	propertiesViewer.setChecked(att, !(att.getValue() == null)); TODO
				}
			}

		}
	}
}
