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
	 * @param jobName
	 * @param sourceModel
	 * @param pamtramPath
	 * @param targetFilePath
	 * @param maxPathlength
	 */
	public GenericTransformationJob(String jobName, EObject sourceModel,
			String pamtramPath, String targetFilePath, int maxPathlength) {
		super(jobName);
		genTransRunner=new GenericTransformationRunner(sourceModel, pamtramPath, targetFilePath,maxPathlength);
	}
	
	/**
	 * @param jobName
	 * @param sourceModel
	 * @param pamtramPath
	 * @param targetFilePath
	 */
	public GenericTransformationJob(String jobName , EObject sourceModel,
			String pamtramPath, String targetFilePath){
		this(jobName,sourceModel,pamtramPath,targetFilePath,-1);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try{
			// perform the transformation
			genTransRunner.runTransformation();
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
