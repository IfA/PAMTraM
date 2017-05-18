package de.mfreund.gentrans.ui.launching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
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
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import de.mfreund.gentrans.launching.GentransLaunchingDelegate;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.provider.PamtramEditPlugin;

/**
 * An {@link ILaunchShortcut2} that is able to launch a GenTrans transformation
 * based on a selection.
 *
 * @author mfreund
 */
public class GentransLaunchShortcut implements ILaunchShortcut2 {

	@Override
	public void launch(ISelection selection, String mode) {

		this.launch(this.getLaunchableResource(selection), mode);

	}

	@Override
	public void launch(IEditorPart editor, String mode) {

		this.launch(this.getLaunchableResource(editor), mode);

	}

	protected void launch(IResource launchableResource, String mode) {

		if (launchableResource == null) {
			MessageDialog.openError(new Shell(), "Error", "No launchable resource found!");
			return;
		}

		Optional<ILaunchConfiguration> configToLaunch = this.getConfigurationToLaunch(launchableResource);

		if (!configToLaunch.isPresent()) {
			return;
		}

		try {
			// launch the configuration
			configToLaunch.get().launch(mode, null);

		} catch (CoreException e) {
			MessageDialog.openError(new Shell(), "Error", e.getMessage());
			return;
		}
	}

	/**
	 * For the given launchable {@link IResource}, get a single
	 * {@link ILaunchConfiguration} to launch.
	 *
	 * @param launchableResource
	 *            The {@link IResource} for which a launch configuration shall
	 *            be returned.
	 * @return The {@link ILaunchConfiguration} to launch or an empty optional
	 *         if no suitable configuration could be determined/created.
	 */
	protected Optional<ILaunchConfiguration> getConfigurationToLaunch(IResource launchableResource) {

		ILaunchConfigurationType type = DebugPlugin.getDefault().getLaunchManager()
				.getLaunchConfigurationType("de.mfreund.gentrans.launchConfigurationType.gentrans");

		// get the existing launch configurations for the current selection
		ILaunchConfiguration[] launchConfigs = this.getLaunchConfigurations(launchableResource);

		ILaunchConfiguration configToLaunch;

		if (launchConfigs.length == 0) {

			// If no launch config has been found, create a new one
			//
			try {
				configToLaunch = this.createNewLaunchConfiguration(launchableResource, type);

			} catch (CoreException e) {
				MessageDialog.openError(new Shell(), "Error", e.getMessage());
				return Optional.empty();
			}

		} else if (launchConfigs.length == 1) {

			// Use the single available configuration
			//
			configToLaunch = launchConfigs[0];

		} else {

			// Let the user decide which of the available launch configurations
			// to use
			//
			ListDialog launchConfigSelectionDialog = new ListDialog(UIHelper.getShell());
			launchConfigSelectionDialog.setTitle("Select Launch Configuration");
			launchConfigSelectionDialog
					.setMessage("Multiple suitable launch configurations found. Please select one...");
			launchConfigSelectionDialog.setLabelProvider(new LabelProvider());
			launchConfigSelectionDialog.setContentProvider(new ArrayContentProvider());
			launchConfigSelectionDialog.setInput(launchConfigs);
			launchConfigSelectionDialog.open();

			Object result = launchConfigSelectionDialog.getResult();
			if (result == null || !(result instanceof Object[])
					|| !(((Object[]) result)[0] instanceof ILaunchConfiguration)) {
				return Optional.empty();
			}

			configToLaunch = (ILaunchConfiguration) ((Object[]) result)[0];
		}
		return Optional.ofNullable(configToLaunch);
	}

	/**
	 * Create a new {@link ILaunchConfiguration} for the given launchable
	 * resource.
	 *
	 * @param launchableResource
	 *            The launchable {@link IResource} for that a configuration
	 *            shall be create.
	 * @param type
	 *            The {@link ILaunchConfigurationType type} of launch
	 *            configuration to create.
	 * @return The created {@link ILaunchConfiguration}.
	 * @throws CoreException
	 */
	protected ILaunchConfiguration createNewLaunchConfiguration(IResource launchableResource,
			ILaunchConfigurationType type) throws CoreException {
		ILaunchConfiguration configToLaunch;
		ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, launchableResource.getName());

		// set default for common settings
		CommonTab tab = new CommonTab();
		tab.setDefaults(workingCopy);
		tab.dispose();

		// the context to use in the transformation
		GentransLaunchContext context = new GentransLaunchContext();

		// set default for gentrans main settings
		GentransLaunchMainTab mainTab = new GentransLaunchMainTab(context);
		mainTab.setDefaults(workingCopy);
		mainTab.dispose();

		// set default for gentrans ambiguity settings
		GentransLaunchAmbiguityTab ambiguityTab = new GentransLaunchAmbiguityTab(context);
		ambiguityTab.setDefaults(workingCopy);
		ambiguityTab.dispose();

		// set default for gentrans library settings
		GentransLaunchLibraryTab libraryTab = new GentransLaunchLibraryTab(context);
		libraryTab.setDefaults(workingCopy);
		libraryTab.dispose();

		// determine source and/or pamtram model files to use
		if (launchableResource instanceof IProject) {

			List<String> pamtramFilesToLaunch = this.getPamtramFilesToLaunch((IProject) launchableResource);
			if (pamtramFilesToLaunch.isEmpty()) {
				return null;
			}
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PAMTRAM_FILES, pamtramFilesToLaunch);

			List<String> sourceFilesToLaunch = this.getSourceFilesToLaunch((IProject) launchableResource);
			if (sourceFilesToLaunch.isEmpty()) {
				return null;
			}
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_SRC_FILES, sourceFilesToLaunch);

		} else if (launchableResource instanceof IFile) {
			if (IsLaunchablePropertyTester.isLaunchablePamtramFile((IFile) launchableResource)) {

				List<String> sourceFilesToLaunch = this.getSourceFilesToLaunch(launchableResource.getProject());
				if (sourceFilesToLaunch.isEmpty()) {
					return null;
				}
				workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_SRC_FILES, sourceFilesToLaunch);

			} else if (IsLaunchablePropertyTester.isLaunchableSourceFile((IFile) launchableResource)) {

				List<String> pamtramFilesToLaunch = this.getPamtramFilesToLaunch(launchableResource.getProject());
				if (pamtramFilesToLaunch.isEmpty()) {
					return null;
				}
				workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PAMTRAM_FILES, pamtramFilesToLaunch);
			}
		}

		// save the working copy
		configToLaunch = workingCopy.doSave();
		return configToLaunch;
	}

	/**
	 * For a given project, determine one or multiple PAMTraM files to use for a
	 * transformation by consulting the user if necessary.
	 *
	 * @param project
	 * @return
	 * @throws CoreException
	 */
	protected List<String> getPamtramFilesToLaunch(IProject project) throws CoreException {

		IFolder pamtramFolder = project.getFolder(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME"));
		List<String> pamtramFiles = Arrays.asList(pamtramFolder.members()).stream()
				.filter(p -> p instanceof IFile && IsLaunchablePropertyTester.isLaunchablePamtramFile((IFile) p))
				.map(IResource::getName).collect(Collectors.toList());

		if (pamtramFiles.isEmpty() || pamtramFiles.size() == 1) {
			return new ArrayList<>();
		} else {
			// Let the user decide which PAMTraM file(s) to use
			//
			ListSelectionDialog pamtramFileSelectionDialog = new ListSelectionDialog(UIHelper.getShell(), pamtramFiles,
					new ArrayContentProvider(), new LabelProvider(),
					"Multiple suitable PAMTraM files found. Please select one or multiple to be used in the transformation...");
			pamtramFileSelectionDialog.setTitle("Select PAMTraM File(s)");
			pamtramFileSelectionDialog.open();

			Object[] result = pamtramFileSelectionDialog.getResult();
			if (result == null || result.length == 0) {
				return new ArrayList<>();
			}
			return Arrays.asList(result).stream().map(f -> (String) f).collect(Collectors.toList());

		}
	}

	/**
	 * For a given project, determine one or multiple source files to use for a
	 * transformation by consulting the user if necessary.
	 *
	 * @param project
	 * @return
	 * @throws CoreException
	 */
	protected List<String> getSourceFilesToLaunch(IProject project) throws CoreException {

		IFolder sourceFolder = project.getFolder(PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME"));
		List<String> sourceFiles = Arrays.asList(sourceFolder.members()).stream()
				.filter(p -> p instanceof IFile && IsLaunchablePropertyTester.isLaunchableSourceFile((IFile) p))
				.map(IResource::getName).collect(Collectors.toList());
		if (sourceFiles.isEmpty() || sourceFiles.size() == 1) {
			return new ArrayList<>();
		} else {
			// Let the user decide which source file(s) to use
			//
			ListSelectionDialog sourceFileSelectionDialog = new ListSelectionDialog(UIHelper.getShell(), sourceFiles,
					new ArrayContentProvider(), new LabelProvider(),
					"Multiple suitable source files found. Please select one or multiple to be used in the transformation...");
			sourceFileSelectionDialog.setTitle("Select Source File(s)");
			sourceFileSelectionDialog.open();

			Object[] result = sourceFileSelectionDialog.getResult();
			if (result == null || result.length == 0) {
				return new ArrayList<>();
			}
			return Arrays.asList(result).stream().map(f -> (String) f).collect(Collectors.toList());

		}
	}

	/**
	 * Retrieve the existing launch configurations that are available for the
	 * current selection.
	 *
	 * @param selection
	 *            the current selection
	 * @return a list of launch configurations for the current selection
	 */
	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {

		IResource launchableResource = this.getLaunchableResource(selection);

		return this.getLaunchConfigurations(launchableResource);
	}

	/**
	 * Retrieve the existing launch configurations that are available for the
	 * current editor part.
	 *
	 * @param editorpart
	 *            the current editor part
	 * @return a list of launch configurations for the current editor part
	 */
	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {

		IResource launchableResource = this.getLaunchableResource(editorpart);

		return this.getLaunchConfigurations(launchableResource);
	}

	/**
	 * Retrieve the existing launch configurations that are available for the
	 * given launchable {@link IResource resource}.
	 *
	 * @param launchableResource
	 *            the {@link IResource} for that the launch configurations shall
	 *            be retrieved
	 * @return a list of launch configurations for the given resource
	 */
	protected ILaunchConfiguration[] getLaunchConfigurations(IResource launchableResource) {
		IProject project = launchableResource != null ? launchableResource.getProject() : null;

		// if no launchable project could be determined, return
		// an empty list of launch configurations
		if (project == null) {
			return new ILaunchConfiguration[] {};
		}

		List<ILaunchConfiguration> launchConfigs = new ArrayList<>();

		try {

			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			ILaunchConfigurationType type = launchManager
					.getLaunchConfigurationType("de.mfreund.gentrans.launchConfigurationType.gentrans");

			// retrieve the launch configurations from the launch manager
			ILaunchConfiguration[] launchConfigurations = launchManager.getLaunchConfigurations(type);

			for (ILaunchConfiguration launchConfiguration : launchConfigurations) {

				// the launch configuration is applicable if the project
				// attribute matches...
				//
				if (launchConfiguration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PROJECT, "")
						.equals(project.getName())) {

					// ... and if the user either selected a project to launch
					// or the selected file matches a source or the pamtram file
					// of a launch config
					//
					if (launchableResource instanceof IProject
							|| launchConfiguration
									.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_SRC_FILES, new ArrayList<>())
									.contains(launchableResource.getName())
							|| launchConfiguration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PAMTRAM_FILES,
									new ArrayList<>()).contains(launchableResource.getName())) {
						launchConfigs.add(launchConfiguration);
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// return the matching launch configurations
		return launchConfigs.toArray(new ILaunchConfiguration[launchConfigs.size()]);
	}

	@Override
	public IResource getLaunchableResource(ISelection selection) {

		if (selection.isEmpty() || !(selection instanceof IStructuredSelection)) {
			return null;
		}

		Object selectedElement = ((IStructuredSelection) selection).getFirstElement();

		if (selectedElement instanceof IProject) {

			return IsLaunchablePropertyTester.isLaunchablePamtramProject((IProject) selectedElement)
					? (IProject) selectedElement : null;

		} else if (selectedElement instanceof IFile) {

			if (IsLaunchablePropertyTester.isLaunchablePamtramFile((IFile) selectedElement)
					|| IsLaunchablePropertyTester.isLaunchableSourceFile((IFile) selectedElement)) {
				return (IFile) selectedElement;
			} else {
				return IsLaunchablePropertyTester.isLaunchablePamtramProject(((IFile) selectedElement).getProject())
						? ((IFile) selectedElement).getProject() : null;
			}
		}

		return null;
	}

	@Override
	public IResource getLaunchableResource(IEditorPart editorpart) {

		if (UIHelper.getCurrentEditor() == null || !UIHelper.getCurrentEditor().equals(editorpart)) {
			return null;
		}

		IEditorInput editorInput = UIHelper.getCurrentEditorInput();

		if (editorInput instanceof IFileEditorInput) {

			IFile file = ((IFileEditorInput) editorInput).getFile();

			return IsLaunchablePropertyTester.isLaunchablePamtramFile(file)
					|| IsLaunchablePropertyTester.isLaunchableSourceFile(file) ? file : null;
		}

		return null;
	}

}
