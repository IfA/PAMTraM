package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

import de.mfreund.pamtram.model.generator.provider.ResultPageTableViewerLabelProvider;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.providers.EObjectTreeContentProvider;
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
	protected List<MetaModelElement<?, ?, ?, ?>> elementsToExclude = new ArrayList<>();

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

		if (visible && this.wizardData.getCreatedSections() == null) {

			// Create the sections
			//
			try {
				this.createMetaModelSections();

			} catch (Exception e) {
				this.setErrorMessage(e.getLocalizedMessage());
				this.wizardData.setCreatedSections(new ArrayList<>());
			}

			if(this.wizardData.getCreatedSections() != null) {
				this.viewer.setInput(this.wizardData.getCreatedSections().toArray());
				// expand the tree so that the tree item map can be generated
				this.viewer.expandAll();
				for (Section<?, ?, ?, ?> clazz : this.wizardData.getCreatedSections()) {
					this.viewer.setSubtreeChecked(clazz, true);
				}
				// collapse the tree (NOTE: 'collapseAll()' cannot be used as this disposes the tree items)
				this.viewer.setExpandedTreePaths(new TreePath[]{});
				// only expand the root element and its direct children
				this.viewer.expandToLevel(2);
			}

			this.getWizard().getContainer().updateButtons();
		}

		super.setVisible(visible);
	}

	@Override
	public void createControl(Composite parent) {
	
		// container to host the file selector
		Composite container = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(container);
	
		// the viewer field is an already configured TreeViewer
		this.viewer = new ContainerCheckedTreeViewer(container, SWT.H_SCROLL | SWT.V_SCROLL);
	
		this.viewer.setContentProvider(new EObjectTreeContentProvider());
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
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(350, 400).applyTo(tree);
	
		// add a selection listener that - if a non-containment reference is selected
		// jumps to the referenced item in the tree
		tree.addSelectionListener(new ResultPageTreeViewerSelectionListener());
	
		// create the properties viewer
		this.propertiesViewer = CheckboxTableViewer.newCheckList(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		this.createTableViewerColumn("Property", 100);
		this.createTableViewerColumn("Value", 150);
	
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

	/**
	 * Create the {@link Section Section(s)} with the help of a {@link MetaModelSectionGenerator} and store them in the
	 * {@link #wizardData}.
	 *
	 */
	private void createMetaModelSections() {

		MetaModelSectionGenerator generator = new MetaModelSectionGenerator(this.wizardData.getPamtram(),
				this.wizardData.getSourceElements(), this.wizardData.getSectionType(),
				this.wizardData.isIncludeCrossReferences());

		this.wizardData.setGenerator(generator);

		List<Section<?, ?, ?, ?>> created = generator.generate();

		this.wizardData.setCreatedSections(created);

	}

	/**
	 * This creates a {@link TableViewerColumn} in the {@link #propertiesViewer}.
	 *
	 * @param title
	 *            The title of the column.
	 * @param width
	 *            The width of the column
	 * @return The created {@link TableViewerColumn}.
	 */
	private TableViewerColumn createTableViewerColumn(String title, int width) {

		final TableViewerColumn viewerColumn = new TableViewerColumn(this.propertiesViewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(width);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	/**
	 * This is the getter for the {@link #elementsToExclude}.
	 *
	 * @return the {@link #elementsToExclude}.
	 */
	public List<MetaModelElement<?, ?, ?, ?>> getElementsToExclude() {
		return this.elementsToExclude;
	}

	@Override
	public boolean isPageComplete() {

		// This can finish if at least one section has been created and selected by the user
		//
		return this.wizardData.getCreatedSections() != null && !this.wizardData.getCreatedSections().isEmpty()
				&& this.viewer.getCheckedElements().length > 0;
	}

	/**
	 * A {@link SelectionListener2 SelectionListener} that will update the {@link PreviewPage#propertiesViewer} based on
	 * the selection in the {@link PreviewPage#viewer}.
	 *
	 * @author mfreund
	 *
	 */
	private final class ResultPageTreeViewerSelectionListener implements SelectionListener2 {

		@Override
		public void widgetSelected(SelectionEvent e) {

			List<Attribute<?, ?, ?, ?>> lines = new ArrayList<>();

			if (e.item.getData() instanceof pamtram.metamodel.Class) {

				// populate the attribute view
				lines.addAll(((pamtram.metamodel.Class<?, ?, ?, ?>) e.item.getData()).getAttributes());
			}

			PreviewPage.this.propertiesViewer.setInput(lines);

			// set the 'checked' states of the attributes
			//
			lines.stream().forEach(att -> {
				if(!PreviewPage.this.elementsToExclude.contains(att)) {
					PreviewPage.this.propertiesViewer.setChecked(att, true);
				}
			});

			PreviewPage.this.getContainer().updateButtons();
		}
	}
}