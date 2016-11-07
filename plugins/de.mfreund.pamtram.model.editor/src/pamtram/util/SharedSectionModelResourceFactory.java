/**
 *
 */
package pamtram.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


/**
 * A special {@link org.eclipse.emf.ecore.resource.Resource.Factory} that will create {@link SharedSectionModelResource
 * SharedSectionModelResources} instead of standard resources when necessary.
 *
 * @author mfreund
 */
public class SharedSectionModelResourceFactory extends XMIResourceFactoryImpl {

	/**
	 * This creates an instance.
	 *
	 */
	public SharedSectionModelResourceFactory() {
		super();
	}

	@Override
	public Resource createResource(URI uri) {

		if (uri.toString().endsWith(".pamtram.source") || uri.toString().endsWith(".pamtram.target")) {
			return new SharedSectionModelResource(uri);
		} else {
			return super.createResource(uri);
		}
	}
}
