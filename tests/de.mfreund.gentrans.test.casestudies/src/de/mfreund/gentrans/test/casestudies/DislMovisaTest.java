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

import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.tud.et.ifa.agtele.emf.connecting.Length;

/**
 *
 * @author mfreund
 */
public class DislMovisaTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "disl-movisa";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.disl-movisa/Source/usecase_simple.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.disl-movisa/Pamtram/Disl2Movisa.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		return super.getTransformationConfig().withDefaultTargetModel("out.movisa.xmi")
				.withMaxPathLength(Length.DIRECT_CONNECTION);
	}

}
