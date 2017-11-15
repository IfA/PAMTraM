/**
 *
 */
package de.mfreund.gentrans.transformation.registries;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

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

	/**
	 * The {@link Logger} that shall be used to log messages.
	 */
	protected Logger logger;

	/**
	 * This creates an instance.
	 *
	 * @param logger
	 *            The {@link Logger} that shall be used to log messages.
	 */
	public MatchedSectionRegistry(Logger logger) {

		this.logger = logger;
	}

	/**
	 * Return the one {@link MatchedSectionDescriptor} registered in this registry that represents the given combination
	 * of {@link EObject source model element} and {@link SourceSection}.
	 *
	 * @param element
	 *            The {@link EObject} for that a {@link MatchedSectionDescriptor} shall be returned.
	 * @param sourceSection
	 *            The {@link SourceSection} represented by the {@link MatchedSectionDescriptor} to be returned.
	 * @return The {@link MatchedSectionDescriptor} representing the <em>element</em>.
	 */
	public Optional<MatchedSectionDescriptor> getMatchedSectionDescriptorFor(EObject element,
			SourceSection sourceSection) {

		return element == null || sourceSection == null || !this.containsKey(sourceSection) ? Optional.empty()
				: this.get(sourceSection).parallelStream()
						.filter(msd -> msd.getMatchedSourceModelObjectFlat().contains(element)).findAny();
	}

	/**
	 * Check if the given {@link EObject source model element} is registered in this registry for the given
	 * {@link SourceSection}.
	 *
	 * @param element
	 *            The {@link EObject} to check.
	 * @param sourceSection
	 *            The {@link SourceSection} to check.
	 * @return '<em>true</em>' if this registry already contains a {@link MatchedSectionDescriptor} representing the
	 *         given {@link EObject} for the given {@link SourceSection}; '<em>false</em>' otherwise.
	 */
	public boolean contains(EObject element, SourceSection sourceSection) {

		return element == null ? false : this.getMatchedSectionDescriptorFor(element, sourceSection).isPresent();
	}

	/**
	 * Check if the given {@link EObject source model element} is registered in this registry.
	 *
	 * @param element
	 *            The {@link EObject} to check.
	 * @return '<em>true</em>' if this registry already contains a {@link MatchedSectionDescriptor} representing the
	 *         given {@link EObject}; '<em>false</em>' otherwise.
	 */
	public boolean contains(EObject element) {

		return this.values().parallelStream().flatMap(List::stream)
				.anyMatch(msd -> msd.getMatchedSourceModelObjectFlat().contains(element));
	}

	/**
	 * Check if the given {@link MatchedSectionDescriptor} is registered in this registry.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} to check.
	 * @return '<em>true</em>' if this registry already contains the given {@link MatchedSectionDescriptor};
	 *         '<em>false</em>' otherwise.
	 */
	public boolean contains(MatchedSectionDescriptor descriptor) {

		return descriptor == null ? false
				: this.values().parallelStream().flatMap(List::stream).anyMatch(d -> d == descriptor);
	}

	/**
	 * Register a new {@link MatchedSectionDescriptor} in this registry.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} to register.
	 * @return '<em>true</em>' if the descriptor was successfully registered; '<em>false</em>' if the registry already
	 *         contained the descriptor or if the {@link MatchedSectionDescriptor#getAssociatedSourceSectionClass()
	 *         associated SourceSectionClass} was not a {@link SourceSectionClass}.
	 */
	public boolean register(MatchedSectionDescriptor descriptor) {

		SourceSectionClass section = descriptor.getAssociatedSourceSectionClass();

		if (!(section instanceof SourceSection)) {
			this.logger.severe(() -> "Internal Error: Unable to register the MatchedSectionDescriptor '" + descriptor
					+ "' as it does not represent a SourceSection!");
			return false;
		}

		List<MatchedSectionDescriptor> descriptors = this.containsKey(section) ? this.get(section) : new ArrayList<>();

		if (descriptors.contains(descriptor)) {
			return false;
		}

		descriptors.add(descriptor);
		this.put((SourceSection) section, descriptors);

		return true;
	}
}
