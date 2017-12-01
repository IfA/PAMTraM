/**
 *
 */
package de.mfreund.gentrans.transformation.registries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class represents a registry for the various source model snippets that are matched against {@link SourceSection
 * SourceSections} during a transformation.
 * <p />
 * Note: The map used internally to represent the registry as well as all relevant operations are
 * {@link Collections#synchronizedMap(Map) synchronized} (thread-safe). Consequently, it is safe to operate on this
 * registry e.g. by means of a parallel stream.
 *
 * @author mfreund
 */
public class MatchedSectionRegistry {

	/**
	 * The map realizing the actual registry.
	 */
	protected Map<SourceSection, List<MatchedSectionDescriptor>> internalRegistry;

	/**
	 * The {@link Logger} that shall be used to log messages.
	 */
	protected Logger logger;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public MatchedSectionRegistry(TransformationAssetManager assetManager) {

		this.logger = assetManager.getLogger();

		this.internalRegistry = Collections.synchronizedMap(new LinkedHashMap<>());

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
	public synchronized Optional<MatchedSectionDescriptor> getMatchedSectionDescriptorFor(EObject element,
			SourceSection sourceSection) {

		return element == null || sourceSection == null || !this.internalRegistry.containsKey(sourceSection)
				? Optional.empty()
				: this.internalRegistry.get(sourceSection).parallelStream()
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
	public synchronized boolean contains(EObject element, SourceSection sourceSection) {

		return this.getMatchedSectionDescriptorFor(element, sourceSection).isPresent();
	}

	/**
	 * Whether anything is registered in this registry for the given {@link SourceSection}.
	 *
	 * @param sourceSection
	 *            The {@link SourceSection} to check.
	 * @return '<em>true</em>' if this registry already contains the given {@link SourceSection}; '<em>false</em>'
	 *         otherwise.
	 */
	public synchronized boolean containsKey(SourceSection sourceSection) {

		return this.internalRegistry.containsKey(sourceSection);
	}

	/**
	 * Returns the set of {@link SourceSection SourceSections} registered in this registry.
	 *
	 * @return The set of {@link SourceSection SourceSections} registered in this registry.
	 */
	public synchronized Set<SourceSection> keySet() {

		return this.internalRegistry.keySet();
	}

	/**
	 * Return the {@link MatchedSectionDescriptor MatchedSectionDescriptors} registered in this registry for the given
	 * {@link SourceSection}.
	 *
	 * @param sourceSection
	 *            The {@link SourceSection} to check.
	 * @return The registered {@link MatchedSectionDescriptor MatchedSectionDescriptors} or an empty list if nothing is
	 *         registered.
	 */
	public synchronized List<MatchedSectionDescriptor> get(SourceSection sourceSection) {

		return this.containsKey(sourceSection) ? new ArrayList<>(this.internalRegistry.get(sourceSection))
				: new ArrayList<>();
	}

	/**
	 * Check if the given {@link EObject source model element} is registered in this registry.
	 *
	 * @param element
	 *            The {@link EObject} to check.
	 * @return '<em>true</em>' if this registry already contains a {@link MatchedSectionDescriptor} representing the
	 *         given {@link EObject}; '<em>false</em>' otherwise.
	 */
	public synchronized boolean contains(EObject element) {

		return this.internalRegistry.values().parallelStream().flatMap(List::stream)
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
	public synchronized boolean contains(MatchedSectionDescriptor descriptor) {

		return descriptor == null ? false
				: this.internalRegistry.values().parallelStream().flatMap(List::stream).anyMatch(d -> d == descriptor);
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
	public synchronized boolean register(MatchedSectionDescriptor descriptor) {

		SourceSectionClass section = descriptor.getAssociatedSourceSectionClass();

		if (!(section instanceof SourceSection)) {
			this.logger.severe(() -> "Internal Error: Unable to register the MatchedSectionDescriptor '" + descriptor
					+ "' as it does not represent a SourceSection!");
			return false;
		}

		List<MatchedSectionDescriptor> descriptors = this.internalRegistry.containsKey(section)
				? this.internalRegistry.get(section)
				: new ArrayList<>();

		if (descriptors.contains(descriptor)) {
			return false;
		}

		descriptors.add(descriptor);
		this.internalRegistry.put((SourceSection) section, descriptors);

		return true;
	}
}
