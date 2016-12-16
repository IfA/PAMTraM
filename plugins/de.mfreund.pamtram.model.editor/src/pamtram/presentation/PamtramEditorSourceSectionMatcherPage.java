package pamtram.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ide.ResourceUtil;

import de.mfreund.gentrans.transformation.BaseTransformationConfiguration;
import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.mfreund.gentrans.transformation.GenericTransformationRunnerFactory;
import de.tud.et.ifa.agtele.ui.interfaces.IPersistable;
import de.tud.et.ifa.agtele.ui.providers.EObjectTreeContentProvider;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup;
import pamtram.contentprovider.MappingContentProvider;
import pamtram.contentprovider.SourceSectionContentProvider;
import pamtram.listeners.SetViewerMouseListener;
import pamtram.listeners.SetViewerSelectionListener;
import pamtram.mapping.MappingType;
import pamtram.structure.SourceSectionClass;

/**
 * The page of the {@link PamtramEditor} that allows to check which source sections are matched for a given source
 * model..
 *
 * @author mfreund
 */
public class PamtramEditorSourceSectionMatcherPage extends SashForm implements IPersistable {

	/**
	 * This is the editor that this view is hosted in.
	 */
	protected PamtramEditor editor;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the group for the source tree viewer.
	 */
	protected Group sourceGroup;

	/**
	 * The {@link TreeViewerGroup} for the source sections.
	 */
	protected TreeViewerGroup sourceViewerGroup;

	/**
	 * This is the viewer for the source meta model sections.
	 */
	protected TreeViewer sourceViewer;

	/**
	 * This is the selection listener for the source tree.
	 */
	protected SelectionListener sourceTreeSelectionListener;

	/**
	 * This is the group for the mapping tree viewer.
	 */
	protected Group mappingGroup;

	/**
	 * The {@link TreeViewerGroup} for the mappings.
	 */
	protected TreeViewerGroup mappingViewerGroup;

	/**
	 * This is the the viewer for the mappings.
	 */
	protected TreeViewer mappingViewer;

	/**
	 * This is the selection listener for the mapping tree.
	 */
	protected SelectionListener mappingTreeSelectionListener;

	/**
	 * This is the group for the source model that shall be matched.
	 */
	protected Group sourceModelGroup;

	/**
	 * This is the combo that allos to choose the source model to be matched.
	 */
	protected Combo sourceModelCombo;

	/**
	 * This is the the viewer for the source model to be matched.
	 */
	protected TreeViewer sourceModelViewer;

	/**
	 * This is the current active project.
	 */
	protected IProject project;

	/**
	 * This is the list of matched sections that is determined when the user
	 * selects a source model.
	 */
	protected Map<SourceSectionClass, Set<EObject>> matchedSections;

	/**
	 * This creates an instance.
	 *
	 * @param parent
	 *            A widget which will be the parent of the new instance (cannot be null)
	 * @param style
	 *            The style of widget to construct
	 * @param adapterFactory
	 *            The one adapter factory used for providing views of the model.
	 * @param editor
	 *            The parent {@link PamtramEditor} that this page belongs to.
	 */
	public PamtramEditorSourceSectionMatcherPage(
			Composite parent,
			int style,
			ComposedAdapterFactory adapterFactory,
			PamtramEditor editor) {

		super(parent, style);

		this.adapterFactory = adapterFactory;
		this.editor = editor;

		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			this.setLayoutData(data);
		}

		this.createSourceViewer();
		this.createMappingViewer();
		this.createSourceModelViewer();
	}

	/**
	 * Create the viewer for the source sections.
	 */
	private void createSourceViewer() {

		// Create the viewer for the source sections.
		//
		this.sourceViewerGroup = new TreeViewerGroup(
				this, this.adapterFactory, this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Source Sections");
		this.sourceViewer = this.sourceViewerGroup.getViewer();
		this.sourceViewer.setContentProvider(new SourceSectionContentProvider(this.adapterFactory));
		this.sourceViewer.setInput(this.editor.pamtram);
		this.sourceTreeSelectionListener = new SetViewerSelectionListener(this.editor, this.sourceViewer);
		this.sourceViewer.getTree().addSelectionListener(this.sourceTreeSelectionListener);
		this.sourceViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.sourceViewer));

		new AdapterFactoryTreeEditor(this.sourceViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.sourceViewer);

	}

	/**
	 * Create the viewer for the mappings.
	 */
	private void createMappingViewer() {

		// Create the viewer for the source sections.
		//
		this.mappingViewerGroup = new TreeViewerGroup(
				this, this.adapterFactory, this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Mappings");
		this.mappingViewer = this.mappingViewerGroup.getViewer();

		this.mappingViewer.setContentProvider(new MappingContentProvider(this.adapterFactory));
		this.mappingViewer.setInput(this.editor.pamtram);
		this.mappingTreeSelectionListener = new SetViewerSelectionListener(this.editor, this.mappingViewer);
		this.mappingViewer.getTree().addSelectionListener(this.mappingTreeSelectionListener);
		this.mappingViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.mappingViewer));

		new AdapterFactoryTreeEditor(this.mappingViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.mappingViewer);

	}

	/**
	 * Create the viewer for the source model to be matched.
	 */
	private void createSourceModelViewer() {
		// Create a group for the source section tree viewer.
		this.sourceModelGroup = new Group(this, SWT.NONE);
		this.sourceModelGroup.setText("Model to be matched");
		this.sourceModelGroup.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		this.sourceModelGroup.setLayout(new GridLayout(1, true));

		// Create a drop-down list that allows to select the source model to be analysed.
		this.sourceModelCombo = new Combo(this.sourceModelGroup, SWT.DROP_DOWN | SWT.BORDER);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.grabExcessHorizontalSpace = true;
			this.sourceModelCombo.setLayoutData(gd);
		}
		// Create a modify listener that updates the source model based on the selection.
		this.sourceModelCombo.addModifyListener(e -> PamtramEditorSourceSectionMatcherPage.this.updateSourceModel());

		// Get the current project.
		this.project = ResourceUtil.getResource(this.editor.getEditorInput()).getProject();

		try {
			if(this.project.hasNature("de.mfreund.pamtram.pamtramNature")) {
				// populate the current source projects in the workspace to the list
				for(IResource res : this.project.getFolder("Source").members()) {
					if(res.getName().endsWith(".xml") || res.getName().endsWith(".xmi")) {
						this.sourceModelCombo.add(res.getName());
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Create the source tree viewer.
		Tree sourceModelTree = new Tree(this.sourceModelGroup, SWT.MULTI);
		this.sourceModelViewer = new TreeViewer(sourceModelTree);
		sourceModelTree.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		this.sourceModelViewer.setContentProvider(new EObjectTreeContentProvider());
		this.sourceModelViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));
		sourceModelTree.addSelectionListener(new SetViewerSelectionListener(this.editor, this.sourceModelViewer));
	}

	/**
	 * This updates the source model file shown in the source model
	 * tree based on the current selection in the source model combo.
	 *
	 * TODO There should be no direct dependency to the gentrans plug-in/the GenericTransformationRunner.
	 * This should be solved by an extension point.
	 */
	protected void updateSourceModel() {

		if(this.sourceModelCombo.getText().isEmpty()) {
			this.sourceModelViewer.setInput(null);
			return;
		}

		// the selected file
		String modelFile = this.project.getName() + IPath.SEPARATOR + "Source" + IPath.SEPARATOR + this.sourceModelCombo.getText();

		// if an xml source file has been selected,
		// add the file extension to registry
		if(modelFile.endsWith(".xml")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
			.put("xml", new GenericXMLResourceFactoryImpl());
		}

		// the selected resource as URI
		URI modelUri = URI.createPlatformResourceURI(modelFile, true);

		Resource modelResource = null;
		try {
			// load the source model
			modelResource = this.editor.getEditingDomain().getResourceSet().getResource(modelUri, true);
			modelResource.load(Collections.EMPTY_MAP);
		} catch(Exception e) {
			MessageDialog.openError(this.getShell(), "Error loading resource",
					e.getMessage());
			this.sourceModelViewer.setInput(null);
			return;
		}

		EList<EObject> contents = modelResource.getContents();

		/*
		 * If an xml source file has been selected,  we have to omit the 'document root' element and
		 * instead determine the actual contents. Passing the load option 'XMLResource.OPTION_SUPPRESS_DOCUMENT_ROOT'
		 * somehow does not seem to work.
		 */
		if(contents.get(0).eClass().getName().equals("DocumentRoot")) {
			contents = contents.get(0).eContents();
		}


		// set the contents of the resource as input for the source model viewer
		this.sourceModelViewer.setInput(contents);

		// the target file
		String targetBasePath = this.project.getName() + IPath.SEPARATOR + "Target";
		String defaultTargetModel = "temp.xmi";

		// Create a transformation runner and use it to get the matching source sections
		//
		BaseTransformationConfiguration baseConfig = new BaseTransformationConfiguration()
				.withDefaultTargetModel(defaultTargetModel);

		GenericTransformationRunner tr =
				GenericTransformationRunnerFactory.eINSTANCE.createInstanceFromSourceModels(
						new ArrayList<>(contents),
						this.editor.pamtram,
						targetBasePath,
						baseConfig);

		this.matchedSections = tr.matchSourceSections();

		if(this.matchedSections == null) {
			return;
		}

		// add a selection listener for the highlighting (overwrite the old one)
		this.sourceViewer.getTree().removeSelectionListener(this.sourceTreeSelectionListener);
		this.sourceTreeSelectionListener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				SourceSectionClass sourceSectionClass = null;

				// get the source section for which the matched elements in the source
				// model viewer shall be shown (depending on the users selection)
				//
				if(((TreeItem) e.item).getData() instanceof SourceSectionClass) {
					sourceSectionClass = (SourceSectionClass) ((TreeItem) e.item).getData();
					// do not select a mapping because multiple mappings could make use of
					// this source section
					PamtramEditorSourceSectionMatcherPage.this.mappingViewer.setSelection(new StructuredSelection());
				} else {
					PamtramEditorSourceSectionMatcherPage.this.sourceModelViewer.setSelection(new StructuredSelection());
				}

				if(sourceSectionClass != null) {
					// find the 'matched sections' for the selected source section
					for (SourceSectionClass c : PamtramEditorSourceSectionMatcherPage.this.matchedSections.keySet()) {
						if(EcoreUtil.equals(sourceSectionClass, c)) {
							// the matched elements that shall be highlighted
							Set<EObject> matchedEObjects = PamtramEditorSourceSectionMatcherPage.this.matchedSections.get(c);

							if(matchedEObjects == null) {
								continue;
							}

							PamtramEditorSourceSectionMatcherPage.this.sourceModelViewer.collapseAll();
							PamtramEditorSourceSectionMatcherPage.this.sourceModelViewer.setSelection(
									new StructuredSelection(matchedEObjects.toArray()),
									true
									);

							break;
						}
					}
				}

				PamtramEditorSourceSectionMatcherPage.this.editor.setCurrentViewer(PamtramEditorSourceSectionMatcherPage.this.sourceViewer);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};
		this.sourceViewer.getTree().addSelectionListener(this.sourceTreeSelectionListener);

		// add a selection listener for the highlighting (overwrite the old one)
		this.mappingViewer.getTree().removeSelectionListener(this.mappingTreeSelectionListener);
		this.mappingTreeSelectionListener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				SourceSectionClass sourceSectionClass = null;

				// get the source section for which the matched elements in the source
				// model viewer shall be shown (depending on the users selection)
				//
				if(((TreeItem) e.item).getData() instanceof MappingType) {
					sourceSectionClass = ((MappingType) ((TreeItem) e.item).getData()).getSourceSection();
					// select the source section for this mapping (that is used to find the matched elements
					PamtramEditorSourceSectionMatcherPage.this.sourceViewer.setSelection(new StructuredSelection(sourceSectionClass), true);
				} else {
					PamtramEditorSourceSectionMatcherPage.this.sourceModelViewer.setSelection(new StructuredSelection());
				}

				if(sourceSectionClass != null) {
					// find the 'matched sections' for the selected source section
					for (SourceSectionClass c : PamtramEditorSourceSectionMatcherPage.this.matchedSections.keySet()) {
						if(EcoreUtil.equals(sourceSectionClass, c)) {
							// the matched elements that shall be highlighted
							Set<EObject> matchedEObjects = PamtramEditorSourceSectionMatcherPage.this.matchedSections.get(c);

							if(matchedEObjects == null) {
								continue;
							}

							PamtramEditorSourceSectionMatcherPage.this.sourceModelViewer.collapseAll();
							PamtramEditorSourceSectionMatcherPage.this.sourceModelViewer.setSelection(
									new StructuredSelection(matchedEObjects.toArray()),
									true
									);

							break;
						}
					}
				}

				PamtramEditorSourceSectionMatcherPage.this.editor.setCurrentViewer(PamtramEditorSourceSectionMatcherPage.this.mappingViewer);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};
		this.mappingViewer.getTree().addSelectionListener(this.mappingTreeSelectionListener);
	}

	@Override
	public void persist(IDialogSettings settings) {

		// Persist the active editor and its selection
		//
		String activeViewer = "";
		String activeSelection = "";
		if(this.editor.getSelectedPage() != null && this.editor.getSelectedPage().equals(this) &&
				this.editor.currentViewer != null) {
			if(this.editor.currentViewer.equals(this.sourceViewer)) {
				activeViewer = "SOURCE_VIEWER";
			} else if(this.editor.currentViewer.equals(this.mappingViewer)) {
				activeViewer = "MAPPING_VIEWER";
			}
			if(!this.editor.currentViewer.getSelection().isEmpty() &&
					this.editor.currentViewer.getSelection() instanceof TreeSelection) {
				Object selection = ((TreeSelection) this.editor.currentViewer.getSelection()).getFirstElement();
				if(selection instanceof EObject) {
					try {
						/*
						 * use the URI of the eObject as unique identifier
						 */
						activeSelection = EcoreUtil.getURI((EObject) selection).toString();
					} catch (IllegalArgumentException e) {
						// do nothing
					}
				}
			}
		}
		settings.put("ACTIVE_VIEWER", activeViewer);
		settings.put("ACTIVE_SELECTION", activeSelection);

		// Persist the expanded tree paths of the various tree viewers
		//
		this.sourceViewerGroup.persist(settings.addNewSection("SOURCE_VIEWER"));
		this.mappingViewerGroup.persist(settings.addNewSection("MAPPING_VIEWER"));
	}

	@Override
	public void restore(IDialogSettings settings) {

		// Restore the active editor and its selection
		//
		if(this.editor.getSelectedPage() != null && this.editor.getSelectedPage().equals(this) &&
				settings.get("ACTIVE_VIEWER") != null) {

			String activeViewer = settings.get("ACTIVE_VIEWER");
			if(activeViewer.equals("SOURCE_VIEWER")) {
				this.editor.setCurrentViewer(this.sourceViewer);
			} else if(activeViewer.equals("MAPPING_VIEWER")) {
				this.editor.setCurrentViewer(this.mappingViewer);
			}
		}
		if(this.editor.getSelectedPage() != null && this.editor.getSelectedPage().equals(this) &&
				settings.get("ACTIVE_SELECTION") != null && !settings.get("ACTIVE_SELECTION").isEmpty()) {

			String activeSelection = settings.get("ACTIVE_SELECTION");
			/*
			 * as the URI of an eObject also reflects the containing resource, we can use this to
			 * uniquely identify an eObject inside a resource set
			 */
			EObject selection = this.editor.getEditingDomain().getResourceSet().getEObject(URI.createURI(activeSelection), true);
			if(selection != null) {
				this.editor.currentViewer.setSelection(new StructuredSelection(selection));
			}
		}

		// Restore the expanded tree paths of the various tree viewers
		//
		if(settings.getSection("SOURCE_VIEWER") != null) {
			this.sourceViewerGroup.restore(settings.getSection("SOURCE_VIEWER"));
		}
		if(settings.getSection("MAPPING_VIEWER") != null) {
			this.mappingViewerGroup.restore(settings.getSection("MAPPING_VIEWER"));
		}
	}

}
