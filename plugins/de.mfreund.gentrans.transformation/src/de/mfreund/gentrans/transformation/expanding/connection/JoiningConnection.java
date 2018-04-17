/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.expanding.connection;

import java.util.Collection;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import pamtram.structure.target.FileType;

/**
 * An {@link Connection} that is able to optionally wrap an {@link EClassConnectionPathBasedConnection} and add
 * unconnected elements to the root of a target model.
 *
 * @author mfreund
 */
public class JoiningConnection extends Connection {

	private EClassConnectionPathBasedConnection wrappedConnection;

	private TargetModelRegistry targetModelRegistry;

	/**
	 * Creates an instance that wraps an {@link EClassConnectionPathBasedConnection}.
	 * <p />
	 * Note: When {@link #instantiate() instantiated}, this will first instantiate the wrapped
	 * {@link EClassConnectionPathBasedConnection}. If this still leaves some
	 * {@link Connection#unconnectedElements unconnectedElements}, those are added to the root of a target
	 * model.
	 *
	 * @param startingElement
	 * @param targetElements
	 * @param connectionPath
	 *            The {@link EClassConnectionPath} used to construct the wrapped
	 *            {@link EClassConnectionPathBasedConnection}.
	 * @param targetSectionRegistry
	 * @param targetModelRegistry
	 * @param logger
	 *
	 */
	public JoiningConnection(EObjectWrapper startingElement, Collection<EObjectWrapper> targetElements,
			EClassConnectionPath connectionPath, TargetSectionRegistry targetSectionRegistry,
			TargetModelRegistry targetModelRegistry, Logger logger) {

		super(startingElement, targetElements, targetSectionRegistry, logger);

		wrappedConnection = connectionPath != null
				? new EClassConnectionPathBasedConnection(startingElement, connectionPath, targetElements,
						targetSectionRegistry, logger)
				: null;
		this.targetModelRegistry = targetModelRegistry;
	}

	/**
	 * Creates an instance that does not wrap an {@link EClassConnectionPathBasedConnection}.
	 * <p />
	 * Note: When {@link #instantiate() instantiated}, this will add all of the {@link #getTargetElements()
	 * targetElements} to the root of a target model.
	 *
	 * @param targetElements
	 * @param targetSectionRegistry
	 * @param targetModelRegistry
	 * @param logger
	 *
	 */
	public JoiningConnection(Collection<EObjectWrapper> targetElements, TargetSectionRegistry targetSectionRegistry,
			TargetModelRegistry targetModelRegistry, Logger logger) {

		this(null, targetElements, null, targetSectionRegistry, targetModelRegistry, logger);
	}

	@Override
	protected void doInstantiate() {

		if (wrappedConnection != null) {
			instantiateWrappedConnection();
		}

		addUnconnectedElementsToTargetModelRoot();
	}

	private void instantiateWrappedConnection() {

		wrappedConnection.doInstantiate();
		unconnectedElements = wrappedConnection.unconnectedElements;
	}

	private void addUnconnectedElementsToTargetModelRoot() {

		unconnectedElements.stream().forEach(this::addToTargetModelRoot);

		unconnectedElements.clear();
	}

	private void addToTargetModelRoot(EObjectWrapper helper) {

		EObject element = helper.getEObject();

		String targetModelPath = helper.getFile();

		if (targetModelPath.isEmpty()) {
			targetModelRegistry.addToTargetModel(element);

		} else {
			FileType targetModelFileType = helper.getFileType();
			targetModelRegistry.addToTargetModel(element, targetModelPath, targetModelFileType);
		}
	}
}
