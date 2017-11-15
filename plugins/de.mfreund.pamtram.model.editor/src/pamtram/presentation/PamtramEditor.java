/**
 */
package pamtram.presentation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import de.mfreund.pamtram.preferences.PreferenceSupplier;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.provider.GenLibraryItemProviderAdapterFactory;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.AgteleUIPlugin;
import de.tud.et.ifa.agtele.ui.editors.ClonableEditor;
import de.tud.et.ifa.agtele.ui.emf.editor.TooltipDisplayingDropAdapter;
import de.tud.et.ifa.agtele.ui.interfaces.IPersistable;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.PAMTraM;
import pamtram.TargetSectionModel;
import pamtram.commandlistener.PamtramCommandStackListener;
import pamtram.condition.provider.ConditionItemProviderAdapterFactory;
import pamtram.contentadapter.PamtramContentAdapter;
import pamtram.mapping.provider.MappingItemProviderAdapterFactory;
import pamtram.provider.PamtramItemProviderAdapterFactory;
import pamtram.structure.provider.StructureItemProviderAdapterFactory;
import pamtram.util.PamtramModelUtil;
import pamtram.util.PamtramModelUtil.ModelLoadException;

/**
 * This is an example of a Pamtram model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated NOT
 */
public class PamtramEditor extends ClonableEditor implements IEditingDomainProvider, ISelectionProvider, IMenuListener,
		IViewerProvider, IGotoMarker, IPersistable {

	/**
	 * This keeps track of the editing domain that is used to track all changes to the model. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the content outline page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IContentOutlinePage contentOutlinePage;

	/**
	 * This is a kludge... <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;

	/**
	 * This is the content outline page's viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/**
	 * This is the property sheet page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected List<PropertySheetPage> propertySheetPages = new ArrayList<>();

	/**
	 * This is the viewer that shadows the selection in the content outline. The parent relation must be correctly
	 * defined for this to work. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TreeViewer selectionViewer;

	/**
	 * This inverts the roll of parent and child in the content provider and show parents as a tree. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TreeViewer parentViewer;

	/**
	 * This shows how a tree view works. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TreeViewer treeViewer;

	/**
	 * This shows how a list view works. A list viewer doesn't support icons. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected ListViewer listViewer;

	/**
	 * This shows how a table view works. A table can be used as a list with icons. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected TableViewer tableViewer;

	/**
	 * This shows how a tree view with columns works. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected TreeViewer treeViewerWithColumns;

	/**
	 * This keeps track of the active viewer pane, in the book. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
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
	 * This keeps track of the active content viewer, which may be either one of the viewers in the pages or the content
	 * outline viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Viewer currentViewer;

	/**
	 * This listens to which ever viewer is active. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;

	/**
	 * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are listening to
	 * this editor. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<>();

	/**
	 * This keeps track of the selection of the editor as a whole. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers presented in Eclipse's Problems View.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();

	protected IPartListener handleRestoreListener = new IPartListener() {

		@Override
		public void partOpened(IWorkbenchPart part) {

			// Ignore.
		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {

			// Ignore.
		}

		@Override
		public void partClosed(IWorkbenchPart part) {

			// Ignore.
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {

			// Ignore.
		}

		@Override
		public void partActivated(IWorkbenchPart p) {

			if (p == PamtramEditor.this) {
				PamtramEditor.this.handleActivate();

				if (PamtramEditor.this.getEditorInput() instanceof FileEditorInput) {

					// Restore the UI state
					//
					IDialogSettings settings = PamtramEditorPlugin.getPlugin().getDialogSettings();
					IDialogSettings section = settings.getSection("UI_STATE");
					if (section != null) {
						String pamtramFile = ((FileEditorInput) PamtramEditor.this.getEditorInput()).getFile()
								.toString();
						IDialogSettings project = section.getSection(pamtramFile);

						PamtramEditor.this.restore(project);
					}
				}

				PamtramEditor.this.getSite().getPage().removePartListener(this);
			}
		}
	};

	/**
	 * This listens for when the outline becomes active <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected IPartListener partListener = new IPartListener() {

		@Override
		public void partActivated(IWorkbenchPart p) {

			if (p instanceof ContentOutline) {
				if (((ContentOutline) p).getCurrentPage() == PamtramEditor.this.contentOutlinePage) {
					PamtramEditor.this.getActionBarContributor().setActiveEditor(PamtramEditor.this);

					PamtramEditor.this.setCurrentViewer(PamtramEditor.this.contentOutlineViewer);
				}
			} else if (p instanceof PropertySheet) {
				if (PamtramEditor.this.propertySheetPages.contains(((PropertySheet) p).getCurrentPage())) {
					PamtramEditor.this.getActionBarContributor().setActiveEditor(PamtramEditor.this);
					PamtramEditor.this.handleActivate();
				}
			}

		}

		@Override
		public void partBroughtToTop(IWorkbenchPart p) {

			// Ignore.
		}

		@Override
		public void partClosed(IWorkbenchPart p) {

			if (p == PamtramEditor.this && PamtramEditor.this.getEditorInput() instanceof FileEditorInput) {

				// Save the UI state
				//
				IDialogSettings settings = PamtramEditorPlugin.getPlugin().getDialogSettings();
				IDialogSettings section = settings.getSection("UI_STATE");
				if (section == null) {
					section = settings.addNewSection("UI_STATE");
				}
				String pamtramFile = ((FileEditorInput) PamtramEditor.this.getEditorInput()).getFile().toString();
				IDialogSettings project = settings.getSection(pamtramFile);
				if (project == null) {
					project = section.addNewSection(pamtramFile);
				}
				PamtramEditor.this.persist(project);
			}

		}

		@Override
		public void partDeactivated(IWorkbenchPart p) {

			// Ignore.
		}

		@Override
		public void partOpened(IWorkbenchPart p) {

			PamtramEditor.this.getSite().getPage().addPartListener(PamtramEditor.this.handleRestoreListener);
		}
	};

	/**
	 * Resources that have been removed since last activation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Collection<Resource> removedResources = new ArrayList<>();

	/**
	 * Resources that have been changed since last activation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Collection<Resource> changedResources = new ArrayList<>();

	/**
	 * Resources that have been saved. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Collection<Resource> savedResources = new ArrayList<>();

	/**
	 * Map to store the diagnostic associated with a resource. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<>();

	/**
	 * Controls whether the problem indication should be updated. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * Adapter used to update the problem indication when resources are demanded loaded. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {

		@Override
		public void notifyChanged(Notification notification) {

			if (notification.getNotifier() instanceof Resource) {
				switch (notification.getFeatureID(Resource.class)) {
					case Resource.RESOURCE__IS_LOADED:
					case Resource.RESOURCE__ERRORS:
					case Resource.RESOURCE__WARNINGS: {
						Resource resource = (Resource) notification.getNotifier();
						Diagnostic diagnostic = PamtramEditor.this.analyzeResourceProblems(resource, null);
						if (diagnostic.getSeverity() != Diagnostic.OK) {
							PamtramEditor.this.resourceToDiagnosticMap.put(resource, diagnostic);
						} else {
							PamtramEditor.this.resourceToDiagnosticMap.remove(resource);
						}

						if (PamtramEditor.this.updateProblemIndication) {
							PamtramEditor.this.getSite().getShell().getDisplay()
									.asyncExec(() -> PamtramEditor.this.updateProblemIndication());
						}
						break;
					}
				}
			} else {
				super.notifyChanged(notification);
			}
		}

		@Override
		protected void setTarget(Resource target) {

			this.basicSetTarget(target);
		}

		@Override
		protected void unsetTarget(Resource target) {

			this.basicUnsetTarget(target);
			PamtramEditor.this.resourceToDiagnosticMap.remove(target);
			if (PamtramEditor.this.updateProblemIndication) {
				PamtramEditor.this.getSite().getShell().getDisplay()
						.asyncExec(() -> PamtramEditor.this.updateProblemIndication());
			}
		}
	};

	/**
	 * The content adapter used to perform various changes automatically when the model changes.
	 */
	protected PamtramContentAdapter pamtramContentAdapter = new PamtramContentAdapter(this);

	/**
	 * This returns the {@link #pamtramContentAdapter}.
	 *
	 * @return The content adapter used to perform various changes automatically when the model changes.
	 */
	public PamtramContentAdapter getPamtramContentAdapter() {

		return this.pamtramContentAdapter;
	}

	/**
	 * This adapter keeps track of the {@link Resource}s in the resource set that represent {@link LibraryEntry}s.
	 */
	protected Adapter libraryResourceAdapter = new AdapterImpl() {

		@Override
		public void notifyChanged(Notification msg) {

			super.notifyChanged(msg);

			Resource resource;

			if (msg.getEventType() == Notification.ADD && msg.getNewValue() instanceof Resource) {
				resource = (Resource) msg.getNewValue();
			} else if (msg.getEventType() == Notification.REMOVE && msg.getOldValue() instanceof Resource) {
				resource = (Resource) msg.getOldValue();
			} else {
				return;
			}

			Resource pamtramResource = PamtramEditor.this.pamtram.eResource();

			if (pamtramResource.equals(resource)) {
				return;
			}

			// Check if the changed resource is a library resource
			//
			if (resource.isLoaded()) {
				if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof LibraryEntry)) {
					return;
				}
			} else {
				URI relativeURI = resource.getURI().deresolve(pamtramResource.getURI());
				if (relativeURI == null || relativeURI.isEmpty() || relativeURI.equals(resource.getURI())
						|| !"lib".equals(relativeURI.segment(0))) {
					return;
				}
			}

			if (msg.getEventType() == Notification.ADD) {

				PamtramEditor.this.libraryResources.add((Resource) msg.getNewValue());
				PamtramEditor.this.editingDomain.getResourceToReadOnlyMap().put((Resource) msg.getNewValue(),
						Boolean.TRUE);

			} else if (msg.getEventType() == Notification.REMOVE) {

				PamtramEditor.this.libraryResources.remove(msg.getOldValue());
				PamtramEditor.this.editingDomain.getResourceToReadOnlyMap().remove(msg.getOldValue());

			}
		}
	};

	/**
	 * This listens for commands.
	 */
	protected PamtramCommandStackListener pamtramCommandStackListener = new PamtramCommandStackListener(this);

	/**
	 * This listens for workspace changes. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected IResourceChangeListener resourceChangeListener = event -> {
		IResourceDelta delta = event.getDelta();
		try {
			class ResourceDeltaVisitor implements IResourceDeltaVisitor {

				protected ResourceSet resourceSet = PamtramEditor.this.editingDomain.getResourceSet();

				protected Collection<Resource> changedResources = new ArrayList<>();

				protected Collection<Resource> removedResources = new ArrayList<>();

				@Override
				public boolean visit(IResourceDelta delta) {

					if (delta.getResource().getType() == IResource.FILE) {
						if (delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED
								&& delta.getFlags() != IResourceDelta.MARKERS) {
							Resource resource = this.resourceSet.getResource(
									URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
							if (resource != null) {
								if (delta.getKind() == IResourceDelta.REMOVED) {
									this.removedResources.add(resource);
								} else if (!PamtramEditor.this.savedResources.remove(resource)) {
									this.changedResources.add(resource);
								}
							}
						}
						return false;
					}

					return true;
				}

				public Collection<Resource> getChangedResources() {

					return this.changedResources;
				}

				public Collection<Resource> getRemovedResources() {

					return this.removedResources;
				}
			}

			final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
			delta.accept(visitor);

			if (!visitor.getRemovedResources().isEmpty()) {
				boolean exit = false;
				EList<pamtram.structure.library.LibraryEntry> libEntries = new BasicEList<>();
				for (TargetSectionModel targetSectionModel : PamtramEditor.this.pamtram.getTargetSectionModels()) {
					libEntries.addAll(targetSectionModel.getLibraryElements());
				}
				for (Resource resource : visitor.getRemovedResources()) {
					// Only close the editor if a used library entry is deleted
					//
					if (resource.getURI().lastSegment().equals("data.xmi")) {
						String path = resource.getURI().trimSegments(1).lastSegment();
						for (pamtram.structure.library.LibraryEntry libraryEntry : libEntries) {
							if (libraryEntry.getClasspath().equals(path)) {
								exit = true;
								break;
							}
						}
						// Only close the editor if a used shared SectionModel
						// is deleted
						//
					} else if (resource.getURI().lastSegment().endsWith(".pamtram.source")
							|| resource.getURI().lastSegment().endsWith(".pamtram.target")) {
						if (!resource.getContents().isEmpty()) {
							exit = true;
							break;
						}
					} else {
						exit = true;
						break;
					}
				}
				if (exit) {
					PamtramEditor.this.getSite().getShell().getDisplay().asyncExec(() -> {
						PamtramEditor.this.removedResources.addAll(visitor.getRemovedResources());
						if (!PamtramEditor.this.isDirty()) {
							PamtramEditor.this.getSite().getPage().closeEditor(PamtramEditor.this, false);
						}
					});
				}
			}

			if (!visitor.getChangedResources().isEmpty()) {
				PamtramEditor.this.getSite().getShell().getDisplay().asyncExec(() -> {
					PamtramEditor.this.changedResources.addAll(visitor.getChangedResources());
					if (PamtramEditor.this.getSite().getPage().getActiveEditor() == PamtramEditor.this) {
						PamtramEditor.this.handleActivate();
					}
				});
			}
		} catch (CoreException exception) {
			PamtramEditorPlugin.INSTANCE.log(exception);
		}
	};

	/**
	 * This is the {@link PAMTraM} instance that this editor works on.
	 */
	protected PAMTraM pamtram;

	/**
	 * This is the getter for the {@link #pamtram}
	 *
	 * @return The pamtram instance that this editor operates on.
	 */
	public PAMTraM getPamtram() {

		return this.pamtram;
	}

	/**
	 * This is a list of {@link Resource}s that represent
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry}s in the {@link PAMTraM}
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
	 * Handles activation of the editor or it's associated views. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void handleActivateGen() {

		// Recompute the read only state.
		//
		if (this.editingDomain.getResourceToReadOnlyMap() != null) {
			this.editingDomain.getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled.
			//
			this.setSelection(this.getSelection());
		}

		if (!this.removedResources.isEmpty()) {
			if (this.handleDirtyConflict()) {
				this.getSite().getPage().closeEditor(PamtramEditor.this, false);
			} else {
				this.removedResources.clear();
				this.changedResources.clear();
				this.savedResources.clear();
			}
		} else if (!this.changedResources.isEmpty()) {
			this.changedResources.removeAll(this.savedResources);
			this.handleChangedResources();
			this.changedResources.clear();
			this.savedResources.clear();
		}
	}

	/**
	 * Handles activation of the editor or it's associated views. <!-- begin-user-doc --> Add all the library element
	 * resources to the read-only map. <!-- end-user-doc -->
	 */
	protected void handleActivate() {

		this.handleActivateGen();

		if (this.pamtram == null || this.pamtram.getTargetSectionModels() == null) {
			return;
		}

		// mark all known resource that represent library entries as read-only
		for (Resource resource : this.libraryResources) {
			this.editingDomain.getResourceToReadOnlyMap().put(resource, Boolean.TRUE);
		}
	}

	/**
	 * Handles what to do with changed resources on activation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT due to evaluating 'getSelection' instead of the default 'editorSelection'
	 */
	protected void handleChangedResources() {

		if (!this.changedResources.isEmpty() && (!this.isDirty() || this.handleDirtyConflict())) {
			if (this.isDirty()) {
				this.changedResources.addAll(this.editingDomain.getResourceSet().getResources());
			}
			this.editingDomain.getCommandStack().flush();

			this.updateProblemIndication = false;
			for (Resource resource : this.changedResources) {
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					} catch (IOException exception) {
						if (!this.resourceToDiagnosticMap.containsKey(resource)) {
							this.resourceToDiagnosticMap.put(resource,
									this.analyzeResourceProblems(resource, exception));
						}
					}
				}
			}

			// if (AdapterFactoryEditingDomain.isStale(this.editorSelection)) {
			if (AdapterFactoryEditingDomain.isStale(this.getSelection())) {
				this.setSelection(StructuredSelection.EMPTY);
			}

			this.updateProblemIndication = true;
			this.updateProblemIndication();
		}
	}

	/**
	 * Updates the problems indication with the information described in the specified diagnostic. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void updateProblemIndication() {

		if (this.updateProblemIndication) {
			BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "de.mfreund.pamtram.model.editor", 0, null,
					new Object[] { this.editingDomain.getResourceSet() });
			for (Diagnostic childDiagnostic : this.resourceToDiagnosticMap.values()) {
				if (childDiagnostic.getSeverity() != Diagnostic.OK) {
					diagnostic.add(childDiagnostic);
				}
			}

			int lastEditorPage = this.getPageCount() - 1;
			if (lastEditorPage >= 0 && this.getEditor(lastEditorPage) instanceof ProblemEditorPart) {
				((ProblemEditorPart) this.getEditor(lastEditorPage)).setDiagnostic(diagnostic);
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					this.setActivePage(lastEditorPage);
				}
			} else if (diagnostic.getSeverity() != Diagnostic.OK) {
				ProblemEditorPart problemEditorPart = new ProblemEditorPart();
				problemEditorPart.setDiagnostic(diagnostic);
				problemEditorPart.setMarkerHelper(this.markerHelper);
				try {
					this.addPage(++lastEditorPage, problemEditorPart, this.getEditorInput());
					this.setPageText(lastEditorPage, problemEditorPart.getPartName());
					this.setActivePage(lastEditorPage);
					this.showTabs();
				} catch (PartInitException exception) {
					PamtramEditorPlugin.INSTANCE.log(exception);
				}
			}

			if (this.markerHelper.hasMarkers(this.editingDomain.getResourceSet())) {
				this.markerHelper.deleteMarkers(this.editingDomain.getResourceSet());
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					try {
						this.markerHelper.createMarkers(diagnostic);
					} catch (CoreException exception) {
						PamtramEditorPlugin.INSTANCE.log(exception);
					}
				}
			}
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected boolean handleDirtyConflict() {

		return MessageDialog.openQuestion(this.getSite().getShell(), PamtramEditor.getString("_UI_FileConflict_label"),
				PamtramEditor.getString("_WARN_FileConflict"));
	}

	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given '<em>pamtram</em>' instance.
	 *
	 * @param pamtram
	 *            The {@link PAMTraM} model for which an existing editor shall be returned.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 *         exists.
	 */
	public static PamtramEditor getEditor(PAMTraM pamtram) {

		// get the active workbench window
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		// iterate through all pages and their editors and check if there is a
		// 'PamtramEditor' for the given pamtram
		// instance
		for (IWorkbenchPage page : workbenchWindow.getPages()) {
			for (IEditorReference editorRef : page.getEditorReferences()) {
				if (editorRef.getEditor(false) instanceof PamtramEditor
						&& ((PamtramEditor) editorRef.getEditor(false)).isEditorFor(pamtram)) {

					return (PamtramEditor) editorRef.getEditor(false);
				}
			}

		}

		return null;
	}

	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given '<em>pamtram</em>' instance.
	 *
	 * @param pamtram
	 *            The {@link PAMTraM} model for which an existing editor shall be returned.
	 * @param openNewEditor
	 *            Whether a new editor shall be opened if no editor for the given '<em>pamtram</em>' exists.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 *         exists/could be opened.
	 */
	public static PamtramEditor getEditor(PAMTraM pamtram, boolean openNewEditor) {

		PamtramEditor editor = PamtramEditor.getEditor(pamtram);

		if (editor != null || !openNewEditor) {
			return editor;
		}

		// no editor has been found so we open a new one
		IFile file = ResourceHelper.getFileForResource(pamtram.eResource());

		try {
			return (PamtramEditor) UIHelper.openEditor(file, "pamtram.presentation.PamtramEditorID");
		} catch (PartInitException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given path to a pamtram instance.
	 *
	 * @param pamtramPath
	 *            The absolute full path to the pamtram model for which an existing editor shall be returned.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 *         exists.
	 */
	public static PamtramEditor getEditor(String pamtramPath) {

		// get the active workbench window
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		// iterate through all pages and their editors and check if there is a
		// 'PamtramEditor' for the given pamtram
		// instance
		for (IWorkbenchPage page : workbenchWindow.getPages()) {
			for (IEditorReference editorRef : page.getEditorReferences()) {
				if (editorRef.getEditor(false) instanceof PamtramEditor
						&& ((PamtramEditor) editorRef.getEditor(false)).isEditorFor(pamtramPath)) {

					return (PamtramEditor) editorRef.getEditor(true);
				}
			}

		}

		return null;
	}

	/**
	 * This returns an existing {@link PamtramEditor} that is used for the given path to a pamtram instance.
	 *
	 * @param pamtramPath
	 *            The absolute full path to the pamtram model for which an existing editor shall be returned.
	 * @param openNewEditor
	 *            Whether a new editor shall be opened if no editor for the given '<em>pamtramPath</em>' exists.
	 * @return The {@link PamtramEditor} for the given '<em>pamtram</em>' instance or '<em>null</em>' if no editor
	 *         exists/could be opened.
	 */
	public static PamtramEditor getEditor(String pamtramPath, boolean openNewEditor) {

		PamtramEditor editor = PamtramEditor.getEditor(pamtramPath);

		if (editor != null || !openNewEditor) {
			return editor;
		}

		// no editor has been found so we open a new one
		IFile file = null;
		try {

			IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
					.findFilesForLocationURI(new java.net.URI(URI.createFileURI(pamtramPath).toString()));

			if (files.length == 0) {
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

			IEditorPart editorPart = workbenchWindow.getActivePage().openEditor(new FileEditorInput(file),
					"pamtram.presentation.PamtramEditorID");

			return (PamtramEditor) editorPart;

		} catch (PartInitException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * This may be used to check if the editor is used for editing the given '<em>pamtram</em>' instance.
	 *
	 * @param pamtram
	 *            The {@link PAMTraM} instance to check.
	 * @return '<em><b>true</b></em>' if this editor is used for editing the given {@link PAMTraM} instance,
	 *         '<em><b>false</b></em>' otherwise.
	 */
	public boolean isEditorFor(PAMTraM pamtram) {

		if (this.pamtram == null) {
			return false;

		} else if (this.pamtram.equals(pamtram)
				|| this.pamtram.eResource().getURI().toString().equals(pamtram.eResource().getURI().toString())) {
			return true;

		} else if (pamtram.eResource().getURI().isFile()) {

			// if all other checks failed, check if both pamtram instance are
			// based on the same file
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IFile file = workspace.getRoot()
					.getFile(new Path(this.pamtram.eResource().getURI().toPlatformString(true)));
			return file.getLocation().toOSString().equals(pamtram.eResource().getURI().toFileString());
		}
		return false;
	}

	/**
	 * This may be used to check if the editor is used for editing the given path to a pamtra file.
	 *
	 * @param pamtramPath
	 *            The absolute full path to the pamtram instance to check.
	 * @return '<em><b>true</b></em>' if this editor is used for editing the given {@link PAMTraM} instance,
	 *         '<em><b>false</b></em>' otherwise.
	 */
	public boolean isEditorFor(String pamtramPath) {

		// if all other checks failed, check if both pamtram instance are based
		// on the same file
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IFile file = workspace.getRoot().getFile(new Path(this.pamtram.eResource().getURI().toPlatformString(true)));
		return file.getLocation().toOSString().equals(pamtramPath);
	}

	/**
	 * This creates a model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public PamtramEditor() {

		super();
		// initializeEditingDomain();
	}

	/**
	 * This sets up the editing domain for the model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void initializeEditingDomain() {

		// Create an adapter factory that yields item providers.
		//
		this.adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		this.adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new PamtramItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new StructureItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new ConditionItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new MappingItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new GenLibraryItemProviderAdapterFactory());
		this.adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are
		// executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack() {

			@Override
			public void execute(Command command) {

				// Cancel live validation before executing a command that will
				// trigger a new round of validation.
				//
				if (!(command instanceof AbstractCommand.NonDirtying)) {
					DiagnosticDecorator.cancel(PamtramEditor.this.editingDomain);
				}
				super.execute(command);
			}
		};

		// Add a listener to set the most recent command's affected objects to
		// be the selection of the viewer with
		// focus.
		//
		commandStack.addCommandStackListener(event -> PamtramEditor.this.getContainer().getDisplay().asyncExec(() -> {
			PamtramEditor.this.firePropertyChange(IEditorPart.PROP_DIRTY);

			// Try to select the affected objects.
			//
			Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
			if (mostRecentCommand != null) {
				PamtramEditor.this.setSelectionToViewer(mostRecentCommand.getAffectedObjects());
			}
			for (Iterator<PropertySheetPage> i = PamtramEditor.this.propertySheetPages.iterator(); i.hasNext();) {
				PropertySheetPage propertySheetPage = i.next();
				if (propertySheetPage.getControl().isDisposed()) {
					i.remove();
				} else {
					propertySheetPage.refresh();
				}
			}
		}));

		// Create the editing domain with a special command stack.
		//
		this.editingDomain = new AdapterFactoryEditingDomain(this.adapterFactory, commandStack,
				new HashMap<Resource, Boolean>());
	}

	/**
	 * This is here for the listener to be able to call it. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void firePropertyChange(int action) {

		super.firePropertyChange(action);
	}

	/**
	 * This sets the selection into whichever viewer is active. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSelectionToViewer(Collection<?> collection) {

		final Collection<?> theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable = () -> {
				// Try to select the items in the current content viewer of the
				// editor.
				//
				if (PamtramEditor.this.currentViewer != null) {
					PamtramEditor.this.currentViewer.setSelection(new StructuredSelection(theSelection.toArray()),
							true);
				}
			};
			this.getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

	/**
	 * This returns the editing domain as required by the {@link IEditingDomainProvider} interface. This is important
	 * for implementing the static methods of {@link AdapterFactoryEditingDomain} and for supporting
	 * {@link org.eclipse.emf.edit.ui.action.CommandAction}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AdapterFactoryEditingDomain getEditingDomain() {

		return this.editingDomain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public class ReverseAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {

			super(adapterFactory);
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		@Override
		public Object[] getElements(Object object) {

			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		@Override
		public Object[] getChildren(Object object) {

			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		@Override
		public boolean hasChildren(Object object) {

			Object parent = super.getParent(object);
			return parent != null;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		@Override
		public Object getParent(Object object) {

			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setCurrentViewerPane(ViewerPane viewerPane) {

		if (this.currentViewerPane != viewerPane) {
			if (this.currentViewerPane != null) {
				this.currentViewerPane.showFocus(false);
			}
			this.currentViewerPane = viewerPane;
		}
		this.setCurrentViewer(this.currentViewerPane.getViewer());
	}

	/**
	 * This makes sure that one content viewer, either for the current page or the outline view, if it has focus, is the
	 * current one. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setCurrentViewer(Viewer viewer) {

		// If it is changing...
		//
		if (this.currentViewer != viewer) {
			if (this.selectionChangedListener == null) {
				// Create the listener on demand.
				//
				this.selectionChangedListener = selectionChangedEvent -> PamtramEditor.this
						.setSelection(selectionChangedEvent.getSelection());
			}

			// Stop listening to the old one.
			//
			if (this.currentViewer != null) {
				this.currentViewer.removeSelectionChangedListener(this.selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(this.selectionChangedListener);
			}

			// Remember it.
			//
			this.currentViewer = viewer;

			// Set the editors selection based on the current viewer's
			// selection.
			//
			this.setSelection(
					this.currentViewer == null ? StructuredSelection.EMPTY : this.currentViewer.getSelection());
		}
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider} interface. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Viewer getViewer() {

		return this.currentViewer;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well registering the menu for extension. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void createContextMenuFor(StructuredViewer viewer) {

		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		this.getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance(), LocalSelectionTransfer.getTransfer(),
				FileTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));

		// Use the custom drop adapter that will display a tooltip to the user
		viewer.addDropSupport(dndOperations, transfers, new TooltipDisplayingDropAdapter(this.editingDomain, viewer));

		// Show the 'PropertiesView' if the user double-clicks on an element
		viewer.getControl().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDoubleClick(MouseEvent event) {

				if (event.button == 1) {
					try {
						PamtramEditor.this.getEditorSite().getPage().showView("org.eclipse.ui.views.PropertySheet");
					} catch (PartInitException exception) {
						AgteleUIPlugin.INSTANCE.log(exception);
					}
				}
			}
		});
	}

	/**
	 * This is the method called to load a resource into the editing domain's resource set based on the editor's input.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void createModel() {

		URI resourceURI = EditUIUtil.getURI(this.getEditorInput(),
				this.editingDomain.getResourceSet().getURIConverter());

		Exception exception = null;
		Resource resource = null;
		try {
			this.pamtram = PamtramModelUtil.loadPamtramModel(this.editingDomain.getResourceSet(), resourceURI, true);
			resource = this.pamtram.eResource();
		} catch (ModelLoadException e1) {
			exception = e1;
			resource = this.editingDomain.getResourceSet().getResource(resourceURI, true);
			if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof PAMTraM) {
				this.pamtram = (PAMTraM) resource.getContents().get(0);
			}
		}

		Diagnostic diagnostic = this.analyzeResourceProblems(resource, exception);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			this.resourceToDiagnosticMap.put(resource, this.analyzeResourceProblems(resource, exception));
		}

		// Prevent the adapter to be added multiple times in case this method is
		// called more than once
		//
		if (!this.editingDomain.getResourceSet().eAdapters().contains(this.problemIndicationAdapter)) {
			this.editingDomain.getResourceSet().eAdapters().add(this.problemIndicationAdapter);
		}
	}

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the resource and the specified exception (if
	 * any). <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {

		boolean hasErrors = !resource.getErrors().isEmpty();
		if (hasErrors || !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic = new BasicDiagnostic(hasErrors ? Diagnostic.ERROR : Diagnostic.WARNING,
					"de.mfreund.pamtram.model.editor", 0,
					PamtramEditor.getString("_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception == null ? (Object) resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		} else if (exception != null) {
			return new BasicDiagnostic(Diagnostic.ERROR, "de.mfreund.pamtram.model.editor", 0,
					PamtramEditor.getString("_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception });
		} else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	/**
	 * This is the method used by the framework to install your own controls. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public void createPagesGen() {

		// Creates the model from the editor input
		//
		this.createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!this.getEditingDomain().getResourceSet().getResources().isEmpty()) {
			// Create a page for the selection tree view.
			//
			{
				ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), PamtramEditor.this) {

					@Override
					public Viewer createViewer(Composite composite) {

						Tree tree = new Tree(composite, SWT.MULTI);
						TreeViewer newTreeViewer = new TreeViewer(tree);
						return newTreeViewer;
					}

					@Override
					public void requestActivation() {

						super.requestActivation();
						PamtramEditor.this.setCurrentViewerPane(this);
					}
				};
				viewerPane.createControl(this.getContainer());

				this.selectionViewer = (TreeViewer) viewerPane.getViewer();
				this.selectionViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));

				this.selectionViewer.setLabelProvider(
						new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(
								new AdapterFactoryLabelProvider.StyledLabelProvider(this.adapterFactory,
										this.selectionViewer),
								new DiagnosticDecorator.Styled(this.editingDomain, this.selectionViewer,
										PamtramEditorPlugin.getPlugin().getDialogSettings()))));
				this.selectionViewer.setInput(this.editingDomain.getResourceSet());
				this.selectionViewer.setSelection(
						new StructuredSelection(this.editingDomain.getResourceSet().getResources().get(0)), true);
				viewerPane.setTitle(this.editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(this.selectionViewer.getTree(), this.adapterFactory);
				new ColumnViewerInformationControlToolTipSupport(this.selectionViewer,
						new DiagnosticDecorator.Styled.EditingDomainLocationListener(this.editingDomain,
								this.selectionViewer));

				this.createContextMenuFor(this.selectionViewer);
				int pageIndex = this.addPage(viewerPane.getControl());
				this.setPageText(pageIndex, PamtramEditor.getString("_UI_SelectionPage_label"));
			}

			// Create a page for the parent tree view.
			//
			{
				ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), PamtramEditor.this) {

					@Override
					public Viewer createViewer(Composite composite) {

						Tree tree = new Tree(composite, SWT.MULTI);
						TreeViewer newTreeViewer = new TreeViewer(tree);
						return newTreeViewer;
					}

					@Override
					public void requestActivation() {

						super.requestActivation();
						PamtramEditor.this.setCurrentViewerPane(this);
					}
				};
				viewerPane.createControl(this.getContainer());

				this.parentViewer = (TreeViewer) viewerPane.getViewer();
				this.parentViewer.setAutoExpandLevel(30);
				this.parentViewer.setContentProvider(new ReverseAdapterFactoryContentProvider(this.adapterFactory));
				this.parentViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
						new AdapterFactoryLabelProvider.StyledLabelProvider(this.adapterFactory, this.parentViewer)));

				this.createContextMenuFor(this.parentViewer);
				int pageIndex = this.addPage(viewerPane.getControl());
				this.setPageText(pageIndex, PamtramEditor.getString("_UI_ParentPage_label"));
			}

			// This is the page for the list viewer
			//
			{
				ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), PamtramEditor.this) {

					@Override
					public Viewer createViewer(Composite composite) {

						return new ListViewer(composite);
					}

					@Override
					public void requestActivation() {

						super.requestActivation();
						PamtramEditor.this.setCurrentViewerPane(this);
					}
				};
				viewerPane.createControl(this.getContainer());
				this.listViewer = (ListViewer) viewerPane.getViewer();
				this.listViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
				this.listViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
						new AdapterFactoryLabelProvider.StyledLabelProvider(this.adapterFactory, this.listViewer)));

				this.createContextMenuFor(this.listViewer);
				int pageIndex = this.addPage(viewerPane.getControl());
				this.setPageText(pageIndex, PamtramEditor.getString("_UI_ListPage_label"));
			}

			// This is the page for the tree viewer
			//
			{
				ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), PamtramEditor.this) {

					@Override
					public Viewer createViewer(Composite composite) {

						return new TreeViewer(composite);
					}

					@Override
					public void requestActivation() {

						super.requestActivation();
						PamtramEditor.this.setCurrentViewerPane(this);
					}
				};
				viewerPane.createControl(this.getContainer());
				this.treeViewer = (TreeViewer) viewerPane.getViewer();
				this.treeViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
				this.treeViewer.setLabelProvider(
						new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(
								new AdapterFactoryLabelProvider.StyledLabelProvider(this.adapterFactory,
										this.treeViewer),
								new DiagnosticDecorator.Styled(this.editingDomain, this.treeViewer))));

				new AdapterFactoryTreeEditor(this.treeViewer.getTree(), this.adapterFactory);
				new ColumnViewerInformationControlToolTipSupport(this.treeViewer,
						new DiagnosticDecorator.Styled.EditingDomainLocationListener(this.editingDomain,
								this.treeViewer));

				this.createContextMenuFor(this.treeViewer);
				int pageIndex = this.addPage(viewerPane.getControl());
				this.setPageText(pageIndex, PamtramEditor.getString("_UI_TreePage_label"));
			}

			// This is the page for the table viewer.
			//
			{
				ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), PamtramEditor.this) {

					@Override
					public Viewer createViewer(Composite composite) {

						return new TableViewer(composite);
					}

					@Override
					public void requestActivation() {

						super.requestActivation();
						PamtramEditor.this.setCurrentViewerPane(this);
					}
				};
				viewerPane.createControl(this.getContainer());
				this.tableViewer = (TableViewer) viewerPane.getViewer();

				Table table = this.tableViewer.getTable();
				TableLayout layout = new TableLayout();
				table.setLayout(layout);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);

				TableColumn objectColumn = new TableColumn(table, SWT.NONE);
				layout.addColumnData(new ColumnWeightData(3, 100, true));
				objectColumn.setText(PamtramEditor.getString("_UI_ObjectColumn_label"));
				objectColumn.setResizable(true);

				TableColumn selfColumn = new TableColumn(table, SWT.NONE);
				layout.addColumnData(new ColumnWeightData(2, 100, true));
				selfColumn.setText(PamtramEditor.getString("_UI_SelfColumn_label"));
				selfColumn.setResizable(true);

				this.tableViewer.setColumnProperties(new String[] { "a", "b" });
				this.tableViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
				this.tableViewer.setLabelProvider(
						new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(
								new AdapterFactoryLabelProvider.StyledLabelProvider(this.adapterFactory,
										this.tableViewer),
								new DiagnosticDecorator.Styled(this.editingDomain, this.tableViewer,
										PamtramEditorPlugin.getPlugin().getDialogSettings()))));

				new ColumnViewerInformationControlToolTipSupport(this.tableViewer,
						new DiagnosticDecorator.Styled.EditingDomainLocationListener(this.editingDomain,
								this.tableViewer));

				this.createContextMenuFor(this.tableViewer);
				int pageIndex = this.addPage(viewerPane.getControl());
				this.setPageText(pageIndex, PamtramEditor.getString("_UI_TablePage_label"));
			}

			// This is the page for the table tree viewer.
			//
			{
				ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), PamtramEditor.this) {

					@Override
					public Viewer createViewer(Composite composite) {

						return new TreeViewer(composite);
					}

					@Override
					public void requestActivation() {

						super.requestActivation();
						PamtramEditor.this.setCurrentViewerPane(this);
					}
				};
				viewerPane.createControl(this.getContainer());

				this.treeViewerWithColumns = (TreeViewer) viewerPane.getViewer();

				Tree tree = this.treeViewerWithColumns.getTree();
				tree.setLayoutData(new FillLayout());
				tree.setHeaderVisible(true);
				tree.setLinesVisible(true);

				TreeColumn objectColumn = new TreeColumn(tree, SWT.NONE);
				objectColumn.setText(PamtramEditor.getString("_UI_ObjectColumn_label"));
				objectColumn.setResizable(true);
				objectColumn.setWidth(250);

				TreeColumn selfColumn = new TreeColumn(tree, SWT.NONE);
				selfColumn.setText(PamtramEditor.getString("_UI_SelfColumn_label"));
				selfColumn.setResizable(true);
				selfColumn.setWidth(200);

				this.treeViewerWithColumns.setColumnProperties(new String[] { "a", "b" });
				this.treeViewerWithColumns.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
				this.treeViewerWithColumns.setLabelProvider(
						new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(
								new AdapterFactoryLabelProvider.StyledLabelProvider(this.adapterFactory,
										this.treeViewerWithColumns),
								new DiagnosticDecorator.Styled(this.editingDomain, this.treeViewerWithColumns,
										PamtramEditorPlugin.getPlugin().getDialogSettings()))));

				new ColumnViewerInformationControlToolTipSupport(this.treeViewerWithColumns,
						new DiagnosticDecorator.Styled.EditingDomainLocationListener(this.editingDomain,
								this.treeViewerWithColumns));

				this.createContextMenuFor(this.treeViewerWithColumns);
				int pageIndex = this.addPage(viewerPane.getControl());
				this.setPageText(pageIndex, PamtramEditor.getString("_UI_TreeWithColumnsPage_label"));
			}

			this.getSite().getShell().getDisplay().asyncExec(() -> PamtramEditor.this.setActivePage(0));
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		this.getContainer().addControlListener(new ControlAdapter() {

			boolean guard = false;

			@Override
			public void controlResized(ControlEvent event) {

				if (!this.guard) {
					this.guard = true;
					PamtramEditor.this.hideTabs();
					this.guard = false;
				}
			}
		});

		this.getSite().getShell().getDisplay().asyncExec(() -> PamtramEditor.this.updateProblemIndication());
	}

	/**
	 * This is the method used by the framework to install your own controls. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 */
	@Override
	public void createPages() {

		// Load the Pamtram model from the editor input.
		//
		this.createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (this.pamtram != null) {

			// Set the Pamtram content adapter.
			this.pamtram.eAdapters().add(this.pamtramContentAdapter);

			// Set the library resource adapter.
			this.editingDomain.getResourceSet().eAdapters().add(this.libraryResourceAdapter);

			// Set the Pamtram command stack listener.
			this.getEditingDomain().getCommandStack().addCommandStackListener(this.pamtramCommandStackListener);
		}

		// Create a page for the selection tree view.
		//
		{
			this.mainPage = new PamtramEditorMainPage(this.getContainer(), SWT.None, this.adapterFactory, this);
			int pageIndex = this.addPage(this.mainPage);
			this.setPageText(pageIndex, PamtramEditor.getString("_UI_SelectionPage_label"));
		}

		// Create a page for the source section matcher view.
		//
		{
			this.sourceSectionMatcherPage = new PamtramEditorSourceSectionMatcherPage(this.getContainer(), SWT.NONE,
					this.adapterFactory, this);
			// createContextMenuFor(parentViewer);
			int pageIndex = this.addPage(this.sourceSectionMatcherPage);
			this.setPageText(pageIndex, PamtramEditor.getString("_UI_ParentPage_label"));
		}

		this.getSite().getShell().getDisplay().asyncExec(() -> PamtramEditor.this.setActivePage(0));

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		this.getContainer().addControlListener(new ControlAdapter() {

			boolean guard = false;

			@Override
			public void controlResized(ControlEvent event) {

				if (!this.guard) {
					this.guard = true;
					PamtramEditor.this.hideTabs();
					this.guard = false;
				}
			}
		});

		this.getSite().getShell().getDisplay().asyncExec(() -> PamtramEditor.this.updateProblemIndication());
	}

	/**
	 * If there is just one page in the multi-page editor part, this hides the single tab at the bottom. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void hideTabs() {

		if (this.getPageCount() <= 1) {
			this.setPageText(0, "");
			if (this.getContainer() instanceof CTabFolder) {
				((CTabFolder) this.getContainer()).setTabHeight(1);
				Point point = this.getContainer().getSize();
				this.getContainer().setSize(point.x, point.y + 6);
			}
		}
	}

	/**
	 * If there is more than one page in the multi-page editor part, this shows the tabs at the bottom. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void showTabs() {

		if (this.getPageCount() > 1) {
			this.setPageText(0, PamtramEditor.getString("_UI_SelectionPage_label"));
			if (this.getContainer() instanceof CTabFolder) {
				((CTabFolder) this.getContainer()).setTabHeight(SWT.DEFAULT);
				Point point = this.getContainer().getSize();
				this.getContainer().setSize(point.x, point.y - 6);
			}
		}
	}

	/**
	 * This is used to track the active viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected void pageChange(int pageIndex) {

		super.pageChange(pageIndex);

		if (this.contentOutlinePage != null) {
			this.handleContentOutlineSelection(this.contentOutlinePage.getSelection());
		}
	}

	/**
	 * This is how the framework determines which interfaces we implement. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {

		if (key.equals(IContentOutlinePage.class)) {
			return this.showOutlineView() ? this.getContentOutlinePage() : null;
		} else if (key.equals(IPropertySheetPage.class)) {
			return this.getPropertySheetPage();
		} else if (key.equals(IGotoMarker.class)) {
			return this;
		} else {
			return super.getAdapter(key);
		}
	}

	/**
	 * This accesses a cached version of the content outliner. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public IContentOutlinePage getContentOutlinePage() {

		if (this.contentOutlinePage == null) {
			// The content outline is just a tree.
			//
			class MyContentOutlinePage extends ContentOutlinePage {

				@Override
				public void createControl(Composite parent) {

					super.createControl(parent);
					PamtramEditor.this.contentOutlineViewer = this.getTreeViewer();
					PamtramEditor.this.contentOutlineViewer.addSelectionChangedListener(this);

					// Set up the tree viewer.
					//
					PamtramEditor.this.contentOutlineViewer
							.setContentProvider(new AdapterFactoryContentProvider(PamtramEditor.this.adapterFactory));
					PamtramEditor.this.contentOutlineViewer.setLabelProvider(
							new DelegatingStyledCellLabelProvider(new DecoratingColumLabelProvider.StyledLabelProvider(
									new AdapterFactoryLabelProvider.StyledLabelProvider(
											PamtramEditor.this.adapterFactory, PamtramEditor.this.contentOutlineViewer),
									new DiagnosticDecorator.Styled(PamtramEditor.this.editingDomain,
											PamtramEditor.this.contentOutlineViewer,
											PamtramEditorPlugin.getPlugin().getDialogSettings()))));
					PamtramEditor.this.contentOutlineViewer.setInput(PamtramEditor.this.editingDomain.getResourceSet());

					new ColumnViewerInformationControlToolTipSupport(PamtramEditor.this.contentOutlineViewer,
							new DiagnosticDecorator.Styled.EditingDomainLocationListener(
									PamtramEditor.this.editingDomain, PamtramEditor.this.contentOutlineViewer));

					// Make sure our popups work.
					//
					PamtramEditor.this.createContextMenuFor(PamtramEditor.this.contentOutlineViewer);

					if (!PamtramEditor.this.editingDomain.getResourceSet().getResources().isEmpty()) {
						// Select the root object in the view.
						//
						PamtramEditor.this.contentOutlineViewer.setSelection(new StructuredSelection(
								PamtramEditor.this.editingDomain.getResourceSet().getResources().get(0)), true);
					}
				}

				@Override
				public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager,
						IStatusLineManager statusLineManager) {

					super.makeContributions(menuManager, toolBarManager, statusLineManager);
					PamtramEditor.this.contentOutlineStatusLineManager = statusLineManager;
				}

				@Override
				public void setActionBars(IActionBars actionBars) {

					super.setActionBars(actionBars);
					PamtramEditor.this.getActionBarContributor().shareGlobalActions(this, actionBars);
				}
			}

			this.contentOutlinePage = new MyContentOutlinePage();

			// Listen to selection so that we can handle it is a special way.
			//
			this.contentOutlinePage.addSelectionChangedListener(
					event -> PamtramEditor.this.handleContentOutlineSelection(event.getSelection()));
		}

		return this.contentOutlinePage;
	}

	/**
	 * This accesses a cached version of the property sheet. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public IPropertySheetPage getPropertySheetPage() {

		PropertySheetPage propertySheetPage = new ExtendedPropertySheetPage(this.editingDomain,
				ExtendedPropertySheetPage.Decoration.LIVE, PamtramEditorPlugin.getPlugin().getDialogSettings()) {

			@Override
			public void setSelectionToViewer(List<?> selection) {

				PamtramEditor.this.setSelectionToViewer(selection);
				PamtramEditor.this.setFocus();
			}

			@Override
			public void setActionBars(IActionBars actionBars) {

				super.setActionBars(actionBars);
				PamtramEditor.this.getActionBarContributor().shareGlobalActions(this, actionBars);
			}
		};
		propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(this.adapterFactory));
		this.propertySheetPages.add(propertySheetPage);

		return propertySheetPage;
	}

	/**
	 * This deals with how we want selection in the outliner to affect the other views. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	public void handleContentOutlineSelection(ISelection selection) {

		if (this.currentViewerPane != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection) selection).iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				// If it's the selection viewer, then we want it to select the
				// same selection as this selection.
				//
				if (this.currentViewerPane.getViewer() == this.selectionViewer) {
					ArrayList<Object> selectionList = new ArrayList<>();
					selectionList.add(selectedElement);
					while (selectedElements.hasNext()) {
						selectionList.add(selectedElements.next());
					}

					// Set the selection to the widget.
					//
					this.selectionViewer.setSelection(new StructuredSelection(selectionList));
				} else {
					// Set the input to the widget.
					//
					if (this.currentViewerPane.getViewer().getInput() != selectedElement) {
						this.currentViewerPane.getViewer().setInput(selectedElement);
						this.currentViewerPane.setTitle(selectedElement);
					}
				}
			}
		}
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command stack. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isDirty() {

		return ((BasicCommandStack) this.editingDomain.getCommandStack()).isSaveNeeded();
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {

		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);

		// Persist type information for every reference type if specified by the
		// corresponding preference
		//
		if (PreferenceSupplier.isSerializeAllTypeInfo()) {
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

		// Do the work within an operation because this is a long running
		// activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {

				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : PamtramEditor.this.editingDomain.getResourceSet().getResources()) {
					if ((first || !resource.getContents().isEmpty() || PamtramEditor.this.isPersisted(resource))
							&& !PamtramEditor.this.editingDomain.isReadOnly(resource)) {
						try {
							long timeStamp = resource.getTimeStamp();
							resource.save(saveOptions);
							if (resource.getTimeStamp() != timeStamp) {
								PamtramEditor.this.savedResources.add(resource);
							}
						} catch (Exception exception) {
							PamtramEditor.this.resourceToDiagnosticMap.put(resource,
									PamtramEditor.this.analyzeResourceProblems(resource, exception));
						}
						first = false;
					}
				}
			}
		};

		this.updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(this.getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack) this.editingDomain.getCommandStack()).saveIsDone();
			// firePropertyChange(IEditorPart.PROP_DIRTY);
			this.updateDirtyState();
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			PamtramEditorPlugin.INSTANCE.log(exception);
		}
		this.updateProblemIndication = true;
		this.updateProblemIndication();
	}

	/**
	 * This returns whether something has been persisted to the URI of the specified resource. The implementation uses
	 * the URI converter from the editor's resource set to try to open an input stream. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected boolean isPersisted(Resource resource) {

		boolean result = false;
		try {
			InputStream stream = this.editingDomain.getResourceSet().getURIConverter()
					.createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This always returns true because it is not currently supported. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isSaveAsAllowed() {

		return super.isSaveAsAllowed();
	}

	/**
	 * This also changes the editor's input. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void doSaveAs() {

		SaveAsDialog saveAsDialog = new SaveAsDialog(this.getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				this.doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true),
						new FileEditorInput(file));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {

		ClonableEditor.editingDomains.remove(((IFileEditorInput) editorInput).getFile().toString());
		this.editingDomain.getResourceSet().getResources().get(0).setURI(uri);
		ClonableEditor.editingDomains.put(((IFileEditorInput) editorInput).getFile().toString(), this.editingDomain);

		this.setInputWithNotify(editorInput);
		this.setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = this.getActionBars().getStatusLineManager() != null
				? this.getActionBars().getStatusLineManager().getProgressMonitor()
				: new NullProgressMonitor();
		this.doSave(progressMonitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void gotoMarker(IMarker marker) {

		List<?> targetObjects = this.markerHelper.getTargetObjects(this.editingDomain, marker);
		if (!targetObjects.isEmpty()) {
			this.setSelectionToViewer(targetObjects);
		}
	}

	/**
	 * This is called during startup. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {

		super.init(site, editorInput);
		this.setSite(site);
		this.setInputWithNotify(editorInput);
		this.setPartName(editorInput.getName());
		site.setSelectionProvider(this);
		site.getPage().addPartListener(this.partListener);
		// ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener,
		// IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setFocus() {

		if (this.currentViewerPane != null) {
			this.currentViewerPane.setFocus();
		} else {
			this.getControl(this.getActivePage()).setFocus();
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {

		this.selectionChangedListeners.add(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {

		this.selectionChangedListeners.remove(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's overall selection.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT due to retrieving the selection from the current viewer instead of just evaluating the
	 *            'editorSelection'
	 */
	@Override
	public ISelection getSelection() {

		return this.currentViewer != null ? this.currentViewer.getSelection() : StructuredSelection.EMPTY;
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to set this editor's overall selection.
	 * Calling this result will notify the listeners. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT due to forwarding to 'setSelection' in the active page instead of just setting the
	 *            'editorSelection'
	 */
	@Override
	public void setSelection(ISelection selection) {

		// Redirect to 'setSelection' in the page that is currently active
		//
		if (this.getSelectedPage() instanceof ISelectionProvider) {

			// We need to clear the active selectionChangedListeners to prevent an infinite loop (as setting the
			// selection will trigger new 'changed selection' events which lead to this method being called again)
			//
			List<ISelectionChangedListener> selectionChangedListenersBackup = new ArrayList<>(
					this.selectionChangedListeners);
			this.selectionChangedListeners.clear();
			this.getCurrentViewer().removeSelectionChangedListener(this.selectionChangedListener);

			((ISelectionProvider) this.getSelectedPage()).setSelection(selection);

			// Now, we can restore the active selectionChangeListers
			//
			this.selectionChangedListeners.addAll(selectionChangedListenersBackup);
			this.getCurrentViewer().addSelectionChangedListener(this.selectionChangedListener);
		}

		// Instead of firing a SelectionChangedEvent based on the original 'selection', we use the resulting selection
		// for the currently active viewer instead. That way, the default listeners like e.g. the PropertySheet does not
		// get confused if elements were selected in multiple viewers.
		//
		ISelection resultingSelection = this.getSelection();
		for (ISelectionChangedListener listener : this.selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, resultingSelection));
		}
		this.setStatusLineManager(selection);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setStatusLineManager(ISelection selection) {

		IStatusLineManager statusLineManager = this.currentViewer != null
				&& this.currentViewer == this.contentOutlineViewer ? this.contentOutlineStatusLineManager
						: this.getActionBars().getStatusLineManager();

		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection) selection).toList();
				switch (collection.size()) {
					case 0: {
						statusLineManager.setMessage(PamtramEditor.getString("_UI_NoObjectSelected"));
						break;
					}
					case 1: {
						String text = new AdapterFactoryItemDelegator(this.adapterFactory)
								.getText(collection.iterator().next());
						statusLineManager.setMessage(PamtramEditor.getString("_UI_SingleObjectSelected", text));
						break;
					}
					default: {
						statusLineManager.setMessage(PamtramEditor.getString("_UI_MultiObjectSelected",
								Integer.toString(collection.size())));
						break;
					}
				}
			} else {
				statusLineManager.setMessage("");
			}
		}
	}

	/**
	 * This looks up a string in the plugin's plugin.properties file. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static String getString(String key) {

		return PamtramEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static String getString(String key, Object s1) {

		return PamtramEditorPlugin.INSTANCE.getString(key, new Object[] { s1 });
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus with contributions
	 * from the Edit menu. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {

		((IMenuListener) this.getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {

		return (EditingDomainActionBarContributor) this.getEditorSite().getActionBarContributor();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public IActionBars getActionBars() {

		return this.getActionBarContributor().getActionBars();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public AdapterFactory getAdapterFactory() {

		return this.adapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void disposeGen() {

		this.updateProblemIndication = false;

		// ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		this.getSite().getPage().removePartListener(this.partListener);

		// adapterFactory.dispose();

		if (this.getActionBarContributor().getActiveEditor() == this) {
			this.getActionBarContributor().setActiveEditor(null);
		}

		for (PropertySheetPage propertySheetPage : this.propertySheetPages) {
			propertySheetPage.dispose();
		}

		if (this.contentOutlinePage != null) {
			this.contentOutlinePage.dispose();
		}

		super.dispose();
	}

	/**
	 * Dispose the PamtramContentAdapter and call the original dispose() function.
	 */
	@Override
	public void dispose() {

		// Dispose the Pamtram content adapter.
		this.pamtram.eAdapters().remove(this.pamtramContentAdapter);

		// Dispose the library resource adapter.
		this.editingDomain.getResourceSet().eAdapters().remove(this.libraryResourceAdapter);

		// Dispose the problem indication adapter.
		this.editingDomain.getResourceSet().eAdapters().remove(this.problemIndicationAdapter);

		this.disposeGen();
	}

	/**
	 * Returns whether the outline view should be presented to the user. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected boolean showOutlineView() {

		return true;
	}

	@Override
	public void persist(IDialogSettings settings) {

		// persist the active page
		int index = this.getActivePage();
		settings.put("ACTIVE_PAGE", index);

		// persist the state of the pages displayed by the editor
		this.mainPage.persist(settings.addNewSection("MAIN_PAGE"));
		this.sourceSectionMatcherPage.persist(settings.addNewSection("SOURCE_SECTION_MATCHER_PAGE"));
	}

	@Override
	public void restore(final IDialogSettings settings) {

		// perform the restore operations in an asynchronous way (doing it in a
		// synchonous way would lead to an error because the UI is not yet
		// completely ready)
		//
		try {
			this.getSite().getShell().getDisplay().asyncExec(() -> {

				if (settings == null) {

					// If there are not any settings to restore from, we simply
					// initialize the pages
					//
					this.mainPage.init();
				} else {

					// restore the active page
					int index = settings.getInt("ACTIVE_PAGE");
					if (index >= 0 && index < PamtramEditor.this.getPageCount()) {
						PamtramEditor.this.setActivePage(index);
					}

					// restore the state of the pages displayed by the editor
					this.mainPage.init();
					IDialogSettings page = settings.getSection("MAIN_PAGE");
					if (page != null) {
						PamtramEditor.this.mainPage.restore(page);
					}
					page = settings.getSection("SOURCE_SECTION_MATCHER_PAGE");
					if (page != null) {
						PamtramEditor.this.sourceSectionMatcherPage.restore(page);
					}
				}
			});
		} catch (Exception e) {
			// do nothing
		}
	}

	@Override
	protected Viewer getCurrentViewer() {

		return this.currentViewer;
	}

	@Override
	protected List<PropertySheetPage> getPropertySheetPages() {

		return this.propertySheetPages;
	}

	@Override
	protected ComposedAdapterFactory internalGetAdapterFactory() {

		return this.adapterFactory;
	}

	@Override
	protected Map<Resource, Diagnostic> getResourceToDiagnosticMap() {

		return this.resourceToDiagnosticMap;
	}

	@Override
	protected void setUpdateProblemIndication(boolean updateProblemIndication) {

		this.updateProblemIndication = updateProblemIndication;
	}

	@Override
	protected EMFPlugin getPlugin() {

		return PamtramEditorPlugin.INSTANCE;
	}

	@Override
	protected Collection<Resource> getRemovedResources() {

		return this.removedResources;
	}

	@Override
	protected void setRemovedResources(Collection<Resource> removedResources) {

		this.removedResources = removedResources;
	}

	@Override
	protected Collection<Resource> getChangedResources() {

		return this.changedResources;
	}

	@Override
	protected void setChangedResources(Collection<Resource> changedResources) {

		this.changedResources = changedResources;
	}

	@Override
	protected Collection<Resource> getSavedResources() {

		return this.savedResources;
	}

	@Override
	protected void setSavedResources(Collection<Resource> savedResources) {

		this.savedResources = savedResources;
	}

	@Override
	protected void setAdapterFactory(ComposedAdapterFactory adapterFactory) {

		this.adapterFactory = adapterFactory;
	}

	@Override
	protected void setEditingDomain(AdapterFactoryEditingDomain editingDomain) {

		this.editingDomain = editingDomain;
	}

	@Override
	protected IResourceChangeListener getResourceChangeListener() {

		return this.resourceChangeListener;
	}

	@Override
	protected void setResourceChangeListener(IResourceChangeListener resourceChangeListener) {

		this.resourceChangeListener = resourceChangeListener;
	}
}
