package pamtram.presentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import pamtram.MappingModel;
import pamtram.NamedElement;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.CalculatorMapping;
import pamtram.mapping.CalculatorMappingSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingSourceInterface;
import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceInterface;
import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.SimpleAttributeMatcher;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.presentation.listeners.MMElementDragListener;
import pamtram.presentation.listeners.MappingDropListener;

public class PamtramEditorMainPage extends SashForm {
	
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
	 * This is the group for the att val modifier set tree viewer.
	 */
	protected Group attValModGroup;

	/**
	 * This is the the viewer for the att val modifier sets.
	 */
	protected TreeViewer globalElementsViewer;
	
	/**
	 * This is the group for the target tree viewer.
	 */
	protected Group targetGroup;

	/**
	 * This is the the viewer for the target meta model sections.
	 */
	protected TreeViewer targetViewer;

	public PamtramEditorMainPage(
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
		createTargetViewer();
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
				
				if(((TreeItem) e.item).getData() instanceof MetaModelSectionReference) {
					
					MetaModelSectionReference reference = (MetaModelSectionReference) ((TreeItem) e.item).getData();
					
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

	private void createMappingViewer() {
		
		// Create a sash form to host the mapping and the attribute value modifier view
		SashForm mappingSash = new SashForm(this,SWT.NONE | SWT.VERTICAL);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			mappingSash.setLayoutData(data);
		}
		
		// Create a group for the mapping tree viewer.
		mappingGroup = new Group(mappingSash, SWT.NONE);
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
		
		// add d'n'd support
		{
			int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
			Transfer[] transferTypes = new Transfer[]{LocalTransfer.getInstance()};
			mappingViewer.addDropSupport(dndOperations, transferTypes, new MappingDropListener(mappingViewer));
		}
		
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
		mappingTree.addSelectionListener(new SelectionListener() {
			
			private Mapping currentMapping;
			private NamedElement currentMappingHintGroup;
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				editor.setCurrentViewer(mappingViewer);
				
				if(((TreeItem) e.item).getData() instanceof Mapping
						||
						((TreeItem) e.item).getData() instanceof MappingHintGroupType
						|| ((TreeItem) e.item).getData() instanceof MappingHintGroupImporter
						|| ((TreeItem) e.item).getData() instanceof GlobalAttribute
						) {
					
					LinkedList<Object> expanded=new LinkedList<Object>();
					Mapping mapping=null;
					Object source=null;
					LinkedList<pamtram.metamodel.Class> targets=new LinkedList<pamtram.metamodel.Class>();
					
					
					if(((TreeItem) e.item).getData() instanceof MappingHintGroupType){
						
						if ((MappingHintGroupType) ((TreeItem) e.item).getData() != null){
							currentMappingHintGroup=(MappingHintGroupType) ((TreeItem) e.item).getData();
							mapping=(Mapping) currentMappingHintGroup.eContainer();
							targets.add(((MappingHintGroupType)currentMappingHintGroup).getTargetMMSection());		
							source=mapping.getSourceMMSection();
							expanded.add(mapping);
							expanded.add(currentMappingHintGroup);
						}
						
					} else if(((TreeItem) e.item).getData() instanceof MappingHintGroupImporter){
						currentMappingHintGroup=(MappingHintGroupImporter) ((TreeItem) e.item).getData();
						mapping=(Mapping) currentMappingHintGroup.eContainer();
						targets.add(((MappingHintGroupImporter)currentMappingHintGroup).getHintGroup().getTargetMMSection());	
						source=mapping.getSourceMMSection();
						expanded.add(mapping);
						expanded.add(currentMappingHintGroup);
					} else if(((TreeItem) e.item).getData() instanceof GlobalAttribute){
						GlobalAttribute g=(GlobalAttribute)(((TreeItem) e.item).getData());
						mapping=(Mapping) g.eContainer();
						if(g.getSource() != null){
							expanded.add(g.getSource());
							source=g.getSource();
						} else{
							source=mapping.getSourceMMSection();								
						}
						
						expanded.add(mapping);
					} else {
						mapping = (Mapping) ((TreeItem) e.item).getData();
						source = mapping.getSourceMMSection();
						
						if(mapping != null){
							expanded.add(mapping);
							for(MappingHintGroupType group : mapping.getMappingHintGroups()){
								targets.add(group.getTargetMMSection());
							}
						}
						
					}
					
					// Expand the mapping in the mapping tree viewer.
					mappingViewer.setExpandedElements(
							expanded.toArray());
					
					// Select and expand the source and target items associated with
					// the selected mapping.
					if(source == null) {
						sourceViewer.setSelection(
								new StructuredSelection());
						if(mapping != currentMapping) {
							sourceViewer.setExpandedElements(
									new Object[]{});
						}
					} else {
						sourceViewer.setSelection(
								new StructuredSelection(source));
						if(mapping != currentMapping) {
							sourceViewer.setExpandedElements(
									new Object[]{source});
						}
					}
					if(targets.isEmpty()) {
						targetViewer.setSelection(
								new StructuredSelection());
						if(mapping != currentMapping) {
							targetViewer.setExpandedElements(
									new Object[]{});
						}
					} else {
						targetViewer.setSelection(
								new StructuredSelection(targets));
						if(mapping != currentMapping) {
							targetViewer.setExpandedElements(
									targets.toArray());
						}
					}
					
					// Update the currently selected mapping.
					currentMapping = mapping;
				}  else if(((TreeItem) e.item).getData() instanceof AttributeMappingSourceElementType 
						&& ! (((TreeItem) e.item).getData()instanceof SimpleAttributeMatcher)
						&& ! (((TreeItem) e.item).getData()instanceof SimpleModelConnectionHint)
						) {
					AttributeMappingSourceElementType mapping = (AttributeMappingSourceElementType) ((TreeItem) e.item).getData();
					
					Attribute target = null;
					
					if(mapping.eContainer() instanceof AttributeMapping){
						target= ((AttributeMapping)mapping.eContainer()).getTarget();
					} else if (mapping instanceof SimpleAttributeMapping){
						target=((SimpleAttributeMapping) mapping).getTarget();
					}
					
					Attribute source = mapping.getSource();
					
					setSourceTargetViewerSingleItemSelections(target,
							source);
				}  else if(((TreeItem) e.item).getData() instanceof GlobalAttributeImporter){
					GlobalAttributeImporter mapping = (GlobalAttributeImporter) ((TreeItem) e.item).getData();
					Attribute target = ((AttributeMapping)mapping.eContainer()).getTarget();
					Attribute source=mapping.getSourceAttribute();
					
					setSourceTargetViewerSingleItemSelections(target, source);
					
					
				} else if(((TreeItem) e.item).getData() instanceof ComplexAttributeMapping || ((TreeItem) e.item).getData() instanceof CalculatorMapping) {
					AttributeMapping mapping = (AttributeMapping) ((TreeItem) e.item).getData();
					Attribute target = mapping.getTarget();
					
					
					List<Attribute> sources = new LinkedList<Attribute>();
					
					if(mapping instanceof ComplexAttributeMapping){							
						for(ComplexAttributeMappingSourceInterface c : ((ComplexAttributeMapping) mapping).getSourceAttributeMappings()){
							if(c.getSourceAttribute() != null){
								sources.add(c.getSourceAttribute());
							}
						}
						
					} else {
						
						for(CalculatorMappingSourceInterface c : ((CalculatorMapping) mapping).getVariables()){
							if(c.getSourceAttribute() != null){
								sources.add(c.getSourceAttribute());
							}
						}
					}
					
					
					
					sourceViewer.setSelection(new StructuredSelection(sources));
					
					if(target == null) {
						targetViewer.setSelection(
								new StructuredSelection());
					} else {
						targetViewer.setSelection(
								new StructuredSelection(target));
					}
					
				} else if(((TreeItem) e.item).getData() instanceof CardinalityMapping) {
					
					CardinalityMapping mapping = (CardinalityMapping) ((TreeItem) e.item).getData();
					
					pamtram.metamodel.Class source = mapping.getSource();
					pamtram.metamodel.Class target = mapping.getTarget();
					
					// Select the source and target item associated with the selected mapping.
					setSourceTargetViewerSingleItemSelections(target, source);
				} else if(((TreeItem) e.item).getData() instanceof MappingInstanceSelector) {
					
					MappingInstanceSelector selector = (MappingInstanceSelector) ((TreeItem) e.item).getData();
					
					NonContainmentReference reference = selector.getAffectedReference();
					
					// Select the reference associated with the selected Mapping Instance Selector.
					if(reference == null) {
						targetViewer.setSelection(
								new StructuredSelection());
					} else {
						targetViewer.setSelection(
								new StructuredSelection(reference));
					}
					sourceViewer.setSelection(new StructuredSelection());
					
				} else if(((TreeItem) e.item).getData() instanceof SimpleAttributeMatcher) {
					
					AttributeMatcher matcher = (AttributeMatcher) ((TreeItem) e.item).getData();
					
					
					TargetSectionAttribute target=matcher.getTargetAttribute();
					SourceSectionAttribute source=null;
					
					if(matcher instanceof SimpleAttributeMatcher){
						source=((SimpleAttributeMatcher) matcher).getSource();
					} else if(matcher instanceof AttributeMappingSourceElementType){
						source=((AttributeMappingSourceElementType) matcher).getSource();
					}
					
					// Select the source and target item associated with the selected matcher.
					setSourceTargetViewerSingleItemSelections(target, source);
					
				} else if(((TreeItem) e.item).getData() instanceof ComplexAttributeMatcher){
					ComplexAttributeMatcher matcher= (ComplexAttributeMatcher) ((TreeItem) e.item).getData();
					
					TargetSectionAttribute target= matcher.getTargetAttribute();
					
					List<SourceSectionAttribute> sources= new LinkedList<SourceSectionAttribute> ();
					
					for(ComplexAttributeMatcherSourceInterface srcElement : matcher.getSourceAttributes()){
						if(srcElement.getSourceAttribute() != null){
							sources.add(srcElement.getSourceAttribute());
						}
					}
					
					sourceViewer.setSelection(new StructuredSelection(sources));
					
					if(target == null){
						targetViewer.setSelection(new StructuredSelection());
					} else {
						targetViewer.setSelection(new StructuredSelection(target));
					}
					
				} else if(((TreeItem) e.item).getData() instanceof ClassMatcher) {
					
					ClassMatcher matcher = (ClassMatcher) ((TreeItem) e.item).getData();
					
					pamtram.metamodel.Class target = matcher.getTargetClass();
					
					// Select the source and target item associated with the selected matcher.
					if(target == null) {
						targetViewer.setSelection(
								new StructuredSelection());
					} else {
						targetViewer.setSelection(
								new StructuredSelection(target));
					}
					sourceViewer.setSelection(new StructuredSelection());
					
				} else if(((TreeItem) e.item).getData() instanceof ModelConnectionHint) {
					
					ModelConnectionHint hint = (ModelConnectionHint) ((TreeItem) e.item).getData();
					
					LinkedList<Attribute> sources = new LinkedList<Attribute>();
					
					if(hint instanceof SimpleModelConnectionHint){
						sources.add(((SimpleModelConnectionHint) hint).getSource());
					} else if(hint instanceof ComplexModelConnectionHint){
						for(ComplexModelConnectionHintSourceInterface sourceElement : ((ComplexModelConnectionHint) hint).getSourceElements() ){
							sources.add(sourceElement.getSourceAttribute());
						}
					}
					
					LinkedList<Attribute> targets = new LinkedList<Attribute>();
					
					
					
					for(ConnectionHintTargetAttribute a : hint.getTargetAttributes()){
						targets.add(a.getTargetAttribute());
					}
					
					// Select the source and target item associated with the selected matcher.
					targetViewer.setSelection(new StructuredSelection(targets));
					sourceViewer.setSelection(new StructuredSelection(sources));
					
				} else if(((TreeItem) e.item).getData() instanceof MappingHintGroupImporter){
					MappingHintGroupImporter imp=(MappingHintGroupImporter) ((TreeItem) e.item).getData();
					TargetSectionClass target=null;
					SourceSectionClass source=null;
					if(imp.getHintGroup() != null){
						target=imp.getHintGroup().getTargetMMSection();
						
						source=((Mapping)imp.getHintGroup().eContainer()).getSourceMMSection();
					}
					setSourceTargetViewerSingleItemSelections(target, source);
				} else if(((TreeItem)e.item).getData() instanceof MappedAttributeValueExpander){
					MappedAttributeValueExpander exp = (MappedAttributeValueExpander)((TreeItem)e.item).getData();
					
					setSourceTargetViewerSingleItemSelections(null, exp.getSourceAttribute());
					
					List<TargetSectionAttribute> attr = new LinkedList<TargetSectionAttribute>();
					for(ExpandableHint m : exp.getHintsToExpand()){
						if(m instanceof AttributeMapping){
							attr.add(((AttributeMapping) m).getTarget());
						} else if(m instanceof AttributeMatcher){
							attr.add(((AttributeMatcher) m).getTargetAttribute());
						}
					}
					targetViewer.setSelection(new StructuredSelection(attr));
					
				}
			}
			private void setSourceTargetViewerSingleItemSelections(
					Object target, Object source) {
				// Select the source and target item associated with  the selected mapping.
				if(source == null) {
					sourceViewer.setSelection(
							new StructuredSelection());
				} else {
					sourceViewer.setSelection(
							new StructuredSelection(source));
				}
				if(target == null) {
					targetViewer.setSelection(
							new StructuredSelection());
				} else {
					targetViewer.setSelection(
							new StructuredSelection(target));
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		});
		
		new AdapterFactoryTreeEditor(mappingViewer.getTree(), adapterFactory);
		
		// Create a group for the attribute value modifier viewer.
		attValModGroup = new Group(mappingSash, SWT.NONE);
		attValModGroup.setText("Modifier Sets and Global Values");
		attValModGroup.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		attValModGroup.setLayout(new GridLayout(1, true));
		
		// Create the mapping tree viewer.
		Tree attValModtree = new Tree(attValModGroup, SWT.MULTI);
		globalElementsViewer = new TreeViewer(attValModtree);
		attValModtree.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
		globalElementsViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory){
			/* extend the content provider in a way that no mappings but only attribute value
			 * modifier sets are returned as children of a mapping model
			 */
			@Override
			public Object[] getElements(Object object) {
				if(object instanceof MappingModel) {
					List<Object> elements=new ArrayList<Object>();
					elements.addAll(((MappingModel) object).getModifierSets());
					elements.addAll(((MappingModel) object).getGlobalValues());
					return elements.toArray();
				}
				return super.getElements(object);
			}
		});
		globalElementsViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		globalElementsViewer.setInput(editor.pamtram.getMappingModel());
		
		attValModtree.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				editor.setCurrentViewer(globalElementsViewer);
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		new AdapterFactoryTreeEditor(globalElementsViewer.getTree(), adapterFactory);
		
		editor.createContextMenuFor(mappingViewer);
		editor.createContextMenuFor(globalElementsViewer);
		
	}
	
	private void createTargetViewer() {
		
		// Create a group for the target tree viewer.
		targetGroup = new Group(this, SWT.NONE);
		targetGroup.setText("Target Sections");
		targetGroup.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		targetGroup.setLayout(new GridLayout(1, true));
		
		// Create the target tree viewer.
		Tree targetTree = new Tree(targetGroup, SWT.MULTI);
		targetViewer = new TreeViewer(targetTree);
		targetTree.setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		
		// add d'n'd support
		{
			int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
			Transfer[] transferTypes = new Transfer[]{LocalTransfer.getInstance()};
			targetViewer.addDragSupport(dndOperations, transferTypes, new MMElementDragListener(targetViewer));
		}
		
		targetViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		targetViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		targetViewer.setInput(editor.pamtram.getTargetSectionModel());
		targetTree.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editor.setCurrentViewer(targetViewer);
				
				// if a non containment reference has been selected while holding down the
				// control key, jump to the referenced class 
				if(((TreeItem) e.item).getData() instanceof MetaModelSectionReference) {
					
					MetaModelSectionReference reference = (MetaModelSectionReference) ((TreeItem) e.item).getData();
					
					EList<pamtram.metamodel.SourceSectionClass> referencedElements = reference.getValue();
					
					if(reference != null && e.stateMask == SWT.CTRL) {
						targetViewer.setSelection(
								new StructuredSelection(referencedElements.toArray()));
					}
				} else 	if(((TreeItem) e.item).getData() instanceof TargetSectionNonContainmentReference) {
					
					TargetSectionNonContainmentReference reference = (TargetSectionNonContainmentReference) ((TreeItem) e.item).getData();
					
					EList<pamtram.metamodel.TargetSectionClass> referencedElements = reference.getValue();
					
					if(reference != null && e.stateMask == SWT.CTRL) {
						targetViewer.setSelection(
								new StructuredSelection(referencedElements.toArray()));
					}
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		new AdapterFactoryTreeEditor(targetViewer.getTree(), adapterFactory);
	
		editor.createContextMenuFor(targetViewer);
		
	}
	
}
