package de.mfreund.gentrans.transformation.instantiating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.console.MessageConsoleStream;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.registries.AttributeValueRegistry;
import de.mfreund.gentrans.transformation.registries.HintValueStorage;
import de.mfreund.gentrans.transformation.registries.TargetModelRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancellableElement;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.AttributeParameter;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.util.GenLibraryManager;

/**
 * Class for instantiating target model sections using the hints supplied by
 * {@link MappingInstanceStorage MappingInstanceStorages}.
 *
 * @author mfreund
 */
public class TargetSectionInstantiator extends CancellableElement {

	private static final String RESOLVE_EXPANDING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";

	private static final String RESOLVE_EXPANDING_AMBIGUITY_STARTED = "[Ambiguity] Resolve expanding ambiguity...";

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
	 * used to write console output
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * List of {@link LibraryEntryInstantiator}s that are to be used at the end of the
	 * transformation.
	 */
	private List<LibraryEntryInstantiator> libEntryInstantiators;

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
	 * @param globalVarValues
	 *            Registry for values of global Variables
	 * @param attributeValuemodifier An instance of the {@link AttributeValueModifierExecutor}.
	 * @param globalVals A list of {@link FixedValue GlobalValues}.
	 * @param consoleStream
	 *            used to write console output
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used
	 * to resolve occurring ambiguities.
	 */
	public TargetSectionInstantiator(
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueRegistry attributeValueRegistry,
			final Map<GlobalAttribute, String> globalVarValues,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final List<FixedValue> globalVals,
			final MessageConsoleStream consoleStream,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		this.targetSectionRegistry = targetSectionRegistry;
		this.attributeValueRegistry = attributeValueRegistry;
		this.consoleStream = consoleStream;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.canceled = false;
		this.wrongCardinalityContainmentRefs = new HashSet<>();
		this.libEntryInstantiators = new ArrayList<>();
		this.libEntryInstantiatorMap = new HashMap<>();

		Map<String, String> globalValues = new HashMap<>();

		// add GlobalAttributes
		globalValues.putAll(globalVarValues.entrySet().stream().collect(
				Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue())));

		// add GlobalValues
		//
		globalValues.putAll(globalVals.stream().filter(g -> g.getName() != null).collect(
				Collectors.toMap(FixedValue::getName, FixedValue::getValue)));

		/*
		 * only use global values that represent doubles
		 */
		Map<String, Double> globalDoubleValues = new HashMap<>();
		globalValues.entrySet().stream().forEach(globalValueEntry -> {

			try {
				/*
				 * We make use of the ExpressionBuilder as 'String.valueOf(double)' doesn't support
				 * scientific notation, like: 0.42e2 == 4200e-2 == 42
				 */
				final Calculable calc = new ExpressionBuilder(globalValueEntry.getValue()).build();
				globalDoubleValues.put(globalValueEntry.getKey(), calc.calculate());
			} catch (final Exception e) {}
		});

		calculator = new AttributeValueCalculator(globalDoubleValues, attributeValuemodifier, consoleStream);

		consoleStream.println("...parsing done!");
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
		.filter(g -> g.getTargetMMSection() != null && g instanceof MappingHintGroup)
		.map(g -> (MappingHintGroup) g).forEach(g -> expandTargetSectionInstance(mappingInstance, g));

		/*
		 * Iterate over all imported mapping hint groups and expand them
		 */
		// TODO check if we can parallelize this
		mappingInstance.getMappingHintGroupImporters().stream()
		.filter(g -> g.getHintGroup() != null && g.getHintGroup().getTargetMMSection() != null)
		.forEach(g -> expandTargetSectionInstance(mappingInstance, g));
		
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
				instantiateTargetSectionFirstPass(
						hintGroup.getTargetMMSection(),
						hintGroup, mappingInstance.getMappingHints(hintGroup),
						mappingInstance.getHintValues());
	
		if (instancesBySection == null) {
			if (hintGroup.getTargetMMSection().getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
	
				consoleStream
				.println("Error instantiating target section '"
						+ hintGroup.getTargetMMSection().getName()
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
	
		final List<MappingHint> hints = getMappingHints(mappingInstance, mappingHintGroupImporter);
	
		final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection = 
				instantiateTargetSectionFirstPass(mappingHintGroupImporter.getHintGroup().getTargetMMSection(), mappingHintGroupImporter, hints,
						mappingInstance.getHintValues());
	
		if (instancesBySection == null) {
			if (mappingHintGroupImporter.getHintGroup().getTargetMMSection()
					.getCardinality() != CardinalityType.ZERO_INFINITY) {// Error
				consoleStream.println(
						"Error instantiating target section '"
								+ mappingHintGroupImporter.getHintGroup().getTargetMMSection().getName()
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

					final AttributeMapping hint = searchAttributeMapping(val, hints, hintValues, selectedHint);

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
	 * This creates a link from the given {@link EObject source element} to the given {@link EObject target element}
	 * via the non-containment reference specified by the given {@link TargetSectionNonContainmentReference}.
	 *
	 * @param ref The {@link TargetSectionNonContainmentReference} that specifies the {@link EReference} to be used
	 * to create the link.
	 * @param target The {@link EObject} to be linked to the <em>source</em> via the given reference.
	 * @param source The {@link EObject} being the source of the link to be created.
	 */
	private void addValueToReference(
			final TargetSectionNonContainmentReference ref,
			final EObject target, final EObject source) {

		if (ref.getEReference().getUpperBound() == 1) {
			if (source.eIsSet(ref.getEReference())) {

				consoleStream.println("More than one value was supposed to be connected to the TargetSectionNonContainmentReference '"
						+ ref.getName()
						+ "' in the target section '"
						+ ref.getContainingSection()
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
	 * This creates a link from the given {@link EObject source element} to the given list of {@link EObject target elements}
	 * via the non-containment reference specified by the given {@link TargetSectionNonContainmentReference}.
	 *
	 * @param ref The {@link TargetSectionNonContainmentReference} that specifies the {@link EReference} to be used
	 * to create the link.
	 * @param targets The {@link EObject EObjects} to be linked to the <em>source</em> via the given reference.
	 * @param source The {@link EObject} being the source of the link to be created.
	 */
	private void addValuesToReference(
			final TargetSectionNonContainmentReference ref,
			final List<EObject> targets, final EObject source) {

		if (ref.getEReference().getUpperBound() == 1) {
			if(targets.size() > 1) {

				consoleStream.println("More than one value was supposed to be connected to the TargetSectionNonContainmentReference '"
						+ ref.getName()
						+ "' in the target section '"
						+ ref.getContainingSection()
						+ "Please check your mapping model.");
			} else {

				addValueToReference(ref, targets.get(0), source);
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
		if (instantiateTargetSectionFirstPass(targetSection, mappingGroup,
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
		int cardinality = determineCardinality(targetSectionClass, mappingGroup, mappingHints, hintValues);

		// Cardinality == 0
		//
		if(cardinality == 0) {

			if(!targetSectionClass.getCardinality().equals(CardinalityType.ZERO_INFINITY)) {

				consoleStream.println("TargetMMSection class '"
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
				i -> instantiateTargetSectionClass(targetSectionClass, mappingGroup, mappingHints, hintValues)).collect(Collectors.toList());

		// create attributes
		//
		final List<EObjectWrapper> markedForDelete = instantiateTargetSectionAttributes(targetSectionClass,
				mappingGroup, mappingHints, hintValues, sectionAttributeValues, cardinality, instances);

		if (markedForDelete == null) {
			return null;
		}

		// create containment references
		//
		boolean result = instantiateTargetSectionContainmentReferences(targetSectionClass, mappingGroup, mappingHints,
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
			targetSectionRegistry.addClassInstance(instance, mappingGroup, targetSectionClass);
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

				if (mhGrp.getModelConnectionMatcher() != null && mhGrp.getTargetMMSection().equals(targetSectionClass)) {

					hintFound = true;
					cardinality = hintValues.getHintValues(mhGrp.getModelConnectionMatcher()).size();
				}
			}

			final AttributeMapping hint = searchAttributeMapping(targetSectionClass,mappingHints, hintValues, null);

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
							consoleStream.println(RESOLVE_EXPANDING_AMBIGUITY_STARTED);
							List<Integer> resolved = ambiguityResolvingStrategy.expandingSelectCardinality(Arrays.asList((Integer) null), targetSectionClass, mappingGroup);
							consoleStream.println(RESOLVE_EXPANDING_AMBIGUITY_FINISHED);
							if(resolved.get(0) != null) {
								cardinality = resolved.get(0);
							} else {
								cardinality = targetSectionClass.getCardinality() != CardinalityType.ZERO_INFINITY ? 1 : 0;									
							}
						} catch (Exception e) {

							consoleStream.println(e.getMessage());
							canceled = true;
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
		EObjectWrapper instTransformationHelper = new EObjectWrapper(inst, attributeValueRegistry);

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
					clonedLibEntry, instTransformationHelper, mappingGroup, mappingHints, hintValues, consoleStream);

			libEntryInstantiators.add(instLibraryEntryInstantiator);
			libEntryInstantiatorMap.put(instTransformationHelper, instLibraryEntryInstantiator);
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
							consoleStream.println("Cardinality mismatch (expected: " + cardinality + ", got :"
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
				String attrValue = calculator.calculateAttributeValue(attr, hintFound, attrHintValues);

				if(attrValue == null) {
					/*
					 * Consult the specified resolving strategy to resolve the ambiguity.				
					 */
					try {
						consoleStream.println("[Ambiguity] Resolve expanding ambiguity...");
						List<String> resolved = ambiguityResolvingStrategy.expandingSelectAttributeValue(Arrays.asList((String) null), attr, instance.getEObject());
						consoleStream.println("[Ambiguity] ...finished.\n");
						attrValue = resolved.get(0);
					} catch (Exception e) {
						consoleStream.println(e.getMessage());
						canceled = true;
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

					final EAttribute eAttr = ((ActualAttribute) attr).getAttribute();

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
							LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(instance).getLibraryEntry();
							LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
							AttributeParameter attrParam = (AttributeParameter) specificLibEntry.getParameters().get(genericLibEntry.getParameters().indexOf(attr.eContainer()));
							@SuppressWarnings("unchecked")
							AbstractAttributeParameter<EObject> originalParam = (AbstractAttributeParameter<EObject>) attrParam.getOriginalParameter();
							originalParam.setNewValue(setValue);
						}


					} catch (final IllegalArgumentException e) {
						consoleStream.println("Could not set Attribute " + attr.getName() + " of target section Class "
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

					final List<EObjectWrapper> children = instantiateTargetSectionFirstPass(
							val, mappingGroup, mappingHints,
							hintValues, createdInstancesByTargetSectionClass,
							sectionAttributeValues);

					if (children != null) { // error? //TODO also delete
						// here?
						childInstances.addAll(children);

					} else {

						consoleStream.println("NoChildren");
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
								&& !wrongCardinalityContainmentRefs.contains(ref)) {

							wrongCardinalityContainmentRefs.add(ref);

							consoleStream.println("More than one value was supposed to be connected to the "
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
	 * Instantiate the given {@link TargetSection} using the specified
	 * {@link HintValueStorage hint values}.
	 * <p />
	 * Note: This constitutes the second pass of the instantiation that creates
	 * non-containment references.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} to instantiate.
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
	 * @param instancesBySection
	 *            The registry for {@link EObjectWrapper instances} created
	 *            during the first pass of the instantiation.
	 */
	public void instantiateTargetSectionSecondPass(
			final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection) {

		/*
		 * only go on if any instances of this section were created
		 */
		if (instancesBySection.get(targetSectionClass) == null) {
			return;
		}

		EList<TargetSectionReference> references = targetSectionClass.getReferences();

		if (targetSectionClass.isLibraryEntry()) {
			// the target section class is part of a library entry, thus
			// there must not be any references as direct children of it
			references = new BasicEList<>();
			// however, we want to perform the linking for the references
			// affected by ExternalReferenceParameters
			LibraryEntry libEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();

			for (LibraryParameter<?> parameter : libEntry.getParameters()) {
				if (parameter instanceof ExternalReferenceParameter) {
					references.add(((ExternalReferenceParameter) parameter).getReference());
				}
			}
		}

		List<TargetSectionNonContainmentReference> nonContainmentReferences = references.parallelStream()
				.filter(ref -> ref instanceof TargetSectionNonContainmentReference)
				.map(ref -> (TargetSectionNonContainmentReference) ref).collect(Collectors.toList());

		for (final TargetSectionNonContainmentReference ref : nonContainmentReferences) {

			final LinkedList<TargetSectionClass> refValueClone = new LinkedList<>();
			refValueClone.addAll(ref.getValue());

			boolean hintFound = false;

			// Collect MappingInstanceSelectors that affect the current reference
			//
			List<MappingInstanceSelector> mappingInstanceSelectorsToConcider = mappingHints.parallelStream()
					.filter(h -> h instanceof MappingInstanceSelector
							&& ((MappingInstanceSelector) h).getAffectedReference().equals(ref))
					.map(h -> (MappingInstanceSelector) h).collect(Collectors.toList());

			// search for mapping instance selector
			for (MappingInstanceSelector h : mappingInstanceSelectorsToConcider) {

				/*
				 * handle AttributeMatcher
				 */
				if (h.getMatcher() instanceof AttributeMatcher) {

					final AttributeMatcher matcher = (AttributeMatcher) h.getMatcher();

					hintFound = true;
					// now search for target attributes
					final List<EObjectWrapper> targetInstances = targetSectionRegistry
							.getFlattenedPamtramClassInstances(matcher.getTargetAttribute().getOwningClass());

					// instances are sorted in the same order as
					// hintValues
					final LinkedList<EObjectWrapper> instancesToConsider = new LinkedList<>();
					instancesToConsider.addAll(instancesBySection.get(targetSectionClass));
					/*
					 * Sizes of instances and attributeHints must either match,
					 * or, in case there was a cardinality mapping, the size of
					 * the hintValues must be 1
					 */
					LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> newHintValues = new LinkedList<>();
					int numberOfInstancesToCreate = 0;
					if (hintValues.getHintValues(h).size() == 1) {

						// one hint value but multiple instances
						// -> clone the single hint value for
						// each instance
						final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hintVal = hintValues
								.getHintValues(h).getFirst();
						for (int i = 0; i < instancesToConsider.size(); i++) {
							newHintValues.add(hintVal);
						}
						numberOfInstancesToCreate = newHintValues.size();
					} else if (instancesToConsider.size() == hintValues.getHintValues(h)
							.size()) {

						// multiple hint values and the same
						// amount of instances -> each hint
						// value is used for one instance
						newHintValues = hintValues.getHintValues(h);
						numberOfInstancesToCreate = newHintValues.size();
					} else if (h.getAffectedReference().getEReference().isMany()
							&& hintValues.getHintValues(h).size()
							% instancesToConsider.size() == 0) {

						// a multiple of hint values for each
						// instance -> use multiple hint values
						// for each instance
						newHintValues = hintValues.getHintValues(h);
						numberOfInstancesToCreate = instancesToConsider.size();
					} else {

						consoleStream.println(
								"There was a size mismatch while trying to set a non-containment reference, using the Hint "
										+ h.getName() + ". There where " + instancesToConsider.size()
										+ " instances to be connected but "
										+ hintValues.getHintValues(h).size()
										+ " MappingHint values. The output below"
										+ " shows the hint values and the source instances for the reference:\n"
										+ hintValues.getHintValues(h) + "\n"
										+ instancesToConsider);
					}

					// how many target instances are to be set
					// as value of the non-containment reference
					// of each instance
					final int targetsPerInstance = newHintValues.size() / numberOfInstancesToCreate;

					for (int i = 0; i < numberOfInstancesToCreate; i++) {

						final EObjectWrapper srcInst = instancesToConsider.remove(0);

						for (int j = 0; j < targetsPerInstance; j++) {

							String attrValStr = null;
							if (h.getMatcher() instanceof AttributeMatcher) {
								attrValStr = calculator.calculateAttributeValue(null, h, newHintValues);
							}
							final List<EObjectWrapper> fittingVals = new LinkedList<>();

							for (final EObjectWrapper targetInst : targetInstances) {
								// get Attribute value
								final String targetValStr = targetInst.getAttributeValue(matcher.getTargetAttribute());
								if (targetValStr != null) {
									if (targetValStr.equals(attrValStr)) {
										fittingVals.add(targetInst);
									}
								} else {
									consoleStream.println("Problemo?");
								}
							}
							// select targetInst
							List<EObject> targetInst = new ArrayList<>();
							if (fittingVals.size() == 1) {
								targetInst.add(fittingVals.get(0).getEObject());

							} else if (fittingVals.size() > 1) {

								if (canceled) {
									return;
								}

								/*
								 * Consult the specified resolving strategy to
								 * resolve the ambiguity.
								 */
								try {
									consoleStream.println("[Ambiguity] Resolve linking ambiguity...");
									List<EObjectWrapper> resolved = ambiguityResolvingStrategy
											.linkingSelectTargetInstance(fittingVals,
													h.getAffectedReference(),
													(MappingHintGroupType) mappingGroup, h,
													srcInst);
									consoleStream.println(RESOLVE_EXPANDING_AMBIGUITY_FINISHED);
									if (ref.getEReference().isMany()) {
										for (EObjectWrapper eObjectWrapper : resolved) {
											targetInst.add(eObjectWrapper.getEObject());
										}
									} else {
										targetInst.add(resolved.get(0).getEObject());
									}
								} catch (Exception e) {
									consoleStream.println(e.getMessage());
									cancel();
									return;
								}

							} else {
								consoleStream.println("The MappigInstanceSelector " + h.getName() + " (Mapping: "
										+ ((Mapping) mappingGroup.eContainer()).getName() + ", Group: "
										+ mappingGroup.getName()
										+ " ) has an AttributeMatcher that picked up the value '" + attrValStr
										+ "' to be matched to the "
										+ "TargetAttribute, but no fitting TargetSectionInstance with this value could be found.");

							}

							// finally, we can set the value of
							// the reference
							if (!targetSectionClass.isLibraryEntry()) {
								addValuesToReference(ref, targetInst, srcInst.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(srcInst).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
								ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
										.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
								@SuppressWarnings("unchecked")
								AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
								.getOriginalParameter();
								// library entries do currently
								// not support to set multiple
								// target instances for an
								// ExternalReferenceParameter
								originalParam.setTarget(targetInst.get(0));
							}
						}

					}

					/*
					 * Handle ClassMatcher
					 */
				} else if (h.getMatcher() instanceof ClassMatcher) {

					hintFound = true;

					if (((ClassMatcher) h.getMatcher()).getTargetClass() != null) {// was
						// the
						// matcher
						// modeled
						// correctly?
						if (refValueClone.contains(((ClassMatcher) h.getMatcher()).getTargetClass())) {
							// select any of the targetInstances
							// available for the reference
							// target
							final List<EObjectWrapper> instancesToConsider = instancesBySection.get(targetSectionClass);

							final TargetSectionClass matcherTargetClass = ((ClassMatcher) h.getMatcher())
									.getTargetClass();

							/*
							 * select potential instances globally
							 */
							final List<EObjectWrapper> insts = targetSectionRegistry
									.getFlattenedPamtramClassInstances(matcherTargetClass);

							EObjectWrapper targetInstance = null;
							if (insts.size() == 1) {
								targetInstance = insts.get(0);
							} else if (insts.size() > 1) {
								// Dialog
								if (canceled) {
									return;
								}

								/*
								 * Consult the specified resolving strategy to
								 * resolve the ambiguity.
								 */
								try {
									List<EObjectWrapper> resolved = ambiguityResolvingStrategy
											.linkingSelectTargetInstance(insts,
													h.getAffectedReference(), null,
													h, null);
									targetInstance = resolved.get(0);
								} catch (Exception e) {
									consoleStream.println(e.getMessage());
									cancel();
									return;
								}

							} else {
								consoleStream.println("The MappingInstanceSelector '" + h.getName() + " of Mapping"
										+ ((Mapping) mappingGroup.eContainer()).getName() + "(Group: "
										+ mappingGroup.getName() + ")' has a Matcher that points to the target class "
										+ matcherTargetClass.getName() + " (Section: "
										+ matcherTargetClass.getContainingSection().getName()
										+ "). Sadly, no instances of this Class were created.");
							}

							if (targetInstance != null) {
								for (final EObjectWrapper inst : instancesToConsider) {// same
									// action for every instance of specific
									// mapping
									//
									if (!targetSectionClass.isLibraryEntry()) {
										addValueToReference(ref, targetInstance.getEObject(), inst.getEObject());
									} else {
										/*
										 * for library entries, we cannot simply
										 * add the value as the reference we are
										 * handling is not part of the
										 * targetSectionClass; instead we want
										 * to specify the value as 'target' for
										 * the affected
										 * ExternalReferenceParameter
										 */
										LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(inst)
												.getLibraryEntry();
										LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
												.eContainer();
										ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
												.getParameters()
												.get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
										@SuppressWarnings("unchecked")
										AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
										.getOriginalParameter();
										originalParam.setTarget(targetInstance.getEObject());
									}
								}
							}
						}
					}

				} else {
					consoleStream.println("Matcher of type " + h.getMatcher().eClass().getName() + " in MappingHint "
							+ h.getName() + " is not supported.");
				}

				if (hintFound) {
					break;
				}
			}

			/*
			 * In case no suitable hint could be found we will try the
			 * following:
			 * 
			 * 1.only non-cont ref targets to other subsections of this
			 * targetMMSection are considered, we can resolve the reference if
			 * only one Instance of the ref Target was created in the same
			 * mapping instance
			 * 
			 * if that isn't the case:
			 * 
			 * 2. consider all available instances of the ref target
			 */
			if (!hintFound) { // last chance

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
						 * values the pamtram-reference points to, is part of
						 * the same MappingHintGroup's targetMMSection
						 */
						foundLocalNonContRefTargets.add((TargetSectionClass) next);
						refValue.remove(next);
					}

				}
				/*
				 * only non-cont ref targets to other subsections of this
				 * targetMMSection are considered
				 */
				if (foundLocalNonContRefTargets.size() > 0) {
					// get source instances for the reference
					final LinkedList<EObjectWrapper> sourceInstances = new LinkedList<>();
					sourceInstances.addAll(instancesBySection.get(targetSectionClass));

					// get root instances of groups targetMMSection
					final List<EObjectWrapper> rootInstances = instancesBySection
							.get(mappingGroup.getTargetMMSectionGeneric());

					// get target instances for the reference
					final LinkedList<EObjectWrapper> targetInstances = new LinkedList<>();
					for (final TargetSectionClass section : foundLocalNonContRefTargets) {
						targetInstances.addAll(instancesBySection.get(section));
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
						final List<EObjectWrapper> instances = targetInstancesByRoot
								.get(rootBySourceInstance.get(source));
						if (instances.size() == 1) {
							if (!targetSectionClass.isLibraryEntry()) {
								addValueToReference(ref, instances.get(0).getEObject(), source.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(source).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
								ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
										.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
								@SuppressWarnings("unchecked")
								AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
								.getOriginalParameter();
								originalParam.setTarget(instances.get(0).getEObject());
							}
						} else if (instances.size() > 1) {
							// Dialog
							if (canceled) {
								return;
							}

							/*
							 * Consult the specified resolving strategy to
							 * resolve the ambiguity.
							 */
							List<EObject> targets = new ArrayList<>();
							try {
								List<EObjectWrapper> resolved = ambiguityResolvingStrategy.linkingSelectTargetInstance(
										instances, ref, (MappingHintGroupType) mappingGroup, null, source);
								if (ref.getEReference().isMany()) {
									for (EObjectWrapper eObjectWrapper : resolved) {
										targets.add(eObjectWrapper.getEObject());
									}
								} else {
									targets.add(resolved.get(0).getEObject());
								}
							} catch (Exception e) {
								consoleStream.println(e.getMessage());
								cancel();
								return;
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
								addValuesToReference(ref, targets, source.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(source).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
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
							consoleStream.println("No suitable refernce target found for non-cont. reference '"
									+ ref.getName() + "' of the following instance of target class "
									+ targetSectionClass.getName() + " (Section: "
									+ targetSectionClass.getContainingSection().getName() + ").'\n"
									+ source.toString());
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
						final String classString = v.getName() + " (Section: " + v.getContainingSection().getName()
								+ ")";
						final List<EObjectWrapper> insts = targetSectionRegistry.getFlattenedPamtramClassInstances(v);

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

						if (canceled) {
							return;
						}

						/*
						 * Consult the specified resolving strategy to resolve
						 * the ambiguity.
						 */
						HashMap<TargetSectionClass, List<EObjectWrapper>> choices = new HashMap<>();
						for (TargetSectionClass targetSection : refValueClone) {
							choices.put(targetSection, new ArrayList<>(
									targetSectionRegistry.getFlattenedPamtramClassInstances(targetSection)));
						}
						try {
							consoleStream.println("[Ambiguity] Resolve linking ambiguity...");
							HashMap<TargetSectionClass, List<EObjectWrapper>> resolved = ambiguityResolvingStrategy
									.linkingSelectTargetSectionAndInstance(choices, ref,
											(MappingHintGroupType) mappingGroup);
							consoleStream.println(RESOLVE_EXPANDING_AMBIGUITY_FINISHED);
							if (ref.getEReference().isMany()) {
								targets = new ArrayList<>();
								for (EObjectWrapper eObjectWrapper : resolved.entrySet().iterator().next().getValue()) {
									targets.add(eObjectWrapper.getEObject());
								}
							} else {
								targets = new ArrayList<>(Arrays.asList(
										(resolved.entrySet().iterator().next().getValue().get(0).getEObject())));
							}
						} catch (Exception e) {
							consoleStream.println(e.getMessage());
							cancel();
							return;
						}

					} else {
						consoleStream.println("No suitable hint targets found for non-cont reference '" + ref.getName()
						+ "' of TargetMMSection " + mappingGroup.getTargetMMSectionGeneric().getName()
						+ "(Section: " + targetSectionClass.getName() + ") in Mapping "
						+ ((Mapping) mappingGroup.eContainer()).getName() + "(Group: " + mappingGroup.getName()
						+ ").");
					}

					if (targets != null) {
						for (final EObjectWrapper inst : instancesBySection.get(targetSectionClass)) {
							if (!targetSectionClass.isLibraryEntry()) {
								addValuesToReference(ref, targets, inst.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(inst).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
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

		instantiateTargetSectionSecondPassGoDeeper(targetSectionClass, mappingGroup, mappingHints, hintValues,
				instancesBySection);
	}

	/**
	 * This iterates further downward in the containment hierarchy and calls
	 * {@link #instantiateTargetSectionSecondPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map)}
	 * for every found child {@link TargetSectionClass}.
	 * 
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} from where to iterate further
	 *            downward in the containment hierarchy.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the
	 *            TargetSection gets instantiated.
	 * @param hints
	 *            The list of {@link MappingHint MappingHints} to take into
	 *            account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover
	 *            <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param instancesBySection
	 *            The registry for {@link EObjectWrapper instances} created
	 *            during the first pass of the instantiation.
	 */
	private void instantiateTargetSectionSecondPassGoDeeper(
			final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> hints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection) {

		for (final TargetSectionReference ref : targetSectionClass.getReferences()) {

			if (ref instanceof TargetSectionContainmentReference) {

				for (final TargetSectionClass val : ((TargetSectionContainmentReference) ref).getValue()) {// instantiate
					// targets

					instantiateTargetSectionSecondPass(val, mappingGroup,
							hints, hintValues,
							instancesBySection);

					if (canceled) {
						return;
					}
				}
			}

		}
	}

	/**
	 * Instantiate all library entry-based target sections that have been collected
	 * during {@link #instantiateTargetSectionFirstPass}.
	 * 
	 * @param targetModelRegistry The {@link TargetModelRegistry} representing the target models into that the library entries are 
	 * to be instantiated.
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	public boolean instantiateLibraryEntries(
			TargetModelRegistry targetModelRegistry, LibraryContextDescriptor targetLibraryContextDescriptor) {

		if(libEntryInstantiators.isEmpty()) { // nothing to be done
			return true;
		}

		if(targetLibraryContextDescriptor.getLibraryContextClass() == null) {
			consoleStream.println("Could not instantiate library entries as no target"
					+ " library context class has been specified!");
			return false;
		}

		/*
		 * Create a GenLibraryManager that proxies calls to the LibraryPlugin. 
		 */
		GenLibraryManager manager;
		try {
			manager = new GenLibraryManager(
					targetLibraryContextDescriptor);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			consoleStream.println("Error while instantiatiating library context/parser!");
			return false;
		}

		boolean successful = true;
		/*
		 * Iterate over all stored instantiators and instantiate the associated library entry
		 * in the given target model.
		 */
		for (LibraryEntryInstantiator libraryEntryInstantiator : libEntryInstantiators) {
			if(!libraryEntryInstantiator.instantiate(
					manager, calculator, 
					targetSectionRegistry)) {
				consoleStream.println("Failed to instantiate library entry '" + 
						libraryEntryInstantiator.getLibraryEntry().getPath().getValue() + "'!");
				successful = false;
			}
		}

		return successful;

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

}
