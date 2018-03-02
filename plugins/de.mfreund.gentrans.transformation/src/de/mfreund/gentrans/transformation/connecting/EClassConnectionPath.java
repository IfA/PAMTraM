/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * Instances of this represent a connection path between two {@link EClass EClasses} via one or multiple
 * {@link EReference EReferences} (and intermediate EClasses in case of multiple references).
 *
 * @author mfreund
 */
public interface EClassConnectionPath {

	/**
	 * @return The starting {@link EClass} of the path.
	 */
	public EClass getStartingClass();

	/**
	 * @return The target {@link EClass} of the path.
	 */
	public EClass getTargetClass();

	/**
	 * @return The length of the path (i.e. the number of intermediate EClasses).
	 */
	public int getLength();

}
