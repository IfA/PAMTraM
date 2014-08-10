package de.mfreund.pamtram.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.ide.undo.CreateProjectOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

import de.mfreund.pamtram.pages.PamtramFileSpecificationPage;
import de.mfreund.pamtram.util.ResourceHelper;
import pamtram.presentation.PamtramModelWizard;
import pamtram.presentation.pages.PamtramEPackageSpecificationPage;

public class NewPAMTraMProjectWizard extends PamtramModelWizard implements IExecutableExtension{

	// the element currently selected (might e.g. be a working set)
	private IStructuredSelection selection;
	
	// the project to be created
	private IProject newProject;
	
	// the wizard page where the project name can be entered
	private WizardNewProjectCreationPage mainPage;
	
	// the wizard page where the name of the pamtram file can be entered
	private PamtramFileSpecificationPage fileSpecPage;

	// the configuration element for the wizard
	private IConfigurationElement config;

	/**
	 * Constructor for the NewPAMTraMProjectWizard
	 */
	public NewPAMTraMProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("PAMTraM Project Wizard");
	}
	
	@Override
	public void addPages() {
		
		mainPage = new WizardNewProjectCreationPage("autoProBeProjectCreation") { //$NON-NLS-1$
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.ui.dialogs.WizardNewProjectCreationPage#createControl(org.eclipse.swt.widgets.Composite)
			 */
			public void createControl(Composite parent) {
				super.createControl(parent);
				createWorkingSetGroup(
						(Composite) getControl(),
						selection,
						new String[] {"org.eclipse.ui.resourceWorkingSetPage"}); //$NON-NLS-1$
				Dialog.applyDialogFont(getControl());
			}
		}; 
		mainPage.setTitle("PAMTraM Project");
		mainPage.setDescription("This creates a new PAMTraM Project that consists of a PAMTraM model.");
		this.addPage(mainPage);
		
		fileSpecPage = new PamtramFileSpecificationPage("Whatever2");
		fileSpecPage.setTitle("Pamtram specification");
		fileSpecPage.setDescription("Specify the name of the PAMTraM file and the source file (optional).");
		this.addPage(fileSpecPage);

		ePackageSpecificationPage = new PamtramEPackageSpecificationPage("Whatever3");
		ePackageSpecificationPage.setTitle("ePackage specification");
		ePackageSpecificationPage.setDescription("Specify the ePackages of the source and target sections.");
		this.addPage(ePackageSpecificationPage);
	}

	@Override
	public boolean performFinish() {
		
		try {
			
			// Create the Project 
			createNewProject();
			
			if (newProject == null) {
				return false;
			}
			
			// Add the created project to a working set if necessary
			IWorkingSet[] workingSets = mainPage.getSelectedWorkingSets();
			workbench.getWorkingSetManager().addToWorkingSets(newProject.getProject(),
					workingSets);
			
			// Create the project sturcture
			doFinish();
			
			// Update the perspective to the 'final perspective' set in
			// the plugin.xml
			BasicNewProjectResourceWizard.updatePerspective(this.config);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * Creates a new project resource with the selected name.
	 * <p>
	 * In normal usage, this method is invoked after the user has pressed Finish
	 * on the wizard; the enablement of the Finish button implies that all
	 * controls on the pages currently contain valid values.
	 * </p>
	 * <p>
	 * Note that this wizard caches the new project once it has been
	 * successfully created; subsequent invocations of this method will answer
	 * the same project resource without attempting to create it again.
	 * </p>
	 * 
	 * @return the created project resource, or <code>null</code> if the
	 *         project was not created
	 * @throws InvocationTargetException 
	 * @throws CoreException 
	 */
	private IProject createNewProject() throws InvocationTargetException, CoreException {
		if (newProject != null) {
			return newProject;
		}

		// get a project handle
		IProject newProjectHandle = mainPage.getProjectHandle();
		

		// get a project descriptor
		URI location = null;
		if (!mainPage.useDefaults()) {
			location = mainPage.getLocationURI();
		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace
				.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(location);
		description.setNatureIds(new String[]{"de.mfreund.pamtram.pamtramNature"});
//		description.setBuildConfigs(new String[]{"org.eclipse.wst.common.project.facet.core.builder"});
		
		// create the new project operation
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				CreateProjectOperation op = new CreateProjectOperation(
						description, "PAMTraM Project");
				try {
					// see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=219901
					// directly execute the operation so that the undo state is
					// not preserved.  Making this undoable resulted in too many 
					// accidental file deletions.
					op.execute(monitor, WorkspaceUndoUtil
						.getUIInfoAdapter(getShell()));
				} catch (ExecutionException e) {
					throw new InvocationTargetException(e);
				}
			}
		};

		// run the new project creation operation
		try {
			getContainer().run(true, true, op);
		} catch (InterruptedException e) {
			return null;
		} catch (InvocationTargetException e) {
			throw new InvocationTargetException(e);
		}
		
		newProject = newProjectHandle.getProject();
		
		return newProject;
	}
	
	/**
	 * The worker method. It performs a 'WorkspaceModifyOperation' that
	 * creates the required folders inside the project, creates an instance
	 * of the Pamtram model and copies the source model if there is one.
	 */
	private void doFinish() {
		
		
		/*
		 * Create the folders, create a pamtram model and copy the source model
		 */
		WorkspaceModifyOperation operation =
			new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					
					progressMonitor.beginTask("Creating project structure...", 1);
					
					try {
						// create the folders inside the project
						String[] paths = { "Source", "Pamtram", "Target" }; 
						ResourceHelper.addToProjectStructure(newProject.getProject(), paths);
					} catch (CoreException e) {
						e.printStackTrace();
						newProject = null;
						progressMonitor.done();
						return;
					}
					
					// copy the specified source file
					String srcFile = fileSpecPage.getSrcFile();
					if(!srcFile.isEmpty()) {
						// copy files
						ResourceHelper.copyFile(
								new File(srcFile), "Source", newProject.getProject());
						
					}
					
					progressMonitor.beginTask("Creating PAMTraM instance", 1);
					
					try {
						// Create a resource set
						//
						ResourceSet resourceSet = new ResourceSetImpl();

						// Get the URI of the pamtram file to be created.
						//
						org.eclipse.emf.common.util.URI fileURI = 
								org.eclipse.emf.common.util.URI.createPlatformResourceURI(
										newProject.getFile("Pamtram/" + fileSpecPage.getPamtramFile()).getFullPath().toString(), true);

						// Create a resource for this file.
						//
						Resource resource = resourceSet.createResource(fileURI);

						// Add the initial model object to the contents.
						//
						EObject rootObject = createInitialModel();
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.
						//
						resource.save(null);
					}
					catch (Exception e) {
						e.printStackTrace();
					}

					progressMonitor.done();
					return;
				}
		};

		// run the operation
		try {
			getContainer().run(true, false, operation);
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// save the config element
		this.config = config;
	}

}
