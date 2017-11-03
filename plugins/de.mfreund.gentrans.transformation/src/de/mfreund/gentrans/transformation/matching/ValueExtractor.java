package de.mfreund.gentrans.transformation.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;

import de.mfreund.gentrans.transformation.calculation.InstanceSelectorHandler;
import de.mfreund.gentrans.transformation.calculation.ValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.tud.et.ifa.agtele.emf.AgteleEcoreUtil;
import pamtram.FixedValue;
import pamtram.NamedElement;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.extended.GlobalAttributeImporter;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.ExternalDynamicSourceElement;
import pamtram.structure.GlobalDynamicSourceElement;
import pamtram.structure.LocalDynamicSourceElement;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Reference;
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
public abstract class ValueExtractor extends CancelableElement {

	/**
	 * The {@link ValueModifierExecutor} that shall be used for modifying attribute values.
	 */
	protected final ValueModifierExecutor attributeValueModifierExecutor;

	/**
	 * The {@link InstanceSelectorHandler} used for selecting specific instances when extracting values.
	 */
	protected final InstanceSelectorHandler instanceSelectorHandler;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	protected final Logger logger;

	/**
	 * The {@link GlobalValueMap} that contains the relevant values of {@link GlobalAttribute GlobalAttributes}.
	 */
	protected final GlobalValueMap globalValues;

	/**
	 * Whether extended parallelization shall be used during the transformation that might lead to the fact that the
	 * transformation result (especially the order of lists) varies between executions.
	 */
	protected boolean useParallelization;

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param attributeValueModifierExecutor
	 *            The {@link ValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used for selecting specific instances when extracting values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 * @deprecated use
	 *             {@link #ValueExtractor(GlobalValueMap, InstanceSelectorHandler, ValueModifierExecutor, Logger, boolean)}
	 *             instead
	 */
	@Deprecated
	public ValueExtractor(ValueModifierExecutor attributeValueModifierExecutor,
			InstanceSelectorHandler instanceSelectorHandler, Logger logger, boolean useParallelization) {

		this.attributeValueModifierExecutor = attributeValueModifierExecutor;
		this.instanceSelectorHandler = instanceSelectorHandler;
		this.logger = logger;
		this.useParallelization = useParallelization;
		this.globalValues = new GlobalValueMap();
	}

	/**
	 * This creates an instance for a given list of {@link MatchedSectionDescriptor matchedSectionDescriptors}.
	 *
	 * @param globalValues
	 *            The {@link GlobalValueMap} that contains the relevant values of {@link GlobalAttribute
	 *            GlobalAttributes}.
	 * @param instanceSelectorHandler
	 *            The {@link InstanceSelectorHandler} used for selecting specific instances when extracting values.
	 * @param attributeValueModifierExecutor
	 *            The {@link ValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 */
	public ValueExtractor(GlobalValueMap globalValues, InstanceSelectorHandler instanceSelectorHandler,
			ValueModifierExecutor attributeValueModifierExecutor, Logger logger, boolean useParallelization) {

		this.attributeValueModifierExecutor = attributeValueModifierExecutor;
		this.instanceSelectorHandler = instanceSelectorHandler;
		this.logger = logger;
		this.useParallelization = useParallelization;
		this.globalValues = globalValues;
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

		return this.globalValues.getGlobalAttributes().containsKey(globaleAttributeImporter.getGlobalAttribute())
				? new AttributeValueRepresentation(null,
						this.globalValues.get(globaleAttributeImporter.getGlobalAttribute()))
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
					// Error: could not determine hint value
					return null;
				}
			} while (!sourceDescriptor.getSourceModelObjectsMapped()
					.containsKey(mappingHintSourceElement.getSource().eContainer()));
		}

		Set<EObject> sourceElements = sourceDescriptor.getSourceModelObjectsMapped()
				.get(mappingHintSourceElement.getSource().eContainer());

		if (mappingHintSourceElement instanceof LocalDynamicSourceElement<?, ?, ?, ?>) {

			// If the user specified an additional 'referenceMatchSpec', use
			// only that subset of the determined source elements corresponding
			// to this matching path.
			//
			List<Reference<?, ?, ?, ?>> matchSpec = new ArrayList<>(
					((LocalDynamicSourceElement<?, ?, ?, ?>) mappingHintSourceElement).getReferenceMatchSpec());

			if (!matchSpec.isEmpty()) {

				MatchedSectionDescriptor localDescriptor = sourceDescriptor;
				sourceElements = sourceElements.stream()
						.filter(s -> this.conformsMatchedObjectToMatchingPath(
								localDescriptor.getAssociatedSourceModelElement(), s, matchSpec))
						.collect(Collectors.toSet());
			}
		}

		if (sourceElements == null) {
			this.logger.warning(() -> "Hint source value '" + mappingHintSourceElement.getName() + "' not found!");
			return null;
		}

		return this.extractValue(mappingHintSourceElement, new ArrayList<>(sourceElements));
	}

	private boolean conformsMatchedObjectToMatchingPath(EObject root, EObject element,
			List<Reference<?, ?, ?, ?>> matchSpec) {

		// Create a local copy first
		//
		List<Reference<?, ?, ?, ?>> localReferenceSegments = new ArrayList<>(matchSpec);

		Reference<?, ?, ?, ?> firstSegment = localReferenceSegments.remove(0);

		if (firstSegment instanceof ActualReference<?, ?, ?, ?>) {

			if (!root.eClass().getEAllReferences()
					.contains(((ActualReference<?, ?, ?, ?>) firstSegment).getEReference())) {
				this.logger.severe("Faulty Reference Match Spec encountered!");
				return false;
			}

			List<Object> values = AgteleEcoreUtil.getStructuralFeatureValueAsList(root,
					((ActualReference<?, ?, ?, ?>) firstSegment).getEReference());
			if (localReferenceSegments.isEmpty()) {
				return values.contains(element);
			} else {
				return !localReferenceSegments.isEmpty() && values.stream().filter(v -> v instanceof EObject).anyMatch(
						v -> this.conformsMatchedObjectToMatchingPath((EObject) v, element, localReferenceSegments));
			}

		} else {
			this.logger.severe("Reference Match Specs based on VirtualReferences are not yet supported!");
			return false;
		}
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
			Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			MatchedSectionDescriptor matchedSectionDescriptor, boolean useParallelization) {

		this.checkCanceled();

		List<MatchedSectionDescriptor> sourceDescriptors = matchedSections
				.get(mappingHintSourceElement.getSource().getContainingSection());

		// Collect all instances for the MatchedSectionDescriptors
		//
		List<EObject> sourceElements = (useParallelization ? sourceDescriptors.parallelStream()
				: sourceDescriptors.stream())
						.flatMap(descriptor -> descriptor.getSourceModelObjectsMapped()
								.get(mappingHintSourceElement.getSource().eContainer()).stream())
						.collect(Collectors.toList());

		// Reduce the list of instances based on modeled InstancePointers
		//
		if (!sourceElements.isEmpty() && !mappingHintSourceElement.getInstanceSelectors().isEmpty()) {

			for (SourceInstanceSelector instancePointer : mappingHintSourceElement.getInstanceSelectors()) {

				sourceElements = this.instanceSelectorHandler.getSelectedInstancesByInstanceList(instancePointer,
						sourceElements, matchedSectionDescriptor);
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

		EAttribute sourceAttribute = mappingHintSourceElement.getSource() instanceof ActualSourceSectionAttribute
				? ((ActualSourceSectionAttribute) mappingHintSourceElement.getSource()).getAttribute()
				: null;

		// Collect all values of the attribute in all source elements
		//
		List<Object> srcAttrValues = ValueExtractor.getAttributeValueAsList(sourceElements,
				mappingHintSourceElement.getSource(), this.logger);

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

			final String valCopy = this.attributeValueModifierExecutor.applyAttributeValueModifiers(srcAttrAsString,
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
	public static List<Object> getAttributeValueAsList(List<EObject> sourceElements,
			SourceSectionAttribute sourceAttribute, Logger logger) {

		return sourceElements.stream()
				.flatMap(e -> ValueExtractor.getAttributeValueAsList(e, sourceAttribute, logger).stream())
				.collect(Collectors.toList());
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
	public static List<Object> getAttributeValueAsList(EObject sourceElement, SourceSectionAttribute sourceAttribute,
			Logger logger) {

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