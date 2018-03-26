/*******************************************************************************
 * Copyright (C) 2017-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package de.mfreund.gentrans.test.casestudies;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 *
 * @author mfreund
 */
public class AutoProBeSimpleTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "autoprobe-simple";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.autoprobe/Source/beispiel_ver_0_2_3_simple.xml");
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

}
