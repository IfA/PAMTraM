package de.mfreund.pamtram.launching;

import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

public class GentransLaunchShortcut implements ILaunchShortcut2 {

	@Override
	public void launch(ISelection selection, String mode) {

		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = launchManager
				.getLaunchConfigurationType("de.mfreund.pamtram.launching.gentrans");
		
		// get the existing launch configurations for the current selection
		ILaunchConfiguration[] launchConfigs =
				getLaunchConfigurations(selection);
		
		ILaunchConfiguration configToLaunch = null;
		if(launchConfigs.length == 0) {
			// if no launch config has been found, create a new one
			try {
				IResource res = getLaunchableResource(selection);
				if(res == null) {
					MessageDialog.openError(new Shell(), 
							"Error", "No launchable resource found!");
					return;
				}
				ILaunchConfigurationWorkingCopy workingCopy = 
						type.newInstance(null, res.getName());
				
				// set default for common settings
				CommonTab tab = new CommonTab();
				tab.setDefaults(workingCopy);
				tab.dispose();
				
				// set default for gentrans main settings
				GentransLaunchMainTab mainTab = new GentransLaunchMainTab();
				mainTab.setDefaults(workingCopy);
				mainTab.dispose();
				
				// save the working copy
				configToLaunch = workingCopy.doSave();
			
			} catch (CoreException e) {
				MessageDialog.openError(new Shell(), "Error", e.getMessage());
				return;
			}
			    
		} else {
			// use the first available launch configuration
			// TODO let the user choose
			configToLaunch = launchConfigs[0];
		}
		
		try {

			// launch the configuration
			configToLaunch.launch(mode, null);
			
		} catch (CoreException e) {
			MessageDialog.openError(new Shell(), "Error", e.getMessage());
			return;
		}
		
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		return;
	}

	/**
	 * Retrieve the existing launch configurations that are available for the
	 * current selection.
	 * 
	 * @param selection the current selection
	 * @return a list of launch configurations for the current selection
	 */
	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		
		IResource res = getLaunchableResource(selection);
		// if no launchable project could be determined, return
		// an empty list of launch configurations
		if(res == null || !(res instanceof IProject)) {
			return new ILaunchConfiguration[]{};
		}
		
		IProject project = (IProject) res;
		ArrayList<ILaunchConfiguration> launchConfigs = 
				new ArrayList<ILaunchConfiguration>();
		
		try {
		    
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		    ILaunchConfigurationType type = launchManager
		    		.getLaunchConfigurationType("de.mfreund.pamtram.launching.gentrans");

		    // retrieve the launch configurations from the launch manager
		    ILaunchConfiguration[] launchConfigurations = 
		    		launchManager.getLaunchConfigurations(type);
		    
		    for (ILaunchConfiguration launchConfiguration : launchConfigurations) {
		    	// the launch configuration is applicable if the project
		    	// attribute matches the launchable resource
		    	if (launchConfiguration.getAttribute("project", "").equals(project.getLocation().toOSString())) {
		    		launchConfigs.add(launchConfiguration);
		    	}
		    }
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		// return the matching launch configurations
		return launchConfigs.toArray(new ILaunchConfiguration[launchConfigs.size()]);
	}

	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {
		return null;
	}

	@Override
	public IResource getLaunchableResource(ISelection selection) {
		
		if(!selection.isEmpty() && selection instanceof TreeSelection) {
			
			// the selected object
			Object el = ((TreeSelection) selection).getFirstElement();
			
			if(el instanceof IProject) {
				
				// if a project has been selected, return it
				return (IProject) el;
				
			} else if(el instanceof IFile) {
				
				// if a source or pamtram file has been selected, determine
				// the corresponding project and return it
				IFile file = (IFile) el;
				if(file.getName().endsWith(".xmi") && 
						file.getParent().getName().equals("Source")) {
					return file.getProject();
				} else if(file.getName().endsWith(".pamtram") && 
						file.getParent().getName().equals("Pamtram")) {
					return file.getProject();
				}
			}
		}
		
		// no launchable resource could be determined
		return null;
	}

	@Override
	public IResource getLaunchableResource(IEditorPart editorpart) {
		return null;
	}
	
}
