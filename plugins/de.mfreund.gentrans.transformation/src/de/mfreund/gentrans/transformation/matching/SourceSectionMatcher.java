package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
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
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.generic.VirtualReference;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCompositeReference;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.util.NullComparator;

/**
 * This class can be used to match a list of {@link #sourceSections} against a {@link #containmentTree}.
 *
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
	 * This iterates through the given {@link ContainmentTree} representing one or multiple source models and tries to
	 * match each of the given {@link SourceSection SourceSections} against the elements represented in the tree. The
	 * result of this process is a list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that is stored in
	 * the {@link #matchedSectionRegistry}.
	 *
	 * @param containmentTree
	 *            The {@link ContainmentTree} representing the source models to be matched.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the ' <em>containmentTree</em>' shall be matched
	 *            against.
	 */
	private void matchSections(ContainmentTree containmentTree, List<SourceSection> sourceSections) {

		// Determine the potential matches (these may still be ambiguous and can be equipped with MatchingDependencies)
		//
		Map<EObject, List<MatchedSectionDescriptor>> potentialMatches = this
				.findPotentialApplicableSections(containmentTree.getElements(), sourceSections);

		// Now that we know each potential match, we need to check the determined 'MatchingDependencies' and resolve
		// ambiguous matches, i.e. select the resulting matches for the next steps of the transformation. Therefore, we
		// once again iterate through the potential source model elements starting with the first potential match...
		//
		for (Entry<EObject, List<MatchedSectionDescriptor>> match : potentialMatches.entrySet()) {

			// For each potential descriptors, build the 'local registry', i.e. the collection of snippets that would be
			// matched if the descriptor would be used as match
			//
			Map<MatchedSectionDescriptor, MatchedSectionRegistry> localRegistries = new LinkedHashMap<>();

			for (MatchedSectionDescriptor potentialDescriptor : match.getValue()) {

				MatchedSectionRegistry localRegistry = new MatchedSectionRegistry(this.assetManager);
				localRegistry.register(potentialDescriptor);

				for (MatchingDependency dependency : potentialDescriptor.getMatchingDependencies()) {

					for (EObject dependencyElement : dependency.getSourceModelElements()) {

						// matchedSectionRegistry.

						// TODO check if each of the elements can be matched against one of the required classes
					}

				}

				localRegistries.put(potentialDescriptor, localRegistry);
			}

			// If there are multiple matches, select the one section to actually apply.
			//
			MatchedSectionDescriptor descriptor = this.selectApplicableSection(match.getKey(),
					new ArrayList<>(localRegistries.keySet()));

			// Now, register everything that is associated with the chosen descriptor, i.e. everything represented in
			// the 'localRegistry'
			//
			if (descriptor != null) {

				MatchedSectionRegistry chosenRegistry = localRegistries.get(descriptor);
				List<MatchedSectionDescriptor> failedDescriptors = this.matchedSectionRegistry.register(chosenRegistry);
				if (!failedDescriptors.isEmpty()) {
					this.logger.severe(
							() -> "Internal error: Some MatchedSectionDescriptors could not be registered in the global registry!");
				}
				containmentTree.markAsMatched(new HashSet<>(chosenRegistry.getRegisteredElements()));
			}
		}

		this.logger.info(() -> "Summary:\tAvailable Elements:\t" + containmentTree.getNumberOfElements());
		this.logger.info(() -> "\t\tMatched Elements:\t" + containmentTree.getNumberOfMatchedElements());
		this.logger.info(() -> "\t\tUnmatched Elements:\t" + containmentTree.getNumberOfUnmatchedElements());

	}

	/**
	 *
	 *
	 * ${tags}
	 */
	private Map<EObject, List<MatchedSectionDescriptor>> findPotentialApplicableSections(List<EObject> elements,
			List<SourceSection> sourceSections) {

		Map<EObject, List<MatchedSectionDescriptor>> potentialMatches = new LinkedHashMap<>();

		// TODO this should now be parallelizable
		for (EObject element : elements) {

			// Get all 'potential' matches for the current element (they are only 'potential' because they may depend on
			// one or more 'MatchingDependencies'
			//
			Map<SourceSection, MatchedSectionDescriptor> potentialElementMatches = this
					.findPotentialApplicableSections(element, sourceSections);
			if (!potentialElementMatches.isEmpty()) {
				potentialMatches.put(element, new ArrayList<>(potentialElementMatches.values()));
			}

		}
		return potentialMatches;
	}

	/**
	 * This determines and returns all applicable source sections for the given source model <em>element</em>.
	 *
	 * @param element
	 *            The element from the source model for that the applicable source sections shall be determined.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the <em>element</em> shall be matched against.
	 * @return A map that contains all applicable {@link SourceSection SourceSections} and the associated
	 *         {@link MatchedSectionDescriptor} for the given {@link EObject}.
	 */
	private Map<SourceSection, MatchedSectionDescriptor> findPotentialApplicableSections(final EObject element,
			final List<SourceSection> sourceSections) {

		/*
		 * This keeps track of all found possible sections (a MatchedSectionDescriptor is created for every applicable
		 * Section).
		 */
		final Map<SourceSection, MatchedSectionDescriptor> applicableSections = new LinkedHashMap<>();

		/*
		 * Now, iterate over all sections and find those that are applicable for the current 'element'.
		 */
		sourceSections.stream().forEach(section -> this.isApplicable(section, element, applicableSections));

		return applicableSections;
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
	private MatchedSectionDescriptor selectApplicableSection(EObject element,
			List<MatchedSectionDescriptor> descriptors) {

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

			if (match.getMatchedSourceModelObjectFlat().size() >= maxMatchedElements) {

				if (match.getMatchedSourceModelObjectFlat().size() > maxMatchedElements) {
					maxMatchedElements = match.getMatchedSourceModelObjectFlat().size();
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
	 * This checks if the given {@link SourceSection} is applicable for the given source model <em>element</em>.
	 * Therefore, it first {@link #checkContainerSection(EObject, SourceSection) checks the container} and then the
	 * {@link #checkClass(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor) section itself}.
	 * <p />
	 * If the Section is applicable, this stores the result in the <em>applicableSections</em>.
	 *
	 * @param section
	 *            The {@link SourceSection} to check.
	 * @param element
	 *            The {@link EObject} from the source model for that the applicability of the source section shall be
	 *            determined.
	 * @param applicableSections
	 *            The map where applicable sections are stored.
	 * @return '<em>true</em>' if the given {@link SourceSection} is applicable for the given {@link EObject} (and a
	 *         corresponding entry was added to the <em>mappingData</em>); '<em>false</em>' otherwise.
	 */
	private boolean isApplicable(SourceSection section, final EObject element,
			final Map<SourceSection, MatchedSectionDescriptor> applicableSections) {

		if (!section.getEClass().isSuperTypeOf(element.eClass())) {
			return false;
		}

		Optional<MatchedSectionDescriptor> descriptor;

		// /*
		// * check if the section that is referenced as 'container' can be matched
		// */
		// if (!this.checkContainerSection(element, section)) {
		// return false;
		// }

		// check if the section itself is applicable
		//
		descriptor = this.checkClass(element, Optional.empty(), section, null);

		if (!descriptor.isPresent()) {
			return false;
		}

		if (section.getContainer() != null) {

			if (element.eContainer() == null) {
				return false;
			}

			ContainerDependency containerDependency = new ContainerDependency();
			containerDependency.setDependencySource(descriptor.get());
			containerDependency.setSourceModelElements(Arrays.asList(element.eContainer()));
			containerDependency.setSourceSectionClasses(Arrays.asList(section.getContainer()));
			descriptor.get().addMatchingDependency(containerDependency);
		}

		// // set the associated container descriptor
		// //
		// this.setContainerDescriptor(descriptor.get());

		// all checks were successful -> the section is applicable
		//
		applicableSections.put(section, descriptor.get());

		return true;
	}

	/**
	 * For a given {@link MatchedSectionDescriptor}, this extracts the associated '<em>container descriptor</em>' from
	 * the {@link #matchedSectionRegistry} and
	 * {@link MatchedSectionDescriptor#setContainerDescriptor(MatchedSectionDescriptor) sets} it in the descriptor.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for that the container shall be determined and set.
	 * @return '<em><b>true</b></em>' if either the given '<em>descriptor</em>' does not represent a SourceSection but a
	 *         SourceSectionClass, if the {@link SourceSection} represented by the given '<em>descriptor</em>' does not
	 *         specify a {@link SourceSection#getContainer() container}, if the container descriptor has already been
	 *         set, or if the container descriptor was set successfully; '<em><b>false</b></em>' otherwise.
	 */
	private boolean setContainerDescriptor(MatchedSectionDescriptor descriptor) {

		if (!(descriptor.getAssociatedSourceSectionClass() instanceof SourceSection)) {
			return true;
		}

		EObject element = descriptor.getAssociatedSourceModelElement();

		SourceSection section = (SourceSection) descriptor.getAssociatedSourceSectionClass();

		if (section.getContainer() == null || descriptor.getContainerDescriptor() != null) {
			return true;
		}

		if (!this.matchedSectionRegistry.containsKey(section.getContainer().getContainingSection())) {
			return false;
		}

		Set<MatchedSectionDescriptor> containerDescriptors = this.matchedSectionRegistry
				.get(section.getContainer().getContainingSection()).parallelStream()
				.filter(d -> d.getMatchedSourceModelObjectFlat().contains(element.eContainer()))
				.collect(Collectors.toSet());

		assert containerDescriptors.size() == 1;

		descriptor.setContainerDescriptor(containerDescriptors.iterator().next());

		return true;
	}

	/**
	 * This recursively checks if a {@link SourceSectionClass} is applicable for a certain part of the source model.
	 * Therefore, it iterates downward in the containment hierarchy of the source section and checks if every element
	 * can be matched to a part of the source model.
	 *
	 * @param srcModelObject
	 *            The element of the source model that is currently evaluated for applicability.
	 * @param reference
	 *            If this is called as part of the check for another {@link SourceSectionClass}, this holds the
	 *            {@link EReference} referencing the given <em>srcModelObject</em>. This will be an empty optional if
	 *            this is either the <em>root</em> call to <em>checkSection</em> or if called for a
	 *            {@link VirtualReference}.
	 * @param srcSection
	 *            The {@link SourceSectionClass} (either the sourceMMSection itself or a direct or indirect child of it)
	 *            that is currently checked.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for the parent {@link SourceSectionClass element}.
	 *
	 * @return The {@link MatchedSectionDescriptor} representing the matched section (including all matched child
	 *         elements).
	 */
	private Optional<MatchedSectionDescriptor> checkClass(final EObject srcModelObject, Optional<EReference> reference,
			final SourceSectionClass srcSection, final MatchedSectionDescriptor parentDescriptor) {

		// This will be returned in the end
		//
		MatchedSectionDescriptor descriptor;

		// // This prevents endless recursion in case of (direct or indirect) cyclic references between Sections
		// //
		// if (parentDescriptor != null && parentDescriptor.containsSourceModelObjectMapped(srcModelObject)) {
		// descriptor = new MatchedSectionDescriptor();
		// descriptor.setAssociatedSourceModelElement(srcModelObject);
		// descriptor.setAssociatedSourceSectionClass(srcSection);
		// descriptor.setContainerDescriptor(parentDescriptor);
		// return Optional.of(descriptor);
		// }

		this.checkCanceled();

		// First, we check if the 'EClass' of the given srcModelObject is
		// compatible with the srcSection
		//
		final boolean classFits = srcSection.isIncludeSubTypes()
				? srcSection.getEClass().isSuperTypeOf(srcModelObject.eClass())
				: NullComparator.compare(srcSection.getEClass(), srcModelObject.eClass());

		if (!classFits) {
			return Optional.empty();
		}

		// // Check if the element was already matched previously for the same
		// // SourceSectionClass. If this is the case, we just reuse the existing
		// // descriptor
		// //
		// Optional<MatchedSectionDescriptor> existingDescriptor = this.matchedSectionRegistry
		// .getMatchedSectionDescriptorFor(srcModelObject, srcSection.getContainingSection());
		//
		// if (existingDescriptor.isPresent()
		// && existingDescriptor.get().getAssociatedSourceSectionClass().equals(srcSection)) {
		//
		// // set the list of source model objects that have been mapped.
		// // first, add all mapped objects from 'changedRefsAndHints' ...
		// if (parentDescriptor != null && reference.isPresent() && reference.get().isContainment()) {
		// if (reference.get() instanceof CompositeReference<?, ?, ?, ?>) {
		// existingDescriptor.get().add(parentDescriptor);
		// }
		// existingDescriptor.get().setContainerDescriptor(parentDescriptor);
		// }
		//
		// return existingDescriptor;
		// }

		// this is the 'MatchedSectionDescriptor' that we will return this in
		// case we find the mapping to be applicable
		// else we return null
		//
		descriptor = new MatchedSectionDescriptor();
		descriptor.setAssociatedSourceModelElement(srcModelObject);
		descriptor.setAssociatedSourceSectionClass(srcSection);

		// set the list of source model objects that have been mapped.
		// first, add all mapped objects from 'changedRefsAndHints' ...
		if (parentDescriptor != null && reference.isPresent() && reference.get().isContainment()
				&& reference.get() instanceof CompositeReference<?, ?, ?, ?>) {
			descriptor.add(parentDescriptor);
		}
		// ..., then add the current srcModelObject
		descriptor.addSourceModelObjectMapped(srcModelObject, srcSection);

		/*
		 * check if all attributes are present and valid
		 */
		boolean attributesOk = this.checkAttributes(srcModelObject, srcSection);

		if (!attributesOk) {
			return Optional.empty();
		}

		/*
		 * check if all modeled references can be matched; this will also iterate further down the hierarchy (and
		 * thereby call 'checkMapping', 'checkAttributes' and 'checkReferences' multiple times)
		 */
		boolean referencesOk = this.checkReferences(srcModelObject, srcSection, descriptor);

		if (!referencesOk) {
			return Optional.empty();
		}

		// set the associated container descriptor if the element is checked as
		// part of a containment reference check
		//
		if (parentDescriptor != null && reference.isPresent() && reference.get().isContainment()) {
			descriptor.setContainerDescriptor(parentDescriptor);
		}

		return Optional.of(descriptor);

	}

	/**
	 * This checks if all {@link SourceSectionReference references} that have been defined for a given
	 * {@link SourceSectionClass} can be matched for the given '<em>srcModelObject</em>'. Therefore, all
	 * {@link SourceSectionClass#getCardinality() cardinalities} of referenced {@link SourceSectionClass classes} are
	 * checked. <br />
	 * <b>Note:</b> For every {@link SourceSectionClass class} that is referenced by a modeled
	 * {@link SourceSectionReference reference}, this calls
	 * {@link #checkClass(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)} so that we iteratively go
	 * through the complete hierarchy of the modeled section.
	 *
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} for which the references shall be checked. The
	 *            {@link MatchedSectionDescriptor} for the {@link SourceSection} to be evaluated. Note: The same
	 *            instance will be used for the SourceSection and all child SourceSectionClasses.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for the {@link SourceSectionClass} to be evaluated.
	 * @param refByClassMap
	 *            A map that collects all {@link SourceSectionReference SourceSectionReferences} and the
	 *            {@link SourceSectionClass} that they are contained in.
	 */
	private boolean checkReferences(final EObject srcModelObject, final SourceSectionClass sourceSectionClass,
			final MatchedSectionDescriptor descriptor) {

		// All CompositeReferences defined by the class (and extended Sections)
		//
		List<SourceSectionCompositeReference> compositeReferences = sourceSectionClass.getAllCompositeReferences()
				.stream().filter(r -> r instanceof SourceSectionCompositeReference)
				.map(r -> (SourceSectionCompositeReference) r).filter(r -> r.getEReference() != null)
				.collect(Collectors.toList());

		// All CrossReferences defined by the class (and extended Sections)
		//
		List<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> crossReferences = sourceSectionClass
				.getAllCrossReferences();

		// This map keeps track of all CrossReferences that 'complement' a CompositeReference, i.e. that represents the
		// same 'EReference'
		//
		Map<SourceSectionCompositeReference, CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> complementingReferences = new HashMap<>();
		for (SourceSectionCompositeReference compositeReference : compositeReferences) {

			Optional<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> complementingCrossReference = crossReferences
					.stream().filter(r -> r instanceof ActualReference<?, ?, ?, ?>).filter(r -> compositeReference
							.getEReference().equals(((ActualReference<?, ?, ?, ?>) r).getEReference()))
					.findAny();
			complementingCrossReference.ifPresent(r -> complementingReferences.put(compositeReference, r));
		}

		Map<CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, List<EObject>> complementingReferenceMatchingRequirements = new HashMap<>();

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

			List<EObject> remainingReferencedElements = new ArrayList<>(referencedElements);

			if (complementingReferences.containsKey(compositeReference)) {

				complementingReferenceMatchingRequirements.put(complementingReferences.get(compositeReference),
						remainingReferencedElements);
			}

		}

		// Do not match the CrossReferences directly, instead generate corresponding 'MatchingDependencies' that will be
		// checked later
		//
		for (CrossReference<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> crossReference : crossReferences) {

			// The elements that need to be matched against the CrossReference. If this CrossReference complements a
			// CompositeReference, we must not match all referenced elements but only those that could not be matched
			// against the CompositeReference
			//
			List<EObject> referencedElements = complementingReferenceMatchingRequirements.containsKey(crossReference)
					? complementingReferenceMatchingRequirements.get(crossReference)
					: this.assetManager.getModelTraversalUtil().getReferenceValueAsList(srcModelObject, crossReference);

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
	 * {@link #checkClass(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)}.
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
		List<SourceSectionClass> targetClasses = reference.getValuesGeneric();

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

			// This is not a problem if the given 'reference' is an optional reference (lower bound of 0) and all
			// modeled child Classes have an optional cardinality (ZERO_INFINITY).
			//
			return referenceIsOptional
					&& targetClasses.stream().allMatch(c -> c.getCardinality().equals(CardinalityType.ZERO_INFINITY));
		}

		if (targetClasses.isEmpty()) {

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

		if (necessaryTargetClasses.size() > referencedElements.size()) {
			return false;
		}

		return true;

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

		List<SourceSectionClass> targetClasses = reference.getValuesGeneric();

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
		List<MatchedSectionDescriptor> childDescriptors = new ArrayList<>();
		List<EObject> remainingReferencedElements = new ArrayList<>(referencedElements);

		for (SourceSectionClass targetClass : Stream
				.concat(necessaryTargetClasses.stream(), optionalTargetClasses.stream()).collect(Collectors.toList())) {

			boolean targetClassMatched = false;

			Iterator<EObject> it = remainingReferencedElements.iterator();
			while (it.hasNext()) {

				EObject referencedElement = it.next();

				// iterate further
				//
				Optional<MatchedSectionDescriptor> childDescriptor = this.checkClass(referencedElement,
						Optional.of(reference.getEReference()), targetClass, descriptor);

				if (childDescriptor.isPresent()) {
					childDescriptors.add(childDescriptor.get());
					remainingReferencedElements.remove(referencedElement);
					targetClassMatched = true;
				}
			}

			// A necessary target class (cardinality of ONE or ONE_INFINITY) could not be matched -> abort
			//
			if (!targetClassMatched && necessaryTargetClasses.contains(targetClass)) {
				return false;
			}
		}

		for (MatchedSectionDescriptor childDescriptor : childDescriptors) {
			// Update the given parent descriptor
			//
			descriptor.add(childDescriptor);
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
		dependency.setSourceSectionClasses(reference.getValue());
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

	/**
	 * Counts how often each {@link EObject source model element} is
	 * {@link MatchedSectionDescriptor#getAssociatedSourceModelElement() referenced} by each
	 * {@link MatchedSectionDescriptor} and returns one mapping result for the Object with the lowest count.
	 *
	 * @param possibleElements
	 *            The list of possible {@link MatchedSectionDescriptor MatchedSectionDescriptors} to evaluate.
	 * @return The chosen {@link MatchedSectionDescriptor}.
	 */
	private static MatchedSectionDescriptor getResultForLeastUsedSrcModelElement(
			final List<MatchedSectionDescriptor> possibleElements) {

		// count how often a sourceModel Element is mapped
		//
		final Map<EObject, Integer> usages = possibleElements.stream()
				.map(MatchedSectionDescriptor::getAssociatedSourceModelElement)
				.collect(Collectors.toConcurrentMap(element -> element, element -> 1, (i, j) -> i + j));

		Optional<Integer> leastUsage = usages.values().parallelStream().sorted().findFirst();

		if (!leastUsage.isPresent()) {
			return null;
		}

		// return the FIRST of the possible MatchedSectionDescriptors that
		// represents one of the least used elements (we
		// need to ensure a correct order at this point to match according to
		// the order of the modeled
		// SourceSectionClasses)
		//
		return possibleElements.stream()
				.filter(e -> usages.get(e.getAssociatedSourceModelElement()).intValue() == leastUsage.get()).findFirst()
				.orElseGet(null);

	}

}