/**
 *
 */
package de.mfreund.gentrans.transformation.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import de.mfreund.gentrans.transformation.BaseTransformationConfiguration;
import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.mfreund.gentrans.transformation.GenericTransformationRunnerFactory;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.pamtram.transformation.Transformation;
import pamtram.PAMTraM;
import pamtram.structure.target.FileAttribute;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Job for running the GenTrans outside of the Eclipse UI Thread. The
 *          GenericTransformationRunner object is exposed so it can be
 *          configured.
 */
public class GenericTransformationJob extends Job {

	final GenericTransformationRunner genTransRunner;

	/**
	 * Create a new GenericTransformationJob with the given 'jobName'.
	 *
	 * @param jobName
	 *            The name of the transformation job to be created.
	 * @param sourceFilePath
	 *            A file path pointing to the single source model to be
	 *            transformed.
	 * @param pamtramPath
	 *            A file path pointing to the {@link PAMTraM} model to be
	 *            transformed.
	 * @param targetBasePath
	 *            File path relative to that all target models will be created.
	 * @param defaultTargetModel
	 *            File path of the <em>default</em> target model (relative to
	 *            the given '<em>targetBasePath</em>'). The default target model
	 *            is that target model to which all contents will be added that
	 *            are not associated with a special model via the
	 *            {@link FileAttribute}. If this is '<em>null</em>',
	 *            '<em>out.xmi</em>' will be used as default value.
	 * @param transformationModelPath
	 *            This is the file path where an instance of
	 *            {@link Transformation} that contains information about the
	 *            execution will be stored after the transformation. If this is
	 *            set to '<em>null</em>', the transformation model will not be
	 *            stored.
	 * @param libPaths
	 *            The list of paths to the libraries to be used to retrieve the
	 *            LibraryEntry.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} that shall be used to
	 *            resolve ambiguities that arise during the execution of the
	 *            transformation. If this is '<em>null</em>', the
	 *            {@link DefaultAmbiguityResolvingStrategy} will be used.
	 * @param maxPathLength
	 * @param rememberAmbiguousMappingChoice
	 * @param logLevel
	 *            The minimum {@link Level} a logged messages must represent to
	 *            be printed to the user. Use {@link Level#ALL} to ensure
	 *            logging of all messages and {@link Level#OFF} to prevent any
	 *            logging.s
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the
	 *            transformation that might lead to the fact that the
	 *            transformation result (especially the order of lists) varies
	 *            between executions.
	 */
	public GenericTransformationJob(final String jobName, final String sourceFilePath, final String pamtramPath,
			final String targetBasePath, final String defaultTargetModel, final String transformationModelPath,
			List<String> libPaths, final IAmbiguityResolvingStrategy ambiguityResolvingStrategy, int maxPathLength,
			boolean rememberAmbiguousMappingChoice, Level logLevel, boolean useParallelization) {

		super(jobName);

		BaseTransformationConfiguration baseConfig = new BaseTransformationConfiguration()
				.withAmbiguityResolvingStrategy(ambiguityResolvingStrategy).withDefaultTargetModel(defaultTargetModel)
				.withTransformationModelPath(transformationModelPath).withMaxPathLength(maxPathLength)
				.withOnlyAskOnceOnAmbiguousMappings(rememberAmbiguousMappingChoice).withLibPaths(libPaths)
				.withLogLevel(logLevel).withUseParallelization(useParallelization);

		this.genTransRunner = GenericTransformationRunnerFactory.eINSTANCE.createInstanceFromSourcePaths(
				new HashSet<>(Arrays.asList(sourceFilePath)), new HashSet<>(Arrays.asList(pamtramPath)), targetBasePath,
				baseConfig);

		this.setPriority(Job.BUILD);

	}

	/**
	 * Create a new GenericTransformationJob with the given 'jobName'.
	 *
	 * @param jobName
	 *            The name of the transformation job to be created.
	 * @param sourceFilePaths
	 *            A list of file paths pointing to the source models to be
	 *            transformed.
	 * @param pamtramPath
	 *            A file path pointing to the {@link PAMTraM} model to be
	 *            transformed.
	 * @param targetBasePath
	 *            File path relative to that all target models will be created.
	 * @param defaultTargetModel
	 *            File path of the <em>default</em> target model (relative to
	 *            the given '<em>targetBasePath</em>'). The default target model
	 *            is that target model to which all contents will be added that
	 *            are not associated with a special model via the
	 *            {@link FileAttribute}. If this is '<em>null</em>',
	 *            '<em>out.xmi</em>' will be used as default value.
	 * @param transformationModelPath
	 *            This is the file path where an instance of
	 *            {@link Transformation} that contains information about the
	 *            execution will be stored after the transformation. If this is
	 *            set to '<em>null</em>', the transformation model will not be
	 *            stored.
	 * @param libPaths
	 *            The list of paths to the libraries to be used to retrieve the
	 *            LibraryEntry.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} that shall be used to
	 *            resolve ambiguities that arise during the execution of the
	 *            transformation. If this is '<em>null</em>', the
	 *            {@link DefaultAmbiguityResolvingStrategy} will be used.
	 * @param maxPathLength
	 *            Maximum length for connection paths in the 'joining' step; If
	 *            this is set to less than zero 0, it means that the maximum
	 *            length is unbounded.
	 * @param rememberAmbiguousMappingChoice
	 *            Determines whether the user should be asked every time an
	 *            ambiguous mapping was detected, or if we should reuse user
	 *            decisions.
	 * @param logLevel
	 *            The minimum {@link Level} a logged messages must represent to
	 *            be printed to the user. Use {@link Level#ALL} to ensure
	 *            logging of all messages and {@link Level#OFF} to prevent any
	 *            logging.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the
	 *            transformation that might lead to the fact that the
	 *            transformation result (especially the order of lists) varies
	 *            between executions.
	 */
	public GenericTransformationJob(final String jobName, Set<String> sourceFilePaths, String pamtramPath,
			String targetBasePath, String defaultTargetModel, String transformationModelPath, List<String> libPaths,
			IAmbiguityResolvingStrategy ambiguityResolvingStrategy, int maxPathLength,
			boolean rememberAmbiguousMappingChoice, Level logLevel, boolean useParallelization) {

		super(jobName);

		BaseTransformationConfiguration baseConfig = new BaseTransformationConfiguration()
				.withAmbiguityResolvingStrategy(ambiguityResolvingStrategy).withDefaultTargetModel(defaultTargetModel)
				.withTransformationModelPath(transformationModelPath).withMaxPathLength(maxPathLength)
				.withOnlyAskOnceOnAmbiguousMappings(rememberAmbiguousMappingChoice).withLibPaths(libPaths)
				.withLogLevel(logLevel).withUseParallelization(useParallelization);

		this.genTransRunner = GenericTransformationRunnerFactory.eINSTANCE.createInstanceFromSourcePaths(
				sourceFilePaths, new HashSet<>(Arrays.asList(pamtramPath)), targetBasePath, baseConfig);
		this.setPriority(Job.BUILD);
	}

	/**
	 * Create a new GenericTransformationJob with the given 'jobName'.
	 *
	 * @param jobName
	 *            The name of the transformation job to be created.
	 * @param sourceFilePaths
	 *            A list of file paths pointing to the source models to be
	 *            transformed.
	 * @param pamtramPaths
	 *            A file path pointing to the {@link PAMTraM} model to be
	 *            transformed.
	 * @param targetBasePath
	 *            File path relative to that all target models will be created.
	 * @param defaultTargetModel
	 *            File path of the <em>default</em> target model (relative to
	 *            the given '<em>targetBasePath</em>'). The default target model
	 *            is that target model to which all contents will be added that
	 *            are not associated with a special model via the
	 *            {@link FileAttribute}. If this is '<em>null</em>',
	 *            '<em>out.xmi</em>' will be used as default value.
	 * @param transformationModelPath
	 *            This is the file path where an instance of
	 *            {@link Transformation} that contains information about the
	 *            execution will be stored after the transformation. If this is
	 *            set to '<em>null</em>', the transformation model will not be
	 *            stored.
	 * @param libPaths
	 *            The list of paths to the libraries to be used to retrieve the
	 *            LibraryEntry.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} that shall be used to
	 *            resolve ambiguities that arise during the execution of the
	 *            transformation. If this is '<em>null</em>', the
	 *            {@link DefaultAmbiguityResolvingStrategy} will be used.
	 * @param maxPathLength
	 *            Maximum length for connection paths in the 'joining' step; If
	 *            this is set to less than zero 0, it means that the maximum
	 *            length is unbounded.
	 * @param rememberAmbiguousMappingChoice
	 *            Determines whether the user should be asked every time an
	 *            ambiguous mapping was detected, or if we should reuse user
	 *            decisions.
	 * @param logLevel
	 *            The minimum {@link Level} a logged messages must represent to
	 *            be printed to the user. Use {@link Level#ALL} to ensure
	 *            logging of all messages and {@link Level#OFF} to prevent any
	 *            logging.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the
	 *            transformation that might lead to the fact that the
	 *            transformation result (especially the order of lists) varies
	 *            between executions.
	 */
	public GenericTransformationJob(final String jobName, Set<String> sourceFilePaths, Set<String> pamtramPaths,
			String targetBasePath, String defaultTargetModel, String transformationModelPath, List<String> libPaths,
			IAmbiguityResolvingStrategy ambiguityResolvingStrategy, int maxPathLength,
			boolean rememberAmbiguousMappingChoice, Level logLevel, boolean useParallelization) {

		super(jobName);

		BaseTransformationConfiguration baseConfig = new BaseTransformationConfiguration()
				.withAmbiguityResolvingStrategy(ambiguityResolvingStrategy).withDefaultTargetModel(defaultTargetModel)
				.withTransformationModelPath(transformationModelPath).withMaxPathLength(maxPathLength)
				.withOnlyAskOnceOnAmbiguousMappings(rememberAmbiguousMappingChoice)
				.withLibPaths(new ArrayList<>(libPaths)).withLogLevel(logLevel)
				.withUseParallelization(useParallelization);

		this.genTransRunner = GenericTransformationRunnerFactory.eINSTANCE
				.createInstanceFromSourcePaths(sourceFilePaths, pamtramPaths, targetBasePath, baseConfig);
		this.setPriority(Job.BUILD);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.jobs.Job#canceling()
	 */
	@Override
	protected void canceling() {

		this.genTransRunner.cancel();
		super.canceling();
	}

	/**
	 * @return the genTransRunner
	 */
	public GenericTransformationRunner getGenTransRunner() {

		return this.genTransRunner;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {

		try {
			// perform the transformation
			this.genTransRunner.runTransformation(monitor);
			return org.eclipse.core.runtime.Status.OK_STATUS;

		} catch (final Exception e) {
			e.printStackTrace(System.out);
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
	}

}
