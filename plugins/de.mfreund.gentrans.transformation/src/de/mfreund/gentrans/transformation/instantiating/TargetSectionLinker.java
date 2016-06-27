package de.mfreund.gentrans.transformation.instantiating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;

import de.mfreund.gentrans.transformation.calculation.AttributeValueCalculator;
import de.mfreund.gentrans.transformation.calculation.AttributeValueModifierExecutor;
import de.mfreund.gentrans.transformation.descriptors.AttributeValueRepresentation;
import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MappingInstanceStorage;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;
import de.mfreund.gentrans.transformation.registries.HintValueStorage;
import de.mfreund.gentrans.transformation.registries.TargetSectionRegistry;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.util.CancelableElement;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import pamtram.NamedElement;
import pamtram.mapping.AttributeMatcher;
import pamtram.mapping.AttributeMatcherSourceInterface;
import pamtram.mapping.ClassMatcher;
import pamtram.mapping.ExportedMappingHintGroup;
import pamtram.mapping.FixedValue;
import pamtram.mapping.GlobalAttribute;
import pamtram.mapping.InstantiableMappingHintGroup;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHint;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingHintType;
import pamtram.mapping.MappingInstanceSelector;
import pamtram.metamodel.ExternalReferenceParameter;
import pamtram.metamodel.LibraryEntry;
import pamtram.metamodel.LibraryParameter;
import pamtram.metamodel.TargetSection;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import pamtram.metamodel.TargetSectionReference;

/**
 * Class for linking target model sections using the hints supplied by
 * {@link MappingInstanceStorage MappingInstanceStorages}.
 *
 * @author mfreund
 */
public class TargetSectionLinker extends CancelableElement {

	private static final String RESOLVE_LINKING_AMBIGUITY_STARTED = "[Ambiguity] Resolve linking ambiguity...";
	private static final String RESOLVE_LINKING_AMBIGUITY_FINISHED = "[Ambiguity] ...finished.\n";
	
	/**
	 * target section registry used when instantiating classes
	 */
	private final TargetSectionRegistry targetSectionRegistry;
	
	/**
	 * used to write console output
	 */
	private final MessageConsoleStream consoleStream;
	
	/**
	 * This is the {@link IAmbiguityResolvingStrategy} that shall be used to 
	 * resolve ambiguities that arise during the execution of the transformation.
	 */
	private IAmbiguityResolvingStrategy ambiguityResolvingStrategy;
	
	/**
	 * This relates temporarily created elements for LibraryEntries (represented by an {@link EObjectWrapper}) to
	 * their {@link LibraryEntryInstantiator}. 
	 */
	private Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap;
	
	/**
	 * An instance of {@link AttributeValueCalculator} that is used to calculate attribute values.
	 */
	private AttributeValueCalculator calculator;
	
	/**
	 * This creates an instance.
	 * 
	 * @param targetSectionRegistry
	 *            target section registry used when instantiating classes
	 * @param globalValues
	 *            Registry for values of {@link GlobalAttribute GlobalAttributes} and {@link FixedValue FixedValues}.
	 * @param libEntryInstantiatorMap The temporarily created elements for LibraryEntries (represented by an {@link EObjectWrapper}) and
	 * their corresponding {@link LibraryEntryInstantiator}. 
	 * @param attributeValuemodifier An instance of the {@link AttributeValueModifierExecutor}.
	 * @param consoleStream
	 *            used to write console output
	 * @param ambiguityResolvingStrategy The {@link IAmbiguityResolvingStrategy} that shall be used
	 * to resolve occurring ambiguities.
	 */
	public TargetSectionLinker(
			final TargetSectionRegistry targetSectionRegistry,
			final Map<NamedElement, Double> globalValues,
			final Map<EObjectWrapper, LibraryEntryInstantiator> libEntryInstantiatorMap,
			final AttributeValueModifierExecutor attributeValuemodifier,
			final MessageConsoleStream consoleStream,
			final IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		this.targetSectionRegistry = targetSectionRegistry;
		this.consoleStream = consoleStream;
		this.ambiguityResolvingStrategy = ambiguityResolvingStrategy;
		this.canceled = false;
		this.libEntryInstantiatorMap = libEntryInstantiatorMap;
		
		Map<String, Double> globalDoubleValues = globalValues.entrySet().parallelStream().collect(
				Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));

		calculator = new AttributeValueCalculator(globalDoubleValues, attributeValuemodifier, consoleStream);

		consoleStream.println("...parsing done!");
	}

	/**
	 * This links the {@link TargetSection TargetSections} represented by the
	 * <em>hintGroups</em> of the given {@link MappingInstanceStorage}.
	 * 
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to link.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully; 
	 * '<em><b>false</b></em>' otherwise
	 */
	public boolean linkTargetSectionInstance(final MappingInstanceStorage mappingInstance) {
		
		
		// Link 'local' hint groups
		//
		if(!mappingInstance.getMappingHintGroups().stream()
				.allMatch(g -> linkTargetSectionInstance(mappingInstance, g))) {
			
			return false;
		}
		
		// Link 'imported' hint groups
		//
		if(!mappingInstance.getMappingHintGroupImporters().stream()
				.allMatch(g -> linkTargetSectionInstance(mappingInstance, g))) {
			
			return false;
		}
		
		return true;
	}

	/**
	 * This links given {@link TargetSection} represented by the given
	 * <em>hintGroup</em> for the given {@link MappingInstanceStorage} by
	 * redirecting to
	 * {@link TargetSectionInstantiator#instantiateTargetSectionSecondPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map)}.
	 * 
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to link.
	 * @param hintGroupImporter
	 *            The {@link MappingHintGroupImporter} that lead to the
	 *            instantiation of the given <em>mappingInstance</em>.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully; 
	 * '<em><b>false</b></em>' otherwise
	 */
	private boolean linkTargetSectionInstance(final MappingInstanceStorage mappingInstance, 
			final MappingHintGroupImporter hintGroupImporter) {
		
		final ExportedMappingHintGroup expGrp = hintGroupImporter.getHintGroup();
		if (expGrp.getTargetMMSection() != null) {
			if (mappingInstance.getInstancesBySection(hintGroupImporter) != null) {
				final List<MappingHint> hints = new LinkedList<>();
				hints.addAll(mappingInstance.getMappingHints(expGrp));
				for (final MappingHintType h : mappingInstance.getMappingHints(hintGroupImporter)) {
					
					if (isCanceled()) {
						return false;
					}
	
					if (h instanceof MappingHint) {
						hints.add((MappingHint) h);
					}// TODO else if ...??-> should have already been
					// done during 1st pass
				}
	
				instantiateTargetSectionSecondPass(
						expGrp.getTargetMMSection(), 
						hintGroupImporter, 
						hints, 
						mappingInstance.getHintValues(), 
						mappingInstance.getInstancesBySection(hintGroupImporter));
				
				if (isCanceled()) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * This links given {@link TargetSection} represented by the given
	 * <em>hintGroup</em> for the given {@link MappingInstanceStorage} by
	 * redirecting to
	 * {@link TargetSectionInstantiator#instantiateTargetSectionSecondPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map)}.
	 * 
	 * @param mappingInstance
	 *            The {@link MappingInstanceStorage mapping instance} to link.
	 * @param hintGroup
	 *            The {@link MappingHintGroupType} that lead to the
	 *            instantiation of the given <em>mappingInstance</em>.
	 * @return '<em><b>true</b></em>' if all instances of the TargetSection were joined successfully; 
	 * '<em><b>false</b></em>' otherwise
	 */
	private boolean linkTargetSectionInstance(final MappingInstanceStorage mappingInstance, 
			final MappingHintGroupType hintGroup) {
		
		if (hintGroup.getTargetMMSection() != null && hintGroup instanceof MappingHintGroup) {
			
			if (mappingInstance.getInstancesBySection((MappingHintGroup) hintGroup) != null) {
	
				instantiateTargetSectionSecondPass(
						hintGroup.getTargetMMSection(),
						(MappingHintGroup) hintGroup,
						mappingInstance.getMappingHints(hintGroup),
						mappingInstance.getHintValues(),
						mappingInstance.getInstancesBySection((MappingHintGroup) hintGroup));
				
				if (isCanceled()) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * Instantiate the given {@link TargetSection} using the specified
	 * {@link HintValueStorage hint values}.
	 * <p />
	 * Note: This constitutes the second pass of the instantiation that creates
	 * non-containment references.
	 *
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} to instantiate.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the
	 *            TargetSection gets instantiated.
	 * @param mappingHints
	 *            The list of {@link MappingHint MappingHints} to take into
	 *            account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover
	 *            <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param instancesBySection
	 *            The registry for {@link EObjectWrapper instances} created
	 *            during the first pass of the instantiation.
	 */
	private void instantiateTargetSectionSecondPass(
			final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> mappingHints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection) {
	
		/*
		 * only go on if any instances of this section were created
		 */
		if (instancesBySection.get(targetSectionClass) == null) {
			return;
		}
	
		EList<TargetSectionReference> references = targetSectionClass.getReferences();
	
		if (targetSectionClass.isLibraryEntry()) {
			// the target section class is part of a library entry, thus
			// there must not be any references as direct children of it
			references = new BasicEList<>();
			// however, we want to perform the linking for the references
			// affected by ExternalReferenceParameters
			LibraryEntry libEntry = (LibraryEntry) targetSectionClass.eContainer().eContainer();
	
			for (LibraryParameter<?> parameter : libEntry.getParameters()) {
				if (parameter instanceof ExternalReferenceParameter) {
					references.add(((ExternalReferenceParameter) parameter).getReference());
				}
			}
		}
	
		List<TargetSectionNonContainmentReference> nonContainmentReferences = references.parallelStream()
				.filter(ref -> ref instanceof TargetSectionNonContainmentReference)
				.map(ref -> (TargetSectionNonContainmentReference) ref).collect(Collectors.toList());
	
		for (final TargetSectionNonContainmentReference ref : nonContainmentReferences) {
	
			final LinkedList<TargetSectionClass> refValueClone = new LinkedList<>();
			refValueClone.addAll(ref.getValue());
	
			boolean hintFound = false;
	
			// Collect MappingInstanceSelectors that affect the current reference
			//
			List<MappingInstanceSelector> mappingInstanceSelectorsToConcider = mappingHints.parallelStream()
					.filter(h -> h instanceof MappingInstanceSelector
							&& ((MappingInstanceSelector) h).getAffectedReference().equals(ref))
					.map(h -> (MappingInstanceSelector) h).collect(Collectors.toList());
	
			// search for mapping instance selector
			for (MappingInstanceSelector h : mappingInstanceSelectorsToConcider) {
	
				/*
				 * handle AttributeMatcher
				 */
				if (h.getMatcher() instanceof AttributeMatcher) {
	
					final AttributeMatcher matcher = (AttributeMatcher) h.getMatcher();
	
					hintFound = true;
					// now search for target attributes
					final List<EObjectWrapper> targetInstances = targetSectionRegistry
							.getFlattenedPamtramClassInstances(matcher.getTargetAttribute().getOwningClass());
	
					// instances are sorted in the same order as
					// hintValues
					final LinkedList<EObjectWrapper> instancesToConsider = new LinkedList<>();
					instancesToConsider.addAll(instancesBySection.get(targetSectionClass));
					/*
					 * Sizes of instances and attributeHints must either match,
					 * or, in case there was a cardinality mapping, the size of
					 * the hintValues must be 1
					 */
					LinkedList<Map<AttributeMatcherSourceInterface, AttributeValueRepresentation>> newHintValues = new LinkedList<>();
					int numberOfInstancesToCreate = 0;
					if (hintValues.getHintValues(h).size() == 1) {
	
						// one hint value but multiple instances
						// -> clone the single hint value for
						// each instance
						final Map<AttributeMatcherSourceInterface, AttributeValueRepresentation> hintVal = hintValues
								.getHintValues(h).getFirst();
						for (int i = 0; i < instancesToConsider.size(); i++) {
							newHintValues.add(hintVal);
						}
						numberOfInstancesToCreate = newHintValues.size();
					} else if (instancesToConsider.size() == hintValues.getHintValues(h)
							.size()) {
	
						// multiple hint values and the same
						// amount of instances -> each hint
						// value is used for one instance
						newHintValues = hintValues.getHintValues(h);
						numberOfInstancesToCreate = newHintValues.size();
					} else if (h.getAffectedReference().getEReference().isMany()
							&& hintValues.getHintValues(h).size()
							% instancesToConsider.size() == 0) {
	
						// a multiple of hint values for each
						// instance -> use multiple hint values
						// for each instance
						newHintValues = hintValues.getHintValues(h);
						numberOfInstancesToCreate = instancesToConsider.size();
					} else {
	
						consoleStream.println(
								"There was a size mismatch while trying to set a non-containment reference, using the Hint "
										+ h.getName() + ". There where " + instancesToConsider.size()
										+ " instances to be connected but "
										+ hintValues.getHintValues(h).size()
										+ " MappingHint values. The output below"
										+ " shows the hint values and the source instances for the reference:\n"
										+ hintValues.getHintValues(h) + "\n"
										+ instancesToConsider);
					}
	
					// how many target instances are to be set
					// as value of the non-containment reference
					// of each instance
					final int targetsPerInstance = newHintValues.size() / numberOfInstancesToCreate;
	
					for (int i = 0; i < numberOfInstancesToCreate; i++) {
	
						final EObjectWrapper srcInst = instancesToConsider.remove(0);
	
						for (int j = 0; j < targetsPerInstance; j++) {
	
							String attrValStr = null;
							if (h.getMatcher() instanceof AttributeMatcher) {
								attrValStr = calculator.calculateAttributeValue(null, h, newHintValues);
							}
							final List<EObjectWrapper> fittingVals = new LinkedList<>();
	
							for (final EObjectWrapper targetInst : targetInstances) {
								// get Attribute value
								final String targetValStr = targetInst.getAttributeValue(matcher.getTargetAttribute());
								if (targetValStr != null) {
									if (targetValStr.equals(attrValStr)) {
										fittingVals.add(targetInst);
									}
								} else {
									consoleStream.println("Problemo?");
								}
							}
							// select targetInst
							List<EObject> targetInst = new ArrayList<>();
							if (fittingVals.size() == 1) {
								targetInst.add(fittingVals.get(0).getEObject());
	
							} else if (fittingVals.size() > 1) {
	
								if (canceled) {
									return;
								}
	
								/*
								 * Consult the specified resolving strategy to
								 * resolve the ambiguity.
								 */
								try {
									consoleStream.println(RESOLVE_LINKING_AMBIGUITY_STARTED);
									List<EObjectWrapper> resolved = ambiguityResolvingStrategy
											.linkingSelectTargetInstance(fittingVals,
													h.getAffectedReference(),
													(MappingHintGroupType) mappingGroup, h,
													srcInst);
									consoleStream.println(RESOLVE_LINKING_AMBIGUITY_FINISHED);
									if (ref.getEReference().isMany()) {
										for (EObjectWrapper eObjectWrapper : resolved) {
											targetInst.add(eObjectWrapper.getEObject());
										}
									} else {
										targetInst.add(resolved.get(0).getEObject());
									}
								} catch (Exception e) {
									consoleStream.println(e.getMessage());
									cancel();
									return;
								}
	
							} else {
								consoleStream.println("The MappigInstanceSelector " + h.getName() + " (Mapping: "
										+ ((Mapping) mappingGroup.eContainer()).getName() + ", Group: "
										+ mappingGroup.getName()
										+ " ) has an AttributeMatcher that picked up the value '" + attrValStr
										+ "' to be matched to the "
										+ "TargetAttribute, but no fitting TargetSectionInstance with this value could be found.");
	
							}
	
							// finally, we can set the value of
							// the reference
							if (!targetSectionClass.isLibraryEntry()) {
								addValuesToReference(ref, targetInst, srcInst.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(srcInst).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
								ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
										.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
								@SuppressWarnings("unchecked")
								AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
								.getOriginalParameter();
								// library entries do currently
								// not support to set multiple
								// target instances for an
								// ExternalReferenceParameter
								originalParam.setTarget(targetInst.get(0));
							}
						}
	
					}
	
					/*
					 * Handle ClassMatcher
					 */
				} else if (h.getMatcher() instanceof ClassMatcher) {
	
					hintFound = true;
	
					if (((ClassMatcher) h.getMatcher()).getTargetClass() != null) {// was
						// the
						// matcher
						// modeled
						// correctly?
						if (refValueClone.contains(((ClassMatcher) h.getMatcher()).getTargetClass())) {
							// select any of the targetInstances
							// available for the reference
							// target
							final List<EObjectWrapper> instancesToConsider = instancesBySection.get(targetSectionClass);
	
							final TargetSectionClass matcherTargetClass = ((ClassMatcher) h.getMatcher())
									.getTargetClass();
	
							/*
							 * select potential instances globally
							 */
							final List<EObjectWrapper> insts = targetSectionRegistry
									.getFlattenedPamtramClassInstances(matcherTargetClass);
	
							EObjectWrapper targetInstance = null;
							if (insts.size() == 1) {
								targetInstance = insts.get(0);
							} else if (insts.size() > 1) {
								// Dialog
								if (canceled) {
									return;
								}
	
								/*
								 * Consult the specified resolving strategy to
								 * resolve the ambiguity.
								 */
								try {
									List<EObjectWrapper> resolved = ambiguityResolvingStrategy
											.linkingSelectTargetInstance(insts,
													h.getAffectedReference(), null,
													h, null);
									targetInstance = resolved.get(0);
								} catch (Exception e) {
									consoleStream.println(e.getMessage());
									cancel();
									return;
								}
	
							} else {
								consoleStream.println("The MappingInstanceSelector '" + h.getName() + " of Mapping"
										+ ((Mapping) mappingGroup.eContainer()).getName() + "(Group: "
										+ mappingGroup.getName() + ")' has a Matcher that points to the target class "
										+ matcherTargetClass.getName() + " (Section: "
										+ matcherTargetClass.getContainingSection().getName()
										+ "). Sadly, no instances of this Class were created.");
							}
	
							if (targetInstance != null) {
								for (final EObjectWrapper inst : instancesToConsider) {// same
									// action for every instance of specific
									// mapping
									//
									if (!targetSectionClass.isLibraryEntry()) {
										addValueToReference(ref, targetInstance.getEObject(), inst.getEObject());
									} else {
										/*
										 * for library entries, we cannot simply
										 * add the value as the reference we are
										 * handling is not part of the
										 * targetSectionClass; instead we want
										 * to specify the value as 'target' for
										 * the affected
										 * ExternalReferenceParameter
										 */
										LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(inst)
												.getLibraryEntry();
										LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
												.eContainer();
										ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
												.getParameters()
												.get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
										@SuppressWarnings("unchecked")
										AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
										.getOriginalParameter();
										originalParam.setTarget(targetInstance.getEObject());
									}
								}
							}
						}
					}
	
				} else {
					consoleStream.println("Matcher of type " + h.getMatcher().eClass().getName() + " in MappingHint "
							+ h.getName() + " is not supported.");
				}
	
				if (hintFound) {
					break;
				}
			}
	
			/*
			 * In case no suitable hint could be found we will try the
			 * following:
			 * 
			 * 1.only non-cont ref targets to other subsections of this
			 * targetMMSection are considered, we can resolve the reference if
			 * only one Instance of the ref Target was created in the same
			 * mapping instance
			 * 
			 * if that isn't the case:
			 * 
			 * 2. consider all available instances of the ref target
			 */
			if (!hintFound) { // last chance
	
				final LinkedHashSet<TargetSectionClass> foundLocalNonContRefTargets = new LinkedHashSet<>();
				final LinkedList<TargetSectionClass> refValue = new LinkedList<>();
				refValue.addAll(ref.getValue());
	
				// first check root targetMMSection itself
				if (refValue.contains(mappingGroup.getTargetMMSectionGeneric())) {
					foundLocalNonContRefTargets.add(mappingGroup.getTargetMMSectionGeneric());
					refValue.remove(mappingGroup.getTargetMMSectionGeneric());
				}
	
				// then check all its children
				final TreeIterator<EObject> it = mappingGroup.getTargetMMSectionGeneric().eAllContents();
				while (it.hasNext() && !refValue.isEmpty()) {
					final EObject next = it.next();
					if (refValue.contains(next)) {// at least one of the
						/*
						 * values the pamtram-reference points to, is part of
						 * the same MappingHintGroup's targetMMSection
						 */
						foundLocalNonContRefTargets.add((TargetSectionClass) next);
						refValue.remove(next);
					}
	
				}
				/*
				 * only non-cont ref targets to other subsections of this
				 * targetMMSection are considered
				 */
				if (foundLocalNonContRefTargets.size() > 0) {
					// get source instances for the reference
					final LinkedList<EObjectWrapper> sourceInstances = new LinkedList<>();
					sourceInstances.addAll(instancesBySection.get(targetSectionClass));
	
					// get root instances of groups targetMMSection
					final List<EObjectWrapper> rootInstances = instancesBySection
							.get(mappingGroup.getTargetMMSectionGeneric());
	
					// get target instances for the reference
					final LinkedList<EObjectWrapper> targetInstances = new LinkedList<>();
					for (final TargetSectionClass section : foundLocalNonContRefTargets) {
						targetInstances.addAll(instancesBySection.get(section));
					}
	
					// now sort instances by root
					final LinkedHashMap<EObjectWrapper, EObjectWrapper> rootBySourceInstance = new LinkedHashMap<>();
					final LinkedHashMap<EObjectWrapper, LinkedList<EObjectWrapper>> targetInstancesByRoot = new LinkedHashMap<>();
	
					for (final EObjectWrapper root : rootInstances) {
						targetInstancesByRoot.put(root, new LinkedList<EObjectWrapper>());
	
						// check if root node itself is a target
						for (final EObjectWrapper t : targetInstances) {
							if (t.getEObject().equals(root.getEObject())) {
								targetInstancesByRoot.get(root).add(root);
								targetInstances.remove(t);
								break;
							}
						}
	
						// check root node's contents
						final TreeIterator<EObject> it1 = root.getEObject().eAllContents();
						while (it1.hasNext() && !(sourceInstances.size() == 0 && targetInstances.size() == 0)) {
							final EObject next = it1.next();
	
							boolean found = false;
	
							for (final EObjectWrapper h : sourceInstances) {
								if (h.getEObject().equals(next)) {
									rootBySourceInstance.put(h, root);
									sourceInstances.remove(h);
									found = true;
									break;
								}
							}
	
							if (!found) {
								for (final EObjectWrapper t : targetInstances) {
									if (t.getEObject().equals(next)) {
										targetInstancesByRoot.get(root).add(t);
										targetInstances.remove(t);
										break;
									}
								}
	
							}
						}
					}
					// now select targetInstance for each source
					// instance
					for (final EObjectWrapper source : rootBySourceInstance.keySet()) {
						final List<EObjectWrapper> instances = targetInstancesByRoot
								.get(rootBySourceInstance.get(source));
						if (instances.size() == 1) {
							if (!targetSectionClass.isLibraryEntry()) {
								addValueToReference(ref, instances.get(0).getEObject(), source.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(source).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
								ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
										.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
								@SuppressWarnings("unchecked")
								AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
								.getOriginalParameter();
								originalParam.setTarget(instances.get(0).getEObject());
							}
						} else if (instances.size() > 1) {
							// Dialog
							if (canceled) {
								return;
							}
	
							/*
							 * Consult the specified resolving strategy to
							 * resolve the ambiguity.
							 */
							List<EObject> targets = new ArrayList<>();
							try {
								List<EObjectWrapper> resolved = ambiguityResolvingStrategy.linkingSelectTargetInstance(
										instances, ref, (MappingHintGroupType) mappingGroup, null, source);
								if (ref.getEReference().isMany()) {
									for (EObjectWrapper eObjectWrapper : resolved) {
										targets.add(eObjectWrapper.getEObject());
									}
								} else {
									targets.add(resolved.get(0).getEObject());
								}
							} catch (Exception e) {
								consoleStream.println(e.getMessage());
								cancel();
								return;
							}
	
							// final
							// GenericItemSelectorDialogRunner<EObjectWrapper>
							// dialog = new
							// GenericItemSelectorDialogRunner<>(
							// "There was more than one target element
							// found for the NonContainmmentReference '"
							// + ref.getName()
							// + "' of TargetMMSection "
							// + groupTargetSection.getName()
							// + "(Section: "
							// + targetSectionClass.getName()
							// + ") in Mapping "
							// + mappingName
							// + "(Group: "
							// + group.getName()
							// + ") ."
							// + "Please select a target element for the
							// following source:\n"
							// + source.toString(),
							// instances, 0);
							// Display.getDefault().syncExec(dialog);
							//
							// if
							// (dialog.wasTransformationStopRequested())
							// {
							// canceled = true;
							// return;
							// }
							if (!targetSectionClass.isLibraryEntry()) {
								addValuesToReference(ref, targets, source.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(source).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
								ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
										.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
								@SuppressWarnings("unchecked")
								AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
								.getOriginalParameter();
								// library entries do currently not
								// support to set multiple target
								// instances for an
								// ExternalReferenceParameter
								originalParam.setTarget(targets.get(0));
							}
	
						} else {
							consoleStream.println("No suitable refernce target found for non-cont. reference '"
									+ ref.getName() + "' of the following instance of target class "
									+ targetSectionClass.getName() + " (Section: "
									+ targetSectionClass.getContainingSection().getName() + ").'\n"
									+ source.toString());
						}
	
					}
					/*
					 * consider all available instances of the ref target
					 */
				} else {
					final LinkedHashMap<String, EObjectWrapper> targetInstancesToConsider = new LinkedHashMap<>();
					final LinkedList<String> targetSectionChoices = new LinkedList<>();
					final LinkedList<List<String>> instanceChoices = new LinkedList<>();
	
					for (final TargetSectionClass v : refValueClone) {
						final String classString = v.getName() + " (Section: " + v.getContainingSection().getName()
								+ ")";
						final List<EObjectWrapper> insts = targetSectionRegistry.getFlattenedPamtramClassInstances(v);
	
						if (insts.size() > 0) {
							targetSectionChoices.add(classString);
							final LinkedList<String> choices = new LinkedList<>();
							for (final EObjectWrapper i : insts) {
								final String description = i.toString();
								targetInstancesToConsider.put(description, i);
								choices.add(description);
							}
							instanceChoices.add(choices);
						}
					}
	
					// the EObjectWrapper that will be set as target of
					// the non-containment reference
					List<EObject> targets = null;
	
					if (targetInstancesToConsider.values().size() == 1) {
	
						targets = Arrays.asList(targetInstancesToConsider.values().iterator().next().getEObject());
	
					} else if (targetInstancesToConsider.values().size() > 1) {
	
						if (canceled) {
							return;
						}
	
						/*
						 * Consult the specified resolving strategy to resolve
						 * the ambiguity.
						 */
						HashMap<TargetSectionClass, List<EObjectWrapper>> choices = new HashMap<>();
						for (TargetSectionClass targetSection : refValueClone) {
							choices.put(targetSection, new ArrayList<>(
									targetSectionRegistry.getFlattenedPamtramClassInstances(targetSection)));
						}
						try {
							consoleStream.println(RESOLVE_LINKING_AMBIGUITY_STARTED);
							HashMap<TargetSectionClass, List<EObjectWrapper>> resolved = ambiguityResolvingStrategy
									.linkingSelectTargetSectionAndInstance(choices, ref,
											(MappingHintGroupType) mappingGroup);
							consoleStream.println(RESOLVE_LINKING_AMBIGUITY_FINISHED);
							if (ref.getEReference().isMany()) {
								targets = new ArrayList<>();
								for (EObjectWrapper eObjectWrapper : resolved.entrySet().iterator().next().getValue()) {
									targets.add(eObjectWrapper.getEObject());
								}
							} else {
								targets = new ArrayList<>(Arrays.asList(
										(resolved.entrySet().iterator().next().getValue().get(0).getEObject())));
							}
						} catch (Exception e) {
							consoleStream.println(e.getMessage());
							cancel();
							return;
						}
	
					} else {
						consoleStream.println("No suitable hint targets found for non-cont reference '" + ref.getName()
						+ "' of TargetMMSection " + mappingGroup.getTargetMMSectionGeneric().getName()
						+ "(Section: " + targetSectionClass.getName() + ") in Mapping "
						+ ((Mapping) mappingGroup.eContainer()).getName() + "(Group: " + mappingGroup.getName()
						+ ").");
					}
	
					if (targets != null) {
						for (final EObjectWrapper inst : instancesBySection.get(targetSectionClass)) {
							if (!targetSectionClass.isLibraryEntry()) {
								addValuesToReference(ref, targets, inst.getEObject());
							} else {
								/*
								 * for library entries, we cannot simply add the
								 * value as the reference we are handling is not
								 * part of the targetSectionClass; instead we
								 * want to specify the value as 'target' for the
								 * affected ExternalReferenceParameter
								 */
								LibraryEntry specificLibEntry = libEntryInstantiatorMap.get(inst).getLibraryEntry();
								LibraryEntry genericLibEntry = (LibraryEntry) targetSectionClass.eContainer()
										.eContainer();
								ExternalReferenceParameter extRefParam = (ExternalReferenceParameter) specificLibEntry
										.getParameters().get(genericLibEntry.getParameters().indexOf(ref.eContainer()));
								@SuppressWarnings("unchecked")
								AbstractExternalReferenceParameter<EObject, EObject> originalParam = (AbstractExternalReferenceParameter<EObject, EObject>) extRefParam
								.getOriginalParameter();
								// library entries do currently not
								// support to set multiple target
								// instances for an
								// ExternalReferenceParameter
								originalParam.setTarget(targets.get(0));
							}
						}
					}
	
				}
	
			}
		}
	
		instantiateTargetSectionSecondPassGoDeeper(targetSectionClass, mappingGroup, mappingHints, hintValues,
				instancesBySection);
	}

	/**
	 * This iterates further downward in the containment hierarchy and calls
	 * {@link #instantiateTargetSectionSecondPass(TargetSectionClass, InstantiableMappingHintGroup, List, HintValueStorage, Map)}
	 * for every found child {@link TargetSectionClass}.
	 * 
	 * @param targetSectionClass
	 *            The {@link TargetSectionClass} from where to iterate further
	 *            downward in the containment hierarchy.
	 * @param mappingGroup
	 *            The {@link InstantiableMappingHintGroup} based on which the
	 *            TargetSection gets instantiated.
	 * @param hints
	 *            The list of {@link MappingHint MappingHints} to take into
	 *            account (in case we are dealing with an
	 *            {@link MappingHintGroupImporter}, this needs to cover
	 *            <em>local</em> hints as well as
	 *            {@link ExportedMappingHintGroup imported hints}).
	 * @param hintValues
	 *            The {@link HintValueStorage hint values} to take into account.
	 * @param instancesBySection
	 *            The registry for {@link EObjectWrapper instances} created
	 *            during the first pass of the instantiation.
	 */
	private void instantiateTargetSectionSecondPassGoDeeper(
			final TargetSectionClass targetSectionClass,
			final InstantiableMappingHintGroup mappingGroup,
			final List<MappingHint> hints,
			final HintValueStorage hintValues,
			final Map<TargetSectionClass, List<EObjectWrapper>> instancesBySection) {
	
		for (final TargetSectionReference ref : targetSectionClass.getReferences()) {
	
			if (ref instanceof TargetSectionContainmentReference) {
	
				for (final TargetSectionClass val : ((TargetSectionContainmentReference) ref).getValue()) {// instantiate
					// targets
	
					instantiateTargetSectionSecondPass(val, mappingGroup,
							hints, hintValues,
							instancesBySection);
	
					if (canceled) {
						return;
					}
				}
			}
	
		}
	}

	/**
	 * This creates a link from the given {@link EObject source element} to the given {@link EObject target element}
	 * via the non-containment reference specified by the given {@link TargetSectionNonContainmentReference}.
	 *
	 * @param ref The {@link TargetSectionNonContainmentReference} that specifies the {@link EReference} to be used
	 * to create the link.
	 * @param target The {@link EObject} to be linked to the <em>source</em> via the given reference.
	 * @param source The {@link EObject} being the source of the link to be created.
	 */
	private void addValueToReference(
			final TargetSectionNonContainmentReference ref,
			final EObject target, final EObject source) {
	
		if (ref.getEReference().getUpperBound() == 1) {
			if (source.eIsSet(ref.getEReference())) {
	
				consoleStream.println("More than one value was supposed to be connected to the TargetSectionNonContainmentReference '"
						+ ref.getName()
						+ "' in the target section '"
						+ ref.getContainingSection()
						+ "Please check your mapping model.");
	
			} else {
				source.eSet(ref.getEReference(), target);
			}
	
		} else {
	
			@SuppressWarnings("unchecked")
			final EList<EObject> oldRefs = (EList<EObject>) source.eGet(ref.getEReference());
			final LinkedList<EObject> newRefs = new LinkedList<>();
			if (oldRefs != null) {
				newRefs.addAll(oldRefs);
			}
			newRefs.add(target);
			source.eSet(ref.getEReference(), newRefs);
	
		}
	}

	/**
	 * This creates a link from the given {@link EObject source element} to the given list of {@link EObject target elements}
	 * via the non-containment reference specified by the given {@link TargetSectionNonContainmentReference}.
	 *
	 * @param ref The {@link TargetSectionNonContainmentReference} that specifies the {@link EReference} to be used
	 * to create the link.
	 * @param targets The {@link EObject EObjects} to be linked to the <em>source</em> via the given reference.
	 * @param source The {@link EObject} being the source of the link to be created.
	 */
	private void addValuesToReference(
			final TargetSectionNonContainmentReference ref,
			final List<EObject> targets, final EObject source) {
	
		if (ref.getEReference().getUpperBound() == 1) {
			if(targets.size() > 1) {
	
				consoleStream.println("More than one value was supposed to be connected to the TargetSectionNonContainmentReference '"
						+ ref.getName()
						+ "' in the target section '"
						+ ref.getContainingSection()
						+ "Please check your mapping model.");
			} else {
	
				addValueToReference(ref, targets.get(0), source);
			}
	
		} else {
	
			@SuppressWarnings("unchecked")
			final EList<EObject> oldRefs = (EList<EObject>) source.eGet(ref.getEReference());
			final LinkedList<EObject> newRefs = new LinkedList<>();
			if (oldRefs != null) {
				newRefs.addAll(oldRefs);
			}
			newRefs.addAll(targets);
			source.eSet(ref.getEReference(), newRefs);
	
		}
	}

}
