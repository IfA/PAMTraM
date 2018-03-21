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

import de.mfreund.gentrans.transformation.connecting.AllowedReferenceType;
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

		cachedConnections = Collections.synchronizedMap(new HashMap<>());
		pathFactory = logger != null ? new EClassConnectionPathFactory(ePackages, logger)
				: new EClassConnectionPathFactory(ePackages);
	}

	@Override
	public List<EClassConnectionPath> getConnections(EClassConnectionPathRequirement connectionRequirement) {

		return new ArrayList<>(cachedConnections.computeIfAbsent(connectionRequirement, this::determineConnections));
	}

	private Set<EClassConnectionPath> determineConnections(EClassConnectionPathRequirement connectionRequirement) {

		EClass startingClass = connectionRequirement.getRequiredStartingClass();
		EClass targetClass = connectionRequirement.getRequiredTargetClass();
		Length maxPathLength = connectionRequirement.getRequiredMaximumPathLength();
		AllowedReferenceType allowedReferenceType = connectionRequirement.getAllowedReferenceType();

		List<EClassConnectionPath> potentialConnectionPaths;
		if (startingClass == null) {
			potentialConnectionPaths = pathFactory.findPathsToClass(targetClass, maxPathLength, allowedReferenceType);
		} else {
			potentialConnectionPaths = pathFactory.findPathsBetweenClasses(startingClass, targetClass, maxPathLength,
					allowedReferenceType);
		}

		Capacity requiredCapacity = connectionRequirement.getRequiredMinimumCapacity();
		EObject startingElement = connectionRequirement.getRequiredStartingElement();

		Set<EClassConnectionPath> filteredConnectionPaths;
		if (startingElement == null) {
			filteredConnectionPaths = filterConnectionPathsByTheoreticalCapacity(potentialConnectionPaths,
					requiredCapacity);
		} else {
			filteredConnectionPaths = filterConnectionPathsByActualCapacity(potentialConnectionPaths, requiredCapacity,
					startingElement);
		}

		return new LinkedHashSet<>(sortConnectionPathsFromShortestToLongest(filteredConnectionPaths));

	}

	private Set<EClassConnectionPath> filterConnectionPathsByTheoreticalCapacity(
			Collection<EClassConnectionPath> connections, Capacity requiredCapacity) {

		return connections.stream().filter(c -> c.getTheoreticalCapacity().isSufficientFor(requiredCapacity))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private Set<EClassConnectionPath> filterConnectionPathsByActualCapacity(Collection<EClassConnectionPath> connections,
			Capacity requiredCapacity, EObject startingElement) {

		return connections.stream().filter(c -> c.getActualCapacity(startingElement).isSufficientFor(requiredCapacity))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private List<EClassConnectionPath> sortConnectionPathsFromShortestToLongest(
			Set<EClassConnectionPath> connectionPaths) {

		return connectionPaths.stream().sorted((p1, p2) -> p1.getLength().compareTo(p2.getLength()))
				.collect(Collectors.toList());
	}

}
