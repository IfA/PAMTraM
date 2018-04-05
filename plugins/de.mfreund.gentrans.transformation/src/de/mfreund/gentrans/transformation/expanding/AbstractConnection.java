/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator.EClassConnectionPathInstantiationException;

/**
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public abstract class AbstractConnection {

	protected EObjectWrapper startingElement;

	protected List<EObjectWrapper> targetElements;

	protected List<EObjectWrapper> unconnectedElements;

	protected TargetSectionRegistry targetSectionRegistry;

	protected Logger logger;

	public AbstractConnection(EObjectWrapper startingElement, Collection<EObjectWrapper> targetElements,
			TargetSectionRegistry targetSectionRegistry, Logger logger) {

		this.startingElement = startingElement;
		this.targetElements = targetElements != null ? new ArrayList<>(targetElements) : new ArrayList<>();
		this.targetSectionRegistry = targetSectionRegistry;
		this.logger = logger;
		unconnectedElements = new ArrayList<>(targetElements);

	}

	public EObjectWrapper getStartingElement() {

		return startingElement;
	}

	public List<EObjectWrapper> getTargetElements() {

		return targetElements;
	}

	/**
	 * Instantiates this connection by creating an {@link EClassConnectionPathInstantiator} and calling
	 * {@link EClassConnectionPathInstantiator#instantiate() instantiate()} on it.
	 *
	 * @param targetSectionRegistry
	 *            The {@link TargetSectionRegistry} to which all created 'intermediate elements' shall be registered.
	 * @return A list of elements (a subset of the {@link #targetElements}) that could not be connected (possibly
	 *         because the capacity of the path was not large enough).
	 */
	public List<EObjectWrapper> instantiate() {

		try {
			doInstantiate();

		} catch (EClassConnectionPathInstantiationException e) {
			logger.log(Level.SEVERE, e, () -> e.getMessage() != null ? e.getMessage() : e.toString());
		}

		return Collections.unmodifiableList(unconnectedElements);
	}

	protected abstract void doInstantiate();

}