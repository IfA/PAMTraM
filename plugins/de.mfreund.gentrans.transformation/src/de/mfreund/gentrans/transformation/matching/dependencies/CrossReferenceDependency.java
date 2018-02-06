/**
 *
 */
package de.mfreund.gentrans.transformation.matching.dependencies;

import java.util.List;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.SourceSectionReference;

/**
 * A {@link MatchingDependency} that represents a dependency concerning the values of a specified
 * {@link SourceSectionCrossReference}.
 *
 * @author mfreund
 */
public class CrossReferenceDependency extends MatchingDependency {

	/**
	 * The {@link CrossReference} that this represents.
	 */
	protected CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> reference;

	/**
	 * @return the {@link #reference}
	 */
	public CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> getReference() {

		return this.reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(
			CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> reference) {

		this.reference = reference;
	}

	/**
	 * Resolves this dependency by updating the {@link MatchedSectionDescriptor#getReferencedDescriptors()
	 * referencedDescriptors} of the {@link #getDependencySource() dependencySource}.
	 */
	@Override
	public boolean resolve(List<MatchedSectionDescriptor> resolvedBy) {

		boolean ret = super.resolve(resolvedBy);

		if (ret) {
			// FIXME 'getDependecySource' does not return the correct descriptor if the dependency is not based on the
			// root element of a source section
			resolvedBy.stream().forEach(d -> this.getDependencySource().addReferencedDescriptor(this.reference, d));
		}

		return ret;

	}
}