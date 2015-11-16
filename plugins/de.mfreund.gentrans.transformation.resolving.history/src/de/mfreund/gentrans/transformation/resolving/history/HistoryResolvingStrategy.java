package de.mfreund.gentrans.transformation.resolving.history;

import java.util.ArrayList;

import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.mfreund.pamtram.transformation.Transformation;

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

}
