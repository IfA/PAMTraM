/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
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
package de.mfreund.gentrans.transformation.matching.dependencies;

import java.util.List;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.source.SourceSection;

/**
 * A {@link MatchingDependency} that represents a dependency concerning the {@link SourceSection#getContainer()
 * container} specification of a {@link SourceSection}.
 *
 * @author mfreund
 */
public class ContainerDependency extends MatchingDependency {

	/**
	 * Resolves this dependency by setting the
	 * {@link MatchedSectionDescriptor#setContainerDescriptor(MatchedSectionDescriptor) containerDescriptor} of the
	 * {@link #getDependencySource() dependencySource}.
	 */
	@Override
	public boolean resolve(List<MatchedSectionDescriptor> resolvedBy) {

		boolean ret = false;

		if (this.sourceModelElements.size() == resolvedBy.size()) {
			ret = super.resolve(resolvedBy);
		}

		if (ret) {
			this.getDependencySource().setContainerDescriptor(resolvedBy.get(0));
		}

		return ret;

	}

	@Override
	public boolean isOptional() {

		return false;
	}

}
