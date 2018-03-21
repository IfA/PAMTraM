/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.Length;
import de.mfreund.gentrans.transformation.registries.EClassConnectionInformationRegistry;

/**
 *
 * @author mfreund
 */
public class EClassConnectionPathFactory {

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

	@SuppressWarnings("javadoc")
	public List<EClassConnectionPath> findPathsBetweenClasses(EClass startingClass, EClass targetClass,
			Length maxPathLength) {

		if (maxPathLength.isNoConnection()) {
			return Collections.emptyList();
		}

		List<EClassConnectionPath> foundPaths = new ArrayList<>();

		Set<EClassConnectionPath> pathStack = new LinkedHashSet<>();

		// we will move downward in the containment hierarchy and start at the 'containerClass'
		pathStack.addAll(this.getAllPossibleOutgoingDirectConnectionPaths(startingClass));

		// iterate as long as every possible connection path has been found
		while (!pathStack.isEmpty()) {

			final EClassConnectionPath next = pathStack.iterator().next();

			pathStack.remove(next);

			// a possible connection path has been found
			if (next.getTargetClass().equals(targetClass)) {

				foundPaths.add(next);

			} else {

				if (maxPathLength.compareTo(next.getLength()) > 0) {

					List<EClassConnectionPath> nextPossiblePathSegments = this
							.getAllPossibleOutgoingDirectConnectionPaths(next.getTargetClass());
					List<EClassConnectionPath> resultingConnectionPaths = nextPossiblePathSegments.stream()
							.map(s -> join(next, s)).collect(Collectors.toList());
					List<EClassConnectionPath> resultingConnectionPathsWithoutLoops = resultingConnectionPaths.stream()
							.filter(p -> !p.containsLoop()).collect(Collectors.toList());

					pathStack.addAll(resultingConnectionPathsWithoutLoops);

				}
			}
		}

		return foundPaths;

	}

	private List<EClassConnectionPath> getAllPossibleOutgoingDirectConnectionPaths(EClass startingClass) {

		List<EReference> outgoingReferences = startingClass.getEAllContainments();

		return outgoingReferences.stream()
				.flatMap(r -> this.getAllPossibleOutgoingDirectConnectionPaths(startingClass, r).stream())
				.collect(Collectors.toList());
	}

	private List<EClassConnectionPath> getAllPossibleOutgoingDirectConnectionPaths(EClass startingClass,
			EReference reference) {

		List<EClass> potentialTargetClasses = getAllPotentialTargetClasses(reference);

		List<EClass> nonAbstractPotentialTargetClasses = potentialTargetClasses.stream().filter(c -> !c.isAbstract())
				.collect(Collectors.toList());

		return nonAbstractPotentialTargetClasses.stream()
				.map(c -> new DirectEClassConnectionPath(startingClass, reference, c)).collect(Collectors.toList());
	}

	private List<EClass> getAllPotentialTargetClasses(EReference reference) {

		EClass referenceType = reference.getEReferenceType();

		List<EClass> potentialTargetClasses = new ArrayList<>();
		potentialTargetClasses.add(referenceType);
		potentialTargetClasses.addAll(eClassConnectionInformationRegistry.getAllSubClasses(referenceType));

		return potentialTargetClasses;
	}

	@SuppressWarnings("javadoc")
	public List<EClassConnectionPath> findPathsToClass(EClass targetClass, Length maxPathLength) {

		Stream<EClass> concreteRegisteredClasses = eClassConnectionInformationRegistry.getRegisteredClasses().stream()
				.filter(c -> !c.isAbstract());

		return concreteRegisteredClasses.flatMap(c -> findPathsBetweenClasses(c, targetClass, maxPathLength).stream())
				.collect(Collectors.toList());
	}

	private EClassConnectionPath join(EClassConnectionPath path1, EClassConnectionPath path2) {

		List<DirectEClassConnectionPath> segments = new ArrayList<>();

		segments.addAll(getPathSegments(path1));
		segments.addAll(getPathSegments(path2));

		return new ComplexEClassConnectionPath(segments);
	}

	private List<DirectEClassConnectionPath> getPathSegments(EClassConnectionPath path) {

		if (path instanceof DirectEClassConnectionPath) {
			return Arrays.asList((DirectEClassConnectionPath) path);
		} else if (path instanceof ComplexEClassConnectionPath) {
			return ((ComplexEClassConnectionPath) path).getPathSegments();
		} else if (path instanceof EmptyEClassConnectionPath) {
			return Collections.emptyList();
		} else {
			throw new RuntimeException(
					"Unknown type of ConnectionPath '" + path.getClass().getName() + "' encountered. Will be ignored.");
		}
	}

}
