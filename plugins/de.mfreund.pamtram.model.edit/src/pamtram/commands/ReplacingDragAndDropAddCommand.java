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
package pamtram.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.dnd.DND;

/**
 * An AddCommand that provides DragAndDropFeedback and can thus be returned by e.g. the 'createDragAndDropCommand'
 * function in EMF item providers. This will replace all objects in the <em>originalCollection</em> by those in the
 * <em>newCollection</em> when the drop is executed. Thereby, shared features (that are provided by both source and
 * target eClasses) are copied and references to elements from the <em>originalCollection</em> are redirected to the
 * <em>newCollection</em>.
 */
public class ReplacingDragAndDropAddCommand extends AddCommand implements DragAndDropFeedback {

	private ArrayList<EObject> originalCollection;

	private ArrayList<EObject> newCollection;

	private EObject oldOwner;

	private EStructuralFeature oldFeature;

	/**
	 * This creates an instance.
	 *
	 * @param domain
	 *            The {@link EditingDomain} on which this command shall operate.
	 * @param owner
	 *            The {@link EObject} acting as current owner of the <em>orginalCollection</em> and new owner of the
	 *            <em>newCollection</em>.
	 * @param feature
	 *            The {@link EStructuralFeature} that currently holds the <em>orginalCollection</em> and will hold the
	 *            <em>newCollection</em> after execution of the command.
	 * @param originalCollection
	 *            The list of objects to be replaced.
	 * @param newCollection
	 *            The list of objects that shall replace the <em>originalCollection</em>.
	 */
	public ReplacingDragAndDropAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<EObject> originalCollection, Collection<EObject> newCollection) {
		super(domain, owner, feature, newCollection);

		this.originalCollection = new ArrayList<>(originalCollection);
		this.newCollection = new ArrayList<>(newCollection);

		if (!originalCollection.isEmpty()) {
			EObject firstElement = originalCollection.iterator().next();
			this.oldOwner = firstElement.eContainer();
			this.oldFeature = firstElement.eContainingFeature();
		}
	}

	@Override
	public void doExecute() {

		// replace each element of the originalCollection by the respective element of the newCollection
		//
		IntStream.range(0, this.originalCollection.size())
				.forEach(i -> this.replaceElement(this.originalCollection.get(i), this.newCollection.get(i)));

		this.collection = this.newCollection;

		super.doExecute();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doUndo() {

		// replace each element of the newCollection by the respective element of the originalCollection
		//
		IntStream.range(0, this.originalCollection.size())
				.forEach(i -> this.replaceElement(this.newCollection.get(i), this.originalCollection.get(i)));

		ArrayList<Object> currentValues = new ArrayList<>();
		currentValues.addAll((Collection<? extends Object>) this.oldOwner.eGet(this.oldFeature));
		currentValues.addAll(this.originalCollection);
		this.oldOwner.eSet(this.oldFeature, currentValues);

	}

	@Override
	public void doRedo() {

		// replace each element of the originalCollection by the respective element of the newCollection
		//
		IntStream.range(0, this.originalCollection.size())
				.forEach(i -> this.replaceElement(this.originalCollection.get(i), this.newCollection.get(i)));

		super.doRedo();
	}

	/**
	 * Replaces one {@link EObject} by another one by copying all features from the first object to the second one,
	 * redirecting all references to the first object to the second object and then deleting the first object.
	 *
	 * @param originalElement
	 *            The element to be replaced.
	 * @param newElement
	 *            The element to replace the <em>originalElement</em>.
	 */
	private void replaceElement(EObject originalElement, EObject newElement) {

		if (originalElement == null || originalElement.equals(newElement)) {
			return;
		}

		// copy all features that are also present in the new class
		//
		originalElement.eClass().getEAllStructuralFeatures().stream()
				.filter(newElement.eClass().getEAllStructuralFeatures()::contains)
				.forEach(feature -> newElement.eSet(feature, originalElement.eGet(feature)));

		// replace references to the object
		//
		Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(originalElement,
				originalElement.eResource().getResourceSet());
		refs.stream().filter(
				ref -> ref.getEObject() != null && ref.getEStructuralFeature().getEType().isInstance(newElement))
				.forEach(ref -> EcoreUtil.replace(ref, originalElement, newElement));

		// delete the old object
		//
		EcoreUtil.delete(originalElement);
	}

	@Override
	public boolean validate(Object owner, float location, int operations, int operation, Collection<?> collection) {

		return this.isExecutable;
	}

	@Override
	public int getFeedback() {

		return DND.FEEDBACK_SELECT;
	}

	@Override
	public int getOperation() {

		return DND.DROP_LINK;
	}

}
