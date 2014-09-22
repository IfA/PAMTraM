package de.mfreund.gentrans.transformation;

import java.util.LinkedList;
import java.util.List;
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
	 * (there should'nt be a getter for pathElements, therefore we compare the elemnets list this way)
	 * @param pathElements
	 * @return true if list contain same elements
	 */
	boolean comparePathElements(List<EObject> pathElements){
		return pathElements.equals(this.pathElements);
	}

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
	private ModelConnectionPath(LinkedList<EObject> pathElements, EObject newElement,TargetSectionRegistry targetSectionRegistry, boolean reverse) {

		this.pathElements = new LinkedList<EObject>();
		this.pathElements.addAll(pathElements);
		this.pathElements.add(newElement);
		if(reverse){
			this.pathElements=getInvertedPathElementList();
		}
		this.targetSectionRegistry=targetSectionRegistry;
	}
	
	/**
	 *(from container class to class to connect, "down")
	 * @param classToConnect
	 * @param containerClass
	 * @param directPathsOnly
	 */
	void findPathsFromContainerToClassToConnect(EClass classToConnect, EClass containerClass, boolean directPathsOnly){
		if(classToConnect.equals(containerClass) && pathElements.size()>0){
			// add copy of path to possiblePaths
			ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements, classToConnect,targetSectionRegistry,true);

			targetSectionRegistry.addConnection(newSelf, classToConnect, (EClass) pathElements.getFirst());
			return;			
		}
		
		// check for inherited types
		for (EClass c :  targetSectionRegistry.getChildClasses(containerClass)) {
			ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements,targetSectionRegistry);
			newSelf.findPathsFromContainerToClassToConnect(classToConnect, c, directPathsOnly);
		}
		
		if(!directPathsOnly || this.pathElements.size()<1){
			// detect loop
			if (pathElements.contains(containerClass)) {
				return;

			}

			// add class to path if not abstract
			if (!containerClass.isAbstract()) {
				pathElements.add(containerClass);

				// continue path finding for references
				for (EReference cont : containerClass.getEAllContainments()) {
					ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements, cont,targetSectionRegistry,false);
					newSelf.findPathsFromContainerToClassToConnect(classToConnect, cont.getEReferenceType(), directPathsOnly);
				}

			}
		}
	}

	/**
	 * Finds paths to instances of the provided class.
	 * (from class to connect to container class, "up")
	 * @param pathStartClass
	 */
	void findPathsToInstances(EClass pathStartClass, boolean directPathsOnly) {

		// check if path to this MM-Class found
		if (targetSectionRegistry.getTargetClassInstances(pathStartClass).size() > 0
				&& pathElements.size() > 0) {
			// add copy of path to possiblePaths
			ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements, pathStartClass,targetSectionRegistry,false);

			// self.first.~possiblePaths.add(newSelf);
			targetSectionRegistry.addPath(newSelf, (EClass) this.pathElements.getFirst()); // first
																				// class
			return;
		}
		
		// check for inherited types
		for (EClass c : targetSectionRegistry.getChildClasses(pathStartClass)) {
			ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements,targetSectionRegistry);
			newSelf.findPathsToInstances(c,directPathsOnly);
		}
		
		if(!directPathsOnly || this.pathElements.size()<1){
			// detect loop
			if (pathElements.contains(pathStartClass)) {
				return;

			}

			// add class to path if not abstract
			if (!pathStartClass.isAbstract()) {
				pathElements.add(pathStartClass);

				// continue path finding for references
				for (EReference cont : targetSectionRegistry
						.getClassReferences(pathStartClass)) {

					for (EClass s : targetSectionRegistry.getReferenceSources(cont)) {
						ModelConnectionPath newSelf = new ModelConnectionPath(this.pathElements, cont,targetSectionRegistry,false);
						newSelf.findPathsToInstances(s,directPathsOnly);
					}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ModelConnectionPath){
			return ((ModelConnectionPath) obj).comparePathElements(pathElements);
		}else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return pathElements.hashCode();
	}
	
	
	
	
}
