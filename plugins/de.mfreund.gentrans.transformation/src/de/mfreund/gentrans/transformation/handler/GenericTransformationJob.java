/**
 *
 */
package de.mfreund.gentrans.transformation.handler;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

import de.mfreund.gentrans.transformation.GenericTransformationRunner;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;

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
	 * @param jobName
	 * @param sourceFilePath
	 * @param pamtramPath
	 * @param targetFilePath
	 * @param targetLibraryContextDescriptor
	 */
	public GenericTransformationJob(final String jobName,
			final String sourceFilePath, final String pamtramPath,
			final String targetFilePath, final LibraryContextDescriptor targetLibraryContextDescriptor) {
		super(jobName);
		genTransRunner = new GenericTransformationRunner(sourceFilePath,
				pamtramPath, targetFilePath, targetLibraryContextDescriptor);
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
