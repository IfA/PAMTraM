package de.mfreund.gentrans.transformation.matching;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.ElementIDMap;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.maps.HintValue;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.FixedValue;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.extended.AttributeMapping;
import pamtram.mapping.extended.CardinalityMapping;
import pamtram.mapping.extended.CardinalityMappingSourceInterface;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ExpandableHint;
import pamtram.mapping.extended.ExternalMappedAttributeValuePrepender;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.extended.HintImporterMappingHint;
import pamtram.mapping.extended.MappedAttributeValueExpander;
import pamtram.mapping.extended.MappedAttributeValuePrepender;
import pamtram.mapping.extended.MappingHint;
import pamtram.mapping.extended.MappingHintBaseType;
import pamtram.mapping.extended.MappingHintSourceInterface;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.generic.ActualAttribute;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to extract hint values and values of {@link GlobalAttribute GlobalAttributes} from source
 * model elements for a given list of {@link MappingInstanceDescriptor mapping instances}.
 *
 * @author mfreund
 */
public class HintValueExtractor extends ValueExtractor {

	/**
	 * The {@link ValueCalculator} that shall be used to calculate the {@link #getResultingValues() resultingValues}.
	 */
	protected ValueCalculator valueCalculator;

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a
	 * map where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * This keeps track of the {@link MappingInstanceDescriptor MappingInstanceStorages} representing
	 * {@link ExportedMappingHintGroup ExportedMappingHintGroups}.
	 * <p/>
	 * This is used during {@link #extractImportedHintValues(MappingInstanceDescriptor)} to import hint values for
	 * {@link MappingHintGroupImporter MappingHintGroupImporters}.
	 */
	private Map<MappingHint, HintValue> exportedHintValues;

	/**
	 * This creates an instance for a given list of {@link MappingInstanceDescriptor mappingInstances}.
	 * <p />
	 * Note: The extracted hint values are stored in the given <em>mappingInstances</em>.
	 *
	 * @param matchingResult
	 *            The result of the <em>matching</em> step.
	 * @param valueCalculator
	 *            The {@link ValueCalculator} that shall be used to create the {@link HintValue HintValues}.
	 * @param globalValues
	 *            The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute
	 *            GlobalAttribute}) defined in the PAMTraM model.
	 * @param elementIDs
	 *            The {@link ElementIDMap} managing model-unique ids of {@link EObject elements}.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} that is used to evaluate {@link InstanceSelector InstancePointers}
	 *            that have been modeled.
	 * @param attributeValueModifierExecutor
	 *            The {@link ValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 */
	public HintValueExtractor(Map<SourceSection, List<MatchedSectionDescriptor>> matchingResult,
			ValueCalculator valueCalculator, GlobalValueMap globalValues, ElementIDMap elementIDs,
			InstanceSelectorHandler instanceSelectorHandler, ValueModifierExecutor attributeValueModifierExecutor,
			Logger logger, boolean useParallelization) {

		super(globalValues, elementIDs, instanceSelectorHandler, attributeValueModifierExecutor, logger,
				useParallelization);

		this.valueCalculator = valueCalculator;
		this.matchedSections = matchingResult;
		this.exportedHintValues = Collections.synchronizedMap(new LinkedHashMap<>());
	}

	/**
	 * This extracts the values for {@link MappingHint MappingHints} in the given <em>mappingInstances</em>.
	 * <p />
	 * Note: The extracted values are stored as {@link MappingInstanceDescriptor#getHintValues() hintValues} inside the
	 * respective for each {@link MappingInstanceDescriptor}.
	 *
	 * @param mappingInstances
	 *            The list of {@link MappingInstanceDescriptor MappingInstanceStorages} for that the hint values shall
	 *            be extracted.
	 */
	public void extractHintValues(List<MappingInstanceDescriptor> mappingInstances) {

		Supplier<Stream<MappingInstanceDescriptor>> mappingInstanceSupplier = () -> this.useParallelization
				? mappingInstances.parallelStream()
				: mappingInstances.stream();

		// In a first step, we extract the hints of exported hint groups and store them in the 'exportedHintValues' so
		// that they can be reused by other mapping instances.
		//
		mappingInstanceSupplier.get().forEach(this::extractExportedHintValues);

		// Now, we extract the hints for hint group importers (as we can now used the hint values of exported hint
		// groups that have been calculated before).
		//
		mappingInstanceSupplier.get().forEach(this::extractImportedHintValues);

		// Finally, we extract the 'normal' hint values.
		//
		mappingInstanceSupplier.get().forEach(this::extractNormalHintValues);

	}

	/**
	 * This extracts the '<em>exported</em>' values (values of {@link MappingHint MappingHints} that are part of an
	 * {@link ExportedMappingHintGroup}) for the given {@link MappingInstanceDescriptor}.
	 * <p />
	 * Note: The extracted hint values are stored in the {@link #exportedHintValues} so that they can be reused/imported
	 * by other hints.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} for that the hint values shall be extracted.
	 */
	private void extractExportedHintValues(MappingInstanceDescriptor mappingInstance) {

		mappingInstance.getExportedMappingHints().stream().forEach(h -> {
			// There should be only one hint value for exported hints
			//
			if (this.exportedHintValues.containsKey(h)) {
				this.logger.warning(() -> "Multiple occurences found for exported hint '" + h.getName()
						+ "'! This is currently not supported!");
			}
			this.exportedHintValues.put(h, this.extractHintValue(h, mappingInstance));
		});

	}

	/**
	 * This extracts the '<em>imported</em>' values (values of {@link MappingHint MappingHints} that are imported by a
	 * {@link MappingHintGroupImporter}) for the given {@link MappingInstanceDescriptor}.
	 * <p />
	 * Note: The values are extracted from the {@link #exportedHintValues}. However, potential
	 * {@link HintImporterMappingHint HintImporterMappingHints} are also evaluated so that the imported values may be
	 * altered.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} for that the hint values shall be extracted.
	 */
	private void extractImportedHintValues(MappingInstanceDescriptor mappingInstance) {

		Map<MappingHint, HintValue> importedHintValues = new LinkedHashMap<>();

		mappingInstance.getMappingHintGroupImporters().stream().forEach(importer -> {

			for (MappingHint importedHint : importer.getHintGroup().getActiveMappingHints()) {

				if (!this.exportedHintValues.containsKey(importedHint)) {
					this.logger.severe(() -> "No value found to import for MappingHint '" + importedHint + "'!");
					continue;
				}

				importedHintValues.put(importedHint, this.exportedHintValues.get(importedHint).createCopy());
			}

			importer.getActiveMappingHints().stream().filter(h -> h instanceof MappedAttributeValueExpander)
					.map(h -> (MappedAttributeValueExpander) h).forEach(h -> {

						String valueToAdd = this.extractHintValue(h, mappingInstance);

						// Whether the hintValue shall be preprended or appended.
						//
						boolean prepend = h instanceof MappedAttributeValuePrepender
								|| h instanceof ExternalMappedAttributeValuePrepender;

						for (ExpandableHint hintToExpand : h.getHintsToExpand()) {

							if (!importedHintValues.containsKey(hintToExpand)) {
								this.logger
										.severe(() -> "No hint value found for ExpandableHint '" + hintToExpand + "'!");
								return;
							}

							importedHintValues.get(hintToExpand).expandHintValue(valueToAdd, prepend);

						}

					});
		});

		importedHintValues.entrySet().stream().forEach(
				e -> mappingInstance.getHintValues().addHintValues(e.getKey(), e.getValue().getResultingValues()));

	}

	/**
	 * This extracts the '<em>normal</em>' values (values of {@link MappingHint MappingHints} that are not part of an
	 * {@link ExportedMappingHintGroup} and that are no {@link HintImporterMappingHint HintImporterMappingHints}) for
	 * the given {@link MappingInstanceDescriptor}.
	 * <p />
	 * Note: The extracted hint values are stored in the <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} for that the hint values shall be extracted.
	 */
	private void extractNormalHintValues(MappingInstanceDescriptor mappingInstance) {

		mappingInstance.getMappingHints(true).stream()
				.filter(h -> !(h.eContainer() instanceof ExportedMappingHintGroup))
				.forEach(h -> mappingInstance.getHintValues().addHintValues(h,
						this.extractHintValue(h, mappingInstance).getResultingValues()));

	}

	/**
	 * This extracts the hint value for the given {@link MappingHintBaseType mapping hint}.
	 * <p />
	 * Note: The extracted hint value is stored in the <em>mappingInstance</em>.
	 *
	 * @param hint
	 *            The {@link MappingHintBaseType} for that the hint values shall be extracted.
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} for that the hint values shall be extracted.
	 * @return
	 */
	private HintValue extractHintValue(MappingHintBaseType hint, MappingInstanceDescriptor mappingInstance) {

		HintValue ret = null;

		if (hint instanceof AttributeMapping || hint instanceof ReferenceTargetSelector
				|| hint instanceof ContainerSelector) {

			MatchedSectionDescriptor matchedSectionDescriptor = mappingInstance.getMatchedSectionDescriptor();

			// This keeps track of the extracted hint value parts
			//
			LinkedHashMap<MappingHintSourceInterface, AttributeValueRepresentation> hintValueMap = new LinkedHashMap<>();

			// Extract the hint value parts based on the type
			// (Disregard source elements with negative conditions)
			//
			for (MappingHintSourceInterface attributeMappingSourceInterface : mappingInstance
					.getMappingHintSourceElements((MappingHint) hint)) {

				AttributeValueRepresentation attributeValueRepresentation = this
						.extractHintValue(attributeMappingSourceInterface, matchedSectionDescriptor);

				if (attributeValueRepresentation != null) {
					hintValueMap.put(attributeMappingSourceInterface, attributeValueRepresentation);
				}
			}

			if (!hintValueMap.isEmpty()) {
				ret = HintValue.create((MappingHint) hint, hintValueMap, this.valueCalculator);
			}

		} else if (hint instanceof CardinalityMapping) {

			ret = this.extractHintValue((CardinalityMapping) hint, mappingInstance);

		} else {

			this.logger.severe(() -> "Unsupported type of MappingHint found: '" + hint.eClass().getName() + "'!");
			return null;
		}

		return ret != null ? ret : HintValue.create((MappingHint) hint, null, this.valueCalculator);

	}

	/**
	 * Extracts a (partial) hint value for a single {@link MappingHintSourceInterface source element} of a MappingHint.
	 *
	 * @param sourceElement
	 *            The {@link MappingHintSourceInterface} for which the value shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} representing the part of the source model from which the value is
	 *            to be extracted.
	 * @return The {@link AttributeValueRepresentation} representing the extracted value.
	 */
	@SuppressWarnings("unchecked")
	private AttributeValueRepresentation extractHintValue(MappingHintSourceInterface sourceElement,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		AttributeValueRepresentation attributeValueRepresentation = null;

		if (sourceElement instanceof GlobalDynamicSourceElement<?, ?, ?, ?, ?>) {
			attributeValueRepresentation = this.extractValue(
					(GlobalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute, SourceInstanceSelector>) sourceElement,
					this.matchedSections, matchedSectionDescriptor, this.useParallelization);
		} else if (sourceElement instanceof DynamicSourceElement<?, ?, ?, ?>) {
			attributeValueRepresentation = this.extractValue(
					(DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) sourceElement,
					matchedSectionDescriptor);
		} else if (sourceElement instanceof FixedValue) {
			attributeValueRepresentation = this.extractValue((FixedValue) sourceElement, matchedSectionDescriptor);
		} else if (sourceElement instanceof GlobalAttributeImporter) {
			attributeValueRepresentation = this.extractValue((GlobalAttributeImporter) sourceElement,
					matchedSectionDescriptor);
		} else {
			this.logger.severe(() -> "Unsupported type of source element for a MappingHint found: '"
					+ sourceElement.eClass().getName() + "'!");
		}
		return attributeValueRepresentation;
	}

	/**
	 * This extracts and returns the hint value for the given {@link CardinalityMapping}.
	 *
	 * @param cardinalityMapping
	 *            The {@link CardinalityMapping} for that the hint values shall be extracted.
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	private HintValue extractHintValue(CardinalityMapping cardinalityMapping,
			MappingInstanceDescriptor mappingInstance) {

		MatchedSectionDescriptor matchedSectionDescriptor = mappingInstance.getMatchedSectionDescriptor();

		if (cardinalityMapping.getSource() != null) {

			if (cardinalityMapping.getSource() instanceof SourceSectionClass) {

				// If the cardinality mapping specifies a SourceSectionClass as
				// source, we simply return the number of
				// times
				// this class has been matched
				//
				SourceSectionClass sourceClass = (SourceSectionClass) cardinalityMapping.getSource();
				Set<EObject> sourceElements = matchedSectionDescriptor.getMatchedSourceModelElementsFor(sourceClass);
				return sourceElements == null ? null
						: HintValue.create(cardinalityMapping, sourceElements.size(), this.valueCalculator);

			} else if (cardinalityMapping.getSource() instanceof SourceSectionAttribute) {

				// If the cardinality mapping specifies a SourceSectionAttribute
				// as source, we first collect all matches
				// of this attribute and then return the sum of the values for
				// each of the found matches
				//
				SourceSectionAttribute sourceAttribute = (SourceSectionAttribute) cardinalityMapping.getSource();
				Set<EObject> sourceElements = matchedSectionDescriptor
						.getMatchedSourceModelElementsFor(sourceAttribute.getOwningClass());
				return sourceElements == null ? null
						: HintValue.create(cardinalityMapping,
								sourceElements.parallelStream()
										.mapToInt(
												sourceElement -> sourceAttribute instanceof ActualAttribute<?, ?, ?, ?>
														? AgteleEcoreUtil.getStructuralFeatureValueAsList(sourceElement,
																((ActualAttribute<?, ?, ?, ?>) sourceAttribute)
																		.getAttribute())
																.size()
														: 1)
										.sum(),
								this.valueCalculator);

			} else {
				this.logger.severe(() -> "CardinalityMapping '" + cardinalityMapping.getName()
						+ "' specifies an unsupported element type as 'source'. Only SourceSectionClasses and SourceSectionAttributes are supported!");
				return null;
			}

		} else {
			// This keeps track of the extracted hint value parts
			//
			Map<CardinalityMappingSourceInterface, AttributeValueRepresentation> hintValue = new LinkedHashMap<>();

			// Extract the hint value part based on its type
			//
			for (MappingHintSourceInterface cardinalityMappingSourceInterface : mappingInstance
					.getMappingHintSourceElements(cardinalityMapping)) {

				AttributeValueRepresentation attributeValueRepresentation = this
						.extractHintValue(cardinalityMappingSourceInterface, matchedSectionDescriptor);

				if (attributeValueRepresentation != null) {
					hintValue.put((CardinalityMappingSourceInterface) cardinalityMappingSourceInterface,
							attributeValueRepresentation);
				}

			}

			return hintValue.isEmpty() ? null : HintValue.create(cardinalityMapping, hintValue, this.valueCalculator);
		}

	}

	/**
	 * This extracts and returns the hint value for the given {@link MappedAttributeValueExpander}.
	 *
	 * @param mappedAttributeValueExpander
	 *            The {@link MappedAttributeValueExpander} for that the hint values shall be extracted.
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} for that the hint values shall be extracted.
	 * @return The extracted hint value or '<em>null</em>' if nothing could be extracted.
	 */
	@SuppressWarnings("unchecked")
	private String extractHintValue(MappedAttributeValueExpander mappedAttributeValueExpander,
			MappingInstanceDescriptor mappingInstance) {

		MatchedSectionDescriptor matchedSectionDescriptor = mappingInstance.getMatchedSectionDescriptor();

		if (mappedAttributeValueExpander.getSourceAttribute() instanceof ActualSourceSectionAttribute
				&& ((ActualSourceSectionAttribute) mappedAttributeValueExpander.getSourceAttribute()).getAttribute()
						.isMany()) {
			// FIXME Currently, we do not support many-valued attributes
			this.logger.severe("MappedAttributeValueExpanders based on multi-valued attributes are not yet supported!");
			return "";
		}

		// Extract the hint value
		//
		return this.extractValue(
				(DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) mappedAttributeValueExpander,
				matchedSectionDescriptor).getValue();

	}

	// /**
	// * This stores the given '<em>hintValue</em>' produced by the given {@link MappingHintBaseType} in the given
	// * {@link MappingInstanceDescriptor}.
	// * <p />
	// * Note: If the '<em>hintValue</em>' represents a 'complex', attribute-based hint (i.e. one that is composed of
	// * multiple source elements like e.g. an 'AttributeMapping), it is consolidated first. By 'consolidated', we mean
	// * that, if one or more of the source elements returned {@link AttributeValueRepresentation#isMany() multiple
	// * values}, multiple distinct hint values are created.
	// *
	// * @param hintValue
	// * The object representing the hint value. The type of this is dependent on the concrete
	// * {@link MappingHintBaseType} represented by the given '<em>hint</em>'.
	// * @param hint
	// * The {@link MappingHintBaseType hint} that produced the value.
	// * @param mappingInstance
	// * The {@link MappingInstanceDescriptor} where the hint value shall be stored.
	// */
	// @SuppressWarnings("unchecked")
	// private void storeHintValueConsolidated(HintValue hintValue, MappingHintBaseType hint,
	// MappingInstanceDescriptor mappingInstance) {
	//
	// /*
	// * If we deal with a 'complex' hint (one that is composed of multiple source elements) and one or more of the
	// * source elements returned multiple values, we need to 'consolidate' the hint values, i.e. create multiple
	// * distinct hint values.
	// */
	// if (hintValue instanceof AttributeBasedHintValue<?>) {
	//
	// LinkedHashMap<MappingHintSourceInterface, AttributeValueRepresentation> hintValueMap =
	// ((AttributeBasedHintValue<MappingHintSourceInterface>) hintValue)
	// .getInternalValue();
	//
	// int maxNumberOfValues = hintValueMap.values().parallelStream().mapToInt(v -> v.getValues().size()).max()
	// .getAsInt();
	//
	// for (AttributeValueRepresentation valueRepresentation : hintValueMap.values()) {
	// if (maxNumberOfValues % valueRepresentation.getValues().size() > 0) {
	// this.logger.warning(() -> "The source elements of the mapping hint '" + hint.getName()
	// + "' produced an " + "inconsistent number of hint values. They are thus skipped...");
	// return;
	// }
	// }
	//
	// for (int i = 0; i < maxNumberOfValues; i++) {
	// LinkedHashMap<MappingHintSourceInterface, AttributeValueRepresentation> newHintValueMap =
	// (LinkedHashMap<MappingHintSourceInterface, AttributeValueRepresentation>) hintValueMap
	// .clone();
	// for (Entry<MappingHintSourceInterface, AttributeValueRepresentation> entry : hintValueMap.entrySet()) {
	// newHintValueMap.put(entry.getKey(), new AttributeValueRepresentation(
	// entry.getValue().getAttribute(), entry.getValue().getNextValue()));
	// }
	// mappingInstance.getHintValues().addHintValue(hint, new AttributeBasedHintValue<>(newHintValueMap));
	// }
	//
	// /*
	// * In case we are dealing with a HintImporterMappingHint, we cannot simply store the extracted hint value.
	// * Instead, we need to update to the existing value.
	// */
	// } else if (hint instanceof HintImporterMappingHint) {
	//
	// if (!(hint instanceof MappedAttributeValueExpander)) {
	// this.logger.severe(
	// () -> "Unknown type of HintImporterMappingHint found: '" + hint.eClass().getName() + "'.");
	// return;
	// }
	//
	// // Whether the hintValue shall be preprended or appended.
	// //
	// boolean prepend = hint instanceof MappedAttributeValuePrepender
	// || hint instanceof ExternalMappedAttributeValuePrepender;
	//
	// (this.useParallelization ? ((MappedAttributeValueExpander) hint).getHintsToExpand().parallelStream()
	// : ((MappedAttributeValueExpander) hint).getHintsToExpand().stream()).forEach(h -> {
	// if (!this.exportedHintGroups.containsKey(h)) {
	// this.logger.severe(() -> "No hint value found for ExpandableHint '" + h + "'!");
	// return;
	// }
	// hintValue.expandHintValue(this.exportedHintGroups.get(h), prepend);
	// });
	//
	// /*
	// * Otherwise, we can simply store the single hint value in the mapping instance.
	// */
	// } else if (hintValue != null) {
	//
	// mappingInstance.getHintValues().addHintValue(hint, hintValue);
	// }
	// }

}
