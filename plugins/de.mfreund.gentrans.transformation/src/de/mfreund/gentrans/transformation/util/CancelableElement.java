package de.mfreund.gentrans.transformation.util;

import de.mfreund.gentrans.transformation.CancelTransformationException;

/**
 * This provides an <em>abstract</em> default implementation of the
 * {@link ICancelable} interface that stores its status (canceled/not canceled)
 * in a simple boolean field.
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

	/**
	 * This can be used for periodic checks if the object was {@link #cancel()
	 * canceled} by an outside process.
	 * <p />
	 * In case the object was canceled, it will throw a
	 * {@link CancelTransformationException}.
	 */
	protected void checkCanceled() {
		if (this.isCanceled()) {
			throw new CancelTransformationException();
		}
	}

}
