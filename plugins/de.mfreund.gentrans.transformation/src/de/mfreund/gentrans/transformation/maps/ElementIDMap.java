/**
 *
 */
package de.mfreund.gentrans.transformation.maps;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import pamtram.structure.DynamicSourceElement;

/**
 * This is used to manage the model-unique ids of elements used in case {@link DynamicSourceElement#isUseElementID()} is
 * set to '<em>true/<em>'.
 *
 *
 *
 * If this is set to 'true', the (model-unique) id of the referenced source model element will be used as value for the
 * source element instead of the actual attribute value. This can be used to create element-specific ids in the target
 * model.
 *
 * @author mfreund
 */
public class ElementIDMap {

	/**
	 * The internal map storing assigned ids.
	 */
	protected Map<EObject, Integer> elementIDMap;

	/**
	 * The last id that was assigend.
	 */
	protected int currentElementID;

	/**
	 * This creates an instance and initializes the {@link #currentElementID} with 0.
	 */
	public ElementIDMap() {

		this.elementIDMap = new HashMap<>();
		this.currentElementID = 0;
	}

	/**
	 * Whether the given {@link EObject} is represented in the #{@link ElementIDMap}.
	 *
	 * @param element
	 * @return
	 */
	public boolean containsElement(EObject element) {

		return this.elementIDMap.containsKey(element);
	}

	/**
	 * Returns the id associated with the given {@link EObject element}. If no id has been associated yet, associates a
	 * new one.
	 *
	 * @param element
	 * @return
	 */
	public int getIDForElement(EObject element) {

		if (!this.containsElement(element)) {
			this.currentElementID++;
			this.elementIDMap.put(element, this.currentElementID);
		}

		return this.elementIDMap.get(element);
	}

}
