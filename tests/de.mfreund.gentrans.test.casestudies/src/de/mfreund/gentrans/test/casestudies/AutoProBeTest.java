/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import de.mfreund.gentrans.transformation.ITransformationRunner.TransformationResult;
import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 *
 * @author mfreund
 */
public class AutoProBeTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "autoprobe";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.autoprobe/Source/beispiel_ver_0_2_3.xml");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.autoprobe/Pamtram/STGML2Movisa_enhanced.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		String libPath = "D:\\git-repos\\de.tud.et.ifa.agtele.autoprobe\\de.tud.et.ifa.agtele.autoprobe.resources\\lib";

		return super.getTransformationConfig().withLibPaths(Arrays.asList(libPath)).withMaxPathLength(0);
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
