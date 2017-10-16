package pamtram.contentadapter;

import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * Abstract content adapter that all adapters acting as child adapters of the
 * PamtramContentAdapter shoul implement.
 *
 * @author mfreund
 *
 */
public abstract class PamtramChildContentAdapter extends EContentAdapter {

	PamtramContentAdapter parentAdapter;

	/**
	 * This create an instance.
	 *
	 * @param parentAdapter
	 *            The parent {@link PamtramContentAdapter} that will manage this
	 *            as one of its child adapters.
	 */
	public PamtramChildContentAdapter(PamtramContentAdapter parentAdapter) {
		this.parentAdapter = parentAdapter;
	}

}
