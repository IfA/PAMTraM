/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.registries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;

/**
 * This class represents a registry for the various source model snippets that are matched against {@link SourceSection
 * SourceSections} during a transformation.
 * <p />
 * Note: Each {@link EObject} may be registered to a registry only once, i.e. as part of only one
 * {@link MatchedSectionDescriptor}!
 * <p />
 * Note: The map used internally to represent the registry as well as all relevant operations are
 * {@link Collections#synchronizedMap(Map) synchronized} (thread-safe). Consequently, it is safe to operate on this
 * registry e.g. by means of a parallel stream.
 *
 * @author mfreund
 */
public class MatchedSectionRegistry {

	/**
	 * The {@link TransformationAssetManager} providing access to the various other assets used in the current
	 * transformation instance.
	 */
	protected TransformationAssetManager assetManager;

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

		this.assetManager = assetManager;
		this.logger = assetManager.getLogger();

		this.internalRegistry = Collections.synchronizedMap(new LinkedHashMap<>());

	}

	/**
	 * Return all {@link MatchedSectionDescriptor MatchedSectionDescriptors} that are registered in this registry.
	 *
	 * @return The registered {@link MatchedSectionDescriptor MatchedSectionDescriptors}.
	 */
	public synchronized List<MatchedSectionDescriptor> getRegisteredDescriptors() {

		return this.internalRegistry.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
	}

	/**
	 * Returns a map relating each of the {@link EObject elements} registered as
	 * {@link MatchedSectionDescriptor#getAssociatedSourceModelElement() associatedSourceModelElement} of a descriptor
	 * to the {@link MatchedSectionDescriptor} they are registered against.
	 *
	 * @return The registered {@link EObject elements} related to their {@link MatchedSectionDescriptor}.
	 */
	public synchronized Map<EObject, MatchedSectionDescriptor> getRegisteredDescriptorByAssociatedSourceModelElementMap() {

		return this.getRegisteredDescriptors().parallelStream()
				.collect(Collectors.toMap(MatchedSectionDescriptor::getAssociatedSourceModelElement,
						Function.identity(), (d1, d2) -> d2, HashMap::new));
	}

	/**
	 * Return all {@link MatchedSectionDescriptor MatchedSectionDescriptors} that are registered in this registry.
	 *
	 * @return The registered {@link MatchedSectionDescriptor MatchedSectionDescriptors}.
	 */
	public synchronized List<EObject> getRegisteredElements() {

		return this.getRegisteredDescriptors().stream().flatMap(d -> d.getMatchedSourceModelObjectFlat(false).stream())
				.collect(Collectors.toList());
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
	public synchronized Optional<MatchedSectionDescriptor> getRegisteredDescriptorFor(EObject element,
			SourceSection sourceSection) {

		return element == null || sourceSection == null || !this.internalRegistry.containsKey(sourceSection)
				? Optional.empty()
				: this.internalRegistry.get(sourceSection).parallelStream()
						.filter(msd -> msd.getMatchedSourceModelObjectFlat(false).contains(element)).findAny();
	}

	/**
	 * Return the one {@link MatchedSectionDescriptor} registered in this registry that represents the given
	 * {@link EObject source model element} and {@link SourceSection}.
	 *
	 * @param element
	 *            The {@link EObject} for that a {@link MatchedSectionDescriptor} shall be returned.
	 * @return The {@link MatchedSectionDescriptor} representing the <em>element</em>.
	 */
	public synchronized Optional<MatchedSectionDescriptor> getRegisteredDescriptorFor(EObject element) {

		return element == null ? Optional.empty()
				: this.getRegisteredDescriptors().parallelStream()
						.filter(msd -> msd.getMatchedSourceModelObjectFlat(false).contains(element)).findAny();
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

		return this.getRegisteredDescriptorFor(element, sourceSection).isPresent();
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
				.anyMatch(msd -> msd.getMatchedSourceModelObjectFlat(false).contains(element));
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
	 * <p />
	 * Note: Each {@link EObject} may be registered to a registry only once, i.e. as part of only one
	 * {@link MatchedSectionDescriptor}!
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} to register.
	 * @return '<em>true</em>' if the descriptor was successfully registered (or if it was registered before);
	 *         '<em>false</em>' if the registry already contained the descriptor or one of its elements or if the
	 *         {@link MatchedSectionDescriptor#getAssociatedSourceSection() associated SourceSectionClass} was not a
	 *         {@link SourceSectionClass}.
	 */
	public synchronized boolean register(MatchedSectionDescriptor descriptor) {

		SourceSectionClass section = descriptor.getAssociatedSourceSection();

		if (!(section instanceof SourceSection)) {
			this.logger.severe(() -> "Internal Error: Unable to register the MatchedSectionDescriptor '" + descriptor
					+ "' as it does not represent a SourceSection!");
			return false;
		}

		if (this.get(descriptor.getAssociatedSourceSection()).contains(descriptor)) {
			// The descriptor was already registered
			//
			return true;
		}

		if (descriptor.getMatchedSourceModelObjectFlat(false).stream().anyMatch(this::contains)) {

			this.logger.severe(() -> "Internal Error: Unable to register the MatchedSectionDescriptor '" + descriptor
					+ "' as at least one of the represented elements is already registered in this registry!");
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

	/**
	 * Register all {@link MatchedSectionDescriptor descriptors} registered in the given <em>other</em> registry in this
	 * registry.
	 * <p />
	 * Note: {@link MatchedSectionDescriptor descriptors} that are already registered to this registry are simply
	 * skipped.
	 * <p />
	 * Note: Each {@link EObject} may be registered to a registry only once, i.e. as part of only one
	 * {@link MatchedSectionDescriptor}!
	 *
	 * @param otherRegistry
	 *            The {@link MatchedSectionRegistry} to register.
	 * @return A list of descriptors that could not be registered because {@link #register(MatchedSectionDescriptor)}
	 *         returned '<em>false</em>'.
	 */
	public synchronized List<MatchedSectionDescriptor> register(MatchedSectionRegistry otherRegistry) {

		List<MatchedSectionDescriptor> descriptorsToRegister = otherRegistry.getRegisteredDescriptors();
		List<MatchedSectionDescriptor> failedDescriptors = new ArrayList<>();

		for (MatchedSectionDescriptor descriptorToRegister : descriptorsToRegister) {
			if (!this.register(descriptorToRegister)) {
				failedDescriptors.add(descriptorToRegister);
			}
		}

		return failedDescriptors;
	}

	/**
	 * Create a clone of this {@link MatchedSectionRegistry registry} that operates on the same {@link #assetManager}
	 * and a clone of the {@link #internalRegistry}.
	 */
	@Override
	public MatchedSectionRegistry clone() {

		MatchedSectionRegistry clone = new MatchedSectionRegistry(this.assetManager);
		clone.register(this);
		return clone;
	}

}
