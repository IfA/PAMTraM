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
package de.mfreund.gentrans.transformation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import de.mfreund.gentrans.transformation.resolving.ComposedAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.DefaultAmbiguityResolvingStrategy;
import de.mfreund.gentrans.transformation.resolving.IAmbiguityResolvingStrategy;
import de.tud.et.ifa.agtele.emf.connecting.Length;
import pamtram.structure.library.LibraryEntry;
import pamtram.structure.target.FileAttribute;

/**
 * This class captures the optional parameters that can be specified for an instance of the generic transformation. They
 * are used by a {@link TransformationRunnerFactory} to instantiate instances of {@link ITransformationRunner}.
 * <p />
 * The various <em>with...</em> methods provide a floating API to configure the parameters.
 *
 * @author mfreund
 *
 */
public class BaseTransformationConfiguration {

	/**
	 * Whether the (first of the) generated target model(s) shall be automatically opened after a (successful) execution
	 * of the transformation.
	 */
	protected boolean openTargetModelOnCompletion;

	/**
	 * File path of the <em>default</em> target model (relative to the given '<em>targetBasePath</em>'). The default
	 * target model is that target model to which all contents will be added that are not associated with a special
	 * model via the {@link FileAttribute}.
	 */
	protected String defaultTargetModel;

	/**
	 * This is the path to the folder where the {@link #transformationModel} will be stored after the transformation. It
	 * needs to be in the form 'project-name/path'. If this is set to '<em>null</em>', the transformation model will not
	 * be stored.
	 * <p />
	 * Note: The transformation (including all related files) will be stored in a sperate folder inside the given path.
	 */
	protected String transformationModelPath;

	/**
	 * Maximum length for connection paths in the 'joining' step.
	 */
	protected Length maxPathLength;

	/**
	 * Determines whether the user should be asked every time an ambiguous mapping was detected, or if the first user
	 * decision shall be stored and reused.
	 */
	protected boolean onlyAskOnceOnAmbiguousMappings;

	/**
	 * The list of paths to the libraries to be used to retrieve the entries for the instantiation of
	 * {@link LibraryEntry LibraryEntries}.
	 */
	protected List<String> libPaths;

	/**
	 * The {@link IAmbiguityResolvingStrategy} that shall be used to resolve ambiguities that arise during the execution
	 * of the transformation.
	 */
	protected IAmbiguityResolvingStrategy ambiguityResolvingStrategy;

	/**
	 * The minimum {@link Level} a logged messages must represent to be printed to the user. Use {@link Level#ALL} to
	 * ensure logging of all messages and {@link Level#OFF} to prevent any logging.
	 */
	protected Level logLevel;

	/**
	 * Whether extended parallelization shall be used during the transformation that might lead to the fact that the
	 * transformation result (especially the order of lists) varies between executions.
	 */
	protected boolean useParallelization;

	/**
	 * This creates an instance and initializes all parameters with default values.
	 * <p />
	 * Note: These can be changed by means of the various <em>with...</em> methods.
	 */
	public BaseTransformationConfiguration() {

		// Initialize all parameters with default values.
		//
		withDefaultTargetModel(null);
		withTransformationModelPath(null);
		withMaxPathLength(Length.UNBOUNDED);
		withOnlyAskOnceOnAmbiguousMappings(true);
		withLibPaths(null);
		withAmbiguityResolvingStrategy(null);
		withLogLevel(null);
		withUseParallelization(false);
	}

	/**
	 * Check if all parameters have been initialized with meaningful values.
	 *
	 * @return '<em><b>true</b></em>' if all parameters have been initialized with meaningful values;
	 *         '<em><b>false</b></em>' otherwise.
	 */
	public boolean validate() {

		return defaultTargetModel != null && ambiguityResolvingStrategy != null;
	}

	/**
	 * Set the {@link #openTargetModelOnCompletion}.
	 * <p />
	 * Note: If this is set to '<em>true</em>', it means that the (first of the) generated target model(s) shall be
	 * automatically opened after a (successful) execution of the transformation.
	 *
	 * @param openTargetModelOnCompletion
	 *            The {@link #openTargetModelOnCompletion} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #openTargetModelOnCompletion}.
	 *
	 */
	public BaseTransformationConfiguration withOpenTargetModelOnCompletion(boolean openTargetModelOnCompletion) {

		this.openTargetModelOnCompletion = openTargetModelOnCompletion;
		return this;
	}

	/**
	 * Set the {@link #defaultTargetModel}.
	 * <p />
	 * Note: If this is '<em>null</em>', '<em>out.xmi</em>' will be used as default value.
	 *
	 * @param defaultTargetModel
	 *            The name of the {@link #defaultTargetModel} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #defaultTargetModel}.
	 */
	public BaseTransformationConfiguration withDefaultTargetModel(String defaultTargetModel) {

		this.defaultTargetModel = defaultTargetModel == null ? "out.xmi" : defaultTargetModel;
		return this;
	}

	/**
	 * Set the {@link #transformationModelPath} in the form 'project-name/path'.
	 * <p />
	 * Note: If this is set to '<em>null</em>', the transformation model will not be stored.
	 *
	 * @param transformationModelPath
	 *            The {@link #transformationModelPath} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #transformationModelPath}.
	 */
	public BaseTransformationConfiguration withTransformationModelPath(String transformationModelPath) {

		this.transformationModelPath = transformationModelPath;
		return this;
	}

	/**
	 * Set the {@link #maxPathLength}.
	 *
	 * @param maxPathLength
	 *            The {@link #maxPathLength} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #maxPathLength}.
	 */
	public BaseTransformationConfiguration withMaxPathLength(Length maxPathLength) {

		this.maxPathLength = maxPathLength;
		return this;
	}

	/**
	 * Set the {@link #onlyAskOnceOnAmbiguousMappings}.
	 * <p />
	 * Note: If this is set to '<em>true</em>', it means that the user will be asked every time an ambiguity occurs.
	 *
	 * @param onlyAskOnceOnAmbiguousMappings
	 *            The {@link #onlyAskOnceOnAmbiguousMappings} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #onlyAskOnceOnAmbiguousMappings}.
	 *
	 */
	public BaseTransformationConfiguration withOnlyAskOnceOnAmbiguousMappings(boolean onlyAskOnceOnAmbiguousMappings) {

		this.onlyAskOnceOnAmbiguousMappings = onlyAskOnceOnAmbiguousMappings;
		return this;
	}

	/**
	 * Set the {@link #libPaths}.
	 * <p />
	 * Note: This may be set to '<em>null</em>' if no library entries shall be instantiated during the transformation.
	 *
	 * @param libPaths
	 *            The list of paths to the libraries to be used to retrieve the LibraryEntry.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #libPaths}.
	 */
	public BaseTransformationConfiguration withLibPaths(List<String> libPaths) {

		this.libPaths = libPaths == null ? new ArrayList<>() : libPaths;
		return this;
	}

	/**
	 * Set the {@link #ambiguityResolvingStrategy}.
	 * <p />
	 * Based on the given <em>ambiguityResolvingStrategy</em>, the resulting strategy is created so that an instance of
	 * the {@link DefaultAmbiguityResolvingStrategy} is included in the strategy -- if necessary, a
	 * {@link ComposedAmbiguityResolvingStrategy} is created for this.
	 *
	 * @param ambiguityResolvingStrategy
	 *            The {@link #ambiguityResolvingStrategy} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #ambiguityResolvingStrategy}.
	 */
	public BaseTransformationConfiguration withAmbiguityResolvingStrategy(
			IAmbiguityResolvingStrategy ambiguityResolvingStrategy) {

		IAmbiguityResolvingStrategy resultingStrategy;

		if (ambiguityResolvingStrategy == null) {

			resultingStrategy = new DefaultAmbiguityResolvingStrategy();

		} else if (ambiguityResolvingStrategy instanceof DefaultAmbiguityResolvingStrategy) {

			resultingStrategy = ambiguityResolvingStrategy;

		} else if (ambiguityResolvingStrategy instanceof ComposedAmbiguityResolvingStrategy) {

			boolean containsDefaultStrategy = false;
			for (IAmbiguityResolvingStrategy strategy : ((ComposedAmbiguityResolvingStrategy) ambiguityResolvingStrategy)
					.getComposedStrategies()) {
				if (strategy instanceof DefaultAmbiguityResolvingStrategy) {
					containsDefaultStrategy = true;
					break;
				}
			}

			if (!containsDefaultStrategy) {
				((ComposedAmbiguityResolvingStrategy) ambiguityResolvingStrategy)
						.addStrategy(new DefaultAmbiguityResolvingStrategy());
			}

			resultingStrategy = ambiguityResolvingStrategy;

		} else {

			ArrayList<IAmbiguityResolvingStrategy> composed = new ArrayList<>();
			composed.add(ambiguityResolvingStrategy);
			composed.add(new DefaultAmbiguityResolvingStrategy());
			resultingStrategy = new ComposedAmbiguityResolvingStrategy(composed);

		}

		this.ambiguityResolvingStrategy = resultingStrategy;

		return this;
	}

	/**
	 * Set the {@link #logLevel}.
	 * <p />
	 * Note: If this is '<em>null</em>', {@link Level#ALL} will be used.
	 *
	 * @param logLevel
	 *            The {@link #logLevel} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #logLevel}.
	 */
	public BaseTransformationConfiguration withLogLevel(Level logLevel) {

		this.logLevel = logLevel == null ? Level.ALL : logLevel;
		return this;
	}

	/**
	 * Set the {@link #useParallelization}.
	 *
	 * @param useParallelization
	 *            The {@link #useParallelization} to set.
	 * @return The {@link BaseTransformationConfiguration} after setting the {@link #logLevel}.
	 */
	public BaseTransformationConfiguration withUseParallelization(boolean useParallelization) {

		this.useParallelization = useParallelization;
		return this;
	}

	/**
	 * The getter for the {@link #openTargetModelOnCompletion}.
	 *
	 * @return the openTargetModelOnCompletion
	 */
	public boolean isOpenTargetModelOnCompletion() {

		return openTargetModelOnCompletion;
	}

	/**
	 * The getter for the {@link #defaultTargetModel}.
	 *
	 * @return the defaultTargetModel
	 */
	public String getDefaultTargetModel() {

		return defaultTargetModel;
	}

	/**
	 * The getter for the {@link #transformationModelPath}.
	 *
	 * @return the transformationModelPath
	 */
	public String getTransformationModelPath() {

		return transformationModelPath;
	}

	/**
	 * The getter for the {@link #maxPathLength}.
	 *
	 * @return the maxPathLength
	 */
	public Length getMaxPathLength() {

		return maxPathLength;
	}

	/**
	 * The getter for the {@link #onlyAskOnceOnAmbiguousMappings}.
	 *
	 * @return the onlyAskOnceOnAmbiguousMappings
	 */
	public boolean isOnlyAskOnceOnAmbiguousMappings() {

		return onlyAskOnceOnAmbiguousMappings;
	}

	/**
	 * The getter for the {@link #libPaths}.
	 *
	 * @return the libPath
	 */
	public List<String> getLibPaths() {

		return libPaths;
	}

	/**
	 * The getter for the {@link #ambiguityResolvingStrategy}.
	 *
	 * @return the ambiguityResolvingStrategy
	 */
	public IAmbiguityResolvingStrategy getAmbiguityResolvingStrategy() {

		return ambiguityResolvingStrategy;
	}

	/**
	 * The getter for the {@link #logLevel}.
	 *
	 * @return the logLevel
	 */
	public Level getLogLevel() {

		return logLevel;
	}

	/**
	 * The getter for the {@link #useParallelization}.
	 *
	 * @return the useParallelization
	 */
	public boolean isUseParallelization() {

		return useParallelization;
	}

	/**
	 * Print a summary of the used configuration.
	 */
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("- Open Target Model on Completion: " + openTargetModelOnCompletion);
		builder.append("\n- Default Target Model: " + defaultTargetModel);
		builder.append("\n- Maximum length for Connection Paths: " + maxPathLength);
		builder.append("\n- Remember Choices For Ambiguous Mappings: " + onlyAskOnceOnAmbiguousMappings);
		builder.append("\n- Create Transformation Model: " + (transformationModelPath != null ? "true" : "false"));
		builder.append("\n- Extended Parallelization: " + useParallelization);
		builder.append("\n- Used Ambiguity Resolving Strategy: " + ambiguityResolvingStrategy);
		builder.append("\n- Library Location(s): ");
		builder.append(libPaths.isEmpty() ? "---" : "\n\t" + libPaths.stream().collect(Collectors.joining("\n\t")));

		return builder.toString();
	}

}
