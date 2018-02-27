/**
 *
 */
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
