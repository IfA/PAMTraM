package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;

import de.mfreund.gentrans.transformation.calculation.MatchSpecHandler;
import de.mfreund.gentrans.transformation.core.CancelableTransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.FixedValue;
import pamtram.MatchSpecElement;
import pamtram.NamedElement;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.mapping.extended.MappingHint;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.source.VirtualSourceSectionAttribute;
import pamtram.util.OCLUtil;

/**
 * This represents an abstract base class that allows to extract {@link AttributeValueRepresentation values} from a list
 * of {@link MatchedSectionDescriptor MatchedSectionDescriptors}.
 *
 * @author mfreund
 *
 */
public abstract class ValueExtractor extends CancelableTransformationAsset {

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public ValueExtractor(TransformationAssetManager assetManager) {

		super(assetManager);
	}

	/**
	 * This extracts and returns the value for the given {@link FixedValue} from the source elements represented by the
	 * given <em>matchedSectionDescriptor</em>.
	 *
	 * @param fixedValue
	 *            The {@link FixedValue} for that the values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(FixedValue fixedValue,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		this.checkCanceled();

		// FIXME two different FixedValues are currently not supported (both get
		// added to the 'null' attribute
		return new AttributeValueRepresentation(null, fixedValue.getValue());
	}

	/**
	 * This extracts and returns the value for the given {@link GlobalAttributeImporter} from the source elements
	 * represented by the given <em>mappingInstance</em>.
	 *
	 * @param globaleAttributeImporter
	 *            The {@link GlobalAttributeImporter} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(GlobalAttributeImporter globaleAttributeImporter,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		this.checkCanceled();

		return this.assetManager.getGlobalValues().getGlobalAttributes()
				.containsKey(globaleAttributeImporter.getGlobalAttribute())
						? new AttributeValueRepresentation(null,
								this.assetManager.getGlobalValues().get(globaleAttributeImporter.getGlobalAttribute()))
						: null;
	}

	/**
	 * This extracts and returns the hint value for the given {@link DynamicSourceElement} from the source elements
	 * represented by the given <em>mappingInstance</em>.
	 * <p />
	 * Note: This method must not be used for {@link GlobalDynamicSourceElement GlobalModifiedAttributeElementTypes}.
	 * Use {@link #extractValue(GlobalDynamicSourceElement, Map)} instead.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link DynamicSourceElement} for that the hint values shall be extracted.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(
			DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		this.checkCanceled();

		MatchedSectionDescriptor sourceDescriptor = matchedSectionDescriptor;

		// In case we are dealing with an external source element, we first need
		// to determine the correct
		// 'container descriptor' that represents the source element
		//
		if (mappingHintSourceElement instanceof ExternalDynamicSourceElement<?, ?, ?, ?>) {
			do {
				sourceDescriptor = sourceDescriptor.getContainerDescriptor();
				if (sourceDescriptor == null) {
					break;
				}
			} while (sourceDescriptor.getMatchedSourceModelElementsFor(
					(SourceSectionClass) mappingHintSourceElement.getSource().eContainer()).isEmpty());
		}

		Set<EObject> sourceElements = sourceDescriptor == null ? new HashSet<>()
				: sourceDescriptor.getMatchedSourceModelElementsFor(
						(SourceSectionClass) mappingHintSourceElement.getSource().eContainer());

		if (mappingHintSourceElement instanceof LocalDynamicSourceElement<?, ?, ?, ?>) {

			// If the user specified an additional 'referenceMatchSpec', use
			// only that subset of the determined source elements corresponding
			// to this matching path.
			//
			if (!((LocalDynamicSourceElement<?, ?, ?, ?>) mappingHintSourceElement).getReferenceMatchSpec().isEmpty()) {

				MatchedSectionDescriptor localDescriptor = sourceDescriptor;
				sourceElements = sourceElements.stream()
						.filter(s -> MatchSpecHandler.conformsMatchedObject(
								localDescriptor.getAssociatedSourceModelElement(), s,
								(MatchSpecElement<?, ?, ?, ?>) mappingHintSourceElement, this.logger))
						.collect(Collectors.toCollection(LinkedHashSet::new));
			}
		}

		if (sourceElements.isEmpty()) {
			this.logger
					.warning(() -> "Hint source value '" + mappingHintSourceElement.getName() + "' (Containing Hint: '"
							+ ((MappingHint) mappingHintSourceElement.eContainer()).printInfo() + "') not found!");
			return null;
		}

		return this.extractValue(mappingHintSourceElement, new ArrayList<>(sourceElements));
	}

	/**
	 * This extracts and returns the hint value for the given {@link GlobalDynamicSourceElement} from the source
	 * elements represented by the given <em>mappingInstance</em>.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link GlobalDynamicSourceElement} for that the hint values shall be extracted.
	 * @param matchedSections
	 *            Registry for <em>source model objects</em> that have already been matched. The matched objects are
	 *            stored in a map where the key is the corresponding {@link SourceSectionClass} that they have been
	 *            matched to.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the hint values shall be extracted.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(
			GlobalDynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute, SourceInstanceSelector> mappingHintSourceElement,
			MatchedSectionRegistry matchedSections, MatchedSectionDescriptor matchedSectionDescriptor,
			boolean useParallelization) {

		this.checkCanceled();

		List<MatchedSectionDescriptor> sourceDescriptors = matchedSections
				.get(mappingHintSourceElement.getSource().getContainingSection());

		// Collect all instances for the MatchedSectionDescriptors
		//
		List<EObject> sourceElements = (useParallelization ? sourceDescriptors.parallelStream()
				: sourceDescriptors.stream())
						.flatMap(descriptor -> descriptor
								.getMatchedSourceModelElementsFor(
										(SourceSectionClass) mappingHintSourceElement.getSource().eContainer())
								.stream())
						.collect(Collectors.toList());

		// Reduce the list of instances based on modeled InstancePointers
		//
		if (!sourceElements.isEmpty() && !mappingHintSourceElement.getInstanceSelectors().isEmpty()) {

			for (SourceInstanceSelector instancePointer : mappingHintSourceElement.getInstanceSelectors()) {

				sourceElements = this.assetManager.getInstanceSelectorHandler()
						.getSelectedInstancesByInstanceList(instancePointer, sourceElements, matchedSectionDescriptor);
			}

		}

		if (sourceElements.isEmpty()) {
			this.logger.warning(() -> "Hint source value '" + mappingHintSourceElement.getName() + "' not found!");
			return null;
		}

		if (!(mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute)) {

			this.logger.severe(() -> "Mapping hint source elements of type '"
					+ mappingHintSourceElement.getSource().eClass() + "' are not yet supported!");
			return null;
		}

		return this.extractValue(mappingHintSourceElement, sourceElements);
	}

	/**
	 * This extracts and returns the hint value for the given {@link DynamicSourceElement} from the given list of source
	 * elements.
	 *
	 * @param mappingHintSourceElement
	 *            The {@link DynamicSourceElement} for that the hint values shall be extracted.
	 * @param sourceElements
	 * @return The extracted {@link AttributeValueRepresentation hint value} or '<em>null</em>' if no hint value could
	 *         be extracted.
	 */
	protected AttributeValueRepresentation extractValue(
			DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> mappingHintSourceElement,
			List<EObject> sourceElements) {

		this.checkCanceled();

		if (!(mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute
				|| mappingHintSourceElement.getSource() instanceof VirtualSourceSectionAttribute)) {

			this.logger.severe(() -> "Mapping hint source elements of type '"
					+ mappingHintSourceElement.getSource().eClass() + "' are not yet supported!");
			return null;
		}

		AttributeValueRepresentation hintValue = null;

		if (mappingHintSourceElement.isUseElementID()) {

			for (EObject sourceElement : sourceElements) {

				String val = String.valueOf(this.assetManager.getElementIDs().getIDForElement(sourceElement));

				// Apply ValueModifierSets
				//
				final String valCopy = this.assetManager.getValueModifierExecutor().applyAttributeValueModifiers(val,
						mappingHintSourceElement.getModifiers());

				// create a new AttributeValueRepresentation or update the existing
				// one
				if (hintValue == null) {
					hintValue = new AttributeValueRepresentation(mappingHintSourceElement.getSource(), valCopy);
				} else {
					hintValue.addValue(valCopy);
				}
			}

			return hintValue;

		}

		EAttribute sourceAttribute = mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute
				? ((ActualSourceSectionAttribute) mappingHintSourceElement.getSource()).getAttribute()
				: null;

		// Collect all values of the attribute in all source elements
		//
		List<Object> srcAttrValues = ValueExtractor.getAttributeValueAsList(sourceElements,
				mappingHintSourceElement.getSource(), this.assetManager.getLogger());

		if (srcAttrValues.isEmpty()) {
			this.logger.warning(() -> "No hint value found for source element '" + mappingHintSourceElement.getName()
					+ "' in mapping hint '" + ((NamedElement) mappingHintSourceElement.eContainer()).getName()
					+ "' (Mapping '" + ((Mapping) AgteleEcoreUtil.getAncestorOfKind(mappingHintSourceElement,
							MappingPackage.Literals.MAPPING)).getName()
					+ "')!");
			return null;
		}

		// Extract a hint value for each retrieved value
		//
		for (Object srcAttrValue : srcAttrValues) {

			String srcAttrAsString = srcAttrValue.toString();

			// if the attribute represents an actual EAttribute, we need to
			// convert the value based on its type
			if (sourceAttribute != null) {
				srcAttrAsString = sourceAttribute.getEType().getEPackage().getEFactoryInstance()
						.convertToString(sourceAttribute.getEAttributeType(), srcAttrValue);
			}

			// Apply ValueModifierSets
			//
			final String valCopy = this.assetManager.getValueModifierExecutor()
					.applyAttributeValueModifiers(srcAttrAsString, mappingHintSourceElement.getModifiers());

			// create a new AttributeValueRepresentation or update the existing
			// one
			if (hintValue == null) {
				hintValue = new AttributeValueRepresentation(mappingHintSourceElement.getSource(), valCopy);
			} else {
				hintValue.addValue(valCopy);
			}
		}

		return hintValue;
	}

	/**
	 * For the given list of {@link EObject EObjects}, this returns the
	 * {@link EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature) value or values} of the given {@link EAttribute} as
	 * String. Therefore, the values returned by
	 * {@link ValueExtractor#getAttributeValueAsList(List, SourceSectionAttribute, Logger)} are converted to a String
	 * representation.
	 *
	 * @param sourceElements
	 *            The list of {@link EObject EObjects} for that the values shall be returned.
	 * @param sourceAttribute
	 *            The {@link EAttribute} for that the values shall be returned.
	 * @param logger
	 *            The {@link Logger} to be used to print message to the user.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public static synchronized List<String> getAttributeValueAsStringList(List<EObject> sourceElements,
			SourceSectionAttribute sourceAttribute, Logger logger) {

		return sourceElements.stream()
				.flatMap(e -> ValueExtractor.getAttributeValueAsStringList(e, sourceAttribute, logger).stream())
				.collect(Collectors.toList());
	}

	/**
	 * For the given list of {@link EObject EObjects}, this returns the
	 * {@link EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature) value or values} of the given {@link EAttribute} by
	 * collecting the values returned by
	 * {@link ValueExtractor#getAttributeValueAsList(EObject, SourceSectionAttribute, Logger)} for every element.
	 *
	 * @param sourceElements
	 *            The list of {@link EObject EObjects} for that the values shall be returned.
	 * @param sourceAttribute
	 *            The {@link EAttribute} for that the values shall be returned.
	 * @param logger
	 *            The {@link Logger} to be used to print message to the user.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public static synchronized List<Object> getAttributeValueAsList(List<EObject> sourceElements,
			SourceSectionAttribute sourceAttribute, Logger logger) {

		return sourceElements.stream()
				.flatMap(e -> ValueExtractor.getAttributeValueAsList(e, sourceAttribute, logger).stream())
				.collect(Collectors.toList());
	}

	/**
	 * For the given {@link EObject}, this returns the {@link EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature)
	 * value or values} of the given {@link EAttribute} as String. Therefore, the values returned by
	 * {@link ValueExtractor#getAttributeValueAsList(EObject, SourceSectionAttribute, Logger)} are converted to a String
	 * representation.
	 *
	 * @param sourceElement
	 *            The list of {@link EObject EObjects} for that the values shall be returned.
	 * @param sourceAttribute
	 *            The {@link EAttribute} for that the values shall be returned.
	 * @param logger
	 *            The {@link Logger} to be used to print message to the user.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public static synchronized List<String> getAttributeValueAsStringList(EObject sourceElement,
			SourceSectionAttribute sourceAttribute, Logger logger) {

		List<Object> srcAttrValues = ValueExtractor.getAttributeValueAsList(sourceElement, sourceAttribute, logger);

		EAttribute attribute = sourceAttribute instanceof ActualSourceSectionAttribute
				? ((ActualSourceSectionAttribute) sourceAttribute).getAttribute()
				: null;

		List<String> srcAttrValuesAsString = new ArrayList<>();

		for (Object srcAttrValue : srcAttrValues) {

			// convert Attribute value to String
			String srcAttrAsString = attribute != null ? attribute.getEType().getEPackage().getEFactoryInstance()
					.convertToString(attribute.getEAttributeType(), srcAttrValue) : srcAttrValue.toString();
			srcAttrValuesAsString.add(srcAttrAsString);
		}

		return srcAttrValuesAsString;
	}

	/**
	 * For the given {@link EObject}, this returns the value or values of the given {@link SourceSectionAttribute}.
	 * <p />
	 * Note: Depending on the concrete type of {@link SourceSectionAttribute}, this will either just redirect to
	 * {@link AgteleEcoreUtil#getStructuralFeatureValueAsList(EObject, EStructuralFeature)} (in case of
	 * {@link ActualSourceSectionAttribute ActualSourceSectionAttributes}) or calculate the
	 * {@link VirtualSourceSectionAttribute#getDerivation() derived} value (in case of
	 * {@link VirtualSourceSectionAttribute VirtualSourceSectionAttributes}). <br />
	 * Note: As EAttributes can be {@link EAttribute#isMany() many-valued}, too, this will return either no value, a
	 * single value, or a list of values. <br />
	 * Note: The type of the entries inside the list will match the {@link EAttribute#getEAttributeType() type} of the
	 * given EAttribute for {@link ActualSourceSectionAttribute ActualSourceSectionAttributes}.
	 *
	 * @param sourceElement
	 *            The {@link EObject} for that the values shall be returned.
	 * @param sourceAttribute
	 *            The {@link EAttribute} for that the values shall be returned.
	 * @param logger
	 *            The {@link Logger} to be used to print message to the user.
	 * @return The determined values (either an empty list, a list consisting of a single value, or multiple values).
	 */
	public static synchronized List<Object> getAttributeValueAsList(EObject sourceElement,
			SourceSectionAttribute sourceAttribute, Logger logger) {

		if (sourceAttribute instanceof ActualSourceSectionAttribute) {
			EAttribute eAttribute = ((ActualSourceSectionAttribute) sourceAttribute).getAttribute();
			return AgteleEcoreUtil.getStructuralFeatureValueAsList(sourceElement, eAttribute);
		} else {

			Object result;

			try {
				result = OCLUtil.evaluteQuery(((VirtualSourceSectionAttribute) sourceAttribute).getDerivation(),
						sourceElement);
			} catch (ParserException e) {
				logger.severe(() -> "Unable to evaluate OCL query '"
						+ ((VirtualSourceSectionAttribute) sourceAttribute).getDerivation()
						+ "' for SourceSectionAttribute '" + sourceAttribute.getName() + "'!");
				logger.severe(() -> "The following error occurred: " + e.getMessage());
				e.printStackTrace();
				return new ArrayList<>();
			}

			return result instanceof Collection<?> ? new ArrayList<>((Collection<?>) result)
					: new ArrayList<>(Arrays.asList(result));

		}
	}

}