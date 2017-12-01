package de.mfreund.gentrans.transformation.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.matching.InstanceSelectorValueExtractor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import pamtram.structure.InstanceSelector;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.generic.VirtualAttribute;
import pamtram.structure.source.ActualSourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.target.TargetSection;
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
	private MatchedSectionRegistry matchedSectionRegistry;

	/**
	 * The {@link TargetSectionRegistry} where instantiated {@link TargetSection TargetSections} are stored.
	 */
	private TargetSectionRegistry targetSectionRegistry;

	/**
	 * The {@link InstanceSelectorValueExtractor} that is used to extract target values for InstancePointers.
	 */
	private InstanceSelectorValueExtractor valueExtractor;

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
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public InstanceSelectorHandler(TransformationAssetManager assetManager) {

		this.matchedSectionRegistry = assetManager.getMatchedSectionRegistry();
		this.targetSectionRegistry = assetManager.getTargetSectionRegistry();
		this.valueExtractor = new InstanceSelectorValueExtractor(assetManager);
		this.logger = assetManager.getLogger();
		this.useParallelization = assetManager.getTransformationConfig().isUseParallelization();

	}

	/**
	 * From the given {@link SourceSectionClass}, this first retrieves all instances from the
	 * {@link #matchedSectionRegistry} and then filters and returns those that satisfy the given
	 * {@link InstanceSelector}.
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

		this.matchedSectionRegistry.get(sourceSectionClass.getContainingSection()).stream()
				.forEach(descriptor -> correspondEclassInstances
						.addAll(descriptor.getMatchedSourceModelElementsFor(sourceSectionClass)));

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
	 * @param potentialTargetInstances
	 *            The list of potential {@link EObjectWrapper target instances} to be filtered.
	 * @param instanceSelectorHintValues
	 *            The hint values of the given <em>targetInstanceSelector</em> to be evaluated.
	 * @param targetInstanceSelector
	 *            The {@link TargetInstanceSelector} to evaluate.
	 * @return The filtered list of <em>potentialTargetInstances</em>. The order of the instances is determined by the
	 *         order of hint values.
	 */
	public List<EObjectWrapper> filterTargetInstances(List<EObjectWrapper> potentialTargetInstances,
			List<String> instanceSelectorHintValues, TargetInstanceSelector targetInstanceSelector) {

		if (potentialTargetInstances == null || potentialTargetInstances.isEmpty()) {

			// Nothing to filter
			//
			return new ArrayList<>();
		}

		if (targetInstanceSelector.getReferenceAttribute() == null) {

			// Nothing to filter
			//
			return new ArrayList<>(potentialTargetInstances);
		}

		// The reference value(s) (based on the specified 'referenceAttribute') for each of the potential target
		// instances. In the following, these will be compared to the list of 'hintValues'.
		//
		Map<EObjectWrapper, List<String>> referenceValueByTargetInstance = potentialTargetInstances.stream()
				.collect(Collectors.toMap(Function.identity(),
						c -> this.getReferenceAttributeInstancesByTargetInstance(c, targetInstanceSelector).stream()
								.map(r -> r.getAttributeValue(targetInstanceSelector.getReferenceAttribute()))
								.collect(Collectors.toList())));

		// Filter those target instances, whose 'reference values' match one of the given 'hint values' and store them
		// in a map relating the list of potential target instances for each of the specified hint values
		//
		Map<String, List<EObjectWrapper>> targetInstancesByHintValue = instanceSelectorHintValues.stream()
				.collect(LinkedHashMap::new, (m, hv) -> m.put(hv, referenceValueByTargetInstance.entrySet().stream()
						.filter(e -> e.getValue().contains(hv)).map(Entry::getKey).collect(Collectors.toList())),
						Map::putAll);

		// Return the filtered instances ordered by the hint values
		//
		return new ArrayList<>(targetInstancesByHintValue.values().stream().flatMap(Collection::stream)
				.collect(LinkedHashSet::new, LinkedHashSet::add, LinkedHashSet::addAll));

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
	private List<EObjectWrapper> getReferenceAttributeInstancesByTargetInstance(EObjectWrapper targetInstance,
			TargetInstanceSelector targetInstanceSelector) {

		// The TargetSectionClasses representing the given 'targetInstance'
		//
		EList<TargetSectionClass> targetClasses = targetInstanceSelector.getTargetClass().getAllConcreteExtending();

		// The TargetSectionClasses that define the 'referenceAttribute' of the TargetInstanceSelector. This may either
		// be the same as the 'targetClass' or a class that is higher or lower in the containment hierarchy
		//
		EList<TargetSectionClass> referenceAttributeClasses = ((TargetSectionClass) targetInstanceSelector
				.getReferenceAttribute().eContainer()).getAllConcreteExtending();

		if (!Collections.disjoint(targetClasses, referenceAttributeClasses)) {
			return Arrays.asList(targetInstance);
		}

		// The 'referenceAttribute' is located in a TargetSectionClass lower in the containment hierarchy than the
		// 'targetClass'
		//
		Optional<TargetSectionClass> descendantReferenceAttributeClass = referenceAttributeClasses.parallelStream()
				.filter(c -> EcoreUtil.isAncestor(targetClasses, c)).findAny();

		if (descendantReferenceAttributeClass.isPresent()) {

			TargetSectionClass ancestorTargetClass = targetClasses.stream()
					.filter(c -> EcoreUtil.isAncestor(c, descendantReferenceAttributeClass.get())).findAny().get();

			// Iterate upwards in the containment hierarchy of the TargetSection and collect all references that need to
			// be followed to retrieve the instances of 'referenceAttributeClass' based on the 'targetInstance'
			//
			List<TargetSectionReference> references = new ArrayList<>();
			TargetSectionClass currentClass = descendantReferenceAttributeClass.get();

			while (ancestorTargetClass != currentClass) {
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
		// 'referenceAttributeClass'
		//
		Optional<TargetSectionClass> descendantTargetClass = targetClasses.parallelStream()
				.filter(c -> EcoreUtil.isAncestor(referenceAttributeClasses, c)).findAny();
		if (descendantTargetClass.isPresent()) {

			TargetSectionClass ancestorReferenceAttributeClass = referenceAttributeClasses.stream()
					.filter(c -> EcoreUtil.isAncestor(c, descendantTargetClass.get())).findAny().get();

			// Iterate upwards in the containment hierarchy to find the (single) instance representing the
			// 'referenceAttribute'
			//
			EObject referenceAttributeInstance = targetInstance.getEObject();
			TargetSectionClass currentClass = descendantTargetClass.get();

			while (currentClass != ancestorReferenceAttributeClass) {
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