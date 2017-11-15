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
public abstract class Models2016Test extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "models2016";
	}

	public static class LibraryMM1ToMM2Test extends Models2016Test {

		@Override
		protected Set<String> getSourceModels() {

			return Collections.singleton("/de.mfreund.pamtram.casestudies.models2016/Source/Library_mm1.xmi");
		}

		@Override
		protected Set<String> getPamtramModels() {

			return Collections
					.singleton("/de.mfreund.pamtram.casestudies.models2016/Pamtram/library_mm1_to_mm2.pamtram");
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

			this.assertResultingModelIsEqualToExpected("Library_mm2.xmi", "out.xmi");
		}

	}

	public static class LibraryMM2ToMM1Test extends Models2016Test {

		@Override
		protected Set<String> getSourceModels() {

			return Collections.singleton("/de.mfreund.pamtram.casestudies.models2016/Source/Library_mm2.xmi");
		}

		@Override
		protected Set<String> getPamtramModels() {

			return Collections
					.singleton("/de.mfreund.pamtram.casestudies.models2016/Pamtram/library_mm2_to_mm1.pamtram");
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

			this.assertResultingModelIsEqualToExpected("Library_mm1.xmi", "out.xmi");
		}

	}

}
