/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * An abstract base implementation for classes that allow to {@link #instantiate(EObject, Collection) instantiate} an
 * {@link EClassConnectionPath}, i.e. connect one or multiple target elements to a starting elements according to the
 * path specification.
 *
 * @author mfreund
 */
public abstract class EClassConnectionPathInstantiator {

	protected final EClassConnectionPath pathToInstantiate;

	protected List<EObject> createdIntermediaryElements;

	// FIXME do we need this any more? we check capacity first so it should never get filled
	protected List<EObject> unconnectedElements;

	protected EObject startingElement;

	protected List<EObject> targetElements;

	protected EClassConnectionPathInstantiator(EClassConnectionPath pathToInstantiate) {

		this.pathToInstantiate = pathToInstantiate;
	}

	protected void init(EObject startingElement, Collection<EObject> targetElements) {

		createdIntermediaryElements = new ArrayList<>();
		unconnectedElements = new ArrayList<>();
		this.startingElement = startingElement;
		this.targetElements = new ArrayList<>(targetElements);
	}

	/**
	 * Connect the given collection of targetObjects to the given startingObject according to the
	 * {@link #pathToInstantiate}.
	 *
	 * @param startingElement
	 * @param targetElements
	 * @throws EClassConnectionPathInstantiationException
	 */
	public void instantiate(EObject startingElement, Collection<EObject> targetElements) {

		init(startingElement, targetElements);

		if (targetElements.isEmpty()) {
			return;
		}

		checkStartingElementMatchesStartingClass();

		checkStartingElementProvidesRequiredCapacity();

		instantiate();
	}

	protected abstract void instantiate();

	/**
	 * @return the {@link #createdIntermediaryElements}
	 */
	public List<EObject> getCreatedIntermediaryElements() {

		return createdIntermediaryElements != null ? createdIntermediaryElements : new ArrayList<>();
	}

	/**
	 * @return the {@link #unconnectedElements}
	 */
	public List<EObject> getUnconnectedElements() {

		return unconnectedElements != null ? unconnectedElements : new ArrayList<>();
	}

	protected void checkStartingElementMatchesStartingClass() {

		if (!pathToInstantiate.isValidStartingElement(startingElement)) {

			unconnectedElements.addAll(targetElements);

			throw new EClassConnectionPathInstantiationException("Error instantiating EClassConnectionPath '"
					+ pathToInstantiate + "'! The EClass of the given starting element ('"
					+ startingElement.eClass().getName() + "') does not conform to the path specification.");
		}
	}

	protected void checkStartingElementProvidesRequiredCapacity() {

		Capacity actualCapacity = pathToInstantiate.getActualCapacity(startingElement);
		Capacity requiredCapactiy = Capacity.valueOf(targetElements);

		if (!actualCapacity.isSufficientFor(requiredCapactiy)) {

			unconnectedElements.addAll(targetElements);

			throw new EClassConnectionPathInstantiationException(
					"Error instantiating EClassConnectionPath '" + pathToInstantiate
							+ "'! The given starting element does not provide the required capacity to connect the "
							+ targetElements.size() + " target elements.");
		}

	}

	@SuppressWarnings("javadoc")
	public class EClassConnectionPathInstantiationException extends RuntimeException {

		private static final long serialVersionUID = 6362792531128516301L;

		public EClassConnectionPathInstantiationException(String message, Throwable cause) {

			super(message, cause);
		}

		public EClassConnectionPathInstantiationException(String message) {

			super(message);
		}

		public EClassConnectionPathInstantiationException(Throwable cause) {

			super(cause);
		}

	}
}
