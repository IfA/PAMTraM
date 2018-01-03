package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.CancelTransformationException;
import de.mfreund.gentrans.transformation.UserAbortException;
import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.MappingHint;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.generic.CardinalityType;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.library.AttributeParameter;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.target.ActualTargetSectionAttribute;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCompositeReference;
import pamtram.structure.target.TargetSectionReference;
import pamtram.structure.target.VirtualTargetSectionAttribute;

/**
 * Class for instantiating target model sections using the hints supplied by {@link MappingInstanceDescriptor
 * MappingInstanceStorages}.
 *
 * @author mfreund
 */
public class TargetSectionInstantiator extends CancelableTransformationAsset {

	private static final String RESOLVE_INSTANTIATING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";

	private static final String RESOLVE_INSTANTIATING_AMBIGUITY_STARTED = "[Ambiguity] Resolve expanding ambiguity...";

	/**
	 * TargetSectionContainmentReferences that point to a EReference with an upporBound of 1 but at one point more than
	 * one element was supposed to be connected with them
	 */
	private final Set<TargetSectionCompositeReference> wrongCardinalityContainmentRefs;

	/**
	 * target section registry used when instantiating classes
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the
	 * execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * Whether extended parallelization shall be used during the transformation that might lead to the fact that the
	 * transformation result (especially the order of lists) varies between executions.
	 */
	private boolean useParallelization;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public TargetSectionInstantiator(TransformationAssetManager assetManager) {

		super(assetManager);

		this.targetSectionRegistry = assetManager.getTargetSectionRegistry();
		this.ambiguityResolvingStrategy = assetManager.getTransformationConfig().getAmbiguityResolvingStrategy();
		this.useParallelization = assetManager.getTransformationConfig().isUseParallelization();
		this.wrongCardinalityContainmentRefs = new HashSet<>();

	}

	/**
	 * This expands the {@link TargetSection TargetSections} represented by the <em>hintGroups</em> of the given list of
	 * {@link MappingInstanceDescriptor MappingInstanceStorages}.
	 * <p />
	 * Created {@link EObjectWrapper instances} are
	 * {@link MappingInstanceDescriptor#addInstances(InstantiableMappingHintGroup, TargetSectionClass, java.util.Collection)
	 * registered} in the corresponding <em>mappingInstance</em>.
	 *
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceDescriptor mapping instances} to expand.
	 */
	public void expandTargetSectionInstances(List<MappingInstanceDescriptor> mappingInstances) {

		this.logger.info(() -> "Instantiating " + mappingInstances.size() + " TargetSection instances...");

		// Iterate over all the mapping instances and expand them
		//
		mappingInstances.stream().forEach(this::expandTargetSectionInstance);
	}

	/**
	 * This expands the {@link TargetSection TargetSections} represented by the <em>hintGroups</em> of the given
	 * {@link MappingInstanceDescriptor}.
	 * <p />
	 * Created {@link EObjectWrapper instances} are
	 * {@link MappingInstanceDescriptor#addInstances(InstantiableMappingHintGroup, TargetSectionClass, java.util.Collection)
	 * registered} in the given <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor mapping instance} to expand.
	 */
	public void expandTargetSectionInstance(MappingInstanceDescriptor mappingInstance) {

		/*
		 * Iterate over all mapping hint groups and expand them
		 */
		// TODO check if we can parallelize this
		mappingInstance.getMappingHintGroups().stream()
				.filter(g -> g.getTargetSection() != null && g instanceof MappingHintGroup)
				.map(g -> (MappingHintGroup) g).forEach(g -> this.expandTargetSectionInstance(mappingInstance, g));

		/*
		 * Iterate over all imported mapping hint groups and expand them
		 */
		// TODO check if we can parallelize this
		mappingInstance.getMappingHintGroupImporters().stream()
				.filter(g -> g.getHintGroup() != null && g.getHintGroup().getTargetSection() != null)
				.forEach(g -> this.expandTargetSectionInstance(mappingInstance, g));

	}

	/**
	 * This expands the given {@link TargetSection} represented by the given <em>hintGroup</em> for the given
	 * {@link MappingInstanceDescriptor} by redirecting to
	 * {@link TargetSectionInstantiator#instantiateTargetSectionFirstPass(TargetSection, InstantiableMappingHintGroup, List, HintValueStorage)}.
	 * <p />
	 * Created {@link EObjectWrapper instances} are
	 * {@link MappingInstanceDescriptor#addInstances(InstantiableMappingHintGroup, TargetSectionClass, java.util.Collection)
	 * registered} in the given <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor mapping instance} to expand.
	 * @param hintGroup
	 *            The {@link MappingHintGroup} that lead to the instantiation of the given <em>mappingInstance</em>.
	 */
	private void expandTargetSectionInstance(final MappingInstanceDescriptor mappingInstance,
			MappingHintGroup hintGroup) {

		final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection = this.instantiateTargetSectionFirstPass(
				hintGroup.getTargetSection(), hintGroup, mappingInstance.getMappingHints(hintGroup),
				mappingInstance.getHintValues());

		if (instancesBySection == null) {
			if (hintGroup.getTargetSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error

				this.logger.severe(() -> "Error instantiating target section '" + hintGroup.getTargetSection().getName()
						+ "' using mapping rule '" + mappingInstance.getMapping().getName() + "'");
			}
		} else {

			// Register the created instance
			//
			instancesBySection.entrySet().stream()
					.forEach(entry -> mappingInstance.addInstances(hintGroup, entry.getKey(), entry.getValue()));
		}
	}

	/**
	 * This expands the given {@link TargetSection} represented by the given <em>hintGroup</em> for the given
	 * {@link MappingInstanceDescriptor} by redirecting to
	 * {@link TargetSectionInstantiator#instantiateTargetSectionFirstPass(TargetSection, InstantiableMappingHintGroup, List, HintValueStorage)}.
	 * <p />
	 * Created {@link EObjectWrapper instances} are
	 * {@link MappingInstanceDescriptor#addInstances(InstantiableMappingHintGroup, TargetSectionClass, java.util.Collection)
	 * registered} in the given <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor mapping instance} to expand.
	 * @param mappingHintGroupImporter
	 *            The {@link MappingHintGroupImporter} that lead to the instantiation of the given
	 *            <em>mappingInstance</em>.
	 */
	private void expandTargetSectionInstance(final MappingInstanceDescriptor mappingInstance,
			MappingHintGroupImporter mappingHintGroupImporter) {

		final List<MappingHint> hints = mappingInstance.getMappingHints(mappingHintGroupImporter, true);

		final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection = this.instantiateTargetSectionFirstPass(
				mappingHintGroupImporter.getHintGroup().getTargetSection(), mappingHintGroupImporter, hints,
				mappingInstance.getHintValues());

		if (instancesBySection == null) {
			if (mappingHintGroupImporter.getHintGroup().getTargetSection()
					.getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
				this.logger.severe(() -> "Error instantiating target section '"
						+ mappingHintGroupImporter.getHintGroup().getTargetSection().getName()
						+ "' using mapping rule '" + mappingInstance.getMapping().getName() + "'");
			}
		} else {

			// Register the created instance
			//
			instancesBySection.entrySet().stream().forEach(
					entry -> mappingInstance.addInstances(mappingHintGroupImporter, entry.getKey(), entry.getValue()));
		}
	}

	/**
	 * From the given list of {@link MappingHint MappingHints} and the given {@link HintValueStorage hint values}, find
	 * all attribute mappings that add to the cardinality of the given {@link TargetSectionClass}.
	 * <p />
	 * Note: This function iterates downward in the containment hierarchy of the {@link TargetSection}.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that the cardinality shall be determined.
	 * @param hints
	 *            The list of {@link MappingHint MappingHints} to be considered.
	 * @param hintValues
	 *            The {@link HintValueStorage} for the current TargetSection containing all extracted hint values.
	 * @param oldSelectedHint
	 *            The {@link AttributeMapping} that was previously determined as 'cardinality-defining'.
	 * @return The {@link AttributeMapping} that determines the cardinality or <em>null</em> if no AttributeMapping
	 *         could be determined that would produce a higher cardinality than the one produced by the
	 *         '<em>oldSelectedHint</em>'.
	 */
	private static List<AttributeMapping> searchAttributesMapping(final TargetSectionClass targetSectionClass,
			final Collection<MappingHint> hints, final HintValueStorage hintValues,
			final AttributeMapping oldSelectedHint) {

		Set<AttributeMapping> selectedHints = new LinkedHashSet<>();

		// check attributes
		for (final TargetSectionAttribute attr : targetSectionClass.getAllAttributes()) {

			for (final MappingHint hint : hints) {
				if (hint instanceof AttributeMapping && ((AttributeMapping) hint).getTarget().equals(attr)) {

					selectedHints.add((AttributeMapping) hint);
					// if (selectedHint == null || hintValues.getHintValues((AttributeMapping) hint).isEmpty()) {
					//
					// if (hintValues.getHintValues((AttributeMapping) hint).isEmpty()) {
					// return null;// there needs to be at least one
					// // value for each attributeHint
					// } else {
					// selectedHint = (AttributeMapping) hint;
					// }
					//
					// } else if (hintValues.getHintValues((AttributeMapping) hint).size() > hintValues
					// .getHintValues(selectedHint).size()) {
					//
					// selectedHint = (AttributeMapping) hint;
					// }
				}
			}
		}

		// check references
		for (final TargetSectionReference ref : targetSectionClass.getReferences()) {

			for (final TargetSectionClass val : ref.getValuesGeneric()) {
				if (val.getCardinality().equals(CardinalityType.ONE)) {

					selectedHints
							.addAll(TargetSectionInstantiator.searchAttributesMapping(val, hints, hintValues, null));
					// final AttributeMapping hint = TargetSectionInstantiator.searchAttributeMapping(val, hints,
					// hintValues, selectedHint);
					//
					// if (hint == null && selectedHint != null) {
					// return null;
					// } else {
					// selectedHint = hint;
					// }
				}
			}
		}

		return new ArrayList<>(selectedHints);
	}

	/**
	 * Instantiate the given {@link TargetSection} using the specified {@link HintValueStorage hint values}.
	 * <p />
	 * Note: This constitutes the first pass of the instantiation that only creates attributes and containment
	 * references. Non-containment references are created during the
	 * {@link #instantiateTargetSectionSecondPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map)
	 * second pass}.
	 *
	 * @param targetSection
	 *            The {@link TargetSection} to instantiate.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @return A map relating created {@link EObjectWrapper instances} to the {@link TargetSectionClass} based on which
	 *         they have been created.
	 */
	private Map<TargetSectionClass, List<EObjectWrapper>> instantiateTargetSectionFirstPass(
			final TargetSection targetSection, final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints, final HintValueStorage hintValues) {

		// This will be filled as we iterate through the TargetSection and will
		// be returned in the end
		//
		final Map<TargetSectionClass, List<EObjectWrapper>> instBySection = new LinkedHashMap<>();

		/*
		 * Now, perform the first-run instantiation.
		 */
		if (this.instantiateTargetSectionFirstPass(targetSection, mappingGroup, mappingHints, hintValues,
				instBySection) != null) {

			return instBySection;
		} else {
			return null;
		}

	}

	/**
	 * Instantiate the given {@link TargetSectionClass} using the specified {@link HintValueStorage hint values}.
	 * <p />
	 * Note: This is called recursively as we iterate downward in the containment hierarchy of the {@link TargetSection}
	 * to be instantiated. Note: Created instances are registered in the <em>createdInstancesByTargetSectionClass</em>.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} to instantiate.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param createdInstancesByTargetSectionClass
	 *            The map where all created {@link EObjectWrapper instances} are registered.
	 * @return The list of created {@link EObjectWrapper instances} or '<em>null</em>' if an error occurred.
	 */
	private List<EObjectWrapper> instantiateTargetSectionFirstPass(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> createdInstancesByTargetSectionClass) {

		// Determine the cardinality based on Attribute- and CardinalityMappings
		//
		int cardinality = this.determineCardinality(targetSectionClass, mappingGroup, mappingHints, hintValues);

		// Cardinality == 0
		//
		if (cardinality == 0) {

			if (!targetSectionClass.getCardinality().equals(CardinalityType.ZERO_INFINITY)) {

				this.logger.severe(() -> "TargetMMSection class '" + targetSectionClass.getName()
						+ "' has a cardinality of at least 1 specified, but no suitable mappingHint was found.");

				return null;

			} else {
				/*
				 * return empty Sequence or else this will fail
				 */
				return new LinkedList<>();
			}
		}

		// Cardinality > 0
		//

		// instantiate self(s)
		//
		final List<EObjectWrapper> instances = IntStream.range(0, cardinality).mapToObj(
				i -> this.instantiateTargetSectionClass(targetSectionClass, mappingGroup, mappingHints, hintValues))
				.collect(Collectors.toList());

		// create attributes
		//
		final List<EObjectWrapper> markedForDelete = this.instantiateTargetSectionAttributes(targetSectionClass,
				mappingGroup, mappingHints, hintValues, instances);

		if (markedForDelete == null) {
			return null;
		}

		// create containment references
		//
		boolean result = this.instantiateTargetSectionContainmentReferences(targetSectionClass, mappingGroup,
				mappingHints, hintValues, createdInstancesByTargetSectionClass, instances, markedForDelete);

		if (!result) {
			return null;
		}

		// Remove instances marked for delete
		instances.removeAll(markedForDelete);

		// All went well...
		for (final EObjectWrapper instance : instances) {
			// Add instance to map of targetMetaModel
			this.targetSectionRegistry.addClassInstance(instance, mappingGroup, targetSectionClass);
		}

		if (createdInstancesByTargetSectionClass.containsKey(targetSectionClass)) {

			createdInstancesByTargetSectionClass.get(targetSectionClass).addAll(instances);

		} else {

			final LinkedList<EObjectWrapper> instClone = new LinkedList<>();
			instClone.addAll(instances);
			createdInstancesByTargetSectionClass.put(targetSectionClass, instClone);

		}
		return instances;
	}

	/**
	 * This determines and returns the cardinality when instantiating the given {@link TargetSectionClass} using the
	 * specified {@link HintValueStorage hint values}, i.e. how many instances of {@link TargetSectionClass} shall be
	 * created.
	 * <p />
	 * Therefore, existing {@link AttributeMapping AttributeMappings} and {@link CardinalityMapping CardinalityMappings}
	 * are evaluated based on the given {@link HintValueStorage hint values}.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} for that the cardinality shall be determined.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account for the determination of the
	 *            cardinality.
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @return The cardinality to be used whne instantiating the given {@link TargetSectionClass}.
	 */
	private int determineCardinality(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues) {

		/*
		 * ignore attribute hints and cardinality hint, if variableCardinality == false
		 */
		if (targetSectionClass.getCardinality().equals(CardinalityType.ONE)) {
			return 1;
		}

		// This will be returned in the end. We start by assuming a cardinality
		// of '0' or '1' depending on the cardinality of the TargetSectionClass.
		//
		int cardinality = targetSectionClass.getCardinality().equals(CardinalityType.ONE_INFINITY) ? 1 : 0;

		int cardHintValue = 1;
		boolean cardMappingExists = false;

		// check CardinalityMappings
		//
		List<CardinalityMapping> cardinalityMappings = mappingHints.stream().filter(
				h -> h instanceof CardinalityMapping && ((CardinalityMapping) h).getTarget().equals(targetSectionClass))
				.map(h -> (CardinalityMapping) h).collect(Collectors.toList());

		for (CardinalityMapping cardinalityMapping : cardinalityMappings) {

			if (hintValues.containsHint(cardinalityMapping)
					&& !hintValues.getHintValues(cardinalityMapping).isEmpty()) {

				String hintVal = hintValues.getNextHintValue(cardinalityMapping);

				try {
					double doubleValue = Double.parseDouble(hintVal);
					if (doubleValue == Math.floor(doubleValue) && !Double.isInfinite(doubleValue)) {
						cardHintValue = Double.valueOf(hintVal).intValue();
					} else {
						this.logger
								.severe(() -> "Unable to parse Integer from calculated value for CardinalityMapping '"
										+ cardinalityMapping.getName() + "! The problematic value was '" + hintVal
										+ "'.");
						continue;
					}
				} catch (NumberFormatException e) {
					this.logger.severe(() -> "Unable to parse Integer from calculated value for CardinalityMapping '"
							+ cardinalityMapping.getName() + "! The problematic value was '" + hintVal + "'.");
					continue;
				}

				cardMappingExists = true;

			}
		}

		// check for attribute hint
		boolean hintFound = false;
		if (mappingGroup instanceof MappingHintGroup) {

			final MappingHintGroup mhGrp = (MappingHintGroup) mappingGroup;

			if (!mhGrp.getContainerSelectors().isEmpty() && (mhGrp.getTargetSection().equals(targetSectionClass)
					|| mhGrp.getTargetSection().getAllExtending().contains(targetSectionClass))) {

				hintFound = true;

				// Use the maximum cardinality provided by one of the
				// ContainerSelectors
				//
				for (ContainerSelector containerSelector : mhGrp.getContainerSelectors()) {

					int containerSelectorCardinality = hintValues.getHintValues(containerSelector).size();
					if (containerSelectorCardinality > cardinality) {
						cardinality = containerSelectorCardinality;
					}
				}
			}
		}

		List<AttributeMapping> hints = TargetSectionInstantiator.searchAttributesMapping(targetSectionClass,
				mappingHints, hintValues, null);

		if (!hints.isEmpty()) {// there was an AttributeHint....

			int attributeMappingHintCardinality = 0;

			// Collect the cardinality for each TargetSectionAttribute
			//
			for (TargetSectionAttribute targetAttribute : hints.stream().map(AttributeMapping::getTarget)
					.collect(Collectors.toCollection(LinkedHashSet::new))) {

				int localAttributeMappingHintCardinality = this.getTargetAttributeCardinality(hintValues, hints,
						targetAttribute);

				if (localAttributeMappingHintCardinality > attributeMappingHintCardinality) {
					attributeMappingHintCardinality = localAttributeMappingHintCardinality;
				}

			}

			if (attributeMappingHintCardinality > cardinality) {

				cardinality = attributeMappingHintCardinality;
			}

			// Use the hint value of the found CardinalityMapping
			if (cardMappingExists && cardHintValue > attributeMappingHintCardinality
					&& cardHintValue % attributeMappingHintCardinality == 0) {
				cardinality = cardHintValue;
			}

		} else {// no AttributeHint found

			// mc hint found....only go on if there were no attrMappings
			//
			if (hintFound && mappingHints.parallelStream().anyMatch(h -> h instanceof AttributeMapping)) {

				cardinality = 0;
			}

			// no modelConnaectionHint or AttributeMapping found
			// or cardinality is still 1
			// last chance
			if (cardinality <= 1) {

				if (cardMappingExists) {
					cardinality = cardHintValue;

				} else {
					/*
					 * Consult the specified resolving strategy to resolve the ambiguity.
					 */
					try {
						this.logger.fine(TargetSectionInstantiator.RESOLVE_INSTANTIATING_AMBIGUITY_STARTED);
						List<Integer> resolved = this.ambiguityResolvingStrategy.instantiatingSelectCardinality(
								Arrays.asList((Integer) null), targetSectionClass, mappingGroup);
						if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
							((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
									.instantiatingCardinalitySelected(Arrays.asList((Integer) null), resolved.get(0));
						}
						this.logger.fine(TargetSectionInstantiator.RESOLVE_INSTANTIATING_AMBIGUITY_FINISHED);
						if (resolved.get(0) != null) {
							cardinality = resolved.get(0);
						} else {
							cardinality = targetSectionClass.getCardinality() != CardinalityType.ZERO_INFINITY ? 1 : 0;
						}
					} catch (AmbiguityResolvingException e) {

						if (e.getCause() instanceof UserAbortException) {
							throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
						} else {
							this.logger.severe(
									() -> "The following exception occured during the resolving of an ambiguity concerning a cardinality: "
											+ e.getMessage());
							this.logger.severe("Using default cardinality instead...");
							cardinality = targetSectionClass.getCardinality() != CardinalityType.ZERO_INFINITY ? 1 : 0;
						}
					}
				}
			}

		}

		return cardinality;
	}

	/**
	 * This just sums up the cardinalities contributed by each {@link AttributeMapping} (resp. the corresponding hint
	 * values) for the given {@link TargetSectionAttribute}. I.e, if there are two AttributeMappings for the given
	 * Attribute, this will return the sum of the cardinalities resulting from each of those two AttributeMappings.
	 *
	 * @param hintValues
	 *            The {@link HintValueStorage} providing the hint values based on which the cardinalities are
	 *            calculated.
	 * @param hints
	 *            The list of potential {@link AttributeMapping AttributeMappings} (only the subset pointing to the
	 *            given <em>targetAttribute</em> are evaluated by this method).
	 * @param targetAttribute
	 *            The {@link TargetSectionAttribute} for which the cardinality shall be determined.
	 * @return The determined cardinality.
	 */
	private int getTargetAttributeCardinality(final HintValueStorage hintValues, List<AttributeMapping> hints,
			TargetSectionAttribute targetAttribute) {

		// This is based on the addition of all cardinalities from all AttributeMappings
		//
		int localAttributeMappingHintCardinality = 0;

		for (AttributeMapping hint : hints.stream().filter(a -> a.getTarget().equals(targetAttribute))
				.collect(Collectors.toList())) {

			int hintCardinality = hintValues.getHintValues(hint).size();

			localAttributeMappingHintCardinality += hintCardinality;

		}
		return localAttributeMappingHintCardinality;
	}

	/**
	 * This instantiates the given {@link TargetSectionClass} by creating a new {@link EObject} and wrapping it in an
	 * {@link EObjectWrapper}.
	 * <p />
	 * If the given TargetSectionClass represents a {@link TargetSectionClass#isLibraryEntry() LibraryEntry},
	 * additionally, a new {@link LibraryEntryInstantiator} is created and registered in the
	 * {@link #libEntryInstantiators} and {@link #libEntryInstantiatorMap}.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} to instantiate.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @return The created {@link EObjectWrapper instance}.
	 */
	private EObjectWrapper instantiateTargetSectionClass(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues) {

		// create the eObject
		final EObject inst = targetSectionClass.getEClass().getEPackage().getEFactoryInstance()
				.create(targetSectionClass.getEClass());

		// create an EObjectTransformationHelper that wraps the eObject and more
		// stuff
		EObjectWrapper instTransformationHelper = new EObjectWrapper(inst, this.targetSectionRegistry);

		/*
		 * If the target section is a library entry, we create a new 'LibraryEntryInstantiator' that will insert the
		 * real library entry at the end.
		 */
		if (targetSectionClass.isLibraryEntry()) {

			/*
			 * As LibraryEntries may get inserted multiple times, we need to create a self-contained copy of the library
			 * entry
			 */
			LibraryEntry originallibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
			ArrayList<EObject> originals = new ArrayList<>();
			originals.add(originallibEntry);
			originals.add(originallibEntry.getOriginalLibraryEntry());
			LibraryEntry clonedLibEntry = (LibraryEntry) EcoreUtil.copyAll(originals).iterator().next();

			LibraryEntryInstantiator instLibraryEntryInstantiator = new LibraryEntryInstantiator(clonedLibEntry,
					instTransformationHelper, mappingGroup, mappingHints, hintValues, this.logger);

			this.targetSectionRegistry.getLibraryEntryRegistry().put(instTransformationHelper,
					instLibraryEntryInstantiator);
		}

		return instTransformationHelper;
	}

	/**
	 * This instantiates the {@link TargetSectionAttribute TargetSectionAttributes} for the given
	 * {@link TargetSectionClass} based on the provided {@link HintValueStorage hint values}.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} defining the attributes to be instantiated.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param instances
	 *            The {@link EObjectWrapper instances} created based on the given {@link TargetSectionClass} for which
	 *            the {@link TargetSectionAttribute TargetSectionAttributes} shall be instantiated.
	 * @return markedForDelete The list of instances to be deleted or '<em>null</em>' if an internal error occurred and
	 *         the transformation should abort.
	 */
	private List<EObjectWrapper> instantiateTargetSectionAttributes(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues, final List<EObjectWrapper> instances) {

		// This keeps track of the instances that need to be deleted due to
		// duplicate attribute values
		// that should be unique; We will return this in the end
		//
		List<EObjectWrapper> markedForDelete = new ArrayList<>();

		/*
		 * we don't need to reference the EObjects, since their order doesn't change while we are using this
		 */
		final Map<TargetSectionAttribute, List<String>> attributeValues = new LinkedHashMap<>();

		List<AttributeMapping> attributeMappings = mappingHints.stream().filter(h -> h instanceof AttributeMapping)
				.map(h -> (AttributeMapping) h).collect(Collectors.toList());

		for (final TargetSectionAttribute attr : targetSectionClass.getAllAttributes()) {

			attributeValues.put(attr, new LinkedList<String>());

			// Get a useful number of hint values
			//
			LinkedList<String> attrHintValues = new LinkedList<>(
					this.harmonizeHintValues(attr, instances.size(), hintValues, attributeMappings));

			// No hint values are present, so we either use the default value (if present) are ask the
			// AmbiguityResolvingStrategy for a value to use
			//
			if (attrHintValues.isEmpty()) {

				for (EObjectWrapper instance : instances) {

					if (attr.getValue() != null && !attr.getValue().isEmpty()) {
						attrHintValues.add(attr.getValue());
					} else {
						/*
						 * Consult the specified resolving strategy to resolve the ambiguity.
						 */
						try {
							this.logger.fine("\n[Ambiguity] Resolve expanding ambiguity...");
							List<String> resolved = this.ambiguityResolvingStrategy.instantiatingSelectAttributeValue(
									Arrays.asList((String) null), attr, instance.getEObject(), mappingGroup);
							if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
								((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
										.instantiatingAttributeValueSelected(Arrays.asList((String) null),
												resolved.get(0));
							}
							this.logger.fine("[Ambiguity] ...finished.");
							attrHintValues.add(resolved.get(0));
						} catch (AmbiguityResolvingException e) {
							if (e.getCause() instanceof UserAbortException) {
								throw new CancelTransformationException(e.getCause().getMessage(), e.getCause());
							} else {
								this.logger.severe(
										() -> "The following exception occured during the resolving of an ambiguity concerning an attribute value: "
												+ e.getMessage());
								this.logger.severe("Using default value instead...");
								continue;
							}
						}
					}

				}
			}

			// Always create at least one value so that we are able to used the default value for the attribute (if
			// present) or use the AmbiguityResolvingStrategy
			//
			int numberOfValuesPerInstance = attrHintValues.size() / instances.size();

			// Create and store the hint values (they will be set later on
			// after we have check for duplicates)
			//
			for (int i = 0; i < instances.size(); i++) {

				EObjectWrapper instance = instances.get(i);
				List<String> hintValuesForInstance = attrHintValues.subList(i * numberOfValuesPerInstance,
						(i + 1) * numberOfValuesPerInstance);

				for (int j = 0; j < numberOfValuesPerInstance; j++) {

					String attrValue = hintValuesForInstance.get(j);

					if (attr.isUnique() && (attributeValues.get(attr).contains(attrValue)
							|| this.targetSectionRegistry.getAttrValRegistry().attributeValueExists(attr, attrValue))) {

						/*
						 * we can only delete this at the end, or else the attributeHint values won't fit anymore
						 */
						markedForDelete.add(instance);

					}

					// save attr value in Map
					//
					attributeValues.get(attr).add(attrValue);
				}

			}
		}

		/*
		 * Now that we know which instances will be deleted we set (and register) the actual attribute values of the
		 * instances that will not get deleted
		 */
		for (final EObjectWrapper instance : instances) {

			for (final TargetSectionAttribute attr : attributeValues.keySet()) {

				int numberOfValuesPerInstance = attributeValues.get(attr).size() / instances.size();

				if (attributeValues.get(attr).isEmpty() || numberOfValuesPerInstance == 0) {
					continue;
				}

				if (numberOfValuesPerInstance > 1) {
					if (attr instanceof VirtualAttribute<?, ?, ?, ?>) {
						this.logger.severe(() -> "Trying to set multiple values for a VirtualAttribute ('"
								+ attr.getName() + "'). This is currently not supported!");
						continue;
					} else if (targetSectionClass.isLibraryEntry()) {
						this.logger.severe(
								() -> "Trying to set multiple values for an AttributeParameter of a LibraryEntry ('"
										+ targetSectionClass.getName() + "'). This is currently not supported!");
						continue;
					} else if (!((ActualAttribute<?, ?, ?, ?>) attr).getAttribute().isMany()) {
						this.logger.severe(() -> "Trying to set multiple values for an ActualAttribute ('"
								+ attr.getName() + "') that is based on a single-valued EAttribute!");
						continue;
					}
				}

				boolean isMany = attr instanceof ActualTargetSectionAttribute
						&& ((ActualTargetSectionAttribute) attr).getAttribute().isMany();

				// In case we are dealing with a multi-valued attribute, we add to potentially already existing
				// values (e.g. based on another attribute mapping) instead of overwriting them
				//
				List<String> setValues = !isMany ? new ArrayList<>()
						: new ArrayList<>(this.getCurrentAttributeValues(instance, attr));
				setValues.addAll(IntStream.range(0, numberOfValuesPerInstance)
						.mapToObj(i -> attributeValues.get(attr).get(instances.indexOf(instance) + i))
						.collect(Collectors.toList()));

				try {

					// finally, we can set the value of the attribute
					if (!targetSectionClass.isLibraryEntry()) {
						/*
						 * setting an Attribute causes the value to be saved in the attribute value registry
						 */
						instance.setAttributeValues(attr, setValues);
					} else {

						String setValue = setValues.get(0);
						/*
						 * for library entries, we cannot simply set the value as the attribute we are handling is not
						 * part of the targetSectionClass; instead we want to specify the value as 'new value' for the
						 * affected AttributeParameter
						 */
						LibraryEntry specificLibEntry = this.targetSectionRegistry.getLibraryEntryRegistry()
								.get(instance).getLibraryEntry();
						LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
						int attParamIndex = genericLibEntry.getParameters().indexOf(attr.eContainer());
						if (attParamIndex >= 0) {
							AttributeParameter attrParam = (AttributeParameter) specificLibEntry.getParameters()
									.get(attParamIndex);
							@SuppressWarnings("unchecked")
							AbstractAttributeParameter<EObject> originalParam = (AbstractAttributeParameter<EObject>) attrParam
									.getOriginalParameter();

							originalParam.setNewValue(setValue);
						} else {
							if (attr.equals(genericLibEntry.getId())) {
								specificLibEntry.getId().setValue(setValue);
							} else if (attr.equals(genericLibEntry.getClasspath())) {
								specificLibEntry.getClasspath().setValue(setValue);
							}
						}
					}

				} catch (final IllegalArgumentException e) {
					this.logger.severe(() -> "Could not set Attribute " + attr.getName() + " of target section Class "
							+ targetSectionClass.getName() + " in target section "
							+ targetSectionClass.getContainingSection().getName()
							+ ".\nThe problematic value(s) was/were: '" + String.join(", ", setValues) + "'.");
				}

			}

		}

		return markedForDelete;
	}

	/**
	 * This harmonizes the actual extracted hint values for the given {@link TargetSectionAttribute} with the expected
	 * number of values. For example, if only a single value has been extracted but 3 values are expected, this will
	 * just duplicate the single hint value three times.
	 * <p />
	 * Note: If no hint values could be determined (e.g. because there are no {@link AttributeMapping AttributeMappings}
	 * corresponding to the given {@link TargetSectionAttribute}) or if anything goes wrong during the harmonization, an
	 * empty list will be returned.
	 * <p />
	 * Note: If the given {@link TargetSectionAttribute} is not {@link EAttribute#isMany() many-valued}, the size of the
	 * returned list will always match the given <em>expected</em> number. If it is {@link EAttribute#isMany()
	 * many-valued}, the size of the returned list will always be a multiple thereof.
	 *
	 * @param attribute
	 *            The {@link TargetSectionAttribute} for which the hint values shall be harmonized.
	 * @param expected
	 *            The expected number of hint values.
	 * @param hintValues
	 *            The {@link HintValueStorage} providing the extracted hint values.
	 * @param attributeMappings
	 *            The list of potential {@link AttributeMapping AttributeMappings} providing values for the given
	 *            <em>attribute</em> (only the subset of those actually pointing to the given
	 *            {@link TargetSectionAttribute} are evaluated)
	 * @return The harmonized hint values.
	 */
	private List<String> harmonizeHintValues(final TargetSectionAttribute attribute, int expected,
			final HintValueStorage hintValues, List<AttributeMapping> attributeMappings) {

		List<String> attrHintValues = new ArrayList<>();

		// The subset of the given AttributeMappings that point to the given attribute
		//
		List<AttributeMapping> attributeMappingsForAttribute = attributeMappings.stream()
				.filter(am -> am.getTarget().equals(attribute)).collect(Collectors.toList());

		if (expected == 0 || attributeMappingsForAttribute.isEmpty()) {

			return attrHintValues;

			// A single AttributeMapping provides all hint values
			//
		} else if (attributeMappingsForAttribute.size() == 1) {

			AttributeMapping hint = attributeMappingsForAttribute.get(0);

			int numberOfHintValues = hintValues.getHintValues(hint).size();

			if (numberOfHintValues == 1) {

				// Exactly one hint value found -> reuse for all
				// instances
				//
				String value = hintValues.getNextHintValue(hint);
				attrHintValues.addAll(IntStream.range(0, expected).mapToObj(i -> value).collect(Collectors.toList()));

			} else if (numberOfHintValues > 0 && numberOfHintValues < expected && expected % numberOfHintValues == 0) {

				// Multiply the hint values to fit the cardinality
				//
				for (int i = 0; i < expected / numberOfHintValues; i++) {
					attrHintValues.addAll(hintValues.getHintValues(hint));
				}

			} else if (numberOfHintValues >= expected) {

				// As many/more hint values found as/than instances
				// -> each instance gets its own hint value
				//
				for (int i = 0; i < expected; i++) {
					// Note: Using '#getNextHintValue' ensures that the correct sub-list of hint values are used even if
					// the same HintValueStorage is used for multiple TargetSectionClasses
					//
					attrHintValues.add(hintValues.getNextHintValue(hint));
				}

			} else {

				// Less hint values found than instances -> This should not happen
				//
				this.logger.severe(() -> "Cardinality mismatch (expected number of hint values: " + expected + ", got :"
						+ numberOfHintValues + ") for " + hint.printInfo()
						+ ". Maybe check Cardinality of Metamodel section?");
				return new ArrayList<>();
			}

			// Multiple AttributeMappings provide (possibly different numbers of) hint values
			//
		} else {

			int numberOfHintValues = attributeMappingsForAttribute.stream()
					.mapToInt(am -> hintValues.getHintValues(am).size()).sum();

			boolean allHintsProvideEqualNumberOfValues = attributeMappingsForAttribute.stream()
					.map(hintValues::getHintValues).collect(Collectors.toSet()).size() == 1;

			if (numberOfHintValues == expected) {

				// Just add all the hint values
				//
				for (AttributeMapping attribtueMapping : attributeMappingsForAttribute) {
					attrHintValues.addAll(hintValues.getHintValues(attribtueMapping));
				}

			} else if (allHintsProvideEqualNumberOfValues && numberOfHintValues > 0 && numberOfHintValues < expected
					&& expected % numberOfHintValues == 0) {

				// Multiply the hint values to fit the cardinality
				//
				for (int i = 0; i < expected / numberOfHintValues; i++) {
					for (AttributeMapping attribtueMapping : attributeMappingsForAttribute) {
						attrHintValues.addAll(hintValues.getHintValues(attribtueMapping));
					}
				}
			} else if (numberOfHintValues >= expected) {

				// As many/more hint values found as/than instances
				// -> each instance gets its own hint value
				//
				for (AttributeMapping attribtueMapping : attributeMappingsForAttribute) {
					attrHintValues.addAll(hintValues.getHintValues(attribtueMapping));
				}
				attrHintValues.subList(expected, attrHintValues.size()).clear();

			} else {

				// Less hint values found than instances -> This should not happen
				//
				this.logger.severe(() -> "Cardinality mismatch (expected number of hint values: " + expected + ", got :"
						+ numberOfHintValues + ") for the following AttributeMappings: "
						+ String.join(", ", attributeMappingsForAttribute.stream().map(MappingHint::printInfo)
								.collect(Collectors.toList()).toArray(new String[] {}))
						+ ".");
				return new ArrayList<>();
			}
		}

		if (attrHintValues.size() < expected) {

			// Less hint values found than instances -> This should not happen
			//
			this.logger.severe(() -> "Cardinality mismatch (expected number of hint values: " + expected + ", got :"
					+ attrHintValues.size() + ") for TargetSectionAttribute " + attribute.getName()
					+ ". Maybe check Cardinality of Metamodel section?");
			return new ArrayList<>();
		}

		if (attribute instanceof ActualTargetSectionAttribute
				&& ((ActualTargetSectionAttribute) attribute).getAttribute().isMany()) {

			// For many-valued attributes, return a multitude of the expected number of values
			//
			return attrHintValues.subList(0, expected * (attrHintValues.size() / expected));

		} else {

			if (attrHintValues.size() / expected > 1) {
				if (attribute instanceof VirtualTargetSectionAttribute) {
					this.logger.severe(() -> "Trying to set multiple values for a VirtualAttribute ('"
							+ attribute.getName() + "'). This is currently not supported!");
				} else if (attribute.isLibraryEntry()) {
					this.logger
							.severe(() -> "Trying to set multiple values for an AttributeParameter of a LibraryEntry ('"
									+ attribute.getContainingSection().getName()
									+ "'). This is currently not supported!");
				} else {
					this.logger.severe(() -> "Trying to set multiple values for an ActualAttribute ('"
							+ attribute.getName() + "') that is based on a single-valued EAttribute!");
				}
			}

			// For single-valued attributes, return exactly as many values as expected
			//
			return attrHintValues.subList(0, expected);
		}
	}

	/**
	 * Returns the current value(s) of the given {@link TargetSectionAttribute} that is/are set in the given
	 * {@link EObjectWrapper}.
	 *
	 * @param instance
	 *            The {@link EObjectWrapper} for that the set value(s) is/are to be returned.
	 * @param attribute
	 *            The {@link TargetSectionAttribute} whose value(s) is/are to be returned.
	 * @return The value(s).
	 */
	private List<String> getCurrentAttributeValues(final EObjectWrapper instance,
			final TargetSectionAttribute attribute) {

		if (!attribute.isLibraryEntry()) {
			return instance.getAttributeValues(attribute);
		}

		// For LibraryEntries, we need to find the value that was set for the appropriate AttributeParameter
		//
		LibraryEntry specificLibEntry = this.targetSectionRegistry.getLibraryEntryRegistry().get(instance)
				.getLibraryEntry();
		LibraryEntry genericLibEntry = (LibraryEntry) attribute.getContainingSection().eContainer().eContainer();

		String currentValue = null;

		int attParamIndex = genericLibEntry.getParameters().indexOf(attribute.eContainer());
		if (attParamIndex >= 0) {
			AttributeParameter attrParam = (AttributeParameter) specificLibEntry.getParameters().get(attParamIndex);
			@SuppressWarnings("unchecked")
			AbstractAttributeParameter<EObject> originalParam = (AbstractAttributeParameter<EObject>) attrParam
					.getOriginalParameter();

			currentValue = originalParam.getNewValue();
		} else {
			if (attribute.equals(genericLibEntry.getId())) {
				currentValue = specificLibEntry.getId().getValue();
			} else if (attribute.equals(genericLibEntry.getClasspath())) {
				currentValue = specificLibEntry.getClasspath().getValue();
			}
		}

		return currentValue == null ? new ArrayList<>() : Arrays.asList(currentValue);
	}

	/**
	 * This instantiates the {@link TargetSectionContainmentReference TargetSectionContainmentReferences} defined by the
	 * given {@link TargetSectionClass}. Therefore, it iterates further downward in the containment hierarchy of the
	 * TargetSection and call
	 * {@link #instantiateTargetSectionFirstPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map, Map)}
	 * .
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} of which the {@link TargetSectionContainmentReference
	 *            TargetSectionContainmentReferences} are to be instantiate.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param createdInstancesByTargetSectionClass
	 *            The registry where created {@link EObjectWrapper instances} shall be stored.
	 * @param instances
	 *            The list of {@link EObjectWrapper instances} that have been created for the given
	 *            {@link TargetSectionClass}. The references need to be created for each of these instances unless they
	 *            are <em>markedForDelete</em>.
	 * @param markedForDelete
	 *            The subset of the given list of <em>instances/<em> that will get deleted in the end due to duplicate
	 *            attribute values that should be unique.
	 * @return The created {@link EObjectWrapper instance}.
	 */
	private boolean instantiateTargetSectionContainmentReferences(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> createdInstancesByTargetSectionClass,
			final List<EObjectWrapper> instances, final List<EObjectWrapper> markedForDelete) {

		// collect all containment references
		//
		List<TargetSectionCompositeReference> containmentReferences = (this.useParallelization
				? targetSectionClass.getAllReferences().parallelStream()
				: targetSectionClass.getAllReferences().stream())
						.filter(ref -> ref instanceof TargetSectionCompositeReference)
						.map(ref -> (TargetSectionCompositeReference) ref).collect(Collectors.toList());

		// recursively instantiate the containment references
		//
		for (final TargetSectionCompositeReference ref : containmentReferences) {

			// Instantiate the referenced TargetSectionClass for each instance
			//
			for (final EObjectWrapper instance : instances) {

				final LinkedList<EObjectWrapper> childInstances = new LinkedList<>();

				for (final TargetSectionClass val : ref.getValue()) {

					final List<EObjectWrapper> children = this.instantiateTargetSectionFirstPass(val, mappingGroup,
							mappingHints, hintValues, createdInstancesByTargetSectionClass);

					if (children != null) { // error? //TODO also delete
						// here?
						childInstances.addAll(children);

					} else {

						this.logger.warning("NoChildren");
						return false;
					}
				}

				// we needed to create the targetSection
				// even though we already knew we didn't want it to be
				// part of the targetModel or else we
				// would get problems with the hintValues
				if (!markedForDelete.contains(instance) && !childInstances.isEmpty()) {

					if (ref.getEReference().getUpperBound() == 1) {

						if (childInstances.size() > 1 && !this.wrongCardinalityContainmentRefs.contains(ref)) {

							this.wrongCardinalityContainmentRefs.add(ref);

							this.logger.severe(() -> "More than one value was supposed to be connected to the "
									+ "TargetSectionContainmentReference '" + ref.getName()
									+ "' in the target section '" + ref.getContainingSection()
									+ "', instantiated by the Mapping '"
									+ ((Mapping) mappingGroup.eContainer()).getName() + "' (Group: '"
									+ mappingGroup.getName() + "'). "
									+ "Only the first instance will be added to the model, the rest will be discarded. "
									+ "Please check your mapping model.");
						}

						instance.getEObject().eSet(ref.getEReference(), childInstances.getFirst().getEObject());
					} else {

						final LinkedList<EObject> childEObjects = new LinkedList<>();

						for (final EObjectWrapper o : childInstances) {
							childEObjects.add(o.getEObject());
						}

						instance.getEObject().eSet(ref.getEReference(), childEObjects);
					}
				}
			}

		}

		return true;
	}

}
