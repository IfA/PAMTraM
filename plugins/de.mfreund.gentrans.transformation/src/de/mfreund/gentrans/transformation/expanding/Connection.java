/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
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
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator.EClassConnectionPathInstantiationException;

/**
 * A class that represents a connection between model elements to be instantiated. Each connection is characterized by a
 * {@link #startingElement}, a {@link #connectionPath}, and a list of {@link #targetElements}.
 * <p />
 * This basically represents a wrapper for an {@link EClassConnectionPathInstantiator} that works based on
 * {@link EObjectWrapper EObjectWrappers} instead of {@link EObject}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class Connection {

	protected EObjectWrapper startingElement;

	protected EClassConnectionPath connectionPath;

	protected List<EObjectWrapper> targetElements;

	protected List<EObjectWrapper> unconnectedElements;

	protected TargetSectionRegistry targetSectionRegistry;

	protected Logger logger;

	public Connection(EObjectWrapper startingElement, EClassConnectionPath connectionPath,
			Collection<EObjectWrapper> targetElements) {

		this.startingElement = startingElement;
		this.connectionPath = connectionPath;
		this.targetElements = targetElements != null ? new ArrayList<>(targetElements) : new ArrayList<>();
		unconnectedElements = new ArrayList<>(targetElements);
	}

	public EObjectWrapper getStartingElement() {

		return startingElement;
	}

	public EClassConnectionPath getConnectionPath() {

		return connectionPath;
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
	public List<EObjectWrapper> instantiate(TargetSectionRegistry targetSectionRegistry, Logger logger) {

		this.targetSectionRegistry = targetSectionRegistry;
		this.logger = logger;

		try {
			doInstantiate();

		} catch (EClassConnectionPathInstantiationException e) {
			logger.log(Level.SEVERE, e, () -> e.getMessage() != null ? e.getMessage() : e.toString());
		}

		return Collections.unmodifiableList(unconnectedElements);
	}

	protected void doInstantiate() {

		EObject startingEObject = startingElement.getEObject();
		List<EObject> targetEObjects = targetElements.stream().map(EObjectWrapper::getEObject)
				.collect(Collectors.toList());
		EClassConnectionPathInstantiator instantiator = connectionPath.createInstantiator(startingEObject,
				targetEObjects);
		instantiator.instantiate();

		instantiator.getCreatedIntermediaryElements().stream().forEach(targetSectionRegistry::addClassInstance);

		List<EObject> unconnectedEObjects = instantiator.getUnconnectedElements();

		unconnectedElements = targetElements.stream().filter(r -> unconnectedEObjects.contains(r.getEObject()))
				.collect(Collectors.toList());
	}
}
