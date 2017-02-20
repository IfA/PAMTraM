package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.HintValueMap;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.FixedValue;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ContainerSelector;
import pamtram.mapping.ContainerSelectorSourceInterface;
import pamtram.mapping.ExpandableHint;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalAttributeImporter;
import pamtram.mapping.HintImporterMappingHint;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.MappedAttributeValuePrepender;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.ReferenceTargetSelector;
import pamtram.structure.GlobalModifiedAttributeElementType;
import pamtram.structure.ModifiedAttributeElementType;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to extract hint values and values of {@link GlobalAttribute GlobalAttributes} from source
 * model elements for a given list of {@link MappingInstanceStorage mapping instances}.
 *
 * @author mfreund
 */
public class HintValueExtractor extends ValueExtractor {

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a
	 * map where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * The list of {@link MappingInstanceStorage MappingInstanceStorages} for that the hint values shall be extracted.
	 */
	private List<MappingInstanceStorage> mappingInstances;

	/**
	 * This keeps track of the {@link MappingInstanceStorage MappingInstanceStorages} representing
	 * {@link ExportedMappingHintGroup ExportedMappingHintGroups}.
	 * <p/>
	 * This is used during {@link #extractImportedHintValues(MappingInstanceStorage)} to import hint values for
	 * {@link MappingHintGroupImporter MappingHintGroupImporters}.
	 */
	private Map<ExportedMappingHintGroup, MappingInstanceStorage> exportedHintGroups;

	/**
	 * This creates an instance for a given list of {@link MappingInstanceStorage mappingInstances}.
	 * <p />
	 * Note: The extracted hint values are stored in the given <em>mappingInstances</em>.
	 *
	 * @param matchingResult
	 *            The result of the <em>matching</em> step.
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceStorage MappingInstanceStorages} for that the hint values shall be
	 *            extracted.
	 * @param globalAttributes
	 *            The values of {@link GlobalAttribute GlobalAttributes} that shall be used by
	 *            {@link #extractValue(GlobalAttributeImporter, MatchedSectionDescriptor)}.
	 * @param attributeValueModifierExecutor
	 *            The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public HintValueExtractor(Map<SourceSection, List<MatchedSectionDescriptor>> matchingResult,
			List<MappingInstanceStorage> mappingInstances, Map<GlobalAttribute, String> globalAttributes,
			AttributeValueModifierExecutor attributeValueModifierExecutor, Logger logger) {

		super(globalAttributes, attributeValueModifierExecutor, logger);

		this.matchedSections = matchingResult;
		this.mappingInstances = mappingInstances;
		this.exportedHintGroups = new HashMap<>();
	}

	/**
	 * This extracts the hint values and stores them in the {@link #mappingInstances}.
	 */
	public void extractHintValues() {

		// In a first step, we extract the hints of 'normal' and exported hint groups.
		//
		this.mappingInstances.parallelStream().forEach(this::extractHintValues);

		// Now, we collect exported hint groups and associated mapping instances
		//
		this.mappingInstances.parallelStream().forEach(m -> m.getMappingHintGroups().parallelStream()
				.filter(hg -> hg instanceof ExportedMappingHintGroup).forEach(hg -> {
					if (this.exportedHintGroups.containsKey(hg)) {
						this.logger.warning("Multiple occurences found for exported hint group '" + hg.getName()
								+ "'! This is currently not supported!");
					}
					this.exportedHintGroups.put((ExportedMappingHintGroup) hg, m);
				}));

		// Now, we extract the hints for hint group importers (as we can now used the
		// hint values of exported hint groups that have been calculated before)
		//
		this.mappingInstances.parallelStream().forEach(this::extractImportedHintValues);
	}

	/**
	 * This extracts the hint values for the given {@link MappingInstanceStorage}.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractHintValues(MappingInstanceStorage mappingInstance) {

		// First, we collect all hints (including a possible ModelConnectionHint)
		//
		List<MappingHintBaseType> mappingHints = new ArrayList<>();
		for (MappingHintGroupType hintGroup : mappingInstance.getMappingHintGroups()) {
			if (hintGroup instanceof MappingHintGroup
					&& ((MappingHintGroup) hintGroup).getContainerSelector() != null) {
				mappingHints.add(((MappingHintGroup) hintGroup).getContainerSelector());
			}
			mappingHints.addAll(hintGroup.getMappingHints());
		}

		// Now, we need to initialize the corresponding maps to store hint values
		// (Note: Using a parallel stream would for whatever reason result in exceptions, so we make use of a sequential
		// stream).
		//
		mappingHints.stream().forEach(hint -> this.initializeHintValueMap(hint, mappingInstance));

		// Now, we can extract the hint values for each hint
		//
		mappingHints.parallelStream().forEach(h -> this.extractHintValue(h, mappingInstance));
	}

	/**
	 * This extracts the hint values of {@link MappingHintGroupImporter MappingHintGroupImporters} for the given
	 * {@link MappingInstanceStorage}.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractImportedHintValues(MappingInstanceStorage mappingInstance) {

		for (MappingHintGroupImporter hintGroupImporter : mappingInstance.getMappingHintGroupImporters()) {

			// First, we copy all imported hint values
			// (Note: Using a parallel stream would for whatever reason result in exceptions, so we make use of a
			// sequential stream).
			//
			ExportedMappingHintGroup exportedHintGroup = hintGroupImporter.getHintGroup();
			MappingInstanceStorage exported = this.exportedHintGroups.get(exportedHintGroup);

			exportedHintGroup.getMappingHints().stream().forEach(hint -> {
				this.initializeHintValueMap(hint, mappingInstance);
				mappingInstance.getHintValues().addHintValues(hint, exported.getHintValues().getHintValuesCloned(hint));
			});

			// Now, we need to initialize the corresponding maps to store values for own hints
			// (Note: Using a parallel stream would for whatever reason result in exceptions, so we make use of a
			// sequential stream).
			//
			hintGroupImporter.getMappingHints().stream()
					.forEach(hint -> this.initializeHintValueMap(hint, mappingInstance));

			// Now, we can extract the hint values for each own hint.
			// (Note: MappedAttributeValueExpanders that change existing values of imported hints are also handled
			// here).
			//
			hintGroupImporter.getMappingHints().parallelStream()
					.forEach(h -> this.extractHintValue(h, mappingInstance));
		}

	}

	/**
	 * This extracts the hint value for the given {@link MappingHintBaseType mapping hint}.
	 * <p />
	 * Note: The extracted hint value is stored in the <em>mappingInstance</em>.
	 *
	 * @param hint
	 *            The {@link MappingHintBaseType} for that the hint values shall be extracted.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} for that the hint values shall be extracted.
	 */
	private void extractHintValue(MappingHintBaseType hint, MappingInstanceStorage mappingInstance) {

		// The MatchedSectionDescriptor for the SourceSection from that we want to extract hint values
		//
		MatchedSectionDescriptor matchedSectionDescriptor = mappingInstance.getMatchedSectionDescriptor();

		Object hintValue = null;

		if (hint instanceof AttributeMapping) {

			hintValue = this.extractHintValue((AttributeMapping) hint, matchedSectionDescriptor);

		} else if (hint instanceof ReferenceTargetSelector) {

			if (((ReferenceTargetSelector) hint).getMatcher() instanceof AttributeMatcher) {

				hintValue = this.extractHintValue((AttributeMatcher) ((ReferenceTargetSelector) hint).getMatcher(),
						matchedSectionDescriptor);
			}

		} else if (hint instanceof ContainerSelector) {

			hintValue = this.extractHintValue((ContainerSelector) hint, matchedSectionDescriptor);

		} else if (hint instanceof CardinalityMapping) {

			hintValue = this.extractHintValue((CardinalityMapping) hint, matchedSectionDescriptor);

		} else if (hint instanceof MappedAttributeValueExpander) {

			hintValue = this.extractHintValue((MappedAttributeValueExpander) hint, matchedSectionDescriptor);

		} else {

			this.logger.severe("Unsupported type of MappingHint found: '" + hint.eClass().getName() + "'!");
		}

		this.storeHintValueConsolidated(hintValue, hint, mappingInstance);

	}

	/**
	 * This extracts and returns the hint value for the given {@link AttributeMapping}.
	 *
	 * @param attributeMapping
	 *            The {@link AttributeMapping} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private Map<AttributeMappingSourceInterface, AttributeValueRepresentation> extractHintValue(
			AttributeMapping attributeMapping, MatchedSectionDescriptor matchedSectionDescriptor) {

		// This keeps track of the extracted hint value parts
		//
		Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();

		// Extract the hint value part based on its type
		//
		for (AttributeMappingSourceInterface attributeMappingSourceInterface : attributeMapping.getSourceElements()) {

			AttributeValueRepresentation attributeValueRepresentation = null;

			if (attributeMappingSourceInterface instanceof GlobalModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(GlobalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMappingSourceInterface,
						this.matchedSections, matchedSectionDescriptor);
			} else if (attributeMappingSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMappingSourceInterface,
						matchedSectionDescriptor);
			} else if (attributeMappingSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = this.extractValue((FixedValue) attributeMappingSourceInterface,
						matchedSectionDescriptor);
			} else if (attributeMappingSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = this.extractValue(
						(GlobalAttributeImporter) attributeMappingSourceInterface, matchedSectionDescriptor);
			} else {
				this.logger.severe("Unsupported type of source element for an AttributeMapping found: '"
						+ attributeMappingSourceInterface.eClass().getName() + "'!");
			}

			if (attributeValueRepresentation != null) {
				hintValue.put(attributeMappingSourceInterface, attributeValueRepresentation);
			}
		}

		return hintValue.isEmpty() ? null : hintValue;
	}

	/**
	 * This extracts and returns the hint value for the given {@link MappingHintBaseType mapping hint}.
	 *
	 * @param attributeMatcher
	 *            The {@link AttributeMatcher} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> extractHintValue(
			AttributeMatcher attributeMatcher, MatchedSectionDescriptor matchedSectionDescriptor) {

		// This keeps track of the extracted hint value parts
		//
		Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();

		// Extract the hint value part based on its type
		//
		for (AttributeMatcherSourceInterface attributeMatcherSourceInterface : attributeMatcher.getSourceElements()) {

			AttributeValueRepresentation attributeValueRepresentation = null;

			if (attributeMatcherSourceInterface instanceof GlobalModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(GlobalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMatcherSourceInterface,
						this.matchedSections, matchedSectionDescriptor);
			} else if (attributeMatcherSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) attributeMatcherSourceInterface,
						matchedSectionDescriptor);
			} else if (attributeMatcherSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = this.extractValue((FixedValue) attributeMatcherSourceInterface,
						matchedSectionDescriptor);
			} else if (attributeMatcherSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = this.extractValue(
						(GlobalAttributeImporter) attributeMatcherSourceInterface, matchedSectionDescriptor);
			} else {
				this.logger.severe("Unsupported type of source element for an AttributeMatcher found: '"
						+ attributeMatcherSourceInterface.eClass().getName() + "'!");
			}

			if (attributeValueRepresentation != null) {
				hintValue.put(attributeMatcherSourceInterface, attributeValueRepresentation);
			}

		}

		return hintValue.isEmpty() ? null : hintValue;
	}

	/**
	 * This extracts and returns the hint value for the given {@link ContainerSelector}.
	 *
	 * @param modelConnectionHint
	 *            The {@link ContainerSelector} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private Map<ContainerSelectorSourceInterface, AttributeValueRepresentation> extractHintValue(
			ContainerSelector modelConnectionHint, MatchedSectionDescriptor matchedSectionDescriptor) {

		// This keeps track of the extracted hint value parts
		//
		Map<ContainerSelectorSourceInterface, AttributeValueRepresentation> hintValue = new HashMap<>();

		// Extract the hint value part based on its type
		//
		for (ContainerSelectorSourceInterface modelConnectionHintSourceInterface : modelConnectionHint
				.getSourceElements()) {

			AttributeValueRepresentation attributeValueRepresentation = null;

			if (modelConnectionHintSourceInterface instanceof GlobalModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(GlobalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) modelConnectionHintSourceInterface,
						this.matchedSections, matchedSectionDescriptor);
			} else if (modelConnectionHintSourceInterface instanceof ModifiedAttributeElementType<?, ?, ?, ?>) {
				attributeValueRepresentation = this.extractValue(
						(ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) modelConnectionHintSourceInterface,
						matchedSectionDescriptor);
			} else if (modelConnectionHintSourceInterface instanceof FixedValue) {
				attributeValueRepresentation = this.extractValue((FixedValue) modelConnectionHintSourceInterface,
						matchedSectionDescriptor);
			} else if (modelConnectionHintSourceInterface instanceof GlobalAttributeImporter) {
				attributeValueRepresentation = this.extractValue(
						(GlobalAttributeImporter) modelConnectionHintSourceInterface, matchedSectionDescriptor);
			} else {
				this.logger.severe("Unsupported type of source element for a ModelConnectionHint found: '"
						+ modelConnectionHintSourceInterface.eClass().getName() + "'!");
			}

			if (attributeValueRepresentation != null) {
				hintValue.put(modelConnectionHintSourceInterface, attributeValueRepresentation);
			}
		}

		return hintValue.isEmpty() ? null : hintValue;
	}

	/**
	 * This extracts and returns the hint value for the given {@link CardinalityMapping}.
	 *
	 * @param cardinalityMapping
	 *            The {@link CardinalityMapping} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	private Integer extractHintValue(CardinalityMapping cardinalityMapping,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		if (cardinalityMapping.getSource() != null) {

			if (cardinalityMapping.getSource() instanceof SourceSectionClass) {

				// If the cardinality mapping specifies a SourceSectionClass as source, we simply return the number of
				// times
				// this class has been matched
				//
				SourceSectionClass sourceClass = (SourceSectionClass) cardinalityMapping.getSource();
				Set<EObject> sourceElements = matchedSectionDescriptor.getSourceModelObjectsMapped().get(sourceClass);
				return sourceElements == null ? null : sourceElements.size();

			} else if (cardinalityMapping.getSource() instanceof SourceSectionAttribute) {

				// If the cardinality mapping specifies a SourceSectionAttribute as source, we first collect all matches
				// of this attribute and then return the sum of the values for each of the found matches
				//
				SourceSectionAttribute sourceAttribute = (SourceSectionAttribute) cardinalityMapping.getSource();
				Set<EObject> sourceElements = matchedSectionDescriptor.getSourceModelObjectsMapped()
						.get(sourceAttribute.getOwningClass());
				return sourceElements == null ? null
						: sourceElements.parallelStream()
								.mapToInt(sourceElement -> sourceAttribute instanceof ActualAttribute<?, ?, ?, ?>
										? AgteleEcoreUtil
												.getAttributeValueAsList(sourceElement,
														((ActualAttribute<?, ?, ?, ?>) sourceAttribute).getAttribute())
												.size()
										: 1)
								.sum();

			} else {
				this.logger.severe("CardinalityMapping '" + cardinalityMapping.getName()
						+ "' specifies an unsupported element type as 'source'. Only SourceSectionClasses and SourceSectionAttributes are supported!");
				return null;
			}

		} else {
			this.logger.severe("CardinalityMappings without a specified 'source' element are not yet supported!");
			return null;
		}

	}

	/**
	 * This extracts and returns the hint value for the given {@link MappedAttributeValueExpander}.
	 *
	 * @param mappedAttributeValueExpander
	 *            The {@link MappedAttributeValueExpander} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private String extractHintValue(MappedAttributeValueExpander mappedAttributeValueExpander,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		if (mappedAttributeValueExpander.getSourceAttribute() instanceof ActualSourceSectionAttribute
				&& ((ActualSourceSectionAttribute) mappedAttributeValueExpander.getSourceAttribute()).getAttribute()
						.isMany()) {
			// FIXME Currently, we do not support many-valued attributes
			this.logger.severe("MappedAttributeValueExpanders based on multi-valued attributes are not yet supported!");
			return null;
		}

		// Extract the hint value
		//
		AttributeValueRepresentation attributeValueRepresentation = this.extractValue(
				(ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) mappedAttributeValueExpander,
				matchedSectionDescriptor);

		return attributeValueRepresentation == null ? null : attributeValueRepresentation.getNextValue();
	}

	/**
	 * For a given {@link MappingHintBaseType hint}, this {@link HintValueMap#init(EObject, boolean) initializes} the
	 * {@link HintValueMap} in the given {@link MappingInstanceStorage}.
	 *
	 * @param hint
	 *            The {@link MappingHintBaseType} for that the map shall be initialized.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} in that the hint value map shall be initialized.
	 */
	private void initializeHintValueMap(MappingHintBaseType hint, MappingInstanceStorage mappingInstance) {

		if (hint instanceof AttributeMapping) {
			mappingInstance.getHintValues().getAttributeMappingHintValues().init((AttributeMapping) hint, false);
		} else if (hint instanceof ReferenceTargetSelector) {
			if (((ReferenceTargetSelector) hint).getMatcher() instanceof AttributeMatcher) {
				mappingInstance.getHintValues().getMappingInstanceSelectorHintValues()
						.init((ReferenceTargetSelector) hint, false);
			}
		} else if (hint instanceof ContainerSelector) {
			mappingInstance.getHintValues().getModelConnectionHintValues().init((ContainerSelector) hint, false);
		}
	}

	/**
	 * This stores the given '<em>hintValue</em>' produced by the given {@link MappingHintBaseType} in the given
	 * {@link MappingInstanceStorage}.
	 * <p />
	 * Note: If the '<em>hintValue</em>' represents a 'complex', attribute-based hint (i.e. one that is composed of
	 * multiple source elements like e.g. an 'AttributeMapping), it is consolidated first. By 'consolidated', we mean
	 * that, if one or more of the source elements returned {@link AttributeValueRepresentation#isMany() multiple
	 * values}, multiple distinct hint values are created.
	 *
	 * @param hintValue
	 *            The object representing the hint value. The type of this is dependent on the concrete
	 *            {@link MappingHintBaseType} represented by the given '<em>hint</em>'.
	 * @param hint
	 *            The {@link MappingHintBaseType hint} that produced the value.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} where the hint value shall be stored.
	 */
	@SuppressWarnings("unchecked")
	private void storeHintValueConsolidated(Object hintValue, MappingHintBaseType hint,
			MappingInstanceStorage mappingInstance) {

		/*
		 * If we deal with a 'complex' hint (one that is composed of multiple source elements) and one or more of the
		 * source elements returned multiple values, we need to 'consolidate' the hint values, i.e. create multiple
		 * distinct hint values.
		 */
		if (hintValue instanceof Map<?, ?>) {

			HashMap<EObject, AttributeValueRepresentation> hintValueMap = (HashMap<EObject, AttributeValueRepresentation>) hintValue;

			int maxNumberOfValues = hintValueMap.values().parallelStream().mapToInt(v -> v.getValues().size()).max()
					.getAsInt();

			for (AttributeValueRepresentation valueRepresentation : hintValueMap.values()) {
				if (maxNumberOfValues % valueRepresentation.getValues().size() > 0) {
					this.logger.warning("The source elements of the mapping hint '" + hint.getName() + "' produced an "
							+ "inconsistent number of hint values. They are thus skipped...");
					return;
				}
			}

			for (int i = 0; i < maxNumberOfValues; i++) {
				HashMap<EObject, AttributeValueRepresentation> newHintValueMap = (HashMap<EObject, AttributeValueRepresentation>) hintValueMap
						.clone();
				for (Entry<EObject, AttributeValueRepresentation> entry : hintValueMap.entrySet()) {
					newHintValueMap.put(entry.getKey(), new AttributeValueRepresentation(
							entry.getValue().getAttribute(), entry.getValue().getNextValue()));
				}
				mappingInstance.getHintValues().addHintValue(hint, newHintValueMap);
			}

			/*
			 * In case we are dealing with a HintImporterMappingHint, we cannot simply store the extracted hint value.
			 * Instead, we need to update to the existing value.
			 */
		} else if (hint instanceof HintImporterMappingHint) {

			if (!(hint instanceof MappedAttributeValueExpander)) {
				this.logger.severe("Unknown type of HintImporterMappingHint found: '" + hint.eClass().getName() + "'.");
				return;
			}

			// Whether the hintValue shall be preprended or appended.
			//
			boolean prepend = hint instanceof MappedAttributeValuePrepender
					|| hint instanceof ExternalMappedAttributeValuePrepender;

			((MappedAttributeValueExpander) hint).getHintsToExpand().parallelStream()
					.forEach(h -> this.expandHint(h, hintValue, mappingInstance, prepend));

			/*
			 * Otherwise, we can simply store the single hint value in the mapping instance.
			 */
		} else if (hintValue != null) {

			mappingInstance.getHintValues().addHintValue(hint, hintValue);
		}
	}

	/**
	 * Expand the existing values of the given {@link ExpandableHint} stored for the given
	 * {@link MappingInstanceStorage}.
	 *
	 * @param expandableHint
	 *            The {@link ExpandableHint} of which the existing values shall be expanded.
	 * @param hintValue
	 *            The value to append/prepend.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} containing the hint values to expand.
	 * @param prepend
	 *            If this is '<em><b>true</b></em>', the hintValue shall be prepended; otherwise, it shall be appended.
	 */
	private void expandHint(ExpandableHint expandableHint, Object hintValue, MappingInstanceStorage mappingInstance,
			boolean prepend) {

		if (!(hintValue instanceof String)) {
			this.logger.severe("Trying to expand a hint value that is no String. This not supported!");
			return;
		}

		if (expandableHint instanceof AttributeMapping) {
			this.expandAttributeMapping((AttributeMapping) expandableHint, (String) hintValue, mappingInstance,
					prepend);
		} else if (expandableHint instanceof AttributeMatcher) {
			this.expandAttributeMatcher((AttributeMatcher) expandableHint, (String) hintValue, mappingInstance,
					prepend);
		} else {
			this.logger.severe("Unknown type of ExpandableHint found '" + expandableHint.eClass().getName() + "'!");
		}
	}

	/**
	 * Expand the existing values of the given {@link AttributeMapping} stored for the given
	 * {@link MappingInstanceStorage}.
	 *
	 * @param attributeMapping
	 *            The {@link AttributeMapping} of which the existing values shall be expanded.
	 * @param hintValue
	 *            The value to append/prepend.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} containing the hint values to expand.
	 * @param prepend
	 *            If this is '<em><b>true</b></em>', the hintValue shall be prepended; otherwise, it shall be appended.
	 */
	private void expandAttributeMapping(AttributeMapping attributeMapping, String hintValue,
			MappingInstanceStorage mappingInstance, boolean prepend) {

		AttributeMappingSourceInterface element;

		if (prepend) {
			element = attributeMapping.getSourceElements().get(0);
		} else {
			element = attributeMapping.getSourceElements().get(attributeMapping.getSourceElements().size() - 1);
		}

		mappingInstance.getHintValues().getHintValues(attributeMapping).parallelStream().forEach(existingValue -> {

			if (existingValue.containsKey(element)) {
				if (prepend) {
					existingValue.get(element).addPrefix(hintValue);
				} else {
					existingValue.get(element).addSuffix(hintValue);
				}
			}
		});
	}

	/**
	 * Expand the existing values of the given {@link AttributeMatcher} stored for the given
	 * {@link MappingInstanceStorage}.
	 *
	 * @param attributeMatcher
	 *            The {@link AttributeMatcher} of which the existing values shall be expanded.
	 * @param hintValue
	 *            The value to append/prepend.
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage} containing the hint values to expand.
	 * @param prepend
	 *            If this is '<em><b>true</b></em>', the hintValue shall be prepended; otherwise, it shall be appended.
	 */
	private void expandAttributeMatcher(AttributeMatcher attributeMatcher, String hintValue,
			MappingInstanceStorage mappingInstance, boolean prepend) {

		AttributeMatcherSourceInterface element;

		if (prepend) {
			element = attributeMatcher.getSourceElements().get(0);
		} else {
			element = attributeMatcher.getSourceElements().get(attributeMatcher.getSourceElements().size() - 1);
		}

		mappingInstance.getHintValues().getHintValues((ReferenceTargetSelector) attributeMatcher.eContainer())
				.parallelStream().forEach(existingValue -> {

					if (existingValue.containsKey(element)) {
						if (prepend) {
							existingValue.get(element).addPrefix(hintValue);
						} else {
							existingValue.get(element).addSuffix(hintValue);
						}
					}
				});
	}

}
