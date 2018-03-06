/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.connecting.Capacity;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;

/**
 * An {@link EClassConnectionPath} that represents an empty path (no connection possible).
 *
 * @author mfreund
 */
public class EmptyEClassConnectionPath implements EClassConnectionPath {

	@Override
	public EClass getStartingClass() {

		return null;
	}

	@Override
	public EClass getTargetClass() {

		return null;
	}

	@Override
	public int getLength() {

		return 0;
	}

	@Override
	public Capacity getTheoreticalCapacity() {

		return Capacity.ZERO;
	}

	@Override
	public Capacity getActualCapacity(EObject startingElement) {

		return Capacity.ZERO;
	}

	@Override
	public boolean describesConnectionBetween(EObject startingElement, EObject targetElement) {

		return Objects.equals(startingElement, targetElement);
	}

}
