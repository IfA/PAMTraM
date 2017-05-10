package de.mfreund.gentrans.ui.launching;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.ListDialog;

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

		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = launchManager
				.getLaunchConfigurationType("de.mfreund.gentrans.launchConfigurationType.gentrans");

		// get the existing launch configurations for the current selection
		ILaunchConfiguration[] launchConfigs = this.getLaunchConfigurations(selection);

		ILaunchConfiguration configToLaunch;

		if (launchConfigs.length == 0) {
			// if no launch config has been found, create a new one
			try {
				IResource res = this.getLaunchableResource(selection);
				if (res == null) {
					MessageDialog.openError(new Shell(), "Error", "No launchable resource found!");
					return;
				}
				ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, res.getName());

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

				// save the working copy
				configToLaunch = workingCopy.doSave();

			} catch (CoreException e) {
				MessageDialog.openError(new Shell(), "Error", e.getMessage());
				return;
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
				return;
			}

			configToLaunch = (ILaunchConfiguration) ((Object[]) result)[0];
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
	 * @param selection
	 *            the current selection
	 * @return a list of launch configurations for the current selection
	 */
	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {

		IResource launchableResource = this.getLaunchableResource(selection);

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
							|| launchConfiguration
									.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_PAMTRAM_FILE, "")
									.equals(launchableResource.getName())) {
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
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {

		return new ILaunchConfiguration[] {};
	}

	@Override
	public IResource getLaunchableResource(ISelection selection) {

		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {

			// the selected object
			Object el = ((IStructuredSelection) selection).getFirstElement();

			if (el instanceof IProject) {

				// if a project has been selected, return it
				return (IProject) el;

			} else if (el instanceof IFile) {

				// if a source or pamtram file has been selected, return it
				IFile file = (IFile) el;
				if ((file.getName().endsWith(".xmi") || file.getName().endsWith(".xml")) && file.getParent().getName()
						.equals(PamtramEditPlugin.INSTANCE.getString("SOURCE_FOLDER_NAME"))) {
					return file;
				} else if (file.getName().endsWith(".pamtram") && file.getParent().getName()
						.equals(PamtramEditPlugin.INSTANCE.getString("PAMTRAM_FOLDER_NAME"))) {
					return file;
				} else {
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
