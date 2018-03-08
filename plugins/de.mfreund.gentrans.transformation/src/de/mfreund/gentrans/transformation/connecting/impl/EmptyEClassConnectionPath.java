/**
 *
 */
package de.mfreund.gentrans.transformation.connecting.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.mfreund.gentrans.transformation.connecting.Capacity;
import de.mfreund.gentrans.transformation.connecting.EClassConnectionPath;
import de.mfreund.gentrans.transformation.connecting.Length;

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
	public Length getLength() {

		return Length.NO_CONNECTION;
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
	public List<EObject> getExistingTargetElements(EObject startingElement) {

		return Collections.emptyList();
	}

	@Override
	public boolean describesConnectionBetween(EObject startingElement, EObject targetElement) {

		return Objects.equals(startingElement, targetElement);
	}

	@Override
	public List<EClass> getAllClasses() {

		return Collections.emptyList();
	}

	@Override
	public List<EReference> getAllReferences() {

		return Collections.emptyList();
	}

}
