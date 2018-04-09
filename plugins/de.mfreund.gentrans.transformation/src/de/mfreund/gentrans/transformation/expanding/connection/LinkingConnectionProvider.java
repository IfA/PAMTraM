/**
 *
 */
package de.mfreund.gentrans.transformation.expanding.connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.expanding.TargetSectionLinker;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathRequirement;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.target.TargetSectionAnyContentCrossReference;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class LinkingConnectionProvider extends AbstractConnectionProvider {

	public LinkingConnectionProvider(TransformationAssetManager assetManager,
			EClassConnectionPathProvider eClassConnectionPathProvider) {

		super(assetManager, new LinkedHashMap<>(), eClassConnectionPathProvider);

	}

	public List<LinkingConnection> determineConnectionsToLinkInstances(
			MappingInstanceDescriptor currentMappingInstanceDescriptor, List<EObjectWrapper> instances,
			TargetSectionCrossReference ref, InstantiableMappingHintGroup currentHintGroup) {

		this.currentMappingInstanceDescriptor = currentMappingInstanceDescriptor;
		this.currentHintGroup = currentHintGroup;
		currentInstancesToConnect = instances;

		List<ReferenceTargetSelector> referenceTargetSelectorsToConcider = getReferenceTargetSelectorsForReference(ref);

		if (!referenceTargetSelectorsToConcider.isEmpty()) {
			return determineConnectionsToInstantiateWithReferencesTargetSelectors(instances, ref,
					referenceTargetSelectorsToConcider);

		} else {
			return determineConnectionsToLinkWithoutReferenceTargetSelector(instances, ref);
		}

	}

	private List<LinkingConnection> determineConnectionsToInstantiateWithReferencesTargetSelectors(
			List<EObjectWrapper> instances, TargetSectionCrossReference ref,
			List<ReferenceTargetSelector> referenceTargetSelectorsToConcider) {

		List<LinkingConnection> connectionsToInstantiate = new ArrayList<>();
		for (ReferenceTargetSelector referenceTargetSelector : referenceTargetSelectorsToConcider) {

			connectionsToInstantiate.addAll(
					determineConnectionsToLinkWithReferenceTargetSelector(instances, ref, referenceTargetSelector));
		}
		return connectionsToInstantiate;
	}

	private List<ReferenceTargetSelector> getReferenceTargetSelectorsForReference(
			TargetSectionCrossReference reference) {

		List<ReferenceTargetSelector> allReferenceTargetSelectors = getReferenceTargetSelectorsInCurrentHintGroup();

		return allReferenceTargetSelectors.stream().filter(h -> h.getAffectedReference().equals(reference))
				.collect(Collectors.toList());
	}

	private List<ReferenceTargetSelector> getReferenceTargetSelectorsInCurrentHintGroup() {

		return currentMappingInstanceDescriptor.getMappingHints(currentHintGroup, true).stream()
				.filter(h -> h instanceof ReferenceTargetSelector).map(h -> (ReferenceTargetSelector) h)
				.collect(Collectors.toList());
	}

	/**
	 * Link the given {@link TargetSectionCrossReference} using the given {@link ReferenceTargetSelector}, i.e. find
	 * target elements for the various target model elements created by the given <em>hintGroup</em> of the given
	 * {@link MappingInstanceDescriptor}.
	 *
	 * @param sourceInstances
	 *            The {@link EObjectWrapper instances} for which the target elements of the given
	 *            {@link TargetSectionCrossReference} shall be determined.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 * @param referenceTargetSelector
	 *            The {@link ReferenceTargetSelector} to be used to determine the target elements.
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @return
	 */
	private List<LinkingConnection> determineConnectionsToLinkWithReferenceTargetSelector(
			final List<EObjectWrapper> sourceInstances, TargetSectionCrossReference ref,
			ReferenceTargetSelector referenceTargetSelector) {

		HintValueStorage hintValues = currentMappingInstanceDescriptor.getHintValues();

		// Nothing to connect
		//
		if (sourceInstances == null || sourceInstances.isEmpty()) {
			return Collections.emptyList();
		}

		// All potential target elements
		//
		List<EObjectWrapper> potentialTargetInstances = targetSectionRegistry
				.getFlattenedPamtramClassInstances(referenceTargetSelector.getTargetClass());

		if (potentialTargetInstances.isEmpty()) {
			logger.warning(() -> "The ReferenceTargetSelector '" + referenceTargetSelector.printInfo()
					+ " points to the target class '" + referenceTargetSelector.getTargetClass()
					+ "'. Sadly, no instances of this Class were created.");
			return Collections.emptyList();
		}

		// If possible, filter those that satisfy one of the calculated hint values
		//
		List<EObjectWrapper> filteredTargetInstances;
		if (referenceTargetSelector.getReferenceAttribute() == null) {

			filteredTargetInstances = potentialTargetInstances;

		} else {

			filteredTargetInstances = instanceSelectorHandler.filterTargetInstances(potentialTargetInstances,
					referenceTargetSelector, hintValues.getHintValues(referenceTargetSelector));
		}

		if (filteredTargetInstances.isEmpty()) {
			logger.warning(() -> "Evaluating the " + referenceTargetSelector.printInfo()
					+ " returned no suitable target instances.");

			return Collections.emptyList();
		}

		return getConnectionsToInstantiate(sourceInstances, filteredTargetInstances, ref, currentHintGroup);

	}

	/**
	 * Link the given {@link TargetSectionCrossReference}, i.e. find target elements for the various target model
	 * elements created by the given <em>hintGroup</em> of the given {@link MappingInstanceDescriptor}.
	 *
	 * @param sourceInstances
	 *            The {@link EObjectWrapper instances} for which the target elements of the given
	 *            {@link TargetSectionCrossReference} shall be determined.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @return
	 */
	private List<LinkingConnection> determineConnectionsToLinkWithoutReferenceTargetSelector(
			final List<EObjectWrapper> sourceInstances, TargetSectionCrossReference ref) {

		// The user did neither model a ReferenceTargetSelector nor any TargetSectionClasses as value for the given
		// CrossReference. Thus, we do not consider this Reference in the linking process...
		//
		if (sourceInstances == null || sourceInstances.isEmpty()) {
			return Collections.emptyList();
		}

		// Only consider instances that have been created based on the modeled target 'values' as potential target
		// instances
		//
		List<EObjectWrapper> potentialTargetInstances = ref.getValuesGeneric().stream()
				.flatMap(targetClass -> targetSectionRegistry.getFlattenedPamtramClassInstances(targetClass).stream())
				.collect(Collectors.toList());

		List<LinkingConnection> connectionsToInstantiate = new ArrayList<>();

		// We distinguish between 'local' and 'global' linking: 1. 'Local' linking takes place if all classes that have
		// been modeled as 'target' of the given 'ref' are located inside the same target section that the given
		// 'mappingGroup' points to. In this case, we consider only created model elements that are located inside the
		// same created model snippet as the current 'sourceInstance' as possible targets. 2. 'Global' linking instead
		// takes all created model elements into account as potential target instances.
		//
		boolean useLocalLinking = !ref.getValue().isEmpty() && ref.getValue().stream()
				.allMatch(t -> t.getContainingSection().equals(currentHintGroup.getTargetMMSectionGeneric()));

		if (useLocalLinking) {

			// The root instances of the instantiated target section (we use these to filter the 'local' target
			// instances for each source instance)
			//
			final List<EObjectWrapper> rootInstances = targetSectionRegistry
					.getFlattenedPamtramClassInstances(currentHintGroup.getTargetMMSectionGeneric());

			// Determine the 'local' potential target instances separately for each of the source instances and select
			// one or multiple to be used as targets
			//

			for (EObjectWrapper sourceInstance : sourceInstances) {

				Optional<EObjectWrapper> localRootInstance = rootInstances.stream()
						.filter(r -> EcoreUtil.isAncestor(r.getEObject(), sourceInstance.getEObject())).findAny();

				if (!localRootInstance.isPresent()) {
					logger.severe(() -> "Internal error while linking instances via the CrossReference '"
							+ ref.getName() + "'! No local root instance could be determined.");
					continue;
				}

				List<EObjectWrapper> localPotentialTargetInstances = potentialTargetInstances.stream()
						.filter(t -> EcoreUtil.isAncestor(localRootInstance.get().getEObject(), t.getEObject()))
						.collect(Collectors.toList());

				connectionsToInstantiate.addAll(getConnectionsToInstantiate(Arrays.asList(sourceInstance),
						localPotentialTargetInstances, ref, currentHintGroup));
			}

		} else {

			connectionsToInstantiate.addAll(getConnectionsToInstantiate(sourceInstances,
					new ArrayList<>(potentialTargetInstances), ref, currentHintGroup));
		}

		return connectionsToInstantiate;

	}

	/**
	 * Link the given list of <em>sourceInstances</em> with the given list of <em>targetInstances</em>.
	 * <p />
	 * The process of selecting the connections to instantiate is dependent on the number of source instances, target
	 * instances, and the {@link EReference#isMany() type} of the given {@link EReference}.
	 *
	 * @param sourceInstances
	 *            A list of {@link EObjectWrapper elements} to link to one or multiple of the given
	 *            <em>targetInstances</em>.
	 * @param targetInstances
	 *            The {@link EObjectWrapper elements} that act as target instances for the connections to instantiate.
	 * @param reference
	 *            The {@link TargetSectionCrossReference} via which to instantiate the connections.
	 * @param mappingGroup
	 *            The {@link MappingHintGroupType} that is used.
	 * @return
	 */
	private List<LinkingConnection> getConnectionsToInstantiate(final List<EObjectWrapper> sourceInstances,
			List<EObjectWrapper> targetInstances, TargetSectionCrossReference reference,
			final InstantiableMappingHintGroup mappingGroup) {

		if (targetInstances.isEmpty()) {
			// Nothing to connect
			//
			return Collections.emptyList();
		}

		Map<EObjectWrapper, List<EObjectWrapper>> targetInstancesBySourceInstance = selectConnections(sourceInstances,
				targetInstances, reference, mappingGroup);

		return getConnectionsToInstantiate(reference, mappingGroup, targetInstancesBySourceInstance);
	}

	private Map<EObjectWrapper, List<EObjectWrapper>> selectConnections(List<EObjectWrapper> sourceInstances,
			List<EObjectWrapper> targetInstances, final CrossReference<?, ?, ?, ?> reference,
			final InstantiableMappingHintGroup mappingGroup) {

		// This will be used in the end to instantiate the connections
		//
		Map<EObjectWrapper, List<EObjectWrapper>> targetInstancesBySourceInstance = new LinkedHashMap<>();

		// Continue depending on the number of source instances, target instances, and on the reference type
		//
		if (sourceInstances.size() == targetInstances.size()) {

			// Exactly one target instance will be used for each source instance
			//
			IntStream.range(0, sourceInstances.size()).forEach(i -> targetInstancesBySourceInstance
					.put(sourceInstances.get(i), Arrays.asList(targetInstances.get(i))));
		} else if (targetInstances.size() == 1) {

			// The single target instance will be used for each source instance
			//
			IntStream.range(0, sourceInstances.size()).forEach(i -> targetInstancesBySourceInstance
					.put(sourceInstances.get(i), Arrays.asList(targetInstances.iterator().next())));

		} else {

			if (reference instanceof TargetSectionAnyContentCrossReference
					|| reference instanceof TargetSectionCrossReference
							&& ((TargetSectionCrossReference) reference).getEReference().isMany()) {

				// Use all target instances as reference target for each source instance
				//
				IntStream.range(0, sourceInstances.size()).forEach(i -> targetInstancesBySourceInstance
						.put(sourceInstances.get(i), new ArrayList<>(targetInstances)));
			} else {

				/*
				 * Consult the specified resolving strategy to resolve the ambiguity (and select a single target
				 * instance that will be used for each source instance).
				 */
				try {
					logger.fine(TargetSectionLinker.RESOLVE_LINKING_AMBIGUITY_STARTED);
					List<EObjectWrapper> resolved = ambiguityResolvingStrategy
							.linkingSelectTargetInstance(targetInstances, (TargetSectionCrossReference) reference,
									mappingGroup instanceof MappingHintGroup ? (MappingHintGroup) mappingGroup
											: ((MappingHintGroupImporter) mappingGroup).getHintGroup(),
									null, sourceInstances);
					logger.fine(TargetSectionLinker.RESOLVE_LINKING_AMBIGUITY_FINISHED);
					IntStream.range(0, sourceInstances.size()).forEach(i -> targetInstancesBySourceInstance
							.put(sourceInstances.get(i), Arrays.asList(resolved.get(0))));
				} catch (AmbiguityResolvingException e) {
					if (e.getCause() instanceof UserAbortException) {
						throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
					} else {
						logger.severe(
								() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a target instance: "
										+ e.getMessage());
						logger.severe("Using default instance instead...");
						IntStream.range(0, sourceInstances.size()).forEach(i -> targetInstancesBySourceInstance
								.put(sourceInstances.get(i), Arrays.asList(targetInstances.get(0))));
					}
				}

			}
		}

		return targetInstancesBySourceInstance;
	}

	private List<LinkingConnection> getConnectionsToInstantiate(TargetSectionCrossReference reference,
			final InstantiableMappingHintGroup mappingGroup,
			Map<EObjectWrapper, List<EObjectWrapper>> targetInstancesBySourceInstance) {

		List<LinkingConnection> connectionsToInstantiate = new ArrayList<>();

		for (Entry<EObjectWrapper, List<EObjectWrapper>> entryToInstantiate : targetInstancesBySourceInstance
				.entrySet()) {

			if (!mappingGroup.getTargetMMSectionGeneric().isLibraryEntry()) {

				EClassConnectionPathRequirement requirement = new EClassConnectionPathRequirement(
						reference.getEReference().getEReferenceType())
								.withRequiredReferences(Arrays.asList(reference.getEReference()))
								.withRequiredStartingClass(reference.getEReference().getEContainingClass())
								.withAllowedReferenceType(AllowedReferenceType.NONCONTAINMENT)
								.withRequiredStartingElement(entryToInstantiate.getKey().getEObject())
								.withRequiredMaximumPathLength(Length.DIRECT_CONNECTION);

				List<EClassConnectionPath> connections = eClassConnectionPathProvider.getConnections(requirement);

				if (connections.isEmpty()) {
					logger.severe(
							"Internal Error: No connection found for reference " + reference.getEReference() + "!");
				} else if (connections.size() > 1) {
					logger.severe("Internal Error: Multiple connections found for reference "
							+ reference.getEReference() + "! Only the first one will be used...");
				}

				connectionsToInstantiate.add(new LinkingConnection(entryToInstantiate.getKey(),
						entryToInstantiate.getValue(), connections.get(0), targetSectionRegistry, logger));

			} else {

				LibraryEntry genericLibEntry = (LibraryEntry) AgteleEcoreUtil.getAncestorOfKind(
						mappingGroup.getTargetMMSectionGeneric(), LibraryPackage.Literals.LIBRARY_ENTRY);

				connectionsToInstantiate.add(new LinkingConnection(entryToInstantiate.getKey(), reference,
						genericLibEntry, entryToInstantiate.getValue(), targetSectionRegistry, logger));

			}
		}

		return connectionsToInstantiate;
	}
}
