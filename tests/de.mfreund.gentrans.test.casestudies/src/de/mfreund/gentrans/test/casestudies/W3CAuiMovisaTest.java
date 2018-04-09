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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.mfreund.gentrans.transformation.TransformationConfiguration;
import de.tud.et.ifa.agtele.emf.connecting.Length;

/**
 *
 * @author mfreund
 */
public class W3CAuiMovisaTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "w3caui-movisa";
	}

	@Override
	protected Set<String> getSourceModels() {

		return new HashSet<>(
				Arrays.asList("/de.mfreund.pamtram.casestudies.w3caui-movisa/Source/Kleinversuchsanlage.xmi",
						"/de.mfreund.pamtram.casestudies.w3caui-movisa/Source/PMbase1.xmi"));
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.w3caui-movisa/Pamtram/w3caui-movisa.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		return super.getTransformationConfig().withMaxPathLength(Length.DIRECT_CONNECTION);
	}

}
