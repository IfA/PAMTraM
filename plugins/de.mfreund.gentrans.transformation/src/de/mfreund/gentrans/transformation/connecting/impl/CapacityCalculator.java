/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Arrays;
import java.util.Collection;

import de.mfreund.gentrans.transformation.connecting.Capacity;

/**
 * A util class that helps calculating with {@link Capacity Capacities}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class CapacityCalculator {

	private CapacityCalculator() {

	}

	public static Capacity addSequentialCapacities(Capacity... capacities) {

		return CapacityCalculator.addSequentialCapacities(Arrays.asList(capacities));
	}

	public static Capacity addSequentialCapacities(Collection<Capacity> capacities) {

		if (CapacityCalculator.containsZeroCapacity(capacities)) {
			return Capacity.ZERO;
		} else if (CapacityCalculator.containsUnboundedCapacity(capacities)) {
			return Capacity.UNBOUNDED;
		} else {
			return new Capacity(capacities.stream().mapToInt(Capacity::getValue).reduce(1, Math::multiplyExact));
		}

	}

	public static Capacity addParallelCapacities(Capacity... capacities) {

		return CapacityCalculator.addParallelCapacities(Arrays.asList(capacities));
	}

	public static Capacity addParallelCapacities(Collection<Capacity> capacities) {

		if (CapacityCalculator.containsUnboundedCapacity(capacities)) {
			return Capacity.UNBOUNDED;
		} else {
			return new Capacity(capacities.stream().mapToInt(Capacity::getValue).reduce(0, Math::addExact));
		}

	}

	private static boolean containsZeroCapacity(Collection<Capacity> capacities) {

		return capacities.contains(Capacity.ZERO);
	}

	private static boolean containsUnboundedCapacity(Collection<Capacity> capacities) {

		return capacities.contains(Capacity.UNBOUNDED);
	}

	public static boolean greaterThan(Capacity capacity1, Capacity capacity2) {

		if (capacity1.isUnbounded()) {
			return !capacity2.isUnbounded();
		} else if (capacity2.isUnbounded()) {
			return false;
		} else {
			return capacity1.getValue() > capacity2.getValue();
		}
	}

	public static boolean greaterThanOrEqual(Capacity capacity1, Capacity capacity2) {

		if (capacity1.isUnbounded()) {
			return true;
		} else if (capacity2.isUnbounded()) {
			return false;
		} else {
			return capacity1.getValue() >= capacity2.getValue();
		}
	}
}
