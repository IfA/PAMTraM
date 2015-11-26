package de.mfreund.gentrans.ui.launching;

import java.util.ArrayList;
import java.util.Arrays;

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
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.mfreund.pamtram.util.SelectionListener2;

public class GentransLaunchMainTab extends AbstractLaunchConfigurationTab {
	private DataBindingContext m_bindingContext;

	/**
	 * The domain model that this tab operates on.
	 */
	private GentransLaunchContext context;

	// the workspace root
	private final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

	// the list of projects in the current workspace
	final private IProject[] projects = 
			ResourcesPlugin.getWorkspace().getRoot().getProjects();

	// combo boxes to select the project, the source file, the pamtram file and the
	// target file
	private Combo projectCombo, srcFileCombo, pamtramFileCombo, targetFileCombo;

	//spinner to set max path length
	private Spinner pathLengthSpinner;

	//CheckBox for setting wether user should be askedd only once which mapping tdouse
	private Button onlyAskOnceForAmbiguousMappings;

	/**
	 * This CheckBox controls whether a TransformationModel representing the results of the transformation 
	 * shall be created at the end of every executed transformation.
	 */
	private Button createTransformationModel;

	public List sourceFileList;

	public GentransLaunchMainTab(GentransLaunchContext context) {
		this.context = context;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {

		// a composite to host all other controls
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), getHelpContextId());
		comp.setLayout(new GridLayout(2, true));
		comp.setFont(parent.getFont());

		// a group to host all project related settings
		Group projectGroup = new Group(comp, SWT.NONE);
		projectGroup.setText("Project");
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			projectGroup.setLayoutData(gd);

			GridLayout gl = new GridLayout(1, false);
			projectGroup.setLayout(gl);
		}

		// create drop-down list for the project selection
		projectCombo = new Combo(projectGroup, SWT.DROP_DOWN | SWT.BORDER);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.grabExcessHorizontalSpace = true;
			projectCombo.setLayoutData(gd);
		}

		// populate the current projects in the workspace to the list
		for(IProject project : projects) {
			projectCombo.add(project.getName());
		}

		// if a project is selected populate the source, pamtram and target file lists
		projectCombo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {

				String projectName = ((Combo)e.widget).getText();

				// save the selected values in the other combo boxes
				String oldSrcFile = srcFileCombo.getText();
				String oldPamtramFile = pamtramFileCombo.getText();
				String oldTargetFile = targetFileCombo.getText();

				// reset the source and pamtram file combo
				srcFileCombo.setItems(new String[]{});
				pamtramFileCombo.setItems(new String[]{});
				targetFileCombo.setItems(new String[]{});

				// check if a valid project has been selected
				if(projectName.equals("") || projectCombo.indexOf(projectName) == -1) {
					srcFileCombo.setEnabled(false);
					pamtramFileCombo.setEnabled(false);
					targetFileCombo.setEnabled(false);
					return;
				}

				// update the source file combo
				try {
					for(IResource r : workspaceRoot.getProject(projectName).getFolder("Source").members()) {
						if(r.getName().endsWith(".xmi") || r.getName().endsWith(".xml")) {
							srcFileCombo.add(r.getName());
						}
					}
					int index = srcFileCombo.indexOf(oldSrcFile);
					srcFileCombo.select((index != -1 ? index : 0));
					srcFileCombo.setEnabled(true);
				} catch (CoreException e1) {
					e1.printStackTrace();
				}
				// update the pamtram file combo
				try {
					for(IResource r : workspaceRoot.getProject(projectName).getFolder("Pamtram").members()) {
						if(r.getName().endsWith(".pamtram")) {
							pamtramFileCombo.add(r.getName());
						}
					}
					int index = pamtramFileCombo.indexOf(oldPamtramFile);
					pamtramFileCombo.select((index != -1 ? index : 0));
					pamtramFileCombo.setEnabled(true);
				} catch (CoreException e1) {
					e1.printStackTrace();
				}
				// update the target file combo
				targetFileCombo.add("out.xmi");
				try {
					for(IResource r : workspaceRoot.getProject(projectName).getFolder("Target").members()) {
						if(r.getName().endsWith(".xmi")) {
							targetFileCombo.add(r.getName());
						}
					}
					int index = targetFileCombo.indexOf(oldTargetFile);
					targetFileCombo.select((index != -1 ? index : 0));
					targetFileCombo.setEnabled(true);
				} catch (CoreException e1) {
					e1.printStackTrace();
				}
				updateLaunchConfigurationDialog();
			}
		});

		// a group to host all file related settings
		Group fileGroup = new Group(comp, SWT.NONE);
		fileGroup.setText("Files");
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			fileGroup.setLayoutData(gd);

			GridLayout gl = new GridLayout(3, false);
			fileGroup.setLayout(gl);
		}

		// create a label for the source file selection
		Label srcFileLabel = new Label(fileGroup, SWT.NONE);
		srcFileLabel.setText("Source File(s):");

		// create drop-down list for the source file selection (based on the project)
		srcFileCombo = new Combo(fileGroup, SWT.DROP_DOWN | SWT.BORDER);
		srcFileCombo.setEnabled(false);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.grabExcessHorizontalSpace = true;
			srcFileCombo.setLayoutData(gd);
		}
		srcFileCombo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		Button addSourceFileButton = new Button(fileGroup, SWT.NONE);
		addSourceFileButton.setText("Add...");
		addSourceFileButton.addSelectionListener(new SelectionListener2() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				sourceFileList.add(srcFileCombo.getText());
				updateLaunchConfigurationDialog();
			}
		});

		ScrolledComposite scrolledComposite = new ScrolledComposite(fileGroup, SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		sourceFileList = new List(scrolledComposite, SWT.BORDER);
		sourceFileList.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.DEL && sourceFileList.getSelectionIndex() != -1) {
					sourceFileList.remove(sourceFileList.getSelectionIndex());
					updateLaunchConfigurationDialog();
				}
			}
		});
		scrolledComposite.setContent(sourceFileList);
		scrolledComposite.setMinSize(sourceFileList.computeSize(SWT.DEFAULT, SWT.DEFAULT));


		Label separator1 = new Label(fileGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		// create a label for the pamtram file selection
		Label pamtramFileLabel = new Label(fileGroup, SWT.NONE);
		pamtramFileLabel.setText("Pamtram File:");

		// create drop-down list for the pamtram file selection (based on the project)
		pamtramFileCombo = new Combo(fileGroup, SWT.DROP_DOWN | SWT.BORDER);
		pamtramFileCombo.setEnabled(false);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			gd.grabExcessHorizontalSpace = true;
			pamtramFileCombo.setLayoutData(gd);
		}
		pamtramFileCombo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		Label separator2 = new Label(fileGroup, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		// create a label for the target file
		Label targetFileLabel = new Label(fileGroup, SWT.NONE);
		targetFileLabel.setText("Target File:");

		// create drop-down list for the target file selection (based on the project)
		targetFileCombo = new Combo(fileGroup, SWT.DROP_DOWN | SWT.BORDER);
		targetFileCombo.setEnabled(false);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			gd.grabExcessHorizontalSpace = true;
			targetFileCombo.setLayoutData(gd);
		}
		targetFileCombo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		// a group for specific GenTrans settings
		Group settingsGroup = new Group(comp, SWT.NONE);
		settingsGroup.setText("Settings");
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 2;
			settingsGroup.setLayoutData(gd);

			GridLayout gl = new GridLayout(2, false);
			settingsGroup.setLayout(gl);
		}

		// create a spinner for path setting
		pathLengthSpinner= new Spinner(settingsGroup, SWT.BORDER);
		pathLengthSpinner.setMinimum(-1);
		pathLengthSpinner.setMaximum(Integer.MAX_VALUE);
		pathLengthSpinner.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		Label pathLengthLabel=new Label(settingsGroup, SWT.NONE);
		pathLengthLabel.setText("max. length for model connection paths (0 = direct connection only, -1 = unbounded)");

		//create CHeckBox for ambiguous mappings setting
		onlyAskOnceForAmbiguousMappings=new Button(settingsGroup,SWT.CHECK);
		onlyAskOnceForAmbiguousMappings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		onlyAskOnceForAmbiguousMappings.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		onlyAskOnceForAmbiguousMappings.setText("Remember choices for ambiguous Mappings");

		createTransformationModel = new Button(settingsGroup, SWT.CHECK);
		createTransformationModel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		createTransformationModel.setToolTipText("Whether a TransformationModel shall be created in the folder 'Pamtram/transformation' for every executed transformation. This trace model can be used for further reasoning about the executed transformation...");
		createTransformationModel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		createTransformationModel.setText("Create transformation model");
		m_bindingContext = initDataBindings();

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		// get the current selection
		IWorkbench wb = PlatformUI.getWorkbench(); 
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		ISelection sel = win.getSelectionService().getSelection(); 

		// nothing can be done if the user did not select anything
		if(sel.isEmpty() || !(sel instanceof TreeSelection)) {
			return;
		}

		try {
			// initialize the launch configuration
			initLaunchConfiguration(configuration, (TreeSelection) sel);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			// set the project
			projectCombo.setText(configuration.getAttribute("project", ""));
			// set the files
			sourceFileList.removeAll();
			ArrayList<String> srcFiles = (ArrayList<String>) configuration.getAttribute("srcFiles", new ArrayList<>());
			for (String srcFile : srcFiles) {
				sourceFileList.add(srcFile);
			}
			pamtramFileCombo.setText(configuration.getAttribute("pamtramFile", ""));
			targetFileCombo.setText(configuration.getAttribute("targetFile", ""));
			//settings
			pathLengthSpinner.setSelection(configuration.getAttribute("maxPathLength", -1));
			onlyAskOnceForAmbiguousMappings.setSelection(configuration.getAttribute("rememberAmbiguousMappingChoice", true));
			createTransformationModel.setSelection(configuration.getAttribute("storeTransformation", false));
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// store the project
		configuration.setAttribute("project", projectCombo.getText());
		// store the files
		configuration.setAttribute("srcFiles", new ArrayList<>(Arrays.asList(sourceFileList.getItems())));
		configuration.setAttribute("pamtramFile", pamtramFileCombo.getText());
		configuration.setAttribute("targetFile", targetFileCombo.getText());
		//settings
		configuration.setAttribute("maxPathLength", pathLengthSpinner.getSelection());
		configuration.setAttribute("rememberAmbiguousMappingChoice", onlyAskOnceForAmbiguousMappings.getSelection());
		configuration.setAttribute("storeTransformation", createTransformationModel.getSelection());
	}

	@Override
	public String getName() {
		return "Main";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		if(!isProjectComboValid()) {
			setErrorMessage("Select a valid project directory");
			return false;
		}
		if(!isSrcFileListValid()) {
			setErrorMessage("Select one or multiple valid source files");
			return false;
		}
		if(!isPamtramFileComboValid()) {
			setErrorMessage("Select a valid Pamtram file");
			return false;
		}
		if(!isTargetFileComboValid()) {
			setErrorMessage("Specify a valid target file");
			return false;
		}
		return true;
	}

	private boolean isProjectComboValid() {
		// check if the selected project exists
		boolean ret = false;
		try{
			ret = workspaceRoot.getProject(projectCombo.getText()).exists();
		} catch(Exception e) {
			return false;
		}
		return ret;
	}

	// check if the selected source file is valid
	private boolean isSrcFileListValid() {
		for (String sourceFile : sourceFileList.getItems()) {
			if(!(workspaceRoot.getProject(projectCombo.getText()).getFolder("Source").getFile(sourceFile).exists() && 
					(sourceFile.endsWith(".xmi") || sourceFile.endsWith(".xml")))) {
				return false;
			}
		}
		return true;
	}

	// check if the selected pamtram file is valid
	private boolean isPamtramFileComboValid() {
		return (workspaceRoot.getProject(projectCombo.getText()).getFolder("Pamtram").getFile(pamtramFileCombo.getText()).exists() && 
				pamtramFileCombo.getText().endsWith(".pamtram"));
	}

	// check if the selected target file is valid
	private boolean isTargetFileComboValid() {
		return targetFileCombo.getText().endsWith(".xmi");
	}

	/** Initializes the values of a launch configuration based on the current selection
	 * 
	 * @param workingCopy a launch configuration to be initialized
	 * @param selection the current selection
	 */
	private void initLaunchConfiguration(ILaunchConfigurationWorkingCopy workingCopy, 
			TreeSelection selection) throws CoreException {

		// the selected element
		Object el = selection.getFirstElement();

		IProject project;
		IFile srcFile = null, pamtramFile = null;

		// determine the project based on the selection
		if(el instanceof IProject) {
			project = (IProject) el; 
		} else if(el instanceof IFile) {
			project = ((IFile) el).getProject();
			IFile file = (IFile) el;
			// check if the file can be used as source file...
			if(file.getParent().getName().equals("Source") &&
					(file.getName().endsWith(".xmi") || file.getName().endsWith(".xml"))) {
				srcFile = file;
				// ... or as pamtram file
			} else if(file.getName().endsWith(".pamtram") &&
					file.getParent().getName().equals("Pamtram")) {
				pamtramFile = file;
			}
		} else {
			return;
		}

		// check if the project has the pamtram nature assigned
		if(project.hasNature("de.mfreund.pamtram.pamtramNature")) {
			// set the project attribute
			workingCopy.setAttribute("project", project.getName());

			// set the srcFile attribute
			if(srcFile == null) {
				for(IResource res : project.getFolder("Source").members()) {
					// search for a suitable src file
					if(res instanceof IFile && ((IFile) res).getName().endsWith(".xmi")) {
						srcFile = (IFile) res;
						break;
					}
				}
			}
			ArrayList<String> srcFiles = new ArrayList<>();
			if(srcFile != null) {
				srcFiles.add(srcFile.getName());
			}
			workingCopy.setAttribute("srcFiles", srcFiles);

			// set the pamtramFile attribute
			if(pamtramFile == null) {
				for(IResource res : project.getFolder("Pamtram").members()) {
					// search for a suitable pamtram file
					if(res instanceof IFile && ((IFile) res).getName().endsWith(".pamtram")) {
						pamtramFile = (IFile) res;
						workingCopy.setAttribute("pamtramFile", pamtramFile.getName());
						break;
					}
				}
			} else {
				workingCopy.setAttribute("pamtramFile", pamtramFile.getName());
			}
			// set the targetFile attribute
			workingCopy.setAttribute("targetFile", "out.xmi");

			//set the direct paths only setting
			workingCopy.setAttribute("maxPathLength", -1);

			//set the ambiguous Mappings choice
			workingCopy.setAttribute("rememberAmbiguousMappingChoice", true);

			//set whether a TransformationModel shall be created
			workingCopy.setAttribute("storeTransformation", false);

		} else {
			return;
		}

	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextProjectComboObserveWidget = WidgetProperties.text().observe(projectCombo);
		IObservableValue projectContextObserveValue = PojoProperties.value("project").observe(context);
		bindingContext.bindValue(observeTextProjectComboObserveWidget, projectContextObserveValue, null, null);
		//
		return bindingContext;
	}
}
