package pamtram.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelectionProvider;
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
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.part.FileEditorInput;

import de.mfreund.pamtram.properties.PropertySupplier;
import de.mfreund.pamtram.wizards.ImportLibraryElementWizard;
import de.mfreund.pamtram.wizards.ImportSharedModelWizard;
import de.tud.et.ifa.agtele.resources.BundleContentHelper;
import de.tud.et.ifa.agtele.ui.interfaces.IPersistable;
import de.tud.et.ifa.agtele.ui.interfaces.ISelectionProviderWrapper;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import de.tud.et.ifa.agtele.ui.widgets.MinimizableSashForm;
import de.tud.et.ifa.agtele.ui.widgets.MinimizableTreeViewerGroup;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup.TreeViewerGroupOption;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup.TreeViewerGroupToolbarAddButtonOption;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup.TreeViewerGroupToolbarCollapseAllButtonOption;
import de.tud.et.ifa.agtele.ui.widgets.TreeViewerGroup.TreeViewerGroupToolbarOption;
import pamtram.ConditionalElement;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.condition.ComplexCondition;
import pamtram.condition.Condition;
import pamtram.condition.UnaryCondition;
import pamtram.condition.VariadicCondition;
import pamtram.contentadapter.DeactivationListenerAdapter;
import pamtram.contentadapter.LibraryNatureListenerAdapter;
import pamtram.contentprovider.ConditionContentProvider;
import pamtram.contentprovider.LibraryEntryContentProvider;
import pamtram.contentprovider.MappingContentProvider;
import pamtram.contentprovider.ModifierSetContentProvider;
import pamtram.contentprovider.SourceSectionContentProvider;
import pamtram.contentprovider.TargetSectionContentProvider;
import pamtram.listeners.SetViewerMouseListener;
import pamtram.listeners.SetViewerSelectionListener;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.AttributeMappingSourceInterface;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingSourceInterface;
import pamtram.mapping.extended.ExpandableHint;
import pamtram.mapping.extended.ExternalMappedAttributeValueExpander;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.extended.LocalMappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValueExpander;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.mapping.modifier.ValueModifierSet;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;
import pamtram.util.SharedModelUtil.SharedModelType;

/**
 * The main page of the {@link PamtramEditor} that allows to configure source sections, mappings, and target sections.
 *
 * @author mfreund
 */
public class PamtramEditorMainPage extends SashForm implements IPersistable, ISelectionProviderWrapper {

	/**
	 * This is the editor that this view is hosted in.
	 */
	protected PamtramEditor editor;

	/**
	 * This is the one adapter factory used for providing views of the model.
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
	 * This is the the viewer for the conditions.
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
	 * This is the group for the {@link ValueModifierSet} set tree viewer.
	 */
	protected Group valueModifierSetGroup;

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
	 * This is a special content adapter that will refresh the viewer when an element gets (de-)activated. Otherwise,
	 * the updates to the label and its colors are not reflected properly.
	 */
	protected DeactivationListenerAdapter deactivationListener;

	/**
	 * The {@link MinimizableSashForm} containing the {@link #sourceViewerGroup} and the {@link #conditionViewerGroup}.
	 */
	protected MinimizableSashForm sourceSash;

	/**
	 * The {@link MinimizableSashForm} containing the {@link #mappingViewerGroup} and the
	 * {@link #globalElementsViewerGroup}.
	 */
	protected MinimizableSashForm mappingSash;

	/**
	 * The {@link MinimizableSashForm} containing the {@link #targetViewerGroup} and the {@link #libTargetViewerGroup}.
	 */
	protected MinimizableSashForm targetSash;

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
	public PamtramEditorMainPage(Composite parent, int style, ComposedAdapterFactory adapterFactory,
			PamtramEditor editor) {

		super(parent, style);

		this.adapterFactory = adapterFactory;
		this.editor = editor;

		GridDataFactory.fillDefaults().grab(true, false).align(GridData.FILL, GridData.FILL).applyTo(this);

		this.createSourceViewer();
		this.createMappingViewer();
		this.createTargetViewer();
	}

	/**
	 * Create the viewers for the source sections and conditions.
	 */
	private void createSourceViewer() {

		this.sourceSash = new MinimizableSashForm(this, SWT.NONE | SWT.VERTICAL);

		GridDataFactory.fillDefaults().grab(true, false).align(GridData.FILL, GridData.FILL).applyTo(this.sourceSash);

		// Create the viewer for the source sections.
		//
		this.sourceViewerGroup = new MinimizableTreeViewerGroup(this.sourceSash, this.adapterFactory,
				this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(), "Source Sections",
				new TreeViewerGroupToolbarAddButtonOption(), new TreeViewerGroupToolbarCollapseAllButtonOption(),
				new TreeViewerGroupToolbarImportSharedSectionModelButtonOption(this.editor.pamtram,
						this.editor.getEditingDomain(), SharedModelType.SOURCE),
				TreeViewerGroup.BIND_HELP_LISTENER());

		this.sourceViewer = this.sourceViewerGroup.getViewer();
		this.sourceViewer.setContentProvider(new SourceSectionContentProvider(this.adapterFactory));
		this.sourceViewer.setInput(this.editor.pamtram);
		this.sourceViewer.getTree().addSelectionListener(new SourceViewerSelectionListener(this.sourceViewer));
		this.sourceViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.sourceViewer));

		new AdapterFactoryTreeEditor(this.sourceViewer.getTree(), this.adapterFactory);
		this.editor.createContextMenuFor(this.sourceViewer);

		// Create the viewer for the condtions.
		//

		this.conditionViewerGroup = new MinimizableTreeViewerGroup(this.sourceSash, this.adapterFactory,
				this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(), "Conditions",
				new TreeViewerGroupToolbarAddButtonOption(), new TreeViewerGroupToolbarCollapseAllButtonOption(),
				new TreeViewerGroupToolbarImportSharedSectionModelButtonOption(this.editor.pamtram,
						this.editor.getEditingDomain(), SharedModelType.CONDITION),
				TreeViewerGroup.BIND_HELP_LISTENER());
		this.conditionViewer = this.conditionViewerGroup.getViewer();
		this.conditionViewer.setContentProvider(new ConditionContentProvider(this.adapterFactory));
		this.conditionViewer.setInput(this.editor.pamtram);
		this.conditionViewer.getTree()
				.addSelectionListener(new SetViewerSelectionListener(this.editor, this.conditionViewer));
		this.conditionViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.conditionViewer));

		new AdapterFactoryTreeEditor(this.conditionViewer.getTree(), this.adapterFactory);
		this.editor.createContextMenuFor(this.conditionViewer);
	}

	/**
	 * Create the viewers for the mappings and global elements.
	 */
	private void createMappingViewer() {

		this.mappingSash = new MinimizableSashForm(this, SWT.NONE | SWT.VERTICAL);

		GridDataFactory.fillDefaults().grab(true, false).align(GridData.FILL, GridData.FILL).applyTo(this.mappingSash);

		// Create the viewer for the source sections.
		//

		this.mappingViewerGroup = new MinimizableTreeViewerGroup(this.mappingSash, this.adapterFactory,
				this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(), "Mappings",
				new TreeViewerGroupToolbarAddButtonOption(), new TreeViewerGroupToolbarCollapseAllButtonOption(),
				new TreeViewerGroupToolbarImportSharedSectionModelButtonOption(this.editor.pamtram,
						this.editor.getEditingDomain(), SharedModelType.MAPPING),
				TreeViewerGroup.BIND_HELP_LISTENER());
		this.mappingViewer = this.mappingViewerGroup.getViewer();
		/*
		 * We add a special content adapter that will refresh the viewer when an element gets (de-)activated. Otherwise,
		 * the updates to the label and its colors are not reflected properly.
		 */
		this.deactivationListener = new DeactivationListenerAdapter(this.editor.getPamtramContentAdapter(),
				this.mappingViewer);
		this.editor.getPamtramContentAdapter().addSubAdapter(this.deactivationListener);
		/*
		 * Use a special content provider.
		 */
		this.mappingViewer.setContentProvider(new MappingContentProvider(this.adapterFactory));
		this.mappingViewer.setInput(this.editor.pamtram);
		this.mappingViewer.getTree().addSelectionListener(new MappingViewerSelectionListener(this.mappingViewer));
		this.mappingViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.mappingViewer));

		new AdapterFactoryTreeEditor(this.mappingViewer.getTree(), this.adapterFactory);

		this.editor.setCurrentViewer(this.mappingViewer);

		// Create the viewer for the attribute value modifier sets.
		//

		this.globalElementsViewerGroup = new MinimizableTreeViewerGroup(this.mappingSash, this.adapterFactory,
				this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Modifier Sets and Global Values", new TreeViewerGroupToolbarAddButtonOption(),
				new TreeViewerGroupToolbarCollapseAllButtonOption(),
				new TreeViewerGroupToolbarImportSharedSectionModelButtonOption(this.editor.pamtram,
						this.editor.getEditingDomain(), SharedModelType.MAPPING),
				TreeViewerGroup.BIND_HELP_LISTENER());
		this.globalElementsViewer = this.globalElementsViewerGroup.getViewer();

		this.globalElementsViewer.setContentProvider(new ModifierSetContentProvider(this.adapterFactory));
		this.globalElementsViewer.setInput(this.editor.pamtram);

		this.globalElementsViewer.getTree()
				.addSelectionListener(new GlobalElementsViewerSelectionListener(this.globalElementsViewer));
		this.globalElementsViewer.getTree()
				.addMouseListener(new SetViewerMouseListener(this.editor, this.globalElementsViewer));

		new AdapterFactoryTreeEditor(this.globalElementsViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.mappingViewer);
		this.editor.createContextMenuFor(this.globalElementsViewer);

	}

	/**
	 * Create the viewers for the target sections and library entries.
	 */
	private void createTargetViewer() {

		this.targetSash = new MinimizableSashForm(this, SWT.NONE | SWT.VERTICAL);

		GridDataFactory.fillDefaults().grab(true, false).align(GridData.FILL, GridData.FILL).applyTo(this.targetSash);

		// Create the viewer for the target sections.
		//
		this.targetViewerGroup = new MinimizableTreeViewerGroup(this.targetSash, this.adapterFactory,
				this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(), "Target Sections",
				new TreeViewerGroupToolbarAddButtonOption(), new TreeViewerGroupToolbarCollapseAllButtonOption(),
				new TreeViewerGroupToolbarImportSharedSectionModelButtonOption(this.editor.pamtram,
						this.editor.getEditingDomain(), SharedModelType.TARGET),
				TreeViewerGroup.BIND_HELP_LISTENER());

		this.targetViewer = this.targetViewerGroup.getViewer();

		this.targetViewer.setContentProvider(new TargetSectionContentProvider(this.adapterFactory));
		this.targetViewer.setInput(this.editor.pamtram);
		this.targetViewer.getTree().addSelectionListener(new TargetViewerSelectionListener(this.targetViewer));
		this.targetViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.targetViewer));

		new AdapterFactoryTreeEditor(this.targetViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.targetViewer);

		// Create the viewer for the library element target sections.
		//
		this.libTargetViewerGroup = new MinimizableTreeViewerGroup(this.targetSash, this.adapterFactory,
				this.editor.getEditingDomain(), PamtramEditorPlugin.getPlugin().getDialogSettings(),
				"Library Element Target Sections", new TreeViewerGroupToolbarCollapseAllButtonOption(),
				new TreeViewerGroupToolbarImportLibraryEntryButtonOption(this.editor.pamtram,
						this.editor.getEditingDomain()),
				TreeViewerGroup.BIND_HELP_LISTENER());

		this.libTargetViewer = this.libTargetViewerGroup.getViewer();

		this.libTargetViewer.setContentProvider(new LibraryEntryContentProvider(this.adapterFactory));
		this.libTargetViewer.setInput(this.editor.pamtram);
		this.libTargetViewer.getTree()
				.addSelectionListener(new SetViewerSelectionListener(this.editor, this.libTargetViewer));
		this.libTargetViewer.getTree().addMouseListener(new SetViewerMouseListener(this.editor, this.libTargetViewer));

		new AdapterFactoryTreeEditor(this.libTargetViewer.getTree(), this.adapterFactory);

		this.editor.createContextMenuFor(this.libTargetViewer);

		try {
			boolean hasLibraryNature = this.editor.getEditorInput() instanceof FileEditorInput && Boolean
					.parseBoolean(PropertySupplier.getResourceProperty(PropertySupplier.PROP_HAS_LIBRARY_NATURE,
							((FileEditorInput) this.editor.getEditorInput()).getFile().getProject()));

			// Do not show the libTargetViewerGroup if the project is not
			// equipped
			// with the 'PAMTraM Library Nature'
			//
			this.libTargetViewerGroup.setVisible(hasLibraryNature);

			// Add an adapter that will add the library nature if necessary
			//
			if (!hasLibraryNature) {
				this.editor.getPamtramContentAdapter().addSubAdapter(new LibraryNatureListenerAdapter(
						this.editor.getPamtramContentAdapter(), this.libTargetViewerGroup));
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	/**
	 * A {@link SetViewerSelectionListener} that handles selections in the {@link PamtramEditorMainPage#sourceViewer}.
	 * <p />
	 * It automatically expands referenced {@link SourceSectionClass SourceSectionClasses} if a
	 * {@link SectionCrossReference} is selected.
	 *
	 * @author mfreund
	 */
	private final class SourceViewerSelectionListener extends SetViewerSelectionListener {

		private SourceViewerSelectionListener(TreeViewer viewer) {

			super(PamtramEditorMainPage.this.editor, viewer);
		}

		@Override
		public void widgetSelected(SelectionEvent e) {

			super.widgetSelected(e);

			if (e.item == null || !(this.viewer.getSelection() instanceof StructuredSelection)
					|| !((StructuredSelection) this.viewer.getSelection()).isEmpty()) {
				return;
			}

			// if a non containment reference has been selected while holding down the control key, jump to the
			// referenced class
			//
			if (e.item.getData() instanceof SourceSectionCrossReference && e.stateMask == SWT.CTRL) {

				SourceSectionCrossReference reference = (SourceSectionCrossReference) e.item.getData();

				PamtramEditorMainPage.this.editor.setSelection(new StructuredSelection(reference.getValue()));
			}
		}
	}

	/**
	 * A {@link SourceViewerSelectionListener} that handles selections in the
	 * {@link PamtramEditorMainPage#mappingViewer}.
	 * <p />
	 * It automatically expands referenced elements. For example, if an {@link AttributeMapping} is selected, the
	 * associated source and target elements are expanded so that the user can easily determine those.
	 *
	 * @author mfreund
	 */
	private final class MappingViewerSelectionListener extends SetViewerSelectionListener {

		private MappingViewerSelectionListener(TreeViewer viewer) {

			super(PamtramEditorMainPage.this.editor, viewer);
		}

		@Override
		protected void handleSingleSelection(Object selected, SelectionEvent e) {

			// The elements that will be selected in the various viewers
			//
			List<Object> toSelect = new ArrayList<>();

			toSelect.add(selected);

			if (selected instanceof ConditionalElement) {
				toSelect.add(((ConditionalElement) selected).getSharedCondition());
			}

			/*
			 * If a MappingHintGroup is selected, expand the hint group itself and the parent Mapping. Additionally,
			 * select corresponding source and target sections and the referenced condition.
			 */
			if (selected instanceof MappingHintGroupType) {

				MappingHintGroupType hintGroup = (MappingHintGroupType) selected;
				Mapping mapping = (Mapping) hintGroup.eContainer();

				toSelect.add(mapping.getSourceSection());
				toSelect.add(hintGroup.getTargetSection());

				/*
				 * If a MappingHintGroup is selected, expand the importer itself and the parent mapping. Additionally,
				 * select corresponding source and target sections of the importer/of the imported hint group.
				 */
			} else if (selected instanceof MappingHintGroupImporter) {

				MappingHintGroupImporter hintGroupImporter = (MappingHintGroupImporter) selected;
				Mapping mapping = (Mapping) hintGroupImporter.eContainer();

				toSelect.add(mapping.getSourceSection());
				if (hintGroupImporter.getHintGroup() != null) {
					toSelect.add(hintGroupImporter.getHintGroup().getTargetSection());
				}

				/*
				 * If a ComplexCondition is selected, expand referenced conditions, sections, and/or attributes.
				 */
			} else if (selected instanceof ComplexCondition) {

				ComplexCondition condition = (ComplexCondition) selected;

				if (condition instanceof UnaryCondition) {
					toSelect.add(((UnaryCondition) condition).getSharedCondPart());
				} else if (condition instanceof VariadicCondition) {
					toSelect.addAll(((VariadicCondition) condition).getSharedCondParts());
				} else if (condition instanceof Condition) {
					toSelect.add(((Condition<?>) condition).getTarget());
				}

				/*
				 * If a Mapping is selected, expand the mapping itself. Additionally, select the source of the mapping
				 * and the targets of the hint groups.
				 */
			} else if (selected instanceof Mapping) {

				Mapping mapping = (Mapping) selected;

				toSelect.add(mapping.getSourceSection());
				toSelect.addAll(mapping.getMappingHintGroups().stream().map(hg -> hg.getTargetSection())
						.collect(Collectors.toSet()));

				/*
				 * If a DynamicSourceElement is selected, select the source attribute that it represents and the target
				 * attribute of a possible parent AttributeMapping.
				 */
			} else if (selected instanceof DynamicSourceElement<?, ?, ?, ?>) {

				DynamicSourceElement<?, ?, ?, ?> modifiedAttribute = (DynamicSourceElement<?, ?, ?, ?>) selected;

				toSelect.add(modifiedAttribute.getSource());

				if (modifiedAttribute.eContainer() instanceof AttributeMapping) {
					toSelect.add(((AttributeMapping) modifiedAttribute.eContainer()).getTarget());
				} else if (modifiedAttribute.eContainer() instanceof CardinalityMapping) {
					toSelect.add(((CardinalityMapping) modifiedAttribute.eContainer()).getTarget());
				} else if (modifiedAttribute.eContainer() instanceof TargetInstanceSelector) {
					toSelect.add(((TargetInstanceSelector) modifiedAttribute.eContainer()).getReferenceAttribute());
					toSelect.add(((TargetInstanceSelector) modifiedAttribute.eContainer()).getTargetClass());
					if (modifiedAttribute.eContainer() instanceof ReferenceTargetSelector) {
						toSelect.add(((ReferenceTargetSelector) modifiedAttribute.eContainer()).getAffectedReference());
					}
				} else if (modifiedAttribute.eContainer() instanceof SourceInstanceSelector) {
					toSelect.add(((SourceInstanceSelector) modifiedAttribute.eContainer()).getReferenceAttribute());
				}

				/*
				 * If a GlobalAttributeImporter is selected, select the source attribute that it imports and the target
				 * attribute of a possible parent AttributeMapping.
				 */
			} else if (selected instanceof GlobalAttributeImporter) {

				GlobalAttributeImporter importer = (GlobalAttributeImporter) selected;

				toSelect.add(importer.getGlobalAttribute());

				if (importer.eContainer() instanceof AttributeMapping) {
					toSelect.add(((AttributeMapping) importer.eContainer()).getTarget());
				} else if (importer.eContainer() instanceof CardinalityMapping) {
					toSelect.add(((CardinalityMapping) importer.eContainer()).getTarget());
				} else if (importer.eContainer() instanceof TargetInstanceSelector) {
					toSelect.add(((TargetInstanceSelector) importer.eContainer()).getReferenceAttribute());
					toSelect.add(((TargetInstanceSelector) importer.eContainer()).getTargetClass());
					if (importer.eContainer() instanceof ReferenceTargetSelector) {
						toSelect.add(((ReferenceTargetSelector) importer.eContainer()).getAffectedReference());
					}
				} else if (importer.eContainer() instanceof SourceInstanceSelector) {
					toSelect.add(((SourceInstanceSelector) importer.eContainer()).getReferenceAttribute());
				}

				/*
				 * If an AttributeMapping is selected, select all source attributes and the target attribute.
				 */
			} else if (selected instanceof AttributeMapping) {

				AttributeMapping mapping = (AttributeMapping) selected;

				toSelect.add(mapping.getTarget());

				for (AttributeMappingSourceInterface c : mapping.getSourceElements()) {
					if (c instanceof DynamicSourceElement<?, ?, ?, ?>) {
						toSelect.add(((DynamicSourceElement<?, ?, ?, ?>) c).getSource());
					}
				}

				/*
				 * If a CardinalityMapping is selected, select its source and target classes.
				 */
			} else if (selected instanceof CardinalityMapping) {

				CardinalityMapping mapping = (CardinalityMapping) selected;

				toSelect.add(mapping.getSource());
				toSelect.add(mapping.getTarget());

				for (CardinalityMappingSourceInterface c : mapping.getSourceElements()) {
					if (c instanceof DynamicSourceElement<?, ?, ?, ?>) {
						toSelect.add(((DynamicSourceElement<?, ?, ?, ?>) c).getSource());
					}
				}

				/*
				 * If a TargetInstanceSelector is selected, select the target elements that it points to.
				 */
			} else if (selected instanceof TargetInstanceSelector) {

				TargetInstanceSelector selector = (TargetInstanceSelector) selected;

				for (InstanceSelectorSourceInterface c : selector.getSourceElements()) {
					if (c instanceof DynamicSourceElement<?, ?, ?, ?>) {
						toSelect.add(((DynamicSourceElement<?, ?, ?, ?>) c).getSource());
					}
				}

				toSelect.add(selector.getTargetClass());
				toSelect.add(selector.getReferenceAttribute());

				if (selector instanceof ReferenceTargetSelector) {
					toSelect.add(((ReferenceTargetSelector) selector).getAffectedReference());
				}

				/*
				 * If a MappedAttributeValueExpander is selected, select ist source attribute and the targets of all
				 * associated expandable hints.
				 */
			} else if (selected instanceof MappedAttributeValueExpander) {

				MappedAttributeValueExpander exp = (MappedAttributeValueExpander) selected;

				for (ExpandableHint m : exp.getHintsToExpand()) {
					if (m.eContainer() instanceof AttributeMapping) {
						toSelect.add(((AttributeMapping) m.eContainer()).getTarget());
					} else if (m.eContainer() instanceof CardinalityMapping) {
						toSelect.add(((CardinalityMapping) m.eContainer()).getTarget());
					} else if (m.eContainer() instanceof TargetInstanceSelector) {
						toSelect.add(((TargetInstanceSelector) m.eContainer()).getReferenceAttribute());
						toSelect.add(((TargetInstanceSelector) m.eContainer()).getTargetClass());
						if (m.eContainer() instanceof ReferenceTargetSelector) {
							toSelect.add(((ReferenceTargetSelector) m.eContainer()).getAffectedReference());
						}
					} else if (m.eContainer() instanceof SourceInstanceSelector) {
						toSelect.add(((SourceInstanceSelector) m.eContainer()).getReferenceAttribute());
					}
				}

				if (exp instanceof LocalMappedAttributeValueExpander) {
					toSelect.add(((LocalMappedAttributeValueExpander) exp).getSource());
				} else if (exp instanceof ExternalMappedAttributeValueExpander) {
					toSelect.add(((ExternalMappedAttributeValueExpander) exp).getSource());
				}

			}

			PamtramEditorMainPage.this.editor.setSelection(new StructuredSelection(
					toSelect.stream().filter(Objects::nonNull).collect(Collectors.toSet()).toArray()));
		}

	}

	/**
	 * A {@link SourceViewerSelectionListener} that handles selections in the
	 * {@link PamtramEditorMainPage#globalElementsViewer}.
	 * <p />
	 * It automatically expands referenced elements. For example, if a {@link GlobalAttribute} is selected, the
	 * associated {@link SourceSectionAttribute} is expanded so that the user can easily determine it.
	 *
	 * @author mfreund
	 */
	private final class GlobalElementsViewerSelectionListener extends SetViewerSelectionListener {

		private GlobalElementsViewerSelectionListener(TreeViewer viewer) {

			super(PamtramEditorMainPage.this.editor, viewer);
		}

		@Override
		protected void handleSingleSelection(Object selected, SelectionEvent e) {

			if (selected instanceof GlobalAttribute) {

				PamtramEditorMainPage.this.editor
						.setSelection(new StructuredSelection(Arrays.asList(((GlobalAttribute) selected).getSource())));
			}

		}
	}

	/**
	 * A {@link SetViewerSelectionListener} that also handles selections in the
	 * {@link PamtramEditorMainPage#targetViewer}.
	 * <p />
	 * It automatically expands referenced {@link TargetSectionClass TargetSectionClasses} if a
	 * {@link TargetSectionCrossReference} is selected.
	 *
	 * @author mfreund
	 */
	private final class TargetViewerSelectionListener extends SetViewerSelectionListener {

		private TargetViewerSelectionListener(TreeViewer viewer) {

			super(PamtramEditorMainPage.this.editor, PamtramEditorMainPage.this.targetViewer);
		}

		@Override
		protected void handleSingleSelection(Object selected, SelectionEvent e) {

			// if a non containment reference has been selected while holding
			// down the
			// control key, jump to the referenced class
			if (selected instanceof TargetSectionCrossReference && e.stateMask == SWT.CTRL) {

				EList<pamtram.structure.target.TargetSectionClass> referencedElements = ((TargetSectionCrossReference) selected)
						.getValue();

				PamtramEditorMainPage.this.editor.setSelection(new StructuredSelection(referencedElements));
			}
		}
	}

	/**
	 * An abstract base class that adds a {@link ToolItem} that will trigger the importing of some elements into a given
	 * {@link PAMTraM} model.
	 *
	 * @author mfreund
	 */
	public abstract class TreeViewerGroupToolbarImportButtonOption implements TreeViewerGroupToolbarOption {

		/**
		 * The added item.
		 */
		protected ToolItem item;

		/**
		 * The tool-tip text for the import button.
		 */
		protected String toolTipText;

		/**
		 * The {@link SelectionListener2} that is be called when the created <em>Import</em> tool item is clicked by the
		 * user.
		 */
		protected SelectionListener2 selectionListener;

		/**
		 * The containing TreeViewerGroup.
		 */
		protected TreeViewerGroup group;

		/**
		 * This creates an instance without setting the {@link #selectionListener}. If this constructor is used, the
		 * {@link #selectionListener} should be set manually via {@link #setSelectionListener(SelectionListener2)}.
		 * Otherwise, nothing happens when the option is selected by the user.
		 *
		 * @param toolTipText
		 *            The tool-tip text for the import button.
		 *
		 */
		public TreeViewerGroupToolbarImportButtonOption(String toolTipText) {

			this.toolTipText = toolTipText;
			this.selectionListener = null;
		}

		/**
		 * This creates an instance.
		 *
		 * @param toolTipText
		 *            The tool-tip text for the import button.
		 * @param listener
		 *            The {@link SelectionListener2} to be called when the created <em>Import</em> tool item is clicked
		 *            by the user.
		 *
		 */
		public TreeViewerGroupToolbarImportButtonOption(String toolTipText, SelectionListener2 listener) {

			this.toolTipText = toolTipText;
			this.selectionListener = listener;
		}

		/**
		 * Set/update the {@link #selectionListener}.
		 *
		 * @param selectionListener
		 *            the selectionListener to set
		 */
		public void setSelectionListener(SelectionListener2 selectionListener) {

			if (this.item != null && this.selectionListener != null) {
				this.item.removeSelectionListener(this.selectionListener);
			}
			this.selectionListener = selectionListener;
			if (this.item != null) {
				this.item.addSelectionListener(selectionListener);
			}
		}

		@Override
		public void addToolbarControls(TreeViewerGroup group, ToolBar toolbar, TreeViewerGroupOption[] options) {

			this.group = group;
			this.item = new ToolItem(toolbar, SWT.PUSH);
			this.item.setImage(BundleContentHelper.getBundleImage(PamtramEditorPlugin.getPlugin().getSymbolicName(),
					"icons/import_wiz.gif"));
			this.item.setToolTipText(this.toolTipText);
			if (this.selectionListener != null) {
				this.item.addSelectionListener(this.selectionListener);
			}

		}

		@Override
		public void dispose() {

			this.item.dispose();
		}
	}

	/**
	 * A {@link TreeViewerGroupToolbarImportButtonOption} that allows to import shared {@link SectionModel
	 * SectionModels}.
	 */
	public class TreeViewerGroupToolbarImportSharedSectionModelButtonOption
			extends TreeViewerGroupToolbarImportButtonOption {

		/**
		 * This creates an instance.
		 *
		 * @param pamtram
		 *            The {@link PAMTraM} instance into which elements shall be imported.
		 * @param editingDomain
		 *            The {@link EditingDomain} that shall be used to import elements.
		 * @param sharedModelType
		 *            The {@link SharedModelType type} of shared model to be imported.
		 */
		public TreeViewerGroupToolbarImportSharedSectionModelButtonOption(PAMTraM pamtram, EditingDomain editingDomain,
				SharedModelType sharedModelType) {

			super("Import Shared Model", null);
			this.setSelectionListener((SelectionListener2) e -> {

				// create the wizard that allows to import shared
				// SourceSectionModels
				//
				WizardDialog wizardDialog = new WizardDialog(UIHelper.getShell(),
						new ImportSharedModelWizard(pamtram, editingDomain, this.group.getViewer(), sharedModelType));
				wizardDialog.create();
				wizardDialog.open();

				// Ensure that the source section viewer is not minimized
				//
				switch (sharedModelType) {
					case SOURCE:
						if (PamtramEditorMainPage.this.sourceViewerGroup
								.equals(PamtramEditorMainPage.this.sourceSash.getMinimizedControl())) {
							PamtramEditorMainPage.this.sourceSash.restoreLayout();
						}
						break;
					case CONDITION:
						if (PamtramEditorMainPage.this.conditionViewerGroup
								.equals(PamtramEditorMainPage.this.sourceSash.getMinimizedControl())) {
							PamtramEditorMainPage.this.sourceSash.restoreLayout();
						}
						break;
					case MAPPING:
						if (PamtramEditorMainPage.this.mappingViewerGroup
								.equals(PamtramEditorMainPage.this.mappingSash.getMinimizedControl())) {
							PamtramEditorMainPage.this.mappingSash.restoreLayout();
						}
						break;
					case TARGET:
						if (PamtramEditorMainPage.this.targetViewerGroup
								.equals(PamtramEditorMainPage.this.targetSash.getMinimizedControl())) {
							PamtramEditorMainPage.this.targetSash.restoreLayout();
						}
						break;
					default:
						break;
				}
			});
		}

	}

	/**
	 * A {@link TreeViewerGroupToolbarImportButtonOption} that allows to import {@link LibraryEntry LibraryEntries}.
	 */
	public class TreeViewerGroupToolbarImportLibraryEntryButtonOption extends TreeViewerGroupToolbarImportButtonOption {

		/**
		 * This creates an instance.
		 *
		 * @param pamtram
		 *            The {@link PAMTraM} instance into which elements shall be imported.
		 * @param editingDomain
		 *            The {@link EditingDomain} that shall be used to import elements.
		 */
		public TreeViewerGroupToolbarImportLibraryEntryButtonOption(PAMTraM pamtram, EditingDomain editingDomain) {

			super("Import Library Entry", null);
			this.setSelectionListener((SelectionListener2) e -> {

				// create the wizard that allows to import LibraryEntries
				//
				WizardDialog wizardDialog = new WizardDialog(new Shell(), new ImportLibraryElementWizard(pamtram,
						editingDomain, this.group.getViewer(), PamtramEditorMainPage.this.mappingViewer));
				wizardDialog.create();
				wizardDialog.open();

				// Ensure that the library element viewer and the mapping viewer
				// are not minimized
				//
				if (PamtramEditorMainPage.this.libTargetViewerGroup
						.equals(PamtramEditorMainPage.this.targetSash.getMinimizedControl())) {
					PamtramEditorMainPage.this.targetSash.restoreLayout();
				}
				if (PamtramEditorMainPage.this.mappingViewerGroup
						.equals(PamtramEditorMainPage.this.mappingSash.getMinimizedControl())) {
					PamtramEditorMainPage.this.mappingSash.restoreLayout();
				}
			});

		}

	}

	/**
	 * This intializes the page by minimizing the {@link #conditionViewerGroup}, the {@link #globalElementsViewerGroup},
	 * and the {@link #libTargetViewerGroup}.
	 *
	 */
	public void init() {

		this.sourceSash.minimizeControl(this.conditionViewerGroup);
		this.mappingSash.minimizeControl(this.globalElementsViewerGroup);
		this.targetSash.minimizeControl(this.libTargetViewerGroup);
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
			} else if (this.editor.currentViewer.equals(this.conditionViewer)) {
				activeViewer = "CONDITION_VIEWER";
			} else if (this.editor.currentViewer.equals(this.mappingViewer)) {
				activeViewer = "MAPPING_VIEWER";
			} else if (this.editor.currentViewer.equals(this.globalElementsViewer)) {
				activeViewer = "GLOBAL_ELEMENTS_VIEWER";
			} else if (this.editor.currentViewer.equals(this.targetViewer)) {
				activeViewer = "TARGET_VIEWER";
			} else if (this.editor.currentViewer.equals(this.libTargetViewer)) {
				activeViewer = "LIB_TARGET_VIEWER";
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
		if (this.editor.getSelectedPage() != null && this.editor.getSelectedPage().equals(this)
				&& settings.get("ACTIVE_VIEWER") != null) {

			String activeViewer = settings.get("ACTIVE_VIEWER");
			if (activeViewer.equals("SOURCE_VIEWER")) {
				this.editor.setCurrentViewer(this.sourceViewer);
			} else if (activeViewer.equals("CONDITION_VIEWER")) {
				this.editor.setCurrentViewer(this.conditionViewer);
			} else if (activeViewer.equals("MAPPING_VIEWER")) {
				this.editor.setCurrentViewer(this.mappingViewer);
			} else if (activeViewer.equals("GLOBAL_ELEMENTS_VIEWER")) {
				this.editor.setCurrentViewer(this.globalElementsViewer);
			} else if (activeViewer.equals("TARGET_VIEWER")) {
				this.editor.setCurrentViewer(this.targetViewer);
			} else if (activeViewer.equals("LIB_TARGET_VIEWER")) {
				this.editor.setCurrentViewer(this.libTargetViewer);
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

		// Restore the state of the 'sourceSash'
		//
		if (settings.getSection("SOURCE_SASH") != null) {
			this.sourceSash.restore(settings.getSection("SOURCE_SASH"));
		}

		// Restore the state of the 'mappingSash'
		//
		if (settings.getSection("MAPPING_SASH") != null) {
			this.mappingSash.restore(settings.getSection("MAPPING_SASH"));
		}

		// Restore the state of the 'targetSash'
		//
		if (settings.getSection("TARGET_SASH") != null) {
			this.targetSash.restore(settings.getSection("TARGET_SASH"));
		}

		// Restore the expanded tree paths of the various tree viewers
		//
		if (settings.getSection("SOURCE_VIEWER") != null) {
			this.sourceViewerGroup.restore(settings.getSection("SOURCE_VIEWER"));
		}
		if (settings.getSection("CONDITION_VIEWER") != null) {
			this.conditionViewerGroup.restore(settings.getSection("CONDITION_VIEWER"));
		}
		if (settings.getSection("MAPPING_VIEWER") != null) {
			this.mappingViewerGroup.restore(settings.getSection("MAPPING_VIEWER"));
		}
		if (settings.getSection("GLOBAL_ELEMENTS_VIEWER") != null) {
			this.globalElementsViewerGroup.restore(settings.getSection("GLOBAL_ELEMENTS_VIEWER"));
		}
		if (settings.getSection("TARGET_VIEWER") != null) {
			this.targetViewerGroup.restore(settings.getSection("TARGET_VIEWER"));
		}
		if (settings.getSection("LIB_TARGET_VIEWER") != null) {
			this.libTargetViewerGroup.restore(settings.getSection("LIB_TARGET_VIEWER"));
		}
	}

	@Override
	public Collection<ISelectionProvider> getWrappedProviders() {

		return Arrays.asList(this.sourceViewerGroup, this.conditionViewerGroup, this.mappingViewerGroup,
				this.globalElementsViewerGroup, this.targetViewerGroup, this.libTargetViewerGroup);
	}

}
