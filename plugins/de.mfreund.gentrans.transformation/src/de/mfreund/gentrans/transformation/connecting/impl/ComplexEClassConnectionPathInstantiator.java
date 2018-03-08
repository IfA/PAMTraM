/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.connecting.Capacity;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathInstantiator;

/**
 * An {@link EClassConnectionPathInstantiator} that is able to automatically instantiate missing intermediary elements.
 *
 * @author mfreund
 */
public class ComplexEClassConnectionPathInstantiator extends EClassConnectionPathInstantiator {

	private DirectEClassConnectionPath firstPathSegment;

	private EClassConnectionPathInstantiator firstPathSegmentInstantiator;

	private List<EObject> existingTargetElementsOfFirstPathSegment;

	// All 'pathSegments' excluding the 'firstPathSegment'
	private EClassConnectionPath remainingPath;

	private EClassConnectionPathInstantiator remainingPathInstantiator;

	private Capacity requiredCapacity;

	@SuppressWarnings("javadoc")
	public ComplexEClassConnectionPathInstantiator(ComplexEClassConnectionPath pathToInstantiate) {

		super(pathToInstantiate);

		firstPathSegment = pathToInstantiate.getPathSegments().get(0);
		firstPathSegmentInstantiator = firstPathSegment.createInstantiator();

		remainingPath = pathToInstantiate.getSubPath(1);
		remainingPathInstantiator = remainingPath.createInstantiator();
	}

	@Override
	protected void init(EObject startingElement, Collection<EObject> targetElements) {

		super.init(startingElement, targetElements);

		existingTargetElementsOfFirstPathSegment = firstPathSegment.getExistingTargetElements(startingElement);
		requiredCapacity = Capacity.valueOf(targetElements);
	}

	/**
	 * Instantiates the {@link EClassConnectionPathInstantiator#pathToInstantiate pathToInstantiate}. If necessary,
	 * missing intermediary elements along the path will be created automatically.
	 *
	 */
	@Override
	protected void instantiate() {

		List<EObject> targetElementsOfFirstPathSegment;

		if (firstPathSegmentIsOnlyPathSegment()) {
			targetElementsOfFirstPathSegment = targetElements;

		} else if (firstPathSegmentCanBeReused()) {
			targetElementsOfFirstPathSegment = existingTargetElementsOfFirstPathSegment;

		} else {
			targetElementsOfFirstPathSegment = createRequiredIntermediaryElementsForFirstPathSegment();
		}

		instantiateFirstPathSegment(targetElementsOfFirstPathSegment);

		instantiateRemainingPath(targetElementsOfFirstPathSegment);

	}

	private boolean firstPathSegmentIsOnlyPathSegment() {

		return remainingPath instanceof EmptyEClassConnectionPath;
	}

	private boolean firstPathSegmentCanBeReused() {

		return !firstPathSegmentIsOnlyPathSegment() && canTargetElementsOfFirstPathSegmentBeReused();

	}

	private boolean canTargetElementsOfFirstPathSegmentBeReused() {

		if (existingTargetElementsOfFirstPathSegment.isEmpty()) {
			return false;

		} else if (existingTargetElementsOfFirstPathSegment.size() == 1) {
			return canSingleTargetElementOfFirstPathSegmentBeReused();

		} else if (existingTargetElementsOfFirstPathSegment.size() == targetElements.size()) {
			return canAllTargetElementsOfFirstPathSegmentBeReused();

		} else {
			return false;
		}

	}

	private boolean canSingleTargetElementOfFirstPathSegmentBeReused() {

		EObject targetElementOfFirstPathSegment = existingTargetElementsOfFirstPathSegment.get(0);

		Capacity actualCapacityOfSubPath = remainingPath.getActualCapacity(targetElementOfFirstPathSegment);

		return actualCapacityOfSubPath.isSufficientFor(requiredCapacity);
	}

	private boolean canAllTargetElementsOfFirstPathSegmentBeReused() {

		return existingTargetElementsOfFirstPathSegment.stream()
				.noneMatch(e -> remainingPath.getActualCapacity(e).isZero());
	}

	private List<EObject> createRequiredIntermediaryElementsForFirstPathSegment() {

		int requiredNumberOfElements = getRequiredNumberOfIntermediaryElements();

		List<EObject> createdElements = IntStream.range(0, requiredNumberOfElements)
				.mapToObj(i -> createIntermediaryElementForFirstPathSegment()).collect(Collectors.toList());

		createdIntermediaryElements.addAll(createdElements);

		return createdElements;
	}

	private int getRequiredNumberOfIntermediaryElements() {

		Capacity theoreticalCapacityOfPathWithoutFirstSegment = remainingPath.getTheoreticalCapacity();

		if (theoreticalCapacityOfPathWithoutFirstSegment.isSufficientFor(requiredCapacity)) {
			// all target elements can be connected to a single intermediary element
			return 1;

		} else {
			// create an own intermediary element for each target element (we do not consider more complex cases where,
			// e.g., 5 target elements are connected to 3 elements of the first path segment)
			//
			return requiredCapacity.getValue();
		}
	}

	private EObject createIntermediaryElementForFirstPathSegment() {

		EClass classToInstantiate = firstPathSegment.getTargetClass();

		return classToInstantiate.getEPackage().getEFactoryInstance().create(classToInstantiate);
	}

	private void instantiateFirstPathSegment(List<EObject> targetElementsOfFirstPathSegment) {

		instantiate(firstPathSegmentInstantiator, startingElement, targetElementsOfFirstPathSegment);
	}

	private void instantiateRemainingPath(List<EObject> startingElementsOfRemainingPath) {

		int targetElementsPerStartingElement = getTargetElementsPerStartingElementOfRemainingPath(
				startingElementsOfRemainingPath);

		for (int i = 0; i < startingElementsOfRemainingPath.size(); i++) {

			EObject startingElementOfRemainingPath = startingElementsOfRemainingPath.get(i);
			List<EObject> correspondingTargetElements = targetElements.subList(targetElementsPerStartingElement * i,
					targetElementsPerStartingElement * (i + 1));

			instantiateRemainingPath(startingElementOfRemainingPath, correspondingTargetElements);
		}

	}

	private int getTargetElementsPerStartingElementOfRemainingPath(List<EObject> startingElementsOfRemainingPath) {

		if (startingElementsOfRemainingPath.size() == 1) {
			return targetElements.size();

		} else if (startingElementsOfRemainingPath.size() == targetElements.size()) {
			return 1;

		} else {
			throw new EClassConnectionPathInstantiationException(
					"Internal error during instantiation of EClassConnectionPath '" + pathToInstantiate
							+ "'! Trying to connect " + targetElements.size() + " target elements to "
							+ startingElementsOfRemainingPath.size() + " starting elements.");
		}
	}

	private void instantiateRemainingPath(EObject startingElementOfRemainingPath,
			List<EObject> correspondingTargetElements) {

		instantiate(remainingPathInstantiator, startingElementOfRemainingPath, correspondingTargetElements);
	}

	private void instantiate(EClassConnectionPathInstantiator instantiator, EObject startingElement,
			List<EObject> targetElements) {

		instantiator.instantiate(startingElement, targetElements);

		createdIntermediaryElements.addAll(instantiator.getCreatedIntermediaryElements());
		unconnectedElements.addAll(instantiator.getUnconnectedElements());
	}

}
