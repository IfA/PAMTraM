/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 *
 */
package pamtram.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * A special {@link org.eclipse.emf.ecore.resource.Resource.Factory} that will create {@link SharedModelResource
 * SharedSectionModelResources} instead of standard resources when necessary.
 *
 * @author mfreund
 */
public class SharedModelResourceFactory extends XMIResourceFactoryImpl {

	/**
	 * This creates an instance.
	 *
	 */
	public SharedModelResourceFactory() {
		super();
	}

	@Override
	public Resource createResource(URI uri) {

		if (uri.toString().endsWith(".pamtram.source") || uri.toString().endsWith(".pamtram.target")
				|| uri.toString().endsWith(".pamtram.mapping") || uri.toString().endsWith(".pamtram.condition")) {
			return new SharedModelResource(uri);
		} else {
			return super.createResource(uri);
		}
	}
}
