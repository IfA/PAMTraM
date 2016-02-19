/**
 */
package pamtram.presentation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.action.CreateSiblingAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;

import pamtram.PamtramPackage;
import pamtram.contentprovider.ConditionContentProvider;
import pamtram.contentprovider.LibraryEntryContentProvider;
import pamtram.contentprovider.MappingContentProvider;
import pamtram.contentprovider.ModifierSetContentProvider;
import pamtram.contentprovider.SourceSectionContentProvider;
import pamtram.contentprovider.TargetSectionContentProvider;
import pamtram.converter.HintGroupToExportedHintGroupConverter;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingPackage;
import pamtram.metamodel.MetaModelElement;
import pamtram.presentation.actions.CutClassAndPasteAsNewSectionAction;
import pamtram.presentation.actions.GenericConversionCommandAction;

/**
 * This is the action bar contributor for the Pamtram model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PamtramActionBarContributor
	extends EditingDomainActionBarContributor
	implements ISelectionChangedListener {
	/**
	 * This keeps track of the active editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;

	/**
	 * This action opens the Properties view.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction showPropertiesViewAction =
		new Action(PamtramEditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) {
			@Override
			public void run() {
				try {
					getPage().showView("org.eclipse.ui.views.PropertySheet");
				}
				catch (PartInitException exception) {
					PamtramEditorPlugin.INSTANCE.log(exception);
				}
			}
		};

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction refreshViewerAction =
		new Action(PamtramEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) {
			@Override
			public boolean isEnabled() {
				return activeEditorPart instanceof IViewerProvider;
			}

			@Override
			public void run() {
				if (activeEditorPart instanceof IViewerProvider) {
					Viewer viewer = ((IViewerProvider)activeEditorPart).getViewer();
					if (viewer != null) {
						viewer.refresh();
					}
				}
			}
		};

	/**
	 * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateChildAction} corresponding to each descriptor
	 * generated for the current selection by the item provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<IAction> createChildActions;

	/**
	 * This is the menu manager into which menu contribution items should be added for CreateChild actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMenuManager createChildMenuManager;

	/**
	 * This will contain one {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} corresponding to each descriptor
	 * generated for the current selection by the item provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<IAction> createSiblingActions;	

	/**
	 * This is the menu manager into which menu contribution items should be added for CreateSibling actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IMenuManager createSiblingMenuManager;
	
	/**
	 * Other Menu Actions
	 */
	protected Collection<IAction> otherActions;
	
	/**
	 * This is the menu manager into which menu contribution items should be added for "other actions" actions.
	 */
	protected IMenuManager otherActionsMenuManager;

	/**
	 * This creates an instance of the contributor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PamtramActionBarContributor() {
		super(ADDITIONS_LAST_STYLE);
		loadResourceAction = new LoadResourceAction();
		validateAction = new ValidateAction();
		liveValidationAction = new DiagnosticDecorator.LiveValidator.LiveValidationAction(PamtramEditorPlugin.getPlugin().getDialogSettings());
		controlAction = new ControlAction();
	}

	/**
	 * This adds Separators for editor additions to the tool bar.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		toolBarManager.add(new Separator("pamtram-settings"));
		toolBarManager.add(new Separator("pamtram-additions"));
	}

	/**
	 * This adds to the menu bar a menu and some separators for editor additions,
	 * as well as the sub-menus for object creation items.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);

		IMenuManager submenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_PamtramEditor_menu"), "pamtramMenuID");
		menuManager.insertAfter("additions", submenuManager);
		submenuManager.add(new Separator("settings"));
		submenuManager.add(new Separator("actions"));
		submenuManager.add(new Separator("additions"));
		submenuManager.add(new Separator("additions-end"));

		// Prepare for CreateChild item addition or removal.
		//
		createChildMenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
		submenuManager.insertBefore("additions", createChildMenuManager);

		// Prepare for CreateSibling item addition or removal.
		//
		createSiblingMenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
		submenuManager.insertBefore("additions", createSiblingMenuManager);

		// Prepare for other actions item addition or removal.
		//		
		otherActionsMenuManager = new MenuManager("other actions");
		submenuManager.insertBefore("additions", otherActionsMenuManager);
		
		// Force an update because Eclipse hides empty menus now.
		//
		submenuManager.addMenuListener
			(new IMenuListener() {
				 @Override
				public void menuAboutToShow(IMenuManager menuManager) {
					 menuManager.updateAll(true);
				 }
			 });

		addGlobalActions(submenuManager);
	}

	/**
	 * When the active editor changes, this remembers the change and registers with it as a selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		}
		else {
			selectionProvider = part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
	 * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for the children and siblings
	 * that can be added to the selected object and updating the menus accordingly.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		// Remove any menu items for old selection.
		//
		if (createChildMenuManager != null) {
			depopulateManager(createChildMenuManager, createChildActions);
		}
		if (createSiblingMenuManager != null) {
			depopulateManager(createSiblingMenuManager, createSiblingActions);
		}
		if(otherActionsMenuManager != null){
			depopulateManager(otherActionsMenuManager, otherActions);
		}

		// Query the new selection for appropriate new child/sibling descriptors
		//
		Collection<?> newChildDescriptors = null;
		Collection<?> newSiblingDescriptors = null;
		Object otherActionsDescriptor=null;
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
			Object object = ((IStructuredSelection)selection).getFirstElement();

			EditingDomain domain = ((IEditingDomainProvider)activeEditorPart).getEditingDomain();

			newChildDescriptors = domain.getNewChildDescriptors(object, null);
			newSiblingDescriptors = domain.getNewChildDescriptors(null, object);
			otherActionsDescriptor=object;
			
		}

		// Generate actions for selection; populate and redraw the menus.
		//
		createChildActions = generateCreateChildActions(newChildDescriptors, selection);
		createSiblingActions = generateCreateSiblingActions(newSiblingDescriptors, selection);
		otherActions=generateOtherActionsActions(otherActionsDescriptor, selection);

		
		if (createChildMenuManager != null) {
			populateManager(createChildMenuManager, createChildActions, null);
			createChildMenuManager.update(true);
		}
		if (createSiblingMenuManager != null) {
			populateManager(createSiblingMenuManager, createSiblingActions, null);
			createSiblingMenuManager.update(true);
		}
		if(otherActionsMenuManager != null){
			populateManager(otherActionsMenuManager, otherActions, null);
			otherActionsMenuManager.update(true);
		}
	}

	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateChildAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection) {
		Collection<IAction> actions = new ArrayList<IAction>();
		if (descriptors != null) {
			
			IContentProvider provider = null;
			if(activeEditorPart instanceof PamtramEditor && ((PamtramEditor) activeEditorPart).getViewer() instanceof ContentViewer) {
				provider = ((ContentViewer) (((PamtramEditor) activeEditorPart).getViewer())).getContentProvider();
			}
			
			for (Object descriptor : descriptors) {
				
				if(isValidDescriptor(descriptor, provider)) {				
					actions.add(new CreateChildAction(activeEditorPart, selection, descriptor));
				}
			}
		}
		return actions;
	}
	
	protected Collection<IAction> generateOtherActionsActions(final Object descriptor, ISelection selection) {
		Collection<IAction> actions = new ArrayList<IAction>();
		if(descriptor instanceof MappingHintGroup){
			actions.add(
					new GenericConversionCommandAction<MappingHintGroup, ExportedMappingHintGroup>(
							activeEditorPart, 
							selection, 
							"Convert to exported MappingHintGroup",
							MappingPackage.Literals.MAPPING__MAPPING_HINT_GROUPS,
							(MappingHintGroup) descriptor,
							new HintGroupToExportedHintGroupConverter()));
		} else if(descriptor instanceof pamtram.metamodel.Class){
			// the section may be 'null' if the class is not part of a target section but of a library element
			pamtram.metamodel.Class section = ((MetaModelElement) descriptor).getContainingSection();
			if(section != null && !section.equals(descriptor)){
				actions.add(new CutClassAndPasteAsNewSectionAction((pamtram.metamodel.Class) descriptor));				
			}
		}
		return actions;
	}


	/**
	 * This generates a {@link org.eclipse.emf.edit.ui.action.CreateSiblingAction} for each object in <code>descriptors</code>,
	 * and returns the collection of these actions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection) {
		Collection<IAction> actions = new ArrayList<IAction>();
		if (descriptors != null) {
			
			IContentProvider provider = null;
			if(activeEditorPart instanceof PamtramEditor && ((PamtramEditor) activeEditorPart).getViewer() instanceof ContentViewer) {
				provider = ((ContentViewer) (((PamtramEditor) activeEditorPart).getViewer())).getContentProvider();
			}
			
			for (Object descriptor : descriptors) {
				
				if(isValidDescriptor(descriptor, provider)) {
					actions.add(new CreateSiblingAction(activeEditorPart, selection, descriptor));					
				}
			
			}
		}
		return actions;
	}
	
	/**
	 * This is used by {@link #generateCreateChildActions(Collection, ISelection)} and {@link #generateCreateSiblingActions(Collection, ISelection)}
	 * to perform additional checks if an action corresponding to the given <em>descriptor</em> is valid for the active <em>content provider</em>.
	 * 
	 * @param descriptor The {@link CommandParameter} that describes an action to be executed.
	 * @param provider The {@link IContentProvider content provider} that is associated with the active viewer.
	 * @return '<em><b>true</b></em>' if the descriptor is valid for the active viewer; '<em><b>false</b></em>' otherwise.
	 */
	private boolean isValidDescriptor(Object descriptor, IContentProvider provider) {
		
		if(descriptor == null || provider == null) {
			return false;
		}
		
		if(!(descriptor instanceof CommandParameter)) {
			return true;
		}
		
		CommandParameter commandParam = (CommandParameter) descriptor;
		
		if(provider instanceof SourceSectionContentProvider) {
			if(commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL)) {
				return false;
			}
		} else if(provider instanceof ConditionContentProvider) {
			if(commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL)) {
				return false;
			}
		} else if(provider instanceof MappingContentProvider) {
			if(commandParam.getFeature().equals(PamtramPackage.Literals.MAPPING_MODEL__MODIFIER_SETS) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.MAPPING_MODEL__GLOBAL_VALUES) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL)) {
				return false;
			}
		} else if(provider instanceof ModifierSetContentProvider) {
			if(commandParam.getFeature().equals(PamtramPackage.Literals.MAPPING_MODEL__MAPPING) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__TARGET_SECTION_MODEL)) {
				return false;
			}
		} else if(provider instanceof TargetSectionContentProvider) {
			if(commandParam.getFeature().equals(PamtramPackage.Literals.TARGET_SECTION_MODEL__LIBRARY_ELEMENTS) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL)) {
				return false;
			}
		}
		 else if(provider instanceof LibraryEntryContentProvider) {
			if(commandParam.getFeature().equals(PamtramPackage.Literals.SECTION_MODEL__META_MODEL_SECTIONS) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__SOURCE_SECTION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__CONDITION_MODEL) ||
					commandParam.getFeature().equals(PamtramPackage.Literals.PAM_TRA_M__MAPPING_MODEL)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * This populates the specified <code>manager</code> with {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection,
	 * by inserting them before the specified contribution item <code>contributionID</code>.
	 * If <code>contributionID</code> is <code>null</code>, they are simply added.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void populateManager(IContributionManager manager, Collection<? extends IAction> actions, String contributionID) {
		if (actions != null) {
			for (IAction action : actions) {
				if (contributionID != null) {
					manager.insertBefore(contributionID, action);
				}
				else {
					manager.add(action);
				}
			}
		}
	}
		
	/**
	 * This removes from the specified <code>manager</code> all {@link org.eclipse.jface.action.ActionContributionItem}s
	 * based on the {@link org.eclipse.jface.action.IAction}s contained in the <code>actions</code> collection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void depopulateManager(IContributionManager manager, Collection<? extends IAction> actions) {
		if (actions != null) {
			IContributionItem[] items = manager.getItems();
			for (int i = 0; i < items.length; i++) {
				// Look into SubContributionItems
				//
				IContributionItem contributionItem = items[i];
				while (contributionItem instanceof SubContributionItem) {
					contributionItem = ((SubContributionItem)contributionItem).getInnerItem();
				}

				// Delete the ActionContributionItems with matching action.
				//
				if (contributionItem instanceof ActionContributionItem) {
					IAction action = ((ActionContributionItem)contributionItem).getAction();
					if (actions.contains(action)) {
						manager.remove(contributionItem);
					}
				}
			}
		}
	}

	/**
	 * This populates the pop-up menu before it appears.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		super.menuAboutToShow(menuManager);
		MenuManager submenuManager = null;

		submenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_CreateChild_menu_item"));
		populateManager(submenuManager, createChildActions, null);
		menuManager.insertBefore("edit", submenuManager);

		submenuManager = new MenuManager(PamtramEditorPlugin.INSTANCE.getString("_UI_CreateSibling_menu_item"));
		populateManager(submenuManager, createSiblingActions, null);
		menuManager.insertBefore("edit", submenuManager);
		
		submenuManager = new MenuManager("other actions");
		populateManager(submenuManager, otherActions, null);
		menuManager.insertBefore("edit", submenuManager);
	}

	/**
	 * This inserts global actions before the "additions-end" separator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions"));
		menuManager.insertAfter("ui-actions", showPropertiesViewAction);

		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());		
		menuManager.insertAfter("ui-actions", refreshViewerAction);

		super.addGlobalActions(menuManager);
	}

	/**
	 * This ensures that a delete action will clean up all references to deleted objects.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean removeAllReferencesOnDelete() {
		return true;
	}

}
