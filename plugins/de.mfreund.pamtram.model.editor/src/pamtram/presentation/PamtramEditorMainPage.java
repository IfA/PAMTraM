package pamtram.presentation;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.TreeItem;
import de.mfreund.pamtram.util.BundleContentHelper;
import de.mfreund.pamtram.util.SelectionListener2;
import de.mfreund.pamtram.wizards.ImportLibraryElementWizard;
import pamtram.TargetSectionModel;
import pamtram.contentadapter.DeactivationListenerAdapter;
import pamtram.contentprovider.LibraryEntryContentProvider;
import pamtram.contentprovider.MappingContentProvider;
import pamtram.contentprovider.ModifierSetContentProvider;
import pamtram.contentprovider.SourceSectionContentProvider;
import pamtram.contentprovider.TargetSectionContentProvider;
import pamtram.listeners.SetViewerMouseListener;
import pamtram.listeners.SetViewerSelectionListener;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ConnectionHintTargetAttribute;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.LocalMappedAttributeValueExpander;
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
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.presentation.widgets.MinimizableSashForm;
import pamtram.presentation.widgets.MinimizableTreeViewerGroup;
import pamtram.presentation.widgets.TreeViewerGroup;

public class PamtramEditorMainPage extends SashForm implements IPersistable {

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
	 * The {@link TreeViewerGroup} for the mappings.
	 */
	protected TreeViewerGroup mappingViewerGroup;
	
	/**
	 * This is the the viewer for the mappings.
	 */
	protected TreeViewer mappingViewer;

	/**
	 * This is the group for the att val modifier set tree viewer.
	 */
	protected Group attValModGroup;

	/**
	 * The {@link TreeViewerGroup} for the att val modifier sets.
	 */
	protected TreeViewerGroup globalElementsViewerGroup;
	
	/**
	 * This is the the viewer for the att val modifier sets.
	 */
	protected TreeViewer globalElementsViewer;

	/**
	 * This is the group for the target tree viewer.
	 */
	protected Group targetGroup;

	/**
	 * The {@link TreeViewerGroup} for the target meta model sections.
	 */
	protected TreeViewerGroup targetViewerGroup;
	
	/**
	 * This is the the viewer for the target meta model sections.
	 */
	protected TreeViewer targetViewer;
	
	/**
	 * The {@link TreeViewerGroup} for the library target meta model sections.
	 */
	protected TreeViewerGroup libTargetViewerGroup;

	/**
	 * This is the group for the library element tree viewer.
	 */
	protected Group libTargetGroup;

	/**
	 * This is the the viewer for the library element meta model sections.
	 */
	protected TreeViewer libTargetViewer;

	/**
	 * This is a special content adapter that will refresh the viewer when an element
	 * gets (de-)activated. Otherwise, the updates to the label and its colors are
	 * not reflected properly.
	 */
	protected DeactivationListenerAdapter deactivationListener;

	/**
	 * The {@link MinimizableSashForm} containing the {@link #mappingViewerGroup} and the {@link #globalElementsViewerGroup}.
	 */
	protected MinimizableSashForm mappingSash;

	/**
	 * The {@link MinimizableSashForm} containing the {@link #targetViewerGroup} and the {@link #libTargetViewerGroup}.
	 */
	protected MinimizableSashForm targetSash;

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
		sourceViewer.setContentProvider(new SourceSectionContentProvider(adapterFactory));
		sourceViewer.setInput(editor.pamtram);
		sourceViewer.getTree().addSelectionListener(new SourceViewerSelectionListener());
		sourceViewer.getTree().addMouseListener(new SetViewerMouseListener(editor, sourceViewer));
		
		new AdapterFactoryTreeEditor(sourceViewer.getTree(), adapterFactory);
		editor.createContextMenuFor(sourceViewer);
	}


	private void createMappingViewer() {
	
		mappingSash = new MinimizableSashForm(this,SWT.NONE | SWT.VERTICAL);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			mappingSash.setLayoutData(data);
		}
	
		// Create the viewer for the source sections.
		//
	
		mappingViewerGroup = new MinimizableTreeViewerGroup(
				mappingSash, adapterFactory, editor.getEditingDomain(),
				"Mappings", null, null, true, true
				);
		mappingViewer = mappingViewerGroup.getViewer();
		/*
		 * We add a special content adapter that will refresh the viewer when an element
		 * gets (de-)activated. Otherwise, the updates to the label and its colors are
		 * not reflected properly.
		 */
		deactivationListener = new DeactivationListenerAdapter(editor.getPamtramContentAdapter(), mappingViewer);
		editor.getPamtramContentAdapter().addSubAdapter(deactivationListener);
		/*
		 * Use a special content provider.
		 */
		mappingViewer.setContentProvider(new MappingContentProvider(adapterFactory));
		mappingViewer.setInput(editor.pamtram);
		mappingViewer.getTree().addSelectionListener(new MappingViewerSelectionListener());
		mappingViewer.getTree().addMouseListener(new SetViewerMouseListener(editor, mappingViewer));
		
		new AdapterFactoryTreeEditor(mappingViewer.getTree(), adapterFactory);
	
		editor.setCurrentViewer(mappingViewer);
	
		// Create the viewer for the attribute value modifier sets.
		//
	
		globalElementsViewerGroup = new MinimizableTreeViewerGroup(
				mappingSash, adapterFactory, editor.getEditingDomain(), 
				"Modifier Sets and Global Values", null, null, true, true);
		globalElementsViewer = globalElementsViewerGroup.getViewer();
	
		globalElementsViewer.setContentProvider(new ModifierSetContentProvider(adapterFactory));
		globalElementsViewer.setInput(editor.pamtram);
	
		globalElementsViewer.getTree().addSelectionListener(new SetViewerSelectionListener(editor, globalElementsViewer));
		globalElementsViewer.getTree().addMouseListener(new SetViewerMouseListener(editor, globalElementsViewer));
	
		new AdapterFactoryTreeEditor(globalElementsViewer.getTree(), adapterFactory);
	
		editor.createContextMenuFor(mappingViewer);
		editor.createContextMenuFor(globalElementsViewer);
	
	}


	private void createTargetViewer() {
	
		targetSash = new MinimizableSashForm(this, SWT.NONE | SWT.VERTICAL);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			targetSash.setLayoutData(data);
		}
	
	
		// Create the viewer for the target sections.
		//
		targetViewerGroup = new MinimizableTreeViewerGroup(
				targetSash, adapterFactory, editor.getEditingDomain(),
				"Target Sections", null, null, true, true
				);
		targetViewer = targetViewerGroup.getViewer();
	
		targetViewer.setContentProvider(new TargetSectionContentProvider(adapterFactory));
		targetViewer.setInput(editor.pamtram);
		targetViewer.getTree().addSelectionListener(new TargetViewerSelectionListener());
		targetViewer.getTree().addMouseListener(new SetViewerMouseListener(editor, targetViewer));
	
		new AdapterFactoryTreeEditor(targetViewer.getTree(), adapterFactory);
	
		editor.createContextMenuFor(targetViewer);
	
		// Create the viewer for the library element target sections.
		//
		libTargetViewerGroup = new MinimizableTreeViewerGroup(
				targetSash, adapterFactory, editor.getEditingDomain(), 
				"Library Element Target Sections", null, null, true, false){
			@Override
			protected void createAdditionalToolbarItems(org.eclipse.swt.widgets.ToolBar toolbar) {
				
				// import library entries
				ToolItem item = new ToolItem(toolbar, SWT.PUSH);
				item.setImage(BundleContentHelper.getBundleImage(bundleID, "icons/import_wiz.gif"));
				item.setToolTipText("Import Library Item");
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
				
				super.createAdditionalToolbarItems(toolbar);
			};
		};
		libTargetViewer = libTargetViewerGroup.getViewer();
	
		libTargetViewer.setContentProvider(new LibraryEntryContentProvider(adapterFactory));
		libTargetViewer.setInput(editor.pamtram);
		libTargetViewer.getTree().addSelectionListener(new SetViewerSelectionListener(editor, libTargetViewer));
		libTargetViewer.getTree().addMouseListener(new SetViewerMouseListener(editor, libTargetViewer));
	
		new AdapterFactoryTreeEditor(libTargetViewer.getTree(), adapterFactory);
	
		editor.createContextMenuFor(libTargetViewer);
	
	}

	/**
	 * A {@link SourceViewerSelectionListener} that handles selections in the {@link PamtramEditorMainPage#sourceViewer}.
	 * <p />
	 * It automatically expands referenced {@link SourceSectionClass SourceSectionClasses} if a {@link MetaModelSectionReference}
	 * is selected.
	 * 
	 * @author mfreund
	 */
	private final class SourceViewerSelectionListener extends SetViewerSelectionListener {
		
		private SourceViewerSelectionListener() {
			super(editor, sourceViewer);
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			super.widgetSelected(e);
	
			if(((TreeItem) e.item).getData() instanceof MetaModelSectionReference) {
	
				MetaModelSectionReference reference = (MetaModelSectionReference) ((TreeItem) e.item).getData();
	
				EList<pamtram.metamodel.SourceSectionClass> referencedElements = reference.getValue();
	
				// if a non containment reference has been selected while holding down the
				// control key, jump to the referenced class 
				if(reference != null && e.stateMask == SWT.CTRL) {
					sourceViewer.setSelection(
							new StructuredSelection(referencedElements.toArray()));
				}
			}
		}
	}

	/**
	 * A {@link SourceViewerSelectionListener} that handles selections in the {@link PamtramEditorMainPage#mappingViewer}.
	 * <p />
	 * It automatically expands referenced elements. For example, if an {@link AttributeMapping} is selected, the
	 * associated source and target elements are expanded so that the user can easily determine those.
	 * 
	 * @author mfreund
	 */
	private final class MappingViewerSelectionListener extends SetViewerSelectionListener {
		
		/**
		 * This keeps track of the mapping that is currently selected. It is used to
		 * determine if the 'expanded' state of a mapping is to be reset (in case
		 * a elements from a different mapping are selected).
		 */
		private Mapping currentMapping;
		
		private MappingViewerSelectionListener() {
			super(editor, mappingViewer);
		}
	
		@Override
		public void widgetSelected(SelectionEvent e) {
			super.widgetSelected(e);
	
			TreeItem item = (TreeItem) e.item;
	
			if(item.getData() instanceof Mapping
					|| item.getData() instanceof MappingHintGroupType
					|| item.getData() instanceof MappingHintGroupImporter
					|| item.getData() instanceof GlobalAttribute
					) {
	
				/*
				 * This keeps track of the elements to be expanded in the mapping viewer. 
				 */
				LinkedList<Object> expanded = new LinkedList<>(Arrays.asList(mappingViewer.getExpandedElements()));
	
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
				LinkedList<pamtram.metamodel.Class<?, ?, ?, ?>> targets = new LinkedList<>();
	
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
					if(target != null) {
						if(target.eContainer() instanceof ContainerParameter) {
							libraryTargets.add(target);
						} else {
							targets.add(target);	
						}							
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
						if(target != null) {
							if(target.eContainer() instanceof ContainerParameter) {
								libraryTargets.add(target);
							} else {
								targets.add(target);
							}
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
								if(target.eContainer() instanceof ContainerParameter) {
									libraryTargets.add(target);
								} else {
									targets.add(target);
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
				} else {
					sourceViewer.setSelection(
							new StructuredSelection(source));
					if(mapping != currentMapping) {
						ArrayList<Object> newExpansion = new ArrayList<>(Arrays.asList(sourceViewer.getExpandedElements()));
						newExpansion.add(source);
						sourceViewer.setExpandedElements(newExpansion.toArray());
					}
				}
				if(targets.isEmpty()) {
					targetViewer.setSelection(
							new StructuredSelection());
				} else {
					targetViewer.setSelection(
							new StructuredSelection(targets));
					if(mapping != currentMapping) {
						ArrayList<Object> newExpansion = new ArrayList<>(Arrays.asList(targetViewer.getExpandedElements()));
						newExpansion.addAll(targets);
						targetViewer.setExpandedElements(newExpansion.toArray());
					}
				}
				if(libraryTargets.isEmpty()) {
					libTargetViewer.setSelection(
							new StructuredSelection());
				} else {
					libTargetViewer.setSelection(
							new StructuredSelection(libraryTargets));
					if(mapping != currentMapping) {
						ArrayList<Object> newExpansion = new ArrayList<>(Arrays.asList(libTargetViewer.getExpandedElements()));
						newExpansion.addAll(libraryTargets);
						libTargetViewer.setExpandedElements(newExpansion.toArray());
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
			}  else if(item.getData() instanceof ModifiedAttributeElementType<?,?,?,?>) {
				ModifiedAttributeElementType<?,?,?,?> modifiedAttribute = 
						(ModifiedAttributeElementType<?,?,?,?>) item.getData();
	
				Attribute<?, ?, ?, ?> target = null;
				if(modifiedAttribute.eContainer() instanceof AttributeMapping){
					target = ((AttributeMapping) modifiedAttribute.eContainer()).getTarget();
				}
	
				Attribute<?, ?, ?, ?> source = modifiedAttribute.getSource();
	
				setSourceTargetViewerSelections(source, target);
	
				/*
				 * If a GlobalAttributeImporter is selected, select the source attribute that
				 * it imports and the target attribute of a possible parent AttributeMapping.
				 */
			}  else if(item.getData() instanceof GlobalAttributeImporter){
				GlobalAttributeImporter importer = (GlobalAttributeImporter) item.getData();
				Attribute<?, ?, ?, ?> target = ((AttributeMapping) importer.eContainer()).getTarget();
				Attribute<?, ?, ?, ?> source = importer.getSourceAttribute();
	
				setSourceTargetViewerSelections(source, target);
	
				/*
				 * If an AttributeMapping is selected, select all source attributes and the 
				 * target attribute.
				 */
			} else if(item.getData() instanceof AttributeMapping) {
				AttributeMapping mapping = (AttributeMapping) item.getData();
				Attribute<?, ?, ?, ?> target = mapping.getTarget();
	
				List<Attribute<?, ?, ?, ?>> sources = new LinkedList<>();
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
	
				pamtram.metamodel.Class<?, ?, ?, ?> source = mapping.getSource();
				pamtram.metamodel.Class<?, ?, ?, ?> target = mapping.getTarget();
	
				setSourceTargetViewerSelections(source, target);
	
				/*
				 * If a MappingInstanceSelector is selected, select the target reference that it points to.	
				 */
			} else if(item.getData() instanceof MappingInstanceSelector) {
	
				MappingInstanceSelector selector = (MappingInstanceSelector) item.getData();
	
				NonContainmentReference<?, ?, ?, ?> reference = selector.getAffectedReference();
	
				setSourceTargetViewerSelections(null, reference);
	
				/*
				 * If an AttributeMatcher is selected, select its source and target attributes.
				 */
			} else if(item.getData() instanceof AttributeMatcher){
				AttributeMatcher matcher= (AttributeMatcher) item.getData();
	
				TargetSectionAttribute target= matcher.getTargetAttribute();
	
				List<SourceSectionAttribute> sources= new LinkedList<>();
	
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
	
				TargetSectionClass target = matcher.getTargetClass();
	
				setSourceTargetViewerSelections(null, target);
	
				/*
				 * If a ModelConnectionHint is selected, Select the source and target item 
				 * associated with the selected matcher.
				 */
			} else if(item.getData() instanceof ModelConnectionHint) {
	
				ModelConnectionHint hint = (ModelConnectionHint) item.getData();
	
				ArrayList<Attribute<?, ?, ?, ?>> sources = new ArrayList<>();
				ArrayList<Attribute<?, ?, ?, ?>> targets = new ArrayList<>();
	
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
	
				List<TargetSectionAttribute> attr = new ArrayList<>();
				for(ExpandableHint m : exp.getHintsToExpand()){
					if(m instanceof AttributeMapping){
						attr.add(((AttributeMapping) m).getTarget());
					} else if(m instanceof AttributeMatcher){
						attr.add(((AttributeMatcher) m).getTargetAttribute());
					}
				}
	
				if(exp instanceof LocalMappedAttributeValueExpander) {
					setSourceTargetViewerSelections(((LocalMappedAttributeValueExpander) exp).getSource(), attr);
				} else if(exp instanceof ExternalMappedAttributeValueExpander) {
					setSourceTargetViewerSelections(((ExternalMappedAttributeValueExpander) exp).getSource(), attr);
				}
	
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
	}

	/**
	 * A {@link SetViewerSelectionListener} that also handles selections in the {@link PamtramEditorMainPage#targetViewer}.
	 * <p />
	 * It automatically expands referenced {@link TargetSectionClass TargetSectionClasses} if a 
	 * {@link TargetSectionNonContainmentReference} is selected.
	 * 
	 * @author mfreund
	 */
	private final class TargetViewerSelectionListener extends SetViewerSelectionListener {
		
		private TargetViewerSelectionListener() {
			super(editor, targetViewer);
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			super.widgetSelected(e);
	
			// if a non containment reference has been selected while holding down the
			// control key, jump to the referenced class 
			if(((TreeItem) e.item).getData() instanceof TargetSectionNonContainmentReference) {
	
				TargetSectionNonContainmentReference reference = (TargetSectionNonContainmentReference) ((TreeItem) e.item).getData();
	
				EList<pamtram.metamodel.TargetSectionClass> referencedElements = reference.getValue();
	
				if(reference != null && e.stateMask == SWT.CTRL) {
					targetViewer.setSelection(
							new StructuredSelection(referencedElements.toArray()));
				}
			}
		}
	}

	@Override
	public void persist(IDialogSettings settings) {
		
		// Persist the state of the 'mappingSash'
		//
		String minimizedControl = "";
		if(mappingSash.getMinimizedControl() != null) {
			if(mappingSash.getMinimizedControl().equals(mappingViewerGroup)) {
				minimizedControl = "MAPPING_VIEWER_GROUP";
			} else if(mappingSash.getMinimizedControl().equals(globalElementsViewerGroup)) {
				minimizedControl = "GLOBAL_ELEMENTS_VIEWER_GROUP";
			}
		}
		
		if(minimizedControl.isEmpty()) {
			settings.put("MAPPING_SASH_MINIMIZED_CONTROL", "");
			settings.put("MAPPING_SASH_WEIGHTS", Arrays.toString(mappingSash.getWeights()).split(", "));
		} else {
			settings.put("MAPPING_SASH_MINIMIZED_CONTROL", minimizedControl);
			settings.put("MAPPING_SASH_WEIGHTS", "");
		}
		
		// Persist the state of the 'targetSash'
		//
		minimizedControl = "";
		if(targetSash.getMinimizedControl() != null) {
			if(targetSash.getMinimizedControl().equals(targetViewerGroup)) {
				minimizedControl = "TARGET_VIEWER_GROUP";
			} else if(targetSash.getMinimizedControl().equals(libTargetViewerGroup)) {
				minimizedControl = "LIBRARY_TARGET_VIEWER_GROUP";
			}
		}
		
		if(minimizedControl.isEmpty()) {
			settings.put("TARGET_SASH_MINIMIZED_CONTROL", "");
			settings.put("TARGET_SASH_WEIGHTS", Arrays.toString(targetSash.getWeights()).split("[\\[\\]]")[1].split(", "));
		} else {
			settings.put("TARGET_SASH_MINIMIZED_CONTROL", minimizedControl);
			settings.put("TARGET_SASH_WEIGHTS", "");
		}
		
		// Persist the expanded tree paths of the various tree viewers
		//
		persistExpandedTreePaths(sourceViewer, editor.getPamtram(), settings, "SOURCE_VIEWER_EXPANDED_PATHS");
		persistExpandedTreePaths(mappingViewer, editor.getPamtram(), settings, "MAPPING_VIEWER_EXPANDED_PATHS");
		persistExpandedTreePaths(globalElementsViewer, editor.getPamtram(), settings, "GLOBAL_ELEMENT_VIEWER_EXPANDED_PATHS");
		persistExpandedTreePaths(targetViewer, editor.getPamtram(), settings, "TARGET_VIEWER_EXPANDED_PATHS");
		persistExpandedTreePaths(libTargetViewer, editor.getPamtram(), settings, "LIB_TARGET_VIEWER_EXPANDED_PATHS");
	}

	@Override
	public void restore(IDialogSettings settings) {

		// Restore the state of the 'mappingSash'
		//
		String minimizedControl = settings.get("MAPPING_SASH_MINIMIZED_CONTROL");
		if(minimizedControl != null && !minimizedControl.isEmpty()) {
			if(minimizedControl.equals("MAPPING_VIEWER_GROUP")) {
				mappingSash.minimizeControl(mappingViewerGroup);
			} else if(minimizedControl.equals("GLOBAL_ELEMENTS_VIEWER_GROUP")) {
				mappingSash.minimizeControl(globalElementsViewerGroup);
			}
		} else {
			String[] weights = settings.getArray("MAPPING_SASH_WEIGHTS");
			if(weights != null) {
				try {
					int[] parsedWeights = new int[weights.length];
					for (int i = 0; i < weights.length; i++) {
						parsedWeights[i] = Integer.parseInt(weights[i]);
					}
					mappingSash.setWeights(parsedWeights);
				} catch (NumberFormatException e) {
					// do nothing
				}
			}
		}
			
		// Restore the state of the 'mappingSash'
		//
		minimizedControl = settings.get("TARGET_SASH_MINIMIZED_CONTROL");
		if(minimizedControl != null && !minimizedControl.isEmpty()) {
			if(minimizedControl.equals("TARGET_VIEWER_GROUP")) {
				targetSash.minimizeControl(targetViewerGroup);
			} else if(minimizedControl.equals("GLOBAL_ELEMENTS_VIEWER_GROUP")) {
				targetSash.minimizeControl(libTargetViewerGroup);
			}
		} else {
			String[] weights = settings.getArray("TARGET_SASH_WEIGHTS");
			if(weights != null) {
				try {
					int[] parsedWeights = new int[weights.length];
					for (int i = 0; i < weights.length; i++) {
						parsedWeights[i] = Integer.parseInt(weights[i]);
					}
					targetSash.setWeights(parsedWeights);
				} catch (NumberFormatException e) {
					// do nothing
				}
			}
		}
		
		if(settings.getArray("SOURCE_VIEWER_EXPANDED_PATHS") != null) {
			String[] paths = settings.getArray("SOURCE_VIEWER_EXPANDED_PATHS");
			for (int i = 0; i < paths.length; i++) {
				EObject expanded = EcoreUtil.getEObject(editor.getPamtram(), paths[i]);
				if(expanded != null) {
					sourceViewer.setExpandedState(expanded, true);					
				}
			}
		}
		
		// Restore the expanded tree paths of the various tree viewers
		//
		restoreExpandedTreePaths(sourceViewer, editor.getPamtram(), settings, "SOURCE_VIEWER_EXPANDED_PATHS");
		restoreExpandedTreePaths(mappingViewer, editor.getPamtram(), settings, "MAPPING_VIEWER_EXPANDED_PATHS");
		restoreExpandedTreePaths(globalElementsViewer, editor.getPamtram(), settings, "GLOBAL_ELEMENT_VIEWER_EXPANDED_PATHS");
		restoreExpandedTreePaths(targetViewer, editor.getPamtram(), settings, "TARGET_VIEWER_EXPANDED_PATHS");
		restoreExpandedTreePaths(libTargetViewer, editor.getPamtram(), settings, "LIB_TARGET_VIEWER_EXPANDED_PATHS");
	}

	/**
	 * Persists the expanded tree paths of the given {@link TreeViewer viewer} in the given instance of
	 * {@link IDialogSettings}.
	 * <p />
	 * In order, to create a string representation of the expanded paths, their 
	 * {@link EcoreUtil#getRelativeURIFragmentPath(EObject, EObject) relative URI fragment path} relative to the given
	 * {@link EObject ancestor} is used.
	 * 
	 * @param viewer The {@link TreeViewer} for that the expanded tree paths are to be persisted.
	 * @param ancestor An {@link EObject} that is a common ancestor of all the objects represented by the tree paths.
	 * This is used in the calculation of the {@link EcoreUtil#getRelativeURIFragmentPath(EObject, EObject)} that
	 * is used as string representation of the path. 
	 * @param settings The instance of {@link IDialogSettings} that the expanded paths shall be persisted to.
	 * @param key The {@link IDialogSettings#put(String, String[]) key} under that the paths shall be stored.
	 */
	private void persistExpandedTreePaths(TreeViewer viewer, EObject ancestor, IDialogSettings settings, String key) {
		ArrayList<String> paths = new ArrayList<>();
		for (int i = 0; i < viewer.getExpandedTreePaths().length; i++) {
			TreePath path = viewer.getExpandedTreePaths()[i];
			if(path.getLastSegment() instanceof EObject) {
				try {
					paths.add(EcoreUtil.getRelativeURIFragmentPath(editor.getPamtram(), ((EObject) (path.getLastSegment()))));				
				} catch (IllegalArgumentException e) {
					// do nothing
				}
			}
		}
		settings.put(key, paths.toArray(new String[paths.size()]));
	}
	
	/**
	 * Restore the expanded tree paths of the given {@link TreeViewer viewer} that have been persisted via
	 * {@link #persistExpandedTreePaths(TreeViewer, EObject, IDialogSettings, String)}.
	 * 
	 * @param viewer The {@link TreeViewer} for that the expanded tree paths are to be restored.
	 * @param ancestor The same {@link EObject ancestor} that has been used during the persisting of
	 * the tree paths via {@link #persistExpandedTreePaths(TreeViewer, EObject, IDialogSettings, String)}.
	 * @param settings The instance of {@link IDialogSettings} that the expanded paths shall be restored from.
	 * @param key The {@link IDialogSettings#put(String, String[]) key} from that the paths shall be restored.
	 */
	private void restoreExpandedTreePaths(TreeViewer viewer, EObject ancestor, IDialogSettings settings, String key) {
		if(settings.getArray(key) != null) {
			String[] paths = settings.getArray(key);
			for (int i = 0; i < paths.length; i++) {
				EObject expanded = EcoreUtil.getEObject(ancestor, paths[i]);
				if(expanded != null) {
					viewer.setExpandedState(expanded, true);					
				}
			}
		}
	}

}
