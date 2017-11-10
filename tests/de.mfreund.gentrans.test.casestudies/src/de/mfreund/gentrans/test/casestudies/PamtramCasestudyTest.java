/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Set;
import java.util.logging.Level;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import de.mfreund.gentrans.transformation.ITransformationRunner;
import de.mfreund.gentrans.transformation.ITransformationRunner.TransformationResult;
import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.mfreund.gentrans.transformation.TransformationRunnerWithUIFactory;
import de.tud.et.ifa.agtele.emf.compare.EMFCompareUtil;
import de.tud.et.ifa.agtele.resources.ResourceHelper;

/**
 * An abstract base class for tests that consist of executing one of the various PAMTraM casestudies.
 *
 * @author mfreund
 */
public abstract class PamtramCasestudyTest {

	protected static final String expectedResultsFolderPath = "de.mfreund.gentrans.test.casestudies/expected-results";

	protected static final String resultsFolderPath = "de.mfreund.gentrans.test.casestudies/results";

	/**
	 * Creates the output directory for each casestudy.
	 */
	@Before
	public void createOutputDirectory() {

		System.out.println("Create Output Directory for casestudy '" + this.getCaseStudyName() + "'...");

		String resultsPath = PamtramCasestudyTest.resultsFolderPath + "/" + this.getCaseStudyName();
		URI resultsPathURI = URI.createPlatformResourceURI(resultsPath, true);
		IContainer resultsPathFolder = ResourceHelper.getContainerForURI(resultsPathURI);

		Assert.assertTrue("Failed to retrieve AutoProBe results folder!", resultsPathFolder instanceof IFolder);

		try {
			ResourceHelper.createFolder((IFolder) resultsPathFolder);
		} catch (CoreException e) {
			Assertions.fail("Failed to create AutoProBe results folder!", e);
		}

		ResourceHelper.refresh(resultsPathFolder);

		System.out.println("...finished.");
	}

	/**
	 * Executes the casestudy specified via {@link #getTransformationConfig()} and
	 * {@link #validateCaseStudyResult(TransformationResult) validates} the results.
	 */
	@Test
	public void caseStudyShouldProduceCorrectResult() {

		// Create the transformation runner
		//
		ITransformationRunner runner = TransformationRunnerWithUIFactory.INSTANCE
				.createGenericTransformationRunner(this.getTransformationConfig());

		// Execute the transformation
		//
		TransformationResult result = runner.run();

		// Validate the result
		//
		this.validateCaseStudyResult(result);

	}

	/**
	 * Assert that the given {@link TransformationResult} is as expected.
	 */
	protected abstract void validateCaseStudyResult(TransformationResult result);

	/**
	 * Get the name of the casestudy to run. This will among others be used to create the sub-folder in the 'results'
	 * folder.
	 */
	protected abstract String getCaseStudyName();

	/**
	 * Get the {@link TransformationConfiguration} that specifies the transformation to be executed.
	 * <p />
	 * The default implementation makes use of {@link #getSourceModels()}, {@link #getPamtramModels()} and
	 * {@link #getTargetBasePath()}.
	 */
	protected TransformationConfiguration getTransformationConfig() {

		TransformationConfiguration config;
		try {
			config = TransformationConfiguration.createInstanceFromSourcePaths(this.getSourceModels(),
					this.getPamtramModels(), this.getTargetBasePath());
			config.withLogLevel(Level.INFO).withLogLevel(Level.WARNING).withOpenTargetModelOnCompletion(false)
					.withOnlyAskOnceOnAmbiguousMappings(true).withUseParallelization(false);

		} catch (Exception e) {
			Assertions.fail("Failed to create the TransformationConfiguration!", e);
			return null;
		}

		return config;
	}

	/**
	 * The source models to use for the transformation.
	 */
	protected abstract Set<String> getSourceModels();

	/**
	 * The PAMTraM models to use for the transformation.
	 */
	protected abstract Set<String> getPamtramModels();

	/**
	 * The base path for the target models to be created during the transformation.
	 */
	protected String getTargetBasePath() {

		return PamtramCasestudyTest.resultsFolderPath + "/" + this.getCaseStudyName();
	}

	/**
	 * {@link EMFCompareUtil#compare(Notifier, Notifier) Compares} the expected and resulting model identified by
	 * <em>model</em> and asserts that they are equal.
	 *
	 * @see #assertResultingModelIsEqualToExpected(String, String)
	 *
	 * @param model
	 *            The path to the model (relative to the path corresponding to this {@link #getCaseStudyName()} in the
	 *            {@link #expectedResultsFolderPath} for the <em>expected</em> model and relative to the path
	 *            corresponding to this {@link #getCaseStudyName()} in the {@link #resultsFolderPath} for the
	 *            <em>resulting</em> model).
	 */
	protected void assertResultingModelIsEqualToExpected(String model) {

		this.assertResultingModelIsEqualToExpected(model, model);
	}

	/**
	 * {@link EMFCompareUtil#compare(Notifier, Notifier) Compares} the two models identified by <em>expected</em> and
	 * <em>result</em> and asserts that they are equal.
	 *
	 * @see #assertResultingModelIsEqualToExpected(String)
	 *
	 * @param expected
	 *            The path to the expected model (relative to the path corresponding to this {@link #getCaseStudyName()}
	 *            in the {@link #expectedResultsFolderPath}).
	 * @param result
	 *            The path to the result model (relative to the path corresponding to this {@link #getCaseStudyName()}
	 *            in the {@link #resultsFolderPath}).
	 */
	protected void assertResultingModelIsEqualToExpected(String expected, String result) {

		ResourceSet rs = new ResourceSetImpl();
		Resource expectedResultResource = rs.getResource(URI.createPlatformResourceURI(
				PamtramCasestudyTest.expectedResultsFolderPath + "/" + this.getCaseStudyName() + "/" + expected, true),
				true);
		Resource resultResource = rs.getResource(
				URI.createPlatformResourceURI(
						PamtramCasestudyTest.resultsFolderPath + "/" + this.getCaseStudyName() + "/" + result, true),
				true);

		Comparison compareResult = EMFCompareUtil.compare(expectedResultResource, resultResource);

		Assert.assertTrue(
				"Comparing expected file '" + expectedResultResource.getURI().lastSegment() + "' and actual result '"
						+ resultResource.getURI().lastSegment() + "' resulted in conflicts!",
				compareResult.getConflicts().isEmpty());

		Assert.assertTrue(
				"Comparing expected file '" + expectedResultResource.getURI().lastSegment() + "' and actual result '"
						+ resultResource.getURI().lastSegment() + "' resulted in differences!",
				compareResult.getDifferences().isEmpty());
	}
}
