/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.calculation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.matching.AttributeValueConstraintValueExtractor;
import de.mfreund.gentrans.transformation.registries.MatchedSectionRegistry;
import pamtram.structure.DynamicSourceElement;
import pamtram.structure.InstanceSelector;
import pamtram.structure.SourceInstanceSelector;
import pamtram.structure.constraint.SingleReferenceValueConstraint;
import pamtram.structure.constraint.ValueConstraint;
import pamtram.structure.constraint.ValueConstraintExternalSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceElement;
import pamtram.structure.constraint.ValueConstraintSourceInterface;
import pamtram.structure.source.SourceSection;
import pamtram.structure.source.SourceSectionAttribute;
import pamtram.structure.source.SourceSectionClass;
import pamtram.structure.source.SourceSectionReference;

/**
 * This class can be used to calculate reference values of {@link ValueConstraint ValueConstraints}.
 *
 * @author mfreund
 */
public class ValueConstraintReferenceValueCalculator {

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a
	 * map where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private MatchedSectionRegistry matchedSections;

	/**
	 * The {@link Logger} to be used to print messages.
	 */
	private Logger consoleStream;

	/**
	 * It will be used for extract a more in detail specified Element which was more than one times matched
	 */
	private InstanceSelectorHandler instanceSelectorHandler;

	/**
	 * The {@link AttributeValueConstraintValueExtractor} that is used to extract target values for
	 * AttributeValueConstraints.
	 */
	private AttributeValueConstraintValueExtractor valueExtractor;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public ValueConstraintReferenceValueCalculator(TransformationAssetManager assetManager) {

		// store the matched sections
		this.matchedSections = assetManager.getMatchedSectionRegistry();

		// store the message stream
		this.consoleStream = assetManager.getLogger();

		// store the 'InstanceSelectorHandler'
		this.instanceSelectorHandler = assetManager.getInstanceSelectorHandler();

		// create a value extractor
		this.valueExtractor = new AttributeValueConstraintValueExtractor(assetManager);

	}

	/**
	 * General structure for calculating a reference value (mostly for {@link ValueConstraint}s).
	 *
	 * @param rootObj
	 *            This is the root element which contains all needed information (e.g. references) (mostly an instance
	 *            of {@link ValueConstraint}-child)
	 * @param matchedSectionDescriptor
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(EObject rootObj, MatchedSectionDescriptor matchedSectionDescriptor) {

		String refValue;

		List<SourceInstanceSelector> instPointersAsList;
		List<ValueConstraintSourceInterface> sourceElements;

		// The MatchedSectionDescriptor that shall be used to retrieve the
		// values for the various source elements
		//
		MatchedSectionDescriptor descriptorToEvaluate;

		// Fill variables and lists
		if (rootObj instanceof SingleReferenceValueConstraint) {
			sourceElements = ((SingleReferenceValueConstraint) rootObj).getSourceElements();
			instPointersAsList = ((SingleReferenceValueConstraint) rootObj).getInstanceSelectors();
			descriptorToEvaluate = this.getInstancesToConsider(sourceElements, instPointersAsList,
					((SingleReferenceValueConstraint) rootObj).isLocalConstraint(), matchedSectionDescriptor);
		} else {
			// more types could be supported in the future
			this.consoleStream.severe(
					() -> "AttributeValueConstraint type " + rootObj.getClass().getName() + " is not yet supported!");
			return null; // "" keep running the application (in this case YOU
							// may have to do some changes here?!)
		}

		// if (rootObj instanceof SingleReferenceValueConstraint) {
		refValue = this.valueExtractor.extractRequiredTargetValue((SingleReferenceValueConstraint) rootObj,
				descriptorToEvaluate);
		// } else {
		// refValue =
		// this.valueExtractor.extractRequiredTargetValue((RangeBound) rootObj,
		// descriptorToEvaluate);
		// }

		return refValue;
	}

	/**
	 * General structure for calculating a reference value (mostly for {@link ValueConstraint}s).
	 *
	 * @param rootObj
	 *            This is the root element which contains all needed information (e.g. references) (mostly an instance
	 *            of {@link ValueConstraint}-child)
	 * @return The calculated attribute value or <em>""</em> if no value could be calculated.
	 */
	public String calculateReferenceValue(EObject rootObj) {

		String refValue;

		List<SourceInstanceSelector> instPointersAsList;
		List<ValueConstraintSourceInterface> sourceElements;

		// The MatchedSectionDescriptor that shall be used to retrieve the
		// values for the various source elements
		//
		MatchedSectionDescriptor descriptorToEvaluate;

		// Fill variables and lists
		if (rootObj instanceof SingleReferenceValueConstraint) {
			sourceElements = ((SingleReferenceValueConstraint) rootObj).getSourceElements();
			instPointersAsList = ((SingleReferenceValueConstraint) rootObj).getInstanceSelectors();
			descriptorToEvaluate = this.getInstancesToConsider(sourceElements, instPointersAsList,
					((SingleReferenceValueConstraint) rootObj).isLocalConstraint(), null);
			// } else if (rootObj instanceof RangeBound) {
			// sourceElements = ((RangeBound) rootObj).getSourceElements();
			// instPointersAsList = ((RangeBound)
			// rootObj).getBoundReferenceValueAdditionalSpecification();
			// descriptorToEvaluate =
			// this.getInstancesToConsider(sourceElements, instPointersAsList,
			// ((RangeBound) rootObj).isLocalConstraint(), null);
		} else {
			// more types could be supported in the future
			this.consoleStream.severe(
					() -> "AttributeValueConstraint type " + rootObj.getClass().getName() + " is not yet supported!");
			return null; // "" keep running the application (in this case YOU
							// may have to do some changes here?!)
		}

		// if (rootObj instanceof SingleReferenceValueConstraint) {
		refValue = this.valueExtractor.extractRequiredTargetValue((SingleReferenceValueConstraint) rootObj,
				descriptorToEvaluate);
		// } else {
		// refValue =
		// this.valueExtractor.extractRequiredTargetValue((RangeBound) rootObj,
		// descriptorToEvaluate);
		// }

		return refValue;
	}

	/**
	 * This collects and returns the list of {@link EObject EObjects} that need to be considered during the evaluation
	 * of the given {@link EObject attributeValueConstraint} for the given {@link MatchedSectionDescriptor}.
	 * <p />
	 * Depending on the presence of {@link InstanceSelector InstancePointers}, only the elements represented by the
	 * given <em>matchedSectionDescriptor</em> or the elements represented by all suitable descriptors stored in the
	 * {@link #matchedSections} need to be considered.
	 *
	 * @param EObject
	 *            The {@link SingleReferenceValueConstraint} to be checked.
	 * @param matchedSectionDescriptor
	 *            The {@link MatchedSectionDescriptor} that the constraint shall be checked for.
	 * @return The list of {@link EObject elements of the source model} that need to be considered when checking the
	 *         constraint.
	 */
	@SuppressWarnings("unchecked")
	private MatchedSectionDescriptor getInstancesToConsider(List<ValueConstraintSourceInterface> sourceElements,
			List<SourceInstanceSelector> instancePointers, boolean isLocalConstraint,
			MatchedSectionDescriptor matchedSectionDescriptor) {

		List<MatchedSectionDescriptor> descriptorsToConsider;
		Optional<SourceSection> affectedSection;

		if (isLocalConstraint && instancePointers.isEmpty()) {

			// In case of a 'local' constraint without any InstancePointers
			// specified,
			// we only consider the given 'matchedSectionDescriptor'.
			//
			return matchedSectionDescriptor;

		} else {

			// In case of a 'global' constraint or if an InstanceSelector has
			// been specified, we
			// have to consider all 'descriptors' for the SourceSection under
			// consideration
			//
			affectedSection = sourceElements.parallelStream().filter(
					s -> s instanceof ValueConstraintSourceElement || s instanceof ValueConstraintExternalSourceElement)
					.map(s -> ((DynamicSourceElement<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) s)
							.getSource().getContainingSection())
					.findAny();

			if (!affectedSection.isPresent()) {
				return matchedSectionDescriptor;
			}

			descriptorsToConsider = this.matchedSections.get(affectedSection.get());
		}

		// Collect all instances for the selected MatchedSectionDescriptors
		//
		List<EObject> correspondEClassInstances = descriptorsToConsider.parallelStream()
				.flatMap(descriptor -> descriptor.getMatchedSourceModelElementsFor(affectedSection.get(), false).stream())
				.collect(Collectors.toList());

		// Reduce the list of instances based on modeled InstancePointers
		//
		if (!correspondEClassInstances.isEmpty() && !instancePointers.isEmpty()) {

			for (SourceInstanceSelector instancePointer : instancePointers) {

				correspondEClassInstances = this.instanceSelectorHandler.filterSourceInstances(
						correspondEClassInstances, instancePointer, matchedSectionDescriptor);
			}

		}

		if (correspondEClassInstances.isEmpty()) {
			return null;

		} else if (correspondEClassInstances.size() > 1) {

			// Multiple instances found -> check if all are represented by the
			// same MatchedSectionDescriptor
			//
			Set<MatchedSectionDescriptor> result = correspondEClassInstances.parallelStream()
					.map(e -> MatchedSectionDescriptor.getDescriptorForElement(e, descriptorsToConsider))
					.filter(Objects::nonNull).collect(Collectors.toSet());

			if (result.isEmpty()) {
				return null;
			} else if (result.size() > 1) {
				this.consoleStream.severe("Internal Error: Multiple source descriptors found during evaluation of an "
						+ "AttributeValueConstraint! This should not happen in valid models.");
				return null;
			} else {
				return result.iterator().next();
			}

		} else {

			return MatchedSectionDescriptor.getDescriptorForElement(correspondEClassInstances.get(0),
					descriptorsToConsider);
		}
	}

}
