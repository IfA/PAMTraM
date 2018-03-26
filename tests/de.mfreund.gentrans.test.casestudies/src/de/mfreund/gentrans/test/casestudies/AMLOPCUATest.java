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

import java.util.Collections;
import java.util.Set;

import pamtram.structure.target.FileType;

/**
 *
 * @author mfreund
 */
public class AMLOPCUATest extends PamtramCasestudyTest {

	@Override
	protected String getCaseStudyName() {

		return "aml-opcua";
	}

	@Override
	protected Set<String> getSourceModels() {

		return Collections
				.singleton("/de.mfreund.pamtram.casestudies.aml-opc-ua/Source/Kleinversuchsanlage_PandIX_AML_Libs.xmi");
	}

	@Override
	protected Set<String> getPamtramModels() {

		return Collections.singleton("/de.mfreund.pamtram.casestudies.aml-opc-ua/Pamtram/aml-opc-ua.pamtram");
	}

	@Override
	protected FileType getTargetModelType() {

		return FileType.XML;
	}
}
