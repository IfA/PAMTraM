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

		boolean ret = super.resolve(resolvedBy);

		if (ret) {
			this.getDependencySource().setContainerDescriptor(resolvedBy.get(0));
		}

		return ret;

	}

}