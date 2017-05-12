package de.mfreund.gentrans.ui.launching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab2;
import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.SWTResourceManager;

import de.mfreund.gentrans.launching.GentransLaunchingDelegate;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import de.tud.et.ifa.agtele.ui.widgets.ManageableItemList;
import pamtram.provider.PamtramEditPlugin;

/**
 * An {@link ILaunchConfigurationTab2} that allows to customize the main
 * settings to be applied during a GenTrans transformation.
 *
 * @author mfreund
 */
public class GentransLaunchMainTab extends AbstractLaunchConfigurationTab {

	/**
	 * The name of the folder in the PAMTraM project where the source files are
	 * located.
	 */
	private static final String SOURCE_FOLDER = PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME");

	/**
	 * The name of the folder in the PAMTraM project where the PAMTraM files are
	 * located.
	 */
	private static final String PAMTRAM_FOLDER = PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME");

	/**
	 * The name of the folder in the PAMTraM project where the target files are
	 * located.
	 */
	private static final String TARGET_FOLDER = PamtramEditPlugin.INSTANCE.getString("TARGET_FOLDER_NAME");

	/**
	 * The font to be used across the tab.
	 */
	private static final String FONT = "Segoe UI";

	/**
	 * The domain model that this tab operates on and that is used to realize
	 * all data bindings to the various widgets.
	 */
	private GentransLaunchContext context;

	/**
	 * The workspace root
	 */
	private final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

	/**
	 * The list of projects in the current workspace.
	 */
	private final IProject[] projects;

	/**
	 * The combo box to select the project
	 */
	private Combo projectCombo;

	/**
	 * The combo box to select the target file
	 */
	private Combo targetFileCombo;

	/**
	 * The combo box to select the log level
	 */
	private Combo logLevelCombo;

	/**
	 * The spinner to set max path length
	 */
	private Spinner pathLengthSpinner;

	/**
	 * The check box for setting whether the user should be asked only once
	 * which mapping to use
	 */
	private Button onlyAskOnceForAmbiguousMappings;

	/**
	 * This CheckBox controls whether a TransformationModel representing the
	 * results of the transformation shall be created at the end of every
	 * executed transformation.
	 */
	private Button createTransformationModel;

	/**
	 * This CheckBox controls whether extended parallelization is used during
	 * the transformation that might lead to the fact that the transformation
	 * result (especially the order of lists) varies between executions.
	 */
	private Button useParallelization;

	/**
	 * A {@link ManageableItemList} that allows the user to manage the source
	 * files used for the transformation.
	 */
	private ManageableItemList srcList;

	/**
	 * A {@link ManageableItemList} that allows the user to manage the pamtram
	 * files used for the transformation.
	 */
	private ManageableItemList pamtramList;

	/**
	 * This creates an instance.
	 *
	 * @param context
	 *            The {@link GentransLaunchContext} that shall be used for data
	 *            bindings to the various widgets.
	 */
	public GentransLaunchMainTab(GentransLaunchContext context) {
		this.context = context;
		this.projects = this.workspaceRoot.getProjects();
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

		// a group to host all project related settings
		//
		Group projectGroup = new Group(comp, SWT.NONE);
		projectGroup.setFont(SWTResourceManager.getFont(GentransLaunchMainTab.FONT, 9, SWT.BOLD));
		projectGroup.setText("Project");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(2, 1).applyTo(projectGroup);
		GridLayoutFactory.swtDefaults().applyTo(projectGroup);

		// create drop-down list for the project selection
		//
		this.projectCombo = new Combo(projectGroup, SWT.DROP_DOWN | SWT.BORDER);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(this.projectCombo);
		// populate the current projects in the workspace to the list
		for (IProject project : this.projects) {
			this.projectCombo.add(project.getName());
		}

		// if a project is selected populate the source, pamtram and target file
		// lists
		//
		this.projectCombo.addModifyListener(e -> this.updateFileLists(this.projectCombo.getText()));

		// a group to host all file related settings
		//
		Group fileGroup = new Group(comp, SWT.NONE);
		fileGroup.setFont(SWTResourceManager.getFont(GentransLaunchMainTab.FONT, 9, SWT.BOLD));
		fileGroup.setText("Files");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(2, 1).applyTo(fileGroup);
		GridLayoutFactory.swtDefaults().numColumns(3).applyTo(fileGroup);

		// The widget that allows to manage the source files used for the
		// transformation
		//
		this.srcList = new ManageableItemList(fileGroup, SWT.NONE, "Source File(s):");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).span(3, 1).applyTo(this.srcList);
		this.srcList.setEnabled(false);
		// Call 'updateLaunchConfigurationDialog' whenever changes are made to
		// the list
		this.srcList.addObserver(o -> GentransLaunchMainTab.this.updateLaunchConfigurationDialog());

		// just a separator
		//
		Label separator1 = new Label(fileGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(3, 1).applyTo(separator1);

		// The widget that allows to manage the source files used for the
		// transformation
		//
		this.pamtramList = new ManageableItemList(fileGroup, SWT.NONE, "Pamtram File(s):");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(3, 1)
				.applyTo(this.pamtramList);
		this.pamtramList.setEnabled(false);
		// Call 'updateLaunchConfigurationDialog' whenever changes are made to
		// the list
		this.pamtramList.addObserver(o -> GentransLaunchMainTab.this.updateLaunchConfigurationDialog());

		// just a separator
		//
		Label separator2 = new Label(fileGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).span(3, 1).applyTo(separator2);

		// create a label for the target file
		//
		Label targetFileLabel = new Label(fileGroup, SWT.NONE);
		targetFileLabel.setToolTipText(
				"If no distinct target models are specified via the 'path' attribute of TargetSections, "
						+ "this will be used as single target model.");
		targetFileLabel.setText("Default Target File:");

		// create drop-down list for the target file selection (based on the
		// project)
		//
		this.targetFileCombo = new Combo(fileGroup, SWT.DROP_DOWN | SWT.BORDER);
		this.targetFileCombo.setEnabled(false);
		this.targetFileCombo.addModifyListener(e -> GentransLaunchMainTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(2, 1)
				.applyTo(this.targetFileCombo);

		// a group for specific GenTrans settings
		//
		Group settingsGroup = new Group(comp, SWT.NONE);
		settingsGroup.setFont(SWTResourceManager.getFont(GentransLaunchMainTab.FONT, 9, SWT.BOLD));
		settingsGroup.setText("Settings");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(2, 1).applyTo(settingsGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(settingsGroup);

		// create a spinner for path setting
		//
		this.pathLengthSpinner = new Spinner(settingsGroup, SWT.BORDER);
		this.pathLengthSpinner.setMinimum(-1);
		this.pathLengthSpinner.setMaximum(Integer.MAX_VALUE);
		this.pathLengthSpinner.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				GentransLaunchMainTab.this.updateLaunchConfigurationDialog();
			}
		});
		GridDataFactory.swtDefaults().applyTo(this.pathLengthSpinner);

		// a label for the path length
		Label pathLengthLabel = new Label(settingsGroup, SWT.NONE);
		pathLengthLabel.setText("max. length for model connection paths (0 = direct connection only, -1 = unbounded)");
		GridDataFactory.swtDefaults().grab(true, false).applyTo(pathLengthLabel);

		// create check box for ambiguous mappings setting
		//
		this.onlyAskOnceForAmbiguousMappings = new Button(settingsGroup, SWT.CHECK);
		this.onlyAskOnceForAmbiguousMappings.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				GentransLaunchMainTab.this.updateLaunchConfigurationDialog();
			}
		});
		this.onlyAskOnceForAmbiguousMappings.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		this.onlyAskOnceForAmbiguousMappings.setText("Remember choices for ambiguous Mappings");

		// create a check box to customize whether a transformation model shall
		// be stored
		//
		this.createTransformationModel = new Button(settingsGroup, SWT.CHECK);
		this.createTransformationModel.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				GentransLaunchMainTab.this.updateLaunchConfigurationDialog();
			}
		});
		this.createTransformationModel.setToolTipText(
				"Whether a TransformationModel shall be created in the folder 'Pamtram/transformation' for every executed transformation. This trace model can be used for further reasoning about the executed transformation...");
		this.createTransformationModel.setText("Create transformation model");
		GridDataFactory.swtDefaults().span(2, 1).applyTo(this.createTransformationModel);

		// Create a combo box to select the log level
		//
		this.logLevelCombo = new Combo(settingsGroup, SWT.DROP_DOWN | SWT.BORDER);
		this.logLevelCombo.setEnabled(true);
		this.logLevelCombo.setLayoutData(new GridData());
		this.logLevelCombo.setItems("OFF", "SEVERE", "WARNING", "INFO", "ALL");
		this.logLevelCombo.select(3);
		this.logLevelCombo.addModifyListener(e -> GentransLaunchMainTab.this.updateLaunchConfigurationDialog());

		// a label for the log level
		Label logLevelLabel = new Label(settingsGroup, SWT.NONE);
		logLevelLabel.setText("Select the verbosity of the log.");
		GridDataFactory.swtDefaults().grab(true, false).applyTo(logLevelLabel);

		// create a check box to customize whether a transformation model shall
		// be stored
		//
		this.useParallelization = new Button(settingsGroup, SWT.CHECK);
		this.useParallelization.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				GentransLaunchMainTab.this.updateLaunchConfigurationDialog();
			}
		});
		this.useParallelization.setToolTipText(
				"Whether extended parallelization shall be used during the transformation. If checked, this will speed up the transformation. However, it might lead to the fact that the transformation result (especially the order of lists) varies between executions.");
		this.useParallelization.setText("Use extended parallelization");
		GridDataFactory.swtDefaults().span(2, 1).applyTo(this.useParallelization);

		// After we have created all widgets, we can initialize the data
		// bindings among the widgets and between widgets
		// and the context
		//
		this.initDataBindings();

	}

	/**
	 * Based on a given <em>projectName</em> that represents the project
	 * selected by the user in the {@link #projectCombo}, update the list of
	 * available source, pamtram, and target files.
	 *
	 * @param projectName
	 */
	private void updateFileLists(String projectName) {

		// save the selected values in the other combo boxes
		//
		String oldSrcFile = this.srcList.getComboText();
		String oldPamtramFile = this.pamtramList.getComboText();
		String oldTargetFile = this.targetFileCombo.getText();

		// reset the source and pamtram file combo
		//
		this.srcList.setSelectableItems(new ArrayList<>());
		this.pamtramList.setSelectableItems(new ArrayList<>());
		this.targetFileCombo.setItems(new String[] {});

		// check if a valid project has been selected
		//
		if (projectName.isEmpty() || this.projectCombo.indexOf(projectName) == -1) {
			this.srcList.setEnabled(false);
			this.pamtramList.setEnabled(false);
			this.targetFileCombo.setEnabled(false);
			return;
		}

		// update the source file combo
		//
		try {
			for (IResource r1 : GentransLaunchMainTab.this.workspaceRoot.getProject(projectName)
					.getFolder(GentransLaunchMainTab.SOURCE_FOLDER).members()) {
				if (r1.getName().endsWith(".xmi") || r1.getName().endsWith(".xml")) {
					this.srcList.addSelectableItem(r1.getName());
				}
			}
			this.srcList.select(oldSrcFile);
			this.srcList.setEnabled(true);
		} catch (CoreException e11) {
			e11.printStackTrace();
		}

		// update the pamtram file combo
		try {
			for (IResource r2 : GentransLaunchMainTab.this.workspaceRoot.getProject(projectName)
					.getFolder(GentransLaunchMainTab.PAMTRAM_FOLDER).members()) {
				if (r2.getName().endsWith(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING"))) {
					this.pamtramList.addSelectableItem(r2.getName());
				}
			}
			this.pamtramList.select(oldPamtramFile);
			this.pamtramList.setEnabled(true);
		} catch (CoreException e12) {
			e12.printStackTrace();
		}

		// update the target file combo
		//
		GentransLaunchMainTab.this.targetFileCombo.add("out.xmi");
		try {
			for (IResource r3 : GentransLaunchMainTab.this.workspaceRoot.getProject(projectName)
					.getFolder(GentransLaunchMainTab.TARGET_FOLDER).members()) {
				if (r3.getName().endsWith(".xmi")) {
					GentransLaunchMainTab.this.targetFileCombo.add(r3.getName());
				}
			}
			int index3 = GentransLaunchMainTab.this.targetFileCombo.indexOf(oldTargetFile);
			GentransLaunchMainTab.this.targetFileCombo.select(index3 != -1 ? index3 : 0);
			GentransLaunchMainTab.this.targetFileCombo.setEnabled(true);
		} catch (CoreException e13) {
			e13.printStackTrace();
		}

		GentransLaunchMainTab.this.updateLaunchConfigurationDialog();
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

			// set the project
			this.projectCombo.setText(configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PROJECT, ""));

			// set the files
			this.srcList.setSelectedItems(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_SRC_FILES, new ArrayList<>()));
			this.pamtramList.setSelectedItems(configuration
					.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PAMTRAM_FILES, new ArrayList<>()));
			this.targetFileCombo
					.setText(configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_FILE, ""));

			// settings
			this.pathLengthSpinner.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_MAX_PATH_LENGTH, -1));
			this.onlyAskOnceForAmbiguousMappings.setSelection(configuration
					.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_REMEMBER_AMBIGUOUS_MAPPINGS_CHOICE, true));
			this.createTransformationModel.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_STORE_TRANSFORMATION, false));
			this.logLevelCombo.select(this.logLevelCombo
					.indexOf(configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_LOG_LEVEL, "INFO")));
			this.useParallelization.setSelection(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_USE_PARALLELIZATION, false));
		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

		// store the project
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PROJECT, this.projectCombo.getText());

		// store the files
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_SRC_FILES, this.srcList.getSelectedItems());
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PAMTRAM_FILES,
				this.pamtramList.getSelectedItems());
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_FILE,
				this.targetFileCombo.getText());

		// settings
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_MAX_PATH_LENGTH,
				this.pathLengthSpinner.getSelection());
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_REMEMBER_AMBIGUOUS_MAPPINGS_CHOICE,
				this.onlyAskOnceForAmbiguousMappings.getSelection());
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_STORE_TRANSFORMATION,
				this.createTransformationModel.getSelection());
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_LOG_LEVEL, this.logLevelCombo.getText());
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_USE_PARALLELIZATION,
				this.useParallelization.getSelection());

	}

	@Override
	public String getName() {

		return "Main";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {

		this.setErrorMessage(null);

		if (!this.isProjectComboValid()) {
			this.setErrorMessage("Select a valid project directory");
			return false;
		}

		if (!this.isSrcFileListValid()) {
			this.setErrorMessage("Select one or multiple valid source files");
			return false;
		}

		if (!this.isPamtramFileComboValid()) {
			this.setErrorMessage("Select a valid Pamtram file");
			return false;
		}

		if (!this.isTargetFileComboValid()) {
			this.setErrorMessage("Specify a valid target file");
			return false;
		}

		if (!this.isLogLevelValid()) {
			this.setErrorMessage("Specify a valid log level");
			return false;
		}

		return true;
	}

	/**
	 * Check if the project specified in the {@link #projectCombo} exists.
	 *
	 * @return '<em><b>true</b></em>' if the setting is valid;
	 *         '<em><b>false</b></em>' otherwise.
	 */
	private boolean isProjectComboValid() {

		// check if the selected project exists
		try {
			return this.workspaceRoot.getProject(this.projectCombo.getText()).exists();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check if the source files specified in the {@link #sourceFileList} exist.
	 *
	 * @return '<em><b>true</b></em>' if the settings are valid;
	 *         '<em><b>false</b></em>' otherwise.
	 */
	private boolean isSrcFileListValid() {

		if (this.srcList.getSelectedItems().isEmpty()) {
			return false;
		}
		for (String sourceFile : this.srcList.getSelectedItems()) {
			if (!(this.workspaceRoot.getProject(this.projectCombo.getText())
					.getFolder(GentransLaunchMainTab.SOURCE_FOLDER).getFile(sourceFile).exists()
					&& (sourceFile.endsWith(".xmi") || sourceFile.endsWith(".xml")))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if the pamtram file specified in the {@link #pamtramFileCombo}
	 * exists.
	 *
	 * @return '<em><b>true</b></em>' if the setting is valid;
	 *         '<em><b>false</b></em>' otherwise.
	 */
	private boolean isPamtramFileComboValid() {

		if (this.pamtramList.getSelectedItems().isEmpty()) {
			return false;
		}
		for (String pamtramFile : this.pamtramList.getSelectedItems()) {
			if (!(this.workspaceRoot.getProject(this.projectCombo.getText())
					.getFolder(GentransLaunchMainTab.PAMTRAM_FOLDER).getFile(pamtramFile).exists()
					&& pamtramFile.endsWith(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING")))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if the target specified in the {@link #targetFileCombo} is valid.
	 *
	 * @return '<em><b>true</b></em>' if the setting is valid;
	 *         '<em><b>false</b></em>' otherwise.
	 */
	private boolean isTargetFileComboValid() {

		return this.targetFileCombo.getText().endsWith(".xmi");
	}

	/**
	 * Check if the specified {@link #logLevelCombo Log Level} is valid.
	 *
	 * @return '<em><b>true</b></em>' if the setting is valid;
	 *         '<em><b>false</b></em>' otherwise.
	 */
	private boolean isLogLevelValid() {

		return Stream.of("ALL", "INFO", "WARNING", "SEVERE", "OFF")
				.anyMatch(l -> l.equals(this.logLevelCombo.getText()));
	}

	/**
	 * Initializes the values of a launch configuration based on the current
	 * selection
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
		IFile srcFile = null;
		IFile pamtramFile = null;

		// determine the project based on the selection
		if (el instanceof IProject) {
			project = (IProject) el;
		} else if (el instanceof IFile) {
			project = ((IFile) el).getProject();
			IFile file = (IFile) el;
			// check if the file can be used as source file...
			if (file.getParent().getName().equals(GentransLaunchMainTab.SOURCE_FOLDER)
					&& (file.getName().endsWith(".xmi") || file.getName().endsWith(".xml"))) {
				srcFile = file;
				// ... or as pamtram file
			} else if (file.getName().endsWith(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING"))
					&& file.getParent().getName().equals(GentransLaunchMainTab.PAMTRAM_FOLDER)) {
				pamtramFile = file;
			}
		} else {
			return;
		}

		// check if the project has the pamtram nature assigned
		if (project.hasNature("de.mfreund.pamtram.pamtramNature")) {
			// set the project attribute
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PROJECT, project.getName());

			// set the srcFile attribute
			if (srcFile == null) {
				for (IResource res : project.getFolder(GentransLaunchMainTab.SOURCE_FOLDER).members()) {
					// search for a suitable src file
					if (res instanceof IFile
							&& (((IFile) res).getName().endsWith(".xmi") || ((IFile) res).getName().endsWith(".xml"))) {
						srcFile = (IFile) res;
						break;
					}
				}
			}
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_SRC_FILES,
					srcFile != null ? Arrays.asList(srcFile.getName()) : new ArrayList<>());

			// set the pamtramFile attribute
			if (pamtramFile == null) {
				for (IResource res : project.getFolder(GentransLaunchMainTab.PAMTRAM_FOLDER).members()) {
					// search for a suitable pamtram file
					if (res instanceof IFile && ((IFile) res).getName()
							.endsWith(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_MODEL_FILE_ENDING"))) {
						pamtramFile = (IFile) res;
						break;
					}
				}
			}
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PAMTRAM_FILES,
					pamtramFile != null ? Arrays.asList(pamtramFile.getName()) : new ArrayList<>());

			// set the targetFile attribute
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_FILE, "out.xmi");

			// set the direct paths only setting
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_MAX_PATH_LENGTH, -1);

			// set the ambiguous Mappings choice
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_REMEMBER_AMBIGUOUS_MAPPINGS_CHOICE, true);

			// set whether a TransformationModel shall be created
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_STORE_TRANSFORMATION, false);

			// set the log level
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_LOG_LEVEL, "INFO");

			// set whether parallelization shall be used
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_USE_PARALLELIZATION, false);

		} else {
			return;
		}

	}

	/**
	 * Initialize all {@link Binding data bindings} between the various widgets
	 * displayed on this tab and the {@link #context} as well as among widgets.
	 *
	 */
	@SuppressWarnings("unchecked")
	protected DataBindingContext initDataBindings() {

		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue<String> observeTextProjectComboObserveWidget = WidgetProperties.text()
				.observe(this.projectCombo);
		IObservableValue<String> projectContextObserveValue = PojoProperties.value("project").observe(this.context);
		bindingContext.bindValue(observeTextProjectComboObserveWidget, projectContextObserveValue, null, null);
		//
		return bindingContext;
	}
}
