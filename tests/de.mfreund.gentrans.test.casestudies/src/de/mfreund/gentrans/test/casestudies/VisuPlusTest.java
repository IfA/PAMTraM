/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.compare.contentmergeviewer.TokenComparator;
import org.eclipse.compare.rangedifferencer.IRangeComparator;
import org.eclipse.compare.rangedifferencer.RangeDifference;
import org.eclipse.compare.rangedifferencer.RangeDifferencer;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import de.mfreund.gentrans.transformation.ITransformationRunner.TransformationResult;
import de.tud.et.ifa.agtele.resources.ResourceHelper;

/**
 *
 * @author mfreund
 */
public class VisuPlusTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "visu-plus";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.visu-plus/Source/beispiel_ver_0_2_3.xml");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.visu-plus/Pamtram/visu-plus.pamtram");
	}

	@Override
	protected void validateCaseStudyResult(TransformationResult result) {

		if (!result.getTargetModelRegistry().isPresent()) {
			Assertions.fail("Execution returned no TargetModelRegistry!");
			return;
		}

		URI expectedResultsFolderURI = URI.createPlatformResourceURI(
				PamtramCasestudyTest.expectedResultsFolderPath + "/" + this.getCaseStudyName(), true);
		IContainer expectedResultsFolder = ResourceHelper.getContainerForURI(expectedResultsFolderURI);

		Assert.assertTrue("Failed to retrieve results folder!", expectedResultsFolder instanceof IFolder);

		URI resultsFolderURI = URI.createPlatformResourceURI(
				PamtramCasestudyTest.resultsFolderPath + "/" + this.getCaseStudyName(), true);
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

		Assert.assertTrue("Unexpected (number of) target model(s)!",
				expectedResultsFiles.size() == resultsFiles.size());

		for (int i = 0; i < expectedResultsFiles.size(); i++) {

			String expectedFile = ResourceHelper
					.convertPlatformToFileURI(
							ResourceHelper.getURIForPathString(expectedResultsFiles.get(i).getFullPath().toString()))
					.toFileString();
			String resultFile = ResourceHelper
					.convertPlatformToFileURI(
							ResourceHelper.getURIForPathString(resultsFiles.get(i).getFullPath().toString()))
					.toFileString();
			this.assertResultingModelIsEqualToExpected(expectedFile, resultFile);

		}

	}

	/**
	 * As the resulting models are plain XML without any namespace declarations, we cannot use the super implemtation
	 * that makes use of 'EMFCompare'. Instead, we need to compare on a pure string basis.
	 */
	@Override
	protected void assertResultingModelIsEqualToExpected(String expected, String result) {

		Scanner expectedScanner = null;
		String expectedContent = "";
		try {
			expectedScanner = new Scanner(new File(expected));
			expectedContent = expectedScanner.useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			Assertions.fail(e);
		} finally {
			expectedScanner.close();
		}

		Scanner resultScanner = null;
		String resultContent = "";
		try {
			resultScanner = new Scanner(new File(result));
			resultContent = resultScanner.useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			Assertions.fail(e);
		} finally {
			resultScanner.close();
		}

		IRangeComparator left = new TokenComparator(expectedContent);
		IRangeComparator right = new TokenComparator(resultContent);
		RangeDifference[] diffs = RangeDifferencer.findRanges(left, right);

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
