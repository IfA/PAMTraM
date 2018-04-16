/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.pamtram.wizards;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
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

import de.mfreund.pamtram.pages.EPackageSpecificationPage;
import de.mfreund.pamtram.pages.PamtramFileSpecificationPage;
import de.tud.et.ifa.agtele.genlibrary.LibraryImplementationRegistry;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.provider.PamtramEditPlugin;

/**
 * A wizard that handles the creation of new PAMTraM projects.
 *
 * @author mfreund
 */
public class NewPAMTraMProjectWizard extends PamtramModelWizard implements IExecutableExtension {

	// the project to be created
	private IProject newProject;

	// the PAMTraM resource to be created
	private Resource newPamtramResource;

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
		this.setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

		super.init(workbench, selection);
		this.setWindowTitle("PAMTraM Project Wizard");
	}

	@Override
	public void addPages() {

		this.mainPage = new WizardNewProjectCreationPage("autoProBeProjectCreation") { //$NON-NLS-1$
			/*
			 * (non-Javadoc)
			 *
			 * @see
			 * org.eclipse.ui.dialogs.WizardNewProjectCreationPage#createControl
			 * (org.eclipse.swt.widgets.Composite)
			 */

			@Override
			public void createControl(Composite parent) {

				super.createControl(parent);
				this.createWorkingSetGroup((Composite) this.getControl(), NewPAMTraMProjectWizard.this.selection,
						new String[] { "org.eclipse.ui.resourceWorkingSetPage" }); //$NON-NLS-1$
				Dialog.applyDialogFont(this.getControl());
			}
		};
		this.mainPage.setTitle("PAMTraM Project");
		this.mainPage.setDescription("This creates a new PAMTraM Project that consists of a PAMTraM model.");
		this.addPage(this.mainPage);

		this.fileSpecPage = new PamtramFileSpecificationPage("Whatever2") {

			@Override
			public void setVisible(boolean visible) {

				super.setVisible(visible);
				if (!visible) {
					NewPAMTraMProjectWizard.this.sourceEPackageSpecificationPage
							.setNamespaceURIs(new HashSet<>(NewPAMTraMProjectWizard.this.fileSpecPage.getNsUris()));
				}
			}
		};
		this.fileSpecPage.setTitle("Pamtram specification");
		this.fileSpecPage.setDescription("Specify the name of the PAMTraM file and the source file(s) (optional).");
		this.addPage(this.fileSpecPage);

		this.sourceEPackageSpecificationPage = new EPackageSpecificationPage("sourceEPackageSelection",
				"Source EPackage Specification",
				"Specify all EPackages (via their namespace URIs) for that a 'SourceSectionModel' shall "
						+ "be generated. The EPackages can thereby either be selected from the global EPackage registry or "
						+ "based on a meta-model file (Ecore/XSD).",
				null);
		this.addPage(this.sourceEPackageSpecificationPage);

		this.targetEPackageSpecificationPage = new EPackageSpecificationPage("targetEPackageSelection",
				"Target EPackage Specification",
				"Specify all EPackages (via their namespace URIs) for that a 'TargetSectionModel' shall "
						+ "be generated. The EPackages can thereby either be selected from the global EPackage registry or "
						+ "based on a meta-model file (Ecore/XSD).",
				null);
		this.addPage(this.targetEPackageSpecificationPage);

	}

	@Override
	public boolean performFinish() {

		try {

			// Create the Project
			this.createNewProject();

			if (this.newProject == null) {
				return false;
			}

			// Add the created project to a working set if necessary
			IWorkingSet[] workingSets = this.mainPage.getSelectedWorkingSets();
			this.workbench.getWorkingSetManager().addToWorkingSets(this.newProject.getProject(), workingSets);

			// Create the project structure
			this.doFinish();

			// Update the perspective to the 'final perspective' set in
			// the plugin.xml
			BasicNewProjectResourceWizard.updatePerspective(this.config);

			// Open the created PAMTraM resource in the PAMTraM editor
			//
			UIHelper.openEditor(ResourceHelper.getFileForResource(this.newPamtramResource),
					"pamtram.presentation.PamtramEditorID");

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(UIHelper.getShell(), "PAMTraM Project Wizard", e.getMessage());
			return false;
		}

		UIHelper.getCurrentEditor().getEditorSite().getActionBars().getStatusLineManager()
				.setMessage("New PAMTraM project '" + this.newProject.getName() + "' successfully created...");

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
	 * @return the created project resource, or <code>null</code> if the project
	 *         was not created
	 * @throws InvocationTargetException
	 * @throws CoreException
	 * @throws InterruptedException
	 */
	private IProject createNewProject() throws InvocationTargetException, CoreException, InterruptedException {

		if (this.newProject != null) {
			return this.newProject;
		}

		// get a project handle
		IProject newProjectHandle = this.mainPage.getProjectHandle();

		// get a project descriptor
		URI location = null;
		if (!this.mainPage.useDefaults()) {
			location = this.mainPage.getLocationURI();
		}

		boolean setPamtramLibraryNature = this.targetEPackageSpecificationPage.getRegistry().keySet().stream().anyMatch(
				nsUri -> LibraryImplementationRegistry.getInstance().getLibraryContextImplementation(nsUri) != null);

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProjectDescription description = workspace.newProjectDescription(newProjectHandle.getName());
		description.setLocationURI(location);
		description.setNatureIds(setPamtramLibraryNature
				? new String[] { "de.mfreund.pamtram.pamtramNature", "de.mfreund.pamtram.pamtramLibraryNature" }
				: new String[] { "de.mfreund.pamtram.pamtramNature" });

		// create the new project operation
		IRunnableWithProgress op = monitor -> {
			CreateProjectOperation op1 = new CreateProjectOperation(description, "PAMTraM Project");
			try {
				// see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=219901
				// directly execute the operation so that the undo state is
				// not preserved. Making this undoable resulted in too many
				// accidental file deletions.
				op1.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(NewPAMTraMProjectWizard.this.getShell()));
			} catch (ExecutionException e) {
				throw new InvocationTargetException(e);
			}
		};

		// run the new project creation operation
		this.getContainer().run(true, true, op);

		this.newProject = newProjectHandle.getProject();

		return this.newProject;
	}

	/**
	 * The worker method. It performs a 'WorkspaceModifyOperation' that creates
	 * the required folders inside the project, creates an instance of the
	 * Pamtram model and copies the source model if there is one.
	 *
	 * @throws InterruptedException
	 * @throws InvocationTargetException
	 */
	private void doFinish() throws InvocationTargetException, InterruptedException {

		EPackage.Registry sourceRegistry = this.sourceEPackageSpecificationPage.getRegistry();
		HashMap<String, String> sourceMap = this.sourceEPackageSpecificationPage.getNamespaceURIsToMetamodelFiles();
		EPackage.Registry targetRegistry = this.targetEPackageSpecificationPage.getRegistry();
		HashMap<String, String> targetMap = this.targetEPackageSpecificationPage.getNamespaceURIsToMetamodelFiles();

		/*
		 * Create the folders, create a pamtram model and copy the source model
		 */
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor progressMonitor) throws CoreException {

				progressMonitor.beginTask("Creating project structure...", 1);

				try {
					// create the folders inside the project
					if (!sourceMap.values().isEmpty() || !targetMap.isEmpty()) {
						ResourceHelper.addToProjectStructure(NewPAMTraMProjectWizard.this.newProject.getProject(),
								new String[] { PamtramEditPlugin.INSTANCE.getString("METAMODEL_FOLDER_NAME"),
										PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME"),
										PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME"),
										PamtramEditPlugin.INSTANCE.getString("TARGET_FOLDER_NAME") });
					} else {
						ResourceHelper.addToProjectStructure(NewPAMTraMProjectWizard.this.newProject.getProject(),
								new String[] { PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME"),
										PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME"),
										PamtramEditPlugin.INSTANCE.getString("TARGET_FOLDER_NAME") });

					}
				} catch (CoreException e) {
					NewPAMTraMProjectWizard.this.newProject = null;
					progressMonitor.done();
					throw new RuntimeException("Error creating folder structure for the project...", e);
				}

				// copy the specified source file
				for (String srcFile : NewPAMTraMProjectWizard.this.fileSpecPage.getSrcFiles()) {
					// copy files
					ResourceHelper.copyFile(new File(srcFile),
							PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME"),
							NewPAMTraMProjectWizard.this.newProject.getProject());
				}

				// copy the source ecore model(s) if necessary
				for (Entry<String, String> entry : sourceMap.entrySet()) {
					ResourceHelper.copyFile(new File(entry.getValue()),
							PamtramEditPlugin.INSTANCE.getString("METAMODEL_FOLDER_NAME"),
							NewPAMTraMProjectWizard.this.newProject.getProject());

					// if the meta-model is an XSD file, we need to create the
					// corresponding Ecore file
					if (entry.getValue().endsWith(".xsd")) {
						if (!NewPAMTraMProjectWizard.this.createEcoreForXSD(entry.getValue(),
								sourceRegistry.getEPackage(entry.getKey()))) {
							progressMonitor.done();
							throw new RuntimeException(
									"Could not create Ecore model for XSD '" + entry.getValue() + "'!");
						}
					}
				}

				// copy the target ecore model if necessary
				for (Entry<String, String> entry : targetMap.entrySet()) {
					ResourceHelper.copyFile(new File(entry.getValue()),
							PamtramEditPlugin.INSTANCE.getString("METAMODEL_FOLDER_NAME"),
							NewPAMTraMProjectWizard.this.newProject.getProject());

					// if the meta-model is an XSD file, we need to create the
					// corresponding Ecore file
					if (entry.getValue().endsWith(".xsd")) {
						if (!NewPAMTraMProjectWizard.this.createEcoreForXSD(entry.getValue(),
								targetRegistry.getEPackage(entry.getKey()))) {
							throw new RuntimeException(
									"Could not create Ecore model for XSD '" + entry.getValue() + "'!");
						}
					}

				}

				progressMonitor.beginTask("Creating PAMTraM instance", 1);

				try {
					// Create a resource set
					//
					ResourceSet resourceSet = new ResourceSetImpl();

					// Get the URI of the pamtram file to be created.
					//
					org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI
							.createPlatformResourceURI(NewPAMTraMProjectWizard.this.newProject
									.getFile(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME") + "/"
											+ NewPAMTraMProjectWizard.this.fileSpecPage.getPamtramFile())
									.getFullPath().toString(), true);

					// Create a resource for this file.
					//
					NewPAMTraMProjectWizard.this.newPamtramResource = resourceSet.createResource(fileURI);

					// Add the initial model object to the contents.
					//
					EObject rootObject = NewPAMTraMProjectWizard.this.createInitialModel();
					if (rootObject != null) {
						NewPAMTraMProjectWizard.this.newPamtramResource.getContents().add(rootObject);
					}

					// Save the contents of the resource to the file system.
					//
					NewPAMTraMProjectWizard.this.newPamtramResource.save(null);

					// Refresh the project
					//
					ResourceHelper.refresh(NewPAMTraMProjectWizard.this.newProject);

				} catch (Exception e) {
					progressMonitor.done();
					throw new RuntimeException("An error occurred during the creation of the PAMTraM model!", e);
				}

				progressMonitor.done();
				return;
			}
		};

		// run the operation
		//
		this.getContainer().run(true, false, operation);

	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

		// save the config element
		this.config = config;
	}

	/**
	 * Create an Ecore file for the given '<em>xsdFile</em>' and the
	 * corresponding '<em>ePackage</em>'.
	 *
	 * @param xsdFile
	 *            The absolute path to the file containing the XSD.
	 * @param ePackage
	 *            The {@link EPackage} that has been created from the XSD.
	 * @return '<em><b>true</b></em>' if the Ecore file could be created
	 *         successfully, '<em><b>false</b></em>' otherwise.
	 */
	private boolean createEcoreForXSD(String xsdFile, EPackage ePackage) {

		org.eclipse.emf.common.util.URI ecoreURI = org.eclipse.emf.common.util.URI
				.createPlatformResourceURI(this.newProject.getProject().getName() + "/"
						+ PamtramEditPlugin.INSTANCE.getString("METAMODEL_FOLDER_NAME") + "/"
						+ new File(xsdFile).getName() + ".ecore", true);
		Resource resource = new ResourceSetImpl().createResource(ecoreURI);
		resource.getContents().add(ePackage);

		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		/*
		 * Adapt the uri of the resource to point to the namespace URI. This
		 * needs to be set after saving the resource so that the resource is
		 * still stored to the correct location. However, the in-memory
		 * representation of the URI needs to represent the namespace instead of
		 * the location so that all references (e.g. in the PAMTraM model are
		 * namespace- instead of location-based.
		 */
		org.eclipse.emf.common.util.URI namespaceURI = org.eclipse.emf.common.util.URI.createURI(ePackage.getNsURI());
		ePackage.eResource().setURI(namespaceURI);

		return true;
	}
}
