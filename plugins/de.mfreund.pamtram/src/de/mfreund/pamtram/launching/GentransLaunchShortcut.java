package de.mfreund.pamtram.launching;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
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
				ILaunchConfigurationWorkingCopy workingCopy = 
						type.newInstance(null, res.getName());
				GentransLaunchConfigInitializer.init(workingCopy, selection);
				configToLaunch = workingCopy;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    
		} else {
			configToLaunch = launchConfigs[0];
		}
		
		try {
			if(configToLaunch != null) {
				ILaunch launch = configToLaunch.launch(mode, null);				
				launchManager.addLaunch(launch);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		return;
	}

	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		IResource res = getLaunchableResource(selection);
		if(res == null || !(res instanceof IProject)) {
			return new ILaunchConfiguration[]{};
		}
		
		IProject project = (IProject) res;
		ArrayList<ILaunchConfiguration> launchConfigs = 
				new ArrayList<ILaunchConfiguration>();
		
		// retrieve the launch configs from the launch manager
		try {
		    ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		    ILaunchConfigurationType type = launchManager
		    		.getLaunchConfigurationType("de.mfreund.pamtram.launching.gentrans");
		    ILaunchConfiguration[] launchConfigurations = 
		    		launchManager.getLaunchConfigurations(type);
		    for (ILaunchConfiguration launchConfiguration : launchConfigurations) {
		    	String projectPath =
		    			launchConfiguration.getAttribute("project", "");
		    	if (projectPath.equals(project.getLocation().toOSString())) {
		    		launchConfigs.add(launchConfiguration);
		    	}
		    }
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		ILaunchConfiguration[] configArray = 
				new ILaunchConfiguration[launchConfigs.size()];
		for(int i=0; i<launchConfigs.size(); i++) {
			configArray[i] = launchConfigs.get(i);
		}
		return configArray;
	}

	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {
		return null;
	}

	@Override
	public IResource getLaunchableResource(ISelection selection) {
		
		if(!selection.isEmpty() && selection instanceof TreeSelection) {
			Object el = ((TreeSelection) selection).getFirstElement();
			if(el instanceof IProject) {
				return (IProject) el;
			} else if(el instanceof IFile) {
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
		return null;
	}

	@Override
	public IResource getLaunchableResource(IEditorPart editorpart) {
		return null;
	}
	
}
