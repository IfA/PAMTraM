/**
 */
package pamtram.presentation;


import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.ColumnViewerInformationControlToolTipSupport;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.DecoratingColumLabelProvider;
import org.eclipse.emf.edit.ui.provider.DelegatingStyledCellLabelProvider;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.mfreund.pamtram.preferences.PreferenceSupplier;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.GenLibraryItemProviderAdapterFactory;
import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.commandlistener.PamtramCommandStackListener;
import pamtram.condition.provider.ConditionItemProviderAdapterFactory;
import pamtram.contentadapter.PamtramContentAdapter;
import pamtram.mapping.provider.MappingItemProviderAdapterFactory;
import pamtram.metamodel.provider.MetamodelItemProviderAdapterFactory;
import pamtram.provider.PamtramItemProviderAdapterFactory;
import pamtram.util.EPackageHelper;
import pamtram.util.EPackageHelper.EPackageCheck;


/**
 * This is an example of a Pamtram model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PamtramEditor 
extends MultiPageEditorPart
implements IEditingDomainProvider, ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker, IPersistable {
	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the content outline page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IContentOutlinePage contentOutlinePage;

	/**
	 * This is a kludge...
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;

	/**
	 * This is the content outline page's viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/**
	 * This is the property sheet page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();

	/**
	 * This is the viewer that shadows the selection in the content outline.
	 * The parent relation must be correctly defined for this to work.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer selectionViewer;

	/**
	 * This inverts the roll of parent and child in the content provider and show parents as a tree.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer parentViewer;

	/**
	 * This shows how a tree view works.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer treeViewer;

	/**
	 * This shows how a list view works.
	 * A list viewer doesn't support icons.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListViewer listViewer;

	/**
	 * This shows how a table view works.
	 * A table can be used as a list with icons.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableViewer tableViewer;

	/**
	 * This shows how a tree view with columns works.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeViewer treeViewerWithColumns;

	/**
	 * This keeps track of the active viewer pane, in the book.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewerPane currentViewerPane;

	/**
	 * This is the viewer that displays the attribute value modifier sets.
	 */
	protected TreeViewer globalElementsViewer;

	/**
	 * This is the the viewer for the source meta model sections.
	 */
	protected TreeViewer sourceViewer;

	/**
	 * This is the the viewer for the target meta model sections.
	 */
	protected TreeViewer targetViewer;

	/**
	 * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content outline viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Viewer currentViewer;

	/**
	 * This listens to which ever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;

	/**
	 * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to this editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	/**
	 * This keeps track of the selection of the editor as a whole.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers presented
	 * in Eclipse's Problems View.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();

	/**
	 * This listens for when the outline becomes active
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected IPartListener partListener =
			new IPartListener() {
			public void partActivated(IWorkbenchPart p) {
				if (p instanceof ContentOutline) {
					if (((ContentOutline)p).getCurrentPage() == contentOutlinePage) {
						getActionBarContributor().setActiveEditor(PamtramEditor.this);

						setCurrentViewer(contentOutlineViewer);
					}
				}
				else if (p instanceof PropertySheet) {
					if (propertySheetPages.contains(((PropertySheet)p).getCurrentPage())) {
						getActionBarContributor().setActiveEditor(PamtramEditor.this);
						handleActivate();
					}
				}
				else if (p == PamtramEditor.this) {
					handleActivate();
				}
			}
			public void partBroughtToTop(IWorkbenchPart p) {
				// Ignore.
			}
			public void partClosed(IWorkbenchPart p) {
				
				if(getEditorInput() instanceof FileEditorInput) {
					
					// Save the UI state
					//
					IDialogSettings settings = PamtramEditorPlugin.getPlugin().getDialogSettings();				
					IDialogSettings section = settings.getSection("UI_STATE");
					if (section == null) {
						section = settings.addNewSection("UI_STATE");
					}
					String pamtramFile = ((FileEditorInput) getEditorInput()).getFile().toString();
					IDialogSettings project = settings.getSection(pamtramFile);
					if (project == null) {
						project = section.addNewSection(pamtramFile);
					}
					PamtramEditor.this.persist(project);
				}
				
			}
			public void partDeactivated(IWorkbenchPart p) {
				// Ignore.
			}
			public void partOpened(IWorkbenchPart p) {

				if(getEditorInput() instanceof FileEditorInput) {
					
					// Restore the UI state
					//
					IDialogSettings settings = PamtramEditorPlugin.getPlugin().getDialogSettings();				
					IDialogSettings section = settings.getSection("UI_STATE");
					if (section != null) {
						String pamtramFile = ((FileEditorInput) getEditorInput()).getFile().toString();
						IDialogSettings project = section.getSection(pamtramFile);
						
						if(project != null) {
							PamtramEditor.this.restore(project);							
						}
					}
				}
			}
		};

	/**
	 * Resources that have been removed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Resource> savedResources = new ArrayList<Resource>();

	/**
	 * Map to store the diagnostic associated with a resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * Controls whether the problem indication should be updated.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * Adapter used to update the problem indication when resources are demanded loaded.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EContentAdapter problemIndicationAdapter =
			new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				if (notification.getNotifier() instanceof Resource) {
					switch (notification.getFeatureID(Resource.class)) {
						case Resource.RESOURCE__IS_LOADED:
						case Resource.RESOURCE__ERRORS:
						case Resource.RESOURCE__WARNINGS: {
							Resource resource = (Resource)notification.getNotifier();
							Diagnostic diagnostic = analyzeResourceProblems(resource, null);
							if (diagnostic.getSeverity() != Diagnostic.OK) {
								resourceToDiagnosticMap.put(resource, diagnostic);
							}
							else {
								resourceToDiagnosticMap.remove(resource);
							}

							if (updateProblemIndication) {
								getSite().getShell().getDisplay().asyncExec
									(new Runnable() {
										 public void run() {
											 updateProblemIndication();
										 }
									 });
							}
							break;
						}
					}
				}
				else {
					super.notifyChanged(notification);
				}
			}

			@Override
			protected void setTarget(Resource target) {
				basicSetTarget(target);
			}

			@Override
			protected void unsetTarget(Resource target) {
				basicUnsetTarget(target);
				resourceToDiagnosticMap.remove(target);
				if (updateProblemIndication) {
					getSite().getShell().getDisplay().asyncExec
						(new Runnable() {
							 public void run() {
								 updateProblemIndication();
							 }
						 });
				}
			}
		};

	/**
	 * The content adapter used to perform various changes
	 * automatically when the model changes.
	 */
	protected PamtramContentAdapter pamtramContentAdapter = 
			new PamtramContentAdapter(this);

	public PamtramContentAdapter getPamtramContentAdapter() {
		return pamtramContentAdapter;
	}

	/**
	 * This adapter keeps track of the {@link Resource}s in the resource set that represent {@link LibraryEntry}s.
	 */
	protected Adapter libraryResourceAdapter =
			new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if(msg.getEventType() == Notification.ADD) {
				if(msg.getNewValue() instanceof Resource && !((Resource) msg.getNewValue()).equals(pamtram.eResource())) {
					libraryResources.add((Resource) msg.getNewValue());						
					editingDomain.getResourceToReadOnlyMap().put((Resource) msg.getNewValue(), Boolean.TRUE);
				}
			} else if(msg.getEventType() == Notification.REMOVE) {
				libraryResources.remove(msg.getOldValue());
				editingDomain.getResourceToReadOnlyMap().remove(msg.getOldValue());
			}
		}
	};

	/**
	 * This listens for commands.
	 */
	protected PamtramCommandStackListener pamtramCommandStackListener =
			new PamtramCommandStackListener(this);

	/**
	 * This listens for workspace changes.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected IResourceChangeListener resourceChangeListener =
			new IResourceChangeListener() {
		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				class ResourceDeltaVisitor implements IResourceDeltaVisitor {
					protected ResourceSet resourceSet = editingDomain.getResourceSet();
					protected Collection<Resource> changedResources = new ArrayList<Resource>();
					protected Collection<Resource> removedResources = new ArrayList<Resource>();

					@Override
					public boolean visit(IResourceDelta delta) {
						if (delta.getResource().getType() == IResource.FILE) {
							if (delta.getKind() == IResourceDelta.REMOVED ||
									delta.getKind() == IResourceDelta.CHANGED && delta.getFlags() != IResourceDelta.MARKERS) {
								Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
								if (resource != null) {
									if (delta.getKind() == IResourceDelta.REMOVED) {
										removedResources.add(resource);
									}
									else if (!savedResources.remove(resource)) {
										changedResources.add(resource);
									}
								}
							}
							return false;
						}

						return true;
					}

					public Collection<Resource> getChangedResources() {
						return changedResources;
					}

					public Collection<Resource> getRemovedResources() {
						return removedResources;
					}
				}

				final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);

				if (!visitor.getRemovedResources().isEmpty()) {
					boolean exit = false;
					EList<pamtram.metamodel.LibraryEntry> libEntries = new BasicEList<>();
					for (TargetSectionModel	targetSectionModel : pamtram.getTargetSectionModel()) {
						libEntries.addAll(targetSectionModel.getLibraryElements());
					}
					for (Resource resource : visitor.getRemovedResources()) {
						if(resource.getURI().lastSegment().equals("data.xmi")) {
							String path = resource.getURI().trimSegments(1).lastSegment();
							for (pamtram.metamodel.LibraryEntry libraryEntry : libEntries) {
								if(libraryEntry.getPath().equals(path)) {
									exit = true;
									break;
								}
							}
						} else {
							exit = true;
							break;
						}
					}
					if(exit) {
						getSite().getShell().getDisplay().asyncExec
						(new Runnable() {
							@Override
							public void run() {
								removedResources.addAll(visitor.getRemovedResources());
								if (!isDirty()) {
									getSite().getPage().closeEditor(PamtramEditor.this, false);
								}
							}
						});							
					}
				}

				if (!visitor.getChangedResources().isEmpty()) {
					getSite().getShell().getDisplay().asyncExec
					(new Runnable() {
						@Override
						public void run() {
							changedResources.addAll(visitor.getChangedResources());
							if (getSite().getPage().getActiveEditor() == PamtramEditor.this) {
								handleActivate();
							}
						}
					});
				}
			}
			catch (CoreException exception) {
				PamtramEditorPlugin.INSTANCE.log(exception);
			}
		}
	};

	/**
	 * This is the {@link PAMTraM} instance that this editor works on.
	 */
	protected PAMTraM pamtram;

	/**
	 * This is the getter for the {@link #pamtram}
	 * @return The pamtram instance that this editor operates on.
	 */
	public PAMTraM getPamtram() {
		return pamtram;
	}

	/**
	 * This is a list of {@link Resource}s that represent {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry}s in the {@link PAMTraM}
	 */
	protected ArrayList<Resource> libraryResources = new ArrayList<>();

	/**
	 * The main page that allows to configure source and target section as well as mappings.
	 */
	protected PamtramEditorMainPage mainPage;

	/**
	 * A page that allows to match the configured source sections against a source model to be selected.
	 */
	protected PamtramEditorSourceSectionMatcherPage sourceSectionMatcherPage;

	/**
	 * Handles activation of the editor or it's associated views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void handleActivateGen() {
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
		  editingDomain.getResourceToReadOnlyMap().clear();

		  // Refresh any actions that may become enabled or disabled.
		  //
		  setSelection(getSelection());
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(PamtramEditor.this, false);
			}
			else {
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		}
		else if (!changedResources.isEmpty()) {
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}
	}

	/**
	 * Handles activation of the editor or it's associated views.
	 * <!-- begin-user-doc -->
	 * Add all the library element resources to the read-only map. 
	 * <!-- end-user-doc -->
	 */
	protected void handleActivate() {
		handleActivateGen();

		if(pamtram == null || pamtram.getTargetSectionModel() == null) {
			return;
		}

		// mark all known resource that represent library entries as read-only
		for (Resource resource : libraryResources) {
			editingDomain.getResourceToReadOnlyMap().put(resource, Boolean.TRUE);
		}
	}	

	/**
	 * Handles what to do with changed resources on activation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void handleChangedResources() {
		if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
			if (isDirty()) {
				changedResources.addAll(editingDomain.getResourceSet().getResources());
			}
			editingDomain.getCommandStack().flush();

			updateProblemIndication = false;
			for (Resource resource : changedResources) {
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					}
					catch (IOException exception) {
						if (!resourceToDiagnosticMap.containsKey(resource)) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
					}
				}
			}

			if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
				setSelection(StructuredSelection.EMPTY);
			}

			updateProblemIndication = true;
			updateProblemIndication();
		}
	}

	/**
	 * Updates the problems indication with the information described in the specified diagnostic.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void updateProblemIndication() {
		if (updateProblemIndication) {
			BasicDiagnostic diagnostic =
				new BasicDiagnostic
					(Diagnostic.OK,
					 "de.mfreund.pamtram.model.editor",
					 0,
					 null,
					 new Object [] { editingDomain.getResourceSet() });
			for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
				if (childDiagnostic.getSeverity() != Diagnostic.OK) {
					diagnostic.add(childDiagnostic);
				}
			}

			int lastEditorPage = getPageCount() - 1;
			if (lastEditorPage >= 0 && getEditor(lastEditorPage) instanceof ProblemEditorPart) {
				((ProblemEditorPart)getEditor(lastEditorPage)).setDiagnostic(diagnostic);
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					setActivePage(lastEditorPage);
				}
			}
			else if (diagnostic.getSeverity() != Diagnostic.OK) {
				ProblemEditorPart problemEditorPart = new ProblemEditorPart();
				problemEditorPart.setDiagnostic(diagnostic);
				problemEditorPart.setMarkerHelper(markerHelper);
				try {
					addPage(++lastEditorPage, problemEditorPart, getEditorInput());
					setPageText(lastEditorPage, problemEditorPart.getPartName());
					setActivePage(lastEditorPage);
					showTabs();
				}
				catch (PartInitException exception) {
					PamtramEditorPlugin.INSTANCE.log(exception);
				}
			}

			if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
				markerHelper.deleteMarkers(editingDomain.getResourceSet());
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					try {
						markerHelper.createMarkers(diagnostic);
					}
					catch (CoreException exception) {
						PamtramEditorPlugin.INSTANCE.log(exception);
					}
				}
			}
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean handleDirtyConflict() {
		return
			MessageDialog.openQuestion
				(getSite().getShell(),
				 getString("_UI_FileConflict_label"),
				 getString("_WARN_FileConflict"));
	}

	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given '<em>pamtram</em>' instance.
	 *  
	 * @param pamtram The {@link PAMTraM} model for which an existing editor shall be returned.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 * exists.
	 */
	public static PamtramEditor getEditor(PAMTraM pamtram) {

		// get the active workbench window
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		// iterate through all pages and their editors and check if there is a 'PamtramEditor' for the given pamtram instance
		for (IWorkbenchPage page : workbenchWindow.getPages()) {
			for (IEditorReference editorRef : page.getEditorReferences()) {
				if(editorRef.getEditor(false) instanceof PamtramEditor && ((PamtramEditor) editorRef.getEditor(false)).isEditorFor(pamtram)) {

					return (PamtramEditor) editorRef.getEditor(false);
				}
			}

		}

		return null;
	}
	
	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given '<em>pamtram</em>' instance.
	 *  
	 * @param pamtram The {@link PAMTraM} model for which an existing editor shall be returned.
	 * @param openNewEditor Whether a new editor shall be opened if no editor for the given '<em>pamtram</em>' exists.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 * exists/could be opened.
	 */
	public static PamtramEditor getEditor(PAMTraM pamtram, boolean openNewEditor) {
		
		PamtramEditor editor = getEditor(pamtram);

		if(editor != null || !openNewEditor) {
			return editor;
		}
		
		// no editor has been found so we open a new one
		IFile file = null;
		try {
			
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(
					new java.net.URI(pamtram.eResource().getURI().toString()));
			
			if(files.length == 0) {
				return null;
			}
			
			file = files[0];
			
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
			return null;
		}

		try {
			// get the active workbench window
			IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			
			IEditorPart editorPart = workbenchWindow.getActivePage().openEditor(new FileEditorInput(file), "pamtram.presentation.PamtramEditorID");
			
			return (PamtramEditor) editorPart;
			
		} catch (PartInitException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given path to a pamtram instance.
	 *  
	 * @param pamtramPath The absolute full path to the pamtram model for which an existing editor shall be returned.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 * exists.
	 */
	public static PamtramEditor getEditor(String pamtramPath) {

		// get the active workbench window
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		// iterate through all pages and their editors and check if there is a 'PamtramEditor' for the given pamtram instance
		for (IWorkbenchPage page : workbenchWindow.getPages()) {
			for (IEditorReference editorRef : page.getEditorReferences()) {
				if(editorRef.getEditor(false) instanceof PamtramEditor && ((PamtramEditor) editorRef.getEditor(false)).isEditorFor(pamtramPath)) {

					return (PamtramEditor) editorRef.getEditor(true);
				}
			}

		}
		
		return null;
	}
	
	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given path to a pamtram instance.
	 *  
	 * @param pamtramPath The absolute full path to the pamtram model for which an existing editor shall be returned.
	 * @param openNewEditor Whether a new editor shall be opened if no editor for the given '<em>pamtramPath</em>' exists.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 * exists/could be opened.
	 */
	public static PamtramEditor getEditor(String pamtramPath, boolean openNewEditor) {

		PamtramEditor editor = getEditor(pamtramPath);
		
		if(editor != null || !openNewEditor) {
			return editor;
		}
		
		// no editor has been found so we open a new one
		IFile file = null;
		try {
			
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(
					new java.net.URI(URI.createFileURI(pamtramPath).toString()));
			
			if(files.length == 0) {
				return null;
			}
			
			file = files[0];
			
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
			return null;
		}

		try {
			// get the active workbench window
			IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			
			IEditorPart editorPart = workbenchWindow.getActivePage().openEditor(new FileEditorInput(file), "pamtram.presentation.PamtramEditorID");
			
			return (PamtramEditor) editorPart;
			
		} catch (PartInitException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * This may be used to check if the editor is used for editing the given '<em>pamtram</em>' instance.
	 * 
	 * @param pamtram The {@link PAMTraM} instance to check.
	 * @return '<em><b>true</b></em>' if this editor is used for editing the given {@link PAMTraM} instance,
	 * '<em><b>false</b></em>' otherwise.
	 */
	public boolean isEditorFor(PAMTraM pamtram) {
		if(this.pamtram == null) {
			return false;
		} else if(this.pamtram.equals(pamtram) || this.pamtram.eResource().getURI().equals(pamtram.eResource().getURI())) {
			return true;
		} else if(pamtram.eResource().getURI().isFile()) {
			// if all other checks failed, check if both pamtram instance are based on the same file 
			IWorkspace workspace = ResourcesPlugin.getWorkspace(); 
			IFile file = workspace.getRoot().getFile(new Path(this.pamtram.eResource().getURI().toPlatformString(true)));
			return file.getLocation().toOSString().equals(pamtram.eResource().getURI().toFileString());
		}
		return false;
	}

	/**
	 * This may be used to check if the editor is used for editing the given path to a pamtra file.
	 * 
	 * @param pamtramPath The absolute full path to the pamtram instance to check.
	 * @return '<em><b>true</b></em>' if this editor is used for editing the given {@link PAMTraM} instance,
	 * '<em><b>false</b></em>' otherwise.
	 */
	public boolean isEditorFor(String pamtramPath) {

		// if all other checks failed, check if both pamtram instance are based on the same file 
		IWorkspace workspace = ResourcesPlugin.getWorkspace(); 
		IFile file = workspace.getRoot().getFile(new Path(this.pamtram.eResource().getURI().toPlatformString(true)));
		return file.getLocation().toOSString().equals(pamtramPath);
	}

	/**
	 * This creates a model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PamtramEditor() {
		super();
		initializeEditingDomain();
	}

	/**
	 * This sets up the editing domain for the model editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new PamtramItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new MetamodelItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ConditionItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new MappingItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new GenLibraryItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener
			(new CommandStackListener() {
				 public void commandStackChanged(final EventObject event) {
					 getContainer().getDisplay().asyncExec
						 (new Runnable() {
							  public void run() {
								  firePropertyChange(IEditorPart.PROP_DIRTY);

								  // Try to select the affected objects.
								  //
								  Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
								  if (mostRecentCommand != null) {
									  setSelectionToViewer(mostRecentCommand.getAffectedObjects());
								  }
								  for (Iterator<PropertySheetPage> i = propertySheetPages.iterator(); i.hasNext(); ) {
									  PropertySheetPage propertySheetPage = i.next();
									  if (propertySheetPage.getControl().isDisposed()) {
										  i.remove();
									  }
									  else {
										  propertySheetPage.refresh();
									  }
								  }
							  }
						  });
				 }
			 });

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	/**
	 * This is here for the listener to be able to call it.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	/**
	 * This sets the selection into whichever viewer is active.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable =
				new Runnable() {
					public void run() {
						// Try to select the items in the current content viewer of the editor.
						//
						if (currentViewer != null) {
							currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
						}
					}
				};
			getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

	/**
	 * This returns the editing domain as required by the {@link IEditingDomainProvider} interface.
	 * This is important for implementing the static methods of {@link AdapterFactoryEditingDomain}
	 * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class ReverseAdapterFactoryContentProvider extends AdapterFactoryContentProvider {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object [] getElements(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object [] getChildren(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public boolean hasChildren(Object object) {
			Object parent = super.getParent(object);
			return parent != null;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Object getParent(Object object) {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentViewerPane(ViewerPane viewerPane) {
		if (currentViewerPane != viewerPane) {
			if (currentViewerPane != null) {
				currentViewerPane.showFocus(false);
			}
			currentViewerPane = viewerPane;
		}
		setCurrentViewer(currentViewerPane.getViewer());
	}

	/**
	 * This makes sure that one content viewer, either for the current page or the outline view, if it has focus,
	 * is the current one.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentViewer(Viewer viewer) {
		// If it is changing...
		//
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				// Create the listener on demand.
				//
				selectionChangedListener =
					new ISelectionChangedListener() {
						// This just notifies those things that are affected by the section.
						//
						public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
							setSelection(selectionChangedEvent.getSelection());
						}
					};
			}

			// Stop listening to the old one.
			//
			if (currentViewer != null) {
				currentViewer.removeSelectionChangedListener(selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			// Remember it.
			//
			currentViewer = viewer;

			// Set the editors selection based on the current viewer's selection.
			//
			setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
		}
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider} interface.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Viewer getViewer() {
		return currentViewer;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well registering the menu for extension.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance(), LocalSelectionTransfer.getTransfer(), FileTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}

	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput(), editingDomain.getResourceSet().getURIConverter());
		Exception exception = null;
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			//
			resource = editingDomain.getResourceSet().getResource(resourceURI, true);
		}
		catch (Exception e) {
			exception = e;
			resource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}

		Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(resource,  analyzeResourceProblems(resource, exception));
		}
		editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
	}

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the resource
	 * and the specified exception (if any).
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		boolean hasErrors = !resource.getErrors().isEmpty();
		if (hasErrors || !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic =
				new BasicDiagnostic
					(hasErrors ? Diagnostic.ERROR : Diagnostic.WARNING,
					 "de.mfreund.pamtram.model.editor",
					 0,
					 getString("_UI_CreateModelError_message", resource.getURI()),
					 new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if (exception != null) {
			return
				new BasicDiagnostic
					(Diagnostic.ERROR,
					 "de.mfreund.pamtram.model.editor",
					 0,
					 getString("_UI_CreateModelError_message", resource.getURI()),
					 new Object[] { exception });
		}
		else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	/**
	 * This is the method used by the framework to install your own controls.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPagesGen() {
		// Creates the model from the editor input
		//
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			// Create a page for the selection tree view.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), PamtramEditor.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							Tree tree = new Tree(composite, SWT.MULTI);
							TreeViewer newTreeViewer = new TreeViewer(tree);
							return newTreeViewer;
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());

				selectionViewer = (TreeViewer)viewerPane.getViewer();
				selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

				selectionViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(new AdapterFactoryLabelProvider.StyledLabelProvider(adapterFactory, selectionViewer), new DiagnosticDecorator.Styled(editingDomain, selectionViewer, PamtramEditorPlugin.getPlugin().getDialogSettings()))));
				selectionViewer.setInput(editingDomain.getResourceSet());
				selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
				viewerPane.setTitle(editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);
				new ColumnViewerInformationControlToolTipSupport(selectionViewer, new DiagnosticDecorator.Styled.EditingDomainLocationListener(editingDomain, selectionViewer));

				createContextMenuFor(selectionViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_SelectionPage_label"));
			}

			// Create a page for the parent tree view.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), PamtramEditor.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							Tree tree = new Tree(composite, SWT.MULTI);
							TreeViewer newTreeViewer = new TreeViewer(tree);
							return newTreeViewer;
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());

				parentViewer = (TreeViewer)viewerPane.getViewer();
				parentViewer.setAutoExpandLevel(30);
				parentViewer.setContentProvider(new ReverseAdapterFactoryContentProvider(adapterFactory));
				parentViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new AdapterFactoryLabelProvider.StyledLabelProvider(adapterFactory, parentViewer)));

				createContextMenuFor(parentViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_ParentPage_label"));
			}

			// This is the page for the list viewer
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), PamtramEditor.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new ListViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());
				listViewer = (ListViewer)viewerPane.getViewer();
				listViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
				listViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new AdapterFactoryLabelProvider.StyledLabelProvider(adapterFactory, listViewer)));

				createContextMenuFor(listViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_ListPage_label"));
			}

			// This is the page for the tree viewer
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), PamtramEditor.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new TreeViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());
				treeViewer = (TreeViewer)viewerPane.getViewer();
				treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
				treeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(new AdapterFactoryLabelProvider.StyledLabelProvider(adapterFactory, treeViewer), new DiagnosticDecorator.Styled(editingDomain, treeViewer))));

				new AdapterFactoryTreeEditor(treeViewer.getTree(), adapterFactory);
				new ColumnViewerInformationControlToolTipSupport(treeViewer, new DiagnosticDecorator.Styled.EditingDomainLocationListener(editingDomain, treeViewer));

				createContextMenuFor(treeViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_TreePage_label"));
			}

			// This is the page for the table viewer.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), PamtramEditor.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new TableViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());
				tableViewer = (TableViewer)viewerPane.getViewer();

				Table table = tableViewer.getTable();
				TableLayout layout = new TableLayout();
				table.setLayout(layout);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);

				TableColumn objectColumn = new TableColumn(table, SWT.NONE);
				layout.addColumnData(new ColumnWeightData(3, 100, true));
				objectColumn.setText(getString("_UI_ObjectColumn_label"));
				objectColumn.setResizable(true);

				TableColumn selfColumn = new TableColumn(table, SWT.NONE);
				layout.addColumnData(new ColumnWeightData(2, 100, true));
				selfColumn.setText(getString("_UI_SelfColumn_label"));
				selfColumn.setResizable(true);

				tableViewer.setColumnProperties(new String [] {"a", "b"});
				tableViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
				tableViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(new AdapterFactoryLabelProvider.StyledLabelProvider(adapterFactory, tableViewer), new DiagnosticDecorator.Styled(editingDomain, tableViewer, PamtramEditorPlugin.getPlugin().getDialogSettings()))));

				new ColumnViewerInformationControlToolTipSupport(tableViewer, new DiagnosticDecorator.Styled.EditingDomainLocationListener(editingDomain, tableViewer));

				createContextMenuFor(tableViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_TablePage_label"));
			}

			// This is the page for the table tree viewer.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), PamtramEditor.this) {
						@Override
						public Viewer createViewer(Composite composite) {
							return new TreeViewer(composite);
						}
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());

				treeViewerWithColumns = (TreeViewer)viewerPane.getViewer();

				Tree tree = treeViewerWithColumns.getTree();
				tree.setLayoutData(new FillLayout());
				tree.setHeaderVisible(true);
				tree.setLinesVisible(true);

				TreeColumn objectColumn = new TreeColumn(tree, SWT.NONE);
				objectColumn.setText(getString("_UI_ObjectColumn_label"));
				objectColumn.setResizable(true);
				objectColumn.setWidth(250);

				TreeColumn selfColumn = new TreeColumn(tree, SWT.NONE);
				selfColumn.setText(getString("_UI_SelfColumn_label"));
				selfColumn.setResizable(true);
				selfColumn.setWidth(200);

				treeViewerWithColumns.setColumnProperties(new String [] {"a", "b"});
				treeViewerWithColumns.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
				treeViewerWithColumns.setLabelProvider(new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(new AdapterFactoryLabelProvider.StyledLabelProvider(adapterFactory, treeViewerWithColumns), new DiagnosticDecorator.Styled(editingDomain, treeViewerWithColumns, PamtramEditorPlugin.getPlugin().getDialogSettings()))));

				new ColumnViewerInformationControlToolTipSupport(treeViewerWithColumns, new DiagnosticDecorator.Styled.EditingDomainLocationListener(editingDomain, treeViewerWithColumns));

				createContextMenuFor(treeViewerWithColumns);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, getString("_UI_TreeWithColumnsPage_label"));
			}

			getSite().getShell().getDisplay().asyncExec
				(new Runnable() {
					 public void run() {
						 setActivePage(0);
					 }
				 });
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener
			(new ControlAdapter() {
				boolean guard = false;
				@Override
				public void controlResized(ControlEvent event) {
					if (!guard) {
						guard = true;
						hideTabs();
						guard = false;
					}
				}
			 });

		getSite().getShell().getDisplay().asyncExec
			(new Runnable() {
				 public void run() {
					 updateProblemIndication();
				 }
			 });
	}

	/**
	 * This is the method used by the framework to install your own controls.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public void createPages() {

		// Load the Pamtram model from the editor input.
		//
		boolean pamtramFound = 
				getPamtramFromResourceSet();

		// Only creates the other pages if there is something that can be edited
		//
		if(pamtramFound) {
			// Try to register missing ePackages.
			//
			registerEPackages();

			// Set the Pamtram content adapter.
			pamtram.eAdapters().add(pamtramContentAdapter);

			// Set the library resource adapter.
			editingDomain.getResourceSet().eAdapters().add(libraryResourceAdapter);

			// Set the Pamtram command stack listener.
			getEditingDomain().getCommandStack().addCommandStackListener(pamtramCommandStackListener);

			// Create a page for the selection tree view.
			//
			{
				mainPage = new PamtramEditorMainPage(
						getContainer(), SWT.None, adapterFactory, this);
				int pageIndex = addPage(mainPage);
				setPageText(pageIndex, getString("_UI_SelectionPage_label"));
			}

			// Create a page for the source section matcher view.
			//
			{
				sourceSectionMatcherPage = new PamtramEditorSourceSectionMatcherPage(
						getContainer(), 
						SWT.NONE, adapterFactory, this);
				//										createContextMenuFor(parentViewer);
				int pageIndex = addPage(sourceSectionMatcherPage);
				setPageText(pageIndex, getString("_UI_ParentPage_label"));
			}

			getSite().getShell().getDisplay().asyncExec
			(new Runnable() {
				@Override
				public void run() {
					setActivePage(0);
				}
			});
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener
		(new ControlAdapter() {
			boolean guard = false;
			@Override
			public void controlResized(ControlEvent event) {
				if (!guard) {
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});

		getSite().getShell().getDisplay().asyncExec
		(new Runnable() {
			@Override
			public void run() {
				updateProblemIndication();
			}
		});
	}

	/**
	 * Tries to load the Pamtram model from the editor input.
	 * 
	 * Therefore, 'createModel()' is called at first. After that, the Pamtram instance
	 * is extracted from the resource and stored in the editor's 'pamtram' field.
	 * 
	 * @return true if the pamtram model has been found and stored; false otherwise.
	 */
	private boolean getPamtramFromResourceSet() {

		// Creates the model from the editor input
		//
		createModel();

		if(getEditingDomain().getResourceSet().getResources().isEmpty()) {
			return false;
		}

		// Get the Pamtram instance.
		for (Resource resource : getEditingDomain().getResourceSet().getResources()) {
			if(resource.getContents().get(0) instanceof PAMTraM) {
				pamtram = (PAMTraM) resource.getContents().get(0);
				break;
			}
		}
		if(pamtram == null) {
			MessageDialog.openError(getContainer().getShell(),
					"Error", "The root element contained in the resource is no PAMTraM instance!");
			return false;
		}
		return true;
	}

	/**
	 * This checks if all ePackages involved in the pamtram model are registered. If not, it
	 * tries to register them by scanning the project's 'metamodel' folder for suitable ecore
	 * models. Any errors that might occur during this process will not be reflected in the
	 * diagnostic map and will thus not be reflected in the editor. 
	 */
	private void registerEPackages() {

		// Create a backup of the diagnostic map.
		Map<Resource, Diagnostic> backup = new HashMap<Resource, Diagnostic>(resourceToDiagnosticMap);

		// try to register the ePackages involved in the pamtram model (if not already done)
		EPackageCheck result = EPackageHelper.checkInvolvedEPackages(
				pamtram,
				ResourceUtil.getFile(getEditorInput()).getProject(),
				EPackage.Registry.INSTANCE);

		switch (result) {
		case OK_NOTHING_REGISTERED:
			return;
		case OK_PACKAGES_REGISTERED:
			// if packages have been registered, a new resource set has to be created; otherwise,
			// proxy resolving does not seem to work correctly; therefore, the editing is re-initialized
			// and the source model is reloaded
			initializeEditingDomain();
			getPamtramFromResourceSet();

			// Reset the diagnostic map so that errors that occurred during the above operations are
			// not reflected.
			resourceToDiagnosticMap = backup;
			break;
		case ERROR_METAMODEL_FOLDER_NOT_FOUND:
		case ERROR_PACKAGE_NOT_FOUND:
		case ERROR_PAMTRAM_NOT_FOUND:
		default:
			break;
		}
	}

	/**
	 * If there is just one page in the multi-page editor part,
	 * this hides the single tab at the bottom.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void hideTabs() {
		if (getPageCount() <= 1) {
			setPageText(0, "");
			if (getContainer() instanceof CTabFolder) {
				((CTabFolder)getContainer()).setTabHeight(1);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y + 6);
			}
		}
	}

	/**
	 * If there is more than one page in the multi-page editor part,
	 * this shows the tabs at the bottom.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void showTabs() {
		if (getPageCount() > 1) {
			setPageText(0, getString("_UI_SelectionPage_label"));
			if (getContainer() instanceof CTabFolder) {
				((CTabFolder)getContainer()).setTabHeight(SWT.DEFAULT);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y - 6);
			}
		}
	}

	/**
	 * This is used to track the active viewer.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void pageChange(int pageIndex) {
		super.pageChange(pageIndex);

		if (contentOutlinePage != null) {
			handleContentOutlineSelection(contentOutlinePage.getSelection());
		}
	}

	/**
	 * This is how the framework determines which interfaces we implement.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			return showOutlineView() ? getContentOutlinePage() : null;
		}
		else if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}
		else if (key.equals(IGotoMarker.class)) {
			return this;
		}
		else {
			return super.getAdapter(key);
		}
	}

	/**
	 * This accesses a cached version of the content outliner.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			// The content outline is just a tree.
			//
			class MyContentOutlinePage extends ContentOutlinePage {
				@Override
				public void createControl(Composite parent) {
					super.createControl(parent);
					contentOutlineViewer = getTreeViewer();
					contentOutlineViewer.addSelectionChangedListener(this);

					// Set up the tree viewer.
					//
					contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
					contentOutlineViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(new AdapterFactoryLabelProvider.StyledLabelProvider(adapterFactory, contentOutlineViewer), new DiagnosticDecorator.Styled(editingDomain, contentOutlineViewer, PamtramEditorPlugin.getPlugin().getDialogSettings()))));
					contentOutlineViewer.setInput(editingDomain.getResourceSet());

					new ColumnViewerInformationControlToolTipSupport(contentOutlineViewer, new DiagnosticDecorator.Styled.EditingDomainLocationListener(editingDomain, contentOutlineViewer));

					// Make sure our popups work.
					//
					createContextMenuFor(contentOutlineViewer);

					if (!editingDomain.getResourceSet().getResources().isEmpty()) {
					  // Select the root object in the view.
					  //
					  contentOutlineViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
					}
				}

				@Override
				public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
					super.makeContributions(menuManager, toolBarManager, statusLineManager);
					contentOutlineStatusLineManager = statusLineManager;
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			}

			contentOutlinePage = new MyContentOutlinePage();

			// Listen to selection so that we can handle it is a special way.
			//
			contentOutlinePage.addSelectionChangedListener
				(new ISelectionChangedListener() {
					 // This ensures that we handle selections correctly.
					 //
					 public void selectionChanged(SelectionChangedEvent event) {
						 handleContentOutlineSelection(event.getSelection());
					 }
				 });
		}

		return contentOutlinePage;
	}

	/**
	 * This accesses a cached version of the property sheet.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IPropertySheetPage getPropertySheetPage() {
		PropertySheetPage propertySheetPage =
			new ExtendedPropertySheetPage(editingDomain, ExtendedPropertySheetPage.Decoration.LIVE, PamtramEditorPlugin.getPlugin().getDialogSettings()) {
				@Override
				public void setSelectionToViewer(List<?> selection) {
					PamtramEditor.this.setSelectionToViewer(selection);
					PamtramEditor.this.setFocus();
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			};
		propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		propertySheetPages.add(propertySheetPage);

		return propertySheetPage;
	}

	/**
	 * This deals with how we want selection in the outliner to affect the other views.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection)selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the selection viewer, then we want it to select the same selection as this selection.
				//
				if (currentViewerPane.getViewer() == selectionViewer) {
					ArrayList<Object> selectionList = new ArrayList<Object>();
					selectionList.add(selectedElement);
					while (selectedElements.hasNext()) {
						selectionList.add(selectedElements.next());
					}

					// Set the selection to the widget.
					//
					selectionViewer.setSelection(new StructuredSelection(selectionList));
				}
				else {
					// Set the input to the widget.
					//
					if (currentViewerPane.getViewer().getInput() != selectedElement) {
						currentViewerPane.getViewer().setInput(selectedElement);
						currentViewerPane.setTitle(selectedElement);
					}
				}
			}
		}
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command stack.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);

		// Persist type information for every reference type if specified by the corresponding preference
		//
		if(PreferenceSupplier.isSerializeAllTypeInfo()) {
			XMLTypeInfo typeInfo = new XMLSave.XMLTypeInfo() {

				@Override
				public boolean shouldSaveType(EClass arg0, EClassifier arg1, EStructuralFeature arg2) {
					return true;
				}

				@Override
				public boolean shouldSaveType(EClass arg0, EClass arg1, EStructuralFeature arg2) {
					return true;
				}
			};
			saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, typeInfo);

		}

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : editingDomain.getResourceSet().getResources()) {
					if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
						try {
							long timeStamp = resource.getTimeStamp();
							resource.save(saveOptions);
							if (resource.getTimeStamp() != timeStamp) {
								savedResources.add(resource);
							}
						}
						catch (Exception exception) {
							resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
						}
						first = false;
					}
				}
			}
		};

		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			PamtramEditorPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		updateProblemIndication();
	}

	/**
	 * This returns whether something has been persisted to the URI of the specified resource.
	 * The implementation uses the URI converter from the editor's resource set to try to open an input stream.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		}
		catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This always returns true because it is not currently supported.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * This also changes the editor's input.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor =
			getActionBars().getStatusLineManager() != null ?
				getActionBars().getStatusLineManager().getProgressMonitor() :
				new NullProgressMonitor();
		doSave(progressMonitor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void gotoMarker(IMarker marker) {
		List<?> targetObjects = markerHelper.getTargetObjects(editingDomain, marker);
		if (!targetObjects.isEmpty()) {
			setSelectionToViewer(targetObjects);
		}
	}

	/**
	 * This is called during startup.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFocus() {
		if (currentViewerPane != null) {
			currentViewerPane.setFocus();
		}
		else {
			getControl(getActivePage()).setFocus();
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's overall selection.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ISelection getSelection() {
		return editorSelection;
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to set this editor's overall selection.
	 * Calling this result will notify the listeners.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
		setStatusLineManager(selection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatusLineManager(ISelection selection) {
		IStatusLineManager statusLineManager = currentViewer != null && currentViewer == contentOutlineViewer ?
			contentOutlineStatusLineManager : getActionBars().getStatusLineManager();

		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection)selection).toList();
				switch (collection.size()) {
					case 0: {
						statusLineManager.setMessage(getString("_UI_NoObjectSelected"));
						break;
					}
					case 1: {
						String text = new AdapterFactoryItemDelegator(adapterFactory).getText(collection.iterator().next());
						statusLineManager.setMessage(getString("_UI_SingleObjectSelected", text));
						break;
					}
					default: {
						statusLineManager.setMessage(getString("_UI_MultiObjectSelected", Integer.toString(collection.size())));
						break;
					}
				}
			}
			else {
				statusLineManager.setMessage("");
			}
		}
	}

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key) {
		return PamtramEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return PamtramEditorPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions from the Edit menu.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener)getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void disposeGen() {
		updateProblemIndication = false;

		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		getSite().getPage().removePartListener(partListener);

		adapterFactory.dispose();

		if (getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}

		for (PropertySheetPage propertySheetPage : propertySheetPages) {
			propertySheetPage.dispose();
		}

		if (contentOutlinePage != null) {
			contentOutlinePage.dispose();
		}

		super.dispose();
	}

	/**
	 * Dispose the PamtramContentAdapter and call the
	 * original dispose() function.
	 */
	@Override
	public void dispose() {

		// Dispose the Pamtram content adapter.
		pamtram.eAdapters().remove(pamtramContentAdapter);

		// Dispose the library resource adapter.
		editingDomain.getResourceSet().eAdapters().remove(libraryResourceAdapter);

		// Dispose the problem indication adapter.
		editingDomain.getResourceSet().eAdapters().remove(
				problemIndicationAdapter);

		disposeGen();
	}

	/**
	 * Returns whether the outline view should be presented to the user.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected boolean showOutlineView() {
		return true;
	}

	@Override
	public void persist(IDialogSettings settings) {
		
		// persist the active page
		int index = getActivePage();
		settings.put("ACTIVE_PAGE", index);
		
		// persist the state of the 'mainPage'
		mainPage.persist(settings);
	}

	@Override
	public void restore(final IDialogSettings settings) {
		// perform the restore operations in an asynchronous way
		try {
			getSite().getShell().getDisplay().asyncExec
			(new Runnable() {
				@Override
				public void run() {
					// restore the active page
					int index = settings.getInt("ACTIVE_PAGE");
					setActivePage(index);
					
					// restore the state of the 'mainPage'
					mainPage.restore(settings);
				}
			});
		} catch (Exception e) {
			// do nothing
		}
	}
}
