package de.mfreund.gentrans.ui.launching;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import de.mfreund.pamtram.properties.PropertySupplier;

public class GentransLaunchLibraryTab extends AbstractLaunchConfigurationTab {

	// the context containing all settings necessary to launch a new generic transformation
	private GentransLaunchContext context;

	/**
	 * A text field to specify the full path to the folder that holds the target library.
	 */
	private Text targetPathText;

	/**
	 * A text field to specify the bundle that represents the specific target library.
	 */
	private Text targetBundleText;

	/**
	 * A text field to specify the concrete library context of the specific target library.
	 */
	private Text targetLibContextText;

	/**
	 * A text field to specify the concrete library path parser of the specific target library.
	 */
	private Text targetLibParserText;

	public GentransLaunchLibraryTab(GentransLaunchContext context) {
		this.context = context;
	}

	@Override
	public void createControl(Composite parent) {

		// a composite to host all other controls
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), getHelpContextId());
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(comp);
		comp.setFont(parent.getFont());

		// a group to host all target related settings
		Group targetGroup = new Group(comp, SWT.NONE);
		targetGroup.setText("Target");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(targetGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(targetGroup);

		// create a label for the specification of the path to the folder that holds the target library 
		Label targetPathLabel = new Label(targetGroup, SWT.NONE);
		targetPathLabel.setText("Library folder path:");
		GridDataFactory.swtDefaults().applyTo(targetPathLabel);

		// create a text field for the specification of the path to the folder that holds the target library
		targetPathText = new Text(targetGroup, SWT.NONE);
		targetPathText.setMessage("Full path to the folder that holds the target library");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(targetPathText);
		targetPathText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		// create a label for the specification of the bundle that represents the specific target library 
		Label targetBundleLabel = new Label(targetGroup, SWT.NONE);
		targetBundleLabel.setText("Bundle ID:");
		GridDataFactory.swtDefaults().applyTo(targetBundleLabel);

		// create a text field for the specification of the bundle that represents the specific target library 
		targetBundleText = new Text(targetGroup, SWT.NONE);
		targetBundleText.setMessage("Bundle identifier of the plug-in hosting the concrete LibraryContext and PathParser");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(targetBundleText);
		targetBundleText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		// create a label for the specification of the concrete library context of the specific target library
		Label targetLibContextLabel = new Label(targetGroup, SWT.NONE);
		targetLibContextLabel.setText("Library Context ID:");
		GridDataFactory.swtDefaults().applyTo(targetLibContextLabel);

		// create a text field for the specification of the concrete library context of the specific target library
		targetLibContextText = new Text(targetGroup, SWT.NONE);
		targetLibContextText.setMessage("Fully qualified name of the concrete LibraryContext");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(targetLibContextText);
		targetLibContextText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		// create a label for the specification of the concrete library path parser of the specific target library
		Label targetLibParserLabel = new Label(targetGroup, SWT.NONE);
		targetLibParserLabel.setText("Library Path Parser ID:");
		GridDataFactory.swtDefaults().applyTo(targetLibParserLabel);

		// create a text field for the specification of the concrete library path parser of the specific target library 
		targetLibParserText = new Text(targetGroup, SWT.NONE);
		targetLibParserText.setMessage("Fully qualified name of the concrete PathParser (Leave empty to use default parser...)");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(targetLibParserText);
		targetLibParserText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		// get the current selection
		IWorkbench wb = PlatformUI.getWorkbench(); 
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		ISelection sel = win.getSelectionService().getSelection(); 

		// nothing can be done if the user did not select anything
		if(sel.isEmpty() || !(sel instanceof TreeSelection)) {
			return;
		}


		try {
			// initialize the launch configuration
			initLaunchConfiguration(configuration, (TreeSelection) sel);
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			// set the target lib path
			targetPathText.setText(configuration.getAttribute("targetLibPath", ""));
			// set the target bundle
			targetBundleText.setText(configuration.getAttribute("targetLibBundle", ""));
			// set the target context class
			targetLibContextText.setText(configuration.getAttribute("targetLibContext", ""));
			// set the target parser class
			targetLibParserText.setText(configuration.getAttribute("targetLibParser", ""));
		} catch (CoreException e) {
			setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// set the target lib path
		configuration.setAttribute("targetLibPath", targetPathText.getText());
		// set the target bundle
		configuration.setAttribute("targetLibBundle", targetBundleText.getText());
		// set the target context class
		configuration.setAttribute("targetLibContext", targetLibContextText.getText());
		// set the target parser class
		configuration.setAttribute("targetLibParser", targetLibParserText.getText());
	}

	@Override
	public String getName() {
		return "Library";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		setWarningMessage(null);
		String targetLibPath = targetPathText.getText();
		if(targetLibPath.isEmpty()) {
			setWarningMessage("No target library path has been specified!");
			return true;
		} else if(!(new File(targetLibPath)).exists()) {
			setErrorMessage("Target library path does not exist!");
			return false;
		} else if(!(new File(targetLibPath)).isDirectory()) {
			setErrorMessage("Target library path does not represent a folder!");
			return false;
		}
		try {
			String targetLibBundle = launchConfig.getAttribute("targetLibBundle", "");
			Bundle bundle;
			if(!targetLibBundle.isEmpty()) {
				if((bundle = Platform.getBundle(targetLibBundle)) == null) {
					setErrorMessage("Bundle '" + targetLibBundle + "' cannot be resolved!" );
					return false;
				}
				String targetLibContext = launchConfig.getAttribute("targetLibContext", "");
				if(targetLibContext.isEmpty()) {
					setWarningMessage("No target library context has been specified!");
				} else {
					try {
						bundle.loadClass(targetLibContext);
					} catch (Exception e) {
						setErrorMessage("The target library context could not be resolved!");
						return false;
					}
				}
				String targetLibParser = launchConfig.getAttribute("targetLibParser", "");
				if(!targetLibParser.isEmpty()) {
					try {
						bundle.loadClass(targetLibParser);
					} catch (Exception e) {
						setErrorMessage("The target library parser could not be resolved!");
						return false;
					}
				}
			} else {
				setWarningMessage("No bundle for the library context and path parser has been specified");
			}
		} catch(Exception e) {
			setErrorMessage(e.getMessage());
			return false;
		}
		return true;
	}

	/** Initializes the values of a launch configuration based on the current selection
	 * 
	 * @param workingCopy a launch configuration to be initialized
	 * @param selection the current selection
	 */
	private void initLaunchConfiguration(ILaunchConfigurationWorkingCopy workingCopy, 
			TreeSelection selection) throws CoreException {

		// the selected element
		Object el = selection.getFirstElement();

		IProject project;

		// determine the project based on the selection
		if(el instanceof IProject) {
			project = (IProject) el; 
		} else if(el instanceof IFile) {
			project = ((IFile) el).getProject();
		} else {
			return;
		}

		// check if the project has the pamtram nature assigned
		if(project.hasNature("de.mfreund.pamtram.pamtramNature")) {

			// set the target lib path
			workingCopy.setAttribute(
					"targetLibPath",
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PATH, project));

			// set the target bundle
			workingCopy.setAttribute(
					"targetLibBundle", 
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_BUNDLE, project));
			// set the target context class
			workingCopy.setAttribute(
					"targetLibContext",
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_CONTEXT, project));
			// set the target parser class
			workingCopy.setAttribute(
					"targetLibParser",
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PARSER, project));

		} else {
			return;
		}

	}

}
