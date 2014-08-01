package de.mfreund.pamtram.launching;

import java.io.File;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.mfreund.pamtram.util.ResourceHelper;

public class GentransLaunchingDelegate implements ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		// validate the launch configuration
		if(!validateLaunchConfig(configuration)) {
			return;
		}
		
		// get the associated files from the launch configuration
		String project = configuration.getAttribute("project", "");
		String sourceFile = project + Path.SEPARATOR +
				"Source" + Path.SEPARATOR + configuration.getAttribute("srcFile", "");
		String pamtramFile = project + Path.SEPARATOR + 
				"Pamtram" + Path.SEPARATOR + configuration.getAttribute("pamtramFile", "");
		String targetFile = project + Path.SEPARATOR + 
				"Target" + Path.SEPARATOR + configuration.getAttribute("targetFile", "");
		
		// Create a resource set. 
		ResourceSet rs = new ResourceSetImpl();
		
		// the selected resource (IMPORTANT: needs to be represented as absolute URI with "file://" scheme; 
		// if other schemes are used, the relative paths to the wprops and other model files are not set correct!)
		URI sourceUri = URI.createFileURI(new java.io.File(sourceFile).toString());

		Resource sourceResource = null;
		try {
			// load the source file
			sourceResource = rs.getResource(sourceUri, true);
			sourceResource.load(Collections.EMPTY_MAP);
		} catch(Exception e) {
			MessageDialog.openError(new Shell(), "Error loading resource", 
					e.getMessage());
			return;
		}
		
		// get the root object of the xml resource
		EObject root = sourceResource.getContents().get(0);
		final GenericTransformationRunner tr = 
				new GenericTransformationRunner(root, pamtramFile, targetFile);

		Job job = new Job("Gentrans"){

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try{
					// perform the transformation
					tr.runTransformation();
					return org.eclipse.core.runtime.Status.OK_STATUS;
					
				} catch (Exception e){
					e.printStackTrace(System.out);
					return org.eclipse.core.runtime.Status.CANCEL_STATUS;//TODO
				} finally {
					// refresh the project to see the results
					IProject projectResource = ResourcesPlugin.getWorkspace().getRoot().
			 			getProject((new File(project)).getName());
					ResourceHelper.refresh(projectResource);
				}

			}
			
		};
		
		job.setUser(true);
		job.schedule();
		
	}

	/** 
	 * Validates a launch configuration by check if all attributes
	 * have meaningful values.
	 * 
	 * @param configuration the launch configuration to validate
	 * @return true if the launch configuration is valid, false otherwise
	 */
	private boolean validateLaunchConfig(ILaunchConfiguration configuration) {
		try {
			if(configuration.getAttribute("project", "").equals("")) {
				MessageDialog.openError(new Shell(), "Error", 
						"No project has been specified!");
				return false;
			}
			
			if(configuration.getAttribute("srcFile", "").equals("")) {
				MessageDialog.openError(new Shell(), "Error", 
						"No source file has been specified!");
				return false;
			}
		
			if(configuration.getAttribute("pamtramFile", "").equals("")) {
				MessageDialog.openError(new Shell(), "Error", 
						"No pamtram file has been specified!");
				return false;
			}
			
			if(configuration.getAttribute("targetFile", "").equals("")) {
				MessageDialog.openError(new Shell(), "Error", 
						"No target file has been specified!");
				return false;
			}
		} catch (CoreException e) {
			MessageDialog.openError(new Shell(), "Error", 
					e.getMessage());
			return false;
		}
		return true;
	}

}
