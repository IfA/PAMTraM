package de.mfreund.pamtram.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * A nature to denote 'PAMTraM' projects that support library elements as target
 * sections.
 *
 * @author mfreund
 */
public class PamtramLibraryNature implements IProjectNature {

	/**
	 * The pamtram project.
	 */
	private IProject project;

	@Override
	public void configure() throws CoreException {
		// nothing needs to be configured
	}

	@Override
	public void deconfigure() throws CoreException {
		// nothing needs to be deconfigured
	}

	@Override
	public IProject getProject() {
		return this.project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}
}
