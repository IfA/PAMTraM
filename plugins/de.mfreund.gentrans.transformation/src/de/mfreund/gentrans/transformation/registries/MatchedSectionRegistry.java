/**
 *
 */
package de.mfreund.gentrans.transformation.registries;

import java.util.LinkedHashMap;
import java.util.List;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.source.SourceSection;

/**
 * This class represents a registry for the various source model snippets that are matched against {@link SourceSection
 * SourceSections} during a transformation.
 *
 * @author mfreund
 */
public class MatchedSectionRegistry extends LinkedHashMap<SourceSection, List<MatchedSectionDescriptor>> {

	/**
	 *
	 */
	private static final long serialVersionUID = -3886366599486668256L;

}
