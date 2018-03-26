/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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
