package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueConstraintReferenceValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.ContainmentTree;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.maps.SourceSectionMatchingResultsMap;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.MappingModel;
import pamtram.mapping.FixedValue;
import pamtram.structure.constraint.ChoiceConstraint;
import pamtram.structure.constraint.EqualityConstraint;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintType;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.Section;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionCrossReference;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to match a list of {@link #sourceSections} against a {@link #containmentTree}.
 *
 *
 * @author mfreund
 */
public class SourceSectionMatcher {

	/**
	 * The {@link ContainmentTree} that represents the list of source models to be matched.
	 */
	private final ContainmentTree containmentTree;

	/**
	 * The list of {@link SourceSection SourceSections} that this matcher operates on. These are matched against the
	 * {@link #containmentTree} in the course of the matching process.
	 */
	private EList<SourceSection> sourceSections;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the
	 * execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	private Logger logger;

	/**
	 * Registry for <em>source model elements</em> that have already been matched. The matched elements are stored in a
	 * map where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private final Map<SourceSectionClass, Set<EObject>> matchedSections;

	/**
	 * Registry for <em>source model elements</em> that were not directly matched but indirectly matched as part of a
	 * container section. The matched objects are stored in a map where the key is the corresponding
	 * {@link SourceSectionClass container section} that they have been matched to.
	 */
	private final Map<SourceSectionClass, Set<EObject>> matchedContainers;

	/**
	 * This keeps track of all {@link ValueConstraint AttributeValueConstraints} that could not be evaluated so we don't
	 * need to send a potential error message twice. This might e.g. happen for a malformed regular expression in a
	 * {@link RegExConstraint}.
	 */
	private final Set<ValueConstraint> constraintsWithErrors;

	/**
	 * This {@link AttributeValueConstraintReferenceValueCalculator} will be used for calculating referenceValues that
	 * are needed for {@link ValueConstraint}
	 */
	private AttributeValueConstraintReferenceValueCalculator refValueCalculator;

	private Map<SourceSection, List<MatchedSectionDescriptor>> sections2Descriptors;

	/**
	 * This creates an instance.
	 *
	 * @param containmentTree
	 *            The {@link ContainmentTree} representing the source models to be matched.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the ' <em>containmentTree</em>' shall be matched
	 *            against.
	 * @param globalValues
	 *            The list of {@link MappingModel#getGlobalValues() global values} modeled in the PAMTraM instance.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} to be used.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public SourceSectionMatcher(ContainmentTree containmentTree, EList<SourceSection> sourceSections,
			Map<FixedValue, String> globalValues, IAmbiguityResolvingStrategy ambiguityResolvingStrategy,
			Logger logger) {

		this.containmentTree = containmentTree;
		this.sourceSections = sourceSections;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.logger = logger;
		this.matchedSections = new HashMap<>();
		this.matchedContainers = new HashMap<>();
		this.constraintsWithErrors = Collections.synchronizedSet(new HashSet<>());
		GlobalValueMap globalValueMap = new GlobalValueMap(globalValues, new HashMap<>());
		this.refValueCalculator = new AttributeValueConstraintReferenceValueCalculator(globalValueMap,
				new AttributeValueCalculator(globalValueMap, AttributeValueModifierExecutor.getInstance(), logger),
				logger);
	}

	/**
	 * This iterates through the {@link #containmentTree} and tries to match each of the given {@link #sourceSections}
	 * against the elements represented in the tree. The result of this process is a list of
	 * {@link MatchedSectionDescriptor MatchedSectionDescriptors} that will be returned.
	 *
	 * @return The set of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that represents the result of the
	 *         matching process.
	 */
	public Map<SourceSection, List<MatchedSectionDescriptor>> matchSections() {

		this.sections2Descriptors = new HashMap<>();

		while (this.containmentTree.getNumberOfAvailableElements() > 0) {

			EObject element = this.containmentTree.getNextElementForMatching();

			Map<SourceSection, MatchedSectionDescriptor> matches = this.findApplicableSections(element);

			// If there are multiple matches, select the one section to actually
			// apply.
			//
			MatchedSectionDescriptor descriptor = this.selectApplicableSection(element, matches);

			if (descriptor == null) {
				continue;
			}

			/*
			 * Register the created descriptor in the 'sections2Descriptors' map that will be returned in the end
			 */
			this.registerDescriptor((SourceSection) descriptor.getAssociatedSourceSectionClass(), descriptor);

			/*
			 * Before returning the matched sections, we mark the affected elements as 'matched' in the containment tree
			 * and update the 'matchedSections' map
			 */
			this.updateMatchedElements(descriptor);

		}

		return this.sections2Descriptors;
	}

	/**
	 * Add the given <em>descriptor</em> to the {@link #sections2Descriptors} map.
	 *
	 * @param sourceSection
	 *            The {@link SourceSection} that the given <em>descriptor</em> represents.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} to add.
	 */
	private void registerDescriptor(SourceSection sourceSection, MatchedSectionDescriptor descriptor) {

		List<MatchedSectionDescriptor> descriptors = this.sections2Descriptors.containsKey(sourceSection)
				? this.sections2Descriptors.get(sourceSection) : new ArrayList<>();

		descriptors.add(descriptor);
		this.sections2Descriptors.put(sourceSection, descriptors);
	}

	/**
	 * Update the {@link #matchedSections} and mark matched elements in the {@link ContainmentTree#markAsMatched(Set)
	 * containmentTree} based on the given '<em>descriptor</em>'.
	 *
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} describing the matched elements.
	 */
	private void updateMatchedElements(MatchedSectionDescriptor descriptor) {

		for (final SourceSectionClass c : descriptor.getSourceModelObjectsMapped().keySet()) {

			if (!this.matchedSections.containsKey(c)) {
				this.matchedSections.put(c, new LinkedHashSet<EObject>());
			}
			this.matchedSections.get(c).addAll(descriptor.getSourceModelObjectsMapped().get(c));
			this.containmentTree.markAsMatched(descriptor.getSourceModelObjectsMapped().get(c));
		}
	}

	/**
	 * Update the {@link #matchedContainers} and mark matched elements in the {@link ContainmentTree#markAsMatched(Set)
	 * containmentTree} based on the given '<em>descriptor</em>'.
	 *
	 * @param containerDescriptor
	 *            The {@link MatchedSectionDescriptor} describing the matched container elements.
	 */
	private void updateMatchedContainers(MatchedSectionDescriptor containerDescriptor) {

		for (final SourceSectionClass c : containerDescriptor.getSourceModelObjectsMapped().keySet()) {

			if (!this.matchedContainers.containsKey(c)) {
				this.matchedContainers.put(c, new LinkedHashSet<EObject>());
			}
			this.matchedContainers.get(c).addAll(containerDescriptor.getSourceModelObjectsMapped().get(c));
			this.containmentTree.markAsMatched(containerDescriptor.getSourceModelObjectsMapped().get(c));
		}
	}

	/**
	 * This determines and returns all applicable source sections for the given source model <em>element</em>.
	 *
	 * @param element
	 *            The element from the source model for that the applicable source sections shall be determined.
	 * @return A map that contains all applicable mappings and the associated {@link MappingInstanceStorage
	 *         MappingInstanceStorages}.
	 */
	private Map<SourceSection, MatchedSectionDescriptor> findApplicableSections(final EObject element) {

		/*
		 * This keeps track of all found possible sections (a MatchedSectionDescriptor is created for every mapping).
		 */
		final Map<SourceSection, MatchedSectionDescriptor> mappingData = new LinkedHashMap<>();

		/*
		 * Now, iterate over all sections and find those that are applicable for the current 'element'.
		 */
		this.sourceSections.parallelStream().filter(section -> section.getEClass().isSuperTypeOf(element.eClass()))
				.sequential().forEach(section -> this.findApplicableSection(element, mappingData, section));

		return mappingData;
	}

	/**
	 * If multiple applicable sections have been found for an element of the source model during
	 * {@link #findApplicableSections(EObject)}, one of the sections needs to be selected that shall actually be used.
	 * Therefore, we first select those matched sections that match the most elements. If there are multiple sections
	 * that match the same number of elements, we apply the AmbiguityResolvingStrategy.
	 *
	 * @param element
	 *            The {@link EObject element} of the source model for that we are selecting an applicable section.
	 * @param matches
	 *            The applicable sections.
	 * @return The {@link MatchedSectionDescriptor} representing the selected {@link SourceSection} or '<em>null</em>'
	 *         if no descriptor was selected.
	 */
	private MatchedSectionDescriptor selectApplicableSection(EObject element,
			Map<SourceSection, MatchedSectionDescriptor> matches) {

		if (matches.isEmpty()) {
			return null;
		} else if (matches.size() == 1) {
			return matches.values().iterator().next();
		}

		// First, we collect those matches that cover the most elements of the
		// source model
		//
		List<MatchedSectionDescriptor> matchesWithMaximumElements = new ArrayList<>();

		int maxMatchedElements = 0;
		for (MatchedSectionDescriptor match : matches.values()) {

			if (match.getSourceModelObjectFlat().size() >= maxMatchedElements) {

				if (match.getSourceModelObjectFlat().size() > maxMatchedElements) {
					maxMatchedElements = match.getSourceModelObjectFlat().size();
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
			this.logger.severe(e.getMessage());
			return null;
		}
	}

	/**
	 * This checks if the given {@link SourceSection} is applicable for the given source model <em>element</em>.
	 * Therefore, it first {@link #checkContainerSection(EObject, SourceSection) checks the container} and then the
	 * {@link #checkSection(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor) section itself.}
	 * <p />
	 * If the section is applicable, this stores the result in the <em>mappingData</em>.
	 *
	 * @param element
	 *            The {@link EObject} from the source model for that the applicability of the source section shall be
	 *            determined.
	 * @param mappingData
	 *            The map where applicable sections are stored.
	 * @param section
	 *            The {@link SourceSection} to check.
	 */
	private void findApplicableSection(final EObject element,
			final Map<SourceSection, MatchedSectionDescriptor> mappingData, SourceSection section) {

		MatchedSectionDescriptor descriptor;

		/*
		 * check if the section that is referenced as 'container' can be matched
		 */
		boolean failed = !this.checkContainerSection(element, section);

		if (failed) {
			return;
		}

		// check if the section itself is applicable
		//
		descriptor = this.checkSection(element, false, section, null);

		failed = descriptor == null;

		if (failed) {
			return;
		}

		// set the associated container descriptor
		//
		this.setContainerDescriptor(descriptor);

		// all checks were successful -> the section is applicable
		//
		mappingData.put(section, descriptor);
	}

	/**
	 * For a given {@link MatchedSectionDescriptor}, this extracts the associated '<em>container descriptor</em>' from
	 * the {@link #sections2Descriptors} map and
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

		if (!this.sections2Descriptors.containsKey(section.getContainer().getContainingSection())) {
			return false;
		}

		Set<MatchedSectionDescriptor> containerDescriptors = this.sections2Descriptors
				.get(section.getContainer().getContainingSection()).parallelStream()
				.filter(d -> d.getSourceModelObjectFlat().contains(element.eContainer())).collect(Collectors.toSet());

		assert containerDescriptors.size() == 1;

		descriptor.setContainerDescriptor(containerDescriptors.iterator().next());

		return true;
	}

	/**
	 * Check if the container section referenced by the {@link SourceSection SourceSection's}
	 * {@link Section#getContainer()} can be matched for the given element.
	 *
	 * @param element
	 *            The {@link EObject element} for that the container shall be checked.
	 * @param sourceSection
	 *            The {@link SourceSection} that specifies the container to be checked.
	 * @return '<em>true</em>' if the {@link Section#getContainer() container} of the SourceSection has not been set or
	 *         if a fitting container instance exists; '<em>false</em>' otherwise
	 */
	private boolean checkContainerSection(final EObject element, final SourceSection sourceSection) {

		if (sourceSection.getContainer() == null) {

			// this part is easy
			return true;
		}

		/*
		 * Step 1: Identify all container sections and the corresponding elements (and check if these elements match the
		 * EClass specified by the respective container section).
		 */
		final Map<SourceSection, EObject> containers = this.collectContainers(element, sourceSection);

		if (containers == null) {
			return false;
		}

		/*
		 * Step 2: Check if each container section (that has not already been matched) can be matched, starting from the
		 * highest
		 */
		return containers.entrySet().stream()
				.filter(container -> !this.checkObjectWasMapped(container.getKey(), container.getValue()))
				.allMatch(container -> {

					MatchedSectionDescriptor containerDescriptor = this.checkSection(container.getValue(), false,
							container.getKey(), null);
					if (containerDescriptor == null) {
						return false;
					}

					// Register the created container descriptor in the
					// 'sections2Descriptors' map that will be returned
					// in the end
					//
					this.registerDescriptor(container.getKey(), containerDescriptor);

					// Before returning the matched sections, we mark the
					// affected elements as 'matched' in the
					// containment tree and update the 'matchedSections' map
					//
					this.updateMatchedContainers(containerDescriptor);

					return true;
				});

	}

	/**
	 * For a given {@link SourceSection} and an {@link EObject element}, identify, check, and collect all container
	 * {@link SourceSections} and the corresponding {@link EObject elements} for a given combination.
	 *
	 * Note: This does not collect all elements all the way up but only those SourceSectionClasses for that
	 * 'isSection()' returns 'true'.
	 *
	 * @param element
	 *            The {@link EObject element} for that the containers shall be identified and checked.
	 * @param sourceSection
	 *            The {@link SourceSection} for that the containers shall be identified and checked.
	 * @return A map of identified {@link SourceSection SourceSections} and associated {@link EObject elements} or
	 *         '<em><b>null</b></em>' if at least one identified container {@link EObject element} was not of the
	 *         {@link EClass} specified by the associated {@link SourceSection}.
	 */
	private Map<SourceSection, EObject> collectContainers(final EObject element, final SourceSection sourceSection) {

		final Map<SourceSection, EObject> containers = new HashMap<>();

		SourceSectionClass currentClass = sourceSection;
		EObject currentElement = element;

		while (currentClass.getContainer() != null) {

			if (currentElement.eContainer() == null) {
				return null;
			}

			currentElement = currentElement.eContainer();
			currentClass = currentClass.getContainer();

			/*
			 * scan all levels of source section until we are at a top level again
			 *
			 * we do not concern ourselves with mapping of the elements at this point, all we need are the container
			 * sections
			 */
			while (!currentClass.getContainingSection().equals(currentClass)) {

				if (currentElement.eContainer() == null) {
					return null;
				}

				currentElement = currentElement.eContainer();
				currentClass = currentClass.getOwningContainmentReference().getOwningClass();
			}

			assert currentClass instanceof SourceSection;

			// we found a container class (and its matching element)
			//
			containers.put((SourceSection) currentClass, currentElement);

		}
		return containers;
	}

	/**
	 * This recursively checks if a {@link SourceSectionClass} is applicable for a certain part of the source model.
	 * Therefore, it iterates downward in the containment hierarchy of the source section and checks if every element
	 * can be matched to a part of the source model.
	 *
	 * @param srcModelObject
	 *            The element of the source model that is currently evaluated for applicability.
	 * @param usedOkay
	 *            Whether elements already contained in <em>newRefsAndHints</em> can be matched again. This needs to be
	 *            set to '<em>true</em> when
	 *            {@link #checkSection(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)} is called for a
	 *            non-containment reference.
	 * @param srcSection
	 *            The {@link SourceSectionClass} (either the sourceMMSection itself or a direct or indirect child of it)
	 *            that is currently checked.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for the parent {@link SourceSectionClass element}.
	 *
	 * @return The {@link MatchedSectionDescriptor} representing the matched section (including all matched child
	 *         elements).
	 */
	private MatchedSectionDescriptor checkSection(final EObject srcModelObject, final boolean usedOkay,
			final SourceSectionClass srcSection, final MatchedSectionDescriptor parentDescriptor) {

		final boolean classFits = srcSection.getEClass().isSuperTypeOf(srcModelObject.eClass());

		// first of all: check if usedRefs contains this item and if type fits
		// (we do not check any of the used elements of other mappings, since
		// they will be in a different section of the containment tree )
		//
		// TODO Is the 'containsSourceModelObjectMapped' check even necessary?
		// If this returns true, we must deal with a NC-reference - in this
		// case, however, the 'usedOkay' flag should be set to 'true'!
		if (!usedOkay && parentDescriptor != null && parentDescriptor.containsSourceModelObjectMapped(srcModelObject)
				|| !classFits) {
			return null;
		}

		// this is the 'MatchedSectionDescriptor' that we will return this in
		// case we find the mapping to be applicable
		// else we return null
		//
		final MatchedSectionDescriptor descriptor = new MatchedSectionDescriptor();
		descriptor.setAssociatedSourceModelElement(srcModelObject);
		descriptor.setAssociatedSourceSectionClass(srcSection);

		// set the list of source model objects that have been mapped.
		// first, add all mapped objects from 'changedRefsAndHints' ...
		if (parentDescriptor != null) {
			descriptor.addSourceModelObjectsMapped(parentDescriptor.getSourceModelObjectsMapped());
		}
		// ..., then add the current srcModelObject
		descriptor.addSourceModelObjectMapped(srcModelObject, srcSection);

		/*
		 * check if all attributes are present and valid
		 */
		boolean attributesOk = this.checkAttributes(srcModelObject, srcSection, descriptor);

		if (!attributesOk) {
			return null;
		}

		/*
		 * check if all modeled references can be matched; this will also iterate further down the hierarchy (and
		 * thereby call 'checkMapping', 'checkAttributes' and 'checkReferences' multiple times)
		 */
		boolean referencesOk = this.checkReferences(srcModelObject, usedOkay, srcSection, descriptor);

		if (!referencesOk) {
			return null;
		}

		// set the associated container descriptor
		//
		descriptor.setContainerDescriptor(parentDescriptor);

		return descriptor;

	}

	/**
	 * This checks if all {@link SourceSectionReference references} that have been defined for a given
	 * {@link SourceSectionClass} can be matched for the given '<em>srcModelObject</em>'. Therefore, all
	 * {@link SourceSectionClass#getCardinality() cardinalities} of referenced {@link SourceSectionClass classes} are
	 * checked. <br />
	 * <b>Note:</b> For every {@link SourceSectionClass class} that is referenced by a modeled
	 * {@link SourceSectionReference reference}, this calls
	 * {@link #checkSection(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)} so that we iteratively go
	 * through the complete hierarchy of the modeled section.
	 *
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param usedOkay
	 *            Whether elements already contained in <em>descriptor<em> can be matched again. This needs to be set to
	 *            '<em>true</em> when
	 *            {@link #checkReferences(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)
	 *            checkReferences()} is called for elements referenced by a non-containment reference.
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
	@SuppressWarnings("unchecked")
	private boolean checkReferences(final EObject srcModelObject, final boolean usedOkay,
			final SourceSectionClass sourceSectionClass, final MatchedSectionDescriptor descriptor) {

		// Collect the modeled references and reference targets
		// (SourceSectionClasses) for the
		// current 'sourceSectionClass' and store them in to maps
		//
		Map<EReference, List<SourceSectionClass>> classByRefMap = sourceSectionClass.getReferences().parallelStream()
				.collect(Collectors.toConcurrentMap(r -> r.getEReference(), r -> r.getValuesGeneric(), (i, j) -> {
					i.addAll(j);
					return i;
				}));
		Map<SourceSectionClass, SourceSectionReference> refByClassMap = new ConcurrentHashMap<>();
		sourceSectionClass.getReferences().parallelStream()
				.forEach(r -> r.getValuesGeneric().parallelStream().forEach(c -> refByClassMap.put(c, r)));

		// now, iterate through all the modeled references (and reference
		// targets) and check if they can be matched for
		// the current 'srcModelObject'
		//
		for (final Entry<EReference, List<SourceSectionClass>> entry : classByRefMap.entrySet()) {

			// the reference that we are currently checking
			//
			EReference reference = entry.getKey();

			// the SourceSectionClasses that have been modeled for the
			// 'reference' in the pamtram model
			//
			List<SourceSectionClass> classes = entry.getValue();

			if (classes.isEmpty()) {

				/*
				 * if no target SourceSectionClass has been specified, this means that there must be NO target element
				 * in the source model; if this is not the case (meaning that there is a target element for the
				 * reference), the mapping is not applicable
				 */
				if (reference.isMany() && !((EList<EObject>) srcModelObject.eGet(reference)).isEmpty()
						|| !reference.isMany() && srcModelObject.eGet(reference) != null) {
					return false;
				} else {
					continue;
				}
			}

			// get targets of the reference in the source model, then proceed
			// depending on the cardinality of the
			// reference
			//
			final Object refTarget = srcModelObject.eGet(reference);

			if (!reference.isMany()) {

				// check the single-valued reference
				//
				if (!this.checkSingleValuedReference((EObject) refTarget, descriptor, classes, refByClassMap, usedOkay,
						sourceSectionClass)) {
					return false;
				}

			} else {

				// check the multi-valued reference
				//
				if (!this.checkManyValuedReference(new ArrayList<>((Collection<EObject>) refTarget), descriptor,
						classes, refByClassMap, usedOkay)) {
					return false;
				}
			}

		}

		return true;
	}

	/**
	 * This checks if the given <em>refTargetObj</em> that is referenced by a {@link EReference#isMany() single-valued}
	 * reference can be matched for the given {@link MatchedSectionDescriptor} representing the referencing element.
	 * <p />
	 * Note: This iterates further downward in the containment hierarchy by calling
	 * {@link #checkSection(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)}.
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
	 * @param usedOkay
	 *            Whether elements already contained in <em>descriptor<em> can be matched again. This needs to be set to
	 *            '<em>true</em> when this is called if <em>refTargetObj</em> is referenced by a non-containment
	 *            reference.
	 * @param sourceSectionClass
	 *            The parent {@link SourceSectionClass} for which the references shall be checked.
	 * @return '<em><b>true</b></em>' if the check succeeded; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkSingleValuedReference(final EObject referencedElement,
			final MatchedSectionDescriptor descriptor, List<SourceSectionClass> classes,
			final Map<SourceSectionClass, SourceSectionReference> refByClassMap, final boolean usedOkay,
			final SourceSectionClass sourceSectionClass) {

		if (referencedElement == null) {
			return false;
		}

		MatchedSectionDescriptor childDescriptor = null;
		boolean nonZeroCardSectionFound = false;

		// check non-zero classes (classes with a lower bound != ZERO) first; it
		// doesn't make sense in this case to
		// model ZERO_INFINITY sections, if there is one section with a minimum
		// cardinality of 1, but it can be handled
		//
		List<SourceSectionClass> nonZeroClasses = classes.parallelStream()
				.filter(c -> !c.getCardinality().equals(CardinalityType.ZERO_INFINITY)).collect(Collectors.toList());

		for (final SourceSectionClass c : nonZeroClasses) {

			if (nonZeroCardSectionFound) {

				// modeling error
				this.logger.severe("Modeling error in source section: '" + sourceSectionClass.getContainer().getName()
						+ "', subsection: '" + sourceSectionClass.getName() + "'. The Reference '"
						+ refByClassMap.get(c)
						+ "' points to a metamodel reference, that can only hold one value but in the source section "
						+ "it references more than one Class with a CardinalityType that is not ZERO_INFINITY.");
				return false;
			}

			nonZeroCardSectionFound = true;

			// iterate further
			//
			childDescriptor = this.checkSection(referencedElement,
					refByClassMap.get(c) instanceof SourceSectionCrossReference || usedOkay, c, descriptor);
		}

		if (!nonZeroCardSectionFound) {

			// if no non-zero class has been found, try to match classes with a
			// lower bound of ZERO
			//
			List<SourceSectionClass> zeroClasses = classes.parallelStream()
					.filter(c -> c.getCardinality().equals(CardinalityType.ZERO_INFINITY)).collect(Collectors.toList());
			for (final SourceSectionClass c : zeroClasses) {

				// iterate further
				//
				childDescriptor = this.checkSection(referencedElement,
						refByClassMap.get(c) instanceof SourceSectionCrossReference || usedOkay, c, descriptor);

				if (childDescriptor != null) {
					break;
				}
			}
		}

		// none of the given classes could be matched
		//
		if (childDescriptor == null) {
			return false;
		}

		// one of the classes could be matched, so we update the given parent
		// descriptor
		//
		descriptor.add(childDescriptor);

		// if the given descriptor was retrieved via a
		// MetaModelSectionReference, we need to register this descriptor in
		// the 'sections2Descriptors' map that will be returned in the end
		//
		if (refByClassMap.get(childDescriptor.getAssociatedSourceSectionClass()) instanceof SourceSectionCrossReference
				&& childDescriptor.getAssociatedSourceSectionClass() instanceof SourceSection) {

			this.registerDescriptor((SourceSection) childDescriptor.getAssociatedSourceSectionClass(), childDescriptor);
		}

		return true;
	}

	/**
	 * This checks if the given list of <em>referencedElements</em> that are referenced by a {@link EReference#isMany()
	 * many-valued} reference can be matched for the given {@link MatchedSectionDescriptor} representing the referencing
	 * element.
	 * <p />
	 * Note: This iterates further downward in the containment hierarchy by calling
	 * {@link #checkSection(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)}.
	 *
	 * @param referencedElements
	 *            The {@link EObject elements} to check.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} representing the {@link EObject} that references the given
	 *            <em>referencedElements</em>.
	 * @param classes
	 *            The list of {@link SourceSectionClass SourceSectionClasses} that have been modeled as target for the
	 *            current reference to be checked (these are the potential matches for the given
	 *            <em>referencedElements</em>).
	 * @param refByClassMap
	 *            A map that collects all {@link SourceSectionClass SourceSectionClasses} and the
	 *            {@link SourceSectionReference} that they are referenced by.
	 * @param usedOkay
	 *            Whether elements already contained in <em>descriptor<em> can be matched again. This needs to be set to
	 *            '<em>true</em> when this is called if <em>referencedElements</em> are referenced by a non-containment
	 *            reference.
	 *
	 * @return '<em><b>true</b></em>' if the check succeeded; '<em><b>false</b></em>' otherwise.
	 */
	private boolean checkManyValuedReference(final List<EObject> referencedElements,
			final MatchedSectionDescriptor descriptor, List<SourceSectionClass> classes,
			final Map<SourceSectionClass, SourceSectionReference> refByClassMap, final boolean usedOkay) {

		/*
		 * this is a little more complicated: now we need to find ONE possible way to map our referenceTargets to the
		 * source sections
		 *
		 * To do this we need to find out first which MMSections are applicable to which srcModel sections.
		 *
		 * Then we try to find a way to map one srcModelSection to each MMSection
		 */

		// Map to store possible srcModelSections to MMSections (non-vc)
		//
		final SourceSectionMatchingResultsMap possibleSrcModelElementsNoVC = new SourceSectionMatchingResultsMap();
		classes.stream().filter(val -> val.getCardinality().equals(CardinalityType.ONE))
				.forEach(possibleSrcModelElementsNoVC::init);

		// Map to store possible srcModelSections to MMSections (vc)
		//
		final SourceSectionMatchingResultsMap possibleSrcModelElementsVC = new SourceSectionMatchingResultsMap();
		classes.stream().filter(val -> !val.getCardinality().equals(CardinalityType.ONE))
				.forEach(possibleSrcModelElementsVC::init);

		final LinkedHashSet<EObject> elementsUsableForVC = new LinkedHashSet<>();

		// First, find all possible matches for all referenced elements
		//
		for (final EObject rt : referencedElements) {
			boolean foundMapping = false;

			for (final SourceSectionClass val : classes) {

				final MatchedSectionDescriptor childDescriptor = this.checkSection(rt,
						refByClassMap.get(val) instanceof SourceSectionCrossReference || usedOkay, val, descriptor);

				// we found a match
				//
				if (childDescriptor != null) {
					foundMapping = true;

					if (!val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsVC.get(val).add(childDescriptor);
						elementsUsableForVC.add(rt);

					} else {
						possibleSrcModelElementsNoVC.get(val).add(childDescriptor);
					}
				}
			}

			if (!foundMapping) {
				// we need to find a mapping for every srcModelElement if the
				// reference Type was modeled in the
				// srcMMSection
				//
				return false;
			}
		}

		final List<EObject> allElementsMapped = new ArrayList<>();

		// Now, try to satisfy the SourceSectionClasses with a fixed cardinality
		// (no-vc)
		//
		while (!possibleSrcModelElementsNoVC.keySet().isEmpty()) {

			final SourceSectionClass smallestKey = possibleSrcModelElementsNoVC
					.getKeyForValueWithSmallestCollectionSize();

			if (!possibleSrcModelElementsNoVC.get(smallestKey).isEmpty()) {

				MatchedSectionDescriptor srcSectionResult;

				// we need to filter a little more
				//
				if (possibleSrcModelElementsNoVC.get(smallestKey).size() > 1) {

					List<MatchedSectionDescriptor> possibleElements = new ArrayList<>();
					possibleElements.addAll(possibleSrcModelElementsNoVC.get(smallestKey));

					// filter elements that can be used for a vc-section
					final List<MatchedSectionDescriptor> allVCIncompatible = new ArrayList<>();

					allVCIncompatible.addAll(possibleElements.parallelStream()
							.filter(s -> !elementsUsableForVC.contains(s.getAssociatedSourceModelElement()))
							.collect(Collectors.toList()));

					if (!allVCIncompatible.isEmpty()) {
						possibleElements = allVCIncompatible;
					}

					srcSectionResult = SourceSectionMatcher.getResultForLeastUsedSrcModelElement(possibleElements);

				} else {
					srcSectionResult = possibleSrcModelElementsNoVC.get(smallestKey).getFirst();
				}

				// remember mapping
				//
				descriptor.add(srcSectionResult);

				if (refByClassMap.get(
						srcSectionResult.getAssociatedSourceSectionClass()) instanceof SourceSectionCrossReference) {
					/*
					 * Register the created child descriptor in the 'sections2Descriptors' map that will be returned in
					 * the end
					 */
					if (srcSectionResult.getAssociatedSourceSectionClass() instanceof SourceSection) {
						this.registerDescriptor((SourceSection) srcSectionResult.getAssociatedSourceSectionClass(),
								srcSectionResult);
					}
				}

				allElementsMapped.add(srcSectionResult.getAssociatedSourceModelElement());
				// remove srcModel element from possibility lists of
				// MMSections
				possibleSrcModelElementsNoVC.removeResultsForElement(srcSectionResult);
				possibleSrcModelElementsVC.removeResultsForElement(srcSectionResult);
				possibleSrcModelElementsNoVC.remove(smallestKey);
				/*
				 * successfully mapped mmSection from list
				 */

			} else {
				// all non-vc-elements need to be mapped exactly once
				//
				return false;
			}
		}

		// Now, we can match the SourceSectionClasses with a variable
		// cardinality (vc)
		//

		// for counting cardinality
		//
		final HashSet<SourceSectionClass> usedKeys = new HashSet<>();

		while (!possibleSrcModelElementsVC.keySet().isEmpty()) {

			final SourceSectionClass smallestKey = possibleSrcModelElementsVC
					.getKeyForValueWithSmallestCollectionSize();
			if (!possibleSrcModelElementsVC.get(smallestKey).isEmpty()) {

				usedKeys.add(smallestKey);
				MatchedSectionDescriptor srcSectionResult;

				// we need to filter a little more
				//
				if (possibleSrcModelElementsVC.get(smallestKey).size() > 1) {

					srcSectionResult = SourceSectionMatcher
							.getResultForLeastUsedSrcModelElement(possibleSrcModelElementsVC.get(smallestKey));

				} else {
					srcSectionResult = possibleSrcModelElementsVC.get(smallestKey).getFirst();
				}

				// remember mapping
				descriptor.add(srcSectionResult);
				if (refByClassMap.get(
						srcSectionResult.getAssociatedSourceSectionClass()) instanceof SourceSectionCrossReference) {
					/*
					 * Register the created child descriptor in the 'sections2Descriptors' map that will be returned in
					 * the end
					 */
					if (srcSectionResult.getAssociatedSourceSectionClass() instanceof SourceSection) {
						this.registerDescriptor((SourceSection) srcSectionResult.getAssociatedSourceSectionClass(),
								srcSectionResult);
					}
				}

				allElementsMapped.add(srcSectionResult.getAssociatedSourceModelElement());

				// remove srcModel element from possibility lists of
				// MMSections
				possibleSrcModelElementsVC.removeResultsForElement(srcSectionResult);

			} else if (usedKeys.contains(smallestKey)
					|| smallestKey.getCardinality().equals(CardinalityType.ZERO_INFINITY)) {
				// remove mmSection from list
				possibleSrcModelElementsVC.remove(smallestKey);
			} else {
				// the fact that samllestKey is not in the collection
				// means that no mapping was found at all
				return false;
			}
		}

		// check if all refTargets where mapped
		referencedElements.removeAll(allElementsMapped);
		if (!referencedElements.isEmpty()) {
			this.logger.warning("Not everything could be mapped");
			return false;
		}

		return true;
	}

	/**
	 * This checks if all {@link SourceSectionAttribute attributes} that have been defined for a given
	 * {@link SourceSectionClass} can be mapped for the given '<em>srcModelObject</em>'. Therefore, all the
	 * {@link ValueConstraint AttributeValueConstraints} are checked.
	 *
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param srcSection
	 *            The {@link SourceSectionClass} for which the attributes shall be checked.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for the current matching process.
	 * @return '<em></b>true</b></em>' if all attributes are present and satisfy the modeled constraints, '
	 *         <em><b>false</b></em>' otherwise
	 */
	private boolean checkAttributes(final EObject srcModelObject, final SourceSectionClass srcSection,
			final MatchedSectionDescriptor descriptor) {

		srcSection.getAttributes().parallelStream().filter(at -> !(at instanceof ActualSourceSectionAttribute))
				.forEach(at -> this.logger.severe(
						"SourceSectionAttributes of type '" + at.eClass().getName() + "' are not yet supported!"));

		// Check if all the constraints are satisfied for every attribute value.
		//
		List<ActualSourceSectionAttribute> actualAttributes = srcSection.getAttributes().stream()
				.filter(at -> at instanceof ActualSourceSectionAttribute).map(at -> (ActualSourceSectionAttribute) at)
				.collect(Collectors.toList());

		return actualAttributes.parallelStream().allMatch(at -> {
			List<Object> values = AgteleEcoreUtil.getAttributeValueAsList(srcModelObject, at.getAttribute());
			if (values.isEmpty()) {
				// add an 'empty' value
				values.add(null);
			}
			return values.parallelStream()
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

		// convert Attribute value to String
		String srcAttrAsString;

		if (value instanceof String) {
			srcAttrAsString = (String) value;
		} else if (attribute instanceof ActualSourceSectionAttribute) {
			srcAttrAsString = ((ActualSourceSectionAttribute) attribute).getAttribute().getEType().getEPackage()
					.getEFactoryInstance().convertToString(
							((ActualSourceSectionAttribute) attribute).getAttribute().getEAttributeType(), value);
		} else {
			this.logger.severe("Unable to convert the following value of the SourceSectionAttribute '"
					+ attribute.toString() + "' to a String: '" + value.toString() + "'");
			return false;
		}

		/*
		 * check AttributeValueConstraints
		 *
		 * Inclusions are OR connected
		 *
		 * Exclusions are NOR connected
		 */
		boolean inclusionMatched = false;
		boolean containsInclusions = false;

		List<ValueConstraint> validConstraints = attribute.getValueConstraint().parallelStream()
				.filter(c -> !this.constraintsWithErrors.contains(c)).collect(Collectors.toList());

		// Check each constraint
		//
		for (final ValueConstraint constraint : validConstraints) {

			try {

				boolean constraintVal = this.checkAttributeValueConstraint(srcAttrAsString, constraint);

				if (!constraintVal && constraint.getType().equals(ValueConstraintType.FORBIDDEN)) {

					return false;

				} else if (constraint.getType().equals(ValueConstraintType.REQUIRED)) {

					containsInclusions = true;
					inclusionMatched = constraintVal;
				}

			} catch (final Exception e) {
				this.constraintsWithErrors.add(constraint);
				this.logger.warning("The AttributeValueConstraint '" + constraint.getName() + "' of the Attribute '"
						+ attribute.getName() + " (Class: " + attribute.getOwningClass().getName() + ", Section: "
						+ attribute.getContainingSection().getName()
						+ ")' could not be evaluated and will be ignored. The following error was supplied:\n"
						+ e.getLocalizedMessage());
			}

		}

		// If we arrive at this point, the constraint is valid unless there is
		// an unmatched 'inclusion'
		//
		return !containsInclusions || inclusionMatched;
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
			this.logger
					.severe("ReferenceableElement type " + constraint.getClass().getName() + " is not yet supported!");
		}

		return constraintVal;
	}

	/**
	 * This can be used to check if a given '<em>sourceSectionClass</em>' and the corresponding '<em>element</em>' have
	 * been previously matched (by another section).
	 *
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} that shall be checked for previous matching.
	 * @param element
	 *            The {@link EObject} that shall be checked for previous matching.
	 */
	private boolean checkObjectWasMapped(final SourceSectionClass sourceSectionClass, final EObject element) {

		if (element == null) {
			return false;
		}

		return this.matchedSections.containsKey(sourceSectionClass)
				&& this.matchedSections.get(sourceSectionClass).contains(element)
				|| this.matchedContainers.containsKey(sourceSectionClass)
						&& this.matchedContainers.get(sourceSectionClass).contains(element);
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
		final Map<EObject, Integer> usages = possibleElements.parallelStream()
				.map(e -> e.getAssociatedSourceModelElement())
				.collect(Collectors.toConcurrentMap(element -> element, element -> 1, (i, j) -> i + j));

		// use one of the mappings for one of the elements with the least
		// possible mappings
		//
		EObject leastUsed = usages.entrySet().parallelStream()
				.sorted((e1, e2) -> e1.getValue() < e2.getValue() ? -1 : 1).findFirst().get().getKey();

		// return the descriptor representing the 'leastUsed' element
		//
		return possibleElements.parallelStream().filter(d -> d.getAssociatedSourceModelElement().equals(leastUsed))
				.findAny().get();

	}
}