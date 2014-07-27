package de.mfreund.pamtram.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;

public abstract class GentransLaunchConfigInitializer {

	public static void init(
			ILaunchConfigurationWorkingCopy workingCopy, ISelection selection) throws CoreException {
		
		// handle a selection in a tree viewer
		if(selection instanceof TreeSelection) {
			TreeSelection treeSel = (TreeSelection) selection;
			Object el = treeSel.getFirstElement();
			
			IProject project;
			IFile srcFile = null, pamtramFile = null;
			
			// determine the project based on the selection
			if(el instanceof IProject) {
				project = (IProject) el; 
			} else if(el instanceof IFile) {
				project = ((IFile) el).getProject();
				IFile file = (IFile) el;
				// check if the file can be used as source file...
				if(file.getName().endsWith(".xmi") && 
						file.getParent().getName().equals("Source")) {
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
				
			} else {
				return;
			}
				
		}
	}
}
