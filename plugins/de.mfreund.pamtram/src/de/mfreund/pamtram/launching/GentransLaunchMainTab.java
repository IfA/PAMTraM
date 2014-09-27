package de.mfreund.pamtram.launching;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class GentransLaunchMainTab extends AbstractLaunchConfigurationTab {

	// the list of projects in the current workspace
	final private IProject[] projects = 
			ResourcesPlugin.getWorkspace().getRoot().getProjects();

	// combo boxes to select the project, the source file, the pamtram file and the
	// target file
	private Combo projectCombo, srcFileCombo, pamtramFileCombo, targetFileCombo;
	private Spinner pathLengthSpinner;

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
			projectCombo.add(project.getLocation().toOSString());
		}
		
		// if a project is selected populate the source, pamtram and target file lists
		projectCombo.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				String projectPath = ((Combo)e.widget).getText();
				
				// reset the source and pamtram file combo
				srcFileCombo.setItems(new String[]{});
				pamtramFileCombo.setItems(new String[]{});
				targetFileCombo.setItems(new String[]{});
				
				// check if a valid project has been selected
				if(projectPath.equals("") || projectCombo.indexOf(projectPath) == -1) {
					srcFileCombo.setEnabled(false);
					pamtramFileCombo.setEnabled(false);
					targetFileCombo.setEnabled(false);
					return;
				}
				
				// update the source file combo
				for(File f : new File(projectPath + Path.SEPARATOR + "Source").listFiles()) {
					if(f.getName().endsWith(".xmi") || f.getName().endsWith(".xml")) {
						srcFileCombo.add(f.getName());
					}
				}
				srcFileCombo.select(0);
				srcFileCombo.setEnabled(true);
				// update the pamtram file combo
				for(File f : new File(projectPath + Path.SEPARATOR + "Pamtram").listFiles()) {
					if(f.getName().endsWith(".pamtram")) {
						pamtramFileCombo.add(f.getName());
					}
				}
				pamtramFileCombo.select(0);
				pamtramFileCombo.setEnabled(true);
				// update the target file combo
				targetFileCombo.add("out.xmi");
				for(File f : new File(projectPath + Path.SEPARATOR + "Target").listFiles()) {
					if(f.getName().endsWith(".xmi")) {
						targetFileCombo.add(f.getName());
					}
				}
				targetFileCombo.select(0);
				targetFileCombo.setEnabled(true);
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
			
			GridLayout gl = new GridLayout(2, false);
			fileGroup.setLayout(gl);
		}

		// create a label for the source file selection
		Label srcFileLabel = new Label(fileGroup, SWT.NONE);
		srcFileLabel.setText("Source File:");
		
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
		
		// create a label for the pamtram file selection
		Label pamtramFileLabel = new Label(fileGroup, SWT.NONE);
		pamtramFileLabel.setText("Pamtram File:");
		
		// create drop-down list for the pamtram file selection (based on the project)
		pamtramFileCombo = new Combo(fileGroup, SWT.DROP_DOWN | SWT.BORDER);
		pamtramFileCombo.setEnabled(false);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.grabExcessHorizontalSpace = true;
			pamtramFileCombo.setLayoutData(gd);
		}
		pamtramFileCombo.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		
		// create a label for the target file
		Label targetFileLabel = new Label(fileGroup, SWT.NONE);
		targetFileLabel.setText("Target File:");
		
		// create drop-down list for the target file selection (based on the project)
		targetFileCombo = new Combo(fileGroup, SWT.DROP_DOWN | SWT.BORDER);
		targetFileCombo.setEnabled(false);
		{
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
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
			
			GridLayout gl = new GridLayout(3, false);
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
			srcFileCombo.setText(configuration.getAttribute("srcFile", ""));
			pamtramFileCombo.setText(configuration.getAttribute("pamtramFile", ""));
			targetFileCombo.setText(configuration.getAttribute("targetFile", ""));
			//settings
			pathLengthSpinner.setSelection(configuration.getAttribute("maxPathLength", -1));
			
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// store the project
		configuration.setAttribute("project", projectCombo.getText());
		// store the files
		configuration.setAttribute("srcFile", srcFileCombo.getText());
		configuration.setAttribute("pamtramFile", pamtramFileCombo.getText());
		configuration.setAttribute("targetFile", targetFileCombo.getText());
		//settings
		configuration.setAttribute("maxPathLength", pathLengthSpinner.getSelection());
	}

	@Override
	public String getName() {
		return "Main";
	}

	public boolean isValid(ILaunchConfiguration launchConfig) {
	    setErrorMessage(null);
	    if(!isProjectComboValid()) {
	    	setErrorMessage("Select a valid project directory");
	    	return false;
	    }
	    if(!isSrcFileComboValid()) {
	    	setErrorMessage("Select a valid source file");
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
		return (new File(projectCombo.getText())).exists();
	}
	
	// check if the selected source file is valid
	private boolean isSrcFileComboValid() {
		return (new File(projectCombo.getText() + Path.SEPARATOR + 
							"Source" + Path.SEPARATOR + srcFileCombo.getText())).exists() && 
						(srcFileCombo.getText().endsWith(".xmi") || srcFileCombo.getText().endsWith(".xml"));
	}
	
	// check if the selected pamtram file is valid
	private boolean isPamtramFileComboValid() {
		return (new File(projectCombo.getText() + Path.SEPARATOR + 
							"Pamtram" + Path.SEPARATOR + pamtramFileCombo.getText())).exists()  && 
						pamtramFileCombo.getText().endsWith(".pamtram");
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
			workingCopy.setAttribute("project", 
					project.getLocation().toOSString());
			
			// set the srcFile attribute
			if(srcFile == null) {
				for(IResource res : project.getFolder("Source").members()) {
					// search for a suitable src file
					if(res instanceof IFile && ((IFile) res).getName().endsWith(".xmi")) {
						srcFile = (IFile) res;
						workingCopy.setAttribute("srcFile", srcFile.getName());
						break;
					}
				}
			} else {
				workingCopy.setAttribute("srcFile", srcFile.getName());
			}
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
			workingCopy.setAttribute("directPathsOnly", false);
			
		} else {
			return;
		}
			
	}
}
