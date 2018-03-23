/*******************************************************************************
 * Copyright (C) 2015-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.transformation;

import java.util.Optional;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.progress.UIJob;

import de.mfreund.gentrans.transformation.core.TransformationTaskRunner;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.ui.Activator;
import de.mfreund.gentrans.transformation.ui.util.MonitorWrapper;
import de.tud.et.ifa.agtele.resources.ResourceHelper;
import de.tud.et.ifa.agtele.ui.util.UIHelper;

/**
 * A {@link GenericTransformationRunner} that uses an {@link IProgressMonitor} to inform the user about the progress of
 * the transformation.
 * <p />
 * Note: Instances need to be created via a {@link TransformationRunnerFactory}.
 *
 * @author mfreund
 */
public class GenericTransformationRunnerWithUI extends GenericTransformationRunner {

	/**
	 * The {@link IProgressMonitor} that shall be used to visualize the progress of the transformation.
	 * <p />
	 * Instead of directly storing an {@link IProgressMonitor}, we make use of a {@link MonitorWrapper} so that we are
	 * not dependent on an actual monitor to be present.
	 */
	protected MonitorWrapper monitor;

	/**
	 * This creates an instance based on the given {@link TransformationTaskRunner}.
	 * <p />
	 * Note: This will use the given {@link Logger} implementation to print log messages.
	 *
	 * @param taskRunner
	 *            The {@link TransformationTaskRunner} that shall be used to executed the main tasks of the
	 *            transformation.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param monitor
	 *            An optional {@link IProgressMonitor} that shall be used to inform the user about the progress of the
	 *            transformation.
	 */
	public GenericTransformationRunnerWithUI(TransformationTaskRunner taskRunner, Logger logger,
			Optional<IProgressMonitor> monitor) {

		super(taskRunner, logger);
		this.monitor = new MonitorWrapper(monitor);
	}

	/**
	 * This performs the actual generic transformation. It loads all necessary models, executes the mappings defined in
	 * the PAMTraM model, stores the generated target model and - if necessary - opens the (first of the) generated
	 * model(s). All progress is reported to the given '<em>monitor</em>'.
	 *
	 * @see GenericTransformationRunner#run()
	 *
	 * @return A {@link ITransformationRunner.TransformationResult} indicating the result of the run.
	 */
	@Override
	public TransformationResult doRun() {

		this.monitor.beginTask("Executing Generic Transformation", 700);

		TransformationResult result = super.doRun();

		if (this.taskRunner.getTransformationConfig().isOpenTargetModelOnCompletion()) {

			result.getTargetModelRegistry().ifPresent(this::openGeneratedTargetModel);
		}

		this.monitor.done();

		return result;

	}

	/**
	 * Open the first of the generated models present in the given {@link TargetModelRegistry}.
	 *
	 * @param targetModelRegistry
	 *            The {@link TargetModelRegistry} holding all generated models.
	 */
	protected void openGeneratedTargetModel(TargetModelRegistry targetModelRegistry) {

		if (targetModelRegistry.isEmpty()) {
			// Nothing to open
			//
			return;
		}

		// Determine the URI of the (first of the) generated target model(s)
		//
		String targetModelToOpen = targetModelRegistry.getTargetModels().keySet().iterator().next();
		final URI targetModelToOpenUri = ResourceHelper.getURIForPathString(
				GenericTransformationRunnerWithUI.this.taskRunner.getTransformationConfig().getTargetBasePath()
						+ Path.SEPARATOR + targetModelToOpen);

		// Open the target model. We need to use a 'UIJob' because the transformation was
		// (probably) not run as part of a UIJob so that we have no direct access to the UI thread.
		//
		new UIJob("Open Generated Target Model") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {

				try {
					UIHelper.openEditor(ResourceHelper.getFileForURI(targetModelToOpenUri));
				} catch (PartInitException e) {
					Activator.log(Status.ERROR, e);
					return Status.CANCEL_STATUS;
				}

				return Status.OK_STATUS;
			}
		}.schedule();
	}
}
