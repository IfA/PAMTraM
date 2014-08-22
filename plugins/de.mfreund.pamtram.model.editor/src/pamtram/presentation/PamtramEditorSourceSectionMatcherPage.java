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
import pamtram.MappingModel;
import pamtram.mapping.MappingType;
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
	 * This is the group for the mapping tree viewer.
	 */
	protected Group mappingGroup;

	/**
	 * This is the the viewer for the mappings.
	 */
	protected TreeViewer mappingViewer;
	
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
	 * the user selects a source section or a mapping.
	 */
	protected SelectionListener highlightMatchedSectionsListener = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			editor.setCurrentViewer(sourceViewer);
			
			SourceSectionClass sourceSectionClass = null;
			
			// get the source section for which the matched elements in the source
			// model viewer shall be shown (depending on the users selection)
			//
			if(((TreeItem) e.item).getData() instanceof SourceSectionClass) {
				sourceSectionClass = (SourceSectionClass) ((TreeItem) e.item).getData();
				// do not select a mapping because multiple mappings could make use of
				// this source section
				mappingViewer.setSelection(new StructuredSelection());
			} else if(((TreeItem) e.item).getData() instanceof MappingType) {
				sourceSectionClass = ((MappingType) ((TreeItem) e.item).getData()).getSourceMMSection();
				// select the source section for this mapping (that is used to find the matched elements
				sourceViewer.setSelection(new StructuredSelection(sourceSectionClass), true);
			} else {
				sourceModelViewer.setSelection(new StructuredSelection());
				return;
			}
				
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
		createMappingViewer();
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
	
	private void createMappingViewer() {
		
		// Create a group for the mapping tree viewer.
		mappingGroup = new Group(this, SWT.NONE);
		mappingGroup.setText("Mappings");
		mappingGroup.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		mappingGroup.setLayout(new GridLayout(1, true));
		
		// Create the mapping tree viewer.
		Tree mappingTree = new Tree(mappingGroup, SWT.MULTI);
		mappingViewer = new TreeViewer(mappingTree);
		mappingTree.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
		editor.setCurrentViewer(mappingViewer);
		
		mappingViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {
			/* extend the content provider in a way that no attribute value modifier sets 
			 * but only mappings are returned as children of a mapping model
			 */
			@Override
			public Object[] getElements(Object object) {
				if(object instanceof MappingModel) {
					return ((MappingModel) object).getMapping().toArray();
				}
				return super.getElements(object);
			}
		});
		mappingViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		mappingViewer.setInput(editor.pamtram.getMappingModel());
		mappingTree.addSelectionListener(highlightMatchedSectionsListener);
//		mappingTree.addSelectionListener(new SelectionListener() {
//			
//			private Mapping currentMapping;
//			private NamedElement currentMappingHintGroup;
//			
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				editor.setCurrentViewer(mappingViewer);
//				
//				if(((TreeItem) e.item).getData() instanceof Mapping) {
//					
//					LinkedList<Object> expanded=new LinkedList<Object>();
//					Mapping mapping=null;
//					Object source=null;
//					LinkedList<pamtram.metamodel.Class> targets=new LinkedList<pamtram.metamodel.Class>();
//					
//					mapping = (Mapping) ((TreeItem) e.item).getData();
//					source = mapping.getSourceMMSection();
//					
//					if(mapping != null){
//						expanded.add(mapping);
//						for(MappingHintGroupType group : mapping.getMappingHintGroups()){
//							targets.add(group.getTargetMMSection());
//						}
//					}
//					
//					// Expand the mapping in the mapping tree viewer.
//					mappingViewer.setExpandedElements(
//							expanded.toArray());
//					
//					// Select and expand the source and target items associated with
//					// the selected mapping.
//					if(source == null) {
//						sourceViewer.setSelection(
//								new StructuredSelection());
//						if(mapping != currentMapping) {
//							sourceViewer.setExpandedElements(
//									new Object[]{});
//						}
//					} else {
//						sourceViewer.setSelection(
//								new StructuredSelection(source));
//						if(mapping != currentMapping) {
//							sourceViewer.setExpandedElements(
//									new Object[]{source});
//						}
//					}
//					if(targets.isEmpty()) {
//						targetViewer.setSelection(
//								new StructuredSelection());
//						if(mapping != currentMapping) {
//							targetViewer.setExpandedElements(
//									new Object[]{});
//						}
//					} else {
//						targetViewer.setSelection(
//								new StructuredSelection(targets));
//						if(mapping != currentMapping) {
//							targetViewer.setExpandedElements(
//									targets.toArray());
//						}
//					}
//					
//					// Update the currently selected mapping.
//					currentMapping = mapping;
//				}  else if(((TreeItem) e.item).getData() instanceof AttributeMappingSourceElementType 
//						&& ! (((TreeItem) e.item).getData()instanceof SimpleAttributeMatcher)
//						&& ! (((TreeItem) e.item).getData()instanceof SimpleModelConnectionHint)
//						) {
//					AttributeMappingSourceElementType mapping = (AttributeMappingSourceElementType) ((TreeItem) e.item).getData();
//					
//					Attribute target = null;
//					
//					if(mapping.eContainer() instanceof AttributeMapping){
//						target= ((AttributeMapping)mapping.eContainer()).getTarget();
//					} else if (mapping instanceof SimpleAttributeMapping){
//						target=((SimpleAttributeMapping) mapping).getTarget();
//					}
//					
//					Attribute source = mapping.getSource();
//					
//					setSourceTargetViewerSingleItemSelections(target,
//							source);
//				}  else if(((TreeItem) e.item).getData() instanceof GlobalVariableImporter){
//					GlobalVariableImporter mapping = (GlobalVariableImporter) ((TreeItem) e.item).getData();
//					Attribute target = ((AttributeMapping)mapping.eContainer()).getTarget();
//					Attribute source=mapping.getSourceAttribute();
//					
//					setSourceTargetViewerSingleItemSelections(target, source);
//					
//					
//				} else if(((TreeItem) e.item).getData() instanceof ComplexAttributeMapping || ((TreeItem) e.item).getData() instanceof CalculatorMapping) {
//					AttributeMapping mapping = (AttributeMapping) ((TreeItem) e.item).getData();
//					Attribute target = mapping.getTarget();
//					
//					
//					List<Attribute> sources = new LinkedList<Attribute>();
//					
//					if(mapping instanceof ComplexAttributeMapping){							
//						for(ComplexAttributeMappingSourceInterface c : ((ComplexAttributeMapping) mapping).getSourceAttributeMappings()){
//							if(c.getSourceAttribute() != null){
//								sources.add(c.getSourceAttribute());
//							}
//						}
//						
//					} else {
//						
//						for(CalculatorMappingSourceInterface c : ((CalculatorMapping) mapping).getVariables()){
//							if(c.getSourceAttribute() != null){
//								sources.add(c.getSourceAttribute());
//							}
//						}
//					}
//					
//					
//					
//					sourceViewer.setSelection(new StructuredSelection(sources));
//					
//					if(target == null) {
//						targetViewer.setSelection(
//								new StructuredSelection());
//					} else {
//						targetViewer.setSelection(
//								new StructuredSelection(target));
//					}
//					
//				} else if(((TreeItem) e.item).getData() instanceof CardinalityMapping) {
//					
//					CardinalityMapping mapping = (CardinalityMapping) ((TreeItem) e.item).getData();
//					
//					pamtram.metamodel.Class source = mapping.getSource();
//					pamtram.metamodel.Class target = mapping.getTarget();
//					
//					// Select the source and target item associated with the selected mapping.
//					setSourceTargetViewerSingleItemSelections(target, source);
//				} else if(((TreeItem) e.item).getData() instanceof MappingInstanceSelector) {
//					
//					MappingInstanceSelector selector = (MappingInstanceSelector) ((TreeItem) e.item).getData();
//					
//					NonContainmentReference reference = selector.getAffectedReference();
//					
//					// Select the reference associated with the selected Mapping Instance Selector.
//					if(reference == null) {
//						targetViewer.setSelection(
//								new StructuredSelection());
//					} else {
//						targetViewer.setSelection(
//								new StructuredSelection(reference));
//					}
//					sourceViewer.setSelection(new StructuredSelection());
//					
//				} else if(((TreeItem) e.item).getData() instanceof SimpleAttributeMatcher) {
//					
//					AttributeMatcher matcher = (AttributeMatcher) ((TreeItem) e.item).getData();
//					
//					
//					TargetSectionAttribute target=matcher.getTargetAttribute();
//					SourceSectionAttribute source=null;
//					
//					if(matcher instanceof SimpleAttributeMatcher){
//						source=((SimpleAttributeMatcher) matcher).getSource();
//					} else if(matcher instanceof AttributeMappingSourceElementType){
//						source=((AttributeMappingSourceElementType) matcher).getSource();
//					}
//					
//					// Select the source and target item associated with the selected matcher.
//					setSourceTargetViewerSingleItemSelections(target, source);
//					
//				} else if(((TreeItem) e.item).getData() instanceof ComplexAttributeMatcher){
//					ComplexAttributeMatcher matcher= (ComplexAttributeMatcher) ((TreeItem) e.item).getData();
//					
//					TargetSectionAttribute target= matcher.getTargetAttribute();
//					
//					List<SourceSectionAttribute> sources= new LinkedList<SourceSectionAttribute> ();
//					
//					for(ComplexAttributeMatcherSourceInterface srcElement : matcher.getSourceAttributes()){
//						if(srcElement.getSourceAttribute() != null){
//							sources.add(srcElement.getSourceAttribute());
//						}
//					}
//					
//					sourceViewer.setSelection(new StructuredSelection(sources));
//					
//					if(target == null){
//						targetViewer.setSelection(new StructuredSelection());
//					} else {
//						targetViewer.setSelection(new StructuredSelection(target));
//					}
//					
//				} else if(((TreeItem) e.item).getData() instanceof ClassMatcher) {
//					
//					ClassMatcher matcher = (ClassMatcher) ((TreeItem) e.item).getData();
//					
//					pamtram.metamodel.Class target = matcher.getTargetClass();
//					
//					// Select the source and target item associated with the selected matcher.
//					if(target == null) {
//						targetViewer.setSelection(
//								new StructuredSelection());
//					} else {
//						targetViewer.setSelection(
//								new StructuredSelection(target));
//					}
//					sourceViewer.setSelection(new StructuredSelection());
//					
//				} else if(((TreeItem) e.item).getData() instanceof ModelConnectionHint) {
//					
//					ModelConnectionHint hint = (ModelConnectionHint) ((TreeItem) e.item).getData();
//					
//					LinkedList<Attribute> sources = new LinkedList<Attribute>();
//					
//					if(hint instanceof SimpleModelConnectionHint){
//						sources.add(((SimpleModelConnectionHint) hint).getSource());
//					} else if(hint instanceof ComplexModelConnectionHint){
//						for(ComplexModelConnectionHintSourceInterface sourceElement : ((ComplexModelConnectionHint) hint).getSourceElements() ){
//							sources.add(sourceElement.getSourceAttribute());
//						}
//					}
//					
//					LinkedList<Attribute> targets = new LinkedList<Attribute>();
//					
//					
//					
//					for(ConnectionHintTargetAttribute a : hint.getTargetAttributes()){
//						targets.add(a.getTargetAttribute());
//					}
//					
//					// Select the source and target item associated with the selected matcher.
//					targetViewer.setSelection(new StructuredSelection(targets));
//					sourceViewer.setSelection(new StructuredSelection(sources));
//					
//				} else if(((TreeItem) e.item).getData() instanceof MappingHintGroupImporter){
//					MappingHintGroupImporter imp=(MappingHintGroupImporter) ((TreeItem) e.item).getData();
//					TargetSectionClass target=null;
//					SourceSectionClass source=null;
//					if(imp.getHintGroup() != null){
//						target=imp.getHintGroup().getTargetMMSection();
//						
//						source=((Mapping)imp.getHintGroup().eContainer()).getSourceMMSection();
//					}
//					setSourceTargetViewerSingleItemSelections(target, source);
//				} else if(((TreeItem)e.item).getData() instanceof MappedAttributeValueExpander){
//					MappedAttributeValueExpander exp = (MappedAttributeValueExpander)((TreeItem)e.item).getData();
//					setSourceTargetViewerSingleItemSelections(exp.getTargetAttribute(), exp.getSourceAttribute());
//				}
//			}
//			private void setSourceTargetViewerSingleItemSelections(
//					Object target, Object source) {
//				// Select the source and target item associated with  the selected mapping.
//				if(source == null) {
//					sourceViewer.setSelection(
//							new StructuredSelection());
//				} else {
//					sourceViewer.setSelection(
//							new StructuredSelection(source));
//				}
//				if(target == null) {
//					targetViewer.setSelection(
//							new StructuredSelection());
//				} else {
//					targetViewer.setSelection(
//							new StructuredSelection(target));
//				}
//			}
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) {
//			}
//			
//		});
//		
		//new AdapterFactoryTreeEditor(mappingViewer.getTree(), adapterFactory);
		
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
