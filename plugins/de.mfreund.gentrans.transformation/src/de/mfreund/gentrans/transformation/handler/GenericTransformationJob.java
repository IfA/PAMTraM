/**
 *
 */
package de.mfreund.gentrans.transformation.handler;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.pamtram.transformation.Transformation;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import pamtram.PAMTraM;

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
	 * @param jobName The name of the transformation job to be created.
	 * @param sourceFilePath A file path pointing to the single source model to be transformed.
	 * @param pamtramPath A file path pointing to the {@link PAMTraM} model to be transformed.
	 * @param targetFilePath A file path denoting the location where the target model created by the transformation shall be stored.
	 * @param transformationModelPath
	 * 				This is the file path where an instance of {@link Transformation} that contains information
	 * about the execution will be stored after the transformation.
	 * If this is set to '<em>null</em>', the transformation model will not be stored.
	 * @param targetLibraryContextDescriptor The descriptor for the target library context to be used during the transformation.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation. If this is '<em>null</em>', the 
	 * {@link DefaultAmbiguityResolvingStrategy} will be used.
	 */
	public GenericTransformationJob(final String jobName,
			final String sourceFilePath, final String pamtramPath,
			final String targetFilePath, final String transformationModelPath,
			final LibraryContextDescriptor targetLibraryContextDescriptor,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		super(jobName);
		ArrayList<String> sourceFilePaths = new ArrayList<>();
		sourceFilePaths.add(sourceFilePath);
		genTransRunner = GenericTransformationRunner.createInstanceFromSourcePaths(sourceFilePaths,
				pamtramPath, targetFilePath, targetLibraryContextDescriptor, ambiguityResolvingStrategy);
		genTransRunner.setTransformationModelPath(transformationModelPath);
		setPriority(Job.BUILD);

	}

	/**
	 * Create a new GenericTransformationJob with the given 'jobName'.
	 * 
	 * @param jobName The name of the transformation job to be created.
	 * @param sourceFilePaths A list of file paths pointing to the source models to be transformed.
	 * @param pamtramPath A file path pointing to the {@link PAMTraM} model to be transformed.
	 * @param targetFilePath A file path denoting the location where the target model created by the transformation shall be stored.
	 * @param transformationModelPath
	 * 				This is the file path where an instance of {@link Transformation} that contains information
	 * about the execution will be stored after the transformation.
	 * If this is set to '<em>null</em>', the transformation model will not be stored.
	 * @param targetLibraryContextDescriptor The descriptor for the target library context to be used during the transformation.
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation. If this is '<em>null</em>', the 
	 * {@link DefaultAmbiguityResolvingStrategy} will be used.
	 */
	public GenericTransformationJob(final String jobName,
			final ArrayList<String> sourceFilePaths, final String pamtramPath,
			final String targetFilePath, final String transformationModelPath, 
			final LibraryContextDescriptor targetLibraryContextDescriptor,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {
		super(jobName);
		genTransRunner = GenericTransformationRunner.createInstanceFromSourcePaths(sourceFilePaths,
				pamtramPath, targetFilePath, targetLibraryContextDescriptor, ambiguityResolvingStrategy);
		genTransRunner.setTransformationModelPath(transformationModelPath);
		setPriority(Job.BUILD);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.jobs.Job#canceling()
	 */
	@Override
	protected void canceling() {
		genTransRunner.cancel();
		super.canceling();
	}

	/**
	 * @return the genTransRunner
	 */
	public GenericTransformationRunner getGenTransRunner() {
		return genTransRunner;
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
			genTransRunner.runTransformation(monitor);
			return org.eclipse.core.runtime.Status.OK_STATUS;

		} catch (final Exception e) {
			e.printStackTrace(System.out);
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
	}

}
