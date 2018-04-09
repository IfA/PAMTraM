/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.expanding.connection.LinkingConnection;
import de.mfreund.gentrans.transformation.expanding.connection.LinkingConnectionProvider;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * Class for linking target model sections using the hints supplied by {@link MappingInstanceDescriptor
 * MappingInstanceStorages}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class TargetSectionLinker extends TargetSectionConnector {

	public static final String RESOLVE_LINKING_AMBIGUITY_STARTED = "[Ambiguity] Resolve linking ambiguity...";

	public static final String RESOLVE_LINKING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";

	private LinkingConnectionProvider connectionProvider;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public TargetSectionLinker(TransformationAssetManager assetManager) {

		super(assetManager);

		maxPathLength = Length.DIRECT_CONNECTION;

		connectionProvider = new LinkingConnectionProvider(assetManager, eClassConnectionPathProvider);

	}

	@Override
	protected void determineConnectionsToInstantiateForCurrentHintGroup() {

		List<TargetSectionCrossReference> crossReferences = collectContainedCrossReferencesRecursively(
				currentHintGroup.getTargetMMSectionGeneric());

		crossReferences.stream().forEach(this::determineConnectionsToLinkViaCrossReference);

	}

	private List<TargetSectionCrossReference> collectContainedCrossReferencesRecursively(
			TargetSectionClass targetSectionClass) {

		List<TargetSectionCrossReference> recursivelyContainedCrossReferences = new ArrayList<>();

		List<TargetSectionCrossReference> directlyContainedCrossReferences = targetSectionClass.getAllReferences()
				.stream().filter(TargetSectionCrossReference.class::isInstance)
				.map(TargetSectionCrossReference.class::cast).collect(Collectors.toList());

		recursivelyContainedCrossReferences.addAll(directlyContainedCrossReferences);

		List<TargetSectionCompositeReference> directlyContainedCompositeReferences = targetSectionClass
				.getAllReferences().stream().filter(TargetSectionCompositeReference.class::isInstance)
				.map(TargetSectionCompositeReference.class::cast).collect(Collectors.toList());

		List<TargetSectionClass> containedClasses = directlyContainedCompositeReferences.stream()
				.flatMap(r -> r.getValue().stream()).collect(Collectors.toList());

		for (TargetSectionClass containedClass : containedClasses) {
			recursivelyContainedCrossReferences.addAll(collectContainedCrossReferencesRecursively(containedClass));
		}

		return recursivelyContainedCrossReferences;
	}

	private void determineConnectionsToLinkViaCrossReference(TargetSectionCrossReference ref) {

		// We are searching for target elements for instances of this class
		//
		final TargetSectionClass targetSectionClass = !ref.isLibraryEntry() ? ref.getOwningClass()
				: ref.getContainingSection();

		List<EObjectWrapper> instancesToLink = currentMappingInstanceDescriptor.getInstances(currentHintGroup,
				targetSectionClass);

		if (!instancesToLink.isEmpty()) {
			determineConnectionsToLinkInstances(ref, instancesToLink);
		}

	}

	private void determineConnectionsToLinkInstances(TargetSectionCrossReference ref, List<EObjectWrapper> instances) {

		List<LinkingConnection> selectedConnections = connectionProvider.determineConnectionsToLinkInstances(
				currentMappingInstanceDescriptor, instances, ref, currentHintGroup);

		connectionsToInstantiate.addAll(selectedConnections);

	}

}
