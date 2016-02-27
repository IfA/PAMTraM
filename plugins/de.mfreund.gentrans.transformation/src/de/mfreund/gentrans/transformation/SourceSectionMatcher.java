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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ui.console.MessageConsoleStream;

import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancellableElement;
import pamtram.ConditionalElement;
import pamtram.SourceSectionModel;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingExternalSourceElement;
import pamtram.mapping.AttributeMappingSourceElement;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherExternalSourceElement;
import pamtram.mapping.AttributeMatcherSourceElement;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.AttributeValueModifierSet;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.ExternalModifiedAttributeElementType;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintBaseType;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintSourceInterface;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.ModelConnectionHintExternalSourceElement;
import pamtram.mapping.ModelConnectionHintSourceElement;
import pamtram.mapping.ModelConnectionHintSourceInterface;
import pamtram.mapping.ModifiedAttributeElementType;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.MultipleReferencesAttributeValueConstraint;
import pamtram.metamodel.RangeConstraint;
import pamtram.metamodel.RegExMatcher;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSection;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;

/**
 * This class can be used to match <em>source model objects</em> to {@link pamtram.metamodel.Class SourceSections} and find values for
 * {@link MappingHint MappingHints}. Consequently, it performs the first step of a <em>gentrans</em> transformation (<em>matching</em>).
 *
 * @author mfreund
 * @version 2.0
 */
public class SourceSectionMatcher extends CancellableElement {

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
	 * Registry for {@link MappingHintBaseType MappingHints} for all selected {@link Mapping Mappings}.
	 */
	private final Map<Mapping, LinkedList<MappingHintBaseType>> mappingHints;

	/**
	 * The list of {@link Mapping Mappings} that shall be used in the <em>matching</em> process.
	 */
	private final List<Mapping> mappingsToChooseFrom;

	/**
	 * If ambiguous {@link Mapping Mappings} should be resolved only once or on a per-element basis.
	 */
	private boolean onlyAskOnceOnAmbiguousMappings;

	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

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
	 * Registry for values of {@link GlobalAttribute GlobalAttributes}. Only the latest value found is
	 * saved (GlobalAttributes really only make sense for elements that appear only once in the source model).
	 */
	private final Map<GlobalAttribute, String> globalAttributeValues;

	/**
	 * The {@link AttributeValueModifierExecutor} that shall be used for modifying attribute values.
	 */
	private final AttributeValueModifierExecutor attributeValueModifierExecutor;

	/**
	 * This keeps track of all {@link AttributeValueConstraint AttributeValueConstraints} that could not be evaluated 
	 * so we don't need to send a potential error message twice. This might e.g. happen for a malformed regular expression
	 * in a {@link RegExMatcher}.
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
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} to be used.
	 * @param consoleStream
	 *           The {@link MessageConsoleStream} that shall be used to print messages.
	 */
	public SourceSectionMatcher(
			ContainmentTree containmentTree, 
			final List<Mapping> mappingsToChooseFrom,
			boolean onlyAskOnceOnAmbiguousMappings, 
			final AttributeValueModifierExecutor attributeValuemodifier,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy,
			final MessageConsoleStream consoleStream) {

		/*
		 * initialize all class variables
		 */
		this.containmentTree = containmentTree;
		this.matchedSections = new LinkedHashMap<>();
		this.matchedContainers = new LinkedHashMap<>();
		this.mappingHints = new LinkedHashMap<>();
		this.mappingsToChooseFrom = mappingsToChooseFrom;
		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.ambiguousMappingSelections = new HashMap<>();
		this.commonContainerClassOfComplexHints = new HashMap<>();
		this.deepestSourceSectionClassesByAttributeMapping = new LinkedHashMap<>();
		this.deepestSourceSectionClassesByAttributeMatcher = new LinkedHashMap<>();
		this.deepestSourceSectionClassesByModelConnectionHint = new LinkedHashMap<>();
		this.consoleStream = consoleStream;
		this.canceled = false;
		this.globalAttributeValues = new HashMap<>();
		this.attributeValueModifierExecutor = attributeValuemodifier;
		this.constraintsWithErrors = new HashSet<>();

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

	/**
	 * This determines and returns a mapping for the {@link #containmentTree} that we operate on. If multiple mappings are
	 * applicable, the user needs to choose a suitable one.
	 * <p />
	 * Note: All hint values (local and external ones) for the various hints in the selected mapping are also determined by this method.
	 * Consequently, the returned {@link MappingInstanceStorage} already contains all hint values.
	 *
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
				 * Consult the specified resolving strategy to resolve the ambiguity.				
				 */
				try {
					consoleStream.println("[Ambiguity] Resolve matching ambiguity...");
					List<Mapping> resolved = ambiguityResolvingStrategy.matchingSelectMapping(new ArrayList<>(applicableMappings.keySet()), element);
					consoleStream.println("[Ambiguity] ...finished.\n");
					ret = applicableMappings.get(resolved.get(0));
					ambiguousMappingSelections.put(applicableMappings.keySet(), resolved.get(0));
				} catch (Exception e) {
					consoleStream.println(e.getMessage());
					canceled = true;
					return null;
				}
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
				
				//Simplify Mapping by checking conditions all ConditionalElements (Mapping, MappingHintGroup, MappingHint)
				Mapping mSimplified = checkConditions(m);

				if (!mappingFailed && mSimplified != null) {

					// check if the mapping is applicable and determine the (local) hint values
					res = checkMapping(element, false, mappingHints.get(mSimplified), mSimplified.getGlobalVariables(),
							mSimplified.getSourceMMSection(),
							new MappingInstanceStorage());

					if (canceled) {
						return null;
					}

					mappingFailed = (res == null);

					if (!mappingFailed) {

						/* 
						 * now, determine the external hint values (the container must be present and valid as this was
						 * already checked earlier); found values are added to the given MappingInstanceStorage
						 */
						mappingFailed = determineExternalHintValues(mSimplified, res, mappingFailed);
					}

					if (!mappingFailed) {
						// all checks were successful -> the mapping is applicable
						res.setMapping(mSimplified);
						mappingData.put(mSimplified, res);
					}
				}
			}
		}

		return mappingData;
	}
	
	/**
	 * This recursively checks if a conditional {@link Mapping} is succeeded. If not, the whole {@link Mapping} will be discarded.
	 * Otherwise all conditional {@link MappingHintGroup} will be checked in the same procedure. 
	 * Of course, we do it the same way for all conditional {@link MappingHint}s. 
	 * 
	 * Note: This process is recursively and a nested procedure which saves time. In case of '<em><b>false</b></em>' other underneath ConditionalElements will be ignored and discarded.
	 * @param mOld
	 * 			represents the original {@link Mapping} 
	 * @return The {@link Mapping} representing a simplified of the origin one. There are all ConditionalElements that returned '<em><b>false</b></em>' are extracted.
	 */
	private Mapping checkConditions(Mapping mOld) {
	
		//Copy Mapping
		Mapping mNew = mOld;
		
		// check Conditions of the Mapping (Note: no condition modeled = true)
		if(mOld.checkCondition(mOld.getCondition()) && mOld.checkCondition(mOld.getConditionRef())) {
			
			// check Condition of corresponding MappingHintGroups
			for (MappingHintGroupType mHintGroup : mOld.getMappingHintGroups()){
				
				if(((ConditionalElement) mHintGroup).checkCondition(((ConditionalElement) mHintGroup).getCondition()) && 
						((ConditionalElement) mHintGroup).checkCondition(((ConditionalElement) mHintGroup).getConditionRef())){
					
					// check now Conditions of corresponding MappingHints
					for(MappingHint mHint : mHintGroup.getMappingHints()){
						
						if(!(((ConditionalElement) mHint).checkCondition(((ConditionalElement) mHint).getCondition()) && 
								((ConditionalElement) mHint).checkCondition(((ConditionalElement) mHint).getConditionRef()))){
							
							//Condition false, so remove it from copied Mapping
							mHintGroup.getMappingHints().remove(mHint);
							break;
						}
					}
				} else {
					//Condition false, so remove it from copied Mapping
					mNew.getMappingHintGroups().remove(mHintGroup);
					break;
				}
			}
			
			// check Condition of corresponding IMPORTED MappingHintGroups
			for (MappingHintGroupImporter mImportHintGroup : mOld.getImportedMappingHintGroups()){
				
				//Condition of imported MappingHintGroup false, than remove it from copied Mapping
				if(!(((ConditionalElement) mImportHintGroup).checkCondition(((ConditionalElement) mImportHintGroup).getCondition()) && 
						((ConditionalElement) mImportHintGroup).checkCondition(((ConditionalElement) mImportHintGroup).getConditionRef()))){
					
					mNew.getImportedMappingHintGroups().remove(mImportHintGroup);
					break;
				}
			}
		}
		return mNew;
	}

	/**
	 * This recursively checks if a {@link Mapping} (respectively its {@link Mapping#getSourceMMSection() sourceMMSection}) is 
	 * applicable for a certain part of the source model. Therefore, it iterates downward in the containment hierarchy of the 
	 * source section and checks if every element can be matched to a part of the source model. 
	 * <p />
	 * Note: This does not check the if the {@link SourceSectionClass#getContainer() container} and {@link ExternalModifiedAttributeElementType
	 * external attributes} can also be matched. This has to be checked additionally by means of {@link #determineExternalHintValues(Mapping, 
	 * MappingInstanceStorage, boolean) determineExternalHintValues()}.
	 * <p />
	 * Note: During this process, all hint values are determined as well and stored in the returned {@link MappingInstanceStorage}.
	 *
	 * @param srcModelObject
	 *            The element of the source model that is currently evaluated for applicability.
	 * @param usedOkay
	 *            Whether elements already contained in <em>newRefsAndHints<em> can be matched again. This needs to be set to '<em>true</em> when 
	 *            {@link #checkMapping(EObject, boolean, Iterable, Iterable, Iterable, SourceSectionClass, MappingInstanceStorage) checkMapping()} 
	 *            is called for a non-containment reference.
	 * @param hints A list of {@link MappingHintBaseType MappingHints} that are defined by the mapping that is currently checked.
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
			final Iterable<MappingHintBaseType> hints,
			final Iterable<GlobalAttribute> globalAttributes,
			final SourceSectionClass srcSection,
			final MappingInstanceStorage newRefsAndHints) {

		final boolean classFits = srcSection.getEClass().isSuperTypeOf(srcModelObject.eClass());

		// first of all: check if usedRefs contains this item and if type fits
		// (we do not check any of the used elements of other mappings, since
		// they will be in a different section of the containment tree )
		if (!usedOkay && newRefsAndHints.containsSourceModelObjectMapped(srcModelObject) || !classFits) {
			return null;
		}

		// this is the 'MappingInstanceStorage' that we will return this in Case we find the mapping to be applicable
		// else we return null
		final MappingInstanceStorage changedRefsAndHints = new MappingInstanceStorage();
		changedRefsAndHints.setAssociatedSourceElement(srcSection, srcModelObject);

		/*
		 * These maps will be filled with values for the various (local) source elements of the hints.
		 */
		final Map<AttributeMappingSourceElement, AttributeValueRepresentation> attributeMappingSourceValues = new LinkedHashMap<>();
		final Map<AttributeMatcherSourceElement, AttributeValueRepresentation> attributeMatcherSourceValues = new LinkedHashMap<>();
		final Map<ModelConnectionHintSourceElement, AttributeValueRepresentation> modelConnectionHintSourceValues = new LinkedHashMap<>();

		// init hintValues
		for (final MappingHintBaseType hint : hints) {
			if (hint instanceof AttributeMapping) {
				changedRefsAndHints.getHintValues().getAttributeMappingHintValues().init((AttributeMapping) hint, true);
			} else if (hint instanceof MappingInstanceSelector) {
				if (((MappingInstanceSelector) hint).getMatcher() instanceof AttributeMatcher) {
					changedRefsAndHints.getHintValues().getMappingInstanceSelectorHintValues().init((MappingInstanceSelector) hint, true);
				}
			} else if (hint instanceof ModelConnectionHint) {
				if (newRefsAndHints.getHintValues().containsHint(hint)) {
					changedRefsAndHints.getHintValues().getHintValues((ModelConnectionHint) hint).addAll(
							newRefsAndHints.getHintValues().getHintValues((ModelConnectionHint) hint));
				} else {
					changedRefsAndHints.getHintValues().getModelConnectionHintValues().init((ModelConnectionHint) hint, true);
				}
			}

		}

		// set the list of source model objects that have been mapped;
		// first, add all mapped objects from 'changedRefsAndHints' ...
		changedRefsAndHints.addSourceModelObjectsMapped(newRefsAndHints
				.getSourceModelObjectsMapped());
		// ..., then add the current srcModelObject
		changedRefsAndHints.addSourceModelObjectMapped(srcModelObject,
				srcSection);

		/*
		 * check if all attributes are present and valid; determine HintValues
		 */
		boolean attributesOk = checkAttributes(srcModelObject, hints,
				globalAttributes, srcSection, changedRefsAndHints,
				attributeMappingSourceValues,
				attributeMatcherSourceValues,
				modelConnectionHintSourceValues);

		if (!attributesOk) {
			return null;
		}

		/*
		 * Now, we store the found (local) values for the various hints in the MappingInstanceStorage. Possible
		 * external values will be added later by 'checkExternalAttributes'.
		 */
		final Set<AttributeMapping> attributeMappingsFound = new HashSet<>();
		final Set<AttributeMatcher> attributeMatchersFound = new HashSet<>();
		final Set<ModelConnectionHint> modelConnectionHintsFound = new HashSet<>();

		for (final MappingHintBaseType h : hints) {

			final Map<Object, AttributeValueRepresentation> foundValues = new LinkedHashMap<>();

			if (h instanceof AttributeMapping) {
				AttributeMapping attributeMapping = (AttributeMapping) h;

				// append the complex hint value (cardinality either 0 or 1) with found values in right order
				for (final AttributeMappingSourceInterface s : attributeMapping.getSourceAttributeMappings()) {
					if (attributeMappingSourceValues.containsKey(s)) {
						foundValues.put(s, attributeMappingSourceValues.get(s));
						attributeMappingsFound.add(attributeMapping);
					}

				}

			} else if (h instanceof MappingInstanceSelector) {
				MappingInstanceSelector mappingInstanceSelector = (MappingInstanceSelector) h;

				if (mappingInstanceSelector.getMatcher() instanceof AttributeMatcher) {
					final AttributeMatcher m = (AttributeMatcher) mappingInstanceSelector.getMatcher();

					// append the complex hint value (cardinality either 0 or 1) with found values in right order
					for (final AttributeMatcherSourceElement s : m.getLocalSourceElements()) {
						if (attributeMatcherSourceValues.containsKey(s)) {
							foundValues.put(s, attributeMatcherSourceValues.get(s));
							attributeMatchersFound.add(m);
						}
					}

				}
			} else if (h instanceof ModelConnectionHint) {
				ModelConnectionHint modelConnectionHint = (ModelConnectionHint) h;

				// append the complex hint value (cardinality either 0 or 1) with found values in right order
				for (final ModelConnectionHintSourceElement s : modelConnectionHint.getLocalSourceElements()) {
					if (modelConnectionHintSourceValues.containsKey(s)) {
						foundValues.put(s, modelConnectionHintSourceValues.get(s));
						modelConnectionHintsFound.add(modelConnectionHint);
					}
				}

			}


			if (foundValues.keySet().size() > 0) {
				/*
				 * if there already exist some hint values in 'changedRefsAndHints', we have to keep those and
				 * add our new values
				 */
				@SuppressWarnings("unchecked")
				final Map<Object, AttributeValueRepresentation> oldValues = 
				(Map<Object, AttributeValueRepresentation>) changedRefsAndHints.getHintValues().removeHintValue(h);
				foundValues.putAll(oldValues);
				changedRefsAndHints.getHintValues().addHintValue(h, foundValues);
			}

		}

		/*
		 * Combine values of references of same type
		 */
		final Map<EReference, List<SourceSectionClass>> classByRefMap = new LinkedHashMap<>();
		final Map<SourceSectionClass, SourceSectionReference> refByClassMap = new HashMap<>();// TODO
		/*
		 * if this gets to slow, maybe add a map (refBySectionByClass) to this
		 * class
		 */

		final Map<SourceSectionClass, Integer> mappingCounts = new HashMap<>();

		/*
		 * check if all modeled references can be matched; this will also iterate further down the hierarchy
		 * (and thereby call 'checkMapping', 'checkAttributes' and 'checkReferences' multiple times)
		 */
		boolean referencesOk = checkReferences(srcModelObject, usedOkay, hints, globalAttributes, srcSection, changedRefsAndHints,
				classByRefMap, refByClassMap, mappingCounts);

		if(!referencesOk) {
			return null;
		}

		/*
		 * Handle cardinality Hints
		 */
		for (final MappingHintBaseType h : hints) {
			if (h instanceof CardinalityMapping) {
				CardinalityMapping cardinalityMapping = (CardinalityMapping) h;

				if (mappingCounts.keySet().contains(cardinalityMapping.getSource())) {
					changedRefsAndHints.getHintValues().addHintValue(
							cardinalityMapping, mappingCounts.get(cardinalityMapping.getSource()));
				}
			}
		}

		/*
		 * sync hint values
		 */
		syncAttributeMappingHintValues(srcSection, changedRefsAndHints);
		syncAttributeMatcherHintValues(srcSection, changedRefsAndHints);
		syncModelConnectionHintValues(srcSection, changedRefsAndHints);

		/*
		 * if we are at one of the deepest SourceElements of a complex Mapping,
		 * we create a new unsynced list, and remove it from the
		 * changedRefsAndHints List until we sync it again (see above)
		 */
		for (final MappingHintBaseType h : hints) {
			if (h instanceof AttributeMapping) {
				AttributeMapping attributeMapping = (AttributeMapping) h;

				if (!(attributeMappingsFound.contains(h) && deepestSourceSectionClassesByAttributeMapping
						.get(h).contains(srcSection))) {
					changedRefsAndHints.getHintValues().removeHintValue(attributeMapping); // remove incomplete hint value
				} else if (deepestSourceSectionClassesByAttributeMapping
						.get(h).size() > 1) {

					changedRefsAndHints.getUnsyncedHintValues().setHintValues(attributeMapping, srcSection,
							new LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>());
					final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> val = 
							changedRefsAndHints.getHintValues().removeHintValue(attributeMapping);
					changedRefsAndHints.getUnsyncedHintValues().addHintValue(attributeMapping, srcSection, val);
				}
			} else if (h instanceof MappingInstanceSelector) {
				MappingInstanceSelector mappingInstanceSelector = (MappingInstanceSelector) h;

				if (mappingInstanceSelector.getMatcher() instanceof AttributeMatcher) {
					if (!(attributeMatchersFound.contains(mappingInstanceSelector.getMatcher()) && 
							deepestSourceSectionClassesByAttributeMatcher.get(mappingInstanceSelector.getMatcher()).contains(srcSection))) {
						changedRefsAndHints.getHintValues().removeHintValue((MappingInstanceSelector) h); // remove incomplete hint value
					} else if (deepestSourceSectionClassesByAttributeMatcher.get(((MappingInstanceSelector) h).getMatcher()).size() > 1) {

						changedRefsAndHints.getUnsyncedHintValues().setHintValues(mappingInstanceSelector, srcSection, new LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>>());
						final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> val = changedRefsAndHints.getHintValues().removeHintValue(mappingInstanceSelector);
						changedRefsAndHints.getUnsyncedHintValues().addHintValue(mappingInstanceSelector, srcSection, val);
					}
				}
			} else if (h instanceof ModelConnectionHint) {
				ModelConnectionHint modelConnectionHint = (ModelConnectionHint) h;

				if (!(modelConnectionHintsFound.contains(h) && 
						deepestSourceSectionClassesByModelConnectionHint.get(h).contains(srcSection))) {
					changedRefsAndHints.getHintValues().removeHintValue(h); // remove incomplete hint value
				} else if (deepestSourceSectionClassesByModelConnectionHint.get(h).size() > 1) {

					changedRefsAndHints.getUnsyncedHintValues().setHintValues(modelConnectionHint, srcSection, new LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>>());
					final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> val = changedRefsAndHints.getHintValues().removeHintValue(modelConnectionHint);
					changedRefsAndHints.getUnsyncedHintValues().addHintValue(modelConnectionHint, srcSection, val);
				}
			}
		}

		return changedRefsAndHints;

	}

	/**
	 * This checks if all {@link SourceSectionReference References} that have been defined for a given 
	 * {@link SourceSectionClass} can be matched for the given '<em>srcModelObject</em>'. Therefore, all
	 * {@link SourceSectionClass#getCardinality() cardinalities} of referenced {@link SourceSectionClass classes}
	 * are checked.
	 * <br />
	 * <b>Note:<b/> For every {@link SourceSectionClass class} that is referenced by a modeled
	 * {@link SourceSectionReference reference}, this calls {@link #checkMapping(EObject, boolean, Iterable, Iterable, 
	 * SourceSectionClass, MappingInstanceStorage) checkMapping()} so that we iteratively go through the complete
	 * hierarchy of the modeled section.
	 * 
	 * @param srcModelObject The object to be checked.
	 * @param usedOkay  Whether elements already contained in <em>changedRefsAndHints<em> can be matched again. 
	 * This needs to be set to '<em>true</em> when {@link #checkReferences(EObject, boolean, Iterable, Iterable, 
	 * SourceSectionClass, MappingInstanceStorage, Map, Map, Map) checkMapping()} is called for a non-containment reference.
	 * @param hints A list of {@link MappingHintBaseType MappingHints} that are associated with the mapping 
	 * that is currently evaluated.
	 * @param globalAttributes A list of {@link GlobalAttribute GlobalAttributes}.
	 * @param srcSection The {@link SourceSectionClass} for which the references shall be checked.
	 * @param changedRefsAndHints The {@link MappingInstanceStorage} containing the hint values that have been already 
	 * determined (earlier in the recursion cycle).
	 * @param classByRefMap A map that collects all {@link SourceSectionClass SourceSectionClasses} and the 
	 * {@link SourceSectionReference} that they are referenced by. 
	 * @param refByClassMap A map that collects all {@link SourceSectionReference SourceSectionReferences} and the
	 * {@link SourceSectionClass} that they are contained in.
	 * @param mappingCounts A map that stores how often each {@link SourceSectionClass} has been matched.
	 */
	@SuppressWarnings("unchecked")
	private boolean checkReferences(final EObject srcModelObject, final boolean usedOkay,
			final Iterable<MappingHintBaseType> hints, final Iterable<GlobalAttribute> globalAttributes,
			final SourceSectionClass srcSection, final MappingInstanceStorage changedRefsAndHints,
			final Map<EReference, List<SourceSectionClass>> classByRefMap,
			final Map<SourceSectionClass, SourceSectionReference> refByClassMap,
			final Map<SourceSectionClass, Integer> mappingCounts) {

		/*
		 * update the 'classByRef' and 'refByClass' map
		 */
		for (final SourceSectionReference ref : srcSection.getReferences()) {
			if (!classByRefMap.containsKey(ref.getEReference())) {
				classByRefMap.put(ref.getEReference(), new LinkedList<SourceSectionClass>());
			}

			classByRefMap.get(ref.getEReference()).addAll(ref.getValuesGeneric());

			for (final SourceSectionClass c : ref.getValuesGeneric()) {
				refByClassMap.put(c, ref);
				mappingCounts.put(c, new Integer(0));
			}
		}

		// now go through all the srcMmSection refs
		for (final EReference ref : classByRefMap.keySet()) {
			// check if reference is allowed by src metamodel
			// check if reference in srcMMSection points anywhere
			if (classByRefMap.get(ref).size() < 1) {

				/*
				 * if no target SourceSectionClass has been specified, this means that there must be NO target element
				 * in the source model; if this is not the case (meaning that there is a target element for the reference),
				 * the mapping is not applicable
				 */
				if((ref.isMany() && !((EList<EObject>) srcModelObject.eGet(ref)).isEmpty()) ||
						(!ref.isMany() && srcModelObject.eGet(ref) != null)) {
					return false;
				} else {
					break;					
				}
			}

			/*
			 * get targets of the reference in the source model, then behave depending on the
			 * cardinality of the reference
			 */
			final Object refTarget = srcModelObject.eGet(ref);

			/*
			 * There are cases in which modeling more target values for a
			 * section than it can actually hold might make sense depending on
			 * how the target's CardinalityType value was set. Therefore we do
			 * not check the modeled references values at this point.
			 */
			if (ref.getUpperBound() == 1) {

				final EObject refTargetObj = (EObject) refTarget;
				if (refTargetObj == null) {
					return false;
				}

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
						if (nonZeroCardSectionFound) {
							// modeling error
							consoleStream.println("Modeling error in source section: '" + srcSection.getContainer().getName()
									+ "', subsection: '" + srcSection.getName() + "'. The Reference '" + refByClassMap.get(c)
									+ "' points to a metamodel reference, that can only hold one value but in the source section "
									+ "it references more than one Class with a CardinalityType that is not ZERO_INFINITY.");
							return false;
						}
						nonZeroCardSectionFound = true;
						res = checkMapping(
								refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference
								|| usedOkay, hints,
								globalAttributes, c, changedRefsAndHints);
						if (canceled) {
							return false;
						}
					}
				}

				if (!nonZeroCardSectionFound) {
					for (final SourceSectionClass c : classByRefMap.get(ref)) {
						res = checkMapping(
								refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference
								|| usedOkay, hints,
								globalAttributes, c, changedRefsAndHints);
						if (canceled) {
							return false;
						}
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
					return false;
				}

			} else {// unbounded or unspecified
				// cast refTarget to EList
				final LinkedList<EObject> refTargetL = new LinkedList<>(
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

				final LinkedHashSet<EObject> elementsUsableForVC = new LinkedHashSet<>();
				// find possible srcElements for mmsections
				for (final EObject rt : refTargetL) {
					boolean foundMapping = false;
					for (final SourceSectionClass val : classByRefMap.get(ref)) {
						final MappingInstanceStorage res = checkMapping(
								rt,
								refByClassMap.get(val) instanceof MetaModelSectionReference
								|| usedOkay, hints,
								globalAttributes, val, changedRefsAndHints);
						if (canceled) {
							return false;
						}

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
						return false; // we need to find a mapping for every
						// srcModelElement if the reference Type
						// was modeled in the srcMMSection
					}
				}

				final LinkedList<EObject> allElementsMapped = new LinkedList<>();

				while (possibleSrcModelElementsNoVC.keySet().size() > 0) {
					final SourceSectionClass smallestKey = possibleSrcModelElementsNoVC
							.getKeyForValueWithSmallestCollectionSize();
					if (possibleSrcModelElementsNoVC.get(smallestKey).size() > 0) {
						MappingInstanceStorage srcSectionResult;
						// we need to filter a little more
						if (possibleSrcModelElementsNoVC.get(smallestKey)
								.size() > 1) {
							LinkedList<MappingInstanceStorage> possibleElements = new LinkedList<>();
							possibleElements
							.addAll(possibleSrcModelElementsNoVC
									.get(smallestKey));

							// filter elements that can be used for a vc-section
							final LinkedList<MappingInstanceStorage> allVCIncompatible = new LinkedList<>();
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
						return false;// all non-vc-elements need to be mapped
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
						// remove mmSection from list
						possibleSrcModelElementsVC.remove(smallestKey);
					} else {
						// the fact that samllestKey is not in the collection means that no mapping was found at all
						return false;
					}
				}

				// check if all refTargets where mapped
				refTargetL.removeAll(allElementsMapped);
				if (refTargetL.size() > 0) {
					consoleStream.println("Not everything could be mapped");
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * This checks if all {@link SourceSectionAttribute Attributes} that have been defined for a given 
	 * {@link SourceSectionClass} can be mapped for the given '<em>srcModelObject</em>'. Therefore, 
	 * all the {@link AttributeValueConstraint AttributeValueConstraints} are checked.
	 * <br />
	 * <b>Note:</b> The hint values that are determined from the attribute values are calculated during 
	 * above process as well. They are stored in the various <em>...HintValues</em> maps.
	 * 
	 * @param srcModelObject The object to be checked.
	 * @param hints A list of {@link MappingHintBaseType MappingHints} that are associated with the mapping 
	 * that is currently evaluated.
	 * @param globalAttributes A list of {@link GlobalAttribute GlobalAttributes}.
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
	private boolean checkAttributes(
			final EObject srcModelObject,
			final Iterable<MappingHintBaseType> hints,
			final Iterable<GlobalAttribute> globalAttributes,
			final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints,
			final Map<AttributeMappingSourceElement, AttributeValueRepresentation> complexSourceElementHintValues,
			final Map<AttributeMatcherSourceElement, AttributeValueRepresentation> complexAttrMatcherSourceElementHintValues,
			final Map<ModelConnectionHintSourceElement, AttributeValueRepresentation> complexConnectionHintSourceElementHintValues) {
		
		ReferenceableValueCalculator refValueCalculator = new ReferenceableValueCalculator(null, null, consoleStream);
		
		for (final SourceSectionAttribute at : srcSection.getAttributes()) {

			/*
			 * Check if the modeled attribute exists in the srcModelObject
			 */
			final Object srcAttr = srcModelObject.eGet(at.getAttribute());

			if (srcAttr == null) {
				/*
				 * This is not a problem unless any mappings point here or AttributeValueConstraints were modeled.
				 * Unset mapping hint values are handled elsewhere. Here we only need to check for matchers.
				 */
				if (at.getValueConstraint().size() > 0) {
					return false;
				}
			} else {

				/*
				 * As attributes may have a cardinality greater than 1, too, we have to handle
				 * every attribute value separately.
				 */
				ArrayList<Object> srcAttrValues = new ArrayList<>();
				if(at.getAttribute().isMany()) {
					srcAttrValues.addAll((Collection<?>) srcAttr);
				} else {
					srcAttrValues.add(srcAttr);
				}

				/*
				 * First, we check if all the constraints are satisfied for every attribute value.
				 */
				for (Object srcAttrValue : srcAttrValues) {

					// convert Attribute value to String
					final String srcAttrAsString = at.getAttribute().getEType().getEPackage().getEFactoryInstance()
							.convertToString(at.getAttribute().getEAttributeType(), srcAttrValue);
					/*
					 * check AttributeValueConstraints
					 *
					 * Inclusions are OR connected
					 *
					 * Exclusions are NOR connected
					 */
					boolean inclusionMatched = false;
					boolean containsInclusions = false;
					for (final AttributeValueConstraint constraint : at.getValueConstraint()) {

						if (constraintsWithErrors.contains(constraint)) {
							continue;
						}

						boolean constraintVal=false; // TODO have to be initialized?!!
						try {
							// Note: 'checkConstraint' already takes the type (INCLUSION/EXCLUSION) into consideration
							// Starting from now we have to differentiate between Single- and MultipleReferenceAttributeValueConstraints
							// and we need to extract the right reference Value(s) for each constraint
							
							if (constraint instanceof SingleReferenceAttributeValueConstraint){
								String srcAttrRefValAsString = refValueCalculator.calculateReferenceValue(srcAttrValue); //TODO actually reference Values will be calculated for each loop 
								constraintVal = ((SingleReferenceAttributeValueConstraint) constraint).checkConstraint(srcAttrAsString,srcAttrRefValAsString);
								srcAttrRefValAsString = null; //TODO Do we need this?
							} else if (constraint instanceof MultipleReferencesAttributeValueConstraint){
								
								if(constraint instanceof RangeConstraint){
									List<String> srcAttrRefValuesAsList = new ArrayList<String>();
									srcAttrRefValuesAsList.add(refValueCalculator.calculateReferenceValue(((RangeConstraint) srcAttrValue).getLowerBound()));
									srcAttrRefValuesAsList.add(refValueCalculator.calculateReferenceValue(((RangeConstraint) srcAttrValue).getUpperBound()));
									
									BasicEList<String> RefValuesAsEList = new BasicEList<String>(srcAttrRefValuesAsList); // TODO Convert List to EList // Check it 
									constraintVal = ((MultipleReferencesAttributeValueConstraint) constraint).checkConstraint(srcAttrAsString,RefValuesAsEList);
									srcAttrRefValuesAsList.clear();
									RefValuesAsEList.clear(); //TODO Do we need this?
								}
								// placeholder for other MultipleReferenceAttributeValueConstraints
								// else if (constraint instanceof xxx){}
								
							}
						} catch (final Exception e) {
							constraintsWithErrors.add(constraint);
							consoleStream.println("The AttributeValueConstraint '" + constraint.getName() + "' of the Attribute '"
									+ at.getName() + " (Class: " + at.getOwningClass().getName() + ", Section: " + at.getContainingSection().getName()
									+ ")' could not be evaluated and will be ignored. The following error was supplied:\n"
									+ e.getLocalizedMessage());
							continue;
						}

						if (!constraintVal && constraint.getType().equals(AttributeValueConstraintType.EXCLUSION)) {
							return false;
						} else if (constraint.getType().equals(AttributeValueConstraintType.INCLUSION)) {
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

				/*
				 * Second, we iterate once again and calculate all the hint values based
				 * on the attributes.
				 * Note: We have to iterate two times to prevent side effects if the check for
				 * constraints (see above) fails at anything but the first value.
				 */
				for (Object srcAttrValue : srcAttrValues) {

					// convert Attribute value to String
					final String srcAttrAsString = at.getAttribute().getEType().getEPackage().getEFactoryInstance()
							.convertToString(at.getAttribute().getEAttributeType(), srcAttrValue);

					/*
					 * Now, calculate the hint values for the various types of hints.
					 */
					for (final MappingHintBaseType hint : hints) {
						if (hint instanceof MappedAttributeValueExpander) {
							MappedAttributeValueExpander mappedAttributeValueExpander = (MappedAttributeValueExpander) hint;

							if (mappedAttributeValueExpander.getSourceAttribute().equals(at)) {

								if(at.getAttribute().isMany()) {
									//TODO implement this?
									throw new RuntimeException("MappedAttributeValueExpanders based on multi-valued attributes are not yet supported!");
								}

								final String valCopy = attributeValueModifierExecutor.
										applyAttributeValueModifiers(srcAttrAsString, mappedAttributeValueExpander.getModifiers());
								changedRefsAndHints.getHintValues().addHintValue(mappedAttributeValueExpander, valCopy);
							}

						} else if (hint instanceof AttributeMapping) {
							AttributeMapping attributeMapping = (AttributeMapping) hint;

							for (final AttributeMappingSourceElement sourceElement : attributeMapping.getLocalSourceElements()) {
								if (sourceElement.getSource().equals(at)) {

									final String valCopy = attributeValueModifierExecutor
											.applyAttributeValueModifiers(srcAttrAsString, sourceElement.getModifier());

									// create a new AttributeValueRepresentation or update the existing one
									if(complexSourceElementHintValues.get(sourceElement) == null) {
										complexSourceElementHintValues.put(sourceElement, new AttributeValueRepresentation(sourceElement.getSource(), valCopy));
									} else {
										complexSourceElementHintValues.get(sourceElement).addValue(valCopy);
									}
								}
							}
						} else if (hint instanceof MappingInstanceSelector) {
							MappingInstanceSelector mappingInstanceSelector = (MappingInstanceSelector) hint;

							if (mappingInstanceSelector.getMatcher() instanceof AttributeMatcher) {

								final AttributeMatcher matcher = (AttributeMatcher) mappingInstanceSelector.getMatcher();

								for (final AttributeMatcherSourceElement sourceElement : matcher.getLocalSourceElements()) {
									if (sourceElement.getSource().equals(at)) {

										final String valCopy = attributeValueModifierExecutor
												.applyAttributeValueModifiers(srcAttrAsString, sourceElement.getModifier());

										// create a new AttributeValueRepresentation or update the existing one
										if(complexAttrMatcherSourceElementHintValues.get(sourceElement) == null) {
											complexAttrMatcherSourceElementHintValues.put(sourceElement, new AttributeValueRepresentation(sourceElement.getSource(), valCopy));
										} else {
											complexAttrMatcherSourceElementHintValues.get(sourceElement).addValue(valCopy);
										}
									}
								}
							}
						} else if (hint instanceof ModelConnectionHint) {
							ModelConnectionHint modelConnectionHint = (ModelConnectionHint) hint;

							for (final ModelConnectionHintSourceElement m : modelConnectionHint.getLocalSourceElements()) {
								if (m.getSource().equals(at)) {

									if(at.getAttribute().isMany()) {
										//TODO implement this?
										throw new RuntimeException("ModelConnectionHints based on multi-valued attributes are not yet supported!");
									}

									final String modifiedVal = attributeValueModifierExecutor
											.applyAttributeValueModifiers(srcAttrAsString, m.getModifier());
									complexConnectionHintSourceElementHintValues.put(m, new AttributeValueRepresentation(at, modifiedVal));
								}
							}
						}
					}

					/*
					 * Last, calculate the values for GlobalAttributes.
					 */
					for (final GlobalAttribute globalAttribute : globalAttributes) {
						if (globalAttribute.getSource().equals(at)) {
							final String modifiedVal = attributeValueModifierExecutor
									.applyAttributeValueModifiers(srcAttrAsString, globalAttribute.getModifier());
							globalAttributeValues.put(globalAttribute, modifiedVal);
						}
					}

				}
			}
		}

		return true;
	}

	/**
	 * This 'synchronizes' hint values for {@link AttributeMapping AttributeMappings}. This means that those hint values that
	 * have been found in the current iteration cycle are added to the list of {@link MappingInstanceStorage#getUnsyncedHintValues()
	 * unsyncedHintValues} in the given {@link MappingInstanceStorage}. If the given '<em>srcSection</em>' is the common
	 * container for an {@link AttributeMapping} (this means that all necessary hint values should have been found) the
	 * (now complete) list of hint values is stored as {@link MappingInstanceStorage#getHintValues() syncedHintValues} in the given
	 * {@link MappingInstanceStorage}.
	 * 
	 * @param srcSection The {@link SourceSectionClass} (either the sourceMMSection itself or a direct or indirect child of it) that is
	 * currently checked.
	 * @param changedRefsAndHints The {@link MappingInstanceStorage} where all ('<em>synced</em>' as well as '<em>unsynced</em>') 
	 * hint values are stored.
	 */
	private void syncAttributeMappingHintValues(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {

		for (final AttributeMapping h : changedRefsAndHints.getUnsyncedHintValues().getAttributeMappingHintValues().keySet()) {

			final boolean isCommonParent = commonContainerClassOfComplexHints.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnsyncedHintValues().getHintValues(h).size() > 1 || isCommonParent) {
				final Map<SourceSectionClass, LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>>> m = 
						changedRefsAndHints.getUnsyncedHintValues().getAttributeMappingHintValues().get(h);

				// list of "synced" hint values
				LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> syncedHintValues = null;

				// find longest list (ideally they are either of the same
				// length, or there is only one value)
				SourceSectionClass cl = null;
				for (final SourceSectionClass c : m.keySet()) {
					if (syncedHintValues == null) {
						syncedHintValues = m.get(c);
						cl = c;
					} else if (m.get(c).size() > syncedHintValues
							.size()) {
						syncedHintValues = m.get(c);
						cl = c;
					}
				}
				// remove selected List from m
				m.remove(cl);

				// combine values
				for (final SourceSectionClass c : m.keySet()) {
					final LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> vals = m.get(c);
					if (vals.size() == 1) {
						for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> valMap : syncedHintValues) {
							valMap.putAll(vals.getFirst());
						}
					} else if (vals.size() > 1) {
						for (int i = 0; i < vals.size(); i++) {// remember:
							/*
							 * the size of vals will be lower or equel the
							 * size of syncedComplexAttrMappings
							 */
							syncedHintValues.get(i).putAll(vals.get(i));
						}
					}
				}
				m.clear();

				if (isCommonParent) {
					// sync (add to changedRefsAndHints)
					changedRefsAndHints.getHintValues().addHintValues(h, syncedHintValues);
				} else {
					// remove old hints and add new hints
					changedRefsAndHints.getUnsyncedHintValues().setHintValues(h, srcSection, syncedHintValues);
				}
			}
		}
	}

	/**
	 * This 'synchronizes' hint values for {@link AttributeMatcher AttributeMatchers}. This means that those hint values that
	 * have been found in the current iteration cycle are added to the list of {@link MappingInstanceStorage#getUnsyncedHintValues()
	 * unsyncedHintValues} in the given {@link MappingInstanceStorage}. If the given '<em>srcSection</em>' is the common
	 * container for an {@link AttributeMatcher} (this means that all necessary hint values should have been found) the
	 * (now complete) list of hint values is stored as {@link MappingInstanceStorage#getHintValues() syncedHintValues} in the given
	 * {@link MappingInstanceStorage}.
	 * 
	 * @param srcSection The {@link SourceSectionClass} (either the sourceMMSection itself or a direct or indirect child of it) that is
	 * currently checked.
	 * @param changedRefsAndHints The {@link MappingInstanceStorage} where all ('<em>synced</em>' as well as '<em>unsynced</em>') 
	 * hint values are stored.
	 */
	private void syncAttributeMatcherHintValues(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {

		for (final MappingInstanceSelector h : changedRefsAndHints.getUnsyncedHintValues().getMappingInstanceSelectorHintValues().keySet()) {

			final boolean isCommonParent = commonContainerClassOfComplexHints.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnsyncedHintValues().getHintValues(h).size() > 1 || isCommonParent) {
				final Map<SourceSectionClass, LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>>> m = 
						changedRefsAndHints.getUnsyncedHintValues().getMappingInstanceSelectorHintValues().get(h);
				// list of "synced" hints
				LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> syncedHintValues = null;
				// find longest list (ideally they are either of the same
				// length, or there is only one value)
				SourceSectionClass cl = null;
				for (final SourceSectionClass c : m.keySet()) {
					if (syncedHintValues == null) {
						syncedHintValues = m.get(c);
						cl = c;
					} else if (m.get(c).size() > syncedHintValues
							.size()) {
						syncedHintValues = m.get(c);
						cl = c;
					}
				}
				// remove selected List from m
				m.remove(cl);

				// combine values
				for (final SourceSectionClass c : m.keySet()) {
					final LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> vals = m.get(c);
					if (vals.size() == 1) {
						for (final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> valMap : syncedHintValues) {
							valMap.putAll(vals.getFirst());
						}
					} else if (vals.size() > 1) {
						for (int i = 0; i < vals.size(); i++) {// remember:
							/* 
							 * the size of vals will be lower or equal the size of syncedComplexAttrMappings
							 */
							syncedHintValues.get(i)
							.putAll(vals.get(i));
						}
					}
				}
				m.clear();

				if (isCommonParent) {
					// sync (add to changedRefsAndHints)
					changedRefsAndHints.getHintValues().addHintValues(h, syncedHintValues);
					// }
				} else {
					// remove old hints and add new hints
					changedRefsAndHints.getUnsyncedHintValues().setHintValues(h, srcSection, syncedHintValues);
				}
			}
		}
	}

	/**
	 * This 'synchronizes' hint values for {@link ModelConnectionHint ModelConnectionHints}. This means that those hint values that
	 * have been found in the current iteration cycle are added to the list of {@link MappingInstanceStorage#getUnsyncedHintValues()
	 * unsyncedHintValues} in the given {@link MappingInstanceStorage}. If the given '<em>srcSection</em>' is the common
	 * container for an {@link ModelConnectionHint} (this means that all necessary hint values should have been found) the
	 * (now complete) list of hint values is stored as {@link MappingInstanceStorage#getHintValues() syncedHintValues} in the given
	 * {@link MappingInstanceStorage}.
	 * 
	 * @param srcSection The {@link SourceSectionClass} (either the sourceMMSection itself or a direct or indirect child of it) that is
	 * currently checked.
	 * @param changedRefsAndHints The {@link MappingInstanceStorage} where all ('<em>synced</em>' as well as '<em>unsynced</em>') 
	 * hint values are stored.
	 */
	private void syncModelConnectionHintValues(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {

		for (final ModelConnectionHint h : changedRefsAndHints.getUnsyncedHintValues().getModelConnectionHintValues().keySet()) {

			final boolean isCommonParent = commonContainerClassOfComplexHints.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnsyncedHintValues().getHintValues(h).size() > 1 || isCommonParent) {

				final Map<SourceSectionClass, LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>>> m = 
						changedRefsAndHints.getUnsyncedHintValues().getModelConnectionHintValues().get(h);

				// list of "synced" hints
				LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> syncedHintValues = null;

				// find longest list (ideally they are either of the same
				// length, or there is only one value)
				SourceSectionClass cl = null;
				for (final SourceSectionClass c : m.keySet()) {
					if (syncedHintValues == null) {
						syncedHintValues = m.get(c);
						cl = c;
					} else if (m.get(c).size() > syncedHintValues
							.size()) {
						syncedHintValues = m.get(c);
						cl = c;
					}
				}
				// remove selected List from m
				m.remove(cl);

				// combine values
				for (final SourceSectionClass c : m.keySet()) {
					final LinkedList<Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation>> vals = m.get(c);
					if (vals.size() == 1) {
						for (final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> valMap : syncedHintValues) {
							valMap.putAll(vals.getFirst());
						}
					} else if (vals.size() > 1) {
						for (int i = 0; i < vals.size(); i++) {// remember:
							/*
							 * the size of vals will be lower or equal the size of syncedComplexAttrMappings
							 */
							syncedHintValues.get(i).putAll(vals.get(i));
						}
					}
				}
				m.clear();

				if (isCommonParent) {
					// sync (add to changedRefsAndHints)
					changedRefsAndHints.getHintValues().addHintValues(h, syncedHintValues);
				} else {
					// remove old hints and add new hints
					changedRefsAndHints.getUnsyncedHintValues().setHintValues(h, srcSection, syncedHintValues);
				}
			}
		}
	}

	/**
	 * Tries to determine the hintValues for {@link ExternalModifiedAttributeElementType external hint values}, if present.
	 *
	 * @param m The {@link Mapping} that is currently evaluated.
	 * @param res The {@link MappingInstanceStorage} that contains the hint values that have already been determined. Found external 
	 * hint values for attribute mappings are stored there.
	 * @param mappingFailed If the mapping already failed at an earlier stage.
	 * @return '<em>false</em>' if something went wrong while determining the external hint values for the attribute mapping; '<em>true</em>'
	 * otherwise
	 */
	private boolean determineExternalHintValues(
			final Mapping m,
			final MappingInstanceStorage res, 
			boolean mappingFailed) {

		if (m.getSourceMMSection().getContainer() != null) {

			final Map<ExternalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, AttributeValueRepresentation> attrVals = 
					new HashMap<>();

			for (final MappingHintBaseType h : mappingHints.get(m)) {
				if (h instanceof AttributeMapping) {
					AttributeMapping attributeMapping = (AttributeMapping) h;

					/* try to find a hint value for every external source element; those will
					 * be stored in 'attrVals'
					 */
					for (final AttributeMappingExternalSourceElement i : attributeMapping.getExternalSourceElements()) {
						mappingFailed = determineExternalHintValue(m, res, mappingFailed, attrVals, i);

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
						if (res.getHintValues().getHintValues(attributeMapping).size() == 0) {
							res.getHintValues().getAttributeMappingHintValues().init(attributeMapping, true);
						}

						if(attributeMapping.getExpression() != null && !attributeMapping.getExpression().isEmpty()) {

							final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> newVals = new HashMap<>();
							for (final ExternalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
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
							for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues(attributeMapping)) {
								hVal.putAll(newVals);
							}
						} else {
							for (final Map<AttributeMappingSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues(attributeMapping)) {
								for (final ExternalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
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
					ExternalMappedAttributeValueExpander externalMappedAttributeValueExpander = (ExternalMappedAttributeValueExpander) h;

					if(externalMappedAttributeValueExpander.getSourceAttribute().getAttribute().isMany()) {
						//TODO implement this?
						throw new RuntimeException("ExternalMappedAttributeValueExpanders based on multi-valued attributes are not yet supported!");
					}

					String attrVal = getContainerAttributeValue(
							externalMappedAttributeValueExpander.getSourceAttribute(),
							m.getSourceMMSection().getContainer(), 
							res.getAssociatedSourceModelElement().eContainer());
					if (attrVal == null) {
						mappingFailed = true;
						break;
					} else {
						attrVal = attributeValueModifierExecutor.applyAttributeValueModifiers(attrVal, 
								externalMappedAttributeValueExpander.getModifiers());
						res.getHintValues().addHintValue(externalMappedAttributeValueExpander, attrVal);
					}

				} else if (h instanceof MappingInstanceSelector) {
					MappingInstanceSelector mappingInstanceSelector = (MappingInstanceSelector) h;

					if (mappingInstanceSelector.getMatcher() != null) {
						if (mappingInstanceSelector.getMatcher() instanceof AttributeMatcher) {
							final AttributeMatcher matcher = (AttributeMatcher) mappingInstanceSelector.getMatcher();
							for (final AttributeMatcherExternalSourceElement i : matcher.getExternalSourceElements()) {

								if(i.getSourceAttribute().getAttribute().isMany()) {
									//TODO implement this?
									throw new RuntimeException("AttributeMatchers based on multi-valued attributes are not yet supported!");
								}

								mappingFailed = determineExternalHintValue(
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
								if (res.getHintValues().getHintValues(mappingInstanceSelector).size() == 0) {
									res.getHintValues().getMappingInstanceSelectorHintValues().init(mappingInstanceSelector, true);
								}

								for (final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues(mappingInstanceSelector)) {
									for (final ExternalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
											.keySet()) {
										hVal.put((AttributeMatcherSourceInterface) e, attrVals.get(e));
									}
								}
								// last action: reset attrval list
								attrVals.clear();
							}
						}
					}
				} else if (h instanceof ModelConnectionHint) {
					ModelConnectionHint modelConnectionHint = (ModelConnectionHint) h;

					for (final ModelConnectionHintExternalSourceElement i : modelConnectionHint.getExternalSourceElements()) {

						if(i.getSourceAttribute().getAttribute().isMany()) {
							//TODO implement this?
							throw new RuntimeException("ModelConnectionHints based on multi-valued attributes are not yet supported!");
						}

						mappingFailed = determineExternalHintValue(
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
						if (res.getHintValues().getHintValues(modelConnectionHint).size() == 0) {
							res.getHintValues().getModelConnectionHintValues().init(modelConnectionHint, true);
						}

						for (final Map<ModelConnectionHintSourceInterface, AttributeValueRepresentation> hVal : res.getHintValues().getHintValues(modelConnectionHint)) {
							for (final ExternalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> e : attrVals
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
	 * Helper method to determine a value for an {@link ExternalModifiedAttributeElementType}. This uses {@link #getContainerAttributeValue(
	 * SourceSectionAttribute, SourceSectionClass, EObject)} to find a hint value for a given {@link MappingHintSourceInterface}, 
	 * applies possible {@link AttributeValueModifierSet AttributeValueModifierSets} and stores the found value in the '<em>attrVals</em>' map.
	 *
	 * @param m The {@link Mapping} that is currently checked.
	 * @param res The {@link MappingInstanceStorage} representing the mapping that is currently checked.
	 * @param mappingFailed Whether the mapping failed earlier. //TODO do we really need this here? 
	 * @param attrVals The map where a found external hint value shall be stored.
	 * @param externalModifiedAttributeElement The {@link ExternalModifiedAttributeElementType} for that the hint value shall be determined.
	 * @return '<em>true</em>' if the hint value could be determined; '<em>false</em>' otherwise
	 */
	private boolean determineExternalHintValue(
			final Mapping m,
			final MappingInstanceStorage res, 
			boolean mappingFailed,
			final Map<ExternalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>, AttributeValueRepresentation> attrVals,
			final ExternalModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> externalModifiedAttributeElement) {

		String attrVal = getContainerAttributeValue(
				externalModifiedAttributeElement.getSource(),
				m.getSourceMMSection().getContainer(), 
				res.getAssociatedSourceModelElement().eContainer());
		if (attrVal == null) {
			mappingFailed = true;
		} else {
			attrVal = attributeValueModifierExecutor.applyAttributeValueModifiers(
					attrVal, externalModifiedAttributeElement.getModifier());
			attrVals.put(
					externalModifiedAttributeElement, 
					new AttributeValueRepresentation(externalModifiedAttributeElement.getSource(), attrVal));
		}

		return mappingFailed;
	}

	/**
	 * Determines and returns the value of a {@link SourceSectionAttribute} that is located somewhere
	 * inside the given {@link SourceSectionClass} respectively the corresponding {@link EObject}.
	 *
	 * @param attr
	 *            The {@link SourceSectionAttribute attribute} to find.
	 * @param extClass
	 *            The {@link SourceSectionClass container class} to start looking.
	 * @param extObj
	 *            The {@link EObject} that corresponds to the <em>container class</em>.
	 * @return The value of the {@link SourceSectionAttribute} or '<em>null</em>' if the value could
	 * not be determined.
	 */
	private String getContainerAttributeValue(
			final SourceSectionAttribute attr, 
			SourceSectionClass extClass,
			EObject extObj) {

		final SourceSectionClass attrClass = attr.getOwningClass();

		while (true) {
			// found container section?
			if (attrClass.equals(extClass)) {
				final Object attrVal = extObj.eGet(attr.getAttribute());
				if (attrVal == null) {
					consoleStream.println("Unset external Attrbute "+ attr.getName());
					return null;

				} else { // convert Attribute value to String
					return attr.getAttribute().getEType().getEPackage().getEFactoryInstance().convertToString(
							attr.getAttribute().getEAttributeType(), attrVal);
				}
			} else if (extClass.eContainer() instanceof SourceSectionContainmentReference) {
				extClass = (SourceSectionClass) extClass.eContainer().eContainer();
				extObj = extObj.eContainer();
				// Check if the parent object exists, and if it was mapped for
				// the section.
				if (!checkObjectWasMapped(extClass, extObj)) {
					return null;
				}
			} else if (extClass.eContainer() instanceof SourceSectionModel
					&& extClass.getContainer() != null) {
				extClass = extClass.getContainer();
				extObj = extObj.eContainer();
				if (!checkObjectWasMapped(extClass, extObj)) {
					return null;
				}
			} else {// modeling error, object not found
				consoleStream.println("Modeling error. External Source Element " + attr.getName()
				+ "is not part of the the container section or the section that the container "
				+ "section is part of.");
				return null;
			}

		}
	}

	/**
	 * This can be used to check if a given '<em>clazz</em>' and the corresponding '<em>object</em>' have been matched
	 * previously (by another mapping).
	 *  
	 * @param clazz The {@link SourceSectionClass} that shall be checked for previous matching.
	 * @param object The {@link EObject} that shall be checked for previous matching.
	 */
	private boolean checkObjectWasMapped(final SourceSectionClass clazz,
			final EObject object) {
		if (object != null) {
			if (matchedSections.containsKey(clazz)) {
				if (matchedSections.get(clazz).contains(object)) {
					return true;
				}
			} else if (matchedContainers.containsKey(clazz)) {
				if (matchedContainers.get(clazz).contains(object)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check if the container section referenced by the {@link SourceSectionClass SourceSectionClass'}
	 * container can be matched for the given element.
	 *
	 * @param element The {@link EObject element} for that the container shall be checked.
	 * @param sourceSectionClass The {@link SourceSectionClass} that specifies the container to be checked.
	 * @return '<em>true</em>' if the {@link SourceSectionClass#getContainer() container} of the SourceSectionClass
	 *         has not been set or if a fitting container instance exists; '<em>false</em>' otherwise
	 */
	private boolean checkContainer(final EObject element,
			final SourceSectionClass sourceSectionClass) {

		if (sourceSectionClass.getContainer() == null) {

			// this part is easy
			return true;
		}

		/*
		 * Step 1: identify all containers and the corresponding elements; we do not collect
		 * all elements all the way up but only those SourceSectionClasses for that 'isSection()' returns 'true'
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
				while (!currentClass.getContainingSection().equals(currentClass)) {
					if (currentElement.eContainer() != null) {
						currentElement = currentElement.eContainer();
						currentClass = currentClass.getOwningContainmentReference().getOwningClass();
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
		 * Step 2: Check if each container section can be matched, starting from the highest
		 */
		for(int i=containerClasses.size() - 1; i >= 0; i--) {
			/*
			 * map container if it wasn't mapped before
			 */
			if (!checkObjectWasMapped(containerClasses.get(i), containerElements.get(i))) {

				final MappingInstanceStorage res = checkMapping(
						containerElements.get(i), false,
						Collections.<MappingHintBaseType> emptyList(),
						Collections.<GlobalAttribute> emptyList(),
						containerClasses.get(i),
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
			 * This should not be necessary as it only checks if the current element has been matched which
			 * has already been checked via 'res == null'!?
			 */
			//			/*
			//			 * make sure that next container's container was mapped at the
			//			 * appropriate position
			//			 */
			//			if (i-1 >= 0) {
			//				if (!checkObjectWasMapped(containerClasses.get(i-1).getContainer(), containerElements.get(i-1).eContainer())) {
			//					return false;
			//				}
			//			} else {// we cannot put this element in the list because we do
			//				// not want to map it already
			//				if (!checkObjectWasMapped(sourceSectionClass.getContainer(), element.eContainer())) {
			//					return false;
			//				}
			//			}
		}

		// if we reached this point all went well
		return true;

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

			// initialize the 'mappingHints' map
			mappingHints.put(mapping, new LinkedList<MappingHintBaseType>());
			for (final MappingHintGroupType g : mapping.getActiveMappingHintGroups()) {
				if (g.getMappingHints() != null) {
					mappingHints.get(mapping).addAll(g.getMappingHints());
				}
				if (g instanceof MappingHintGroup) {
					if (((MappingHintGroup) g).getModelConnectionMatcher() != null) {
						mappingHints.get(mapping).add(
								((MappingHintGroup) g).getModelConnectionMatcher());
					}
				}
			}
			for (final MappingHintGroupImporter g : mapping.getActiveImportedMappingHintGroups()) {
				if (g.getMappingHints() != null) {
					mappingHints.get(mapping).addAll(g.getMappingHints());
				}
			}

			for (final MappingHintBaseType h : mappingHints.get(mapping)) {
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
				} else if (h instanceof ModelConnectionHint) {
					// initialize the 'deepestSourceSectionsByModelConnectionHint' map
					buildDeepestSourceSectionClassesByModelConnectionHintMap(
							(ModelConnectionHint) h, mapping.getSourceMMSection());
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
			final Set<ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> srcElements = 
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
			final Set<ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> srcElements = 
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
			final Set<ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> srcElements = 
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
			final Set<ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute>> sourceElements,
			final SourceSectionClass srcSection, 
			final MappingHintBaseType hint) {

		final Set<SourceSectionClass> resultSet = new HashSet<>();

		/*
		 * Fill the resultSet with all potential candidates
		 */
		for (final ModifiedAttributeElementType<SourceSection, SourceSectionClass, SourceSectionReference, SourceSectionAttribute> sourceElement : sourceElements) {
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
						final Set<SourceSectionClass> childrenChecked = new HashSet<>();
						final List<SourceSectionClass> classesToCheck = new LinkedList<>();
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
		final LinkedHashMap<EObject, Integer> usages = new LinkedHashMap<>();
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
