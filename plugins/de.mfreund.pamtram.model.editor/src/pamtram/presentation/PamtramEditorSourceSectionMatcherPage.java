package pamtram.presentation;

import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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

import pamtram.metamodel.SourceSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.presentation.listeners.MMElementDragListener;

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
		sourceTree.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editor.setCurrentViewer(sourceViewer);
				
				if(((TreeItem) e.item).getData() instanceof SourceSectionNonContainmentReference) {
					
					SourceSectionNonContainmentReference reference = (SourceSectionNonContainmentReference) ((TreeItem) e.item).getData();
					
					EList<pamtram.metamodel.SourceSectionClass> referencedElements = reference.getValue();
					
					// if a non containment reference has been selected while holding down the
					// control key, jump to the referenced class 
					if(reference != null && e.stateMask == SWT.CTRL) {
						sourceViewer.setSelection(
								new StructuredSelection(referencedElements.toArray()));
					}
				} else 	if(((TreeItem) e.item).getData() instanceof TargetSectionNonContainmentReference) {
					
					TargetSectionNonContainmentReference reference = (TargetSectionNonContainmentReference) ((TreeItem) e.item).getData();
					
					EList<pamtram.metamodel.TargetSectionClass> referencedElements = reference.getValue();
					
					// if a non containment reference has been selected while holding down the
					// control key, jump to the referenced class 
					if(reference != null && e.stateMask == SWT.CTRL) {
						sourceViewer.setSelection(
								new StructuredSelection(referencedElements.toArray()));
					}
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
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
		sourceModelViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory){
			/* extend the content provider in a way that an eList of objects can
			 * be set as input
			 */
			@SuppressWarnings("rawtypes")
			@Override
			public Object[] getElements(Object object) {
				if(object instanceof EList) {
					return ((EList) object).toArray();
				}
				return super.getElements(object);
			}
			
		});
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
		
		// create a resource set
		ResourceSet rs = new ResourceSetImpl();
		
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
			modelResource = rs.getResource(modelUri, true);
			modelResource.load(Collections.EMPTY_MAP);
		} catch(Exception e) {
			MessageDialog.openError(getShell(), "Error loading resource", 
					e.getMessage());
			sourceModelViewer.setInput(null);
			return;
		}
		
		// set the contents of the resource as input for the source model viewer
		sourceModelViewer.setInput(modelResource.getContents());
	}

}
