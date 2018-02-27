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
