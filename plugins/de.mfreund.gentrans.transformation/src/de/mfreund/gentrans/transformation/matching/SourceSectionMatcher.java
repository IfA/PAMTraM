package de.mfreund.gentrans.transformation.matching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.ContainmentTree;
import de.mfreund.gentrans.transformation.ReferenceableValueCalculator;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.Section;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;

/**
 * This class can be used to match a list of {@link #sourceSections} against a
 * {@link #containmentTree}.
 * 
 * 
 * @author mfreund
 */
public class SourceSectionMatcher {

	/**
	 * The {@link ContainmentTree} that represents the list of source models to
	 * be matched.
	 */
	private final ContainmentTree containmentTree;

	/**
	 * The list of {@link SourceSection SourceSections} that this matcher
	 * operates on. These are matched against the {@link #containmentTree} in
	 * the course of the matching process.
	 */
	private EList<SourceSection> sourceSections;

	/**
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	private MessageConsoleStream consoleStream;

	/**
	 * Registry for <em>source model elements</em> that have already been
	 * matched. The matched elements are stored in a map where the key is the
	 * corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private final Map<SourceSectionClass, Set<EObject>> matchedSections;

	/**
	 * Registry for <em>source model elements</em> that were not directly
	 * matched but indirectly matched as part of a container section. The
	 * matched objects are stored in a map where the key is the corresponding
	 * {@link SourceSectionClass container section} that they have been matched
	 * to.
	 */
	private final Map<SourceSectionClass, Set<EObject>> matchedContainers;

	/**
	 * This keeps track of all {@link AttributeValueConstraint
	 * AttributeValueConstraints} that could not be evaluated so we don't need
	 * to send a potential error message twice. This might e.g. happen for a
	 * malformed regular expression in a {@link RegExMatcher}.
	 */
	private final Set<AttributeValueConstraint> constraintsWithErrors;

	/**
	 * This {@link ReferenceableValueCalculator} will be used for calculating
	 * referenceValues that are needed for {@link AttributeValueConstraint}
	 */
	private ReferenceableValueCalculator refValueCalculator;

	/**
	 * This creates an instance.
	 * 
	 * @param containmentTree
	 *            The {@link ContainmentTree} representing the source models to
	 *            be matched.
	 * @param sourceSections
	 *            The list of {@link SourceSection SourceSections} that the '
	 *            <em>containmentTree</em>' shall be matched against.
	 * @param consoleStream
	 *            The {@link MessageConsoleStream} that shall be used to print
	 *            messages.
	 */
	public SourceSectionMatcher(ContainmentTree containmentTree, EList<SourceSection> sourceSections,
			MessageConsoleStream consoleStream) {

		this.containmentTree = containmentTree;
		this.sourceSections = sourceSections;
		this.consoleStream = consoleStream;
		this.matchedSections = new HashMap<>();
		this.matchedContainers = new HashMap<>();
		this.constraintsWithErrors = new HashSet<>();
	}

	/**
	 * This iterates through the {@link #containmentTree} and tries to match each of the given
	 * {@link #sourceSections} against the elements represented in the tree. The result of this
	 * process is a list of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that will
	 * be returned.
	 * 
	 * @return The set of {@link MatchedSectionDescriptor MatchedSectionDescriptors} that represents
	 * the result of the matching process.
	 */
	public Map<SourceSection, MatchedSectionDescriptor> matchSections() {

		// This will be returned in the end
		//
		Map<SourceSection, MatchedSectionDescriptor> result = new HashMap<>();

		while (containmentTree.getNumberOfAvailableElements() > 0) {

			EObject element = containmentTree.getNextElementForMatching();

			result.putAll(findApplicableSections(element));

		}

		return result;
	}

	/**
	 * This determines and returns all applicable source sections for the given
	 * source model <em>element</em>.
	 *
	 * @param element
	 *            The element from the source model for that the applicable
	 *            source sections shall be determined.
	 * @return A map that contains all applicable mappings and the associated
	 *         {@link MappingInstanceStorage MappingInstanceStorages}.
	 */
	private Map<SourceSection, MatchedSectionDescriptor> findApplicableSections(final EObject element) {

		/*
		 * This keeps track of all found possible sections (a
		 * MatchedSectionDescriptor is created for every mapping).
		 */
		final Map<SourceSection, MatchedSectionDescriptor> mappingData = new LinkedHashMap<>();

		/*
		 * Now, iterate over all sections and find those that are applicable for
		 * the current 'element'.
		 */
		for (final SourceSection section : this.sourceSections) {

			MatchedSectionDescriptor descriptor;

			/*
			 * This check is also done by 'findMapping(EObject, ...)', but since
			 * it will most likely fail at the top level, for most mappings we
			 * do it here before we construct any collections and so on. This
			 * might save us a little time, but of course that depends on the
			 * number mappings and the source meta-model.
			 */
			if (section.getEClass().isSuperTypeOf(element.eClass())) {

				/*
				 * check if the section that is referenced as 'container' can be
				 * matched
				 */
				boolean failed = !checkContainerSection(element, section);

				if (failed) {
					continue;
				}

				// check if the section itself is applicable
				//
				descriptor = checkSection(element, false, section, null);

				failed = descriptor == null;

				if (failed) {
					continue;
				}

				// all checks were successful -> the section is applicable
				//
				mappingData.put(section, descriptor);
			}
		}

		return mappingData;
	}

	/**
	 * Check if the container section referenced by the {@link SourceSection
	 * SourceSection's} {@link Section#getContainer()} can be matched for the
	 * given element.
	 *
	 * @param element
	 *            The {@link EObject element} for that the container shall be
	 *            checked.
	 * @param sourceSection
	 *            The {@link SourceSection} that specifies the container to be
	 *            checked.
	 * @return '<em>true</em>' if the {@link Section#getContainer() container}
	 *         of the SourceSection has not been set or if a fitting container
	 *         instance exists; '<em>false</em>' otherwise
	 */
	private boolean checkContainerSection(final EObject element, final SourceSection sourceSection) {

		if (sourceSection.getContainer() == null) {

			// this part is easy
			return true;
		}

		/*
		 * Step 1: identify all containers and the corresponding elements; we do
		 * not collect all elements all the way up but only those
		 * SourceSectionClasses for that 'isSection()' returns 'true'
		 */
		final Map<SourceSection, EObject> containers = new HashMap<>();

		SourceSectionClass currentClass = sourceSection;
		EObject currentElement = element;

		while (currentClass.getContainer() != null) {

			if (currentElement.eContainer() != null) {
				return false;
			}

			currentElement = currentElement.eContainer();
			currentClass = currentClass.getContainer();

			/*
			 * scan all levels of source section until we are at a top level
			 * again
			 *
			 * we do not concern ourselves with mapping of the elements at this
			 * point, all we need are the container sections
			 */
			while (!currentClass.getContainingSection().equals(currentClass)) {

				if (currentElement.eContainer() == null) {
					return false;
				}

				currentElement = currentElement.eContainer();
				currentClass = currentClass.getOwningContainmentReference().getOwningClass();
			}

			assert currentClass instanceof SourceSection;

			// we found a container class (and its matching element)
			//
			containers.put((SourceSection) currentClass, currentElement);

		}

		/*
		 * Step 2: Check if each container section can be matched, starting from
		 * the highest
		 */
		for (Entry<SourceSection, EObject> container : containers.entrySet()) {
			/*
			 * map container if it wasn't mapped before
			 */
			if (!checkObjectWasMapped(container.getKey(), container.getValue())) {

				MatchedSectionDescriptor containerDescriptor = checkSection(container.getValue(), false,
						container.getKey(), null);
				if (containerDescriptor == null) {
					return false;
				}

				for (final SourceSectionClass c : containerDescriptor.getSourceModelObjectsMapped().keySet()) {
					if (!matchedContainers.containsKey(c)) {
						matchedContainers.put(c, new LinkedHashSet<EObject>());
					}
					matchedContainers.get(c).addAll(containerDescriptor.getSourceModelObjectsMapped().get(c));
				}

			}
		}

		// if we reached this point all went well.
		//
		return true;


	}

	/**
	 * This recursively checks if a {@link SourceSectionClass} is applicable for
	 * a certain part of the source model. Therefore, it iterates downward in
	 * the containment hierarchy of the source section and checks if every
	 * element can be matched to a part of the source model.
	 * 
	 * @param srcModelObject
	 *            The element of the source model that is currently evaluated
	 *            for applicability.
	 * @param usedOkay
	 *            Whether elements already contained in
	 *            <em>newRefsAndHints<em> can be matched again. This needs to be set to '<em>true</em>
	 *            when
	 *            {@link #checkMapping(EObject, boolean, Iterable, Iterable, Iterable, SourceSectionClass, MappingInstanceStorage)
	 *            checkMapping()} is called for a non-containment reference.
	 * @param srcSection
	 *            The {@link SourceSectionClass} (either the sourceMMSection
	 *            itself or a direct or indirect child of it) that is currently
	 *            checked.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for the parent
	 *            {@link SourceSectionClass element}.
	 * 
	 * @return The {@link MatchedSectionDescriptor} representing the matched
	 *         section (including all matched child elements).
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
		// Case
		// we find the mapping to be applicable
		// else we return null
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
		 * check if all attributes are present and valid; determine HintValues
		 */
		boolean attributesOk = checkAttributes(srcModelObject, srcSection, descriptor);

		if (!attributesOk) {
			return null;
		}

		/*
		 * Combine values of references of same type. if this gets to slow,
		 * maybe add a map (refBySectionByClass) to this class
		 */
		final Map<EReference, List<SourceSectionClass>> classByRefMap = new LinkedHashMap<>();
		final Map<SourceSectionClass, SourceSectionReference> refByClassMap = new HashMap<>();


		/*
		 * check if all modeled references can be matched; this will also
		 * iterate further down the hierarchy (and thereby call 'checkMapping',
		 * 'checkAttributes' and 'checkReferences' multiple times)
		 */
		boolean referencesOk = checkReferences(srcModelObject, usedOkay, srcSection, descriptor, classByRefMap,
				refByClassMap);

		if (!referencesOk) {
			return null;
		}

		return descriptor;

	}

	/**
	 * This checks if all {@link SourceSectionReference references} that have
	 * been defined for a given {@link SourceSectionClass} can be matched for
	 * the given '<em>srcModelObject</em>'. Therefore, all
	 * {@link SourceSectionClass#getCardinality() cardinalities} of referenced
	 * {@link SourceSectionClass classes} are checked. <br />
	 * <b>Note:<b/> For every {@link SourceSectionClass class} that is
	 * referenced by a modeled {@link SourceSectionReference reference}, this
	 * calls
	 * {@link #checkcheckMapping(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)
	 * checkMapping()} so that we iteratively go through the complete hierarchy
	 * of the modeled section.
	 * 
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param usedOkay
	 *            Whether elements already contained in
	 *            <em>descriptor<em> can be matched again. This needs to be set to '<em>true</em>
	 *            when
	 *            {@link #checkReferences(EObject, boolean, SourceSectionClass, MatchedSectionDescriptor)
	 *            checkReferences()} is called for elements referenced by a
	 *            non-containment reference.
	 * @param srcSection
	 *            The {@link SourceSectionClass} for which the references shall
	 *            be checked. The {@link MatchedSectionDescriptor} for the
	 *            {@link SourceSection} to be evaluated. Note: The same instance
	 *            will be used for the SourceSection and all child
	 *            SourceSectionClasses.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for the
	 *            {@link SourceSectionClass} to be evaluated.
	 * @param classByRefMap
	 *            A map that collects all {@link SourceSectionClass
	 *            SourceSectionClasses} and the {@link SourceSectionReference}
	 *            that they are referenced by.
	 * @param refByClassMap
	 *            A map that collects all {@link SourceSectionReference
	 *            SourceSectionReferences} and the {@link SourceSectionClass}
	 *            that they are contained in.
	 */
	@SuppressWarnings("unchecked")
	private boolean checkReferences(final EObject srcModelObject, final boolean usedOkay,
			final SourceSectionClass srcSection, final MatchedSectionDescriptor descriptor,
			final Map<EReference, List<SourceSectionClass>> classByRefMap,
			final Map<SourceSectionClass, SourceSectionReference> refByClassMap) {

		/*
		 * update the 'classByRef' and 'refByClass' map
		 */
		for (final SourceSectionReference ref : srcSection.getReferences()) {
			if (!classByRefMap.containsKey(ref.getEReference())) {
				classByRefMap.put(ref.getEReference(), new LinkedList<SourceSectionClass>());
			}

			classByRefMap.get(ref.getEReference()).addAll(ref.getValuesGeneric());

			for (final SourceSectionClass c : ref.getValuesGeneric()) {
				refByClassMap.put(c, ref);
			}
		}

		// now go through all the srcMmSection refs
		for (final Entry<EReference, List<SourceSectionClass>> entry : classByRefMap.entrySet()) {

			// the reference that we are currenlty checking
			//
			EReference reference = entry.getKey();
			// the SourceSectionClasses that have been modeled for the
			// 'reference' in the pamtram model
			//
			List<SourceSectionClass> classes = entry.getValue();

			// check if reference is allowed by src metamodel
			// check if reference in srcMMSection points anywhere
			if (classes.isEmpty()) {

				/*
				 * if no target SourceSectionClass has been specified, this
				 * means that there must be NO target element in the source
				 * model; if this is not the case (meaning that there is a
				 * target element for the reference), the mapping is not
				 * applicable
				 */
				if ((reference.isMany() && !((EList<EObject>) srcModelObject.eGet(reference)).isEmpty())
						|| (!reference.isMany() && srcModelObject.eGet(reference) != null)) {
					return false;
				} else {
					continue;
				}
			}

			/*
			 * get targets of the reference in the source model, then behave
			 * depending on the cardinality of the reference
			 */
			final Object refTarget = srcModelObject.eGet(reference);

			/*
			 * There are cases in which modeling more target values for a
			 * section than it can actually hold might make sense depending on
			 * how the target's CardinalityType value was set. Therefore we do
			 * not check the modeled references values at this point.
			 */
			if (!reference.isMany()) {

				final EObject refTargetObj = (EObject) refTarget;
				if (refTargetObj == null) {
					return false;
				}

				MatchedSectionDescriptor childDescriptor = null;
				boolean nonZeroCardSectionFound = false;

				for (final SourceSectionClass c : classes) {
					// check non-zero sections first (it doesn't make sense in
					// this case to model ZERO_INFINITY sections, if there is
					// one
					// section with a minimum cardinality of 1, but it can be
					// handled
					if (!c.getCardinality().equals(CardinalityType.ZERO_INFINITY)) {
						if (nonZeroCardSectionFound) {
							// modeling error
							consoleStream.println("Modeling error in source section: '"
									+ srcSection.getContainer().getName() + "', subsection: '" + srcSection.getName()
									+ "'. The Reference '" + refByClassMap.get(c)
									+ "' points to a metamodel reference, that can only hold one value but in the source section "
									+ "it references more than one Class with a CardinalityType that is not ZERO_INFINITY.");
							return false;
						}
						nonZeroCardSectionFound = true;
						childDescriptor = checkSection(refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference || usedOkay, c, descriptor);
					}
				}

				if (!nonZeroCardSectionFound) {
					for (final SourceSectionClass c : classes) {
						childDescriptor = checkSection(refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference || usedOkay, c, descriptor);
						if (childDescriptor != null) {
							continue;
						}
					}
				}

				if (childDescriptor == null) {
					return false;
				}

				// success: combine references
				if (refByClassMap
						.get(childDescriptor.getAssociatedSourceSectionClass()) instanceof ContainmentReference) {
					descriptor.add(childDescriptor);
				}

			} else {// unbounded or unspecified
				// cast refTarget to EList
				final LinkedList<EObject> refTargetL = new LinkedList<>((EList<EObject>) refTarget);

				/*
				 * this is a little more complicated: now we need to find ONE
				 * possible way to map our referenceTargets to the source
				 * sections
				 * 
				 * To do this we need to find out first which MMSections are
				 * applicable to which srcModel sections.
				 * 
				 * Then we try to find a way to map one srcModelSection to each
				 * MMSection
				 */

				// Map to store possible srcModelSections to MMSections
				// (non-vc))
				final SourceSectionMatchingResultsMap possibleSrcModelElementsNoVC = new SourceSectionMatchingResultsMap();
				for (final SourceSectionClass val : classes) {
					if (val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsNoVC.put(val, new LinkedList<MatchedSectionDescriptor>());
					}
				}

				// Map to store possible srcModelSections to MMSections (vc))
				final SourceSectionMatchingResultsMap possibleSrcModelElementsVC = new SourceSectionMatchingResultsMap();
				for (final SourceSectionClass val : classes) {
					if (!val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsVC.put(val, new LinkedList<MatchedSectionDescriptor>());
					}
				}

				final LinkedHashSet<EObject> elementsUsableForVC = new LinkedHashSet<>();
				// find possible srcElements for mmsections
				for (final EObject rt : refTargetL) {
					boolean foundMapping = false;
					for (final SourceSectionClass val : classes) {
						final MatchedSectionDescriptor childDescriptor = checkSection(rt,
								refByClassMap.get(val) instanceof MetaModelSectionReference || usedOkay, val,
								descriptor);

						if (childDescriptor != null) {// mapping possible
							foundMapping = true;

							// TODO Do we need this? This is done as part of
							// 'checkSection(...)', isn't it?
							//
							childDescriptor.setAssociatedSourceModelElement(rt);
							childDescriptor.setAssociatedSourceSectionClass(val);

							if (!val.getCardinality().equals(CardinalityType.ONE)) {
								possibleSrcModelElementsVC.get(val).add(childDescriptor);
								elementsUsableForVC.add(rt);

							} else {
								possibleSrcModelElementsNoVC.get(val).add(childDescriptor);
							}
						}
					}
					if (!foundMapping) {
						return false; // we need to find a mapping for every
						// srcModelElement if the reference Type
						// was modeled in the srcMMSection
					}
				}

				final LinkedList<EObject> allElementsMapped = new LinkedList<>();

				while (!possibleSrcModelElementsNoVC.keySet().isEmpty()) {
					final SourceSectionClass smallestKey = possibleSrcModelElementsNoVC
							.getKeyForValueWithSmallestCollectionSize();
					if (!possibleSrcModelElementsNoVC.get(smallestKey).isEmpty()) {
						MatchedSectionDescriptor srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsNoVC.get(smallestKey).size() > 1) {
							LinkedList<MatchedSectionDescriptor> possibleElements = new LinkedList<>();
							possibleElements.addAll(possibleSrcModelElementsNoVC.get(smallestKey));

							// filter elements that can be used for a vc-section
							final LinkedList<MatchedSectionDescriptor> allVCIncompatible = new LinkedList<>();
							for (final MatchedSectionDescriptor s : possibleElements) {
								if (!elementsUsableForVC.contains(s.getAssociatedSourceModelElement())) {
									allVCIncompatible.add(s);
								}
							}
							if (!allVCIncompatible.isEmpty()) {
								possibleElements = allVCIncompatible;
							}

							srcSectionResult = getResultForLeastUsedSrcModelElement(possibleElements);

						} else {
							srcSectionResult = possibleSrcModelElementsNoVC.get(smallestKey).getFirst();
						}

						// remember mapping
						if (refByClassMap.get(
								srcSectionResult.getAssociatedSourceSectionClass()) instanceof ContainmentReference) {
							descriptor.add(srcSectionResult);

						}

						allElementsMapped.add(srcSectionResult.getAssociatedSourceModelElement());
						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsNoVC.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsVC.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsNoVC.remove(smallestKey);// remove
						/*
						 * successfully mapped mmSection from list
						 */

					} else {
						// consoleStream.println("no-vc mapping failed");
						return false;// all non-vc-elements need to be mapped
						// exactly once
					}
				}

				// try to map all vc-elements
				final LinkedHashSet<SourceSectionClass> usedKeys = new LinkedHashSet<>(); // for
				// counting
				// cardinality

				while (!possibleSrcModelElementsVC.keySet().isEmpty()) {

					final SourceSectionClass smallestKey = possibleSrcModelElementsVC
							.getKeyForValueWithSmallestCollectionSize();
					if (!possibleSrcModelElementsVC.get(smallestKey).isEmpty()) {

						usedKeys.add(smallestKey);
						MatchedSectionDescriptor srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsVC.get(smallestKey).size() > 1) {

							srcSectionResult = getResultForLeastUsedSrcModelElement(
									possibleSrcModelElementsVC.get(smallestKey));

						} else {
							srcSectionResult = possibleSrcModelElementsVC.get(smallestKey).getFirst();
						}
						// remember mapping
						if (refByClassMap
								.get(srcSectionResult
										.getAssociatedSourceSectionClass()) instanceof ContainmentReference) {
							descriptor.add(srcSectionResult);

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
				refTargetL.removeAll(allElementsMapped);
				if (!refTargetL.isEmpty()) {
					consoleStream.println("Not everything could be mapped");
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * This checks if all {@link SourceSectionAttribute attributes} that have
	 * been defined for a given {@link SourceSectionClass} can be mapped for the
	 * given '<em>srcModelObject</em>'. Therefore, all the
	 * {@link AttributeValueConstraint AttributeValueConstraints} are checked.
	 * 
	 * @param srcModelObject
	 *            The object to be checked.
	 * @param srcSection
	 *            The {@link SourceSectionClass} for which the attributes shall
	 *            be checked.
	 * @param descriptor
	 *            The {@link MatchedSectionDescriptor} for the current matching
	 *            process.
	 * @return '<em></b>true</b></em>' if all attributes are present, '
	 *         <em><b>false</b></em>' otherwise
	 */
	private boolean checkAttributes(final EObject srcModelObject,
			final SourceSectionClass srcSection, final MatchedSectionDescriptor descriptor) {

		for (final SourceSectionAttribute at : srcSection.getAttributes()) {

			/*
			 * Check if the modeled attribute exists in the srcModelObject
			 */
			final Object srcAttr = srcModelObject.eGet(at.getAttribute());

			if (srcAttr == null && !at.getValueConstraint().isEmpty()) {
				return false;
			}

			/*
			 * We may not check 'AttributeValueConstraints' at this point as the
			 * 'ReferenceableElements' referenced are not yet known at this
			 * point (they may e.g. refer to other sections that have not yet
			 * been matched). Thus, we only record the constraints that need to
			 * be checked later on.
			 */
			descriptor.addAttributeValueConstraints(at.getValueConstraint());

		}

		return true;
	}

	/**
	 * This can be used to check if a given '<em>sourceSectionClass</em>' and
	 * the corresponding '<em>element</em>' have been previously matched (by
	 * another section).
	 * 
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} that shall be checked for
	 *            previous matching.
	 * @param element
	 *            The {@link EObject} that shall be checked for previous
	 *            matching.
	 */
	private boolean checkObjectWasMapped(final SourceSectionClass sourceSectionClass, final EObject element) {

		if (element == null) {
			return false;
		}

		if ((matchedSections.containsKey(sourceSectionClass)
				&& matchedSections.get(sourceSectionClass).contains(element))
				|| (matchedContainers.containsKey(sourceSectionClass)
						&& matchedContainers.get(sourceSectionClass).contains(element))) {
			return true;
		}

		return false;
	}

	/**
	 * Counts how often each associated source model element is referenced by
	 * each {@link MatchedSectionDescriptor} as associated source model object
	 * and returns one mapping result for the Object with the lowest count.
	 *
	 * @param possibleElements
	 *            The list of possible {@link MatchedSectionDescriptor
	 *            MatchedSectionDescriptors} to evaluate.
	 * @return The chosen {@link MatchedSectionDescriptor}.
	 */
	private static MatchedSectionDescriptor getResultForLeastUsedSrcModelElement(
			final LinkedList<MatchedSectionDescriptor> possibleElements) {

		MatchedSectionDescriptor srcSectionResult;
		// count how often a sourceModel Element is mapped
		final LinkedHashMap<EObject, Integer> usages = new LinkedHashMap<>();
		for (final MatchedSectionDescriptor e : possibleElements) {
			final EObject element = e.getAssociatedSourceModelElement();
			if (!usages.containsKey(element)) {
				usages.put(element, 0);
			}
			usages.put(element, usages.get(element) + 1);
		}
		// use one of the mappings for one of the elements with the least
		// possible mappings
		EObject leastUsed = possibleElements.getFirst().getAssociatedSourceModelElement();
		int numberUsed = usages.get(leastUsed);
		for (final EObject o : usages.keySet()) {// find the first element least
			// used
			// and return the first possible
			// result
			if (usages.get(o) < numberUsed) {
				leastUsed = o;
				numberUsed = usages.get(o);
			}
		}

		srcSectionResult = possibleElements.getFirst();// initialize this
		// variable so we dont
		// get compile errors
		for (final MatchedSectionDescriptor e : possibleElements) {
			if (e.getAssociatedSourceModelElement().equals(leastUsed)) {
				srcSectionResult = e;
				break;
			}
		}
		return srcSectionResult;
	}
}