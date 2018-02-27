/**
 *
 */
package de.mfreund.gentrans.transformation.util;

import de.mfreund.gentrans.transformation.CancelTransformationException;

/**
 * This interface can be implemented to indicate that an element/algorithm can be cancelled.
 *
 * @author mfreund
 */
public interface ICancelable {

	/**
	 * This cancels the element/algorithm that implements this interface.
	 */
	public abstract void cancel();

	/**
	 * This returns the status of the element/algorithm.
	 *
	 * @return '<em><b>true</b></em>' if the element has been {@link #cancel() canceled}; '<em><b>false</b></em>'
	 *         otherwise.
	 */
	public abstract boolean isCanceled();

	/**
	 * This can be used for periodic checks if the object was {@link #cancel() canceled} by an outside process.
	 * <p />
	 * In case the object was canceled, it will throw a {@link CancelTransformationException}.
	 *
	 * @throws CancelTransformationException
	 *             If the element was {@link #isCanceled() canceled}.
	 */
	public default void checkCanceled() throws CancelTransformationException {

		if (this.isCanceled()) {
			throw new CancelTransformationException();
		}
	}
}
