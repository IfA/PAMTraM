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
package de.mfreund.gentrans.transformation.matching;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.calculation.ValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.ContainmentTree;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.matching.dependencies.ContainerDependency;
import de.mfreund.gentrans.transformation.matching.dependencies.CrossReferenceDependency;
import de.mfreund.gentrans.transformation.matching.dependencies.MatchingDependency;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import pamtram.DeactivatableElement;
import pamtram.PAMTraM;
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintType;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.util.NullComparator;

/**
 * This class can be used to match a list of {@link EObject source models} against a list of {@link SourceSection
 * SourceSections}.
 *
 * @author mfreund
 */
public class SourceSectionMatcher extends CancelableTransformationAsset {

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the
	 * execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * This {@link ValueConstraintReferenceValueCalculator} will be used for calculating referenceValues that are needed
	 * for {@link ValueConstraint}
	 */
	private ValueConstraintReferenceValueCalculator refValueCalculator;

	/**
	 * The map of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that represents the result of the matching
	 * process.
	 */
	private MatchedSectionRegistry matchedSectionRegistry;

	/**
	 * The {@link ContainmentTree} representing the model elements that are currently matched.
	 */
	private ContainmentTree tree;

	/**
	 * The list of {@link SourceSection SourceSections} that are currently matched.
	 */
	private List<SourceSection> sourceSections;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public SourceSectionMatcher(TransformationAssetManager assetManager) {

		super(assetManager);

		this.ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		this.refValueCalculator = assetManager.getValueConstraintReferenceValueCalculator();
	}

	/**
	 * This iterates through the given list of <em>sourceModels</em> and tries to match each of the {@link SourceSection
	 * SourceSections} defined in the given list of {@link PAMTraM PAMTraM Models} against the elements of the source
	 * models. The result of this process is a list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that
	 * is registered in the {@link MatchedSectionRegistry} of the {@link #assetManager}.
	 * <p />
	 * Note: {@link DeactivatableElement#isDeactivated() Deactivated} SourceSections and SourceSections in deactivated
	 * SourceSectionModels are not considered in the matching process.
	 *
	 * @param sourceModels
	 *            The list of source models (each represented by its root {@link EObject element}) to be matched.
	 * @param pamtramModels
	 *            The list of {@link PAMTraM PAMTraM Models} providing the {@link SourceSection SourceSections} that the
	 *            ' <em>sourceModels</em>' shall be matched against.
	 */
	public void matchSections(List<EObject> sourceModels, List<PAMTraM> pamtramModels) {

		// The SourceSections defined by the active SourceSectionModels that will be matched against the source models
		//
		Set<SourceSection> activeSourceSections = pamtramModels.stream()
				.flatMap(p -> p.getActiveSourceSections().stream())
				.collect(LinkedHashSet<SourceSection>::new, LinkedHashSet::add, LinkedHashSet::addAll);

		this.matchSections(sourceModels, activeSourceSections);
	}

	/**
	 * This iterates through the given list of <em>sourceModels</em> and tries to match each of the given
	 * {@link SourceSection SourceSections} against the elements of the source models. The result of this process is a
	 * list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that is stored in the
	 * {@link MatchedSectionRegistry} of the {@link #assetManager}.
	 * <p />
	 * Note: {@link DeactivatableElement#isDeactivated() Deactivated} SourceSections are not considered in the matching
	 * process.
	 *
	 * @see #matchSections(List, List)
	 *
	 * @param sourceModels
	 *            The list of source models (each represented by its root {@link EObject element}) to be matched.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the ' <em>containmentTree</em>' shall be matched
	 *            against.
	 */
	public void matchSections(List<EObject> sourceModels, Set<SourceSection> sourceSections) {

		// The active SourceSections that will be matched against the source models
		//
		List<SourceSection> activeSourceSections = sourceSections.stream()
				.filter(s -> !s.isAbstract() && !s.isDeactivated()).collect(Collectors.toList());

		this.matchedSectionRegistry = new MatchedSectionRegistry(this.assetManager);
		this.tree = ContainmentTree.build(sourceModels);
		this.sourceSections = activeSourceSections;

		this.matchSections();
	}

	/**
	 * This iterates through the given {@link ContainmentTree} and tries to match each of the given {@link SourceSection
	 * SourceSections} against the elements represented in the tree. The result of this process is a list of
	 * {@link MatchedSectionDescriptor MatchedSectionDescriptors} that is stored in the {@link MatchedSectionRegistry}
	 * of the {@link #assetManager}..
	 *
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the ' <em>containmentTree</em>' shall be matched
	 *            against.
	 */
	private void matchSections() {

		// Determine the potential matches. These may still be ambiguous (multiple matches for one EObject) and can be
		// equipped with MatchingDependencies (as this first step only matches the direct contents of the given Sections
		// and not any CrossReferences to other Sections).
		//
		Map<EObject, List<MatchedSectionDescriptor>> potentialMatches = this.findPotentialApplicableSections();

		// Now that we know each potential match, we need to check the determined 'MatchingDependencies' and resolve
		// ambiguous matches, i.e. select the resulting matches for the next steps of the transformation.
		//
		this.selectApplicableSections(potentialMatches);

		// Finally, register the chosen matches to the 'global' registry of the 'assetManager' associated with this.
		this.registerSectionsToGlobalRegistry();

		this.logger.info(() -> "Summary:\tAvailable Elements:\t" + this.tree.getNumberOfElements());
		this.logger.info(() -> "\t\tMatched Elements:\t" + this.tree.getNumberOfMatchedElements());
		this.logger.info(() -> "\t\tUnmatched Elements:\t" + this.tree.getNumberOfUnmatchedElements());

	}

	/**
	 * For each of the {@link EObject elements} in the {@link #tree}, determine those of the {@link #sourceSections}
	 * that are <em>potentially</em> applicable (can be matched against the element).
	 * <p />
	 * Note: <em>Potentially</em> applicable in this case means that the applicability of a SourceSection may be
	 * {@link MatchingDependency dependent} on the applicability of one or multiple other combinations of elements and
	 * SourceSections: This only checks the applicability of the direct content of the {@link SourceSection} and not the
	 * applicability of any other SourceSections referenced via {@link CrossReference CrossReferences}
	 *
	 * @return A map relating the elements of the source model with a list of potentially applicable
	 *         {@link MatchedSectionDescriptor MatchedSectionDescriptors}. Note: Elements for that no applicable
	 *         {@link MatchedSectionDescriptor MatchedSectionDescriptors} could be determined will be represented in the
	 *         map by means of an empty list of descriptors!
	 */
	private Map<EObject, List<MatchedSectionDescriptor>> findPotentialApplicableSections() {

		return this.tree.getElements().parallelStream().map(
				e -> new AbstractMap.SimpleEntry<>(e, this.findPotentialApplicableSections(e, this.sourceSections)))
				.filter(e -> !e.getValue().isEmpty()).collect(Collectors.toConcurrentMap(Entry::getKey, Entry::getValue,
						(v1, v2) -> v2, ConcurrentHashMap::new));

	}

	/**
	 * Based on the given list of {@link #findPotentialApplicableSections() potentialMatches}, selects those that shall
	 * in deed be applied for the current matching process.
	 * <p />
	 * Therefore, all {@link #checkPotentialDescriptorDependencies(EObject, Map, MatchedSectionRegistry)
	 * potentialDescriptorDependencies} are checked and resolved. If multiple applicable matches remain, one is
	 * {@link #selectSectionToApply(EObject, List) selected}. Last, the selected match (and all related matches) are
	 * registered to the {@link #matchedSectionRegistry}.
	 *
	 * @param potentialMatches
	 *            The result from the {@link #findPotentialApplicableSections() findPotentialApplicableSections} step.
	 */
	private void selectApplicableSections(Map<EObject, List<MatchedSectionDescriptor>> potentialMatches) {

		// As each EObject may only be used for one descriptor, we iterate over the ContainmentTree and make use of its
		// 'getNextElementForMatching' feature that will not return any elements that have already been marked as
		// 'matched'.
		this.tree.restartIteration();
		Optional<EObject> element;

		while ((element = this.tree.getNextElementForMatching()).isPresent()) {

			if (potentialMatches.getOrDefault(element.get(), new ArrayList<>()).isEmpty()) {
				continue;
			}

			// For each of the potential descriptors, check if the matching dependencies can be resolved (recursively).
			// The result is a list of descriptors that are really applicable (for that all dependencies can be
			// resolved) as well as associated registries that represent all descriptors that have to be applied if
			// the associated potential descriptor would be applied.
			//
			Map<MatchedSectionDescriptor, MatchedSectionRegistry> localRegistries = this
					.checkPotentialDescriptorDependencies(element.get(), potentialMatches,
							new MatchedSectionRegistry(this.assetManager));

			if (localRegistries.isEmpty()) {
				// None of the potential descriptors was really applicable
				//
				continue;
			}

			// If there are multiple matches, select the one section to actually apply.
			//
			MatchedSectionDescriptor descriptor = this.selectSectionToApply(element.get(),
					new ArrayList<>(localRegistries.keySet()));

			if (descriptor == null) {
				continue;
			}

			MatchedSectionRegistry selectedLocalRegistry = localRegistries.get(descriptor);

			if (selectedLocalRegistry == null) {
				this.logger.severe(() -> "Internal error while matching the source model element '"
						+ descriptor.getAssociatedSourceModelElement().toString() + "' against the SourceSection '"
						+ descriptor.getAssociatedSourceSection().getName() + "'!");
				continue;
			}

			// Now, register everything that is associated with the chosen descriptor (i.e. everything represented in
			// the 'localRegistry') to the global registry
			//
			List<MatchedSectionDescriptor> failedDescriptors = this.matchedSectionRegistry
					.register(selectedLocalRegistry);

			if (!failedDescriptors.isEmpty()) {
				this.logger.severe(
						() -> "Internal error: Some MatchedSectionDescriptors could not be registered in the global "
								+ "registry! Aborting matching process...");
				break;
			}

			// As all descriptors related to the chosen descriptor are now registered in the global registry, we can
			// also formally resolve all collected MatchingDependencies of these descriptors
			//
			List<MatchingDependency> failedDependencies = selectedLocalRegistry.getRegisteredDescriptors().stream()
					.flatMap(d -> d.resolveMatchingDependencies(this.matchedSectionRegistry).stream())
					.collect(Collectors.toList());

			if (!failedDependencies.isEmpty()) {
				this.logger.severe(() -> "Internal error: Some MatchingDependencies could not be resolved Properly!"
						+ " Aborting matching process...");
				break;
			}

			this.tree.markAsMatched(new HashSet<>(selectedLocalRegistry.getRegisteredElements()));

		}
	}

	/**
	 * This registers all descriptors from the {@link #matchedSectionRegistry} to the '<em>global</em>'
	 * {@link MatchedSectionRegistry} associated with the {@link #assetManager}.
	 *
	 */
	private void registerSectionsToGlobalRegistry() {

		Map<EObject, MatchedSectionDescriptor> descriptorByEObject = this.matchedSectionRegistry
				.getRegisteredDescriptorByAssociatedSourceModelElementMap();

		// Due to parallel processes, the selected descriptors can be registered to the internal
		// 'matchedSectionRegistry' in an arbitrary order. This might be a problem when hint values are extracted
		// because other algorithms may rely on a reproducible order. In order to get such an order, we
		// once again iterate over the containment tree and register the associated descriptors step by step.
		//
		for (EObject element : this.tree.getElements()) {

			MatchedSectionDescriptor descriptor = descriptorByEObject.get(element);
			if (descriptor != null && !this.assetManager.getMatchedSectionRegistry().contains(descriptor)) {
				this.assetManager.getMatchedSectionRegistry().register(descriptor);

				Map<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, List<MatchedSectionDescriptor>> referencedDescriptors = descriptor
						.getReferencedDescriptors();
				for (Entry<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, List<MatchedSectionDescriptor>> ref : referencedDescriptors
						.entrySet()) {
					ref.getValue().sort((d1, d2) -> {
						int i1 = this.tree.getElements().indexOf(d1.getAssociatedSourceModelElement());
						int i2 = this.tree.getElements().indexOf(d2.getAssociatedSourceModelElement());

						return ((Integer) i1).compareTo(i2);
					});

				}
			}
		}
	}

	/**
	 * This determines all {@link SourceSection SourceSections} that are <em> potentially</em> applicable for the given
	 * source model <em>element</em>.
	 * <p />
	 * Note: <em>Potentially</em> applicable in this case means that the applicability of a SourceSection may be
	 * {@link MatchingDependency dependent} on the applicability of one or multiple other combinations of elements and
	 * SourceSections: This only checks the applicability of the direct content of the given {@link SourceSection} and
	 * not the applicability of any other SourceSections referenced via {@link CrossReference CrossReferences}
	 *
	 * @param element
	 *            The {@link EObject element} from the source model for that the applicable {@link SourceSection
	 *            SourceSections} shall be determined.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the <em>element</em> shall be matched against.
	 * @return A list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} representing all
	 *         {@link SourceSection SourceSections} that are applicable for the given {@link EObject} (one descriptor
	 *         per applicable SourceSection).
	 */
	private List<MatchedSectionDescriptor> findPotentialApplicableSections(final EObject element,
			final List<SourceSection> sourceSections) {

		// Iterate over all sections and find those that are applicable for the current 'element'.
		//
		return sourceSections.stream().map(section -> this.isPotentiallyApplicable(section, element))
				.filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());

	}

	/**
	 * If multiple applicable sections have been found for an element of the source model during
	 * {@link #findApplicableSections(EObject)}, one of the sections needs to be selected that shall actually be used.
	 * Therefore, we first select those matched sections that match the most elements. If there are multiple sections
	 * that match the same number of elements, we apply the AmbiguityResolvingStrategy.
	 *
	 * @param element
	 *            The {@link EObject element} of the source model for that we are selecting an applicable section.
	 * @param descriptors
	 *            The descriptors representing the applicable sections.
	 * @return The {@link MatchedSectionDescriptor} representing the selected {@link SourceSection} or '<em>null</em>'
	 *         if no descriptor was selected.
	 */
	private MatchedSectionDescriptor selectSectionToApply(EObject element, List<MatchedSectionDescriptor> descriptors) {

		if (descriptors.isEmpty()) {
			return null;
		} else if (descriptors.size() == 1) {
			return descriptors.get(0);
		}

		// First, we collect those matches that cover the most elements of the
		// source model
		//
		List<MatchedSectionDescriptor> matchesWithMaximumElements = new ArrayList<>();

		int maxMatchedElements = 0;
		for (MatchedSectionDescriptor match : descriptors) {

			Set<EObject> currentMatchedElements = match.getMatchedSourceModelObjectFlat(false);
			if (currentMatchedElements.size() >= maxMatchedElements) {

				if (currentMatchedElements.size() > maxMatchedElements) {
					maxMatchedElements = currentMatchedElements.size();
					matchesWithMaximumElements.clear();
				}

				matchesWithMaximumElements.add(match);
			}
		}

		if (matchesWithMaximumElements.size() == 1) {
			return matchesWithMaximumElements.get(0);
		}

		// As there are multiple elements with the same number of matched
		// elements, we need to select one of those to
		// actually use.
		try {
			this.logger.fine("[Ambiguity] Resolve searching ambiguity...");
			List<MatchedSectionDescriptor> resolved = this.ambiguityResolvingStrategy
					.searchingSelectSection(new ArrayList<>(matchesWithMaximumElements), element);
			if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
				((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
						.searchingSectionSelected(new ArrayList<>(matchesWithMaximumElements), resolved.get(0));
			}
			this.logger.fine("[Ambiguity] ...finished.\n");
			return resolved.get(0);
		} catch (AmbiguityResolvingException e) {
			if (e.getCause() instanceof UserAbortException) {
				throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
			} else {
				this.logger.severe(
						() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a matched section: "
								+ e.getMessage());
				this.logger.severe("Using default section instead...");
				return matchesWithMaximumElements.get(0);
			}
		}
	}

	/**
	 * For each of the {@link MatchedSectionDescriptor descriptors} that are potentially applicable for the given
	 * {@link EObject source model element}, check if the associated
	 * {@link MatchedSectionDescriptor#getMatchingDependencies() MatchingDependencies} can be resolved.
	 * <p />
	 * Note: This check is performed recursively, i.e. not only for each of the given element but also for each of the
	 * elements (resp. the corresponding descriptors) that is determined as resolution for one of the dependencies (and
	 * so on).
	 *
	 * @param element
	 *            The {@link EObject source model element} for which the applicability of the given potential
	 *            descriptors shall be checked.
	 * @param allPotentialMatches
	 *            The potential {@link MatchedSectionDescriptor matches} for each of the elements of the source model.
	 *            This is consulted to get potentially applicable descriptors for the given <em>element</em> as well as
	 *            to determine possible solutions for each dependency.
	 * @param localRegistry
	 *            A {@link MatchedSectionRegistry} containing those {@link MatchedSectionDescriptor descriptors} that
	 *            have already been registered in the current recursive check (this is required to prevent endless
	 *            recursion in case of cyclic cross references between Sections). This may be an empty registry if this
	 *            is called for the root element of a dependency check.
	 * @return A list of {@link MatchedSectionDescriptor descriptors} that are applicable (for that each dependency
	 *         could successfully be resolved) as well as associated {@link MatchedSectionRegistry
	 *         MatchedSectionRegistrys} that represent all descriptors that have to be applied if the associated
	 *         potential descriptor would be applied.
	 */
	private Map<MatchedSectionDescriptor, MatchedSectionRegistry> checkPotentialDescriptorDependencies(EObject element,
			Map<EObject, List<MatchedSectionDescriptor>> allPotentialMatches, MatchedSectionRegistry localRegistry) {

		this.checkCanceled();

		// All of the potential MatchedSectionDescriptors that we need to consider. As we must not only consider those
		// descriptors specifying the given element as their 'associatedSourceModelElement' but also all descriptors
		// that represent the given element further downwards in the containment hierarchy, we cannot simply use the
		// result for 'allPotentialMatches.get(element)'
		//
		List<MatchedSectionDescriptor> potentialDescriptors = allPotentialMatches.values().stream()
				.flatMap(Collection::stream).filter(d -> d.containsSourceModelObject(element, false))
				.collect(Collectors.toList());

		// For each potential descriptors, build the resulting 'local registry' variation, i.e. the collection of
		// snippets that would be matched if the descriptor is used as match
		//
		Map<MatchedSectionDescriptor, MatchedSectionRegistry> localRegistryVariations = new LinkedHashMap<>();

		for (MatchedSectionDescriptor potentialDescriptor : potentialDescriptors) {

			Optional<MatchedSectionRegistry> updatedLocalRegistryClone = this
					.checkPotentialDescriptorDependencies(potentialDescriptor, allPotentialMatches, localRegistry);

			if (updatedLocalRegistryClone.isPresent()) {

				// Everything could be resolved successfully so we store the resulting registry as one possible
				// solution.
				//
				localRegistryVariations.put(potentialDescriptor, updatedLocalRegistryClone.get());
			} else {

				// We can delete the descriptor from the list of potential matches as it is not applicable
				//
				allPotentialMatches.get(element).remove(potentialDescriptor);
			}

		}

		return localRegistryVariations;
	}

	/**
	 * Check if the {@link MatchedSectionDescriptor#getMatchingDependencies() MatchingDependencies} associated with the
	 * given {@link MatchedSectionDescriptor potentialDescriptor} can be resolved.
	 * <p />
	 * Note: This check is performed recursively, i.e. not only for each of the given descriptors but also for each of
	 * the descriptors that is determined as resolution for one of the dependencies (and so on).
	 *
	 * @param potentialDescriptor
	 *            The potential {@link MatchedSectionDescriptor MatchedSectionDescriptors} for that the
	 *            {@link MatchedSectionDescriptor#getMatchingDependencies() dependencies} shall be checked.
	 * @param allPotentialMatches
	 *            The potential {@link MatchedSectionDescriptor matches} for each of the elements of the source model.
	 *            This is consulted to determine possible solutions for each dependency.
	 * @param localRegistry
	 *            A {@link MatchedSectionRegistry} containing those {@link MatchedSectionDescriptor descriptors} that
	 *            have already been registered in the current recursive check (this is required to prevent endless
	 *            recursion in case of cyclic cross references between Sections). This may be an empty registry if this
	 *            is called for the root element of a dependency check.
	 * @return A {@link MatchedSectionRegistry MatchedSectionRegistrys} that represents all descriptors that have to be
	 *         applied if the given {@link MatchedSectionDescriptor potentialDescriptor} would be applied or an empty
	 *         Optional if the given {@link MatchedSectionDescriptor potentialDescriptor} is not applicable.
	 */
	private Optional<MatchedSectionRegistry> checkPotentialDescriptorDependencies(
			MatchedSectionDescriptor potentialDescriptor, Map<EObject, List<MatchedSectionDescriptor>> potentialMatches,
			MatchedSectionRegistry localRegistry) {

		// Check if any of the elements represented by the given potential descriptor is already registered (as part of
		// another descriptor) either in the global or in the local registry. As we must not register elements multiple
		// times, we cannot use the potential descriptor in such cases,
		//
		if (potentialDescriptor.getMatchedSourceModelObjectFlat(false).stream()
				.anyMatch(e -> localRegistry.contains(e) || this.matchedSectionRegistry.contains(e))) {
			return Optional.empty();
		}

		// We need to create a clone of the localRegistry so that we are able to throw away
		// preliminary (assuming) registrations that in later steps of the resolution process turn out to be erroneous
		// (if the registered descriptor turned out to rely on unresolvable dependencies)
		//
		MatchedSectionRegistry localRegistryClone = localRegistry.clone();
		localRegistryClone.register(potentialDescriptor);

		for (MatchingDependency dependency : potentialDescriptor.getMatchingDependencies()) {

			boolean resolved = this.checkDependency(dependency, potentialMatches, localRegistryClone);

			if (!resolved) {
				return Optional.empty();
			}
		}

		return Optional.of(localRegistryClone);
	}

	/**
	 * Check if the given {@link MatchingDependency dependency} can be resolved.
	 * <p />
	 * Note: This check is performed recursively, i.e. not only for the given dependency but also for each of the
	 * dependencies of the descriptors that is determined as resolution this dependency (and so on).
	 * <p />
	 * Note: All descriptors that have to be applied for the given dependency to be resolved are registered to the given
	 * {@link MatchedSectionRegistry}.
	 *
	 * @param dependency
	 *            The {@link MatchingDependency} to check.
	 * @param allPotentialMatches
	 *            The potential {@link MatchedSectionDescriptor matches} for each of the elements of the source model.
	 *            This is consulted to determine possible solutions for the dependency.
	 * @param localRegistry
	 *            A {@link MatchedSectionRegistry} containing those {@link MatchedSectionDescriptor descriptors} that
	 *            have already been registered (this is required to prevent endless recursion in case of cyclic cross
	 *            references between Sections).
	 * @return '<em>true</em>' if the given dependency could be resolved; '<em>false</em> otherwise.
	 */
	private boolean checkDependency(MatchingDependency dependency,
			Map<EObject, List<MatchedSectionDescriptor>> potentialMatches, MatchedSectionRegistry localRegistry) {

		// This will be updated during the course of checking the various 'dependency elements'. If all checks are
		// successful, we will update the given 'local registry' with this.
		//
		MatchedSectionRegistry currentLocalRegistry = localRegistry;

		for (EObject dependencyElement : dependency.getSourceModelElements()) {

			// Check if the element was already registered in the global registry.
			//
			Optional<MatchedSectionDescriptor> globalDescriptor = this.matchedSectionRegistry
					.getRegisteredDescriptorFor(dependencyElement);

			if (globalDescriptor.isPresent()) {

				if (dependency.isOptional()
						|| dependency.getSourceSectionClasses().stream().anyMatch(c -> globalDescriptor.get()
								.getMatchedSourceModelElementsFor(c, false).contains(dependencyElement))) {

					continue;
				} else {

					return false;
				}
			}

			// In order to prevent endless recursion, we need to check if the element was already registered in the
			// given registry.
			//
			Optional<MatchedSectionDescriptor> localDescriptor = currentLocalRegistry
					.getRegisteredDescriptorFor(dependencyElement);

			if (localDescriptor.isPresent()) {

				if (dependency.isOptional()
						|| dependency.getSourceSectionClasses().stream().anyMatch(c -> localDescriptor.get()
								.getMatchedSourceModelElementsFor(c, false).contains(dependencyElement))) {

					continue;
				} else {

					return false;
				}
			}

			// Try to resolve the matching dependencies for each of the potential descriptors. The result is a list of
			// descriptors that are really applicable as well as an associated registry.
			//
			Map<MatchedSectionDescriptor, MatchedSectionRegistry> localRegistries = this
					.checkPotentialDescriptorDependencies(dependencyElement, potentialMatches, currentLocalRegistry);

			// If there are multiple matches, select the one section to actually apply.
			//
			MatchedSectionDescriptor descriptor = this.selectSectionToApply(dependencyElement,
					new ArrayList<>(localRegistries.keySet()));

			if (descriptor != null) {
				currentLocalRegistry = localRegistries.get(descriptor);
			} else if (dependency.isOptional()) {
				continue;
			} else {

				// The dependency could not be resolved for the current element
				//
				return false;
			}

		}

		localRegistry.register(currentLocalRegistry);

		return true;
	}

	/**
	 * This checks if the given {@link SourceSection} is <em> potentially</em> applicable for the given source model
	 * <em>element</em>.
	 * <p />
	 * Note: <em>Potentially</em> applicable in this case means that the applicability of a SourceSection may be
	 * {@link MatchingDependency dependent} on the applicability of one or multiple other combinations of elements and
	 * SourceSections: This only checks the applicability of the direct content of the given {@link SourceSection} and
	 * not the applicability of any other SourceSections referenced via {@link CrossReference CrossReferences}
	 *
	 * @param section
	 *            The {@link SourceSection} to check.
	 * @param element
	 *            The {@link EObject} from the source model for that the applicability of the source section shall be
	 *            determined.
	 * @return A suitable preliminary {@link MatchedSectionDescriptor} if the given {@link SourceSection} is applicable
	 *         for the given {@link EObject} or an empty optional if the given SourceSection was not applicable.
	 */
	private Optional<MatchedSectionDescriptor> isPotentiallyApplicable(SourceSection section, final EObject element) {

		this.checkCanceled();

		if (!section.getEClass().isSuperTypeOf(element.eClass())) {
			return Optional.empty();
		}

		// This is the 'MatchedSectionDescriptor' that we will return in case we find the Section to be applicable
		//
		MatchedSectionDescriptor descriptor = new MatchedSectionDescriptor();
		descriptor.setAssociatedSourceModelElement(element);
		descriptor.setAssociatedSourceSectionClass(section);

		// check if the section itself is applicable
		//
		boolean result = this.checkClass(element, section, descriptor);

		if (result && section.getContainer() != null) {

			if (element.eContainer() == null) {
				return Optional.empty();
			}

			ContainerDependency containerDependency = new ContainerDependency();
			containerDependency.setDependencySource(descriptor);
			containerDependency.setSourceModelElements(Arrays.asList(element.eContainer()));
			containerDependency.setSourceSectionClasses(Arrays.asList(section.getContainer()));
			descriptor.addMatchingDependency(containerDependency);
		}

		return result ? Optional.of(descriptor) : Optional.empty();
	}

	/**
	 * This recursively checks if a {@link SourceSectionClass} and all its direct and indirect contents are applicable
	 * for a certain part of the source model. Therefore, it iterates downward in the containment hierarchy of the
	 * {@link SourceSection} and checks if every element can be matched to a part of the source model.
	 * <p />
	 * For all {@link CrossReference CrossReferences} encountered during the iteration process, a suitable
	 * {@link CrossReferenceDependency} is added to the <em>descriptor</em>.
	 *
	 * @param srcModelObject
	 *            The element of the source model that is currently evaluated for applicability.
	 * @param srcSection
	 *            The {@link SourceSectionClass} (either the sourceMMSection itself or a direct or indirect child of it)
	 *            that is currently checked.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} representing the current matching step.
	 * @return The {@link MatchedSectionDescriptor} representing the matched section (including all matched child
	 *         elements).
	 */
	private boolean checkClass(final EObject srcModelObject, final SourceSectionClass srcSection,
			final MatchedSectionDescriptor descriptor) {

		this.checkCanceled();

		// First, we check if the 'EClass' of the given srcModelObject is
		// compatible with the srcSection
		//
		final boolean classFits = srcSection.isIncludeSubTypes()
				? srcSection.getEClass().isSuperTypeOf(srcModelObject.eClass())
				: NullComparator.compare(srcSection.getEClass(), srcModelObject.eClass());

		if (!classFits) {
			return false;
		}

		/*
		 * check if all attributes are present and valid
		 */
		boolean attributesOk = this.checkAttributes(srcModelObject, srcSection);

		if (!attributesOk) {
			return false;
		}

		/*
		 * check if all modeled references can be matched; this will also iterate further down the hierarchy (and
		 * thereby call 'checkMapping', 'checkAttributes' and 'checkReferences' multiple times)
		 */
		boolean referencesOk = this.checkReferences(srcModelObject, srcSection, descriptor);

		// ..., then add the current srcModelObject
		descriptor.addSourceModelObjectMapped(srcModelObject, srcSection);

		return referencesOk;

	}

	/**
	 * This checks if all {@link SourceSectionReference references} that have been defined for a given
	 * {@link SourceSectionClass} can be matched for the given '<em>srcModelObject</em>'. Therefore, all
	 * {@link SourceSectionClass#getCardinality() cardinalities} of referenced {@link SourceSectionClass classes} are
	 * checked by redirecting to
	 * {@link #checkCompositeReference(EObject, SourceSectionClass, MatchedSectionDescriptor, SourceSectionCompositeReference, List)}
	 * or {@link #checkCrossReference(EObject, SourceSectionClass, MatchedSectionDescriptor, CrossReference, List)}.
	 *
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} for which the references shall be checked. The
	 *            {@link MatchedSectionDescriptor} for the {@link SourceSection} to be evaluated. Note: The same
	 *            instance will be used for the SourceSection and all child SourceSectionClasses.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} representing the current matching step.
	 */
	private boolean checkReferences(final EObject srcModelObject, final SourceSectionClass sourceSectionClass,
			final MatchedSectionDescriptor descriptor) {

		// Collect the CompositeReferences defined by the class (and extended Sections). However, we do only consider
		// references that are not 'extended' by other references as these are considered identical during the
		// matching process.
		// Note: The values (target classes) of an extended reference are regarded during the matching of the
		// extending reference inside 'checkComposite/CrossReference'.
		//
		List<SourceSectionCompositeReference> compositeReferences = sourceSectionClass.getAllCompositeReferences()
				.stream().filter(r -> r instanceof SourceSectionCompositeReference)
				.map(r -> (SourceSectionCompositeReference) r).filter(r -> r.getEReference() != null)
				.filter(r -> !r.isExtended()).collect(Collectors.toList());

		// All CrossReferences defined by the class (and extended Sections). However, we do only consider
		// references that are not 'extended' by other references as these are considered identical during the
		// matching process.
		// Note: The values (target classes) of an extended reference are regarded during the matching of the
		// extending reference inside 'checkComposite/CrossReference'.
		//
		List<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> crossReferences = sourceSectionClass
				.getAllCrossReferences().stream().filter(r -> !r.isExtended()).collect(Collectors.toList());

		// There may be multiple references representing the same 'EReference'. In order to not match elements
		// twice in such cases, this map keeps track of the remaining elements elements that have not been matched for
		// previous references.
		//
		Map<EReference, List<EObject>> remainingElements = new HashMap<>();

		// First, we try to match all CompositeReferences (resp. the modeled Values). After that, the CrossReferences
		// are checked based on the remaining (unmatched) model elements.
		//
		for (SourceSectionCompositeReference compositeReference : compositeReferences) {

			// The list of elements referenced via the current reference
			//
			List<EObject> referencedElements = this.assetManager.getModelAccessUtil()
					.getReferenceValueAsList(srcModelObject, compositeReference);

			// Check if the elements referenced in the source model can be matched against one of the target classes
			// defined for the reference
			//
			if (!this.checkCompositeReference(descriptor, compositeReference, referencedElements)) {
				return false;
			}

			remainingElements.put(compositeReference.getEReference(), new ArrayList<>(referencedElements));

		}

		// Do not match the CrossReferences directly, instead generate corresponding 'MatchingDependencies' that will be
		// checked later
		//
		for (CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> crossReference : crossReferences) {

			// The elements that need to be matched against the CrossReference. If this CrossReference complements a
			// CompositeReference, we must not match all referenced elements but only those that could not be matched
			// against the CompositeReference
			//
			List<EObject> referencedElements = crossReference instanceof ActualReference<?, ?, ?, ?>
					&& remainingElements.containsKey(((ActualReference<?, ?, ?, ?>) crossReference).getEReference())
							? remainingElements.get(((ActualReference<?, ?, ?, ?>) crossReference).getEReference())
							: this.assetManager.getModelAccessUtil().getReferenceValueAsList(srcModelObject,
									crossReference);

			// Check if the elements referenced in the source model can be matched against one of the target classes
			// defined for the reference
			//
			if (!this.checkCrossReference(descriptor, crossReference, referencedElements)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * This performs basic checks concerning the given list of <em>referencedElements</em> with respect to the
	 * cardinality requirements of the given {@link SourceSectionReference}.
	 *
	 * @param reference
	 *            The {@link SourceSectionReference} to check.
	 * @param referencedElements
	 *            The {@link EObject elements} to check.
	 * @return '<em><b>true</b></em>' if the check succeeded; '<em><b>false</b></em>' otherwise.
	 */
	private boolean basicCheckReference(final SourceSectionReference reference,
			final List<EObject> referencedElements) {

		// The list of SourceSectionClasses that the 'referenceElements' need to be matched against
		//
		List<SourceSectionClass> targetClasses = reference.getValuesIncludingExtended();

		// The reference has a lower bound of 0
		//
		boolean referenceIsOptional = !(reference instanceof ActualReference<?, ?, ?, ?>)
				|| ((ActualReference<?, ?, ?, ?>) reference).getEReference().getLowerBound() == 0;

		// The reference can hold multiple target values (upper bound < 1)
		//
		boolean referenceIsMany = !(reference instanceof ActualReference<?, ?, ?, ?>)
				|| ((ActualReference<?, ?, ?, ?>) reference).getEReference().getUpperBound() < 0;

		assert referenceIsMany || referencedElements.size() <= 1;

		if (referencedElements.isEmpty()) {

			// This is not a problem if the user explicitly specified no child Classes or if the given 'reference' is an
			// optional reference (lower bound of 0) and all modeled child Classes have an optional cardinality
			// (ZERO_INFINITY).
			//
			return targetClasses.isEmpty() || referenceIsOptional
					&& targetClasses.stream().allMatch(c -> c.getCardinality().equals(CardinalityType.ZERO_INFINITY));
		} else if (targetClasses.isEmpty()) {

			// If no target SourceSectionClass has been specified, this means that there must be NO target element
			// in the source model (unless there is a reference with 'ignoreUnmatchedElements' set to 'true').
			//
			return reference.isIgnoreUnmatchedElements();
		}

		// The list of necessary/required target classes (classes with a lower bound != ZERO). These NEED TO be matched
		// for the section to be applicable.
		//
		List<SourceSectionClass> necessaryTargetClasses = targetClasses.stream()
				.filter(c -> !c.getCardinality().equals(CardinalityType.ZERO_INFINITY)).collect(Collectors.toList());

		if (necessaryTargetClasses.size() > 1 && !referenceIsMany) {
			// modeling error: Multiple concrete target SourceSectionClasses with a lower bound of 'ONE' defined for
			// a reference that can hold only one value
			//
			SourceSectionClass parentSourceSectionClass = reference.getOwningClass();
			this.logger.severe(() -> "Modeling error in source section: '"
					+ parentSourceSectionClass.getContainingSection().getName() + "', subsection: '"
					+ parentSourceSectionClass.getName() + "'. The Reference '" + reference.getName()
					+ "' points to a metamodel reference that can only hold one value but references more "
					+ "than one SourceSectionClass with a CardinalityType that is not ZERO_INFINITY as 'value'.");
			return false;
		}

		return necessaryTargetClasses.size() <= referencedElements.size();

	}

	/**
	 * This checks if the given list of <em>referencedElements</em> can be matched against the given
	 * {@link SourceSectionCompositeReference}.
	 * <p />
	 * Note: During the check, this iterates downward in the containment hierarchy of the {@link SourceSection} and
	 * checks if every of the given <em>referencedElements</em> can be
	 * {@link #checkClass(EObject, SourceSectionClass, MatchedSectionDescriptor) matched}.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} representing the current matching step.
	 * @param reference
	 *            The {@link SourceSectionReference} to check.
	 * @param referencedElements
	 *            The {@link EObject elements} to check.
	 * @return '<em><b>true</b></em>' if the check succeeded; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkCompositeReference(final MatchedSectionDescriptor descriptor,
			final SourceSectionCompositeReference reference, final List<EObject> referencedElements) {

		if (!this.basicCheckReference(reference, referencedElements)) {
			return false;
		}

		List<SourceSectionClass> targetClasses = reference.getValuesIncludingExtended();

		// The list of necessary/required target classes (classes with a lower bound != ZERO). These NEED TO be matched
		// for the section to be applicable.
		//
		List<SourceSectionClass> necessaryTargetClasses = targetClasses.stream()
				.filter(c -> !c.getCardinality().equals(CardinalityType.ZERO_INFINITY)).collect(Collectors.toList());

		// The list of optional target classes (classes with a lower bound != ZERO). These DO NOT NEED TO be matched
		// for the section to be applicable.
		//
		List<SourceSectionClass> optionalTargetClasses = targetClasses.stream()
				.filter(c -> c.getCardinality().equals(CardinalityType.ZERO_INFINITY)).collect(Collectors.toList());

		// First, try to match all of the necessary target classes. If any unmatched elements remain after this,
		// try to match the optional target classes.
		//
		List<EObject> remainingReferencedElements = new ArrayList<>(referencedElements);

		for (SourceSectionClass targetClass : Stream
				.concat(necessaryTargetClasses.stream(), optionalTargetClasses.stream()).collect(Collectors.toList())) {

			boolean targetClassMatched = false;

			Iterator<EObject> it = new ArrayList<>(remainingReferencedElements).iterator();
			while (it.hasNext()) {

				EObject referencedElement = it.next();

				if (!remainingReferencedElements.contains(referencedElement)) {
					// The element was matched in the meantime and thus removed from the list of remaining elements
					//
					continue;
				}

				// iterate further
				//
				boolean result = this.checkClass(referencedElement, targetClass, descriptor);

				if (result) {
					remainingReferencedElements.remove(referencedElement);
					targetClassMatched = true;

					if (targetClass.getCardinality().equals(CardinalityType.ONE)) {
						// We must match this target class only once
						//
						break;
					}
				}
			}

			// A necessary target class (cardinality of ONE or ONE_INFINITY) could not be matched -> abort
			//
			if (!targetClassMatched && necessaryTargetClasses.contains(targetClass)) {
				return false;
			}
		}

		// Update the list of referenced elements that need to be matched via another SourceSecitonReference
		//
		referencedElements.clear();
		referencedElements.addAll(remainingReferencedElements);

		return remainingReferencedElements.isEmpty() || reference.isIgnoreUnmatchedElements();
	}

	/**
	 * This checks if the given list of <em>referencedElements</em> can be matched against the given
	 * {@link SourceSectionCrossReference}.
	 * <p />
	 * Note: As the first part of the matching process is preliminary and does not try to
	 * {@link #checkClass(EObject, SourceSectionClass, MatchedSectionDescriptor) match} the elements referenced via
	 * {@link CrossReference CrossReference} this simply generates a corresponding {@link MatchingDependency} (after
	 * calling {@link #basicCheckReference(SourceSectionReference, List)}.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} representing the current matching step.
	 * @param reference
	 *            The {@link SourceSectionReference} to check.
	 * @param referencedElements
	 *            The {@link EObject elements} to check.
	 * @return '<em><b>true</b></em>' if the check succeeded; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkCrossReference(final MatchedSectionDescriptor descriptor,
			final CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> reference,
			final List<EObject> referencedElements) {

		if (!this.basicCheckReference((SourceSectionReference) reference, referencedElements)) {
			return false;
		}

		// We do not check the reference directly, instead generate a suitable 'MatchingDependency' that will be checked
		// later
		//
		CrossReferenceDependency dependency = new CrossReferenceDependency();
		dependency.setDependencySource(descriptor);
		dependency.setSourceModelElements(referencedElements);
		dependency.setSourceSectionClasses(reference.getValuesIncludingExtended());
		dependency.setReference(reference);

		descriptor.addMatchingDependency(dependency);

		return true;
	}

	/**
	 * This checks if all {@link SourceSectionAttribute attributes} that have been defined for a given
	 * {@link SourceSectionClass} can be mapped for the given '<em>srcModelObject</em>'. Therefore, all the
	 * {@link ValueConstraint AttributeValueConstraints} are checked.
	 *
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} for which the attributes shall be checked.
	 * @return '<em></b>true</b></em>' if all attributes are present and satisfy the modeled constraints, '
	 *         <em><b>false</b></em>' otherwise
	 */
	private boolean checkAttributes(final EObject srcModelObject, final SourceSectionClass sourceSectionClass) {

		sourceSectionClass.getAllAttributes().parallelStream().filter(
				at -> !(at instanceof ActualSourceSectionAttribute) && !(at instanceof VirtualSourceSectionAttribute))
				.forEach(at -> this.logger.severe(() -> "SourceSectionAttributes of type '" + at.eClass().getName()
						+ "' are not yet supported!"));

		// Check if all the constraints are satisfied for every attribute value.
		//
		return sourceSectionClass.getAllAttributes().stream().filter(a -> !a.getValueConstraints().isEmpty())
				.allMatch(at -> {
					List<Object> values = this.assetManager.getModelAccessUtil().getAttributeValueAsList(srcModelObject,
							at);
					/*
					 * Check if all the constraints are satisfied for every attribute value.
					 */
					return !values.isEmpty() && values.parallelStream()
							.allMatch(srcAttrValue -> this.checkAttributeValueConstraints(at, srcAttrValue));
				});
	}

	/**
	 * Check the given {@link Object attribute value} against the {@link ValueConstraint AttributeValueConstraints}
	 * modeled for the given {@link SourceSectionAttribute attribute}.
	 *
	 * @param attribute
	 *            The {@link SourceSectionAttribute} for that the constraints shall be checked.
	 * @param value
	 *            The attribute value to be checked against the constraints.
	 * @return '<em><b>true</b></em>' if the value satisfies all modeled constraints; '<em><b>false</b></em>' if at
	 *         least one constraint could not be satisfied.
	 */
	private boolean checkAttributeValueConstraints(final SourceSectionAttribute attribute, Object value) {

		if (attribute.getValueConstraints().isEmpty()) {
			// nothing to check
			//
			return true;
		}

		// convert Attribute value to String
		String srcAttrAsString;

		if (value instanceof String) {
			srcAttrAsString = (String) value;
		} else if (attribute instanceof ActualSourceSectionAttribute) {
			srcAttrAsString = ((ActualSourceSectionAttribute) attribute).getAttribute().getEType().getEPackage()
					.getEFactoryInstance().convertToString(
							((ActualSourceSectionAttribute) attribute).getAttribute().getEAttributeType(), value);
		} else {
			this.logger.severe(() -> "Unable to convert the following value of the SourceSectionAttribute '"
					+ attribute.toString() + "' to a String: '" + value.toString() + "'");
			return false;
		}

		List<ValueConstraint> requiredConstraints = attribute.getValueConstraints().stream()
				.filter(c -> c.getType().equals(ValueConstraintType.REQUIRED)).collect(Collectors.toList());
		List<ValueConstraint> forbiddenConstraints = attribute.getValueConstraints().stream()
				.filter(c -> c.getType().equals(ValueConstraintType.FORBIDDEN)).collect(Collectors.toList());

		// Check that at least one 'required' constraint is met (OR-connection)
		//
		if (!requiredConstraints.isEmpty() && !requiredConstraints.parallelStream()
				.anyMatch(constraint -> this.checkAttributeValueConstraint(srcAttrAsString, constraint))) {
			return false;
		}

		// Check that no 'forbidden' constraint is violated (NOR-connection)
		//
		return forbiddenConstraints.parallelStream()
				.allMatch(constraint -> this.checkAttributeValueConstraint(srcAttrAsString, constraint));

	}

	/**
	 * Check the given {@link Object attribute value} against the {@link ValueConstraint AttributeValueConstraints}
	 * modeled for the given {@link SourceSectionAttribute attribute}.
	 *
	 * @param attribute
	 *            The {@link SourceSectionAttribute} for that the constraints shall be checked.
	 * @param value
	 *            The
	 *
	 * @param attributeValueAsString
	 *            A String representation of the attribute value to be checked against the given <em>constraint</em>.
	 * @param constraint
	 *            The {@link ValueConstraint} that the given <em>attributeValueAsString</em> shall be checked against.
	 * @return '<em><b>true</b></em>' if the value satisfies the constraint; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkAttributeValueConstraint(final String attributeValueAsString,
			final ValueConstraint constraint) {

		boolean constraintVal = false;

		// Note: 'checkConstraint' already takes the type (REQUIRED/FORBIDDEN)
		// into consideration
		// Starting from now we have to differentiate between Single- and
		// MultipleReferenceAttributeValueConstraints
		// and we need to extract the right reference Value(s) for each
		// constraint

		if (constraint instanceof SingleReferenceValueConstraint) {

			String srcAttrRefValAsString = this.refValueCalculator.calculateReferenceValue(constraint);
			constraintVal = ((SingleReferenceValueConstraint) constraint).checkConstraint(attributeValueAsString,
					srcAttrRefValAsString);

		} else if (constraint instanceof ChoiceConstraint) {

			List<String> srcAttrRefValuesAsList = new ArrayList<>();

			for (EqualityConstraint equalityConstraint : ((ChoiceConstraint) constraint).getChoices()) {
				srcAttrRefValuesAsList.add(this.refValueCalculator.calculateReferenceValue(equalityConstraint));
			}

			constraintVal = ((ChoiceConstraint) constraint).checkConstraint(attributeValueAsString,
					new BasicEList<>(srcAttrRefValuesAsList));

		} else {
			// If we are here, some mistake is happened
			// more types could be supported in the future
			// placeholder for other MultipleReferenceAttributeValueConstraints
			this.logger.severe(
					() -> "ReferenceableElement type " + constraint.getClass().getName() + " is not yet supported!");
		}

		return constraintVal;
	}

}
