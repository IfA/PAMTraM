package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Holds a very ugly List that represents a path (mixed EClass and EReference)
 * and provides a bunch of methods that involve handling this List.
 *
 * Objects of this Class can only be instantiated by the static methods for
 * finding paths defined in this class.
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
final class ModelConnectionPath {

	/**
	 * @param elementClass
	 * @param containerClass
	 * @param directPathsOnly
	 */
	static void findPathsFromContainerToClassToConnect(
			final TargetSectionRegistry registry, final EClass elementClass,
			final EClass containerClass, final int maxPathLength) {
		// new
		// ModelConnectionPath(registry).findPathsFromContainerToClassToConnect(elementClass,
		// containerClass, maxPathLength);
		final LinkedHashSet<Pair<EClass, LinkedList<EObject>>> pathStack = new LinkedHashSet<Pair<EClass, LinkedList<EObject>>>();

		pathStack.add(new Pair<EClass, LinkedList<EObject>>(containerClass,
				new LinkedList<EObject>()));

		while (pathStack.size() > 0 && !registry.isCancelled()) {
			final Pair<EClass, LinkedList<EObject>> next = pathStack.iterator()
					.next();
			pathStack.remove(next);

			if (next.getLeft().equals(elementClass)
					&& next.getRight().size() > 0) {
				// add copy of path to possiblePaths
				final ModelConnectionPath newSelf = new ModelConnectionPath(
						next.getRight(), elementClass, registry, true);

				registry.addConnection(newSelf, elementClass, (EClass) next
						.getRight().getFirst());
			} else {
				// check for inherited types
				for (final EClass c : registry.getChildClasses(next.getLeft())) {
					pathStack.add(new Pair<EClass, LinkedList<EObject>>(c, next
							.getRight()));
				}

				if (maxPathLength < 0
						|| next.getRight().size() / 2 - 1 < maxPathLength) {
					// detect loop
					if (!next.getRight().contains(next.getLeft())
							&& !next.getLeft().isAbstract()) {
						// continue path finding for references
						for (final EReference cont : next.getLeft()
								.getEAllContainments()) {
							final LinkedList<EObject> newRight = new LinkedList<EObject>(
									next.getRight());
							newRight.add(next.getLeft());
							newRight.add(cont);
							pathStack
							.add(new Pair<EClass, LinkedList<EObject>>(
									cont.getEReferenceType(), newRight));
						}
					}
				}
			}
		}

	}

	/**
	 * Finds paths to instances of the provided class. (from class to connect to
	 * container class, "up")
	 *
	 * @param pathStartClass
	 */
	static void findPathsToInstances(final TargetSectionRegistry registry,
			final EClass pathStartClass, final int maxPathLength) {
		// new
		// ModelConnectionPath(registry).findPathsFromContainerToClassToConnect(elementClass,
		// containerClass, maxPathLength);
		final LinkedHashSet<Pair<EClass, LinkedList<EObject>>> pathStack = new LinkedHashSet<Pair<EClass, LinkedList<EObject>>>();

		pathStack.add(new Pair<EClass, LinkedList<EObject>>(pathStartClass,
				new LinkedList<EObject>()));

		while (pathStack.size() > 0 && !registry.isCancelled()) {
			final Pair<EClass, LinkedList<EObject>> next = pathStack.iterator()
					.next();
			pathStack.remove(next);

			// check if path to this MM-Class found
			if (registry.getTargetClassInstances(next.getLeft()).size() > 0
					&& next.getRight().size() > 0) {
				// add copy of path to possiblePaths
				final ModelConnectionPath newSelf = new ModelConnectionPath(
						next.getRight(), next.getLeft(), registry, false);

				// self.first.~possiblePaths.add(newSelf);
				registry.addPath(newSelf, (EClass) next.getRight().getFirst()); // first
				// class

			} else {
				// check for inherited types
				for (final EClass c : registry.getChildClasses(next.getLeft())) {
					pathStack.add(new Pair<EClass, LinkedList<EObject>>(c, next
							.getRight()));
				}

				if (maxPathLength < 0
						|| next.getRight().size() / 2 - 1 < maxPathLength) {
					// detect loop
					if (!next.getRight().contains(next.getLeft())
							&& !next.getLeft().isAbstract()) {
						// continue path finding for references
						for (final EReference cont : registry
								.getClassReferences(next.getLeft())) {
							for (final EClass s : registry
									.getReferenceSources(cont)) {
								final LinkedList<EObject> newRight = new LinkedList<EObject>(
										next.getRight());
								newRight.add(next.getLeft());
								newRight.add(cont);
								pathStack
								.add(new Pair<EClass, LinkedList<EObject>>(
										s, newRight));
							}
						}

					}
				}
			}

		}

	}

	/**
	 * Return possible paths that can connect a minimum number of elements
	 *
	 * @param paths The {@link ModelConnectionPath}s that shall be checked for minimum capacity.
	 * @param startInstance An optional {@link EObject} that shall be the starting point of the path (may be <em>null</em>).
	 * @param minimumCapacity The minimumCapacity that has to be satisfied by the paths.
	 * @return The subset of the given paths that satisfies the minimumCapacity.
	 */
	static LinkedList<ModelConnectionPath> findPathsWithMinimumCapacity(
			final LinkedList<ModelConnectionPath> paths,
			final EObject startInstance, final int minimumCapacity) {
		final LinkedList<ModelConnectionPath> pathsToConsider = new LinkedList<ModelConnectionPath>();
		for (final ModelConnectionPath p : paths) {
			if (startInstance != null) {
				if (!p.leadsToRootType(startInstance.eClass())) {
					continue;// only consider paths with the right start
					// instance type
				}
			}

			final int capacity = p.getCapacity(startInstance);
			if (capacity != 0) {
				if (minimumCapacity != -1 && capacity >= minimumCapacity
						|| capacity == -1) {
					pathsToConsider.add(p);
				}
			}
		}
		return pathsToConsider;
	}

	/**
	 * Registry of created target section instances
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * List of path elements
	 *
	 * A path starts and ends with an Instance of an EClass. These are connected
	 * either by one EReference (containment) or pairs of EReferences and
	 * EClasses.
	 */
	private LinkedList<EObject> pathElements;

	/**
	 * Private Constructor to be used when spawning new Paths during path
	 * search. Clones the path and appends new element.
	 *
	 * @param pathElements
	 * @param newElement
	 * @param targetSectionRegistry
	 */
	private ModelConnectionPath(final LinkedList<EObject> pathElements,
			final EObject newElement,
			final TargetSectionRegistry targetSectionRegistry,
			final boolean reverse) {

		this.pathElements = new LinkedList<EObject>();
		this.pathElements.addAll(pathElements);
		this.pathElements.add(newElement);
		if (reverse) {
			this.pathElements = getInvertedPathElementList();
		}
		this.targetSectionRegistry = targetSectionRegistry;
	}

	/**
	 * Private Constructor to be used when spawning new Paths during path
	 * search.Clones the path.
	 *
	 * @param pathElements
	 * @param targetSectionRegistry
	 */
	private ModelConnectionPath(final LinkedList<EObject> pathElements,
			final TargetSectionRegistry targetSectionRegistry) {

		this.pathElements = new LinkedList<EObject>();
		this.pathElements.addAll(pathElements);
		this.targetSectionRegistry = targetSectionRegistry;

	}

	/**
	 * Constructor
	 *
	 * @param targetSectionRegistry
	 */
	private ModelConnectionPath(
			final TargetSectionRegistry targetSectionRegistry) {
		pathElements = new LinkedList<EObject>();
		this.targetSectionRegistry = targetSectionRegistry;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof ModelConnectionPath) {
			return ((ModelConnectionPath) obj).pathElements
					.equals(pathElements);
		} else {
			return false;
		}
	}

	/**
	 * Calculate the paths capacity starting from the targetInstance.
	 * <p>
	 * If targetInstance is null the theoretical capacity of this path is
	 * calculated.
	 *
	 * @param targetInstance
	 * @return path capacity
	 */
	int getCapacity(final EObject targetInstance) {
		boolean use = false; // gets toggled every loop, to help us separate
		// refs from types
		EObject instance = targetInstance;
		int max = 1;

		final ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			final EObject e = it.previous();

			if (max < 1)
				break;
			if (use) {// every second element in a path sequence is a reference,
				// we only need those
				final EReference ref = (EReference) e;
				if (instance != null) {
					final Object targets = instance.eGet(ref);

					if (targets != null) {
						if (ref.getUpperBound() == 1) {
							instance = (EObject) targets;
						} else if (ref.getUpperBound() > 1) {
							@SuppressWarnings("unchecked")
							final EList<EObject> targetsL = (EList<EObject>) targets;
							instance = null;
							max = max * (ref.getUpperBound() - targetsL.size());
						} else if (ref.getUpperBound() < 0) {
							return -1;
						} else { // can only be 0
							return 0;
						}
					} else {
						instance = null;
						max = max * ref.getUpperBound();
					}
				} else {
					max = max * ref.getUpperBound();
				}
			}
			use = !use;// toggle use bit
		}

		return max;

	}

	/**
	 * Used when instantiating a path.
	 *
	 * @return inverted List of path elements
	 */
	private LinkedList<EObject> getInvertedPathElementList() {
		final LinkedList<EObject> inverted = new LinkedList<EObject>();
		final ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			inverted.add(it.previous());

		}

		return inverted;
	}

	/**
	 * @return EClass of the end of the path.
	 */
	EClass getPathRootClass() {
		return (EClass) pathElements.getLast();

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return pathElements.hashCode();
	}

	/**
	 * INstantiate the Path for all the supplied elements. (This will not modify
	 * the List "instancesAtEnd")
	 *
	 * @param refStartInstance
	 * @param instancesAtEnd
	 * @return unconnected instances
	 */
	List<EObjectTransformationHelper> instantiate(
			final EObject refStartInstance,
			final Collection<EObjectTransformationHelper> instancesAtEnd) {
		return instantiateMissingPath(getInvertedPathElementList(),
				refStartInstance, new LinkedList<EObjectTransformationHelper>(
						instancesAtEnd));
	}

	/**
	 * The actual method for linking Objects to another object.
	 * <p>
	 * Missing instances of objects along the path will be created.
	 *
	 * @param invertedPath
	 * @param refStartInstance
	 * @param instancesAtEnd
	 * @param attrValRegistry
	 * @returns unLinkedInstances
	 */
	private List<EObjectTransformationHelper> instantiateMissingPath(
			final LinkedList<EObject> invertedPath,
			final EObject refStartInstance,
			List<EObjectTransformationHelper> instancesAtEnd) {
		final LinkedList<EObject> pathCopy = new LinkedList<EObject>();
		pathCopy.addAll(invertedPath);
		pathCopy.remove(0);// EClass refStart=(EClass)
		final EReference ref = (EReference) pathCopy.remove(0);
		Object targetInst = refStartInstance.eGet(ref);

		if (pathCopy.size() > 1) {
			if (ref.getUpperBound() == 1) {// only one target instance allowed,
				// check if it exists
				if (targetInst == null) {
					final EClass classToCreate = (EClass) pathCopy.get(0);
					final EObject inst = classToCreate.getEPackage()
							.getEFactoryInstance().create(classToCreate);

					targetSectionRegistry.addClassInstance(inst);
					refStartInstance.eSet(ref, inst);

					targetInst = inst;
				}

				instancesAtEnd = instantiateMissingPath(pathCopy,
						(EObject) targetInst, instancesAtEnd);
				return instancesAtEnd;

			} else if (ref.getUpperBound() < 0) {
				final LinkedList<EObject> newTarget = new LinkedList<EObject>();// it
				// is
				// absolutely
				// neccessary
				// to
				// copy
				// targetInst, since targetInst will be cleared by
				final List<EObject> targetInstL = new LinkedList<EObject>(); // eSet
				// before
				// new
				// elements
				// are
				// added
				if (targetInst != null) {
					@SuppressWarnings("unchecked")
					final EList<EObject> castedList = (EList<EObject>) targetInst;
					targetInstL.addAll(castedList);
				}

				final EClass classToCreate = (EClass) pathCopy.get(0);

				while (instancesAtEnd.size() > 0) {
					final EObject instance = classToCreate.getEPackage()
							.getEFactoryInstance().create(classToCreate);
					// instance.~description="Class '" + newSelf.first.name +
					// "' (created to link targetSection):"; TODO seee above
					targetInstL.add(instance);
					newTarget.clear();// shouldn't be neccesssary because eSet
					// will clear this
					newTarget.addAll(targetInstL);
					targetSectionRegistry.addClassInstance(newTarget.getLast());
					refStartInstance.eSet(ref, newTarget);

					instancesAtEnd = instantiateMissingPath(pathCopy, instance,
							instancesAtEnd);
				}

				return instancesAtEnd;

			} else {// cardinality less than infinity
				// TODO
				System.out.println("Owei, owei");
				// addToTargetModelRoot(instancesAtEnd);
				return new LinkedList<EObjectTransformationHelper>();

			}

		} else {// at End
			if (ref.getUpperBound() == 1) {
				if (targetInst != null) {
					System.out.println("Big mistake"); // this shouldn't happen
					// addToTargetModelRoot(instancesAtEnd);
					return new LinkedList<EObjectTransformationHelper>();
				} else {
					refStartInstance.eSet(ref, instancesAtEnd.remove(0)
							.getEObject());

					return instancesAtEnd;

				}
			} else if (ref.getUpperBound() < 0) {
				final LinkedList<EObject> newTarget = new LinkedList<EObject>();// it
				/*
				 * is absolutely neccessary to copy targetInst, since targetInst
				 * will be cleared by eSet before new elements are added
				 */
				if (targetInst != null) {
					@SuppressWarnings("unchecked")
					final EList<EObject> targetInstL = (EList<EObject>) targetInst;
					newTarget.addAll(targetInstL);
				}
				for (final EObjectTransformationHelper inst : instancesAtEnd) {
					newTarget.add(inst.getEObject());
				}

				refStartInstance.eSet(ref, newTarget);
				return new LinkedList<EObjectTransformationHelper>();
			} else {// cardinality less than infinity
				// TODO
				System.out.println("owei, owei");
				// addToTargetModelRoot(instancesAtEnd);
				return new LinkedList<EObjectTransformationHelper>();
			}
		}

	}

	/**
	 * @param root
	 * @return true if path leads to the specified class
	 */
	boolean leadsToRootType(final EClass root) {
		if (pathElements.size() > 0) {
			if (pathElements.getLast() instanceof EClass) {

				return ((EClass) pathElements.getLast()).equals(root);

			} else
				return false;

		} else
			return false;
	}

	/**
	 * @return count of Elements in the path
	 */
	int size() {
		return pathElements.size();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String path = "";

		final ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			final EObject prev = it.previous();
			if (prev instanceof EClass) {
				path += ((EClass) prev).getName();
			} else if (prev instanceof EReference) {
				// RegEx copied from:
				// https://stackoverflow.com/questions/1097901/regular-expression-split-string-by-capital-letter-but-ignore-tla
				path += "..."
						+ ((EReference) prev)
						.getName()
						.replaceAll(
								"((?<=\\p{Ll})\\p{Lu}|\\p{Lu}(?=\\p{Ll}))",
								" $1").toLowerCase().trim() + "...";
			}
		}

		return path;
	}

}
