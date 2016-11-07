/**
 *
 */
package pamtram.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import pamtram.SectionModel;


/**
 * A special resource for shared {@link SectionModel SectionModels} that uses {@link #useUUIDs() IDs} instead of URI
 * fragments to address model elements.
 * <p />
 * That way, using and editing model contents from multiple PAMTraM models should be less likely to break references.
 *
 * @author mfreund
 */
public class SharedSectionModelResource extends XMIResourceImpl {

	/**
	 * This creates an instance.
	 *
	 */
	public SharedSectionModelResource() {
		super();
	}

	/**
	 * This creates an instance.
	 *
	 * @param uri
	 *            The {@link URI} of the resource to be created.
	 */
	public SharedSectionModelResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {

		return true;
	}
}
