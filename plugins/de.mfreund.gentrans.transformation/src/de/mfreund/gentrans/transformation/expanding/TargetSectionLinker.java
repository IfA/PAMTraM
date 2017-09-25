package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintType;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.library.ExternalReferenceParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * Class for linking target model sections using the hints supplied by {@link MappingInstanceStorage
 * MappingInstanceStorages}.
 *
 * @author mfreund
 */
public class TargetSectionLinker extends CancelableElement {

	private static final String RESOLVE_LINKING_AMBIGUITY_STARTED = "[Ambiguity] Resolve linking ambiguity...";

	private static final String RESOLVE_LINKING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";

	/**
	 * target section registry used when instantiating classes
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * The {@link Logger} that is used to print messages.
	 */
	private final Logger logger;

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

	/**
	 * This relates temporarily created elements for LibraryEntries (represented by an {@link EObjectWrapper}) to their
	 * {@link LibraryEntryInstantiator}.
	 */
	private Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap;

	/**
	 * This creates an instance.
	 *
	 * @param targetSectionRegistry
	 *            target section registry used when instantiating classes
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used to evaluate modeled {@link ReferenceTargetSelector
	 *            ReferenceTargetSelectors}.
	 * @param libEntryInstantiatorMap
	 *            The temporarily created elements for LibraryEntries (represented by an {@link EObjectWrapper}) and
	 *            their corresponding {@link LibraryEntryInstantiator}.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} that shall be used to resolve occurring ambiguities.
	 */
	public TargetSectionLinker(final TargetSectionRegistry targetSectionRegistry,
			InstanceSelectorHandler instanceSelectorHandler,
			final Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap, final Logger logger,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		this.targetSectionRegistry = targetSectionRegistry;
		this.instanceSelectorHandler = instanceSelectorHandler;
		this.logger = logger;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.canceled = false;
		this.libEntryInstantiatorMap = libEntryInstantiatorMap;

	}

	/**
	 * Link the {@link TargetSection TargetSections} represented by the <em>hintGroups</em> of the given
	 * {@link MappingInstanceStorage}, i.e. find target elements for the various {@link TargetSectionCrossReference
	 * TargetSectionCrossReferences} of the TargetSections.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to link.
	 * @return '<em><b>true</b></em>' if all instances of the linking step completed successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	public boolean linkTargetSection(final MappingInstanceStorage mappingInstance) {

		// Link 'local' hint groups
		//
		if (!mappingInstance.getMappingHintGroups().stream()
				.allMatch(g -> this.linkTargetSection(mappingInstance, g))) {

			return false;
		}

		// Link 'imported' hint groups
		//
		if (!mappingInstance.getMappingHintGroupImporters().stream()
				.allMatch(g -> this.linkTargetSection(mappingInstance, g))) {

			return false;
		}

		return true;
	}

	/**
	 * Link the {@link TargetSection TargetSections} created by the given <em>hintGroupImporter</em> of the given
	 * {@link MappingInstanceStorage}, i.e. find target elements for the various {@link TargetSectionCrossReference
	 * TargetSectionCrossReferences} of the associated TargetSection.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to link.
	 * @param hintGroupImporter
	 *            The {@link MappingHintGroupImporter} that lead to the instantiation of the given
	 *            <em>mappingInstance</em>.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	private boolean linkTargetSection(final MappingInstanceStorage mappingInstance,
			final MappingHintGroupImporter hintGroupImporter) {

		this.checkCanceled();

		final ExportedMappingHintGroup expGrp = hintGroupImporter.getHintGroup();
		if (expGrp.getTargetSection() != null) {
			if (mappingInstance.getInstancesBySection(hintGroupImporter) != null) {
				final List<MappingHint> hints = new LinkedList<>();
				hints.addAll(mappingInstance.getMappingHints(expGrp));
				for (final MappingHintType h : mappingInstance.getMappingHints(hintGroupImporter)) {

					if (h instanceof MappingHint) {
						hints.add((MappingHint) h);
					} // TODO else if ...??-> should have already been
						// done during 1st pass
				}

				this.linkTargetSection(expGrp.getTargetSection(), hintGroupImporter, hints,
						mappingInstance.getHintValues(), mappingInstance.getInstancesBySection(hintGroupImporter));

			}
		}

		return true;
	}

	/**
	 * Link the {@link TargetSection TargetSections} created by the given <em>hintGroup</em> of the given
	 * {@link MappingInstanceStorage}, i.e. find target elements for the various {@link TargetSectionCrossReference
	 * TargetSectionCrossReferences} of the associated TargetSection.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to link.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that lead to the instantiation of the given <em>mappingInstance</em>.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully;
	 *         '<em><b>false</b></em>' otherwise
	 */
	private boolean linkTargetSection(final MappingInstanceStorage mappingInstance,
			final MappingHintGroupType hintGroup) {

		this.checkCanceled();

		if (hintGroup.getTargetSection() != null && hintGroup instanceof MappingHintGroup) {

			if (mappingInstance.getInstancesBySection((MappingHintGroup) hintGroup) != null) {

				this.linkTargetSection(hintGroup.getTargetSection(), (MappingHintGroup) hintGroup,
						mappingInstance.getMappingHints(hintGroup), mappingInstance.getHintValues(),
						mappingInstance.getInstancesBySection((MappingHintGroup) hintGroup));

			}
		}

		return true;
	}

	/**
	 * Link the {@link TargetSection TargetSections} created by the given <em>hintGroup</em> using the specified
	 * {@link HintValueStorage hint values}.
	 *
	 * @param targetSection
	 *            The {@link TargetSection} to link.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param instancesBySection
	 *            The registry for {@link EObjectWrapper instances} created during the first pass of the instantiation.
	 */
	private void linkTargetSection(final TargetSection targetSection, final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints, final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection) {

		// Only go on if any instances of this section were created
		//
		if (instancesBySection.get(targetSection) == null) {
			return;
		}

		// The list of CrossReferences for that we need to find target elements
		//
		List<TargetSectionCrossReference> nonContainmentReferences = this
				.collectCrossReferencesRecursively(targetSection);

		// Link all found CrossReferences
		//
		nonContainmentReferences.stream().forEach(ref -> this.linkTargetSectionReference(mappingGroup, mappingHints,
				hintValues, instancesBySection, ref));

	}

	/**
	 * Recursively collect all {@link TargetSectionCrossReference TargetSectionCrossReferences} that are defined as part
	 * of the given {@link TargetSectionClass}.
	 * <p />
	 * Note: This also collects the CrossReferences that are part of an {@link ExternalReferenceParameter} if the given
	 * <em>targetSectionClass</em> is a {@link TargetSection#isLibraryEntry() library entry}.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that the CrossReferences shall be collected.
	 * @return The list of {@link TargetSectionCrossReference TargetSectionCrossReferences} defined as part of the given
	 *         <em>targetSectionClass</em> or any contained TargetSectionClass.
	 */
	private List<TargetSectionCrossReference> collectCrossReferencesRecursively(TargetSectionClass targetSectionClass) {

		if (targetSectionClass.isLibraryEntry()) {
			// The target section class is part of a library entry, thus
			// there must not be any references as direct children of it.
			// However, we want to perform the linking for the references
			// affected by ExternalReferenceParameters.
			//
			LibraryEntry libEntry = (LibraryEntry) AgteleEcoreUtil.getAncestorOfKind(targetSectionClass,
					GenLibraryPackage.Literals.LIBRARY_ENTRY);

			if (libEntry != null) {
				return libEntry.getParameters().stream().filter(p -> p instanceof ExternalReferenceParameter)
						.map(p -> ((ExternalReferenceParameter) p).getReference()).collect(Collectors.toList());
			}
		}

		// All CrossReferences defined as direct children of the given 'targetSectionClass'
		//
		List<TargetSectionCrossReference> crossReferences = targetSectionClass.getReferences().stream()
				.filter(ref -> ref instanceof TargetSectionCrossReference).map(ref -> (TargetSectionCrossReference) ref)
				.collect(Collectors.toList());

		// Now, iterate further downward in the containment hierarchy defined by the 'CompositeReferences' of the given
		// 'targetSectionClass' and collect the contained 'CrossReferences'
		//
		List<TargetSectionClass> containedClasses = targetSectionClass.getReferences().stream()
				.filter(ref -> ref instanceof TargetSectionCompositeReference)
				.flatMap(ref -> ((TargetSectionCompositeReference) ref).getValue().stream())
				.collect(Collectors.toList());

		for (TargetSectionClass containedClass : containedClasses) {
			crossReferences.addAll(this.collectCrossReferencesRecursively(containedClass));
		}

		return crossReferences;
	}

	/**
	 * Link the given {@link TargetSectionCrossReference}, i.e. find target elements for the various target model
	 * elements created by the given <em>hintGroup</em> of the given {@link MappingInstanceStorage}.
	 *
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param instancesBySection
	 *            The registry for {@link EObjectWrapper instances} created during the first pass of the instantiation.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 */
	private void linkTargetSectionReference(final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints, final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection,
			final TargetSectionCrossReference ref) {

		// We are searching for target elements for instances of this class
		//
		final TargetSectionClass targetSectionClass = (TargetSectionClass) ref.eContainer();

		if (!instancesBySection.containsKey(targetSectionClass)
				|| instancesBySection.get(targetSectionClass).isEmpty()) {

			// Nothing to be done
			//
			return;
		}

		final LinkedList<TargetSectionClass> refValueClone = new LinkedList<>();
		refValueClone.addAll(ref.getValue());

		// Collect ReferenceTargetSelectors that affect the current reference
		//
		List<ReferenceTargetSelector> referenceTargetSelectorsToConcider = mappingHints.parallelStream()
				.filter(h -> h instanceof ReferenceTargetSelector
						&& ((ReferenceTargetSelector) h).getAffectedReference().equals(ref))
				.map(h -> (ReferenceTargetSelector) h).collect(Collectors.toList());

		if (!referenceTargetSelectorsToConcider.isEmpty()) {

			// Link the created instances using the specified 'ReferenceTargetSelector(s)'
			//
			for (ReferenceTargetSelector referenceTargetSelector : referenceTargetSelectorsToConcider) {

				this.linkWithReferenceTargetSelector(mappingGroup, hintValues,
						instancesBySection.get(targetSectionClass), ref, referenceTargetSelector);
			}

		} else {

			// Link the created instances using the 'value' of the reference or no hint at all
			//
			this.linkWithoutReferenceTargetSelector(mappingGroup, instancesBySection.get(targetSectionClass), ref,
					targetSectionClass, refValueClone);
		}

	}

	/**
	 * Link the given {@link TargetSectionCrossReference} using the given {@link ReferenceTargetSelector}, i.e. find
	 * target elements for the various target model elements created by the given <em>hintGroup</em> of the given
	 * {@link MappingInstanceStorage}.
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
			final TargetSectionCrossReference ref, ReferenceTargetSelector referenceTargetSelector) {

		this.checkCanceled();

		// Nothing to connect
		//
		if (sourceInstances == null || sourceInstances.isEmpty()) {
			return;
		}

		// All potential target elements
		//
		List<EObjectWrapper> potentialTargetInstances = this.targetSectionRegistry
				.getFlattenedPamtramClassInstances(referenceTargetSelector.getTargetClass());

		if (potentialTargetInstances.isEmpty()) {
			this.logger.warning(() -> "The ReferenceTargetSelector '" + referenceTargetSelector.printInfo()
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

			filteredTargetInstances = this.instanceSelectorHandler.filterTargetInstances(potentialTargetInstances,
					hintValues.getHintValues(referenceTargetSelector), referenceTargetSelector);
		}

		if (potentialTargetInstances.isEmpty()) {
			this.logger.warning(() -> "Evaluating the ReferenceTargetSelector '" + referenceTargetSelector.printInfo()
					+ " returned no suitable target instances.");

			return;
		}

		this.selectAndInstantiateConnections(sourceInstances, filteredTargetInstances, ref, mappingGroup);

	}

	/**
	 * Link the given {@link TargetSectionCrossReference}, i.e. find target elements for the various target model
	 * elements created by the given <em>hintGroup</em> of the given {@link MappingInstanceStorage}.
	 *
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param instancesBySection
	 *            The registry for {@link EObjectWrapper instances} created during the first pass of the instantiation.
	 * @param ref
	 *            The {@link TargetSectionCrossReference} for that the target elements shall be determined.
	 */
	private void linkWithoutReferenceTargetSelector(final InstantiableMappingHintGroup mappingGroup,
			final List<EObjectWrapper> sourceInstances, final TargetSectionCrossReference ref,
			final TargetSectionClass targetSectionClass, final LinkedList<TargetSectionClass> refValueClone) {

		/*
		 * In case no suitable hint could be found we will try the following:
		 *
		 * 1.only non-cont ref targets to other subsections of this targetMMSection are considered, we can resolve the
		 * reference if only one Instance of the ref Target was created in the same mapping instance
		 *
		 * if that isn't the case:
		 *
		 * 2. consider all available instances of the ref target
		 */
		if (true) { // last chance

			final LinkedHashSet<TargetSectionClass> foundLocalNonContRefTargets = new LinkedHashSet<>();
			final LinkedList<TargetSectionClass> refValue = new LinkedList<>();
			refValue.addAll(ref.getValue());

			// first check root targetMMSection itself
			if (refValue.contains(mappingGroup.getTargetMMSectionGeneric())) {
				foundLocalNonContRefTargets.add(mappingGroup.getTargetMMSectionGeneric());
				refValue.remove(mappingGroup.getTargetMMSectionGeneric());
			}

			// then check all its children
			final TreeIterator<EObject> it = mappingGroup.getTargetMMSectionGeneric().eAllContents();
			while (it.hasNext() && !refValue.isEmpty()) {
				final EObject next = it.next();
				if (refValue.contains(next)) {// at least one of the
					/*
					 * values the pamtram-reference points to, is part of the same MappingHintGroup's targetMMSection
					 */
					foundLocalNonContRefTargets.add((TargetSectionClass) next);
					refValue.remove(next);
				}

			}
			/*
			 * only non-cont ref targets to other subsections of this targetMMSection are considered
			 */
			if (foundLocalNonContRefTargets.size() > 0) {

				// get root instances of groups targetMMSection
				final List<EObjectWrapper> rootInstances = this.targetSectionRegistry
						.getFlattenedPamtramClassInstances(mappingGroup.getTargetMMSectionGeneric());

				// get target instances for the reference
				final LinkedList<EObjectWrapper> targetInstances = new LinkedList<>();
				for (final TargetSectionClass section : foundLocalNonContRefTargets) {
					targetInstances.addAll(this.targetSectionRegistry.getFlattenedPamtramClassInstances(section));
				}

				// now sort instances by root
				final LinkedHashMap<EObjectWrapper, EObjectWrapper> rootBySourceInstance = new LinkedHashMap<>();
				final LinkedHashMap<EObjectWrapper, LinkedList<EObjectWrapper>> targetInstancesByRoot = new LinkedHashMap<>();

				for (final EObjectWrapper root : rootInstances) {
					targetInstancesByRoot.put(root, new LinkedList<EObjectWrapper>());

					// check if root node itself is a target
					for (final EObjectWrapper t : targetInstances) {
						if (t.getEObject().equals(root.getEObject())) {
							targetInstancesByRoot.get(root).add(root);
							targetInstances.remove(t);
							break;
						}
					}

					// check root node's contents
					final TreeIterator<EObject> it1 = root.getEObject().eAllContents();
					while (it1.hasNext() && !(sourceInstances.size() == 0 && targetInstances.size() == 0)) {
						final EObject next = it1.next();

						boolean found = false;

						for (final EObjectWrapper h : sourceInstances) {
							if (h.getEObject().equals(next)) {
								rootBySourceInstance.put(h, root);
								sourceInstances.remove(h);
								found = true;
								break;
							}
						}

						if (!found) {
							for (final EObjectWrapper t : targetInstances) {
								if (t.getEObject().equals(next)) {
									targetInstancesByRoot.get(root).add(t);
									targetInstances.remove(t);
									break;
								}
							}

						}
					}
				}
				// now select targetInstance for each source
				// instance
				for (final EObjectWrapper source : rootBySourceInstance.keySet()) {
					final List<EObjectWrapper> instances = targetInstancesByRoot.get(rootBySourceInstance.get(source));
					if (instances.size() == 1) {
						if (!targetSectionClass.isLibraryEntry()) {
							this.addValueToReference(ref, instances.get(0).getEObject(), source.getEObject());
						} else {
							/*
							 * for library entries, we cannot simply add the value as the reference we are handling is
							 * not part of the targetSectionClass; instead we want to specify the value as 'target' for
							 * the affected ExternalReferenceParameter
							 */
							LibraryEntry specificLibEntry = this.libEntryInstantiatorMap.get(source).getLibraryEntry();
							LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
							ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
									.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
							@SuppressWarnings("unchecked")
							AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
									.getOriginalParameter();
							originalParam.setTarget(instances.get(0).getEObject());
						}
					} else if (instances.size() > 1) {
						// Dialog
						this.checkCanceled();

						/*
						 * Consult the specified resolving strategy to resolve the ambiguity.
						 */
						List<EObject> targets = new ArrayList<>();
						try {
							List<EObjectWrapper> resolved = this.ambiguityResolvingStrategy.linkingSelectTargetInstance(
									instances, ref, (MappingHintGroupType) mappingGroup, null, Arrays.asList(source));
							if (ref.getEReference().isMany()) {
								for (EObjectWrapper eObjectWrapper : resolved) {
									targets.add(eObjectWrapper.getEObject());
								}
							} else {
								targets.add(resolved.get(0).getEObject());
							}
						} catch (AmbiguityResolvingException e) {
							if (e.getCause() instanceof UserAbortException) {
								throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
							} else {
								this.logger.severe(
										() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a target instance: "
												+ e.getMessage());
								this.logger.severe("Using default instance instead...");
								targets.add(instances.get(0).getEObject());
							}
						}

						// final
						// GenericItemSelectorDialogRunner<EObjectWrapper>
						// dialog = new
						// GenericItemSelectorDialogRunner<>(
						// "There was more than one target element
						// found for the NonContainmmentReference '"
						// + ref.getName()
						// + "' of TargetMMSection "
						// + groupTargetSection.getName()
						// + "(Section: "
						// + targetSectionClass.getName()
						// + ") in Mapping "
						// + mappingName
						// + "(Group: "
						// + group.getName()
						// + ") ."
						// + "Please select a target element for the
						// following source:\n"
						// + source.toString(),
						// instances, 0);
						// Display.getDefault().syncExec(dialog);
						//
						// if
						// (dialog.wasTransformationStopRequested())
						// {
						// canceled = true;
						// return;
						// }
						if (!targetSectionClass.isLibraryEntry()) {
							this.addValuesToReference(ref, targets, source.getEObject());
						} else {
							/*
							 * for library entries, we cannot simply add the value as the reference we are handling is
							 * not part of the targetSectionClass; instead we want to specify the value as 'target' for
							 * the affected ExternalReferenceParameter
							 */
							LibraryEntry specificLibEntry = this.libEntryInstantiatorMap.get(source).getLibraryEntry();
							LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
							ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
									.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
							@SuppressWarnings("unchecked")
							AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
									.getOriginalParameter();
							// library entries do currently not
							// support to set multiple target
							// instances for an
							// ExternalReferenceParameter
							originalParam.setTarget(targets.get(0));
						}

					} else {
						this.logger.warning(() -> "No suitable refernce target found for non-cont. reference '"
								+ ref.getName() + "' of the following instance of target class "
								+ targetSectionClass.getName() + " (Section: "
								+ targetSectionClass.getContainingSection().getName() + ").'\n" + source.toString());
					}

				}
				/*
				 * consider all available instances of the ref target
				 */
			} else {
				final LinkedHashMap<String, EObjectWrapper> targetInstancesToConsider = new LinkedHashMap<>();
				final LinkedList<String> targetSectionChoices = new LinkedList<>();
				final LinkedList<List<String>> instanceChoices = new LinkedList<>();

				for (final TargetSectionClass v : refValueClone) {
					final String classString = v.getName() + " (Section: " + v.getContainingSection().getName() + ")";
					final List<EObjectWrapper> insts = this.targetSectionRegistry.getFlattenedPamtramClassInstances(v);

					if (insts.size() > 0) {
						targetSectionChoices.add(classString);
						final LinkedList<String> choices = new LinkedList<>();
						for (final EObjectWrapper i : insts) {
							final String description = i.toString();
							targetInstancesToConsider.put(description, i);
							choices.add(description);
						}
						instanceChoices.add(choices);
					}
				}

				// the EObjectWrapper that will be set as target of
				// the non-containment reference
				List<EObject> targets = null;

				if (targetInstancesToConsider.values().size() == 1) {

					targets = Arrays.asList(targetInstancesToConsider.values().iterator().next().getEObject());

				} else if (targetInstancesToConsider.values().size() > 1) {

					this.checkCanceled();

					/*
					 * Consult the specified resolving strategy to resolve the ambiguity.
					 */
					HashMap<TargetSectionClass, List<EObjectWrapper>> choices = new HashMap<>();
					for (TargetSectionClass targetSection : refValueClone) {
						choices.put(targetSection, new ArrayList<>(
								this.targetSectionRegistry.getFlattenedPamtramClassInstances(targetSection)));
					}
					try {
						this.logger.fine(TargetSectionLinker.RESOLVE_LINKING_AMBIGUITY_STARTED);

						Map<TargetSectionClass, List<EObjectWrapper>> resolved;
						if (choices.size() == 1) {
							// If there is only one possible TargetSection,
							// we only need to let the user choose the
							// instance...
							//
							TargetSectionClass resolvedSection = choices.keySet().iterator().next();
							List<EObjectWrapper> resolvedInstances = this.ambiguityResolvingStrategy
									.linkingSelectTargetInstance(choices.values().iterator().next(), ref,
											(MappingHintGroupType) mappingGroup, null, sourceInstances);
							resolved = new HashMap<>();
							resolved.put(resolvedSection, resolvedInstances);
						} else {
							// ... otherwise, the user also needs to select
							// the container instance.
							//
							resolved = this.ambiguityResolvingStrategy.linkingSelectTargetSectionAndInstance(choices,
									ref, (MappingHintGroupType) mappingGroup);
						}

						Entry<TargetSectionClass, List<EObjectWrapper>> selected = resolved.entrySet().iterator()
								.next();
						if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
							((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
									.linkingTargetSectionSelected(new ArrayList<>(choices.keySet()), selected.getKey());
							((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy).linkingTargetInstanceSelected(
									new ArrayList<>(choices.get(selected.getKey())), selected.getValue().get(0));
						}
						this.logger.fine(TargetSectionLinker.RESOLVE_LINKING_AMBIGUITY_FINISHED);
						if (ref.getEReference().isMany()) {
							targets = new ArrayList<>();
							for (EObjectWrapper eObjectWrapper : selected.getValue()) {
								targets.add(eObjectWrapper.getEObject());
							}
						} else {
							targets = new ArrayList<>(Arrays.asList(selected.getValue().get(0).getEObject()));
						}
					} catch (AmbiguityResolvingException e) {
						if (e.getCause() instanceof UserAbortException) {
							throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
						} else {
							this.logger.severe(
									() -> "The following exception occured during the resolving of an ambiguity concerning a target section and instance: "
											+ e.getMessage());
							this.logger.severe("Using default section and instance instead...");
							targets = new ArrayList<>(
									Arrays.asList(choices.entrySet().iterator().next().getValue().get(0).getEObject()));
						}
					}

				} else {
					this.logger.warning(() -> "No suitable hint targets found for non-cont reference '" + ref.getName()
							+ "' of TargetMMSection " + mappingGroup.getTargetMMSectionGeneric().getName()
							+ "(Section: " + targetSectionClass.getName() + ") in Mapping "
							+ ((Mapping) mappingGroup.eContainer()).getName() + "(Group: " + mappingGroup.getName()
							+ ").");
				}

				if (targets != null) {
					for (final EObjectWrapper inst : sourceInstances) {
						if (!targetSectionClass.isLibraryEntry()) {
							this.addValuesToReference(ref, targets, inst.getEObject());
						} else {
							/*
							 * for library entries, we cannot simply add the value as the reference we are handling is
							 * not part of the targetSectionClass; instead we want to specify the value as 'target' for
							 * the affected ExternalReferenceParameter
							 */
							LibraryEntry specificLibEntry = this.libEntryInstantiatorMap.get(inst).getLibraryEntry();
							LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
							ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
									.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
							@SuppressWarnings("unchecked")
							AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
									.getOriginalParameter();
							// library entries do currently not
							// support to set multiple target
							// instances for an
							// ExternalReferenceParameter
							originalParam.setTarget(targets.get(0));
						}
					}
				}

			}

		}
	}

	// /**
	// * This iterates further downward in the containment hierarchy and calls
	// * {@link #linkTargetSection(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map)} for
	// * every found child {@link TargetSectionClass}.
	// *
	// * @param targetSectionClass
	// * The {@link TargetSectionClass} from where to iterate further downward in the containment hierarchy.
	// * @param mappingGroup
	// * The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	// * @param hints
	// * The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	// * {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	// * {@link ExportedMappingHintGroup imported hints}).
	// * @param hintValues
	// * The {@link HintValueStorage hint values} to take into account.
	// * @param instancesBySection
	// * The registry for {@link EObjectWrapper instances} created during the first pass of the instantiation.
	// */
	// private void instantiateTargetSectionSecondPassGoDeeper(final TargetSectionClass targetSectionClass,
	// final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> hints,
	// final HintValueStorage hintValues, final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection) {
	//
	// for (final TargetSectionReference ref : targetSectionClass.getReferences()) {
	//
	// if (ref instanceof TargetSectionCompositeReference) {
	//
	// for (final TargetSectionClass val : ((TargetSectionCompositeReference) ref).getValue()) {// instantiate
	// // targets
	//
	// this.linkTargetSection(val, mappingGroup, hints, hintValues, instancesBySection);
	//
	// this.checkCanceled();
	// }
	// }
	//
	// }
	// }

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
			List<EObjectWrapper> targetInstances, final TargetSectionCrossReference reference,
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
		} else {

			if (reference.getEReference().isMany()) {

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
					this.logger.fine(TargetSectionLinker.RESOLVE_LINKING_AMBIGUITY_STARTED);
					List<EObjectWrapper> resolved = this.ambiguityResolvingStrategy
							.linkingSelectTargetInstance(targetInstances, reference, null, null, sourceInstances);
					this.logger.fine(TargetSectionLinker.RESOLVE_LINKING_AMBIGUITY_FINISHED);
					IntStream.range(0, sourceInstances.size()).forEach(i -> targetInstancesBySourceInstance
							.put(sourceInstances.get(i), Arrays.asList(resolved.get(0))));
				} catch (AmbiguityResolvingException e) {
					if (e.getCause() instanceof UserAbortException) {
						throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
					} else {
						this.logger.severe(
								() -> "The following exception occured during the resolving of an ambiguity concerning the selection of a target instance: "
										+ e.getMessage());
						this.logger.severe("Using default instance instead...");
						IntStream.range(0, sourceInstances.size()).forEach(i -> targetInstancesBySourceInstance
								.put(sourceInstances.get(i), Arrays.asList(targetInstances.get(0))));
					}
				}

			}
		}

		for (Entry<EObjectWrapper, List<EObjectWrapper>> entryToInstantiate : targetInstancesBySourceInstance
				.entrySet()) {

			if (!mappingGroup.getTargetMMSectionGeneric().isLibraryEntry()) {
				this.addValuesToReference(reference, entryToInstantiate.getValue().stream()
						.map(EObjectWrapper::getEObject).collect(Collectors.toList()),
						entryToInstantiate.getKey().getEObject());
			} else {

				/*
				 * for library entries, we cannot simply add the value as the reference we are handling is not part of
				 * the targetSectionClass; instead we want to specify the value as 'target' for the affected
				 * ExternalReferenceParameter
				 */
				LibraryEntry specificLibEntry = this.libEntryInstantiatorMap.get(entryToInstantiate.getKey())
						.getLibraryEntry();
				LibraryEntry genericLibEntry = (LibraryEntry) AgteleEcoreUtil.getAncestorOfKind(
						mappingGroup.getTargetMMSectionGeneric(), LibraryPackage.Literals.LIBRARY_ENTRY);

				if (entryToInstantiate.getValue().size() > 1) {
					this.logger.severe(
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

	/**
	 * This creates a link from the given {@link EObject source element} to the given {@link EObject target element} via
	 * the non-containment reference specified by the given {@link TargetSectionCrossReference}.
	 *
	 * @param ref
	 *            The {@link TargetSectionCrossReference} that specifies the {@link EReference} to be used to create the
	 *            link.
	 * @param target
	 *            The {@link EObject} to be linked to the <em>source</em> via the given reference.
	 * @param source
	 *            The {@link EObject} being the source of the link to be created.
	 */
	private void addValueToReference(final TargetSectionCrossReference ref, final EObject target,
			final EObject source) {

		if (ref.getEReference().getUpperBound() == 1) {
			if (source.eIsSet(ref.getEReference())) {

				this.logger.warning(
						() -> "More than one value was supposed to be connected to the TargetSectionNonContainmentReference '"
								+ ref.getName() + "' in the target section '" + ref.getContainingSection()
								+ "Please check your mapping model.");

			} else {
				source.eSet(ref.getEReference(), target);
			}

		} else {

			@SuppressWarnings("unchecked")
			final EList<EObject> oldRefs = (EList<EObject>) source.eGet(ref.getEReference());
			final LinkedList<EObject> newRefs = new LinkedList<>();
			if (oldRefs != null) {
				newRefs.addAll(oldRefs);
			}
			newRefs.add(target);
			source.eSet(ref.getEReference(), newRefs);

		}
	}

	/**
	 * This creates a link from the given {@link EObject source element} to the given list of {@link EObject target
	 * elements} via the non-containment reference specified by the given {@link TargetSectionCrossReference}.
	 *
	 * @param ref
	 *            The {@link TargetSectionCrossReference} that specifies the {@link EReference} to be used to create the
	 *            link.
	 * @param targets
	 *            The {@link EObject EObjects} to be linked to the <em>source</em> via the given reference.
	 * @param source
	 *            The {@link EObject} being the source of the link to be created.
	 */
	private void addValuesToReference(final TargetSectionCrossReference ref, final List<EObject> targets,
			final EObject source) {

		if (ref.getEReference().getUpperBound() == 1) {
			if (targets.size() > 1) {

				this.logger.warning(
						() -> "More than one value was supposed to be connected to the TargetSectionNonContainmentReference '"
								+ ref.getName() + "' in the target section '" + ref.getContainingSection()
								+ "Please check your mapping model.");
			} else if (targets.isEmpty()) {

				this.logger.warning(() -> "No value found to be connected to the TargetSectionNonContainmentReference '"
						+ ref.getName() + "' in the target section '" + ref.getContainingSection()
						+ "Please check your mapping model.");
			} else {

				this.addValueToReference(ref, targets.get(0), source);
			}

		} else {

			@SuppressWarnings("unchecked")
			final EList<EObject> oldRefs = (EList<EObject>) source.eGet(ref.getEReference());
			final LinkedList<EObject> newRefs = new LinkedList<>();
			if (oldRefs != null) {
				newRefs.addAll(oldRefs);
			}
			newRefs.addAll(targets);
			source.eSet(ref.getEReference(), newRefs);

		}
	}

}
