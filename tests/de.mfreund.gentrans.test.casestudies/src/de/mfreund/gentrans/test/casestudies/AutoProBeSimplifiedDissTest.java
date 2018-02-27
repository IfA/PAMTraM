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
public class AutoProBeSimplifiedDissTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "autoprobe-simplified-diss";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections
				.singleton("/de.mfreund.pamtram.casestudies.autoprobe-simplified-diss/Source/SampleStateModel.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton(
				"/de.mfreund.pamtram.casestudies.autoprobe-simplified-diss/Pamtram/stgml-to-movisa-simplified.pamtram");
	}

}
