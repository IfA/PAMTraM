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

import de.mfreund.gentrans.transformation.util.Pair;

/**
 * Instances of this class represent a connection path (via containment references) between two {@link EObject EObjects}. Therefore, 
 * this holds a list that of EObjects that alternately represent an {@link EClass} and an {@link EReference} and that form the path
 * <b>upward</b> in the containment hierarchy. Additionally, a bunch of methods that are provided that allow handling this List.
 *
 * Objects of this class can only be instantiated by the static methods {@link #findPathsWithMinimumCapacity(List, EObject, int) 
 * findPathsWithMinimumCapacity(...)}, {@link #findPathsFromContainerToClassToConnect(TargetSectionRegistry, EClass, EClass, int) 
 * findPathsFromContainerToClassToConnect(...)}, and {@link #findPathsToInstances(TargetSectionRegistry, EClass, int) 
 * findPathsToInstances(...)} for finding paths.
 *
 * @author mfreund
 *
 */
public final class ModelConnectionPath {

	/**
	 * This holds the list of path elements.
	 *
	 * A path starts and ends with an instance of an {@link EClass} - the first element of the path is the target element (lower in the
	 * containment hierarchy) and the last element is the parent element (higher in the containment hierarchy). These are connected
	 * either by one {@link EReference} (containment) or pairs of EReferences and EClasses.
	 */
	private LinkedList<EObject> pathElements;

	/**
	 * The registry of created target section instances that this ModelConnectionPath is associated with. Instances of
	 * ModelConnectionPath that are created e.g. by {@link #findPathsFromContainerToClassToConnect(TargetSectionRegistry, EClass, EClass, int)}
	 * are added to this registry.
	 * <br /><br />
	 * <b>Note:</b> If a new connection path is instantiated via {@link #instantiate(EObject, Collection)}, 
	 * the newly created EObjects (representing EClasses) will be added to this TargetSectionRegistry.
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * Private Constructor to be used when spawning new Paths during path
	 * search. Clones the path and appends new element.
	 *
	 * @param pathElements The existing elements of the connection path (EObjects representing
	 * {@link EClass EClasses} and {@link EReference EReferences} in alternating order.
	 * @param newElement The new element for the connection path (an EObject that represents either
	 * an {@link EClass} or an {@link EReference} depending on the last element of '<em>pathElements</em>'.
	 * @param targetSectionRegistry The registry of created target section instances that this ModelConnectionPath is 
	 * associated with.
	 * @param reverse '<em>true</em>' means that the path specified by '<em>pathElements</em>' + '<em>newElement</em>'
	 * denotes a path in inverse order (bottom-up instead of top-down). In this case, the order of the elements will be 
	 * inverted to create a regular (top-down) path. 
	 */
	private ModelConnectionPath(final LinkedList<EObject> pathElements,
			final EObject newElement,
			final TargetSectionRegistry targetSectionRegistry,
			final boolean reverse) {
	
		this.pathElements = new LinkedList<>();
		this.pathElements.addAll(pathElements);
		this.pathElements.add(newElement);
		if (reverse) {
			this.pathElements = getInvertedPathElementList();
		}
		this.targetSectionRegistry = targetSectionRegistry;
	}

	/**
	 * This is the getter for the list of {@link #pathElements}.
	 * 
	 * @return The elements forming this path. 
	 */
	public LinkedList<EObject> getPathElements() {
		return this.pathElements;
	}

	/**
	 * This tries to determine a connection path betwenn a given '<em>container EClass</em>' (higher in the containment hierarchy)
	 * and a given '<em>element EClass</em>' (lower in the containment hierarchy) by analyzing the concerned meta-model. Found paths
	 * are stored in the given {@link TargetSectionRegistry}.
	 * 
	 * @param registry The {@link TargetSectionRegistry} that shall be consulted for existing class instances and that determined connections 
	 * paths will be stored to.
	 * @param elementClass The {@link EClass} for that a connection (upward in the containment hierarchy) to the 'containerClass' shall 
	 * be determined.
	 * @param containerClass The {@link EClass} for that a connection (downward in the containment hierarchy) to the 'elementClass' shall 
	 * be determined.
	 * @param maxPathLength The maximum number of segments that the path may consist of ('<em>0</em>' indicating that only direct connections
	 * without any intermediary elements are allowed). 
	 */
	public static void findPathsFromContainerToClassToConnect(
			final TargetSectionRegistry registry, final EClass elementClass,
			final EClass containerClass, final int maxPathLength) {

		// this list holds pairs of EClasses and possible child EClasses
		final LinkedHashSet<Pair<EClass, LinkedList<EObject>>> pathStack = new LinkedHashSet<>();

		// we will move downward in the containment hierarchy and start at the 'containerClass'
		pathStack.add(new Pair<>(containerClass, new LinkedList<EObject>()));

		// iterate as long as every possible connection path has been found
		while (!pathStack.isEmpty() && !registry.isCancelled()) {

			final Pair<EClass, LinkedList<EObject>> next = pathStack.iterator().next();

			pathStack.remove(next);

			// a possible connection path has been found
			if (next.getLeft().equals(elementClass) && !next.getRight().isEmpty()) {

				// add copy of path to possiblePaths
				final ModelConnectionPath newSelf = new ModelConnectionPath(
						next.getRight(), elementClass, registry, true);

				// save the determined connection path in the TargetSectionRegistry for later use
				registry.addConnection(newSelf);
			} else {
				// check for inherited types
				for (final EClass c : registry.getChildClasses(next.getLeft())) {
					pathStack.add(new Pair<>(c, next
							.getRight()));
				}

				if (maxPathLength < 0 || next.getRight().size() / 2 - 1 < maxPathLength) {
					
					// detect loop
					if (!next.getRight().contains(next.getLeft())
							&& !next.getLeft().isAbstract()) {
						// continue path finding for references
						for (final EReference cont : next.getLeft()
								.getEAllContainments()) {
							final LinkedList<EObject> newRight = new LinkedList<>(
									next.getRight());
							newRight.add(next.getLeft());
							newRight.add(cont);
							pathStack.add(new Pair<>(cont.getEReferenceType(), newRight));
						}
					}
				}
			}
		}

	}

	/**
	 * This tries to determine connection paths to connect a given '<em>pathStartClass</em>' (lower in 
	 * the containment hierarchy) to any other class (higher in the containment hierarchy) by analyzing the 
	 * concerned meta-model. Found paths are stored in the given {@link TargetSectionRegistry}.
	 * 
	 * @param registry The {@link TargetSectionRegistry} that shall be consulted for existing class instances and that determined connections 
	 * paths will be stored to.
	 * @param pathStartClass The {@link EClass} for that a connection (upward in the containment hierarchy) to any other class shall 
	 * be determined.
	 * @param maxPathLength The maximum number of segments that the path may consist of ('<em>0</em>' indicating that only direct connections
	 * without any intermediary elements are allowed). 
	 */
	public static void findPathsToInstances(final TargetSectionRegistry registry,
			final EClass pathStartClass, final int maxPathLength) {

		// this list holds pairs of EClasses and possible child EClasses
		final LinkedHashSet<Pair<EClass, LinkedList<EObject>>> pathStack = new LinkedHashSet<>();

		pathStack.add(new Pair<>(pathStartClass,
				new LinkedList<EObject>()));

		while (!pathStack.isEmpty() && !registry.isCancelled()) {
			final Pair<EClass, LinkedList<EObject>> next = pathStack.iterator()
					.next();
			pathStack.remove(next);

			// check if path to this MM-Class found
			if (!registry.getTargetClassInstances(next.getLeft()).isEmpty() && !next.getRight().isEmpty()) {
				
				// add copy of path to possiblePaths
				final ModelConnectionPath newSelf = new ModelConnectionPath(
						next.getRight(), next.getLeft(), registry, false);

				// save the determined connection path in the TargetSectionRegistry for later use
				registry.addPath(newSelf); // first class

			} else {
				// check for inherited types
				for (final EClass c : registry.getChildClasses(next.getLeft())) {
					pathStack.add(new Pair<>(c, next
							.getRight()));
				}

				if (maxPathLength < 0 || next.getRight().size() / 2 - 1 < maxPathLength) {
					
					// detect loop
					if (!next.getRight().contains(next.getLeft())
							&& !next.getLeft().isAbstract()) {
						// continue path finding for references
						for (final EReference cont : registry
								.getClassReferences(next.getLeft())) {
							for (final EClass s : registry
									.getReferenceSources(cont)) {
								final LinkedList<EObject> newRight = new LinkedList<>(
										next.getRight());
								newRight.add(next.getLeft());
								newRight.add(cont);
								pathStack.add(new Pair<>(s, newRight));
							}
						}

					}
				}
			}

		}

	}

	/**
	 * For the given list of {@link ModelConnectionPath ModelConnectionPaths}, this method returns the subset of the paths
	 * that are able to connect at least as many elements to the given '<em>startInstance</em>' as denoted by the given
	 * '<em>minimumCapacity</em>'. Therefore, {@link #getCapacity(EObject)} is consulted for every possible path.
	 * <p />
	 * <b>Note:</b> If 'startInstance' is <em>null</em>, the 'theoretical' capacity of the paths will be checked
	 * (see {@link #getCapacity(EObject)}). 
	 *
	 * @param paths The {@link ModelConnectionPath}s that shall be checked for minimum capacity.
	 * @param startInstance An optional {@link EObject} that shall be the starting point of the path (may be <em>null</em>).
	 * @param minimumCapacity The minimumCapacity that has to be satisfied by the paths.
	 * @return The subset of the given paths that satisfies the minimumCapacity.
	 */
	public static List<ModelConnectionPath> findPathsWithMinimumCapacity(
			final List<ModelConnectionPath> paths,
			final EObject startInstance, final int minimumCapacity) {
		
		final List<ModelConnectionPath> pathsToConsider = new LinkedList<>();
		
		for (final ModelConnectionPath p : paths) {
			
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

	/**
	 * Compares two instances of {@link ModelConnectionPath}.
	 * 
	 * @param obj An instance of {@link ModelConnectionPath} to be compared to this path.
	 * @return '<em><b>true</b></em>' if the elements of the two paths to be compared are equal and exist in the 
	 * same order; '<em><b>false</b></em>' otherwise or if 'obj' is no instance of {@link ModelConnectionPath}.
	 */
	@Override
	public boolean equals(final Object obj) {
		
		if (obj instanceof ModelConnectionPath) {
			return ((ModelConnectionPath) obj).pathElements.equals(pathElements);
		} else {
			return false;
		}
	}

	/**
	 * Calculates the paths '<em>capacity</em>' for the given '<em>parentInstance</em>' (how many elements
	 * can be connected to the parent instance via this path).
	 * <p />
	 * <b>Note:</b> If '<em>parentInstance</em>' is <em>null</em> the theoretical capacity of this path is
	 * calculated. <em>Theoretical</em> in this case means that the maximum cardinality for each reference that is
	 * part of the path is used instead of the actual cardinality based on the given parentInstance.
	 *
	 * @param parentInstance The {@link EObject} for that the capacity of this path shall be calculated.
	 * @return The capacity of this path for the given 'parentInstance' ('<em>-1</em>' is 
	 * returned for paths with unbounded capacity).
	 */
	public int getCapacity(final EObject parentInstance) {

		// gets toggled every loop, to help us separate refs from types
		boolean use = false;

		EObject instance = parentInstance;
		int max = 1;

		// iterate downward in the containment hierarchy starting from the root element of this path

		final ListIterator<EObject> it = pathElements.listIterator(pathElements.size());
		while (it.hasPrevious()) {

			// the current parent element to connect 'targetInstance'
			final EObject e = it.previous();

			if (max < 1) {
				break;
			}

			if(use) {

				// every second element in a path sequence is a reference, we only need those
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
	 * This returns the inverted list of path elements (top-down instead of bottom-up).
	 *
	 * @return The inverted list of path elements.
	 */
	private LinkedList<EObject> getInvertedPathElementList() {
		
		final LinkedList<EObject> inverted = new LinkedList<>();
		final ListIterator<EObject> it = pathElements.listIterator(pathElements.size());

		while (it.hasPrevious()) {
			inverted.add(it.previous());

		}

		return inverted;
	}

	/**
	 * Returns the {@link EClass} that is the root of the path (the upper-most class
	 * in the containment hierarchy.
	 * 
	 * @return The EClass of the end of the path.
	 */
	public EClass getPathRootClass() {
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
	 * This instantiates the path and connects all instances in the given list of 'objectsToConnect' (lower in the
	 * containment hierarchy) to the given 'rootObject' (higher in the containment hierarchy). If necessary,
	 * missing objects along the path will be created.
	 * <p />
	 * Note: This will not modify the given list '<em>objectsToConnect</em>'.
	 *
	 * @param rootObject The {@link EObject} that shall contain the list of 'objectsToConnect' after the instantiation
	 * of the path. 
	 * @param objectsToConnect The list of {@link EObjectWrapper objects} that shall be connected to the 
	 * 'rootObject' via this path.
	 * @return A list of objects that could not be connected (possibly because the capacity of the path was not large
	 * enough).
	 */
	public List<EObjectWrapper> instantiate(
			final EObject rootObject,
			final Collection<EObjectWrapper> objectsToConnect) {

		return instantiateMissingPath(getInvertedPathElementList(), rootObject, new LinkedList<>(objectsToConnect));
	}

	/**
	 * The actual method for linking objects to another object.
	 * <p>
	 * Missing instances of objects along the path will be created.
	 *
	 * @param invertedPath A list of elements describing the path to instantiate (in inverse order which means
	 * top-down).
	 * @param rootObject The {@link EObject} that shall contain the list of 'objectsToConnect' after the instantiation
	 * of the path. 
	 * @param objectsToConnect The list of {@link EObjectWrapper objects} that shall be connected to the 
	 * 'rootObject' via this path.
	 * @returns unLinkedInstances A list of objects that could not be connected (possibly because the capacity of the path was not large
	 * enough).
	 */
	@SuppressWarnings("unchecked")
	private List<EObjectWrapper> instantiateMissingPath(
			final LinkedList<EObject> invertedPath,
			final EObject rootObject,
			List<EObjectWrapper> objectsToConnect) {

		final LinkedList<EObject> pathCopy = new LinkedList<>();
		pathCopy.addAll(invertedPath);
		pathCopy.remove(0);// EClass refStart=(EClass)

		final EReference ref = (EReference) pathCopy.remove(0);
		Object targetInst = rootObject.eGet(ref);

		if (pathCopy.size() > 1) {

			// Connect to a single-valued reference 
			//
			if (ref.getUpperBound() == 1) {// only one target instance allowed,
				// check if it exists
				if (targetInst == null) {
					final EClass classToCreate = (EClass) pathCopy.get(0);
					final EObject inst = classToCreate.getEPackage()
							.getEFactoryInstance().create(classToCreate);

					targetSectionRegistry.addClassInstance(inst);
					rootObject.eSet(ref, inst);

					targetInst = inst;
				}

				objectsToConnect = instantiateMissingPath(pathCopy,
						(EObject) targetInst, objectsToConnect);
				return objectsToConnect;

				// Connect to a multi-valued reference with 'upperBound == -1'
				//
			} else if (ref.getUpperBound() < 0) {

				/*
				 * it is absolutely necessary to copy targetInst, since targetInst will be cleared by
				 * eSet before new elements are added
				 */
				final LinkedList<EObject> newTarget = new LinkedList<>();
				final List<EObject> targetInstL = new LinkedList<>(); 
				if (targetInst != null) {
					final EList<EObject> castedList = (EList<EObject>) targetInst;
					targetInstL.addAll(castedList);
				}

				final EClass classToCreate = (EClass) pathCopy.get(0);

				while (!objectsToConnect.isEmpty()) {
					
					final EObject instance = classToCreate.getEPackage()
							.getEFactoryInstance().create(classToCreate);
					targetInstL.add(instance);
					newTarget.clear();// shouldn't be neccesssary because eSet will clear this
					newTarget.addAll(targetInstL);
					targetSectionRegistry.addClassInstance(newTarget.getLast());
					rootObject.eSet(ref, newTarget);

					objectsToConnect = instantiateMissingPath(pathCopy, instance, objectsToConnect);
				}

				return objectsToConnect;

			} else {

				// There is enough place to connect all objects
				//
				if(ref.getUpperBound() > 1 && (ref.getUpperBound() - (targetInst == null ? 0 : ((EList<EObject>) targetInst).size())) >= objectsToConnect.size()) {

					/*
					 * it is absolutely necessary to copy targetInst, since targetInst will be cleared by
					 * eSet before new elements are added
					 */
					final LinkedList<EObject> newTarget = new LinkedList<>();
					final List<EObject> targetInstL = new LinkedList<>(); 
					if (targetInst != null) {
						final EList<EObject> castedList = (EList<EObject>) targetInst;
						targetInstL.addAll(castedList);
					}

					final EClass classToCreate = (EClass) pathCopy.get(0);

					while (!objectsToConnect.isEmpty()) {
						
						final EObject instance = classToCreate.getEPackage().getEFactoryInstance().create(classToCreate);
						
						targetInstL.add(instance);
						newTarget.clear();// shouldn't be neccesssary because eSet will clear this
						newTarget.addAll(targetInstL);
						targetSectionRegistry.addClassInstance(newTarget.getLast());
						rootObject.eSet(ref, newTarget);

						objectsToConnect = instantiateMissingPath(pathCopy, instance,
								objectsToConnect);
					}

					return objectsToConnect;

					// This should never happen
					//
				} else {
					// TODO
					System.out.println("Owei, owei");
					// addToTargetModelRoot(instancesAtEnd);
					return new LinkedList<>();
				}

			}

		} else {// at End

			// Connect to a single-valued reference 
			//
			if (ref.getUpperBound() == 1) {
				if (targetInst != null) {
					System.out.println("Big mistake"); // this shouldn't happen
					// addToTargetModelRoot(instancesAtEnd);
					return new LinkedList<>();
				} else {
					rootObject.eSet(ref, objectsToConnect.remove(0)
							.getEObject());

					return objectsToConnect;

				}

				// Connect to a multi-valued reference with 'upperBound == -1'
				//
			} else if (ref.getUpperBound() < 0) { 
				final LinkedList<EObject> newTarget = new LinkedList<>();// it
				/*
				 * is absolutely neccessary to copy targetInst, since targetInst
				 * will be cleared by eSet before new elements are added
				 */
				if (targetInst != null) {
					final EList<EObject> targetInstL = (EList<EObject>) targetInst;
					newTarget.addAll(targetInstL);
				}
				for (final EObjectWrapper inst : objectsToConnect) {
					newTarget.add(inst.getEObject());
				}

				rootObject.eSet(ref, newTarget);
				return new LinkedList<>();

				// Connect to a multi-valued refernce with 'upperBound != -1'
				//
			} else {

				// There is enough place to connect all objects
				//
				if(ref.getUpperBound() > 1 && (ref.getUpperBound() - (targetInst == null ? 0 : ((EList<EObject>) targetInst).size())) >= objectsToConnect.size()) {
					
					final LinkedList<EObject> newTarget = new LinkedList<>();// it
					/*
					 * is absolutely neccessary to copy targetInst, since targetInst
					 * will be cleared by eSet before new elements are added
					 */
					if (targetInst != null) {
						final EList<EObject> targetInstL = (EList<EObject>) targetInst;
						newTarget.addAll(targetInstL);
					}
					for (final EObjectWrapper inst : objectsToConnect) {
						newTarget.add(inst.getEObject());
					}

					rootObject.eSet(ref, newTarget);
					return new LinkedList<>();

					// This should never happen
					//
				} else {
					// TODO
					System.out.println("owei, owei");
					// addToTargetModelRoot(instancesAtEnd);
					return new LinkedList<>();
				}
			}

		}

	}

	/**
	 * This can be used to check if this path leads to the given {@link EClass} 'root' (if 'root' denotes
	 * the container class of this path).
	 * 
	 * @param root The {@link EClass} that shall be checked as root of this path.
	 * @return '<em><b>true</b></em>' if this path leads to the specified EClass.
	 */
	boolean leadsToRootType(final EClass root) {
		
		return !pathElements.isEmpty() && ((EClass) pathElements.getLast()).equals(root);
	}

	/**
	 * This return the number of elements in the path, i.e. length of the path.
	 * 
	 * @return The number of elements in the path.
	 */
	public int size() {
		
		return pathElements.size();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();

		final ListIterator<EObject> it = pathElements.listIterator(pathElements.size());

		while (it.hasPrevious()) {
			
			final EObject prev = it.previous();
			if (prev instanceof EClass) {
				
				stringBuilder.append(((EClass) prev).getName());
				
			} else if (prev instanceof EReference) {
				
				// RegEx copied from:
				// https://stackoverflow.com/questions/1097901/regular-expression-split-string-by-capital-letter-but-ignore-tla
				stringBuilder.
					append("...").
					append(((EReference) prev).getName().replaceAll("((?<=\\p{Ll})\\p{Lu}|\\p{Lu}(?=\\p{Ll}))", " $1").toLowerCase().trim()).
					append("...");
			}
		}

		return stringBuilder.toString();
	}

}
