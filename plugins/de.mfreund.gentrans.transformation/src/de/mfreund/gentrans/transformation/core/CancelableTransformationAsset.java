/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.core;

import de.mfreund.gentrans.transformation.util.ICancelable;

/**
 * An abstract base class for the {@link TransformationAsset TransformationAssets} that are also {@link ICancelable}.
 *
 * @author mfreund
 */
public abstract class CancelableTransformationAsset extends TransformationAsset implements ICancelable {

	/**
	 * This keeps track of the element's status.
	 */
	protected boolean canceled;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public CancelableTransformationAsset(TransformationAssetManager assetManager) {

		super(assetManager);
		this.canceled = false;
	}

	@Override
	public void cancel() {

		this.canceled = true;

	}

	@Override
	public boolean isCanceled() {

		return this.canceled;
	}

}
