/**
 *
 */
package de.mfreund.gentrans.transformation.calculation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.mfreund.gentrans.transformation.core.TransformationAsset;
import de.mfreund.gentrans.transformation.core.TransformationAssetManager;
import pamtram.MatchSpecElement;
import pamtram.impl.MatchSpecElementImpl;
import pamtram.structure.generic.ActualReference;
import pamtram.structure.generic.Reference;

/**
 * A simple util class to evaluate {@link MatchSpecElement MatchSpecElements}.
 *
 * @author mfreund
 */
public class MatchSpecHandler extends TransformationAsset {

	/**
	 * This creates an instance.
	 *
	 * @param assetManager
	 *            The {@link TransformationAssetManager} providing access to the various other assets used in the
	 *            current transformation instance.
	 */
	public MatchSpecHandler(TransformationAssetManager assetManager) {

		super(assetManager);
	}

	/**
	 * This can be used to check whether the given <em>matchedElement</em> fulfills the
	 * {@link MatchSpecElementImpl#getReferenceMatchSpec() referenceMatchSpec} of the given <em>matchSpecElement</em>
	 * starting the evaluation from the given <em>root</em> element.
	 *
	 * @param root
	 *            The {@link EObject} from which to start the evaluation.
	 * @param matchedElement
	 *            The {@link EObject} to check.
	 * @param matchSpecElement
	 *            The {@link MatchSpecElement} to evaluate.
	 * @return '<em>true</em>' if the match spec if fulfilled; '<em>false</em>' otherwise.
	 */
	public boolean conformsMatchedObject(EObject root, EObject matchedElement,
			MatchSpecElement<?, ?, ?, ?> matchSpecElement) {

		return this.conformsMatchedObject(root, matchedElement,
				new ArrayList<>(matchSpecElement.getReferenceMatchSpec()));
	}

	protected boolean conformsMatchedObject(EObject root, EObject matchedElement,
			List<Reference<?, ?, ?, ?>> referenceMatchSpec) {

		// Create a local copy first
		//
		List<Reference<?, ?, ?, ?>> localReferenceSegments = new ArrayList<>(referenceMatchSpec);

		Reference<?, ?, ?, ?> firstSegment = localReferenceSegments.remove(0);

		if (firstSegment instanceof ActualReference<?, ?, ?, ?>) {

			if (!root.eClass().getEAllReferences()
					.contains(((ActualReference<?, ?, ?, ?>) firstSegment).getEReference())) {
				this.logger.severe("Faulty Reference Match Spec encountered!");
				return false;
			}
		}

		List<EObject> values = this.assetManager.getModelAccessUtil().getReferenceValueAsList(root, firstSegment);
		if (localReferenceSegments.isEmpty()) {
			return values.contains(matchedElement);
		} else {
			return !localReferenceSegments.isEmpty() && values.stream().filter(v -> v instanceof EObject)
					.anyMatch(v -> this.conformsMatchedObject(v, matchedElement, localReferenceSegments));
		}

	}
}
