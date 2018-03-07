/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * A base class for classes that allow to #instantiat an {@link EClassConnectionPath}, i.e. connect one or multiple
 * target elements to a starting elements according to the path specification.
 *
 * @author mfreund
 */
public abstract class EClassConnectionPathInstantiator {

	protected final EClassConnectionPath pathToInstantiate;

	protected List<EObject> createdIntermediaryElements;

	protected List<EObject> unconnectedElements;

	@SuppressWarnings("javadoc")
	public EClassConnectionPathInstantiator(EClassConnectionPath pathToInstantiate) {

		this.pathToInstantiate = pathToInstantiate;
		this.createdIntermediaryElements = new ArrayList<>();
		this.unconnectedElements = new ArrayList<>();
	}

	/**
	 * Connect the given collection of targetObjects to the given startingObject according to the
	 * {@link #pathToInstantiate}.
	 *
	 * @param startingObject
	 * @param targetObjects
	 */
	public abstract void instantiate(EObject startingObject, Collection<EObject> targetObjects);

	/**
	 * @return the {@link #createdIntermediaryElements}
	 */
	public List<EObject> getCreatedIntermediaryElements() {

		return this.createdIntermediaryElements;
	}

	/**
	 * @return the {@link #unconnectedElements}
	 */
	public List<EObject> getUnconnectedElements() {

		return this.unconnectedElements;
	}

}
