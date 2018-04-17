/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
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
package de.mfreund.pamtram.model.generator;

import pamtram.PAMTraM;
import pamtram.structure.generic.Section;

/**
 * An enum describing the types of {@link Section Sections} that can be created by an instance of
 * {@link GeneratorWizard} for a selected {@link PAMTraM} model.
 *
 * @author mfreund
 */
enum SectionType {
	NONE, SOURCE, TARGET, BOTH
}
