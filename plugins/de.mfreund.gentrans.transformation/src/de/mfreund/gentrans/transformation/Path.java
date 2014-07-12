package de.mfreund.gentrans.transformation;

import java.util.LinkedList;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class Path {

	private TargetSectionRegistry targetSectionRegistry;

	private LinkedList<EObject> pathElements;

	public Path(TargetSectionRegistry targetSectionRegistry) {
		this.pathElements = new LinkedList<EObject>();
		this.targetSectionRegistry=targetSectionRegistry;


	}

	private Path(LinkedList<EObject> pathElements,TargetSectionRegistry targetSectionRegistry) {

		this.pathElements = new LinkedList<EObject>();
		this.pathElements.addAll(pathElements);
		this.targetSectionRegistry=targetSectionRegistry;


	}

	private Path(LinkedList<EObject> pathElements, EObject newElement,TargetSectionRegistry targetSectionRegistry) {

		this.pathElements = new LinkedList<EObject>();
		this.pathElements.addAll(pathElements);
		this.pathElements.add(newElement);
		this.targetSectionRegistry=targetSectionRegistry;


	}

	public void findPathsToInstances(EClass targetSectionClass) {

		// check if path to this MM-Class found
		if (targetSectionRegistry.getTargetClassInstances(targetSectionClass).size() > 0
				&& pathElements.size() > 0) {
			// add copy of path to possiblePaths
			Path newSelf = new Path(this.pathElements, targetSectionClass,targetSectionRegistry);

			// self.first.~possiblePaths.add(newSelf);
			targetSectionRegistry.addPath(newSelf, (EClass) this.pathElements.getFirst()); // first
																				// class
			return;
		}

		// check for inherited types
		for (EClass c : targetSectionRegistry.getChildClasses(targetSectionClass)) {
			Path newSelf = new Path(this.pathElements,targetSectionRegistry);
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
					Path newSelf = new Path(this.pathElements, cont,targetSectionRegistry);
					newSelf.findPathsToInstances(s);
				}
			}

		}

	}

	@SuppressWarnings("unchecked")
	public int getCapacity(EObject targetInstance) {
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
							instance = null;
							max = max
									* (ref.getUpperBound() - ((EList<EObject>) targets)
											.size());
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

	@Override
	public String toString() {
		String path = "";
		boolean first = true;

		ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			if (!first) {
				path += "  ";
			} else
				first = false;
			EObject prev = it.previous();
			if (prev instanceof EClass) {
				path += ((EClass) prev).getName();
			} else if (prev instanceof EReference) {
				path += ((EReference) prev).getName();
			}
		}

		return path;
	}

	public LinkedList<EObject> getInvertedPath() {
		LinkedList<EObject> inverted = new LinkedList<EObject>();
		ListIterator<EObject> it = pathElements.listIterator(pathElements
				.size());

		while (it.hasPrevious()) {
			inverted.add(it.previous());

		}

		return inverted;
	}

	public EClass getRootType() {
		return (EClass) pathElements.getLast();

	}

	public boolean leadsToRootType(EClass root) {
		if (pathElements.size() > 0) {
			if (pathElements.getLast() instanceof EClass) {

				return ((EClass) pathElements.getLast()).equals(root);//TODO chekc if this works

			} else
				return false;

		} else
			return false;
	}

	public int size() {
		return pathElements.size();
	}
	
	


}
