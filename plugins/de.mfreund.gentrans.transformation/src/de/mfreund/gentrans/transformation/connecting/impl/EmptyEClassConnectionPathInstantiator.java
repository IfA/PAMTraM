/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPathInstantiator;

/**
 * An {@link EClassConnectionPathInstantiator} that is able to instantiate {@link EmptyEClassConnectionPath
 * EmptyEClassConnectionPath}.
 *
 * @author mfreund
 */
@SuppressWarnings("javadoc")
public class EmptyEClassConnectionPathInstantiator extends EClassConnectionPathInstantiator {

	public EmptyEClassConnectionPathInstantiator(EClassConnectionPath pathToInstantiate) {

		super(pathToInstantiate);
	}

	@Override
	protected void instantiate() {

		// nothing needs to be instantiated because this represents an 'empty' path

	}

}
