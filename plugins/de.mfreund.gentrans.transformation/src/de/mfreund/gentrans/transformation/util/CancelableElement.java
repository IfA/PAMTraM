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
package de.mfreund.gentrans.transformation.util;

/**
 * This provides an <em>abstract</em> default implementation of the {@link ICancelable} interface that stores its status
 * (canceled/not canceled) in a simple boolean field.
 *
 * @author mfreund
 *
 */
public abstract class CancelableElement implements ICancelable {

	/**
	 * This keeps track of the element's status.
	 */
	protected boolean canceled;

	@Override
	public void cancel() {

		this.canceled = true;
	}

	@Override
	public boolean isCanceled() {

		return this.canceled;
	}

}
