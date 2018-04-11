/*******************************************************************************
 * Copyright (C) 2017-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import de.mfreund.gentrans.transformation.ITransformationRunner.TransformationResult;
import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.tud.et.ifa.agtele.resources.ResourceHelper;

/**
 *
 * @author mfreund
 */
public abstract class Models2016Test extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "models2016";
	}

	@SuppressWarnings("javadoc")
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
		protected TransformationConfiguration getTransformationConfig() {

			return super.getTransformationConfig().withDefaultTargetModel("Library_mm2.xmi");
		}

		@Override
		protected void validateCaseStudyResult(TransformationResult result) {

			if (!result.getTargetModelRegistry().isPresent()) {
				Assertions.fail("Execution returned no TargetModelRegistry!");
				return;
			}

			Set<String> targetModels = result.getTargetModelRegistry().get().getTargetModels().keySet();

			Assert.assertTrue("Unexpected (number of) target model(s)!",
					targetModels.size() == 1 && "Library_mm2.xmi".equals(targetModels.iterator().next()));

			URI expectedResultURI = URI.createPlatformResourceURI(
					PamtramCasestudyTest.expectedResultsFolderPath + "/" + getCaseStudyName() + "/Library_mm2.xmi",
					true);

			URI resultURI = URI.createPlatformResourceURI(
					PamtramCasestudyTest.resultsFolderPath + "/" + getCaseStudyName() + "/Library_mm2.xmi", true);

			assertResultingModelIsEqualToExpected(
					ResourceHelper.convertPlatformToFileURI(expectedResultURI).toFileString(),
					ResourceHelper.convertPlatformToFileURI(resultURI).toFileString());

		}

	}

	@SuppressWarnings("javadoc")
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
		protected TransformationConfiguration getTransformationConfig() {

			return super.getTransformationConfig().withDefaultTargetModel("Library_mm1.xmi");
		}

		@Override
		protected void validateCaseStudyResult(TransformationResult result) {

			if (!result.getTargetModelRegistry().isPresent()) {
				Assertions.fail("Execution returned no TargetModelRegistry!");
				return;
			}

			Set<String> targetModels = result.getTargetModelRegistry().get().getTargetModels().keySet();

			Assert.assertTrue("Unexpected (number of) target model(s)!",
					targetModels.size() == 1 && "Library_mm1.xmi".equals(targetModels.iterator().next()));

			URI expectedResultURI = URI.createPlatformResourceURI(
					PamtramCasestudyTest.expectedResultsFolderPath + "/" + getCaseStudyName() + "/Library_mm1.xmi",
					true);

			URI resultURI = URI.createPlatformResourceURI(
					PamtramCasestudyTest.resultsFolderPath + "/" + getCaseStudyName() + "/Library_mm1.xmi", true);

			assertResultingModelIsEqualToExpected(
					ResourceHelper.convertPlatformToFileURI(expectedResultURI).toFileString(),
					ResourceHelper.convertPlatformToFileURI(resultURI).toFileString());

		}
	}

}
