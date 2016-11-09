package de.mfreund.gentrans.ui.launching;

import java.io.File;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
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
import org.osgi.framework.Bundle;

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

		// create a label for the specification of the bundle that represents the specific target library
		//
		Label targetBundleLabel = new Label(targetGroup, SWT.NONE);
		targetBundleLabel.setText("Bundle ID:");

		// create a text field for the specification of the bundle that represents the specific target library
		//
		this.targetBundleText = new Text(targetGroup, SWT.NONE);
		this.targetBundleText.setMessage("Bundle identifier of the plug-in hosting the concrete LibraryContext and PathParser");
		this.targetBundleText.addModifyListener(e -> GentransLaunchLibraryTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetBundleText);

		// create a label for the specification of the concrete library context of the specific target library
		//
		Label targetLibContextLabel = new Label(targetGroup, SWT.NONE);
		targetLibContextLabel.setText("Library Context ID:");

		// create a text field for the specification of the concrete library context of the specific target library
		//
		this.targetLibContextText = new Text(targetGroup, SWT.NONE);
		this.targetLibContextText.setMessage("Fully qualified name of the concrete LibraryContext");
		this.targetLibContextText
		.addModifyListener(e -> GentransLaunchLibraryTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetLibContextText);

		// create a label for the specification of the concrete library path parser of the specific target library
		//
		Label targetLibParserLabel = new Label(targetGroup, SWT.NONE);
		targetLibParserLabel.setText("Library Path Parser ID:");

		// create a text field for the specification of the concrete library path parser of the specific target library
		//
		this.targetLibParserText = new Text(targetGroup, SWT.NONE);
		this.targetLibParserText.setMessage("Fully qualified name of the concrete PathParser (Leave empty to use default parser...)");
		this.targetLibParserText
		.addModifyListener(e -> GentransLaunchLibraryTab.this.updateLaunchConfigurationDialog());
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(this.targetLibParserText);

		// After we have created all widgets, we can initialize the data bindings among the widgets and between widgets
		// and the context
		//
		this.initDataBindings();
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		ISelection sel = UIHelper.getCurrentSelection();

		// nothing can be done if the user did not select anything
		if(sel.isEmpty() || !(sel instanceof TreeSelection)) {
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
			// set the target bundle
			this.targetBundleText.setText(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_BUNDLE, ""));
			// set the target context class
			this.targetLibContextText.setText(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_CONTEXT, ""));
			// set the target parser class
			this.targetLibParserText.setText(
					configuration.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PARSER, ""));
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
		// set the target bundle
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_BUNDLE,
				this.targetBundleText.getText());
		// set the target context class
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_CONTEXT,
				this.targetLibContextText.getText());
		// set the target parser class
		configuration.setAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PARSER,
				this.targetLibParserText.getText());
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

		if(targetLibPath.isEmpty()) {
			this.setWarningMessage("No target library path has been specified!");
			return true;
		} else if(!new File(targetLibPath).exists()) {
			this.setErrorMessage("Target library path does not exist!");
			return false;
		} else if(!new File(targetLibPath).isDirectory()) {
			this.setErrorMessage("Target library path does not represent a folder!");
			return false;
		}

		// validate the specified target library bundle
		//
		try {
			String targetLibBundle = launchConfig
					.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_BUNDLE, "");
			Bundle bundle;
			if(!targetLibBundle.isEmpty()) {
				if((bundle = Platform.getBundle(targetLibBundle)) == null) {
					this.setErrorMessage("Bundle '" + targetLibBundle + "' cannot be resolved!" );
					return false;
				}

				// validate the specified target library context
				//
				String targetLibContext = launchConfig
						.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_CONTEXT, "");
				if(targetLibContext.isEmpty()) {
					this.setWarningMessage("No target library context has been specified!");
				} else {
					try {
						bundle.loadClass(targetLibContext);
					} catch (Exception e) {
						this.setErrorMessage("The target library context could not be resolved!");
						return false;
					}
				}

				// validate the specified target library path parser
				//
				String targetLibParser = launchConfig
						.getAttribute(GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PARSER, "");
				if(!targetLibParser.isEmpty()) {
					try {
						bundle.loadClass(targetLibParser);
					} catch (Exception e) {
						this.setErrorMessage("The target library parser could not be resolved!");
						return false;
					}
				}
			} else {
				this.setWarningMessage("No bundle for the library context and path parser has been specified");
			}
		} catch(Exception e) {
			this.setErrorMessage(e.getMessage());
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
					GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PATH,
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PATH, project));

			// set the target bundle
			workingCopy.setAttribute(
					GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_BUNDLE,
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_BUNDLE, project));
			// set the target context class
			workingCopy.setAttribute(
					GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_CONTEXT,
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_CONTEXT, project));
			// set the target parser class
			workingCopy.setAttribute(
					GentransLaunchingDelegate.ATTRIBUTE_NAME_TARGET_LIB_PARSER,
					PropertySupplier.getResourceProperty(PropertySupplier.PROP_LIBRARY_TARGET_PARSER, project));

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
		IObservableValue<String> observeTextTargetBundleTextObserveWidget = WidgetProperties.text()
				.observe(this.targetBundleText);
		IObservableValue<String> observeTextTargetLibContextTextObserveWidget = WidgetProperties.text()
				.observe(this.targetLibContextText);
		IObservableValue<String> observeTextTargetLibParserTextObserveWidget = WidgetProperties.text()
				.observe(this.targetLibParserText);

		// The various observable values for bean properties
		//
		IObservableValue<String> targetLibraryPathContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_TARGET_LIBRARY_PATH).observe(this.context);
		IObservableValue<String> targetLibraryBundleContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_TARGET_LIBRARY_BUNDLE).observe(this.context);
		IObservableValue<String> targetLibraryContextContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_TARGET_LIBRARY_CONTEXT).observe(this.context);
		IObservableValue<String> targetLibraryPathParserContextObserveValue = BeanProperties
				.value(GentransLaunchContext.PROPERTY_NAME_TARGET_LIBRARY_PATH_PARSER).observe(this.context);

		// Enable the bindings between widgets and the context
		//
		this.bindingContext.bindValue(observeTextTargetPathTextObserveWidget, targetLibraryPathContextObserveValue,
				null, null);
		this.bindingContext.bindValue(observeTextTargetBundleTextObserveWidget, targetLibraryBundleContextObserveValue,
				null, null);
		this.bindingContext.bindValue(observeTextTargetLibContextTextObserveWidget,
				targetLibraryContextContextObserveValue, null, null);
		this.bindingContext.bindValue(observeTextTargetLibParserTextObserveWidget,
				targetLibraryPathParserContextObserveValue, null, null);
	}

}
