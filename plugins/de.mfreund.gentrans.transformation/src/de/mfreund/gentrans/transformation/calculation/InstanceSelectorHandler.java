package de.mfreund.gentrans.transformation.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.InstanceSelectorValueExtractor;
import pamtram.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.structure.InstanceSelector;
import pamtram.structure.InstanceSelectorSourceInterface;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.target.TargetSectionAttribute;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * This class will be used to get/extract specific model objects supported by model 'InstanceSelectors' Note: There are
 * two ways: 1.) By 'matchedSection'-HashMap we get specific model objects (from global HashMap defined in the
 * SourceSectionMatcher) 2.) By List we extract specific model objects from a delivered list (so this method can be used
 * everywhere inside generic transformation for minimize the number of specific /concretize model objects
 */
public class InstanceSelectorHandler {

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a
	 * map where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * The {@link InstanceSelectorValueExtractor} that is used to extract target values for InstancePointers.
	 */
	private InstanceSelectorValueExtractor valueExtractor;

	/**
	 * The {@link ValueCalculator} that is used to calculate reference values for {@link ContainerSelector
	 * ContainerSelectors}.
	 */
	private final ValueCalculator valueCalculator;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	private final Logger logger;

	/**
	 * Whether extended parallelization shall be used during the transformation that might lead to the fact that the
	 * transformation result (especially the order of lists) varies between executions.
	 */
	private boolean useParallelization;

	/**
	 * This creates an instance.
	 *
	 * @param matchedSections
	 *            A map relating {@link SourceSection SourceSections} and lists of {@link MatchedSectionDescriptor
	 *            MatchedSectionDescriptors} that have been create for each SourceSection during the <em>matching</em>
	 *            process.
	 * @param globalValues
	 *            The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute
	 *            GlobalAttribute}) defined in the PAMTraM model.
	 * @param attributeValueCalculator
	 *            The {@link ValueCalculator} to use in order to calculate resulting values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 * @param useParallelization
	 *            Whether extended parallelization shall be used during the transformation that might lead to the fact
	 *            that the transformation result (especially the order of lists) varies between executions.
	 */
	public InstanceSelectorHandler(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			GlobalValueMap globalValues, ValueCalculator attributeValueCalculator, Logger logger,
			boolean useParallelization) {

		this.matchedSections = matchedSections;
		this.valueCalculator = attributeValueCalculator;
		this.valueExtractor = new InstanceSelectorValueExtractor(globalValues, this, attributeValueCalculator,
				ValueModifierExecutor.getInstance(), logger, useParallelization);
		this.logger = logger;
		this.useParallelization = useParallelization;

	}

	/**
	 * From the given {@link SourceSectionClass}, this first retrieves all instances from the {@link #matchedSections}
	 * and then filters and returns those that satisfy the given {@link InstanceSelector}.
	 *
	 * @param instanceSelector
	 *            The {@link InstanceSelector} to evaluate.
	 * @param sourceSectionClass
	 *            The {@link SourceSectionClass} for that instances shall be retrieved and filtered.
	 * @param matchedSectionDescriptor
	 *            the {@link MatchedSectionDescriptor} for that the instancePointer shall be evaluated.
	 * @return The subset of <em>instanceList</em> determined based on the given {@link SourceSectionClass} that satisfy
	 *         the given <em>instancePointer</em>.
	 */
	public List<EObject> getSelectedInstancesBySourceSectionClass(SourceInstanceSelector instanceSelector,
			SourceSectionClass sourceSectionClass, MatchedSectionDescriptor matchedSectionDescriptor) {

		EList<EObject> correspondEclassInstances = new BasicEList<>();

		if (this.matchedSections.get(sourceSectionClass.getContainingSection()) != null) {
			this.matchedSections.get(sourceSectionClass.getContainingSection()).stream()
					.forEach(descriptor -> correspondEclassInstances
							.addAll(descriptor.getSourceModelObjectsMapped().get(sourceSectionClass)));
		}

		return this.getSelectedInstancesByInstanceList(instanceSelector, correspondEclassInstances,
				matchedSectionDescriptor);

	}

	/**
	 * From the given list of {@link EObject elements}, this filters and returns those that satisfy the given
	 * {@link InstanceSelector}.
	 *
	 * @param instanceSelector
	 *            The {@link InstanceSelector} to evaluate.
	 * @param instanceList
	 *            The list of matched {@link EObject elements} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the instancePointer shall be evaluated (providing the
	 *            reference value).
	 * @return The subset of the given <em>instanceList</em> that satisfy the given <em>instancePointer</em>.
	 */
	public List<EObject> getSelectedInstancesByInstanceList(SourceInstanceSelector instanceSelector,
			List<EObject> instanceList, MatchedSectionDescriptor matchedSectionDescriptor) {

		if (instanceSelector.getReferenceAttribute() == null) {
			return new ArrayList<>(instanceList);
		}

		if (instanceSelector.getReferenceAttribute() instanceof VirtualAttribute) {
			throw new RuntimeException(
					"Internal Error! InstanceSelectors based on VirtualAttributes are not yet supported!");
		}

		String referenceValue = this.valueExtractor.extractRequiredTargetValue(instanceSelector,
				matchedSectionDescriptor);

		ActualSourceSectionAttribute sourceAttr = (ActualSourceSectionAttribute) instanceSelector
				.getReferenceAttribute();

		return (this.useParallelization ? instanceList.parallelStream() : instanceList.stream()).filter(element -> {

			Object sourceRefAttr = element.eGet(sourceAttr.getAttribute());

			try {
				// convert Attribute value to String
				String sourceRefAttrAsString = sourceAttr.getAttribute().getEType().getEPackage().getEFactoryInstance()
						.convertToString(sourceAttr.getAttribute().getEAttributeType(), sourceRefAttr);
				return sourceRefAttrAsString.equals(referenceValue);

			} catch (final Exception e) {
				this.logger.warning(() -> "Message:\n InstancePointerHander failed because of:" + e.getMessage());
				return false;
			}

		}).collect(Collectors.toList());

	}

	/**
	 * From the given list of {@link EObjectWrapper elements}, this filters and returns those that satisfy the given
	 * {@link InstanceSelector}.
	 *
	 * @param instanceSelector
	 *            The {@link InstanceSelector} to evaluate.
	 * @param instanceList
	 *            The list of created {@link EObjectWrapper elements} to check.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the instancePointer shall be evaluated (providing the
	 *            reference value).
	 * @return The subset of the given <em>instanceList</em> that satisfy the given <em>instancePointer</em>.
	 */
	public List<EObjectWrapper> getSelectedInstancesByInstanceList(TargetInstanceSelector instanceSelector,
			List<EObjectWrapper> instanceList, MatchedSectionDescriptor matchedSectionDescriptor) {

		if (instanceSelector.getReferenceAttribute() == null) {
			return new ArrayList<>(instanceList);
		}

		String referenceValue = this.valueExtractor.extractRequiredTargetValue(instanceSelector,
				matchedSectionDescriptor);

		TargetSectionAttribute targetAttr = instanceSelector.getReferenceAttribute();

		return (this.useParallelization ? instanceList.parallelStream() : instanceList.stream())
				.filter(element -> element.getAttributeValue(targetAttr).equals(referenceValue))
				.collect(Collectors.toList());

	}

	/**
	 * From the given list of potential {@link EObjectWrapper model elements}, filters those that satisfy one of the
	 * given hint values calculated for the given {@link TargetInstanceSelector}.
	 *
	 * @param potentialContainerInstances
	 *            The list of potential {@link EObjectWrapper container instances} to be filtered.
	 * @param instanceSelectorHintValues
	 *            The hint values of the given <em>containerSelector</em> are to be evaluated.
	 * @param targetInstanceSelector
	 *            The {@link TargetInstanceSelector} to evaluate.
	 * @return The filtered list (a subset of the given list) of <em>potentialContainerInstances</em>.
	 */
	public List<EObjectWrapper> filterContainerInstances(List<EObjectWrapper> potentialContainerInstances,
			List<Map<InstanceSelectorSourceInterface, AttributeValueRepresentation>> instanceSelectorHintValues,
			TargetInstanceSelector targetInstanceSelector) {

		// The hint values that will be compared to the value of the 'referenceAttribute' (the 'reference values' of
		// potential target instances. In most cases, there should be only a single hint value. If there are multiple
		// values, these will be treated as alternative values.
		//
		List<String> hintValues = instanceSelectorHintValues.stream()
				.map(v -> this.valueCalculator.calculateValue(
						new ArrayList<>(targetInstanceSelector.getSourceElements()),
						targetInstanceSelector.getExpression(), v, targetInstanceSelector.getModifiers()))
				.collect(Collectors.toList());

		// The reference value(s) (based on the specified 'referenceAttribute') for each of the potential container
		// instances. In the following, these will be compared to the list of 'hintValues'
		//
		Map<EObjectWrapper, List<String>> referenceValueByContainerInstance = potentialContainerInstances.stream()
				.collect(Collectors.toMap(Function.identity(),
						c -> this.getReferenceAttributeInstancesByContainerInstance(c, targetInstanceSelector).stream()
								.map(r -> r.getAttributeValue(targetInstanceSelector.getReferenceAttribute()))
								.collect(Collectors.toList())));

		// Filter those container instances, whose 'reference values' match one of the given 'hint values'
		//
		return referenceValueByContainerInstance.entrySet().stream()
				.filter(e -> !Collections.disjoint(hintValues, e.getValue())).map(Entry::getKey)
				.collect(Collectors.toList());
	}

	/**
	 * For a given {@link TargetInstanceSelector} and a given {@link EObjectWrapper model element} that corresponds to
	 * its {@link TargetInstanceSelector#getTargetClass() targetClass}, returns those {@link EObjectWrapper elements}
	 * that are responsible for providing the reference values for the
	 * {@link TargetInstanceSelector#getReferenceAttribute() referenceAttribute} of the TargetInstanceSelector.
	 * <p />
	 * Note: If the {@link TargetInstanceSelector#getReferenceAttribute() referenceAttribute} of the InstanceSelector is
	 * a direct child of its {@link TargetInstanceSelector#getTargetClass() targetClass}, the given
	 * <em>targetInstance</em> itself is returned. Otherwise, one or multiple elements higher or lower in the
	 * containment hierarchy of the target model fragment are returned.
	 *
	 * @param targetInstance
	 *            The {@link EObjectWrapper} representing the target instance to be checked against the given
	 *            <em>targetInstanceSelector</em>.
	 * @param targetInstanceSelector
	 *            The {@link TargetInstanceSelector} specifying the
	 *            {@link TargetInstanceSelector#getReferenceAttribute() referenceAttribute}.
	 * @return The list of {@link EObjectWrapper elements} that shall be used to determine the reference values for the
	 *         {@link TargetInstanceSelector#getReferenceAttribute() referenceAttribute} of the TargetInstanceSelector
	 *         or an empty list if no suitable model elements could be determined.
	 */
	private List<EObjectWrapper> getReferenceAttributeInstancesByContainerInstance(EObjectWrapper targetInstance,
			TargetInstanceSelector targetInstanceSelector) {

		// The TargetSectionClass representing the given 'targetInstance'
		//
		TargetSectionClass targetClass = targetInstanceSelector.getTargetClass();

		// The TargetSectionClass that defines the 'referenceAttribute' of the TargetInstanceSelector. This may either
		// be
		// the same as the 'targetClass' or a class that is higher or lower in the containment hierarchy
		//
		TargetSectionClass referenceAttributeClass = (TargetSectionClass) targetInstanceSelector.getReferenceAttribute()
				.eContainer();

		if (targetClass.equals(referenceAttributeClass)) {
			return Arrays.asList(targetInstance);
		}

		// The 'referenceAttribute' is located in a TargetSectionClass lower in the containment hierarchy than the
		// 'targetClass'
		//
		if (EcoreUtil.isAncestor(targetClass, referenceAttributeClass)) {

			// Iterate upwards in the containment hierarchy of the TargetSection and collect all references that need to
			// be followed to retrieve the instances of 'referenceAttributeClass' based on the 'targetInstance'
			//
			List<TargetSectionReference> references = new ArrayList<>();
			TargetSectionClass currentClass = referenceAttributeClass;

			while (targetClass != currentClass) {
				CompositeReference<?, ?, ?, ?> owningCompositeReference = currentClass.getOwningContainmentReference();
				if (!(owningCompositeReference instanceof TargetSectionReference)
						|| !(owningCompositeReference.getOwningClass() instanceof TargetSectionClass)) {
					break; // this should not happen
				}

				references.add(0, (TargetSectionReference) owningCompositeReference);
				currentClass = (TargetSectionClass) owningCompositeReference.getOwningClass();
			}

			// Now, follow the collected references to determine the instances of the 'referenceAttributeClass'
			//
			return targetInstance.getReferencedElements(references);
		}

		// The 'reference attribute' is located in a TargetSectionClass higher in the containment hierarchy than the
		// 'container class'
		//
		if (EcoreUtil.isAncestor(referenceAttributeClass, targetClass)) {

			// Iterate upwards in the containment hierarchy to find the (single) container instance representing the
			// 'referenceAttribute'
			//
			EObject referenceAttributeInstance = targetInstance.getEObject();
			TargetSectionClass currentClass = targetClass;
			while (currentClass != referenceAttributeClass) {
				CompositeReference<?, ?, ?, ?> owningCompositeReference = currentClass.getOwningContainmentReference();
				if (!(owningCompositeReference instanceof TargetSectionReference)
						|| !(owningCompositeReference.getOwningClass() instanceof TargetSectionClass)) {
					break; // this should not happen
				}

				referenceAttributeInstance = referenceAttributeInstance.eContainer();
				currentClass = (TargetSectionClass) owningCompositeReference.getOwningClass();
			}

			return Arrays.asList(this.targetSectionRegistry.getInstanceWrapper(referenceAttributeInstance));
		}

		this.logger.severe(() -> "Unable to evaluate " + targetInstanceSelector.eClass().getName() + " '"
				+ targetInstanceSelector.toString() + "'! The specified 'reference attribute' is not valid.");
		return new ArrayList<>();
	}
}