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

import java.util.Collections;
import java.util.Set;

import de.mfreund.gentrans.transformation.TransformationConfiguration;

/**
 *
 * @author mfreund
 */
public class CompanyVizTest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "company-viz";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.company-viz/Source/IfA.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.company-viz/Pamtram/company-viz.pamtram");
	}

	@Override
	protected TransformationConfiguration getTransformationConfig() {

		return super.getTransformationConfig().withDefaultTargetModel("visualization.xmi");
	}

}
