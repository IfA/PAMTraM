package de.mfreund.gentrans.transformation;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.matching.SourceSectionMatcher;
import de.mfreund.gentrans.transformation.util.MonitorWrapper;
import de.mfreund.pamtram.transformation.Transformation;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.util.UIHelper;
import pamtram.FixedValue;
import pamtram.structure.source.SourceSectionClass;

/**
 * A special {@link BasicGenericTransformationRunner} that uses an {@link IProgressMonitor} to inform the user about the
 * current phase of the transformation and makes use of {@link MessageDialog MessageDialogs} to request user feedback.
 * <p />
 * Note: Instances need to be created via the {@link GenericTransformationRunnerFactory}.
 *
 * @author mfreund
 */
public class GenericTransformationRunnerWithUI extends BasicGenericTransformationRunner {

	/**
	 * The {@link IProgressMonitor} that shall be used to visualize the progress of the transformation.
	 * <p />
	 * Instead of directly storing an {@link IProgressMonitor}, we make use of a {@link MonitorWrapper} so that we are
	 * not dependent on an actual monitor to be present.
	 */
	protected MonitorWrapper monitor;

	/**
	 * This creates an instance based on the given {@link TransformationConfiguration}.
	 * <p />
	 * Note: This will use a default {@link Logger} implementation to print log messages.
	 *
	 * @see #GenericTransformationRunner(TransformationConfiguration, Logger)
	 *
	 * @param config
	 *            The {@link TransformationConfiguration} specifying all parameters necessary for the execution of the
	 *            transformation.
	 * @param monitor
	 *            An optional {@link IProgressMonitor} that shall be used to display the progress of the transformation.
	 */
	protected GenericTransformationRunnerWithUI(TransformationConfiguration config,
			Optional<IProgressMonitor> monitor) {

		super(config);

		this.monitor = new MonitorWrapper(monitor);

	}

	/**
	 * This creates an instance based on the given {@link TransformationConfiguration}.
	 * <p />
	 * Note: This will use the given {@link Logger} implementation to print log messages.
	 *
	 * @see #GenericTransformationRunner(TransformationConfiguration)
	 *
	 * @param config
	 *            The {@link TransformationConfiguration} specifying all parameters necessary for the execution of the
	 *            transformation.
	 * @param monitor
	 *            An optional {@link IProgressMonitor} that shall be used to display the progress of the transformation.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	protected GenericTransformationRunnerWithUI(TransformationConfiguration config, Optional<IProgressMonitor> monitor,
			Logger logger) {

		super(config, logger);

		this.monitor = new MonitorWrapper(monitor);

	}

	/**
	 * This performs the actual generic transformation. It loads all necessary models, executes the mappings defined in
	 * the PAMTraM model and stores the generated target model. All progress is reported to the given
	 * '<em>monitor</em>'.
	 *
	 * @return '<em>true</em>' if the transformation completed successfully; '<em>false</em>' otherwise
	 */
	@Override
	public boolean runTransformation() {

		this.monitor.beginTask("Executing Generic Transformation", 700);

		boolean result = super.runTransformation();

		if (result && !this.assetManager.getTargetModelRegistry().isEmpty()
				&& this.transformationConfig.isOpenTargetModelOnCompletion()) {

			// Open the (first of the) generated target model(s)
			//
			new UIJob("Open Generated Target Model") {

				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {

					String targetModelToOpen = GenericTransformationRunnerWithUI.this.assetManager
							.getTargetModelRegistry().getTargetModels().keySet().iterator().next();
					final URI targetModelToOpenUri = URI.createPlatformResourceURI(
							GenericTransformationRunnerWithUI.this.transformationConfig.getTargetBasePath()
									+ Path.SEPARATOR + targetModelToOpen,
							true);

					try {
						UIHelper.openEditor(ResourceHelper.getFileForURI(targetModelToOpenUri));
					} catch (PartInitException e) {
						GenericTransformationRunnerWithUI.this.assetManager.getLogger().severe(e::toString);
						e.printStackTrace();
					}

					return Status.OK_STATUS;
				}
			}.schedule();

		}

		this.monitor.done();

		return result;

	}

	/**
	 * This is a temporary method that is called by the 'source section matcher page' in order to get the matched
	 * sections for a sample source model. Therefore, it performs half a transformation and then returns the matched
	 * section. This should be changed in the future e.g. by using the 'transformation model'.
	 *
	 * @return A map relating the matched SourceSectionClasses to the {@link EObject elements} they have been matched
	 *         against.
	 */
	@Deprecated
	public Map<SourceSectionClass, Set<EObject>> matchSourceSections() {

		// prepare the transformation (validate pamtram model, merge extends,
		// etc.)
		//
		if (!this.prepare()) {
			this.assetManager.getLogger().severe(GenericTransformationRunnerWithUI.TRANSFORMATION_ABORTED_MESSAGE);
			return null;
		}

		this.writePamtramMessage("Matching SourceSections");

		// Collect the global values modeled in the PAMTraM instance
		//
		Map<FixedValue, String> globalFixedValues = this.transformationConfig.getPamtramModels().stream()
				.flatMap(p -> p.getGlobalValues().stream())
				.collect(Collectors.toMap(Function.identity(), FixedValue::getValue));

		this.assetManager.getGlobalValues().addFixedValues(globalFixedValues);

		/*
		 * Match the SourceSections
		 */
		SourceSectionMatcher sourceSectionMatcher = this.assetManager.getSourceSectionMatcher();

		sourceSectionMatcher.matchSections(this.transformationConfig.getSourceModels(),
				this.transformationConfig.getPamtramModels());

		// Retrieve the list of all created MatchedSectionDescriptors
		//
		List<MatchedSectionDescriptor> descriptors = this.assetManager.getMatchedSectionRegistry().values()
				.parallelStream().flatMap(e -> e.parallelStream()).collect(Collectors.toList());

		// Collect the matched class from all returned descriptors
		// (see
		// http://stackoverflow.com/questions/23038673/merging-two-mapstring-integer-with-java-8-stream-api)
		//
		Map<SourceSectionClass, Set<EObject>> matchedClasses = descriptors.parallelStream()
				.map(d -> d.getSourceModelObjectsMapped()).map(m -> m.entrySet()).flatMap(Collection::stream)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (i, j) -> {
					i.addAll(j);
					return i;
				}));

		this.writePamtramMessage("Complete");

		return matchedClasses;

	}

	@Override
	protected boolean prepare() {

		return this.runSupplierWithMonitor("Preparing Transformation", 50, super::prepare);
	}

	@Override
	protected boolean validatePamtramModels() {

		boolean isValid = super.validatePamtramModels();

		if (isValid) {
			return true;
		}

		// If the models are invalid, let the user decide if the transformation should be continued anyway
		//
		final AtomicBoolean result = new AtomicBoolean();
		Display.getDefault().syncExec(
				() -> result.set(ErrorDialog.open(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"Errors exist in the specified PAMTraM model. Continue anyway?")));

		return result.get();
	}

	@Override
	protected void performSearching_MatchSections() {

		this.runRunnableWithMonitor("Searching - Matching SourceSections", 100, super::performSearching_MatchSections);
	}

	@Override
	protected void performSearching_SelectMappings() {

		this.runRunnableWithMonitor("Searching - Selecting Mappings", 100, super::performSearching_SelectMappings);
	}

	@Override
	protected void performExtracting() {

		this.runRunnableWithMonitor("Extractring", 100, super::performExtracting);
	}

	@Override
	protected void performInstantiating() {

		this.runRunnableWithMonitor("Instantiating TargetSections for Selected Mappings", 100,
				super::performInstantiating);
	}

	@Override
	protected void performJoining() {

		this.runRunnableWithMonitor("Joining Instantiated TargetSections", 100, super::performJoining);
	}

	@Override
	protected void performLinking() {

		this.runRunnableWithMonitor("Linking Instantiated TargetSections", 100, super::performLinking);
	}

	@Override
	protected void performInstantiatingLibraryEntries() {

		this.runRunnableWithMonitor("Instantiating LibraryEntries", 100, super::performInstantiatingLibraryEntries);
	}

	@Override
	protected boolean storeTargetModels() {

		return this.runSupplierWithMonitor("Storing Target Model(s)", 50, super::storeTargetModels);
	}

	@Override
	protected boolean generateTransformationModel(Date startTime, Date endTime) {

		this.monitor.subTask("Generating Transformation Model");
		boolean result = super.generateTransformationModel(startTime, endTime);
		this.monitor.worked(50);

		return result;
	}

	@Override
	protected Optional<String> getTransformationModelName() {

		String transformationModelName = super.getTransformationModelName().orElse("");

		// Let the user specify a name for the transformation model
		//
		final AtomicReference<Optional<String>> result = new AtomicReference<>();
		Display.getDefault().syncExec(
				() -> result.set(TransformationModelNameDialog.open(UIHelper.getShell(), transformationModelName)));

		return result.get();
	}

	@Override
	protected void internalPersistTransformationModel(Transformation transformationModel) throws IOException {

		try {
			super.internalPersistTransformationModel(transformationModel);
		} catch (IOException e) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
					"The XMI resource for the TransformationModel could not be created.");
			throw e;
		}
	}

	/**
	 * A helper function that simply executes the given {@link Runnable}. However, it first creates a new
	 * {@link IProgressMonitor#subTask(String) sub task} on the {@link #monitor} and afterwards updates its
	 * {@link IProgressMonitor#worked(int) worked} status.
	 *
	 * @param taskName
	 *            The name of the sub task to create on the {@link #monitor}.
	 * @param work
	 *            The work of the sub task (used to update the {@link IProgressMonitor#worked(int) worked} status.
	 * @param subTask
	 *            The {@link Runnable} to execute.
	 * @throws Exception
	 */
	protected void runRunnableWithMonitor(String taskName, int work, Runnable subTask) {

		this.monitor.subTask(taskName);
		subTask.run();
		this.monitor.worked(work);
	}

	/**
	 * A helper function that simply executes the given {@link Supplier} and returns its return value. However, it first
	 * creates a new {@link IProgressMonitor#subTask(String) sub task} on the {@link #monitor} and afterwards updates
	 * its {@link IProgressMonitor#worked(int) worked} status.
	 *
	 * @param taskName
	 *            The name of the sub task to create on the {@link #monitor}.
	 * @param work
	 *            The work of the sub task (used to update the {@link IProgressMonitor#worked(int) worked} status.
	 * @param subTask
	 *            The {@link Runnable} to execute.
	 */
	protected <R> R runSupplierWithMonitor(String taskName, int work, Supplier<R> subTask) {

		this.monitor.subTask(taskName);
		R result = subTask.get();
		this.monitor.worked(work);

		return result;
	}

	/**
	 * A helper function that simply executes the given {@link Callable} and returns its return value. However, it first
	 * creates a new {@link IProgressMonitor#subTask(String) sub task} on the {@link #monitor} and afterwards updates
	 * its {@link IProgressMonitor#worked(int) worked} status.
	 *
	 * @param taskName
	 *            The name of the sub task to create on the {@link #monitor}.
	 * @param work
	 *            The work of the sub task (used to update the {@link IProgressMonitor#worked(int) worked} status.
	 * @param subTask
	 *            The {@link Runnable} to execute.
	 * @throws Exception
	 *             Any exception thrown by the given {@link Callable} during its execution.
	 */
	protected <R> R runCallableWithMonitor(String taskName, int work, Callable<R> subTask) throws Exception {

		this.monitor.subTask(taskName);
		R result = subTask.call();
		this.monitor.worked(work);

		return result;
	}

	/**
	 * A {@link MessageDialog} that informs about an error and asks the user whether he wants to continue or to abort.
	 *
	 * @author mfreund
	 */
	static class ErrorDialog extends MessageDialog {

		private ErrorDialog(Shell parentShell, String dialogMessage) {

			super(parentShell, "Error", null, dialogMessage, MessageDialog.ERROR, new String[] { "Continue", "Abort" },
					0);
		}

		/**
		 * This creates and opens a dialog.
		 *
		 * @param parentShell
		 *            The parent shell of the dialog, or <code>null</code> if none.
		 * @param dialogMessage
		 *            The message to display to the user.
		 * @return '<em><b>true</b></em>' if the user selected <em>Continue</em>, '<em><b>false</b></em>' if he selected
		 *         <em>Abort</em>.
		 */
		public static boolean open(Shell parentShell, String dialogMessage) {

			ErrorDialog dialog = new ErrorDialog(parentShell, dialogMessage);
			return dialog.open() == 0;
		}
	}

	/**
	 * A {@link MessageDialog} that asks for a name for the name of the TransformationModel to be created..
	 *
	 * @author mfreund
	 */
	static class TransformationModelNameDialog extends MessageDialog {

		/**
		 * The {@link Text} where the user enters the name for the TransformationModel.
		 */
		private Text transformationModelNameTextField;

		/**
		 * The name for the TransformationModel that was specified by the user.
		 */
		private String transformationModelName = "";

		private TransformationModelNameDialog(Shell parentShell, String defaultName) {

			super(parentShell, "TransformationModel", null,
					"Please specify a name for the TransformationModel to be created for this transformation...",
					MessageDialog.QUESTION, new String[] { "OK", "Abort" }, 0);

			this.transformationModelName = defaultName;
		}

		@Override
		protected Control createCustomArea(Composite parent) {

			this.transformationModelNameTextField = new Text(parent, SWT.BORDER);
			this.transformationModelNameTextField.insert(this.transformationModelName);
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false)
					.applyTo(this.transformationModelNameTextField);
			this.transformationModelNameTextField.addModifyListener(e -> {
				String newName = TransformationModelNameDialog.this.transformationModelNameTextField.getText();
				TransformationModelNameDialog.this.transformationModelName = newName;
				this.getButton(IDialogConstants.OK_ID).setEnabled(!newName.isEmpty());
			});
			this.transformationModelNameTextField
					.addModifyListener(e -> this.getButton(IDialogConstants.OK_ID).setEnabled(
							!TransformationModelNameDialog.this.transformationModelNameTextField.getText().isEmpty()));
			return this.transformationModelNameTextField;
		}

		/**
		 * Return the name that was specified by the user.
		 *
		 * @return The name that was specified by the user or an empty String if the user did not specify anything.
		 */
		private String getResult() {

			return this.transformationModelName;
		}

		/**
		 * This creates and opens a dialog.
		 *
		 * @param parentShell
		 *            The parent shell of the dialog, or <code>null</code> if none.
		 * @param defaultName
		 *            The default name that will be used if the user selects 'OK' without typing anything.
		 * @return If the user selected 'OK', this returns the name that was specified by the user or an empty String if
		 *         the user did not specify anything; if the user selected 'Abort', this returns an empty optional.
		 */
		public static Optional<String> open(Shell parentShell, String defaultName) {

			TransformationModelNameDialog dialog = new TransformationModelNameDialog(parentShell, defaultName);
			return Optional.ofNullable(dialog.open() == 0 ? dialog.getResult() : null);
		}
	}
}
