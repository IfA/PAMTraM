package de.mfreund.gentrans.ui.launching;

import java.io.File;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab2;
import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.SWTResourceManager;

import de.mfreund.gentrans.launching.GentransLaunchingDelegate;
import de.mfreund.pamtram.properties.PropertySupplier;
import de.tud.et.ifa.agtele.ui.util.UIHelper;

/**
 * An {@link ILaunchConfigurationTab2} that allows to customize the GenLibrary-related settings to be applied during a
 * GenTrans transformation.
 *
 * @author mfreund
 */
public class GentransLaunchLibraryTab extends AbstractLaunchConfigurationTab {

	/**
	 * A text field to specify the full path to the folder that holds the target library.
	 */
	private Text targetPathText;

	/**
	 * The domain model that this tab operates on.
	 */
	private GentransLaunchContext context;

	/**
	 * The {@link DataBindingContext} that is used to realize all data bindings among widgets and between widgets and
	 * the {@link #context}.
	 */
	private DataBindingContext bindingContext;

	/**
	 * This creates an instance.
	 *
	 * @param context
	 *            The {@link GentransLaunchContext} that shall be used for data bindings to the various widgets.
	 */
	public GentransLaunchLibraryTab(GentransLaunchContext context) {
		this.context = context;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {

		// a composite to host all other controls
		//
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setFont(parent.getFont());
		this.setControl(comp);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(this.getControl(), this.getHelpContextId());
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(true).applyTo(comp);

		// a group to host all target related settings
		//
		Group targetGroup = new Group(comp, SWT.NONE);
		targetGroup.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		targetGroup.setText("Target");
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(targetGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(targetGroup);

		// create a label for the specification of the path to the folder that holds the target library
		//
		Label targetPathLabel = new Label(targetGroup, SWT.NONE);
		targetPathLabel.setText("Library folder path:");

		// create a text field for the specification of the path to the folder that holds the target library
		//
		this.targetPathText = new Text(targetGroup, SWT.NONE);
		this.targetPathText.setMessage("Full path to the folder that holds the target library");
		this.targetPathText.addModifyListener(e -> GentransLaunchLibraryTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetPathText);

		// After we have created all widgets, we can initialize the data bindings among the widgets and between widgets
		// and the context
		//
		this.initDataBindings();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		ISelection sel = UIHelper.getCurrentSelection();

		// nothing can be done if the user did not select anything
		if (sel.isEmpty() || !(sel instanceof TreeSelection)) {
			return;
		}

		try {
			// initialize the launch configuration
			this.initLaunchConfiguration(configuration, (TreeSelection) sel);
		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {

		try {
			// set the target lib path
			this.targetPathText
					.setText(configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PATH, ""));
		} catch (CoreException e) {
			this.setErrorMessage(e.getMessage());
		}

		this.bindingContext.updateModels();
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

		// set the target lib path
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PATH,
				this.targetPathText.getText());
	}

	@Override
	public String getName() {

		return "Library";
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {

		this.setErrorMessage(null);
		this.setWarningMessage(null);

		// validate the specified target library path
		//
		String targetLibPath = this.targetPathText.getText();

		if (targetLibPath.isEmpty()) {
			this.setWarningMessage("No target library path has been specified!");
			return true;
		} else if (!new File(targetLibPath).exists()) {
			this.setErrorMessage("Target library path does not exist!");
			return false;
		} else if (!new File(targetLibPath).isDirectory()) {
			this.setErrorMessage("Target library path does not represent a folder!");
			return false;
		}

		return true;
	}

	/**
	 * Initializes the values of a launch configuration based on the current selection
	 *
	 * @param workingCopy
	 *            a launch configuration to be initialized
	 * @param selection
	 *            the current selection
	 */
	private void initLaunchConfiguration(ILaunchConfigurationWorkingCopy workingCopy, TreeSelection selection)
			throws CoreException {

		// the selected element
		Object el = selection.getFirstElement();

		IProject project;

		// determine the project based on the selection
		if (el instanceof IProject) {
			project = (IProject) el;
		} else if (el instanceof IFile) {
			project = ((IFile) el).getProject();
		} else {
			return;
		}

		// check if the project has the pamtram nature assigned
		if (project.hasNature("de.mfreund.pamtram.pamtramNature")) {

			// set the target lib path
			workingCopy.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PATH,
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PATH, project));

		} else {
			return;
		}

	}

	/**
	 * Initialize all {@link Binding data bindings} between the various widgets displayed on this tab and the
	 * {@link #context} as well as among widgets.
	 *
	 */
	@SuppressWarnings("unchecked")
	protected void initDataBindings() {

		// The context where all bindings will be registered
		//
		this.bindingContext = new DataBindingContext();

		// The various observable values for widget properties
		//
		IObservableValue<String> observeTextTargetPathTextObserveWidget = WidgetProperties.text()
				.observe(this.targetPathText);

		// The various observable values for bean properties
		//
		IObservableValue<String> targetLibraryPathContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_TARGET_LIBRARY_PATH).observe(this.context);

		// Enable the bindings between widgets and the context
		//
		this.bindingContext.bindValue(observeTextTargetPathTextObserveWidget, targetLibraryPathContextObserveValue,
				null, null);
	}

}
