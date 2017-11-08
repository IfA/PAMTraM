/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

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

import de.tud.et.ifa.agtele.resources.ResourceHelper;

/**
 *
 * @author mfreund
 */
@RunWith(Suite.class)
@SuiteClasses({ AutoProBeSimplifiedDissTest.class, //
		AutoProBeTest.class, //
		CompanyVizTest.class, //
		DislMovisaTest.class, //
		ExcelMovisaTdpTest.class, //
		LibraryTest.class, //
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

		System.out.println("Create Results Directory...");

		URI resultsFolderURI = URI.createPlatformResourceURI(AllCasestudyTests.resultsFolderPath, true);
		IContainer resultsFolder = ResourceHelper.getContainerForURI(resultsFolderURI);

		Assert.assertTrue("Failed to retrieve results folder!", resultsFolder instanceof IFolder);

		ResourceHelper.refresh(resultsFolder.getParent());

		try {
			ResourceHelper.createFolder((IFolder) resultsFolder);
		} catch (CoreException e) {
			Assertions.fail("Failed to create results folder!", e);
		}

		ResourceHelper.refresh(resultsFolder);

		System.out.println("...finished.");
	}

}
