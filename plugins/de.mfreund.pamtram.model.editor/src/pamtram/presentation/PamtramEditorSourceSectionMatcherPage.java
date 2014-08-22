package pamtram.presentation;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
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
import pamtram.metamodel.SourceSectionClass;
import pamtram.presentation.listeners.MMElementDragListener;
import pamtram.util.EObjectTreeContentProvider;

public class PamtramEditorSourceSectionMatcherPage extends SashForm {
	
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
	 * This is the the viewer for the source meta model sections.
	 */
	protected TreeViewer sourceViewer;
	
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
	 * This is the listener that is used to highlight matching sections when
	 * the user selects a source section.
	 */
	protected SelectionListener highlightMatchedSectionsListener = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			editor.setCurrentViewer(sourceViewer);
			
			if(((TreeItem) e.item).getData() instanceof SourceSectionClass) {
				
				SourceSectionClass sourceSectionClass = (SourceSectionClass) ((TreeItem) e.item).getData();
				
				for (SourceSectionClass c : matchedSections.keySet()) {
					if(EcoreUtil.equals(sourceSectionClass, c)) {
						Set<EObject> matchedEObjects = matchedSections.get(c);
						
						if(matchedEObjects == null) {
							continue;
						}
						
						sourceModelViewer.setSelection(
								new StructuredSelection(matchedEObjects.toArray()),
								true
							);
						
						break;
					}
				}
			}
			
			if(((TreeItem) e.item).getData() instanceof SourceSectionClass) {
				
				
			}
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
	};
	
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
		createSourceModelViewer();
	}
	
	private void createSourceViewer() {
		
		// Create a group for the source section tree viewer.
		sourceGroup = new Group(this, SWT.NONE);
		sourceGroup.setText("Source Sections");
		sourceGroup.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		sourceGroup.setLayout(new GridLayout(1, true));
		
		// Create the source tree viewer.
		Tree sourceTree = new Tree(sourceGroup, SWT.MULTI);
		sourceViewer = new TreeViewer(sourceTree);
		sourceTree.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
		// add d'n'd support
		{
			int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
			Transfer[] transferTypes = new Transfer[]{LocalTransfer.getInstance()};
			sourceViewer.addDragSupport(dndOperations, transferTypes, new MMElementDragListener(sourceViewer));
		}
		
		sourceViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		sourceViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		sourceViewer.setInput(editor.pamtram.getSourceSectionModel());
		//sourceTree.addSelectionListener(highlightMatchedSectionsListener);
		
		new AdapterFactoryTreeEditor(sourceViewer.getTree(), adapterFactory);
		
		editor.createContextMenuFor(sourceViewer);
		
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
		
	}

	/**
	 * This updates the source model file shown in the source model
	 * tree based on the current selection in the source model combo.
	 */
	protected void updateSourceModel() {
		
		if(sourceModelCombo.getText().isEmpty()) {
			sourceModelViewer.setInput(null);
			return;
		}

		// the selected file
		String modelFile = project.getFullPath().toString() + Path.SEPARATOR + 
				"Source" + Path.SEPARATOR + sourceModelCombo.getText();
		
		// if an xml source file has been selected, 
		// add the file extension to registry 
		if(modelFile.endsWith(".xml")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.put("xml", new GenericXMLResourceFactoryImpl());
		}
		
		// the selected resource as URI
		URI modelUri = URI.createFileURI(new java.io.File(modelFile).toString());

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
		
		// set the contents of the resource as input for the source model viewer
		sourceModelViewer.setInput(modelResource.getContents());
		
		// the pamtram file
		String pamtramFile = project.getFullPath().toString() + Path.SEPARATOR + 
				"Pamtram" + Path.SEPARATOR + "Disl2Movisa.pamtram";
		
		// the target file
		String targetFile = project.getFullPath().toString() + Path.SEPARATOR + 
				"Target" + Path.SEPARATOR + "test.xmi";
		
		// Create a transformation runner and use it to get the matching source sections
		GenericTransformationRunner tr = 
				new GenericTransformationRunner(modelResource.getContents().get(0), pamtramFile, targetFile);
		
		matchedSections = tr.mapSections();
		
		if(matchedSections == null) {
			return;
		}
		
		sourceViewer.getTree().addSelectionListener(highlightMatchedSectionsListener);
	}

}
