/**
 *
 */
package de.mfreund.gentrans.transformation.connecting;

import java.util.HashSet;
import java.util.List;

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
	 * @return The {@link Length} of the path.
	 */
	public Length getLength();

	/**
	 * Calculates the path's <em>theoretical</em> {@link Capacity} (how many elements of the {@link #getTargetClass()
	 * targetClass} can be connected to one instance of the {@link #getStartingClass() startingClass} via this path).
	 *
	 * @return The capacity of this path.
	 */
	public Capacity getTheoreticalCapacity();

	/**
	 * Calculates the paths <em>actual</em> {@link Capacity} for the given {@link EObject rootElement} (how many
	 * elements of the {@link #getTargetClass() targetClass} can be connected to the startingElement via this path).
	 *
	 * @param startingElement
	 * @return The capacity of this path.
	 */
	public Capacity getActualCapacity(EObject startingElement);

	/**
	 * How many elements are connected to the given {@link EObject startingElement} via this path.
	 */
	@SuppressWarnings("javadoc")
	public List<EObject> getExistingTargetElements(EObject startingElement);

	/**
	 * Whether following this path based on the given {@link EObject startingElement} leads to the given {@link EObject
	 * targetElement}.
	 */
	@SuppressWarnings("javadoc")
	public boolean describesConnectionBetween(EObject startingElement, EObject targetElement);

	/**
	 * @return A list of all {@link EClass EClasses} that make up this path.
	 */
	public List<EClass> getAllClasses();

	/**
	 * @return A list of all {@link EReference EReferences} that make up this path.
	 */
	public List<EReference> getAllReferences();

	/**
	 * @return '<em>true</em>' if {@link #getAllClasses()} contains the same EClass twice.
	 */
	public default boolean containsLoop() {

		return new HashSet<>(getAllClasses()).size() < getAllClasses().size();
	}

	/**
	 * @param startingElement
	 * @return '<em>true</em>' if the given {@link EObject startingElement} is an instance of the
	 *         {@link #getTargetClass()}
	 */
	public default boolean isValidStartingElement(EObject startingElement) {

		return getStartingClass() != null && getStartingClass().isInstance(startingElement);
	}
}
