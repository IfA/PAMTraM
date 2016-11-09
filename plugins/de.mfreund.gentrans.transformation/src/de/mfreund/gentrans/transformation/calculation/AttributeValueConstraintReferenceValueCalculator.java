package de.mfreund.gentrans.transformation.calculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.maps.GlobalValueMap;
import de.mfreund.gentrans.transformation.matching.AttributeValueConstraintValueExtractor;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.InstancePointer;
import pamtram.metamodel.RangeBound;
import pamtram.metamodel.SingleReferenceValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionReference;
import pamtram.metamodel.ValueConstraint;
import pamtram.metamodel.ValueConstraintExternalSourceElement;
import pamtram.metamodel.ValueConstraintSourceElement;
import pamtram.metamodel.ValueConstraintSourceInterface;


/**
 * This class can be used to calculate reference values of {@link ValueConstraint
 * AttributeValueConstraints}.
 *
 * @author mfreund
 */
public class AttributeValueConstraintReferenceValueCalculator {

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections;

	/**
	 * The {@link Logger} to be used to print messages.
	 */
	private Logger consoleStream;

	/**
	 * It will be used for extract a more in detail specified Element which was more than one times matched
	 */
	private InstancePointerHandler instancePointerHandler;

	/**
	 * The {@link AttributeValueConstraintValueExtractor} that is used to extract target values for AttributeValueConstraints.
	 */
	private AttributeValueConstraintValueExtractor valueExtractor;

	/**
	 * This creates an instance that can only handled {@link FixedValue
	 * FixedValues} but no referenced {@link SourceSectionAttribute
	 * SourceSectionAttributes}.
	 * <p />
	 * This should be used during the 'matching' phase where these latter
	 * information are not yet present.
	 *
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
	public AttributeValueConstraintReferenceValueCalculator(GlobalValueMap globalValues,
			AttributeValueCalculator attributeValueCalculator, Logger logger) {
		this(new HashMap<>(), globalValues, null, attributeValueCalculator, logger);
	}

	/**
	 * This creates an instance.
	 *
	 * @param matchedSections A map relating {@link SourceSection SourceSections} and lists of {@link MatchedSectionDescriptor
	 * MatchedSectionDescriptors} that have been create for each SourceSection during the <em>matching</em> process.
	 * @param globalValues The <em>global values</em> (values of {@link FixedValue FixedValues} and {@link GlobalAttribute GlobalAttribute})
	 * defined in the PAMTraM model.
	 * @param instancePointerHandler The {@link InstancePointerHandler} that is used to evaluate {@link InstancePointer InstancePointers}
	 * that have been modeled.
	 * @param attributeValueCalculator The {@link AttributeValueCalculator} to use in order to calculate
	 * resulting values.
	 * @param logger The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public AttributeValueConstraintReferenceValueCalculator(
			Map<SourceSection, List<MatchedSectionDescriptor>> matchedSections,
			GlobalValueMap globalValues,
			InstancePointerHandler instancePointerHandler,
			AttributeValueCalculator attributeValueCalculator,
			Logger logger) {

		// store the matched sections
		this.matchedSections = matchedSections;

		// store the message stream
		this.consoleStream = logger;

		// store the 'InstancePointerHandler'
		this.instancePointerHandler = instancePointerHandler;

		// create a value extractor
		this.valueExtractor = new AttributeValueConstraintValueExtractor(
				globalValues.getGlobalAttributes(), attributeValueCalculator, AttributeValueModifierExecutor.getInstance(), this.consoleStream);

	}

	/**
	 * General structure for calculating a reference value (mostly for {@link ValueConstraint}s).
	 *
	 * @param rootObj This is the root element which contains all needed information (e.g. references)
	 * (mostly an instance of {@link ValueConstraint}-child)
	 * @param matchedSectionDescriptor
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(EObject rootObj, MatchedSectionDescriptor matchedSectionDescriptor) {

		String refValue;

		List<InstancePointer> instPointersAsList;
		List<ValueConstraintSourceInterface> sourceElements;

		// The MatchedSectionDescriptor that shall be used to retrieve the values for the various source elements
		//
		MatchedSectionDescriptor descriptorToEvaluate;

		// Fill variables and lists
		if(rootObj instanceof SingleReferenceValueConstraint){
			sourceElements = ((SingleReferenceValueConstraint) rootObj).getSourceElements();
			instPointersAsList = ((SingleReferenceValueConstraint) rootObj).getConstraintReferenceValueAdditionalSpecification();
			descriptorToEvaluate = this.getInstancesToConsider(sourceElements, instPointersAsList,
					((SingleReferenceValueConstraint) rootObj).isLocalConstraint(), matchedSectionDescriptor);
		} else if (rootObj instanceof RangeBound){
			sourceElements = ((RangeBound) rootObj).getSourceElements();
			instPointersAsList = ((RangeBound) rootObj).getBoundReferenceValueAdditionalSpecification();
			descriptorToEvaluate = this.getInstancesToConsider(sourceElements, instPointersAsList,
					((RangeBound) rootObj).isLocalConstraint(), matchedSectionDescriptor);
		} else {
			// more types could be supported in the future
			this.consoleStream
			.severe("AttributeValueConstraint type " + rootObj.getClass().getName() + " is not yet supported!");
			return null; // "" keep running the application (in this case YOU may have to do some changes here?!)
		}

		if(rootObj instanceof SingleReferenceValueConstraint){
			refValue = this.valueExtractor.extractRequiredTargetValue(
					(SingleReferenceValueConstraint) rootObj, descriptorToEvaluate);
		} else {
			refValue = this.valueExtractor.extractRequiredTargetValue(
					(RangeBound) rootObj, descriptorToEvaluate);
		}

		return refValue;
	}

	/**
	 * General structure for calculating a reference value (mostly for {@link ValueConstraint}s).
	 *
	 * @param rootObj This is the root element which contains all needed information (e.g. references)
	 * (mostly an instance of {@link ValueConstraint}-child)
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(EObject rootObj) {

		String refValue;

		List<InstancePointer> instPointersAsList;
		List<ValueConstraintSourceInterface> sourceElements;

		// The MatchedSectionDescriptor that shall be used to retrieve the values for the various source elements
		//
		MatchedSectionDescriptor descriptorToEvaluate;

		// Fill variables and lists
		if(rootObj instanceof SingleReferenceValueConstraint){
			sourceElements = ((SingleReferenceValueConstraint) rootObj).getSourceElements();
			instPointersAsList = ((SingleReferenceValueConstraint) rootObj).getConstraintReferenceValueAdditionalSpecification();
			descriptorToEvaluate = this.getInstancesToConsider(sourceElements, instPointersAsList,
					((SingleReferenceValueConstraint) rootObj).isLocalConstraint(), null);
		} else if (rootObj instanceof RangeBound){
			sourceElements = ((RangeBound) rootObj).getSourceElements();
			instPointersAsList = ((RangeBound) rootObj).getBoundReferenceValueAdditionalSpecification();
			descriptorToEvaluate = this.getInstancesToConsider(sourceElements, instPointersAsList,
					((RangeBound) rootObj).isLocalConstraint(), null);
		} else {
			// more types could be supported in the future
			this.consoleStream
			.severe("AttributeValueConstraint type " + rootObj.getClass().getName() + " is not yet supported!");
			return null; // "" keep running the application (in this case YOU may have to do some changes here?!)
		}

		if(rootObj instanceof SingleReferenceValueConstraint){
			refValue = this.valueExtractor.extractRequiredTargetValue(
					(SingleReferenceValueConstraint) rootObj, descriptorToEvaluate);
		} else {
			refValue = this.valueExtractor.extractRequiredTargetValue(
					(RangeBound) rootObj, descriptorToEvaluate);
		}

		return refValue;
	}

	/**
	 * This collects and returns the list of {@link EObject EObjects} that
	 * need to be considered during the evaluation of the given {@link EObject attributeValueConstraint} for the given
	 * {@link MatchedSectionDescriptor}.
	 * <p />
	 * Depending on the presence of {@link InstancePointer InstancePointers},
	 * only the elements represented by the given <em>matchedSectionDescriptor</em> or the elements
	 * represented by all suitable descriptors stored in the {@link #matchedSections} need to be considered.
	 *
	 * @param EObject The {@link SingleReferenceValueConstraint} to be checked.
	 * @param matchedSectionDescriptor The {@link MatchedSectionDescriptor} that the constraint
	 * shall be checked for.
	 * @return The list of {@link EObject elements of the source model} that need to be
	 * considered when checking the constraint.
	 */
	@SuppressWarnings("unchecked")
	private MatchedSectionDescriptor getInstancesToConsider(
			List<ValueConstraintSourceInterface> sourceElements,
			List<InstancePointer> instancePointers,
			boolean isLocalConstraint,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		List<MatchedSectionDescriptor> descriptorsToConsider;
		Optional<SourceSection> affectedSection;

		if(isLocalConstraint && instancePointers.isEmpty()) {

			// In case of a 'local' constraint without any InstancePointers specified,
			// we only consider the given 'matchedSectionDescriptor'.
			//
			return matchedSectionDescriptor;

		} else {

			// In case of a 'global' constraint or if an InstancePointer has been specified, we
			// have to consider all 'descriptors' for the SourceSection  under consideration
			//
			affectedSection = sourceElements.parallelStream()
					.filter(s -> s instanceof ValueConstraintSourceElement || s instanceof ValueConstraintExternalSourceElement)
					.map(s -> ((ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) s).getSource().getContainingSection()).findAny();

			if(!affectedSection.isPresent()) {
				return matchedSectionDescriptor;
			}

			descriptorsToConsider = this.matchedSections.get(affectedSection.get());
		}

		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = descriptorsToConsider.parallelStream()
				.flatMap(descriptor -> descriptor.getSourceModelObjectsMapped().get(affectedSection.get()).stream())
				.collect(Collectors.toList());

		// Reduce the list of instances based on modeled InstancePointers
		//
		if(!correspondEClassInstances.isEmpty() && !instancePointers.isEmpty()){

			for (InstancePointer instancePointer : instancePointers) {

				correspondEClassInstances = this.instancePointerHandler.getPointedInstanceByInstanceList(
						instancePointer, correspondEClassInstances, matchedSectionDescriptor);
			}

		}

		if(correspondEClassInstances.isEmpty()) {
			return null;

		} else if(correspondEClassInstances.size() > 1) {

			// Multiple instances found -> check if all are represented by the same MatchedSectionDescriptor
			//
			Set<MatchedSectionDescriptor> result = correspondEClassInstances.parallelStream().map(
					e -> MatchedSectionDescriptor.getDescriptorForElement(e, descriptorsToConsider)).filter(d -> d != null).collect(Collectors.toSet());

			if(result.isEmpty()) {
				return null;
			} else if(result.size() > 1) {
				this.consoleStream.severe("Internal Error: Multiple source descriptors found during evaluation of an "
						+
						"AttributeValueConstraint! This should not happen in valid models.");
				return null;
			} else {
				return result.iterator().next();
			}

		} else {

			return MatchedSectionDescriptor.getDescriptorForElement(correspondEClassInstances.get(0), descriptorsToConsider);
		}
	}

}
