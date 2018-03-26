/*******************************************************************************
 * Copyright (C) 2017-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.compare.contentmergeviewer.TokenComparator;
import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
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
import pamtram.structure.target.FileType;

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

		System.out.println("Create Output Directory for casestudy '" + getCaseStudyName() + "'...");

		String resultsPath = PamtramCasestudyTest.resultsFolderPath + "/" + getCaseStudyName();
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
				.createGenericTransformationRunner(getTransformationConfig());

		// Execute the transformation
		//
		TransformationResult result = runner.run();

		// Validate the result
		//
		validateCaseStudyResult(result);

	}

	/**
	 * Assert that the given {@link TransformationResult} is as expected.
	 */
	protected void validateCaseStudyResult(TransformationResult result) {

		if (!result.getTargetModelRegistry().isPresent()) {
			Assertions.fail("Execution returned no TargetModelRegistry!");
			return;
		}

		URI expectedResultsFolderURI = URI.createPlatformResourceURI(
				PamtramCasestudyTest.expectedResultsFolderPath + "/" + getCaseStudyName(), true);
		IContainer expectedResultsFolder = ResourceHelper.getContainerForURI(expectedResultsFolderURI);

		Assert.assertTrue("Failed to retrieve results folder!", expectedResultsFolder instanceof IFolder);

		URI resultsFolderURI = URI
				.createPlatformResourceURI(PamtramCasestudyTest.resultsFolderPath + "/" + getCaseStudyName(), true);
		IContainer resultsFolder = ResourceHelper.getContainerForURI(resultsFolderURI);

		Assert.assertTrue("Failed to retrieve results folder!", resultsFolder instanceof IFolder);

		List<IFile> expectedResultsFiles;
		List<IFile> resultsFiles;
		try {
			expectedResultsFiles = ResourceHelper.getFilesInContainerRecursively(expectedResultsFolder);
			resultsFiles = ResourceHelper.getFilesInContainerRecursively(resultsFolder);
		} catch (CoreException e) {
			Assertions.fail(e);
			return;
		}

		Assert.assertTrue("Unexpected number of created target model(s)!",
				result.getTargetModelRegistry().get().getTargetModels().size() == resultsFiles.size());

		Assert.assertTrue("Unexpected number of stored target model(s)!",
				expectedResultsFiles.size() == resultsFiles.size());

		for (int i = 0; i < expectedResultsFiles.size(); i++) {

			Assert.assertTrue("Unexpected target model name!",
					expectedResultsFiles.get(i).getName().equals(resultsFiles.get(i).getName()));

			String expectedFile = ResourceHelper
					.convertPlatformToFileURI(
							ResourceHelper.getURIForPathString(expectedResultsFiles.get(i).getFullPath().toString()))
					.toFileString();
			String resultFile = ResourceHelper
					.convertPlatformToFileURI(
							ResourceHelper.getURIForPathString(resultsFiles.get(i).getFullPath().toString()))
					.toFileString();

			assertResultingModelIsEqualToExpected(expectedFile, resultFile);

		}

	}

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
			config = TransformationConfiguration.createInstanceFromSourcePaths(getSourceModels(), getPamtramModels(),
					getTargetBasePath());
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

		return PamtramCasestudyTest.resultsFolderPath + "/" + getCaseStudyName();
	}

	/**
	 * The type of the created target models (either {@link FileType#XMI} or {@link FileType#XML}).
	 */
	protected FileType getTargetModelType() {

		return FileType.XMI;
	}

	/**
	 * {@link EMFCompareUtil#compare(Notifier, Notifier) Compares} the two models identified by <em>expected</em> and
	 * <em>result</em> and asserts that they are equal.
	 * <p />
	 * Note: This will just redirect to either {@link #assertResultingXMIModelIsEqualToExpected(String, String)} or
	 * {@link #assertResultingXMLModelIsEqualToExpected(String, String)}.
	 *
	 * @param expected
	 *            The absolute path to the file representing the expected model.
	 * @param result
	 *            The absolute path to the file representing the result model.
	 */
	protected void assertResultingModelIsEqualToExpected(String expected, String result) {

		if (getTargetModelType().equals(FileType.XMI)) {

			assertResultingXMIModelIsEqualToExpected(expected, result);

		} else if (getTargetModelType().equals(FileType.XML)) {

			assertResultingXMLModelIsEqualToExpected(expected, result);

		} else {
			Assert.fail("Unsupported target model file type: " + getTargetModelType().getName());
		}
	}

	/**
	 * {@link EMFCompareUtil#compare(Notifier, Notifier) Compares} the two XMI models identified by <em>expected</em>
	 * and <em>result</em> and asserts that they are equal.
	 *
	 * @param expected
	 *            The absolute path to the file representing the expected XMI model.
	 * @param result
	 *            The absolute path to the file representing the result XMI model.
	 */
	protected void assertResultingXMIModelIsEqualToExpected(String expected, String result) {

		ResourceSet rs1 = new ResourceSetImpl();
		ResourceSet rs2 = new ResourceSetImpl();

		Resource expectedResultResource = rs1.getResource(URI.createFileURI(expected), true);
		Resource resultResource = rs2.getResource(URI.createFileURI(result), true);

		Comparison compareResult = EMFCompareUtil.compare(rs1, rs2);

		Assert.assertTrue(
				"Comparing expected file '" + getNameOfResource(expectedResultResource) + "' and actual result '"
						+ getNameOfResource(resultResource) + "' resulted in conflicts!",
				compareResult.getConflicts().isEmpty());

		Assert.assertTrue(
				"Comparing expected file '" + getNameOfResource(expectedResultResource) + "' and actual result '"
						+ getNameOfResource(resultResource) + "' resulted in differences!",
				compareResult.getDifferences().isEmpty());
	}

	protected String getNameOfResource(Resource resource) {

		URI resourceURI = resource.getURI();
		return resourceURI == null ? "" : resourceURI.lastSegment();
	}

	/**
	 * {@link EMFCompareUtil#compare(Notifier, Notifier) Compares} the two XML models identified by <em>expected</em>
	 * and <em>result</em> and asserts that they are equal.
	 *
	 * @param expected
	 *            An {@link IFile} representing the expected XMI model.
	 * @param result
	 *            An {@link IFile} representing the result XMI model.
	 */
	protected void assertResultingXMLModelIsEqualToExpected(String expected, String result) {

		// As the resulting models are plain XML without any namespace declarations, we cannot use the super
		// implementation that makes use of 'EMFCompare'. Instead, we need to compare on a pure string basis.
		//
		Scanner expectedScanner = null;
		String expectedContent = "";
		try {
			expectedScanner = new Scanner(new File(expected));
			expectedScanner.useDelimiter("\\A");
			while (expectedScanner.hasNextLine()) {
				expectedContent += expectedScanner.nextLine().trim();
			}
		} catch (FileNotFoundException e) {
			Assertions.fail(e);
		} finally {
			expectedScanner.close();
		}

		Scanner resultScanner = null;
		String resultContent = "";
		try {
			resultScanner = new Scanner(new File(result));
			resultScanner.useDelimiter("\\A");
			while (resultScanner.hasNextLine()) {
				resultContent += resultScanner.nextLine().trim();
			}
		} catch (FileNotFoundException e) {
			Assertions.fail(e);
		} finally {
			resultScanner.close();
		}

		IRangeComparator left = new TokenComparator(expectedContent);
		IRangeComparator right = new TokenComparator(resultContent);
		RangeDifference[] diffs = RangeDifferencer.findDifferences(left, right);

		Assert.assertTrue(
				"Comparing expected file '" + new File(expected).getName() + "' and actual result '"
						+ new File(result).getName() + "' resulted in conflicts!",
				Arrays.asList(diffs).stream().noneMatch(d -> d.kind() == RangeDifference.CONFLICT));

		Assert.assertTrue(
				"Comparing expected file '" + new File(expected).getName() + "' and actual result '"
						+ new File(result).getName() + "' resulted in differences!",
				Arrays.asList(diffs).stream().allMatch(d -> d.kind() == RangeDifference.NOCHANGE));
	}
}
