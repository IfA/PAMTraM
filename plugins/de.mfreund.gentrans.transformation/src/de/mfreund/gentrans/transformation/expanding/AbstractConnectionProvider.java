/**
 *
 */
package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.core.TransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;

/**
 * An abstract based implementation of the {@link ConnectionProvider}. It provides utility functions to determine
 * connections that are common to all concrete implementations, whether they are used in the 'joining' or in the
 * 'linking' phase.
 *
 * @author mfreund
 */
// FIXME this should be used for both linking and joining. thus, the variable names should be unified (names like
// 'container' and 'root' should be replaced by names like 'startElement' and 'targetElement'
@SuppressWarnings("javadoc")
public abstract class AbstractConnectionProvider extends TransformationAsset implements ConnectionProvider {

	protected Map<InstantiableMappingHintGroup, EClassConnectionPath> standardConnectionsForHintGroups;

	protected EClassConnectionPathProvider eClassConnectionPathProvider;

	protected IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	protected Logger logger;

	protected TargetSectionRegistry targetSectionRegistry;

	protected InstanceSelectorHandler instanceSelectorHandler;

	public AbstractConnectionProvider(TransformationAssetManager assetManager,
			Map<InstantiableMappingHintGroup, EClassConnectionPath> standardPaths,
			EClassConnectionPathProvider eClassConnectionPathProvider) {

		super(assetManager);

		standardConnectionsForHintGroups = standardPaths;
		this.eClassConnectionPathProvider = eClassConnectionPathProvider;
		ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		logger = assetManager.getLogger();
		targetSectionRegistry = assetManager.getTargetSectionRegistry();
		instanceSelectorHandler = assetManager.getInstanceSelectorHandler();
	}

	protected List<EClassConnectionPathBasedConnection> selectConnections(List<EObjectWrapper> targetElements,
			Map<EClassConnectionPath, List<EObjectWrapper>> connectionChoices,
			InstantiableMappingHintGroup mappingGroup) {

		// The list of Connections that will get instantiated in the end
		//
		List<EClassConnectionPathBasedConnection> selectedConnections = new ArrayList<>();

		// The list of (distinct) container instances represented by the 'connectionChoices'
		//
		List<EObjectWrapper> containerInstances = new ArrayList<>(connectionChoices.values().stream()
				.flatMap(List::stream).collect(Collectors.toCollection(LinkedHashSet::new)));

		if (containerInstances.size() == targetElements.size()) {
			// This is the special case where there is exactly one container instance per root instance -> We connect
			// each root instance to its own container instance if there is a connection path that can be used for each
			// container instance
			//

			// The set of connection choices that provide exactly as many container elements as root elements
			//
			Map<EClassConnectionPath, List<EObjectWrapper>> limitedConnectionChoices = connectionChoices.entrySet()
					.stream().filter(e -> e.getValue().size() == containerInstances.size())
					.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

			if (limitedConnectionChoices.isEmpty()) {
				// Fall back to the 'default' behavior (use the same container instance for each root instance)
				//
				selectedConnections.add(getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(
						targetElements, connectionChoices, mappingGroup));
			} else {
				// Create a distinct connection for each pair of container/root instances
				//
				Map<EObjectWrapper, EObjectWrapper> containerInstanceByRootInstance = IntStream
						.range(0, targetElements.size()).boxed()
						.collect(Collectors.toMap(targetElements::get, containerInstances::get));

				selectedConnections.addAll(containerInstanceByRootInstance.entrySet().stream()
						.map(e -> getConnectionToInstantiateBasedOnSingleStartingElementPossiblity(
								Arrays.asList(e.getKey()), new ArrayList<>(limitedConnectionChoices.keySet()),
								e.getValue(), mappingGroup))
						.collect(Collectors.toList()));
			}

		} else {
			// This is the default case where each root instance is connected to the same container instance
			//
			selectedConnections.add(getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(
					targetElements, connectionChoices, mappingGroup));
		}
		return selectedConnections;
	}

	private EClassConnectionPathBasedConnection getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(
			final List<EObjectWrapper> targetElements,
			Map<EClassConnectionPath, List<EObjectWrapper>> connectionChoices,
			InstantiableMappingHintGroup mappingGroup) {

		// If there is already a 'standardPath' for the given 'mappingGroup', we reuse this standard path
		//
		EClassConnectionPath standardPath = standardConnectionsForHintGroups.getOrDefault(mappingGroup, null);
		if (standardPath != null && connectionChoices.containsKey(standardPath) && connectionChoices.size() > 1) {

			return getConnectionToInstantiate(targetElements, standardPath, connectionChoices.get(standardPath),
					mappingGroup);
		}

		List<EClassConnectionPath> pathsWithoutInstances = connectionChoices.keySet().stream()
				.filter(p -> connectionChoices.get(p).isEmpty()).collect(Collectors.toList());
		if (pathsWithoutInstances.size() < connectionChoices.size()) {
			pathsWithoutInstances.stream().forEach(connectionChoices::remove);
		}

		if (connectionChoices.keySet().size() == 1
				&& connectionChoices.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size() == 1) {

			// There is only one possible connection path and container instance
			//
			EClassConnectionPath connectionPath = connectionChoices.keySet().iterator().next();
			return this.getConnectionFor(connectionChoices.get(connectionPath).iterator().next(), targetElements,
					connectionPath, mappingGroup);

		} else if (connectionChoices.keySet().size() == 1) {

			// If there is only one possible connection path, we only need to let the user choose the
			// container instance
			//
			EClassConnectionPath connectionPath = connectionChoices.keySet().iterator().next();
			return getConnectionToInstantiate(targetElements, connectionPath, connectionChoices.get(connectionPath),
					mappingGroup);

		} else {

			EClassConnectionPath selectedConnectionPath;
			EObjectWrapper selectedContainerInstance;

			// There are multiple possible connection paths and/or container instances
			//
			try {
				logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);

				Map<EClassConnectionPath, List<EObjectWrapper>> resolved;
				if (connectionChoices.values().stream().flatMap(List::stream).collect(Collectors.toSet()).size() == 1) {
					// If there is only one possible container instance, we only need to let the user choose the
					// connection path
					//
					List<EClassConnectionPath> resolvedPaths = ambiguityResolvingStrategy.joiningSelectConnectionPath(
							new ArrayList<>(connectionChoices.keySet()), mappingGroup.getTargetMMSectionGeneric());
					resolved = resolvedPaths.stream()
							.collect(Collectors.toMap(Function.identity(), connectionChoices::get));
					selectedConnectionPath = resolvedPaths.get(0);
				} else {
					// Otherwise, the user needs to select the connection path as well as the container instance
					//
					resolved = ambiguityResolvingStrategy.joiningSelectConnectionPathAndContainerInstance(
							connectionChoices, mappingGroup.getTargetMMSectionGeneric(), targetElements,
							mappingGroup instanceof MappingHintGroupImporter
									? ((MappingHintGroupImporter) mappingGroup).getHintGroup()
									: (MappingHintGroupType) mappingGroup);
					selectedConnectionPath = resolved.entrySet().iterator().next().getKey();
				}

				selectedContainerInstance = resolved.entrySet().iterator().next().getValue().get(0);
				if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy).joiningConnectionPathSelected(
							new ArrayList<>(connectionChoices.keySet()), selectedConnectionPath);
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy).joiningContainerInstanceSelected(
							new ArrayList<>(connectionChoices.get(selectedConnectionPath)), selectedContainerInstance);
				}
				logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a common root element: "
									+ e.getMessage());
					logger.severe("Using default path and instance instead...");
					selectedConnectionPath = connectionChoices.keySet().iterator().next();
					selectedContainerInstance = connectionChoices.get(selectedConnectionPath).get(0);
				}
			}

			return this.getConnectionFor(selectedContainerInstance, targetElements, selectedConnectionPath,
					mappingGroup);
		}

	}

	private EClassConnectionPathBasedConnection getConnectionToInstantiateBasedOnSingleStartingElementPossiblity(
			List<EObjectWrapper> targetElements, List<EClassConnectionPath> connectionPaths,
			EObjectWrapper startingElement, InstantiableMappingHintGroup mappingGroup) {

		// If there is already a 'standardPath' for the given 'mappingGroup', we reuse this standard path
		//
		EClassConnectionPath standardPath = standardConnectionsForHintGroups.getOrDefault(mappingGroup, null);
		if (standardPath != null && connectionPaths.contains(standardPath)) {

			return this.getConnectionFor(startingElement, targetElements, standardPath, mappingGroup);
		}

		Map<EClassConnectionPath, List<EObjectWrapper>> connectionChoices = connectionPaths.stream()
				.collect(Collectors.toMap(Function.identity(), c -> Arrays.asList(startingElement)));

		return getConnectionToInstantiateBasedOnMultipleStartingElementPossibilities(targetElements, connectionChoices,
				mappingGroup);
	}

	private EClassConnectionPathBasedConnection getConnectionFor(EObjectWrapper startingElement, final List<EObjectWrapper> targetElements,
			EClassConnectionPath connectionPath, InstantiableMappingHintGroup mappingGroup) {

		EClassConnectionPathBasedConnection connectionToInstantiate = new EClassConnectionPathBasedConnection(startingElement, connectionPath, targetElements);

		if (!standardConnectionsForHintGroups.containsKey(mappingGroup)
				|| standardConnectionsForHintGroups.get(mappingGroup) != connectionPath) {

			standardConnectionsForHintGroups.put(mappingGroup, connectionPath);

			logger.info(() -> mappingGroup.getTargetMMSectionGeneric().getName() + " ("
					+ ((Mapping) mappingGroup.eContainer()).getName() + "): "
					+ connectionToInstantiate.getConnectionPath().toString());
		}

		return connectionToInstantiate;
	}

	private EClassConnectionPathBasedConnection getConnectionToInstantiate(final List<EObjectWrapper> rootInstances,
			EClassConnectionPath connectionPath, List<EObjectWrapper> containerInstances,
			InstantiableMappingHintGroup mappingGroup) {

		EObjectWrapper selectedContainerInstance;

		if (containerInstances.size() == 1) {

			selectedContainerInstance = containerInstances.get(0);

		} else {

			// There are multiple possible container instances
			//
			try {
				logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_STARTED);

				selectedContainerInstance = ambiguityResolvingStrategy
						.joiningSelectContainerInstance(containerInstances, rootInstances,
								mappingGroup instanceof MappingHintGroupImporter
										? ((MappingHintGroupImporter) mappingGroup).getHintGroup()
										: (MappingHintGroupType) mappingGroup,
								null, null)
						.iterator().next();
				if (ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
					((IAmbiguityResolvedAdapter) ambiguityResolvingStrategy)
							.joiningContainerInstanceSelected(containerInstances, selectedContainerInstance);
				}
				logger.fine(TargetSectionConnector.RESOLVE_JOINING_AMBIGUITY_ENDED);

			} catch (AmbiguityResolvingException e) {
				if (e.getCause() instanceof UserAbortException) {
					throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
				} else {
					logger.severe(
							() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a container instance: "
									+ e.getMessage());
					logger.severe("Using default path and instance instead...");
					selectedContainerInstance = containerInstances.get(0);
				}
			}
		}

		return this.getConnectionFor(selectedContainerInstance, rootInstances, connectionPath, mappingGroup);
	}

}