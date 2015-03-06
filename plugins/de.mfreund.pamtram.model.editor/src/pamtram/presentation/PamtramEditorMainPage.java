package pamtram.presentation;

import java.util.AbstractCollection;
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
import pamtram.metamodel.ContainerParameter;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
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
		mappingViewer.getTree().addSelectionListener(new SelectionListener2() {
			
			/**
			 * This keeps track of the mapping that is currently selected. It is used to
			 * determine if the 'expanded' state of a mapping is to be reset (in case
			 * a elements from a different mapping are selected).
			 */
			private Mapping currentMapping;
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				editor.setCurrentViewer(mappingViewer);
				
				TreeItem item = (TreeItem) e.item;
				
				if(item.getData() instanceof Mapping
						|| item.getData() instanceof MappingHintGroupType
						|| item.getData() instanceof MappingHintGroupImporter
						|| item.getData() instanceof GlobalAttribute
						) {
					
					/*
					 * This keeps track of the elements to be expanded in the mapping viewer. 
					 */
					LinkedList<Object> expanded = new LinkedList<Object>();
					
					/*
					 * This keeps track of the (parent) mapping of the currently selected element.
					 */
					Mapping mapping = null;
					
					/*
					 * This keeps track of the element in the source viewer that corresponds to the currently selected element.
					 */
					Object source = null;
					
					/*
					 * This keeps track of the elements in the target viewer that correspond to the currently selected element.
					 */
					LinkedList<pamtram.metamodel.Class> targets = new LinkedList<>();
					
					/*
					 * This keeps track of the elements in the library target viewer that correspond to the currently selected element.
					 */
					ArrayList<Object> libraryTargets = new ArrayList<>();
					
					/*
					 * If a MappingHintGroup is selected, expand the hint group itself and the parent Mapping.
					 * Additionally, select corresponding source and target sections.
					 */
					if(item.getData() instanceof MappingHintGroupType){
						MappingHintGroupType hintGroup = (MappingHintGroupType) item.getData();
						mapping = (Mapping) hintGroup.eContainer();
						source = mapping.getSourceMMSection();
						TargetSectionClass target = hintGroup.getTargetMMSection(); 
						if(target.eContainer() instanceof TargetSectionModel) {
							targets.add(target);	
						} else if(target.eContainer() instanceof ContainerParameter) {
							libraryTargets.add(target);
						}
						expanded.add(mapping);
						expanded.add(hintGroup);
						
					/*
					 * If a MappingHintGroup is selected, expand the importer itself and the parent mapping.
					 * Additionally, select corresponding source and target sections of the importer/of the 
					 * imported hint group.
					 */
					} else if(item.getData() instanceof MappingHintGroupImporter){
						MappingHintGroupImporter hintGroupImporter = (MappingHintGroupImporter) item.getData();
						mapping = (Mapping) hintGroupImporter.eContainer();
						source = mapping.getSourceMMSection();
						if(hintGroupImporter.getHintGroup() != null) {
							TargetSectionClass target = hintGroupImporter.getHintGroup().getTargetMMSection(); 
							if(target.eContainer() instanceof TargetSectionModel) {
								targets.add(target);	
							} else if(target.eContainer() instanceof ContainerParameter) {
								libraryTargets.add(target);
							}
						}
						expanded.add(mapping);
						expanded.add(hintGroupImporter);
						
					/*
					 * If a GlobalAttribute is selected, expand the attribute itself and the parent mapping.
					 * Additionally, select the corresponding source attribute.
					 */
					} else if(item.getData() instanceof GlobalAttribute){
						GlobalAttribute g = (GlobalAttribute) (item.getData());
						mapping = (Mapping) g.eContainer();
						if(g.getSource() != null){
							source = g.getSource();
						} else{
							source = mapping.getSourceMMSection();								
						}
						expanded.add(mapping);
						expanded.add(g);
						
					/*
					 * If a Mapping is selected, expand the mapping itself.
					 * Additionally, select the source of the mapping and the targets of the hint groups.
					 */
					} else {
						mapping = (Mapping) item.getData();
						source = mapping.getSourceMMSection();
						
						if(mapping != null){
							expanded.add(mapping);
							for(MappingHintGroupType group : mapping.getMappingHintGroups()){
								if(group.getTargetMMSection() != null) {
									TargetSectionClass target = group.getTargetMMSection(); 
									if(target.eContainer() instanceof TargetSectionModel) {
										targets.add(target);	
									} else if(target.eContainer() instanceof ContainerParameter) {
										libraryTargets.add(target);
									}
								}
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
					if(libraryTargets.isEmpty()) {
						libTargetViewer.setSelection(
								new StructuredSelection());
						if(mapping != currentMapping) {
							libTargetViewer.setExpandedElements(
									new Object[]{});
						}
					} else {
						libTargetViewer.setSelection(
								new StructuredSelection(libraryTargets));
						if(mapping != currentMapping) {
							libTargetViewer.setExpandedElements(
									libraryTargets.toArray());
							/* this second selection is a quirk that is necessary because of the virtual 'ParameterDescription'
							 * that prevents the expansion to work at the first try 
							 */
							libTargetViewer.setSelection(
									new StructuredSelection(libraryTargets));
						}
					}
					// Update the currently selected mapping.
					currentMapping = mapping;
					
				/*
				 * If a ModifiedAttributeElementType is selected, select the source attribute that
				 * it represents and the target attribute of a possible parent AttributeMapping.
				 */
				}  else if(item.getData() instanceof ModifiedAttributeElementType<?>) {
					@SuppressWarnings("unchecked")
					ModifiedAttributeElementType<Attribute> modifiedAttribute = 
							(ModifiedAttributeElementType<Attribute>) item.getData();
					
					Attribute target = null;
					if(modifiedAttribute.eContainer() instanceof AttributeMapping){
						target = ((AttributeMapping) modifiedAttribute.eContainer()).getTarget();
					}
					
					Attribute source = modifiedAttribute.getSource();
					
					setSourceTargetViewerSelections(source, target);
					
				/*
				 * If a GlobalAttributeImporter is selected, select the source attribute that
				 * it imports and the target attribute of a possible parent AttributeMapping.
				 */
				}  else if(item.getData() instanceof GlobalAttributeImporter){
					GlobalAttributeImporter importer = (GlobalAttributeImporter) item.getData();
					Attribute target = ((AttributeMapping) importer.eContainer()).getTarget();
					Attribute source = importer.getSourceAttribute();
					
					setSourceTargetViewerSelections(source, target);
					
				/*
				 * If an AttributeMapping is selected, select all source attributes and the 
				 * target attribute.
				 */
				} else if(item.getData() instanceof AttributeMapping) {
					AttributeMapping mapping = (AttributeMapping) item.getData();
					Attribute target = mapping.getTarget();
					
					List<Attribute> sources = new LinkedList<Attribute>();
					for(AttributeMappingSourceInterface c : mapping.getSourceAttributeMappings()){
						if(c.getSourceAttribute() != null){
							sources.add(c.getSourceAttribute());
						}
					}
						
					setSourceTargetViewerSelections(sources, target);
					
				/*
				 * If a CardinalityMapping is selected, select its source and target classes.
				 */
				} else if(item.getData() instanceof CardinalityMapping) {
					
					CardinalityMapping mapping = (CardinalityMapping) item.getData();
					
					pamtram.metamodel.Class source = mapping.getSource();
					pamtram.metamodel.Class target = mapping.getTarget();
					
					setSourceTargetViewerSelections(source, target);
					
				/*
				 * If a MappingInstanceSelector is selected, select the target reference that it points to.	
				 */
				} else if(item.getData() instanceof MappingInstanceSelector) {
					
					MappingInstanceSelector selector = (MappingInstanceSelector) item.getData();
					
					NonContainmentReference reference = selector.getAffectedReference();
					
					setSourceTargetViewerSelections(null, reference);
					
				/*
				 * If an AttributeMatcher is selected, select its source and target attributes.
				 */
				} else if(item.getData() instanceof AttributeMatcher){
					AttributeMatcher matcher= (AttributeMatcher) item.getData();
					
					TargetSectionAttribute target= matcher.getTargetAttribute();
					
					List<SourceSectionAttribute> sources= new LinkedList<SourceSectionAttribute>();
					
					for(AttributeMatcherSourceInterface srcElement : matcher.getSourceAttributes()){
						if(srcElement.getSourceAttribute() != null){
							sources.add(srcElement.getSourceAttribute());
						}
					}
					
					setSourceTargetViewerSelections(sources, target);
				
				/*
				 * If a ClassMatcher is selected, select the source and target classes associated with it.
				 */
				} else if(item.getData() instanceof ClassMatcher) {
					
					ClassMatcher matcher = (ClassMatcher) item.getData();
					
					pamtram.metamodel.Class target = matcher.getTargetClass();
					
					setSourceTargetViewerSelections(null, target);
					
				/*
				 * If a ModelConnectionHint is selected, Select the source and target item 
				 * associated with the selected matcher.
				 */
				} else if(item.getData() instanceof ModelConnectionHint) {
					
					ModelConnectionHint hint = (ModelConnectionHint) item.getData();
					
					ArrayList<Attribute> sources = new ArrayList<>();
					ArrayList<Attribute> targets = new ArrayList<>();
					
					for(ModelConnectionHintSourceInterface sourceElement : hint.getSourceElements() ){
						sources.add(sourceElement.getSourceAttribute());
					}
					
					for(ModelConnectionHintTargetAttribute a : hint.getTargetAttributes()){
						targets.add(a.getSource());
					}
					
					setSourceTargetViewerSelections(sources, targets);
					
				/*
				 * If a ConnectionHintTargetAttribute is selected, select its specified 
				 * target attribute.
				 */
				} else if(item.getData() instanceof ConnectionHintTargetAttribute){
					ConnectionHintTargetAttribute a = (ConnectionHintTargetAttribute) item.getData();
					setSourceTargetViewerSelections(null, a.getTargetAttribute());
					
				/*
				 * If a MappedAttributeValueExpander is selected, select ist source attribute and
				 * the targets of all associated expandable hints.
				 */
				} else if(((TreeItem)e.item).getData() instanceof MappedAttributeValueExpander){
					MappedAttributeValueExpander exp = (MappedAttributeValueExpander) item.getData();
					
					List<TargetSectionAttribute> attr = new ArrayList<TargetSectionAttribute>();
					for(ExpandableHint m : exp.getHintsToExpand()){
						if(m instanceof AttributeMapping){
							attr.add(((AttributeMapping) m).getTarget());
						} else if(m instanceof AttributeMatcher){
							attr.add(((AttributeMatcher) m).getTargetAttribute());
						}
					}

					setSourceTargetViewerSelections(exp.getSourceAttribute(), attr);
					
				}
			}
			
			/**
			 * This is a convenience method to select elements in the source viewer and in the target/library target {@link TreeViewer}.
			 * The method automatically determines if the target element(s) is/are located in the target viewer or in the library target viewer
			 * and performs the appropriate selection.
			 * 
			 * @param source The object(s) to be selected in the source viewer (or null if nothing is to be selected).
			 * 					This may be a single object or an {@link AbstractCollection} of objects.
			 * @param target The object(s) to be selected in the target (or library target) viewer (or null if nothing is to be selected).
			 * 					This may be a single object or an {@link AbstractCollection} of objects.
			 */
			private void setSourceTargetViewerSelections(
					Object source, Object target) {
				if(source == null) {
					sourceViewer.setSelection(
							new StructuredSelection());
				} else {
					if(source instanceof AbstractCollection<?>) {
						sourceViewer.setSelection(
								new StructuredSelection(((AbstractCollection<?>) source).toArray()));
					} else {
						sourceViewer.setSelection(
								new StructuredSelection(source));						
					}
				}
				if(target == null) {
					targetViewer.setSelection(
							new StructuredSelection());
					libTargetViewer.setSelection(
							new StructuredSelection());
				} else {
					/* as the target(s) may either be located in target sections or in a library entries,
					 * we simply set the selection in both viewers (knowing that only one will succeed)  
					 */
					if(target instanceof AbstractCollection<?>) {
						targetViewer.setSelection(
								new StructuredSelection(((AbstractCollection<?>) target).toArray()));
						libTargetViewer.setSelection(
								new StructuredSelection(((AbstractCollection<?>) target).toArray()));
					} else {
						targetViewer.setSelection(
								new StructuredSelection(target));
						libTargetViewer.setSelection(
								new StructuredSelection(target));
					}
				}
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
