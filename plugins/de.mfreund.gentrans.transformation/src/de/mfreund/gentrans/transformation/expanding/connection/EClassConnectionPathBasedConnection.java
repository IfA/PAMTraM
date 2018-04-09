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

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator;

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
public class EClassConnectionPathBasedConnection extends Connection {

	protected EClassConnectionPath connectionPath;

	public EClassConnectionPathBasedConnection(EObjectWrapper startingElement, EClassConnectionPath connectionPath,
			Collection<EObjectWrapper> targetElements, TargetSectionRegistry targetSectionRegistry, Logger logger) {

		super(startingElement, targetElements, targetSectionRegistry, logger);

		this.connectionPath = connectionPath;
	}

	public EClassConnectionPath getConnectionPath() {

		return connectionPath;
	}

	@Override
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
