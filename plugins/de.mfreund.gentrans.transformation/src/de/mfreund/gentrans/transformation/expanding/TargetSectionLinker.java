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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator.EClassConnectionPathInstantiationException;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathRequirement;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.generic.CrossReference;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.target.TargetSectionAnyContentCrossReference;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * Class for linking target model sections using the hints supplied by {@link MappingInstanceDescriptor
 * MappingInstanceStorages}.
 *
 * @author mfreund
 */
public class TargetSectionLinker extends TargetSectionConnector {

	private static final String RESOLVE_LINKING_AMBIGUITY_STARTED = "[Ambiguity] Resolve linking ambiguity...";

	private static final String RESOLVE_LINKING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";

	/**
	 * The {@link InstanceSelectorHandler} used to evaluate modeled {@link ReferenceTargetSelector
	 * ReferenceTargetSelectors}.
	 */
	private InstanceSelectorHandler instanceSelectorHandler;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public TargetSectionLinker(TransformationAssetManager assetManager) {

		super(assetManager);

		instanceSelectorHandler = assetManager.getInstanceSelectorHandler();
		maxPathLength = Length.DIRECT_CONNECTION;

	}

	@Override
	protected void doConnectCurrentHintGroup() {

		linkAllCrossReferencesInCurrentHintGroup();
	}

	private void linkAllCrossReferencesInCurrentHintGroup() {

		List<TargetSectionCrossReference> crossReferences = collectContainedCrossReferencesRecursively(
				currentHintGroup.getTargetMMSectionGeneric());

		crossReferences.stream().forEach(this::linkCrossReference);

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

	private void linkCrossReference(TargetSectionCrossReference ref) {

		// We are searching for target elements for instances of this class
		//
		final TargetSectionClass targetSectionClass = !ref.isLibraryEntry() ? ref.getOwningClass()
				: ref.getContainingSection();

		List<EObjectWrapper> instancesToLink = currentMappingInstanceDescriptor.getInstances(currentHintGroup,
				targetSectionClass);

		if (instancesToLink.isEmpty()) {
			return;
		}

		List<ReferenceTargetSelector> referenceTargetSelectorsToConcider = getReferenceTargetSelectorsForReference(ref);

		if (!referenceTargetSelectorsToConcider.isEmpty()) {

			// Link the created instances using the specified 'ReferenceTargetSelector(s)'
			//
			for (ReferenceTargetSelector referenceTargetSelector : referenceTargetSelectorsToConcider) {

				linkWithReferenceTargetSelector(instancesToLink, ref, referenceTargetSelector);
			}

		} else {

			// Link the created instances using the 'value' of the reference or no hint at all
			//
			linkWithoutReferenceTargetSelector(instancesToLink, ref);
		}

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
	 */
	private void linkWithReferenceTargetSelector(final List<EObjectWrapper> sourceInstances,
			TargetSectionCrossReference ref, ReferenceTargetSelector referenceTargetSelector) {

		HintValueStorage hintValues = currentMappingInstanceDescriptor.getHintValues();

		// Nothing to connect
		//
		if (sourceInstances == null || sourceInstances.isEmpty()) {
			return;
		}

		// All potential target elements
		//
		List<EObjectWrapper> potentialTargetInstances = targetSectionRegistry
				.getFlattenedPamtramClassInstances(referenceTargetSelector.getTargetClass());

		if (potentialTargetInstances.isEmpty()) {
			logger.warning(() -> "The ReferenceTargetSelector '" + referenceTargetSelector.printInfo()
					+ " points to the target class '" + referenceTargetSelector.getTargetClass()
					+ "'. Sadly, no instances of this Class were created.");
			return;
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

			return;
		}

		selectAndInstantiateConnections(sourceInstances, filteredTargetInstances, ref, currentHintGroup);

	}

	/**
	 * Link the given {@link TargetSectionCrossReference}, i.e. find target elements for the various target model
	 * elements created by the given <em>hintGroup</em> of the given {@link MappingInstanceDescriptor}.
	 * @param sourceInstances
	 *            The {@link EObjectWrapper instances} for which the target elements of the given
	 *            {@link TargetSectionCrossReference} shall be determined.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 */
	private void linkWithoutReferenceTargetSelector(final List<EObjectWrapper> sourceInstances,
			TargetSectionCrossReference ref) {

		checkCanceled();

		// Nothing to connect
		//
		if (sourceInstances == null || sourceInstances.isEmpty()) {
			return;
		}

		// All potential target elements
		//
		Set<EObjectWrapper> potentialTargetInstances = new LinkedHashSet<>();

		if (ref.getValue().isEmpty()) {

			// The user did neither model a ReferenceTargetSelector nor any TargetSectionClasses as value for the given
			// CrossReference. Thus, we do not consider this Reference in the linking process...
			//

			// // The user did not model any target classes for the given 'ref'. Thus, we consider all possible classes
			// //
			// List<EClass> possibleTargetClasses = new ArrayList<>();
			// possibleTargetClasses.add(ref.getEReference().getEReferenceType());
			// possibleTargetClasses
			// .addAll(this.targetSectionRegistry.getChildClasses(ref.getEReference().getEReferenceType()));
			//
			// potentialTargetInstances.addAll(possibleTargetClasses.stream()
			// .flatMap(targetClass -> this.targetSectionRegistry.getTargetClassInstances(targetClass).stream())
			// .collect(Collectors.toList()));

		} else {

			// The user modeled one or multiple allowed target classes. Thus, we only consider instances that have been
			// created based on theses.
			//
			potentialTargetInstances.addAll(ref.getValuesGeneric().stream().flatMap(
					targetClass -> targetSectionRegistry.getFlattenedPamtramClassInstances(targetClass).stream())
					.collect(Collectors.toList()));
		}

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

				selectAndInstantiateConnections(Arrays.asList(sourceInstance), localPotentialTargetInstances, ref,
						currentHintGroup);
			}

		} else {

			selectAndInstantiateConnections(sourceInstances, new ArrayList<>(potentialTargetInstances), ref,
					currentHintGroup);
		}

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
	 */
	private void selectAndInstantiateConnections(final List<EObjectWrapper> sourceInstances,
			List<EObjectWrapper> targetInstances, TargetSectionCrossReference reference,
			final InstantiableMappingHintGroup mappingGroup) {

		if (targetInstances.isEmpty()) {
			// Nothing to connect
			//
			return;
		}

		Map<EObjectWrapper, List<EObjectWrapper>> targetInstancesBySourceInstance = selectConnections(sourceInstances,
				targetInstances, reference, mappingGroup);

		instantiateConnections(reference, mappingGroup, targetInstancesBySourceInstance);
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

	private void instantiateConnections(TargetSectionCrossReference reference,
			final InstantiableMappingHintGroup mappingGroup,
			Map<EObjectWrapper, List<EObjectWrapper>> targetInstancesBySourceInstance) {

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

				if (connections.size() == 1) {

					EClassConnectionPathInstantiator instantiator = connections.get(0)
							.createInstantiator(entryToInstantiate.getKey().getEObject(), entryToInstantiate.getValue()
									.stream().map(EObjectWrapper::getEObject).collect(Collectors.toList()));
					try {
						instantiator.instantiate();
					} catch (EClassConnectionPathInstantiationException e) {
						logger.severe(e.getMessage());
					}

				} else {
					logger.severe(
							"Internal Error: Multiple connections found for reference " + reference.getEReference());
				}

			} else {

				/*
				 * for library entries, we cannot simply add the value as the reference we are handling is not part of
				 * the targetSectionClass; instead we want to specify the value as 'target' for the affected
				 * ExternalReferenceParameter
				 */
				LibraryEntry specificLibEntry = targetSectionRegistry.getLibraryEntryRegistry()
						.get(entryToInstantiate.getKey()).getLibraryEntry();
				LibraryEntry genericLibEntry = (LibraryEntry) AgteleEcoreUtil.getAncestorOfKind(
						mappingGroup.getTargetMMSectionGeneric(), LibraryPackage.Literals.LIBRARY_ENTRY);

				if (entryToInstantiate.getValue().size() > 1) {
					logger.severe(
							() -> "'ExternalReferenceParameters' of LibraryEntries currently only support setting a single target instance! Using the first of the selected instances for LibraryEntry '"
									+ genericLibEntry.toString() + "'!");
				}

				ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry.getParameters()
						.get(genericLibEntry.getParameters().indexOf(reference.eContainer()));
				@SuppressWarnings("unchecked")
				AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
						.getOriginalParameter();
				originalParam.setTarget(entryToInstantiate.getValue().iterator().next().getEObject());
			}
		}
	}

}
