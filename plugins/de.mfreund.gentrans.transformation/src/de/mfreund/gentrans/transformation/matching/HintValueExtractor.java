package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.calculation.ValueCalculator;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceDescriptor;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.ElementIDMap;
import de.mfreund.gentrans.transformation.maps.HintValue;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
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
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.StructurePackage;
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
	private MatchedSectionRegistry matchedSections;

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
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public HintValueExtractor(TransformationAssetManager assetManager) {

		super(assetManager);

		this.valueCalculator = assetManager.getValueCalculator();
		this.matchedSections = assetManager.getMatchedSectionRegistry();
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

		Supplier<Stream<MappingInstanceDescriptor>> mappingInstanceSupplier = mappingInstances::parallelStream;

		// As the generated IDs depend on the invocation order, we first initialize all IDs in a serialized way. That
		// way, we can safely extract the hint values in parallel after this
		//
		mappingInstanceSupplier.get().sequential().forEach(this::reserveRequiredElementIDs);

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
	 * This initializes all IDs in the {@link ElementIDMap} that are required for the given <em>mappingInstance</em>.
	 *
	 * @param mappingInstance
	 *            The {@link MappingInstanceDescriptor} for that the IDs shall be reserved.
	 */
	private void reserveRequiredElementIDs(MappingInstanceDescriptor mappingInstanceDescriptor) {

		Set<MappingHint> mappingHints = mappingInstanceDescriptor.getMappingHints(true);

		Collection<EObject> dynamicSourceElementsInMappingHints = AgteleEcoreUtil.getAllInstances(
				StructurePackage.Literals.DYNAMIC_SOURCE_ELEMENT, new ArrayList<EObject>(mappingHints));

		@SuppressWarnings("unchecked")
		Stream<DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> dynamicSourceElementsWithUseElementID = dynamicSourceElementsInMappingHints
				.stream()
				.map(d -> (DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) d)
				.filter(DynamicSourceElement::isUseElementID);

		Set<SourceSectionAttribute> attributesUsedForIDs = dynamicSourceElementsWithUseElementID
				.map(DynamicSourceElement::getSource).collect(Collectors.toCollection(LinkedHashSet::new));

		this.reserveRequiredElementIDs(attributesUsedForIDs, mappingInstanceDescriptor.getMatchedSectionDescriptor());
	}

	private void reserveRequiredElementIDs(Set<SourceSectionAttribute> attributesUsedForIDs,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		for (SourceSectionAttribute sourceSectionAttribute : attributesUsedForIDs) {

			Set<EObject> eObjectsMatchedAgainstAttribute = matchedSectionDescriptor
					.getMatchedSourceModelElementsFor(sourceSectionAttribute.getOwningClass(), true);

			for (EObject eObject : eObjectsMatchedAgainstAttribute) {
				this.assetManager.getElementIDs().getID(eObject, sourceSectionAttribute);
			}
		}
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
					this.matchedSections, matchedSectionDescriptor,
					this.assetManager.getTransformationConfig().isUseParallelization());
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

			// Depending on the type of 'source' element specified, we first need to determine the elements whose
			// cardinality we need to check
			//
			List<SourceSectionClass> sourceClasses = new ArrayList<>();

			if (cardinalityMapping.getSource() instanceof SourceSectionClass) {
				sourceClasses.add((SourceSectionClass) cardinalityMapping.getSource());
			} else if (cardinalityMapping.getSource() instanceof SourceSectionReference) {
				sourceClasses.addAll(((SourceSectionReference) cardinalityMapping.getSource()).getValuesGeneric());
			} else if (cardinalityMapping.getSource() instanceof SourceSectionAttribute) {
				sourceClasses.add(((SourceSectionAttribute) cardinalityMapping.getSource()).getOwningClass());
			} else {
				this.logger.severe(() -> "CardinalityMapping '" + cardinalityMapping.getName()
						+ "' specifies an unsupported element type as 'source' ('"
						+ cardinalityMapping.getSource().eClass().getName() + "').");
				return null;
			}

			Set<EObject> sourceElements = sourceClasses.stream().flatMap(sourceClass -> matchedSectionDescriptor
					.getMatchedSourceModelElementsFor(sourceClass, cardinalityMapping.isFollowExternalReferences())
					.stream()).collect(Collectors.toSet());

			// Evaluate potential ReferenceMatchSpecs
			//
			if (!cardinalityMapping.getReferenceMatchSpec().isEmpty()) {
				sourceElements = sourceElements.stream()
						.filter(e -> this.assetManager.getMatchSpecHandler().conformsMatchedObject(
								matchedSectionDescriptor.getAssociatedSourceModelElement(), e, cardinalityMapping))
						.collect(Collectors.toSet());
			}

			if (sourceElements.isEmpty()) {
				return HintValue.create(cardinalityMapping, 0, this.valueCalculator);
			}

			int resultingCardinality = 0;

			if (cardinalityMapping.getSource() instanceof SourceSectionClass
					|| cardinalityMapping.getSource() instanceof SourceSectionReference) {

				// The resulting cardinality is simply the number of determined relevant source elements
				//
				resultingCardinality = sourceElements.size();

			} else if (cardinalityMapping.getSource() instanceof SourceSectionAttribute) {

				// We have to determine the number of attribute values for the relevant source elements (there
				// may be more than one attribute value per source element)
				//
				SourceSectionAttribute sourceAttribute = (SourceSectionAttribute) cardinalityMapping.getSource();
				resultingCardinality = sourceElements.stream().mapToInt(sourceElement -> this.assetManager
						.getModelAccessUtil().getAttributeValueAsList(sourceElement, sourceAttribute).size()).sum();

			}

			return HintValue.create(cardinalityMapping, resultingCardinality, this.valueCalculator);

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

}
