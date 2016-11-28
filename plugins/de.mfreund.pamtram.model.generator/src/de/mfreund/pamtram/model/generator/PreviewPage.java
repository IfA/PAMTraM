package de.mfreund.pamtram.model.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ContentViewer;
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
import org.eclipse.ui.views.properties.PropertyEditingSupport;

import de.mfreund.pamtram.model.generator.provider.ResultPageTableViewerLabelProvider;
import de.mfreund.pamtram.util.NullComparator;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.providers.EObjectTreeContentProvider;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import de.tud.et.ifa.agtele.ui.widgets.EnhancedContainerCheckedTreeViewer;
import pamtram.PAMTraM;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.Class;
import pamtram.metamodel.MetaModelElement;
import pamtram.metamodel.Reference;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.ValueConstraint;
import pamtram.metamodel.provider.MetamodelItemProviderAdapterFactory;

/**
 * This {@link WizardPage} will display a preview of a generated source or
 * target {@link Section} that will get inserted into a pamtram model.
 *
 * @author mfreund
 */
public class PreviewPage extends WizardPage {

	/**
	 * The {@link WizardData} that stores all relevant information gathered in
	 * the course of the wizard.
	 */
	protected WizardData wizardData;

	/**
	 * The {@link ContainerCheckedTreeViewer} that will display the preview of
	 * the generated section in a tree view.
	 */
	protected ContainerCheckedTreeViewer viewer;

	/**
	 * The {@link CheckboxTableViewer} that will display the preview of the
	 * attributes of the element currently selected in the {@link #viewer}.
	 */
	protected CheckboxTableViewer propertiesViewer;

	/**
	 * This keeps track of all {@link MetaModelElement MetaModelElements}
	 * displayed in the {@link #viewer}.
	 */
	protected Set<MetaModelElement<?, ?, ?, ?>> elements;

	/**
	 * This keeps track of those {@link Attribute Attributes} that have been
	 * unchecked by the user in the {@link #propertiesViewer} and that thus will
	 * not be included in the section that will finally be added to the pamtram
	 * model.
	 */
	protected Set<MetaModelElement<?, ?, ?, ?>> attributesToExclude = new HashSet<>();

	/**
	 * This is the one adapter factory used for providing views of the model.
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This creates an instance.
	 *
	 * @param wizardData
	 *            The {@link WizardData} that stores all relevant information
	 *            gathered in the course of the wizard.
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

			if (this.wizardData.getCreatedSections() != null) {
				this.viewer.setInput(this.wizardData.getCreatedSections().toArray());

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

		this.viewer.addSelectionChangedListener(event -> {

			if (event.getSelection() instanceof IStructuredSelection) {

				IStructuredSelection selection = (IStructuredSelection) event.getSelection();

				// Create a context menu
				//
				MenuManager menuMgr = new MenuManager();
				Menu menu = menuMgr.createContextMenu(PreviewPage.this.viewer.getControl());
				this.viewer.getControl().setMenu(menu);

				// Add an action that allows merging the selected elements
				//
				menuMgr.add(new MergeAction("Merge selected Elements", selection,
						Arrays.asList(this.viewer, this.propertiesViewer)));
			}

		});

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
		valueColumn.setEditingSupport(new PropertyEditingSupport(this.propertiesViewer,
				new AdapterFactoryContentProvider(this.adapterFactory), "value"));

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
	 * Create the {@link Section Section(s)} with the help of a
	 * {@link MetaModelSectionGenerator} and store them in the
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
	 * This creates a {@link TableViewerColumn} in the
	 * {@link #propertiesViewer}.
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
	 * This returns all {@link MetaModelElement MetaModelElements} that shall
	 * not be included in the generated sections because they have been
	 * unchecked by the user in the {@link #viewer} or in the
	 * {@link #propertiesViewer}.
	 *
	 * @return The {@link MetaModelElement MetaModelElements} to exclude from
	 *         the generated {@link Section Section(s)}.
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
	 * An {@link Action} that can be used two {@link MetaModelElement
	 * MetaModelElements} in a {@link PAMTraM} model.
	 *
	 * @author mfreund
	 */
	private class MergeAction extends Action {

		/**
		 * The list of {@link Class elements} selected by the user to be merged.
		 */
		protected List<pamtram.metamodel.Class<?, ?, ?, ?>> selectedElements = new ArrayList<>();

		/**
		 * The list of {@link ContentViewer ContentViewers} to be refreshed
		 * after the merge.
		 */
		protected List<ContentViewer> viewersToUpdate;

		/**
		 * This creates an instance.
		 *
		 * @param text
		 *            The String used as text for the action.
		 * @param selection
		 *            The {@link IStructuredSelection selected elements} to be
		 *            merged.
		 * @param viewersToUpdate
		 *            The list of {@link ContentViewer ContentViewers} to be
		 *            refreshed after the merge.
		 */
		public MergeAction(String text, IStructuredSelection selection, List<ContentViewer> viewersToUpdate) {

			super(text);

			this.viewersToUpdate = viewersToUpdate;

			// This action is only enabled if more than one elements are
			// selected ...
			//
			boolean enabled = selection.size() > 1;

			// And if all selected elements represent the same EClass
			//
			this.selectedElements = Stream.of(selection.toArray())
					.filter(e -> e instanceof pamtram.metamodel.Class<?, ?, ?, ?>)
					.map(e -> (pamtram.metamodel.Class<?, ?, ?, ?>) e).collect(Collectors.toList());
			Set<EClass> eClasses = this.selectedElements.parallelStream()
					.map(pamtram.metamodel.Class<?, ?, ?, ?>::getEClass).collect(Collectors.toSet());

			enabled = enabled && eClasses.size() == 1;

			this.setEnabled(enabled);
		}

		@Override
		public void run() {

			// Merge the elements
			//
			boolean result = false;

			pamtram.metamodel.Class<?, ?, ?, ?> class1 = this.selectedElements.get(0);

			for (Class<?, ?, ?, ?> class2 : this.selectedElements) {
				if (class1.equals(class2)) {
					continue;
				}

				if (class1 instanceof SourceSectionClass && class2 instanceof SourceSectionClass) {

					result = this.merge((SourceSectionClass) class1, (SourceSectionClass) class2);
				} else if (class1 instanceof TargetSectionClass && class2 instanceof TargetSectionClass) {

					result = this.merge((TargetSectionClass) class1, (TargetSectionClass) class2);
				}

				// If the merge was successful, delete the merged element and
				// update/refresh the viewers
				//
				if (result) {

					EcoreUtil.delete(class2);

					this.viewersToUpdate.stream().forEach(v -> {

						if (v.getInput() instanceof Object[]) {
							List<Object> input = new ArrayList<>(Arrays.asList((Object[]) v.getInput()));
							input.remove(class2);
							v.setInput(input);
						} else if (v.getInput() instanceof Collection<?>) {
							List<Object> input = new ArrayList<>((Collection<?>) v.getInput());
							input.remove(class2);
							v.setInput(input);
						}

						v.refresh();
					});

				} else {
					break;
				}
			}

			if (!result) {

				MessageDialog.openError(UIHelper.getShell(), "Error", "Error while merging the selected elements!");
			}

		}

		private <S extends Section<S, C, R, A>, C extends pamtram.metamodel.Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> boolean merge(
				C left, C right) {

			for (A rightAttribute : right.getAttributes()) {

				Optional<A> leftAttribute = left.getAttributes().parallelStream()
						.filter(a -> a.getName().equals(rightAttribute.getName())).findAny();

				// Simply add the attribute
				//
				if (!leftAttribute.isPresent()) {
					left.getAttributes().add(rightAttribute);
					continue;
				}

				// Merge the attributes
				//
				if (leftAttribute.get() instanceof SourceSectionAttribute) {

					List<ValueConstraint> leftConstraints = ((SourceSectionAttribute) leftAttribute.get())
							.getValueConstraint();
					List<ValueConstraint> rightConstraints = ((SourceSectionAttribute) rightAttribute)
							.getValueConstraint();

					if (leftConstraints.isEmpty() && rightConstraints.isEmpty()) {
						// nothing to be done
					} else if (!leftConstraints.isEmpty() || !rightConstraints.isEmpty()
							|| leftConstraints.size() != rightConstraints.size()) {
						leftConstraints.clear();
					} else {
						for (int i = 0; i < leftConstraints.size(); i++) {
							System.out.println(leftConstraints.get(i).equals(rightConstraints.get(i)));
						}
					}
				} else if (leftAttribute.get() instanceof TargetSectionAttribute) {

					String leftValue = ((TargetSectionAttribute) leftAttribute.get()).getValue();
					String rightValue = ((TargetSectionAttribute) rightAttribute).getValue();

					if (!NullComparator.compare(leftValue, rightValue)) {
						((TargetSectionAttribute) leftAttribute.get()).setValue(null);
					}

				} else {
					return false;
				}
			}

			return true;
		}

	}

	/**
	 * A {@link SelectionListener2 SelectionListener} that will update the
	 * {@link PreviewPage#propertiesViewer} based on the selection in the
	 * {@link PreviewPage#viewer}.
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
