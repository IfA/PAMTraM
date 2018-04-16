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
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.List;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.expanding.connection.Connection;
import de.mfreund.gentrans.transformation.registries.SelectedMappingRegistry;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import de.tud.et.ifa.agtele.emf.connecting.Length;

/**
 * An abstract base implementation for workers that are able to perform some aspects of the <em>expanding</em> step of
 * the transformation that are related to connecting instantiated elements.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public abstract class TargetSectionConnector extends TargetSectionExpander {

	protected EClassConnectionPathProvider eClassConnectionPathProvider;

	protected Length maxPathLength;

	protected List<Connection> connectionsToInstantiate;

	public TargetSectionConnector(TransformationAssetManager assetManager) {

		super(assetManager);

		eClassConnectionPathProvider = assetManager.getEClassConnectionPathProvider();
		maxPathLength = assetManager.getTransformationConfig().getMaxPathLength();
		connectionsToInstantiate = new ArrayList<>();
	}

	@Override
	public void expandMappingInstances(SelectedMappingRegistry selectedMappingRegistry) {

		super.expandMappingInstances(selectedMappingRegistry);

		instantiateConnections();
	}

	@Override
	protected void doExpandCurrentHintGroup() {

		if (hasCurrentMappinHintGroupBeenInstantiated()) {
			determineConnectionsToInstantiateForCurrentHintGroup();
		}

	}

	private boolean hasCurrentMappinHintGroupBeenInstantiated() {

		return !currentMappingInstanceDescriptor.getRootInstances(currentHintGroup).isEmpty();
	}

	/**
	 * Determine all {@link Connection AbstractConnections} that need to be instantiated in order to expand the
	 * {@link TargetSectionExpander#currentHintGroup} and store them in the {@link #connectionsToInstantiate}. These
	 * will be instantiated at the end of the {@link #expandMappingInstances(SelectedMappingRegistry) expanding}
	 * process.
	 */
	protected abstract void determineConnectionsToInstantiateForCurrentHintGroup();

	private void instantiateConnections() {

		connectionsToInstantiate.stream().forEach(Connection::instantiate);
	}
}
