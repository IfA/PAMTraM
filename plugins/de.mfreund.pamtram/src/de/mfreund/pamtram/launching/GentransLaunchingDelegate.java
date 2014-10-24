package de.mfreund.pamtram.launching;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.mfreund.gentrans.transformation.handler.GenericTransformationJob;
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
		final String project = configuration.getAttribute("project", "");
		String sourceFile = project + Path.SEPARATOR +
				"Source" + Path.SEPARATOR + configuration.getAttribute("srcFile", "");
		String pamtramFile = project + Path.SEPARATOR + 
				"Pamtram" + Path.SEPARATOR + configuration.getAttribute("pamtramFile", "");
		String targetFile = project + Path.SEPARATOR + 
				"Target" + Path.SEPARATOR + configuration.getAttribute("targetFile", "");
		
		//get the settings
		int maxPathLength=configuration.getAttribute("maxPathLength", -1);
		boolean rememberAmbiguousMappingChoice=configuration.getAttribute("rememberAmbiguousMappingChoice", true);
		
		// if an xml source file shall be transformed, 
		// add the file extension to registry 
		if(sourceFile.endsWith(".xml")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
				.put("xml", new GenericXMLResourceFactoryImpl());
		}
		
		GenericTransformationJob job = new GenericTransformationJob("GenTrans", sourceFile, pamtramFile, targetFile);
		job.getGenTransRunner().setMaxPathLength(maxPathLength);
		job.getGenTransRunner().setOnlyAskOnceOnAmbiguousMappings(rememberAmbiguousMappingChoice);

		job.setUser(true);
		job.schedule();
		
		job.addJobChangeListener(new IJobChangeListener() {
			
			@Override
			public void done(IJobChangeEvent event) {
				// refresh the project to see the results
				IProject projectResource = ResourcesPlugin.getWorkspace().getRoot().
		 			getProject(project);
				ResourceHelper.refresh(projectResource);

			}

			@Override
			public void aboutToRun(IJobChangeEvent event) {
				
			}

			@Override
			public void awake(IJobChangeEvent event) {
				
			}

			@Override
			public void running(IJobChangeEvent event) {
				
			}

			@Override
			public void scheduled(IJobChangeEvent event) {
				
			}

			@Override
			public void sleeping(IJobChangeEvent event) {
				
			}

		});
		
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
				MessageDialog.openError(getShell(), "Error", 
						"No project has been specified!");
				return false;
			}
			
			if(configuration.getAttribute("srcFile", "").equals("")) {
				MessageDialog.openError(getShell(), "Error", 
						"No source file has been specified!");
				return false;
			}
		
			if(configuration.getAttribute("pamtramFile", "").equals("")) {
				MessageDialog.openError(getShell(), "Error", 
						"No pamtram file has been specified!");
				return false;
			}
			
			if(configuration.getAttribute("targetFile", "").equals("")) {
				MessageDialog.openError(getShell(), "Error", 
						"No target file has been specified!");
				return false;
			}
		} catch (CoreException e) {
			MessageDialog.openError(getShell(), "Error", 
					e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Returns the current shell or creates a new one.
	 * 
	 * @return the current shell
	 */
	private Shell getShell() {
		IWorkbench workbench = PlatformUI.getWorkbench(); 
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow(); 
		return (window != null && window.getShell() != null) 
				? window.getShell() : new Shell(); 
	}
}
