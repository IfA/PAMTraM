package de.mfreund.gentrans.transformation.expanding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.HintValueStorage;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.registries.AttributeValueRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvedAdapter;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy.AmbiguityResolvingException;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionReference;

/**
 * Class for instantiating target model sections using the hints supplied by
 * {@link MappingInstanceStorage MappingInstanceStorages}.
 *
 * @author mfreund
 */
public class TargetSectionInstantiator extends CancelableElement {

	private static final String RESOLVE_INSTANTIATING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";

	private static final String RESOLVE_INSTANTIATING_AMBIGUITY_STARTED = "[Ambiguity] Resolve expanding ambiguity...";

	/**
	 * TargetSectionContainmentReferences that point to a EReference with an
	 * upporBound of 1 but at one point more than one element was supposed to be
	 * connected with them
	 */
	private final Set<TargetSectionContainmentReference> wrongCardinalityContainmentRefs;

	/**
	 * target section registry used when instantiating classes
	 */
	private final TargetSectionRegistry targetSectionRegistry;

	/**
	 * used when setting attribute values
	 */
	private final AttributeValueRegistry attributeValueRegistry;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	private final Logger logger;

	/**
	 * This relates temporarily created elements for LibraryEntries (represented by an {@link EObjectWrapper}) to
	 * their {@link LibraryEntryInstantiator}.
	 */
	private Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap;

	/**
	 * An instance of {@link AttributeValueCalculator} that is used to calculate attribute values.
	 */
	private AttributeValueCalculator calculator;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to
	 * resolve ambiguities that arise during the execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * This creates an instance.
	 *
	 * @param targetSectionRegistry
	 *            target section registry used when instantiating classes
	 * @param attributeValueRegistry
	 *            used when setting attribute values
	 * @param globalValueMap
	 *            Registry for values of global Variables
	 * @param attributeValuemodifier
	 *            An instance of the {@link AttributeValueModifierExecutor}.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param ambiguityResolvingStrategy
	 *            The {@link IAmbiguityResolvingStrategy} that shall be used to resolve occurring ambiguities.
	 */
	public TargetSectionInstantiator(
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueRegistry attributeValueRegistry,
			final GlobalValueMap globalValueMap,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final Logger logger,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		this.targetSectionRegistry = targetSectionRegistry;
		this.attributeValueRegistry = attributeValueRegistry;
		this.logger = logger;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.canceled = false;
		this.wrongCardinalityContainmentRefs = new HashSet<>();
		this.libEntryInstantiatorMap = new HashMap<>();

		this.calculator = new AttributeValueCalculator(globalValueMap, attributeValuemodifier, logger);

		logger.fine("...parsing done!");
	}

	/**
	 * This expands the {@link TargetSection TargetSections} represented by the
	 * <em>hintGroups</em> of the given {@link MappingInstanceStorage}.
	 * <p />
	 * Created {@link EObjectWrapper instances} are
	 * {@link MappingInstanceStorage#addInstances(InstantiableMappingHintGroup, TargetSectionClass, java.util.Collection)
	 * registered} in the given <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to expand.
	 */
	public void expandTargetSectionInstance(MappingInstanceStorage mappingInstance) {

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
	 * This expands the given {@link TargetSection} represented by the given
	 * <em>hintGroup</em> for the given {@link MappingInstanceStorage} by
	 * redirecting to
	 * {@link TargetSectionInstantiator#instantiateTargetSectionFirstPass(TargetSection, InstantiableMappingHintGroup, List, HintValueStorage)}.
	 * <p />
	 * Created {@link EObjectWrapper instances} are
	 * {@link MappingInstanceStorage#addInstances(InstantiableMappingHintGroup, TargetSectionClass, java.util.Collection)
	 * registered} in the given <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to expand.
	 * @param hintGroup
	 *            The {@link MappingHintGroup} that lead to the instantiation of
	 *            the given <em>mappingInstance</em>.
	 */
	private void expandTargetSectionInstance(final MappingInstanceStorage mappingInstance,
			MappingHintGroup hintGroup) {

		final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection =
				this.instantiateTargetSectionFirstPass(
						hintGroup.getTargetSection(),
						hintGroup, mappingInstance.getMappingHints(hintGroup),
						mappingInstance.getHintValues());

		if (instancesBySection == null) {
			if (hintGroup.getTargetSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error

				this.logger
				.severe("Error instantiating target section '"
						+ hintGroup.getTargetSection().getName()
						+ "' using mapping rule '"
						+ mappingInstance.getMapping().getName()
						+ "'");
			}
		} else {

			// Register the created instance
			//
			instancesBySection.entrySet().stream().forEach(
					entry -> mappingInstance.addInstances(hintGroup, entry.getKey(), entry.getValue()));
		}
	}

	/**
	 * This expands the given {@link TargetSection} represented by the given
	 * <em>hintGroup</em> for the given {@link MappingInstanceStorage} by
	 * redirecting to
	 * {@link TargetSectionInstantiator#instantiateTargetSectionFirstPass(TargetSection, InstantiableMappingHintGroup, List, HintValueStorage)}.
	 * <p />
	 * Created {@link EObjectWrapper instances} are
	 * {@link MappingInstanceStorage#addInstances(InstantiableMappingHintGroup, TargetSectionClass, java.util.Collection)
	 * registered} in the given <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to expand.
	 * @param mappingHintGroupImporter
	 *            The {@link MappingHintGroupImporter} that lead to the
	 *            instantiation of the given <em>mappingInstance</em>.
	 */
	private void expandTargetSectionInstance(final MappingInstanceStorage mappingInstance,
			MappingHintGroupImporter mappingHintGroupImporter) {

		final List<MappingHint> hints = this.getMappingHints(mappingInstance, mappingHintGroupImporter);

		final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection =
				this.instantiateTargetSectionFirstPass(mappingHintGroupImporter.getHintGroup().getTargetSection(), mappingHintGroupImporter, hints,
						mappingInstance.getHintValues());

		if (instancesBySection == null) {
			if (mappingHintGroupImporter.getHintGroup().getTargetSection()
					.getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
				this.logger.severe(
						"Error instantiating target section '"
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
	 * From the given list of {@link MappingHint MappingHints} and the
	 * given {@link HintValueStorage hint values}, find one attribute mapping that
	 * determines the cardinality of the given {@link TargetSectionClass}.
	 * <p />
	 * Note: This function iterates downward in the containment hierarchy of the {@link TargetSection}.
	 * Thereby, the <em>oldSelectedHint</em> is taken into account and only
	 * attribute mappings that result in a higher cardinality than the one already determined are considered.
	 *
	 * @param targetSectionClass The {@link TargetSectionClass} for that the cardinality shall be determined.
	 * @param hints The list of {@link MappingHint MappingHints} to be considered.
	 * @param hintValues The {@link HintValueStorage} for the current TargetSection containing all extracted
	 * hint values.
	 * @param oldSelectedHint The {@link AttributeMapping} that was previously determined as
	 * 'cardinality-defining'.
	 * @return The {@link AttributeMapping} that determines the cardinality or <em>null</em> if no
	 * AttributeMapping could be determined that would produce a higher cardinality than the one produced by
	 * the '<em>oldSelectedHint</em>'.
	 */
	private static AttributeMapping searchAttributeMapping(
			final TargetSectionClass targetSectionClass,
			final Collection<MappingHint> hints,
			final HintValueStorage hintValues,
			final AttributeMapping oldSelectedHint) {

		AttributeMapping selectedHint = oldSelectedHint;

		// check attributes
		for (final TargetSectionAttribute attr : targetSectionClass.getAttributes()) {

			for (final MappingHint hint : hints) {
				if (hint instanceof AttributeMapping && ((AttributeMapping) hint).getTarget().equals(attr)) {

					if (selectedHint == null || hintValues.getHintValues((AttributeMapping) hint).isEmpty()) {

						if (hintValues.getHintValues((AttributeMapping) hint).isEmpty()) {
							return null;// there needs to be at least one
							// value for each attributeHint
						} else {
							selectedHint = (AttributeMapping) hint;
						}

					} else if (hintValues.getHintValues((AttributeMapping) hint).size() > hintValues.getHintValues(selectedHint).size()) {

						selectedHint = (AttributeMapping) hint;
					}
				}
			}
		}

		// check references
		for (final TargetSectionReference ref : targetSectionClass.getReferences()) {

			for (final TargetSectionClass val : ref.getValuesGeneric()) {
				if (val.getCardinality().equals(CardinalityType.ONE)) {

					final AttributeMapping hint = TargetSectionInstantiator.searchAttributeMapping(val, hints, hintValues, selectedHint);

					if (hint == null && selectedHint != null) {
						return null;
					} else {
						selectedHint = hint;
					}
				}
			}
		}

		return selectedHint;
	}

	/**
	 * Instantiate the given {@link TargetSection} using the specified
	 * {@link HintValueStorage hint values}.
	 * <p />
	 * Note: This constitutes the first pass of the instantiation that only
	 * creates attributes and containment references. Non-containment references
	 * are created during the
	 * {@link #instantiateTargetSectionSecondPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map)
	 * second pass}.
	 *
	 * @param targetSection
	 *            The {@link TargetSection} to instantiate.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the
	 *            TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into
	 *            account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover
	 *            <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @return A map relating created {@link EObjectWrapper instances} to the
	 *         {@link TargetSectionClass} based on which they have been created.
	 */
	private Map<TargetSectionClass, List<EObjectWrapper>> instantiateTargetSectionFirstPass(
			final TargetSection targetSection,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints,
			final HintValueStorage hintValues) {

		// This will be filled as we iterate through the TargetSection and will be returned in the end
		//
		final Map<TargetSectionClass, List<EObjectWrapper>> instBySection = new LinkedHashMap<>();

		/*
		 * Now, perform the first-run instantiation.
		 */
		if (this.instantiateTargetSectionFirstPass(targetSection, mappingGroup,
				mappingHints, hintValues, instBySection,
				new HashMap<EClass, Map<EAttribute, Set<String>>>()) != null) {

			return instBySection;
		} else {
			return null;
		}

	}

	/**
	 * Instantiate the given {@link TargetSectionClass} using the specified
	 * {@link HintValueStorage hint values}.
	 * <p />
	 * Note: This is called recursively as we iterate downward in the containment hierarchy of the
	 * {@link TargetSection} to be instantiated.
	 * Note: Created instances are registered in the <em>createdInstancesByTargetSectionClass</em>.
	 *
	 * @param targetSectionClass The {@link TargetSectionClass} to instantiate.
	 * @param mappingGroup The {@link InstantiableMappingHintGroup} based on which the TargetSection gets
	 * instantiated.
	 * @param mappingHints The list of {@link MappingHint MappingHints} to take into account (in case we are dealing
	 * with an {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 * {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues The {@link HintValueStorage hint values} to take into account.
	 * @param createdInstancesByTargetSectionClass The map where all created {@link EObjectWrapper instances} are
	 * registered.
	 * @param sectionAttributeValues
	 *            These are used to determine if an attribute value was used
	 *            higher up in the section hierarchy.
	 * @return The list of created {@link EObjectWrapper instances} or '<em>null</em>' if an error occurred.
	 */
	private List<EObjectWrapper> instantiateTargetSectionFirstPass(
			final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> createdInstancesByTargetSectionClass,
			final Map<EClass, Map<EAttribute, Set<String>>> sectionAttributeValues) {

		// Determine the cardinality based on Attribute- and CardinalityMappings
		//
		int cardinality = this.determineCardinality(targetSectionClass, mappingGroup, mappingHints, hintValues);

		// Cardinality == 0
		//
		if(cardinality == 0) {

			if(!targetSectionClass.getCardinality().equals(CardinalityType.ZERO_INFINITY)) {

				this.logger.severe("TargetMMSection class '"
						+ targetSectionClass.getName()
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
				i -> this.instantiateTargetSectionClass(targetSectionClass, mappingGroup, mappingHints, hintValues)).collect(Collectors.toList());

		// create attributes
		//
		final List<EObjectWrapper> markedForDelete = this.instantiateTargetSectionAttributes(targetSectionClass,
				mappingGroup, mappingHints, hintValues, sectionAttributeValues, cardinality, instances);

		if (markedForDelete == null) {
			return null;
		}

		// create containment references
		//
		boolean result = this.instantiateTargetSectionContainmentReferences(targetSectionClass, mappingGroup, mappingHints,
				hintValues,
				createdInstancesByTargetSectionClass, sectionAttributeValues, instances, markedForDelete);

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
	 * This determines and returns the cardinality when instantiating the given {@link TargetSectionClass} using the specified
	 * {@link HintValueStorage hint values}, i.e. how many instances of {@link TargetSectionClass} shall be created.
	 * <p />
	 * Therefore, existing {@link AttributeMapping AttributeMappings} and {@link CardinalityMapping CardinalityMappings} are
	 * evaluated based on the given {@link HintValueStorage hint values}.
	 *
	 * @param targetSectionClass The {@link TargetSectionClass} for that the cardinality shall be determined.
	 * @param mappingGroup The {@link InstantiableMappingHintGroup} based on which the TargetSection gets
	 * instantiated.
	 * @param mappingHints The list of {@link MappingHint MappingHints} to take into account for the determination
	 * of the cardinality.
	 * @param hintValues The {@link HintValueStorage hint values} to take into account.
	 * @return The cardinality to be used whne instantiating the given {@link TargetSectionClass}.
	 */
	private int determineCardinality(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues) {

		// This will be returned in the end. We start by assuming a cardinality of '1'.
		//
		int cardinality = 1;

		boolean attrMappingExists = false;
		int cardHintValue = 1;
		boolean cardMappingExists = false;

		/*
		 * check for CardinalityHint
		 */

		// check AttributeMappings
		//
		if(mappingHints.parallelStream().anyMatch(h -> h instanceof AttributeMapping)) {
			attrMappingExists = true;
		}

		// check CardinalityMappings
		//
		List<CardinalityMapping> cardinalityMappings = mappingHints.stream().
				filter(h -> h instanceof CardinalityMapping && ((CardinalityMapping) h).getTarget().equals(targetSectionClass)).
				map(h -> (CardinalityMapping) h).
				collect(Collectors.toList());

		for (CardinalityMapping cardinalityMapping : cardinalityMappings) {

			if (hintValues.getCardinalityMappingHintValues().containsKey(cardinalityMapping) &&
					!hintValues.getHintValues(cardinalityMapping).isEmpty()) {

				final Integer val = hintValues.removeHintValue(cardinalityMapping);
				cardHintValue = val.intValue();
				cardMappingExists = true;

			}
		}

		/*
		 * ignore attribute hints and cardinality hint, if variableCardinality == false
		 */
		if (!targetSectionClass.getCardinality().equals(CardinalityType.ONE)) {

			// check for attribute hint
			boolean hintFound = false;
			if (mappingGroup instanceof MappingHintGroup) {

				final MappingHintGroup mhGrp = (MappingHintGroup) mappingGroup;

				if (mhGrp.getContainerSelector() != null && mhGrp.getTargetSection().equals(targetSectionClass)) {

					hintFound = true;
					cardinality = hintValues.getHintValues(mhGrp.getContainerSelector()).size();
				}
			}

			final AttributeMapping hint = TargetSectionInstantiator.searchAttributeMapping(targetSectionClass,mappingHints, hintValues, null);

			if (hint != null) {// there was an AttributeHint....

				int hintCardinality = hintValues.getHintValues(hint).size();

				/*
				 * Now, we have to check if there are multi-valued attributes that also try
				 * to determine the cardinality.
				 */
				int multiValuedAttributeCardinality = 1;

				for (Map<AttributeMappingSourceInterface, AttributeValueRepresentation> x : hintValues.getHintValues(hint)) {

					for(AttributeValueRepresentation rep : x.values()) {
						if(rep.isMany()) {

							if(multiValuedAttributeCardinality == 1) {
								multiValuedAttributeCardinality = rep.getValues().size();
							} else if(multiValuedAttributeCardinality != rep.getValues().size()) {
								throw new RuntimeException("There are different multi-valued attributes with" +
										" different cardinalities!");
							}
						}
					}
				}

				/*
				 * Check if there are contradictory cardinalities...
				 */
				if(hintCardinality > 1 && multiValuedAttributeCardinality > 1) {

					throw new RuntimeException("Failed to determine an unambiguous cardinality for hint " + hint.getName());

				} else if(multiValuedAttributeCardinality > 1) {
					hintCardinality = multiValuedAttributeCardinality;
				}

				if (hintCardinality > cardinality) {

					cardinality = hintCardinality;
				}

			} else {// no AttributeHint found

				// mc hint found....only go on if there were no attrMappings
				//
				if (hintFound && attrMappingExists) {

					cardinality = 0;
				}

				// no modelConnaectionHint or AttributeMapping found
				// or cardinality is still 1
				// last chance
				if (cardinality <= 1) {

					if(cardMappingExists) {
						cardinality = cardHintValue;

					} else {
						/*
						 * Consult the specified resolving strategy to resolve the ambiguity.
						 */
						try {
							this.logger.fine(TargetSectionInstantiator.RESOLVE_INSTANTIATING_AMBIGUITY_STARTED);
							List<Integer> resolved = this.ambiguityResolvingStrategy.instantiatingSelectCardinality(Arrays.asList((Integer) null), targetSectionClass, mappingGroup);
							if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
								((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
										.instantiatingCardinalitySelected(Arrays.asList((Integer) null),
												resolved.get(0));
							}
							this.logger.fine(TargetSectionInstantiator.RESOLVE_INSTANTIATING_AMBIGUITY_FINISHED);
							if(resolved.get(0) != null) {
								cardinality = resolved.get(0);
							} else {
								cardinality = targetSectionClass.getCardinality() != CardinalityType.ZERO_INFINITY ? 1 : 0;
							}
						} catch (AmbiguityResolvingException e) {

							this.logger.severe(e.getMessage());
							this.canceled = true;
							return 0;
						}
					}
				}

			}
		}

		return cardinality;
	}

	/**
	 * This instantiates the given {@link TargetSectionClass} by creating a new {@link EObject} and
	 * wrapping it in an {@link EObjectWrapper}.
	 * <p />
	 * If the given TargetSectionClass represents a {@link TargetSectionClass#isLibraryEntry() LibraryEntry},
	 * additionally, a new {@link LibraryEntryInstantiator} is created and registered in the
	 * {@link #libEntryInstantiators} and {@link #libEntryInstantiatorMap}.
	 *
	 * @param targetSectionClass The {@link TargetSectionClass} to instantiate.
	 * @param mappingGroup The {@link InstantiableMappingHintGroup} based on which the TargetSection gets
	 * instantiated.
	 * @param mappingHints The list of {@link MappingHint MappingHints} to take into account (in case we are dealing
	 * with an {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 * {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues The {@link HintValueStorage hint values} to take into account.
	 * @return The created {@link EObjectWrapper instance}.
	 */
	private EObjectWrapper instantiateTargetSectionClass(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues) {

		// create the eObject
		final EObject inst = targetSectionClass.getEClass().getEPackage()
				.getEFactoryInstance()
				.create(targetSectionClass.getEClass());

		// create an EObjectTransformationHelper that wraps the eObject and more stuff
		EObjectWrapper instTransformationHelper = new EObjectWrapper(inst, this.attributeValueRegistry);

		/*
		 * If the target section is a library entry, we create a new 'LibraryEntryInstantiator'
		 * that will insert the real library entry at the end.
		 */
		if(targetSectionClass.isLibraryEntry()) {

			/*
			 * As LibraryEntries may get inserted multiple times, we need to create a self-contained copy
			 * of the library entry
			 */
			LibraryEntry originallibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
			ArrayList<EObject> originals = new ArrayList<>();
			originals.add(originallibEntry);
			originals.add(originallibEntry.getOriginalLibraryEntry());
			LibraryEntry clonedLibEntry = (LibraryEntry) EcoreUtil.copyAll(originals).iterator().next();

			LibraryEntryInstantiator instLibraryEntryInstantiator = new LibraryEntryInstantiator(
					clonedLibEntry, instTransformationHelper, mappingGroup, mappingHints, hintValues, this.logger);

			this.libEntryInstantiatorMap.put(instTransformationHelper, instLibraryEntryInstantiator);
		}

		return instTransformationHelper;
	}

	/**
	 * This instantiates the {@link TargetSectionAttribute TargetSectionAttributes} for the given
	 * {@link TargetSectionClass} based on the provided {@link HintValueStorage hint values}.
	 *
	 * @param targetSectionClass The {@link TargetSectionClass} defining the attributes to be instantiated.
	 * @param mappingGroup The {@link InstantiableMappingHintGroup} based on which the TargetSection gets
	 * instantiated.
	 * @param mappingHints The list of {@link MappingHint MappingHints} to take into account (in case we are dealing
	 * with an {@link MappingHintGroupImporter}, this needs to cover <em>local</em> hints as well as
	 * {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues The {@link HintValueStorage hint values} to take into account.
	 * @param sectionAttributeValues These are used to determine if an attribute value was used
	 *            higher up in the section hierarchy.
	 * @param cardinality
	 * @param instances
	 * @return markedForDelete
	 */
	private List<EObjectWrapper> instantiateTargetSectionAttributes(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues, final Map<EClass, Map<EAttribute, Set<String>>> sectionAttributeValues,
			int cardinality, final List<EObjectWrapper> instances) {

		// This keeps track of the instances that need to be deleted due to
		// duplicate attribute values
		// that should be unique; We will return this in the end
		//
		List<EObjectWrapper> markedForDelete = new ArrayList<>();

		/*
		 * we don't need to reference the EObjects, since their order doesn't
		 * change while we are using this
		 */
		final Map<TargetSectionAttribute, List<String>> attributeValues = new HashMap<>();

		EList<TargetSectionAttribute> attributes = targetSectionClass.getAttributes();

		if (targetSectionClass.isLibraryEntry()) {
			// the metamodelsection is a library entry, thus there must not be
			// any attributes as direct children of it
			assert attributes.isEmpty();
			attributes = new BasicEList<>();
			// however, we want to perform the calculation of the values affected by AttributeParameters
			LibraryEntry libEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();

			for (LibraryParameter<?> parameter : libEntry.getParameters()) {
				if (parameter instanceof AttributeParameter) {
					attributes.add(((AttributeParameter) parameter).getAttribute());
				}
			}
		}

		for (final TargetSectionAttribute attr : attributes) {
			attributeValues.put(attr, new LinkedList<String>());

			MappingHint hintFound = null;
			// look for an attribute mapping
			List<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> attrHintValues = null;

			for (final MappingHint hint : mappingHints) {
				if (hint instanceof AttributeMapping) {
					if (((AttributeMapping) hint).getTarget().equals(attr)) {

						hintFound = hint;

						if (hintValues.getHintValues((AttributeMapping) hint).size() == 1) {

							// Exactly one hint value found -> reuse for all
							// instances
							//
							attrHintValues = new LinkedList<>();
							for (int i = 0; i < cardinality; i++) {
								attrHintValues.add(hintValues.getHintValues((AttributeMapping) hint).getFirst());
							}
							break;

						} else if (hintValues.getHintValues((AttributeMapping) hint).size() >= cardinality) {

							// As many/more hint values found as/than instances
							// -> each instance gets its own hint value
							//
							attrHintValues = hintValues.getHintValues((AttributeMapping) hint);
							break;

						} else {

							// Less hint values found than instance -> This
							// should not happen
							//
							this.logger.severe("Cardinality mismatch (expected: " + cardinality + ", got :"
									+ hintValues.getHintValues((AttributeMapping) hint).size() + "): " + hint.getName()
									+ " for Mapping " + ((Mapping) mappingGroup.eContainer()).getName() + " (Group: "
									+ mappingGroup.getName() + ") Maybe check Cardinality of Metamodel section?");
							return null;
						}
					}
				}
			}

			// Create and store the hint values (they will be set later on
			// after we have check for duplicates)
			//
			for(int i=0; i<instances.size(); i++) {

				EObjectWrapper instance = instances.get(i);
				String attrValue = this.calculator.calculateAttributeValue(attr, hintFound, attrHintValues);

				if(attrValue == null) {
					/*
					 * Consult the specified resolving strategy to resolve the ambiguity.
					 */
					try {
						this.logger.fine("[Ambiguity] Resolve expanding ambiguity...");
						List<String> resolved = this.ambiguityResolvingStrategy.instantiatingSelectAttributeValue(Arrays.asList((String) null), attr, instance.getEObject());
						if (this.ambiguityResolvingStrategy instanceof IAmbiguityResolvedAdapter) {
							((IAmbiguityResolvedAdapter) this.ambiguityResolvingStrategy)
							.instantiatingAttributeValueSelected(Arrays.asList((String) null), resolved.get(0));
						}
						this.logger.fine("[Ambiguity] ...finished.\n");
						attrValue = resolved.get(0);
					} catch (AmbiguityResolvingException e) {
						this.logger.severe(e.getMessage());
						this.canceled = true;
						return null;
					}
				}

				// Check if value is unique and was already used, mark
				// instance for deletion if necessary
				boolean attrValUsedInSection = false;
				if (!sectionAttributeValues.containsKey(targetSectionClass.getEClass())) {

					sectionAttributeValues.put(
							targetSectionClass.getEClass(),
							new HashMap<EAttribute, Set<String>>());

				}

				final Map<EAttribute, Set<String>> secAttrValsForEClass = sectionAttributeValues
						.get(targetSectionClass.getEClass());

				if (attr instanceof ActualAttribute) {

					final EAttribute eAttr = ((ActualAttribute<?, ?, ?, ?>) attr).getAttribute();

					if (!secAttrValsForEClass.containsKey(eAttr)) {
						secAttrValsForEClass.put(eAttr, new HashSet<String>());
					} else {
						attrValUsedInSection = secAttrValsForEClass.get(eAttr).contains(attrValue);
					}

					secAttrValsForEClass.get(eAttr).add(attrValue);

				}
				if (attr.isUnique()
						&& (instance.attributeValueExists(attr, attrValue)
								|| attributeValues.get(attr).contains(attrValue) || attrValUsedInSection)) {

					/*
					 * we can only delete this at the end, or else the
					 * attributeHint values won't fit anymore
					 */
					markedForDelete.add(instance);

				}

				// save attr value in Map
				attributeValues.get(attr).add(attrValue);

			}
		}

		/*
		 * Now that we know which instances will be deleted we set (and
		 * register) the actual attribute values of the instances that will
		 * not get deleted
		 */
		for (final EObjectWrapper instance : instances) {

			final boolean noDelete = !markedForDelete.contains(instance);

			for (final TargetSectionAttribute attr : attributeValues.keySet()) {

				if (noDelete) {

					final String setValue = attributeValues.get(attr).remove(0);

					try {

						// finally, we can set the value of the attribute
						if(!targetSectionClass.isLibraryEntry()) {
							/*
							 * setting an Attribute causes the value to be saved
							 * in the attribute value registry
							 */
							instance.setAttributeValue(attr, setValue);
						} else {
							/*
							 * for library entries, we cannot simply set the value as the attribute we are handling is not part of the targetSectionClass;
							 * instead we want to specify the value as 'new value' for the affected AttributeParameter
							 */
							LibraryEntry specificLibEntry = this.libEntryInstantiatorMap.get(instance).getLibraryEntry();
							LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
							AttributeParameter attrParam = (AttributeParameter) specificLibEntry.getParameters().get(genericLibEntry.getParameters().indexOf(attr.eContainer()));
							@SuppressWarnings("unchecked")
							AbstractAttributeParameter<EObject> originalParam = (AbstractAttributeParameter<EObject>) attrParam.getOriginalParameter();
							originalParam.setNewValue(setValue);
						}


					} catch (final IllegalArgumentException e) {
						this.logger.severe("Could not set Attribute " + attr.getName() + " of target section Class "
								+ targetSectionClass.getName() + " in target section " + targetSectionClass.getContainingSection()
								.getName() + ".\nThe problematic value was: '" + setValue + "'.");
					}

				} else {
					attributeValues.get(attr).remove(0);
				}
			}

		}

		return markedForDelete;
	}

	/**
	 * This instantiates the {@link TargetSectionContainmentReference
	 * TargetSectionContainmentReferences} defined by the given
	 * {@link TargetSectionClass}. Therefore, it iterates further downward in
	 * the containment hierarchy of the TargetSection and call
	 * {@link #instantiateTargetSectionFirstPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map, Map)}
	 * .
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} of which the
	 *            {@link TargetSectionContainmentReference
	 *            TargetSectionContainmentReferences} are to be instantiate.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the
	 *            TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into
	 *            account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover
	 *            <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param createdInstancesByTargetSectionClass
	 *            The registry where created {@link EObjectWrapper instances}
	 *            shall be stored.
	 * @param sectionAttributeValues
	 *            These are used to determine if an attribute value was used
	 *            higher up in the section hierarchy.
	 * @param instances
	 *            The list of {@link EObjectWrapper instances} that have been
	 *            created for the given {@link TargetSectionClass}. The
	 *            references need to be created for each of these instances
	 *            unless they are <em>markedForDelete</em>.
	 * @param markedForDelete
	 *            The subset of the given list of <em>instances/<em> that will
	 *            get deleted in the end due to duplicate attribute values that
	 *            should be unique.
	 * @return The created {@link EObjectWrapper instance}.
	 */
	private boolean instantiateTargetSectionContainmentReferences(final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup, final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> createdInstancesByTargetSectionClass,
			final Map<EClass, Map<EAttribute, Set<String>>> sectionAttributeValues,
			final List<EObjectWrapper> instances, final List<EObjectWrapper> markedForDelete) {

		// collect all containment references
		//
		List<TargetSectionContainmentReference> containmentReferences = targetSectionClass.getReferences()
				.parallelStream().filter(ref -> ref instanceof TargetSectionContainmentReference)
				.map(ref -> (TargetSectionContainmentReference) ref).collect(Collectors.toList());

		// recursively instantiate the containment references
		//
		for (final TargetSectionContainmentReference ref : containmentReferences) {

			// Instantiate the referenced TargetSectionClass for each instance
			//
			for (final EObjectWrapper instance : instances) {

				final LinkedList<EObjectWrapper> childInstances = new LinkedList<>();

				for (final TargetSectionClass val : ref.getValue()) {

					final List<EObjectWrapper> children = this.instantiateTargetSectionFirstPass(
							val, mappingGroup, mappingHints,
							hintValues, createdInstancesByTargetSectionClass,
							sectionAttributeValues);

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

						if (childInstances.size() > 1
								&& !this.wrongCardinalityContainmentRefs.contains(ref)) {

							this.wrongCardinalityContainmentRefs.add(ref);

							this.logger.severe("More than one value was supposed to be connected to the "
									+ "TargetSectionContainmentReference '"
									+ ref.getName()
									+ "' in the target section '"
									+ ref.getContainingSection()
									+ "', instantiated by the Mapping '"
									+ ((Mapping) mappingGroup.eContainer()).getName()
									+ "' (Group: '"
									+ mappingGroup.getName()
									+ "'). "
									+ "Only the first instance will be added to the model, the rest will be discarded. "
									+ "Please check your mapping model.");
						}

						instance.getEObject().eSet(ref.getEReference(),
								childInstances.getFirst().getEObject());
					} else {

						final LinkedList<EObject> childEObjects = new LinkedList<>();

						for (final EObjectWrapper o : childInstances) {
							childEObjects.add(o.getEObject());
						}

						instance.getEObject().eSet(ref.getEReference(),
								childEObjects);
					}
				}
			}

		}

		return true;
	}

	/**
	 * For the given {@link MappingHintGroupImporter}, this collects the
	 * <em>local</em> hints as well as the imported hints from the referenced
	 * {@link ExportedMappingHintGroup} for the given
	 * {@link MappingInstanceStorage mapping instance}.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} for that imported hints
	 *            shall be returned.
	 * @param hintGroupImporter
	 *            The {@link MappingHintGroupImporter} to handle.
	 * @return The imported {@link MappingHint MappingHints}.
	 */
	private List<MappingHint> getMappingHints(final MappingInstanceStorage mappingInstance,
			final MappingHintGroupImporter hintGroupImporter) {

		final ExportedMappingHintGroup exportedHintGroup = hintGroupImporter.getHintGroup();

		final List<MappingHint> hints = mappingInstance.getMappingHints(hintGroupImporter).parallelStream().filter(
				hint -> hint instanceof MappingHint).map(hint -> (MappingHint) hint).collect(Collectors.toList());

		hints.addAll(exportedHintGroup.getMappingHints());

		return hints;
	}

	/**
	 * This is the getter for the {@link #libEntryInstantiatorMap}.
	 *
	 * @return The temporarily created elements for LibraryEntries (represented by an {@link EObjectWrapper}) and
	 * their {@link LibraryEntryInstantiator}.
	 */
	public Map<EObjectWrapper, LibraryEntryInstantiator> getLibEntryInstantiatorMap() {
		return this.libEntryInstantiatorMap;
	}

}
