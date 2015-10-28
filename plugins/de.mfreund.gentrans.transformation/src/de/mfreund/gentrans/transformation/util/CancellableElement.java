package de.mfreund.gentrans.transformation.util;

/**
 * This provides an <em>abstract</em> default implementation of the {@link ICancellable} interface that
 * stores its status (canceled/not canceled) in a simple boolean field.
 * 
 * @author mfreund
 *
 */
public abstract class CancellableElement implements ICancellable {

	/**
	 * This keeps track of the element's status.
	 */
	protected boolean canceled;

	@Override
	public void cancel() {
		canceled = true;
	}

	@Override
	public boolean isCancelled() {
		return canceled;
	}

}
