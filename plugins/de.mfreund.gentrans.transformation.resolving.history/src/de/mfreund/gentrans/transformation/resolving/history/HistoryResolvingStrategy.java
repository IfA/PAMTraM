package de.mfreund.gentrans.transformation.resolving.history;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;

import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.pamtram.transformation.Transformation;
import pamtram.PAMTraM;

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
	public void init(PAMTraM pamtramModel, ArrayList<EObject> sourceModels) {

		this.pamtramModel = pamtramModel;
		this.sourceModels = sourceModels;
		loadTransformationModel();
		initializeEMFCompare();
	}

	/**
	 * Load the {@link #transformationModel} from the given {@link #transformationModelPath}. 
	 */
	private void loadTransformationModel() {

		ResourceSet resourceSet = new ResourceSetImpl();

		// the URI of the transformation model resource
		final URI transformationModelUri = URI.createPlatformResourceURI(transformationModelPath, true);

		// load the transformation model
		XMIResource transformationModelResource = 
				(XMIResource) resourceSet.getResource(transformationModelUri, true);
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
	 */
	private void initializeEMFCompare() {

		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());

		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);

		IComparisonScope scope = new DefaultComparisonScope(this.pamtramModel, this.transformationModel.getPamtramInstance(), null);
		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();

		Comparison compareResult = comparator.compare(scope);

		System.out.println();
	}

}
