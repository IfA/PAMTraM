/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import org.eclipse.emf.ecore.EClass;

/**
 *
 * @author mfreund
 */
public interface IEClassConnectionPathDescriptor {

	public EClass getStartingClass();

	public EClass getTargetClass();

	public int getLength();

}
