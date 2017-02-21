package de.mfreund.gentrans.ui.launching;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab2;
import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.databinding.swt.ISWTObservableList;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.SWTResourceManager;

import de.mfreund.gentrans.launching.GentransLaunchingDelegate;
import de.mfreund.pamtram.properties.PropertySupplier;
import de.tud.et.ifa.agtele.ui.listeners.KeyPressedListener;
import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;
import de.tud.et.ifa.agtele.ui.util.UIHelper;

/**
 * An {@link ILaunchConfigurationTab2} that allows to customize the GenLibrary-related settings to be applied during a
 * GenTrans transformation.
 *
 * @author mfreund
 */
public class GentransLaunchLibraryTab extends AbstractLaunchConfigurationTab {

	/**
	 * The domain model that this tab operates on.
	 */
	private GentransLaunchContext context;

	/**
	 * The {@link DataBindingContext} that is used to realize all data bindings among widgets and between widgets and
	 * the {@link #context}.
	 */
	private DataBindingContext bindingContext;

	/**
	 * The {@link FileFieldEditor} that allows the user to select new library locations.
	 */
	private DirectoryFieldEditor libraryPathSelector;

	/**
	 * This displays all selected library paths to the user.
	 */
	private List libraryPathList;

	/**
	 * This creates an instance.
	 *
	 * @param context
	 *            The {@link GentransLaunchContext} that shall be used for data bindings to the various widgets.
	 */
	public GentransLaunchLibraryTab(GentransLaunchContext context) {
		this.context = context;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {

		// a composite to host all other controls
		//
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setFont(parent.getFont());
		this.setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(this.getControl(), this.getHelpContextId());
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(comp);

		// a group to confiure all libraries that are to be used
		//
		Group libraryPathsGroup = new Group(comp, SWT.NONE);
		libraryPathsGroup.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		libraryPathsGroup.setText("Library Location(s)");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1)
				.applyTo(libraryPathsGroup);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(libraryPathsGroup);

		Composite directoryEditorComposite = new Composite(libraryPathsGroup, SWT.NONE);
		directoryEditorComposite.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(3, 1)
				.applyTo(directoryEditorComposite);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(directoryEditorComposite);

		// create drop-down list for the source file selection (based on the project)
		//
		this.libraryPathSelector = new DirectoryFieldEditor("libraryPathSelect", "Add Library Location:",
				directoryEditorComposite);
		this.libraryPathSelector.setPropertyChangeListener(e -> this.handleAddLibrarySelected());

		// a composite to display the selected source files as well as buttons to add/remove/reorder files
		//
		ScrolledComposite scrolledComposite = new ScrolledComposite(libraryPathsGroup, SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 3).applyTo(scrolledComposite);

		// a list to display the selected source files
		//
		this.libraryPathList = new List(scrolledComposite, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		this.libraryPathList.addKeyListener((KeyPressedListener) e -> {
			if (e.keyCode == SWT.DEL && this.libraryPathList.getSelectionIndex() != -1) {

				this.handleDelLibraryButtonPressed();
			}
		});
		scrolledComposite.setContent(this.libraryPathList);
		scrolledComposite.setMinSize(this.libraryPathList.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		// a button that allows to delete elements from the 'sourceFileList'
		//
		Button delSourceFileButton = new Button(libraryPathsGroup, SWT.NONE);
		delSourceFileButton.setText("Del...");
		delSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleDelLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(delSourceFileButton);

		// a button that allows to move elements up in the 'sourceFileList'
		//
		Button upSourceFileButton = new Button(libraryPathsGroup, SWT.NONE);
		upSourceFileButton.setText("Up...");
		upSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleUpLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(upSourceFileButton);

		// a button that allows to move elements down in the 'sourceFileList'
		//
		Button downSourceFileButton = new Button(libraryPathsGroup, SWT.NONE);
		downSourceFileButton.setText("Down...");
		downSourceFileButton.addSelectionListener((SelectionListener2) e -> this.handleDownLibraryButtonPressed());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).applyTo(downSourceFileButton);

		// After we have created all widgets, we can initialize the data bindings among the widgets and between widgets
		// and the context
		//
		this.initDataBindings();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		ISelection sel = UIHelper.getCurrentSelection();

		// nothing can be done if the user did not select anything
		if (sel.isEmpty() || !(sel instanceof TreeSelection)) {
			return;
		}

		try {
			// initialize the launch configuration
			this.initLaunchConfiguration(configuration, (TreeSelection) sel);
		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {

		try {
			// set the library paths
			this.libraryPathList.setItems(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_LIB_PATHS, new ArrayList<>())
							.toArray(new String[] {}));
		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
		}

		this.bindingContext.updateModels();
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

		// set the target lib path
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_LIB_PATHS,
				Arrays.asList(this.libraryPathList.getItems()));
	}

	@Override
	public String getName() {

		return "Library";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {

		this.setErrorMessage(null);
		this.setWarningMessage(null);

		// validate the specified library paths
		//
		java.util.List<String> libraryPaths = Arrays.asList(this.libraryPathList.getItems());

		if (libraryPaths.isEmpty()) {
			// do nothing as this is not necessary if no library entries are used
			return true;
		}

		for (String libraryPath : libraryPaths) {

			if (!new File(libraryPath).exists()) {
				this.setErrorMessage("Library path '" + libraryPath + "' does not exist!");
				return false;
			} else if (!new File(libraryPath).isDirectory()) {
				this.setErrorMessage("Library path '" + libraryPath + "' does not represent a folder!");
				return false;
			}
		}

		return true;
	}

	/**
	 * Initializes the values of a launch configuration based on the current selection
	 *
	 * @param workingCopy
	 *            a launch configuration to be initialized
	 * @param selection
	 *            the current selection
	 */
	private void initLaunchConfiguration(ILaunchConfigurationWorkingCopy workingCopy, TreeSelection selection)
			throws CoreException {

		// the selected element
		Object el = selection.getFirstElement();

		IProject project;

		// determine the project based on the selection
		if (el instanceof IProject) {
			project = (IProject) el;
		} else if (el instanceof IFile) {
			project = ((IFile) el).getProject();
		} else {
			return;
		}

		// check if the project has the pamtram nature assigned
		if (project.hasNature("de.mfreund.pamtram.pamtramNature")) {

			// set the library paths
			String concatenatedLibPaths = PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_PATHS,
					project);
			java.util.List<String> libPathList = concatenatedLibPaths.isEmpty() ? new ArrayList<>()
					: Arrays.asList(concatenatedLibPaths.split(";"));
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_LIB_PATHS, libPathList);

		} else {
			return;
		}

	}

	/**
	 * Initialize all {@link Binding data bindings} between the various widgets displayed on this tab and the
	 * {@link #context} as well as among widgets.
	 *
	 */
	@SuppressWarnings("unchecked")
	protected void initDataBindings() {

		// The context where all bindings will be registered
		//
		this.bindingContext = new DataBindingContext();

		// The various observable values for widget properties
		//
		ISWTObservableList observeTextTargetPathTextObserveWidget = WidgetProperties.items()
				.observe(this.libraryPathList);

		// The various observable values for bean properties
		//
		IObservableList<String> targetLibraryPathContextObserveValue = BeanProperties
				.list(GentransLaunchContext.PROPERTY_NAME_LIBRARY_PATHS).observe(this.context);

		// Enable the bindings between widgets and the context
		//
		this.bindingContext.bindList(observeTextTargetPathTextObserveWidget, targetLibraryPathContextObserveValue, null,
				null);
	}

	/**
	 * Add the file specified in the {@link #libraryPathSelector} to the {@link #libraryPathList}.
	 */
	private void handleAddLibrarySelected() {

		if (this.libraryPathSelector.getStringValue().isEmpty()) {
			this.updateLaunchConfigurationDialog();
			return;
		}

		this.libraryPathList.add(this.libraryPathSelector.getStringValue());
		this.libraryPathList.deselectAll();
		this.libraryPathList.select(this.libraryPathList.getItemCount() - 1);
		this.libraryPathSelector.setStringValue(null);
		this.updateLaunchConfigurationDialog();
	}

	/**
	 * Delete all elements that are selected in the {@link #libraryPathList}.
	 */
	private void handleDelLibraryButtonPressed() {

		int selected = this.libraryPathList.getSelectionIndex();
		this.libraryPathList.remove(this.libraryPathList.getSelectionIndices());
		this.libraryPathList.select(selected > this.libraryPathList.getItemCount() - 1
				? this.libraryPathList.getItemCount() - 1 : selected);
		this.updateLaunchConfigurationDialog();
	}

	/**
	 * Move all elements that are selected in the {@link #libraryPathList} up.
	 */
	private void handleUpLibraryButtonPressed() {

		for (int selected : this.libraryPathList.getSelectionIndices()) {
			if (selected == 0) {
				return;
			}
			String[] items = this.libraryPathList.getItems();
			String prevItem = this.libraryPathList.getItem(selected - 1);
			items[selected - 1] = this.libraryPathList.getItem(selected);
			items[selected] = prevItem;
			int[] currentSel = this.libraryPathList.getSelectionIndices();
			this.libraryPathList.setItems(items);
			this.libraryPathList.select(currentSel);
			this.libraryPathList.deselect(selected);
			this.libraryPathList.select(selected - 1);
		}

		this.updateLaunchConfigurationDialog();
	}

	/**
	 * Move all elements that are selected in the {@link #libraryPathList} down.
	 */
	private void handleDownLibraryButtonPressed() {

		int[] selections = this.libraryPathList.getSelectionIndices();
		for (int i = selections.length - 1; i >= 0; i--) {
			int sel = selections[i];
			if (sel == this.libraryPathList.getItemCount() - 1) {
				return;
			}
			String[] items = this.libraryPathList.getItems();
			String nextItem = this.libraryPathList.getItem(sel + 1);
			items[sel + 1] = this.libraryPathList.getItem(sel);
			items[sel] = nextItem;
			int[] currentSel = this.libraryPathList.getSelectionIndices();
			this.libraryPathList.setItems(items);
			this.libraryPathList.select(currentSel);
			this.libraryPathList.deselect(sel);
			this.libraryPathList.select(sel + 1);
		}

		this.updateLaunchConfigurationDialog();
	}

}
