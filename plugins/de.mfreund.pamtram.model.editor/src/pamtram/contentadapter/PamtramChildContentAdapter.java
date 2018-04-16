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
package pamtram.contentadapter;

import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * Abstract content adapter that all adapters acting as child adapters of the
 * PamtramContentAdapter shoul implement.
 *
 * @author mfreund
 *
 */
public abstract class PamtramChildContentAdapter extends EContentAdapter {

	PamtramContentAdapter parentAdapter;

	/**
	 * This create an instance.
	 *
	 * @param parentAdapter
	 *            The parent {@link PamtramContentAdapter} that will manage this
	 *            as one of its child adapters.
	 */
	public PamtramChildContentAdapter(PamtramContentAdapter parentAdapter) {
		this.parentAdapter = parentAdapter;
	}

}
