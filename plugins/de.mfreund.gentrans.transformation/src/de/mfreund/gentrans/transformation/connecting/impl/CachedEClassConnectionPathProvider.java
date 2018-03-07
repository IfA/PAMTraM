/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import de.mfreund.gentrans.transformation.connecting.Capacity;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathProvider;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathRequirement;
import de.mfreund.gentrans.transformation.connecting.Length;

/**
 * An {@link EClassConnectionPathProvider} that redirects to an {@link EClassConnectionPathFactory} in order to
 * determine possible connection paths and caches determined paths to reduce computation time.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class CachedEClassConnectionPathProvider implements EClassConnectionPathProvider {

	private final Map<EClassConnectionPathRequirement, Set<EClassConnectionPath>> cachedConnections;

	private final EClassConnectionPathFactory pathFactory;

	public CachedEClassConnectionPathProvider(Collection<EPackage> ePackages) {

		this(ePackages, null);
	}

	public CachedEClassConnectionPathProvider(Collection<EPackage> ePackages, Logger logger) {

		this.cachedConnections = Collections.synchronizedMap(new HashMap<>());
		this.pathFactory = logger != null ? new EClassConnectionPathFactory(ePackages, logger)
				: new EClassConnectionPathFactory(ePackages);
	}

	@Override
	public List<EClassConnectionPath> getConnections(EClassConnectionPathRequirement connectionRequirement) {

		return new ArrayList<>(
				this.cachedConnections.computeIfAbsent(connectionRequirement, this::determineConnections));
	}

	private Set<EClassConnectionPath> determineConnections(EClassConnectionPathRequirement connectionRequirement) {

		EClass startingClass = connectionRequirement.getRequiredStartingClass();
		EClass targetClass = connectionRequirement.getRequiredTargetClass();
		Length maxPathLength = connectionRequirement.getRequiredMaximumPathLength();

		List<EClassConnectionPath> potentialConnectionPaths;
		if (startingClass == null) {
			potentialConnectionPaths = this.pathFactory.findPathsToClass(targetClass, maxPathLength);
		} else {
			potentialConnectionPaths = this.pathFactory.findPathsBetweenClasses(startingClass, targetClass,
					maxPathLength);
		}

		Capacity requiredCapacity = connectionRequirement.getRequiredMinimumCapacity();
		EObject startingElement = connectionRequirement.getRequiredStartingElement();

		Set<EClassConnectionPath> filteredConnectionPaths;
		if (startingElement == null) {
			filteredConnectionPaths = this.filterConnectionsByTheoreticalCapacity(potentialConnectionPaths,
					requiredCapacity);
		} else {
			filteredConnectionPaths = this.filterConnectionsByActualCapacity(potentialConnectionPaths, requiredCapacity,
					startingElement);
		}

		return filteredConnectionPaths.stream()
				.sorted((p1, p2) -> Integer.valueOf(p2.getLength().getValue())
						.compareTo(Integer.valueOf(p1.getLength().getValue())))
				.collect(Collectors.toCollection(LinkedHashSet::new));

	}

	private Set<EClassConnectionPath> filterConnectionsByTheoreticalCapacity(
			Collection<EClassConnectionPath> connections, Capacity requiredCapacity) {

		return connections.stream().filter(c -> c.getTheoreticalCapacity().isSufficientFor(requiredCapacity))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private Set<EClassConnectionPath> filterConnectionsByActualCapacity(Collection<EClassConnectionPath> connections,
			Capacity requiredCapacity, EObject startingElement) {

		return connections.stream().filter(c -> c.getActualCapacity(startingElement).isSufficientFor(requiredCapacity))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

}
