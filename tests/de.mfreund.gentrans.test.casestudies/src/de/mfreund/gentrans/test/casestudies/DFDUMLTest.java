/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

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
public class DFDUMLTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "dfd-uml";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.dfd-uml/Source/Temperaturmessung.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.dfd-uml/Pamtram/dfd-uml.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		return super.getTransformationConfig().withMaxPathLength(0);
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
