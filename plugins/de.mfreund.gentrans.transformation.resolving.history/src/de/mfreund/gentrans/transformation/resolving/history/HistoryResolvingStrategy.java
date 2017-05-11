package de.mfreund.gentrans.transformation.resolving.history;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.descriptors.MatchedSectionDescriptor;
import de.mfreund.gentrans.transformation.descriptors.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import de.tud.et.ifa.agtele.emf.compare.EMFComparatorFactory;
import pamtram.PAMTraM;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingHintGroup;
import pamtram.mapping.MappingHintGroupImporter;
import pamtram.mapping.MappingHintGroupType;
import pamtram.mapping.MappingType;
import pamtram.mapping.extended.ContainerSelector;
import pamtram.mapping.extended.ReferenceTargetSelector;
import pamtram.structure.library.LibraryPackage;
import pamtram.structure.target.TargetSection;
import pamtram.structure.target.TargetSectionClass;
import pamtram.structure.target.TargetSectionCrossReference;

/**
 * This class implements a concrete {@link ComposedAmbiguityResolvingStrategy}
 * that consults previous resolving results in order to resolve ambiguities and
 * additionally can compose multiple other resolving strategies.
 * <p />
 * Any call to a method defined by the {@link IAmbiguityResolvingStrategy}
 * interface will first check if a previous resolving result is present for the
 * given configuration. If this is the case, it uses this result; otherwise, it
 * iteratively forwards the call to every of the {@link #composedStrategies} and
 * returns the final result. The result is also stored for future ambiguity
 * evaluation requests.
 *
 * @author mfreund
 */
public class HistoryResolvingStrategy extends ComposedAmbiguityResolvingStrategy {

	/**
	 * This prefix will be added to {@link #printMessage(String, String)
	 * messages} printed after successfully resolving an ambiguity.
	 */
	private static final String historyDecisionPrefix = "History";

	/**
	 * The path to the {@link Transformation TransformationModel} to be used to
	 * consult previous resolving results
	 */
	private String transformationModelPath;

	/**
	 * The {@link Transformation TransformationModel} to be used to consult
	 * previous resolving results.
	 */
	private Transformation transformationModel;

	/**
	 * This will contain the results of the comparison process between the
	 * current PAMTraM models and the 'old' PAMTraM models that are part of the
	 * {@link #transformationModel}.
	 * <p />
	 * Note: The <em>left</em> sides of these comparisons represents the current
	 * PAMTraM models, the <em>right</em> side represents the 'old' models (part
	 * of the transformation model).
	 */
	private List<Comparison> pamtramCompareResults;

	/**
	 * This will contain a list of results of the comparison processes between
	 * the current source models and the 'old' source models that are part of
	 * the {@link #transformationModel}.
	 * <p />
	 * Note: The <em>left</em> sides of these comparisons represent the current
	 * source models, the <em>right</em> sides represent the 'old' models (part
	 * of the transformation model).
	 */
	private List<Comparison> sourceCompareResults;

	/**
	 * This map is filled once during the
	 * {@link #init(PAMTraM, ArrayList, Logger)} method and contains
	 * associations between {@link TargetSection TargetSections} and lists of
	 * {@link TransformationMappingHintGroup TransformationMappingHintGroups}
	 * that are contained in the {@link #transformationModel}. It can be used to
	 * retrieve all hint groups from the transformation model that were
	 * responsible for instantiating a certain target section.
	 */
	private Map<TargetSection, List<TransformationMappingHintGroup>> targetSectionToTransformationHintGroups;

	private HistoryResolvingStrategy(ArrayList<IAmbiguityResolvingStrategy> composedStrategies) {
		super(composedStrategies);
	}

	/**
	 * This creates an instance.
	 *
	 * @param composedStrategies
	 *            The list of {@link IAmbiguityResolvingStrategy strategies}
	 *            that this composes.
	 * @param transformationModelPath
	 *            The path to the {@link Transformation TransformationModel} to
	 *            be used to consult previous resolving results.
	 */
	public HistoryResolvingStrategy(ArrayList<IAmbiguityResolvingStrategy> composedStrategies,
			String transformationModelPath) {
		this(composedStrategies);
		this.transformationModelPath = transformationModelPath;
	}

	@Override
	public void init(List<PAMTraM> pamtramModels, List<EObject> sourceModels, Logger logger)
			throws AmbiguityResolvingException {

		super.init(pamtramModels, sourceModels, logger);

		/*
		 * load the transformation model to be used by this strategy
		 */
		try {
			this.loadTransformationModel();
		} catch (IOException e) {
			throw new AmbiguityResolvingException("An exception occurred while loading the transformation model. ", e);
		}

		/*
		 * compare old and new models
		 */
		this.pamtramCompareResults = new ArrayList<>();
		this.sourceCompareResults = new ArrayList<>();

		try {
			this.comparePamtramModels();
		} catch (IOException e) {
			throw new AmbiguityResolvingException("An exception occurred while comparing the PAMTraM models.", e);
		}

		try {
			this.compareSourceModels();
		} catch (IOException e) {
			throw new AmbiguityResolvingException("An exception occurred while comparing the source models.", e);
		}

		/*
		 * initialize 'targetSectionToTransformationHintGroups' map
		 */
		this.buildTargetSectionToTransformationHintGroupMap();
	}

	/**
	 * Fill the {@link #targetSectionToTransformationHintGroups} map by
	 * iterating over the transformation model.
	 */
	private void buildTargetSectionToTransformationHintGroupMap() {

		this.targetSectionToTransformationHintGroups = new HashMap<>();
		for (TransformationMapping transformationMapping : this.transformationModel.getTransformationMappings()) {
			for (TransformationMappingHintGroup transformationHintGroup : transformationMapping
					.getTransformationHintGroups()) {
				MappingHintGroupType hintGroup = null;
				if (transformationHintGroup.getAssociatedMappingHintGroup() instanceof MappingHintGroup) {
					hintGroup = (MappingHintGroup) transformationHintGroup.getAssociatedMappingHintGroup();
				} else if (transformationHintGroup
						.getAssociatedMappingHintGroup() instanceof MappingHintGroupImporter) {
					hintGroup = ((MappingHintGroupImporter) transformationHintGroup.getAssociatedMappingHintGroup())
							.getHintGroup();
				} else {
					continue;
				}
				TargetSection section = hintGroup.getTargetSection();
				if (section == null) {
					continue;
				}
				List<TransformationMappingHintGroup> hintGroups = new ArrayList<>();
				if (this.targetSectionToTransformationHintGroups.containsKey(section)) {
					hintGroups = this.targetSectionToTransformationHintGroups.get(section);
				}
				hintGroups.add(transformationHintGroup);
				this.targetSectionToTransformationHintGroups.put(section, hintGroups);

			}
		}
	}

	/**
	 * Load the {@link #transformationModel} from the given
	 * {@link #transformationModelPath}.
	 *
	 * @throws IOException
	 */
	private void loadTransformationModel() throws IOException {

		/*
		 * We need to load the transformation model to the same ResourceSet as
		 * the pamtram models, otherwise strange things happen in the EMFcompare
		 * process (changes are shown even nothing has changed).
		 */
		ResourceSet resourceSet = this.pamtramModels.get(0).eResource().getResourceSet();

		// the URI of the transformation model resource
		final URI transformationModelUri = URI.createPlatformResourceURI(this.transformationModelPath, true);

		// load the transformation model
		XMIResource transformationModelResource = (XMIResource) resourceSet.getResource(transformationModelUri, true);
		transformationModelResource.load(Collections.EMPTY_MAP);
		if (!(transformationModelResource.getContents().get(0) instanceof Transformation)) {
			throw new RuntimeException("The transformation model does not contain a stored transformation.");
		}
		this.printMessage("Transformation model successfully loaded from path: " + this.transformationModelPath);
		this.transformationModel = (Transformation) transformationModelResource.getContents().get(0);

	}

	/**
	 * Compare both PAMTraM models (the one stored as part of the
	 * {@link #transformationModel} and the {@link #pamtramModel}) and store the
	 * result in the {@link #pamtramCompareResult} field.
	 *
	 * @throws IOException
	 *             If one of the involved resources cannot be (re)loaded.
	 */
	private void comparePamtramModels() throws IOException {

		ResourceSet resourceSet = this.transformationModel.eResource().getResourceSet();

		for (int i = 0; i < this.transformationModel.getPamtramInstances().size(); i++) {

			PAMTraM pamtramInstance = this.transformationModel.getPamtramInstances().get(i);

			/*
			 * We need to reload the pamtram resource that is part of the
			 * transformation model as otherwise the compare process will show
			 * strange differences even if there should not be any. TODO This
			 * might have to do something with the cross-resource containments
			 * and proxy resolving...
			 */
			URI pamtramUri = pamtramInstance.eResource().getURI();
			XMIResource pamtramResource = (XMIResource) resourceSet.getResource(pamtramUri, true);
			pamtramResource.unload(); // reload the resource as the compare
										// process
			// will show strange differences otherwise
			pamtramResource.load(Collections.EMPTY_MAP);

			/*
			 * Compare the Pamtram resources
			 */
			IComparisonScope scope = new DefaultComparisonScope(this.pamtramModels.get(i).eResource(), pamtramResource,
					null);
			EMFCompare comparator = EMFComparatorFactory.getComparator(new DefaultDiffEngine(new DiffBuilder()) {

				@Override
				protected FeatureFilter createFeatureFilter() {

					return new FeatureFilter() {

						@Override
						protected boolean isIgnoredReference(Match match, EReference reference) {

							/*
							 * We forget about the 'source' reference of library
							 * parameters as the comparison process will report
							 * false changes to references of this type as the
							 * referenced objects are not contained in the
							 * resource in focus (cf.
							 * https://www.eclipse.org/emf/compare/
							 * documentation/
							 * latest/developer/developer-guide.html#
							 * Changing_the_FeatureFilter).
							 */
							return reference.equals(LibraryPackage.Literals.LIBRARY_PARAMETER__SOURCE)
									|| super.isIgnoredReference(match, reference);
						}

						@Override
						public boolean checkForOrderingChanges(EStructuralFeature feature) {

							return false;
						}
					};
				}
			});
			this.pamtramCompareResults.add(comparator.compare(scope));
		}

	}

	/**
	 * Compare the source models (those stored as part of the
	 * {@link #transformationModel} and the {@link #sourceModels}) and store the
	 * results in the {@link #pamtramCompareResult} field.
	 *
	 * @throws IOException
	 *             If one of the involved resources cannot be (re)loaded.
	 */
	private void compareSourceModels() throws IOException {

		ResourceSet resourceSet = this.transformationModel.eResource().getResourceSet();

		/*
		 * Compare the source models (only if the number of models match)
		 */
		if (this.sourceModels.size() == this.transformationModel.getSourceModels().size()) {

			for (int i = 0; i < this.sourceModels.size(); i++) {
				URI sourceUri = this.transformationModel.getSourceModels().get(i).eResource().getURI();
				XMLResource sourceResource = (XMLResource) resourceSet.getResource(sourceUri, true);
				sourceResource.unload(); // reload the resource as the compare
											// process will show strange
											// differences
				sourceResource.load(Collections.EMPTY_MAP);

				IComparisonScope sourceScope = new DefaultComparisonScope(this.sourceModels.get(i).eResource(),
						sourceResource, null);
				EMFCompare sourceComparator = EMFComparatorFactory.getComparator(null);

				this.sourceCompareResults.add(sourceComparator.compare(sourceScope));

			}
		}

	}

	/**
	 * This is a convenience method to find a match for the given source model
	 * element in one of the stored {@link #sourceCompareResults}. This method
	 * simply iterates over all compare results.
	 *
	 * @param objectToMatch
	 *            An element from a source model for that a match shall be
	 *            found.
	 * @return The {@link Match} for the given source model element or
	 *         '<em>null</em>' if no match could be found.
	 */
	private Match getSourceModelMatch(EObject objectToMatch) {

		Match foundMatch = null;

		/*
		 * Iterate over all of the stored 'sourceCompareResults' and try to find
		 * a match for the given 'objectToMatch'.
		 */
		for (Comparison compareResult : this.sourceCompareResults) {
			foundMatch = compareResult.getMatch(objectToMatch);
			if (foundMatch != null) {
				break;
			}
		}

		return foundMatch;
	}

	/**
	 * Consult the list of {@link TransformationMapping TransformationMappings}
	 * stored in the {@link #transformationModel} in order to retrieve the
	 * corresponding selection for the given list of choices. If a corresponding
	 * choice is found, reuse it; otherwise, forward the decision to the list of
	 * {@link ComposedAmbiguityResolvingStrategy#composedStrategies}.
	 */
	@Override
	public List<MatchedSectionDescriptor> searchingSelectSection(List<MatchedSectionDescriptor> choices,
			EObject element) throws AmbiguityResolvingException {

		/*
		 * First, we need to check if we can find a match for the given
		 * 'element'.
		 */
		Match match = this.getSourceModelMatch(element);
		if (match == null || match.getRight() == null) {
			return super.searchingSelectSection(choices, element);
		}

		// the matched element from the 'old' source model
		EObject matchedElement = match.getRight();

		/*
		 * Now, we can determine the mapping that was used in the 'old'
		 * transformation.
		 */
		TransformationMapping oldTransformationMapping = null;
		for (TransformationMapping transformationMapping : this.transformationModel.getTransformationMappings()) {
			if (transformationMapping.getSourceElement().equals(matchedElement)) {
				oldTransformationMapping = transformationMapping;
				break;
			}
		}

		if (oldTransformationMapping == null) {
			return super.searchingSelectSection(choices, element);
		}

		/*
		 * Finally, we check if the list of choices is the 'same' list of
		 * choices as in the 'old' transformation (we do not want to blindly
		 * reuse a choice even if there are changes in the list of mappings that
		 * we can choose from). Currently, we do this by simply checking that
		 * nothing has been changed in the PAMTraM and source models but this
		 * might be done in a more clever way in the future.
		 */
		for (Comparison comparison : this.pamtramCompareResults) {
			if (!comparison.getDifferences().isEmpty()) {
				return super.searchingSelectSection(choices, element);
			}
		}
		for (Comparison comparison : this.sourceCompareResults) {
			if (!comparison.getDifferences().isEmpty()) {
				return super.searchingSelectSection(choices, element);
			}
		}

		/*
		 * Now, we are sure that the current list of choices matches the old one
		 * (and thus that the 'old' choice is also an option in the current list
		 * of choices). Thus, we may safely reuse the old choice.
		 */
		Match sectionMatch = this.getMatch(oldTransformationMapping.getAssociatedMapping().getSourceSection());
		Optional<MatchedSectionDescriptor> descriptor = choices.parallelStream()
				.filter(m -> m.getAssociatedSourceSectionClass().equals(sectionMatch.getLeft())).findAny();

		if (!descriptor.isPresent()) {
			return super.searchingSelectSection(choices, element);
		}

		this.printMessage(descriptor.get().getAssociatedSourceSectionClass().getName(),
				HistoryResolvingStrategy.historyDecisionPrefix);
		return Arrays.asList(descriptor.get());
	}

	/**
	 * Consult the list of {@link TransformationMapping TransformationMappings}
	 * stored in the {@link #transformationModel} in order to retrieve the
	 * corresponding selection for the given list of choices. If a corresponding
	 * choice is found, reuse it; otherwise, forward the decision to the list of
	 * {@link ComposedAmbiguityResolvingStrategy#composedStrategies}.
	 */
	@Override
	public List<Mapping> searchingSelectMapping(List<Mapping> choices, EObject element)
			throws AmbiguityResolvingException {

		/*
		 * First, we need to check if we can find a match for the given
		 * 'element'.
		 */
		Match match = this.getSourceModelMatch(element);
		if (match == null || match.getRight() == null) {
			return super.searchingSelectMapping(choices, element);
		}

		// the matched element from the 'old' source model
		EObject matchedElement = match.getRight();

		/*
		 * Now, we can determine the mappings that were used in the 'old'
		 * transformation.
		 */
		List<TransformationMapping> oldTransformationMappings = this.transformationModel.getTransformationMappings()
				.parallelStream().filter(t -> t.getSourceElement().equals(matchedElement)).collect(Collectors.toList());

		if (oldTransformationMappings.isEmpty()) {
			return super.searchingSelectMapping(choices, element);
		}

		/*
		 * Finally, we check if the list of choices is the 'same' list of
		 * choices as in the 'old' transformation (we do not want to blindly
		 * reuse a choice even if there are changes in the list of mappings that
		 * we can choose from).
		 */
		EList<MappingType> oldChoices = oldTransformationMappings.get(0).getAssociatedMapping().getSourceSection()
				.getReferencingMappings();
		ArrayList<MappingType> oldChoicesWithoutDeactivated = new ArrayList<>(oldChoices);
		for (MappingType oldChoice : oldChoices) {
			// sort out deactivated elements
			if (oldChoice.isDeactivated()) {
				oldChoicesWithoutDeactivated.remove(oldChoice);
			}
		}
		if (oldChoicesWithoutDeactivated.size() != choices.size()) {
			return super.searchingSelectMapping(choices, element);
		}
		for (MappingType oldChoice : oldChoicesWithoutDeactivated) {
			// find a matching 'new' choice
			Match matchingNewChoice = this.getMatch(oldChoice);
			if (matchingNewChoice == null || matchingNewChoice.getLeft() == null
					|| !(matchingNewChoice.getLeft() instanceof Mapping)
					|| !choices.contains(matchingNewChoice.getLeft())) {
				return super.searchingSelectMapping(choices, element);
			}
		}

		/*
		 * Now, we are sure that the current list of choices matches the old one
		 * (and thus that the 'old' choice is also an option in the current list
		 * of choices). Thus, we may safely reuse the old choice.
		 */
		List<Mapping> ret = new ArrayList<>();
		for (TransformationMapping oldTransformationMapping : oldTransformationMappings) {

			Match mappingMatch = this.getMatch(oldTransformationMapping.getAssociatedMapping());
			if (mappingMatch == null || mappingMatch.getLeft() == null
					|| !(mappingMatch.getLeft() instanceof Mapping)) {
				return super.searchingSelectMapping(choices, element);
			}
			ret.add((Mapping) mappingMatch.getLeft());
		}
		this.printMessage(String.join(";", ret.stream().map(Mapping::getName).collect(Collectors.toList())),
				HistoryResolvingStrategy.historyDecisionPrefix);
		return ret;

	}

	/**
	 * This consults the {@link #transformationModel} in order to determine
	 * which of the given '<em>choices</em>' was used during the 'old'
	 * transformation for joining the given '<em>section</em>'.
	 */
	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws AmbiguityResolvingException {

		/*
		 * First, we need to check if we can find a match for the given
		 * 'section'.
		 */
		Match match = this.getMatch(section);
		if (match == null || match.getRight() == null || !(match.getRight() instanceof TargetSection)) {
			return super.joiningSelectConnectionPath(choices, section);
		}

		// the matched section from the 'old' pamtram model
		TargetSection matchedSection = (TargetSection) match.getRight();

		/*
		 * Now, we try to determine an element from the 'old' target model that
		 * represents the found 'matchedSection'. Therefore, we get a
		 * TransformationHintGroup of which the associated MappingHintGroup was
		 * responsible for instantiating the 'matchedSection' from the map
		 * 'targetSectionToTransformationHintGroups'. That way, we can determine
		 * the instantiated ModelConnectionPath from the source model. Thereby,
		 * it should not be relevant which of the (possible multiple)
		 * TransformationHintGroups we determine as all should lead to the same
		 * result. Thus, we simply get the first one.
		 */
		if (!this.targetSectionToTransformationHintGroups.containsKey(matchedSection)) {
			return super.joiningSelectConnectionPath(choices, section);
		}
		EObject instantiatedElement = this.targetSectionToTransformationHintGroups.get(matchedSection).get(0)
				.getTargetElements().get(0);

		if (instantiatedElement == null) {
			return super.joiningSelectConnectionPath(choices, section);
		}

		/*
		 * Finally, we can check which ModelConnectionPath was used to connect
		 * the 'instantiatedElement'.
		 */
		ModelConnectionPath usedPath = null;
		for (ModelConnectionPath modelConnectionPath : choices) {

			usedPath = modelConnectionPath;

			/*
			 * Iterate over every element of the path and check if it was used
			 * to connect the given 'instantiatedElement'.
			 */
			EObject currentElement = instantiatedElement;
			Iterator<EObject> pathElementIterator = modelConnectionPath.getPathElements().iterator();
			while (pathElementIterator.hasNext()) {
				EObject pathElement = pathElementIterator.next();
				if (pathElement instanceof EClass) {
					if (!currentElement.eClass().equals(pathElement)) {
						usedPath = null;
						break;
					}
				} else if (pathElement instanceof EReference) {
					if (!currentElement.eContainingFeature().equals(pathElement)) {
						usedPath = null;
						break;
					} else {
						currentElement = currentElement.eContainer();
					}
				}
			}
			// we have found our path
			if (usedPath != null) {
				break;
			}
		}

		if (usedPath == null) {
			return super.joiningSelectConnectionPath(choices, section);
		} else {
			this.printMessage(usedPath.toString(), HistoryResolvingStrategy.historyDecisionPrefix);
			return Arrays.asList(usedPath);
		}

	}

	/**
	 * This consults the {@link #transformationModel} in order to determine
	 * which of the given '<em>choices</em>' was used during the 'old'
	 * transformation for joining the given '<em>element</em>'.
	 */
	@Override
	public List<EObjectWrapper> joiningSelectContainerInstance(List<EObjectWrapper> choices,
			List<EObjectWrapper> element, MappingHintGroupType hintGroup, ContainerSelector modelConnectionHint,
			String hintValue) throws AmbiguityResolvingException {

		/*
		 * First, we need to check if we can find a match for the given
		 * 'section' and 'hintGroup'.
		 */
		Match sectionMatch = this.getMatch(hintGroup.getTargetSection());
		Match hintGroupMatch = this.getMatch(hintGroup);
		if (sectionMatch == null || sectionMatch.getRight() == null
				|| !(sectionMatch.getRight() instanceof TargetSection) || hintGroupMatch == null
				|| hintGroupMatch.getRight() == null || !(hintGroupMatch.getRight() instanceof MappingHintGroupType)) {
			return super.joiningSelectContainerInstance(choices, element, hintGroup, modelConnectionHint, hintValue);
		}

		// the matched section/hintGroup from the 'old' pamtram model
		TargetSection matchedSection = (TargetSection) sectionMatch.getRight();
		MappingHintGroupType matchedHintGroup = (MappingHintGroupType) hintGroupMatch.getRight();

		/*
		 * Now, we determine the elements from the 'old' target model that
		 * correspond to the given 'sectionInstances'. Therefore, we make use of
		 * the map 'targetSectionToTransformationHintGroups' and collect all
		 * instantiated target elements from all TransformationMappingHintGroups
		 * that represent the given 'hintGroup' (and thus the given 'section').
		 */
		if (!this.targetSectionToTransformationHintGroups.containsKey(matchedSection)) {
			return super.joiningSelectContainerInstance(choices, element, hintGroup, modelConnectionHint, hintValue);
		}
		List<EObject> oldSectionInstances = new ArrayList<>();
		for (TransformationMappingHintGroup transformationMappingHintGroup : this.targetSectionToTransformationHintGroups
				.get(matchedSection)) {

			/*
			 * As only 'InstantiableHintGroups' are stored in the transformation
			 * model whereas the given 'matchedHintGroup' is of type
			 * 'MappingHintGroupType' we need to determine the corresponding
			 * 'MappingHintGroupType' for each 'transformationMappingHintGroup'.
			 */
			MappingHintGroupType mappingHintGroupType = null;
			if (transformationMappingHintGroup.getAssociatedMappingHintGroup() instanceof MappingHintGroup) {
				mappingHintGroupType = (MappingHintGroupType) transformationMappingHintGroup
						.getAssociatedMappingHintGroup();
			} else if (transformationMappingHintGroup
					.getAssociatedMappingHintGroup() instanceof MappingHintGroupImporter) {
				mappingHintGroupType = ((MappingHintGroupImporter) transformationMappingHintGroup
						.getAssociatedMappingHintGroup()).getHintGroup();
			}
			if (mappingHintGroupType != null && mappingHintGroupType.equals(matchedHintGroup)) {
				oldSectionInstances.addAll(transformationMappingHintGroup.getTargetElements());
			}

		}

		/*
		 * Now, we determine one of the 'oldSectionInstances' that actually
		 * represents one of the current 'sectionInstances' by comparing them
		 * ('oldSectionInstances' might represent more elements than
		 * 'sectionInstances' does as this method is called multiple times). As
		 * all of the 'sectionInstances' should be connected to the same
		 * element, we examplarily use only the first of the 'sectionInstances'.
		 * However, if we find multiple matches (part of the old transformation)
		 * for this one 'sectionInstance', we must not proceed as we cannot
		 * guarantee that those did not result from different choices. In that
		 * case, we try to determine another 'sectionInstance' for that we can
		 * determine a unique match.
		 */
		EObject oldSectionInstanceToUse = null;

		// create a comparator first
		EMFCompare comparator = EMFComparatorFactory.getIgnoreAllReferenceChangesComparator();

		for (int i = 0; i < element.size(); i++) {
			for (EObject oldSectionInstance : oldSectionInstances) {
				IComparisonScope scope = new DefaultComparisonScope(element.get(i).getEObject(), oldSectionInstance,
						null);
				Comparison comparison = comparator.compare(scope);
				Match match = comparison.getMatch(element.get(0).getEObject());
				if (match == null || match.getRight() == null) {
					continue;
				}
				if (match.getDifferences().isEmpty()) {
					if (oldSectionInstanceToUse != null) {
						// we have found another match so that we need to try to
						// find a unique match for one of the
						// other choices
						oldSectionInstanceToUse = null;
						break;
					} else {
						// we have found a matching instance that could be used
						oldSectionInstanceToUse = oldSectionInstance;
					}
				}
			}
			if (oldSectionInstanceToUse != null) {
				// we have found a unique match
				break;
			}
		}
		if (oldSectionInstanceToUse == null) {
			return super.joiningSelectContainerInstance(choices, element, hintGroup, modelConnectionHint, hintValue);
		}

		/*
		 * Finally, we can check which Instance was used to connect the
		 * 'oldSectionInstanceToUse'. Therefore, we iterate upward in the
		 * containment hierarchy and compare the elements along this path to the
		 * possible 'containerInstances'.
		 */
		EObject sectionInstanceContainer = oldSectionInstanceToUse;
		ArrayList<EObjectWrapper> containerInstancesToUse = new ArrayList<>();
		while ((sectionInstanceContainer = sectionInstanceContainer.eContainer()) != null) {
			for (EObjectWrapper containerInstance : choices) {
				IComparisonScope scope = new DefaultComparisonScope(containerInstance.getEObject(),
						sectionInstanceContainer, null);
				Comparison comparison = comparator.compare(scope);
				Match match = comparison.getMatch(sectionInstanceContainer);
				if (match == null || match.getLeft() == null) {
					continue;
				}
				if (match.getDifferences().isEmpty()) {
					// we have found a matching instance that can be used
					containerInstancesToUse.add(containerInstance);
				}
			}
			if (!containerInstancesToUse.isEmpty()) {
				break;
			}
		}

		if (containerInstancesToUse.isEmpty()) {
			return super.joiningSelectContainerInstance(choices, element, hintGroup, modelConnectionHint, hintValue);
		} else {
			this.printMessage(containerInstancesToUse.toString(), HistoryResolvingStrategy.historyDecisionPrefix);
			return super.joiningSelectContainerInstance(containerInstancesToUse, element, hintGroup,
					modelConnectionHint, hintValue);
		}

	}

	/**
	 * This consults the {@link #transformationModel} in order to determine
	 * which of the given '<em>choices</em>' (connection path and container
	 * instance) was used during the 'old' transformation for joining the given
	 * '<em>sectionInstances</em>'.
	 */
	@Override
	public Map<ModelConnectionPath, List<EObjectWrapper>> joiningSelectConnectionPathAndContainerInstance(
			Map<ModelConnectionPath, List<EObjectWrapper>> choices, TargetSection section,
			List<EObjectWrapper> sectionInstances, MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		/*
		 * First, we need to check if we can find a match for the given
		 * 'section' and 'hintGroup'.
		 */
		Match sectionMatch = this.getMatch(section);
		Match hintGroupMatch = this.getMatch(hintGroup);
		if (sectionMatch == null || sectionMatch.getRight() == null
				|| !(sectionMatch.getRight() instanceof TargetSection) || hintGroupMatch == null
				|| hintGroupMatch.getRight() == null || !(hintGroupMatch.getRight() instanceof MappingHintGroupType)) {
			return super.joiningSelectConnectionPathAndContainerInstance(choices, section, sectionInstances, hintGroup);
		}

		// the matched section/hintGroup from the 'old' pamtram model
		TargetSection matchedSection = (TargetSection) sectionMatch.getRight();
		MappingHintGroupType matchedHintGroup = (MappingHintGroupType) hintGroupMatch.getRight();

		/*
		 * Now, we determine the elements from the 'old' target model that
		 * correspond to the given 'sectionInstances'. Therefore, we make use of
		 * the map 'targetSectionToTransformationHintGroups' and collect all
		 * instantiated target elements from all TransformationMappingHintGroups
		 * that represent the given 'hintGroup' (and thus the given 'section').
		 */
		if (!this.targetSectionToTransformationHintGroups.containsKey(matchedSection)) {
			return super.joiningSelectConnectionPathAndContainerInstance(choices, section, sectionInstances, hintGroup);
		}
		List<EObject> oldSectionInstances = new ArrayList<>();
		for (TransformationMappingHintGroup transformationMappingHintGroup : this.targetSectionToTransformationHintGroups
				.get(matchedSection)) {

			/*
			 * As only 'InstantiableHintGroups' are stored in the transformation
			 * model whereas the given 'matchedHintGroup' is of type
			 * 'MappingHintGroupType' we need to determine the corresponding
			 * 'MappingHintGroupType' for each 'transformationMappingHintGroup'.
			 */
			MappingHintGroupType mappingHintGroupType = null;
			if (transformationMappingHintGroup.getAssociatedMappingHintGroup() instanceof MappingHintGroup) {
				mappingHintGroupType = (MappingHintGroupType) transformationMappingHintGroup
						.getAssociatedMappingHintGroup();
			} else if (transformationMappingHintGroup
					.getAssociatedMappingHintGroup() instanceof MappingHintGroupImporter) {
				mappingHintGroupType = ((MappingHintGroupImporter) transformationMappingHintGroup
						.getAssociatedMappingHintGroup()).getHintGroup();
			}
			if (mappingHintGroupType != null && mappingHintGroupType.equals(matchedHintGroup)) {
				oldSectionInstances.addAll(transformationMappingHintGroup.getTargetElements());
			}

		}

		/*
		 * Now, check if the 'old' and the current 'sectionInstances' are
		 * equivalent. Here, we simply check if the counts match - a more
		 * thorough comparison could be performed via EMFCompare but this should
		 * take quite a bit of time as we have to cross-compare every instance.
		 */
		if (oldSectionInstances.isEmpty() || oldSectionInstances.size() != sectionInstances.size()) {
			return super.joiningSelectConnectionPathAndContainerInstance(choices, section, sectionInstances, hintGroup);
		}

		/*
		 * Finally, we can check which ModelConnectionPath and Instance was used
		 * to connect the 'sectionInstances'. As all of the 'sectionInstances'
		 * should be connected to the same element (and via the same path), we
		 * examplarily use only the first of the 'sectionInstances'.
		 */
		ModelConnectionPath usedPath = null;
		EObject usedInstance = null;
		for (ModelConnectionPath modelConnectionPath : choices.keySet()) {

			usedPath = modelConnectionPath;

			/*
			 * Iterate over every element of the path and check if it was used
			 * to connect the given 'instantiatedElement'.
			 */
			EObject currentElement = oldSectionInstances.get(0);
			Iterator<EObject> pathElementIterator = modelConnectionPath.getPathElements().iterator();
			while (pathElementIterator.hasNext()) {
				EObject pathElement = pathElementIterator.next();
				if (pathElement instanceof EClass) {
					if (!currentElement.eClass().equals(pathElement)) {
						usedPath = null;
						break;
					}
				} else if (pathElement instanceof EReference) {
					if (!currentElement.eContainingFeature().equals(pathElement)) {
						usedPath = null;
						break;
					} else {
						currentElement = currentElement.eContainer();
					}
				}
			}
			// we have found our path
			if (usedPath != null) {
				usedInstance = currentElement;
				break;
			}
		}

		if (usedPath == null || usedInstance == null) {
			return super.joiningSelectConnectionPathAndContainerInstance(choices, section, sectionInstances, hintGroup);
		}

		/*
		 * Before returning, we have to identify the 'container instance'
		 * (represented by an EObjectWrapper) that corresponds to the determined
		 * 'usedInstance'. Therefore, we compare the 'container instances and
		 * the 'usedInstance' and select this/these instance(s) that could be
		 * matched without any differences.
		 */

		// create a comparator first
		EMFCompare comparator = EMFComparatorFactory.getIgnoreAllReferenceChangesComparator();

		// now, compare every instance
		ArrayList<EObjectWrapper> containerInstancesToUse = new ArrayList<>();
		for (EObjectWrapper containerInstance : choices.get(usedPath)) {
			IComparisonScope scope = new DefaultComparisonScope(containerInstance.getEObject(), usedInstance, null);
			Comparison comparison = comparator.compare(scope);
			Match match = comparison.getMatch(usedInstance);
			if (match == null || match.getLeft() == null) {
				continue;
			}
			if (match.getDifferences().isEmpty()) {
				// we have found a matching instance that can be used
				containerInstancesToUse.add(containerInstance);
			}
		}

		if (containerInstancesToUse.isEmpty()) {
			return super.joiningSelectConnectionPathAndContainerInstance(choices, section, sectionInstances, hintGroup);
		} else {
			this.printMessage(usedPath.toString() + "-->" + containerInstancesToUse.toString(),
					HistoryResolvingStrategy.historyDecisionPrefix);
			HashMap<ModelConnectionPath, List<EObjectWrapper>> ret = new HashMap<>();
			ret.put(usedPath, containerInstancesToUse);
			return super.joiningSelectConnectionPathAndContainerInstance(ret, section, sectionInstances, hintGroup);
		}

	}

	/**
	 * This consults the {@link #transformationModel} in order to determine
	 * which root class was used during the 'old' transformation.
	 */
	@Override
	public List<EClass> joiningSelectRootElement(List<EClass> choices) throws AmbiguityResolvingException {

		/*
		 * Determine the root element from the 'old' transformation model. Note:
		 * Up to now, we always simply use the first target model as multiple
		 * target models are not yet supported. This should probably be changed
		 * one day...
		 */
		EObject targetModelRoot = this.transformationModel.getTargetModels().get(0);
		EClass targetModelRootClass = targetModelRoot.eClass();

		if (choices.contains(targetModelRootClass)) {
			this.printMessage(targetModelRootClass.getName(), HistoryResolvingStrategy.historyDecisionPrefix);
			return Arrays.asList(targetModelRootClass);
		} else {
			return super.joiningSelectRootElement(choices);
		}
	}

	@Override
	public List<EObjectWrapper> linkingSelectTargetInstance(List<EObjectWrapper> choices,
			TargetSectionCrossReference reference, MappingHintGroupType hintGroup,
			ReferenceTargetSelector mappingInstanceSelector, EObjectWrapper sourceElement)
			throws AmbiguityResolvingException {

		/*
		 * First, we need to check if we can find a match for the given
		 * 'sourceElement' in the 'old' target model.
		 */
		EMFCompare comparator = EMFComparatorFactory.getIgnoreNonContainmentReferenceChangesComparator();
		IComparisonScope scope = new DefaultComparisonScope(EcoreUtil.getRootContainer(sourceElement.getEObject()),
				this.transformationModel.getTargetModels().get(0), null);
		Comparison comparison = comparator.compare(scope);
		Match match = comparison.getMatch(sourceElement.getEObject());
		if (match == null || match.getRight() == null || match.getAllDifferences().iterator().hasNext()) {
			return super.linkingSelectTargetInstance(choices, reference, hintGroup, mappingInstanceSelector,
					sourceElement);
		}

		EObject oldInstance = match.getRight();

		/*
		 * Now, we can check which element was used as target for the
		 * 'reference'.
		 */
		EObject oldTargetInstance = null;

		if (reference.getEReference().isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> referenceTargets = (EList<EObject>) oldInstance.eGet(reference.getEReference());
			if (referenceTargets.isEmpty()) {
				return super.linkingSelectTargetInstance(choices, reference, hintGroup, mappingInstanceSelector,
						sourceElement);
			} else {
				oldTargetInstance = referenceTargets.get(0);
			}
		} else {
			oldTargetInstance = (EObject) oldInstance.eGet(reference.getEReference());
		}

		if (oldTargetInstance == null) {
			return super.linkingSelectTargetInstance(choices, reference, hintGroup, mappingInstanceSelector,
					sourceElement);
		}

		/*
		 * Finally, we have to determine which of the new choices matches the
		 * 'oldTargetInstance'. Therefore, we once more rely on EMFCompare.
		 */
		ArrayList<EObjectWrapper> targetInstancesToUse = new ArrayList<>();
		for (EObjectWrapper instance : choices) {
			scope = new DefaultComparisonScope(instance.getEObject(), oldTargetInstance, null);
			comparison = comparator.compare(scope);
			match = comparison.getMatch(oldTargetInstance);
			if (match == null || match.getLeft() == null) {
				continue;
			}
			if (match.getDifferences().isEmpty()) {
				// we have found a matching instance that can be used
				targetInstancesToUse.add(instance);
			}
		}

		if (targetInstancesToUse.isEmpty()) {
			return super.linkingSelectTargetInstance(choices, reference, hintGroup, mappingInstanceSelector,
					sourceElement);
		} else {
			this.printMessage(targetInstancesToUse.toString(), HistoryResolvingStrategy.historyDecisionPrefix);
			System.out.println("Reusing choice during 'linkingSelectTargetInstance': " + targetInstancesToUse);
			return super.linkingSelectTargetInstance(targetInstancesToUse, reference, hintGroup,
					mappingInstanceSelector, sourceElement);
		}
	}

	/**
	 * This consults the {@link #transformationModel} in order to determine
	 * which combination of {@link TargetSectionClass} and
	 * {@link EObjectWrapper} was used during the 'old' transformation.
	 */
	@Override
	public Map<TargetSectionClass, List<EObjectWrapper>> linkingSelectTargetSectionAndInstance(
			Map<TargetSectionClass, List<EObjectWrapper>> choices, TargetSectionCrossReference reference,
			MappingHintGroupType hintGroup) throws AmbiguityResolvingException {

		/*
		 * First, we need to check if we can find a match for the given
		 * 'section' and 'hintGroup'.
		 */
		Match sectionMatch = this.getMatch(hintGroup.getTargetSection());
		Match hintGroupMatch = this.getMatch(hintGroup);
		if (sectionMatch == null || sectionMatch.getRight() == null
				|| !(sectionMatch.getRight() instanceof TargetSection) || hintGroupMatch == null
				|| hintGroupMatch.getRight() == null || !(hintGroupMatch.getRight() instanceof MappingHintGroupType)) {
			return super.linkingSelectTargetSectionAndInstance(choices, reference, hintGroup);
		}

		// the matched section/hintGroup from the 'old' pamtram model
		TargetSection matchedSection = (TargetSection) sectionMatch.getRight();
		MappingHintGroupType matchedHintGroup = (MappingHintGroupType) hintGroupMatch.getRight();

		/*
		 * Now, we try to determine an element from the 'old' target model that
		 * represents the found 'matchedSection'. Therefore, we make use of the
		 * map 'targetSectionToTransformationHintGroups' and collect all
		 * instantiated target elements from all TransformationMappingHintGroups
		 * that represent the given 'hintGroup'. Thereby, it should not be
		 * relevant which of the (possible multiple) target model elements we
		 * determine as their 'references' should all be connected to the same
		 * element. Thus, we simply get the first one.
		 */
		if (!this.targetSectionToTransformationHintGroups.containsKey(matchedSection)) {
			return super.linkingSelectTargetSectionAndInstance(choices, reference, hintGroup);
		}
		EObject oldInstance = null;
		for (TransformationMappingHintGroup transformationMappingHintGroup : this.targetSectionToTransformationHintGroups
				.get(matchedSection)) {

			/*
			 * As only 'InstantiableHintGroups' are stored in the transformation
			 * model whereas the given 'matchedHintGroup' is of type
			 * 'MappingHintGroupType' we need to determine the corresponding
			 * 'MappingHintGroupType' for each 'transformationMappingHintGroup'.
			 */
			MappingHintGroupType mappingHintGroupType = null;
			if (transformationMappingHintGroup.getAssociatedMappingHintGroup() instanceof MappingHintGroup) {
				mappingHintGroupType = (MappingHintGroupType) transformationMappingHintGroup
						.getAssociatedMappingHintGroup();
			} else if (transformationMappingHintGroup
					.getAssociatedMappingHintGroup() instanceof MappingHintGroupImporter) {
				mappingHintGroupType = ((MappingHintGroupImporter) transformationMappingHintGroup
						.getAssociatedMappingHintGroup()).getHintGroup();
			}
			if (mappingHintGroupType != null && mappingHintGroupType.equals(matchedHintGroup)) {
				oldInstance = transformationMappingHintGroup.getTargetElements().get(0);
			}

		}

		if (oldInstance == null) {
			return super.linkingSelectTargetSectionAndInstance(choices, reference, hintGroup);
		}

		/*
		 * Now, we can check which element was used as target for the
		 * 'reference'.
		 */
		EClass usedTargetClass = null;
		EObject usedTargetInstance = null;

		if (reference.getEReference().isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> referenceTargets = (EList<EObject>) oldInstance.eGet(reference.getEReference());
			if (referenceTargets.isEmpty()) {
				return super.linkingSelectTargetSectionAndInstance(choices, reference, hintGroup);
			} else {
				usedTargetInstance = referenceTargets.get(0);
			}
		} else {
			usedTargetInstance = (EObject) oldInstance.eGet(reference.getEReference());
		}

		if (usedTargetInstance == null) {
			return super.linkingSelectTargetSectionAndInstance(choices, reference, hintGroup);
		}

		usedTargetClass = usedTargetInstance.eClass();

		/*
		 * Finally, we have to determine which of the new choices matches the
		 * given combination of 'old' element and class. Therefore, we once more
		 * rely on EMFCompare.
		 */
		EMFCompare comparator = EMFComparatorFactory.getIgnoreNonContainmentReferenceChangesComparator();
		TargetSectionClass usedTargetSectionClass = null;
		ArrayList<EObjectWrapper> targetInstancesToUse = new ArrayList<>();
		for (TargetSectionClass targetSectionClass : choices.keySet()) {
			if (targetSectionClass.getEClass().equals(usedTargetClass)) {
				usedTargetSectionClass = targetSectionClass;
				for (EObjectWrapper instance : choices.get(targetSectionClass)) {
					IComparisonScope scope = new DefaultComparisonScope(instance.getEObject(), usedTargetInstance,
							null);
					Comparison comparison = comparator.compare(scope);
					Match match = comparison.getMatch(usedTargetInstance);
					if (match == null || match.getLeft() == null) {
						continue;
					}
					if (match.getDifferences().isEmpty()) {
						// we have found a matching instance that can be used
						targetInstancesToUse.add(instance);
					}
				}
				break;
			}
		}

		if (usedTargetSectionClass == null || targetInstancesToUse.isEmpty()) {
			return super.linkingSelectTargetSectionAndInstance(choices, reference, hintGroup);
		} else {
			this.printMessage(usedTargetSectionClass.getName() + "-->" + targetInstancesToUse,
					HistoryResolvingStrategy.historyDecisionPrefix);
			HashMap<TargetSectionClass, List<EObjectWrapper>> ret = new HashMap<>();
			ret.put(usedTargetSectionClass, targetInstancesToUse);
			return super.linkingSelectTargetSectionAndInstance(ret, reference, hintGroup);
		}

	}

	/**
	 * For the given {@link EObject}, return a match from the various
	 * {@link #pamtramCompareResults}.
	 *
	 * @param element
	 * @return The found {@link Match} or <em>null</em> if no match could be
	 *         determined.
	 */
	private Match getMatch(EObject element) {

		Optional<Comparison> compareResult = this.pamtramCompareResults.parallelStream()
				.filter(c -> c.getMatch(element) != null).findAny();

		return compareResult.isPresent() ? compareResult.get().getMatch(element) : null;
	}
}
