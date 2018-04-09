/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathRequirement;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;

/**
 * This class is responsible for joining the unconnected target sections to form one coherent target model.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class TargetSectionJoiner extends TargetSectionConnector {

	static final String RESOLVE_JOINING_AMBIGUITY_ENDED = "[Ambiguity] ...finished.\n";

	static final String RESOLVE_JOINING_AMBIGUITY_STARTED = "[Ambiguity] Resolve joining ambiguity...";

	/**
	 * This keeps track of {@link TargetSectionClass TargetSectionClasses} and corresponding {@link EObjectWrapper
	 * EObjects} for that no {@link ComplexEClassConnectionPath} could be determined. These elements are potential root
	 * elements respectively need to be connected to a - yet to be created - root element. The key of the Map thereby
	 * denotes the {@link EClass} that the TargetSectionClasses are associated with.
	 */
	private final Map<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unconnectedElementRegistry;

	private List<EObjectWrapper> unnconnectedInstances;

	private JoiningConnectionProvider connectionProvider;

	public TargetSectionJoiner(TransformationAssetManager assetManager) {

		super(assetManager);

		unconnectedElementRegistry = new LinkedHashMap<>();
		connectionProvider = new JoiningConnectionProvider(assetManager, eClassConnectionPathProvider);
	}

	@Override
	protected void expandMappingInstances(List<MappingInstanceDescriptor> mappingInstanceDescriptors) {

		super.expandMappingInstances(mappingInstanceDescriptors);

		determineConnectionsToJoinUnconnectedElements();
	}

	@Override
	protected void determineConnectionsToInstantiateForCurrentHintGroup() {

		List<EObjectWrapper> instancesToJoin = currentMappingInstanceDescriptor.getRootInstances(currentHintGroup);

		if (!instancesToJoin.isEmpty()) {
			determineConnectionsToJoinInstancesOfCurrentHintGroup(instancesToJoin);
		}
	}

	private void determineConnectionsToJoinInstancesOfCurrentHintGroup(List<EObjectWrapper> instances) {

		List<JoiningConnection> selectedConnections = connectionProvider
				.determineConnectionsToJoinInstances(currentMappingInstanceDescriptor, instances, currentHintGroup);

		if (selectedConnections.isEmpty()) {
			registerAsUnconnectable(instances);

		} else {
			connectionsToInstantiate.addAll(selectedConnections);
		}

	}

	/**
	 * Registers the given list of elements as {@link #unconnectedElementRegistry} so that they will be regarded by
	 * {@link #determineConnectionsToJoinUnconnectedElements()}.
	 *
	 * @param unconnectableInstances
	 *            The list of {@link EObjectWrapper elements} to register.
	 * @param section
	 *            The {@link TargetSection} that was responsible for creating the instances.
	 */
	private void registerAsUnconnectable(List<EObjectWrapper> unconnectableInstances) {

		TargetSection targetSection = currentHintGroup.getTargetMMSectionGeneric();
		EClass eClass = targetSection.getEClass();

		if (!unconnectedElementRegistry.containsKey(eClass)) {

			unconnectedElementRegistry.put(eClass, new LinkedHashMap<TargetSectionClass, List<EObjectWrapper>>());
		}

		if (!unconnectedElementRegistry.get(eClass).containsKey(targetSection)) {

			unconnectedElementRegistry.get(eClass).put(targetSection, new LinkedList<EObjectWrapper>());
		}

		unconnectedElementRegistry.get(eClass).get(targetSection).addAll(unconnectableInstances);
	}

	/**
	 * This takes the list of {@link #unconnectedElementRegistry} and adds them to the target model.
	 * <p />
	 * In the easiest case, the list of {@link #unconnectedElementRegistry} contains only a single element which will
	 * then be used as root element. If multiple elements exist, this tries to determine a common root element and joins
	 * the elements with it. If no common root element can be determined, multiple root elements are added to the target
	 * model.
	 */
	private void determineConnectionsToJoinUnconnectedElements() {

		checkCanceled();

		if (unconnectedElementRegistry.isEmpty()) {
			return;
		}

		unnconnectedInstances = unconnectedElementRegistry.values().stream().flatMap(v -> v.values().stream())
				.flatMap(Collection::stream).collect(Collectors.toList());

		logger.info(() -> "Joining " + unnconnectedInstances.size()
				+ " unconnected instances with a target model root element...");

		if (unnconnectedInstances.size() == 1) {
			determineConnectionsToJoinSingleUnconnectedElement(unnconnectedInstances.get(0));

		} else {
			determineConnectionsToJoinMultipleUnconnectedElements();
		}

	}

	private void determineConnectionsToJoinSingleUnconnectedElement(EObjectWrapper elementToJoin) {

		// Only one element could not be connected -> we already have our root element
		//
		logger.info(() -> "Root element: The single instance of the target section '" + elementToJoin + "'.");
		connectionsToInstantiate.add(
				connectionProvider.determineConnectionToJoinInstancesWithTargetModelRoot(Arrays.asList(elementToJoin)));
	}

	private void determineConnectionsToJoinMultipleUnconnectedElements() {

		List<EClass> classesThatCanActAsCommonRoot = collectClassesThatCanActAsCommonRoot();

		if (classesThatCanActAsCommonRoot.isEmpty()) {

			logger.warning(
					"No suitable root class found to join all unconnected elements. Adding to target model root...");

			connectionsToInstantiate.add(
					connectionProvider.determineConnectionToJoinInstancesWithTargetModelRoot(unnconnectedInstances));
		} else {

			determineConnectionsToJoinMultipleUnconnectedElements(classesThatCanActAsCommonRoot);
		}

	}

	private List<EClass> collectClassesThatCanActAsCommonRoot() {

		List<EClassConnectionPathRequirement> requirements = unconnectedElementRegistry.keySet().stream()
				.map(e -> new EClassConnectionPathRequirement(e).withRequiredMaximumPathLength(maxPathLength)
						.withAllowedReferenceType(AllowedReferenceType.CONTAINMENT))
				.collect(Collectors.toList());

		Iterator<EClassConnectionPathRequirement> requirementIterator = requirements.iterator();

		List<EClass> rootClassesFulfillingAllrequirements = new ArrayList<>(eClassConnectionPathProvider
				.getConnections(requirementIterator.next()).stream().map(EClassConnectionPath::getStartingClass)
				.collect(Collectors.toCollection(LinkedHashSet::new)));

		while (requirementIterator.hasNext()) {
			EClassConnectionPathRequirement requirement = requirementIterator.next();
			rootClassesFulfillingAllrequirements.retainAll(eClassConnectionPathProvider.getConnections(requirement)
					.stream().map(EClassConnectionPath::getStartingClass)
					.collect(Collectors.toCollection(LinkedHashSet::new)));

		}
		return rootClassesFulfillingAllrequirements;
	}

	private void determineConnectionsToJoinMultipleUnconnectedElements(List<EClass> classesThatCanActAsCommonRoot) {

		EObjectWrapper newRootElement = instantiateNewRootElement(classesThatCanActAsCommonRoot);

		connectionsToInstantiate.add(connectionProvider
				.determineConnectionToJoinInstancesWithTargetModelRoot(Arrays.asList(newRootElement)));

		for (final Entry<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableEntry : unconnectedElementRegistry
				.entrySet()) {

			for (TargetSectionClass targetSectionClass : unlinkeableEntry.getValue().keySet()) {

				determineConnectionsToJoinUnconnectedElements(newRootElement, unlinkeableEntry, targetSectionClass);
			}
		}
	}

	private void determineConnectionsToJoinUnconnectedElements(EObjectWrapper newRootElement,
			Entry<EClass, Map<TargetSectionClass, List<EObjectWrapper>>> unlinkeableEntry,
			TargetSectionClass targetSectionClass) {

		/*
		 * It gets a bit tricky here. If there is more than one common container, we have to choose one. Then we need to
		 * find all possible connections for each of the elements involved. Now we need to choose a connection for each
		 * element. This might lead to us asking a lot of questions to the user.
		 */
		List<EObjectWrapper> instancesToJoin = unlinkeableEntry.getValue().get(targetSectionClass);

		connectionsToInstantiate.add(connectionProvider.determineConnectionToJoinInstancesWithSpecificElement(
				instancesToJoin, targetSectionClass, newRootElement));

	}

	private EObjectWrapper instantiateNewRootElement(List<EClass> classesThatCanActAsCommonRoot) {

		EClass classToUseForNewRootElement = getRootClassToUse(classesThatCanActAsCommonRoot);

		EObject newRootElement = classToUseForNewRootElement.getEPackage().getEFactoryInstance()
				.create(classToUseForNewRootElement);

		logger.info("Root element: '" + classToUseForNewRootElement.getName() + "' (generated)");
		return new EObjectWrapper(newRootElement, targetSectionRegistry);
	}

	private EClass getRootClassToUse(List<EClass> classesThatCanActAsCommonRoot) {

		EClass rootClass;

		if (classesThatCanActAsCommonRoot.size() == 1) {
			rootClass = classesThatCanActAsCommonRoot.iterator().next();

		} else {

			// Consult the specified resolving strategy to resolve the ambiguity.
			//
			try {
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_STARTED);
				List<EClass> resolved = ambiguityResolvingStrategy
						.joiningSelectRootElement(new ArrayList<>(classesThatCanActAsCommonRoot));
				if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy).joiningRootElementSelected(
							new ArrayList<>(classesThatCanActAsCommonRoot), resolved.get(0));
				}
				logger.fine(TargetSectionJoiner.RESOLVE_JOINING_AMBIGUITY_ENDED);
				rootClass = resolved.get(0);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a common root class: "
									+ e.getMessage());
					logger.severe("Using default path instead...");
					rootClass = classesThatCanActAsCommonRoot.iterator().next();
				}
			}

		}
		return rootClass;
	}

}
