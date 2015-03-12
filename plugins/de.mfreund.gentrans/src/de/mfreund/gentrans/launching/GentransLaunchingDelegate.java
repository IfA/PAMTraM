package de.mfreund.gentrans.launching;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.osgi.framework.Bundle;

import de.mfreund.gentrans.transformation.handler.GenericTransformationJob;
import de.mfreund.pamtram.util.ResourceHelper;

public class GentransLaunchingDelegate implements ILaunchConfigurationDelegate {

	/**
	 * This keeps track of the class that is to be used as target library context.
	 */
	private Class<?> targetLibContextClass;
	
	/**
	 * This keeps track of the class that is to be used as target library parser.
	 */
	private Class<?> targetLibParserClass;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		// validate the launch configuration
		validateLaunchConfig(configuration);
		
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
		
		GenericTransformationJob job = new GenericTransformationJob(
				"GenTrans", sourceFile, pamtramFile, targetFile, targetLibContextClass, targetLibParserClass);
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
	 * @throws CoreException If the validation fails.
	 */
	private void validateLaunchConfig(ILaunchConfiguration configuration) throws CoreException {
		
		/*
		 * Validate the settings in the 'Main' tab
		 */
		if(configuration.getAttribute("project", "").equals("")) {
			throw new RuntimeException("No project has been specified!");
		}
		
		if(configuration.getAttribute("srcFile", "").equals("")) {
			throw new RuntimeException("No source file has been specified!");
		}
	
		if(configuration.getAttribute("pamtramFile", "").equals("")) {
			throw new RuntimeException("No pamtram file has been specified!");
		}
		
		if(configuration.getAttribute("targetFile", "").equals("")) {
			throw new RuntimeException("No target file has been specified!");
		}
		
		/*
		 * Validate the settings in the 'Library' tab
		 */
		String targetLibBundle = configuration.getAttribute("targetLibBundle", "");
		Bundle bundle;
		targetLibContextClass = null;
		targetLibParserClass = null;
		if(!targetLibBundle.isEmpty()) {
			if((bundle = Platform.getBundle(targetLibBundle)) == null) {
				throw new RuntimeException("Bundle '" + targetLibBundle + "' cannot be resolved!" );
			}
			String targetLibContext = configuration.getAttribute("targetLibContext", "");
			if(targetLibContext.isEmpty()) {
				throw new RuntimeException("No target library context has been specified!");
			} else {
				try {
					targetLibContextClass = bundle.loadClass(targetLibContext);
				} catch (Exception e) {
					throw new RuntimeException("The target library context could not be resolved!");
				}
			}
			String targetLibParser = configuration.getAttribute("targetLibParser", "");
			if(targetLibParser.isEmpty()) {
				throw new RuntimeException("No target library parser has been specified!");
			} else {
				try {
					targetLibParserClass = bundle.loadClass(targetLibParser);
				} catch (Exception e) {
					throw new RuntimeException("The target library parser could not be resolved!");
				}
			}
		}
		
	}

}
