/**
 *
 */
package de.mfreund.gentrans.transformation.matching.dependencies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class represents a matching dependency encountered during the <em>matching</em> phase of the transformation.
 * <p />
 * Instances of this class represent a dependency in the way that a {@link SourceSection} can only be matched if one or
 * multiple other {@link EObject source model elements} can be (and are) matched against a certain
 * {@link SourceSectionClass}.
 *
 * @author mfreund
 */
public abstract class MatchingDependency {

	/**
	 * The {@link MatchedSectionDescriptor} that is the source for this dependency, i.e. that is only valid if this
	 * dependency is resolved.
	 */
	protected MatchedSectionDescriptor dependencySource;

	/**
	 * The list of {@link EObject EObjects} that need to be matched for this dependency to be fulfilled.
	 */
	protected List<EObject> sourceModelElements;

	/**
	 * The list of {@link SourceSectionClass SourceSectionClass} one of which all of the {@link #sourceModelElements}
	 * need to be matched against.
	 */
	protected List<SourceSectionClass> sourceSectionClasses;

	/**
	 * @return the {@link #dependencySource}
	 */
	public MatchedSectionDescriptor getDependencySource() {

		return this.dependencySource;
	}

	/**
	 * @param dependencySource
	 *            the dependencySource to set
	 */
	public void setDependencySource(MatchedSectionDescriptor dependencySource) {

		this.dependencySource = dependencySource;
	}

	/**
	 * @return the {@link #sourceModelElements}
	 */
	public List<EObject> getSourceModelElements() {

		return this.sourceModelElements;
	}

	/**
	 * @param sourceModelElements
	 *            the sourceModelElements to set
	 */
	public void setSourceModelElements(List<EObject> sourceModelElements) {

		this.sourceModelElements = sourceModelElements;
	}

	/**
	 * @return the {@link #sourceSectionClasses}
	 */
	public List<SourceSectionClass> getSourceSectionClasses() {

		return this.sourceSectionClasses;
	}

	/**
	 * @param sourceSectionClasses
	 *            the sourceSectionClasses to set
	 */
	public void setSourceSectionClasses(List<SourceSectionClass> sourceSectionClasses) {

		this.sourceSectionClasses = sourceSectionClasses;
	}

}
