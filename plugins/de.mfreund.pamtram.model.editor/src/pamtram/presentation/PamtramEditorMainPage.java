package pamtram.presentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TreeItem;

import pamtram.MappingModel;
import pamtram.NamedElement;
import pamtram.TargetSectionModel;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
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
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModelConnectionHintTargetAttribute;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.presentation.widgets.TreeViewerGroup;
import de.mfreund.pamtram.util.BundleContentHelper;
import de.mfreund.pamtram.util.SelectionListener2;
import de.mfreund.pamtram.wizards.ImportLibraryElementWizard;

public class PamtramEditorMainPage extends SashForm {
	
	private final String bundleID = PamtramEditorPlugin.getPlugin().getSymbolicName();
	
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
	protected TreeViewer sourceViewer = null;
	
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
	
	/**
	 * This is the group for the library element tree viewer.
	 */
	protected Group libTargetGroup;

	/**
	 * This is the the viewer for the library element meta model sections.
	 */
	protected TreeViewer libTargetViewer;

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
		
		// Create the viewer for the source sections.
		//
		
		sourceViewer = new TreeViewerGroup(
				this, adapterFactory, editor.getEditingDomain(),
				"Source Sections", null, null, true, true
			).getViewer();
		sourceViewer.setInput(editor.pamtram.getSourceSectionModel());
		sourceViewer.getTree().addSelectionListener(new SelectionListener() {
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
		
		// Create the viewer for the source sections.
		//

		mappingViewer = new TreeViewerGroup(
				mappingSash, adapterFactory, editor.getEditingDomain(),
				"Mappings", null, null, true, true
			).getViewer();
		
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
		mappingViewer.setInput(editor.pamtram.getMappingModel());
		mappingViewer.getTree().addSelectionListener(new SelectionListener() {
			
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
						currentMappingHintGroup = (NamedElement) ((TreeItem) e.item).getData();
						mapping=(Mapping) currentMappingHintGroup.eContainer();
						if(((MappingHintGroupImporter)currentMappingHintGroup).getHintGroup() != null) {
							targets.add(((MappingHintGroupImporter)currentMappingHintGroup).getHintGroup().getTargetMMSection());	
						}
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
				}  else if(((TreeItem) e.item).getData() instanceof ModifiedAttributeElementType<?>) {
					@SuppressWarnings("unchecked")
					ModifiedAttributeElementType<Attribute> mapping = 
							(ModifiedAttributeElementType<Attribute>) ((TreeItem) e.item).getData();
					
					Attribute target = null;
					
					if(mapping.eContainer() instanceof AttributeMapping){
						target= ((AttributeMapping)mapping.eContainer()).getTarget();
					}
					
					Attribute source = mapping.getSource();
					
					setSourceTargetViewerSingleItemSelections(target,
							source);
				}  else if(((TreeItem) e.item).getData() instanceof GlobalAttributeImporter){
					GlobalAttributeImporter mapping = (GlobalAttributeImporter) ((TreeItem) e.item).getData();
					Attribute target = ((AttributeMapping)mapping.eContainer()).getTarget();
					Attribute source=mapping.getSourceAttribute();
					
					setSourceTargetViewerSingleItemSelections(target, source);
					
					
				} else if(((TreeItem) e.item).getData() instanceof AttributeMapping) {
					AttributeMapping mapping = (AttributeMapping) ((TreeItem) e.item).getData();
					Attribute target = mapping.getTarget();
					
					
					List<Attribute> sources = new LinkedList<Attribute>();
					
						for(AttributeMappingSourceInterface c : mapping.getSourceAttributeMappings()){
							if(c.getSourceAttribute() != null){
								sources.add(c.getSourceAttribute());
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
					
				} else if(((TreeItem) e.item).getData() instanceof AttributeMatcher){
					AttributeMatcher matcher= (AttributeMatcher) ((TreeItem) e.item).getData();
					
					TargetSectionAttribute target= matcher.getTargetAttribute();
					
					List<SourceSectionAttribute> sources= new LinkedList<SourceSectionAttribute> ();
					
					for(AttributeMatcherSourceInterface srcElement : matcher.getSourceAttributes()){
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
					LinkedList<Attribute> targets = new LinkedList<Attribute>();
					
					for(ModelConnectionHintSourceInterface sourceElement : hint.getSourceElements() ){
						sources.add(sourceElement.getSourceAttribute());
					}
					
					for(ModelConnectionHintTargetAttribute a : hint.getTargetAttributes()){
						targets.add(a.getSource());
					}
					
					// Select the source and target item associated with the selected matcher.
					targetViewer.setSelection(new StructuredSelection(targets));
					sourceViewer.setSelection(new StructuredSelection(sources));
					
				} else if(((TreeItem) e.item).getData() instanceof ConnectionHintTargetAttribute){
					ConnectionHintTargetAttribute a=(ConnectionHintTargetAttribute) ((TreeItem) e.item).getData();
					setSourceTargetViewerSingleItemSelections(a.getTargetAttribute(), null);
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
		
		editor.setCurrentViewer(mappingViewer);
		
		// Create the viewer for the attribute value modifier sets.
		//
		
		globalElementsViewer = new TreeViewerGroup(
				mappingSash, adapterFactory, editor.getEditingDomain(), 
				"Modifier Sets and Global Values", null, null, true, true
			).getViewer();
		
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
		globalElementsViewer.setInput(editor.pamtram.getMappingModel());
		
		globalElementsViewer.getTree().addSelectionListener(new SelectionListener() {
			
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
		
		// Create a sash form to host the target section and the library element view
		SashForm targetSash = new SashForm(this, SWT.NONE | SWT.VERTICAL);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			targetSash.setLayoutData(data);
		}
		
		
		// Create the viewer for the target sections.
		//
		
		targetViewer = new TreeViewerGroup(
				targetSash, adapterFactory, editor.getEditingDomain(),
				"Target Sections", null, null, true, true
			).getViewer();
		
		targetViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {
			/* extend the content provider in a way that no library elements 
			 * but only classic target section are returned as children of a mapping model
			 */
			@Override
			public Object[] getElements(Object object) {
				if(object instanceof TargetSectionModel) {
					return ((TargetSectionModel) object).getMetaModelSections().toArray();
				}
				return super.getElements(object);
			}
		});
		targetViewer.setInput(editor.pamtram.getTargetSectionModel());
		targetViewer.getTree().addSelectionListener(new SelectionListener() {
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
		
		// Create the viewer for the library element target sections.
		//
		
		libTargetViewer = new TreeViewerGroup(
				targetSash, adapterFactory, editor.getEditingDomain(), 
				"Library Element Target Sections", null, null, true, false){
				@Override
				protected void createAdditionalToolbarItems(org.eclipse.swt.widgets.ToolBar toolbar) {
					ToolItem item = new ToolItem(toolbar, SWT.PUSH);
					item.setImage(BundleContentHelper.getBundleImage(bundleID, "icons/import_wiz.gif"));
					item.addSelectionListener(new SelectionListener2() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							System.out.println("importing");
							// create the wizard
							WizardDialog wizardDialog = new WizardDialog(
									new Shell(), 
									new ImportLibraryElementWizard(editor.pamtram, editor.getEditingDomain()));
							wizardDialog.create();
							wizardDialog.open();
						}
					});
				};
			}.getViewer();
		
		libTargetViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory) {
			/* extend the content provider in a way that only library elements 
			 * but no classic target section are returned as children of a mapping model
			 */
			@Override
			public Object[] getElements(Object object) {
				if(object instanceof TargetSectionModel) {
					return ((TargetSectionModel) object).getLibraryElements().toArray();
				}
				return super.getElements(object);
			}
			@Override
			public Object[] getChildren(Object object) {
				Object[] children = super.getChildren(object);
				if(object instanceof LibraryEntry) {
					Object[] newChildren = new Object[children.length+1];
					// add the LibraryItem to the children
					newChildren[0] = ((LibraryEntry) object).getOriginalLibraryEntry().getLibraryItem();
					System.arraycopy(children, 0, newChildren, 1, children.length);
					return newChildren;
				}
				return children;
			}
		});
		libTargetViewer.setInput(editor.pamtram.getTargetSectionModel());
		libTargetViewer.getTree().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editor.setCurrentViewer(libTargetViewer);
				
				// if a non containment reference has been selected while holding down the
				// control key, jump to the referenced class 
				if(((TreeItem) e.item).getData() instanceof MetaModelSectionReference) {
					
					MetaModelSectionReference reference = (MetaModelSectionReference) ((TreeItem) e.item).getData();
					
					EList<pamtram.metamodel.SourceSectionClass> referencedElements = reference.getValue();
					
					if(reference != null && e.stateMask == SWT.CTRL) {
						libTargetViewer.setSelection(
								new StructuredSelection(referencedElements.toArray()));
					}
				} else 	if(((TreeItem) e.item).getData() instanceof TargetSectionNonContainmentReference) {
					
					TargetSectionNonContainmentReference reference = (TargetSectionNonContainmentReference) ((TreeItem) e.item).getData();
					
					EList<pamtram.metamodel.TargetSectionClass> referencedElements = reference.getValue();
					
					if(reference != null && e.stateMask == SWT.CTRL) {
						libTargetViewer.setSelection(
								new StructuredSelection(referencedElements.toArray()));
					}
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		new AdapterFactoryTreeEditor(libTargetViewer.getTree(), adapterFactory);
	
		editor.createContextMenuFor(libTargetViewer);
		
	}
	
}
