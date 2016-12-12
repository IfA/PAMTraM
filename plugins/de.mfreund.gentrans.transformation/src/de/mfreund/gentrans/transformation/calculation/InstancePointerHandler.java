package de.mfreund.gentrans.transformation.calculation;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.InstancePointerValueExtractor;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.Mapping;
import pamtram.structure.ActualSourceSectionAttribute;
import pamtram.structure.InstancePointer;
import pamtram.structure.SourceSection;
import pamtram.structure.SourceSectionClass;

/**
 * This class will be used to get/extract specific model objects supported by model 'InstancePointers'
 * Note: There are two ways:
 * 1.) By 'matchedSection'-HashMap we get specific model objects (from global HashMap defined in the SourceSectionMatcher)
 * 2.) By List we extract specific model objects from a delivered list (so this method can be used everywhere inside generic transformation for minimize the number of specific /concretize model objects
 */
public class InstancePointerHandler{

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * The {@link InstancePointerValueExtractor} that is used to extract target values for InstancePointers.
	 */
	private InstancePointerValueExtractor valueExtractor;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	private final Logger logger;

	/**
	 * This creates an instance.
	 *
	 * @param matchedSections
	 *            A map relating {@link SourceSection SourceSections} and lists
	 *            of {@link MatchedSectionDescriptor MatchedSectionDescriptors}
	 *            that have been create for each SourceSection during the
	 *            <em>matching</em> process.
	 * @param globalValues
	 *            The <em>global values</em> (values of {@link FixedValue
	 *            FixedValues} and {@link GlobalAttribute GlobalAttribute})
	 *            defined in the PAMTraM model.
	 * @param attributeValueCalculator
	 *            The {@link AttributeValueCalculator} to use in order to
	 *            calculate resulting values.
	 * @param logger
	 *            The {@link Logger} that shall be used to print messages.
	 */
	public InstancePointerHandler(Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			GlobalValueMap globalValues, AttributeValueCalculator attributeValueCalculator, Logger logger) {

		this.matchedSections = matchedSections;
		this.valueExtractor = new InstancePointerValueExtractor(
				globalValues.getGlobalAttributes(), attributeValueCalculator,
				AttributeValueModifierExecutor.getInstance(), logger);
		this.logger = logger;

	}

	/**
	 * From the given {@link SourceSectionClass}, this first retrieves all instances from the {@link #matchedSections} and then
	 * filters and returns those that satisfy the given {@link InstancePointer}.
	 *
	 * @param instancePointer The {@link InstancePointer} to evaluate.
	 * @param sourceSectionClass The {@link SourceSectionClass} for that instances shall be retrieved and filtered.
	 * @param matchedSectionDescriptor the {@link MatchedSectionDescriptor} for that the instancePointer shall be evaluated.
	 * @return The subset of <em>instanceList</em> determined based on the given {@link SourceSectionClass} that satisfy
	 * the given <em>instancePointer</em>.
	 */
	public List<EObject> getPointedInstanceBySourceSectionClass(InstancePointer instancePointer,
			SourceSectionClass sourceSectionClass, MatchedSectionDescriptor matchedSectionDescriptor){

		EList<EObject> correspondEclassInstances = new BasicEList<>();

		if(this.matchedSections.get(sourceSectionClass.getContainingSection()) != null) {
			this.matchedSections.get(sourceSectionClass.getContainingSection()).stream().forEach(descriptor ->
			correspondEclassInstances.addAll(descriptor.getSourceModelObjectsMapped().get(sourceSectionClass)));
		}

		return this.getPointedInstanceByInstanceList(instancePointer, correspondEclassInstances, matchedSectionDescriptor);

	}

	/**
	 * From the given list of {@link EObject elements}, this filters and returns those that satisfy the given
	 * {@link InstancePointer}.
	 *
	 * @param instancePointer The {@link InstancePointer} to evaluate.
	 * @param instanceList The list of {@link EObject elements} to check.
	 * @param matchedSectionDescriptor the {@link MatchedSectionDescriptor} for that the instancePointer shall be evaluated.
	 * @return The subset of the given <em>instanceList</em> that satisfy the given <em>instancePointer</em>.
	 */
	public List<EObject> getPointedInstanceByInstanceList(InstancePointer instancePointer, List<EObject> instanceList,
			MatchedSectionDescriptor matchedSectionDescriptor){

		EObject container = instancePointer.eContainer();

		while(!(container instanceof Mapping)) {
			container = container.eContainer();
		}

		String instancePointerRefValue = this.valueExtractor.extractRequiredTargetValue(instancePointer, matchedSectionDescriptor);

		ActualSourceSectionAttribute sourceAttr = instancePointer.getTarget();

		return instanceList.parallelStream().filter(element -> {

			Object sourceRefAttr = element.eGet(instancePointer.getTarget().getAttribute());

			try{
				// convert Attribute value to String
				String sourceRefAttrAsString = sourceAttr.getAttribute().getEType().getEPackage().getEFactoryInstance()
						.convertToString(sourceAttr.getAttribute().getEAttributeType(), sourceRefAttr);
				return sourceRefAttrAsString.equals(instancePointerRefValue);

			} catch(final Exception e){
				this.logger.warning("Message:\n InstancePointerHander failed because of:" + e.getMessage());
				return false;
			}

		}).collect(Collectors.toList());

	}

}