/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
 * A factory that is able to create {@link EClassConnectionPath EClassConnectionPaths} based on
 *
 * @author mfreund
 */
public class EClassConnectionPathFactory implements EClassConnectionPathProvider {

	private final EClassConnectionInformationRegistry eClassConnectionInformationRegistry;

	/**
	 * This creates an instance without an attached logger.
	 *
	 * @param ePackages
	 *            The collection of {@link EPackage EPackages} that shall be considered when determining potential
	 *            connection paths.
	 */
	public EClassConnectionPathFactory(Collection<EPackage> ePackages) {

		this(ePackages, null);
	}

	/**
	 * This creates an instance with an attached logger.
	 *
	 * @param ePackages
	 *            The collection of {@link EPackage EPackages} that shall be considered when determining potential
	 *            connection paths.
	 * @param logger
	 */
	public EClassConnectionPathFactory(Collection<EPackage> ePackages, Logger logger) {

		eClassConnectionInformationRegistry = logger == null ? new EClassConnectionInformationRegistry()
				: new EClassConnectionInformationRegistry(logger);
		eClassConnectionInformationRegistry.register(ePackages);
	}

	@Override
	public List<EClassConnectionPath> getConnections(EClassConnectionPathRequirement connectionRequirement) {

		EClass startingClass = connectionRequirement.getRequiredStartingClass();
		EClass targetClass = connectionRequirement.getRequiredTargetClass();
		Length maxPathLength = connectionRequirement.getRequiredMaximumPathLength();
		AllowedReferenceType allowedReferenceType = connectionRequirement.getAllowedReferenceType();

		List<EClassConnectionPath> potentialConnectionPaths;
		if (startingClass == null) {
			potentialConnectionPaths = findPathsToClass(targetClass, maxPathLength, allowedReferenceType);
		} else {
			potentialConnectionPaths = findPathsBetweenClasses(startingClass, targetClass, maxPathLength,
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

		return sortConnectionPathsFromShortestToLongest(filteredConnectionPaths);

	}

	private List<EClassConnectionPath> findPathsToClass(EClass targetClass, Length maxPathLength,
			AllowedReferenceType allowedReferenceType) {
	
		Stream<EClass> concreteRegisteredClasses = eClassConnectionInformationRegistry.getRegisteredClasses().stream()
				.filter(c -> !c.isAbstract());
	
		return concreteRegisteredClasses
				.flatMap(c -> findPathsBetweenClasses(c, targetClass, maxPathLength, allowedReferenceType).stream())
				.collect(Collectors.toList());
	}

	private List<EClassConnectionPath> findPathsBetweenClasses(EClass startingClass, EClass targetClass,
			Length maxPathLength, AllowedReferenceType allowedReferenceType) {
	
		EClassConnectionPathBuilder pathBuilder = new EClassConnectionPathBuilder(startingClass, targetClass,
				maxPathLength, allowedReferenceType, eClassConnectionInformationRegistry);
	
		return pathBuilder.build();
	
	}

	private Set<EClassConnectionPath> filterConnectionPathsByTheoreticalCapacity(
			Collection<EClassConnectionPath> connections, Capacity requiredCapacity) {

		return connections.stream().filter(c -> c.getTheoreticalCapacity().isSufficientFor(requiredCapacity))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private Set<EClassConnectionPath> filterConnectionPathsByActualCapacity(
			Collection<EClassConnectionPath> connections, Capacity requiredCapacity, EObject startingElement) {

		return connections.stream().filter(c -> c.getActualCapacity(startingElement).isSufficientFor(requiredCapacity))
				.collect(Collectors.toCollection(LinkedHashSet::new));
	}

	private List<EClassConnectionPath> sortConnectionPathsFromShortestToLongest(
			Set<EClassConnectionPath> connectionPaths) {

		return connectionPaths.stream().sorted((p1, p2) -> p1.getLength().compareTo(p2.getLength()))
				.collect(Collectors.toList());
	}
}
