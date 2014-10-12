package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
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
import pamtram.mapping.AttributeMappingSourceElementType;
import pamtram.mapping.CalculatorMapping;
import pamtram.mapping.CalculatorMappingSourceInterface;
import pamtram.mapping.CardinalityMapping;
import pamtram.mapping.ComplexAttributeMapping;
import pamtram.mapping.ComplexAttributeMappingSourceElement;
import pamtram.mapping.ComplexAttributeMappingSourceInterface;
import pamtram.mapping.ComplexAttributeMatcher;
import pamtram.mapping.ComplexAttributeMatcherSourceElement;
import pamtram.mapping.ComplexAttributeMatcherSourceInterface;
import pamtram.mapping.ComplexMappingHintSourceInterface;
import pamtram.mapping.ComplexModelConnectionHint;
import pamtram.mapping.ComplexModelConnectionHintSourceElement;
import pamtram.mapping.ComplexModelConnectionHintSourceInterface;
import pamtram.mapping.ExpressionVariable;
import pamtram.mapping.ExternalAttributeMappingSourceElement;
import pamtram.mapping.ExternalMappedAttributeValueExpander;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.MappedAttributeValueExpander;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.mapping.ModelConnectionHint;
import pamtram.mapping.SimpleAttributeMapping;
import pamtram.mapping.SimpleAttributeMatcher;
import pamtram.mapping.SimpleModelConnectionHint;
import pamtram.metamodel.AttributeValueConstraint;
import pamtram.metamodel.AttributeValueConstraintType;
import pamtram.metamodel.CardinalityType;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.SourceSectionReference;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.mfreund.gentrans.transformation.selectors.NamedElementItemSelectorDialogRunner;

/**
 * Class to map source model Objects to source sections and find values for
 * mapping hints.
 *
 * @author Sascha Steffen
 * @version 1.0
 */
class SourceSectionMapper implements CancellationListener {

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

	/**
	 * Registry for source model objects already mapped
	 */
	private final LinkedHashMap<SourceSectionClass, Set<EObject>> mappedSections;

	/**
	 * Registry for src model objects that were "not officially" mapped but
	 * included through a container mapping
	 */
	private final LinkedHashMap<SourceSectionClass, Set<EObject>> mappedContainers;
	/**
	 * Registry for ModelConnectionHints. Used When linking target model
	 * sections.
	 */
	private final Map<Mapping, LinkedList<ModelConnectionHint>> modelConnectionHints;
	/**
	 * Registry for MappingHints.
	 */
	private final Map<Mapping, LinkedList<MappingHintType>> mappingHints;

	/**
	 * Map Referencing the Classes referenced by the
	 * ComplexAttributeMappingSourceElement that are buried deepest in the
	 * source Section, sorted by ComplexAttributeMapping.
	 */
	private final Map<ComplexAttributeMapping, Set<SourceSectionClass>> deepestComplexAttrMappingSrcElementsByCmplxMapping;

	/**
	 * We save any user selection for a particular set of possible Mappings so
	 * we don't have to ask twice for the same combination of Mappings.
	 */
	private final Map<Set<Mapping>, Mapping> ambiguousMappingSelections;
	/**
	 * Map to determine at which point ComplexHints need to be joined
	 */
	private final Map<Object, SourceSectionClass> commonContainerClassOfComplexMappings;
	/**
	 * Map Referencing the Classes referenced by the ExpressionVariable that is
	 * buried deepest in the source Section, sorted by CalculatorMapping.
	 */
	private final Map<CalculatorMapping, Set<SourceSectionClass>> deepestCalcAttrMappingSrcElementsByCalcMapping;

	/**
	 * Map Referencing the Classes referenced by the
	 * ComplexAttributeMatcherSourceElement that are buried deepest in the
	 * source Section, sorted by ComplexAttributeMatcher.
	 */
	private final Map<ComplexAttributeMatcher, Set<SourceSectionClass>> deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher;
	/**
	 * Map Referencing the Classes referenced by the
	 * ComplexModelConnectionHintSourceElement that are buried deepest in the
	 * source Section, sorted by ComplexAttributeMatcher.
	 */
	private final Map<ComplexModelConnectionHint, Set<SourceSectionClass>> deepestComplexConnectionHintSrcElementsByComplexConnectionHint;
	/**
	 * Mappings from the PAMTram model
	 */
	private final List<Mapping> mappingsToChooseFrom;
	/**
	 * Output stream for messages
	 */
	private final MessageConsoleStream consoleStream;

	/**
	 * true when user action was triggered to abort the transformation
	 */
	private boolean transformationAborted;

	/**
	 * Registry for values of global Variables Only the newest value found is
	 * saved (GlobalVariables really only make sense for elements that appear
	 * only once)
	 */
	private final Map<GlobalAttribute, String> globalVarValues;

	/**
	 * used for modifying attribute values
	 */
	private final AttributeValueModifierExecutor attributeValuemodifier;

	/**
	 * Set that contains all ValueModifiers with errors so we don't need to send
	 * a potential error message twice
	 */
	private final Set<AttributeValueConstraint> constraintsWithErrors;

	/**
	 * @param mappingsToChooseFrom
	 *            Mappings from the PAMTram model
	 * @param consoleStream
	 *            Output stream for messages
	 */
	SourceSectionMapper(final List<Mapping> mappingsToChooseFrom,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final MessageConsoleStream consoleStream) {
		mappedSections = new LinkedHashMap<SourceSectionClass, Set<EObject>>();
		mappedContainers = new LinkedHashMap<SourceSectionClass, Set<EObject>>();
		mappingHints = new LinkedHashMap<Mapping, LinkedList<MappingHintType>>();
		modelConnectionHints = new LinkedHashMap<Mapping, LinkedList<ModelConnectionHint>>();
		deepestComplexAttrMappingSrcElementsByCmplxMapping = new LinkedHashMap<ComplexAttributeMapping, Set<SourceSectionClass>>();
		deepestCalcAttrMappingSrcElementsByCalcMapping = new LinkedHashMap<CalculatorMapping, Set<SourceSectionClass>>();
		deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher = new LinkedHashMap<ComplexAttributeMatcher, Set<SourceSectionClass>>();
		deepestComplexConnectionHintSrcElementsByComplexConnectionHint = new LinkedHashMap<ComplexModelConnectionHint, Set<SourceSectionClass>>();
		globalVarValues = new HashMap<GlobalAttribute, String>();
		this.mappingsToChooseFrom = mappingsToChooseFrom;
		this.consoleStream = consoleStream;
		transformationAborted = false;
		this.attributeValuemodifier = attributeValuemodifier;
		constraintsWithErrors = new HashSet<AttributeValueConstraint>();
		commonContainerClassOfComplexMappings = new HashMap<Object, SourceSectionClass>();
		ambiguousMappingSelections = new HashMap<Set<Mapping>, Mapping>();

		// this will fill some maps...
		for (final Mapping m : mappingsToChooseFrom) {
			getModelConnectionHints(m);
			for (final MappingHintType h : getHints(m)) {
				if (h instanceof ComplexAttributeMapping) {
					buildDeepestCmplxAttrMappingElementsMap(
							(ComplexAttributeMapping) h, m.getSourceMMSection());
				} else if (h instanceof CalculatorMapping) {
					buildCalcAttrMappingsMaps((CalculatorMapping) h,
							m.getSourceMMSection());
				} else if (h instanceof MappingInstanceSelector) {
					if (((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher) {
						buildDeepestComplexAttrMatcherSrcElements(
								(ComplexAttributeMatcher) ((MappingInstanceSelector) h)
										.getMatcher(), m.getSourceMMSection());
					}
				}
			}

			for (final ModelConnectionHint h : getModelConnectionHints(m)) {
				if (h instanceof ComplexModelConnectionHint) {
					buildDeepestCmplxConnectionHintElementsMap(
							(ComplexModelConnectionHint) h,
							m.getSourceMMSection());
				}
			}
		}
	}

	/**
	 * Extend the deepestCalcAttrMappingSrcElementsByCalcMapping Map for the
	 * MappingHint
	 *
	 * @param m
	 * @param srcSection
	 */
	private void buildCalcAttrMappingsMaps(final CalculatorMapping m,
			final SourceSectionClass srcSection) {
		if (!deepestCalcAttrMappingSrcElementsByCalcMapping.containsKey(m)) {
			final Set<AttributeMappingSourceElementType> srcElements = new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestCalcAttrMappingSrcElementsByCalcMapping.put(m,
					new HashSet<SourceSectionClass>());

			deepestCalcAttrMappingSrcElementsByCalcMapping.get(m).addAll(
					findDeepestClassesAndCommonContainer(srcElements,
							srcSection, m));
		}
	}

	/**
	 * @param EObject
	 *            from srcModel
	 * @return list of the srcModels elements in hierarchical order
	 */
	List<EObject> buildContainmentTree(final EObject object) {

		final List<EObject> list = new LinkedList<EObject>();
		return buildContainmentTree(object, list);
	}

	/**
	 * @param EObject
	 *            from srcModel
	 * @param list
	 *            to expand
	 * @return list of the srcModels elements in hierarchical order
	 */
	@SuppressWarnings("unchecked")
	private List<EObject> buildContainmentTree(final EObject object,
			final List<EObject> list) {
		if (transformationAborted)
			return list;

		list.add(object);

		for (final EReference feature : object.eClass().getEAllContainments()) {
			final Object childElements = object.eGet(feature);
			if (childElements != null) {
				if (childElements instanceof Iterable) {
					for (final EObject child : (Iterable<EObject>) childElements) {
						buildContainmentTree(child, list);
					}

				} else {
					buildContainmentTree((EObject) childElements, list);
				}
			}
		}

		return list;
	}

	/**
	 * Extend the deepestComplexAttrMappingSrcElementsByCmplxMapping Map for the
	 * MappingHint
	 *
	 * @param m
	 *            MApping
	 * @param srcSection
	 */
	private void buildDeepestCmplxAttrMappingElementsMap(
			final ComplexAttributeMapping m, final SourceSectionClass srcSection) {
		if (!deepestComplexAttrMappingSrcElementsByCmplxMapping.containsKey(m)) {
			final Set<AttributeMappingSourceElementType> srcElements = new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestComplexAttrMappingSrcElementsByCmplxMapping.put(m,
					new HashSet<SourceSectionClass>());

			deepestComplexAttrMappingSrcElementsByCmplxMapping.get(m).addAll(
					findDeepestClassesAndCommonContainer(srcElements,
							srcSection, m));

		}
	}

	/**
	 * Extend the deepestComplexConnectionHintSrcElementsByComplexConnectionHint
	 * ModelConnectionHint
	 *
	 * @param m
	 * @param srcSection
	 */
	private void buildDeepestCmplxConnectionHintElementsMap(
			final ComplexModelConnectionHint m,
			final SourceSectionClass srcSection) {
		if (!deepestComplexConnectionHintSrcElementsByComplexConnectionHint
				.containsKey(m)) {
			final Set<AttributeMappingSourceElementType> srcElements = new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestComplexConnectionHintSrcElementsByComplexConnectionHint.put(
					m, new HashSet<SourceSectionClass>());

			deepestComplexConnectionHintSrcElementsByComplexConnectionHint.get(
					m).addAll(
					findDeepestClassesAndCommonContainer(srcElements,
							srcSection, m));

		}
	}

	/**
	 * Extend the deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher
	 * MappingHint
	 *
	 * @param m
	 * @param srcSection
	 */
	private void buildDeepestComplexAttrMatcherSrcElements(
			final ComplexAttributeMatcher m, final SourceSectionClass srcSection) {
		if (!deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher
				.containsKey(m)) {
			final Set<AttributeMappingSourceElementType> srcElements = new HashSet<AttributeMappingSourceElementType>();
			srcElements.addAll(m.getLocalSourceElements());
			deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher.put(m,
					new HashSet<SourceSectionClass>());

			final MappingInstanceSelector s = (MappingInstanceSelector) m
					.eContainer();
			deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher.get(m)
					.addAll(findDeepestClassesAndCommonContainer(srcElements,
							srcSection, s));

		}
	}

	@Override
	public void cancel() {
		transformationAborted = true;

	}

	/**
	 * Helper method to handle an ExternalAttributeMapping
	 *
	 * @param m
	 * @param res
	 * @param mappingFailed
	 * @param attrVals
	 * @param i
	 * @return
	 */
	private boolean checkExternalAttributeMapping(final Mapping m,
			final MappingInstanceStorage res, boolean mappingFailed,
			final Map<ExternalAttributeMappingSourceElement, String> attrVals,
			final ComplexMappingHintSourceInterface i) {
		if (i instanceof ExternalAttributeMappingSourceElement) {
			String attrVal = getContainerAttributeValue(i.getSourceAttribute(),
					m.getSourceMMSection().getContainer(), res
							.getAssociatedSourceModelElement().eContainer());
			if (attrVal == null) {
				mappingFailed = true;
			} else {
				attrVal = attributeValuemodifier.applyAttributeValueModifiers(
						attrVal, ((ExternalAttributeMappingSourceElement) i)
								.getModifier());
				attrVals.put((ExternalAttributeMappingSourceElement) i, attrVal);
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
			if (mappedSections.containsKey(extClass)) {
				if (mappedSections.get(extClass).contains(extObj)) {
					return true;
				}
			} else if (mappedContainers.containsKey(extClass)) {
				if (mappedContainers.get(extClass).contains(extObj)) {
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
	private boolean doContainerCheck(final EObject element,
			final SourceSectionClass sourceSectionClass) {
		if (sourceSectionClass.getContainer() == null) {
			// this part is easy
			return true;
		} else {
			/*
			 * Step 1: identify all containers the corresponding elements
			 */
			final List<SourceSectionClass> containerClasses = new LinkedList<SourceSectionClass>();
			final List<EObject> containerElements = new LinkedList<EObject>();

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
					final MappingInstanceStorage res = findMapping(
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
							if (!mappedContainers.containsKey(c)) {
								mappedContainers.put(c,
										new LinkedHashSet<EObject>());
							}
							mappedContainers.get(c).addAll(
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
	 * Helper Method used when building the deepestElements Maps
	 *
	 * @param s
	 * @param srcSection
	 * @param hint
	 * @return Classes that contain the deepest SourceSectionAttributes
	 */
	private Set<SourceSectionClass> findDeepestClassesAndCommonContainer(
			final Set<AttributeMappingSourceElementType> s,
			final SourceSectionClass srcSection, final Object hint) {
		final Set<SourceSectionClass> resultSet = new HashSet<SourceSectionClass>();

		/*
		 * fill resultSet with all *potential* candidates
		 */
		for (final AttributeMappingSourceElementType t : s) {
			resultSet.add(t.getSource().getOwningClass());
		}

		/*
		 * Find deeppest Elements
		 */
		Map<SourceSectionClass, Set<SourceSectionClass>> resultSets = new HashMap<SourceSectionClass, Set<SourceSectionClass>>();
		boolean commonContainerFound = false;
		/*
		 * init classesToCheck
		 */
		if (resultSet.size() == 1) {
			return resultSet;
		} else {
			if (resultSet.contains(srcSection)) {
				resultSet.remove(srcSection);
				commonContainerClassOfComplexMappings.put(hint, srcSection);
				commonContainerFound = true;
			}
			resultSets.put(srcSection, new HashSet<SourceSectionClass>(
					resultSet));
		}

		/*
		 * Find deepest elements
		 */
		while (resultSets.size() > 0) {
			final Map<SourceSectionClass, Set<SourceSectionClass>> nextResultSets = new HashMap<SourceSectionClass, Set<SourceSectionClass>>();
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
						final Set<SourceSectionClass> childrenChecked = new HashSet<SourceSectionClass>();// to
						// prevent
						// endless
						// loops
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
								commonContainerClassOfComplexMappings.put(hint,
										cl);
								commonContainerFound = true;
							}
							nextResultSets.get(childClass).retainAll(
									resultSets.get(cl));// remove all non-result
							// classes
							// (intersection)
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
	 * Method for finding a suitable Mapping for a srcModelObject
	 *
	 * @param srcModelObject
	 *            Element of the srcModel to be transformed
	 * @param usedOkay
	 *            specify whether elements already contained in newRefsAndHints
	 *            can be mapped (needed for non-cont refs)
	 * @param hints
	 * @param connectionHints
	 * @param srcSection
	 * @param newRefsAndHints
	 * @param srcInstanceMap
	 */
	private MappingInstanceStorage findMapping(final EObject srcModelObject,
			final boolean usedOkay, final Iterable<MappingHintType> hints,
			final Iterable<ModelConnectionHint> connectionHints,
			final Iterable<GlobalAttribute> globalVars,
			final SourceSectionClass srcSection,
			final MappingInstanceStorage newRefsAndHints) {

		final boolean classFits = srcSection.getEClass().isSuperTypeOf(
				srcModelObject.eClass());

		// first of all: check if usedRefs contains this item and if type fits
		// (we do not check any of the used elements of other mappings, since
		// WILL be in a different section of the containment tree )
		if (!usedOkay
				&& newRefsAndHints
						.containsSourceModelObjectMapped(srcModelObject)
				|| !classFits) {
			return null;
		}
		// we will return this in Case we find the mapping to be applicable
		// else we return null
		final MappingInstanceStorage changedRefsAndHints = new MappingInstanceStorage();
		changedRefsAndHints.setAssociatedSourceElement(srcSection,
				srcModelObject);

		final Map<ComplexAttributeMappingSourceElement, String> complexSourceElementHintValues = new LinkedHashMap<ComplexAttributeMappingSourceElement, String>();
		final Map<ExpressionVariable, String> calcVariableHintValues = new LinkedHashMap<ExpressionVariable, String>();
		final Map<ComplexAttributeMatcherSourceElement, String> complexAttrMatcherSourceElementHintValues = new LinkedHashMap<ComplexAttributeMatcherSourceElement, String>();
		final Map<ComplexModelConnectionHintSourceElement, String> complexConnectionHintSourceElementHintValues = new LinkedHashMap<ComplexModelConnectionHintSourceElement, String>();

		// init hintValues
		for (final MappingHintType hint : hints) {
			changedRefsAndHints
					.setHintValueList(hint, new LinkedList<Object>());
			if (hint instanceof ComplexAttributeMapping
					|| hint instanceof CalculatorMapping) {// ComplexAttributeMappings
				// are handled
				// differently
				// because we want
				// to make them work
				// across
				// vc-sections
				if (newRefsAndHints.getHintValues().containsKey(hint)) {
					changedRefsAndHints.getHintValues().get(hint)
							.addAll(newRefsAndHints.getHintValues().get(hint));// the
					// cardinality
					// of
					// the
					// existing
					// hintval
					// is
					// either
					// 0
					// or
					// 1
					// at
					// this
					// point
				} else if (hint instanceof ComplexAttributeMapping) {
					changedRefsAndHints
							.getHintValues()
							.get(hint)
							.add(new LinkedHashMap<ComplexAttributeMappingSourceInterface, String>());
				} else {
					changedRefsAndHints.getHintValues().get(hint)
							.add(new LinkedHashMap<String, Double>());
				}
			} else if (hint instanceof MappingInstanceSelector) {
				if (((MappingInstanceSelector) hint).getMatcher() instanceof ComplexAttributeMatcher) {
					if (newRefsAndHints.getHintValues().containsKey(hint)) {
						changedRefsAndHints
								.getHintValues()
								.get(hint)
								.addAll(newRefsAndHints.getHintValues().get(
										hint));// the cardinality of
						// the existing hintval is
						// either 0 or 1 at this point
					} else {
						changedRefsAndHints
								.getHintValues()
								.get(hint)
								.add(new LinkedHashMap<ComplexAttributeMatcherSourceInterface, String>());
					}
				}
			}

		}

		for (final ModelConnectionHint hint : connectionHints) {
			changedRefsAndHints.setConnectionHintValueList(hint,
					new LinkedList<Object>());
			if (hint instanceof ComplexModelConnectionHint) {
				if (newRefsAndHints.getModelConnectionHintValues().containsKey(
						hint)) {
					changedRefsAndHints
							.getModelConnectionHintValues()
							.get(hint)
							.addAll(newRefsAndHints
									.getModelConnectionHintValues().get(hint));
				} else {
					changedRefsAndHints
							.getModelConnectionHintValues()
							.get(hint)
							.add(new LinkedHashMap<ComplexModelConnectionHintSourceInterface, String>());
				}
			}
		}

		// set refs
		changedRefsAndHints.addSourceModelObjectsMapped(newRefsAndHints
				.getSourceModelObjectsMapped());

		// add self to new Refs
		changedRefsAndHints.addSourceModelObjectMapped(srcModelObject,
				srcSection);

		// check attributes
		for (final SourceSectionAttribute at : srcSection.getAttributes()) {// look
			// for
			// attributes
			// in
			// srcSection
			// does it exist in src model?
			final Object srcAttr = srcModelObject.eGet(at.getAttribute());
			if (srcAttr != null) {
				// convert Attribute value to String
				final String srcAttrAsString = at
						.getAttribute()
						.getEType()
						.getEPackage()
						.getEFactoryInstance()
						.convertToString(at.getAttribute().getEAttributeType(),
								srcAttr);
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
						consoleStream
								.println("The AttributeValueConstraint '"
										+ constraint.getName()
										+ "' of the "
										+ "Attribute '"
										+ at.getName()
										+ " (Class: "
										+ at.getOwningClass().getName()
										+ ", Section: "
										+ at.getContainingSection().getName()
										+ ")"
										+ "' could not be evaluated and will be ignored. The following error was supplied:\n"
										+ e.getLocalizedMessage());
						continue;
					}
					if (!constraintVal
							&& constraint.getType().equals(
									AttributeValueConstraintType.EXCLUSION)) {
						return null;
					} else if (constraint.getType().equals(
							AttributeValueConstraintType.INCLUSION)) {
						containsInclusions = true;
						if (constraintVal) {
							inclusionMatched = true;
						}
					}
				}

				if (!inclusionMatched && containsInclusions) {
					return null;
				}

				// handle possible attribute mappings
				for (final MappingHintType hint : hints) {
					if (hint instanceof SimpleAttributeMapping) {
						if (((SimpleAttributeMapping) hint).getSource().equals(
								at)) {
							final String valCopy = attributeValuemodifier
									.applyAttributeValueModifiers(
											srcAttrAsString,
											((SimpleAttributeMapping) hint)
													.getModifier());
							changedRefsAndHints.addHintValue(hint, valCopy);
						}
					} else if (hint instanceof MappedAttributeValueExpander) {
						if (((MappedAttributeValueExpander) hint)
								.getSourceAttribute().equals(at)) {
							final String valCopy = attributeValuemodifier
									.applyAttributeValueModifiers(
											srcAttrAsString,
											((MappedAttributeValueExpander) hint)
													.getModifiers());
							changedRefsAndHints.addHintValue(hint, valCopy);
						}

					} else if (hint instanceof ComplexAttributeMapping) {
						for (final ComplexAttributeMappingSourceElement m : ((ComplexAttributeMapping) hint)
								.getLocalSourceElements()) {
							if (m.getSource().equals(at)) {
								final String valCopy = attributeValuemodifier
										.applyAttributeValueModifiers(
												srcAttrAsString,
												m.getModifier());
								complexSourceElementHintValues.put(m, valCopy);
							}
						}
					} else if (hint instanceof CalculatorMapping) {
						for (final ExpressionVariable v : ((CalculatorMapping) hint)
								.getLocalSourceElements()) {
							if (v.getSource().equals(at)) {
								final String valCopy = attributeValuemodifier
										.applyAttributeValueModifiers(
												srcAttrAsString,
												v.getModifier());
								calcVariableHintValues.put(v, valCopy);

							}
						}
					} else if (hint instanceof MappingInstanceSelector) {// handle
						// MappingInstanceSelector
						// with
						// AttributeMatcher
						if (((MappingInstanceSelector) hint).getMatcher() instanceof SimpleAttributeMatcher) {
							// handle attribute modifiers
							final SimpleAttributeMatcher matcher = (SimpleAttributeMatcher) ((MappingInstanceSelector) hint)
									.getMatcher();
							if (matcher.getSource().equals(at)) {
								String valCopy = srcAttrAsString;
								valCopy = attributeValuemodifier
										.applyAttributeValueModifiers(valCopy,
												matcher.getModifier());
								changedRefsAndHints.addHintValue(hint, valCopy);
							}
						} else if (((MappingInstanceSelector) hint)
								.getMatcher() instanceof ComplexAttributeMatcher) {

							final ComplexAttributeMatcher matcher = (ComplexAttributeMatcher) ((MappingInstanceSelector) hint)
									.getMatcher();
							for (final ComplexAttributeMatcherSourceElement e : matcher
									.getLocalSourceElements()) {
								if (e.getSource().equals(at)) {
									String valCopy = srcAttrAsString;
									valCopy = attributeValuemodifier
											.applyAttributeValueModifiers(
													valCopy, e.getModifier());
									complexAttrMatcherSourceElementHintValues
											.put(e, valCopy);
								}
							}
						}
					}
				}

				// ModelConnectionHint (is being handled in the same way as
				// MI-Selector with AttrMatcher)
				for (final ModelConnectionHint hint : connectionHints) {
					if (hint instanceof SimpleModelConnectionHint) {
						if (((SimpleModelConnectionHint) hint).getSource()
								.equals(at)) {
							final String modifiedVal = attributeValuemodifier
									.applyAttributeValueModifiers(
											srcAttrAsString,
											((SimpleModelConnectionHint) hint)
													.getModifier());
							changedRefsAndHints.addModelConnectionHintValue(
									hint, modifiedVal);

						}
					} else if (hint instanceof ComplexModelConnectionHint) {
						for (final ComplexModelConnectionHintSourceElement m : ((ComplexModelConnectionHint) hint)
								.getLocalSourceElements()) {
							if (m.getSource().equals(at)) {
								final String modifiedVal = attributeValuemodifier
										.applyAttributeValueModifiers(
												srcAttrAsString,
												m.getModifier());
								complexConnectionHintSourceElementHintValues
										.put(m, modifiedVal);
							}
						}
					}
				}

				for (final GlobalAttribute gVar : globalVars) {
					if (gVar.getSource().equals(at)) {
						final String modifiedVal = attributeValuemodifier
								.applyAttributeValueModifiers(srcAttrAsString,
										gVar.getModifier());
						globalVarValues.put(gVar, modifiedVal);
					}
				}

			} else {// attribute not set / null
				// return null;
				// Not a problem unless any mappings point here or Constraints
				// were modelled.
				// Unset mapping hint values are handled elsewhere.
				// Here we only need to check for matchers
				if (at.getValueConstraint().size() > 0) {
					return null;
				}
			}
		}

		// now work on ComplexAttributeMappings and CalcMappings
		final Set<ComplexAttributeMapping> complexAttributeMappingsFound = new HashSet<ComplexAttributeMapping>();
		final Set<ComplexAttributeMatcher> complexAttributeMatchersFound = new HashSet<ComplexAttributeMatcher>();
		final Set<CalculatorMapping> calculatorMappingsFound = new HashSet<CalculatorMapping>();
		final Set<ComplexModelConnectionHint> complexConnectionHintsFound = new HashSet<ComplexModelConnectionHint>();

		for (final MappingHintType h : hints) {
			if (h instanceof ComplexAttributeMapping) {
				final Map<ComplexAttributeMappingSourceInterface, String> foundValues = new LinkedHashMap<ComplexAttributeMappingSourceInterface, String>();
				// append the complex hint value (cardinality either 0 or 1)
				// with found values in right order
				for (final ComplexAttributeMappingSourceElement s : ((ComplexAttributeMapping) h)
						.getLocalSourceElements()) {
					if (complexSourceElementHintValues.containsKey(s)) {
						foundValues.put(s,
								complexSourceElementHintValues.get(s));
					}
				}

				if (foundValues.keySet().size() > 0) {
					complexAttributeMappingsFound
							.add((ComplexAttributeMapping) h);
					@SuppressWarnings("unchecked")
					final Map<ComplexAttributeMappingSourceInterface, String> oldValues = (Map<ComplexAttributeMappingSourceInterface, String>) changedRefsAndHints
							.getHintValues().get(h).remove();
					foundValues.putAll(oldValues);
					changedRefsAndHints.getHintValues().get(h).add(foundValues);
				}
			} else if (h instanceof MappingInstanceSelector) {
				if (((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher) {
					final ComplexAttributeMatcher m = (ComplexAttributeMatcher) ((MappingInstanceSelector) h)
							.getMatcher();
					final Map<ComplexAttributeMatcherSourceInterface, String> foundValues = new LinkedHashMap<ComplexAttributeMatcherSourceInterface, String>();
					// append the complex hint value (cardinality either 0 or 1)
					// with found values in right order
					for (final ComplexAttributeMatcherSourceElement s : m
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
						@SuppressWarnings("unchecked")
						final Map<ComplexAttributeMatcherSourceInterface, String> oldValues = (Map<ComplexAttributeMatcherSourceInterface, String>) changedRefsAndHints
								.getHintValues().get(h).remove();
						foundValues.putAll(oldValues);
						changedRefsAndHints.getHintValues().get(h)
								.add(foundValues);
					}
				}
			} else if (h instanceof CalculatorMapping) {
				/*
				 * we need this as an extra , since found values might be empty
				 * strings
				 */
				final Map<String, Double> foundValues = new LinkedHashMap<String, Double>();
				// append the complex hint value (cardinality either 0 or 1)
				// with found values in right order
				for (final ExpressionVariable v : ((CalculatorMapping) h)
						.getLocalSourceElements()) {
					if (calcVariableHintValues.containsKey(v)) {
						try {
							final Calculable calc = new ExpressionBuilder(
									calcVariableHintValues.get(v)).build();
							final double variableVal = calc.calculate();// parseDouble
							/*
							 * doesn't support Scientific notation, like: 0.42e2
							 * == 4200e-2 == 42,
							 */
							foundValues.put(v.getName(),
									new Double(variableVal));
						} catch (final Exception e) {
							consoleStream
									.println("Couldn't convert variable "
											+ v.getName()
											+ " of CalculatorMapping "
											+ h.getName()
											+ " from String to double. The problematic source element's attribute value was: "
											+ calcVariableHintValues.get(v));
						}
					}
				}

				if (foundValues.keySet().size() > 0) {
					calculatorMappingsFound.add((CalculatorMapping) h);

					final Map<String, Double> calcValues = new LinkedHashMap<String, Double>();
					@SuppressWarnings("unchecked")
					final Map<String, Double> oldValues = (Map<String, Double>) changedRefsAndHints
							.getHintValues().get(h).remove();
					calcValues.putAll(oldValues);
					calcValues.putAll(foundValues);
					changedRefsAndHints.getHintValues().get(h).add(calcValues);
				}
			}
		}

		// handle ComplexModelConnectionHints in the same way as
		// ComplexAttributeMappings
		for (final ModelConnectionHint hint : connectionHints) {
			if (hint instanceof ComplexModelConnectionHint) {
				final Map<ComplexModelConnectionHintSourceInterface, String> foundValues = new LinkedHashMap<ComplexModelConnectionHintSourceInterface, String>();
				// append the complex hint value (cardinality either 0 or 1)
				// with found values in right order
				for (final ComplexModelConnectionHintSourceElement s : ((ComplexModelConnectionHint) hint)
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
							.add((ComplexModelConnectionHint) hint);
					@SuppressWarnings("unchecked")
					final Map<ComplexModelConnectionHintSourceInterface, String> oldValues = (Map<ComplexModelConnectionHintSourceInterface, String>) changedRefsAndHints
							.getModelConnectionHintValues().get(hint).remove();
					foundValues.putAll(oldValues);
					changedRefsAndHints.getModelConnectionHintValues()
							.get(hint).add(foundValues);
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
						res = findMapping(
								refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference
										|| usedOkay, hints, connectionHints,
								globalVars, c, changedRefsAndHints);
						if (transformationAborted)
							return null;
					}
				}

				if (!nonZeroCardSectionFound) {
					for (final SourceSectionClass c : classByRefMap.get(ref)) {
						res = findMapping(
								refTargetObj,
								refByClassMap.get(c) instanceof MetaModelSectionReference
										|| usedOkay, hints, connectionHints,
								globalVars, c, changedRefsAndHints);
						if (transformationAborted)
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
						changedRefsAndHints.addHintValues(res.getHintValues());
						changedRefsAndHints.addModelConnectionHintValues(res
								.getModelConnectionHintValues());
						changedRefsAndHints.addUnSyncedHintValues(
								res.getUnSyncedComplexAttrMappings(),
								res.getUnSyncedCalcMappings(),
								res.getUnSyncedComplexAttrMatchers(),
								res.getUnSyncedComplexConnectionHints());
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
						final MappingInstanceStorage res = findMapping(
								rt,
								refByClassMap.get(val) instanceof MetaModelSectionReference
										|| usedOkay, hints, connectionHints,
								globalVars, val, changedRefsAndHints);
						if (transformationAborted)
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
					final pamtram.metamodel.Class smallestKey = possibleSrcModelElementsNoVC
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
							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints
									.addModelConnectionHintValues(srcSectionResult
											.getModelConnectionHintValues());
							changedRefsAndHints
									.addUnSyncedHintValues(
											srcSectionResult
													.getUnSyncedComplexAttrMappings(),
											srcSectionResult
													.getUnSyncedCalcMappings(),
											srcSectionResult
													.getUnSyncedComplexAttrMatchers(),
											srcSectionResult
													.getUnSyncedComplexConnectionHints());

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
				final LinkedHashSet<pamtram.metamodel.Class> usedKeys = new LinkedHashSet<pamtram.metamodel.Class>(); // for
				// counting
				// cardinality

				while (possibleSrcModelElementsVC.keySet().size() != 0) {

					final Class smallestKey = possibleSrcModelElementsVC
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

							changedRefsAndHints.addHintValues(srcSectionResult
									.getHintValues());
							changedRefsAndHints
									.addModelConnectionHintValues(srcSectionResult
											.getModelConnectionHintValues());
							changedRefsAndHints
									.addUnSyncedHintValues(
											srcSectionResult
													.getUnSyncedComplexAttrMappings(),
											srcSectionResult
													.getUnSyncedCalcMappings(),
											srcSectionResult
													.getUnSyncedComplexAttrMatchers(),
											srcSectionResult
													.getUnSyncedComplexConnectionHints());

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
					changedRefsAndHints.addHintValue(h, mappingCounts
							.get(((CardinalityMapping) h).getSource()));
				}
			}
		}

		/*
		 * sync complex hints
		 */
		syncComplexAttrMappings(srcSection, changedRefsAndHints);
		syncCalcMappings(srcSection, changedRefsAndHints);
		syncComplexAttrMatchers(srcSection, changedRefsAndHints);
		syncModelConnectionHints(srcSection, changedRefsAndHints);

		/*
		 * if we are at one of the deepest SourceElements of a complex Mapping,
		 * we create a new unsynced list, and remove it from the
		 * changedRefsAndHints List until we sync it again (see above)
		 */
		for (final MappingHintType h : hints) {
			if (h instanceof ComplexAttributeMapping) {
				if (!(complexAttributeMappingsFound.contains(h) && deepestComplexAttrMappingSrcElementsByCmplxMapping
						.get(h).contains(srcSection))) {
					changedRefsAndHints.getHintValues().get(h).remove();// remove
					// incomplete
					// hint
					// value
				} else if (deepestComplexAttrMappingSrcElementsByCmplxMapping
						.get(h).size() > 1) {
					if (!changedRefsAndHints.getUnSyncedComplexAttrMappings()
							.containsKey(h)) {
						changedRefsAndHints
								.getUnSyncedComplexAttrMappings()
								.put(h,
										new HashMap<SourceSectionClass, LinkedList<Map<ComplexAttributeMappingSourceElement, String>>>());
					}
					changedRefsAndHints
							.getUnSyncedComplexAttrMappings()
							.get(h)
							.put(srcSection,
									new LinkedList<Map<ComplexAttributeMappingSourceElement, String>>());
					@SuppressWarnings("unchecked")
					final Map<ComplexAttributeMappingSourceElement, String> val = (Map<ComplexAttributeMappingSourceElement, String>) changedRefsAndHints
							.getHintValues().get(h).remove();
					changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h)
							.get(srcSection).add(val);
				}
			} else if (h instanceof MappingInstanceSelector) {
				if (((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher) {
					if (!(complexAttributeMatchersFound
							.contains(((MappingInstanceSelector) h)
									.getMatcher()) && deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher
							.get(((MappingInstanceSelector) h).getMatcher())
							.contains(srcSection))) {
						changedRefsAndHints.getHintValues().get(h).remove();// remove
						// incomplete
						// hint
						// value
					} else if (deepestComplexAttrMatcherSrcElementsByComplexAttrMatcher
							.get(((MappingInstanceSelector) h).getMatcher())
							.size() > 1) {
						if (!changedRefsAndHints
								.getUnSyncedComplexAttrMatchers()
								.containsKey(h)) {
							changedRefsAndHints
									.getUnSyncedComplexAttrMatchers()
									.put(h,
											new HashMap<SourceSectionClass, LinkedList<Map<ComplexAttributeMatcherSourceElement, String>>>());
						}
						changedRefsAndHints
								.getUnSyncedComplexAttrMatchers()
								.get(h)
								.put(srcSection,
										new LinkedList<Map<ComplexAttributeMatcherSourceElement, String>>());
						@SuppressWarnings("unchecked")
						final Map<ComplexAttributeMatcherSourceElement, String> val = (Map<ComplexAttributeMatcherSourceElement, String>) changedRefsAndHints
								.getHintValues().get(h).remove();
						changedRefsAndHints.getUnSyncedComplexAttrMatchers()
								.get(h).get(srcSection).add(val);
					}
				}
			} else if (h instanceof CalculatorMapping) {
				if (!(calculatorMappingsFound.contains(h) && deepestCalcAttrMappingSrcElementsByCalcMapping
						.get(h).contains(srcSection))) {
					changedRefsAndHints.getHintValues().get(h).remove();// remove
					// incomplete
					// hint
					// value
				} else if (deepestCalcAttrMappingSrcElementsByCalcMapping
						.get(h).size() > 1) {
					if (!changedRefsAndHints.getUnSyncedCalcMappings()
							.containsKey(h)) {
						changedRefsAndHints
								.getUnSyncedCalcMappings()
								.put(h,
										new HashMap<SourceSectionClass, LinkedList<Map<ExpressionVariable, String>>>());
					}
					changedRefsAndHints
							.getUnSyncedCalcMappings()
							.get(h)
							.put(srcSection,
									new LinkedList<Map<ExpressionVariable, String>>());
					@SuppressWarnings("unchecked")
					final Map<ExpressionVariable, String> val = (Map<ExpressionVariable, String>) changedRefsAndHints
							.getHintValues().get(h).remove();
					changedRefsAndHints.getUnSyncedCalcMappings().get(h)
							.get(srcSection).add(val);
				}
			}
		}

		for (final ModelConnectionHint h : connectionHints) {
			if (h instanceof ComplexModelConnectionHint) {
				if (!(complexConnectionHintsFound.contains(h) && deepestComplexConnectionHintSrcElementsByComplexConnectionHint
						.get(h).contains(srcSection))) {
					changedRefsAndHints.getModelConnectionHintValues().get(h)
							.remove();// remove incomplete hint value
				} else if (deepestComplexConnectionHintSrcElementsByComplexConnectionHint
						.get(h).size() > 1) {
					if (!changedRefsAndHints
							.getUnSyncedComplexConnectionHints().containsKey(h)) {
						changedRefsAndHints
								.getUnSyncedComplexConnectionHints()
								.put((ComplexModelConnectionHint) h,
										new HashMap<SourceSectionClass, LinkedList<Map<ComplexModelConnectionHintSourceElement, String>>>());
					}
					changedRefsAndHints
							.getUnSyncedComplexConnectionHints()
							.get(h)
							.put(srcSection,
									new LinkedList<Map<ComplexModelConnectionHintSourceElement, String>>());
					@SuppressWarnings("unchecked")
					final Map<ComplexModelConnectionHintSourceElement, String> val = (Map<ComplexModelConnectionHintSourceElement, String>) changedRefsAndHints
							.getModelConnectionHintValues().get(h).remove();
					changedRefsAndHints.getUnSyncedComplexConnectionHints()
							.get(h).get(srcSection).add(val);
				}
			}
		}

		return changedRefsAndHints;

	}

	/**
	 * Try to apply a mapping that has the first Element of the supplied List as
	 * its root object.
	 * <p>
	 * It is assumed that the List was created by the buildContainmentTree
	 * method
	 *
	 * @param contRefObjectsToMap
	 * @return Hints and used source model elements for the , null if no mapping
	 *         could be found
	 */
	MappingInstanceStorage findMapping(final List<EObject> contRefObjectsToMap,
			final boolean onlyAskOnceOnAmbiguousMappings) {
		long start;// for statistics
		long time;

		final EObject element = contRefObjectsToMap.remove(0);// source model
		// element which
		// we will now
		// try to map
		start = System.nanoTime();
		final Map<Mapping, MappingInstanceStorage> mappingData = new LinkedHashMap<Mapping, MappingInstanceStorage>();
		// find mapping rules that are applicable to a srcMM element
		for (final Mapping m : mappingsToChooseFrom) {
			// create result map
			MappingInstanceStorage res;

			if (m.getSourceMMSection().getEClass()
					.isSuperTypeOf(element.eClass())) {
				/*
				 * This check is also done by findMapping, but since it will
				 * most likely fail at the top level, for most mappings we do it
				 * here before we construct any collections and so on. This
				 * might save us a little time, but of course that depends on
				 * the number mappings and the source metamodel.
				 */

				if (doContainerCheck(element, m.getSourceMMSection())) {
					res = findMapping(element, false, getHints(m),
							getModelConnectionHints(m), m.getGlobalVariables(),
							m.getSourceMMSection(),
							new MappingInstanceStorage());
					if (transformationAborted)
						return null;

					boolean mappingFailed = res == null;
					if (!mappingFailed) {
						// if mapping possible check ExternalAttributeMappings
						// check external attributes here; container element
						// MUST be present (check was done earlier)
						mappingFailed = handleExternalAttributeMappings(m, res,
								mappingFailed);
					}
					if (!mappingFailed) {// if mapping possible add to list
						res.setMapping(m);
						mappingData.put(m, res);
					}
				}
			}
		}
		time = System.nanoTime() - start;

		// last step: let user decide
		MappingInstanceStorage returnVal = null;
		switch (mappingData.keySet().size()) {
		case 0:
			// consoleStream.println("No suitable mappping found for element\n'"
			// + element.eClass().getName() + "'.");
			break;
		case 1:
			returnVal = mappingData.values().iterator().next();
			break;
		default:
			if (onlyAskOnceOnAmbiguousMappings
					&& ambiguousMappingSelections.containsKey(mappingData
							.keySet())) {// only use past choices if this option
				// is set
				returnVal = mappingData.get(ambiguousMappingSelections
						.get(mappingData.keySet()));
			} else {
				if (transformationAborted)
					return null;
				final NamedElementItemSelectorDialogRunner<Mapping> dialog = new NamedElementItemSelectorDialogRunner<Mapping>(
						"Please select a Mapping for the source element\n'"
								+ EObjectTransformationHelper.asString(element)
								+ "'", new ArrayList<Mapping>(
								mappingData.keySet()), 0);
				Display.getDefault().syncExec(dialog);
				if (dialog.wasTransformationStopRequested()) {
					transformationAborted = true;
					return null;
				}
				returnVal = mappingData.get(mappingData.get(dialog
						.getSelection()));
				ambiguousMappingSelections.put(mappingData.keySet(),
						dialog.getSelection());
			}
		}

		if (returnVal != null) {
			int used = 0;
			for (final SourceSectionClass c : returnVal
					.getSourceModelObjectsMapped().keySet()) {
				if (!mappedSections.containsKey(c)) {
					mappedSections.put(c, new LinkedHashSet<EObject>());
				}
				used += returnVal.getSourceModelObjectsMapped().get(c).size();
				mappedSections.get(c).addAll(
						returnVal.getSourceModelObjectsMapped().get(c));

				contRefObjectsToMap.removeAll(returnVal
						.getSourceModelObjectsMapped().get(c));// remove mapped
				// elements from
				// list of
				// elements to
				// be mapped
			}
			consoleStream.println(',' + returnVal.getMapping().getName() + ", "
					+ used + " ,  " + time);

			/*
			 * Handle cardinality Hints for section root (doesn't make sense to
			 * model this but we will tolerate it)
			 */
			for (final MappingHintType h : getHints(returnVal.getMapping())) {
				if (h instanceof CardinalityMapping) {
					returnVal.addHintValue(h, new Integer(1));
				}
			}
		}

		return returnVal;
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
	 * Getter for Registry for values of global Variables
	 *
	 * @return Registry for values of global Variables
	 */
	public Map<GlobalAttribute, String> getGlobalVarValues() {
		return globalVarValues;
	}

	/**
	 * @param m
	 *            Mapping
	 * @return MappingHints of all the Mappings MappingHintGroups.
	 */
	private List<MappingHintType> getHints(final Mapping m) {
		if (!mappingHints.containsKey(m)) {
			mappingHints.put(m, new LinkedList<MappingHintType>());
			for (final MappingHintGroupType g : m.getMappingHintGroups()) {
				if (g.getMappingHints() != null) {
					mappingHints.get(m).addAll(g.getMappingHints());
				}
			}

			for (final MappingHintGroupImporter g : m
					.getImportedMappingHintGroups()) {
				if (g.getMappingHints() != null) {
					mappingHints.get(m).addAll(g.getMappingHints());
				}
			}
		}

		return mappingHints.get(m);

	}

	/**
	 * Getter for Registry for mapped sections
	 *
	 * @return Registry for mapped sections
	 */
	public LinkedHashMap<SourceSectionClass, Set<EObject>> getMappedSections() {
		return mappedSections;
	}

	/**
	 * @param m
	 * @return ModelConnectionHints of all the Mappings MappingHintGroups.
	 */
	private List<ModelConnectionHint> getModelConnectionHints(final Mapping m) {
		if (!modelConnectionHints.containsKey(m)) {
			modelConnectionHints.put(m, new LinkedList<ModelConnectionHint>());
			for (final MappingHintGroupType g : m.getMappingHintGroups()) {
				if (g instanceof MappingHintGroup) {
					if (((MappingHintGroup) g).getModelConnectionMatcher() != null) {
						modelConnectionHints.get(m).add(
								((MappingHintGroup) g)
										.getModelConnectionMatcher());
					}
				}
			}
		}

		return modelConnectionHints.get(m);

	}

	/**
	 * Tries to determine the hintValues for the
	 * ExternalAttributeMappingSourceElements, if present
	 *
	 * @param m
	 * @param res
	 * @param mappingFailed
	 * @return
	 */
	private boolean handleExternalAttributeMappings(final Mapping m,
			final MappingInstanceStorage res, boolean mappingFailed) {
		if (m.getSourceMMSection().getContainer() != null) {
			final Map<ExternalAttributeMappingSourceElement, String> attrVals = new HashMap<ExternalAttributeMappingSourceElement, String>();
			for (final MappingHintType h : getHints(m)) {
				if (h instanceof ComplexAttributeMapping) {
					for (final ComplexAttributeMappingSourceInterface i : ((ComplexAttributeMapping) h)
							.getSourceAttributeMappings()) {
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
						// if the external element was the only one in the hint
						// we need to add a hint value
						if (res.getHintValues().get(h).size() == 0) {
							res.getHintValues()
									.get(h)
									.add(new LinkedHashMap<ComplexAttributeMappingSourceInterface, String>());
						}
						for (final Object hVal : res.getHintValues().get(h)) {
							@SuppressWarnings("unchecked")
							final Map<ComplexAttributeMappingSourceInterface, String> map = (Map<ComplexAttributeMappingSourceInterface, String>) hVal;
							for (final ExternalAttributeMappingSourceElement e : attrVals
									.keySet()) {
								map.put((ComplexAttributeMappingSourceInterface) e,
										attrVals.get(e));
							}
						}
						// last action: reset attrval list
						attrVals.clear();
					}
				} else if (h instanceof ExternalMappedAttributeValueExpander) {
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
						attrVal = attributeValuemodifier
								.applyAttributeValueModifiers(
										attrVal,
										((ExternalMappedAttributeValueExpander) h)
												.getModifiers());
						res.getHintValues().get(h).add(attrVal);
					}

				} else if (h instanceof CalculatorMapping) {
					for (final CalculatorMappingSourceInterface i : ((CalculatorMapping) h)
							.getVariables()) {
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
						if (res.getHintValues().get(h).size() == 0) {
							res.getHintValues().get(h)
									.add(new LinkedHashMap<String, Double>());
						}
						final Map<String, Double> newVals = new HashMap<String, Double>();
						for (final ExternalAttributeMappingSourceElement e : attrVals
								.keySet()) {
							try {
								final Calculable calc = new ExpressionBuilder(
										attrVals.get(e)).build();
								final double variableVal = calc.calculate();// parseDouble
								/*
								 * doesn't support Scientific notation, like:
								 * 0.42e2 == 4200e-2 == 42,
								 */
								newVals.put(e.getName(),
										new Double(variableVal));
							} catch (final Exception execption) {
								consoleStream
										.println("Couldn't convert variable "
												+ e.getName()
												+ " of CalculatorMapping "
												+ h.getName()
										+ " from String to double. The problematic source element's attribute value was: "
												+ attrVals.get(e));
							}
						}
						for (final Object hVal : res.getHintValues().get(h)) {
							@SuppressWarnings("unchecked")
							final Map<String, Double> map = (Map<String, Double>) hVal;
							map.putAll(newVals);
						}
						// last action: reset attrval list
						attrVals.clear();
					}
				} else if (h instanceof MappingInstanceSelector) {
					if (((MappingInstanceSelector) h).getMatcher() != null) {
						if (((MappingInstanceSelector) h).getMatcher() instanceof ComplexAttributeMatcher) {
							final ComplexAttributeMatcher matcher = (ComplexAttributeMatcher) ((MappingInstanceSelector) h)
									.getMatcher();
							for (final ComplexAttributeMatcherSourceInterface i : matcher
									.getSourceAttributes()) {
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
								if (res.getHintValues().get(h).size() == 0) {
									res.getHintValues()
											.get(h)
											.add(new LinkedHashMap<ComplexAttributeMatcherSourceInterface, String>());
								}
								for (final Object hVal : res.getHintValues()
										.get(h)) {
									@SuppressWarnings("unchecked")
									final Map<ComplexAttributeMatcherSourceInterface, String> map = (Map<ComplexAttributeMatcherSourceInterface, String>) hVal;
									for (final ExternalAttributeMappingSourceElement e : attrVals
											.keySet()) {
										map.put((ComplexAttributeMatcherSourceInterface) e,
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

			for (final ModelConnectionHint h : getModelConnectionHints(m)) {
				if (h instanceof ComplexModelConnectionHint) {
					for (final ComplexModelConnectionHintSourceInterface i : ((ComplexModelConnectionHint) h)
							.getSourceElements()) {
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
						if (res.getModelConnectionHintValues().get(h).size() == 0) {
							res.getModelConnectionHintValues()
									.get(h)
									.add(new LinkedHashMap<ComplexModelConnectionHintSourceInterface, String>());
						}
						for (final Object hVal : res
								.getModelConnectionHintValues().get(h)) {
							@SuppressWarnings("unchecked")
							final Map<ComplexModelConnectionHintSourceInterface, String> map = (Map<ComplexModelConnectionHintSourceInterface, String>) hVal;
							for (final ExternalAttributeMappingSourceElement e : attrVals
									.keySet()) {
								map.put((ComplexModelConnectionHintSourceInterface) e,
										attrVals.get(e));
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
	 * @return true when user action was triggered to abort the transformation
	 */
	@Override
	public boolean isCancelled() {
		return transformationAborted;
	}

	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncCalcMappings(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {
		for (final MappingHintType h : changedRefsAndHints
				.getUnSyncedCalcMappings().keySet()) {
			final boolean isCommonParent = commonContainerClassOfComplexMappings
					.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnSyncedCalcMappings().containsKey(h)) {
				if (changedRefsAndHints.getUnSyncedCalcMappings().get(h).size() > 1
						|| isCommonParent) {
					final Map<SourceSectionClass, LinkedList<Map<ExpressionVariable, String>>> m = changedRefsAndHints
							.getUnSyncedCalcMappings().get(h);
					// list of "synced" hints
					LinkedList<Map<ExpressionVariable, String>> syncedComplexMappings = null;
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
						final LinkedList<Map<ExpressionVariable, String>> vals = m
								.get(c);
						if (vals.size() == 1) {
							for (final Map<ExpressionVariable, String> valMap : syncedComplexMappings) {
								valMap.putAll(vals.getFirst());
							}
						} else if (vals.size() > 1) {
							for (int i = 0; i < vals.size(); i++) {// remember:
								/*
								 * the size of vals will be lower or equal the
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
						changedRefsAndHints.getHintValues().get(h)
								.addAll(syncedComplexMappings);
						// }
					} else {
						changedRefsAndHints.getUnSyncedCalcMappings().get(h)
								.clear();// remove old hints
						changedRefsAndHints.getUnSyncedCalcMappings().get(h)
								.put(srcSection, syncedComplexMappings);// add
						// new
						// hints
					}
				}
			}
		}
	}

	/**
	 * @param srcSection
	 * @param changedRefsAndHints
	 */
	private void syncComplexAttrMappings(final SourceSectionClass srcSection,
			final MappingInstanceStorage changedRefsAndHints) {
		for (final MappingHintType h : changedRefsAndHints
				.getUnSyncedComplexAttrMappings().keySet()) {
			final boolean isCommonParent = commonContainerClassOfComplexMappings
					.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnSyncedComplexAttrMappings()
					.containsKey(h)) {
				if (changedRefsAndHints.getUnSyncedComplexAttrMappings().get(h)
						.size() > 1
						|| isCommonParent) {
					final Map<SourceSectionClass, LinkedList<Map<ComplexAttributeMappingSourceElement, String>>> m = changedRefsAndHints
							.getUnSyncedComplexAttrMappings().get(h);
					// list of "synced" hints
					LinkedList<Map<ComplexAttributeMappingSourceElement, String>> syncedComplexMappings = null;
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
						final LinkedList<Map<ComplexAttributeMappingSourceElement, String>> vals = m
								.get(c);
						if (vals.size() == 1) {
							for (final Map<ComplexAttributeMappingSourceElement, String> valMap : syncedComplexMappings) {
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
						changedRefsAndHints.getHintValues().get(h)
								.addAll(syncedComplexMappings);
						// }
					} else {
						changedRefsAndHints.getUnSyncedComplexAttrMappings()
								.get(h).clear();// remove old hints
						// add new hints
						changedRefsAndHints.getUnSyncedComplexAttrMappings()
								.get(h).put(srcSection, syncedComplexMappings);
					}
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
		for (final MappingHintType h : changedRefsAndHints
				.getUnSyncedComplexAttrMatchers().keySet()) {
			final boolean isCommonParent = commonContainerClassOfComplexMappings
					.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnSyncedComplexAttrMatchers()
					.containsKey(h)) {
				if (changedRefsAndHints.getUnSyncedComplexAttrMatchers().get(h)
						.size() > 1
						|| isCommonParent) {
					final Map<SourceSectionClass, LinkedList<Map<ComplexAttributeMatcherSourceElement, String>>> m = changedRefsAndHints
							.getUnSyncedComplexAttrMatchers().get(h);
					// list of "synced" hints
					LinkedList<Map<ComplexAttributeMatcherSourceElement, String>> syncedComplexMappings = null;
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
						final LinkedList<Map<ComplexAttributeMatcherSourceElement, String>> vals = m
								.get(c);
						if (vals.size() == 1) {
							for (final Map<ComplexAttributeMatcherSourceElement, String> valMap : syncedComplexMappings) {
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
						changedRefsAndHints.getHintValues().get(h)
								.addAll(syncedComplexMappings);
						// }
					} else {
						changedRefsAndHints.getUnSyncedComplexAttrMatchers()
								.get(h).clear();// remove old hints
						changedRefsAndHints.getUnSyncedComplexAttrMatchers()
								.get(h).put(srcSection, syncedComplexMappings);// add
						// new
						// hints
					}
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
		for (final ModelConnectionHint h : changedRefsAndHints
				.getUnSyncedComplexConnectionHints().keySet()) {
			final boolean isCommonParent = commonContainerClassOfComplexMappings
					.get(h).equals(srcSection);

			if (changedRefsAndHints.getUnSyncedComplexConnectionHints()
					.containsKey(h)) {
				if (changedRefsAndHints.getUnSyncedComplexConnectionHints()
						.get(h).size() > 1
						|| isCommonParent) {
					final Map<SourceSectionClass, LinkedList<Map<ComplexModelConnectionHintSourceElement, String>>> m = changedRefsAndHints
							.getUnSyncedComplexConnectionHints().get(h);
					// list of "synced" hints
					LinkedList<Map<ComplexModelConnectionHintSourceElement, String>> syncedComplexMappings = null;
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
						final LinkedList<Map<ComplexModelConnectionHintSourceElement, String>> vals = m
								.get(c);
						if (vals.size() == 1) {
							for (final Map<ComplexModelConnectionHintSourceElement, String> valMap : syncedComplexMappings) {
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
						changedRefsAndHints.getHintValues().get(h)
								.addAll(syncedComplexMappings);
						// }
					} else {
						changedRefsAndHints.getUnSyncedComplexConnectionHints()
								.get(h).clear();// remove old hints
						changedRefsAndHints.getUnSyncedComplexConnectionHints()
								.get(h).put(srcSection, syncedComplexMappings);// add
						// new
						// hints
					}
				}
			}
		}
	}

}
