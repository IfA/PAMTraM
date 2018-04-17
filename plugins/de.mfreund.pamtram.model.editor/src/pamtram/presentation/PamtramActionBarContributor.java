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
/**
 */
package pamtram.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.PAMTraM;
import pamtram.SectionModel;
import pamtram.actions.CreateSharedModelChildAction;
import pamtram.actions.CreateSharedModelSiblingAction;
import pamtram.actions.CutClassAndPasteAsNewSectionAction;
import pamtram.actions.GenericConversionCommandAction;
import pamtram.actions.MetaModelElementMergeAction;
import pamtram.actions.PamtramDeleteAction;
import pamtram.contentprovider.IFeatureValidator;
import pamtram.converter.HintGroupToExportedHintGroupConverter;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.structure.generic.MetaModelElement;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;
import pamtram.util.SharedModelUtil;

/**
 * This is the action bar contributor for the Pamtram model editor. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class PamtramActionBarContributor extends EditingDomainActionBarContributor
		implements ISelectionChangedListener {

	/**
	 * This keeps track of the active editor. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;

	/**
	 * This action opens the Properties view. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected IAction showPropertiesViewAction = new Action(
			PamtramEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) {

		@Override
		public void run() {

			try {
				PamtramActionBarContributor.this.getPage().showView("org.eclipse.ui.views.PropertySheet");
			} catch (PartInitException exception) {
				PamtramEditorPlugin.INSTANCE.log(exception);
			}
		}
	};

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IAction refreshViewerAction = new Action(
			PamtramEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) {

		@Override
		public boolean isEnabled() {

			return PamtramActionBarContributor.this.activeEditorPart instanceof IViewerProvider;
		}

		@Override
		public void run() {

			if (PamtramActionBarContributor.this.activeEditorPart instanceof IViewerProvider) {
				Viewer viewer = ((IViewerProvider) PamtramActionBarContributor.this.activeEditorPart).getViewer();
				if (viewer != null) {
					viewer.refresh();
				}
			}
		}
	};

	/**
	 * This will contain one
	 * {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to
	 * each descriptor generated for the current selection by the item provider.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Collection<IAction> createChildActions;

	/**
	 * This is the menu manager into which menu contribution items should be
	 * added for CreateChild actions. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected IMenuManager createChildMenuManager;

	/**
	 * This will contain one
	 * {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding
	 * to each descriptor generated for the current selection by the item
	 * provider. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Collection<IAction> createSiblingActions;

	/**
	 * This is the menu manager into which menu contribution items should be
	 * added for CreateSibling actions. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected IMenuManager createSiblingMenuManager;

	/**
	 * Other Menu Actions
	 */
	protected Collection<IAction> otherActions;

	/**
	 * This is the menu manager into which menu contribution items should be
	 * added for "other actions" actions.
	 */
	protected IMenuManager otherActionsMenuManager;

	/**
	 * This creates an instance of the contributor. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public PamtramActionBarContributor() {
		super(EditingDomainActionBarContributor.ADDITIONS_LAST_STYLE);
		this.loadResourceAction = new LoadResourceAction();
		this.validateAction = new ValidateAction();
		this.liveValidationAction = new DiagnosticDecorator.LiveValidator.LiveValidationAction(
				PamtramEditorPlugin.getPlugin().getDialogSettings());
		this.controlAction = new ControlAction();
	}

	/**
	 * This adds Separators for editor additions to the tool bar. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {

		toolBarManager.add(new Separator("pamtram-settings"));
		toolBarManager.add(new Separator("pamtram-additions"));
	}

	/**
	 * This adds to the menu bar a menu and some separators for editor
	 * additions, as well as the sub-menus for object creation items. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 */
	@Override
	public void contributeToMenu(IMenuManager menuManager) {

		super.contributeToMenu(menuManager);

		IMenuManager submenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_PamtramEditor_menu"),
				"pamtramMenuID");
		menuManager.insertAfter("additions", submenuManager);
		submenuManager.add(new Separator("settings"));
		submenuManager.add(new Separator("actions"));
		submenuManager.add(new Separator("additions"));
		submenuManager.add(new Separator("additions-end"));

		// Prepare for CreateChild item addition or removal.
		//
		this.createChildMenuManager = new MenuManager(
				PamtramEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
		submenuManager.insertBefore("additions", this.createChildMenuManager);

		// Prepare for CreateSibling item addition or removal.
		//
		this.createSiblingMenuManager = new MenuManager(
				PamtramEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
		submenuManager.insertBefore("additions", this.createSiblingMenuManager);

		// Prepare for other actions item addition or removal.
		//
		this.otherActionsMenuManager = new MenuManager("other actions");
		submenuManager.insertBefore("additions", this.otherActionsMenuManager);

		// Force an update because Eclipse hides empty menus now.
		//
		submenuManager.addMenuListener(menuManager1 -> menuManager1.updateAll(true));

		this.addGlobalActions(submenuManager);
	}

	/**
	 * When the active editor changes, this remembers the change and registers
	 * with it as a selection provider. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setActiveEditor(IEditorPart part) {

		super.setActiveEditor(part);
		this.activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (this.selectionProvider != null) {
			this.selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			this.selectionProvider = null;
		} else {
			this.selectionProvider = part.getSite().getSelectionProvider();
			this.selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (this.selectionProvider.getSelection() != null) {
				this.selectionChanged(
						new SelectionChangedEvent(this.selectionProvider, this.selectionProvider.getSelection()));
			}
		}
	}

	/**
	 * This implements
	 * {@link org.eclipse.jface.viewers.ISelectionChangedListener}, handling
	 * {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for
	 * the children and siblings that can be added to the selected object and
	 * updating the menus accordingly. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {

		// Remove any menu items for old selection.
		//
		if (this.createChildMenuManager != null) {
			this.depopulateManager(this.createChildMenuManager, this.createChildActions);
		}
		if (this.createSiblingMenuManager != null) {
			this.depopulateManager(this.createSiblingMenuManager, this.createSiblingActions);
		}
		if (this.otherActionsMenuManager != null) {
			this.depopulateManager(this.otherActionsMenuManager, this.otherActions);
		}

		// Query the new selection for appropriate new child/sibling descriptors
		//
		Collection<?> newChildDescriptors = null;
		Collection<?> newSiblingDescriptors = null;
		Object otherActionsDescriptor = null;
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			Object object = ((IStructuredSelection) selection).getFirstElement();

			EditingDomain domain = ((IEditingDomainProvider) this.activeEditorPart).getEditingDomain();

			newChildDescriptors = domain.getNewChildDescriptors(object, null);
			newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
			otherActionsDescriptor = object;

		}

		// Generate actions for selection; populate and redraw the menus.
		//
		this.createChildActions = this.generateCreateChildActions(newChildDescriptors, selection);
		this.createSiblingActions = this.generateCreateSiblingActions(newSiblingDescriptors, selection);
		this.otherActions = this.generateOtherActionsActions(otherActionsDescriptor, selection);

		if (this.createChildMenuManager != null) {
			this.populateManager(this.createChildMenuManager, this.createChildActions, null);
			this.createChildMenuManager.update(true);
		}
		if (this.createSiblingMenuManager != null) {
			this.populateManager(this.createSiblingMenuManager, this.createSiblingActions, null);
			this.createSiblingMenuManager.update(true);
		}
		if (this.otherActionsMenuManager != null) {
			this.populateManager(this.otherActionsMenuManager, this.otherActions, null);
			this.otherActionsMenuManager.update(true);
		}
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction}
	 * for each object in <code>descriptors</code>, and returns the collection
	 * of these actions. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {

		Collection<IAction> actions = new ArrayList<>();
		if (descriptors != null) {

			IContentProvider provider = null;
			if (this.activeEditorPart instanceof PamtramEditor
					&& ((PamtramEditor) this.activeEditorPart).getViewer() instanceof ContentViewer) {
				provider = ((ContentViewer) ((PamtramEditor) this.activeEditorPart).getViewer()).getContentProvider();
			}

			for (Object descriptor : descriptors) {

				if (this.isValidDescriptor(descriptor, provider)) {
					if (descriptor instanceof CommandParameter
							&& ((CommandParameter) descriptor).getFeature() instanceof EStructuralFeature
							&& SharedModelUtil.isValidSubModelFeature(
									(EStructuralFeature) ((CommandParameter) descriptor).getFeature())) {
						actions.add(new CreateSharedModelChildAction(this.activeEditorPart, selection, descriptor));
					} else {
						actions.add(new CreateChildAction(this.activeEditorPart, selection, descriptor));
					}
				}

			}
		}
		return actions;
	}

	protected Collection<IAction> generateOtherActionsActions(final Object descriptor, ISelection selection) {

		Collection<IAction> actions = new ArrayList<>();
		if (descriptor instanceof MappingHintGroup) {
			actions.add(new GenericConversionCommandAction<>(this.activeEditorPart, selection,
					"Convert to exported MappingHintGroup", MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS,
					(MappingHintGroup) descriptor, new HintGroupToExportedHintGroupConverter()));
		} else if (descriptor instanceof pamtram.structure.generic.Class) {
			// the section may be 'null' if the class is not part of a target
			// section but of a library element
			pamtram.structure.generic.Class<?, ?, ?, ?> section = ((pamtram.structure.generic.Class<?, ?, ?, ?>) descriptor)
					.getContainingSection();
			if (section != null && !section.equals(descriptor)) {
				actions.add(new CutClassAndPasteAsNewSectionAction(
						(pamtram.structure.generic.Class<?, ?, ?, ?>) descriptor));
			}
		} else if (selection instanceof StructuredSelection && ((StructuredSelection) selection).size() > 1) {

			List<Object> selectedElements = Arrays.asList(((StructuredSelection) selection).toArray());

			Set<Class<? extends Object>> types = selectedElements.parallelStream().map(e -> e.getClass())
					.collect(Collectors.toSet());

			if (types.size() == 1 && MetaModelElement.class.isAssignableFrom(types.iterator().next())) {
				Class<? extends Object> metaModelElementClass = types.iterator().next();

				if (SourceSectionClass.class.isAssignableFrom(metaModelElementClass)
						|| SourceSectionReference.class.isAssignableFrom(metaModelElementClass)
						|| SourceSectionAttribute.class.isAssignableFrom(metaModelElementClass)) {
					actions.add(
							new MetaModelElementMergeAction<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>(
									this.activeEditorPart, (IStructuredSelection) selection));
				} else if (TargetSectionClass.class.isAssignableFrom(metaModelElementClass)
						|| TargetSectionReference.class.isAssignableFrom(metaModelElementClass)
						|| TargetSectionAttribute.class.isAssignableFrom(metaModelElementClass)) {
					actions.add(
							new MetaModelElementMergeAction<TargetSection, TargetSectionClass, TargetSectionReference, TargetSectionAttribute>(
									this.activeEditorPart, (IStructuredSelection) selection));
				}
			}
		}

		return actions;
	}

	/**
	 * This generates a
	 * {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each
	 * object in <code>descriptors</code>, and returns the collection of these
	 * actions. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection) {

		Collection<IAction> actions = new ArrayList<>();

		if (descriptors != null) {

			IContentProvider provider = null;
			if (this.activeEditorPart instanceof PamtramEditor
					&& ((PamtramEditor) this.activeEditorPart).getViewer() instanceof ContentViewer) {
				provider = ((ContentViewer) ((PamtramEditor) this.activeEditorPart).getViewer()).getContentProvider();
			}

			for (Object descriptor : descriptors) {

				if (this.isValidDescriptor(descriptor, provider)) {
					if (descriptor instanceof CommandParameter
							&& ((CommandParameter) descriptor).getFeature() instanceof EStructuralFeature
							&& SharedModelUtil.isValidSubModelFeature(
									(EStructuralFeature) ((CommandParameter) descriptor).getFeature())) {
						actions.add(new CreateSharedModelSiblingAction(this.activeEditorPart, selection, descriptor));
					} else {
						actions.add(new CreateSiblingAction(this.activeEditorPart, selection, descriptor));
					}
				}

			}

			// The user selected a shared SectionModel (that is not contained in
			// a PAMTraM model but in its own resource); thus, we need to
			// handle the creation of SectionModels as siblings
			// manually
			//
			if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1
					&& ((IStructuredSelection) selection).getFirstElement() instanceof SectionModel<?, ?, ?, ?>) {
				SectionModel<?, ?, ?, ?> object = (SectionModel<?, ?, ?, ?>) ((IStructuredSelection) selection)
						.getFirstElement();

				if (!(object.eContainer() instanceof PAMTraM)) {

					PAMTraM pamtram = ((PamtramEditor) this.activeEditorPart).getPamtram();
					List<Object> customDescriptors = new ArrayList<>(
							AgteleEcoreUtil.getAdapterFactoryItemDelegatorFor(pamtram).getNewChildDescriptors(pamtram,
									((PamtramEditor) this.activeEditorPart).getEditingDomain(), null));

					// A custom selection to make the Action think the user
					// selected the 'parent' PAMTraM model
					//
					ISelection customSelection = new StructuredSelection(pamtram);

					for (Object descriptor : customDescriptors) {

						if (this.isValidDescriptor(descriptor, provider)) {

							// Use 'CreateChild' instead of 'CreateSibling'
							// actions based on the (virtually) selected parent
							// PAMTraM model
							//
							if (descriptor instanceof CommandParameter
									&& ((CommandParameter) descriptor).getFeature() instanceof EStructuralFeature
									&& SharedModelUtil.isValidSubModelFeature(
											(EStructuralFeature) ((CommandParameter) descriptor).getFeature())) {
								actions.add(new CreateSharedModelChildAction(this.activeEditorPart, customSelection,
										descriptor));
							} else {
								actions.add(new CreateChildAction(this.activeEditorPart, customSelection, descriptor));
							}
						}

					}
				}
			}
		}

		return actions;
	}

	/**
	 * This is used by
	 * {@link #generateCreateChildActions(Collection, ISelection)} and
	 * {@link #generateCreateSiblingActions(Collection, ISelection)} to perform
	 * additional checks if an action corresponding to the given
	 * <em>descriptor</em> is valid for the active <em>content provider</em>.
	 *
	 * @param descriptor
	 *            The {@link CommandParameter} that describes an action to be
	 *            executed.
	 * @param provider
	 *            The {@link IContentProvider content provider} that is
	 *            associated with the active viewer.
	 * @return '<em><b>true</b></em>' if the descriptor is valid for the active
	 *         viewer; '<em><b>false</b></em>' otherwise.
	 */
	private boolean isValidDescriptor(Object descriptor, IContentProvider provider) {

		if (descriptor == null || provider == null) {
			return false;
		}

		if (!(descriptor instanceof CommandParameter)
				|| !(((CommandParameter) descriptor).getFeature() instanceof EStructuralFeature)) {
			return true;
		}

		CommandParameter commandParam = (CommandParameter) descriptor;

		if (provider instanceof IFeatureValidator) {
			return ((IFeatureValidator) provider).isValidFeature((EStructuralFeature) commandParam.getFeature());
		}

		return true;
	}

	/**
	 * This populates the specified <code>manager</code> with
	 * {@link org.eclipse.jface.action.ActionContributionItem}s based on the
	 * {@link org.eclipse.jface.action.IAction}s contained in the
	 * <code>actions</code> collection, by inserting them before the specified
	 * contribution item <code>contributionID</code>. If
	 * <code>contributionID</code> is <code>null</code>, they are simply added.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void populateManager(IContributionManager manager, Collection<? extends IAction> actions,
			String contributionID) {

		if (actions != null) {
			for (IAction action : actions) {
				if (contributionID != null) {
					manager.insertBefore(contributionID, action);
				} else {
					manager.add(action);
				}
			}
		}
	}

	/**
	 * This removes from the specified <code>manager</code> all
	 * {@link org.eclipse.jface.action.ActionContributionItem}s based on the
	 * {@link org.eclipse.jface.action.IAction}s contained in the
	 * <code>actions</code> collection. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions) {

		if (actions != null) {
			IContributionItem[] items = manager.getItems();
			for (IContributionItem item : items) {
				// Look into SubContributionItems
				//
				IContributionItem contributionItem = item;
				while (contributionItem instanceof SubContributionItem) {
					contributionItem = ((SubContributionItem) contributionItem).getInnerItem();
				}

				// Delete the ActionContributionItems with matching action.
				//
				if (contributionItem instanceof ActionContributionItem) {
					IAction action = ((ActionContributionItem) contributionItem).getAction();
					if (actions.contains(action)) {
						manager.remove(contributionItem);
					}
				}
			}
		}
	}

	/**
	 * This populates the pop-up menu before it appears. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {

		super.menuAboutToShow(menuManager);
		MenuManager submenuManager = null;

		submenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
		this.populateManager(submenuManager, this.createChildActions, null);
		menuManager.insertBefore("edit", submenuManager);

		submenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
		this.populateManager(submenuManager, this.createSiblingActions, null);
		menuManager.insertBefore("edit", submenuManager);

		submenuManager = new MenuManager("other actions");
		this.populateManager(submenuManager, this.otherActions, null);
		menuManager.insertBefore("edit", submenuManager);
	}

	/**
	 * This inserts global actions before the "additions-end" separator. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void addGlobalActions(IMenuManager menuManager) {

		menuManager.insertAfter("additions-end", new Separator("ui-actions"));
		menuManager.insertAfter("ui-actions", this.showPropertiesViewAction);

		this.refreshViewerAction.setEnabled(this.refreshViewerAction.isEnabled());
		menuManager.insertAfter("ui-actions", this.refreshViewerAction);

		super.addGlobalActions(menuManager);
	}

	/**
	 * This ensures that a delete action will clean up all references to deleted
	 * objects. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean removeAllReferencesOnDelete() {

		return true;
	}

	@Override
	protected DeleteAction createDeleteAction() {

		// Use the special PamtramDeleteAction which allows to also delete
		// shared SectionModels
		//
		return new PamtramDeleteAction(this.removeAllReferencesOnDelete());
	}

}
