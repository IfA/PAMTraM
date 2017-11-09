/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Collections;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import de.mfreund.gentrans.transformation.ITransformationRunner.TransformationResult;

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

	@Override
	protected void validateCaseStudyResult(TransformationResult result) {

		if (!result.getTargetModelRegistry().isPresent()) {
			Assertions.fail("Execution returned no TargetModelRegistry!");
			return;
		}

		Set<String> targetModels = result.getTargetModelRegistry().get().getTargetModels().keySet();

		Assert.assertTrue("Unexpected (number of) target model(s)!",
				targetModels.size() == 1 && "out.xmi".equals(targetModels.iterator().next()));

		this.assertResultingModelIsEqualToExpected("out.xmi");
	}

}