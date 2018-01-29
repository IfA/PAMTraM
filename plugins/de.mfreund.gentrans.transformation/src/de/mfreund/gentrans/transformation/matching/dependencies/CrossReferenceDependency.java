/**
 *
 */
package de.mfreund.gentrans.transformation.matching.dependencies;

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
}