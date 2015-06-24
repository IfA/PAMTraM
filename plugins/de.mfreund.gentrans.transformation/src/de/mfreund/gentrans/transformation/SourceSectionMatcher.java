package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsoleStream;

import pamtram.SourceSectionModel;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintSourceElement;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.selectors.NamedElementItemSelectorDialogRunner;
import de.mfreund.gentrans.transformation.util.CancellationListener;

/**
 * This class can be used to match <em>source model objects</em> to {@link pamtram.metamodel.Class SourceSections} and find values for
 * {@link MappingHint MappingHints}. Consequently, it performs the first step of a <em>gentrans</em> transformation (<em>matching</em>).
 *
 * @author mfreund
 * @version 2.0
 */
public class SourceSectionMatcher implements CancellationListener {

	/**
	 * The {@link ContainmentTree} for the source model that we try to match.
	 */
	private ContainmentTree containmentTree;

	/**
	 * Registry for <em>source model objects</em> that have already been matched. The matched objects are stored in a map
	 * where the key is the corresponding {@link SourceSectionClass} that they have been matched to.
	 */
	private final LinkedHashMap<SourceSectionClass, Set<EObject>> matchedSections;

	/**
	 * Registry for <em>source model objects</em> that were not directly matched but indirectly matched as part of a container section.
	 * The matched objects are stored in a map where the key is the corresponding <em>container section</em> that they have been matched to.
	 */
	private final LinkedHashMap<SourceSectionClass, Set<EObject>> matchedContainers;
	
	/**
	 * Registry for {@link MappingHintType MappingHints} for all selected {@link Mapping Mappings}.
	 */
	private final Map<Mapping, LinkedList<MappingHintType>> mappingHints;

	/**
	 * Registry for {@link ModelConnectionHint ModelConnectionHints} for all selected {@link Mapping Mappings}.
	 */
	//TODO check if this can now be integrated into the 'mappingHints' map as of the new base class 'MappingHintBaseType'
	private final Map<Mapping, LinkedList<ModelConnectionHint>> modelConnectionHints;

	/**
	 * The list of {@link Mapping Mappings} that shall be used in the <em>matching</em> process.
	 */
	private final List<Mapping> mappingsToChooseFrom;

	/**
	 * If ambiguous {@link Mapping Mappings} should be resolved only once or on a per-element basis.
	 */
	private boolean onlyAskOnceOnAmbiguousMappings;

	/**
	 * We save any user selection for a particular set of possible {@link Mapping Mappings} so that
	 * we don't have to ask twice for the same combination of possible mappings.
	 */
	private final Map<Set<Mapping>, Mapping> ambiguousMappingSelections;
	
	/**
	 * This keeps track of the {@link SourceSectionClass} that is the common container for all source elements of a {@link MappingHintBaseType}.
	 * This map is used to determine at which point complex hints with multiple source elements need to be joined.
	 */
	private final Map<MappingHintBaseType, SourceSectionClass> commonContainerClassOfComplexHints;

	/**
	 * This keeps track of those {@link SourceSectionClass SourceSectionClasses} that contain a {@link SourceSectionAttribute} that is
	 * referenced by an {@link AttributeMappingSourceElement} of an {@link AttributeMapping} and that are located at the 
	 * <em>deepest</em> position in the containment tree of the containing source section.
	 */
	//TODO explain why we need this
	private final Map<AttributeMapping, Set<SourceSectionClass>> deepestSourceSectionClassesByAttributeMapping;

	/**
	 * This keeps track of those {@link SourceSectionClass SourceSectionClasses} that contain a {@link SourceSectionAttribute} that is
	 * referenced by an {@link AttributeMatcherSourceElement} of an {@link AttributeMatcher} and that are located at the 
	 * <em>deepest</em> position in the containment tree of the containing source section.
	 */
	//TODO explain why we need this
	private final Map<AttributeMatcher, Set<SourceSectionClass>> deepestSourceSectionClassesByAttributeMatcher;
	
	/**
	 * This keeps track of those {@link SourceSectionClass SourceSectionClasses} that contain a {@link SourceSectionAttribute} that is
	 * referenced by an {@link ModelConnectionHintSourceElement} of a {@link ModelConnectionHintr} and that are located at the 
	 * <em>deepest</em> position in the containment tree of the containing source section.
	 */
	//TODO explain why we need this
	private final Map<ModelConnectionHint, Set<SourceSectionClass>> deepestSourceSectionClassesByModelConnectionHint;
	
	/**
	 * The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * This keeps track if the user chose to abort the transformation in one of the possible dialogues
	 * ('<em>true</em>' if a user action was triggered to abort the transformation).
	 */
	private boolean abortTransformation;

	/**
	 * Registry for values of {@link GlobalAttribute GlobalAttributes}. Only the latest value found is
	 * saved (GlobalAttributes really only make sense for elements that appear only once in the source model).
	 */
	private final Map<GlobalAttribute, String> globalAttributeValues;

	/**
	 * The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 */
	private final AttributeValueModifierExecutor attributeValueModifierExecutor;

	/**
	 * This keeps track of all {@link AttributeValueConstraint AttributeValueConstraints} that could not be satisfied 
	 * so we don't need to send a potential error message twice.
	 */
	private final Set<AttributeValueConstraint> constraintsWithErrors;

	/**
	 * This constructs an instance.
	 * 
	 * @param containmentTree 
	 * 				The {@link ContainmentTree} for the source model that we try to match.
	 * @param mappingsToChooseFrom
	 *            A list of {@link Mapping Mappings} that shall be used in the <em>matching</em> process.
	 * @param onlyAskOnceOnAmbiguousMappings If ambiguous {@link Mapping Mappings} should be resolved only once or on a per-element basis.
	 * @param attributeValuemodifier The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 * @param consoleStream
	 *           The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public SourceSectionMatcher(
			ContainmentTree containmentTree, 
			final List<Mapping> mappingsToChooseFrom,
			boolean onlyAskOnceOnAmbiguousMappings, 
			final AttributeValueModifierExecutor attributeValuemodifier,
			final MessageConsoleStream consoleStream) {
		
		/*
		 * initialize all class variables
		 */
		this.containmentTree = containmentTree;
		this.matchedSections = new LinkedHashMap<>();
		this.matchedContainers = new LinkedHashMap<>();
		this.mappingHints = new LinkedHashMap<>();
		this.modelConnectionHints = new LinkedHashMap<>();
		this.mappingsToChooseFrom = mappingsToChooseFrom;
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.ambiguousMappingSelections = new HashMap<>();
		this.commonContainerClassOfComplexHints = new HashMap<>();
		this.deepestSourceSectionClassesByAttributeMapping = new LinkedHashMap<>();
		this.deepestSourceSectionClassesByAttributeMatcher = new LinkedHashMap<>();
		this.deepestSourceSectionClassesByModelConnectionHint = new LinkedHashMap<>();
		this.consoleStream = consoleStream;
		this.abortTransformation = false;
		this.globalAttributeValues = new HashMap<>();
		this.attributeValueModifierExecutor = attributeValuemodifier;
		this.constraintsWithErrors = new HashSet<AttributeValueConstraint>();
		
		/*
		 * initialize the various maps based on the given list of mappings
		 */
		initializeMaps(mappingsToChooseFrom);

	}

	/**
	 * Getter for registry of {@link #globalAttributeValues values of global attributes}.
	 *
	 * @return The {@link #globalAttributeValues}.
	 */
	public Map<GlobalAttribute, String> getGlobalAttributeValues() {
		return globalAttributeValues;
	}

	/**
	 * Getter for registry of {@link #matchedSections}.
	 *
	 * @return The {@link #matchedSections}.
	 */
	public LinkedHashMap<SourceSectionClass, Set<EObject>> getMatchedSections() {
		return matchedSections;
	}

	@Override
	public void cancel() {
		abortTransformation = true;

	}

	/**
	 * @return '<em><b>true</b></em>' when user action was triggered to abort the transformation, '<em><b>false</b></em>' otherwise
	 */
	@Override
	public boolean isCancelled() {
		return abortTransformation;
	}

	/**
	 * This determines and returns a mapping for the next unmatched element from the given {@link ContainmentTree}. If multiple mappings are
	 * applicable, the user needs to choose a suitable one.
	 * <p />
	 * Note: All hint values (local and external ones) for the various hints in the selected mapping are also determined by this method.
	 * Consequently, the returned {@link MappingInstanceStorage} already contains all hint values.
	 *
	 * @param containmentTree The {@link ContainmentTree} that keeps track of matched and unmatched elements and is
	 * used to get the element for that a mapping shall be found.
	 * @return The {@link MappingInstanceStorage} that represents the found mapping and contains all hint values
	 * or '<em><b>null</b></em>' if no mapping could be found.
	 */
	public MappingInstanceStorage findMappingForNextElement() {
		
		/* 
		 * This is the source model element which we will now try to match
		 */
		final EObject element = containmentTree.getNextElementForMatching();
		
		/*
		 * Determine all mappings that are applicable for the source model element.
		 */
		final Map<Mapping, MappingInstanceStorage> applicableMappings = findApplicableMappings(element);

		/*
		 * Now, we have to return exactly one (of the possibly multiple found) applicable mappings. 
		 */
		MappingInstanceStorage ret = null;
		
		switch (applicableMappings.size()) {
			case 0:
				// no applicable mapping was found
				return null;
			case 1:
				// return the only found mapping
				ret = applicableMappings.values().iterator().next();
				break;
			default:
				/*
				 * if multiple mappings we need to act depending of the 'onlyAskOnceOnAmbiguousMappings' setting
				 */
				if (onlyAskOnceOnAmbiguousMappings && ambiguousMappingSelections.containsKey(applicableMappings.keySet())) {
					// the user already chose a mapping for this selection of mappings before so that we can reuse this
					ret = applicableMappings.get(ambiguousMappingSelections.get(applicableMappings.keySet()));
				} else {
					/*
					 * There is no other choice but to let the user decide which mapping to apply.					
					 */
					final NamedElementItemSelectorDialogRunner<Mapping> dialog = new NamedElementItemSelectorDialogRunner<>(
							"Please select a Mapping for the source element\n'" + EObjectTransformationHelper.asString(element)+ "'", 
							new ArrayList<Mapping>(applicableMappings.keySet()), 
							0);
					Display.getDefault().syncExec(dialog);
					if (dialog.wasTransformationStopRequested()) {
						abortTransformation = true;
						return null;
					}
					
					ret = applicableMappings.get(dialog.getSelection());
					ambiguousMappingSelections.put(applicableMappings.keySet(), dialog.getSelection());
				}
		}

		/*
		 * Before returning the selected mapping (respectively its MappingInstanceStorage), we mark the affected elements
		 * as 'matched' in the containment tree and update the 'matchedSections' map
		 */
		for (final SourceSectionClass c : ret.getSourceModelObjectsMapped().keySet()) {
			
			if (!matchedSections.containsKey(c)) {
				matchedSections.put(c, new LinkedHashSet<EObject>());
			}
			matchedSections.get(c).addAll(ret.getSourceModelObjectsMapped().get(c));
			containmentTree.markAsMatched(ret.getSourceModelObjectsMapped().get(c));

		}

		return ret;
	}

	/**
	 * This determines and returns all applicable mappings for the given source model <em>element</em>.
	 * <p />
	 * Note: All hint values (local and external ones) for the various hints in the determined mappings are also determined by 
	 * this method and stored in the corresponding {@link MappingInstanceStorage MappingInstanceStorages}.
	 *
	 * @param element The element from the source model for that the applicable mappings shall be determined.
	 * @return A map that contains all applicable mappings and the associated {@link MappingInstanceStorage MappingInstanceStorages}.
	 */
	private Map<Mapping, MappingInstanceStorage> findApplicableMappings(
			final EObject element) {
		
		/*
		 * This keeps track of all found possible mappings (a MappingInstanceStorage is created for
		 * every mapping). One of the found mappings will be returned in the end.
		 */
		final Map<Mapping, MappingInstanceStorage> mappingData = new LinkedHashMap<>();
		
		/*
		 * Now, iterate over all mappings and find those that are applicable for the current 'element'
		 */
		for (final Mapping m : mappingsToChooseFrom) {
			
			MappingInstanceStorage res;
			
			/*
			 * This check is also done by 'findMapping(EObject, ...)', but since it will
			 * most likely fail at the top level, for most mappings we do it
			 * here before we construct any collections and so on. This
			 * might save us a little time, but of course that depends on
			 * the number mappings and the source meta-model.
			 */
			if (m.getSourceMMSection().getEClass().isSuperTypeOf(element.eClass())) {
				
				/*
				 * check if the section that is referenced as 'container' can be matched
				 */
				boolean mappingFailed = !checkContainer(element, m.getSourceMMSection());
				
				if (!mappingFailed) {
					
					// check if the mapping is applicable and determine the (local) hint values
					res = checkMapping(element, false, mappingHints.get(m), modelConnectionHints.get(m), m.getGlobalVariables(),
							m.getSourceMMSection(),
							new MappingInstanceStorage());
					
					if (abortTransformation)
						return null;

					mappingFailed = (res == null);
					
					if (!mappingFailed) {

						/* 
						 * now, determine the external hint values (the container must be present and valid as this was
						 * already checked earlier
						 */
						mappingFailed = handleExternalSourceElements(m, res, mappingFailed);
					}
					
					if (!mappingFailed) {
						// all checks were successful -> the mapping is applicable
						res.setMapping(m);
						mappingData.put(m, res);
					}
				}
			}
		}
		
		return mappingData;
	}

	/**
	 * This recursively checks if a {@link Mapping} (respectively its {@link Mapping#getSourceMMSection() sourceMMSection}) is 
	 * applicable for a certain part of the source model. Therefore, it iterates downward in the containment hierarchy of the 
	 * source section and checks if every element can be matched to a part of the source model. 
	 * <p />
	 * Note: During this process, all hint values are determined as well and stored in the returned {@link MappingInstanceStorage}.
	 *
	 * @param srcModelObject
	 *            The element of the source model that is currently evaluated for applicability.
	 * @param usedOkay
	 *            Whether elements already contained in newRefsAndHints can be mapped (needed for non-containment references).
	 * @param hints A list of {@link MappingHintType MappingHints} that are defined by the mapping that is currently checked.
	 * @param connectionHints A list of {@link ModelConnectionHint ModelConnectionHints} that are defined by the mapping that is currently checked.
	 * @param globalAttributes A list {@link GlobalAttribute GlobalAttributes} that are defined by the mapping that is currently checked.
	 * @param srcSection The {@link SourceSectionClass} (either the sourceMMSection itself or a direct or indirect child of it) that is
	 * currently checked.
	 * @param newRefsAndHints The {@link MappingInstanceStorage} containing the hint values that have been already determined (earlier in the
	 * recursion cycle).
	 * 
	 * @return The {@link MappingInstanceStorage} representing the instance of the mapping (including the <em>new</em> hint values as well as 
	 * those hint values that have already been determined in  earlier recursion cycles) or '<em><b>null</b></em>' if the mapping was not 
	 * applicable/the source section could not be matched.
	 */
	private MappingInstanceStorage checkMapping(
			final EObject srcModelObject,
			final boolean usedOkay, 
			final Iterable<MappingHintType> hints,
			final Iterable<ModelConnectionHint> connectionHints,
			final Iterable<GlobalAttribute> globalAttributes,
			final SourceSectionClass srcSection,
			final MappingInstanceStorage newRefsAndHints) {
	
		final boolean classFits = srcSection.getEClass().isSuperTypeOf(srcModelObject.eClass());
	
		// first of all: check if usedRefs contains this item and if type fits
		// (we do not check any of the used elements of other mappings, since
		// WILL be in a different section of the containment tree )
		if (!usedOkay && newRefsAndHints.containsSourceModelObjectMapped(srcModelObject) || !classFits) {
			return null;
		}
		
		// we will return this in Case we find the mapping to be applicable
		// else we return null
		final MappingInstanceStorage changedRefsAndHints = new MappingInstanceStorage();
		changedRefsAndHints.setAssociatedSourceElement(srcSection, srcModelObject);
	
		final Map<AttributeMappingSourceElement, AttributeValueRepresentation> complexSourceElementHintValues = new LinkedHashMap<>();
		final Map<AttributeMatcherSourceElement, AttributeValueRepresentation> complexAttrMatcherSourceElementHintValues = new LinkedHashMap<>();
		final Map<ModelConnectionHintSourceElement, AttributeValueRepresentation> complexConnectionHintSourceElementHintValues = new LinkedHashMap<>();
	
		// init hintValues
		for (final MappingHintType hint : hints) {
			if (hint instanceof AttributeMapping) {
				changedRefsAndHints.getHintValues().getAttributeMappingHintValues().init((AttributeMapping) hint, true);
			} else if (hint instanceof MappingInstanceSelector) {
				if (((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
					changedRefsAndHints.getHintValues().getMappingInstanceSelectorHintValues().init((MappingInstanceSelector) hint, true);
				}
			}
	
		}
		for (final ModelConnectionHint hint : connectionHints) {
			if (hint instanceof ModelConnectionHint) {
				if (newRefsAndHints.getHintValues().containsHint(hint)) {
					changedRefsAndHints.getHintValues().getHintValues(hint).addAll(newRefsAndHints.getHintValues().getHintValues(hint));
				} else {
					changedRefsAndHints.getHintValues().getModelConnectionHintValues().init(hint, true);
				}
			}
		}
		
		// set refs
		changedRefsAndHints.addSourceModelObjectsMapped(newRefsAndHints
				.getSourceModelObjectsMapped());
	
		// add self to new Refs
		changedRefsAndHints.addSourceModelObjectMapped(srcModelObject,
				srcSection);
	
		/*
		 * check Attributes and determine HintValues
		 */
		boolean attributesOk = handleAttributes(srcModelObject, hints, connectionHints,
				globalAttributes, srcSection, changedRefsAndHints,
				complexSourceElementHintValues,
				complexAttrMatcherSourceElementHintValues,
				complexConnectionHintSourceElementHintValues);
		if (!attributesOk) {
			return null;
		}
		
		// now work on ComplexAttributeMappings and CalcMappings
		final Set<AttributeMapping> complexAttributeMappingsFound = new HashSet<>();
		final Set<AttributeMatcher> complexAttributeMatchersFound = new HashSet<>();
		final Set<ModelConnectionHint> complexConnectionHintsFound = new HashSet<>();
	
		for (final MappingHintType h : hints) {
			if (h instanceof AttributeMapping) {
				
					
				final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> foundValues = 
						new LinkedHashMap<>();
				
				// append the complex hint value (cardinality either 0 or 1)
				// with found values in right order
				for (final AttributeMappingSourceInterface s : ((AttributeMapping) h).getSourceAttributeMappings()) {
					//TODO complexSourceElementHintValues does not seem to contain values from external source elements (either only for 
					// expression mappings or all the times
					if (complexSourceElementHintValues.containsKey(s)) {
													
						if(((AttributeMapping) h).getExpression() != null && !((AttributeMapping) h).getExpression().isEmpty()) {
							AttributeValueRepresentation calculatedValue = null;
							
							for (String value : complexSourceElementHintValues.get(s).getValues()) {
								try {
									/*
									 * Use 'ExpressionBuilder' to parse a 'double' from the 'string' representation
									 * of the attribute value. The simpler way 'Double.parseDouble(value)' would not
									 * support scientific notations like '0.42e2' or '4200e-2'.
									 */
									final double variableVal = new ExpressionBuilder(value).build().calculate();
									
									if(calculatedValue == null) {
										calculatedValue = new AttributeValueRepresentation(s.getSourceAttribute(), String.valueOf(variableVal));
									} else {
										calculatedValue.addValue(String.valueOf(variableVal));
									}
								} catch (final Exception e) {
									consoleStream.println("Couldn't convert variable " + s.getName() 
											+ " of CalculatorMapping " + h.getName() + " from String to double. "
											+ "The problematic source element's attribute value was: " + value);
								}
							
							}
							foundValues.put(s, calculatedValue);
						} else {
							foundValues.put(s, complexSourceElementHintValues.get(s));
						}
					}
					
				}
					
				if (foundValues.keySet().size() > 0) {
					complexAttributeMappingsFound.add((AttributeMapping) h);
					final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> oldValues = 
							changedRefsAndHints.getHintValues().removeHintValue((AttributeMapping) h);
					foundValues.putAll(oldValues);
					changedRefsAndHints.getHintValues().addHintValue((AttributeMapping) h, foundValues);
				}
				
				
			} else if (h instanceof MappingInstanceSelector) {
				if (((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher) {
					final AttributeMatcher m = (AttributeMatcher) ((MappingInstanceSelector) h)
							.getMatcher();
					final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> foundValues = new LinkedHashMap<>();
					// append the complex hint value (cardinality either 0 or 1)
					// with found values in right order
					for (final AttributeMatcherSourceElement s : m
							.getLocalSourceElements()) {
						if (complexAttrMatcherSourceElementHintValues
								.containsKey(s)) {
							foundValues.put(s,
									complexAttrMatcherSourceElementHintValues
									.get(s));
						}
					}
	
					if (foundValues.keySet().size() > 0) {
						complexAttributeMatchersFound.add(m);
						final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> oldValues = 
								changedRefsAndHints.getHintValues().removeHintValue((MappingInstanceSelector) h);
						foundValues.putAll(oldValues);
						changedRefsAndHints.getHintValues().addHintValue((MappingInstanceSelector) h, foundValues);
					}
				}
			}
		}
	
		// handle ComplexModelConnectionHints in the same way as
		// ComplexAttributeMappings
		for (final ModelConnectionHint hint : connectionHints) {
			if (hint instanceof ModelConnectionHint) {
				final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> foundValues = new LinkedHashMap<>();
				// append the complex hint value (cardinality either 0 or 1)
				// with found values in right order
				for (final ModelConnectionHintSourceElement s : hint
						.getLocalSourceElements()) {
					if (complexConnectionHintSourceElementHintValues
							.containsKey(s)) {
						foundValues.put(s,
								complexConnectionHintSourceElementHintValues
								.get(s));
					}
				}
	
				if (foundValues.keySet().size() > 0) {
					complexConnectionHintsFound
					.add(hint);
					final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> oldValues = 
							changedRefsAndHints.getHintValues().removeHintValue(hint);
					foundValues.putAll(oldValues);
					changedRefsAndHints.getHintValues().addHintValue(hint, foundValues);
				}
			}
		}
	
		/*
		 * Combine values of references of same type
		 */
		final Map<EReference, List<SourceSectionClass>> classByRefMap = new LinkedHashMap<EReference, List<SourceSectionClass>>();
		final Map<SourceSectionClass, SourceSectionReference> refByClassMap = new HashMap<SourceSectionClass, SourceSectionReference>();// TODO
		/*
		 * if this gets to slow, maybe add a map (refBySectionByClass) to this
		 * class
		 */
	
		final Map<SourceSectionClass, Integer> mappingCounts = new HashMap<SourceSectionClass, Integer>();
	
		for (final SourceSectionReference ref : srcSection.getReferences()) {
			if (!classByRefMap.containsKey(ref.getEReference())) {
				classByRefMap.put(ref.getEReference(),
						new LinkedList<SourceSectionClass>());
			}
	
			classByRefMap.get(ref.getEReference()).addAll(
					ref.getValuesGeneric());
	
			for (final SourceSectionClass c : ref.getValuesGeneric()) {
				refByClassMap.put(c, ref);
				mappingCounts.put(c, new Integer(0));
			}
		}
	
		// now go through all the srcMmSection refs
		for (final EReference ref : classByRefMap.keySet()) {
			// reference.name.println;
			// check if reference is allowed by src metamodel
			// check if reference in srcMMSection points anywhere
			if (classByRefMap.get(ref).size() < 1)
				break;
			final Object refTarget = srcModelObject.eGet(ref);// getrefTarget(s)
			// in srcModel
			// behave, depending on cardinality
			/*
			 * There are cases in which modeling more than target values for a
			 * section than it can actually hold might make sense depending on
			 * how the target's CardinalityType value was set. Therefore we do
			 * not check the modeled references values at this point.
			 */
			if (ref.getUpperBound() == 1) {
				final EObject refTargetObj = (EObject) refTarget;
				if (refTargetObj == null)
					return null;
				MappingInstanceStorage res = null;
				boolean nonZeroCardSectionFound = false;
	
				for (final SourceSectionClass c : classByRefMap.get(ref)) {
					// check non-zero sections first (it doesn't make sense in
					// this case to model ZERO_INFINITY sections, if there is
					// one
					// section with a minimum cardinality of 1, but it can be
					// handled
					if (!c.getCardinality().equals(
							CardinalityType.ZERO_INFINITY)) {
						if (nonZeroCardSectionFound) {// modeling error
							consoleStream
							.println("Modeling error in source section: '"
									+ srcSection.getContainer()
									.getName()
									+ "'"
									+ ", subsection: '"
									+ srcSection.getName()
									+ "'. The Reference '"
									+ refByClassMap.get(c)
									+ "'"
									+ " points to a metamodel reference, that can only hold one value but in the source section it references more than one Class with"
									+ "a CardinalityType that is not ZERO_INFINITY.");
							return null;
						}
						nonZeroCardSectionFound = true;
						res = checkMapping(
								refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference
								|| usedOkay, hints, connectionHints,
								globalAttributes, c, changedRefsAndHints);
						if (abortTransformation)
							return null;
					}
				}
	
				if (!nonZeroCardSectionFound) {
					for (final SourceSectionClass c : classByRefMap.get(ref)) {
						res = checkMapping(
								refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference
								|| usedOkay, hints, connectionHints,
								globalAttributes, c, changedRefsAndHints);
						if (abortTransformation)
							return null;
						if (res != null) {
							break;
						}
					}
				}
	
				if (res != null) {
					// success: combine refs and hints
					if (refByClassMap.get(res.getAssociatedSourceClass()) instanceof ContainmentReference) {
						changedRefsAndHints.add(res);
					} else {
						changedRefsAndHints.getHintValues().addHintValues(res.getHintValues());
						changedRefsAndHints.getUnsyncedHintValues().addHintValues(res.getUnsyncedHintValues());
					}
					// check for a cardinality hint (it doesn't really make
					// sense to model this for a class connected to a reference
					// with cardinality == 1 but it can be tolerated )
					mappingCounts.put(
							res.getAssociatedSourceClass(),
							new Integer(
									mappingCounts.get(
											res.getAssociatedSourceClass())
											.intValue() + 1));
	
				} else {
					return null;
				}
	
			} else {// unbounded or unspecified
				// cast refTarget to EList
				@SuppressWarnings("unchecked")
				final LinkedList<EObject> refTargetL = new LinkedList<EObject>(
						(EList<EObject>) refTarget);
	
				/*
				 * this is a little more complicated: now we need to find ONE
				 * possible way to map our referenceTargets to the source
				 * sections
				 * 
				 * To do this we need to find out first which MMSections are
				 * applicable to which srcModel sections.
				 * 
				 * Then we try to find a way to map one srcModelSection to each
				 * MMSection
				 */
	
				// Map to store possible srcModelSections to MMSections
				// (non-vc))
				final SourceSectionMappingResultsMap possibleSrcModelElementsNoVC = new SourceSectionMappingResultsMap();
				for (final SourceSectionClass val : classByRefMap.get(ref)) {
					if (val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsNoVC.put(val,
								new LinkedList<MappingInstanceStorage>());
					}
				}
	
				// Map to store possible srcModelSections to MMSections (vc))
				final SourceSectionMappingResultsMap possibleSrcModelElementsVC = new SourceSectionMappingResultsMap();
				for (final SourceSectionClass val : classByRefMap.get(ref)) {
					if (!val.getCardinality().equals(CardinalityType.ONE)) {
						possibleSrcModelElementsVC.put(val,
								new LinkedList<MappingInstanceStorage>());
					}
				}
	
				final LinkedHashSet<EObject> elementsUsableForVC = new LinkedHashSet<EObject>();
				// find possible srcElements for mmsections
				for (final EObject rt : refTargetL) {
					boolean foundMapping = false;
					for (final SourceSectionClass val : classByRefMap.get(ref)) {
						final MappingInstanceStorage res = checkMapping(
								rt,
								refByClassMap.get(val) instanceof MetaModelSectionReference
								|| usedOkay, hints, connectionHints,
								globalAttributes, val, changedRefsAndHints);
						if (abortTransformation)
							return null;
	
						if (res != null) {// mapping possible
							foundMapping = true;
							res.setAssociatedSourceElement(val, rt);
							if (!val.getCardinality().equals(
									CardinalityType.ONE)) {
								possibleSrcModelElementsVC.get(val).add(res);
								elementsUsableForVC.add(rt);
	
							} else {
								possibleSrcModelElementsNoVC.get(val).add(res);
							}
						}
					}
					if (!foundMapping) {
						return null; // we need to find a mapping for every
						// srcModelElement if the reference Type
						// was modeled in the srcMMSection
					}
				}
	
				final LinkedList<EObject> allElementsMapped = new LinkedList<EObject>();
	
				while (possibleSrcModelElementsNoVC.keySet().size() > 0) {
					final SourceSectionClass smallestKey = possibleSrcModelElementsNoVC
							.getKeyForValueWithSmallestCollectionSize();
					if (possibleSrcModelElementsNoVC.get(smallestKey).size() > 0) {
						MappingInstanceStorage srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsNoVC.get(smallestKey)
								.size() > 1) {
							LinkedList<MappingInstanceStorage> possibleElements = new LinkedList<MappingInstanceStorage>();
							possibleElements
									.addAll(possibleSrcModelElementsNoVC
											.get(smallestKey));
	
							// filter elements that can be used for a vc-section
							final LinkedList<MappingInstanceStorage> allVCIncompatible = new LinkedList<MappingInstanceStorage>();
							for (final MappingInstanceStorage s : possibleElements) {
								if (!elementsUsableForVC.contains(s
										.getAssociatedSourceModelElement())) {
									allVCIncompatible.add(s);
								}
							}
							if (allVCIncompatible.size() >= 1) {
								possibleElements = allVCIncompatible;
							}
	
							srcSectionResult = getResultForLeastUsedSrcModelElement(possibleElements);
	
						} else {
							srcSectionResult = possibleSrcModelElementsNoVC
									.get(smallestKey).getFirst();
						}
	
						// remember mapping
						if (refByClassMap.get(srcSectionResult
								.getAssociatedSourceClass()) instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);
	
						} else {
							changedRefsAndHints.getHintValues().addHintValues(srcSectionResult.getHintValues());
							changedRefsAndHints.getUnsyncedHintValues().addHintValues(srcSectionResult.getUnsyncedHintValues());
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());
						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsNoVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
						possibleSrcModelElementsNoVC.remove(smallestKey);// remove
						/*
						 * successfully mapped mmSection from list
						 */
	
						// update cardinality
						mappingCounts.put(
								srcSectionResult.getAssociatedSourceClass(),
								new Integer(mappingCounts.get(
										srcSectionResult
										.getAssociatedSourceClass())
										.intValue() + 1));
					} else {
						// consoleStream.println("no-vc mapping failed");
						return null;// all non-vc-elements need to be mapped
						// exactly once
					}
				}
	
				// try to map all vc-elements
				final LinkedHashSet<SourceSectionClass> usedKeys = new LinkedHashSet<>(); // for
				// counting
				// cardinality
	
				while (possibleSrcModelElementsVC.keySet().size() != 0) {
	
					final SourceSectionClass smallestKey = possibleSrcModelElementsVC
							.getKeyForValueWithSmallestCollectionSize();
					if (possibleSrcModelElementsVC.get(smallestKey).size() > 0) {
	
						usedKeys.add(smallestKey);
						MappingInstanceStorage srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsVC.get(smallestKey).size() > 1) {
	
							srcSectionResult = getResultForLeastUsedSrcModelElement(possibleSrcModelElementsVC
									.get(smallestKey));
	
						} else {
							srcSectionResult = possibleSrcModelElementsVC.get(
									smallestKey).getFirst();
						}
						// remember mapping
						if (refByClassMap.get(srcSectionResult
								.getAssociatedSourceClass()) instanceof ContainmentReference) {
							changedRefsAndHints.add(srcSectionResult);
	
						} else {
							changedRefsAndHints.getHintValues().addHintValues(srcSectionResult.getHintValues());
							changedRefsAndHints.getUnsyncedHintValues().addHintValues(srcSectionResult.getUnsyncedHintValues());
						}
						allElementsMapped.add(srcSectionResult
								.getAssociatedSourceModelElement());
	
						// remove srcModel element from possibility lists of
						// MMSections
						possibleSrcModelElementsVC
								.removeResultsForElement(srcSectionResult);
	
						// update cardinality
						mappingCounts.put(
								srcSectionResult.getAssociatedSourceClass(),
								new Integer(mappingCounts.get(
										srcSectionResult
										.getAssociatedSourceClass())
										.intValue() + 1));
	
					} else if (usedKeys.contains(smallestKey)
							|| smallestKey.getCardinality().equals(
									CardinalityType.ZERO_INFINITY)) {
						possibleSrcModelElementsVC.remove(smallestKey);// remove
						// mmSection
						// from
						// list
					} else {
						// consoleStream.println("vc mapping failed");
						return null; // the fact that samllestKey is not in the
						// collection means that no mapping was
						// found at all
					}
				}
	
				// check if all refTargets where mapped
				refTargetL.removeAll(allElementsMapped);
				if (refTargetL.size() > 0) {
					consoleStream.println("Not everything could be mapped");
					return null;
				}
			}
		}
	
		/*
		 * Handle cardinality Hints
		 */
		for (final MappingHintType h : hints) {
			if (h instanceof CardinalityMapping) {
				if (mappingCounts.keySet().contains(
						((CardinalityMapping) h).getSource())) {
					changedRefsAndHints.getHintValues().addHintValue((CardinalityMapping) h, mappingCounts
							.get(((CardinalityMapping) h).getSource()));
				}
			}
		}
	
		/*
		 * sync complex hints
		 */
		syncComplexAttrMappings(srcSection, changedRefsAndHints);
		syncComplexAttrMatchers(srcSection, changedRefsAndHints);
		syncModelConnectionHints(srcSection, changedRefsAndHints);
	
		/*
		 * if we are at one of the deepest SourceElements of a complex Mapping,
		 * we create a new unsynced list, and remove it from the
		 * changedRefsAndHints List until we sync it again (see above)
		 */
		for (final MappingHintType h : hints) {
			if (h instanceof AttributeMapping) {
				if (!(complexAttributeMappingsFound.contains(h) && deepestSourceSectionClassesByAttributeMapping
						.get(h).contains(srcSection))) {
					changedRefsAndHints.getHintValues().removeHintValue((AttributeMapping) h); // remove incomplete hint value
				} else if (deepestSourceSectionClassesByAttributeMapping
						.get(h).size() > 1) {
					
					changedRefsAndHints.getUnsyncedHintValues().setHintValues((AttributeMapping) h, srcSection,
							new LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>());
					final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> val = 
							changedRefsAndHints.getHintValues().removeHintValue((AttributeMapping) h);
					changedRefsAndHints.getUnsyncedHintValues().addHintValue((AttributeMapping) h, srcSection, val);
				}
			} else if (h instanceof MappingInstanceSelector) {
				if (((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher) {
					if (!(complexAttributeMatchersFound
							.contains(((MappingInstanceSelector) h)
									.getMatcher()) && deepestSourceSectionClassesByAttributeMatcher
									.get(((MappingInstanceSelector) h).getMatcher())
									.contains(srcSection))) {
						changedRefsAndHints.getHintValues().removeHintValue((MappingInstanceSelector) h); // remove incomplete hint value
					} else if (deepestSourceSectionClassesByAttributeMatcher
							.get(((MappingInstanceSelector) h).getMatcher())
							.size() > 1) {
						
						changedRefsAndHints.getUnsyncedHintValues().setHintValues((MappingInstanceSelector) h, srcSection, new LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>>());
						final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> val = changedRefsAndHints.getHintValues().removeHintValue((MappingInstanceSelector) h);
						changedRefsAndHints.getUnsyncedHintValues().addHintValue((MappingInstanceSelector) h, srcSection, val);
					}
				}
			}
		}
	
		for (final ModelConnectionHint h : connectionHints) {
			if (h instanceof ModelConnectionHint) {
				if (!(complexConnectionHintsFound.contains(h) && deepestSourceSectionClassesByModelConnectionHint
						.get(h).contains(srcSection))) {
					changedRefsAndHints.getHintValues().removeHintValue(h); // remove incomplete hint value
				} else if (deepestSourceSectionClassesByModelConnectionHint
						.get(h).size() > 1) {
					
					changedRefsAndHints.getUnsyncedHintValues().setHintValues(h, srcSection, new LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>>());
					final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> val = changedRefsAndHints.getHintValues().removeHintValue(h);
					changedRefsAndHints.getUnsyncedHintValues().addHintValue(h, srcSection, val);
				}
			}
		}
	
		return changedRefsAndHints;
	
	}

	/**
	 * Helper method to handle an ExternalAttributeMapping. This uses {@link #getContainerAttributeValue(SourceSectionAttribute, SourceSectionClass, EObject)}
	 * to find a hint value for a given {@link MappingHintSourceInterface}, applies possible {@link AttributeValueModifierSet AttributeValueModifierSets} and stores
	 * the found value in the '<em>attrVals</em>' map.
	 *
	 * @param m
	 * @param res
	 * @param mappingFailed
	 * @param attrVals
	 * @param i
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean checkExternalAttributeMapping(
			final Mapping m,
			final MappingInstanceStorage res, 
			boolean mappingFailed,
			final Map<ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, AttributeValueRepresentation> attrVals,
			//TODO change this to 'ExternalModifiedAttributeElementType'
			final MappingHintSourceInterface i) {
		
		if (i instanceof ExternalModifiedAttributeElementType) {
			
			ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> externalModifiedAttributeElement = 
					((ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) i);
			
			String attrVal = getContainerAttributeValue(externalModifiedAttributeElement.getSource(),
					m.getSourceMMSection().getContainer(), res.getAssociatedSourceModelElement().eContainer());
			if (attrVal == null) {
				mappingFailed = true;
			} else {
				attrVal = attributeValueModifierExecutor.applyAttributeValueModifiers(
						attrVal, ((ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) i)
						.getModifier());
				attrVals.put(
						(ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>) i, 
						new AttributeValueRepresentation(externalModifiedAttributeElement.getSource(), attrVal));
			}
		}
		return mappingFailed;
	}

	/**
	 * @param extClass
	 * @param extObj
	 */
	private boolean checkObjectWasMapped(final SourceSectionClass extClass,
			final EObject extObj) {
		if (extObj != null) {
			if (matchedSections.containsKey(extClass)) {
				if (matchedSections.get(extClass).contains(extObj)) {
					return true;
				}
			} else if (matchedContainers.containsKey(extClass)) {
				if (matchedContainers.get(extClass).contains(extObj)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check if the container section referenced by the sourceSection Classe's
	 * container ref. can be mapped.
	 *
	 * @param element
	 * @param sourceSectionClass
	 * @return true if the container attribute of the sourceSection Class
	 *         doesn't exist or a fitting container instance exists
	 */
	private boolean checkContainer(final EObject element,
			final SourceSectionClass sourceSectionClass) {
		
		if (sourceSectionClass.getContainer() == null) {
			
			// this part is easy
			return true;
			
		} else {
			
			/*
			 * Step 1: identify all containers of the corresponding elements
			 */
			final List<SourceSectionClass> containerClasses = new LinkedList<>();
			final List<EObject> containerElements = new LinkedList<>();

			SourceSectionClass currentClass = sourceSectionClass;
			EObject currentElement = element;

			while (currentClass.getContainer() != null) {
				/*
				 * "jump" SourceMMSection boundary
				 */
				if (currentElement.eContainer() != null) {
					currentElement = currentElement.eContainer();
					currentClass = currentClass.getContainer();

					/*
					 * scan all levels of source section until we are at a top
					 * level again
					 *
					 * we do not concern ourselves with mapping of the elements
					 * at this point, all we need are the container sections
					 */
					while (!currentClass.getContainingSection().equals(
							currentClass)) {
						if (currentElement.eContainer() != null) {
							currentElement = currentElement.eContainer();
							currentClass = currentClass
									.getOwningContainmentReference()
									.getOwningClass();
						} else {
							return false;
						}
					}
					containerElements.add(currentElement);
					containerClasses.add(currentClass);

				} else {
					return false;
				}
			}

			/*
			 * Step 2: try to map each container section, starting from the
			 * highest
			 */
			int index = containerClasses.size() - 1;
			while (index >= 0) {
				/*
				 * map container if it wasn't mapped before
				 */
				if (!checkObjectWasMapped(containerClasses.get(index),
						containerElements.get(index))) {
					final MappingInstanceStorage res = checkMapping(
							containerElements.get(index), false,
							Collections.<MappingHintType> emptyList(),
							Collections.<ModelConnectionHint> emptyList(),
							Collections.<GlobalAttribute> emptyList(),
							containerClasses.get(index),
							new MappingInstanceStorage());
					if (res == null) {
						return false;
					} else {
						for (final SourceSectionClass c : res
								.getSourceModelObjectsMapped().keySet()) {
							if (!matchedContainers.containsKey(c)) {
								matchedContainers.put(c,
										new LinkedHashSet<EObject>());
							}
							matchedContainers.get(c).addAll(
									res.getSourceModelObjectsMapped().get(c));
						}
					}
				}

				/*
				 * make sure that next container's container was mapped at the
				 * appropriate position
				 */
				index--;
				if (index >= 0) {
					if (!checkObjectWasMapped(containerClasses.get(index)
							.getContainer(), containerElements.get(index)
							.eContainer())) {
						return false;
					}
				} else {// we cannot put this element in the list because we do
					// not want to map it already
					if (!checkObjectWasMapped(
							sourceSectionClass.getContainer(),
							element.eContainer())) {
						return false;
					}
				}
			}
			// if we reached this point all went well
			return true;
		}
	}

	/**
	 * Finds the value for an ExternalAttributeMappingSourceElement
	 *
	 * @param attr
	 *            attribute to find
	 * @param extClass
	 *            container class to start looking
	 * @param extObj
	 *            eObject corresponding to the container class
	 * @return
	 */
	private String getContainerAttributeValue(
			final SourceSectionAttribute attr, SourceSectionClass extClass,
			EObject extObj) {
		final SourceSectionClass attrClass = attr.getOwningClass();

		while (true) {
			// found container section?
			if (attrClass.equals(extClass)) {
				final Object attrVal = extObj.eGet(attr.getAttribute());
				if (attrVal == null) {
					consoleStream.println("Unset external Attrbute "
							+ attr.getName());
					return null;
				} else { // convert Attribute value to String
					return attr
							.getAttribute()
							.getEType()
							.getEPackage()
							.getEFactoryInstance()
							.convertToString(
									attr.getAttribute().getEAttributeType(),
									attrVal);
				}
			} else if (extClass.eContainer() instanceof SourceSectionContainmentReference) {
				extClass = (SourceSectionClass) extClass.eContainer()
						.eContainer();
				extObj = extObj.eContainer();
				// Check if the parent object exists, and if it was mapped for
				// the section.
				if (!checkObjectWasMapped(extClass, extObj))
					return null;
			} else if (extClass.eContainer() instanceof SourceSectionModel
					&& extClass.getContainer() != null) {
				extClass = extClass.getContainer();
				extObj = extObj.eContainer();
				if (!checkObjectWasMapped(extClass, extObj))
					return null;
			} else {// modeling error, object not found
				consoleStream
				.println("Modeling error. External Source Element "
						+ attr.getName()
						+ "is not part of the the container"
						+ "section or the section that the container section is part of.");
				return null;
			}

		}
	}

	/**
	 * This initializes various maps based on the given list of {@link Mapping Mappings}.
	 * <p />
	 * The following maps are initialized:<br />
	 * <ul>
	 * 	<li>{@link #mappingHints}</li>
	 * 	<li>{@link #modelConnectionHints}</li>
	 * 	<li>{@link #deepestSourceSectionClassesByAttributeMapping}</li>
	 * 	<li>{@link #deepestSourceSectionClassesByAttributeMatcher}</li>
	 * 	<li>{@link #deepestSourceSectionClassesByModelConnectionHint}</li>
	 * </ul>
	 * <p />
	 * Note: This needs to be called before the process of <em>matching</em> can be started!
	 * 
	 * @param mappings The list of {@link Mapping Mappings} for which the various maps shall be initialized.
	 */
	private void initializeMaps(List<Mapping> mappings) {
		
		for (Mapping mapping : mappings) {
			
			// initialize the 'modelConnectionHints' map
			modelConnectionHints.put(mapping, new LinkedList<ModelConnectionHint>());
			for (final MappingHintGroupType g : mapping.getActiveMappingHintGroups()) {
				if (g instanceof MappingHintGroup) {
					if (((MappingHintGroup) g).getModelConnectionMatcher() != null) {
						modelConnectionHints.get(mapping).add(
								((MappingHintGroup) g).getModelConnectionMatcher());
					}
				}
			}
			
			// initialize the 'mappingHints' map
			mappingHints.put(mapping, new LinkedList<MappingHintType>());
			for (final MappingHintGroupType g : mapping.getActiveMappingHintGroups()) {
				if (g.getMappingHints() != null) {
					mappingHints.get(mapping).addAll(g.getMappingHints());
				}
			}
			for (final MappingHintGroupImporter g : mapping.getActiveImportedMappingHintGroups()) {
				if (g.getMappingHints() != null) {
					mappingHints.get(mapping).addAll(g.getMappingHints());
				}
			}
			
			for (final MappingHintType h : mappingHints.get(mapping)) {
				// initialize the 'deepestSourceSectionsByAttributeMapping' map
				if (h instanceof AttributeMapping) {
					buildDeepestSourceSectionClassesByAttributeMappingMap(
							(AttributeMapping) h, mapping.getSourceMMSection());
					
				// initialize the 'deepestSourceSectionsByAttributeMatcher' map
				} else if (h instanceof MappingInstanceSelector) {
					if (((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher) {
						buildDeepestSourceSectionClassesByAttributeMatcherMap(
								(AttributeMatcher) ((MappingInstanceSelector) h).getMatcher(), 
								mapping.getSourceMMSection());
					}
				}
			}

			// initialize the 'deepestSourceSectionsByModelConnectionHint' map
			for (final ModelConnectionHint h : modelConnectionHints.get(mapping)) {
				if (h instanceof ModelConnectionHint) {
					buildDeepestSourceSectionClassesByModelConnectionHintMap(
							h, mapping.getSourceMMSection());
				}
			}
		}
	}

	/**
	 * Build the {@link #deepestSourceSectionClassesByAttributeMapping} map for the given {@link AttributeMapping} and
	 * {@link SourceSectionClass}.
	 *
	 * @param attributeMapping The {@link AttributeMapping} for that the deepest source sections shall be determined.
	 * @param srcSection The {@link SourceSectionClass SourceSection} for that the deepest sections shall be determined.
	 */
	private void buildDeepestSourceSectionClassesByAttributeMappingMap(
			final AttributeMapping attributeMapping, 
			final SourceSectionClass srcSection) {
		if (!deepestSourceSectionClassesByAttributeMapping.containsKey(attributeMapping)) {
			final Set<ModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> srcElements = 
					new HashSet<>();
			srcElements.addAll(attributeMapping.getLocalSourceElements());
			deepestSourceSectionClassesByAttributeMapping.put(attributeMapping, new HashSet<SourceSectionClass>());
			deepestSourceSectionClassesByAttributeMapping.get(attributeMapping).addAll(
					findDeepestClassesAndCommonContainer(srcElements, srcSection, attributeMapping));
	
		}
	}

	/**
	 * Build the {@link #deepestSourceSectionClassesByModelConnectionHint} map for the given {@link ModelConnectionHint} and
	 * {@link SourceSectionClass}.
	 *
	 * @param modelConnectionHint The {@link ModelConnectionHint} for that the deepest source sections shall be determined.
	 * @param srcSection The {@link SourceSectionClass SourceSection} for that the deepest sections shall be determined.
	 */
	private void buildDeepestSourceSectionClassesByModelConnectionHintMap(
			final ModelConnectionHint modelConnectionHint,
			final SourceSectionClass srcSection) {
		if (!deepestSourceSectionClassesByModelConnectionHint
				.containsKey(modelConnectionHint)) {
			final Set<ModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> srcElements = 
					new HashSet<>();
			srcElements.addAll(modelConnectionHint.getLocalSourceElements());
			deepestSourceSectionClassesByModelConnectionHint.put(modelConnectionHint, new HashSet<SourceSectionClass>());
			deepestSourceSectionClassesByModelConnectionHint.get(modelConnectionHint).addAll(
							findDeepestClassesAndCommonContainer(srcElements, srcSection, modelConnectionHint));
	
		}
	}

	/**
	 * Build the {@link #deepestSourceSectionClassesByAttributeMatcher} map for the given {@link AttributeMatcher} and
	 * {@link SourceSectionClass}.
	 *
	 * @param attributeMatcher The {@link AttributeMatcher} for that the deepest source sections shall be determined.
	 * @param srcSection The {@link SourceSectionClass SourceSection} for that the deepest sections shall be determined.
	 */
	private void buildDeepestSourceSectionClassesByAttributeMatcherMap(
			final AttributeMatcher attributeMatcher, 
			final SourceSectionClass srcSection) {
		if (!deepestSourceSectionClassesByAttributeMatcher
				.containsKey(attributeMatcher)) {
			final Set<ModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> srcElements = 
					new HashSet<>();
			srcElements.addAll(attributeMatcher.getLocalSourceElements());
			deepestSourceSectionClassesByAttributeMatcher.put(attributeMatcher, new HashSet<SourceSectionClass>());
			final MappingInstanceSelector s = (MappingInstanceSelector) attributeMatcher.eContainer();
			deepestSourceSectionClassesByAttributeMatcher.get(attributeMatcher).addAll(
					findDeepestClassesAndCommonContainer(srcElements, srcSection, s));
	
		}
	}

	/**
	 * Helper method used when building the various maps holding the 'deepestSourceSectionClasses' (
	 * {@link #deepestSourceSectionClassesByAttributeMapping}, {@link #deepestSourceSectionClassesByAttributeMatcher} and
	 * {@link #deepestSourceSectionClassesByModelConnectionHint}). It returns the list of {@link SourceSectionClass classes}
	 * that contain the <em>deepest</em> {@link SourceSectionAttribute SourceSectionAttributes} referenced by the given mapping
	 * hint. Additionally, the {@link #commonContainerClassOfComplexHints common container class} for the given hint is determined.
	 *
	 * @param sourceElements The set of {@link ModifiedAttributeElementType elements} that is defined by the the given <em>hint</em>.
	 * @param srcSection The {@link SourceSectionClass} representing the current <em>source section</em> that is analyzed.
	 * @param hint The {@link MappingHintBaseType mapping hint} that is analyzed.
	 * 
	 * @return Those {@link SourceSectionClass classes} from the source section that contain the deepest 
	 * {@link SourceSectionAttribute SourceSectionAttributes}.
	 */
	private Set<SourceSectionClass> findDeepestClassesAndCommonContainer(
			final Set<ModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> sourceElements,
			final SourceSectionClass srcSection, 
			final MappingHintBaseType hint) {
		
		final Set<SourceSectionClass> resultSet = new HashSet<>();
	
		/*
		 * Fill the resultSet with all potential candidates
		 */
		for (final ModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> sourceElement : sourceElements) {
			resultSet.add(sourceElement.getSource().getOwningClass());
		}
	
		/*
		 * Now, find the deepest elements
		 */
		Map<SourceSectionClass, Set<SourceSectionClass>> resultSets = new HashMap<>();
		boolean commonContainerFound = false;
		
		/*
		 * init classesToCheck
		 */
		if (resultSet.size() == 1) {
			return resultSet;
		} else {
			if (resultSet.contains(srcSection)) {
				resultSet.remove(srcSection);
				commonContainerClassOfComplexHints.put(hint, srcSection);
				commonContainerFound = true;
			}
			resultSets.put(srcSection, new HashSet<>(resultSet));
		}
	
		/*
		 * Find deepest elements
		 */
		while (resultSets.size() > 0) {
			final Map<SourceSectionClass, Set<SourceSectionClass>> nextResultSets = new HashMap<>();
			for (final SourceSectionClass cl : resultSets.keySet()) {
				for (final SourceSectionReference ref : cl.getReferences()) {
					boolean breakLoop = false;
					for (final SourceSectionClass childClass : ref
							.getValuesGeneric()) {
						nextResultSets.put(childClass,
								new HashSet<SourceSectionClass>());
	
						/*
						 * get all child classes and add them to set
						 */
						
						// to prevent endless loops
						final Set<SourceSectionClass> childrenChecked = new HashSet<SourceSectionClass>();
						final List<SourceSectionClass> classesToCheck = new LinkedList<SourceSectionClass>();
						classesToCheck.add(childClass);
						while (classesToCheck.size() > 0) {
							final SourceSectionClass chkClass = classesToCheck
									.remove(0);
	
							childrenChecked.add(chkClass);
							nextResultSets.get(childClass).add(chkClass);
	
							/*
							 * next checks
							 */
							for (final SourceSectionReference chRef : chkClass
									.getReferences()) {
								for (final SourceSectionClass refVal : chRef
										.getValuesGeneric()) {
									if (!childrenChecked.contains(refVal)) {
										classesToCheck.add(refVal);
									}
								}
							}
						}
	
						/*
						 * is the resultSet still a subset of the childClasses
						 * set?
						 */
	
						if (nextResultSets.get(childClass).containsAll(
								resultSets.get(cl))) {
							breakLoop = true;
							nextResultSets.put(childClass, resultSets.get(cl));
							break;
						} else {
							if (!commonContainerFound) {
								commonContainerClassOfComplexHints.put(hint, cl);
								commonContainerFound = true;
							}
							
							// remove all non-result classes (intersection)
							nextResultSets.get(childClass).retainAll(
									resultSets.get(cl));
							
							if (nextResultSets.get(childClass).size() < 1) {
								resultSet.add(childClass);
								nextResultSets.remove(childClass);
							}
						}
					}
					if (breakLoop) {
						break;
					}
				}
	
			}
	
			// next iteration
			resultSets = nextResultSets;
		}
		return resultSet;
	
	}

	/**
	 * This checks if all {@link SourceSectionAttribute Attributes} that have been defined for a given 
	 * {@link SourceSectionClass} can be mapped for the given '<em>srcModelObject</em>'. Therefore, 
	 * all the {@link AttributeValueConstraint AttributeValueConstraints} are checked.
	 * <br />
	 * <b>Note:</b> The hint values that are determined from the attribute values are calculated during 
	 * above process as well.
	 * 
	 * @param srcModelObject The object to be checked.
	 * @param hints A list of {@link MappingHintType MappingHints} that are associated with the mapping 
	 * that is currently evaluated.
	 * @param connectionHints A list of {@link ModelConnectionHint ModelConnectionHints} that are 
	 * associated with the mapping that is currently evaluated.
	 * @param globalVars A list of {@link GlobalAttribute GlobalAttributes}.
	 * @param srcSection The {@link SourceSectionClass} for which the attributes shall be checked.
	 * @param changedRefsAndHints The {@link MappingInstanceStorage} where calculated hint values 
	 * will be stored.
	 * @param complexSourceElementHintValues A {@link Map} where hint values for all found 
	 * {@link AttributeMappingSourceElement AttributeMappingSourceElements} will be stored.
	 * @param complexAttrMatcherSourceElementHintValues A {@link Map} where hint values for all found 
	 * {@link AttributeMatcherSourceElement AttributeMatcherSourceElements} will be stored.
	 * @param complexConnectionHintSourceElementHintValues A {@link Map} where hint values for all found 
	 * {@link ModelConnectionHintSourceElement ModelConnectionHintSourceElements} will be stored.
	 * @return '<em></b>true</b></em>' if all attributes are present, '<em><b>false</b></em>' otherwise
	 */
	@SuppressWarnings("unchecked")
	private boolean handleAttributes(
			final EObject srcModelObject,
			final Iterable<MappingHintType> hints,
			final Iterable<ModelConnectionHint> connectionHints,
			final Iterable<GlobalAttribute> globalVars,
			final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints,
			final Map<AttributeMappingSourceElement, AttributeValueRepresentation> complexSourceElementHintValues,
			final Map<AttributeMatcherSourceElement, AttributeValueRepresentation> complexAttrMatcherSourceElementHintValues,
			final Map<ModelConnectionHintSourceElement, AttributeValueRepresentation> complexConnectionHintSourceElementHintValues) {
		
		for (final SourceSectionAttribute at : srcSection.getAttributes()) {
			/*
			 * look for attributes in srcSection does it exist in src model?
			 */
			final Object srcAttr = srcModelObject.eGet(at.getAttribute());
			
			if (srcAttr == null) {// attribute not set / null
				// Not a problem unless any mappings point here or Constraints
				// were modeled.
				// Unset mapping hint values are handled elsewhere.
				// Here we only need to check for matchers
				if (at.getValueConstraint().size() > 0) {
					return false;
				}
			}
			
			/*
			 * As attributes may have a cardinality greater than 1, too, we have to handle
			 * every attribute value separately.
			 */
			ArrayList<Object> srcAttrValues = new ArrayList<>();
			if(srcAttr instanceof Collection<?>) {
				srcAttrValues.addAll((Collection<Object>) srcAttr);
			} else {
				srcAttrValues.add(srcAttr);
			}
			
			/*
			 * First, we check if all the constraints are satisfied for every attribute value.
			 */
			for (Object srcAttrValue : srcAttrValues) {
				
				// convert Attribute value to String
				final String srcAttrAsString = at
						.getAttribute()
						.getEType()
						.getEPackage()
						.getEFactoryInstance()
						.convertToString(at.getAttribute().getEAttributeType(),
								srcAttrValue);
				/*
				 * check AttributeValueSpecifications
				 *
				 * Inclusions are OR connected
				 *
				 * Exclusions are NOR connected
				 */
				boolean inclusionMatched = false;
				boolean containsInclusions = false;
				for (final AttributeValueConstraint constraint : at
						.getValueConstraint()) {
					if (constraintsWithErrors.contains(constraint))
						continue;

					boolean constraintVal;
					try {
						constraintVal = constraint
								.checkConstraint(srcAttrAsString);
					} catch (final Exception e) {
						constraintsWithErrors.add(constraint);
						consoleStream.println("The AttributeValueConstraint '" + constraint.getName() + "' of the Attribute '"
								+ at.getName() + " (Class: " + at.getOwningClass().getName() + ", Section: " + at.getContainingSection().getName()
								+ ")' could not be evaluated and will be ignored. The following error was supplied:\n"
								+ e.getLocalizedMessage());
						continue;
					}
					if (!constraintVal
							&& constraint.getType().equals(
									AttributeValueConstraintType.EXCLUSION)) {
						return false;
					} else if (constraint.getType().equals(
							AttributeValueConstraintType.INCLUSION)) {
						containsInclusions = true;
						if (constraintVal) {
							inclusionMatched = true;
						}
					}
				}

				if (!inclusionMatched && containsInclusions) {
					return false;
				}
			}
			
			//TODO split this up in a separate method to be more intuitive
			/*
			 * Second, we iterate once again and calculate all the hint values based
			 * on the attributes.
			 * Note: We have to iterate two times to prevent side effects if the check for
			 * constraints (see above) fails at anything but the first value.
			 */
			for (Object srcAttrValue : srcAttrValues) {
				
				// convert Attribute value to String
				final String srcAttrAsString = at
						.getAttribute()
						.getEType()
						.getEPackage()
						.getEFactoryInstance()
						.convertToString(at.getAttribute().getEAttributeType(),
								srcAttrValue);

				// handle possible attribute mappings
				for (final MappingHintType hint : hints) {
					if (hint instanceof MappedAttributeValueExpander) {
						
						if (((MappedAttributeValueExpander) hint)
								.getSourceAttribute().equals(at)) {
							
							if(at.getAttribute().isMany()) {
								//TODO implement this?
								throw new RuntimeException("MappedAttributeValueExpanders based on multi-valued attributes are not yet supported!");
							}
							
							final String valCopy = attributeValueModifierExecutor
									.applyAttributeValueModifiers(
											srcAttrAsString,
											((MappedAttributeValueExpander) hint)
											.getModifiers());
							changedRefsAndHints.getHintValues().addHintValue((MappedAttributeValueExpander) hint, valCopy);
						}

					} else if (hint instanceof AttributeMapping) {
						
						for (final AttributeMappingSourceElement m : ((AttributeMapping) hint)
								.getLocalSourceElements()) {
							if (m.getSource().equals(at)) {

								final String valCopy = attributeValueModifierExecutor
										.applyAttributeValueModifiers(
												srcAttrAsString,
												m.getModifier());
								// create a new AttributeValueRepresentation or update the existing one
								if(complexSourceElementHintValues.get(m) == null) {
									complexSourceElementHintValues.put(m, new AttributeValueRepresentation(m.getSource(), valCopy));
								} else {
									complexSourceElementHintValues.get(m).addValue(valCopy);
								}
							}
						}
					} else if (hint instanceof MappingInstanceSelector) {// handle
						
						// MappingInstanceSelector
						// with
						// AttributeMatcher
						if (((MappingInstanceSelector) hint)
								.getMatcher() instanceof AttributeMatcher) {

							final AttributeMatcher matcher = (AttributeMatcher) ((MappingInstanceSelector) hint)
									.getMatcher();
							for (final AttributeMatcherSourceElement e : matcher
									.getLocalSourceElements()) {
								if (e.getSource().equals(at)) {
									
//									if(at.getAttribute().isMany()) {
//										//TODO implement this?
//										throw new RuntimeException("AttributeMatchers based on multi-valued attributes are not yet supported!");
//									}
									
									final String valCopy = attributeValueModifierExecutor
											.applyAttributeValueModifiers(
													srcAttrAsString, 
													e.getModifier());
									// create a new AttributeValueRepresentation or update the existing one
									if(complexAttrMatcherSourceElementHintValues.get(e) == null) {
										complexAttrMatcherSourceElementHintValues.put(e, new AttributeValueRepresentation(e.getSource(), valCopy));
									} else {
										complexAttrMatcherSourceElementHintValues.get(e).addValue(valCopy);
									}
								}
							}
						}
					}
				}

				// ModelConnectionHint (is being handled in the same way as
				// MI-Selector with AttrMatcher)
				for (final ModelConnectionHint hint : connectionHints) {
					if (hint instanceof ModelConnectionHint) {
						for (final ModelConnectionHintSourceElement m : hint
								.getLocalSourceElements()) {
							if (m.getSource().equals(at)) {
								
								if(at.getAttribute().isMany()) {
									//TODO implement this?
									throw new RuntimeException("ModelConnectionHints based on multi-valued attributes are not yet supported!");
								}
								
								final String modifiedVal = attributeValueModifierExecutor
										.applyAttributeValueModifiers(
												srcAttrAsString,
												m.getModifier());
								complexConnectionHintSourceElementHintValues.put(m, new AttributeValueRepresentation(at, modifiedVal));
							}
						}
					}
				}

				for (final GlobalAttribute gVar : globalVars) {
					if (gVar.getSource().equals(at)) {
						final String modifiedVal = attributeValueModifierExecutor
								.applyAttributeValueModifiers(srcAttrAsString,
										gVar.getModifier());
						globalAttributeValues.put(gVar, modifiedVal);
					}
				}

			} 
		}
		return true;
	}

	/**
	 * Tries to determine the hintValues for the
	 * ExternalAttributeMappingSourceElements, if present
	 *
	 * @param m The {@link Mapping} that is currently evaluated.
	 * @param res The {@link MappingInstanceStorage} that contains the hint values that have already been determined. Found external 
	 * hint values for attribute mappings are stored there.
	 * @param mappingFailed If the mapping already failed at an earlier stage.
	 * @return If something went wrong while determining the external hint values for the attribute mapping.
	 */
	private boolean handleExternalSourceElements(
			final Mapping m,
			final MappingInstanceStorage res, 
			boolean mappingFailed) {
		
		if (m.getSourceMMSection().getContainer() != null) {
			
			final Map<ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, AttributeValueRepresentation> attrVals = new HashMap<>();
			
			for (final MappingHintType h : mappingHints.get(m)) {
				if (h instanceof AttributeMapping) {
					
					/* try to find a hint value for every external source element; those will
					 * be stored in 'attrVals'
					 */
					for (final AttributeMappingSourceInterface i : ((AttributeMapping) h).getExternalSourceElements()) {
						mappingFailed = checkExternalAttributeMapping(m, res,
								mappingFailed, attrVals, i);
						if (mappingFailed) {
							break;
						}
					}
					// add to hintVals
					if (mappingFailed) {
						break;
					} else if (attrVals.keySet().size() > 0) {
						
						/*
						 * if there is not yet any value stored for this hint (e.g. as there are no local source elements), we need
						 * to initialize the hint value first
						 */
						if (res.getHintValues().getHintValues((AttributeMapping) h).size() == 0) {
							res.getHintValues().getAttributeMappingHintValues().init((AttributeMapping) h, true);
						}
						
						if(((AttributeMapping) h).getExpression() != null && !((AttributeMapping) h).getExpression().isEmpty()) {
							
							final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> newVals = new HashMap<>();
							for (final ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
									.keySet()) {
								
								if(e.getSource().getAttribute().isMany()) {
									//TODO implement this?
									throw new RuntimeException("AttributeMappings with external source attributes that are "
											+ "based on multi-valued attributes are not yet supported!");
								}
								
								try {

									/*
									 * Use 'ExpressionBuilder' to parse a 'double' from the 'string' representation
									 * of the attribute value. The simpler way 'Double.parseDouble(value)' would not
									 * support scientific notations like '0.42e2' or '4200e-2'.
									 */
									final double variableVal = new ExpressionBuilder(attrVals.get(e).getValue()).build().calculate();

									newVals.put((AttributeMappingSourceInterface) e,
											new AttributeValueRepresentation(e.getSource(), String.valueOf(variableVal)));
								} catch (final Exception execption) {
									consoleStream.println("Couldn't convert variable " + e.getName()
											+ " of CalculatorMapping " + h.getName() + " from String to double. "
											+ "The problematic source element's attribute value was: " + attrVals.get(e));							
								}
							}
							for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues((AttributeMapping) h)) {
								hVal.putAll(newVals);
							}
						} else {
							for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues((AttributeMapping) h)) {
								for (final ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
										.keySet()) {
									hVal.put((AttributeMappingSourceInterface) e,
											new AttributeValueRepresentation(e.getSource(), attrVals.get(e).getValue()));
								}
							}
						}
						
						// last action: reset attrval list
						attrVals.clear();
					}
				} else if (h instanceof ExternalMappedAttributeValueExpander) {
					
					if(((ExternalMappedAttributeValueExpander) h).getSourceAttribute().getAttribute().isMany()) {
						//TODO implement this?
						throw new RuntimeException("ExternalMappedAttributeValueExpanders based on multi-valued attributes are not yet supported!");
					}
					
					String attrVal = getContainerAttributeValue(
							((ExternalMappedAttributeValueExpander) h)
							.getSourceAttribute(),
							m.getSourceMMSection().getContainer(), res
							.getAssociatedSourceModelElement()
							.eContainer());
					if (attrVal == null) {
						mappingFailed = true;
						break;
					} else {
						attrVal = attributeValueModifierExecutor
								.applyAttributeValueModifiers(
										attrVal,
										((ExternalMappedAttributeValueExpander) h)
										.getModifiers());
						res.getHintValues().addHintValue((MappedAttributeValueExpander) h, attrVal);
					}

				} else if (h instanceof MappingInstanceSelector) {
					if (((MappingInstanceSelector) h).getMatcher() != null) {
						if (((MappingInstanceSelector) h).getMatcher() instanceof AttributeMatcher) {
							final AttributeMatcher matcher = (AttributeMatcher) ((MappingInstanceSelector) h)
									.getMatcher();
							for (final AttributeMatcherSourceInterface i : matcher
									.getSourceAttributes()) {
								
								if(i.getSourceAttribute().getAttribute().isMany()) {
									//TODO implement this?
									throw new RuntimeException("AttributeMatchers based on multi-valued attributes are not yet supported!");
								}
								
								mappingFailed = checkExternalAttributeMapping(
										m, res, mappingFailed, attrVals, i);
								if (mappingFailed) {
									break;
								}
							}
							// add to hintVals
							if (mappingFailed) {
								break;
							} else if (attrVals.keySet().size() > 0) {
								
								/*
								 * if there is not yet any value stored for this hint (e.g. as there are no local source elements), we need
								 * to initialize the hint value first
								 */
								if (res.getHintValues().getHintValues((MappingInstanceSelector) h).size() == 0) {
									res.getHintValues().getMappingInstanceSelectorHintValues().init((MappingInstanceSelector) h, true);
								}
								
								for (final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues((MappingInstanceSelector) h)) {
									for (final ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
											.keySet()) {
										hVal.put((AttributeMatcherSourceInterface) e,
												attrVals.get(e));
									}
								}
								// last action: reset attrval list
								attrVals.clear();
							}
						}
					}
				}
			}

			for (final ModelConnectionHint h : modelConnectionHints.get(m)) {
				if (h instanceof ModelConnectionHint) {
					for (final ModelConnectionHintSourceInterface i : h
							.getSourceElements()) {
						
						if(i.getSourceAttribute().getAttribute().isMany()) {
							//TODO implement this?
							throw new RuntimeException("ModelConnectionHints based on multi-valued attributes are not yet supported!");
						}
						
						mappingFailed = checkExternalAttributeMapping(m, res,
								mappingFailed, attrVals, i);
						if (mappingFailed) {
							break;
						}
					}
					// add to hintVals
					if (mappingFailed) {
						break;
					} else if (attrVals.keySet().size() > 0) {
						
						/*
						 * if there is not yet any value stored for this hint (e.g. as there are no local source elements), we need
						 * to initialize the hint value first
						 */
						if (res.getHintValues().getHintValues(h).size() == 0) {
							res.getHintValues().getModelConnectionHintValues().init(h, true);
						}
						
						for (final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues(h)) {
							for (final ExternalModifiedAttributeElementType<SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
									.keySet()) {
								hVal.put((ModelConnectionHintSourceInterface) e, attrVals.get(e));
							}
						}
						// last action: reset attrval list
						attrVals.clear();
					}
				}
			}

		}
		return mappingFailed;
	}

	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncComplexAttrMappings(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {
		for (final AttributeMapping h : changedRefsAndHints.getUnsyncedHintValues().getAttributeMappingHintValues().keySet()) {
			final boolean isCommonParent = commonContainerClassOfComplexHints
					.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnsyncedHintValues().getHintValues(h).size() > 1 || isCommonParent) {
				final Map<SourceSectionClass, LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>> m = 
						changedRefsAndHints.getUnsyncedHintValues().getAttributeMappingHintValues().get(h);
				// list of "synced" hints
				LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> syncedComplexMappings = null;
				// find longest list (ideally they are either of the same
				// length, or there is only one value)
				SourceSectionClass cl = null;
				for (final SourceSectionClass c : m.keySet()) {
					if (syncedComplexMappings == null) {
						syncedComplexMappings = m.get(c);
						cl = c;
					} else if (m.get(c).size() > syncedComplexMappings
							.size()) {
						syncedComplexMappings = m.get(c);
						cl = c;
					}
				}
				// remove selected List from m
				m.remove(cl);

				// combine values
				for (final SourceSectionClass c : m.keySet()) {
					final LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> vals = m.get(c);
					if (vals.size() == 1) {
						for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> valMap : syncedComplexMappings) {
							valMap.putAll(vals.getFirst());
						}
					} else if (vals.size() > 1) {
						for (int i = 0; i < vals.size(); i++) {// remember:
							/*
							 * the size of vals will be lower or equel the
							 * size of syncedComplexAttrMappings
							 */
							syncedComplexMappings.get(i)
							.putAll(vals.get(i));
						}
					}
				}
				m.clear();

				if (isCommonParent) {// sync
					// add to changedRefsAndHints
					changedRefsAndHints.getHintValues().addHintValues(h, syncedComplexMappings);
					// }
				} else {
					// remove old hints and add new hints
					changedRefsAndHints.getUnsyncedHintValues().setHintValues(h, srcSection, syncedComplexMappings);
				}
			}
		}
	}

	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncComplexAttrMatchers(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {
		for (final MappingInstanceSelector h : changedRefsAndHints.getUnsyncedHintValues().getMappingInstanceSelectorHintValues().keySet()) {
			final boolean isCommonParent = commonContainerClassOfComplexHints
					.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnsyncedHintValues().getHintValues(h).size() > 1 || isCommonParent) {
				final Map<SourceSectionClass, LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>>> m = 
						changedRefsAndHints.getUnsyncedHintValues().getMappingInstanceSelectorHintValues().get(h);
				// list of "synced" hints
				LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> syncedComplexMappings = null;
				// find longest list (ideally they are either of the same
				// length, or there is only one value)
				SourceSectionClass cl = null;
				for (final SourceSectionClass c : m.keySet()) {
					if (syncedComplexMappings == null) {
						syncedComplexMappings = m.get(c);
						cl = c;
					} else if (m.get(c).size() > syncedComplexMappings
							.size()) {
						syncedComplexMappings = m.get(c);
						cl = c;
					}
				}
				// remove selected List from m
				m.remove(cl);

				// combine values
				for (final SourceSectionClass c : m.keySet()) {
					final LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> vals = m.get(c);
					if (vals.size() == 1) {
						for (final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> valMap : syncedComplexMappings) {
							valMap.putAll(vals.getFirst());
						}
					} else if (vals.size() > 1) {
						for (int i = 0; i < vals.size(); i++) {// remember:
							// the size
							// of vals
							// will be
							// lower or
							// equal the
							// size of
							// syncedComplexAttrMappings
							syncedComplexMappings.get(i)
							.putAll(vals.get(i));
						}
					}
				}
				m.clear();

				if (isCommonParent) {// sync
					// add to changedRefsAndHints
					changedRefsAndHints.getHintValues().addHintValues(h, syncedComplexMappings);
					// }
				} else {
					// remove old hints and add new hints
					changedRefsAndHints.getUnsyncedHintValues().setHintValues(h, srcSection, syncedComplexMappings);
				}
			}
		}
	}

	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncModelConnectionHints(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {
		for (final ModelConnectionHint h : changedRefsAndHints.getUnsyncedHintValues().getModelConnectionHintValues().keySet()) {
			final boolean isCommonParent = commonContainerClassOfComplexHints
					.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnsyncedHintValues().getHintValues(h).size() > 1 || isCommonParent) {
				
				final Map<SourceSectionClass, LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>>> m = 
						changedRefsAndHints.getUnsyncedHintValues().getModelConnectionHintValues().get(h);
				// list of "synced" hints
				LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> syncedComplexMappings = null;
				// find longest list (ideally they are either of the same
				// length, or there is only one value)
				SourceSectionClass cl = null;
				for (final SourceSectionClass c : m.keySet()) {
					if (syncedComplexMappings == null) {
						syncedComplexMappings = m.get(c);
						cl = c;
					} else if (m.get(c).size() > syncedComplexMappings
							.size()) {
						syncedComplexMappings = m.get(c);
						cl = c;
					}
				}
				// remove selected List from m
				m.remove(cl);

				// combine values
				for (final SourceSectionClass c : m.keySet()) {
					final LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> vals = m.get(c);
					if (vals.size() == 1) {
						for (final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> valMap : syncedComplexMappings) {
							valMap.putAll(vals.getFirst());
						}
					} else if (vals.size() > 1) {
						for (int i = 0; i < vals.size(); i++) {// remember:
							// the size
							// of vals
							// will be
							// lower or
							// equal the
							// size of
							// syncedComplexAttrMappings
							syncedComplexMappings.get(i)
							.putAll(vals.get(i));
						}
					}
				}
				m.clear();

				if (isCommonParent) {// sync
					// add to changedRefsAndHints
					changedRefsAndHints.getHintValues().addHintValues(h, syncedComplexMappings);
					// }
				} else {
					// remove old hints and add new hints
					changedRefsAndHints.getUnsyncedHintValues().setHintValues(h, srcSection, syncedComplexMappings);
				}
			}
		}
	}

	/**
	 * Counts how often each associated source model element is referenced by
	 * each MappingInstdanceStorage as associated source model object and
	 * returns one mapping result for the Object with the lowest count.
	 *
	 * @param possibleElements
	 * @return Mapping results
	 */
	private static MappingInstanceStorage getResultForLeastUsedSrcModelElement(
			final LinkedList<MappingInstanceStorage> possibleElements) {
		MappingInstanceStorage srcSectionResult;
		// count how often a sourceModel Element is mapped
		final LinkedHashMap<EObject, Integer> usages = new LinkedHashMap<EObject, Integer>();
		for (final MappingInstanceStorage e : possibleElements) {
			final EObject element = e.getAssociatedSourceModelElement();
			if (!usages.containsKey(element)) {
				usages.put(element, 0);
			}
			usages.put(element, usages.get(element) + 1);
		}
		// use one of the mappings for one of the elements with the least
		// possible mappings
		EObject leastUsed = possibleElements.getFirst()
				.getAssociatedSourceModelElement();
		int numberUsed = usages.get(leastUsed);
		for (final EObject o : usages.keySet()) {// find the first element least
			// used
			// and return the first possible
			// result
			if (usages.get(o) < numberUsed) {
				leastUsed = o;
				numberUsed = usages.get(o);
			}
		}
	
		srcSectionResult = possibleElements.getFirst();// initialize this
		// variable so we dont
		// get compile errors
		for (final MappingInstanceStorage e : possibleElements) {
			if (e.getAssociatedSourceModelElement().equals(leastUsed)) {
				srcSectionResult = e;
				break;
			}
		}
		return srcSectionResult;
	}
}