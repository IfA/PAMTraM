/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Collections;
import java.util.Set;

/**
 *
 * @author mfreund
 */
public class LibraryTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "library";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.library/Source/Library_mm3.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.library/Pamtram/library_mm3_to_mm4.pamtram");
	}

}
