/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
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
package pamtram.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import pamtram.ConditionModel;
import pamtram.MappingModel;
import pamtram.SourceSectionModel;
import pamtram.TargetSectionModel;

/**
 * A special resource for a shared {@link SourceSectionModel}, {@link TargetSectionModel}, {@link MappingModel}, or
 * {@link ConditionModel} that uses {@link #useUUIDs() IDs} instead of URI fragments to address model elements.
 * <p />
 * That way, using and editing model contents from multiple PAMTraM models should be less likely to break references.
 *
 * @author mfreund
 */
public class SharedModelResource extends XMIResourceImpl {

	/**
	 * This creates an instance.
	 *
	 */
	public SharedModelResource() {
		super();
	}

	/**
	 * This creates an instance.
	 *
	 * @param uri
	 *            The {@link URI} of the resource to be created.
	 */
	public SharedModelResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {

		return true;
	}
}
