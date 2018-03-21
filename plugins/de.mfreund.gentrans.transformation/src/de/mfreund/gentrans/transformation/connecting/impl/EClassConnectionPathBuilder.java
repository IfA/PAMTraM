/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.AllowedReferenceType;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.Length;

/**
 * A
 *
 * @author mfreund
 */
public class EClassConnectionPathBuilder {

	private EClass startingClass;

	private EClass targetClass;

	private Length maxPathLength;

	private AllowedReferenceType allowedReferenceType;

	private EClassConnectionInformationRegistry eClassConnectionInformationRegistry;

	@SuppressWarnings("javadoc")
	public EClassConnectionPathBuilder(EClass startingClass, EClass targetClass, Length maxPathLength,
			AllowedReferenceType allowedReferenceType,
			EClassConnectionInformationRegistry eClassConnectionInformationRegistry) {

		this.startingClass = startingClass;
		this.targetClass = targetClass;
		this.maxPathLength = maxPathLength;
		this.allowedReferenceType = allowedReferenceType;
		this.eClassConnectionInformationRegistry = eClassConnectionInformationRegistry;
	}

	public List<EClassConnectionPath> build() {

		if (maxPathLength.isNoConnection()) {
			return Collections.emptyList();
		}

		List<EClassConnectionPath> foundPaths = new ArrayList<>();

		Set<EClassConnectionPath> pathStack = new LinkedHashSet<>();

		// we will move downward in the containment hierarchy and start at the 'containerClass'
		pathStack.addAll(getAllAllowedOutgoingDirectConnectionPaths(startingClass, allowedReferenceType));

		// iterate as long as every possible connection path has been found
		while (!pathStack.isEmpty()) {

			final EClassConnectionPath next = pathStack.iterator().next();

			pathStack.remove(next);

			// a possible connection path has been found
			if (next.getTargetClass().equals(targetClass)) {

				foundPaths.add(next);

			} else {

				if (maxPathLength.compareTo(next.getLength()) > 0) {

					List<EClassConnectionPath> nextPossiblePathSegments = getAllAllowedOutgoingDirectConnectionPaths(
							next.getTargetClass(), allowedReferenceType);
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

	private List<EClassConnectionPath> getAllAllowedOutgoingDirectConnectionPaths(EClass startingClass,
			AllowedReferenceType allowedReferenceType) {

		List<EReference> outgoingReferences = getAllAllowedOutgoingReferences(startingClass, allowedReferenceType);

		return getAllPossibleDirectConnectionPathsViaReferences(startingClass, outgoingReferences);
	}

	private List<EReference> getAllAllowedOutgoingReferences(EClass startingClass,
			AllowedReferenceType allowedReferenceType) {

		List<EReference> allOutgoingReferences = startingClass.getEAllReferences();

		return allOutgoingReferences.stream().filter(allowedReferenceType::allows).collect(Collectors.toList());
	}

	private List<EClassConnectionPath> getAllPossibleDirectConnectionPathsViaReferences(EClass startingClass,
			List<EReference> references) {

		return references.stream()
				.flatMap(r -> getAllPossibleDirectConnectionPathsViaReference(startingClass, r).stream())
				.collect(Collectors.toList());
	}

	private List<EClassConnectionPath> getAllPossibleDirectConnectionPathsViaReference(EClass startingClass,
			EReference outgoingReference) {

		List<EClass> potentialTargetClasses = getAllPotentialTargetClasses(outgoingReference);

		List<EClass> nonAbstractPotentialTargetClasses = potentialTargetClasses.stream().filter(c -> !c.isAbstract())
				.collect(Collectors.toList());

		return nonAbstractPotentialTargetClasses.stream()
				.map(c -> new DirectEClassConnectionPath(startingClass, outgoingReference, c))
				.collect(Collectors.toList());
	}

	private List<EClass> getAllPotentialTargetClasses(EReference reference) {

		EClass referenceType = reference.getEReferenceType();

		List<EClass> potentialTargetClasses = new ArrayList<>();
		potentialTargetClasses.add(referenceType);
		potentialTargetClasses.addAll(eClassConnectionInformationRegistry.getAllSubClasses(referenceType));

		return potentialTargetClasses;
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
