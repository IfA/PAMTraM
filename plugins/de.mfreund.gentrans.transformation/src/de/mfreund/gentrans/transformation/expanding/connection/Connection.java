/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.expanding.connection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.expanding.TargetSectionConnector;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator.EClassConnectionPathInstantiationException;

/**
 * An abstract base class for connections that are determined by instances of {@link AbstractConnectionProvider}. These
 * are used to create connections between instantiated elements by instances of {@link TargetSectionConnector}.
 * 
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public abstract class Connection {

	protected EObjectWrapper startingElement;

	protected List<EObjectWrapper> targetElements;

	protected List<EObjectWrapper> unconnectedElements;

	protected TargetSectionRegistry targetSectionRegistry;

	protected Logger logger;

	public Connection(EObjectWrapper startingElement, Collection<EObjectWrapper> targetElements,
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
