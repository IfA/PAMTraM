package de.mfreund.gentrans.transformation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

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
	 * @param paths
	 * @return
	 */
	 static Set<EClass> getCommonClasses(CancellationListener cListener, Map<EClass,List<ModelConnectionPath>> paths){
		Set<EClass> returnSet=new LinkedHashSet<EClass>(); 
		
		Set<EClass> rejected=new LinkedHashSet<EClass>();

		
		if(paths.size()>0){
			List<ModelConnectionPath> comparePath=paths.remove(paths.keySet().iterator().next());
			
			/*
			 * check for each possible Path of the first path List
			 */
			for(ModelConnectionPath element : comparePath){
				//we will now try to find each EClass in the path in one of the paths of the other Lists
				//in case an EClass is found in at least one of the paths of each map value, it will be put to the return sets
				//This means, that one common elements for the EClasses in the key set of the map was found, sothey can be connected
				
				for(EObject pElement : element.pathElements){
					if(cListener.isCancelled()) return Collections.<EClass>emptySet();
					
					if(pElement instanceof EClass){//we do not check the references
						if(rejected.contains(pElement) || returnSet.contains(pElement)){//did we check this before?
							continue;
						} else {
							for(EClass cPathListClass : paths.keySet()){//check in other lists
								boolean foundElement=false;
								for(ModelConnectionPath  cPath : paths.get(cPathListClass)){
									if(cListener.isCancelled()) return Collections.<EClass>emptySet();
									if(cPath.pathElements.contains(pElement)){
										foundElement=true;
										break;//we only need to find one path per key EClass
									}
								}
								if(!foundElement){//if it fails for one element of the key set we can stop looking further
									rejected.add((EClass) pElement);
									break;
								}
							}
							
							if(!rejected.contains(pElement)){//element can be used as container for every EClass in the key set
								returnSet.add((EClass) pElement);
							}
						}
					}
				}
			}


		}	
			return returnSet;
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
			int maxPathLength) {
		//new ModelConnectionPath(registry).findPathsFromContainerToClassToConnect(elementClass, containerClass, maxPathLength);
		LinkedHashSet<Pair<EClass,LinkedList<EObject>>> pathStack=new LinkedHashSet<Pair<EClass,LinkedList<EObject>>>();
		
		pathStack.add(new Pair<EClass,LinkedList<EObject>>(containerClass,new LinkedList<EObject>()));
		
		while(pathStack.size()>0 && !registry.isCancelled()){
			Pair<EClass,LinkedList<EObject>> next=pathStack.iterator().next();
			pathStack.remove(next);
			
			
			if(next.getLeft().equals(elementClass) && next.getRight().size()>0){
				// add copy of path to possiblePaths
				ModelConnectionPath newSelf = new ModelConnectionPath(next.getRight(), elementClass,registry,true);

				registry.addConnection(newSelf, elementClass, (EClass) next.getRight().getFirst());
			} else {				
				// check for inherited types
				for (EClass c :  registry.getChildClasses(next.getLeft())) {
					pathStack.add(new Pair<EClass,LinkedList<EObject>>(c,next.getRight()));
				}
				
				if(maxPathLength < 0 || (next.getRight().size()/2-1) < maxPathLength){
					// detect loop
					if (!next.getRight().contains(next.getLeft()) && !next.getLeft().isAbstract()) {
						// continue path finding for references
						for (EReference cont : next.getLeft().getEAllContainments()) {
							LinkedList<EObject> newRight=new LinkedList<EObject>(next.getRight());
							newRight.add(next.getLeft());
							newRight.add(cont);
							pathStack.add(new Pair<EClass,LinkedList<EObject>>(cont.getEReferenceType(),newRight));
						}
					}
				}			
			}	
		}
		
	}
	 
		/**
		 * Finds paths to instances of the provided class.
		 * (from class to connect to container class, "up")
		 * @param pathStartClass
		 */
	 static void findPathsToInstances(TargetSectionRegistry registry, EClass pathStartClass, int maxPathLength) {
			//new ModelConnectionPath(registry).findPathsFromContainerToClassToConnect(elementClass, containerClass, maxPathLength);
			LinkedHashSet<Pair<EClass,LinkedList<EObject>>> pathStack=new LinkedHashSet<Pair<EClass,LinkedList<EObject>>>();
			
			pathStack.add(new Pair<EClass,LinkedList<EObject>>(pathStartClass,new LinkedList<EObject>()));
			
			while(pathStack.size()>0 && !registry.isCancelled()){
				Pair<EClass,LinkedList<EObject>> next=pathStack.iterator().next();
				pathStack.remove(next);
				
				// check if path to this MM-Class found
				if (registry.getTargetClassInstances(next.getLeft()).size() > 0
						&& next.getRight().size() > 0) {
					// add copy of path to possiblePaths
					ModelConnectionPath newSelf = new ModelConnectionPath(next.getRight(), next.getLeft(),registry,false);

					// self.first.~possiblePaths.add(newSelf);
					registry.addPath(newSelf, (EClass) next.getRight().getFirst()); // first  class
					
				} else {
					// check for inherited types
					for (EClass c : registry.getChildClasses(next.getLeft())) {
						pathStack.add(new Pair<EClass,LinkedList<EObject>>(c,next.getRight()));
					}
					
					if(maxPathLength < 0 || (next.getRight().size()/2-1) < maxPathLength){
						// detect loop
						if (!next.getRight().contains(next.getLeft()) && !next.getLeft().isAbstract()) {
							// continue path finding for references
							for (EReference cont : registry.getClassReferences(next.getLeft())) {
								for (EClass s : registry.getReferenceSources(cont)) {
									LinkedList<EObject> newRight=new LinkedList<EObject>(next.getRight());
									newRight.add(next.getLeft());
									newRight.add(cont);
									pathStack.add(new Pair<EClass,LinkedList<EObject>>(s,newRight));
								}
							}

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
	EClass getPathRootClass() {
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
