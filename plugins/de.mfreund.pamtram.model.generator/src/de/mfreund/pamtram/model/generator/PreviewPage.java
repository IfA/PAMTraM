package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertyEditingSupport;

import de.mfreund.pamtram.model.generator.provider.ResultPageTableViewerLabelProvider;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.providers.EObjectTreeContentProvider;
import de.tud.et.ifa.agtele.ui.widgets.EnhancedContainerCheckedTreeViewer;
import pamtram.actions.MetaModelElementMergeAction;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.generic.Attribute;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.generic.Section;
import pamtram.structure.provider.StructureItemProviderAdapterFactory;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * This {@link WizardPage} will display a preview of a generated source or target {@link Section} that will get inserted
 * into a pamtram model.
 *
 * @author mfreund
 */
public class PreviewPage extends WizardPage {

	/**
	 * The {@link WizardData} that stores all relevant information gathered in the course of the wizard.
	 */
	protected WizardData wizardData;

	/**
	 * The {@link ContainerCheckedTreeViewer} that will display the preview of the generated section in a tree view.
	 */
	protected ContainerCheckedTreeViewer viewer;

	/**
	 * The {@link CheckboxTableViewer} that will display the preview of the attributes of the element currently selected
	 * in the {@link #viewer}.
	 */
	protected CheckboxTableViewer propertiesViewer;

	/**
	 * This keeps track of all {@link MetaModelElement MetaModelElements} displayed in the {@link #viewer}.
	 */
	protected Set<MetaModelElement<?, ?, ?, ?>> elements;

	/**
	 * This keeps track of those {@link Attribute Attributes} that have been unchecked by the user in the
	 * {@link #propertiesViewer} and that thus will not be included in the section that will finally be added to the
	 * pamtram model.
	 */
	protected Set<MetaModelElement<?, ?, ?, ?>> attributesToExclude = new HashSet<>();

	/**
	 * This is the one adapter factory used for providing views of the model.
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * A {@link CommandStackListener} that refreshes the {@link #viewer} and the {@link #propertiesViewer} once a
	 * command is executed on the {@link CommandStack} associated with the {@link #wizardData} (via the incorporated
	 * {@link EditingDomain}).
	 */
	protected CommandStackListener refreshViewersListener = event -> {

		PreviewPage.this.viewer.refresh();
		PreviewPage.this.propertiesViewer.refresh();

	};

	/**
	 * An {@link ISelectionChangedListener} that creates a context menu for the {@link #viewer} based on the current
	 * selection.
	 */
	protected ISelectionChangedListener createContextMenuListener = event -> {

		if (event.getSelection() instanceof IStructuredSelection) {

			IStructuredSelection selection = (IStructuredSelection) event.getSelection();

			// Create a context menu
			//
			MenuManager menuMgr = new MenuManager();
			Menu menu = menuMgr.createContextMenu(PreviewPage.this.viewer.getControl());
			this.viewer.getControl().setMenu(menu);

			// Add an action that allows merging the selected elements
			//
			if (this.wizardData.getSectionType().equals(SectionType.SOURCE)) {
				menuMgr.add(
						new MetaModelElementMergeAction<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>(
								this.wizardData.getEditingDomain(), selection) {

							@Override
							protected Set<EObject> getElementsOfInterest() {

								return new HashSet<>(PreviewPage.this.wizardData.getCreatedSections());
							}
						});
			} else if (this.wizardData.getSectionType().equals(SectionType.TARGET)) {
				menuMgr.add(
						new MetaModelElementMergeAction<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>(
								this.wizardData.getEditingDomain(), selection) {

							@Override
							protected Set<EObject> getElementsOfInterest() {

								return new HashSet<>(PreviewPage.this.wizardData.getCreatedSections());
							}
						});
			}
		}

	};

	/**
	 * This creates an instance.
	 *
	 * @param wizardData
	 *            The {@link WizardData} that stores all relevant information gathered in the course of the wizard.
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
		this.adapterFactory.addAdapterFactory(new StructureItemProviderAdapterFactory());
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

			if (this.wizardData.getCreatedSections() != null) {
				// use the temporary SectionModel that contains all generated sections as input for the viewer as this
				// simplifies refreshing the viewer when some of the sections are deleted e.g. via a ClassMergeAction
				//
				this.viewer.setInput(this.wizardData.getCreatedSections().get(0).eContainer());

				// expand the tree so that the tree item map can be generated
				this.viewer.expandAll();
				for (Section<?, ?, ?, ?> clazz : this.wizardData.getCreatedSections()) {
					this.viewer.setSubtreeChecked(clazz, true);
				}

				this.elements = Arrays.asList(this.viewer.getCheckedElements()).parallelStream()
						.filter(e -> e instanceof MetaModelElement<?, ?, ?, ?>)
						.map(e -> (MetaModelElement<?, ?, ?, ?>) e).collect(Collectors.toSet());

				// collapse the tree (NOTE: 'collapseAll()' cannot be used as
				// this disposes the tree items)
				this.viewer.setExpandedTreePaths(new TreePath[] {});
				// only expand the root element and its direct children
				this.viewer.expandToLevel(2);
			}

			this.getWizard().getContainer().updateButtons();
		}

		// Update the listeners
		//
		if (visible) {
			this.wizardData.getEditingDomain().getCommandStack().addCommandStackListener(this.refreshViewersListener);
			this.viewer.addSelectionChangedListener(this.createContextMenuListener);
		} else {
			this.wizardData.getEditingDomain().getCommandStack()
					.removeCommandStackListener(this.refreshViewersListener);
			this.viewer.removeSelectionChangedListener(this.createContextMenuListener);
		}

		super.setVisible(visible);
	}

	@Override
	public void createControl(Composite parent) {

		// container to host the file selector
		Composite container = new Composite(parent, SWT.NONE);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(container);

		// the viewer field is an already configured TreeViewer
		this.viewer = new EnhancedContainerCheckedTreeViewer(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);

		this.viewer.setContentProvider(new EObjectTreeContentProvider() {

			@Override
			public Object[] getChildren(Object parentElement) {

				return Arrays.asList(super.getChildren(parentElement)).parallelStream()
						.filter(c -> !(c instanceof Attribute<?, ?, ?, ?>)).collect(Collectors.toList()).toArray();
			}

		});

		this.viewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

		// the tree that the viewer operates on
		final Tree tree = (Tree) this.viewer.getControl();
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(350, 400).applyTo(tree);

		// add a selection listener that - if a non-containment reference is
		// selected
		// jumps to the referenced item in the tree
		tree.addSelectionListener(new ResultPageTreeViewerSelectionListener());

		// create the properties viewer
		this.propertiesViewer = CheckboxTableViewer.newCheckList(container,
				SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		this.createTableViewerColumn("Property", 100);
		TableViewerColumn valueColumn = this.createTableViewerColumn("Value", 150);

		// Enable editing of attribute values
		//
		valueColumn.setEditingSupport(new PreviewPagePropertyEditingSupport(this.propertiesViewer,
				new AdapterFactoryContentProvider(this.adapterFactory)));

		// the table that the viewer operates on
		final Table table = this.propertiesViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		this.propertiesViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory) {

			@Override
			public Object[] getElements(Object object) {

				return Arrays.asList(super.getElements(object)).parallelStream()
						.filter(c -> c instanceof Attribute<?, ?, ?, ?>).collect(Collectors.toList()).toArray();
			}

		});

		this.propertiesViewer.setLabelProvider(new ResultPageTableViewerLabelProvider());
		this.propertiesViewer.addCheckStateListener(event -> {
			Attribute<?, ?, ?, ?> att = (Attribute<?, ?, ?, ?>) event.getElement();
			if (event.getChecked()) {
				if (PreviewPage.this.attributesToExclude.contains(att)) {
					PreviewPage.this.attributesToExclude.remove(att);
				}
			} else {
				if (!PreviewPage.this.attributesToExclude.contains(att)) {
					PreviewPage.this.attributesToExclude.add(att);
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
				this.wizardData.isIncludeContainedElements(), this.wizardData.isIncludeCrossReferences());

		this.wizardData.setGenerator(generator);

		List<Section<?, ?, ?, ?>> created = new ArrayList<>(generator.generate().getSections());

		this.wizardData.setCreatedSections(created);

	}

	/**
	 * This creates a {@link TableViewerColumn} in the {@link #propertiesViewer}.
	 *
	 * @param title
	 *            The title of the column.
	 * @param width
	 *            The width of the column
	 * @param propertyID
	 *            The id of the property to display.
	 * @return The created {@link TableViewerColumn}.
	 */
	private TableViewerColumn createTableViewerColumn(String title, int width) {

		final TableViewerColumn viewerColumn = new TableViewerColumn(this.propertiesViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(width);
		column.setResizable(true);
		column.setMoveable(true);

		return viewerColumn;
	}

	/**
	 * This returns all {@link MetaModelElement MetaModelElements} that shall not be included in the generated sections
	 * because they have been unchecked by the user in the {@link #viewer} or in the {@link #propertiesViewer}.
	 *
	 * @return The {@link MetaModelElement MetaModelElements} to exclude from the generated {@link Section Section(s)}.
	 */
	public Set<MetaModelElement<?, ?, ?, ?>> getElementsToExclude() {

		List<Object> checkedTreeElements = Arrays.asList(this.viewer.getCheckedElements());
		Set<MetaModelElement<?, ?, ?, ?>> treeElementsToExclued = this.elements.parallelStream()
				.filter(e -> !checkedTreeElements.contains(e)).collect(Collectors.toSet());

		return Stream.concat(treeElementsToExclued.parallelStream(), this.attributesToExclude.parallelStream())
				.collect(Collectors.toSet());
	}

	@Override
	public boolean isPageComplete() {

		// This can finish if at least one section has been created and selected
		// by the user
		//
		return this.wizardData.getCreatedSections() != null && !this.wizardData.getCreatedSections().isEmpty()
				&& this.viewer.getCheckedElements().length > 0;
	}

	/**
	 * A special {@link PropertyEditingSupport} that allows to edit the values of {@link SourceSectionAttribute
	 * SourceSectionAttributes} and {@link TargetSectionAttribute TargetSectionAttributes}.
	 * <p />
	 * As {@link TargetSectionAttribute TargetSectionAttributes} are not equipped with a <em>value</em> attribute, the
	 * <em>expression</em> of an associated {@link EqualityConstraint} is used as value instead.
	 *
	 * @author mfreund
	 */
	private class PreviewPagePropertyEditingSupport extends PropertyEditingSupport {

		/**
		 * This creates an instance.
		 *
		 * @param viewer
		 *            The {@link ColumnViewer} for that this editing support is defined.
		 * @param propertySourceProvider
		 *            The {@link IPropertySourceProvider} that is used to retrieve and set property values.
		 */
		private PreviewPagePropertyEditingSupport(ColumnViewer viewer, IPropertySourceProvider propertySourceProvider) {
			super(viewer, propertySourceProvider, "value");
		}

		@Override
		protected boolean canEdit(Object object) {

			return object instanceof SourceSectionAttribute
					&& ((SourceSectionAttribute) object).getValueConstraints().size() == 1
					&& ((SourceSectionAttribute) object).getValueConstraints().get(0) instanceof EqualityConstraint
					|| super.canEdit(object);
		}

		@Override
		protected org.eclipse.jface.viewers.CellEditor getCellEditor(Object object) {

			if (object instanceof SourceSectionAttribute
					&& ((SourceSectionAttribute) object).getValueConstraints().size() == 1
					&& ((SourceSectionAttribute) object).getValueConstraints().get(0) instanceof EqualityConstraint) {

				Optional<IPropertyDescriptor> expressionDescriptor = Arrays
						.asList(this.propertySourceProvider
								.getPropertySource(((SourceSectionAttribute) object).getValueConstraints().get(0))
								.getPropertyDescriptors())
						.stream().filter(d -> "expression".equals(d.getId())).findAny();

				return expressionDescriptor.isPresent()
						? expressionDescriptor.get().createPropertyEditor((Composite) this.getViewer().getControl())
						: super.getCellEditor(object);

			} else {

				return super.getCellEditor(object);
			}

		}

		@Override
		protected Object getValue(Object object) {

			if (object instanceof SourceSectionAttribute
					&& ((SourceSectionAttribute) object).getValueConstraints().size() == 1
					&& ((SourceSectionAttribute) object).getValueConstraints().get(0) instanceof EqualityConstraint) {

				return ((EqualityConstraint) ((SourceSectionAttribute) object).getValueConstraints().get(0))
						.getExpression();

			} else {
				return super.getValue(object);
			}
		}

		@Override
		protected void setValue(Object object, Object value) {

			if (object instanceof SourceSectionAttribute && value instanceof String
					&& ((SourceSectionAttribute) object).getValueConstraints().size() == 1
					&& ((SourceSectionAttribute) object).getValueConstraints().get(0) instanceof EqualityConstraint) {

				((EqualityConstraint) ((SourceSectionAttribute) object).getValueConstraints().get(0))
						.setExpression((String) value);

				// We need to refresh the viewer manually so that the displayed value will be updated
				PreviewPage.this.propertiesViewer.refresh();
			} else {
				super.setValue(object, value);
			}
		}
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

			if (e.item.getData() instanceof pamtram.structure.generic.Class) {

				// populate the attribute view
				lines.addAll(((pamtram.structure.generic.Class<?, ?, ?, ?>) e.item.getData()).getAttributes());
			}

			PreviewPage.this.propertiesViewer.setInput(e.item.getData());

			// set the 'checked' states of the attributes
			//
			lines.stream().forEach(att -> PreviewPage.this.propertiesViewer.setChecked(att,
					!PreviewPage.this.attributesToExclude.contains(att)));

			if (e.item.getData() instanceof EObject) {

				// PreviewPage.this.propertiesViewer.getTable()
				// .setEnabled(!PreviewPage.this.elementsToExclude.contains(e.item.getData())
				// && !EcoreUtil
				// .isAncestor(PreviewPage.this.elementsToExclude, (EObject)
				// e.item.getData()));
				PreviewPage.this.propertiesViewer.getTable()
						.setEnabled(PreviewPage.this.viewer.getChecked(e.item.getData()));
			}

			PreviewPage.this.getContainer().updateButtons();
		}
	}
}
