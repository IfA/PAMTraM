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
	private final MatchedSectionRegistry matchedSectionRegistry;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public SourceSectionMatcher(TransformationAssetManager assetManager) {

		super(assetManager);

		this.matchedSectionRegistry = assetManager.getMatchedSectionRegistry();
		this.ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		this.refValueCalculator = assetManager.getValueConstraintReferenceValueCalculator();
	}

	/**
	 * This iterates through the given list of <em>sourceModels</em> and tries to match each of the {@link SourceSection
	 * SourceSections} defined in the given list of {@link PAMTraM PAMTraM Models} against the elements of the source
	 * models. The result of this process is a list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that
	 * is stored in the {@link #matchedSectionRegistry}.
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
	 * {@link #matchedSectionRegistry}.
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

		ContainmentTree tree = ContainmentTree.build(sourceModels);
		this.matchSections(tree, activeSourceSections);
	}

	/**
	 * This iterates through the given {@link ContainmentTree} and tries to match each of the given {@link SourceSection
	 * SourceSections} against the elements represented in the tree. The result of this process is a list of
	 * {@link MatchedSectionDescriptor MatchedSectionDescriptors} that is stored in the {@link #matchedSectionRegistry}.
	 *
	 * @param containmentTree
	 *            The {@link ContainmentTree} representing the source models to be matched.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the ' <em>containmentTree</em>' shall be matched
	 *            against.
	 */
	private void matchSections(ContainmentTree containmentTree, List<SourceSection> sourceSections) {

		// Determine the potential matches. These may still be ambiguous (multiple matches for one EObject) and can be
		// equipped with MatchingDependencies (as this first step only matches the direct contents of the given Sections
		// and not any CrossReferences to other Sections).
		//
		Map<EObject, List<MatchedSectionDescriptor>> potentialMatches = this
				.findPotentialApplicableSections(containmentTree.getElements(), sourceSections);

		// Now that we know each potential match, we need to check the determined 'MatchingDependencies' and resolve
		// ambiguous matches, i.e. select the resulting matches for the next steps of the transformation. As each
		// EObject may only be used for one descriptor, we iterate over the ContainmentTree and make use of its
		// 'getNextElementForMatching' feature that will not return any elements that have already been marked as
		// 'matched'.
		//
		containmentTree.restartIteration();
		Optional<EObject> element;

		while ((element = containmentTree.getNextElementForMatching()).isPresent()) {

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
						+ descriptor.getAssociatedSourceSectionClass().getName() + "'!");
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

			containmentTree.markAsMatched(new HashSet<>(selectedLocalRegistry.getRegisteredElements()));

		}

		this.logger.info(() -> "Summary:\tAvailable Elements:\t" + containmentTree.getNumberOfElements());
		this.logger.info(() -> "\t\tMatched Elements:\t" + containmentTree.getNumberOfMatchedElements());
		this.logger.info(() -> "\t\tUnmatched Elements:\t" + containmentTree.getNumberOfUnmatchedElements());

	}

	/**
	 * For each of the given {@link EObject elements}, determine those of the given {@link SourceSection sourceSections}
	 * that are <em>potentially</em> applicable (can be matched against the element).
	 * <p />
	 * Note: <em>Potentially</em> applicable in this case means that the applicability of a SourceSection may be
	 * {@link MatchingDependency dependent} on the applicability of one or multiple other combinations of elements and
	 * SourceSections: This only checks the applicability of the direct content of the given {@link SourceSection} and
	 * not the applicability of any other SourceSections referenced via {@link CrossReference CrossReferences}
	 *
	 * @param elements
	 *            The list of {@link EObject EObjects} for that the applicability of the given <em>sourceSection</em>
	 *            shall be checked.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} to consider as potentially applicable.
	 * @return A map relating the elements of the source model with a list of potentially applicable
	 *         {@link MatchedSectionDescriptor MatchedSectionDescriptors}. Note: Elements for that no applicable
	 *         {@link MatchedSectionDescriptor MatchedSectionDescriptors} could be determined will be represented in the
	 *         map by means of an empty list of descriptors!
	 */
	private Map<EObject, List<MatchedSectionDescriptor>> findPotentialApplicableSections(List<EObject> elements,
			List<SourceSection> sourceSections) {

		return elements.parallelStream()
				.map(e -> new AbstractMap.SimpleEntry<>(e, this.findPotentialApplicableSections(e, sourceSections)))
				.filter(e -> !e.getValue().isEmpty()).collect(Collectors.toConcurrentMap(Entry::getKey, Entry::getValue,
						(v1, v2) -> v2, ConcurrentHashMap::new));

	}

	/**
	 * This determines and returns all applicable source sections for the given source model <em>element</em>.
	 *
	 * @param element
	 *            The element from the source model for that the applicable source sections shall be determined.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the <em>element</em> shall be matched against.
	 * @return A list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} representing all
	 *         {@link SourceSection SourceSections} that are applicable for the given {@link EObject}.
	 */
	private List<MatchedSectionDescriptor> findPotentialApplicableSections(final EObject element,
			final List<SourceSection> sourceSections) {

		// Iterate over all sections and find those that are applicable for the current 'element'.
		//
		return sourceSections.stream().map(section -> this.isApplicable(section, element)).filter(Optional::isPresent)
				.map(Optional::get).collect(Collectors.toList());

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

			if (match.getMatchedSourceModelObjectFlat(false).size() >= maxMatchedElements) {

				if (match.getMatchedSourceModelObjectFlat(false).size() > maxMatchedElements) {
					maxMatchedElements = match.getMatchedSourceModelObjectFlat(false).size();
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
				.flatMap(Collection::stream).filter(d -> d.containsSourceModelObjectMapped(element))
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
	 * @return A {@link MatchedSectionRegistry MatchedSectionRegistrys} that represents all descriptors that have to be
	 *         applied if the given {@link MatchedSectionDescriptor potentialDescriptor} would be applied or an empty
	 *         Optional if the given {@link MatchedSectionDescriptor potentialDescriptor} is not applicable.
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

				if (dependency.getSourceSectionClasses().stream().anyMatch(c -> globalDescriptor.get()
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

				if (dependency.getSourceSectionClasses().stream().anyMatch(c -> localDescriptor.get()
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
	 * This checks if the given {@link SourceSection} is applicable for the given source model <em>element</em>.
	 * Therefore, it first {@link #checkContainerSection(EObject, SourceSection) checks the container} and then the
	 * {@link #checkClass(EObject, SourceSectionClass, MatchedSectionDescriptor) section itself}.
	 *
	 * @param section
	 *            The {@link SourceSection} to check.
	 * @param element
	 *            The {@link EObject} from the source model for that the applicability of the source section shall be
	 *            determined.
	 * @return An suitable preliminary {@link MatchedSectionDescriptor} if the given {@link SourceSection} is applicable
	 *         for the given {@link EObject} or an empty optional if the given SourceSection was not applicable.
	 */
	private Optional<MatchedSectionDescriptor> isApplicable(SourceSection section, final EObject element) {

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
	 * This recursively checks if a {@link SourceSectionClass} is applicable for a certain part of the source model.
	 * Therefore, it iterates downward in the containment hierarchy of the source section and checks if every element
	 * can be matched to a part of the source model.
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
	 * checked. <br />
	 * <b>Note:</b> For every {@link SourceSectionClass class} that is referenced by a modeled
	 * {@link SourceSectionReference reference}, this calls
	 * {@link #checkClass(EObject, SourceSectionClass, MatchedSectionDescriptor)} so that we iteratively go through the
	 * complete hierarchy of the modeled section.
	 *
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} for which the references shall be checked. The
	 *            {@link MatchedSectionDescriptor} for the {@link SourceSection} to be evaluated. Note: The same
	 *            instance will be used for the SourceSection and all child SourceSectionClasses.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} representing the current matching step.
	 * @param refByClassMap
	 *            A map that collects all {@link SourceSectionReference SourceSectionReferences} and the
	 *            {@link SourceSectionClass} that they are contained in.
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
			List<EObject> referencedElements = this.assetManager.getModelTraversalUtil()
					.getReferenceValueAsList(srcModelObject, compositeReference);

			// Check if the elements referenced in the source model can be matched against one of the target classes
			// defined for the reference
			//
			if (!this.checkCompositeReference(srcModelObject, sourceSectionClass, descriptor, compositeReference,
					referencedElements)) {
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
							: this.assetManager.getModelTraversalUtil().getReferenceValueAsList(srcModelObject,
									crossReference);

			// Check if the elements referenced in the source model can be matched against one of the target classes
			// defined for the reference
			//
			if (!this.checkCrossReference(srcModelObject, sourceSectionClass, descriptor, crossReference,
					referencedElements)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * This checks if the given <em>refTargetObj</em> that is referenced by a {@link EReference#isMany() single-valued}
	 * reference can be matched for the given {@link MatchedSectionDescriptor} representing the referencing element.
	 * <p />
	 * Note: This iterates further downward in the containment hierarchy by calling
	 * {@link #checkClass(EObject, SourceSectionClass, MatchedSectionDescriptor)}.
	 *
	 * @param referencedElement
	 *            The {@link EObject element} to check.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} representing the {@link EObject} that references the given
	 *            <em>refTargetObj</em>.
	 * @param classes
	 *            The list of {@link SourceSectionClass SourceSectionClasses} that have been modeled as target for the
	 *            current reference to be checked (these are the potential matches for the given <em>refTargetObj</em>).
	 * @param refByClassMap
	 *            A map that collects all {@link SourceSectionClass SourceSectionClasses} and the
	 *            {@link SourceSectionReference} that they are referenced by.
	 * @param reference
	 *            The {@link SourceSectionReference} to check.
	 * @param sourceSectionClass
	 *            The parent {@link SourceSectionClass} for which the references shall be checked.
	 * @return '<em><b>true</b></em>' if the check succeeded; '<em><b>false</b></em>' otherwise.
	 */
	private boolean basicCheckReference(final EObject parentElement, final SourceSectionClass parentSourceSectionClass,
			final MatchedSectionDescriptor descriptor, final SourceSectionReference reference,
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
	 *
	 *
	 * ${tags}
	 */
	private boolean checkCompositeReference(final EObject parentElement,
			final SourceSectionClass parentSourceSectionClass, final MatchedSectionDescriptor descriptor,
			final SourceSectionCompositeReference reference, final List<EObject> referencedElements) {

		if (!this.basicCheckReference(parentElement, parentSourceSectionClass, descriptor, reference,
				referencedElements)) {
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

	private boolean checkCrossReference(final EObject parentElement, final SourceSectionClass parentSourceSectionClass,
			final MatchedSectionDescriptor descriptor,
			final CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> reference,
			final List<EObject> referencedElements) {

		if (!this.basicCheckReference(parentElement, parentSourceSectionClass, descriptor,
				(SourceSectionReference) reference, referencedElements)) {
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
					List<Object> values = ValueExtractor.getAttributeValueAsList(srcModelObject, at, this.logger);
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

	// /**
	// * Counts how often each {@link EObject source model element} is
	// * {@link MatchedSectionDescriptor#getAssociatedSourceModelElement() referenced} by each
	// * {@link MatchedSectionDescriptor} and returns one mapping result for the Object with the lowest count.
	// *
	// * @param possibleElements
	// * The list of possible {@link MatchedSectionDescriptor MatchedSectionDescriptors} to evaluate.
	// * @return The chosen {@link MatchedSectionDescriptor}.
	// */
	// private static MatchedSectionDescriptor getResultForLeastUsedSrcModelElement(
	// final List<MatchedSectionDescriptor> possibleElements) {
	//
	// // count how often a sourceModel Element is mapped
	// //
	// final Map<EObject, Integer> usages = possibleElements.stream()
	// .map(MatchedSectionDescriptor::getAssociatedSourceModelElement)
	// .collect(Collectors.toConcurrentMap(element -> element, element -> 1, (i, j) -> i + j));
	//
	// Optional<Integer> leastUsage = usages.values().parallelStream().sorted().findFirst();
	//
	// if (!leastUsage.isPresent()) {
	// return null;
	// }
	//
	// // return the FIRST of the possible MatchedSectionDescriptors that
	// // represents one of the least used elements (we
	// // need to ensure a correct order at this point to match according to
	// // the order of the modeled
	// // SourceSectionClasses)
	// //
	// return possibleElements.stream()
	// .filter(e -> usages.get(e.getAssociatedSourceModelElement()).intValue() == leastUsage.get()).findFirst()
	// .orElseGet(null);
	//
	// }

}