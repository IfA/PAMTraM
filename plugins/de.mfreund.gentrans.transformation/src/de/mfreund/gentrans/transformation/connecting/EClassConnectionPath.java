/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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
	 * @return The length of the path (i.e. the number of intermediate {@link EReference references}).
	 */
	public int getLength();

	/**
	 * Calculates the paths <em>capacity</em> (how many elements of the {@link #getTargetClass() targetClass} can be
	 * connected to one instance of the {@link #getStartingClass() startingClass} via this path).
	 *
	 * @return The capacity of this path.
	 */
	public Capacity getTheoreticalCapacity();

	/**
	 * Calculates the paths <em>actual capacity</em> for the given {@link EObject rootElement} (how many elements of the
	 * {@link #getTargetClass() targetClass} can be connected to the startingElement via this path).
	 *
	 * @param startingElement
	 * @return The capacity of this path.
	 */
	public Capacity getActualCapacity(EObject startingElement);

	/**
	 * Whether following this path based on the given {@link EObject startingElement} leads to the given {@link EObject
	 * targetElement}.
	 */
	@SuppressWarnings("javadoc")
	public boolean describesConnectionBetween(EObject startingElement, EObject targetElement);

}
