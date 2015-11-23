package de.mfreund.gentrans.transformation.resolving.history;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import de.mfreund.gentrans.transformation.ModelConnectionPath;
import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.pamtram.transformation.Transformation;
import de.mfreund.pamtram.transformation.TransformationMapping;
import de.mfreund.pamtram.transformation.TransformationMappingHintGroup;
import pamtram.PAMTraM;
import pamtram.mapping.Mapping;
import pamtram.mapping.MappingType;
import pamtram.metamodel.MetamodelPackage;
import pamtram.metamodel.TargetSection;

/**
 * This class implements a concrete {@link ComposedAmbiguityResolvingStrategy} that consults previous resolving 
 * results in order to resolve ambiguities and additionally can compose multiple other resolving strategies. 
 * <p />
 * Any call to a method defined by the {@link IAmbiguityResolvingStrategy} interface will first check if
 * a previous resolving result is present for the given configuration. If this is the case, it uses this
 * result; otherwise, it iteratively forwards the call to every of the {@link #composedStrategies} and 
 * returns the final result. The result is also stored for future ambiguity evaluation requests.
 * 
 * @author mfreund
 */
public class HistoryResolvingStrategy extends ComposedAmbiguityResolvingStrategy {

	/**
	 * The path to the {@link Transformation TransformationModel} to be used to 
	 * consult previous resolving results
	 */
	private String transformationModelPath;

	/**
	 * The {@link Transformation TransformationModel} to be used to consult previous resolving results.
	 */
	private Transformation transformationModel;

	/**
	 * This keeps track of the {@link PAMTraM} instance that the current transformation operates on.
	 */
	private PAMTraM pamtramModel;

	/**
	 * This keeps track of the list of {@link EObject sourceModels} that serve as input to the current transformation.
	 */
	private ArrayList<EObject> sourceModels;

	/**
	 * This will contain the result of the comparison process between the current PAMTraM model and the 'old' PAMTraM model
	 * that is part of the {@link #transformationModel}.
	 * <p />
	 * Note: The <em>left</em> side of this comparison represents the current PAMTraM model, the <em>right</em> side 
	 * represents the 'old' model (part of the transformation model).
	 */
	private Comparison pamtramCompareResult;

	/**
	 * This will contain a list of results of the comparison processes between the current source models and the 'old' source models
	 * that are part of the {@link #transformationModel}.
	 * <p />
	 * Note: The <em>left</em> sides of these comparisons represent the current source models, the <em>right</em> sides 
	 * represent the 'old' models (part of the transformation model).
	 */
	private ArrayList<Comparison> sourceCompareResults;

	private HistoryResolvingStrategy(ArrayList<IAmbiguityResolvingStrategy> composedStrategies) {
		super(composedStrategies);
	}

	/**
	 * This creates an instance.
	 * 
	 * @param composedStrategies The list of {@link IAmbiguityResolvingStrategy strategies} that this composes.
	 * @param transformationModelPath The path to the {@link Transformation TransformationModel} to be used to 
	 * consult previous resolving results.
	 */
	public  HistoryResolvingStrategy(ArrayList<IAmbiguityResolvingStrategy> composedStrategies, String transformationModelPath) {
		this(composedStrategies);
		this.transformationModelPath = transformationModelPath;
	}

	@Override
	public void init(PAMTraM pamtramModel, ArrayList<EObject> sourceModels) throws IOException {

		this.pamtramModel = pamtramModel;
		this.sourceModels = sourceModels;
		this.sourceCompareResults = new ArrayList<>();
		loadTransformationModel();
		performEMFCompare();

		System.out.println("Number of differences between the pamtram models: " + pamtramCompareResult.getDifferences().size());
	}

	/**
	 * Load the {@link #transformationModel} from the given {@link #transformationModelPath}. 
	 * @throws IOException 
	 */
	private void loadTransformationModel() throws IOException {

		/*
		 * We need to load the transformation model to the same ResourceSet as the pamtram model, otherwise
		 * strange things happen in the EMFcompare process (changes are shown even nothing has changed).
		 */
		ResourceSet resourceSet = this.pamtramModel.eResource().getResourceSet();

		// the URI of the transformation model resource
		final URI transformationModelUri = URI.createPlatformResourceURI(transformationModelPath, true);

		// load the transformation model
		XMIResource transformationModelResource = 
				(XMIResource) resourceSet.getResource(transformationModelUri, true);
		transformationModelResource.load(Collections.EMPTY_MAP);
		if(!(transformationModelResource.getContents().get(0) instanceof Transformation)) {
			throw new RuntimeException("The transformation model does not contain a stored transformation.");
		}
		transformationModel = (Transformation) transformationModelResource.getContents().get(0);

	}

	/**
	 * Initialize the comparison scope, configure the comparison and compare both the PAMTraM models (the one
	 * stored as part of the {@link #transformationModel} and the {@link #pamtramModel}) as well as the
	 * source models (those stored as part of the {@link #transformationModel} and the {@link #sourceModels}).
	 * <p/>
	 * Note: This is taken from <a href="https://www.eclipse.org/emf/compare/documentation/latest/developer/developer-guide.html#Using_The_Compare_APIs">
	 * https://www.eclipse.org/emf/compare/documentation/latest/developer/developer-guide.html#Using_The_Compare_APIs</a>.
	 * 
	 * @throws IOException If one of the involved resources cannot be (re)loaded. 
	 */
	private void performEMFCompare() throws IOException {

		/*
		 * Initialize EMFCompare 
		 */
		ResourceSet resourceSet = this.transformationModel.eResource().getResourceSet();

		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());

		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);

		/*
		 * Compare the Pamtram resources
		 */
		URI pamtramUri =  this.transformationModel.getPamtramInstance().eResource().getURI();
		XMIResource pamtramResource = (XMIResource) resourceSet.getResource(pamtramUri, true);
		pamtramResource.unload(); // reload the resource as the compare process will show strange differences
		pamtramResource.load(Collections.EMPTY_MAP);

		IComparisonScope scope = new DefaultComparisonScope(this.pamtramModel.eResource(), pamtramResource, null);
		IDiffProcessor diffProcessor = new DiffBuilder();
		EMFCompare comparator = EMFCompare.builder().
				setMatchEngineFactoryRegistry(matchEngineRegistry).
				setDiffEngine(new DefaultDiffEngine(diffProcessor) {
					@Override
					protected FeatureFilter createFeatureFilter() {
						return new FeatureFilter() {
							@Override
							protected boolean isIgnoredReference(Match match, EReference reference) {
								/*
								 * We forget about the 'source' reference of library parameters as the comparison process will report
								 * false changes to references of this type as the referenced objects are not contained in the resource 
								 * in focus (cf. https://www.eclipse.org/emf/compare/documentation/latest/developer/developer-guide.html#Changing_the_FeatureFilter).
								 */
								return reference.equals(MetamodelPackage.Literals.LIBRARY_PARAMETER__SOURCE) ||
										super.isIgnoredReference(match, reference);
							}

							@Override
							public boolean checkForOrderingChanges(EStructuralFeature feature) {
								return false;
							}
						};
					}
				}).
				build();

		pamtramCompareResult = comparator.compare(scope);

		/*
		 * Compare the source models (only if the number of models match)
		 */
		if(sourceModels.size() == this.transformationModel.getSourceModels().size()) {

			for (int i=0; i<sourceModels.size(); i++) {
				URI sourceUri =  this.transformationModel.getSourceModels().get(i).eResource().getURI();
				XMLResource sourceResource = (XMLResource) resourceSet.getResource(sourceUri, true);
				sourceResource.unload(); // reload the resource as the compare process will show strange differences
				sourceResource.load(Collections.EMPTY_MAP);

				IComparisonScope sourceScope = new DefaultComparisonScope(this.sourceModels.get(i).eResource(), sourceResource, null);
				EMFCompare sourceComparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();

				sourceCompareResults.add(sourceComparator.compare(sourceScope));

			}
		}

	}

	/**
	 * Consult the list of {@link TransformationMapping TransformationMappings} stored in the 
	 * {@link #transformationModel} in order to retrieve the corresponding selection for the given
	 * list of choices. If a corresponding choice is found, reuse it; otherwise, forward the decision
	 * to the list of {@link ComposedAmbiguityResolvingStrategy#composedStrategies}.
	 */
	@Override
	public List<Mapping> matchingSelectMapping(List<Mapping> choices, EObject element) throws Exception {

		/*
		 * First, we need to check if we can find a match for the given 'element'.
		 */
		Match match = getSourceModelMatch(element);
		if(match == null || match.getRight() == null) {
			return super.matchingSelectMapping(choices, element);			
		}

		// the matched element from the 'old' source model 
		EObject matchedElement = match.getRight();

		/*
		 * Now, we can determine the mapping that was used in the 'old' transformation.
		 */
		TransformationMapping oldTransformationMapping = null;
		for(TransformationMapping transformationMapping : this.transformationModel.getTransformationMappings()) {
			if(transformationMapping.getSourceElement().equals(matchedElement)) {
				oldTransformationMapping = transformationMapping;
				break;
			}
		}

		if(oldTransformationMapping == null) {
			return super.matchingSelectMapping(choices, element);
		}

		/*
		 * Finally, we check if the list of choices is the 'same' list of choices as in the 'old' transformation 
		 * (we do not want to blindly reuse a choice even if there are changes in the list of mappings that
		 * we can choose from).
		 */
		EList<MappingType> oldChoices = oldTransformationMapping.getAssociatedMapping().getSourceMMSection().getReferencingMappings();
		ArrayList<MappingType> oldChoicesWithoutDeactivated = new ArrayList<>(oldChoices);
		for (MappingType oldChoice : oldChoices) {
			// sort out deactivated elements
			if(oldChoice.isDeactivated()) {
				oldChoicesWithoutDeactivated.remove(oldChoice);
			}
		}
		if(oldChoicesWithoutDeactivated.size() != choices.size()) {
			return super.matchingSelectMapping(choices, element);
		}
		for (MappingType oldChoice : oldChoicesWithoutDeactivated) {
			// find a matching 'new' choice
			Match matchingNewChoice = pamtramCompareResult.getMatch(oldChoice);
			if(matchingNewChoice == null || matchingNewChoice.getLeft() == null || !(matchingNewChoice.getLeft() instanceof Mapping) ||
					!choices.contains(matchingNewChoice.getLeft())) {
				return super.matchingSelectMapping(choices, element);
			}
		}

		/*
		 * Now, we are sure that the current list of choices matches the old one (and thus that
		 * the 'old' choice is also an option in the current list of choices). Thus, we may safely reuse
		 * the old choice.
		 */
		Match mappingMatch = pamtramCompareResult.getMatch(oldTransformationMapping.getAssociatedMapping());

		System.out.println("Reusing choice during 'matchingSelectMapping': " + ((Mapping) (mappingMatch.getLeft())).getName());
		return Arrays.asList((Mapping) (mappingMatch.getLeft()));

	}

	@Override
	public List<ModelConnectionPath> joiningSelectConnectionPath(List<ModelConnectionPath> choices,
			TargetSection section) throws Exception {

		/*
		 * First, we need to check if we can find a match for the given 'section'.
		 */
		Match match = pamtramCompareResult.getMatch(section);
		if(match == null || match.getRight() == null || !(match.getRight() instanceof TargetSection)) {
			return super.joiningSelectConnectionPath(choices, section);		
		}

		// the matched section from the 'old' pamtram model
		TargetSection matchedSection = (TargetSection) match.getRight();

		/*
		 * Now, we try to determine an element from the 'old' target model that represents the found 'matchedSection'.
		 * Therefore, we first determine a TransformationHintGroup of which the associated MappingHintGroup
		 * was responsible for instantiating the 'matchedSection'. That way, we can determine the
		 * instantiated ModelConnectionPath from the source model. Thereby, it should not be relevant which
		 * of the (possible multiple) TransformationHintGroups we determine as all should lead to the same
		 * result. Thus, we simply get the first one.
		 */
		EObject instantiatedElement = null;

		outerloop:
			for (TransformationMapping transformationMapping : this.transformationModel.getTransformationMappings()) {
				for (TransformationMappingHintGroup transformationHintGroup : transformationMapping.getTransformationHintGroups()) {
					if(matchedSection.getReferencingMappingHintGroups().contains(transformationHintGroup.getAssociatedMappingHintGroup())) {
						if(!transformationHintGroup.getTargetElements().isEmpty()) {
							instantiatedElement = transformationHintGroup.getTargetElements().get(0);
							break outerloop;
						}
					}

				}
			}

		if(instantiatedElement == null) {
			return super.joiningSelectConnectionPath(choices, section);			
		}

		/*
		 * Finally, we can check which ModelConnectionPath was used to connect the 
		 * 'instantiatedElement'.
		 */
		ModelConnectionPath usedPath = null;
		for (ModelConnectionPath modelConnectionPath : choices) {

			usedPath = modelConnectionPath;

			/*
			 * Iterate over every element of the path and check if it was used to connect
			 * the given 'instantiatedElement'.
			 */
			EObject currentElement = instantiatedElement;
			Iterator<EObject> pathElementIterator = modelConnectionPath.getPathElements().iterator();
			while(pathElementIterator.hasNext()) {
				EObject pathElement = pathElementIterator.next();
				if(pathElement instanceof EClass) {
					if(!(currentElement.eClass().equals(pathElement))) {
						usedPath = null;
						break;
					}
				} else if(pathElement instanceof EReference) {
					if(!(currentElement.eContainingFeature().equals(pathElement))) {
						usedPath = null;
						break;
					} else {
						currentElement = currentElement.eContainer();
					}
				}
			}
			//we have found our path
			if(usedPath != null) {
				break;
			}
		}

		if(usedPath == null) {
			return super.joiningSelectConnectionPath(choices, section);			
		} else {
			System.out.println("Reusing choice during 'joiningSelectConnectionPath': " + usedPath);
			return Arrays.asList(usedPath);
		}

	}

	/**
	 * This is a convenience method to find a match for the given source model element in one of the stored 
	 * {@link #sourceCompareResults}. This method simply iterates over all compare results.
	 * 
	 * @param objectToMatch An element from a source model for that a match shall be found.
	 * @return The {@link Match} for the given source model element or '<em>null</em>' if no
	 * match could be found.
	 */
	private Match getSourceModelMatch(EObject objectToMatch) {

		Match foundMatch = null;

		/*
		 * Iterate over all of the stored 'sourceCompareResults' and try to find 
		 * a match for the given 'objectToMatch'.
		 */
		for (Comparison compareResult : sourceCompareResults) {
			foundMatch = compareResult.getMatch(objectToMatch);
			if(foundMatch != null) {
				break;
			}
		}

		return foundMatch;
	}
}
