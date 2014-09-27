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
	private ModelConnectionPath(TargetSectionRegistry targetSectionRegistry) {
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
	 * @param elementClass
	 * @param containerClass
	 * @param directPathsOnly
	 */
	 static void findPathsFromContainerToClassToConnect(TargetSectionRegistry registry, EClass elementClass, EClass containerClass,
			boolean directPathsOnly) {
		new ModelConnectionPath(registry).findPathsFromContainerToClassToConnect(elementClass, containerClass, directPathsOnly);
	}
	
	/**
	 *(from container class to class to connect, "down")
	 * @param classToConnect
	 * @param containerClass
	 * @param directPathsOnly
	 */
	private void findPathsFromContainerToClassToConnect(EClass classToConnect, EClass containerClass, boolean directPathsOnly){
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
	
	static void findPathsToInstances(TargetSectionRegistry registry, EClass pathStartClass, boolean directPathsOnly) {
		new ModelConnectionPath(registry).findPathsToInstances(pathStartClass,directPathsOnly);
	}

	/**
	 * Finds paths to instances of the provided class.
	 * (from class to connect to container class, "up")
	 * @param pathStartClass
	 */
	private void findPathsToInstances(EClass pathStartClass, boolean directPathsOnly) {

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
	private LinkedList<EObject> getInvertedPathElementList() {
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
	EClass getRootType() {
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
			return ((ModelConnectionPath) obj).pathElements.equals(this.pathElements);
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
	
	
	/**
	 * INstantiate the Path for all the supplied elements.
	 * (This will not modify the List "instancesAtEnd")
	 * @param refStartInstance
	 * @param instancesAtEnd
	 * @return unconnected instances
	 */
	List<EObjectTransformationHelper> instantiate(EObject refStartInstance, Collection<EObjectTransformationHelper> instancesAtEnd){
		return instantiateMissingPath(getInvertedPathElementList(), refStartInstance, new LinkedList<EObjectTransformationHelper>(instancesAtEnd));
	}
	
	/**
	 * The actual method for linking Objects to another object.
	 * <p>
	 * Missing instances of objects along the path will be created.
	 * @param invertedPath
	 * @param refStartInstance
	 * @param instancesAtEnd
	 * @param attrValRegistry 
	 * @returns unLinkedInstances
	 */
	private List<EObjectTransformationHelper> instantiateMissingPath(
			LinkedList<EObject> invertedPath, EObject refStartInstance,
			List<EObjectTransformationHelper> instancesAtEnd) {
		LinkedList<EObject> pathCopy=new LinkedList<EObject> ();
		pathCopy.addAll(invertedPath);
		pathCopy.remove(0);// EClass refStart=(EClass)
		EReference ref = (EReference) pathCopy.remove(0);
		Object targetInst = refStartInstance.eGet(ref);

		if (pathCopy.size() > 1) {
			if (ref.getUpperBound() == 1) {// only one target instance allowed,
											// check if it exists
				if (targetInst == null) {
					EClass classToCreate=(EClass) pathCopy.get(0);
					EObject inst =  classToCreate.getEPackage().getEFactoryInstance().create(classToCreate);

					targetSectionRegistry.addClassInstance(inst);
					refStartInstance.eSet(ref, inst);
					
					targetInst=inst;
				}
				
				instancesAtEnd=instantiateMissingPath(pathCopy, (EObject) targetInst,instancesAtEnd);
				return instancesAtEnd;


			} else if (ref.getUpperBound() < 0) {
				LinkedList<EObject> newTarget = new LinkedList<EObject>();// it is absolutely neccessary to copy
																			// targetInst, since targetInst will be cleared by
				List<EObject> targetInstL=new LinkedList<EObject>();														// eSet before new elements are added
				if (targetInst != null) {
					@SuppressWarnings("unchecked")
					EList<EObject> castedList=(EList<EObject>) targetInst;
					targetInstL.addAll(castedList);
				}
				
				EClass classToCreate=(EClass) pathCopy.get(0);
				
				while(instancesAtEnd.size()>0){
					EObject instance = classToCreate.getEPackage().getEFactoryInstance().create(classToCreate);
					// instance.~description="Class '" + newSelf.first.name +
					// "' (created to link targetSection):"; TODO seee above
					targetInstL.add(instance);
					newTarget.clear();//shouldn't be neccesssary because eSet will clear this
					newTarget.addAll(targetInstL);
					targetSectionRegistry.addClassInstance((EObject)newTarget.getLast());
					refStartInstance.eSet(ref, newTarget);
					
					instancesAtEnd=instantiateMissingPath(pathCopy,instance,instancesAtEnd);
				}
				
				return instancesAtEnd;

			} else {// cardinality less than infinity
				// TODO
				System.out.println("Owei, owei");
				//addToTargetModelRoot(instancesAtEnd);
				return  new LinkedList<EObjectTransformationHelper>();

			}

		} else {// at End
			if (ref.getUpperBound() == 1) {
				if (targetInst != null){
					System.out.println("Big mistake"); // this shouldn't happen
					//addToTargetModelRoot(instancesAtEnd);
					return new LinkedList<EObjectTransformationHelper>();
				} else {
					refStartInstance.eSet(ref, instancesAtEnd.remove(0).getEObject());
					
					return instancesAtEnd;

				}
			} else if (ref.getUpperBound() < 0) {
				LinkedList<EObject> newTarget = new LinkedList<EObject>();// it is absolutely  neccessary  to  copy
																			// targetInst,  since  targetInst  will  be  cleared  
																			//by eSet before new elements are added
				if (targetInst != null) {
					@SuppressWarnings("unchecked")
					EList<EObject> targetInstL=(EList<EObject>) targetInst;
					newTarget.addAll(targetInstL);
				}
				for(EObjectTransformationHelper inst : instancesAtEnd){
					newTarget.add(inst.getEObject());
				}

				refStartInstance.eSet(ref, newTarget);
				return new LinkedList<EObjectTransformationHelper>();
			} else {// cardinality less than infinity
					// TODO
				System.out.println("owei, owei");
				//addToTargetModelRoot(instancesAtEnd);
				return new LinkedList<EObjectTransformationHelper>();
			}
		}

	} 
	
	/**
	 * Return possible paths that can connect a minimum number of elements
	 * @param startInstance may be null
	 * @param minimumCapacity
	 * @return possible paths
	 */
	 static LinkedHashSet<ModelConnectionPath> findPathsWithMinimumCapacity(
			LinkedHashSet<ModelConnectionPath> paths,
			EObject startInstance, int minimumCapacity) {
		LinkedHashSet<ModelConnectionPath> pathsToConsider = new LinkedHashSet<ModelConnectionPath>();
		for (ModelConnectionPath p : paths) {
			if (startInstance != null) {
				if (!p.leadsToRootType(startInstance.eClass())) {
					continue;// only consider paths with the right start
								// instance type
				}
			}

			int capacity = p.getCapacity(startInstance);
			if (capacity != 0) {
				if ((minimumCapacity != -1 && capacity >= minimumCapacity)
						|| capacity == -1) {
					pathsToConsider.add(p);
				}
			}
		}
		return pathsToConsider;
	}

}
