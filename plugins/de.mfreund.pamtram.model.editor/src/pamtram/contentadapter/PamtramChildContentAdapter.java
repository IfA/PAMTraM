package pamtram.contentadapter;

import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * Abstract content adapter that all adapters acting as child adapters of
 * the PamtramContentAdapter shoul implement.
 * 
 * @author mfreund
 *
 */
abstract class PamtramChildContentAdapter extends EContentAdapter {
	
	PamtramContentAdapter parentAdapter;
	
	public PamtramChildContentAdapter(PamtramContentAdapter parentAdapter) {
		this.parentAdapter = parentAdapter;
	}

}
