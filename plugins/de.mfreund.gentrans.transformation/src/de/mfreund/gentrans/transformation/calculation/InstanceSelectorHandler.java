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
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.mfreund.gentrans.transformation.core.TransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.matching.InstanceSelectorValueExtractor;
import pamtram.structure.InstanceSelector;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.TargetInstanceSelector;
import pamtram.structure.generic.CompositeReference;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionReference;

/**
 * This class will be used to get/extract specific model objects supported by model 'InstanceSelectors' Note: There are
 * two ways: 1.) By 'matchedSection'-HashMap we get specific model objects (from global HashMap defined in the
 * SourceSectionMatcher) 2.) By List we extract specific model objects from a delivered list (so this method can be used
 * everywhere inside generic transformation for minimize the number of specific /concretize model objects
 */
public class InstanceSelectorHandler extends TransformationAsset {

	/**
	 * The {@link InstanceSelectorValueExtractor} that is used to extract target values for InstancePointers.
	 */
	private InstanceSelectorValueExtractor valueExtractor;

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

		super(assetManager);

		this.valueExtractor = new InstanceSelectorValueExtractor(assetManager);
		this.useParallelization = assetManager.getTransformationConfig().isUseParallelization();

	}

	/**
	 * From the given list of {@link EObject elements}, this filters and returns those that satisfy the given
	 * {@link InstanceSelector}.
	 *
	 * @param instanceList
	 *            The list of matched {@link EObject elements} to check.
	 * @param instanceSelector
	 *            The {@link InstanceSelector} to evaluate.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the instancePointer shall be evaluated (providing the
	 *            reference value).
	 *
	 * @return The subset of the given <em>instanceList</em> that satisfy the given <em>instancePointer</em>.
	 */
	public List<EObject> filterSourceInstances(List<EObject> instanceList, SourceInstanceSelector instanceSelector,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		if (instanceSelector.getReferenceAttribute() == null) {
			return new ArrayList<>(instanceList);
		}

		String referenceValue = this.valueExtractor.extractRequiredTargetValue(instanceSelector,
				matchedSectionDescriptor);

		return this.filterSourceInstances(instanceList, instanceSelector, Arrays.asList(referenceValue));

	}

	/**
	 * From the given list of {@link EObjectWrapper elements}, this filters and returns those that satisfy the given
	 * {@link InstanceSelector}.
	 *
	 * @param instanceList
	 *            The list of created {@link EObjectWrapper elements} to check.
	 * @param instanceSelector
	 *            The {@link InstanceSelector} to evaluate.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} for that the instancePointer shall be evaluated (providing the
	 *            reference value).
	 *
	 * @return The subset of the given <em>instanceList</em> that satisfy the given <em>instancePointer</em>.
	 */
	public List<EObjectWrapper> filterTargetInstances(List<EObjectWrapper> instanceList,
			TargetInstanceSelector instanceSelector, MatchedSectionDescriptor matchedSectionDescriptor) {

		if (instanceSelector.getReferenceAttribute() == null) {
			return new ArrayList<>(instanceList);
		}

		String referenceValue = this.valueExtractor.extractRequiredTargetValue(instanceSelector,
				matchedSectionDescriptor);

		return this.filterTargetInstances(instanceList, instanceSelector, Arrays.asList(referenceValue));

	}

	/**
	 * From the given list of potential {@link EObjectWrapper model elements}, filters those that satisfy one of the
	 * given hint values calculated for the given {@link TargetInstanceSelector}.
	 *
	 * @param potentialSourceInstances
	 *            The list of potential {@link EObject source instances} to be filtered.
	 * @param sourceInstanceSelector
	 *            The {@link SourceInstanceSelector} to evaluate.
	 * @param instanceSelectorHintValues
	 *            The hint values of the given <em>sourceInstanceSelector</em> to be evaluated.
	 * @return The filtered list of <em>potentialSourceInstances</em>. The order of the instances is determined by the
	 *         order of hint values.
	 */
	public List<EObject> filterSourceInstances(List<EObject> potentialSourceInstances,
			SourceInstanceSelector sourceInstanceSelector, List<String> instanceSelectorHintValues) {

		if (potentialSourceInstances == null || potentialSourceInstances.isEmpty()) {

			// Nothing to filter
			//
			return new ArrayList<>();
		}

		if (sourceInstanceSelector.getReferenceAttribute() == null) {

			// Nothing to filter
			//
			return new ArrayList<>(potentialSourceInstances);
		}

		// The reference value(s) (based on the specified 'referenceAttribute') for each of the potential source
		// instances. In the following, these will be compared to the list of 'hintValues'.
		//
		Map<EObject, List<String>> referenceValueBySourceInstance = potentialSourceInstances.stream()
				.collect(Collectors.toMap(Function.identity(),
						c -> this.getReferenceAttributeInstancesBySourceInstance(c, sourceInstanceSelector).stream()
								.flatMap(r -> InstanceSelectorHandler.this.assetManager.getModelAccessUtil()
										.getAttributeValueAsStringList(r,
												sourceInstanceSelector.getReferenceAttribute())
										.stream())
								.collect(Collectors.toList())));

		// Filter those target instances, whose 'reference values' match one of the given 'hint values' and store them
		// in a map relating the list of potential target instances for each of the specified hint values
		//
		Map<String, List<EObject>> sourceInstancesByHintValue = instanceSelectorHintValues.stream()
				.collect(LinkedHashMap::new, (m, hv) -> m.put(hv, referenceValueBySourceInstance.entrySet().stream()
						.filter(e -> e.getValue().contains(hv)).map(Entry::getKey).collect(Collectors.toList())),
						Map::putAll);

		// Return the filtered instances ordered by the hint values
		//
		return new ArrayList<>(sourceInstancesByHintValue.values().stream().flatMap(Collection::stream)
				.collect(LinkedHashSet::new, LinkedHashSet::add, LinkedHashSet::addAll));

	}

	/**
	 * From the given list of potential {@link EObjectWrapper model elements}, filters those that satisfy one of the
	 * given hint values calculated for the given {@link TargetInstanceSelector}.
	 *
	 * @param potentialTargetInstances
	 *            The list of potential {@link EObjectWrapper target instances} to be filtered.
	 * @param targetInstanceSelector
	 *            The {@link TargetInstanceSelector} to evaluate.
	 * @param instanceSelectorHintValues
	 *            The hint values of the given <em>targetInstanceSelector</em> to be evaluated.
	 * @return The filtered list of <em>potentialTargetInstances</em>. The order of the instances is determined by the
	 *         order of hint values.
	 */
	public List<EObjectWrapper> filterTargetInstances(List<EObjectWrapper> potentialTargetInstances,
			TargetInstanceSelector targetInstanceSelector, List<String> instanceSelectorHintValues) {

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
	 * For a given {@link SourceInstanceSelector} and a given {@link EObject model element} that corresponds to its
	 * {@link SourceInstanceSelector#getTargetClass() targetClass}, returns those {@link EObject elements} that are
	 * responsible for providing the reference values for the {@link SourceInstanceSelector#getReferenceAttribute()
	 * referenceAttribute} of the SourceInstanceSelector.
	 * <p />
	 * Note: If the {@link SourceInstanceSelector#getReferenceAttribute() referenceAttribute} of the InstanceSelector is
	 * a direct child of its {@link SourceInstanceSelector#getTargetClass() targetClass}, the given
	 * <em>sourceInstance</em> itself is returned. Otherwise, one or multiple elements higher or lower in the
	 * containment hierarchy of the target model fragment are returned.
	 *
	 * @param sourceInstance
	 *            The {@link EObject} representing the source instance to be checked against the given
	 *            <em>sourceInstanceSelector</em>.
	 * @param sourceInstanceSelector
	 *            The {@link SourceInstanceSelector} specifying the
	 *            {@link SourceInstanceSelector#getReferenceAttribute() referenceAttribute}.
	 * @return The list of {@link EObject elements} that shall be used to determine the reference values for the
	 *         {@link SourceInstanceSelector#getReferenceAttribute() referenceAttribute} of the SourceInstanceSelector
	 *         or an empty list if no suitable model elements could be determined.
	 */
	private List<EObject> getReferenceAttributeInstancesBySourceInstance(EObject sourceInstance,
			SourceInstanceSelector sourceInstanceSelector) {

		if (sourceInstance == null) {

			// Nothing to filter
			//
			return new ArrayList<>();
		}

		if (sourceInstanceSelector.getReferenceAttribute() == null) {

			// Nothing to filter
			//
			return new ArrayList<>(Arrays.asList(sourceInstance));
		}

		// The SourceSectionClasses representing the given 'targetInstance'
		//
		EList<SourceSectionClass> sourceClasses = sourceInstanceSelector.getTargetClass().getAllConcreteExtending();

		// The SourceSectionClasses that define the 'referenceAttribute' of the SourceInstanceSelector. This may either
		// be the same as the 'targetClass' or a class that is higher or lower in the containment hierarchy
		//
		EList<SourceSectionClass> referenceAttributeClasses = sourceInstanceSelector.getReferenceAttribute()
				.getOwningClass().getAllConcreteExtending();

		if (!Collections.disjoint(sourceClasses, referenceAttributeClasses)) {
			return Arrays.asList(sourceInstance);
		}

		Optional<MatchedSectionDescriptor> descriptor = this.assetManager.getMatchedSectionRegistry()
				.getRegisteredDescriptorFor(sourceInstance);

		if (descriptor.isPresent()) {

			return referenceAttributeClasses.stream()
					.flatMap(c -> descriptor.get().getMatchedSourceModelElementsFor(c, true).stream())
					.collect(Collectors.toList());
		} else {

			this.logger.severe(() -> "Unable to evaluate " + sourceInstanceSelector.printInfo()
					+ "! No descriptor found for the source model element!");
			return new ArrayList<>();
		}

	}

	/**
	 * This returns the {@link EObject element or elements} determined by iteratively evaluating the given list of
	 * {@link SourceSectionReference SourceSectionReference}.
	 * <p />
	 * The referenced elements are determined by redirecting to {@link EStructuralFeature#eGet(EStructuralFeature)}.
	 * <p />
	 * Note: As EReferences can be {@link EStructuralFeature#isMany() many-valued}, this will return either no value, a
	 * single value, or a list of values.
	 *
	 * @param sourceInstance
	 *            The base instance from which the references are to be followed.
	 * @param references
	 *            The {@link SourceSectionReference references} that are iteratively applied to determine the elements
	 *            to return.
	 * @return The determined referenced elements (either an empty list, a list consisting of a single value, or
	 *         multiple values). If <em>eReferences</em> is empty, returns a list containing the given <em>eObject</em>.
	 */
	private List<EObject> getReferencedElements(EObject sourceInstance, List<SourceSectionReference> references) {

		if (references.isEmpty()) {
			return Arrays.asList(sourceInstance);
		}

		SourceSectionReference firstReference = references.remove(0);

		this.assetManager.getModelAccessUtil().getReferenceValueAsList(sourceInstance, firstReference);

		List<EObject> referencedElements = this.assetManager.getModelAccessUtil()
				.getReferenceValueAsList(sourceInstance, firstReference);

		return referencedElements.stream()
				.flatMap(e -> this.getReferencedElements(e, new ArrayList<>(references)).stream())
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
	private List<EObjectWrapper> getReferenceAttributeInstancesByTargetInstance(EObjectWrapper targetInstance,
			TargetInstanceSelector targetInstanceSelector) {

		if (targetInstance == null) {

			// Nothing to filter
			//
			return new ArrayList<>();
		}

		if (targetInstanceSelector.getReferenceAttribute() == null) {

			// Nothing to filter
			//
			return new ArrayList<>(Arrays.asList(targetInstance));
		}

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
				.filter(c -> targetClasses.stream().anyMatch(c::isContainedIn)).findAny();

		if (descendantReferenceAttributeClass.isPresent()) {

			TargetSectionClass ancestorTargetClass = targetClasses.stream()
					.filter(c -> descendantReferenceAttributeClass.get().isContainedIn(c)).findAny().get();

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
				.filter(c -> referenceAttributeClasses.stream().anyMatch(sc -> sc.isContainerFor(c))).findAny();
		if (descendantTargetClass.isPresent()) {

			TargetSectionClass ancestorReferenceAttributeClass = referenceAttributeClasses.stream()
					.filter(c -> c.isContainerFor(descendantTargetClass.get())).findAny().get();

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

			return Arrays.asList(
					this.assetManager.getTargetSectionRegistry().getInstanceWrapper(referenceAttributeInstance));
		}

		this.logger.severe(() -> "Unable to evaluate " + targetInstanceSelector.printInfo()
				+ "! The specified 'reference attribute' is not valid.");
		return new ArrayList<>();
	}
}