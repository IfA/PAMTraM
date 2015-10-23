/**
 *
 */
package de.mfreund.gentrans.transformation.util;

/**
 * This interface can be implemented to indicate that an element/algorithm
 * can be cancelled.
 * 
 * @author mfreund
 */
public interface ICancellable {

	/**
	 * This cancels the element/algorithm that implements this interface.
	 */
	public abstract void cancel();

	/**
	 * This returns the status of the element/algorithm.
	 * 
	 * @return '<em><b>true</b></em>' if the element has been {@link #cancel() canceled}; '<em><b>false</b></em>' otherwise.
	 */
	public abstract boolean isCancelled();
}
