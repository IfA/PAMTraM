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
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPath;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathInstantiator.EClassConnectionPathInstantiationException;
import de.tud.et.ifa.agtele.emf.connecting.EClassConnectionPathProvider;
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
import pamtram.structure.target.TargetSection;
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
public class TargetSectionLinker extends TargetSectionExpander {

	private static final String RESOLVE_LINKING_AMBIGUITY_STARTED = "[Ambiguity] Resolve linking ambiguity...";

	private static final String RESOLVE_LINKING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";

	/**
	 * target section registry used when instantiating classes
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * The {@link InstanceSelectorHandler} used to evaluate modeled {@link ReferenceTargetSelector
	 * ReferenceTargetSelectors}.
	 */
	private InstanceSelectorHandler instanceSelectorHandler;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the
	 * execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	private EClassConnectionPathProvider eClassConnectionPathProvider;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public TargetSectionLinker(TransformationAssetManager assetManager) {

		super(assetManager);

		targetSectionRegistry = assetManager.getTargetSectionRegistry();
		instanceSelectorHandler = assetManager.getInstanceSelectorHandler();
		ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		eClassConnectionPathProvider = assetManager.getEClassConnectionPathProvider();

	}

	@Override
	protected void doExpandTargetSectionsCreatedByInstantiableHintGroup(InstantiableMappingHintGroup hintGroup) {

		linkTargetSectionsCreatedByInstantiableHintGroup(hintGroup);
	}

	/**
	 * Link the {@link TargetSection TargetSections} created by the given <em>hintGroup</em> using the specified
	 * {@link MappingInstanceDescriptor mappingInstance}.
	 *
	 * @param hintGroup
	 *            The {@link InstantiableMappingHintGroup} of which the created {@link TargetSection TargetSections}
	 *            shall be linked.
	 */
	private void linkTargetSectionsCreatedByInstantiableHintGroup(InstantiableMappingHintGroup hintGroup) {

		// Only go on if any instances of this section were created
		//
		if (currentMappingInstanceDescriptor.getInstances(hintGroup, hintGroup.getTargetMMSectionGeneric()).isEmpty()) {
			return;
		}

		// The list of CrossReferences for that we need to find target elements
		//
		List<TargetSectionCrossReference> nonContainmentReferences = collectCrossReferencesRecursively(
				hintGroup.getTargetMMSectionGeneric());

		// Link all found CrossReferences
		//
		nonContainmentReferences.stream().forEach(ref -> linkTargetSectionReference(hintGroup, ref));

	}

	/**
	 * Recursively collect all {@link CrossReference TargetSectionCrossReferences} that are defined as part of the given
	 * {@link TargetSectionClass}.
	 * <p />
	 * Note: This also collects the CrossReferences that are part of an {@link ExternalReferenceParameter} if the given
	 * <em>targetSectionClass</em> is a {@link TargetSection#isLibraryEntry() library entry}.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that the CrossReferences shall be collected.
	 * @return The list of {@link CrossReference TargetSectionCrossReferences} defined as part of the given
	 *         <em>targetSectionClass</em> or any contained TargetSectionClass.
	 */
	private List<TargetSectionCrossReference> collectCrossReferencesRecursively(TargetSectionClass targetSectionClass) {

		// All CrossReferences defined as direct children of the given 'targetSectionClass'
		//
		List<TargetSectionCrossReference> crossReferences = targetSectionClass.getAllReferences().stream()
				.filter(ref -> ref instanceof TargetSectionCrossReference).map(ref -> (TargetSectionCrossReference) ref)
				.collect(Collectors.toList());

		// Now, iterate further downward in the containment hierarchy defined by the 'CompositeReferences' of the given
		// 'targetSectionClass' and collect the contained 'CrossReferences'
		//
		List<TargetSectionClass> containedClasses = targetSectionClass.getAllReferences().stream()
				.filter(ref -> ref instanceof TargetSectionCompositeReference)
				.flatMap(ref -> ((TargetSectionCompositeReference) ref).getValue().stream())
				.collect(Collectors.toList());

		for (TargetSectionClass containedClass : containedClasses) {
			crossReferences.addAll(collectCrossReferencesRecursively(containedClass));
		}

		return crossReferences;
	}

	/**
	 * Link the given {@link TargetSectionCrossReference}, i.e. find target elements for the various target model
	 * elements created by the given <em>hintGroup</em> of the given {@link MappingInstanceDescriptor}.
	 *
	 * @param hintGroup
	 *            The {@link InstantiableMappingHintGroup} of which the created {@link TargetSection TargetSections}
	 *            shall be linked.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 */
	private void linkTargetSectionReference(InstantiableMappingHintGroup hintGroup, TargetSectionCrossReference ref) {

		// We are searching for target elements for instances of this class
		//
		final TargetSectionClass targetSectionClass = !ref.isLibraryEntry() ? (TargetSectionClass) ref.eContainer()
				: ref.getContainingSection();

		List<EObjectWrapper> instancesToLink = currentMappingInstanceDescriptor.getInstances(hintGroup,
				targetSectionClass);

		if (instancesToLink.isEmpty()) {
			// Nothing to be done
			//
			return;
		}

		// Collect ReferenceTargetSelectors that affect the current reference
		//
		List<ReferenceTargetSelector> referenceTargetSelectorsToConcider = currentMappingInstanceDescriptor
				.getMappingHints(hintGroup, true).parallelStream()
				.filter(h -> h instanceof ReferenceTargetSelector
						&& ((ReferenceTargetSelector) h).getAffectedReference().equals(ref))
				.map(h -> (ReferenceTargetSelector) h).collect(Collectors.toList());

		if (!referenceTargetSelectorsToConcider.isEmpty()) {

			// Link the created instances using the specified 'ReferenceTargetSelector(s)'
			//
			for (ReferenceTargetSelector referenceTargetSelector : referenceTargetSelectorsToConcider) {

				linkWithReferenceTargetSelector(hintGroup, currentMappingInstanceDescriptor.getHintValues(),
						instancesToLink, ref, referenceTargetSelector);
			}

		} else {

			// Link the created instances using the 'value' of the reference or no hint at all
			//
			linkWithoutReferenceTargetSelector(hintGroup, instancesToLink, ref);
		}

	}

	/**
	 * Link the given {@link TargetSectionCrossReference} using the given {@link ReferenceTargetSelector}, i.e. find
	 * target elements for the various target model elements created by the given <em>hintGroup</em> of the given
	 * {@link MappingInstanceDescriptor}.
	 *
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param sourceInstances
	 *            The {@link EObjectWrapper instances} for which the target elements of the given
	 *            {@link TargetSectionCrossReference} shall be determined.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 * @param referenceTargetSelector
	 *            The {@link ReferenceTargetSelector} to be used to determine the target elements.
	 */
	private void linkWithReferenceTargetSelector(final InstantiableMappingHintGroup mappingGroup,
			final HintValueStorage hintValues, final List<EObjectWrapper> sourceInstances,
			TargetSectionCrossReference ref, ReferenceTargetSelector referenceTargetSelector) {

		checkCanceled();

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

		selectAndInstantiateConnections(sourceInstances, filteredTargetInstances, ref, mappingGroup);

	}

	/**
	 * Link the given {@link TargetSectionCrossReference}, i.e. find target elements for the various target model
	 * elements created by the given <em>hintGroup</em> of the given {@link MappingInstanceDescriptor}.
	 *
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param sourceInstances
	 *            The {@link EObjectWrapper instances} for which the target elements of the given
	 *            {@link TargetSectionCrossReference} shall be determined.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 */
	private void linkWithoutReferenceTargetSelector(final InstantiableMappingHintGroup mappingGroup,
			final List<EObjectWrapper> sourceInstances, TargetSectionCrossReference ref) {

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
				.allMatch(t -> t.getContainingSection().equals(mappingGroup.getTargetMMSectionGeneric()));

		if (useLocalLinking) {

			// The root instances of the instantiated target section (we use these to filter the 'local' target
			// instances for each source instance)
			//
			final List<EObjectWrapper> rootInstances = targetSectionRegistry
					.getFlattenedPamtramClassInstances(mappingGroup.getTargetMMSectionGeneric());

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
						mappingGroup);
			}

		} else {

			selectAndInstantiateConnections(sourceInstances, new ArrayList<>(potentialTargetInstances), ref,
					mappingGroup);
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
