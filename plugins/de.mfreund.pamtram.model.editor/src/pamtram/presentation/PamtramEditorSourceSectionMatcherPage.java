/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
import org.eclipse.jface.viewers.ISelectionProvider;
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
import org.eclipse.ui.ide.ResourceUtil;

import de.mfreund.gentrans.transformation.ITransformationRunner;
import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.mfreund.gentrans.transformation.TransformationRunnerWithUIFactory;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.tud.et.ifa.agtele.ui.interfaces.IPersistable;
import de.tud.et.ifa.agtele.ui.interfaces.ISelectionProviderWrapper;
import de.tud.et.ifa.agtele.ui.providers.EObjectTreeContentProvider;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup;
import pamtram.contentprovider.MappingContentProvider;
import pamtram.contentprovider.SourceSectionContentProvider;
import pamtram.listeners.SetViewerMouseListener;
import pamtram.listeners.SetViewerSelectionListener;
import pamtram.mapping.MappingType;
import pamtram.provider.PamtramEditPlugin;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * The page of the {@link PamtramEditor} that allows to check which source sections are matched for a given source
 * model..
 *
 * @author mfreund
 */
public class PamtramEditorSourceSectionMatcherPage extends SashForm implements IPersistable, ISelectionProviderWrapper {

	/**
	 * This is the editor that this view is hosted in.
	 */
	protected PamtramEditor editor;

	/**
	 * This is the one adapter factory used for providing views of the model. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
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
	 * This is the list of matched sections that is determined when the user selects a source model.
	 */
	protected MatchedSectionRegistry matchedSections;

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
	public PamtramEditorSourceSectionMatcherPage(Composite parent, int style, ComposedAdapterFactory adapterFactory,
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
		this.sourceViewerGroup = new TreeViewerGroup(this, this.adapterFactory, this.editor.getEditingDomain(),
				PamtramEditorPlugin.getPlugin().getDialogSettings(), "Source Sections",
				TreeViewerGroup.BIND_HELP_LISTENER());
		this.sourceViewer = this.sourceViewerGroup.getViewer();
		this.sourceViewer.setContentProvider(new SourceSectionContentProvider(this.adapterFactory));
		this.sourceViewer.setInput(this.editor.pamtram);
		this.sourceTreeSelectionListener = new ViewerSelectionListener(this.sourceViewer);
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
		this.mappingViewerGroup = new TreeViewerGroup(this, this.adapterFactory, this.editor.getEditingDomain(),
				PamtramEditorPlugin.getPlugin().getDialogSettings(), "Mappings", TreeViewerGroup.BIND_HELP_LISTENER());
		this.mappingViewer = this.mappingViewerGroup.getViewer();

		this.mappingViewer.setContentProvider(new MappingContentProvider(this.adapterFactory));
		this.mappingViewer.setInput(this.editor.pamtram);
		this.mappingTreeSelectionListener = new ViewerSelectionListener(this.mappingViewer);
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
		this.sourceModelGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.sourceModelGroup.setLayout(new GridLayout(1, true));

		// Create a drop-down list that allows to select the source model to be
		// analysed.
		this.sourceModelCombo = new Combo(this.sourceModelGroup, SWT.DROP_DOWN | SWT.BORDER);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.grabExcessHorizontalSpace = true;
			this.sourceModelCombo.setLayoutData(gd);
		}
		// Create a modify listener that updates the source model based on the
		// selection.
		this.sourceModelCombo.addModifyListener(e -> PamtramEditorSourceSectionMatcherPage.this.updateSourceModel());

		// Get the current project.
		this.project = ResourceUtil.getResource(this.editor.getEditorInput()).getProject();

		try {
			if (this.project.hasNature("de.mfreund.pamtram.pamtramNature")) {
				// populate the current source projects in the workspace to the
				// list
				for (IResource res : this.project.getFolder(PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME"))
						.members()) {
					if (res.getName().endsWith(".xml") || res.getName().endsWith(".xmi")) {
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
		sourceModelTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.sourceModelViewer.setContentProvider(new EObjectTreeContentProvider());
		this.sourceModelViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));
		sourceModelTree.addSelectionListener(new SetViewerSelectionListener(this.editor, this.sourceModelViewer));
	}

	/**
	 * This updates the source model file shown in the source model tree based on the current selection in the source
	 * model combo.
	 *
	 * TODO There should be no direct dependency to the gentrans plug-in/the GenericTransformationRunner. This should be
	 * solved by an extension point.
	 */
	protected void updateSourceModel() {

		if (this.sourceModelCombo.getText().isEmpty()) {
			this.sourceModelViewer.setInput(null);
			return;
		}

		// the selected file
		String modelFile = this.project.getName() + IPath.SEPARATOR
				+ PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME") + IPath.SEPARATOR
				+ this.sourceModelCombo.getText();

		// if an xml source file has been selected,
		// add the file extension to registry
		if (modelFile.endsWith(".xml")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml",
					new GenericXMLResourceFactoryImpl());
		}

		// the selected resource as URI
		URI modelUri = URI.createPlatformResourceURI(modelFile, true);

		Resource modelResource = null;
		try {
			// load the source model
			modelResource = this.editor.getEditingDomain().getResourceSet().getResource(modelUri, true);
			modelResource.load(Collections.EMPTY_MAP);
		} catch (Exception e) {
			MessageDialog.openError(this.getShell(), "Error loading resource", e.getMessage());
			this.sourceModelViewer.setInput(null);
			return;
		}

		EList<EObject> contents = modelResource.getContents();

		/*
		 * If an xml source file has been selected, we have to omit the 'document root' element and instead determine
		 * the actual contents. Passing the load option 'XMLResource.OPTION_SUPPRESS_DOCUMENT_ROOT' somehow does not
		 * seem to work.
		 */
		if (contents.get(0).eClass().getName().equals("DocumentRoot")) {
			contents = contents.get(0).eContents();
		}

		// set the contents of the resource as input for the source model viewer
		this.sourceModelViewer.setInput(contents);

		// the target file
		String targetBasePath = this.project.getName() + IPath.SEPARATOR
				+ PamtramEditPlugin.INSTANCE.getString("TARGET_FOLDER_NAME");
		String defaultTargetModel = "temp.xmi";

		// Create a transformation runner and use it to get the matching source
		// sections
		//
		TransformationConfiguration transformationConfig = TransformationConfiguration
				.createInstanceFromSourceModels(new ArrayList<>(contents), Arrays.asList(this.editor.pamtram),
						targetBasePath)
				.withDefaultTargetModel(defaultTargetModel);

		ITransformationRunner tr = TransformationRunnerWithUIFactory.INSTANCE
				.createSourceSectionMatcher(transformationConfig);

		this.matchedSections = tr.run().getMatchedSectionRegistry().orElse(null);

		if (this.matchedSections == null) {
			return;
		}

	}

	/**
	 * A {@link SetViewerSelectionListener} that handles selections in the
	 * {@link PamtramEditorSourceSectionMatcherPage#sourceViewer} or
	 * {@link PamtramEditorSourceSectionMatcherPage#mappingViewer}.
	 *
	 * @author mfreund
	 */
	private final class ViewerSelectionListener extends SetViewerSelectionListener {

		private ViewerSelectionListener(TreeViewer viewer) {

			super(PamtramEditorSourceSectionMatcherPage.this.editor, viewer);
		}

		@Override
		protected void handleSingleSelection(Object selected, SelectionEvent e) {

			// The elements that will be selected in the various viewers
			//
			List<Object> toSelect = new ArrayList<>();
			toSelect.add(selected);

			SourceSectionClass sourceSectionClass = null;

			if (selected instanceof SourceSectionClass) {

				sourceSectionClass = (SourceSectionClass) selected;

			} else if (selected instanceof MappingType) {

				sourceSectionClass = ((MappingType) selected).getSourceSection();
				toSelect.add(sourceSectionClass);
			}

			if (sourceSectionClass != null) {

				// If an abstract SourceSection has been selected, show results for (concrete) extending Sections
				// instead
				//
				List<SourceSectionClass> affectedClasses = new ArrayList<>(
						sourceSectionClass instanceof SourceSection && ((SourceSection) sourceSectionClass).isAbstract()
								? ((SourceSection) sourceSectionClass).getAllExtending()
								: Arrays.asList(sourceSectionClass));

				toSelect.addAll(affectedClasses);

				if (PamtramEditorSourceSectionMatcherPage.this.matchedSections != null) {

					// Determine the source model objects matched against the 'affectedClass' based on the
					// 'matchedSectionRegistry'
					//
					for (SourceSectionClass affectedClass : affectedClasses) {
						List<MatchedSectionDescriptor> potentialDescriptors = PamtramEditorSourceSectionMatcherPage.this.matchedSections
								.get(affectedClass.getContainingSection());
						for (MatchedSectionDescriptor potentialDescriptor : potentialDescriptors) {
							toSelect.addAll(potentialDescriptor.getMatchedSourceModelObjects(false)
									.getOrDefault(affectedClass, new HashSet<>()));
						}
					}
				}

			}

			PamtramEditorSourceSectionMatcherPage.this.editor.setSelection(new StructuredSelection(
					toSelect.stream().filter(Objects::nonNull).collect(Collectors.toSet()).toArray()));
		}

	}

	@Override
	public void persist(IDialogSettings settings) {

		// Persist the active editor and its selection
		//
		String activeViewer = "";
		String activeSelection = "";
		if (this.editor.getSelectedPage() != null && this.editor.getSelectedPage().equals(this)
				&& this.editor.currentViewer != null) {
			if (this.editor.currentViewer.equals(this.sourceViewer)) {
				activeViewer = "SOURCE_VIEWER";
			} else if (this.editor.currentViewer.equals(this.mappingViewer)) {
				activeViewer = "MAPPING_VIEWER";
			}
			if (!this.editor.currentViewer.getSelection().isEmpty()
					&& this.editor.currentViewer.getSelection() instanceof TreeSelection) {
				Object selection = ((TreeSelection) this.editor.currentViewer.getSelection()).getFirstElement();
				if (selection instanceof EObject) {
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
		if (this.editor.getSelectedPage() != null && this.editor.getSelectedPage().equals(this)
				&& settings.get("ACTIVE_VIEWER") != null) {

			String activeViewer = settings.get("ACTIVE_VIEWER");
			if (activeViewer.equals("SOURCE_VIEWER")) {
				this.editor.setCurrentViewer(this.sourceViewer);
			} else if (activeViewer.equals("MAPPING_VIEWER")) {
				this.editor.setCurrentViewer(this.mappingViewer);
			}
		}
		if (this.editor.getSelectedPage() != null && this.editor.getSelectedPage().equals(this)
				&& settings.get("ACTIVE_SELECTION") != null && !settings.get("ACTIVE_SELECTION").isEmpty()) {

			String activeSelection = settings.get("ACTIVE_SELECTION");
			/*
			 * as the URI of an eObject also reflects the containing resource, we can use this to uniquely identify an
			 * eObject inside a resource set
			 */
			EObject selection = this.editor.getEditingDomain().getResourceSet()
					.getEObject(URI.createURI(activeSelection), true);
			if (selection != null) {
				this.editor.currentViewer.setSelection(new StructuredSelection(selection));
			}
		}

		// Restore the expanded tree paths of the various tree viewers
		//
		if (settings.getSection("SOURCE_VIEWER") != null) {
			this.sourceViewerGroup.restore(settings.getSection("SOURCE_VIEWER"));
		}
		if (settings.getSection("MAPPING_VIEWER") != null) {
			this.mappingViewerGroup.restore(settings.getSection("MAPPING_VIEWER"));
		}
	}

	@Override
	public Collection<ISelectionProvider> getWrappedProviders() {

		return Arrays.asList(this.sourceViewerGroup, this.mappingViewerGroup, this.sourceModelViewer);
	}

}
