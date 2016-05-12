package pamtram.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.mfreund.gentrans.transformation.resolving.UserDecisionResolvingStrategy;
import de.tud.et.ifa.agtele.ui.interfaces.IPersistable;
import de.tud.et.ifa.agtele.ui.providers.EObjectTreeContentProvider;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup;
import pamtram.contentprovider.MappingContentProvider;
import pamtram.contentprovider.SourceSectionContentProvider;
import pamtram.listeners.SetViewerMouseListener;
import pamtram.listeners.SetViewerSelectionListener;
import pamtram.mapping.MappingType;
import pamtram.metamodel.SourceSectionClass;

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
	protected LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections;

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

		createSourceViewer();
		createMappingViewer();
		createSourceModelViewer();
	}

	private void createSourceViewer() {

		// Create the viewer for the source sections.
		//
		sourceViewerGroup = new TreeViewerGroup(
				this, adapterFactory, editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(), 
				"Source Sections");
		sourceViewer = sourceViewerGroup.getViewer();
		sourceViewer.setContentProvider(new SourceSectionContentProvider(adapterFactory));
		sourceViewer.setInput(editor.pamtram);
		sourceTreeSelectionListener = new SetViewerSelectionListener(editor, sourceViewer);
		sourceViewer.getTree().addSelectionListener(sourceTreeSelectionListener);
		sourceViewer.getTree().addMouseListener(new SetViewerMouseListener(editor, sourceViewer));

		new AdapterFactoryTreeEditor(sourceViewer.getTree(), adapterFactory);

		editor.createContextMenuFor(sourceViewer);

	}

	private void createMappingViewer() {

		// Create the viewer for the source sections.
		//
		mappingViewerGroup = new TreeViewerGroup(
				this, adapterFactory, editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(), 
				"Mappings");
		mappingViewer = mappingViewerGroup.getViewer();

		mappingViewer.setContentProvider(new MappingContentProvider(adapterFactory));
		mappingViewer.setInput(editor.pamtram);
		mappingTreeSelectionListener = new SetViewerSelectionListener(editor, mappingViewer);
		mappingViewer.getTree().addSelectionListener(mappingTreeSelectionListener);
		mappingViewer.getTree().addMouseListener(new SetViewerMouseListener(editor, mappingViewer));

		new AdapterFactoryTreeEditor(mappingViewer.getTree(), adapterFactory);

		editor.createContextMenuFor(mappingViewer);

	}

	private void createSourceModelViewer() {
		// Create a group for the source section tree viewer.
		sourceModelGroup = new Group(this, SWT.NONE);
		sourceModelGroup.setText("Model to be matched");
		sourceModelGroup.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		sourceModelGroup.setLayout(new GridLayout(1, true));

		// Create a drop-down list that allows to select the source model to be analysed.
		sourceModelCombo = new Combo(sourceModelGroup, SWT.DROP_DOWN | SWT.BORDER);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.grabExcessHorizontalSpace = true;
			sourceModelCombo.setLayoutData(gd);
		}
		// Create a modify listener that updates the source model based on the selection.
		sourceModelCombo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				updateSourceModel();
			}
		});

		// Get the current project.
		project = ResourceUtil.getResource(editor.getEditorInput()).getProject();

		try {
			if(project.hasNature("de.mfreund.pamtram.pamtramNature")) {
				// populate the current source projects in the workspace to the list
				for(IResource res : project.getFolder("Source").members()) {
					if(res.getName().endsWith(".xml") || res.getName().endsWith(".xmi")) {
						sourceModelCombo.add(res.getName());
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Create the source tree viewer.
		Tree sourceModelTree = new Tree(sourceModelGroup, SWT.MULTI);
		sourceModelViewer = new TreeViewer(sourceModelTree);
		sourceModelTree.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		sourceModelViewer.setContentProvider(new EObjectTreeContentProvider());
		sourceModelViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		sourceModelTree.addSelectionListener(new SetViewerSelectionListener(editor, sourceModelViewer));
	}

	/**
	 * This updates the source model file shown in the source model
	 * tree based on the current selection in the source model combo.
	 * 
	 * TODO There should be no direct dependency to the gentrans plug-in/the GenericTransformationRunner. 
	 * This should be solved by an extension point.
	 */
	protected void updateSourceModel() {

		if(sourceModelCombo.getText().isEmpty()) {
			sourceModelViewer.setInput(null);
			return;
		}

		// the selected file
		String modelFile = project.getName() + Path.SEPARATOR + "Source" + Path.SEPARATOR + sourceModelCombo.getText();

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
			modelResource = editor.getEditingDomain().getResourceSet().getResource(modelUri, true);
			modelResource.load(Collections.EMPTY_MAP);
		} catch(Exception e) {
			MessageDialog.openError(getShell(), "Error loading resource", 
					e.getMessage());
			sourceModelViewer.setInput(null);
			return;
		}

		EList<EObject> contents = modelResource.getContents();

		/* 
		 * If an xml source file has been selected,  we have to omit the 'document root' element and 
		 * instead determine the actual contents. Passing the load option 'XMLResource.OPTION_SUPPRESS_DOCUMENT_ROOT'
		 * somehow does not seem to work. 
		 */
		if((contents.get(0)).eClass().getName().equals("DocumentRoot")) {
			contents = (contents.get(0)).eContents();
		}


		// set the contents of the resource as input for the source model viewer
		sourceModelViewer.setInput(contents);

		// the target file
		String targetBasePath = project.getName() + Path.SEPARATOR + "Target";
		String defaultTargetModel = "temp.xmi";

		// Create a transformation runner and use it to get the matching source sections
		GenericTransformationRunner tr = 
				GenericTransformationRunner.createInstanceFromSourceModels(
						new ArrayList<EObject>(contents), editor.pamtram, targetBasePath, defaultTargetModel, null, new UserDecisionResolvingStrategy());

		matchedSections = tr.mapSections();

		if(matchedSections == null) {
			return;
		}

		// add a selection listener for the highlighting (overwrite the old one)
		sourceViewer.getTree().removeSelectionListener(sourceTreeSelectionListener);
		sourceTreeSelectionListener = new SelectionListener() {
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
					mappingViewer.setSelection(new StructuredSelection());
				} else {
					sourceModelViewer.setSelection(new StructuredSelection());
				}

				if(sourceSectionClass != null) {
					// find the 'matched sections' for the selected source section
					for (SourceSectionClass c : matchedSections.keySet()) {
						if(EcoreUtil.equals(sourceSectionClass, c)) {
							// the matched elements that shall be highlighted
							Set<EObject> matchedEObjects = matchedSections.get(c);

							if(matchedEObjects == null) {
								continue;
							}

							sourceModelViewer.collapseAll();
							sourceModelViewer.setSelection(
									new StructuredSelection(matchedEObjects.toArray()),
									true
									);

							break;
						}
					}
				}

				editor.setCurrentViewer(sourceViewer);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};
		sourceViewer.getTree().addSelectionListener(sourceTreeSelectionListener);

		// add a selection listener for the highlighting (overwrite the old one)
		mappingViewer.getTree().removeSelectionListener(mappingTreeSelectionListener);
		mappingTreeSelectionListener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				SourceSectionClass sourceSectionClass = null;

				// get the source section for which the matched elements in the source
				// model viewer shall be shown (depending on the users selection)
				//
				if(((TreeItem) e.item).getData() instanceof MappingType) {
					sourceSectionClass = ((MappingType) ((TreeItem) e.item).getData()).getSourceMMSection();
					// select the source section for this mapping (that is used to find the matched elements
					sourceViewer.setSelection(new StructuredSelection(sourceSectionClass), true);
				} else {
					sourceModelViewer.setSelection(new StructuredSelection());
				}

				if(sourceSectionClass != null) {
					// find the 'matched sections' for the selected source section
					for (SourceSectionClass c : matchedSections.keySet()) {
						if(EcoreUtil.equals(sourceSectionClass, c)) {
							// the matched elements that shall be highlighted
							Set<EObject> matchedEObjects = matchedSections.get(c);

							if(matchedEObjects == null) {
								continue;
							}

							sourceModelViewer.collapseAll();
							sourceModelViewer.setSelection(
									new StructuredSelection(matchedEObjects.toArray()),
									true
									);

							break;
						}
					}
				}

				editor.setCurrentViewer(mappingViewer);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};
		mappingViewer.getTree().addSelectionListener(mappingTreeSelectionListener);
	}

	@Override
	public void persist(IDialogSettings settings) {
		
		// Persist the active editor and its selection
		//
		String activeViewer = "";
		String activeSelection = "";
		if(editor.getSelectedPage() != null && editor.getSelectedPage().equals(this) && 
				editor.currentViewer != null) {
			if(editor.currentViewer.equals(sourceViewer)) {
				activeViewer = "SOURCE_VIEWER";
			} else if(editor.currentViewer.equals(mappingViewer)) {
				activeViewer = "MAPPING_VIEWER";
			}
			if(!editor.currentViewer.getSelection().isEmpty() && 
					editor.currentViewer.getSelection() instanceof TreeSelection) {
				Object selection = ((TreeSelection) editor.currentViewer.getSelection()).getFirstElement();
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
		sourceViewerGroup.persist(settings.addNewSection("SOURCE_VIEWER"));
		mappingViewerGroup.persist(settings.addNewSection("MAPPING_VIEWER"));
	}

	@Override
	public void restore(IDialogSettings settings) {
		
		// Restore the active editor and its selection
		//
		if(editor.getSelectedPage() != null && editor.getSelectedPage().equals(this) && 
				settings.get("ACTIVE_VIEWER") != null) {
			
			String activeViewer = settings.get("ACTIVE_VIEWER");
			if(activeViewer.equals("SOURCE_VIEWER")) {
				editor.setCurrentViewer(sourceViewer);
			} else if(activeViewer.equals("MAPPING_VIEWER")) {
				editor.setCurrentViewer(mappingViewer);
			}
		}
		if(editor.getSelectedPage() != null && editor.getSelectedPage().equals(this) && 
				settings.get("ACTIVE_SELECTION") != null && !settings.get("ACTIVE_SELECTION").isEmpty()) {
			
			String activeSelection = settings.get("ACTIVE_SELECTION");
			/*
			 * as the URI of an eObject also reflects the containing resource, we can use this to
			 * uniquely identify an eObject inside a resource set
			 */
			EObject selection = editor.getEditingDomain().getResourceSet().getEObject(URI.createURI(activeSelection), true);
			if(selection != null) {
				editor.currentViewer.setSelection(new StructuredSelection(selection));			
			}
		}

		// Restore the expanded tree paths of the various tree viewers
		//
		if(settings.getSection("SOURCE_VIEWER") != null) {
			sourceViewerGroup.restore(settings.getSection("SOURCE_VIEWER"));
		}
		if(settings.getSection("MAPPING_VIEWER") != null) {
			mappingViewerGroup.restore(settings.getSection("MAPPING_VIEWER"));
		}
	}

}
