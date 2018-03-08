package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.Capacity;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathInstantiator;
import de.mfreund.gentrans.transformation.connecting.Length;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;

/**
 * An {@link EClassConnectionPath} that represents a complex path that is made up of (one or) multiple segments each
 * represented by a {@link DirectEClassConnectionPath}.
 *
 * @author mfreund
 */
public class ComplexEClassConnectionPath implements EClassConnectionPath {

	private LinkedList<DirectEClassConnectionPath> pathSegments;

	private Map<DirectEClassConnectionPath, Capacity> theoreticalSegmentCapacities;

	// // The starting EObject used during calculation of the 'actual capacity' of the path
	// private EObject startingElement;

	/**
	 * Create a new path based on a number of {@link DirectEClassConnectionPath segments}.
	 *
	 * @param pathSegments
	 */
	public ComplexEClassConnectionPath(DirectEClassConnectionPath... pathSegments) {

		this(Arrays.asList(pathSegments));
	}

	/**
	 * Create a new path based on a list of {@link DirectEClassConnectionPath segments}.
	 *
	 * @param pathSegments
	 */
	public ComplexEClassConnectionPath(List<DirectEClassConnectionPath> pathSegments) {

		this.pathSegments = new LinkedList<>(pathSegments);
		theoreticalSegmentCapacities = this.pathSegments.stream().collect(Collectors.toMap(Function.identity(),
				DirectEClassConnectionPath::getTheoreticalCapacity, (v1, v2) -> v2, LinkedHashMap::new));
	}

	/**
	 * @return the {@link #pathSegments}
	 */
	public List<DirectEClassConnectionPath> getPathSegments() {

		return Collections.unmodifiableList(pathSegments);
	}

	@Override
	public EClass getStartingClass() {

		return pathSegments.getFirst().getStartingClass();
	}

	@Override
	public EClass getTargetClass() {

		return pathSegments.getLast().getTargetClass();
	}

	@Override
	public Length getLength() {

		return pathSegments.stream().map(EClassConnectionPath::getLength).reduce(Length.NO_CONNECTION,
				LengthCalculator::add);
	}

	@Override
	public Capacity getTheoreticalCapacity() {

		return CapacityCalculator.addSequentialCapacities(theoreticalSegmentCapacities.values());
	}

	@Override
	public Capacity getActualCapacity(EObject startingElement) {

		Capacity theoreticalCapacity = getTheoreticalCapacity();

		if (theoreticalCapacity.isUnbounded()) {
			return Capacity.UNBOUNDED;
		} else if (theoreticalCapacity.isZero()) {
			return Capacity.ZERO;
		}

		List<EObject> existingTargetElements = getExistingTargetElements(startingElement);
		Capacity occupiedCapacity = Capacity.valueOf(existingTargetElements);

		return CapacityCalculator.subtract(theoreticalCapacity, occupiedCapacity);

	}

	@Override
	public List<EObject> getExistingTargetElements(EObject startingElement) {

		List<EObject> targetElementsOfFirstPathSegment = getTargetElementsOfFirstPathSegment(startingElement);

		EClassConnectionPath remainingSubPath = getSubPath(1);

		return targetElementsOfFirstPathSegment.stream()
				.flatMap(e -> remainingSubPath.getExistingTargetElements(e).stream()).collect(Collectors.toList());

	}

	// private Capacity getActualCapacityBasedOnFirstPathSegmentCapacity() {
	//
	// if (pathSegments.isEmpty()) {
	// return Capacity.ZERO;
	// }
	//
	// DirectEClassConnectionPath firstPathSegment = pathSegments.get(0);
	//
	// Capacity actualCapacityOfFirstPathSegment = firstPathSegment.getActualCapacity(startingElement);
	//
	// Capacity theoreticalCapacityOfRemainingPathSegments = this.getSubPath(1).getTheoreticalCapacity();
	//
	// return CapacityCalculator.addSequentialCapacities(actualCapacityOfFirstPathSegment,
	// theoreticalCapacityOfRemainingPathSegments);
	// }

	// private Capacity getActualCapacityBasedOnFollowingPathSegmentCapacities() {
	//
	// List<EObject> targetElementsOfFirstPathSegment = getTargetElementsOfFirstPathSegment();
	//
	// EClassConnectionPath remainingSubPath = this.getSubPath(1);
	//
	// List<Capacity> capacitiesOfRemainingSubPath = targetElementsOfFirstPathSegment.stream()
	// .map(remainingSubPath::getActualCapacity).collect(Collectors.toList());
	//
	// return CapacityCalculator.addParallelCapacities(capacitiesOfRemainingSubPath);
	//
	// }

	List<EObject> getTargetElementsOfFirstPathSegment(EObject startingElement) {

		if (!isValidStartingElement(startingElement)) {
			return Collections.emptyList();
		}

		DirectEClassConnectionPath firstPathSegment = pathSegments.get(0);

		List<Object> targetElementsOfPathSegment = AgteleEcoreUtil.getStructuralFeatureValueAsList(startingElement,
				firstPathSegment.getReference());

		return targetElementsOfPathSegment.stream().filter(e -> e instanceof EObject).map(e -> (EObject) e)
				.collect(Collectors.toList());
	}

	EClassConnectionPath getSubPath(int fromSegmentInclusive) {

		return this.getSubPath(fromSegmentInclusive, pathSegments.size());
	}

	EClassConnectionPath getSubPath(int fromSegmentInclusive, int toSegmentExclusive) {

		List<DirectEClassConnectionPath> subPathSegments = pathSegments.subList(fromSegmentInclusive,
				toSegmentExclusive);

		if (subPathSegments.isEmpty()) {
			return new EmptyEClassConnectionPath();
		} else if (subPathSegments.size() == 1) {
			return subPathSegments.get(0);
		} else {
			return new ComplexEClassConnectionPath(subPathSegments);
		}

	}

	/**
	 * Compares two instances of {@link ComplexEClassConnectionPath}.
	 *
	 * @param obj
	 *            An instance of {@link ComplexEClassConnectionPath} to be compared to this path.
	 * @return '<em><b>true</b></em>' if the elements of the two paths to be compared are equal and exist in the same
	 *         order; '<em><b>false</b></em>' otherwise or if 'obj' is no instance of
	 *         {@link ComplexEClassConnectionPath}.
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		} else if (!(obj instanceof ComplexEClassConnectionPath)) {
			return false;
		} else {
			return pathSegments.equals(((ComplexEClassConnectionPath) obj).pathSegments);
		}

	}

	@Override
	public int hashCode() {

		return Objects.hash(pathSegments.toArray());
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		final ListIterator<DirectEClassConnectionPath> it = pathSegments.listIterator();

		stringBuilder.append(getStartingClass().getName());

		while (it.hasNext()) {

			final DirectEClassConnectionPath next = it.next();

			stringBuilder.append("...").append(next.getReference().getName()).append("...");

			stringBuilder.append(next.getTargetClass().getName());
		}

		return stringBuilder.toString();
	}

	@Override
	public boolean describesConnectionBetween(EObject startingElement, EObject targetElement) {

		// this.startingElement = startingElement;

		List<EObject> targetElementsOfFirstPathSegment = getTargetElementsOfFirstPathSegment(startingElement);

		EClassConnectionPath remainingSubPath = this.getSubPath(1);

		return targetElementsOfFirstPathSegment.stream()
				.anyMatch(e -> remainingSubPath.describesConnectionBetween(e, targetElement));
	}

	@Override
	public List<EClass> getAllClasses() {

		return Stream
				.concat(Arrays.asList(getStartingClass()).stream(),
						pathSegments.stream().map(DirectEClassConnectionPath::getTargetClass))
				.collect(Collectors.toList());
	}

	@Override
	public List<EReference> getAllReferences() {

		return pathSegments.stream().map(DirectEClassConnectionPath::getReference).collect(Collectors.toList());
	}

	@Override
	public EClassConnectionPathInstantiator createInstantiator() {

		if (getSubPath(1) instanceof EmptyEClassConnectionPath) {
			DirectEClassConnectionPath firstAndOnlyPathSegment = getPathSegments().get(0);
			return new DirectEClassConnectionPathInstantiator(firstAndOnlyPathSegment);

		} else {
			return new ComplexEClassConnectionPathInstantiator(this);
		}
	}

}
