/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import de.mfreund.gentrans.transformation.ITransformationRunner.TransformationResult;
import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 * An abstract base class for all basic {@link PamtramCasestudyTest PamtramCasestudyTests} that are based on the
 * <em>W3CAUI-Movisa</em> casestudy.
 *
 * @author mfreund
 */
public abstract class W3CAUICasestudyBasedBasicTest extends PamtramCasestudyTest {

	/**
	 * Returns the identifier for the casestudy.
	 */
	protected abstract String getCaseStudyIdentifier();

	@Override
	protected String getCaseStudyName() {

		return "basic/" + this.getCaseStudyIdentifier();
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton(
				"/de.mfreund.pamtram.casestudies.w3caui-movisa/Source/" + this.getCaseStudyIdentifier() + ".xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton(
				"/de.mfreund.pamtram.casestudies.w3caui-movisa/Pamtram/" + this.getCaseStudyIdentifier() + ".pamtram");
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

	public static class _01_AttributeMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "01_attributeMapping";
		}

	}

	public static class _02_ExternalAttributeMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "02_externalAttributeMapping";
		}

	}

	public static class _03_multiValuedAttributeMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "03_multiValuedAttributeMapping";
		}

	}

	public static class _04_modelConnectionHintTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "04_modelConnectionHint";
		}

	}

	public static class _05_attributeMappingWithExpressionTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "05_attributeMappingWithExpression";
		}

	}

	public static class _06_containerCheckTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "06_containerCheck";
		}

	}

	public static class _07_emptyReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "07_emptyReference";
		}

	}

	public static class _08_cardinalityMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "08_cardinalityMapping";
		}

	}

	public static class _09_attributeMappingWithFixedValueTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "09_attributeMappingWithFixedValue";
		}

	}

	public static class _10_applicationDependencyTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "10_applicationDependency";
		}

	}

	public static class _11_equivalentSourceSectionsTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "11_equivalentSourceSections";
		}

	}

	public static class _12_attributeMappingWithGlobalSourceElementTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "12_attributeMappingWithGlobalSourceElement";
		}

	}

	public static class _13_matchSubTypesTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "13_matchSubTypes";
		}

	}

	public static class _14_ignoreUnmatchedElementsTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "14_ignoreUnmatchedElements";
		}

		@Override
		protected TransformationConfiguration getTransformationConfig() {

			return super.getTransformationConfig().withMaxPathLength(0);
		}

	}

	public static class _15_virtualSourceSectionAttributeTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "15_virtualSourceSectionAttribute";
		}

	}

	public static class _16_virtualSourceSectionCrossReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "16_virtualSourceSectionCrossReference";
		}

	}

	public static class _17_multiplePamtramModelsTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "17_multiplePamtramModels";
		}

		@Override
		protected Set<String> getPamtramModels() {

			return new LinkedHashSet<>(Arrays.asList(
					"/de.mfreund.pamtram.casestudies.w3caui-movisa/Pamtram/17_1_multiplePamtramModels.pamtram",
					"/de.mfreund.pamtram.casestudies.w3caui-movisa/Pamtram/17_2_multiplePamtramModels.pamtram"));
		}

	}

	public static class _18_modelConnectionHint2Test extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "18_modelConnectionHint2";
		}

	}

	public static class _19_modelConnectionHint3Test extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "19_modelConnectionHint3";
		}

	}

	public static class _20_modelConnectionHint4Test extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "20_modelConnectionHint4";
		}

	}

	public static class _21_cardinalityConditionForReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "21_cardinalityConditionForReference";
		}

	}

	public static class _22_crossReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "22_crossReference";
		}

	}

	public static class _23_multipleExtendsTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "23_multipleExtends";
		}

	}
}
