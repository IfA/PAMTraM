package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsoleStream;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.selectors.GenericItemSelectorDialogRunner;
import de.mfreund.gentrans.transformation.selectors.PathAndInstanceSelectorRunner;
import de.mfreund.gentrans.transformation.util.CancellationListener;
import de.tud.et.ifa.agtele.genlibrary.LibraryContextDescriptor;
import pamtram.mapping.AttributeMapping;
import pamtram.mapping.AttributeMappingSourceInterface;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.GlobalValue;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.metamodel.ActualAttribute;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.TargetSectionAttribute;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;
import pamtram.util.GenLibraryManager;

/**
 * Class for instantiating target model sections using the hints supplied by
 * MappingInstancestorages.
 *
 *
 * @author Sascha Steffen
 * @version 1.0
 *
 */
class TargetSectionInstantiator implements CancellationListener {
	/**
	 * find Attribute mapping to determine cardinality
	 *
	 * @param metaModelSection
	 * @param hints
	 * @param hintValues
	 * @param oldSelectedHint
	 * @return
	 */
	private static AttributeMapping searchAttributeMapping(
			final TargetSectionClass metaModelSection,
			final Collection<MappingHint> hints,
			final HintValueStorage hintValues,
			final AttributeMapping oldSelectedHint) {
		AttributeMapping selectedHint = oldSelectedHint;
		for (final TargetSectionAttribute attr : metaModelSection
				.getAttributes()) {// check attributes
			for (final MappingHint hint : hints) {
				if (hint instanceof AttributeMapping) {
					if (((AttributeMapping) hint).getTarget().equals(attr)) {

						if (selectedHint == null || hintValues.getHintValues((AttributeMapping) hint).size() == 0) {
							if (hintValues.getHintValues((AttributeMapping) hint).size() == 0) {
								return null;// there needs to be at least one
								// value for each attributeHint
							} else {
								selectedHint = (AttributeMapping) hint;
							}
						} else if (hintValues.getHintValues((AttributeMapping) hint).size() > hintValues.getHintValues(selectedHint).size()) {
							selectedHint = (AttributeMapping) hint;
						}
					}
				}
			}
		}

		for (final TargetSectionReference ref : metaModelSection
				.getReferences()) {// check references
			for (final TargetSectionClass val : ref.getValuesGeneric()) {
				if (val.getCardinality().equals(CardinalityType.ONE)) {
					final AttributeMapping hint = searchAttributeMapping(val, hints,
							hintValues, selectedHint);
					if (hint == null && selectedHint != null) {
						return null;
					} else {
						selectedHint = hint;
					}
				}
			}
		}

		return selectedHint;
	}

	/**
	 * TargetSectionContainmentReferences that point to a EReference with an
	 * upporBound of 1 but at one point more than one element was supposed to be
	 * connected with them
	 */
	private final Set<TargetSectionContainmentReference> wrongCardinalityContainmentRefs;
	//	/**
	//	 * used for modifying attribute values
	//	 */
	//	private final AttributeValueModifierExecutor attributeValuemodifier;
	//	/**
	//	 * RoundFunction instance, needed when evaluating ClaculatorMappingHints
	//	 */
	//	private RoundFunction round;
	//	/**
	//	 * MaxFunction instance, needed when evaluating ClaculatorMappingHints
	//	 */
	//	private MaxFunction max;
	//	/**
	//	 * MinFunction instance, needed when evaluating ClaculatorMappingHints
	//	 */
	//	private MinFunction min;

	/**
	 * target section registry used when instantiating classes
	 */
	private final TargetSectionRegistry targetSectionRegistry;
	/**
	 * used when setting attribute values
	 */
	private final AttributeValueRegistry attributeValueRegistry;
	/**
	 * used to write console output
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * abort transformation if true
	 */
	private boolean transformationAborted;

	/**
	 * Registry for values of global Variables that can be mapped to double
	 */
	private final Map<String, Double> globalVarValueDoubles;

	/**
	 * List of {@link LibraryEntryInstantiator}s that are to be used at the end of the
	 * transformation.
	 */
	private ArrayList<LibraryEntryInstantiator> libEntryInstantiators = new ArrayList<>();

	/**
	 * An instance of {@link AttributeValueCalculator} that is used to calculate attribute values.
	 */
	private AttributeValueCalculator calculator; 

	/**
	 * The parent {@link GenericTransformationRunner}.
	 */
	private final GenericTransformationRunner transformationRunner;

	/**
	 * @param targetSectionRegistry
	 *            target section registry used when instantiating classes
	 * @param attributeValueRegistry
	 *            used when setting attribute values
	 * @param globalVarValues
	 *            Registry for values of global Variables
	 * @param attributeValuemodifier An instance of the {@link AttributeValueModifierExecutor}.
	 * @param globalVals A list of {@link GlobalValue}s.
	 * @param consoleStream
	 *            used to write console output
	 * @param transformationRunner The parent {@link GenericTransformationRunner}.
	 */
	TargetSectionInstantiator(
			final TargetSectionRegistry targetSectionRegistry,
			final AttributeValueRegistry attributeValueRegistry,
			final Map<GlobalAttribute, String> globalVarValues,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final List<GlobalValue> globalVals,
			final MessageConsoleStream consoleStream,
			final GenericTransformationRunner transformationRunner) {
		this.targetSectionRegistry = targetSectionRegistry;
		this.attributeValueRegistry = attributeValueRegistry;
		this.consoleStream = consoleStream;
		this.transformationRunner = transformationRunner;
		transformationAborted = false;
		//		this.attributeValuemodifier = attributeValuemodifier;
		wrongCardinalityContainmentRefs = new HashSet<TargetSectionContainmentReference>();

		//		try {
		//			round = new RoundFunction();
		//			max = new MaxFunction();
		//			min = new MinFunction();
		//		} catch (final InvalidCustomFunctionException e) {
		//			consoleStream.println("This will never happen.");
		//		}

		consoleStream
		.println("Parsing GlobalVariables for numbers. Look below for potential errors..");
		// find GlobalAttrs that can be mapped to double
		globalVarValueDoubles = new HashMap<String, Double>();
		for (final GlobalAttribute g : globalVarValues.keySet()) {
			try {
				final Calculable calc = new ExpressionBuilder(
						globalVarValues.get(g)).build();
				final double variableVal = calc.calculate();// parseDouble
				// doesn't support
				// Scientific
				// notation, like:
				// 0.42e2 == 4200e-2
				// == 42,
				globalVarValueDoubles.put(g.getName(), new Double(variableVal));
			} catch (final Exception e) {
				consoleStream.println(e.getMessage());
			}

		}

		/*
		 * add global values
		 */
		for (final GlobalValue val : globalVals) {
			if (val.getName() != null) {
				globalVarValueDoubles.put(val.getName(), val.getValue());
			}
		}

		calculator = new AttributeValueCalculator(globalVarValueDoubles, attributeValuemodifier, consoleStream);

		consoleStream.println("...parsing done!");
	}

	/**
	 * Set reference value
	 *
	 * @param ref
	 * @param target
	 * @param source
	 */
	private void addValueToReference(
			final TargetSectionNonContainmentReference ref,
			final EObject target, final EObject source) {
		if (ref.getEReference().getUpperBound() == 1) {
			if (source.eIsSet(ref.getEReference())) {
				consoleStream
				.println("More than one value was supposed to be connected to the TargetSectionNonContainmentReference '"
						+ ref.getName()
						+ "' in the target section '"
						+ ref.getContainingSection()
						+ "Please check your mapping model.");

			} else {
				source.eSet(ref.getEReference(), target);
			}
		} else {
			@SuppressWarnings("unchecked")
			final EList<EObject> oldRefs = (EList<EObject>) source.eGet(ref
					.getEReference());
			final LinkedList<EObject> newRefs = new LinkedList<EObject>();
			if (oldRefs != null) {
				newRefs.addAll(oldRefs);
			}
			newRefs.add(target);
			source.eSet(ref.getEReference(), newRefs);

		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.mfreund.gentrans.transformation.CancellationListener#cancel()
	 */
	@Override
	public void cancel() {
		transformationAborted = true;

	}

	/**
	 * instantiate targetModelSection (first pass: attributes and containment
	 * references)
	 * <p>
	 * private recursive version
	 *
	 * @param metamodelSection
	 * @param mappingGroup
	 * @param mappingHints
	 * @param hintValues
	 * @param instBySection
	 * @param mappingName
	 * @param sectionAttributeValues
	 *            These are used to determine if an attribute value was used
	 *            higher up in the section hierarchy.
	 * @return
	 */
	private LinkedList<EObjectTransformationHelper> instantiateTargetSectionFirstPass(
			final TargetSectionClass metamodelSection,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instBySection,
			final String mappingName,
			final Map<EClass, Map<EAttribute, Set<String>>> sectionAttributeValues) {

		int cardinality = 1;
		boolean attrMappingExists = false;
		int cardHintValue = 1;
		/*
		 * check for CardinalityHint
		 */
		for (final MappingHint h : mappingHints) {
			if (h instanceof AttributeMapping) {
				attrMappingExists = true;
			} else if (h instanceof CardinalityMapping) {
				if (((CardinalityMapping) h).getTarget().equals(
						metamodelSection)) {
					if (hintValues.getCardinalityMappingHintValues().containsKey(h)) {
						if (hintValues.getHintValues((CardinalityMapping) h).size() >= 1) {
							final Integer val = hintValues.removeHintValue((CardinalityMapping) h);
							cardHintValue = val.intValue();
						}

					}
				}
			}
		}

		/*
		 * ignore attribute hints and cardinalitys hint, if variableCardinality ==
		 * false
		 */
		if (!metamodelSection.getCardinality().equals(CardinalityType.ONE)) {

			// check for attribute hint
			boolean hintFound = false;
			if (mappingGroup instanceof MappingHintGroup) {
				final MappingHintGroup mhGrp = (MappingHintGroup) mappingGroup;
				if (mhGrp.getModelConnectionMatcher() != null) {
					if (mhGrp.getTargetMMSection().equals(metamodelSection)) {
						hintFound = true;
						cardinality = hintValues.getHintValues(mhGrp.getModelConnectionMatcher()).size();
					}
				}
			}

			final AttributeMapping hint = searchAttributeMapping(metamodelSection,
					mappingHints, hintValues, null);
			if (hint != null) {// there was an AttributeHint....
				int hintCardinality = hintValues.getHintValues(hint).size();

				/*
				 * Now, we have to check if there are multi-valued attributes that also try
				 * to determine the cardinality.
				 */
				int multiValuedAttributeCardinality = 1;

				for (Map<AttributeMappingSourceInterface, AttributeValueRepresentation> x : hintValues.getHintValues(hint)) {

					for(AttributeValueRepresentation rep : x.values()) {
						if(rep.isMany()) {
							if(multiValuedAttributeCardinality == 1) {
								multiValuedAttributeCardinality = rep.getValues().size();
							} else if(multiValuedAttributeCardinality != rep.getValues().size()) {
								throw new RuntimeException("There are different multi-valued attributes with" +
										" different cardinalities!");
							}
						}
					}						
				}

				/*
				 * Check if there are contradictory cardinalities...
				 */
				if(hintCardinality > 1 && multiValuedAttributeCardinality > 1) {
					throw new RuntimeException("Failed to determine an unambiguous cardinality for hint " +
							hint.getName());
				} else if(multiValuedAttributeCardinality > 1) {
					hintCardinality = multiValuedAttributeCardinality;
				}

				if (hintCardinality > cardinality) {
					cardinality = hintCardinality;
				}
			} else {// no AttributeHint found
				if (hintFound && attrMappingExists) { // mc hint found....only
					// go on if there were
					// no attrMappings
					cardinality = 0;
				}
				// no modelConnaectionHint or AttributeMapping found
				// or cardinality is still 1
				// last chance
				if (cardinality == 1) {
					cardinality = cardHintValue;
				}

			}
		}

		if (cardinality > 0) {
			// instantiate self(s)
			final LinkedList<EObjectTransformationHelper> instances = new LinkedList<EObjectTransformationHelper>();
			for (int i = 0; i < cardinality; i++) {

				// create the eObject
				final EObject inst = metamodelSection.getEClass().getEPackage()
						.getEFactoryInstance()
						.create(metamodelSection.getEClass());
				// create an EObjectTransformationHelper that wraps the eObject and more stuff
				EObjectTransformationHelper instTransformationHelper = new EObjectTransformationHelper(inst,
						attributeValueRegistry); 
				instances.add(instTransformationHelper);

				/*
				 * If the target section is a library entry, we create a new 'LibraryEntryInstantiator'
				 * that will insert the real library entry at the end.
				 */
				if(metamodelSection.isLibraryEntry()) {
					LibraryEntry libEntry = (LibraryEntry) metamodelSection.eContainer().eContainer();
					libEntryInstantiators.add(
							new LibraryEntryInstantiator(
									libEntry, instTransformationHelper, mappingGroup, mappingHints, hintValues, consoleStream));
				}

			}

			/*
			 * create attributes
			 */

			/*
			 * we don't need to reference the EObjects, since their order
			 * doesn't change while we are using this
			 */
			final Map<TargetSectionAttribute, List<String>> attributeValues = new HashMap<>();
			final LinkedList<EObjectTransformationHelper> markedForDelete = new LinkedList<>();
			for (final TargetSectionAttribute attr : metamodelSection
					.getAttributes()) {
				attributeValues.put(attr, new LinkedList<String>());

				MappingHint hintFound = null;
				// look for an attribute mapping
				LinkedList<Map<AttributeMappingSourceInterface, AttributeValueRepresentation>> attrHintValues = null;

				for (final MappingHint hint : mappingHints) {
					if (hint instanceof AttributeMapping) {
						if (((AttributeMapping) hint).getTarget().equals(attr)) {

							hintFound = hint;
							if (hintValues.getHintValues((AttributeMapping) hint).size() == 1) {
								attrHintValues = new LinkedList<>();
								for (int i = 0; i < cardinality; i++) {
									attrHintValues.add(hintValues.getHintValues((AttributeMapping) hint).getFirst());
								}
								break;
								// cardinality okay?
							} else if (hintValues.getHintValues((AttributeMapping) hint).size() >= cardinality) {
								attrHintValues = hintValues.getHintValues((AttributeMapping) hint);
								break;
							} else {
								consoleStream.println("Cardinality mismatch (expected: " + cardinality + ", got :"
										+ hintValues.getHintValues((AttributeMapping) hint).size() + "): " + hint.getName()
										+ " for Mapping " + mappingName + " (Group: " + mappingGroup.getName()
										+ ") Maybe check Cardinality of Metamodel section?");
								return null;
							}
						}
					}
				}
				// create attribute values
				for(int i=0; i<instances.size(); i++) {
					EObjectTransformationHelper instance = instances.get(i);
					String attrValue = calculator.calculateAttributeValue(attr, hintFound, attrHintValues);

					// Check if value is unique and was already used, mark
					// instance for deletion if necessary
					boolean attrValUsedInSection = false;
					if (!sectionAttributeValues.containsKey(metamodelSection
							.getEClass())) {
						sectionAttributeValues.put(
								metamodelSection.getEClass(),
								new HashMap<EAttribute, Set<String>>());
					}
					final Map<EAttribute, Set<String>> secAttrValsForEClass = sectionAttributeValues
							.get(metamodelSection.getEClass());
					if (attr instanceof ActualAttribute) {
						final EAttribute eAttr = ((ActualAttribute) attr)
								.getAttribute();
						if (!secAttrValsForEClass.containsKey(eAttr)) {
							secAttrValsForEClass.put(eAttr,
									new HashSet<String>());
						} else {
							attrValUsedInSection = secAttrValsForEClass.get(
									eAttr).contains(attrValue);
						}
						secAttrValsForEClass.get(eAttr).add(attrValue);
					}
					if (attr.isUnique()
							&& (instance.attributeValueExists(attr, attrValue)
									|| attributeValues.get(attr).contains(
											attrValue) || attrValUsedInSection)) {
						/*
						 * we can only delete this at the end, or else the
						 * attributeHint values won't fit anymore
						 */
						markedForDelete.add(instance);
					}
					// save attr value in Map
					attributeValues.get(attr).add(attrValue);

				}
			}

			/*
			 * Now that we know which instances will be deleted we set (and
			 * register) the actual attribute values of the instances that will
			 * not get deleted
			 */
			for (final EObjectTransformationHelper instance : instances) {
				final boolean noDelete = !markedForDelete.contains(instance);
				for (final TargetSectionAttribute attr : attributeValues
						.keySet()) {
					if (noDelete) {
						final String setValue = attributeValues.get(attr)
								.remove(0);
						try {
							/*
							 * setting an Attribute causes the value to be saved
							 * in the attribute value registry
							 */
							instance.setAttributeValue(attr, setValue);

						} catch (final IllegalArgumentException e) {
							consoleStream.println("Could not set Attribute "
									+ attr.getName()
									+ " of target section Class "
									+ metamodelSection.getName()
									+ " in target section "
									+ metamodelSection.getContainingSection()
									.getName() + ".\n"
									+ "The problematic value was: '" + setValue
									+ "'.");
						}
					} else {
						attributeValues.get(attr).remove(0);
					}
				}

			}

			// recursively create containment references
			for (final TargetSectionReference ref : metamodelSection
					.getReferences()) {
				if (ref instanceof TargetSectionContainmentReference) {
					// now instantiate section
					for (final EObjectTransformationHelper instance : instances) {
						final LinkedList<EObjectTransformationHelper> childInstances = new LinkedList<EObjectTransformationHelper>();
						for (final TargetSectionClass val : ((TargetSectionContainmentReference) ref)
								.getValue()) {// instantiate targets
							final LinkedList<EObjectTransformationHelper> children = instantiateTargetSectionFirstPass(
									val, mappingGroup, mappingHints,
									hintValues, instBySection,
									mappingName, sectionAttributeValues);
							if (children != null) { // error? //TODO also delete
								// here?
								childInstances.addAll(children);
							} else {
								consoleStream.println("NoChildren");
								return null;
							}
						}
						// we needed to create the targetSection
						// even though we already knew we didn't want it to be
						// part of the targetModel or else we
						// would get problems with the hintValues
						if (!markedForDelete.contains(instance)) {

							if (ref.getEReference().getUpperBound() == 1) {
								if (childInstances.size() > 1
										&& !wrongCardinalityContainmentRefs
										.contains(ref)) {
									wrongCardinalityContainmentRefs
									.add((TargetSectionContainmentReference) ref);
									consoleStream
									.println("More than one value was supposed to be connected to the TargetSectionContainmentReference '"
											+ ref.getName()
											+ "' in the target section '"
											+ ref.getContainingSection()
											+ "', instantiated by the Mapping '"
											+ mappingName
											+ "' (Group: '"
											+ mappingGroup.getName()
											+ "'). "
											+ "Only the first instance will be added to the model, the rest will be discarded. "
											+ "Please check your mapping model.");
								}
								instance.getEObject().eSet(ref.getEReference(),
										childInstances.getFirst().getEObject());
							} else {
								final LinkedList<EObject> childEObjects = new LinkedList<EObject>();
								for (final EObjectTransformationHelper o : childInstances) {
									childEObjects.add(o.getEObject());
								}
								instance.getEObject().eSet(ref.getEReference(),
										childEObjects);
							}
						}
					}
				}

			}

			// Remove instances marked for delete
			instances.removeAll(markedForDelete);

			// All went well...
			for (final EObjectTransformationHelper instance : instances) {
				// Add instance to map of targetMetaModel
				targetSectionRegistry.addClassInstance(instance, mappingGroup,
						metamodelSection);
			}
			if (instBySection.containsKey(metamodelSection)) {
				instBySection.get(metamodelSection).addAll(instances);
			} else {
				final LinkedList<EObjectTransformationHelper> instClone = new LinkedList<EObjectTransformationHelper>();
				instClone.addAll(instances);
				instBySection.put(metamodelSection, instClone);
			}
			return instances;
		} else if (!metamodelSection.getCardinality().equals(
				CardinalityType.ZERO_INFINITY)) {// <>
			// pamtram!CardinalityType#ZERO__INFINITY){
			consoleStream
			.println("TargetMMSection class '"
					+ metamodelSection.getName()
					+ "' has a cardinality of at least 1 specified, but no suitable mappingHint was found.");
			return null;
		} else {
			/*
			 * return empty Sequence or else this will fail
			 */
			return new LinkedList<EObjectTransformationHelper>();
		}
	}



	/**
	 * instantiate targetModelSection (first pass: attributes and containment
	 * references)
	 *
	 * @param metamodelSection
	 * @param mappingGroup
	 * @param mappingHints
	 * @param hintValues
	 * @param mappingName
	 * @return Map of target section instances
	 */
	LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instantiateTargetSectionFirstPass(
			final TargetSectionClass metamodelSection,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final String mappingName) {

		final LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instBySection = new LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>>();

		/*
		 * Now, perform the first-run instantiation.
		 */
		if (instantiateTargetSectionFirstPass(metamodelSection, mappingGroup,
				mappingHints, hintValues, instBySection,
				mappingName,
				new HashMap<EClass, Map<EAttribute, Set<String>>>()) != null) {
			return instBySection;
		} else {
			return null;
		}

	}

	/**
	 * *instantiate targetModelSection (second pass: non-containment references)
	 *
	 * @param targetSectionClass
	 * @param mappingName
	 * @param group
	 * @param groupTargetSection
	 * @param hints
	 * @param hintValues
	 * @param instancesBySection
	 */
	void instantiateTargetSectionSecondPass(
			final TargetSectionClass targetSectionClass,
			final String mappingName,
			final InstantiableMappingHintGroup group,
			final TargetSectionClass groupTargetSection,
			final List<MappingHint> hints,
			final HintValueStorage hintValues,
			final LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection) {
		/*
		 * only go on if any instances of this section were created
		 */
		if (instancesBySection.get(targetSectionClass) != null) {
			for (final TargetSectionReference refVal : targetSectionClass
					.getReferences()) {
				if (refVal instanceof TargetSectionNonContainmentReference) {
					final TargetSectionNonContainmentReference ref = (TargetSectionNonContainmentReference) refVal;
					final LinkedList<TargetSectionClass> refValueClone = new LinkedList<TargetSectionClass>();
					refValueClone.addAll(ref.getValue());
					boolean hintFound = false;
					// search for mapping instance selector
					for (final MappingHint h : hints) {
						if (h instanceof MappingInstanceSelector) {
							final MappingInstanceSelector hSel = (MappingInstanceSelector) h;
							/*
							 * hint for current ref found
							 */
							if (hSel.getAffectedReference().equals(ref)) {
								/*
								 * handle AttributeMatcher
								 */
								if (hSel.getMatcher() instanceof AttributeMatcher) {
									final AttributeMatcher matcher = (AttributeMatcher) hSel
											.getMatcher();
									hintFound = true;
									// now search for target attributes
									final LinkedList<EObjectTransformationHelper> targetInstances = targetSectionRegistry
											.getFlattenedPamtramClassInstances(matcher
													.getTargetAttribute()
													.getOwningClass());

									// instances are sorted in the same order as
									// hintValues
									final LinkedList<EObjectTransformationHelper> instancesToConsider = new LinkedList<>();
									instancesToConsider
									.addAll(instancesBySection
											.get(targetSectionClass));
									/*
									 * Sizes of instances and attributeHints
									 * must either match, or, in case there was
									 * a cardinality mapping, the size of the
									 * hintValues must be 1
									 */
									LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> newHintValues = 
											new LinkedList<>();
									if (hintValues.getHintValues((MappingInstanceSelector) h).size() == 1) {
										final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hintVal = hintValues.getHintValues((MappingInstanceSelector) h).getFirst();
										for (int i = 0; i < instancesToConsider.size(); i++) {
											newHintValues.add(hintVal);
										}
									} else if (instancesToConsider.size() == hintValues.getHintValues((MappingInstanceSelector) h).size()) {
										newHintValues = hintValues.getHintValues((MappingInstanceSelector) h);
										// newHintValues.addAll(hintValues.get(h));
									} else {
										consoleStream
										.println("There was a size mismatch while trying to set a non-containment reference, using the Hint "
												+ h.getName() + ". There where " + instancesToConsider.size() + " instances to be connected but "
												+ hintValues.getHintValues((MappingInstanceSelector) h).size() + " MappingHint values. The output below"
												+ " shows the hint values and the source instances for the reference:\n"
												+ hintValues.getHintValues((MappingInstanceSelector) h) + "\n" + instancesToConsider);
									}

									final int numberOfInstancesToCreate = newHintValues.size();
									for (int i=0; i<numberOfInstancesToCreate; i++) {
										String attrValStr = null;
										if (hSel.getMatcher() instanceof AttributeMatcher) {
											attrValStr = calculator.calculateAttributeValue(null, hSel,
													newHintValues);
										}
										final EObjectTransformationHelper srcInst = instancesToConsider
												.remove(0);
										final List<EObjectTransformationHelper> fittingVals = new LinkedList<EObjectTransformationHelper>();
										for (final EObjectTransformationHelper targetInst : targetInstances) {
											// get Attribute value
											final String targetValStr = targetInst
													.getAttributeValue(matcher
															.getTargetAttribute());
											if (targetValStr != null) {
												if (targetValStr
														.equals(attrValStr)) {
													fittingVals.add(targetInst);
												}
											} else {
												consoleStream
												.println("Problemo?");
											}
										}
										// select targetInst
										if (fittingVals.size() == 1) {
											addValueToReference(ref,
													fittingVals.get(0)
													.getEObject(),
													srcInst.getEObject());
										} else if (fittingVals.size() > 1) {// let
											// user
											// decide
											if (transformationAborted) {
												return;
											}
											final GenericItemSelectorDialogRunner<EObjectTransformationHelper> dialog = new GenericItemSelectorDialogRunner<EObjectTransformationHelper>(
													"The MappingInstanceSelector '"
															+ h.getName()
															+ " of Mapping"
															+ mappingName
															+ "(Group: "
															+ group.getName()
															+ ")' has a Matcher that points to a target element with more than one instance. "
															+ "Please choose to which element the Reference '"
															+ ref.getName()
															+ "' of the following element should point to:\n\n"
															+ srcInst
															.toString(),
															fittingVals, 0);
											Display.getDefault().syncExec(
													dialog);

											if (dialog
													.wasTransformationStopRequested()) {
												transformationAborted = true;
												return;
											}
											addValueToReference(ref, dialog
													.getSelection()
													.getEObject(),
													srcInst.getEObject());
										} else {
											consoleStream
											.println("The MappigInstanceSelector "
													+ hSel.getName()
													+ " (Mapping: "
													+ mappingName
													+ ", Group: "
													+ group.getName()
													+ " ) has an AttributeMatcher that picked up the value '"
													+ attrValStr
													+ "' to be matched to the "
													+ "TargetAttribute, but no fitting TargetSectionInstance with this value could be found.");

										}
									}

									/*
									 * Handle ClassMatcher
									 */
								} else if (hSel.getMatcher() instanceof ClassMatcher) {
									hintFound = true;
									if (((ClassMatcher) hSel.getMatcher())
											.getTargetClass() != null) {// was
										// the
										// matcher
										// modeled
										// correctly?
										if (refValueClone
												.contains(((ClassMatcher) hSel
														.getMatcher())
														.getTargetClass())) {
											// select any of the targetInstances
											// available for the reference
											// target
											final LinkedList<EObjectTransformationHelper> instancesToConsider = instancesBySection
													.get(targetSectionClass);

											final TargetSectionClass matcherTargetClass = ((ClassMatcher) hSel
													.getMatcher())
													.getTargetClass();

											/*
											 * select potential instances
											 * globally
											 */
											final LinkedList<EObjectTransformationHelper> insts = targetSectionRegistry
													.getFlattenedPamtramClassInstances(matcherTargetClass);

											EObjectTransformationHelper targetInstance = null;
											if (insts.size() == 1) {
												targetInstance = insts.get(0);
											} else if (insts.size() > 1) {
												// Dialog
												if (transformationAborted) {
													return;
												}
												final GenericItemSelectorDialogRunner<EObjectTransformationHelper> dialog = new GenericItemSelectorDialogRunner<EObjectTransformationHelper>(
														"The MappingInstanceSelector '"
																+ h.getName()
																+ " of Mapping"
																+ mappingName
																+ "(Group: "
																+ group.getName()
																+ ")' has a Matcher that points to a target element with more than one instance. "
																+ "Please choose to which element the Reference '"
																+ ref.getName()
																+ "' of the affected elements should point to.",
																insts, 0);
												Display.getDefault().syncExec(
														dialog);

												if (dialog
														.wasTransformationStopRequested()) {
													transformationAborted = true;
													return;
												}
												targetInstance = dialog
														.getSelection();
											} else {
												consoleStream
												.println("The MappingInstanceSelector '"
														+ h.getName()
														+ " of Mapping"
														+ mappingName
														+ "(Group: "
														+ group.getName()
														+ ")' has a Matcher that points to the target class "
														+ matcherTargetClass
														.getName()
														+ " (Section: "
														+ matcherTargetClass
														.getContainingSection()
														.getName()
														+ "). Sadly, no instances of this Class were created.");
											}

											if (targetInstance != null) {
												for (final EObjectTransformationHelper inst : instancesToConsider) {// same
													// action
													// for
													// every
													// instance
													// of
													// specific
													// mapping
													addValueToReference(
															ref,
															targetInstance
															.getEObject(),
															inst.getEObject());
												}
											}
										}
									}
								} else {
									consoleStream.println("Matcher of type "
											+ hSel.getMatcher().eClass()
											.getName()
											+ " in MappingHint "
											+ hSel.getName()
											+ " is not supported.");
								}
								if (hintFound) {
									break;
								}
							}
						}
					}

					/*
					 * In case no suitable hint could be found we will try the
					 * following:
					 * 
					 * 1.only non-cont ref targets to other subsections of this
					 * targetMMSection are considered, we can resolve the
					 * reference if only one Instance of the ref Target was
					 * created in the same mapping instance
					 * 
					 * if that isn't the case:
					 * 
					 * 2. consider all available instances of the ref target
					 */
					if (!hintFound) { // last chance
						final LinkedHashSet<TargetSectionClass> foundLocalNonContRefTargets = new LinkedHashSet<TargetSectionClass>();
						final LinkedList<TargetSectionClass> refValue = new LinkedList<TargetSectionClass>();
						refValue.addAll(ref.getValue());

						// first check root targetMMSection itself
						if (refValue.contains(groupTargetSection)) {
							foundLocalNonContRefTargets.add(groupTargetSection);
							refValue.remove(groupTargetSection);
						}

						// then check all its children
						final TreeIterator<EObject> it = groupTargetSection
								.eAllContents();
						while (it.hasNext() && refValue.size() > 0) {
							final EObject next = it.next();
							if (refValue.contains(next)) {// at least one of the
								/*
								 * values the pamtram-reference points to, is
								 * part of the same MappingHintGroup's
								 * targetMMSection
								 */
								foundLocalNonContRefTargets
								.add((TargetSectionClass) next);
								refValue.remove(next);
							}

						}
						/*
						 * only non-cont ref targets to other subsections of
						 * this targetMMSection are considered
						 */
						if (foundLocalNonContRefTargets.size() > 0) {
							// get source instances for the reference
							final LinkedList<EObjectTransformationHelper> sourceInstances = new LinkedList<EObjectTransformationHelper>();
							sourceInstances.addAll(instancesBySection
									.get(targetSectionClass));

							// get root instances of groups targetMMSection
							final LinkedList<EObjectTransformationHelper> rootInstances = instancesBySection
									.get(groupTargetSection);

							// get target instances for the reference
							final LinkedList<EObjectTransformationHelper> targetInstances = new LinkedList<EObjectTransformationHelper>();
							for (final TargetSectionClass section : foundLocalNonContRefTargets) {
								targetInstances.addAll(instancesBySection
										.get(section));
							}

							// now sort instances by root
							final LinkedHashMap<EObjectTransformationHelper, EObjectTransformationHelper> rootBySourceInstance = new LinkedHashMap<EObjectTransformationHelper, EObjectTransformationHelper>();
							final LinkedHashMap<EObjectTransformationHelper, LinkedList<EObjectTransformationHelper>> targetInstancesByRoot = new LinkedHashMap<EObjectTransformationHelper, LinkedList<EObjectTransformationHelper>>();

							for (final EObjectTransformationHelper root : rootInstances) {
								targetInstancesByRoot
								.put(root,
										new LinkedList<EObjectTransformationHelper>());

								// check if root node itself is a target
								for (final EObjectTransformationHelper t : targetInstances) {
									if (t.getEObject()
											.equals(root.getEObject())) {
										targetInstancesByRoot.get(root).add(
												root);
										targetInstances.remove(t);
										break;
									}
								}

								// check root node's contents
								final TreeIterator<EObject> it1 = root
										.getEObject().eAllContents();
								while (it1.hasNext()
										&& !(sourceInstances.size() == 0 && targetInstances
										.size() == 0)) {
									final EObject next = it1.next();

									boolean found = false;

									for (final EObjectTransformationHelper h : sourceInstances) {
										if (h.getEObject().equals(next)) {
											rootBySourceInstance.put(h, root);
											sourceInstances.remove(h);
											found = true;
											break;
										}
									}

									if (!found) {
										for (final EObjectTransformationHelper t : targetInstances) {
											if (t.getEObject().equals(next)) {
												targetInstancesByRoot.get(root)
												.add(t);
												targetInstances.remove(t);
												break;
											}
										}

									}
								}
							}
							// now select targetInstance for each source
							// instance
							for (final EObjectTransformationHelper source : rootBySourceInstance
									.keySet()) {
								final List<EObjectTransformationHelper> instances = targetInstancesByRoot
										.get(rootBySourceInstance.get(source));
								if (instances.size() == 1) {
									addValueToReference(ref, instances.get(0)
											.getEObject(), source.getEObject());
								} else if (instances.size() > 1) {
									// Dialog
									if (transformationAborted) {
										return;
									}
									final GenericItemSelectorDialogRunner<EObjectTransformationHelper> dialog = new GenericItemSelectorDialogRunner<EObjectTransformationHelper>(
											"There was more than one target element found for the NonContainmmentReference '"
													+ ref.getName()
													+ "' of TargetMMSection "
													+ groupTargetSection.getName()
													+ "(Section: "
													+ targetSectionClass.getName()
													+ ") in Mapping "
													+ mappingName
													+ "(Group: "
													+ group.getName()
													+ ") ."
													+ "Please select a target element for the following source:\n"
													+ source.toString(),
													instances, 0);
									Display.getDefault().syncExec(dialog);

									if (dialog.wasTransformationStopRequested()) {
										transformationAborted = true;
										return;
									}
									addValueToReference(ref, dialog
											.getSelection().getEObject(),
											source.getEObject());

								} else {
									consoleStream
									.println("No suitable refernce target found for non-cont. reference '"
											+ ref.getName()
											+ "' of the following instance of target class "
											+ targetSectionClass
											.getName()
											+ " (Section: "
											+ targetSectionClass
											.getContainingSection()
											.getName()
											+ ").'\n"
											+ source.toString());
								}

							}
							/*
							 * consider all available instances of the ref
							 * target
							 */
						} else {
							final LinkedHashMap<String, EObjectTransformationHelper> targetInstancesToConsider = new LinkedHashMap<String, EObjectTransformationHelper>();
							final LinkedList<String> targetSectionChoices = new LinkedList<String>();
							final LinkedList<List<String>> instanceChoices = new LinkedList<List<String>>();

							for (final TargetSectionClass v : refValueClone) {
								final String classString = v.getName()
										+ " (Section: "
										+ v.getContainingSection().getName()
										+ ")";
								final LinkedList<EObjectTransformationHelper> insts = targetSectionRegistry
										.getFlattenedPamtramClassInstances(v);

								if (insts.size() > 0) {
									targetSectionChoices.add(classString);
									final LinkedList<String> choices = new LinkedList<String>();
									for (final EObjectTransformationHelper i : insts) {
										final String description = i.toString();
										targetInstancesToConsider.put(
												description, i);
										choices.add(description);
									}
									instanceChoices.add(choices);
								}
							}

							EObjectTransformationHelper targetInstance = null;
							if (targetInstancesToConsider.values().size() == 1) {
								targetInstance = targetInstancesToConsider
										.values().iterator().next();
							} else if (targetInstancesToConsider.values()
									.size() > 1) {
								// Dialog
								if (transformationAborted) {
									return;
								}
								final PathAndInstanceSelectorRunner dialog = new PathAndInstanceSelectorRunner(
										"There was more than one target element found for the NonContainmmentReference '"
												+ ref.getName()
												+ "' of TargetMMSection "
												+ groupTargetSection.getName()
												+ "(Section: "
												+ targetSectionClass.getName()
												+ ") in Mapping "
												+ mappingName
												+ "(Group: "
												+ group.getName()
												+ ") ."
												+ "Please select a target Class and element.",
												targetSectionChoices, instanceChoices);
								Display.getDefault().syncExec(dialog);

								if (dialog.wasTransformationStopRequested()) {
									transformationAborted = true;
									return;
								}
								targetInstance = targetInstancesToConsider
										.get(dialog.getInstance());
							} else {
								consoleStream
								.println("No suitable hint targets found for non-cont reference '"
										+ ref.getName()
										+ "' of TargetMMSection "
										+ groupTargetSection.getName()
										+ "(Section: "
										+ targetSectionClass.getName()
										+ ") in Mapping "
										+ mappingName
										+ "(Group: "
										+ group.getName()
										+ ").");
							}

							if (targetInstance != null) {
								for (final EObjectTransformationHelper inst : instancesBySection
										.get(targetSectionClass)) {
									addValueToReference(ref,
											targetInstance.getEObject(),
											inst.getEObject());
								}
							}

						}

					}
				}
			}
			instantiateTargetSectionSecondPassGoDeeper(targetSectionClass,
					mappingName, group, groupTargetSection, hints, hintValues,
					instancesBySection);
		}
	}

	/**
	 * @param targetSectionClass
	 * @param mappingName
	 * @param group
	 * @param groupTargetSection
	 * @param hints
	 * @param hintValues
	 * @param instancesBySection
	 */
	private void instantiateTargetSectionSecondPassGoDeeper(
			final TargetSectionClass targetSectionClass,
			final String mappingName,
			final InstantiableMappingHintGroup group,
			final TargetSectionClass groupTargetSection,
			final List<MappingHint> hints,
			final HintValueStorage hintValues,
			final LinkedHashMap<TargetSectionClass, LinkedList<EObjectTransformationHelper>> instancesBySection) {

		for (final TargetSectionReference ref : targetSectionClass
				.getReferences()) {
			if (ref instanceof TargetSectionContainmentReference) {
				for (final TargetSectionClass val : ((TargetSectionContainmentReference) ref)
						.getValue()) {// instantiate targets
					instantiateTargetSectionSecondPass(val, mappingName, group,
							groupTargetSection, hints, hintValues,
							instancesBySection);
					if (transformationAborted) {
						return;
					}
				}
			}

		}
	}

	/**
	 * Instantiate all library entry-based target sections that have been collected
	 * during {@link #instantiateTargetSectionFirstPass}.
	 * 
	 * @param targetModel The coherent target model into that the library entries are to be
	 * 			instantiated.
	 * @param targetLibraryContextDescriptor
	 * 			  The descriptor for the target library context to be used during the transformation.
	 * @return <em>true</em> if everything went well, <em>false</em> otherwise.
	 */
	boolean instantiateLibraryEntries(
			EObject targetModel, LibraryContextDescriptor targetLibraryContextDescriptor) {

		if(libEntryInstantiators.isEmpty()) { // nothing to be done
			return true;
		}

		if(targetLibraryContextDescriptor.getLibraryContextClass() == null) {
			consoleStream.println("Could not instantiate library entries as no target"
					+ " library context class has been specified!");
			return false;
		}

		/*
		 * Create a GenLibraryManager that proxies calls to the LibraryPlugin. 
		 */
		GenLibraryManager manager;
		try {
			manager = new GenLibraryManager(
					targetLibraryContextDescriptor);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			consoleStream.println("Error while instantiatiating library context/parser!");
			return false;
		}

		boolean successful = true;
		/*
		 * Iterate over all stored instantiators and instantiate the associated library entry
		 * in the given target model.
		 */
		for (LibraryEntryInstantiator libraryEntryInstantiator : libEntryInstantiators) {
			if(!libraryEntryInstantiator.instantiate(
					manager, targetModel, calculator, 
					transformationRunner.getTargetSectionConnector(),
					targetSectionRegistry)) {
				consoleStream.println("Failed to instantiate library entry '" + 
						libraryEntryInstantiator.getLibraryEntry().getPath() + "'!");
				successful = false;
			}
		}
		return successful;

	}

	/**
	 * @return true if transformation was aborted
	 */
	@Override
	public boolean isCancelled() {
		return transformationAborted;
	}

}
