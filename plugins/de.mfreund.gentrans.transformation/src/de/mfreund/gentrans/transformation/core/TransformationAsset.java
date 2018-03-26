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
package de.mfreund.gentrans.transformation.core;

import java.util.logging.Logger;

/**
 * An abstract base class for the various transformation assets managed by the {@link TransformationAssetManager}.
 *
 * @author mfreund
 */
public abstract class TransformationAsset {

	/**
	 * The {@link TransformationAssetManager} providing access to the various other assets used in the current
	 * transformation instance.
	 */
	protected TransformationAssetManager assetManager;

	/**
	 * The {@link Logger} that shall be used to print messages.
	 */
	protected Logger logger;

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public TransformationAsset(TransformationAssetManager assetManager) {

		this.assetManager = assetManager;
		this.logger = assetManager.getLogger();
	}

}
