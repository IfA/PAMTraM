/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

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

	public EmptyEClassConnectionPathInstantiator(EClassConnectionPath pathToInstantiate, EObject startingElement,
			Collection<EObject> targetElements) {

		super(pathToInstantiate, startingElement, targetElements);
	}

	@Override
	protected void doInstantiate() {

		// nothing needs to be instantiated because this represents an 'empty' path

	}

}
