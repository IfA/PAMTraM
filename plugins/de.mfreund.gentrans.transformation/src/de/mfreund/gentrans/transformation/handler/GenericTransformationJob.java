/**
 * 
 */
package de.mfreund.gentrans.transformation.handler;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.GenericTransformationRunner;

/**
 * @author Sascha Steffen
 *
 */
public class GenericTransformationJob extends Job {
	final GenericTransformationRunner genTransRunner;
	/**
	 * @return the genTransRunner
	 */
	public GenericTransformationRunner getGenTransRunner() {
		return genTransRunner;
	}

	/**
	 * @param jobName
	 * @param sourceModel
	 * @param pamtramPath
	 * @param targetFilePath
	 * @param maxPathlength
	 */
	public GenericTransformationJob(String jobName, EObject sourceModel,
			String pamtramPath, String targetFilePath) {
		super(jobName);
		genTransRunner=new GenericTransformationRunner(sourceModel, pamtramPath, targetFilePath);
		setPriority(Job.BUILD);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try{
			// perform the transformation
			genTransRunner.runTransformation(monitor);
			return org.eclipse.core.runtime.Status.OK_STATUS;
			
		} catch (Exception e){
			e.printStackTrace(System.out);
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		} 
	}

	@Override
	protected void canceling() {
		genTransRunner.cancel();
		super.canceling();
	}

}
