/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.mfreund.gentrans.test.casestudies.Models2016Test.LibraryMM1ToMM2Test;
import de.mfreund.gentrans.test.casestudies.Models2016Test.LibraryMM2ToMM1Test;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._01_AttributeMappingTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._02_ExternalAttributeMappingTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._03_multiValuedAttributeMappingTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._04_modelConnectionHintTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._05_attributeMappingWithExpressionTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._06_containerCheckTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._07_emptyReferenceTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._08_cardinalityMappingTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._09_attributeMappingWithFixedValueTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._10_applicationDependencyTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._11_equivalentSourceSectionsTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._12_attributeMappingWithGlobalSourceElementTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._13_matchSubTypesTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._14_ignoreUnmatchedElementsTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._15_virtualSourceSectionAttributeTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._16_virtualSourceSectionCrossReferenceTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._17_multiplePamtramModelsTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._18_modelConnectionHint2Test;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._19_modelConnectionHint3Test;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._20_modelConnectionHint4Test;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._21_cardinalityConditionForReferenceTest;
import de.mfreund.gentrans.test.casestudies.W3CAUICasestudyBasedBasicTest._22_crossReferenceTest;
import de.tud.et.ifa.agtele.resources.ResourceHelper;

/**
 *
 * @author mfreund
 */
@RunWith(Suite.class)
@SuiteClasses({ //
		_01_AttributeMappingTest.class, //
		_02_ExternalAttributeMappingTest.class, //
		_03_multiValuedAttributeMappingTest.class, //
		_04_modelConnectionHintTest.class, //
		_05_attributeMappingWithExpressionTest.class, //
		_06_containerCheckTest.class, //
		_07_emptyReferenceTest.class, //
		_08_cardinalityMappingTest.class, //
		_09_attributeMappingWithFixedValueTest.class, //
		_10_applicationDependencyTest.class, //
		_11_equivalentSourceSectionsTest.class, //
		_12_attributeMappingWithGlobalSourceElementTest.class, //
		_13_matchSubTypesTest.class, //
		_14_ignoreUnmatchedElementsTest.class, //
		_15_virtualSourceSectionAttributeTest.class, //
		_16_virtualSourceSectionCrossReferenceTest.class, //
		_17_multiplePamtramModelsTest.class, //
		_18_modelConnectionHint2Test.class, //
		_19_modelConnectionHint3Test.class, //
		_20_modelConnectionHint4Test.class, //
		_21_cardinalityConditionForReferenceTest.class, //
		_22_crossReferenceTest.class, //
		AutoProBeSimplifiedDissTest.class, //
		AutoProBeTest.class, //
		CompanyVizTest.class, //
		DislMovisaTest.class, //
		ExcelMovisaTdpTest.class, //
		LibraryTest.class, //
		LibraryMM1ToMM2Test.class, //
		LibraryMM2ToMM1Test.class, //
		VisuPlusTest.class, //
		W3CAuiMovisaTest.class //
})
public class AllCasestudyTests {

	protected static final String resultsFolderPath = "de.mfreund.gentrans.test.casestudies/results";

	/**
	 * Prepares the 'results' directory by creating it if necessary and deleting all files in it.
	 *
	 */
	@BeforeClass
	public static void createResultsDirectory() {

		System.out.println("Prepare Results Directory...");

		URI resultsFolderURI = URI.createPlatformResourceURI(AllCasestudyTests.resultsFolderPath, true);
		IContainer resultsFolder = ResourceHelper.getContainerForURI(resultsFolderURI);

		Assert.assertTrue("Failed to retrieve results folder!", resultsFolder instanceof IFolder);

		ResourceHelper.refresh(resultsFolder.getParent());

		try {
			ResourceHelper.createFolder((IFolder) resultsFolder);
		} catch (CoreException e) {
			Assertions.fail("Failed to create results folder!", e);
		}

		ResourceHelper.deleteFilesInFolder(
				new File(ResourceHelper.convertPlatformToFileURI(resultsFolderURI).toFileString()));

		ResourceHelper.refresh(resultsFolder);

		System.out.println("...finished.");
	}

}
