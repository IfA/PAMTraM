/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.registries.EClassConnectionInformationRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.util.Pair;

/**
 *
 * @author mfreund
 */
public class EClassConnectionPathFactory {

	private final EClassConnectionInformationRegistry eClassConnectionInformationRegistry;

	private Optional<Logger> logger;

	/**
	 * This creates an instance without an attached logger.
	 *
	 * @param ePackages
	 *            The collection of {@link EPackage EPackages} that shall be considered when determining potential
	 *            connection paths.
	 */
	public EClassConnectionPathFactory(Collection<EPackage> ePackages) {

		this.eClassConnectionInformationRegistry = new EClassConnectionInformationRegistry();
		this.eClassConnectionInformationRegistry.register(ePackages);
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

		this.logger = Optional.ofNullable(logger);
		this.eClassConnectionInformationRegistry = new EClassConnectionInformationRegistry(logger);
		this.eClassConnectionInformationRegistry.register(ePackages);
	}

	/**
	 * This tries to determine a connection path betwenn a given '<em>container EClass</em>' (higher in the containment
	 * hierarchy) and a given '<em>element EClass</em>' (lower in the containment hierarchy) by analyzing the concerned
	 * meta-model. Found paths are stored in the given {@link TargetSectionRegistry}.
	 *
	 * @param registry
	 *            The {@link TargetSectionRegistry} that shall be consulted for existing class instances and that
	 *            determined connections paths will be stored to.
	 * @param elementClass
	 *            The {@link EClass} for that a connection (upward in the containment hierarchy) to the 'containerClass'
	 *            shall be determined.
	 * @param containerClass
	 *            The {@link EClass} for that a connection (downward in the containment hierarchy) to the 'elementClass'
	 *            shall be determined.
	 * @param maxPathLength
	 *            The maximum number of segments that the path may consist of ('<em>0</em>' indicating that only direct
	 *            connections without any intermediary elements are allowed).
	 * @return
	 */
	public List<MetaModelPath> findPathsFromContainerToClassToConnect(final TargetSectionRegistry registry,
			final EClass elementClass, final EClass containerClass, final int maxPathLength) {

		List<MetaModelPath> foundPaths = new ArrayList<>();

		// this list holds pairs of EClasses and possible child EClasses
		final LinkedHashSet<Pair<EClass, LinkedList<EObject>>> pathStack = new LinkedHashSet<>();

		// we will move downward in the containment hierarchy and start at the 'containerClass'
		pathStack.add(new Pair<>(containerClass, new LinkedList<EObject>()));

		// iterate as long as every possible connection path has been found
		while (!pathStack.isEmpty()) {

			final Pair<EClass, LinkedList<EObject>> next = pathStack.iterator().next();

			pathStack.remove(next);

			// a possible connection path has been found
			if (next.getLeft().equals(elementClass) && !next.getRight().isEmpty()) {

				// add copy of path to possiblePaths
				List<EObject> pathElements = new ArrayList<>();
				pathElements.addAll(next.getRight());
				pathElements.add(elementClass);
				boolean reverse = true;
				final MetaModelPath newSelf = this.constructPath(pathElements, reverse);

				// save the determined connection path in the TargetSectionRegistry for later use
				foundPaths.add(newSelf);
			} else {
				// check for inherited types
				for (final EClass c : this.eClassConnectionInformationRegistry.getAllSubClasses(next.getLeft())) {
					pathStack.add(new Pair<>(c, next.getRight()));
				}

				if (maxPathLength < 0 || next.getRight().size() / 2 - 1 < maxPathLength) {

					// detect loop
					if (!next.getRight().contains(next.getLeft()) && !next.getLeft().isAbstract()) {
						// continue path finding for references
						for (final EReference cont : next.getLeft().getEAllContainments()) {
							final LinkedList<EObject> newRight = new LinkedList<>(next.getRight());
							newRight.add(next.getLeft());
							newRight.add(cont);
							pathStack.add(new Pair<>(cont.getEReferenceType(), newRight));
						}
					}
				}
			}
		}

		return foundPaths;

	}

	/**
	 * This tries to determine connection paths to connect a given '<em>pathStartClass</em>' (lower in the containment
	 * hierarchy) to any other class (higher in the containment hierarchy) by analyzing the concerned meta-model. Found
	 * paths are stored in the given {@link TargetSectionRegistry}.
	 *
	 * @param registry
	 *            The {@link TargetSectionRegistry} that shall be consulted for existing class instances and that
	 *            determined connections paths will be stored to.
	 * @param pathStartClass
	 *            The {@link EClass} for that a connection (upward in the containment hierarchy) to any other class
	 *            shall be determined.
	 * @param maxPathLength
	 *            The maximum number of segments that the path may consist of ('<em>0</em>' indicating that only direct
	 *            connections without any intermediary elements are allowed).
	 * @return
	 */
	public List<MetaModelPath> findPathsToInstances(final TargetSectionRegistry registry, final EClass pathStartClass,
			final int maxPathLength) {

		final List<MetaModelPath> paths = new LinkedList<>();

		// this list holds pairs of EClasses and possible child EClasses
		final LinkedHashSet<Pair<EClass, LinkedList<EObject>>> pathStack = new LinkedHashSet<>();

		pathStack.add(new Pair<>(pathStartClass, new LinkedList<EObject>()));

		while (!pathStack.isEmpty()) {

			final Pair<EClass, LinkedList<EObject>> next = pathStack.iterator().next();
			pathStack.remove(next);

			// check if path to this MM-Class found
			if (!registry.getTargetClassInstances(next.getLeft()).isEmpty() && !next.getRight().isEmpty()) {

				// add copy of path to possiblePaths
				List<EObject> pathElements = new ArrayList<>();
				pathElements.addAll(next.getRight());
				pathElements.add(next.getLeft());
				Collections.reverse(pathElements);
				boolean reverse = false;

				final MetaModelPath newSelf = this.constructPath(pathElements, reverse);

				// save the determined connection path in the TargetSectionRegistry for later use
				paths.add(newSelf); // first class

			} else {
				// check for inherited types
				for (final EClass c : this.eClassConnectionInformationRegistry.getAllSubClasses(next.getLeft())) {
					pathStack.add(new Pair<>(c, next.getRight()));
				}

				if (maxPathLength < 0 || next.getRight().size() / 2 - 1 < maxPathLength) {

					// detect loop
					if (!next.getRight().contains(next.getLeft()) && !next.getLeft().isAbstract()) {
						// continue path finding for references
						for (final EReference cont : this.eClassConnectionInformationRegistry
								.getAllReferencesToClass(next.getLeft())) {
							for (final EClass s : this.eClassConnectionInformationRegistry
									.getAllDefiningClassesForReference(cont)) {
								final LinkedList<EObject> newRight = new LinkedList<>(next.getRight());
								newRight.add(next.getLeft());
								newRight.add(cont);
								pathStack.add(new Pair<>(s, newRight));
							}
						}

					}
				}
			}

		}

		return paths;

	}

	/**
	 *
	 *
	 * ${tags}
	 */
	private MetaModelPath constructPath(List<EObject> pathElements, boolean reverse) {

		List<EClassConnectionPathSegment> segments = new ArrayList<>();
		Iterator<EObject> it = pathElements.iterator();
		EClass sourceClass = (EClass) it.next();
		while (it.hasNext()) {
			EReference reference = (EReference) it.next();
			EClass targetClass = (EClass) it.next();
			segments.add(new EClassConnectionPathSegment(sourceClass, reference, targetClass));
			sourceClass = targetClass;
		}
		final MetaModelPath newSelf = new MetaModelPath(segments);
		return newSelf;
	}

	/**
	 * For the given list of {@link MetaModelPath ModelConnectionPaths}, this method returns the subset of the paths
	 * that are able to connect at least as many elements to the given '<em>startInstance</em>' as denoted by the given
	 * '<em>minimumCapacity</em>'. Therefore, {@link #getCapacity(EObject)} is consulted for every possible path.
	 * <p />
	 * <b>Note:</b> If 'startInstance' is <em>null</em>, the 'theoretical' capacity of the paths will be checked (see
	 * {@link #getCapacity(EObject)}).
	 *
	 * @param paths
	 *            The {@link MetaModelPath}s that shall be checked for minimum capacity.
	 * @param startInstance
	 *            An optional {@link EObject} that shall be the starting point of the path (may be <em>null</em>).
	 * @param minimumCapacity
	 *            The minimumCapacity that has to be satisfied by the paths.
	 * @return The subset of the given paths that satisfies the minimumCapacity.
	 */
	public List<MetaModelPath> findPathsWithMinimumCapacity(final List<MetaModelPath> paths,
			final EObject startInstance, final int minimumCapacity) {

		final List<MetaModelPath> pathsToConsider = new LinkedList<>();

		for (final MetaModelPath p : paths) {

			if (startInstance != null && !p.leadsToRootType(startInstance.eClass())) {
				// only consider paths with the right start instance type
				continue;
			}

			final int capacity = p.getCapacity(startInstance);
			if (capacity != 0 && (minimumCapacity != -1 && capacity >= minimumCapacity || capacity == -1)) {
				pathsToConsider.add(p);
			}
		}

		return pathsToConsider;
	}

	public Set<EClass> getClasses() {

		// FIXME remove/refactor
		return this.eClassConnectionInformationRegistry.getRegisteredClasses();
	}

}
