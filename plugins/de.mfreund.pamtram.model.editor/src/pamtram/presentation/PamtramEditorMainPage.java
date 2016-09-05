package pamtram.presentation;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
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

import de.mfreund.pamtram.wizards.ImportLibraryElementWizard;
import de.tud.et.ifa.agtele.resources.BundleContentHelper;
import de.tud.et.ifa.agtele.ui.interfaces.IPersistable;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup;
import pamtram.condition.AttributeCondition;
import pamtram.condition.ComplexCondition;
import pamtram.condition.VariadicCondition;
import pamtram.condition.CardinalityCondition;
import pamtram.condition.UnaryCondition;
import pamtram.contentadapter.DeactivationListenerAdapter;
import pamtram.contentprovider.ConditionContentProvider;
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
import pamtram.mapping.InstantiableMappingHintGroup;
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
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.presentation.widgets.MinimizableSashForm;
import pamtram.presentation.widgets.MinimizableTreeViewerGroup;

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
	 * The {@link TreeViewerGroup} for the source sections.
	 */
	protected TreeViewerGroup sourceViewerGroup;

	/**
	 * This is the the viewer for the condtions.
	 */
	protected TreeViewer conditionViewer = null;

	/**
	 * This is the group for the condition tree viewer.
	 */
	protected Group conditionGroup;

	/**
	 * The {@link TreeViewerGroup} for the conditions.
	 */
	protected TreeViewerGroup conditionViewerGroup;

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
	 * The {@link MinimizableSashForm} containing the {@link #sourceViewerGroup} and the {@link #conditionViewerGroup}.
	 */
	protected MinimizableSashForm sourceSash;

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
		this.createSourceViewer();
		this.createMappingViewer();
		this.createTargetViewer();
	}


	private void createSourceViewer() {

		this.sourceSash = new MinimizableSashForm(this,SWT.NONE | SWT.VERTICAL);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			this.sourceSash.setLayoutData(data);
		}

		// Create the viewer for the source sections.
		//
		this.sourceViewerGroup = new MinimizableTreeViewerGroup(
				this.sourceSash, this.adapterFactory, this.editor.getEditingDomain(),
				PamtramEditorPlugin.getPlugin().getDialogSettings(), "Source Sections", null, null, true, true
				);
		this.sourceViewer = this.sourceViewerGroup.getViewer();
		this.sourceViewer.setContentProvider(new SourceSectionContentProvider(this.adapterFactory));
		this.sourceViewer.setInput(this.editor.pamtram);
		this.sourceViewer.getTree().addSelectionListener(new SourceViewerSelectionListener());
		this.sourceViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.sourceViewer));

		new AdapterFactoryTreeEditor(this.sourceViewer.getTree(), this.adapterFactory);
		this.editor.createContextMenuFor(this.sourceViewer);

		// Create the viewer for the condtions.
		//

		this.conditionViewerGroup = new MinimizableTreeViewerGroup(
				this.sourceSash, this.adapterFactory, this.editor.getEditingDomain(),
				PamtramEditorPlugin.getPlugin().getDialogSettings(), "Conditions", null, null, true, true
				);
		this.conditionViewer = this.conditionViewerGroup.getViewer();
		this.conditionViewer.setContentProvider(new ConditionContentProvider(this.adapterFactory));
		this.conditionViewer.setInput(this.editor.pamtram);
		this.conditionViewer.getTree().addSelectionListener(new SetViewerSelectionListener(this.editor, this.conditionViewer));
		this.conditionViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.conditionViewer));

		new AdapterFactoryTreeEditor(this.conditionViewer.getTree(), this.adapterFactory);
		this.editor.createContextMenuFor(this.conditionViewer);
	}


	private void createMappingViewer() {

		this.mappingSash = new MinimizableSashForm(this,SWT.NONE | SWT.VERTICAL);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			this.mappingSash.setLayoutData(data);
		}

		// Create the viewer for the source sections.
		//

		this.mappingViewerGroup = new MinimizableTreeViewerGroup(
				this.mappingSash, this.adapterFactory, this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Mappings", null, null, true, true
				);
		this.mappingViewer = this.mappingViewerGroup.getViewer();
		/*
		 * We add a special content adapter that will refresh the viewer when an element
		 * gets (de-)activated. Otherwise, the updates to the label and its colors are
		 * not reflected properly.
		 */
		this.deactivationListener = new DeactivationListenerAdapter(this.editor.getPamtramContentAdapter(), this.mappingViewer);
		this.editor.getPamtramContentAdapter().addSubAdapter(this.deactivationListener);
		/*
		 * Use a special content provider.
		 */
		this.mappingViewer.setContentProvider(new MappingContentProvider(this.adapterFactory));
		this.mappingViewer.setInput(this.editor.pamtram);
		this.mappingViewer.getTree().addSelectionListener(new MappingViewerSelectionListener());
		this.mappingViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.mappingViewer));

		new AdapterFactoryTreeEditor(this.mappingViewer.getTree(), this.adapterFactory);

		this.editor.setCurrentViewer(this.mappingViewer);

		// Create the viewer for the attribute value modifier sets.
		//

		this.globalElementsViewerGroup = new MinimizableTreeViewerGroup(
				this.mappingSash, this.adapterFactory, this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Modifier Sets and Global Values", null, null, true, true);
		this.globalElementsViewer = this.globalElementsViewerGroup.getViewer();

		this.globalElementsViewer.setContentProvider(new ModifierSetContentProvider(this.adapterFactory));
		this.globalElementsViewer.setInput(this.editor.pamtram);

		this.globalElementsViewer.getTree().addSelectionListener(new SetViewerSelectionListener(this.editor, this.globalElementsViewer));
		this.globalElementsViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.globalElementsViewer));

		new AdapterFactoryTreeEditor(this.globalElementsViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.mappingViewer);
		this.editor.createContextMenuFor(this.globalElementsViewer);

	}


	private void createTargetViewer() {

		this.targetSash = new MinimizableSashForm(this, SWT.NONE | SWT.VERTICAL);
		{
			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			this.targetSash.setLayoutData(data);
		}


		// Create the viewer for the target sections.
		//
		this.targetViewerGroup = new MinimizableTreeViewerGroup(
				this.targetSash, this.adapterFactory, this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Target Sections", null, null, true, true
				);
		this.targetViewer = this.targetViewerGroup.getViewer();

		this.targetViewer.setContentProvider(new TargetSectionContentProvider(this.adapterFactory));
		this.targetViewer.setInput(this.editor.pamtram);
		this.targetViewer.getTree().addSelectionListener(new TargetViewerSelectionListener());
		this.targetViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.targetViewer));

		new AdapterFactoryTreeEditor(this.targetViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.targetViewer);

		// Create the viewer for the library element target sections.
		//
		this.libTargetViewerGroup = new MinimizableTreeViewerGroup(
				this.targetSash, this.adapterFactory, this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Library Element Target Sections", null, null, true, false){
			@Override
			protected void createAdditionalToolbarItems(org.eclipse.swt.widgets.ToolBar toolbar) {

				// import library entries
				ToolItem item = new ToolItem(toolbar, SWT.PUSH);
				item.setImage(BundleContentHelper.getBundleImage(PamtramEditorMainPage.this.bundleID, "icons/import_wiz.gif"));
				item.setToolTipText("Import Library Item");
				item.addSelectionListener((SelectionListener2) e -> {
					// create the wizard
					WizardDialog wizardDialog = new WizardDialog(
							new Shell(),
							new ImportLibraryElementWizard(PamtramEditorMainPage.this.editor.pamtram, PamtramEditorMainPage.this.editor.getEditingDomain()));
					wizardDialog.create();
					wizardDialog.open();
				});

				super.createAdditionalToolbarItems(toolbar);
			};
		};
		this.libTargetViewer = this.libTargetViewerGroup.getViewer();

		this.libTargetViewer.setContentProvider(new LibraryEntryContentProvider(this.adapterFactory));
		this.libTargetViewer.setInput(this.editor.pamtram);
		this.libTargetViewer.getTree().addSelectionListener(new SetViewerSelectionListener(this.editor, this.libTargetViewer));
		this.libTargetViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.libTargetViewer));

		new AdapterFactoryTreeEditor(this.libTargetViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.libTargetViewer);

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
			super(PamtramEditorMainPage.this.editor, PamtramEditorMainPage.this.sourceViewer);
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
					PamtramEditorMainPage.this.sourceViewer.setSelection(
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
			super(PamtramEditorMainPage.this.editor, PamtramEditorMainPage.this.mappingViewer);
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			super.widgetSelected(e);

			TreeItem item = (TreeItem) e.item;

			if(item.getData() instanceof Mapping
					|| item.getData() instanceof MappingHintGroupType
					|| item.getData() instanceof MappingHintGroupImporter
					|| item.getData() instanceof GlobalAttribute
					|| item.getData() instanceof ComplexCondition
					) {

				/*
				 * This keeps track of the elements to be expanded in the mapping viewer.
				 */
				LinkedList<Object> expanded = new LinkedList<>(Arrays.asList(PamtramEditorMainPage.this.mappingViewer.getExpandedElements()));

				/*
				 * This keeps track of the (parent) mapping of the currently selected element.
				 */
				Mapping mapping = null;

				/*
				 * This keeps track of the element in the source viewer that corresponds to the currently selected element.
				 */
				Object source = null;

				/*
				 * This keeps track of the elements in the condition viewer that correspond to the currently selected elements.
				 */
				Set<Object> conditions = new HashSet<>();

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
				 * Additionally, select corresponding source and target sections and the referenced condition.
				 */
				if(item.getData() instanceof MappingHintGroupType){
					MappingHintGroupType hintGroup = (MappingHintGroupType) item.getData();
					mapping = (Mapping) hintGroup.eContainer();
					source = mapping.getSourceSection();
					TargetSectionClass target = hintGroup.getTargetSection();
					if(target != null) {
						if(target.eContainer() instanceof ContainerParameter) {
							libraryTargets.add(target);
						} else {
							targets.add(target);
						}
					}
					if(hintGroup instanceof InstantiableMappingHintGroup &&
							((InstantiableMappingHintGroup) hintGroup).getConditionRef() != null) {
						conditions.add(((InstantiableMappingHintGroup) hintGroup).getConditionRef());
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
					source = mapping.getSourceSection();
					if(hintGroupImporter.getHintGroup() != null) {
						TargetSectionClass target = hintGroupImporter.getHintGroup().getTargetSection();
						if(target != null) {
							if(target.eContainer() instanceof ContainerParameter) {
								libraryTargets.add(target);
							} else {
								targets.add(target);
							}
						}
					}
					if(hintGroupImporter.getConditionRef() != null) {
						conditions.add(hintGroupImporter.getConditionRef());
					}
					expanded.add(mapping);
					expanded.add(hintGroupImporter);

					/*
					 * If a GlobalAttribute is selected, expand the attribute itself and the parent mapping.
					 * Additionally, select the corresponding source attribute.
					 */
				} else if(item.getData() instanceof GlobalAttribute){
					GlobalAttribute g = (GlobalAttribute) item.getData();
					mapping = (Mapping) g.eContainer();
					if(g.getSource() != null){
						source = g.getSource();
					} else{
						source = mapping.getSourceSection();
					}
					expanded.add(mapping);
					expanded.add(g);

					/*
					 * If a ComplexCondition is selected, expand referenced conditions, sections, and/or attributes.
					 */
				} else if(item.getData() instanceof ComplexCondition) {
					ComplexCondition condition = (ComplexCondition) item.getData();

					if(condition instanceof UnaryCondition &&
							((UnaryCondition) condition).getCondPartRef() != null) {
						conditions.add(((UnaryCondition) condition).getCondPartRef());
					} else if(condition instanceof VariadicCondition &&
							((VariadicCondition) condition).getCondPartsRef() != null) {
						conditions.addAll(((VariadicCondition) condition).getCondPartsRef());
					} else if(condition instanceof AttributeCondition) {
						source = ((AttributeCondition) condition).getConditionAttributeRef();
					} else if(condition instanceof CardinalityCondition) {
						source = ((CardinalityCondition) condition).getConditionSectionRef();
					}

					/*
					 * If a Mapping is selected, expand the mapping itself.
					 * Additionally, select the source of the mapping and the targets of the hint groups.
					 */
				} else if(item.getData() instanceof Mapping){
					mapping = (Mapping) item.getData();
					source = mapping.getSourceSection();
					if(mapping.getConditionRef() != null) {
						conditions.add(mapping.getConditionRef());
					}
					expanded.add(mapping);
					for(MappingHintGroupType group : mapping.getMappingHintGroups()){
						if(group.getTargetSection() != null) {
							TargetSectionClass target = group.getTargetSection();
							if(target.eContainer() instanceof ContainerParameter) {
								libraryTargets.add(target);
							} else {
								targets.add(target);
							}
						}
					}

				}

				// Expand the mapping in the mapping tree viewer.
				PamtramEditorMainPage.this.mappingViewer.setExpandedElements(
						expanded.toArray());

				// Select and expand the source and target items associated with
				// the selected mapping.
				if(source == null) {
					PamtramEditorMainPage.this.sourceViewer.setSelection(
							new StructuredSelection());
				} else {
					PamtramEditorMainPage.this.sourceViewer.setSelection(
							new StructuredSelection(source));
					if(mapping != this.currentMapping) {
						ArrayList<Object> newExpansion = new ArrayList<>(Arrays.asList(PamtramEditorMainPage.this.sourceViewer.getExpandedElements()));
						newExpansion.add(source);
						PamtramEditorMainPage.this.sourceViewer.setExpandedElements(newExpansion.toArray());
					}
				}
				if(conditions.isEmpty()) {
					PamtramEditorMainPage.this.conditionViewer.setSelection(
							new StructuredSelection());
				} else {
					PamtramEditorMainPage.this.conditionViewer.setSelection(
							new StructuredSelection(conditions.toArray()));
				}
				if(targets.isEmpty()) {
					PamtramEditorMainPage.this.targetViewer.setSelection(
							new StructuredSelection());
				} else {
					PamtramEditorMainPage.this.targetViewer.setSelection(
							new StructuredSelection(targets));
					if(mapping != this.currentMapping) {
						ArrayList<Object> newExpansion = new ArrayList<>(Arrays.asList(PamtramEditorMainPage.this.targetViewer.getExpandedElements()));
						newExpansion.addAll(targets);
						PamtramEditorMainPage.this.targetViewer.setExpandedElements(newExpansion.toArray());
					}
				}
				if(libraryTargets.isEmpty()) {
					PamtramEditorMainPage.this.libTargetViewer.setSelection(
							new StructuredSelection());
				} else {
					PamtramEditorMainPage.this.libTargetViewer.setSelection(
							new StructuredSelection(libraryTargets));
					if(mapping != this.currentMapping) {
						ArrayList<Object> newExpansion = new ArrayList<>(Arrays.asList(PamtramEditorMainPage.this.libTargetViewer.getExpandedElements()));
						newExpansion.addAll(libraryTargets);
						PamtramEditorMainPage.this.libTargetViewer.setExpandedElements(newExpansion.toArray());
						/* this second selection is a quirk that is necessary because of the virtual 'ParameterDescription'
						 * that prevents the expansion to work at the first try
						 */
						PamtramEditorMainPage.this.libTargetViewer.setSelection(
								new StructuredSelection(libraryTargets));
					}
				}
				// Update the currently selected mapping.
				this.currentMapping = mapping;

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

				this.setSourceTargetViewerSelections(source, target);

				/*
				 * If a GlobalAttributeImporter is selected, select the source attribute that
				 * it imports and the target attribute of a possible parent AttributeMapping.
				 */
			}  else if(item.getData() instanceof GlobalAttributeImporter){
				GlobalAttributeImporter importer = (GlobalAttributeImporter) item.getData();
				Attribute<?, ?, ?, ?> target = null;
				if(importer.eContainer() instanceof AttributeMapping) {
					target = ((AttributeMapping) importer.eContainer()).getTarget();
				} else if(importer.eContainer() instanceof AttributeMatcher) {
					target = ((AttributeMatcher) importer.eContainer()).getTarget();
				} else if(importer.eContainer() instanceof ModelConnectionHint) {
					if(!((ModelConnectionHint) importer.eContainer()).getTargetAttributes().isEmpty()) {
						target = ((ModelConnectionHint) importer.eContainer()).getTargetAttributes().get(0).getSource();
					}
				} else if(importer.eContainer() instanceof InstancePointer) {
					target = ((InstancePointer) importer.eContainer()).getTarget();
				}
				Attribute<?, ?, ?, ?> source = importer.getSourceAttribute();

				this.setSourceTargetViewerSelections(source, target);

				/*
				 * If an AttributeMapping is selected, select all source attributes and the
				 * target attribute.
				 */
			} else if(item.getData() instanceof AttributeMapping) {
				AttributeMapping mapping = (AttributeMapping) item.getData();
				Attribute<?, ?, ?, ?> target = mapping.getTarget();

				List<Object> sources = new LinkedList<>();
				for(AttributeMappingSourceInterface c : mapping.getSourceElements()){
					if(c.getSourceAttribute() != null){
						sources.add(c.getSourceAttribute());
					}
				}
				if(mapping.getConditionRef() != null) {
					sources.add(mapping.getConditionRef());
				}

				this.setSourceTargetViewerSelections(sources, target);

				/*
				 * If a CardinalityMapping is selected, select its source and target classes.
				 */
			} else if(item.getData() instanceof CardinalityMapping) {

				CardinalityMapping mapping = (CardinalityMapping) item.getData();

				List<Object> sources = new LinkedList<>();
				sources.add(mapping.getSource());
				pamtram.metamodel.Class<?, ?, ?, ?> target = mapping.getTarget();

				if(mapping.getConditionRef() != null) {
					sources.add(mapping.getConditionRef());
				}

				this.setSourceTargetViewerSelections(sources, target);

				/*
				 * If a MappingInstanceSelector is selected, select the target reference that it points to.
				 */
			} else if(item.getData() instanceof MappingInstanceSelector) {

				MappingInstanceSelector selector = (MappingInstanceSelector) item.getData();

				NonContainmentReference<?, ?, ?, ?> reference = selector.getAffectedReference();

				this.setSourceTargetViewerSelections(selector.getConditionRef(), reference);

				/*
				 * If an AttributeMatcher is selected, select its source and target attributes.
				 */
			} else if(item.getData() instanceof AttributeMatcher){
				AttributeMatcher matcher= (AttributeMatcher) item.getData();

				TargetSectionAttribute target= matcher.getTarget();

				List<SourceSectionAttribute> sources = new LinkedList<>();

				for(AttributeMatcherSourceInterface srcElement : matcher.getSourceElements()){
					if(srcElement.getSourceAttribute() != null){
						sources.add(srcElement.getSourceAttribute());
					}
				}

				this.setSourceTargetViewerSelections(sources, target);

				/*
				 * If a ClassMatcher is selected, select the source and target classes associated with it.
				 */
			} else if(item.getData() instanceof ClassMatcher) {

				ClassMatcher matcher = (ClassMatcher) item.getData();

				TargetSectionClass target = matcher.getTargetClass();

				this.setSourceTargetViewerSelections(null, target);

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

				this.setSourceTargetViewerSelections(sources, targets);

				/*
				 * If a ConnectionHintTargetAttribute is selected, select its specified
				 * target attribute.
				 */
			} else if(item.getData() instanceof ConnectionHintTargetAttribute){
				ConnectionHintTargetAttribute a = (ConnectionHintTargetAttribute) item.getData();
				this.setSourceTargetViewerSelections(null, a.getTargetAttribute());

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
						attr.add(((AttributeMatcher) m).getTarget());
					}
				}

				if(exp instanceof LocalMappedAttributeValueExpander) {
					this.setSourceTargetViewerSelections(((LocalMappedAttributeValueExpander) exp).getSource(), attr);
				} else if(exp instanceof ExternalMappedAttributeValueExpander) {
					this.setSourceTargetViewerSelections(((ExternalMappedAttributeValueExpander) exp).getSource(), attr);
				}

			}
		}

		/**
		 * This is a convenience method to select elements in the source viewer and in the target/library target {@link TreeViewer}.
		 * The method automatically determines if the target element(s) is/are located in the target viewer or in the library target viewer
		 * and performs the appropriate selection.
		 *
		 * @param source The object(s) to be selected in the source (or condition) viewer (or null if nothing is to be selected).
		 * 					This may be a single object or an {@link AbstractCollection} of objects.
		 * @param target The object(s) to be selected in the target (or library target) viewer (or null if nothing is to be selected).
		 * 					This may be a single object or an {@link AbstractCollection} of objects.
		 */
		private void setSourceTargetViewerSelections(
				Object source, Object target) {
			if(source == null) {
				PamtramEditorMainPage.this.sourceViewer.setSelection(
						new StructuredSelection());
				PamtramEditorMainPage.this.conditionViewer.setSelection(
						new StructuredSelection());
			} else {
				/* as the source(s) may either be located in source sections or in conditions,
				 * we simply set the selection in both viewers (knowing that only one will succeed)
				 */
				if(source instanceof AbstractCollection<?>) {
					PamtramEditorMainPage.this.sourceViewer.setSelection(
							new StructuredSelection(((AbstractCollection<?>) source).toArray()));
					PamtramEditorMainPage.this.conditionViewer.setSelection(
							new StructuredSelection(((AbstractCollection<?>) source).toArray()));
				} else {
					PamtramEditorMainPage.this.sourceViewer.setSelection(
							new StructuredSelection(source));
					PamtramEditorMainPage.this.conditionViewer.setSelection(
							new StructuredSelection(source));
				}
			}
			if(target == null) {
				PamtramEditorMainPage.this.targetViewer.setSelection(
						new StructuredSelection());
				PamtramEditorMainPage.this.libTargetViewer.setSelection(
						new StructuredSelection());
			} else {
				/* as the target(s) may either be located in target sections or in a library entries,
				 * we simply set the selection in both viewers (knowing that only one will succeed)
				 */
				if(target instanceof AbstractCollection<?>) {
					PamtramEditorMainPage.this.targetViewer.setSelection(
							new StructuredSelection(((AbstractCollection<?>) target).toArray()));
					PamtramEditorMainPage.this.libTargetViewer.setSelection(
							new StructuredSelection(((AbstractCollection<?>) target).toArray()));
				} else {
					PamtramEditorMainPage.this.targetViewer.setSelection(
							new StructuredSelection(target));
					PamtramEditorMainPage.this.libTargetViewer.setSelection(
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
			super(PamtramEditorMainPage.this.editor, PamtramEditorMainPage.this.targetViewer);
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
					PamtramEditorMainPage.this.targetViewer.setSelection(
							new StructuredSelection(referencedElements.toArray()));
				}
			}
		}
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
			} else if(this.editor.currentViewer.equals(this.conditionViewer)) {
				activeViewer = "CONDITION_VIEWER";
			} else if(this.editor.currentViewer.equals(this.mappingViewer)) {
				activeViewer = "MAPPING_VIEWER";
			} else if(this.editor.currentViewer.equals(this.globalElementsViewer)) {
				activeViewer = "GLOBAL_ELEMENTS_VIEWER";
			} else if(this.editor.currentViewer.equals(this.targetViewer)) {
				activeViewer = "TARGET_VIEWER";
			} else if(this.editor.currentViewer.equals(this.libTargetViewer)) {
				activeViewer = "LIB_TARGET_VIEWER";
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

		// Persist the state of the 'sourceSash'
		//
		this.sourceSash.persist(settings.addNewSection("SOURCE_SASH"));

		// Persist the state of the 'mappingSash'
		//
		this.mappingSash.persist(settings.addNewSection("MAPPING_SASH"));

		// Persist the state of the 'targetSash'
		//
		this.targetSash.persist(settings.addNewSection("TARGET_SASH"));

		// Persist the expanded tree paths of the various tree viewers
		//
		this.sourceViewerGroup.persist(settings.addNewSection("SOURCE_VIEWER"));
		this.conditionViewerGroup.persist(settings.addNewSection("CONDITION_VIEWER"));
		this.mappingViewerGroup.persist(settings.addNewSection("MAPPING_VIEWER"));
		this.globalElementsViewerGroup.persist(settings.addNewSection("GLOBAL_ELEMENTS_VIEWER"));
		this.targetViewerGroup.persist(settings.addNewSection("TARGET_VIEWER"));
		this.libTargetViewerGroup.persist(settings.addNewSection("LIB_TARGET_VIEWER"));

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
			} else if(activeViewer.equals("CONDITION_VIEWER")) {
				this.editor.setCurrentViewer(this.conditionViewer);
			} else if(activeViewer.equals("MAPPING_VIEWER")) {
				this.editor.setCurrentViewer(this.mappingViewer);
			} else if(activeViewer.equals("GLOBAL_ELEMENTS_VIEWER")) {
				this.editor.setCurrentViewer(this.globalElementsViewer);
			} else if(activeViewer.equals("TARGET_VIEWER")) {
				this.editor.setCurrentViewer(this.targetViewer);
			} else if(activeViewer.equals("LIB_TARGET_VIEWER")) {
				this.editor.setCurrentViewer(this.libTargetViewer);
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

		// Restore the state of the 'sourceSash'
		//
		if(settings.getSection("SOURCE_SASH") != null) {
			this.sourceSash.restore(settings.getSection("SOURCE_SASH"));
		}

		// Restore the state of the 'mappingSash'
		//
		if(settings.getSection("MAPPING_SASH") != null) {
			this.mappingSash.restore(settings.getSection("MAPPING_SASH"));
		}

		// Restore the state of the 'targetSash'
		//
		if(settings.getSection("TARGET_SASH") != null) {
			this.targetSash.restore(settings.getSection("TARGET_SASH"));
		}

		// Restore the expanded tree paths of the various tree viewers
		//
		if(settings.getSection("SOURCE_VIEWER") != null) {
			this.sourceViewerGroup.restore(settings.getSection("SOURCE_VIEWER"));
		}
		if(settings.getSection("CONDITION_VIEWER") != null) {
			this.conditionViewerGroup.restore(settings.getSection("CONDITION_VIEWER"));
		}
		if(settings.getSection("MAPPING_VIEWER") != null) {
			this.mappingViewerGroup.restore(settings.getSection("MAPPING_VIEWER"));
		}
		if(settings.getSection("GLOBAL_ELEMENTS_VIEWER") != null) {
			this.globalElementsViewerGroup.restore(settings.getSection("GLOBAL_ELEMENTS_VIEWER"));
		}
		if(settings.getSection("TARGET_VIEWER") != null) {
			this.targetViewerGroup.restore(settings.getSection("TARGET_VIEWER"));
		}
		if(settings.getSection("LIB_TARGET_VIEWER") != null) {
			this.libTargetViewerGroup.restore(settings.getSection("LIB_TARGET_VIEWER"));
		}
	}

}
