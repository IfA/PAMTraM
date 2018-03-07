/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathInstantiator;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;

/**
 *
 * @author mfreund
 */
public class EClassConnectionPathInstantiatorImpl extends EClassConnectionPathInstantiator {

	private List<DirectEClassConnectionPath> pathSegments;

	@SuppressWarnings("javadoc")
	public EClassConnectionPathInstantiatorImpl(EClassConnectionPath pathToInstantiate) {

		super(pathToInstantiate);
		this.pathSegments = EClassConnectionPathUtil.getPathSegments(pathToInstantiate);
	}

	/**
	 * {@link EClassConnectionPathInstantiator#instantiate(EObject, Collection) Instantiates} the path. If necessary,
	 * missing intermediary elements along the path will be created automatically.
	 *
	 */
	@Override
	public void instantiate(EObject rootObject, final Collection<EObject> objectsToConnect) {

		this.unconnectedElements = this.instantiateMissingPath(this.pathSegments, rootObject,
				new LinkedList<>(objectsToConnect));
	}

	/**
	 * The actual method for linking objects to another object.
	 * <p>
	 * Missing instances of objects along the path will be created.
	 *
	 * @param pathSegments
	 *            A list of elements describing the path to instantiate (in inverse order which means top-down).
	 * @param rootObject
	 *            The {@link EObject} that shall contain the list of 'objectsToConnect' after the instantiation of the
	 *            path.
	 * @param objectsToConnect
	 *            The list of {@link EObjectWrapper objects} that shall be connected to the 'rootObject' via this path.
	 * @returns unLinkedInstances A list of objects that could not be connected (possibly because the capacity of the
	 *          path was not large enough).
	 */
	@SuppressWarnings("unchecked")
	private List<EObject> instantiateMissingPath(List<DirectEClassConnectionPath> pathSegments,
			final EObject rootObject, List<EObject> objectsToConnect) {

		final LinkedList<DirectEClassConnectionPath> pathCopy = new LinkedList<>();
		pathCopy.addAll(pathSegments);

		DirectEClassConnectionPath segment = pathCopy.remove(0);
		final EReference ref = segment.getReference();
		Object targetInst = rootObject.eGet(ref);

		if (!pathCopy.isEmpty()) {

			// Connect to a single-valued reference
			//
			if (ref.getUpperBound() == 1) {// only one target instance allowed,
				// check if it exists
				if (targetInst == null) {
					final EClass classToCreate = segment.getTargetClass();
					final EObject inst = classToCreate.getEPackage().getEFactoryInstance().create(classToCreate);

					this.createdIntermediaryElements.add(inst);
					rootObject.eSet(ref, inst);

					targetInst = inst;
				}

				objectsToConnect = this.instantiateMissingPath(pathCopy, (EObject) targetInst, objectsToConnect);
				return objectsToConnect;

				// Connect to a multi-valued reference with 'upperBound == -1'
				//
			} else if (ref.getUpperBound() < 0) {

				/*
				 * it is absolutely necessary to copy targetInst, since targetInst will be cleared by eSet before new
				 * elements are added
				 */
				final LinkedList<EObject> newTarget = new LinkedList<>();
				final List<EObject> targetInstL = new LinkedList<>();
				if (targetInst != null) {
					final EList<EObject> castedList = (EList<EObject>) targetInst;
					targetInstL.addAll(castedList);
				}

				final EClass classToCreate = segment.getTargetClass();

				while (!objectsToConnect.isEmpty()) {

					final EObject instance = classToCreate.getEPackage().getEFactoryInstance().create(classToCreate);
					targetInstL.add(instance);
					newTarget.clear();// shouldn't be neccesssary because eSet will clear this
					newTarget.addAll(targetInstL);
					this.createdIntermediaryElements.add(newTarget.getLast());
					rootObject.eSet(ref, newTarget);

					objectsToConnect = this.instantiateMissingPath(pathCopy, instance, objectsToConnect);
				}

				return objectsToConnect;

			} else {

				// There is enough place to connect all objects
				//
				if (ref.getUpperBound() > 1 && ref.getUpperBound()
						- (targetInst == null ? 0 : ((EList<EObject>) targetInst).size()) >= objectsToConnect.size()) {

					/*
					 * it is absolutely necessary to copy targetInst, since targetInst will be cleared by eSet before
					 * new elements are added
					 */
					final LinkedList<EObject> newTarget = new LinkedList<>();
					final List<EObject> targetInstL = new LinkedList<>();
					if (targetInst != null) {
						final EList<EObject> castedList = (EList<EObject>) targetInst;
						targetInstL.addAll(castedList);
					}

					final EClass classToCreate = segment.getTargetClass();

					while (!objectsToConnect.isEmpty()) {

						final EObject instance = classToCreate.getEPackage().getEFactoryInstance()
								.create(classToCreate);

						targetInstL.add(instance);
						newTarget.clear();// shouldn't be neccesssary because eSet will clear this
						newTarget.addAll(targetInstL);
						this.createdIntermediaryElements.add(newTarget.getLast());
						rootObject.eSet(ref, newTarget);

						objectsToConnect = this.instantiateMissingPath(pathCopy, instance, objectsToConnect);
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
					rootObject.eSet(ref, objectsToConnect.remove(0));

					return objectsToConnect;

				}

				// Connect to a multi-valued reference with 'upperBound == -1'
				//
			} else if (ref.getUpperBound() < 0) {
				final LinkedList<EObject> newTarget = new LinkedList<>();// it
				/*
				 * is absolutely neccessary to copy targetInst, since targetInst will be cleared by eSet before new
				 * elements are added
				 */
				if (targetInst != null) {
					final EList<EObject> targetInstL = (EList<EObject>) targetInst;
					newTarget.addAll(targetInstL);
				}
				for (final EObject inst : objectsToConnect) {
					newTarget.add(inst);
				}

				rootObject.eSet(ref, newTarget);
				return new LinkedList<>();

				// Connect to a multi-valued refernce with 'upperBound != -1'
				//
			} else {

				// There is enough place to connect all objects
				//
				if (ref.getUpperBound() > 1 && ref.getUpperBound()
						- (targetInst == null ? 0 : ((EList<EObject>) targetInst).size()) >= objectsToConnect.size()) {

					final LinkedList<EObject> newTarget = new LinkedList<>();// it
					/*
					 * is absolutely neccessary to copy targetInst, since targetInst will be cleared by eSet before new
					 * elements are added
					 */
					if (targetInst != null) {
						final EList<EObject> targetInstL = (EList<EObject>) targetInst;
						newTarget.addAll(targetInstL);
					}
					for (final EObject inst : objectsToConnect) {
						newTarget.add(inst);
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

}
