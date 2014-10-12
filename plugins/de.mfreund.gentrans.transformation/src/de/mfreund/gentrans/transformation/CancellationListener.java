/**
 *
 */
package de.mfreund.gentrans.transformation;

/**
 * @author Sascha Steffen
 * @version 1.0
 *
 *          Provides methods to handle a Job cancellation.
 */
public interface CancellationListener {
	/**
	 * Cancel (possibly long running) operations
	 */
	public abstract void cancel();

	/**
	 * @return true if cancel() was called
	 */
	public abstract boolean isCancelled();
}
