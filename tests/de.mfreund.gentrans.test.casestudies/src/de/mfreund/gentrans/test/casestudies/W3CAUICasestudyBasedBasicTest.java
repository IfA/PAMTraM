/*******************************************************************************
 * Copyright (C) 2017-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.tud.et.ifa.agtele.emf.connecting.Length;

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

		return "basic/" + getCaseStudyIdentifier();
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections
				.singleton("/de.mfreund.pamtram.casestudies.w3caui-movisa/Source/" + getCaseStudyIdentifier() + ".xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton(
				"/de.mfreund.pamtram.casestudies.w3caui-movisa/Pamtram/" + getCaseStudyIdentifier() + ".pamtram");
	}

	@SuppressWarnings("javadoc")
	public static class _01_AttributeMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "01_attributeMapping";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _02_ExternalAttributeMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "02_externalAttributeMapping";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _03_multiValuedAttributeMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "03_multiValuedAttributeMapping";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _04_modelConnectionHintTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "04_modelConnectionHint";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _05_attributeMappingWithExpressionTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "05_attributeMappingWithExpression";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _06_containerCheckTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "06_containerCheck";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _07_emptyReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "07_emptyReference";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _08_cardinalityMappingTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "08_cardinalityMapping";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _09_attributeMappingWithFixedValueTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "09_attributeMappingWithFixedValue";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _10_applicationDependencyTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "10_applicationDependency";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _11_equivalentSourceSectionsTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "11_equivalentSourceSections";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _12_attributeMappingWithGlobalSourceElementTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "12_attributeMappingWithGlobalSourceElement";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _13_matchSubTypesTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "13_matchSubTypes";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _14_ignoreUnmatchedElementsTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "14_ignoreUnmatchedElements";
		}

		@Override
		protected TransformationConfiguration getTransformationConfig() {

			return super.getTransformationConfig().withMaxPathLength(Length.DIRECT_CONNECTION);
		}

	}

	@SuppressWarnings("javadoc")
	public static class _15_virtualSourceSectionAttributeTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "15_virtualSourceSectionAttribute";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _16_virtualSourceSectionCrossReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "16_virtualSourceSectionCrossReference";
		}

	}

	@SuppressWarnings("javadoc")
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

	@SuppressWarnings("javadoc")
	public static class _18_modelConnectionHint2Test extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "18_modelConnectionHint2";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _19_modelConnectionHint3Test extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "19_modelConnectionHint3";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _20_modelConnectionHint4Test extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "20_modelConnectionHint4";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _21_cardinalityConditionForReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "21_cardinalityConditionForReference";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _22_crossReferenceTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "22_crossReference";
		}

	}

	@SuppressWarnings("javadoc")
	public static class _23_multipleExtendsTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "23_multipleExtends";
		}

		@Override
		protected TransformationConfiguration getTransformationConfig() {

			return super.getTransformationConfig().withMaxPathLength(Length.DIRECT_CONNECTION);
		}

	}

	@SuppressWarnings("javadoc")
	public static class _24_uniqueAttributesTest extends W3CAUICasestudyBasedBasicTest {

		@Override
		protected String getCaseStudyIdentifier() {

			return "24_uniqueAttributes";
		}

	}
}
