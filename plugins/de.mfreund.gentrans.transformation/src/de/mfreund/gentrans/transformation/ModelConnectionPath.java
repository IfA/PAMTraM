package de.mfreund.gentrans.transformation;

import java.util.LinkedList;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * @author Sascha Steffen
 * @version 0.8
 *
 */
class ModelConnectionPath {

	/**
	 * Registry of created target section instances
	 */
	private TargetSectionRegistry targetSectionRegistry;

	/**
	 * List of path elements
	 * 
	 * A path starts and ends with an Instance of an EClass.
	 * These are connected either by one EReference (containment) or pairs of
	 * EReferences and EClasses.
	 */
	private LinkedList<EObject> pathElements;

	/**
	 * Constructor
	 * @param targetSectionRegistry
	 */
	ModelConnectionPath(TargetSectionRegistry targetSectionRegistry) {
		this.pathElements = new LinkedList<EObject>();
		this.targetSectionRegistry=targetSectionRegistry;


	}

	/**
	 * Private Constructor to be used when spawning new Paths during path search.Clones the path.
	 * @param pathElements
	 * @param targetSectionRegistry
	 */
	private ModelConnectionPath(LinkedList<EObject> pathElements,TargetSectionRegistry targetSectionRegistry) {

		this.pathElements = new LinkedList<EObject>();
		this.pathElements.addAll(pathElements);
		this.targetSectionRegistry=targetSectionRegistry;


	}

	/**
	 * Private Constructor to be used when spawning new Paths during path search. Clones the path and appends new element. 
	 * @param pathElements
	 * @param newElement
	 * @param targetSectionRegistry
	 */
	private ModelConnectionPath(LinkedList<EObject> pathElements, EObject newElement,TargetSectionRegistry targetSectionRegistry) {

		this.pathElements = new LinkedList<EObject>();
		this.pathElements.addAll(pathElements);
		this.pathElements.add(newElement);
		this.targetSectionRegistry=targetSectionRegistry;
	}

	/**
	 * Finds paths to instances of the provided class.
	 * @param targetSectionClass
	 */
	void findPathsToInstances(EClass targetSectionClass) {

		// check if path to this MM-Class found
		if (targetSectionRegistry.getTargetClassInstances(targetSectionClass).size() > 0
				&& pathElements.size() > 0) {
			// add copy of path to possiblePaths
			ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements, targetSectionClass,targetSectionRegistry);

			// self.first.~possiblePaths.add(newSelf);
			targetSectionRegistry.addPath(newSelf, (EClass) this.pathElements.getFirst()); // first
																				// class
			return;
		}

		// check for inherited types
		for (EClass c : targetSectionRegistry.getChildClasses(targetSectionClass)) {
			ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements,targetSectionRegistry);
			newSelf.findPathsToInstances(c);
		}

		// detect loop
		if (pathElements.contains(targetSectionClass)) {
			return;

		}

		// add class to path if not abstract
		if (!targetSectionClass.isAbstract()) {
			pathElements.add(targetSectionClass);

			// continue path finding for references
			for (EReference cont : targetSectionRegistry
					.getClassReferences(targetSectionClass)) {

				for (EClass s : targetSectionRegistry.getReferenceSources(cont)) {
					ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements, cont,targetSectionRegistry);
					newSelf.findPathsToInstances(s);
				}
			}

		}

	}

	/**
	 * Calculate the paths capacity starting from the targetInstance.
	 * <p>
	 * If targetInstance is null the theoretical capacity of this path is calculated.
	 * @param targetInstance
	 * @return path capacity
	 */
	int getCapacity(EObject targetInstance) {
		boolean use = false; // gets toggled every loop, to help us separate
								// refs from types
		EObject instance = targetInstance;
		int max = 1;

		ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			EObject e = it.previous();

			if (max < 1)
				break;
			if (use) {// every second element in a path sequence is a reference,
						// we only need those
				EReference ref = (EReference) e;
				if (instance != null) {
					Object targets = instance.eGet(ref);

					if (targets != null) {
						if (ref.getUpperBound() == 1) {
							instance = (EObject) targets;
						} else if (ref.getUpperBound() > 1) {
							@SuppressWarnings("unchecked")
							EList<EObject> targetsL=(EList<EObject>) targets;
							instance = null;
							max = max* (ref.getUpperBound() - targetsL.size());
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String path = "";

		ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			EObject prev = it.previous();
			if (prev instanceof EClass) {
				path += ((EClass) prev).getName();
			} else if (prev instanceof EReference) {
				//RegEx copied from: https://stackoverflow.com/questions/1097901/regular-expression-split-string-by-capital-letter-but-ignore-tla
				path += "..."+((EReference) prev).getName().replaceAll("((?<=\\p{Ll})\\p{Lu}|\\p{Lu}(?=\\p{Ll}))", " $1").toLowerCase().trim()+"...";
			}
		}

		return path;
	}

	/**
	 * Used when instantiating a path.
	 * @return inverted List of path elements
	 */
	public LinkedList<EObject> getInvertedPathElementList() {
		LinkedList<EObject> inverted = new LinkedList<EObject>();
		ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			inverted.add(it.previous());

		}

		return inverted;
	}

	/**
	 * @return EClass of the end of the path.
	 */
	public EClass getRootType() {
		return (EClass) pathElements.getLast();

	}

	/**
	 * @param root
	 * @return true if path leads to the specified class
	 */
	boolean leadsToRootType(EClass root) {
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
}
